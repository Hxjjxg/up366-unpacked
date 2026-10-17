package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CopyFileUtil {
    public static boolean copyFile(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        java.io.File file2 = new java.io.File(str2);
        if (file2.exists()) {
            if (z) {
                new java.io.File(str2).delete();
            }
        } else if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return false;
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i != -1) {
                            fileOutputStream.write(bArr, 0, i);
                        } else {
                            com.up366.mobile.common.utils.IOUtils.close(fileInputStream2);
                            com.up366.mobile.common.utils.IOUtils.close(fileOutputStream);
                            return true;
                        }
                    }
                } catch (java.io.IOException unused) {
                    fileInputStream = fileInputStream2;
                    com.up366.mobile.common.utils.IOUtils.close(fileInputStream);
                    com.up366.mobile.common.utils.IOUtils.close(fileOutputStream);
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.up366.mobile.common.utils.IOUtils.close(fileInputStream);
                    com.up366.mobile.common.utils.IOUtils.close(fileOutputStream);
                    throw th;
                }
            } catch (java.io.IOException unused2) {
                fileOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (java.io.IOException unused3) {
            fileOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static boolean copyDirectory(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Throwable {
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        if (!str2.endsWith(java.io.File.separator)) {
            str2 = str2 + java.io.File.separator;
        }
        java.io.File file2 = new java.io.File(str2);
        if (file2.exists()) {
            if (!z) {
                return false;
            }
            new java.io.File(str2).delete();
        } else if (!file2.mkdirs()) {
            return false;
        }
        boolean zCopyDirectory = true;
        for (java.io.File file3 : file.listFiles()) {
            if (file3.isFile()) {
                zCopyDirectory = copyFile(file3.getAbsolutePath(), str2 + file3.getName(), z);
                if (!zCopyDirectory) {
                    break;
                }
            } else {
                if (file3.isDirectory()) {
                    zCopyDirectory = copyDirectory(file3.getAbsolutePath(), str2 + file3.getName(), z);
                    if (!zCopyDirectory) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return zCopyDirectory;
    }
}
