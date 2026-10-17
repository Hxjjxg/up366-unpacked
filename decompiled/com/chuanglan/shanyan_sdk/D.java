package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class D {
    private static java.util.concurrent.ScheduledExecutorService a = new java.util.concurrent.ScheduledThreadPoolExecutor(1);

    class a implements java.lang.Runnable {
        final /* synthetic */ com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks a;
        final /* synthetic */ long b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;

        a(com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks loginAuthCallbacks, long j, java.lang.String str, long j2, long j3, long j4) {
            this.a = loginAuthCallbacks;
            this.b = j;
            this.c = str;
            this.d = j2;
            this.e = j3;
            this.f = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks loginAuthCallbacks = this.a;
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.TIME_OUT_CODE;
            loginAuthCallbacks.getTokenFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + this.b, this.c, this.d, this.e, this.f);
        }
    }

    public static void a(java.lang.String str, long j, com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks loginAuthCallbacks, long j2, long j3, long j4) {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = a;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            a = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
        }
        a.schedule(new com.chuanglan.shanyan_sdk.D.a(loginAuthCallbacks, j, str, j2, j3, j4), j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public static synchronized void a() {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
