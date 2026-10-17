package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class r implements java.lang.Runnable {
    public final /* synthetic */ java.util.ArrayList b;
    public final /* synthetic */ com.unicom.online.account.kernel.s c;

    public r(com.unicom.online.account.kernel.s sVar, java.util.ArrayList arrayList) {
        this.c = sVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.unicom.online.account.kernel.s sVar = this.c;
            sVar.b.b(sVar.e, sVar.d, this.b);
        } catch (java.lang.Exception e) {
            e.getMessage();
            com.unicom.online.account.kernel.as.b(e);
        }
    }
}
