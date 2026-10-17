package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BitmapUtilsUp {
    private static int failureDrawableId;
    private static int loadingDrawableId;
    private static com.up366.common.task.TaskExecutor taskExecutor;

    public interface ImageDownloadCallback {
        void onDownloadIng(long j, long j2);

        void onError(java.lang.Throwable th);

        void onSuccess(java.lang.String str);
    }

    public static void initDrawable(int i, int i2) {
        loadingDrawableId = i;
        failureDrawableId = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.Bitmap] */
    public static void saveBitmap(android.graphics.Bitmap bitmap, java.lang.String str) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        ?? r2 = 0;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                com.up366.common.FileUtilsUp.mkdirParentDir(str);
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            r2 = 100;
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            com.up366.common.IOUtils.close(fileOutputStream);
        } catch (java.lang.Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            com.up366.common.log.Logger.error("saveBitmap error " + e.getMessage(), e);
            com.up366.common.IOUtils.close(fileOutputStream2);
            r2 = fileOutputStream2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            r2 = fileOutputStream;
            com.up366.common.IOUtils.close(r2);
            throw th;
        }
    }

    public static boolean isPicture(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str, options);
        return options.outMimeType != null && options.outMimeType.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
    }

    public static <T extends android.widget.ImageView> void display(T t, int i) {
        com.bumptech.glide.Glide.with(com.up366.common.global.GB.get().getApplicationContext()).load(java.lang.Integer.valueOf(i)).into(t);
    }

    public static <T extends android.widget.ImageView> void display(T t, int i, android.widget.ImageView.ScaleType scaleType) {
        t.setScaleType(scaleType);
        com.bumptech.glide.Glide.with(com.up366.common.global.GB.get().getApplicationContext()).load(java.lang.Integer.valueOf(i)).into(t);
    }

    public static <T extends android.widget.ImageView> void display(T t, java.lang.String str, int i) {
        com.bumptech.glide.Glide.with(com.up366.common.global.GB.get().getApplicationContext()).load(str).apply(new com.bumptech.glide.request.RequestOptions().placeholder(i).error(i)).into(t);
    }

    public static <T extends android.widget.ImageView> void display(T t, java.lang.String str) {
        com.bumptech.glide.Glide.with(com.up366.common.global.GB.get().getApplicationContext()).load(str).apply(new com.bumptech.glide.request.RequestOptions().placeholder(loadingDrawableId).error(failureDrawableId)).into(t);
    }

    public static void downImage(java.lang.String str, com.up366.common.BitmapUtilsUp.ImageDownloadCallback imageDownloadCallback) {
        if ("noPic".equals(str)) {
            com.up366.common.log.Logger.error("downImage error ,not pic " + str);
        } else {
            if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
                com.up366.common.log.Logger.error("downImage error url is null");
                return;
            }
            java.lang.String imageCachePath = getImageCachePath(str);
            if (new java.io.File(imageCachePath).exists()) {
                imageDownloadCallback.onSuccess(imageCachePath);
                return;
            }
            if (taskExecutor == null) {
                taskExecutor = com.up366.common.task.TaskUtils.createSerialExecutor("TaskExecutor");
            }
            taskExecutor.post(new com.up366.common.BitmapUtilsUp.AnonymousClass1(str, imageCachePath, imageDownloadCallback));
        }
    }

    /* JADX INFO: renamed from: com.up366.common.BitmapUtilsUp$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.common.task.Task {
        int curLength = 0;
        final /* synthetic */ com.up366.common.BitmapUtilsUp.ImageDownloadCallback val$callBack;
        final /* synthetic */ java.lang.String val$filePath;
        final /* synthetic */ java.lang.String val$url;

        AnonymousClass1(java.lang.String str, java.lang.String str2, com.up366.common.BitmapUtilsUp.ImageDownloadCallback imageDownloadCallback) {
            this.val$url = str;
            this.val$filePath = str2;
            this.val$callBack = imageDownloadCallback;
        }

        @Override // com.up366.common.task.Task
        public void run() throws java.lang.Exception {
            java.io.FileOutputStream fileOutputStream;
            java.lang.Throwable th;
            java.io.InputStream inputStream;
            final java.lang.Exception e;
            final long contentLength;
            byte[] bArr;
            try {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(this.val$url).openConnection();
                contentLength = httpURLConnection.getContentLength();
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                try {
                    com.up366.common.FileUtilsUp.mkdirParentDir(this.val$filePath);
                    bArr = new byte[io.objectbox.model.PropertyFlags.INDEX_HASH];
                    fileOutputStream = new java.io.FileOutputStream(this.val$filePath);
                } catch (java.lang.Exception e2) {
                    fileOutputStream = null;
                    e = e2;
                } catch (java.lang.Throwable th2) {
                    fileOutputStream = null;
                    th = th2;
                    com.up366.common.IOUtils.close(fileOutputStream);
                    com.up366.common.IOUtils.close(inputStream);
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                fileOutputStream = null;
                e = e3;
                inputStream = null;
            } catch (java.lang.Throwable th3) {
                fileOutputStream = null;
                th = th3;
                inputStream = null;
            }
            loop0: while (true) {
                int i = 0;
                do {
                    try {
                        try {
                            int i2 = inputStream.read(bArr);
                            if (i2 == -1) {
                                break loop0;
                            }
                            fileOutputStream.write(bArr, 0, i2);
                            this.curLength += i2;
                            i++;
                        } catch (java.lang.Exception e4) {
                            e = e4;
                            com.up366.common.log.Logger.error("load image error : " + e.getMessage(), e);
                            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.common.BitmapUtilsUp.1.2
                                @Override // com.up366.common.task.Task
                                public void run() throws java.lang.Exception {
                                    com.up366.common.BitmapUtilsUp.AnonymousClass1.this.val$callBack.onError(e);
                                }
                            });
                        }
                        com.up366.common.IOUtils.close(fileOutputStream);
                        com.up366.common.IOUtils.close(inputStream);
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        com.up366.common.IOUtils.close(fileOutputStream);
                        com.up366.common.IOUtils.close(inputStream);
                        throw th;
                    }
                } while (i <= 100);
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.common.BitmapUtilsUp.1.1
                    @Override // com.up366.common.task.Task
                    public void run() throws java.lang.Exception {
                        com.up366.common.BitmapUtilsUp.AnonymousClass1.this.val$callBack.onDownloadIng(contentLength, com.up366.common.BitmapUtilsUp.AnonymousClass1.this.curLength);
                    }
                });
            }
            fileOutputStream.flush();
            com.up366.common.IOUtils.close(fileOutputStream);
            com.up366.common.IOUtils.close(inputStream);
        }
    }

    public static java.lang.String getImageCachePath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(com.up366.common.global.GB.get().getApplicationContext().getCacheDir().getAbsolutePath(), generate(str) + ".0");
    }

    private static java.lang.String generate(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return bytesToHexString(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException unused) {
            return java.lang.String.valueOf(str.hashCode());
        }
    }

    private static java.lang.String bytesToHexString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void clearCache(java.lang.String str) {
        com.up366.common.FileUtilsUp.deleteDirOrFile(getImageCachePath(str));
    }

    public static android.graphics.drawable.Drawable getDrawable(int i) {
        return com.up366.common.global.GB.get().getApplicationContext().getResources().getDrawable(i);
    }

    public static boolean compressBitmap(java.lang.String str, java.lang.String str2, int i, int i2, int i3) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str2, options);
        options.inSampleSize = (int) java.lang.Math.max(java.lang.Math.pow(2.0d, java.lang.Math.log(options.outWidth / i) / java.lang.Math.log(2.0d)), java.lang.Math.pow(2.0d, java.lang.Math.log(options.outHeight / i2) / java.lang.Math.log(2.0d)));
        options.inJustDecodeBounds = false;
        return compressBitmap(str, android.graphics.BitmapFactory.decodeFile(str2, options), i, i2, i3);
    }

    public static boolean compressBitmap(java.lang.String str, android.graphics.Bitmap bitmap, int i, int i2, int i3) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        if (bitmap == null) {
            com.up366.common.log.Logger.error("compressBitmap bitmap == null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i >= width) {
            i = width;
        }
        if (i2 >= height) {
            i2 = height;
        }
        float fMin = java.lang.Math.min(i / width, i2 / height);
        if (fMin > 1.0f) {
            fMin = 1.0f;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(fMin, fMin);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        java.io.File file = new java.io.File(str);
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                com.up366.common.FileUtilsUp.mkdirParentDir(file.getPath());
                com.up366.common.FileUtilsUp.deleteDirOrFile(file.getAbsolutePath());
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            if (str.toLowerCase().endsWith("png")) {
                bitmapCreateBitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, i3, fileOutputStream);
            } else {
                bitmapCreateBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i3, fileOutputStream);
            }
            com.up366.common.IOUtils.close(fileOutputStream);
            return true;
        } catch (java.io.IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            com.up366.common.log.Logger.error(e.getMessage(), e);
            com.up366.common.IOUtils.close(fileOutputStream2);
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.up366.common.IOUtils.close(fileOutputStream2);
            throw th;
        }
    }
}
