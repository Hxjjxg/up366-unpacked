package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class bm implements java.lang.Runnable {
    public final /* synthetic */ org.json.JSONObject b;
    public final /* synthetic */ com.unicom.online.account.kernel.bn c;

    public bm(com.unicom.online.account.kernel.bn bnVar, org.json.JSONObject jSONObject) {
        this.c = bnVar;
        this.b = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.e.onResult(this.b.toString());
    }
}
