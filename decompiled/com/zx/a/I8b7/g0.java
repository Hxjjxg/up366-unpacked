package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class g0 implements java.lang.Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ com.zx.a.I8b7.f0 c;

    public g0(com.zx.a.I8b7.f0 f0Var, int i, java.lang.String str) {
        this.c = f0Var;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.c.b.length() >= 10) {
                com.zx.a.I8b7.c3.a("error list length > MAX_COUNT " + this.c.b.length());
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", this.a);
            jSONObject.put("msg", this.b);
            this.c.b.put(jSONObject);
            com.zx.a.I8b7.c3.a("error add:" + jSONObject);
            if (com.zx.a.I8b7.x3.I) {
                com.zx.a.I8b7.c3.a("error save:" + this.c.b.toString());
                com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
                com.zx.a.I8b7.h4 h4Var = w2Var.a;
                java.lang.String string = this.c.b.toString();
                h4Var.getClass();
                w2Var.a.a(321, string, true);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
