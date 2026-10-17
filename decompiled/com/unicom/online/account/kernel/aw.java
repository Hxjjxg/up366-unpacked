package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class aw implements com.unicom.online.account.kernel.z {
    public final /* synthetic */ java.lang.Object[] b;
    public final /* synthetic */ java.util.concurrent.CountDownLatch c;

    public aw(java.lang.Object[] objArr, java.util.concurrent.CountDownLatch countDownLatch) {
        this.b = objArr;
        this.c = countDownLatch;
    }

    @Override // com.unicom.online.account.kernel.z
    public final void b(java.lang.Object obj, boolean z) {
        if (z && obj != null) {
            this.b[0] = obj;
        }
        this.c.countDown();
    }
}
