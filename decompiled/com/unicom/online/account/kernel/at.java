package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class at {
    public static int b;
    public static int c;

    public static void b(android.content.Context context, java.lang.String str) {
        boolean zCommit;
        if (c >= 20) {
            if (b > 2147483627) {
                com.unicom.online.account.kernel.be.b(context, "OAlog");
                b = 0;
                c = 0;
            } else {
                java.lang.String str2 = "at" + b;
                android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
                editorEdit.remove("OAlog" + str2 + str2);
                editorEdit.commit();
                int i = c;
                if (i >= 1) {
                    c = i - 1;
                } else {
                    c = 0;
                }
                b++;
            }
        }
        int i2 = c;
        if (i2 >= 0) {
            c = i2 + 1;
        } else {
            c = 0;
        }
        java.lang.String str3 = "at" + ((b + c) - 1);
        if (com.unicom.online.account.kernel.bh.c(str).booleanValue()) {
            java.lang.String str4 = "OAlog" + str3 + str3;
            if (com.unicom.online.account.kernel.bh.c(str4).booleanValue()) {
                try {
                    android.content.SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("cuAuthCacheName", 0).edit();
                    editorEdit2.putString(str4, str);
                    zCommit = editorEdit2.commit();
                } catch (java.lang.Exception e) {
                    e.getMessage();
                    zCommit = false;
                }
                if (zCommit) {
                    return;
                }
                int i3 = c;
                if (i3 >= 1) {
                    c = i3 - 1;
                } else {
                    c = 0;
                }
            }
        }
    }
}
