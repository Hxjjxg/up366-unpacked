package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountOrganInfo {
    private transient float cosDistance;
    private java.lang.String organId;
    private java.lang.String organName;

    public java.lang.String getOrganId() {
        return this.organId;
    }

    public void setOrganId(java.lang.String str) {
        this.organId = str;
    }

    public java.lang.String getOrganName() {
        return this.organName;
    }

    public void setOrganName(java.lang.String str) {
        this.organName = str;
    }

    public boolean containsWord(java.lang.String str) {
        java.lang.String lowerCase = this.organName.toLowerCase();
        java.lang.String lowerCase2 = str.toLowerCase();
        for (int i = 0; i < lowerCase2.length(); i++) {
            if (!lowerCase.contains(java.lang.String.valueOf(lowerCase2.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public java.lang.CharSequence buildColorString(android.content.Context context, java.lang.String str) {
        com.up366.mobile.common.utils.SpannableStringBuilderUtil spannableStringBuilderUtil = new com.up366.mobile.common.utils.SpannableStringBuilderUtil();
        int color = context.getResources().getColor(com.up366.mobile.R.color.c1);
        for (int i = 0; i < this.organName.length(); i++) {
            java.lang.String strValueOf = java.lang.String.valueOf(this.organName.charAt(i));
            spannableStringBuilderUtil.append(strValueOf);
            if (str.contains(strValueOf)) {
                spannableStringBuilderUtil.setSpan(new android.text.style.ForegroundColorSpan(color));
            }
        }
        return spannableStringBuilderUtil.build();
    }

    public float getCosDistance() {
        return this.cosDistance;
    }

    public void setCosDistance(float f) {
        this.cosDistance = f;
    }

    public void countCosDistance(java.lang.String str) {
        this.cosDistance = countCosDistance(str, this.organName);
    }

    public float countCosDistance(java.lang.String str, java.lang.String str2) {
        char[] charArray = (str + str2).toCharArray();
        char[] charArray2 = str.toCharArray();
        char[] charArray3 = str2.toCharArray();
        float f = 0.0f;
        if (charArray.length == 0) {
            return 0.0f;
        }
        java.util.Arrays.sort(charArray);
        char[] cArr = new char[charArray2.length + charArray3.length];
        int i = 0;
        char c = 0;
        for (char c2 : charArray) {
            if (c2 != c) {
                cArr[i] = c2;
                i++;
                c = c2;
            }
        }
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            char c3 = cArr[i2];
            for (char c4 : charArray2) {
                if (c3 == c4) {
                    iArr[i2] = iArr[i2] + 1;
                }
            }
            for (char c5 : charArray3) {
                if (c3 == c5) {
                    iArr2[i2] = iArr2[i2] + 1;
                }
            }
        }
        float f2 = 0.0f;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += iArr[i4] * iArr2[i4];
            f += r1 * r1;
            f2 += r5 * r5;
        }
        return (float) (((double) i3) / (java.lang.Math.sqrt(f) * java.lang.Math.sqrt(f2)));
    }
}
