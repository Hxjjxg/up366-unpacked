package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class m0 {
    public static java.lang.String a(byte[] bArr, java.security.PublicKey publicKey) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            return a(cipher.doFinal(bArr));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(bArr.length);
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static java.security.PublicKey a(java.lang.String str) throws java.lang.Exception {
        try {
            return java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(com.chuanglan.shanyan_sdk.AbstractC0054k.a(str)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception("公钥数据为空");
        } catch (java.security.NoSuchAlgorithmException unused2) {
            throw new java.lang.Exception("无此算法");
        } catch (java.security.spec.InvalidKeySpecException unused3) {
            throw new java.lang.Exception("公钥非法");
        }
    }
}
