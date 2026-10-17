package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0054k {
    private static final char[] a = com.igexin.c.a.b.g.b.toCharArray();

    public static java.lang.String a(byte[] bArr) {
        int length = bArr.length;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
            char[] cArr = a;
            stringBuffer.append(cArr[(i4 >> 18) & 63]);
            stringBuffer.append(cArr[(i4 >> 12) & 63]);
            stringBuffer.append(cArr[(i4 >> 6) & 63]);
            stringBuffer.append(cArr[i4 & 63]);
            i2 += 3;
            int i5 = i3 + 1;
            if (i3 >= 14) {
                stringBuffer.append(" ");
                i3 = 0;
            } else {
                i3 = i5;
            }
        }
        if (i2 == length - 2) {
            int i6 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
            char[] cArr2 = a;
            stringBuffer.append(cArr2[(i6 >> 18) & 63]);
            stringBuffer.append(cArr2[(i6 >> 12) & 63]);
            stringBuffer.append(cArr2[(i6 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i2 == length - 1) {
            int i7 = (bArr[i2] & 255) << 16;
            char[] cArr3 = a;
            stringBuffer.append(cArr3[(i7 >> 18) & 63]);
            stringBuffer.append(cArr3[(i7 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    public static byte[] a(java.lang.String str) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
        } catch (java.io.IOException unused) {
        }
        try {
            a(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return byteArray;
        } catch (java.io.IOException unused2) {
            throw new java.lang.RuntimeException();
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static void a(java.lang.String str, java.io.OutputStream outputStream) throws java.io.IOException {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else {
                if (i == length) {
                    return;
                }
                int i2 = i + 2;
                int i3 = i + 3;
                int iA = (a(str.charAt(i)) << 18) + (a(str.charAt(i + 1)) << 12) + (a(str.charAt(i2)) << 6) + a(str.charAt(i3));
                outputStream.write((iA >> 16) & 255);
                if (str.charAt(i2) == '=') {
                    return;
                }
                outputStream.write((iA >> 8) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                outputStream.write(iA & 255);
                i += 4;
            }
        }
    }

    private static int a(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'G';
        }
        if (c >= '0' && c <= '9') {
            return c + 4;
        }
        if (c == '+') {
            return 62;
        }
        if (c == '/') {
            return 63;
        }
        if (c == '=') {
            return 0;
        }
        throw new java.lang.RuntimeException("unexpected code: " + c);
    }
}
