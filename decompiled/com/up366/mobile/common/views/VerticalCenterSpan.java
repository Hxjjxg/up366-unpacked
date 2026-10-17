package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VerticalCenterSpan extends android.text.style.ReplacementSpan {
    private int fontSizePx;
    private int textColor;

    public VerticalCenterSpan(int i) {
        this.fontSizePx = i;
    }

    public VerticalCenterSpan(int i, int i2) {
        this.fontSizePx = i;
        this.textColor = i2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(android.graphics.Paint paint, java.lang.CharSequence charSequence, int i, int i2, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        return (int) getCustomTextPaint(paint).measureText(charSequence.subSequence(i, i2).toString());
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, android.graphics.Paint paint) {
        java.lang.CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
        android.text.TextPaint customTextPaint = getCustomTextPaint(paint);
        android.graphics.Paint.FontMetricsInt fontMetricsInt = customTextPaint.getFontMetricsInt();
        canvas.drawText(charSequenceSubSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), customTextPaint);
    }

    private android.text.TextPaint getCustomTextPaint(android.graphics.Paint paint) {
        android.text.TextPaint textPaint = new android.text.TextPaint(paint);
        textPaint.setTextSize(this.fontSizePx);
        int i = this.textColor;
        if (i != 0) {
            textPaint.setColor(i);
        }
        return textPaint;
    }
}
