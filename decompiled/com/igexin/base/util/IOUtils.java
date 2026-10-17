package com.igexin.base.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class IOUtils {
    public static void close(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}
