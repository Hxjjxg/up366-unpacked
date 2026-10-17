package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class t implements com.zx.a.I8b7.x2.b {
    public final /* synthetic */ java.lang.String a;

    public t(java.lang.String str) {
        this.a = str;
    }

    @Override // com.zx.a.I8b7.x2.b
    public void a(int i, java.lang.String str) {
    }

    @Override // com.zx.a.I8b7.x2.b
    public void a(android.net.Network network) {
        b(network);
    }

    public final void b(android.net.Network network) {
        try {
            org.json.JSONArray jSONArray = new org.json.JSONObject(this.a).getJSONArray("config");
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.zx.a.I8b7.x3.l.put(network != null ? com.zx.a.I8b7.k0.a(network, jSONObject) : com.zx.a.I8b7.l0.a(jSONObject));
            }
            com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
            com.zx.a.I8b7.h4 h4Var = w2Var.a;
            org.json.JSONArray jSONArray2 = com.zx.a.I8b7.x3.l;
            h4Var.getClass();
            if (jSONArray2 == null) {
                return;
            }
            w2Var.a.a(63, jSONArray2.toString(), true);
            com.zx.a.I8b7.c3.a("reqBZ had changed refresh:" + jSONArray2);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th.getMessage());
        }
    }

    @Override // com.zx.a.I8b7.x2.b
    public void a() {
        b(null);
    }
}
