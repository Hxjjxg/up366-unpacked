package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class g implements com.unicom.online.account.kernel.z {
    public final /* synthetic */ java.util.concurrent.CountDownLatch b;
    public final /* synthetic */ android.content.Context c;
    public final /* synthetic */ int d;
    public final /* synthetic */ com.unicom.online.account.kernel.f e;
    public final /* synthetic */ com.unicom.online.account.kernel.i f;

    public g(com.unicom.online.account.kernel.i iVar, java.util.concurrent.CountDownLatch countDownLatch, long j, android.content.Context context, int i, com.unicom.online.account.kernel.f fVar) {
        this.f = iVar;
        this.b = countDownLatch;
        this.c = context;
        this.d = i;
        this.e = fVar;
    }

    @Override // com.unicom.online.account.kernel.z
    public final void b(java.lang.Object obj, boolean z) {
        this.b.countDown();
        java.lang.System.currentTimeMillis();
        java.lang.Thread.currentThread().getName();
        if (!z) {
            this.e.b(this.d, 410003, "无法切换至数据网络");
        } else {
            com.unicom.online.account.kernel.u.b().getClass();
            this.f.b(this.c, this.d, obj, this.e);
        }
    }
}
