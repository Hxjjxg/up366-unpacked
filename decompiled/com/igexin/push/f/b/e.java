package com.igexin.push.f.b;

import com.igexin.push.core.e.f.AnonymousClass19;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class e extends com.igexin.push.f.b.f {
    public static final int b = -2147483641;
    private static final java.lang.String c = "RNTT";
    private static com.igexin.push.f.b.e e;
    public long a;
    private long f;

    private e() {
        super(com.igexin.push.config.c.g, (byte) 0);
        this.p = true;
        this.f = java.lang.System.currentTimeMillis();
        this.a = android.os.SystemClock.elapsedRealtime();
    }

    private void b(long j) {
        this.a = j;
    }

    public static synchronized com.igexin.push.f.b.e g() {
        if (e == null) {
            e = new com.igexin.push.f.b.e();
        }
        return e;
    }

    public final void a(java.lang.String str, long j) {
        com.igexin.push.core.e.a(str, j);
        a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return b;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
    }

    @Override // com.igexin.push.f.b.f
    protected final void h() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        boolean zA = com.igexin.push.g.c.a();
        com.igexin.push.core.e.n = com.igexin.push.g.c.e();
        boolean z = com.igexin.push.core.e.u;
        boolean z2 = com.igexin.push.core.e.p;
        boolean z3 = com.igexin.push.core.e.s;
        com.igexin.c.a.c.a.a("RNTT|networkAvailable = " + com.igexin.push.core.e.n + "|,sdkOnline = " + com.igexin.push.core.e.u + ", sdkOn= " + com.igexin.push.core.e.p + ", pushOn =" + com.igexin.push.core.e.s + ", blockEndTime= " + zA, new java.lang.Object[0]);
        if (com.igexin.push.core.e.n && com.igexin.push.core.e.p && com.igexin.push.core.e.s && !com.igexin.push.core.e.u && zA) {
            com.igexin.c.a.c.a.a("RNTT reconnect timer task isOnline = false, try login...", new java.lang.Object[0]);
            if (java.lang.System.currentTimeMillis() - this.f < 2500) {
                com.igexin.push.core.e.r++;
            }
            if (com.igexin.push.core.e.r > 30 && java.lang.Math.abs(android.os.SystemClock.elapsedRealtime() - this.a) < 72000.0d) {
                com.igexin.push.core.e.f.a();
                java.lang.String str = com.igexin.push.core.e.A;
                com.igexin.c.a.c.a.a(com.igexin.push.core.e.f.a + "| found a duplicate cid " + com.igexin.push.core.e.A, new java.lang.Object[0]);
                com.igexin.push.core.e.L = null;
                com.igexin.push.core.e.f.d();
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass19(com.igexin.push.core.e.L), false, true);
                com.igexin.push.core.e.f.a().b();
                com.igexin.push.core.e.r = 0;
                g().a = android.os.SystemClock.elapsedRealtime();
            }
            this.f = java.lang.System.currentTimeMillis();
            com.igexin.push.core.k.a();
            com.igexin.push.core.k.b();
        } else {
            com.igexin.c.a.c.a.a("RNTT reconnect timer task stop, connect interval = 3min #######", new java.lang.Object[0]);
        }
        a(com.igexin.push.config.c.g, java.util.concurrent.TimeUnit.MILLISECONDS);
    }
}
