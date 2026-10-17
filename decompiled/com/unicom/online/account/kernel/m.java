package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class m implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ android.net.Network d;
    public final /* synthetic */ java.lang.String e;
    public final /* synthetic */ com.unicom.online.account.kernel.q f;

    public m(com.unicom.online.account.kernel.q qVar, android.content.Context context, java.lang.String str, int i, android.net.Network network, java.lang.String str2) {
        this.f = qVar;
        this.b = str;
        this.c = i;
        this.d = network;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.util.concurrent.CountDownLatch countDownLatch;
        try {
            try {
                com.unicom.online.account.kernel.q qVar = this.f;
                java.lang.String str = this.b;
                int i = this.c;
                android.net.Network network = this.d;
                qVar.getClass();
                com.unicom.online.account.kernel.p pVarB = com.unicom.online.account.kernel.q.b(str, i, network);
                if (pVarB != null) {
                    this.f.c.put(this.e, pVarB);
                    this.f.d.put(this.e, com.unicom.online.account.kernel.o.CONNECTED);
                } else {
                    this.f.d.put(this.e, com.unicom.online.account.kernel.o.FAILED);
                    com.unicom.online.account.kernel.ao.v = "域名 " + this.b + " 端口 " + this.c + " 预连接失败";
                }
                countDownLatch = (java.util.concurrent.CountDownLatch) this.f.e.get(this.e);
                if (countDownLatch == null) {
                    return;
                }
            } catch (java.lang.Exception e) {
                this.f.d.put(this.e, com.unicom.online.account.kernel.o.FAILED);
                e.getMessage();
                com.unicom.online.account.kernel.ao.v = "域名 " + this.b + " 端口 " + this.c + " 预连接异常: " + e.getMessage();
                com.unicom.online.account.kernel.as.b(e);
                countDownLatch = (java.util.concurrent.CountDownLatch) this.f.e.get(this.e);
                if (countDownLatch == null) {
                    return;
                }
            }
            countDownLatch.countDown();
        } catch (java.lang.Throwable th) {
            java.util.concurrent.CountDownLatch countDownLatch2 = (java.util.concurrent.CountDownLatch) this.f.e.get(this.e);
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            throw th;
        }
    }
}
