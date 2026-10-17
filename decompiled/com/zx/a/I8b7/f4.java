package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class f4 implements java.lang.Runnable {
    public final /* synthetic */ android.content.Context a;
    public final /* synthetic */ com.zx.a.I8b7.g4 b;

    public f4(com.zx.a.I8b7.g4 g4Var, android.content.Context context) {
        this.b = g4Var;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.x3.a(this.a);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXCore init failed: "));
            this.b.b.set(false);
        }
    }
}
