package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GuidePointView extends androidx.appcompat.widget.AppCompatImageView {
    private int curIndex;
    private android.graphics.Paint paint;
    private android.graphics.Paint selectPaint;
    private float space;
    private int total;

    public GuidePointView(android.content.Context context) {
        super(context);
        this.total = 2;
        this.curIndex = 0;
        init(null);
    }

    public GuidePointView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.total = 2;
        this.curIndex = 0;
        init(attributeSet);
    }

    public GuidePointView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.total = 2;
        this.curIndex = 0;
        init(attributeSet);
    }

    private void init(android.util.AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.GuidePointView);
        this.total = typedArrayObtainStyledAttributes.getInt(4, 2);
        this.curIndex = typedArrayObtainStyledAttributes.getInt(0, 0);
        int color = typedArrayObtainStyledAttributes.getColor(1, -5390849);
        int color2 = typedArrayObtainStyledAttributes.getColor(2, -1);
        this.space = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, com.up366.common.DpUtilsUp.dp2px(8.0f));
        typedArrayObtainStyledAttributes.recycle();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setColor(color);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.selectPaint = paint2;
        paint2.setColor(color2);
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int i = 1;
        float height = getHeight() >> 1;
        float width = getWidth();
        int i2 = this.total;
        float f = ((width - ((i2 - 1) * this.space)) / 2.0f) - ((i2 - 1) * height);
        canvas.drawCircle(f, height, height, this.curIndex == 0 ? this.selectPaint : this.paint);
        while (i < this.total) {
            f = f + (height * 2.0f) + this.space;
            canvas.drawCircle(f, height, height, this.curIndex == i ? this.selectPaint : this.paint);
            i++;
        }
    }

    public void setCurIndex(int i) {
        this.curIndex = i;
        postInvalidate();
    }

    public void setTotal(int i) {
        this.total = i;
        postInvalidate();
    }
}
