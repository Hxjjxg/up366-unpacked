package com.cmic.gen.sdk;

/* JADX INFO: compiled from: UmcConfigBean.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class s1 implements java.lang.Cloneable {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;

    /* JADX INFO: compiled from: UmcConfigBean.java */
    public static class b {
        private final com.cmic.gen.sdk.s1 a = new com.cmic.gen.sdk.s1();

        com.cmic.gen.sdk.s1.b a(java.lang.String str) {
            this.a.c = str;
            return this;
        }

        com.cmic.gen.sdk.s1.b b(java.lang.String str) {
            this.a.b = str;
            return this;
        }

        com.cmic.gen.sdk.s1.b c(java.lang.String str) {
            this.a.a = str;
            return this;
        }

        com.cmic.gen.sdk.s1.b d(java.lang.String str) {
            this.a.e = str;
            return this;
        }

        com.cmic.gen.sdk.s1.b e(boolean z) {
            this.a.k = z;
            return this;
        }

        com.cmic.gen.sdk.s1.b f(boolean z) {
            this.a.h = z;
            return this;
        }

        com.cmic.gen.sdk.s1.b a(boolean z) {
            this.a.f = z;
            return this;
        }

        com.cmic.gen.sdk.s1.b b(boolean z) {
            this.a.g = z;
            return this;
        }

        com.cmic.gen.sdk.s1.b c(boolean z) {
            this.a.i = z;
            return this;
        }

        com.cmic.gen.sdk.s1.b d(boolean z) {
            this.a.j = z;
            return this;
        }

        com.cmic.gen.sdk.s1.b a(int i) {
            this.a.m = i;
            return this;
        }

        com.cmic.gen.sdk.s1.b b(int i) {
            this.a.l = i;
            return this;
        }

        public com.cmic.gen.sdk.s1 a() {
            return this.a;
        }
    }

    public int g() {
        return this.l;
    }

    public java.lang.String h() {
        return this.d;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.g;
    }

    public boolean k() {
        return this.i;
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.k;
    }

    public boolean n() {
        return this.h;
    }

    private s1() {
        this.a = "rcs.cmpassport.com";
        this.b = "rcs.cmpassport.com";
        this.c = "config2.cmpassport.com";
        this.d = "onekey2.cmpassport.com";
        this.e = "log2.cmpassport.com:9443";
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = 3;
        this.m = 1;
    }

    public java.lang.String e() {
        return this.e;
    }

    public int f() {
        return this.m;
    }

    public java.lang.String c() {
        return this.b;
    }

    public java.lang.String d() {
        return this.a;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.cmic.gen.sdk.s1 clone() throws java.lang.CloneNotSupportedException {
        return (com.cmic.gen.sdk.s1) super.clone();
    }

    public java.lang.String b() {
        return this.c;
    }
}
