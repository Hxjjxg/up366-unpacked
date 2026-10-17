package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RedPointImageView extends androidx.appcompat.widget.AppCompatImageView {
    private float offsetX;
    private float offsetY;
    private android.graphics.RectF oval;
    private android.graphics.Paint paint;
    private boolean showRedPoint;
    private float size;

    public RedPointImageView(android.content.Context context) {
        super(context);
        init(null);
    }

    public RedPointImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public RedPointImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(android.util.AttributeSet attributeSet) {
        if (attributeSet == null) {
            setImageResource(com.up366.mobile.R.drawable.homework_nopoint_icon);
            return;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.RedPointImageView);
        this.showRedPoint = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.offsetX = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.offsetY = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        this.size = typedArrayObtainStyledAttributes.getDimension(3, 10.0f);
        typedArrayObtainStyledAttributes.recycle();
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setColor(-65536);
        float f = this.size;
        this.oval = new android.graphics.RectF(0.0f, 0.0f, f, f);
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.showRedPoint) {
            this.oval.offsetTo(((getWidth() / 2) - (this.oval.width() / 2.0f)) + this.offsetX, this.offsetY);
            canvas.drawOval(this.oval, this.paint);
        }
    }

    public void showRedPoint(boolean z) {
        this.showRedPoint = z;
        postInvalidate();
    }
}
