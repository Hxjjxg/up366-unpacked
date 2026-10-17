package com.cmic.gen.sdk;

/* JADX INFO: compiled from: LogBeanEx.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class f0 extends com.cmic.gen.sdk.e0 {
    public static java.util.ArrayList<java.lang.Throwable> D = new java.util.ArrayList<>();
    private org.json.JSONObject B = null;
    private org.json.JSONArray C;

    public void a(org.json.JSONObject jSONObject) {
        this.B = jSONObject;
    }

    @Override // com.cmic.gen.sdk.e0, com.cmic.gen.sdk.y0
    public org.json.JSONObject b() {
        org.json.JSONObject jSONObjectB = super.b();
        try {
            jSONObjectB.put("event", this.B);
            jSONObjectB.put("exceptionStackTrace", this.C);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObjectB;
    }

    @Override // com.cmic.gen.sdk.e0
    public void a(org.json.JSONArray jSONArray) {
        this.C = jSONArray;
    }
}
