package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class f {
    public com.zx.a.I8b7.e a;

    public abstract java.lang.String a();

    public void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final android.database.sqlite.SQLiteDatabase b() {
        com.zx.a.I8b7.e eVar = this.a;
        if (eVar != null) {
            return eVar.b().getReadableDatabase();
        }
        java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("table ");
        sbA.append(c());
        sbA.append(" has not been added to a db");
        throw new java.lang.RuntimeException(sbA.toString());
    }

    public abstract java.lang.String c();

    public final android.database.sqlite.SQLiteDatabase d() {
        com.zx.a.I8b7.e eVar = this.a;
        if (eVar != null) {
            return eVar.b().getWritableDatabase();
        }
        throw new java.lang.RuntimeException("table zx_table has not been added to a db");
    }
}
