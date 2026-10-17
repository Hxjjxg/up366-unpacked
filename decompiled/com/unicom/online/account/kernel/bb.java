package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class bb {
    public static java.lang.String b(java.lang.String str) {
        org.bouncycastle.crypto.digests.SM3Digest sM3Digest = new org.bouncycastle.crypto.digests.SM3Digest();
        byte[] bytes = str.getBytes(java.nio.charset.Charset.forName("UTF-8"));
        sM3Digest.update(bytes, 0, bytes.length);
        int digestSize = sM3Digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        sM3Digest.doFinal(bArr, 0);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < digestSize; i++) {
            java.lang.String hexString = java.lang.Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
