package com.up366.common.digest;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Hex {
    public static java.lang.String bytesToHexString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append("0");
            }
            sb.append(java.lang.Integer.toHexString(i));
        }
        return sb.toString();
    }

    private static int toDigit(char c, int i) throws java.lang.Exception {
        int iDigit = java.lang.Character.digit(c, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new java.lang.Exception("Illegal hexadecimal character " + c + " at index " + i);
    }

    public static byte[] hexStringToBytes(java.lang.String str) throws java.lang.Exception {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        if ((length & 1) != 0) {
            throw new java.lang.Exception("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            int digit = (toDigit(charArray[i], i) << 4) | toDigit(charArray[i3], i3);
            i += 2;
            bArr[i2] = (byte) (digit & 255);
            i2++;
        }
        return bArr;
    }

    public static byte[] intToByteArray(int i) {
        int iNumberOfLeadingZeros = (40 - java.lang.Integer.numberOfLeadingZeros(i < 0 ? ~i : i)) / 8;
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < iNumberOfLeadingZeros; i2++) {
            bArr[3 - i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static int byteArrayToInt(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 += (bArr[i3 + i] & 255) << ((3 - i3) * 8);
        }
        return i2;
    }
}
