package com.cmic.gen.sdk;

/* JADX INFO: compiled from: MD5STo16Byte.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class j0 {
    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(str.getBytes(com.igexin.push.g.s.b));
        } catch (java.io.UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return com.cmic.gen.sdk.x1.a(messageDigest.digest());
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
