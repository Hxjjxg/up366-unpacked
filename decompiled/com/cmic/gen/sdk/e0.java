package com.cmic.gen.sdk;

/* JADX INFO: compiled from: LogBean.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class e0 extends com.cmic.gen.sdk.y0 {
    private org.json.JSONArray n;
    private java.lang.String w;
    private java.lang.String x;
    private java.lang.String y;
    private java.lang.String z;
    private java.lang.String a = null;
    private java.lang.String b = null;
    private java.lang.String c = null;
    private java.lang.String d = null;
    private java.lang.String e = null;
    private java.lang.String f = null;
    private java.lang.String g = null;
    private java.lang.String h = null;
    private java.lang.String i = null;
    private java.lang.String j = "";
    private java.lang.String k = null;
    private java.lang.String l = null;
    private java.lang.String m = null;
    private java.lang.String o = null;
    private java.lang.String p = null;
    private java.lang.String q = null;
    private java.lang.String r = null;
    private java.lang.String s = null;
    private java.lang.String t = null;
    private java.lang.String u = null;
    private java.lang.String v = null;
    public java.util.concurrent.CopyOnWriteArrayList<java.lang.Throwable> A = new java.util.concurrent.CopyOnWriteArrayList<>();

    void A(java.lang.String str) {
        this.b = str;
    }

    @Override // com.cmic.gen.sdk.y0
    public java.lang.String a() {
        return null;
    }

    @Override // com.cmic.gen.sdk.y0
    protected java.lang.String a(java.lang.String str) {
        return null;
    }

    void a(org.json.JSONArray jSONArray) {
        this.n = jSONArray;
    }

    @Override // com.cmic.gen.sdk.y0
    public org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("appid", this.a);
            jSONObject.put("traceId", this.b);
            jSONObject.put("appName", this.c);
            jSONObject.put("appVersion", this.d);
            jSONObject.put("sdkVersion", com.cmic.gen.sdk.auth.b.SDK_VERSION);
            jSONObject.put("clientType", "android");
            jSONObject.put("timeOut", this.e);
            jSONObject.put("requestTime", this.f);
            jSONObject.put("responseTime", this.g);
            jSONObject.put("elapsedTime", this.h);
            jSONObject.put("requestType", this.i);
            jSONObject.put("interfaceType", this.j);
            jSONObject.put("interfaceCode", this.k);
            jSONObject.put("interfaceElasped", this.l);
            jSONObject.put("loginType", this.m);
            jSONObject.put("exceptionStackTrace", this.n);
            jSONObject.put("operatorType", this.o);
            jSONObject.put("networkType", this.p);
            jSONObject.put("brand", this.q);
            jSONObject.put("reqDevice", this.r);
            jSONObject.put("reqSystem", this.s);
            jSONObject.put("simCardNum", this.t);
            jSONObject.put("imsiState", this.u);
            jSONObject.put("resultCode", this.v);
            jSONObject.put("AID", this.w);
            jSONObject.put("sysOperType", this.x);
            jSONObject.put("scripType", this.y);
            if (!android.text.TextUtils.isEmpty(this.z)) {
                jSONObject.put("networkTypeByAPI", this.z);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void c(java.lang.String str) {
        this.w = str;
    }

    public void d(java.lang.String str) {
        this.c = str;
    }

    public void e(java.lang.String str) {
        this.d = str;
    }

    public void f(java.lang.String str) {
        this.a = str;
    }

    public void g(java.lang.String str) {
        this.q = str;
    }

    public void h(java.lang.String str) {
        this.h = str;
    }

    public void i(java.lang.String str) {
        this.u = str;
    }

    public void j(java.lang.String str) {
        this.k = str;
    }

    public void k(java.lang.String str) {
        this.l = str;
    }

    public void l(java.lang.String str) {
        this.j = str;
    }

    public void m(java.lang.String str) {
        this.m = str;
    }

    void n(java.lang.String str) {
        this.p = str;
    }

    public void o(java.lang.String str) {
        this.z = str;
    }

    void p(java.lang.String str) {
        this.o = str;
    }

    void q(java.lang.String str) {
        this.r = str;
    }

    void r(java.lang.String str) {
        this.s = str;
    }

    public void s(java.lang.String str) {
        this.f = str;
    }

    public void t(java.lang.String str) {
        this.i = str;
    }

    public void u(java.lang.String str) {
        this.g = str;
    }

    public void v(java.lang.String str) {
        this.v = str;
    }

    public void w(java.lang.String str) {
        this.y = str;
    }

    void x(java.lang.String str) {
        this.t = str;
    }

    public void y(java.lang.String str) {
        this.x = str;
    }

    public void z(java.lang.String str) {
        this.e = str;
    }
}
