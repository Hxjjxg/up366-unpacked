package com.igexin.push.f.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class a extends com.igexin.push.f.b.f {
    private static volatile com.igexin.push.f.b.a b;
    private final java.util.List<com.igexin.push.f.b.c> a;

    private a() {
        super(60000L, (byte) 0);
        this.p = true;
        this.a = new java.util.ArrayList();
    }

    public static com.igexin.push.f.b.a g() {
        if (b == null) {
            synchronized (com.igexin.push.f.b.a.class) {
                if (b == null) {
                    b = new com.igexin.push.f.b.a();
                }
            }
        }
        return b;
    }

    private void i() {
        a(360000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public final boolean a(com.igexin.push.f.b.c cVar, boolean z) {
        java.util.List<com.igexin.push.f.b.c> list = this.a;
        if (list == null || list.contains(cVar)) {
            return false;
        }
        if (z) {
            cVar.b();
            cVar.a(java.lang.System.currentTimeMillis());
        }
        return this.a.add(cVar);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }

    @Override // com.igexin.push.f.b.f
    protected final void h() {
        java.lang.Thread.currentThread().getName();
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        for (com.igexin.push.f.b.c cVar : this.a) {
            if (cVar.d()) {
                cVar.b();
                cVar.a(java.lang.System.currentTimeMillis());
            }
        }
        a(360000L, java.util.concurrent.TimeUnit.MILLISECONDS);
        com.igexin.c.a.b.e.a().a((java.lang.Object) this);
    }
}
