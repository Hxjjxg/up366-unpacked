package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BatchUploadItemDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.common.logic.log.model.BatchUploadItem, java.lang.Long> {
    public static final java.lang.String TABLENAME = "batch_upload_item";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property BatchId = new org.greenrobot.greendao.Property(1, java.lang.String.class, "batchId", false, "batch_id");
        public static final org.greenrobot.greendao.Property Id = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, com.igexin.push.core.b.C, false, com.igexin.push.core.b.C);
        public static final org.greenrobot.greendao.Property Type = new org.greenrobot.greendao.Property(3, java.lang.Integer.TYPE, "type", false, "type");
        public static final org.greenrobot.greendao.Property Size = new org.greenrobot.greendao.Property(4, java.lang.Long.TYPE, "size", false, "size");
        public static final org.greenrobot.greendao.Property UploadSize = new org.greenrobot.greendao.Property(5, java.lang.Long.TYPE, "uploadSize", false, "upload_size");
        public static final org.greenrobot.greendao.Property State = new org.greenrobot.greendao.Property(6, java.lang.Integer.TYPE, "state", false, "state");
        public static final org.greenrobot.greendao.Property ConfigUrl = new org.greenrobot.greendao.Property(7, java.lang.String.class, "configUrl", false, "config_url");
        public static final org.greenrobot.greendao.Property Headers = new org.greenrobot.greendao.Property(8, java.lang.String.class, "headers", false, "headers");
        public static final org.greenrobot.greendao.Property PostParams = new org.greenrobot.greendao.Property(9, java.lang.String.class, "postParams", false, "post_params");
        public static final org.greenrobot.greendao.Property Path = new org.greenrobot.greendao.Property(10, java.lang.String.class, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, false, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        public static final org.greenrobot.greendao.Property ObjectId = new org.greenrobot.greendao.Property(11, java.lang.String.class, "objectId", false, "object_id");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public BatchUploadItemDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BatchUploadItemDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"batch_upload_item\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"batch_id\" TEXT,\"id\" INTEGER NOT NULL ,\"type\" INTEGER NOT NULL ,\"size\" INTEGER NOT NULL ,\"upload_size\" INTEGER NOT NULL ,\"state\" INTEGER NOT NULL ,\"config_url\" TEXT,\"headers\" TEXT,\"post_params\" TEXT,\"path\" TEXT,\"object_id\" TEXT);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"batch_upload_item\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = batchUploadItem.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String batchId = batchUploadItem.getBatchId();
        if (batchId != null) {
            databaseStatement.bindString(2, batchId);
        }
        databaseStatement.bindLong(3, batchUploadItem.getId());
        databaseStatement.bindLong(4, batchUploadItem.getType());
        databaseStatement.bindLong(5, batchUploadItem.getSize());
        databaseStatement.bindLong(6, batchUploadItem.getUploadSize());
        databaseStatement.bindLong(7, batchUploadItem.getState());
        java.lang.String configUrl = batchUploadItem.getConfigUrl();
        if (configUrl != null) {
            databaseStatement.bindString(8, configUrl);
        }
        java.lang.String headers = batchUploadItem.getHeaders();
        if (headers != null) {
            databaseStatement.bindString(9, headers);
        }
        java.lang.String postParams = batchUploadItem.getPostParams();
        if (postParams != null) {
            databaseStatement.bindString(10, postParams);
        }
        java.lang.String path = batchUploadItem.getPath();
        if (path != null) {
            databaseStatement.bindString(11, path);
        }
        java.lang.String objectId = batchUploadItem.getObjectId();
        if (objectId != null) {
            databaseStatement.bindString(12, objectId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = batchUploadItem.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String batchId = batchUploadItem.getBatchId();
        if (batchId != null) {
            sQLiteStatement.bindString(2, batchId);
        }
        sQLiteStatement.bindLong(3, batchUploadItem.getId());
        sQLiteStatement.bindLong(4, batchUploadItem.getType());
        sQLiteStatement.bindLong(5, batchUploadItem.getSize());
        sQLiteStatement.bindLong(6, batchUploadItem.getUploadSize());
        sQLiteStatement.bindLong(7, batchUploadItem.getState());
        java.lang.String configUrl = batchUploadItem.getConfigUrl();
        if (configUrl != null) {
            sQLiteStatement.bindString(8, configUrl);
        }
        java.lang.String headers = batchUploadItem.getHeaders();
        if (headers != null) {
            sQLiteStatement.bindString(9, headers);
        }
        java.lang.String postParams = batchUploadItem.getPostParams();
        if (postParams != null) {
            sQLiteStatement.bindString(10, postParams);
        }
        java.lang.String path = batchUploadItem.getPath();
        if (path != null) {
            sQLiteStatement.bindString(11, path);
        }
        java.lang.String objectId = batchUploadItem.getObjectId();
        if (objectId != null) {
            sQLiteStatement.bindString(12, objectId);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m82readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.common.logic.log.model.BatchUploadItem m81readEntity(android.database.Cursor cursor, int i) {
        int i2 = i + 1;
        int i3 = i + 7;
        int i4 = i + 8;
        int i5 = i + 9;
        int i6 = i + 10;
        int i7 = i + 11;
        return new com.up366.mobile.common.logic.log.model.BatchUploadItem(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.getInt(i + 2), cursor.getInt(i + 3), cursor.getLong(i + 4), cursor.getLong(i + 5), cursor.getInt(i + 6), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem, int i) {
        batchUploadItem.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        batchUploadItem.setBatchId(cursor.isNull(i2) ? null : cursor.getString(i2));
        batchUploadItem.setId(cursor.getInt(i + 2));
        batchUploadItem.setType(cursor.getInt(i + 3));
        batchUploadItem.setSize(cursor.getLong(i + 4));
        batchUploadItem.setUploadSize(cursor.getLong(i + 5));
        batchUploadItem.setState(cursor.getInt(i + 6));
        int i3 = i + 7;
        batchUploadItem.setConfigUrl(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 8;
        batchUploadItem.setHeaders(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 9;
        batchUploadItem.setPostParams(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 10;
        batchUploadItem.setPath(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 11;
        batchUploadItem.setObjectId(cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem, long j) {
        batchUploadItem.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) {
        if (batchUploadItem != null) {
            return batchUploadItem.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.common.logic.log.model.BatchUploadItem batchUploadItem) {
        return batchUploadItem.getRowId() != null;
    }
}
