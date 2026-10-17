package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RequestTimeObjectDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.common.http.RequestTimeObject, java.lang.Long> {
    public static final java.lang.String TABLENAME = "request_time_object";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Key = new org.greenrobot.greendao.Property(1, java.lang.String.class, "key", false, "key");
        public static final org.greenrobot.greendao.Property Params = new org.greenrobot.greendao.Property(2, java.lang.String.class, "params", false, "params");
        public static final org.greenrobot.greendao.Property Time = new org.greenrobot.greendao.Property(3, java.lang.Long.TYPE, "time", false, "time");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public RequestTimeObjectDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public RequestTimeObjectDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"request_time_object\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"key\" TEXT,\"params\" TEXT,\"time\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_request_time_object_key ON \"request_time_object\" (\"key\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"request_time_object\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.common.http.RequestTimeObject requestTimeObject) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = requestTimeObject.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String key = requestTimeObject.getKey();
        if (key != null) {
            databaseStatement.bindString(2, key);
        }
        java.lang.String params = requestTimeObject.getParams();
        if (params != null) {
            databaseStatement.bindString(3, params);
        }
        databaseStatement.bindLong(4, requestTimeObject.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.common.http.RequestTimeObject requestTimeObject) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = requestTimeObject.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String key = requestTimeObject.getKey();
        if (key != null) {
            sQLiteStatement.bindString(2, key);
        }
        java.lang.String params = requestTimeObject.getParams();
        if (params != null) {
            sQLiteStatement.bindString(3, params);
        }
        sQLiteStatement.bindLong(4, requestTimeObject.getTime());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m118readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.common.http.RequestTimeObject m117readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        return new com.up366.mobile.common.http.RequestTimeObject(lValueOf, string, cursor.isNull(i3) ? null : cursor.getString(i3), cursor.getLong(i + 3));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.common.http.RequestTimeObject requestTimeObject, int i) {
        requestTimeObject.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        requestTimeObject.setKey(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        requestTimeObject.setParams(cursor.isNull(i3) ? null : cursor.getString(i3));
        requestTimeObject.setTime(cursor.getLong(i + 3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.common.http.RequestTimeObject requestTimeObject, long j) {
        requestTimeObject.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.common.http.RequestTimeObject requestTimeObject) {
        if (requestTimeObject != null) {
            return requestTimeObject.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.common.http.RequestTimeObject requestTimeObject) {
        return requestTimeObject.getRowId() != null;
    }
}
