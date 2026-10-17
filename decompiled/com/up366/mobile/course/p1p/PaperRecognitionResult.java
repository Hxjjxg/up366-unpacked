package com.up366.mobile.course.p1p;

/* JADX INFO: compiled from: PaperRecognitionResult.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013J\u0018\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-J\u0012\u0010.\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010/\u001a\u00020'H\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\b\u00101\u001a\u00020\u0003H\u0002J(\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014H\u0002J\b\u00108\u001a\u00020'H\u0002J\b\u00109\u001a\u00020\u001bH\u0002J\u0006\u0010:\u001a\u00020\u0003J\u0012\u0010;\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030=2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140>H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "", "imageWidth", "", "imageHeight", "degrees", "cropRect", "Landroid/graphics/Rect;", "<init>", "(IIILandroid/graphics/Rect;)V", "getImageWidth", "()I", "getImageHeight", "getDegrees", "getCropRect", "()Landroid/graphics/Rect;", "realCropRect", "getRealCropRect", "mPoints", "", "Landroid/graphics/PointF;", "getMPoints", "()Ljava/util/List;", "detectPoints", "Lcom/up366/papercut/Detect;", "getDetectPoints", "outScreen", "", "getOutScreen", "()Z", "setOutScreen", "(Z)V", "isAllowArea", "setAllowArea", "isRactangle", "setRactangle", "minAreaRate", "", "setDetects", "", "pointRects", "setConnerData", "connerData", "Lcom/up366/smartscan2/ConnerData;", "cPreviewData", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/BasePhotoAnswerManager$CameraPreviewData;", "initMinRate", "checkArea", "isRectangle", "realImageArea", "calculateQuadrilateralArea", "", "leftTop", "rightTop", "rightBottom", "leftBottom", "detectToPointF", "checkOutScreen", "getStatus", "convert", "findTopTwoMaxYIndices", "Lkotlin/Pair;", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PaperRecognitionResult {
    private final android.graphics.Rect cropRect;
    private final int degrees;
    private final java.util.List<com.up366.papercut.Detect> detectPoints;
    private final int imageHeight;
    private final int imageWidth;
    private boolean isAllowArea;
    private boolean isRactangle;
    private final java.util.List<android.graphics.PointF> mPoints;
    private double minAreaRate;
    private boolean outScreen;
    private final android.graphics.Rect realCropRect;

    public PaperRecognitionResult(int i, int i2, int i3, android.graphics.Rect rect) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rect, "cropRect");
        this.imageWidth = i;
        this.imageHeight = i2;
        this.degrees = i3;
        this.cropRect = rect;
        this.realCropRect = i3 != 0 ? com.up366.mobile.course.p1p.CameraBitmapUtil.INSTANCE.rotateRect(rect, i, i2, i3) : rect;
        this.mPoints = new java.util.ArrayList();
        this.detectPoints = new java.util.ArrayList();
        this.minAreaRate = 0.8d;
    }

    public final android.graphics.Rect getCropRect() {
        return this.cropRect;
    }

    public final int getDegrees() {
        return this.degrees;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final android.graphics.Rect getRealCropRect() {
        return this.realCropRect;
    }

    public final java.util.List<android.graphics.PointF> getMPoints() {
        return this.mPoints;
    }

    public final java.util.List<com.up366.papercut.Detect> getDetectPoints() {
        return this.detectPoints;
    }

    public final boolean getOutScreen() {
        return this.outScreen;
    }

    public final void setOutScreen(boolean z) {
        this.outScreen = z;
    }

    /* JADX INFO: renamed from: isAllowArea, reason: from getter */
    public final boolean getIsAllowArea() {
        return this.isAllowArea;
    }

    public final void setAllowArea(boolean z) {
        this.isAllowArea = z;
    }

    /* JADX INFO: renamed from: isRactangle, reason: from getter */
    public final boolean getIsRactangle() {
        return this.isRactangle;
    }

    public final void setRactangle(boolean z) {
        this.isRactangle = z;
    }

    public final void setDetects(java.util.List<com.up366.papercut.Detect> pointRects) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pointRects, "pointRects");
        if (pointRects.size() != 4) {
            com.up366.common.log.Logger.error("PaperRecognitionResult setDetects error size:" + pointRects.size());
            return;
        }
        this.detectPoints.clear();
        this.detectPoints.addAll(pointRects);
        detectToPointF();
        checkOutScreen();
        checkArea();
        this.isRactangle = isRectangle();
    }

    public final void setConnerData(com.up366.smartscan2.ConnerData connerData, com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData cPreviewData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(connerData, "connerData");
        this.mPoints.clear();
        com.up366.mobile.course.photoanswer.logic.helper.RotationHelper.INSTANCE.rotateCornerData(connerData, this.imageWidth, this.imageHeight, this.degrees);
        this.mPoints.add(new android.graphics.PointF(connerData.getTopLeft()[0], connerData.getTopLeft()[1]));
        this.mPoints.add(new android.graphics.PointF(connerData.getTopRight()[0], connerData.getTopRight()[1]));
        this.mPoints.add(new android.graphics.PointF(connerData.getBottomRight()[0], connerData.getBottomRight()[1]));
        this.mPoints.add(new android.graphics.PointF(connerData.getBottomLeft()[0], connerData.getBottomLeft()[1]));
        initMinRate(cPreviewData);
        this.isAllowArea = true;
        boolean zIsRectangle = isRectangle();
        this.isRactangle = zIsRectangle;
        if (zIsRectangle) {
            boolean zCheckOutScreen = checkOutScreen();
            this.outScreen = zCheckOutScreen;
            if (zCheckOutScreen) {
                return;
            }
            checkArea();
            convert(cPreviewData);
        }
    }

    private final void initMinRate(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData cPreviewData) {
        if (cPreviewData == null) {
            this.minAreaRate = 0.8d;
            return;
        }
        float width = cPreviewData.getViewSize().getWidth();
        float height = cPreviewData.getViewSize().getHeight();
        if (width <= 0.0f || height <= 0.0f || height < width) {
            this.minAreaRate = 0.8d;
        } else {
            this.minAreaRate = 0.65d;
        }
    }

    private final void checkArea() {
        android.graphics.PointF pointF = this.mPoints.get(0);
        android.graphics.PointF pointF2 = this.mPoints.get(1);
        android.graphics.PointF pointF3 = this.mPoints.get(2);
        android.graphics.PointF pointF4 = this.mPoints.get(3);
        float fCalculateQuadrilateralArea = calculateQuadrilateralArea(pointF, pointF2, pointF3, pointF4);
        int iRealImageArea = realImageArea();
        float fAbs = java.lang.Math.abs(pointF2.x - pointF.x);
        float fAbs2 = java.lang.Math.abs(pointF4.y - pointF.y);
        if (fAbs >= fAbs2) {
            this.isAllowArea = ((double) fAbs) > this.minAreaRate * ((double) this.realCropRect.width());
        } else if (fAbs2 > this.minAreaRate * ((double) this.realCropRect.height())) {
            this.isAllowArea = true;
        } else {
            this.isAllowArea = ((double) (fCalculateQuadrilateralArea / ((float) iRealImageArea))) > java.lang.Math.min(((double) (((float) this.realCropRect.width()) / (((float) this.realCropRect.height()) * 1.0f))) - 0.1d, this.minAreaRate);
        }
    }

    private final boolean isRectangle() {
        android.graphics.PointF pointF = this.mPoints.get(0);
        android.graphics.PointF pointF2 = this.mPoints.get(1);
        android.graphics.PointF pointF3 = this.mPoints.get(2);
        android.graphics.PointF pointF4 = this.mPoints.get(3);
        int iWidth = this.realCropRect.width();
        int iHeight = this.realCropRect.height();
        double d = ((double) iHeight) * 0.33d * ((double) (iHeight / iWidth)) * 1.0d;
        if (java.lang.Math.abs(pointF.y - pointF2.y) > d || java.lang.Math.abs(pointF4.y - pointF3.y) > d) {
            return false;
        }
        double dAbs = java.lang.Math.abs(pointF.x - pointF4.x);
        double d2 = ((double) iWidth) * 0.33d;
        return dAbs <= d2 && ((double) java.lang.Math.abs(pointF2.x - pointF3.x)) <= d2;
    }

    private final int realImageArea() {
        return this.realCropRect.width() * this.realCropRect.height();
    }

    private final float calculateQuadrilateralArea(android.graphics.PointF leftTop, android.graphics.PointF rightTop, android.graphics.PointF rightBottom, android.graphics.PointF leftBottom) {
        return java.lang.Math.abs(((((leftTop.x * rightTop.y) + (rightTop.x * rightBottom.y)) + (rightBottom.x * leftBottom.y)) + (leftBottom.x * leftTop.y)) - ((((rightTop.x * leftTop.y) + (rightBottom.x * rightTop.y)) + (leftBottom.x * rightBottom.y)) + (leftTop.x * leftBottom.y))) * 0.5f;
    }

    private final void detectToPointF() {
        this.mPoints.clear();
        this.mPoints.add(new android.graphics.PointF(this.detectPoints.get(0).getRect().centerX(), this.detectPoints.get(0).getRect().centerY()));
        this.mPoints.add(new android.graphics.PointF(this.detectPoints.get(1).getRect().centerX(), this.detectPoints.get(1).getRect().centerY()));
        this.mPoints.add(new android.graphics.PointF(this.detectPoints.get(2).getRect().centerX(), this.detectPoints.get(2).getRect().centerY()));
        this.mPoints.add(new android.graphics.PointF(this.detectPoints.get(3).getRect().centerX(), this.detectPoints.get(3).getRect().centerY()));
    }

    private final boolean checkOutScreen() {
        boolean z = (this.realCropRect.contains((int) this.mPoints.get(0).x, (int) this.mPoints.get(0).y) && this.realCropRect.contains((int) this.mPoints.get(1).x, (int) this.mPoints.get(1).y) && this.realCropRect.contains((int) this.mPoints.get(2).x, (int) this.mPoints.get(2).y) && this.realCropRect.contains((int) this.mPoints.get(3).x, (int) this.mPoints.get(3).y)) ? false : true;
        this.outScreen = z;
        return z;
    }

    public final int getStatus() {
        if (this.mPoints.size() != 4) {
            return -4;
        }
        if (this.outScreen) {
            return -1;
        }
        if (this.isAllowArea) {
            return !this.isRactangle ? -2 : 0;
        }
        return -3;
    }

    private final void convert(com.up366.mobile.course.photoanswer.logic.cameraAlum.BasePhotoAnswerManager.CameraPreviewData cPreviewData) {
        if (cPreviewData == null || this.mPoints.isEmpty() || this.mPoints.size() != 4) {
            return;
        }
        float width = cPreviewData.getViewSize().getWidth();
        float height = cPreviewData.getViewSize().getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            com.up366.common.log.Logger.error("convert error viewWidth:" + width + ", viewHeight:" + height);
            return;
        }
        if (height < width) {
            com.up366.common.log.Logger.error("convert error viewHeight:" + height + " < viewWidth:" + width);
            return;
        }
        float f = this.imageWidth;
        float f2 = this.imageHeight;
        if (f <= 0.0f || f2 <= 0.0f) {
            com.up366.common.log.Logger.error("convert error imageWidthF:" + f + ", imageHeightF:" + f2);
            return;
        }
        float f3 = width / f;
        float f4 = (height - (f2 * f3)) / 2.0f;
        kotlin.Pair<java.lang.Integer, java.lang.Integer> pairFindTopTwoMaxYIndices = findTopTwoMaxYIndices(this.mPoints);
        int size = this.mPoints.size();
        for (int i = 0; i < size; i++) {
            android.graphics.PointF pointF = this.mPoints.get(i);
            float f5 = pointF.x;
            float f6 = (pointF.y * f3) + (f4 / f3);
            if (i == ((java.lang.Number) pairFindTopTwoMaxYIndices.getFirst()).intValue() || i == ((java.lang.Number) pairFindTopTwoMaxYIndices.getSecond()).intValue()) {
                this.mPoints.set(i, new android.graphics.PointF(f5, f6 + ((2 * f4) / 3)));
            } else {
                this.mPoints.set(i, new android.graphics.PointF(f5, f6));
            }
        }
    }

    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> findTopTwoMaxYIndices(java.util.List<? extends android.graphics.PointF> mPoints) {
        if (mPoints.size() < 2) {
            return new kotlin.Pair<>(-1, -1);
        }
        int i = 0;
        int i2 = 1;
        if (mPoints.get(0).y < mPoints.get(1).y) {
            i2 = 0;
            i = 1;
        }
        int size = mPoints.size();
        for (int i3 = 2; i3 < size; i3++) {
            float f = mPoints.get(i3).y;
            if (f > mPoints.get(i).y) {
                i2 = i;
                i = i3;
            } else if (f > mPoints.get(i2).y) {
                i2 = i3;
            }
        }
        return new kotlin.Pair<>(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
    }
}
