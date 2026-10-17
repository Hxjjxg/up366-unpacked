package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RoundImageView extends androidx.appcompat.widget.AppCompatImageView {
    private int aliasColor;
    private float cornerRadius;
    private android.graphics.Paint paint;
    private android.graphics.Path path;
    private android.graphics.RectF rect;

    public RoundImageView(android.content.Context context) {
        super(context);
        init(context, null);
    }

    public RoundImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public RoundImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        this.rect = new android.graphics.RectF();
        this.path = new android.graphics.Path();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setStrokeWidth(1.0f);
        this.paint.setStyle(android.graphics.Paint.Style.STROKE);
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.RoundImageView);
            this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
            int color = typedArrayObtainStyledAttributes.getColor(0, 1728053247);
            this.aliasColor = color;
            this.paint.setColor(color);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void setCornerRadius(float f) {
        this.cornerRadius = f;
        postInvalidate();
    }

    public int getAliasColor() {
        return this.aliasColor;
    }

    public void setAliasColor(int i) {
        this.aliasColor = i;
        this.paint.setColor(i);
        postInvalidate();
    }

    public void draw(android.graphics.Canvas canvas) {
        this.rect.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.path.reset();
        android.graphics.Path path = this.path;
        android.graphics.RectF rectF = this.rect;
        float f = this.cornerRadius;
        path.addRoundRect(rectF, f, f, android.graphics.Path.Direction.CW);
        canvas.save();
        canvas.clipPath(this.path);
        super.draw(canvas);
        canvas.restore();
        android.graphics.RectF rectF2 = this.rect;
        float f2 = this.cornerRadius;
        canvas.drawRoundRect(rectF2, f2, f2, this.paint);
    }
}
