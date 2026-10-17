package com.igexin.push.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class a extends com.igexin.c.a.d.f {
    public static int a = 0;
    public static final int b = -980948;
    public static final int h = -2147483639;
    private static final java.lang.String i = "com.igexin.push.b.a";
    protected android.database.sqlite.SQLiteDatabase c;
    protected android.database.Cursor d;
    java.util.List<com.igexin.push.core.e.a> e;
    java.util.List<com.igexin.push.core.e.a> f;
    boolean g;

    public a() {
        super(1);
        this.e = new java.util.LinkedList();
        this.f = new java.util.LinkedList();
    }

    private void b(boolean z) {
        this.g = z;
    }

    public final void a(com.igexin.push.core.e.a aVar) {
        this.e.add(aVar);
    }

    public final void b(com.igexin.push.core.e.a aVar) {
        this.f.add(aVar);
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        super.b_();
        android.database.sqlite.SQLiteDatabase writableDatabase = com.igexin.push.core.d.a.a.i.getWritableDatabase();
        this.c = writableDatabase;
        writableDatabase.setVersion(7);
        java.util.Iterator<com.igexin.push.core.e.a> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(this.c);
        }
        for (com.igexin.push.core.e.a aVar : this.e) {
            if (this.g) {
                aVar.c(this.c);
            } else {
                aVar.b(this.c);
            }
        }
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.b.a.1
            @Override // com.igexin.push.b.d
            public final void a_() throws java.lang.Exception {
                for (com.igexin.push.core.e.a aVar2 : com.igexin.push.b.a.this.f) {
                    aVar2.a(this.d);
                    if (com.igexin.push.b.a.this.g) {
                        aVar2.c(this.d);
                    } else {
                        aVar2.b(this.d);
                    }
                }
            }
        }, false, true);
        com.igexin.c.a.b.e.a().a(new com.igexin.push.b.c());
        com.igexin.c.a.b.e.a().b();
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2147483639;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        super.d();
        this.o = true;
        this.L = true;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
        android.database.Cursor cursor = this.d;
        if (cursor != null) {
            try {
                cursor.close();
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
