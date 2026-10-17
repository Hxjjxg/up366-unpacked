package com.igexin.push.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class f extends com.igexin.push.f.b.f {
    private static com.igexin.push.c.f c;
    private boolean e;
    private static final java.lang.String b = com.igexin.push.c.b.a + com.igexin.push.c.f.class.getName();
    public static final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    private f() {
        super(10L, (byte) 0);
        this.p = true;
    }

    private void b(long j) {
        a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public static synchronized com.igexin.push.c.f g() {
        if (c == null) {
            c = new com.igexin.push.c.f();
        }
        return c;
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 20150607;
    }

    @Override // com.igexin.push.f.b.f
    public final void h() {
        a(com.igexin.push.c.b.c, java.util.concurrent.TimeUnit.MILLISECONDS);
        if (this.e) {
            java.lang.String str = b;
            com.igexin.c.a.c.a.a(str, "detect task already stop");
            com.igexin.c.a.c.a.a(str + "|detect task already stop", new java.lang.Object[0]);
            return;
        }
        long j = com.igexin.push.c.b.c;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str2 = b;
        sb.append(str2);
        sb.append("|");
        sb.append(com.igexin.push.c.b.c / 1000);
        sb.append("s passed, do task method, start redect ~~~~");
        com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
        boolean zE = com.igexin.push.g.c.e();
        com.igexin.push.core.e.n = zE;
        if (zE) {
            com.igexin.push.c.c.a().c();
            return;
        }
        long j2 = com.igexin.push.c.b.c;
        com.igexin.c.a.c.a.a(str2 + "|" + (com.igexin.push.c.b.c / 1000) + "s passed, network is unavailable, stop ###", new java.lang.Object[0]);
    }

    public final void i() {
        this.p = false;
        this.e = true;
        l();
    }
}
