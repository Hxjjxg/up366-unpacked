package com.up366.medialibrary.third.ucrop.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BitmapLoadTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult> {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final java.lang.String TAG = "BitmapWorkerTask";
    private final com.up366.medialibrary.third.ucrop.callback.BitmapLoadCallback mBitmapLoadCallback;
    private final android.content.Context mContext;
    private final int mInputImageHeight;
    private final int mInputImageWidth;
    private android.net.Uri mInputUri;
    private final android.net.Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public static class BitmapWorkerResult {
        android.graphics.Bitmap mBitmapResult;
        java.lang.Exception mBitmapWorkerException;
        com.up366.medialibrary.third.ucrop.model.ExifInfo mExifInfo;

        public BitmapWorkerResult(android.graphics.Bitmap bitmap, com.up366.medialibrary.third.ucrop.model.ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(java.lang.Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }

    public BitmapLoadTask(android.content.Context context, android.net.Uri uri, android.net.Uri uri2, int i, int i2, int i3, int i4, com.up366.medialibrary.third.ucrop.callback.BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i;
        this.mRequiredHeight = i2;
        this.mInputImageWidth = i3;
        this.mInputImageHeight = i4;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult doInBackground(java.lang.Void... voidArr) {
        if (this.mInputUri == null) {
            return new com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult(new java.lang.NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (options.outWidth == 0 && options.outHeight == 0) {
                int i = this.mInputImageWidth;
                int i2 = this.mInputImageHeight;
                options.inSampleSize = com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.calculateInSampleSize(i, i2, i, i2);
            } else {
                options.inSampleSize = com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.calculateInSampleSize(options.outWidth, options.outHeight, this.mRequiredWidth, this.mRequiredHeight);
            }
            boolean z = false;
            options.inJustDecodeBounds = false;
            android.graphics.Bitmap bitmapDecodeStream = null;
            while (!z) {
                try {
                    bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(this.mContext, this.mInputUri), null, options);
                } catch (java.lang.Exception e) {
                    android.util.Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e);
                    return new com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult(new java.lang.IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]", e));
                } catch (java.lang.OutOfMemoryError e2) {
                    android.util.Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e2);
                    options.inSampleSize *= 2;
                }
                if (options.outWidth != -1 && options.outHeight != -1) {
                    if (!checkSize(bitmapDecodeStream, options)) {
                        z = true;
                    }
                }
                return new com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult(new java.lang.IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
            }
            if (bitmapDecodeStream == null) {
                return new com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult(new java.lang.IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
            }
            int exifOrientation = com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
            int iExifToDegrees = com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.exifToDegrees(exifOrientation);
            int iExifToTranslation = com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.exifToTranslation(exifOrientation);
            com.up366.medialibrary.third.ucrop.model.ExifInfo exifInfo = new com.up366.medialibrary.third.ucrop.model.ExifInfo(exifOrientation, iExifToDegrees, iExifToTranslation);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            if (iExifToDegrees != 0) {
                matrix.preRotate(iExifToDegrees);
            }
            if (iExifToTranslation != 1) {
                matrix.postScale(iExifToTranslation, 1.0f);
            }
            if (!matrix.isIdentity()) {
                return new com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult(com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.transformBitmap(bitmapDecodeStream, matrix), exifInfo);
            }
            return new com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult(bitmapDecodeStream, exifInfo);
        } catch (java.io.IOException | java.lang.NullPointerException e3) {
            return new com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult(e3);
        }
    }

    private void processInputUri() throws java.io.IOException, java.lang.NullPointerException {
        java.lang.String scheme = this.mInputUri.getScheme();
        android.util.Log.d(TAG, "Uri scheme: " + scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            try {
                downloadFile(this.mInputUri, this.mOutputUri);
                return;
            } catch (java.io.IOException | java.lang.NullPointerException e) {
                android.util.Log.e(TAG, "Downloading failed", e);
                throw e;
            }
        }
        if (com.igexin.sdk.FlymePushReceiver.CONTENT.equals(scheme)) {
            java.lang.String filePath = getFilePath();
            if (!android.text.TextUtils.isEmpty(filePath) && new java.io.File(filePath).exists()) {
                this.mInputUri = com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() ? this.mInputUri : android.net.Uri.fromFile(new java.io.File(filePath));
                return;
            }
            try {
                copyFile(this.mInputUri, this.mOutputUri);
                return;
            } catch (java.io.IOException | java.lang.NullPointerException e2) {
                android.util.Log.e(TAG, "Copying failed", e2);
                throw e2;
            }
        }
        if ("file".equals(scheme)) {
            return;
        }
        android.util.Log.e(TAG, "Invalid Uri scheme " + scheme);
        throw new java.lang.IllegalArgumentException("Invalid Uri scheme" + scheme);
    }

    private java.lang.String getFilePath() {
        if (androidx.core.content.ContextCompat.checkSelfPermission(this.mContext, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE) == 0) {
            return com.up366.medialibrary.common.utils.PictureFileUtils.getPath(this.mContext, this.mInputUri);
        }
        return "";
    }

    private void copyFile(android.net.Uri uri, android.net.Uri uri2) throws java.lang.Throwable {
        java.io.InputStream contentResolverOpenInputStream;
        java.io.FileOutputStream fileOutputStream;
        android.util.Log.d(TAG, "copyFile");
        if (uri2 == null) {
            throw new java.lang.NullPointerException("Output Uri is null - cannot copy image");
        }
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            contentResolverOpenInputStream = com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(this.mContext, uri);
            try {
                fileOutputStream = new java.io.FileOutputStream(uri2.getPath());
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            contentResolverOpenInputStream = null;
        }
        try {
            if (contentResolverOpenInputStream == null) {
                throw new java.lang.NullPointerException("InputStream for given input Uri is null");
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int i = contentResolverOpenInputStream.read(bArr);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(fileOutputStream);
                    com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(contentResolverOpenInputStream);
                    this.mInputUri = this.mOutputUri;
                    return;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(fileOutputStream2);
            com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(contentResolverOpenInputStream);
            this.mInputUri = this.mOutputUri;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    private void downloadFile(android.net.Uri uri, android.net.Uri uri2) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        byte[] bArr;
        java.io.BufferedOutputStream bufferedOutputStream;
        android.util.Log.d(TAG, "downloadFile");
        if (uri2 == 0) {
            throw new java.lang.NullPointerException("Output Uri is null - cannot download image");
        }
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                java.net.URL url = new java.net.URL(uri.toString());
                bArr = new byte[1024];
                bufferedInputStream = new java.io.BufferedInputStream(url.openStream());
                try {
                    uri2 = com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenOutputStream(this.mContext, uri2);
                } catch (java.lang.Exception e) {
                    e = e;
                    uri2 = 0;
                } catch (java.lang.Throwable th) {
                    th = th;
                    uri2 = 0;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            uri2 = 0;
            bufferedInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            uri2 = 0;
            bufferedInputStream = null;
        }
        if (uri2 != 0) {
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(uri2);
            } catch (java.lang.Exception e3) {
                e = e3;
            }
            while (true) {
                try {
                    int i = bufferedInputStream.read(bArr);
                    if (i <= -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                    bufferedOutputStream2 = bufferedOutputStream;
                    e.printStackTrace();
                    uri2 = uri2;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    bufferedOutputStream2 = bufferedOutputStream;
                    this.mInputUri = this.mOutputUri;
                    com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(bufferedOutputStream2);
                    com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(bufferedInputStream);
                    com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(uri2);
                    throw th;
                }
            }
            bufferedOutputStream.flush();
            bufferedOutputStream2 = bufferedOutputStream;
            uri2 = uri2;
        }
        this.mInputUri = this.mOutputUri;
        com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(bufferedOutputStream2);
        com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(bufferedInputStream);
        com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.close(uri2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(com.up366.medialibrary.third.ucrop.task.BitmapLoadTask.BitmapWorkerResult bitmapWorkerResult) {
        if (bitmapWorkerResult.mBitmapWorkerException == null) {
            java.lang.String string = this.mInputUri.toString();
            com.up366.medialibrary.third.ucrop.callback.BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            android.graphics.Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
            com.up366.medialibrary.third.ucrop.model.ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
            if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(string)) {
                string = this.mInputUri.getPath();
            }
            android.net.Uri uri = this.mOutputUri;
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, string, uri == null ? null : uri.getPath());
            return;
        }
        this.mBitmapLoadCallback.onFailure(bitmapWorkerResult.mBitmapWorkerException);
    }

    private boolean checkSize(android.graphics.Bitmap bitmap, android.graphics.BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) <= MAX_BITMAP_SIZE) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }
}
