package com.cmic.gen.sdk;

/* JADX INFO: compiled from: BaseScripParameter.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class f extends com.cmic.gen.sdk.y0 {
    protected java.lang.String a = "";
    protected java.lang.String b = "";
    protected java.lang.String c = "";
    protected java.lang.String d = "";
    protected java.lang.String e = "";
    protected java.lang.String f = "";
    protected java.lang.String g = "";
    protected java.lang.String h = "";
    protected java.lang.String i = "";
    protected java.lang.String j = "0";
    protected java.lang.String k = "1.0";
    protected java.lang.String l = "";
    protected java.lang.String m = "";
    protected java.lang.String n = "";
    protected java.lang.String o = "";
    protected java.lang.String p = "";
    protected java.lang.String q = "";
    protected java.lang.String r = "";
    protected java.lang.String s = "";
    protected java.lang.String t = "";
    protected java.lang.String u = "001";
    protected java.lang.String v = "";
    protected java.lang.String w = "";
    protected java.lang.String x = "";
    protected java.lang.String y = "";
    protected java.lang.String z = "";
    protected org.json.JSONObject A = null;
    protected java.lang.String B = "";

    public void a(org.json.JSONObject jSONObject) {
        this.A = jSONObject;
    }

    protected final java.lang.String c(java.lang.String str) {
        return str == null ? "" : str;
    }

    public void d(java.lang.String str) {
        this.c = c(str);
    }

    public void e(java.lang.String str) {
        this.q = c(str);
    }

    public void f(java.lang.String str) {
        this.r = c(str);
    }

    public void g(java.lang.String str) {
        this.j = c(str);
    }

    public void h(java.lang.String str) {
        this.w = str;
    }

    public void i(java.lang.String str) {
        this.k = c(str);
    }

    public void j(java.lang.String str) {
        this.s = c(str);
    }

    public void k(java.lang.String str) {
        this.t = c(str);
    }

    public void l(java.lang.String str) {
        this.g = java.net.URLEncoder.encode(c(str));
    }

    public void m(java.lang.String str) {
        this.h = java.net.URLEncoder.encode(c(str));
    }

    public void n(java.lang.String str) {
        this.i = java.net.URLEncoder.encode(c(str));
    }

    public void o(java.lang.String str) {
        this.m = c(str);
    }

    public void p(java.lang.String str) {
        this.f = c(str);
    }

    public void q(java.lang.String str) {
        this.B = str;
    }

    public void r(java.lang.String str) {
        this.e = c(str);
    }

    public void s(java.lang.String str) {
        this.b = c(str);
    }

    public void t(java.lang.String str) {
        this.p = c(str);
    }

    public void u(java.lang.String str) {
        this.z = str;
    }

    public void v(java.lang.String str) {
        this.x = str;
    }

    public void w(java.lang.String str) {
        this.y = str;
    }

    public void x(java.lang.String str) {
        this.n = c(str);
    }

    public void y(java.lang.String str) {
        this.a = c(str);
    }

    @Override // com.cmic.gen.sdk.y0
    public java.lang.String a() {
        return this.c;
    }
}
