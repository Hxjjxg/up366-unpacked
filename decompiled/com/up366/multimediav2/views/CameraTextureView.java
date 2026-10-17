package com.up366.multimediav2.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CameraTextureView extends android.view.TextureView {
    private int mRatioHeight;
    private int mRatioWidth;

    public CameraTextureView(android.content.Context context) {
        this(context, null);
    }

    public CameraTextureView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraTextureView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatioWidth = 0;
        this.mRatioHeight = 0;
    }

    public void setAspectRatio(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("Size cannot be negative.");
        }
        this.mRatioWidth = i;
        this.mRatioHeight = i2;
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        int i4 = this.mRatioWidth;
        if (i4 == 0 || (i3 = this.mRatioHeight) == 0) {
            setMeasuredDimension(size, size2);
        } else if (size < (size2 * i4) / i3) {
            setMeasuredDimension(size, (i3 * size) / i4);
        } else {
            setMeasuredDimension((i4 * size2) / i3, size2);
        }
    }
}
