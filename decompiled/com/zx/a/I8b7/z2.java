package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class z2 {
    public final com.zx.a.I8b7.e0 a;
    public final java.util.List<com.zx.a.I8b7.u0> b;
    public final javax.net.ssl.SSLSocketFactory c;
    public final javax.net.ssl.HostnameVerifier d;
    public final boolean e;
    public final int f;
    public final int g;

    public static final class a {
        public javax.net.ssl.SSLSocketFactory c;
        public final java.util.List<com.zx.a.I8b7.u0> b = new java.util.ArrayList();
        public com.zx.a.I8b7.e0 a = new com.zx.a.I8b7.e0();
        public boolean e = true;
        public int f = 7000;
        public int g = 7000;
        public javax.net.ssl.HostnameVerifier d = com.zx.a.I8b7.y2.a;
    }

    public z2(com.zx.a.I8b7.z2.a aVar) {
        this.a = aVar.a;
        java.util.List<com.zx.a.I8b7.u0> listA = com.zx.a.I8b7.m2.a(aVar.b);
        this.b = listA;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        if (listA.contains(null)) {
            throw new java.lang.IllegalStateException("Null interceptor: " + listA);
        }
    }
}
