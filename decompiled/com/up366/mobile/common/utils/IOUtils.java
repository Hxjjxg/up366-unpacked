package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class IOUtils {
    public static void close(java.io.Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("IOUtils close error " + e.getMessage());
        }
    }
}
