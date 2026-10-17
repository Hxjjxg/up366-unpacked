package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class r1 implements com.zx.a.I8b7.u0.a {
    public final int a;
    public final java.util.List<com.zx.a.I8b7.u0> b;
    public final com.zx.a.I8b7.y1 c;
    public final java.net.HttpURLConnection d;

    public r1(java.util.List<com.zx.a.I8b7.u0> list, java.net.HttpURLConnection httpURLConnection, int i, com.zx.a.I8b7.y1 y1Var) {
        this.b = list;
        this.d = httpURLConnection;
        this.a = i;
        this.c = y1Var;
    }

    public com.zx.a.I8b7.b2 a(com.zx.a.I8b7.y1 y1Var, java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        if (this.a >= this.b.size()) {
            throw new java.lang.AssertionError();
        }
        java.util.List<com.zx.a.I8b7.u0> list = this.b;
        int i = this.a;
        com.zx.a.I8b7.r1 r1Var = new com.zx.a.I8b7.r1(list, httpURLConnection, i + 1, y1Var);
        com.zx.a.I8b7.u0 u0Var = list.get(i);
        com.zx.a.I8b7.b2 b2VarA = u0Var.a(r1Var);
        if (b2VarA == null) {
            throw new java.lang.NullPointerException("interceptor " + u0Var + " returned null");
        }
        if (b2VarA.e != null) {
            return b2VarA;
        }
        throw new java.lang.IllegalStateException("interceptor " + u0Var + " returned a response with no body");
    }
}
