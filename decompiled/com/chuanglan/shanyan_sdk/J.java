package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class J extends com.chuanglan.shanyan_sdk.AbstractC0057n {
    private static volatile com.chuanglan.shanyan_sdk.J b;

    private J(android.content.Context context) {
        super(context, "cl_jm_database.db", null, 2377, true);
    }

    public static com.chuanglan.shanyan_sdk.J a(android.content.Context context) {
        if (b == null) {
            synchronized (com.chuanglan.shanyan_sdk.J.class) {
                if (b == null) {
                    b = new com.chuanglan.shanyan_sdk.J(context);
                }
            }
        }
        return b;
    }

    @Override // com.chuanglan.shanyan_sdk.AbstractC0057n, android.database.sqlite.SQLiteOpenHelper
    public /* bridge */ /* synthetic */ android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override // com.chuanglan.shanyan_sdk.AbstractC0057n, android.database.sqlite.SQLiteOpenHelper
    public /* bridge */ /* synthetic */ android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override // com.chuanglan.shanyan_sdk.AbstractC0057n, android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        super.onCreate(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cl_jm_device(i4 text UNIQUE,i8 text,i1 text,i7 text,i9 text)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cl_jm_behavior(id INTEGER PRIMARY KEY AUTOINCREMENT,i4 text,bk text,bp text,bm text,b2 text,bc text,bh text,ba text,b7 text,bi text,b8 text,bg text,bj text,bb text,bl text,b5 INTEGER ,b1 INTEGER ,b4 text,be text,b3 text,b6 text,bd text,b9 INTEGER,bf text)");
    }

    @Override // com.chuanglan.shanyan_sdk.AbstractC0057n, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onUpgrade(sQLiteDatabase, i, i2);
    }
}
