package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class b3 extends com.zx.a.I8b7.g1 {
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedList<com.zx.sdk.api.ZXIDChangedListener>> a = new java.util.concurrent.ConcurrentHashMap<>();

    @Override // com.zx.a.I8b7.g1
    public void a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int i = jSONObject.getInt("code");
            for (java.lang.String str2 : this.a.keySet()) {
                for (com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener : this.a.get(str2)) {
                    if (i == 0) {
                        zXIDChangedListener.onChange(a(str2, jSONObject.getString("data")));
                    }
                }
                this.a.remove(str2);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
