package com.cmic.gen.sdk;

/* JADX INFO: compiled from: GetConfigParameter.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class p extends com.cmic.gen.sdk.y0 {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;

    @Override // com.cmic.gen.sdk.y0
    public java.lang.String a() {
        return this.f;
    }

    @Override // com.cmic.gen.sdk.y0
    public org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("version", this.a);
            jSONObject.put("apptype", this.b);
            jSONObject.put("phone_ID", this.c);
            jSONObject.put("certflag", this.d);
            jSONObject.put("sdkversion", this.e);
            jSONObject.put("appid", this.f);
            jSONObject.put("expandparams", "");
            jSONObject.put("sign", this.g);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void c(java.lang.String str) {
        this.f = str;
    }

    public void d(java.lang.String str) {
        this.b = str;
    }

    public void e(java.lang.String str) {
        this.d = str;
    }

    public void f(java.lang.String str) {
        this.c = str;
    }

    public void g(java.lang.String str) {
        this.e = str;
    }

    public void h(java.lang.String str) {
        this.g = str;
    }

    public void i(java.lang.String str) {
        this.a = str;
    }

    @Override // com.cmic.gen.sdk.y0
    protected java.lang.String a(java.lang.String str) {
        return this.a + this.e + this.f + "iYm0HAnkxQtpvN44";
    }
}
