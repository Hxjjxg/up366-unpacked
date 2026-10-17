package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class b2 implements java.io.Closeable {
    public final com.zx.a.I8b7.y1 a;
    public final int b;
    public final java.lang.String c;
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> d;
    public final com.zx.a.I8b7.c2 e;

    public b2(com.zx.a.I8b7.b2.a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = new java.util.HashMap(aVar.d);
        this.e = aVar.e;
    }

    public java.lang.String a(java.lang.String str) {
        java.util.List<java.lang.String> list = this.d.get(str);
        if (list == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("; ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.zx.a.I8b7.c2 c2Var = this.e;
        if (c2Var == null) {
            throw new java.lang.IllegalStateException("response is not eligible for a body and must not be closed");
        }
        c2Var.close();
    }

    public static class a {
        public com.zx.a.I8b7.y1 a;
        public int b;
        public java.lang.String c;
        public java.util.Map<java.lang.String, java.util.List<java.lang.String>> d;
        public com.zx.a.I8b7.c2 e;

        public a() {
            this.b = -1;
            this.d = new java.util.HashMap();
        }

        public com.zx.a.I8b7.b2 a() {
            if (this.a == null) {
                throw new java.lang.IllegalStateException("request == null");
            }
            if (this.b >= 0) {
                if (this.c != null) {
                    return new com.zx.a.I8b7.b2(this);
                }
                throw new java.lang.IllegalStateException("message == null");
            }
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("code < 0: ");
            sbA.append(this.b);
            throw new java.lang.IllegalStateException(sbA.toString());
        }

        public a(com.zx.a.I8b7.b2 b2Var) {
            this.b = -1;
            this.a = b2Var.a;
            this.b = b2Var.b;
            this.c = b2Var.c;
            this.d = new java.util.HashMap(b2Var.d);
            this.e = b2Var.e;
        }
    }
}
