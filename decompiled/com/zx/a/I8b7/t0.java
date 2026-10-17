package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class t0 {
    public static void a(java.io.File file) {
        for (java.io.File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(new java.io.File(file2.getPath()));
            } else {
                file2.delete();
            }
        }
        if (file.listFiles().length <= 0) {
            file.delete();
        }
    }
}
