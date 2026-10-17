package com.cmic.gen.sdk;

/* JADX INFO: compiled from: ConcurrentBundle.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class i {
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> a;

    public i(int i) {
        this.a = new java.util.concurrent.ConcurrentHashMap<>(i);
    }

    public void a(java.lang.String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return;
        }
        this.a.put(str, bArr);
    }

    public void b(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.a.put(str, str2);
    }

    public java.lang.String c(java.lang.String str) {
        return a(str, "");
    }

    public byte[] a(java.lang.String str) {
        if (str != null) {
            return (byte[]) this.a.get(str);
        }
        return null;
    }

    public void b(java.lang.String str, boolean z) {
        if (str != null) {
            this.a.put(str, java.lang.Boolean.valueOf(z));
        }
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        return (str == null || !this.a.containsKey(str)) ? str2 : (java.lang.String) this.a.get(str);
    }

    public void b(java.lang.String str, int i) {
        if (str != null) {
            this.a.put(str, java.lang.Integer.valueOf(i));
        }
    }

    public int b(java.lang.String str) {
        return a(str, 0);
    }

    public boolean a(java.lang.String str, boolean z) {
        return (str == null || !this.a.containsKey(str)) ? z : ((java.lang.Boolean) this.a.get(str)).booleanValue();
    }

    public void b(java.lang.String str, long j) {
        if (str != null) {
            this.a.put(str, java.lang.Long.valueOf(j));
        }
    }

    public com.cmic.gen.sdk.s1 b() {
        com.cmic.gen.sdk.s1 s1Var = (com.cmic.gen.sdk.s1) this.a.get("current_config");
        if (s1Var != null) {
            return s1Var;
        }
        com.cmic.gen.sdk.h0.b("UmcConfigBean为空", "请核查");
        return new com.cmic.gen.sdk.s1.b().a();
    }

    public int a(java.lang.String str, int i) {
        return (str == null || !this.a.containsKey(str)) ? i : ((java.lang.Integer) this.a.get(str)).intValue();
    }

    public long a(java.lang.String str, long j) {
        return (str == null || !this.a.containsKey(str)) ? j : ((java.lang.Long) this.a.get(str)).longValue();
    }

    public void a(com.cmic.gen.sdk.e0 e0Var) {
        if (e0Var != null) {
            this.a.put("logBean", e0Var);
        }
    }

    public com.cmic.gen.sdk.e0 a() {
        com.cmic.gen.sdk.e0 e0Var = (com.cmic.gen.sdk.e0) this.a.get("logBean");
        return e0Var != null ? e0Var : new com.cmic.gen.sdk.e0();
    }

    public void a(com.cmic.gen.sdk.s1 s1Var) {
        if (s1Var != null) {
            this.a.put("current_config", s1Var);
        }
    }
}
