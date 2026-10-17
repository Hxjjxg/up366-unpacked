package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class y extends java.util.TimerTask {
    public final /* synthetic */ com.unicom.online.account.kernel.ab b;

    public y(com.unicom.online.account.kernel.ab abVar) {
        this.b = abVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.b.b(false, (android.net.Network) null);
    }
}
