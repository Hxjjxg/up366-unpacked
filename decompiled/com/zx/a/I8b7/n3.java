package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class n3 implements java.lang.Runnable {
    public final /* synthetic */ boolean a;

    public n3(com.zx.a.I8b7.i3 i3Var, boolean z) {
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.h4 h4Var = com.zx.a.I8b7.w2.a.a.a;
            boolean z = this.a;
            h4Var.getClass();
            if (z != com.zx.a.I8b7.x3.u) {
                com.zx.a.I8b7.x3.u = z ? 1 : 0;
                h4Var.a(20, com.zx.a.I8b7.x3.u + "", false);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }
}
