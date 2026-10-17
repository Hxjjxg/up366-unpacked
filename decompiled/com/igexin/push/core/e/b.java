package com.igexin.push.core.e;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class b implements com.igexin.push.core.e.a {
    private static com.igexin.push.core.e.b b;
    private java.util.Map<java.lang.String, byte[]> a = new java.util.HashMap();

    private b() {
    }

    private static com.igexin.push.core.e.b a() {
        if (b == null) {
            b = new com.igexin.push.core.e.b();
        }
        return b;
    }

    private java.lang.String a(byte[] bArr) {
        java.lang.String strA;
        do {
            strA = com.igexin.push.g.r.a();
        } while (this.a.containsKey(strA));
        this.a.put(strA, bArr);
        return strA;
    }

    private synchronized byte[] a(java.lang.String str) {
        byte[] bArr;
        bArr = this.a.get(str);
        if (bArr != null) {
            this.a.remove(str);
        }
        return bArr;
    }

    @Override // com.igexin.push.core.e.a
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }
}
