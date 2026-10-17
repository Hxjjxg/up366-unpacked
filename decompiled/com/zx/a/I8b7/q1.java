package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class q1 {
    public com.zx.a.I8b7.y1 a;
    public com.zx.a.I8b7.z2 b;
    public boolean c;

    public final class a implements java.lang.Runnable {
        /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r4 = this;
                r0 = 0
                throw r0     // Catch: java.lang.Throwable -> L2
            L2:
                r1 = move-exception
                java.lang.Exception r2 = new java.lang.Exception     // Catch: java.lang.Throwable -> L11
                java.lang.String r3 = r1.getMessage()     // Catch: java.lang.Throwable -> L11
                java.lang.Throwable r1 = r1.getCause()     // Catch: java.lang.Throwable -> L11
                r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L11
                throw r0     // Catch: java.lang.Throwable -> L11
            L11:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.q1.a.run():void");
        }
    }

    public q1(com.zx.a.I8b7.z2 z2Var, com.zx.a.I8b7.y1 y1Var) {
        this.b = z2Var;
        this.a = y1Var;
    }

    public com.zx.a.I8b7.b2 a() throws java.lang.Exception {
        synchronized (this) {
            if (this.c) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.c = true;
        }
        try {
            com.zx.a.I8b7.e0 e0Var = this.b.a;
            synchronized (e0Var) {
                e0Var.d.add(this);
            }
            return b();
        } finally {
            com.zx.a.I8b7.e0 e0Var2 = this.b.a;
            e0Var2.a(e0Var2.d, this, false);
        }
    }

    public com.zx.a.I8b7.b2 b() throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.b.b);
        this.a.getClass();
        arrayList.add(new com.zx.a.I8b7.h());
        arrayList.add(new com.zx.a.I8b7.v(this.b));
        arrayList.add(new com.zx.a.I8b7.p());
        com.zx.a.I8b7.y1 y1Var = this.a;
        if (arrayList.size() <= 0) {
            throw new java.lang.AssertionError();
        }
        com.zx.a.I8b7.r1 r1Var = new com.zx.a.I8b7.r1(arrayList, null, 1, y1Var);
        com.zx.a.I8b7.u0 u0Var = (com.zx.a.I8b7.u0) arrayList.get(0);
        com.zx.a.I8b7.b2 b2VarA = u0Var.a(r1Var);
        if (b2VarA == null) {
            throw new java.lang.NullPointerException("interceptor " + u0Var + " returned null");
        }
        if (b2VarA.e != null) {
            return b2VarA;
        }
        throw new java.lang.IllegalStateException("interceptor " + u0Var + " returned a response with no body");
    }
}
