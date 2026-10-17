package com.igexin.push.f.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class d extends com.igexin.push.f.b.f {
    public static final int a = 20160629;
    public static final long b = 604800000;
    private static final java.lang.String c = "PollingTimerTask";
    private long e;
    private java.util.concurrent.atomic.AtomicBoolean f;

    public static class a {
        private static final com.igexin.push.f.b.d a = new com.igexin.push.f.b.d();

        private a() {
        }
    }

    public d() {
        super(604800000L, (byte) 0);
        this.e = com.igexin.push.config.d.y;
        this.f = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.p = true;
    }

    private void b(long j) {
        a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    private static com.igexin.push.f.b.d q() {
        return com.igexin.push.f.b.d.a.a;
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return a;
    }

    public final void g() {
        if (!this.f.getAndSet(true)) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this, false, true);
        }
        b(this.e);
    }

    @Override // com.igexin.push.f.b.f
    protected final void h() {
        a(this.e, java.util.concurrent.TimeUnit.MILLISECONDS);
        if (com.igexin.push.core.e.u) {
            com.igexin.c.a.c.a.b(c, "polling sendHeartbeat");
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.f();
        } else if (com.igexin.push.core.e.n && com.igexin.push.core.e.p && com.igexin.push.core.e.s && com.igexin.push.g.c.a()) {
            com.igexin.c.a.c.a.a("PollingTimerTask|run = true", new java.lang.Object[0]);
            com.igexin.push.d.c cVar = com.igexin.push.d.c.b.a;
            if (cVar.b && cVar.e != null && !(cVar.e instanceof com.igexin.push.d.d)) {
                cVar.e = new com.igexin.push.d.d();
            }
            com.igexin.push.f.b.e.g().a(c, 100L);
        }
    }

    public final void i() {
        a(604800000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }
}
