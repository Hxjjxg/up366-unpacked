package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SpannableStringBuilderUtil {
    private android.text.SpannableString currentSpan;
    private final android.text.SpannableStringBuilder sb = new android.text.SpannableStringBuilder();

    public android.text.SpannableStringBuilder build() {
        android.text.SpannableString spannableString = this.currentSpan;
        if (spannableString != null) {
            this.sb.append((java.lang.CharSequence) spannableString);
        }
        return this.sb;
    }

    public com.up366.mobile.common.utils.SpannableStringBuilderUtil append(java.lang.CharSequence charSequence) {
        android.text.SpannableString spannableString = this.currentSpan;
        if (spannableString != null) {
            this.sb.append((java.lang.CharSequence) spannableString);
        }
        this.currentSpan = new android.text.SpannableString(charSequence);
        return this;
    }

    public com.up366.mobile.common.utils.SpannableStringBuilderUtil setSpan(android.text.style.CharacterStyle characterStyle) {
        android.text.SpannableString spannableString = this.currentSpan;
        if (spannableString != null) {
            spannableString.setSpan(characterStyle, 0, spannableString.length(), 33);
        }
        return this;
    }
}
