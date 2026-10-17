package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class l0 {
    public static java.lang.String a(android.content.Context context) {
        java.lang.String strB = b();
        if (!android.text.TextUtils.isEmpty(strB)) {
            return strB;
        }
        java.lang.String strA = a();
        return !android.text.TextUtils.isEmpty(strA) ? strA : b(context);
    }

    public static java.lang.String b() {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m();
        }
        return null;
    }

    public static boolean c(android.content.Context context) {
        java.lang.String strA = a(context);
        if (context == null || strA == null) {
            return true;
        }
        return context.getPackageName().equals(strA);
    }

    public static java.lang.String b(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return a(android.os.Process.myPid());
    }

    public static java.lang.String a() {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread", false, android.app.Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            java.lang.Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof java.lang.String) {
                return (java.lang.String) objInvoke;
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(int i) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/" + i + "/cmdline"));
            try {
                java.lang.String strTrim = bufferedReader.readLine().replace((char) 0, ' ').trim();
                bufferedReader.close();
                return strTrim;
            } finally {
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
