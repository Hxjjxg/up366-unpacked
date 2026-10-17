package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class T {
    private static volatile com.chuanglan.shanyan_sdk.T d;
    private android.content.Context a;
    private java.util.concurrent.ExecutorService b;
    private com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks c;

    class a implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        a(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.k0.b().a(this.a, null, this.b, this.c);
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "open preInfo start ");
        }
    }

    private T() {
    }

    public static com.chuanglan.shanyan_sdk.T a() {
        if (d == null) {
            synchronized (com.chuanglan.shanyan_sdk.T.class) {
                if (d == null) {
                    d = new com.chuanglan.shanyan_sdk.T();
                }
            }
        }
        return d;
    }

    public void a(android.content.Context context, java.util.concurrent.ExecutorService executorService) {
        this.a = context;
        this.b = executorService;
    }

    public void a(int i, long j, long j2) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "openLoginAuthMethod start ");
        this.c = new com.chuanglan.shanyan_sdk.e0(this.a);
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        if (this.a != null && this.b != null) {
            com.chuanglan.shanyan_sdk.T.a aVar = new com.chuanglan.shanyan_sdk.T.a(i, j, j2);
            if (com.chuanglan.shanyan_sdk.AbstractC0055l.U.getAndSet(false)) {
                this.b.execute(aVar);
                return;
            }
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "openLoginAuthMethod is in progress");
            com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks openLoginAuthCallbaks = this.c;
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.AUTHPAGE_LOADING_CODE;
            openLoginAuthCallbaks.openPageFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + "openLoginAuthMethod()", "Unknown_Operator", j, j2, jUptimeMillis);
            return;
        }
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "not initialized ");
        com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks openLoginAuthCallbaks2 = this.c;
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q2 = com.chuanglan.shanyan_sdk.EnumC0060q.NOT_INITIALIZED_CODE;
        openLoginAuthCallbaks2.openPageFailed(enumC0060q2.d(), enumC0060q2.b(), enumC0060q2.e(), enumC0060q2.c() + "openLoginAuthMethod()", "Unknown_Operator", j, j2, jUptimeMillis);
    }

    public void a(long j, long j2, long j3) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "start LoginActivity");
            com.chuanglan.shanyan_sdk.t0.h().m();
            com.chuanglan.shanyan_sdk.AbstractC0044a.a(this.a, j, j2, j3);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.AbstractC0055l.U.set(true);
            com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks openLoginAuthCallbaks = this.c;
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
            openLoginAuthCallbaks.openPageFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + e, "Unknown_Operator", j, j2, j3);
        }
    }
}
