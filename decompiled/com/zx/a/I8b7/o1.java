package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class o1 implements java.lang.Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ com.zx.a.I8b7.p1 b;

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.zx.a.I8b7.o1.this.b.g++;
                com.zx.a.I8b7.o1 o1Var = com.zx.a.I8b7.o1.this;
                com.zx.a.I8b7.p1 p1Var = o1Var.b;
                com.zx.a.I8b7.p1.a(p1Var, o1Var.a, p1Var.g);
                com.zx.a.I8b7.o1.this.b.f++;
                com.zx.a.I8b7.p1.a(com.zx.a.I8b7.o1.this.b);
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
            }
        }
    }

    public o1(com.zx.a.I8b7.p1 p1Var, long j) {
        this.b = p1Var;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.i4.f.a.e.execute(new com.zx.a.I8b7.o1.a());
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
