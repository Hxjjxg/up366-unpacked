package com.up366.view.crop.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BitmapLoadTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.up366.view.crop.task.BitmapLoadTask.BitmapWorkerResult> {
    private static final java.lang.String TAG = "BitmapWorkerTask";
    private final com.up366.view.crop.callback.BitmapLoadCallback mBitmapLoadCallback;
    private final android.content.Context mContext;
    private android.net.Uri mInputUri;
    private android.net.Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public static class BitmapWorkerResult {
        android.graphics.Bitmap mBitmapResult;
        java.lang.Exception mBitmapWorkerException;
        com.up366.view.crop.model.ExifInfo mExifInfo;

        public BitmapWorkerResult(android.graphics.Bitmap bitmap, com.up366.view.crop.model.ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(java.lang.Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }

    public BitmapLoadTask(android.content.Context context, android.net.Uri uri, android.net.Uri uri2, int i, int i2, com.up366.view.crop.callback.BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i;
        this.mRequiredHeight = i2;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public com.up366.view.crop.task.BitmapLoadTask.BitmapWorkerResult doInBackground(java.lang.Void... voidArr) {
        if (this.mInputUri == null) {
            return new com.up366.view.crop.task.BitmapLoadTask.BitmapWorkerResult(new java.lang.NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(this.mInputUri.getPath(), options);
            options.inSampleSize = com.up366.view.crop.util.BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
            options.inJustDecodeBounds = false;
            android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(this.mInputUri.getPath(), options);
            if (bitmapDecodeFile == null) {
                return new com.up366.view.crop.task.BitmapLoadTask.BitmapWorkerResult(new java.lang.IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
            }
            int exifOrientation = com.up366.view.crop.util.BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
            int iExifToDegrees = com.up366.view.crop.util.BitmapLoadUtils.exifToDegrees(exifOrientation);
            int iExifToTranslation = com.up366.view.crop.util.BitmapLoadUtils.exifToTranslation(exifOrientation);
            com.up366.view.crop.model.ExifInfo exifInfo = new com.up366.view.crop.model.ExifInfo(exifOrientation, iExifToDegrees, iExifToTranslation);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            if (iExifToDegrees != 0) {
                matrix.preRotate(iExifToDegrees);
            }
            if (iExifToTranslation != 1) {
                matrix.postScale(iExifToTranslation, 1.0f);
            }
            if (!matrix.isIdentity()) {
                return new com.up366.view.crop.task.BitmapLoadTask.BitmapWorkerResult(com.up366.view.crop.util.BitmapLoadUtils.transformBitmap(bitmapDecodeFile, matrix), exifInfo);
            }
            return new com.up366.view.crop.task.BitmapLoadTask.BitmapWorkerResult(bitmapDecodeFile, exifInfo);
        } catch (java.io.IOException | java.lang.NullPointerException e) {
            return new com.up366.view.crop.task.BitmapLoadTask.BitmapWorkerResult(e);
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

    private void copyFile(android.net.Uri uri, android.net.Uri uri2) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpenInputStream;
        java.io.FileOutputStream fileOutputStream;
        android.util.Log.d(TAG, "copyFile");
        if (uri2 == null) {
            throw new java.lang.NullPointerException("Output Uri is null - cannot copy image");
        }
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            inputStreamOpenInputStream = this.mContext.getContentResolver().openInputStream(uri);
            try {
                fileOutputStream = new java.io.FileOutputStream(new java.io.File(uri2.getPath()));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStreamOpenInputStream = null;
        }
        try {
            if (inputStreamOpenInputStream == null) {
                throw new java.lang.NullPointerException("InputStream for given input Uri is null");
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    com.up366.view.crop.util.BitmapLoadUtils.close(fileOutputStream);
                    com.up366.view.crop.util.BitmapLoadUtils.close(inputStreamOpenInputStream);
                    this.mInputUri = this.mOutputUri;
                    return;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            com.up366.view.crop.util.BitmapLoadUtils.close(fileOutputStream2);
            com.up366.view.crop.util.BitmapLoadUtils.close(inputStreamOpenInputStream);
            this.mInputUri = this.mOutputUri;
            throw th;
        }
    }

    private void downloadFile(android.net.Uri uri, android.net.Uri uri2) throws java.lang.Throwable {
        java.io.Closeable closeable;
        okhttp3.Response response;
        android.util.Log.d(TAG, "downloadFile");
        if (uri2 == null) {
            throw new java.lang.NullPointerException("Output Uri is null - cannot download image");
        }
        okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient();
        java.io.Closeable closeable2 = null;
        try {
            okhttp3.Response responseExecute = okHttpClient.newCall(new okhttp3.Request.Builder().url(uri.toString()).build()).execute();
            try {
                java.io.Closeable closeableSource = responseExecute.body().source();
                try {
                    java.io.OutputStream outputStreamOpenOutputStream = this.mContext.getContentResolver().openOutputStream(uri2);
                    if (outputStreamOpenOutputStream != null) {
                        okio.Sink sink = okio.Okio.sink(outputStreamOpenOutputStream);
                        closeableSource.readAll(sink);
                        com.up366.view.crop.util.BitmapLoadUtils.close(closeableSource);
                        com.up366.view.crop.util.BitmapLoadUtils.close(sink);
                        if (responseExecute != null) {
                            com.up366.view.crop.util.BitmapLoadUtils.close(responseExecute.body());
                        }
                        okHttpClient.dispatcher().cancelAll();
                        this.mInputUri = this.mOutputUri;
                        return;
                    }
                    throw new java.lang.NullPointerException("OutputStream for given output Uri is null");
                } catch (java.lang.Throwable th) {
                    th = th;
                    response = responseExecute;
                    closeable = null;
                    closeable2 = closeableSource;
                    com.up366.view.crop.util.BitmapLoadUtils.close(closeable2);
                    com.up366.view.crop.util.BitmapLoadUtils.close(closeable);
                    if (response != null) {
                        com.up366.view.crop.util.BitmapLoadUtils.close(response.body());
                    }
                    okHttpClient.dispatcher().cancelAll();
                    this.mInputUri = this.mOutputUri;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                response = responseExecute;
                closeable = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            closeable = null;
            response = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(com.up366.view.crop.task.BitmapLoadTask.BitmapWorkerResult bitmapWorkerResult) {
        if (bitmapWorkerResult.mBitmapWorkerException == null) {
            com.up366.view.crop.callback.BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            android.graphics.Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
            com.up366.view.crop.model.ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
            java.lang.String path = this.mInputUri.getPath();
            android.net.Uri uri = this.mOutputUri;
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, path, uri == null ? null : uri.getPath());
            return;
        }
        this.mBitmapLoadCallback.onFailure(bitmapWorkerResult.mBitmapWorkerException);
    }
}
