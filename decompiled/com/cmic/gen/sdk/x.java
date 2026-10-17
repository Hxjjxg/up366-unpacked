package com.cmic.gen.sdk;

/* JADX INFO: compiled from: HttpRequest.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class x {
    private final java.lang.String a;
    private final java.util.Map<java.lang.String, java.lang.String> b;
    java.lang.String c;
    private final java.lang.String d;
    private boolean e;
    private final java.lang.String f;
    private android.net.Network g;
    private long h;
    private final java.lang.String i;
    private int j;
    private final com.cmic.gen.sdk.y0 k;

    private x(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, com.cmic.gen.sdk.y0 y0Var, java.lang.String str2, java.lang.String str3) {
        this.e = false;
        this.a = str;
        this.k = y0Var;
        map = map == null ? new java.util.HashMap<>() : map;
        this.b = map;
        this.c = y0Var == null ? "" : y0Var.b().toString();
        this.d = str2;
        this.f = str3;
        this.i = y0Var != null ? y0Var.a() : "";
        map.put("interfaceVersion", "1.0");
        if (y0Var instanceof com.cmic.gen.sdk.t) {
            map.put("timestamp", ((com.cmic.gen.sdk.t) y0Var).c());
        }
        a();
    }

    private void a() {
        this.b.put("sdkVersion", com.cmic.gen.sdk.auth.b.SDK_VERSION);
        this.b.put("Content-Type", "application/json");
        this.b.put("CMCC-EncryptType", "STD");
        this.b.put("traceId", this.f);
        this.b.put("appid", this.i);
        this.b.put("connection", "Keep-Alive");
    }

    public boolean b() {
        int i = this.j;
        this.j = i + 1;
        return i < 2;
    }

    public java.lang.String c() {
        return this.c;
    }

    public java.util.Map<java.lang.String, java.lang.String> d() {
        return this.b;
    }

    public java.lang.String e() {
        return this.d;
    }

    public android.net.Network f() {
        return this.g;
    }

    public com.cmic.gen.sdk.y0 g() {
        return this.k;
    }

    public long h() {
        return this.h;
    }

    public java.lang.String i() {
        return this.f;
    }

    public java.lang.String j() {
        return this.a;
    }

    public boolean k() {
        return this.e;
    }

    public boolean l() {
        return !com.cmic.gen.sdk.r0.d(this.f) || this.a.contains("logReport") || this.a.contains("uniConfig");
    }

    public void a(java.lang.String str, java.lang.String str2) {
        this.b.put(str, str2);
    }

    void a(boolean z) {
        this.e = z;
    }

    public void a(android.net.Network network) {
        this.g = network;
    }

    public void a(long j) {
        this.h = j;
    }

    public x(java.lang.String str, com.cmic.gen.sdk.y0 y0Var, java.lang.String str2, java.lang.String str3) {
        this(str, null, y0Var, str2, str3);
    }
}
