package com.davemorrissey.labs.subscaleview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class ImageViewState implements java.io.Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public ImageViewState(float f, android.graphics.PointF pointF, int i) {
        this.scale = f;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i;
    }

    public float getScale() {
        return this.scale;
    }

    public android.graphics.PointF getCenter() {
        return new android.graphics.PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }
}
