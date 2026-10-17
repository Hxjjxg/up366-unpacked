package com.up366.medialibrary.common.compress;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class Engine {
    private static final int DEFAULT_QUALITY = 80;
    private int compressQuality;
    private final android.content.Context context;

    @java.lang.Deprecated
    private final boolean focusAlpha;
    private final boolean isAutoRotating;
    private int srcHeight;
    private final com.up366.medialibrary.common.compress.InputStreamProvider srcImg;
    private int srcWidth;
    private final java.io.File tagImg;

    Engine(android.content.Context context, com.up366.medialibrary.common.compress.InputStreamProvider inputStreamProvider, java.io.File file, boolean z, int i, boolean z2) throws java.io.IOException {
        this.tagImg = file;
        this.srcImg = inputStreamProvider;
        this.context = context;
        this.focusAlpha = z;
        this.isAutoRotating = z2;
        this.compressQuality = i <= 0 ? 80 : i;
        if (inputStreamProvider.getMedia().getWidth() > 0 && inputStreamProvider.getMedia().getHeight() > 0) {
            this.srcWidth = inputStreamProvider.getMedia().getWidth();
            this.srcHeight = inputStreamProvider.getMedia().getHeight();
            return;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        android.graphics.BitmapFactory.decodeStream(inputStreamProvider.open(), null, options);
        this.srcWidth = options.outWidth;
        this.srcHeight = options.outHeight;
    }

    private int computeSize() {
        int i = this.srcWidth;
        if (i % 2 == 1) {
            i++;
        }
        this.srcWidth = i;
        int i2 = this.srcHeight;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.srcHeight = i2;
        int iMax = java.lang.Math.max(i, i2);
        float fMin = java.lang.Math.min(this.srcWidth, this.srcHeight) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d = fMin;
            if (d <= 0.5625d && d > 0.5d) {
                int i3 = iMax / 1280;
                if (i3 == 0) {
                    return 1;
                }
                return i3;
            }
            return (int) java.lang.Math.ceil(((double) iMax) / (1280.0d / d));
        }
        if (iMax < 1664) {
            return 1;
        }
        if (iMax < 4990) {
            return 2;
        }
        if (iMax <= 4990 || iMax >= 10240) {
            return iMax / 1280;
        }
        return 4;
    }

    java.io.File compress() throws java.io.IOException {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = computeSize();
        android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(this.srcImg.open(), null, options);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        if (this.isAutoRotating && com.up366.medialibrary.common.compress.Checker.SINGLE.isJPG(this.srcImg.getMedia().getMimeType())) {
            java.lang.String cutPath = this.srcImg.getMedia().isCut() ? this.srcImg.getMedia().getCutPath() : this.srcImg.getMedia().getPath();
            int pictureDegree = com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(cutPath) ? com.up366.medialibrary.common.utils.BitmapUtils.readPictureDegree(this.srcImg.open()) : com.up366.medialibrary.common.utils.BitmapUtils.readPictureDegree(this.context, cutPath);
            if (pictureDegree > 0) {
                bitmapDecodeStream = com.up366.medialibrary.common.utils.BitmapUtils.rotatingImage(bitmapDecodeStream, pictureDegree);
            }
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        int i = this.compressQuality;
        if (i <= 0 || i > 100) {
            i = 80;
        }
        this.compressQuality = i;
        bitmapDecodeStream.compress((this.focusAlpha || bitmapDecodeStream.hasAlpha()) ? android.graphics.Bitmap.CompressFormat.PNG : android.graphics.Bitmap.CompressFormat.JPEG, this.compressQuality, byteArrayOutputStream);
        bitmapDecodeStream.recycle();
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(this.tagImg);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.tagImg;
    }
}
