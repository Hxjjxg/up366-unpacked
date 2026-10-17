package com.igexin.base.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class InvokeUtil {
    private static android.content.Context appContext;

    public static android.content.Context findAppContext() {
        android.content.Context context = appContext;
        if (context != null) {
            return context;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            android.content.Context context2 = (android.content.Context) cls.getMethod("getApplication", null).invoke(cls.getDeclaredMethod("currentActivityThread", null).invoke(null, null), null);
            appContext = context2;
            return context2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
