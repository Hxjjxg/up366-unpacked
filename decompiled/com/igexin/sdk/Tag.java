package com.igexin.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Tag implements java.io.Serializable {
    private static final long serialVersionUID = 7265815580156141684L;
    private java.lang.String name;

    private boolean isValidTagName(java.lang.String str) {
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            z = (cCharAt >= 19968 && cCharAt <= 40869) || (cCharAt >= 'A' && cCharAt <= 'Z') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '+' || cCharAt == '-' || cCharAt == '*' || cCharAt == '_' || cCharAt == ' ' || cCharAt == ':'));
            if (!z) {
                break;
            }
        }
        return z;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public boolean isValidTagValue(java.lang.String str) {
        return isValidTagName(str);
    }

    public com.igexin.sdk.Tag setName(java.lang.String str) {
        this.name = str;
        return this;
    }
}
