package com.warkiz.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ArrowView extends android.view.View {
    private final int mHeight;
    private final android.graphics.Paint mPaint;
    private final android.graphics.Path mPath;
    private final int mWidth;

    public ArrowView(android.content.Context context) {
        this(context, null);
    }

    public ArrowView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int iDp2px = com.warkiz.widget.IndicatorUtils.dp2px(context, 12.0f);
        this.mWidth = iDp2px;
        int iDp2px2 = com.warkiz.widget.IndicatorUtils.dp2px(context, 7.0f);
        this.mHeight = iDp2px2;
        android.graphics.Path path = new android.graphics.Path();
        this.mPath = path;
        path.moveTo(0.0f, 0.0f);
        path.lineTo(iDp2px, 0.0f);
        path.lineTo(iDp2px / 2.0f, iDp2px2);
        path.close();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
    }

    void setColor(int i) {
        this.mPaint.setColor(i);
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        canvas.drawPath(this.mPath, this.mPaint);
    }
}
