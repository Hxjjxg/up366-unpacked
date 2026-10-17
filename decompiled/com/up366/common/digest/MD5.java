package com.up366.common.digest;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MD5 {
    private static final long _1024_LIMIT = 1048576;
    private static final long _256_LIMIT = 262144;
    private static final long _512_LIMIT = 524288;
    private static final long _NO_LIMIT_SIZE = 83886080;
    private static final long _PER_256_LIMIT_SIZE = 268435456;
    private static final long _PER_512_LIMIT_SIZE = 536870912;

    private static java.lang.String md5(java.lang.String str, java.lang.String str2) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(str2);
            messageDigest.update(bytes, 0, bytes.length);
            return com.up366.common.digest.Hex.bytesToHexString(messageDigest.digest());
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e);
            return null;
        }
    }

    public static byte[] md5(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr, 0, bArr.length);
            return messageDigest.digest();
        } catch (java.security.NoSuchAlgorithmException e) {
            com.up366.common.log.Logger.error(e);
            return null;
        }
    }

    public static java.lang.String md5(java.lang.String str) {
        return md5(str, "UTF-8");
    }

    public static java.lang.String md5(java.io.File file) {
        return MD5DigestFile(file, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003c -> B:46:0x0087). Please report as a decompilation issue!!! */
    private static java.lang.String MD5DigestFile(java.io.File file, long j) throws java.lang.Throwable {
        java.security.MessageDigest messageDigest;
        java.io.FileInputStream fileInputStream;
        int i;
        byte[] bArr;
        java.lang.String strBytesToHexString = "";
        ?? r1 = 0;
        java.io.FileInputStream fileInputStream2 = null;
        java.io.FileInputStream fileInputStream3 = null;
        r1 = 0;
        try {
            try {
                try {
                    messageDigest = java.security.MessageDigest.getInstance("MD5");
                    fileInputStream = new java.io.FileInputStream(file);
                    i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                    bArr = new byte[(int) (i > 0 ? j : 2048L)];
                } catch (java.io.IOException e) {
                    e = e;
                    fileInputStream2 = fileInputStream;
                    com.up366.common.log.Logger.error("md5 file " + file.getAbsolutePath() + " failed:" + e.getMessage());
                    r1 = fileInputStream2;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                        r1 = fileInputStream2;
                    }
                } catch (java.security.NoSuchAlgorithmException e2) {
                    e = e2;
                    fileInputStream3 = fileInputStream;
                    com.up366.common.log.Logger.error(e.getMessage());
                    r1 = fileInputStream3;
                    if (fileInputStream3 != null) {
                        fileInputStream3.close();
                        r1 = fileInputStream3;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    r1 = fileInputStream;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (java.io.IOException e3) {
                            com.up366.common.log.Logger.error(e3.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException e4) {
                e = e4;
            } catch (java.security.NoSuchAlgorithmException e5) {
                e = e5;
            }
        } catch (java.io.IOException e6) {
            com.up366.common.log.Logger.error(e6.getMessage());
            r1 = r1;
        }
        while (true) {
            int i2 = fileInputStream.read(bArr);
            if (i2 == -1) {
                break;
            }
            messageDigest.update(bArr, 0, i2);
            if (i > 0) {
                fileInputStream.skip(j);
            }
            return strBytesToHexString;
        }
        strBytesToHexString = com.up366.common.digest.Hex.bytesToHexString(messageDigest.digest());
        messageDigest.reset();
        fileInputStream.close();
        r1 = i;
        return strBytesToHexString;
    }

    public static java.lang.String MD5DigestFileToFileMgr(java.io.File file) {
        if (!com.up366.common.FileUtilsUp.isFileExists(file)) {
            return null;
        }
        long length = file.length();
        return MD5DigestFile(file, length < _NO_LIMIT_SIZE ? 0L : length < _PER_256_LIMIT_SIZE ? _256_LIMIT : length < _PER_512_LIMIT_SIZE ? _512_LIMIT : 1048576L);
    }
}
