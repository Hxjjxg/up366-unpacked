package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class bc {
    public static org.bouncycastle.jce.provider.BouncyCastleProvider b;

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws com.unicom.online.account.kernel.bd {
        if (bArr == null || bArr.length != 16) {
            throw new com.unicom.online.account.kernel.bd(16);
        }
        if (bArr3 == null) {
            throw new com.unicom.online.account.kernel.bd(10);
        }
        if (bArr2 == null) {
            throw new com.unicom.online.account.kernel.bd(17);
        }
        if (i == 1) {
            if (bArr3.length <= 0) {
                throw new com.unicom.online.account.kernel.bd(14);
            }
        } else if (bArr3.length <= 0 || bArr3.length % 16 != 0) {
            throw new com.unicom.online.account.kernel.bd(15);
        }
        if (bArr2.length != 16) {
            throw new com.unicom.online.account.kernel.bd(17);
        }
        new javax.crypto.spec.SecretKeySpec(bArr, "SM4");
        javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(bArr2);
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("SM4/CBC/PKCS5Padding", (java.security.Provider) b);
            cipher.init(i, new javax.crypto.spec.SecretKeySpec(bArr, "SM4"), ivParameterSpec);
            return cipher.doFinal(bArr3);
        } catch (java.lang.Exception e) {
            if (i == 1) {
                throw new com.unicom.online.account.kernel.bd(8, e);
            }
            throw new com.unicom.online.account.kernel.bd(9, e);
        }
    }
}
