package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class M {
    private static java.util.concurrent.ScheduledExecutorService a = new java.util.concurrent.ScheduledThreadPoolExecutor(1);

    class a implements java.lang.Runnable {
        final /* synthetic */ com.chuanglan.shanyan_sdk.listener.InitCallbacks a;
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;

        a(com.chuanglan.shanyan_sdk.listener.InitCallbacks initCallbacks, long j, int i, long j2, long j3, long j4) {
            this.a = initCallbacks;
            this.b = j;
            this.c = i;
            this.d = j2;
            this.e = j3;
            this.f = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.listener.InitCallbacks initCallbacks = this.a;
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.TIME_OUT_CODE;
            initCallbacks.initFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + this.b, this.c, this.d, this.e, this.f);
        }
    }

    public static void a(long j, com.chuanglan.shanyan_sdk.listener.InitCallbacks initCallbacks, int i, long j2, long j3, long j4) {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = a;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            a = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
        }
        a.schedule(new com.chuanglan.shanyan_sdk.M.a(initCallbacks, j, i, j2, j3, j4), j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public static synchronized void a() {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
