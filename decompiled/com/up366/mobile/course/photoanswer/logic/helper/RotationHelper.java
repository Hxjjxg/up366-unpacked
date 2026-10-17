package com.up366.mobile.course.photoanswer.logic.helper;

/* JADX INFO: compiled from: RotationHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J(\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/RotationHelper;", "", "<init>", "()V", "rotateCornerData", "", "cornerData", "Lcom/up366/smartscan2/ConnerData;", "w", "", "h", "degrees", "rotatePoint", "", "point", "rotatePointBack", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RotationHelper {
    public static final com.up366.mobile.course.photoanswer.logic.helper.RotationHelper INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.RotationHelper();

    private RotationHelper() {
    }

    public final void rotateCornerData(com.up366.smartscan2.ConnerData cornerData, int w, int h, int degrees) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cornerData, "cornerData");
        if (degrees == 90) {
            int[] bottomLeft = cornerData.getBottomLeft();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bottomLeft, "getBottomLeft(...)");
            int[] iArrRotatePoint = rotatePoint(bottomLeft, w, h, degrees);
            int[] topLeft = cornerData.getTopLeft();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(topLeft, "getTopLeft(...)");
            int[] iArrRotatePoint2 = rotatePoint(topLeft, w, h, degrees);
            int[] bottomRight = cornerData.getBottomRight();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bottomRight, "getBottomRight(...)");
            int[] iArrRotatePoint3 = rotatePoint(bottomRight, w, h, degrees);
            int[] topRight = cornerData.getTopRight();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(topRight, "getTopRight(...)");
            int[] iArrRotatePoint4 = rotatePoint(topRight, w, h, degrees);
            cornerData.setTopLeft(iArrRotatePoint);
            cornerData.setTopRight(iArrRotatePoint2);
            cornerData.setBottomLeft(iArrRotatePoint3);
            cornerData.setBottomRight(iArrRotatePoint4);
            return;
        }
        if (degrees == 180) {
            int[] bottomRight2 = cornerData.getBottomRight();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bottomRight2, "getBottomRight(...)");
            int[] iArrRotatePoint5 = rotatePoint(bottomRight2, w, h, degrees);
            int[] bottomLeft2 = cornerData.getBottomLeft();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bottomLeft2, "getBottomLeft(...)");
            int[] iArrRotatePoint6 = rotatePoint(bottomLeft2, w, h, degrees);
            int[] topRight2 = cornerData.getTopRight();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(topRight2, "getTopRight(...)");
            int[] iArrRotatePoint7 = rotatePoint(topRight2, w, h, degrees);
            int[] topLeft2 = cornerData.getTopLeft();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(topLeft2, "getTopLeft(...)");
            int[] iArrRotatePoint8 = rotatePoint(topLeft2, w, h, degrees);
            cornerData.setTopLeft(iArrRotatePoint5);
            cornerData.setTopRight(iArrRotatePoint6);
            cornerData.setBottomLeft(iArrRotatePoint7);
            cornerData.setBottomRight(iArrRotatePoint8);
            return;
        }
        if (degrees != 270) {
            return;
        }
        int[] topRight3 = cornerData.getTopRight();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(topRight3, "getTopRight(...)");
        int[] iArrRotatePoint9 = rotatePoint(topRight3, w, h, degrees);
        int[] bottomRight3 = cornerData.getBottomRight();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bottomRight3, "getBottomRight(...)");
        int[] iArrRotatePoint10 = rotatePoint(bottomRight3, w, h, degrees);
        int[] topLeft3 = cornerData.getTopLeft();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(topLeft3, "getTopLeft(...)");
        int[] iArrRotatePoint11 = rotatePoint(topLeft3, w, h, degrees);
        int[] bottomLeft3 = cornerData.getBottomLeft();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bottomLeft3, "getBottomLeft(...)");
        int[] iArrRotatePoint12 = rotatePoint(bottomLeft3, w, h, degrees);
        cornerData.setTopLeft(iArrRotatePoint9);
        cornerData.setTopRight(iArrRotatePoint10);
        cornerData.setBottomLeft(iArrRotatePoint11);
        cornerData.setBottomRight(iArrRotatePoint12);
    }

    private final int[] rotatePoint(int[] point, int w, int h, int degrees) {
        int i = point[0];
        int i2 = point[1];
        if (degrees == 90) {
            return new int[]{(h - 1) - i2, i};
        }
        if (degrees != 180) {
            return degrees != 270 ? point : new int[]{i2, (w - 1) - i};
        }
        return new int[]{(w - 1) - i, (h - 1) - i2};
    }

    private final int[] rotatePointBack(int[] point, int w, int h, int degrees) {
        int i = point[0];
        int i2 = point[1];
        if (degrees == 90) {
            return new int[]{i2, (w - 1) - i};
        }
        if (degrees != 180) {
            return degrees != 270 ? point : new int[]{(h - 1) - i2, i};
        }
        return new int[]{(w - 1) - i, (h - 1) - i2};
    }
}
