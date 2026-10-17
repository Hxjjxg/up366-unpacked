package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class ad {
    public static final com.unicom.online.account.kernel.ba b = new com.unicom.online.account.kernel.ba();
    public static final com.unicom.online.account.kernel.bc c;

    static {
        com.unicom.online.account.kernel.bc.b = new org.bouncycastle.jce.provider.BouncyCastleProvider();
        c = new com.unicom.online.account.kernel.bc();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws com.unicom.online.account.kernel.bd {
        b.getClass();
        if (bArr == null) {
            throw new com.unicom.online.account.kernel.bd(10);
        }
        if (bArr.length == 0) {
            throw new com.unicom.online.account.kernel.bd(18);
        }
        if (bArr2.length != 65) {
            throw new com.unicom.online.account.kernel.bd(20);
        }
        if (bArr2[0] != 4) {
            throw new com.unicom.online.account.kernel.bd(11);
        }
        try {
            org.bouncycastle.crypto.params.ECPublicKeyParameters eCPublicKeyParametersB = com.unicom.online.account.kernel.ba.b(bArr2);
            org.bouncycastle.crypto.engines.SM2Engine sM2Engine = new org.bouncycastle.crypto.engines.SM2Engine();
            sM2Engine.init(true, new org.bouncycastle.crypto.params.ParametersWithRandom(eCPublicKeyParametersB, new java.security.SecureRandom()));
            try {
                byte[] bArrProcessBlock = sM2Engine.processBlock(bArr, 0, bArr.length);
                if (bArrProcessBlock == null || bArrProcessBlock.length < 97) {
                    throw new com.unicom.online.account.kernel.bd(13);
                }
                byte[] bArr3 = new byte[bArrProcessBlock.length];
                java.lang.System.arraycopy(bArrProcessBlock, 0, bArr3, 0, 65);
                java.lang.System.arraycopy(bArrProcessBlock, bArrProcessBlock.length - 32, bArr3, 65, 32);
                java.lang.System.arraycopy(bArrProcessBlock, 65, bArr3, 97, bArrProcessBlock.length - 97);
                return bArr3;
            } catch (org.bouncycastle.crypto.InvalidCipherTextException e) {
                throw new com.unicom.online.account.kernel.bd(4, e);
            }
        } catch (java.lang.Exception unused) {
            throw new com.unicom.online.account.kernel.bd(19);
        }
    }
}
