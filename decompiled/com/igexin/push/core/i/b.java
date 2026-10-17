package com.igexin.push.core.i;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class b {
    private static com.igexin.push.core.i.b b;
    private java.util.Map<java.lang.Long, com.igexin.push.core.i.a> a = new java.util.HashMap();

    private b() {
    }

    public static com.igexin.push.core.i.b a() {
        if (b == null) {
            b = new com.igexin.push.core.i.b();
        }
        return b;
    }

    private void b(com.igexin.push.core.i.a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    private void c(com.igexin.push.core.i.a aVar) {
        if (aVar != null) {
            this.a.put(aVar.a(), aVar);
        }
    }

    public final com.igexin.push.core.i.a a(java.lang.Long l) {
        return this.a.get(l);
    }

    public final void a(com.igexin.push.core.i.a aVar) {
        if (aVar != null) {
            this.a.remove(aVar.a());
        }
    }
}
