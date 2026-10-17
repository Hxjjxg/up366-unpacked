package com.cmic.gen.sdk;

/* JADX INFO: compiled from: LoginAuthParameter.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class i0 {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;

    public void a(java.lang.String str) {
        this.c = str;
    }

    public void b(java.lang.String str) {
        this.d = str;
    }

    public void c(java.lang.String str) {
        this.a = str;
    }

    public void d(java.lang.String str) {
        this.b = str;
    }

    public void e(java.lang.String str) {
        this.f = str;
    }

    public void f(java.lang.String str) {
        this.k = str;
    }

    public void g(java.lang.String str) {
        this.j = str;
    }

    public void h(java.lang.String str) {
        this.h = str;
    }

    public void i(java.lang.String str) {
        this.i = str;
    }

    public void j(java.lang.String str) {
        this.g = str;
    }

    public void k(java.lang.String str) {
        this.e = str;
    }

    public org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("authPageOut", this.b);
            jSONObject.put("authPageIn", this.a);
            jSONObject.put("authClickSuccess", this.d);
            jSONObject.put("timeOnAuthPage", this.e);
            jSONObject.put("authClickFailed", this.c);
            jSONObject.put("authPrivacyState", this.f);
            jSONObject.put("PrivacyNotSelectedToast", this.g);
            jSONObject.put("PrivacyNotSelectedPopup", this.h);
            jSONObject.put("PrivacyNotSelectedShake", this.i);
            jSONObject.put("PrivacyNotSelectedCustom", this.j);
            jSONObject.put("brandButton", this.k);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
