package com.cmic.gen.sdk;

/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class h0 {
    private static final com.cmic.gen.sdk.h0 a = new com.cmic.gen.sdk.h0();
    private static boolean b = false;

    public static void a(boolean z) {
        b = z;
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (b) {
            android.util.Log.e("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        if (b) {
            android.util.Log.i("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (b) {
            android.util.Log.d("CMCC-SDK:" + str, "" + str2);
        }
    }
}
