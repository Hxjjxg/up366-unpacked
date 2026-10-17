package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class e implements java.lang.Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ com.unicom.online.account.kernel.i c;

    public e(com.unicom.online.account.kernel.i iVar, int i) {
        this.c = iVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unicom.online.account.kernel.i iVar = this.c;
        int i = this.b;
        synchronized (iVar) {
            com.unicom.online.account.kernel.av avVar = iVar.e;
            if (avVar != null) {
                avVar.b(i, 410000, "请求超时", "", com.unicom.online.account.kernel.bp.c());
                iVar.e = null;
                com.unicom.online.account.kernel.as.b("end:" + java.lang.System.currentTimeMillis() + "", 3);
            }
            iVar.b("超时处理");
        }
    }
}
