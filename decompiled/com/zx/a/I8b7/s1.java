package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class s1 implements java.lang.Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.p1 p1Var = com.zx.a.I8b7.p1.b.a;
            p1Var.getClass();
            if (com.zx.a.I8b7.p1.i != null && com.zx.a.I8b7.p1.i.length() > 0) {
                com.zx.a.I8b7.p1.i.a(p1Var.a - 1);
                p1Var.a = com.zx.a.I8b7.p1.i.length();
            }
            p1Var.getClass();
            if (com.zx.a.I8b7.p1.j == null || com.zx.a.I8b7.p1.j.length() <= 0) {
                return;
            }
            com.zx.a.I8b7.p1.j.a(p1Var.b - 1);
            p1Var.b = com.zx.a.I8b7.p1.j.length();
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
