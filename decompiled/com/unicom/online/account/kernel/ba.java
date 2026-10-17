package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class ba {
    static {
        "1234567812345678".getBytes();
        java.lang.System.setProperty("org.bouncycastle.asn1.allow_unsafe_integer", "true");
    }

    public static org.bouncycastle.crypto.params.ECPublicKeyParameters b(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        byte[] bArr3 = new byte[32];
        java.lang.System.arraycopy(bArr, 1, bArr2, 0, 32);
        java.lang.System.arraycopy(bArr, 33, bArr3, 0, 32);
        org.bouncycastle.math.ec.ECPoint eCPointCreatePoint = org.bouncycastle.jce.ECNamedCurveTable.getParameterSpec("sm2p256v1").getCurve().createPoint(new java.math.BigInteger(1, bArr2), new java.math.BigInteger(1, bArr3));
        org.bouncycastle.jce.spec.ECNamedCurveParameterSpec parameterSpec = org.bouncycastle.jce.ECNamedCurveTable.getParameterSpec("sm2p256v1");
        return new org.bouncycastle.crypto.params.ECPublicKeyParameters(eCPointCreatePoint, new org.bouncycastle.crypto.params.ECDomainParameters(parameterSpec.getCurve(), parameterSpec.getG(), parameterSpec.getN(), parameterSpec.getH(), parameterSpec.getSeed()));
    }
}
