package com.igexin.push;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SdkSource extends com.getui.gtc.dim.DimSource {
    public static final com.igexin.push.SdkSource INSTANCE = new com.igexin.push.SdkSource();
    private static boolean a = false;

    private SdkSource() {
    }

    public static void setLogEnable(boolean z) {
        a = z;
    }

    public <P, V> V get(P p, com.getui.gtc.dim.DimCallback<P, V> dimCallback) {
        com.igexin.c.a.c.a.b("SdkSource", "dim sys call from push");
        if (dimCallback != null) {
            return (V) dimCallback.get(p);
        }
        return null;
    }

    public int getFlags() {
        return 1;
    }

    public <T> T invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object... objArr) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        if (a) {
            try {
                java.lang.Throwable th = new java.lang.Throwable("Push DimSource invoke");
                com.igexin.c.a.c.a.b("SdkSource", "dim sys invoke from Push: " + method + ", exception: " + th + ", stack trace: " + android.util.Log.getStackTraceString(th));
            } catch (java.lang.Throwable th2) {
                com.igexin.c.a.c.a.b("SdkSource", th2.toString());
            }
        }
        return (T) method.invoke(obj, objArr);
    }
}
