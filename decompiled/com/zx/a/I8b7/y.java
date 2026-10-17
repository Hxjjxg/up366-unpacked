package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class y {
    public static boolean a;

    public static void a(java.lang.String str) {
        if (a) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("--- ");
            sbA.append(str == null ? com.igexin.push.core.b.m : str);
            sbA.append(" ---");
            android.util.Log.d("zx-DebugMode", sbA.toString());
        }
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        com.zx.a.I8b7.c3.a(str);
    }

    public static void b(java.lang.String str) {
        if (a) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("--- ");
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sbA.append(str);
            sbA.append(" ---");
            android.util.Log.e("zx-DebugMode", sbA.toString());
        }
    }
}
