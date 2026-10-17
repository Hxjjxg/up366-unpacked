package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class b {
    public static java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() != 0 && str.trim().length() != 0) {
                if (str2 == null) {
                    throw new java.lang.Exception("decrypt key is null");
                }
                if (str2.length() != 16) {
                    throw new java.lang.Exception("decrypt key length error");
                }
                if (str3.length() != 16) {
                    throw new java.lang.Exception(" iv decrypt key length error");
                }
                byte[] bArrB = com.unicom.online.account.kernel.aq.b(str);
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, new javax.crypto.spec.SecretKeySpec(str2.getBytes(com.igexin.push.g.s.b), "AES"), new javax.crypto.spec.IvParameterSpec(str3.getBytes(com.igexin.push.g.s.b)));
                return new java.lang.String(cipher.doFinal(bArrB), com.igexin.push.g.s.b);
            }
            return null;
        } catch (java.lang.Exception e) {
            throw new java.lang.Exception("decrypt error", e);
        }
    }

    public static java.lang.String c(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() != 0 && str.trim().length() != 0) {
                if (str2 == null) {
                    throw new java.lang.Exception("encrypt key is null");
                }
                if (str2.length() != 16) {
                    throw new java.lang.Exception("encrypt key length error");
                }
                if (str3.length() != 16) {
                    throw new java.lang.Exception(" iv encrypt key length error");
                }
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new javax.crypto.spec.SecretKeySpec(str2.getBytes(com.igexin.push.g.s.b), "AES"), new javax.crypto.spec.IvParameterSpec(str3.getBytes(com.igexin.push.g.s.b)));
                return com.unicom.online.account.kernel.aq.b(cipher.doFinal(str.getBytes(com.igexin.push.g.s.b)));
            }
            return null;
        } catch (java.lang.Exception e) {
            throw new java.lang.Exception("Encrypt error", e);
        }
    }
}
