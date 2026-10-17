package com.igexin.push.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class g extends com.igexin.push.c.h implements com.igexin.push.c.i {
    private static com.igexin.push.c.g e;

    private g() {
        super(com.igexin.push.core.e.ap, com.igexin.push.core.e.ar);
        this.d.j = false;
    }

    public static synchronized com.igexin.push.c.g a() {
        if (e == null) {
            e = new com.igexin.push.c.g();
        }
        return e;
    }

    @Override // com.igexin.push.c.i
    public final void a(int i, com.igexin.push.c.d dVar) {
        com.igexin.push.c.e eVarA;
        if (dVar == null || android.text.TextUtils.isEmpty(dVar.a()) || (eVarA = a(dVar.a())) == null) {
            return;
        }
        a(dVar);
        eVarA.a();
        m();
        if (i == com.igexin.push.c.b.a.a) {
            l();
        }
    }

    @Override // com.igexin.push.c.i
    public final void b() {
    }

    @Override // com.igexin.push.c.h
    public final int c() {
        return com.igexin.push.c.b.EnumC0018b.b;
    }

    @Override // com.igexin.push.c.h
    public final com.igexin.push.c.i d() {
        return this;
    }
}
