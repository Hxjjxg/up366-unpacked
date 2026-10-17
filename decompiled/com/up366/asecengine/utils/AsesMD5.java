package com.up366.asecengine.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsesMD5 {
    private final java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");

    public void append(byte[] bArr) throws java.security.NoSuchAlgorithmException {
        this.md.update(md5(bArr).getBytes(java.nio.charset.Charset.forName("UTF-8")));
    }

    public java.lang.String build() {
        return com.up366.common.digest.Hex.bytesToHexString(this.md.digest());
    }

    private static java.lang.String md5(byte[] bArr) throws java.security.NoSuchAlgorithmException {
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
        messageDigest.update(bArr, 0, bArr.length);
        return com.up366.common.digest.Hex.bytesToHexString(messageDigest.digest());
    }
}
