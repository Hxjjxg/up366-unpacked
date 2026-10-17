package com.up366.qmui.span;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITextSizeSpan extends android.text.style.ReplacementSpan {
    private android.graphics.Paint mPaint;
    private int mTextSize;
    private android.graphics.Typeface mTypeface;
    private int mVerticalOffset;

    public QMUITextSizeSpan(int i, int i2) {
        this(i, i2, null);
    }

    public QMUITextSizeSpan(int i, int i2, android.graphics.Typeface typeface) {
        this.mTextSize = i;
        this.mVerticalOffset = i2;
        this.mTypeface = typeface;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(android.graphics.Paint paint, java.lang.CharSequence charSequence, int i, int i2, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        android.graphics.Paint paint2 = new android.graphics.Paint(paint);
        this.mPaint = paint2;
        paint2.setTextSize(this.mTextSize);
        this.mPaint.setTypeface(this.mTypeface);
        if (this.mTextSize > paint.getTextSize() && fontMetricsInt != null) {
            android.graphics.Paint.FontMetricsInt fontMetricsInt2 = this.mPaint.getFontMetricsInt();
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return (int) this.mPaint.measureText(charSequence, i, i2);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, android.graphics.Paint paint) {
        canvas.drawText(charSequence, i, i2, f, i4 + this.mVerticalOffset, this.mPaint);
    }
}
