package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecSessionModelDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.helper.recorder.AsecSessionModel, java.lang.Long> {
    public static final java.lang.String TABLENAME = "asec_session_model";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property RecordId = new org.greenrobot.greendao.Property(1, java.lang.String.class, "recordId", false, "record_id");
        public static final org.greenrobot.greendao.Property Type = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, "type", false, "type");
        public static final org.greenrobot.greendao.Property NetFiles = new org.greenrobot.greendao.Property(3, java.lang.String.class, "netFiles", false, "net_files");
        public static final org.greenrobot.greendao.Property WavPath = new org.greenrobot.greendao.Property(4, java.lang.String.class, "wavPath", false, "wav_path");
        public static final org.greenrobot.greendao.Property Duration = new org.greenrobot.greendao.Property(5, java.lang.Long.TYPE, "duration", false, "duration");
        public static final org.greenrobot.greendao.Property State = new org.greenrobot.greendao.Property(6, java.lang.Integer.TYPE, "state", false, "state");
        public static final org.greenrobot.greendao.Property Result = new org.greenrobot.greendao.Property(7, java.lang.String.class, "result", false, "result");
        public static final org.greenrobot.greendao.Property ErrCount = new org.greenrobot.greendao.Property(8, java.lang.Integer.TYPE, "errCount", false, "err_count");
        public static final org.greenrobot.greendao.Property AddTime = new org.greenrobot.greendao.Property(9, java.lang.Long.TYPE, "addTime", false, "add_time");
        public static final org.greenrobot.greendao.Property Params = new org.greenrobot.greendao.Property(10, java.lang.String.class, "params", false, "params");
        public static final org.greenrobot.greendao.Property CbType = new org.greenrobot.greendao.Property(11, java.lang.Integer.TYPE, "cbType", false, "cb_type");
        public static final org.greenrobot.greendao.Property FingerprintJsonFilepath = new org.greenrobot.greendao.Property(12, java.lang.String.class, "fingerprintJsonFilepath", false, "fingerprint_json_filepath");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public AsecSessionModelDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public AsecSessionModelDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"asec_session_model\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"record_id\" TEXT,\"type\" INTEGER NOT NULL ,\"net_files\" TEXT,\"wav_path\" TEXT,\"duration\" INTEGER NOT NULL ,\"state\" INTEGER NOT NULL ,\"result\" TEXT,\"err_count\" INTEGER NOT NULL ,\"add_time\" INTEGER NOT NULL ,\"params\" TEXT,\"cb_type\" INTEGER NOT NULL ,\"fingerprint_json_filepath\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_asec_session_model_record_id ON \"asec_session_model\" (\"record_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"asec_session_model\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = asecSessionModel.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String recordId = asecSessionModel.getRecordId();
        if (recordId != null) {
            databaseStatement.bindString(2, recordId);
        }
        databaseStatement.bindLong(3, asecSessionModel.getType());
        java.lang.String netFiles = asecSessionModel.getNetFiles();
        if (netFiles != null) {
            databaseStatement.bindString(4, netFiles);
        }
        java.lang.String wavPath = asecSessionModel.getWavPath();
        if (wavPath != null) {
            databaseStatement.bindString(5, wavPath);
        }
        databaseStatement.bindLong(6, asecSessionModel.getDuration());
        databaseStatement.bindLong(7, asecSessionModel.getState());
        java.lang.String result = asecSessionModel.getResult();
        if (result != null) {
            databaseStatement.bindString(8, result);
        }
        databaseStatement.bindLong(9, asecSessionModel.getErrCount());
        databaseStatement.bindLong(10, asecSessionModel.getAddTime());
        java.lang.String params = asecSessionModel.getParams();
        if (params != null) {
            databaseStatement.bindString(11, params);
        }
        databaseStatement.bindLong(12, asecSessionModel.getCbType());
        java.lang.String fingerprintJsonFilepath = asecSessionModel.getFingerprintJsonFilepath();
        if (fingerprintJsonFilepath != null) {
            databaseStatement.bindString(13, fingerprintJsonFilepath);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = asecSessionModel.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String recordId = asecSessionModel.getRecordId();
        if (recordId != null) {
            sQLiteStatement.bindString(2, recordId);
        }
        sQLiteStatement.bindLong(3, asecSessionModel.getType());
        java.lang.String netFiles = asecSessionModel.getNetFiles();
        if (netFiles != null) {
            sQLiteStatement.bindString(4, netFiles);
        }
        java.lang.String wavPath = asecSessionModel.getWavPath();
        if (wavPath != null) {
            sQLiteStatement.bindString(5, wavPath);
        }
        sQLiteStatement.bindLong(6, asecSessionModel.getDuration());
        sQLiteStatement.bindLong(7, asecSessionModel.getState());
        java.lang.String result = asecSessionModel.getResult();
        if (result != null) {
            sQLiteStatement.bindString(8, result);
        }
        sQLiteStatement.bindLong(9, asecSessionModel.getErrCount());
        sQLiteStatement.bindLong(10, asecSessionModel.getAddTime());
        java.lang.String params = asecSessionModel.getParams();
        if (params != null) {
            sQLiteStatement.bindString(11, params);
        }
        sQLiteStatement.bindLong(12, asecSessionModel.getCbType());
        java.lang.String fingerprintJsonFilepath = asecSessionModel.getFingerprintJsonFilepath();
        if (fingerprintJsonFilepath != null) {
            sQLiteStatement.bindString(13, fingerprintJsonFilepath);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m80readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.helper.recorder.AsecSessionModel m79readEntity(android.database.Cursor cursor, int i) {
        int i2 = i + 1;
        int i3 = i + 3;
        int i4 = i + 4;
        int i5 = i + 7;
        int i6 = i + 10;
        int i7 = i + 12;
        return new com.up366.mobile.book.helper.recorder.AsecSessionModel(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.getInt(i + 2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getLong(i + 5), cursor.getInt(i + 6), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.getInt(i + 8), cursor.getLong(i + 9), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getInt(i + 11), cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel, int i) {
        asecSessionModel.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        asecSessionModel.setRecordId(cursor.isNull(i2) ? null : cursor.getString(i2));
        asecSessionModel.setType(cursor.getInt(i + 2));
        int i3 = i + 3;
        asecSessionModel.setNetFiles(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        asecSessionModel.setWavPath(cursor.isNull(i4) ? null : cursor.getString(i4));
        asecSessionModel.setDuration(cursor.getLong(i + 5));
        asecSessionModel.setState(cursor.getInt(i + 6));
        int i5 = i + 7;
        asecSessionModel.setResult(cursor.isNull(i5) ? null : cursor.getString(i5));
        asecSessionModel.setErrCount(cursor.getInt(i + 8));
        asecSessionModel.setAddTime(cursor.getLong(i + 9));
        int i6 = i + 10;
        asecSessionModel.setParams(cursor.isNull(i6) ? null : cursor.getString(i6));
        asecSessionModel.setCbType(cursor.getInt(i + 11));
        int i7 = i + 12;
        asecSessionModel.setFingerprintJsonFilepath(cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel, long j) {
        asecSessionModel.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) {
        if (asecSessionModel != null) {
            return asecSessionModel.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModel) {
        return asecSessionModel.getRowId() != null;
    }
}
