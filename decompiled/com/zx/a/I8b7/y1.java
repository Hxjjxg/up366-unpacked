package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class y1 {
    public java.net.URL a;
    public java.lang.String b;
    public java.util.Map<java.lang.String, java.lang.String> c;
    public com.zx.a.I8b7.a2 d;
    public java.lang.String e;

    public y1(com.zx.a.I8b7.y1.a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        java.util.HashMap map = new java.util.HashMap();
        this.c = map;
        map.putAll(aVar.c);
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public static class a {
        public java.net.URL a;
        public java.lang.String b;
        public java.util.Map<java.lang.String, java.lang.String> c;
        public com.zx.a.I8b7.a2 d;
        public java.lang.String e;

        public a() {
            this.b = "GET";
            this.c = new java.util.HashMap();
            this.e = "";
        }

        public com.zx.a.I8b7.y1.a a(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            try {
                this.a = new java.net.URL(str);
                return this;
            } catch (java.net.MalformedURLException e) {
                throw new java.lang.IllegalArgumentException(e);
            }
        }

        public a(com.zx.a.I8b7.y1 y1Var) {
            this.a = y1Var.a;
            this.b = y1Var.b;
            this.d = y1Var.d;
            this.c = y1Var.c;
            this.e = y1Var.e;
        }
    }
}
