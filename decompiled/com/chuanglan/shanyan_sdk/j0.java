package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class j0 {
    private static java.util.concurrent.ScheduledExecutorService a = new java.util.concurrent.ScheduledThreadPoolExecutor(1);

    class a implements java.lang.Runnable {
        final /* synthetic */ com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks a;
        final /* synthetic */ long b;
        final /* synthetic */ int c;
        final /* synthetic */ android.content.Context d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;

        a(com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks, long j, int i, android.content.Context context, long j2, long j3, long j4) {
            this.a = getPhoneInfoCallbacks;
            this.b = j;
            this.c = i;
            this.d = context;
            this.e = j2;
            this.f = j3;
            this.g = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.a;
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.TIME_OUT_CODE;
            getPhoneInfoCallbacks.getPhoneInfoFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + this.b, this.c, com.chuanglan.shanyan_sdk.C0065v.g().b(this.d), this.e, this.f, this.g);
        }
    }

    public static void a(android.content.Context context, long j, int i, com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks getPhoneInfoCallbacks, long j2, long j3, long j4) {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = a;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            a = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
        }
        a.schedule(new com.chuanglan.shanyan_sdk.j0.a(getPhoneInfoCallbacks, j, i, context, j2, j3, j4), j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public static synchronized void a() {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
