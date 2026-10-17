package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FileMapInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.common.utils.alifile.FileMapInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "file_map_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property ObjectId = new org.greenrobot.greendao.Property(1, java.lang.String.class, "objectId", false, "object_id");
        public static final org.greenrobot.greendao.Property Path = new org.greenrobot.greendao.Property(2, java.lang.String.class, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, false, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        public static final org.greenrobot.greendao.Property Biz = new org.greenrobot.greendao.Property(3, java.lang.String.class, "biz", false, "biz");
        public static final org.greenrobot.greendao.Property Url = new org.greenrobot.greendao.Property(4, java.lang.String.class, com.up366.mobile.commonui.CommonWebViewActivity.URL, false, com.up366.mobile.commonui.CommonWebViewActivity.URL);
        public static final org.greenrobot.greendao.Property Ext = new org.greenrobot.greendao.Property(5, java.lang.String.class, "ext", false, "ext");
        public static final org.greenrobot.greendao.Property AddTime = new org.greenrobot.greendao.Property(6, java.lang.Long.TYPE, "addTime", false, "add_time");
        public static final org.greenrobot.greendao.Property Uploaded = new org.greenrobot.greendao.Property(7, java.lang.Boolean.TYPE, "uploaded", false, "uploaded");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public FileMapInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public FileMapInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"file_map_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"object_id\" TEXT,\"path\" TEXT,\"biz\" TEXT,\"url\" TEXT,\"ext\" TEXT,\"add_time\" INTEGER NOT NULL ,\"uploaded\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_file_map_info_object_id ON \"file_map_info\" (\"object_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"file_map_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = fileMapInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String objectId = fileMapInfo.getObjectId();
        if (objectId != null) {
            databaseStatement.bindString(2, objectId);
        }
        java.lang.String path = fileMapInfo.getPath();
        if (path != null) {
            databaseStatement.bindString(3, path);
        }
        java.lang.String biz = fileMapInfo.getBiz();
        if (biz != null) {
            databaseStatement.bindString(4, biz);
        }
        java.lang.String url = fileMapInfo.getUrl();
        if (url != null) {
            databaseStatement.bindString(5, url);
        }
        java.lang.String ext = fileMapInfo.getExt();
        if (ext != null) {
            databaseStatement.bindString(6, ext);
        }
        databaseStatement.bindLong(7, fileMapInfo.getAddTime());
        databaseStatement.bindLong(8, fileMapInfo.getUploaded() ? 1L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = fileMapInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String objectId = fileMapInfo.getObjectId();
        if (objectId != null) {
            sQLiteStatement.bindString(2, objectId);
        }
        java.lang.String path = fileMapInfo.getPath();
        if (path != null) {
            sQLiteStatement.bindString(3, path);
        }
        java.lang.String biz = fileMapInfo.getBiz();
        if (biz != null) {
            sQLiteStatement.bindString(4, biz);
        }
        java.lang.String url = fileMapInfo.getUrl();
        if (url != null) {
            sQLiteStatement.bindString(5, url);
        }
        java.lang.String ext = fileMapInfo.getExt();
        if (ext != null) {
            sQLiteStatement.bindString(6, ext);
        }
        sQLiteStatement.bindLong(7, fileMapInfo.getAddTime());
        sQLiteStatement.bindLong(8, fileMapInfo.getUploaded() ? 1L : 0L);
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m108readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.common.utils.alifile.FileMapInfo m107readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        java.lang.String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        java.lang.String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        return new com.up366.mobile.common.utils.alifile.FileMapInfo(lValueOf, string, string2, string3, string4, cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getLong(i + 6), cursor.getShort(i + 7) != 0);
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo, int i) {
        fileMapInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        fileMapInfo.setObjectId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        fileMapInfo.setPath(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        fileMapInfo.setBiz(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        fileMapInfo.setUrl(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        fileMapInfo.setExt(cursor.isNull(i6) ? null : cursor.getString(i6));
        fileMapInfo.setAddTime(cursor.getLong(i + 6));
        fileMapInfo.setUploaded(cursor.getShort(i + 7) != 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo, long j) {
        fileMapInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        if (fileMapInfo != null) {
            return fileMapInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        return fileMapInfo.getRowId() != null;
    }
}
