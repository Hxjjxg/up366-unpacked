package com.cmic.gen.sdk;

/* JADX INFO: compiled from: GetSdkPageOptionParameter.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class t extends com.cmic.gen.sdk.y0 {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;

    @Override // com.cmic.gen.sdk.y0
    public java.lang.String a() {
        return this.a;
    }

    @Override // com.cmic.gen.sdk.y0
    public org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("sign", this.c);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void c(java.lang.String str) {
        this.a = str;
    }

    public void d(java.lang.String str) {
        this.c = str;
    }

    public void e(java.lang.String str) {
        this.b = str;
    }

    @Override // com.cmic.gen.sdk.y0
    protected java.lang.String a(java.lang.String str) {
        return "";
    }

    public java.lang.String c() {
        return this.b;
    }
}
