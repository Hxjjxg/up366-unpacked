package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MoneyUtils {
    public static android.text.SpannableString format(double d) {
        android.text.SpannableString spannableString = new android.text.SpannableString(com.up366.common.StringUtils.format("¥%.2f", java.lang.Double.valueOf(d)));
        spannableString.setSpan(new android.text.style.RelativeSizeSpan(1.0f), 0, 1, 17);
        return spannableString;
    }
}
