package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Mp3HeaderHelper {
    public static int findFirstFramePosition(java.lang.String str) throws java.lang.Throwable {
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            return 0;
        }
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[10];
                if (randomAccessFile2.read(bArr) == 10) {
                    if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
                        randomAccessFile2.seek(((bArr[9] & 255) | ((((((bArr[6] & 255) << 7) | (bArr[7] & 255)) << 7) | (bArr[8] & 255)) << 7)) + 10);
                    } else {
                        randomAccessFile2.seek(0L);
                    }
                    long filePointer = randomAccessFile2.getFilePointer();
                    skipFrame(randomAccessFile2, 1);
                    long filePointer2 = randomAccessFile2.getFilePointer();
                    long j = filePointer2 - filePointer;
                    if (j > 1024) {
                        com.up366.mobile.common.onlinelog.OpLog.report("MP3-findFrame>1024", str);
                        com.up366.mobile.common.utils.IOUtils.close(randomAccessFile2);
                        return 0;
                    }
                    randomAccessFile2.seek(filePointer);
                    byte[] bArr2 = new byte[(int) j];
                    randomAccessFile2.read(bArr2);
                    java.lang.String strTrim = new java.lang.String(bArr2).trim();
                    if (!strTrim.contains("Info") && !strTrim.contains("Xing")) {
                        com.up366.mobile.common.utils.IOUtils.close(randomAccessFile2);
                        return 0;
                    }
                    int i = (int) filePointer2;
                    com.up366.mobile.common.utils.IOUtils.close(randomAccessFile2);
                    return i;
                }
                com.up366.mobile.common.utils.IOUtils.close(randomAccessFile2);
                return 0;
            } catch (java.lang.Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                com.up366.mobile.common.utils.IOUtils.close(randomAccessFile);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static int readBit(byte[] bArr, int i, int i2) {
        int i3 = i / 8;
        int i4 = i % 8;
        int i5 = 0;
        while (i3 < bArr.length) {
            int i6 = bArr[i3];
            while (i4 < 8) {
                i5 = (i5 << 1) | ((i6 >> (7 - i4)) & 1);
                i2--;
                if (i2 == 0) {
                    return i5;
                }
                i4++;
            }
            i3++;
            i4 = 0;
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void skipFrame(java.io.RandomAccessFile r20, int r21) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.Mp3HeaderHelper.skipFrame(java.io.RandomAccessFile, int):void");
    }
}
