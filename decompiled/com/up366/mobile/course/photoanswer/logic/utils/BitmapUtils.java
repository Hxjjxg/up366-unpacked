package com.up366.mobile.course.photoanswer.logic.utils;

/* JADX INFO: compiled from: BitmapUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/utils/BitmapUtils;", "", "<init>", "()V", "imageToBitmap", "Landroid/graphics/Bitmap;", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "Landroidx/camera/core/ImageProxy;", "rotateAndResizeBitmap", "bitmap", "rotationDegrees", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitmapUtils {
    public static final com.up366.mobile.course.photoanswer.logic.utils.BitmapUtils INSTANCE = new com.up366.mobile.course.photoanswer.logic.utils.BitmapUtils();

    private BitmapUtils() {
    }

    public final android.graphics.Bitmap imageToBitmap(androidx.camera.core.ImageProxy image) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
        androidx.camera.core.ImageProxy.PlaneProxy planeProxy = image.getPlanes()[0];
        java.nio.ByteBuffer buffer = planeProxy.getBuffer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
        int width = image.getWidth();
        int height = image.getHeight();
        int pixelStride = planeProxy.getPixelStride();
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(width + ((planeProxy.getRowStride() - (pixelStride * width)) / pixelStride), height, android.graphics.Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        bitmapCreateBitmap.copyPixelsFromBuffer(buffer);
        return bitmapCreateBitmap;
    }

    public final android.graphics.Bitmap rotateAndResizeBitmap(android.graphics.Bitmap bitmap, int rotationDegrees) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (rotationDegrees == 0) {
            android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, (int) (bitmap.getHeight() * (1500.0f / bitmap.getWidth())), true);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
            return bitmapCreateScaledBitmap;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(rotationDegrees);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        android.graphics.Bitmap bitmapCreateScaledBitmap2 = android.graphics.Bitmap.createScaledBitmap(bitmapCreateBitmap, com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, (int) (bitmapCreateBitmap.getHeight() * (1500.0f / bitmapCreateBitmap.getWidth())), true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap2, "createScaledBitmap(...)");
        bitmapCreateBitmap.recycle();
        return bitmapCreateScaledBitmap2;
    }
}
