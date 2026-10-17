package com.cmic.gen.sdk;

/* JADX INFO: compiled from: UmcConfigManager.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class u1 implements com.cmic.gen.sdk.t1.c {
    private static com.cmic.gen.sdk.u1 e;
    private com.cmic.gen.sdk.s1 a;
    private com.cmic.gen.sdk.s1 b;
    private com.cmic.gen.sdk.t1 c;
    private android.content.Context d;

    private u1(android.content.Context context) {
        this.d = context;
        c();
    }

    public static com.cmic.gen.sdk.u1 a(android.content.Context context) {
        if (e == null) {
            synchronized (com.cmic.gen.sdk.u1.class) {
                if (e == null) {
                    e = new com.cmic.gen.sdk.u1(context);
                }
            }
        }
        return e;
    }

    private void c() {
        java.lang.String strA = com.cmic.gen.sdk.h1.a("sdk_config_version", "");
        if (android.text.TextUtils.isEmpty(strA) || !com.cmic.gen.sdk.auth.b.SDK_VERSION.equals(strA)) {
            com.cmic.gen.sdk.t1 t1VarA = com.cmic.gen.sdk.t1.a(true);
            this.c = t1VarA;
            this.a = t1VarA.c();
            if (!android.text.TextUtils.isEmpty(strA)) {
                a();
            }
        } else {
            com.cmic.gen.sdk.t1 t1VarA2 = com.cmic.gen.sdk.t1.a(false);
            this.c = t1VarA2;
            this.a = t1VarA2.d();
        }
        this.c.a(this);
        this.b = this.c.c();
    }

    public com.cmic.gen.sdk.s1 b() {
        try {
            return this.a.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            return this.b;
        }
    }

    @Override // com.cmic.gen.sdk.t1.c
    public void a(com.cmic.gen.sdk.s1 s1Var) {
        this.a = s1Var;
    }

    public void a(com.cmic.gen.sdk.i iVar) {
        this.c.a(iVar);
    }

    private void a() {
        com.cmic.gen.sdk.h0.a("UmcConfigManager", "delete localConfig");
        this.c.b();
    }
}
