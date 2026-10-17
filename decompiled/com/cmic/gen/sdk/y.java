package com.cmic.gen.sdk;

/* JADX INFO: compiled from: HttpSuccessResponse.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class y {
    private int a;
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> b;
    private java.lang.String c;

    public y(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.lang.String str) {
        this.a = i;
        this.b = map;
        this.c = str;
    }

    public java.lang.String a() {
        java.lang.String str = this.c;
        return str == null ? "" : str;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> b() {
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = this.b;
        return map == null ? new java.util.HashMap() : map;
    }

    public int c() {
        return this.a;
    }

    public boolean d() {
        int i = this.a;
        return i == 302 || i == 301;
    }
}
