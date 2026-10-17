package com.igexin.c.a.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class g {
    public static final int a = 512;
    public static final java.lang.String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    static final char c = '=';
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 1;
    public static final int k = 2;
    private static final java.lang.String l = "IoUtil";
    private static int[] m;

    public static int a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        return 4;
    }

    public static int a(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((j2 >> 56) & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 7] = (byte) (j2 & 255);
        return 8;
    }

    public static int a(byte[] bArr, byte[] bArr2, int i2, int i3) {
        java.lang.System.arraycopy(bArr, 0, bArr2, i2, i3);
        return i3;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str3 == null || str == null || str2 == null) {
            return null;
        }
        if (!str3.contains(str)) {
            return str3;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            int iIndexOf = str3.indexOf(str);
            if (iIndexOf == -1) {
                sb.append(str3);
                return sb.toString();
            }
            sb.append(str3.substring(0, iIndexOf));
            sb.append(str2);
            str3 = str3.substring(iIndexOf + str.length());
        }
    }

    private static java.lang.String a(java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!strArr[0].equals("")) {
            sb.append(strArr[0]);
            sb.append("://");
        }
        if (!strArr[1].equals("")) {
            sb.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            sb.append(':');
            sb.append(strArr[2]);
        }
        if (!strArr[3].equals("")) {
            sb.append(strArr[3]);
            if (!strArr[3].equals("/")) {
                sb.append('/');
            }
        }
        if (!strArr[4].equals("")) {
            sb.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            sb.append('?');
            sb.append(strArr[5]);
        }
        return sb.toString();
    }

    public static short a(byte[] bArr, int i2) {
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    private static void a(android.database.Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(l, th.toString());
            }
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e2) {
                com.igexin.c.a.c.a.a(l, e2.toString());
            }
        }
    }

    private static void a(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    private static void a(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i2) throws java.io.IOException {
        com.igexin.c.a.b.b bVar = new com.igexin.c.a.b.b(outputStream, i2);
        a(inputStream, bVar);
        bVar.a();
    }

    public static byte[] a(int i2) {
        int i3;
        int i4 = 0;
        int i5 = 0;
        do {
            i3 = 24;
            i4 |= (i2 & 127) << 24;
            i2 >>>= 7;
            i5++;
            if (i2 > 0) {
                i4 = (i4 >>> 8) | com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            }
        } while (i2 > 0);
        byte[] bArr = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = (byte) (i4 >>> i3);
            i3 -= 8;
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.igexin.c.a.c.a.a(th);
                } finally {
                    a(gZIPOutputStream);
                    a(byteArrayOutputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
        }
        return byteArray;
    }

    public static java.lang.String[] a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.toLowerCase());
        java.lang.String[] strArr = new java.lang.String[6];
        for (int i2 = 0; i2 < 6; i2++) {
            strArr[i2] = "";
        }
        int iIndexOf = str.indexOf(":");
        if (iIndexOf > 0) {
            strArr[0] = str.substring(0, iIndexOf);
            sb.delete(0, iIndexOf + 1);
        } else if (iIndexOf == 0) {
            throw new java.lang.IllegalArgumentException("url format error - protocol");
        }
        if (sb.length() >= 2 && sb.charAt(0) == '/' && sb.charAt(1) == '/') {
            sb.delete(0, 2);
            int iIndexOf2 = sb.toString().indexOf(47);
            if (iIndexOf2 < 0) {
                iIndexOf2 = sb.length();
            }
            if (iIndexOf2 != 0) {
                int iLastIndexOf = sb.toString().lastIndexOf(58);
                if (iLastIndexOf < 0) {
                    iLastIndexOf = iIndexOf2;
                } else {
                    if (iLastIndexOf > iIndexOf2) {
                        throw new java.lang.IllegalArgumentException("url format error - port");
                    }
                    strArr[2] = sb.toString().substring(iLastIndexOf + 1, iIndexOf2);
                }
                strArr[1] = sb.toString().substring(0, iLastIndexOf);
                sb.delete(0, iIndexOf2);
            }
        }
        if (sb.length() > 0) {
            java.lang.String string = sb.toString();
            int iLastIndexOf2 = string.lastIndexOf(47);
            if (iLastIndexOf2 > 0) {
                strArr[3] = string.substring(0, iLastIndexOf2);
            } else if (iLastIndexOf2 == 0) {
                if (string.indexOf(63) > 0) {
                    throw new java.lang.IllegalArgumentException("url format error - path");
                }
                strArr[3] = string;
                return strArr;
            }
            if (iLastIndexOf2 < string.length() - 1) {
                java.lang.String strSubstring = string.substring(iLastIndexOf2 + 1);
                int iIndexOf3 = strSubstring.indexOf(63);
                if (iIndexOf3 >= 0) {
                    strArr[4] = strSubstring.substring(0, iIndexOf3);
                    strArr[5] = strSubstring.substring(iIndexOf3 + 1);
                } else {
                    strArr[4] = strSubstring;
                }
            }
        } else {
            strArr[3] = "/";
        }
        return strArr;
    }

    public static int b(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
        return 2;
    }

    public static int b(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
    }

    private static void b(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        a(new com.igexin.c.a.b.a(inputStream), outputStream);
    }

    public static byte[] b(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    public static byte[] b(byte[] bArr) {
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        byte[] byteArray = null;
        try {
            gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
        while (true) {
            try {
                int i2 = gZIPInputStream.read();
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(i2);
            } catch (java.lang.Throwable th3) {
                th = th3;
                try {
                    com.igexin.c.a.c.a.a(th);
                } finally {
                    a(byteArrayOutputStream);
                    a(gZIPInputStream);
                    a(byteArrayInputStream);
                }
            }
            return byteArray;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        return byteArray;
    }

    private static int c(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        return 1;
    }

    public static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static byte[] c(byte[] bArr) throws java.lang.RuntimeException {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            com.igexin.c.a.b.b bVar = new com.igexin.c.a.b.b(byteArrayOutputStream, 0);
            a(byteArrayInputStream, bVar);
            bVar.a();
            a(byteArrayInputStream);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
        }
    }

    public static long d(byte[] bArr, int i2) {
        return (((long) bArr[i2 + 7]) & 255) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i2 + 1]) & 255) << 48) | ((((long) bArr[i2 + 2]) & 255) << 40) | ((((long) bArr[i2 + 3]) & 255) << 32) | ((((long) bArr[i2 + 4]) & 255) << 24) | ((((long) bArr[i2 + 5]) & 255) << 16) | ((((long) bArr[i2 + 6]) & 255) << 8);
    }

    private static byte[] d(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.util.zip.GZIPInputStream gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i2 = gZIPInputStream.read(bArr2);
            if (i2 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, i2);
        }
    }

    private static int e(byte[] bArr, int i2) {
        return bArr[i2] & 255;
    }

    private static byte[] e(byte[] bArr) throws java.lang.RuntimeException {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            a(new com.igexin.c.a.b.a(byteArrayInputStream), byteArrayOutputStream);
            a(byteArrayInputStream);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
        }
    }
}
