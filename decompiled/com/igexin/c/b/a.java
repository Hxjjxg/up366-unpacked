package com.igexin.c.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class a {
    private static final char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static java.lang.String a() {
        java.util.Random random = new java.util.Random();
        char[] cArr = new char[32];
        for (int i = 0; i < 32; i++) {
            char[] cArr2 = a;
            cArr[i] = cArr2[random.nextInt(cArr2.length)];
        }
        return new java.lang.String(cArr);
    }

    public static java.lang.String a(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("");
            int length = bArrDigest.length;
            for (int i = 0; i < length; i++) {
                int i2 = bArrDigest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(java.lang.Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    private static java.lang.String a(byte[] bArr, int i, int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i3 = i; i3 < i + i2; i3++) {
            sb.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(bArr[i3])));
        }
        return sb.toString();
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static byte[] a(byte[] bArr) {
        java.security.MessageDigest messageDigest;
        try {
            messageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (java.security.NoSuchAlgorithmException e) {
            com.igexin.c.a.c.a.a(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static java.lang.String b(java.lang.String str) {
        java.security.MessageDigest messageDigest;
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            messageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (java.security.NoSuchAlgorithmException e) {
            com.igexin.c.a.c.a.a(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bytes);
        byte[] bArrDigest = messageDigest.digest();
        char[] cArr2 = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArrDigest[i2];
            int i3 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i += 2;
            cArr2[i3] = cArr[b & 15];
        }
        return new java.lang.String(cArr2);
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        return android.text.TextUtils.isEmpty(str) ? str2 : str;
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArrA;
        if (bArr == null || (bArrA = com.igexin.c.a.b.g.a(bArr)) == null) {
            return null;
        }
        java.lang.String strB = b(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        int length = bArrA.length;
        byte[] bArr2 = new byte[length + 16];
        byte[] bytes = strB.substring(0, 8).getBytes();
        byte[] bytes2 = strB.substring(24, 32).getBytes();
        java.lang.System.arraycopy(bytes, 0, bArr2, 0, 8);
        java.lang.System.arraycopy(bArrA, 0, bArr2, 8, length);
        java.lang.System.arraycopy(bytes2, 0, bArr2, length + 8, 8);
        return bArr2;
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - 16];
        java.lang.System.arraycopy(bArr, 8, bArr2, 0, bArr.length - 16);
        return com.igexin.c.a.b.g.b(bArr2);
    }
}
