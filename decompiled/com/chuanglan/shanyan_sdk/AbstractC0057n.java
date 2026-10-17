package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
abstract class AbstractC0057n extends android.database.sqlite.SQLiteOpenHelper {
    private java.io.File a;

    AbstractC0057n(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i, boolean z) {
        super(context, str, cursorFactory, i);
        this.a = z ? null : com.chuanglan.shanyan_sdk.AbstractC0066w.a(com.chuanglan.shanyan_sdk.AbstractC0066w.b(), str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        java.io.File file = this.a;
        android.database.sqlite.SQLiteDatabase readableDatabase = file == null ? super.getReadableDatabase() : android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(file, (android.database.sqlite.SQLiteDatabase.CursorFactory) null);
        onCreate(readableDatabase);
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        java.io.File file = this.a;
        android.database.sqlite.SQLiteDatabase writableDatabase = file == null ? super.getWritableDatabase() : android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(file, (android.database.sqlite.SQLiteDatabase.CursorFactory) null);
        onCreate(writableDatabase);
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
