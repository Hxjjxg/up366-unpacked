package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class i3 {
    public static final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    public class a implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context a;

        public a(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.zx.a.I8b7.x3.b(this.a);
                try {
                    com.zx.a.I8b7.i3.a().a();
                } catch (java.lang.Throwable unused) {
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXCore init failed: "));
                com.zx.a.I8b7.i3.a.set(false);
            }
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.i3 a = new com.zx.a.I8b7.i3();
    }

    public static com.zx.a.I8b7.s3 a() {
        android.os.Handler handler = com.zx.a.I8b7.v3.a;
        com.zx.a.I8b7.v3 v3Var = com.zx.a.I8b7.v3.a.a;
        if (v3Var.b()) {
            throw new java.lang.RuntimeException("请先调用 ZXManager.checkPermission() 检查用户是否已授权");
        }
        if (!v3Var.a()) {
            throw new java.lang.RuntimeException("用户未授权");
        }
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = com.zx.a.I8b7.s3.e;
        return com.zx.a.I8b7.s3.e.a;
    }

    public static final com.zx.a.I8b7.i3 b() {
        if (a.get()) {
            return com.zx.a.I8b7.i3.b.a;
        }
        throw new java.lang.IllegalStateException("ZXManager not init, should init firstly");
    }

    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable;

    public static void a(android.content.Context context) {
        try {
            if (a.getAndSet(true)) {
                return;
            }
            com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.i3.a(context));
        } catch (java.lang.Throwable th) {
            a.set(false);
            com.zx.a.I8b7.y.b("ZXManager.init failed:" + th);
        }
    }
}
