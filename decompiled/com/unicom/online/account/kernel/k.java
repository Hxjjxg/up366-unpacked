package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class k {
    public static byte[] b() {
        char[] charArray = "045C5DD4890819CEB16B0A66ED62B2FFA29B08F3CBF344A52A3A100ECB271BBEF3A9BC3743E753CA16EF238A1E55B72E95659A70425064D506B48F8EE3442786F7".toCharArray();
        byte[] bArr = new byte[65];
        int i = 0;
        int i2 = 0;
        while (i < 130) {
            bArr[i2] = java.lang.Integer.valueOf(java.lang.Integer.parseInt("" + charArray[i] + charArray[i + 1], 16) & 255).byteValue();
            i += 2;
            i2++;
        }
        return bArr;
    }
}
