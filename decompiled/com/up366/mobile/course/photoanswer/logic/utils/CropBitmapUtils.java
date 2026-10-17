package com.up366.mobile.course.photoanswer.logic.utils;

/* JADX INFO: compiled from: CropBitmapUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/utils/CropBitmapUtils;", "", "<init>", "()V", "distance", "", "x1", "", "y1", "x2", "y2", "cropImage", "Landroid/graphics/Bitmap;", "detectLib", "Lcom/up366/papercut/DetectLib;", "baseBitmap", "connerData", "Lcom/up366/smartscan2/ConnerData;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CropBitmapUtils {
    public static final com.up366.mobile.course.photoanswer.logic.utils.CropBitmapUtils INSTANCE = new com.up366.mobile.course.photoanswer.logic.utils.CropBitmapUtils();

    private CropBitmapUtils() {
    }

    public final double distance(int x1, int y1, int x2, int y2) {
        return java.lang.Math.sqrt(java.lang.Math.pow(x2 - x1, 2.0d) + java.lang.Math.pow(y2 - y1, 2.0d));
    }

    public final android.graphics.Bitmap cropImage(com.up366.papercut.DetectLib detectLib, android.graphics.Bitmap baseBitmap, com.up366.smartscan2.ConnerData connerData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectLib, "detectLib");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseBitmap, "baseBitmap");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(connerData, "connerData");
        double dDistance = distance(connerData.getTopLeft()[0], connerData.getTopLeft()[1], connerData.getTopRight()[0], connerData.getTopRight()[1]);
        double dDistance2 = distance(connerData.getTopRight()[0], connerData.getTopRight()[1], connerData.getBottomRight()[0], connerData.getBottomRight()[1]);
        int iMax = (int) (java.lang.Math.max(dDistance, dDistance2) * 0.06d);
        int i = (int) (dDistance2 * 0.04d);
        int[] iArr = {connerData.getTopLeft()[0] - iMax, java.lang.Math.max((connerData.getTopLeft()[1] - iMax) - i, 0), connerData.getTopRight()[0] + iMax, java.lang.Math.max((connerData.getTopRight()[1] - iMax) - i, 0), connerData.getBottomRight()[0] + iMax, java.lang.Math.min(connerData.getBottomRight()[1] + iMax + i, baseBitmap.getHeight()), connerData.getBottomLeft()[0] - iMax, java.lang.Math.min(connerData.getBottomLeft()[1] + iMax + i, baseBitmap.getHeight())};
        android.graphics.Bitmap bitmapCropCoordinateToNewBitmap = com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.cropCoordinateToNewBitmap(iArr);
        detectLib.perspectiveCorrection(baseBitmap, bitmapCropCoordinateToNewBitmap, iArr);
        return bitmapCropCoordinateToNewBitmap;
    }
}
