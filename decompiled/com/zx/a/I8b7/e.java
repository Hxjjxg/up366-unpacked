package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class e {
    public android.database.sqlite.SQLiteOpenHelper b;
    public java.util.Map<java.lang.Class<? extends com.zx.a.I8b7.f>, com.zx.a.I8b7.f> a = new java.util.HashMap();
    public java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);

    public abstract java.lang.String a();

    public final android.database.sqlite.SQLiteOpenHelper b() {
        android.database.sqlite.SQLiteOpenHelper sQLiteOpenHelper = this.b;
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper;
        }
        java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("db ");
        sbA.append(a());
        sbA.append(" has not been initialized");
        throw new java.lang.RuntimeException(sbA.toString());
    }

    public abstract int c();
}
