package com.up366.qmui.span;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBlockSpaceSpan extends android.text.style.ReplacementSpan {
    private int mHeight;

    @Override // android.text.style.ReplacementSpan
    public void draw(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, android.graphics.Paint paint) {
    }

    public QMUIBlockSpaceSpan(int i) {
        this.mHeight = i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(android.graphics.Paint paint, java.lang.CharSequence charSequence, int i, int i2, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null && !com.up366.qmui.util.QMUIDeviceHelper.isMeizu()) {
            int fontMetricsInt2 = (-this.mHeight) - paint.getFontMetricsInt(fontMetricsInt);
            fontMetricsInt.top = fontMetricsInt2;
            fontMetricsInt.ascent = fontMetricsInt2;
            fontMetricsInt.bottom = 0;
            fontMetricsInt.descent = 0;
        }
        return 0;
    }
}
