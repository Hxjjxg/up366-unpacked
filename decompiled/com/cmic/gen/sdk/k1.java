package com.cmic.gen.sdk;

/* JADX INFO: compiled from: ThreadUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class k1 {
    private static final java.util.concurrent.ExecutorService a = new java.util.concurrent.ThreadPoolExecutor(0, 30, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue());

    public static void a(com.cmic.gen.sdk.k1.a aVar) {
        try {
            a.execute(aVar);
        } catch (java.lang.Exception e) {
            aVar.a.uncaughtException(java.lang.Thread.currentThread(), e);
        }
    }

    /* JADX INFO: compiled from: ThreadUtils.java */
    public static abstract class a implements java.lang.Runnable {
        private final java.lang.Thread.UncaughtExceptionHandler a;

        /* JADX INFO: renamed from: com.cmic.gen.sdk.k1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ThreadUtils.java */
        class C0007a implements java.lang.Thread.UncaughtExceptionHandler {
            C0007a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX INFO: compiled from: ThreadUtils.java */
        class b implements java.lang.Thread.UncaughtExceptionHandler {
            final /* synthetic */ com.cmic.gen.sdk.i a;
            final /* synthetic */ android.content.Context b;

            b(com.cmic.gen.sdk.i iVar, android.content.Context context) {
                this.a = iVar;
                this.b = context;
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                this.a.a().A.add(th);
                com.cmic.gen.sdk.auth.b.getInstance(this.b).callBackResult("200025", "发生未知错误", this.a, null);
            }
        }

        protected a() {
            this.a = new com.cmic.gen.sdk.k1.a.C0007a();
        }

        protected abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Thread.currentThread().setUncaughtExceptionHandler(this.a);
            a();
            java.lang.Thread.currentThread().setUncaughtExceptionHandler(null);
        }

        protected a(android.content.Context context, com.cmic.gen.sdk.i iVar) {
            this.a = new com.cmic.gen.sdk.k1.a.b(iVar, context);
        }
    }
}
