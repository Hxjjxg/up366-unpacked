package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class j {
    java.lang.String a;
    java.lang.String b;
    java.io.File c;
    private byte[] d;

    private j(java.io.File file) {
        this.c = file;
    }

    private j(java.lang.String str) {
        this(new java.io.File(str));
    }

    private j(java.lang.String str, byte[] bArr) {
        this.a = str;
        this.d = bArr;
    }

    private j(java.lang.String str, byte[] bArr, java.lang.String str2) {
        this(str, bArr);
        this.b = str2;
    }

    private j(byte[] bArr) {
        this.d = bArr;
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.Object obj = null;
        if (bArr != null && bArr.length >= 10) {
            byte b = bArr[0];
            if (b == 71 && bArr[1] == 73 && bArr[2] == 70) {
                obj = "GIF";
            } else {
                byte b2 = bArr[1];
                if (b2 == 80 && bArr[2] == 78 && bArr[3] == 71) {
                    obj = "PNG";
                } else if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                    obj = "JPG";
                } else if (b == 66 && b2 == 77) {
                    obj = "BMP";
                }
            }
        }
        return "JPG".equals(obj) ? "image/jpeg" : "GIF".equals(obj) ? "image/gif" : "PNG".equals(obj) ? com.up366.medialibrary.common.utils.MimeTypeUtils.PNG_Q : "BMP".equals(obj) ? "image/bmp" : "application/octet-stream";
    }

    private java.lang.String b() {
        java.io.File file;
        if (this.a == null && (file = this.c) != null && file.exists()) {
            this.a = this.c.getName();
        }
        return this.a;
    }

    private static java.lang.String b(byte[] bArr) {
        if (bArr != null && bArr.length >= 10) {
            byte b = bArr[0];
            if (b == 71 && bArr[1] == 73 && bArr[2] == 70) {
                return "GIF";
            }
            byte b2 = bArr[1];
            if (b2 == 80 && bArr[2] == 78 && bArr[3] == 71) {
                return "PNG";
            }
            if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                return "JPG";
            }
            if (b == 66 && b2 == 77) {
                return "BMP";
            }
        }
        return null;
    }

    private java.lang.String c() throws java.lang.Throwable {
        if (this.b == null) {
            byte[] bArrA = a();
            java.lang.Object obj = null;
            if (bArrA != null && bArrA.length >= 10) {
                byte b = bArrA[0];
                if (b == 71 && bArrA[1] == 73 && bArrA[2] == 70) {
                    obj = "GIF";
                } else {
                    byte b2 = bArrA[1];
                    if (b2 == 80 && bArrA[2] == 78 && bArrA[3] == 71) {
                        obj = "PNG";
                    } else if (bArrA[6] == 74 && bArrA[7] == 70 && bArrA[8] == 73 && bArrA[9] == 70) {
                        obj = "JPG";
                    } else if (b == 66 && b2 == 77) {
                        obj = "BMP";
                    }
                }
            }
            this.b = "JPG".equals(obj) ? "image/jpeg" : "GIF".equals(obj) ? "image/gif" : "PNG".equals(obj) ? com.up366.medialibrary.common.utils.MimeTypeUtils.PNG_Q : "BMP".equals(obj) ? "image/bmp" : "application/octet-stream";
        }
        return this.b;
    }

    public final byte[] a() throws java.lang.Throwable {
        java.io.File file;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        if (this.d == null && (file = this.c) != null && file.exists()) {
            try {
                fileInputStream = new java.io.FileInputStream(this.c);
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i = fileInputStream.read();
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(i);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                    this.d = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (java.lang.Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                fileInputStream = null;
            }
        }
        return this.d;
    }
}
