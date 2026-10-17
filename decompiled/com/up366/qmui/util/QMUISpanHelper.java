package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISpanHelper {
    public static java.lang.CharSequence generateSideIconText(boolean z, int i, java.lang.CharSequence charSequence, android.graphics.drawable.Drawable drawable) {
        return generateSideIconText(z, i, charSequence, drawable, 0);
    }

    public static java.lang.CharSequence generateSideIconText(boolean z, int i, java.lang.CharSequence charSequence, android.graphics.drawable.Drawable drawable, int i2) {
        return generateSideIconText(z, i, charSequence, drawable, i2, 0, null);
    }

    public static java.lang.CharSequence generateSideIconText(boolean z, int i, java.lang.CharSequence charSequence, android.graphics.drawable.Drawable drawable, int i2, android.view.View view) {
        return generateSideIconText(z, i, charSequence, drawable, 0, i2, view);
    }

    public static java.lang.CharSequence generateSideIconText(boolean z, int i, java.lang.CharSequence charSequence, android.graphics.drawable.Drawable drawable, int i2, int i3, android.view.View view) {
        return generateHorIconText(charSequence, z ? i : 0, z ? drawable : null, z ? i3 : 0, z ? 0 : i, z ? null : drawable, z ? 0 : i3, i2, view);
    }

    public static java.lang.CharSequence generateHorIconText(java.lang.CharSequence charSequence, int i, android.graphics.drawable.Drawable drawable, int i2, android.graphics.drawable.Drawable drawable2) {
        return generateHorIconText(charSequence, i, drawable, i2, drawable2, 0);
    }

    public static java.lang.CharSequence generateHorIconText(java.lang.CharSequence charSequence, int i, android.graphics.drawable.Drawable drawable, int i2, android.graphics.drawable.Drawable drawable2, int i3) {
        return generateHorIconText(charSequence, i, drawable, 0, i2, drawable2, 0, i3, null);
    }

    public static java.lang.CharSequence generateHorIconText(java.lang.CharSequence charSequence, int i, android.graphics.drawable.Drawable drawable, int i2, int i3, android.graphics.drawable.Drawable drawable2, int i4, android.view.View view) {
        return generateHorIconText(charSequence, i, drawable, i2, i3, drawable2, i4, 0, view);
    }

    public static java.lang.CharSequence generateHorIconText(java.lang.CharSequence charSequence, int i, android.graphics.drawable.Drawable drawable, int i2, int i3, android.graphics.drawable.Drawable drawable2, int i4, int i5, android.view.View view) {
        if (drawable == null && drawable2 == null) {
            return charSequence;
        }
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableStringBuilder.append((java.lang.CharSequence) "[icon]");
            int length = spannableStringBuilder.length();
            com.up366.qmui.span.QMUIMarginImageSpan qMUIMarginImageSpan = new com.up366.qmui.span.QMUIMarginImageSpan(drawable, -100, 0, i, i5);
            qMUIMarginImageSpan.setSkinSupportWithTintColor(view, i2);
            qMUIMarginImageSpan.setAvoidSuperChangeFontMetrics(true);
            spannableStringBuilder.setSpan(qMUIMarginImageSpan, 0, length, 17);
        }
        spannableStringBuilder.append(charSequence);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((java.lang.CharSequence) "[icon]");
            int length3 = spannableStringBuilder.length();
            com.up366.qmui.span.QMUIMarginImageSpan qMUIMarginImageSpan2 = new com.up366.qmui.span.QMUIMarginImageSpan(drawable2, -100, i3, 0, i5);
            qMUIMarginImageSpan2.setSkinSupportWithTintColor(view, i4);
            qMUIMarginImageSpan2.setAvoidSuperChangeFontMetrics(true);
            spannableStringBuilder.setSpan(qMUIMarginImageSpan2, length2, length3, 17);
        }
        return spannableStringBuilder;
    }
}
