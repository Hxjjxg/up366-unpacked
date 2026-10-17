package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CopyUtils {
    public static boolean copySandFileToExternalUri(android.content.Context context, java.lang.String str, android.net.Uri uri) {
        java.io.FileInputStream fileInputStream;
        java.io.Closeable closeable = null;
        try {
            java.io.OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uri);
            try {
                java.io.File file = new java.io.File(str);
                if (file.exists()) {
                    fileInputStream = new java.io.FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            outputStreamOpenOutputStream.write(bArr, 0, i);
                            outputStreamOpenOutputStream.flush();
                        }
                        closeable = fileInputStream;
                    } catch (java.lang.Exception e) {
                        e = e;
                        closeable = outputStreamOpenOutputStream;
                        try {
                            com.up366.common.log.Logger.error("copy SandFile To ExternalUri. e = " + e.toString());
                        } catch (java.lang.Throwable unused) {
                        }
                        com.up366.common.IOUtils.close(closeable);
                        com.up366.common.IOUtils.close(fileInputStream);
                        return false;
                    } catch (java.lang.Throwable unused2) {
                        closeable = outputStreamOpenOutputStream;
                        com.up366.common.IOUtils.close(closeable);
                        com.up366.common.IOUtils.close(fileInputStream);
                        return false;
                    }
                }
                com.up366.common.IOUtils.close(outputStreamOpenOutputStream);
                com.up366.common.IOUtils.close(closeable);
                return true;
            } catch (java.lang.Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (java.lang.Throwable unused3) {
                fileInputStream = null;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (java.lang.Throwable unused4) {
            fileInputStream = null;
        }
    }
}
