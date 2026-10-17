package com.cmic.gen.sdk;

/* JADX INFO: compiled from: OAIDFactory.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class n0 {
    private final android.content.Context a;
    private final com.cmic.gen.sdk.o0 b = b();

    public n0(android.content.Context context) {
        this.a = context;
    }

    private com.cmic.gen.sdk.o0 b() {
        if (this.a == null) {
            return null;
        }
        if (com.cmic.gen.sdk.p0.a()) {
            return new com.cmic.gen.sdk.c(this.a);
        }
        if (com.cmic.gen.sdk.p0.f() || com.cmic.gen.sdk.p0.d()) {
            return new com.cmic.gen.sdk.z(this.a);
        }
        if (com.cmic.gen.sdk.p0.e()) {
            return new com.cmic.gen.sdk.u(this.a);
        }
        if (com.cmic.gen.sdk.p0.g() || com.cmic.gen.sdk.p0.j()) {
            return new com.cmic.gen.sdk.d0(this.a);
        }
        if (com.cmic.gen.sdk.p0.h()) {
            return new com.cmic.gen.sdk.k0(this.a);
        }
        if (com.cmic.gen.sdk.p0.k()) {
            return new com.cmic.gen.sdk.m0(this.a);
        }
        if (com.cmic.gen.sdk.p0.m() || com.cmic.gen.sdk.p0.l()) {
            return new com.cmic.gen.sdk.q0(this.a);
        }
        if (com.cmic.gen.sdk.p0.n()) {
            return new com.cmic.gen.sdk.d1(this.a);
        }
        if (com.cmic.gen.sdk.p0.o()) {
            return new com.cmic.gen.sdk.y1(this.a);
        }
        if (com.cmic.gen.sdk.p0.p() || com.cmic.gen.sdk.p0.i() || com.cmic.gen.sdk.p0.b()) {
            return new com.cmic.gen.sdk.b2(this.a);
        }
        if (com.cmic.gen.sdk.p0.q()) {
            return new com.cmic.gen.sdk.c2(this.a);
        }
        if (com.cmic.gen.sdk.p0.a(this.a)) {
            return new com.cmic.gen.sdk.m(this.a);
        }
        if (com.cmic.gen.sdk.p0.c()) {
            return new com.cmic.gen.sdk.n(this.a);
        }
        return null;
    }

    public java.lang.String a() {
        com.cmic.gen.sdk.o0 o0Var = this.b;
        return o0Var == null ? "" : o0Var.b();
    }
}
