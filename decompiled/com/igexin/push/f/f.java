package com.igexin.push.f;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class f implements com.igexin.push.f.b.c {
    private static final java.lang.String a = "SilentTask";
    private static com.igexin.push.f.f b;
    private boolean c = com.igexin.push.g.c.a(java.lang.System.currentTimeMillis());

    private f() {
    }

    public static com.igexin.push.f.f a() {
        if (b == null) {
            b = new com.igexin.push.f.f();
        }
        return b;
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        c();
    }

    public final void c() {
        boolean z = this.c;
        boolean zA = com.igexin.push.g.c.a(java.lang.System.currentTimeMillis());
        this.c = zA;
        if (!z || zA) {
            return;
        }
        com.igexin.c.a.c.a.b(a, "out silence time");
        com.igexin.push.f.a.a().a(false);
    }

    @Override // com.igexin.push.f.b.c
    public final boolean d() {
        return com.igexin.push.config.d.c != 0;
    }
}
