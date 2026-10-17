package com.up366.mobile.course.p1p;

/* JADX INFO: compiled from: CameraBitmapUtil.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000fJ8\u0010\u0012\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0016\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ#\u0010\u001f\u001a\u00020\t2\u0016\u0010 \u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070!\"\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\"J$\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020$J&\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f¨\u00062"}, d2 = {"Lcom/up366/mobile/course/p1p/CameraBitmapUtil;", "", "<init>", "()V", "bitmapToByteBuffer", "Ljava/nio/ByteBuffer;", "bitmap", "Landroid/graphics/Bitmap;", "gcByteBuffer", "", "byteBuffer", "rotateRect", "Landroid/graphics/Rect;", "rect", "width", "", "height", "degrees", "saveBitmap", "imagePath", "", "quality", "", "savePath", "maxWidth", "maxHeight", "rotationDegrees", "imageProxyToScaleBitmap", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "Landroidx/camera/core/ImageProxy;", "bitmapScale", "gcBitmap", "bitmaps", "", "([Landroid/graphics/Bitmap;)V", "detectsToCropCoordinate", "", "corners", "", "Lcom/up366/papercut/Detect;", "scaleX", "", "scaleY", "cropCoordinateToNewBitmap", "points", "pointDistance", "x1", "y1", "x2", "y2", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CameraBitmapUtil {
    public static final com.up366.mobile.course.p1p.CameraBitmapUtil INSTANCE = new com.up366.mobile.course.p1p.CameraBitmapUtil();

    private CameraBitmapUtil() {
    }

    public final java.nio.ByteBuffer bitmapToByteBuffer(android.graphics.Bitmap bitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(byteBufferAllocateDirect);
        byteBufferAllocateDirect.rewind();
        kotlin.jvm.internal.Intrinsics.checkNotNull(byteBufferAllocateDirect);
        return byteBufferAllocateDirect;
    }

    public final void gcByteBuffer(java.nio.ByteBuffer byteBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        byteBuffer.clear();
    }

    public final android.graphics.Rect rotateRect(android.graphics.Rect rect, int width, int height, int degrees) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rect, "rect");
        if (degrees == 90) {
            return new android.graphics.Rect(height - rect.bottom, rect.left, height - rect.top, rect.right);
        }
        if (degrees != 180) {
            return degrees != 270 ? rect : new android.graphics.Rect(rect.top, width - rect.right, rect.bottom, width - rect.left);
        }
        return new android.graphics.Rect(width - rect.right, height - rect.bottom, width - rect.left, height - rect.top);
    }

    public static /* synthetic */ void saveBitmap$default(com.up366.mobile.course.p1p.CameraBitmapUtil cameraBitmapUtil, android.graphics.Bitmap bitmap, java.lang.String str, int i, int i2, java.lang.Object obj) {
        if ((i2 & 4) != 0) {
            i = 100;
        }
        cameraBitmapUtil.saveBitmap(bitmap, str, i);
    }

    public final void saveBitmap(android.graphics.Bitmap bitmap, java.lang.String imagePath, int quality) {
        java.io.File parentFile;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        java.io.File file = new java.io.File(imagePath);
        try {
            java.io.File parentFile2 = file.getParentFile();
            if (parentFile2 != null && !parentFile2.exists() && (parentFile = file.getParentFile()) != null) {
                parentFile.mkdirs();
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (java.lang.Exception e) {
            android.util.Log.i("CameraUtil", "CameraUtil saveBitmap: error:" + e.getMessage());
        }
    }

    public final boolean saveBitmap(java.lang.String savePath, android.graphics.Bitmap bitmap, int maxWidth, int maxHeight, int quality, int rotationDegrees) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(savePath, "savePath");
        if (bitmap == null) {
            com.up366.common.log.Logger.error("compressBitmap bitmap == null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (maxWidth >= width) {
            maxWidth = width;
        }
        if (maxHeight >= height) {
            maxHeight = height;
        }
        float f = maxWidth / width;
        float f2 = maxHeight / height;
        float fMin = java.lang.Math.min(f, f2);
        com.up366.common.log.Logger.info("dstMapWidth = " + maxWidth + ", dstMapHeight = " + maxHeight + ", scale = " + fMin + ", scaleWidth " + f + ",scaleHeight " + f2);
        if (fMin > 1.0f) {
            fMin = 1.0f;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(rotationDegrees);
        matrix.postScale(fMin, fMin);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        java.io.File file = new java.io.File(savePath);
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                com.up366.common.FileUtilsUp.mkdirParentDir(file.getPath());
                com.up366.common.FileUtilsUp.deleteDirOrFile(file.getAbsolutePath());
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            java.util.Locale locale = java.util.Locale.getDefault();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            java.lang.String lowerCase = savePath.toLowerCase(locale);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (kotlin.text.StringsKt.endsWith$default(lowerCase, "png", false, 2, (java.lang.Object) null)) {
                bitmapCreateBitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, quality, fileOutputStream);
            } else {
                bitmapCreateBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
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

    public final android.graphics.Bitmap imageProxyToScaleBitmap(androidx.camera.core.ImageProxy image, int width) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
        float width2 = (image.getWidth() * 1.0f) / image.getHeight();
        java.nio.ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
        buffer.rewind();
        int iCapacity = buffer.capacity();
        byte[] bArr = new byte[iCapacity];
        buffer.get(bArr);
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(android.graphics.BitmapFactory.decodeByteArray(bArr, 0, iCapacity), width, (int) (width / width2), false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    public final android.graphics.Bitmap bitmapScale(android.graphics.Bitmap bitmap, int width) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, width, (int) (width / ((bitmap.getWidth() * 1.0f) / bitmap.getHeight())), false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    public final void gcBitmap(android.graphics.Bitmap... bitmaps) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmaps, "bitmaps");
        for (android.graphics.Bitmap bitmap : bitmaps) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public final int[] detectsToCropCoordinate(java.util.List<com.up366.papercut.Detect> corners, float scaleX, float scaleY) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(corners, "corners");
        return new int[]{(int) (corners.get(0).getRect().centerX() * scaleX), (int) (corners.get(0).getRect().centerY() * scaleY), (int) (corners.get(1).getRect().centerX() * scaleX), (int) (corners.get(1).getRect().centerY() * scaleY), (int) (corners.get(2).getRect().centerX() * scaleX), (int) (corners.get(2).getRect().centerY() * scaleY), (int) (corners.get(3).getRect().centerX() * scaleX), (int) (corners.get(3).getRect().centerY() * scaleY)};
    }

    public final android.graphics.Bitmap cropCoordinateToNewBitmap(int[] points) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(points, "points");
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap((pointDistance(points[0], points[1], points[2], points[3]) + pointDistance(points[6], points[7], points[4], points[5])) / 2, (pointDistance(points[0], points[1], points[6], points[7]) + pointDistance(points[2], points[3], points[4], points[5])) / 2, android.graphics.Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public final int pointDistance(int x1, int y1, int x2, int y2) {
        return (int) java.lang.Math.sqrt(java.lang.Math.pow(x1 - x2, 2.0d) + java.lang.Math.pow(y1 - y2, 2.0d));
    }
}
