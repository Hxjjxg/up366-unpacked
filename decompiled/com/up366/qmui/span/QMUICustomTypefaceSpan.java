package com.up366.qmui.span;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUICustomTypefaceSpan extends android.text.style.TypefaceSpan {
    public static final android.os.Parcelable.Creator<com.up366.qmui.span.QMUICustomTypefaceSpan> CREATOR = new android.os.Parcelable.Creator<com.up366.qmui.span.QMUICustomTypefaceSpan>() { // from class: com.up366.qmui.span.QMUICustomTypefaceSpan.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.qmui.span.QMUICustomTypefaceSpan createFromParcel(android.os.Parcel parcel) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.qmui.span.QMUICustomTypefaceSpan[] newArray(int i) {
            return new com.up366.qmui.span.QMUICustomTypefaceSpan[i];
        }
    };
    private final android.graphics.Typeface newType;

    public QMUICustomTypefaceSpan(java.lang.String str, android.graphics.Typeface typeface) {
        super(str);
        this.newType = typeface;
    }

    private static void applyCustomTypeFace(android.graphics.Paint paint, android.graphics.Typeface typeface) {
        if (typeface == null) {
            return;
        }
        android.graphics.Typeface typeface2 = paint.getTypeface();
        int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(android.text.TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.newType);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(android.text.TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.newType);
    }
}
