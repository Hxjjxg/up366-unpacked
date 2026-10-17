package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ZipStringUtils {
    public static java.lang.String gzip(java.lang.String str) throws java.lang.Throwable {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        if (str == null || str.length() == 0) {
            return str;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.util.zip.GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(str.getBytes());
            com.up366.common.IOUtils.close(gZIPOutputStream);
        } catch (java.io.IOException e2) {
            e = e2;
            gZIPOutputStream2 = gZIPOutputStream;
            e.printStackTrace();
            com.up366.common.IOUtils.close(gZIPOutputStream2);
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            com.up366.common.IOUtils.close(gZIPOutputStream2);
            throw th;
        }
        return com.up366.common.digest.Hex.bytesToHexString(byteArrayOutputStream.toByteArray());
    }

    public static byte[] gzip(byte[] bArr) throws java.lang.Throwable {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            gZIPOutputStream.write(bArr);
            com.up366.common.IOUtils.close(gZIPOutputStream);
        } catch (java.io.IOException e2) {
            e = e2;
            gZIPOutputStream2 = gZIPOutputStream;
            e.printStackTrace();
            com.up366.common.IOUtils.close(gZIPOutputStream2);
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            com.up366.common.IOUtils.close(gZIPOutputStream2);
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] gunzip(byte[] bArr) throws java.lang.Exception {
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.lang.Throwable th;
        java.util.zip.GZIPInputStream gZIPInputStream;
        byte[] bArr2;
        byte[] byteArray = null;
        if (bArr == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        } catch (java.io.IOException e) {
            e = e;
            gZIPInputStream = null;
            byteArrayInputStream = null;
        } catch (java.lang.Throwable th2) {
            byteArrayInputStream = null;
            th = th2;
            gZIPInputStream = null;
        }
        try {
            gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
            try {
                try {
                    bArr2 = new byte[1024];
                } catch (java.io.IOException e2) {
                    e = e2;
                    com.up366.common.log.Logger.error(e);
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                com.up366.common.IOUtils.close(gZIPInputStream);
                com.up366.common.IOUtils.close(byteArrayInputStream);
                com.up366.common.IOUtils.close(byteArrayOutputStream);
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            gZIPInputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            com.up366.common.IOUtils.close(gZIPInputStream);
            com.up366.common.IOUtils.close(byteArrayInputStream);
            com.up366.common.IOUtils.close(byteArrayOutputStream);
            throw th;
        }
        while (true) {
            int i = gZIPInputStream.read(bArr2);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr2, 0, i);
            com.up366.common.IOUtils.close(gZIPInputStream);
            com.up366.common.IOUtils.close(byteArrayInputStream);
            com.up366.common.IOUtils.close(byteArrayOutputStream);
            return byteArray;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        com.up366.common.IOUtils.close(gZIPInputStream);
        com.up366.common.IOUtils.close(byteArrayInputStream);
        com.up366.common.IOUtils.close(byteArrayOutputStream);
        return byteArray;
    }

    public static java.lang.String zip(java.lang.String str) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.ZipOutputStream zipOutputStream;
        java.util.zip.ZipOutputStream zipOutputStream2 = null;
        strBytesToHexString = null;
        strBytesToHexString = null;
        zipOutputStream2 = null;
        java.lang.String strBytesToHexString = null;
        if (str == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                zipOutputStream = new java.util.zip.ZipOutputStream(byteArrayOutputStream);
                try {
                    zipOutputStream.putNextEntry(new java.util.zip.ZipEntry("0"));
                    zipOutputStream.write(str.getBytes());
                    zipOutputStream.closeEntry();
                    strBytesToHexString = com.up366.common.digest.Hex.bytesToHexString(byteArrayOutputStream.toByteArray());
                } catch (java.io.IOException unused) {
                } catch (java.lang.Throwable th) {
                    th = th;
                    zipOutputStream2 = zipOutputStream;
                    com.up366.common.IOUtils.close(zipOutputStream2);
                    com.up366.common.IOUtils.close(byteArrayOutputStream);
                    throw th;
                }
            } catch (java.io.IOException unused2) {
                zipOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException unused3) {
            byteArrayOutputStream = null;
            zipOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        com.up366.common.IOUtils.close(zipOutputStream);
        com.up366.common.IOUtils.close(byteArrayOutputStream);
        return strBytesToHexString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static java.lang.String unzip(java.lang.String str) throws java.lang.Exception {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayInputStream byteArrayInputStream;
        ?? zipInputStream;
        java.lang.Throwable th;
        byte[] bArr;
        java.lang.String string = null;
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrHexStringToBytes = com.up366.common.digest.Hex.hexStringToBytes(str);
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                byteArrayInputStream = new java.io.ByteArrayInputStream(bArrHexStringToBytes);
                try {
                    zipInputStream = new java.util.zip.ZipInputStream(byteArrayInputStream);
                } catch (java.io.IOException unused) {
                    zipInputStream = 0;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    zipInputStream = 0;
                }
            } catch (java.io.IOException unused2) {
                zipInputStream = 0;
                byteArrayInputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                byteArrayInputStream = null;
                th = th;
                zipInputStream = byteArrayInputStream;
                com.up366.common.IOUtils.close(zipInputStream);
                com.up366.common.IOUtils.close(byteArrayInputStream);
                com.up366.common.IOUtils.close(byteArrayOutputStream);
                throw th;
            }
            try {
                zipInputStream.getNextEntry();
                bArr = new byte[1024];
            } catch (java.io.IOException unused3) {
            } catch (java.lang.Throwable th4) {
                th = th4;
                com.up366.common.IOUtils.close(zipInputStream);
                com.up366.common.IOUtils.close(byteArrayInputStream);
                com.up366.common.IOUtils.close(byteArrayOutputStream);
                throw th;
            }
        } catch (java.io.IOException unused4) {
            zipInputStream = 0;
            byteArrayOutputStream = null;
            byteArrayInputStream = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            byteArrayInputStream = null;
        }
        while (true) {
            int i = zipInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            com.up366.common.IOUtils.close(zipInputStream);
            com.up366.common.IOUtils.close(byteArrayInputStream);
            com.up366.common.IOUtils.close(byteArrayOutputStream);
            return string;
        }
        string = byteArrayOutputStream.toString();
        com.up366.common.IOUtils.close(zipInputStream);
        com.up366.common.IOUtils.close(byteArrayInputStream);
        com.up366.common.IOUtils.close(byteArrayOutputStream);
        return string;
    }
}
