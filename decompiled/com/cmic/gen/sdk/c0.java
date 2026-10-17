package com.cmic.gen.sdk;

/* JADX INFO: compiled from: KeystoreUtil.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class c0 {
    private static byte[] a;

    public static boolean a(android.content.Context context, boolean z) {
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.getKey("CMCC_SDK_V1", null) != null) {
                return true;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (z) {
            return a(context);
        }
        return false;
    }

    static java.lang.String b(android.content.Context context, java.lang.String str) {
        byte[] bArrB = b(context);
        if (bArrB != null) {
            return com.cmic.gen.sdk.a.b(bArrB, str, a);
        }
        a();
        return null;
    }

    static java.lang.String c(android.content.Context context, java.lang.String str) {
        byte[] bArrB = b(context);
        if (bArrB != null) {
            return com.cmic.gen.sdk.a.b(bArrB, str, a);
        }
        a();
        return null;
    }

    public static synchronized byte[] b(android.content.Context context) {
        javax.crypto.Cipher cipher;
        byte[] bArrDoFinal;
        javax.crypto.Cipher cipher2;
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!a(context, false)) {
                return null;
            }
            java.lang.String strB = b();
            if (android.text.TextUtils.isEmpty(strB)) {
                bArrDoFinal = com.cmic.gen.sdk.x1.b();
                a = com.cmic.gen.sdk.x1.b();
                java.security.Key key = keyStore.getKey("CMCC_SDK_V1", null);
                if (key instanceof javax.crypto.SecretKey) {
                    com.cmic.gen.sdk.h0.a("KeystoreUtil", "随机生成aes秘钥");
                    cipher2 = javax.crypto.Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher2.init(1, key, new javax.crypto.spec.IvParameterSpec(a));
                } else {
                    if (!(key instanceof java.security.PrivateKey)) {
                        return null;
                    }
                    java.security.PublicKey publicKey = keyStore.getCertificate("CMCC_SDK_V1").getPublicKey();
                    cipher2 = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                    com.cmic.gen.sdk.h0.a("KeystoreUtil", "生成rsa密");
                    cipher2.init(1, publicKey);
                }
                java.lang.String strEncodeToString = android.util.Base64.encodeToString(cipher2.doFinal(bArrDoFinal), 0);
                java.lang.String strEncodeToString2 = android.util.Base64.encodeToString(a, 0);
                java.util.HashMap map = new java.util.HashMap();
                map.put("AES_IV", strEncodeToString2);
                map.put("AES_KEY", strEncodeToString);
                com.cmic.gen.sdk.h1.a(map);
            } else {
                a = android.util.Base64.decode(c(), 0);
                byte[] bArrDecode = android.util.Base64.decode(strB, 0);
                java.security.Key key2 = keyStore.getKey("CMCC_SDK_V1", null);
                if (key2 == null) {
                    return null;
                }
                if (key2 instanceof javax.crypto.SecretKey) {
                    cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher.init(2, key2, new javax.crypto.spec.IvParameterSpec(a));
                    com.cmic.gen.sdk.h0.a("KeystoreUtil", "使用aes");
                } else {
                    if (!(key2 instanceof java.security.PrivateKey)) {
                        return null;
                    }
                    cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                    cipher.init(2, key2);
                    com.cmic.gen.sdk.h0.a("KeystoreUtil", "使用rsa");
                }
                bArrDoFinal = cipher.doFinal(bArrDecode);
                java.lang.StringBuilder sb = new java.lang.StringBuilder("是否解密出秘钥：");
                sb.append(!android.text.TextUtils.isEmpty(android.util.Base64.encodeToString(bArrDoFinal, 0)));
                com.cmic.gen.sdk.h0.a("KeystoreUtil", sb.toString());
            }
            com.cmic.gen.sdk.h0.a("KeystoreUtil", "是否解密出秘钥：" + android.util.Base64.encodeToString(bArrDoFinal, 0));
            return bArrDoFinal;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static java.lang.String c() {
        return com.cmic.gen.sdk.h1.a("AES_IV", "");
    }

    private static boolean a(android.content.Context context) {
        try {
            javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new android.security.keystore.KeyGenParameterSpec.Builder("CMCC_SDK_V1", 3).setDigests("SHA-256", "SHA-512").setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setKeySize(256).build());
            java.lang.Thread.sleep(1000L);
            keyGenerator.generateKey();
            return true;
        } catch (java.lang.Exception e) {
            com.cmic.gen.sdk.h0.b("KeystoreUtil", e.getMessage());
            return false;
        }
    }

    static java.lang.String a(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bArrB = b(context);
        if (bArrB != null) {
            return com.cmic.gen.sdk.a.a(bArrB, str, a);
        }
        a();
        return null;
    }

    public static void a() {
        com.cmic.gen.sdk.h1.b("AES_KEY");
    }

    private static java.lang.String b() {
        return com.cmic.gen.sdk.h1.a("AES_KEY", "");
    }
}
