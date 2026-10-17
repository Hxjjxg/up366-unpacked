package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class k2 {
    public static int a = Integer.MIN_VALUE;
    public static java.lang.Object b;
    public static java.lang.reflect.Method c;
    public static java.lang.reflect.Method d;

    public class a implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                com.zx.a.I8b7.c3.a("tb2 start!");
                com.zx.a.I8b7.j2.b(com.zx.a.I8b7.k2.a(com.zx.a.I8b7.x3.a));
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
            }
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native int a();

    @com.zx.module.annotation.Java2C.Method2C
    private static native android.content.pm.PackageInfo a(int i, int i2);

    @com.zx.module.annotation.Java2C.Method2C
    private static native android.content.pm.PackageInfo a(java.lang.String str, int i) throws android.content.pm.PackageManager.NameNotFoundException;

    @com.zx.module.annotation.Java2C.Method2C
    private static native android.content.pm.PackageInfo a(java.lang.String str, int i, int i2);

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    private static native android.content.pm.PackageInfo b(java.lang.String str, int i);

    @com.zx.module.annotation.Java2C.Method2C
    public static native void b();
}
