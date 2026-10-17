package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class d0 implements java.util.concurrent.ThreadFactory {
    public java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

    public class a implements java.lang.Thread.UncaughtExceptionHandler {
        public a(com.zx.a.I8b7.d0 d0Var) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        }
    }

    public d0(com.zx.a.I8b7.e0 e0Var) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable);
        java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXHttpClient dispatcher's thread");
        sbA.append(this.a.getAndIncrement());
        thread.setName(sbA.toString());
        thread.setUncaughtExceptionHandler(new com.zx.a.I8b7.d0.a(this));
        return thread;
    }
}
