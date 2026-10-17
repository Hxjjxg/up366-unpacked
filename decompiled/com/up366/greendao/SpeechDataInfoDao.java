package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SpeechDataInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.SpeechDataInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "speech_data_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Guid = new org.greenrobot.greendao.Property(1, java.lang.String.class, "guid", false, "guid");
        public static final org.greenrobot.greendao.Property Data = new org.greenrobot.greendao.Property(2, java.lang.String.class, "data", false, "data");
        public static final org.greenrobot.greendao.Property Data1 = new org.greenrobot.greendao.Property(3, java.lang.String.class, "data1", false, "data1");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public SpeechDataInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public SpeechDataInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"speech_data_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"guid\" TEXT,\"data\" TEXT,\"data1\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_speech_data_info_guid ON \"speech_data_info\" (\"guid\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"speech_data_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.SpeechDataInfo speechDataInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = speechDataInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = speechDataInfo.getGuid();
        if (guid != null) {
            databaseStatement.bindString(2, guid);
        }
        java.lang.String data = speechDataInfo.getData();
        if (data != null) {
            databaseStatement.bindString(3, data);
        }
        java.lang.String data1 = speechDataInfo.getData1();
        if (data1 != null) {
            databaseStatement.bindString(4, data1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.SpeechDataInfo speechDataInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = speechDataInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = speechDataInfo.getGuid();
        if (guid != null) {
            sQLiteStatement.bindString(2, guid);
        }
        java.lang.String data = speechDataInfo.getData();
        if (data != null) {
            sQLiteStatement.bindString(3, data);
        }
        java.lang.String data1 = speechDataInfo.getData1();
        if (data1 != null) {
            sQLiteStatement.bindString(4, data1);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m122readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.SpeechDataInfo m121readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        int i3 = i + 2;
        int i4 = i + 3;
        return new com.up366.mobile.book.model.SpeechDataInfo(lValueOf, cursor.isNull(i2) ? null : cursor.getString(i2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.SpeechDataInfo speechDataInfo, int i) {
        speechDataInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        speechDataInfo.setGuid(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        speechDataInfo.setData(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        speechDataInfo.setData1(cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.SpeechDataInfo speechDataInfo, long j) {
        speechDataInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.SpeechDataInfo speechDataInfo) {
        if (speechDataInfo != null) {
            return speechDataInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.SpeechDataInfo speechDataInfo) {
        return speechDataInfo.getRowId() != null;
    }
}
