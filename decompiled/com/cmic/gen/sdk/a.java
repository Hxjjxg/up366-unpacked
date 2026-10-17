package com.cmic.gen.sdk;

/* JADX INFO: compiled from: AESUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class a {
    public static java.lang.String a(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, new javax.crypto.spec.GCMParameterSpec(128, java.util.Arrays.copyOf(bArr, 12)));
            return android.util.Base64.encodeToString(cipher.doFinal(str.getBytes(com.igexin.push.g.s.b)), 2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String b(byte[] bArr, java.lang.String str, byte[] bArr2) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr2));
            return android.util.Base64.encodeToString(cipher.doFinal(str.getBytes(com.igexin.push.g.s.b)), 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(byte[] bArr, java.lang.String str, byte[] bArr2) {
        try {
            byte[] bArrDecode = android.util.Base64.decode(str, 0);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr2));
            return new java.lang.String(cipher.doFinal(bArrDecode), com.igexin.push.g.s.b);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a() {
        byte[] bArr = new byte[16];
        new java.security.SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
