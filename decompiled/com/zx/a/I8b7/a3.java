package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class a3 extends com.zx.a.I8b7.g1 {
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedList<com.zx.sdk.api.ZXIDListener>> a = new java.util.concurrent.ConcurrentHashMap<>();

    @Override // com.zx.a.I8b7.g1
    public void a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int i = jSONObject.getInt("code");
            java.lang.String strOptString = jSONObject.optString("message");
            for (java.lang.String str2 : this.a.keySet()) {
                for (com.zx.sdk.api.ZXIDListener zXIDListener : this.a.get(str2)) {
                    if (i == 0) {
                        zXIDListener.onSuccess(a(str2, jSONObject.getString("data")));
                    } else {
                        com.zx.a.I8b7.f0 f0Var = com.zx.a.I8b7.f0.b.a;
                        f0Var.getClass();
                        try {
                            f0Var.a(new com.zx.a.I8b7.g0(f0Var, i, strOptString));
                        } catch (java.lang.Throwable th) {
                            com.zx.a.I8b7.c3.a(th);
                        }
                        zXIDListener.onFailed(i, strOptString);
                    }
                }
                this.a.remove(str2);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
