package com.up366.view.crop.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ImageState {
    private android.graphics.RectF mCropRect;
    private float mCurrentAngle;
    private android.graphics.RectF mCurrentImageRect;
    private float mCurrentScale;

    public ImageState(android.graphics.RectF rectF, android.graphics.RectF rectF2, float f, float f2) {
        this.mCropRect = rectF;
        this.mCurrentImageRect = rectF2;
        this.mCurrentScale = f;
        this.mCurrentAngle = f2;
    }

    public android.graphics.RectF getCropRect() {
        return this.mCropRect;
    }

    public android.graphics.RectF getCurrentImageRect() {
        return this.mCurrentImageRect;
    }

    public float getCurrentScale() {
        return this.mCurrentScale;
    }

    public float getCurrentAngle() {
        return this.mCurrentAngle;
    }
}
