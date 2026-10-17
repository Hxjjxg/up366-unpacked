package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class b0 implements java.lang.Runnable {
    public final /* synthetic */ java.io.File a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ java.io.File c;
    public final /* synthetic */ java.io.File d;

    public b0(com.zx.a.I8b7.c0 c0Var, java.io.File file, java.lang.String str, java.io.File file2, java.io.File file3) {
        this.a = file;
        this.b = str;
        this.c = file2;
        this.d = file3;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            java.lang.Thread.sleep(1000L);
            this.a.delete();
            new java.io.File(this.b).delete();
            this.c.delete();
            this.d.delete();
            com.zx.a.I8b7.t0.a(this.d);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
