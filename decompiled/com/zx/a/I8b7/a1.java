package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class a1 {
    public final java.util.List<com.zx.a.I8b7.q0> a = new java.util.ArrayList();

    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        for (com.zx.a.I8b7.q0 q0Var : this.a) {
            try {
                if (q0Var.a(i, null)) {
                    q0Var.a(i, null, str2, th);
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void a(com.zx.a.I8b7.q0 q0Var) {
        this.a.add(q0Var);
    }
}
