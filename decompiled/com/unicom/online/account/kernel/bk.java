package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class bk implements com.unicom.online.account.shield.ResultListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ com.unicom.online.account.shield.ResultListener c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ com.unicom.online.account.shield.UniAccountHelper f;

    public bk(com.unicom.online.account.shield.UniAccountHelper uniAccountHelper, int i, int i2, int i3, com.unicom.online.account.shield.ResultListener resultListener) {
        this.f = uniAccountHelper;
        this.b = i;
        this.c = resultListener;
        this.d = i2;
        this.e = i3;
    }

    @Override // com.unicom.online.account.shield.ResultListener
    public final void onResult(java.lang.String str) {
        try {
            int i = com.unicom.online.account.kernel.l.d;
            if (i > 5) {
                com.unicom.online.account.kernel.l.d = 4;
            } else if (i >= 1) {
                com.unicom.online.account.kernel.l.d = i - 1;
            } else {
                com.unicom.online.account.kernel.l.d = 0;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            jSONObject.optString("seq");
            int i2 = jSONObject.getInt("resultCode");
            jSONObject.put("type", this.b);
            if (i2 == 100) {
                com.unicom.online.account.kernel.l.b();
                this.c.onResult(str);
                return;
            }
            int i3 = com.unicom.online.account.kernel.l.d;
            if (i3 == 0) {
                com.unicom.online.account.kernel.l.b();
                this.c.onResult(str);
            } else if (i3 > 0) {
                try {
                    java.lang.Thread.sleep(200L);
                    this.f.cuGetTokenUaidLoopCommon(this.d, this.b, this.e, this.c);
                } catch (java.lang.InterruptedException unused) {
                    java.lang.Thread.currentThread().interrupt();
                }
            }
        } catch (org.json.JSONException e) {
            com.unicom.online.account.kernel.l.b();
            if (com.unicom.online.account.kernel.ar.b) {
                e.printStackTrace();
            }
        }
    }
}
