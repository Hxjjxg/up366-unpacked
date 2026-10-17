package com.cmic.gen.sdk;

/* JADX INFO: compiled from: NoPaddingTextviewUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class l0 {

    /* JADX INFO: compiled from: NoPaddingTextviewUtils.java */
    class a implements android.text.style.LineHeightSpan {
        final /* synthetic */ android.widget.TextView a;

        a(android.widget.TextView textView) {
            this.a = textView;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(java.lang.CharSequence charSequence, int i, int i2, int i3, int i4, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
            android.graphics.Rect rect = new android.graphics.Rect();
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(this.a.getPaint(), charSequence, 0, charSequence.length(), rect);
            } else {
                this.a.getPaint().getTextBounds(charSequence.toString(), 0, charSequence.length(), rect);
            }
            if (rect.bottom - rect.top < this.a.getTextSize()) {
                float textSize = this.a.getTextSize();
                int i5 = rect.bottom;
                float f = (textSize - (i5 - r2)) / 2.0f;
                fontMetricsInt.top = (int) (rect.top - f);
                fontMetricsInt.bottom = (int) (i5 + f);
            } else {
                fontMetricsInt.top = rect.top;
                fontMetricsInt.bottom = rect.bottom;
            }
            fontMetricsInt.ascent = fontMetricsInt.top;
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
    }

    public static void a(android.widget.TextView textView, java.lang.CharSequence charSequence) {
        if (textView == null || charSequence == null) {
            return;
        }
        textView.setPadding(textView.getPaddingLeft(), 0, textView.getPaddingRight(), 0);
        android.text.SpannableString spannableString = new android.text.SpannableString(charSequence);
        spannableString.setSpan(new com.cmic.gen.sdk.l0.a(textView), 0, charSequence.length(), 33);
        textView.setText(spannableString);
    }
}
