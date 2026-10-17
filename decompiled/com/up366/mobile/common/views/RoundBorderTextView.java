package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RoundBorderTextView extends androidx.appcompat.widget.AppCompatTextView {
    private android.graphics.RectF borderRectF;
    private float dp;
    private final android.graphics.Paint paint;

    public RoundBorderTextView(android.content.Context context) {
        this(context, null);
    }

    public RoundBorderTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundBorderTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dp = getResources().getDisplayMetrics().density;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paint = paint;
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeWidth(this.dp * 0.5f);
        this.borderRectF = new android.graphics.RectF(2.0f, 2.0f, 0.0f, 0.0f);
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setColor(getCurrentTextColor());
        this.borderRectF.bottom = getHeight() - 2.0f;
        this.borderRectF.right = getWidth() - 2.0f;
        android.graphics.RectF rectF = this.borderRectF;
        float f = this.dp;
        canvas.drawRoundRect(rectF, f * 3.0f, f * 3.0f, this.paint);
    }
}
