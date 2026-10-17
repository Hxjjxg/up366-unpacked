package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class d extends android.database.sqlite.SQLiteOpenHelper {
    public final /* synthetic */ com.zx.a.I8b7.e a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.zx.a.I8b7.e eVar, android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, i);
        this.a = eVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            java.util.Iterator<java.lang.Class<? extends com.zx.a.I8b7.f>> it = this.a.a.keySet().iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(this.a.a.get(it.next()).a());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        try {
            java.util.Iterator<java.lang.Class<? extends com.zx.a.I8b7.f>> it = this.a.a.keySet().iterator();
            while (it.hasNext()) {
                this.a.a.get(it.next()).getClass();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        try {
            java.util.Iterator<java.lang.Class<? extends com.zx.a.I8b7.f>> it = this.a.a.keySet().iterator();
            while (it.hasNext()) {
                this.a.a.get(it.next()).a(sQLiteDatabase, i, i2);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
