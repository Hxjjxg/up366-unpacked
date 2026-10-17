package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BatchUploadLogDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.common.logic.log.model.BatchUploadLog, java.lang.Long> {
    public static final java.lang.String TABLENAME = "batch_upload_log";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property BatchId = new org.greenrobot.greendao.Property(1, java.lang.String.class, "batchId", false, "batch_id");
        public static final org.greenrobot.greendao.Property RefKey = new org.greenrobot.greendao.Property(2, java.lang.String.class, "refKey", false, "ref_key");
        public static final org.greenrobot.greendao.Property Type = new org.greenrobot.greendao.Property(3, java.lang.Integer.TYPE, "type", false, "type");
        public static final org.greenrobot.greendao.Property State = new org.greenrobot.greendao.Property(4, java.lang.Integer.TYPE, "state", false, "state");
        public static final org.greenrobot.greendao.Property AddTime = new org.greenrobot.greendao.Property(5, java.lang.Long.TYPE, "addTime", false, "add_time");
        public static final org.greenrobot.greendao.Property UpdateTime = new org.greenrobot.greendao.Property(6, java.lang.Long.TYPE, com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_UPDATE_TIME, false, "update_time");
        public static final org.greenrobot.greendao.Property TryCount = new org.greenrobot.greendao.Property(7, java.lang.Integer.TYPE, "tryCount", false, "try_count");
        public static final org.greenrobot.greendao.Property ErrCode = new org.greenrobot.greendao.Property(8, java.lang.Integer.TYPE, "errCode", false, "err_code");
        public static final org.greenrobot.greendao.Property ErrInfo = new org.greenrobot.greendao.Property(9, java.lang.String.class, "errInfo", false, "err_info");
        public static final org.greenrobot.greendao.Property ErrHistory = new org.greenrobot.greendao.Property(10, java.lang.String.class, "errHistory", false, "err_history");
        public static final org.greenrobot.greendao.Property TaskCount = new org.greenrobot.greendao.Property(11, java.lang.Integer.TYPE, "taskCount", false, "task_count");
        public static final org.greenrobot.greendao.Property UploadTaskCount = new org.greenrobot.greendao.Property(12, java.lang.Integer.TYPE, "uploadTaskCount", false, "upload_task_count");
        public static final org.greenrobot.greendao.Property TotalFileSize = new org.greenrobot.greendao.Property(13, java.lang.Long.TYPE, "totalFileSize", false, "total_file_size");
        public static final org.greenrobot.greendao.Property UploadFileSize = new org.greenrobot.greendao.Property(14, java.lang.Long.TYPE, "uploadFileSize", false, "upload_file_size");
        public static final org.greenrobot.greendao.Property Params = new org.greenrobot.greendao.Property(15, java.lang.String.class, "params", false, "params");
        public static final org.greenrobot.greendao.Property Priority = new org.greenrobot.greendao.Property(16, java.lang.Integer.TYPE, "priority", false, "priority");
        public static final org.greenrobot.greendao.Property TaskId = new org.greenrobot.greendao.Property(17, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, false, "task_id");
        public static final org.greenrobot.greendao.Property StudyTaskId = new org.greenrobot.greendao.Property(18, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, false, "study_task_id");
        public static final org.greenrobot.greendao.Property OpLogId = new org.greenrobot.greendao.Property(19, java.lang.String.class, "opLogId", false, "op_log_id");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public BatchUploadLogDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BatchUploadLogDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"batch_upload_log\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"batch_id\" TEXT,\"ref_key\" TEXT,\"type\" INTEGER NOT NULL ,\"state\" INTEGER NOT NULL ,\"add_time\" INTEGER NOT NULL ,\"update_time\" INTEGER NOT NULL ,\"try_count\" INTEGER NOT NULL ,\"err_code\" INTEGER NOT NULL ,\"err_info\" TEXT,\"err_history\" TEXT,\"task_count\" INTEGER NOT NULL ,\"upload_task_count\" INTEGER NOT NULL ,\"total_file_size\" INTEGER NOT NULL ,\"upload_file_size\" INTEGER NOT NULL ,\"params\" TEXT,\"priority\" INTEGER NOT NULL ,\"task_id\" TEXT,\"study_task_id\" TEXT,\"op_log_id\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_batch_upload_log_batch_id ON \"batch_upload_log\" (\"batch_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"batch_upload_log\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = batchUploadLog.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String batchId = batchUploadLog.getBatchId();
        if (batchId != null) {
            databaseStatement.bindString(2, batchId);
        }
        java.lang.String refKey = batchUploadLog.getRefKey();
        if (refKey != null) {
            databaseStatement.bindString(3, refKey);
        }
        databaseStatement.bindLong(4, batchUploadLog.getType());
        databaseStatement.bindLong(5, batchUploadLog.getState());
        databaseStatement.bindLong(6, batchUploadLog.getAddTime());
        databaseStatement.bindLong(7, batchUploadLog.getUpdateTime());
        databaseStatement.bindLong(8, batchUploadLog.getTryCount());
        databaseStatement.bindLong(9, batchUploadLog.getErrCode());
        java.lang.String errInfo = batchUploadLog.getErrInfo();
        if (errInfo != null) {
            databaseStatement.bindString(10, errInfo);
        }
        java.lang.String errHistory = batchUploadLog.getErrHistory();
        if (errHistory != null) {
            databaseStatement.bindString(11, errHistory);
        }
        databaseStatement.bindLong(12, batchUploadLog.getTaskCount());
        databaseStatement.bindLong(13, batchUploadLog.getUploadTaskCount());
        databaseStatement.bindLong(14, batchUploadLog.getTotalFileSize());
        databaseStatement.bindLong(15, batchUploadLog.getUploadFileSize());
        java.lang.String params = batchUploadLog.getParams();
        if (params != null) {
            databaseStatement.bindString(16, params);
        }
        databaseStatement.bindLong(17, batchUploadLog.getPriority());
        java.lang.String taskId = batchUploadLog.getTaskId();
        if (taskId != null) {
            databaseStatement.bindString(18, taskId);
        }
        java.lang.String studyTaskId = batchUploadLog.getStudyTaskId();
        if (studyTaskId != null) {
            databaseStatement.bindString(19, studyTaskId);
        }
        java.lang.String opLogId = batchUploadLog.getOpLogId();
        if (opLogId != null) {
            databaseStatement.bindString(20, opLogId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = batchUploadLog.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String batchId = batchUploadLog.getBatchId();
        if (batchId != null) {
            sQLiteStatement.bindString(2, batchId);
        }
        java.lang.String refKey = batchUploadLog.getRefKey();
        if (refKey != null) {
            sQLiteStatement.bindString(3, refKey);
        }
        sQLiteStatement.bindLong(4, batchUploadLog.getType());
        sQLiteStatement.bindLong(5, batchUploadLog.getState());
        sQLiteStatement.bindLong(6, batchUploadLog.getAddTime());
        sQLiteStatement.bindLong(7, batchUploadLog.getUpdateTime());
        sQLiteStatement.bindLong(8, batchUploadLog.getTryCount());
        sQLiteStatement.bindLong(9, batchUploadLog.getErrCode());
        java.lang.String errInfo = batchUploadLog.getErrInfo();
        if (errInfo != null) {
            sQLiteStatement.bindString(10, errInfo);
        }
        java.lang.String errHistory = batchUploadLog.getErrHistory();
        if (errHistory != null) {
            sQLiteStatement.bindString(11, errHistory);
        }
        sQLiteStatement.bindLong(12, batchUploadLog.getTaskCount());
        sQLiteStatement.bindLong(13, batchUploadLog.getUploadTaskCount());
        sQLiteStatement.bindLong(14, batchUploadLog.getTotalFileSize());
        sQLiteStatement.bindLong(15, batchUploadLog.getUploadFileSize());
        java.lang.String params = batchUploadLog.getParams();
        if (params != null) {
            sQLiteStatement.bindString(16, params);
        }
        sQLiteStatement.bindLong(17, batchUploadLog.getPriority());
        java.lang.String taskId = batchUploadLog.getTaskId();
        if (taskId != null) {
            sQLiteStatement.bindString(18, taskId);
        }
        java.lang.String studyTaskId = batchUploadLog.getStudyTaskId();
        if (studyTaskId != null) {
            sQLiteStatement.bindString(19, studyTaskId);
        }
        java.lang.String opLogId = batchUploadLog.getOpLogId();
        if (opLogId != null) {
            sQLiteStatement.bindString(20, opLogId);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m84readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.common.logic.log.model.BatchUploadLog m83readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = cursor.getInt(i + 3);
        int i5 = cursor.getInt(i + 4);
        long j = cursor.getLong(i + 5);
        long j2 = cursor.getLong(i + 6);
        int i6 = cursor.getInt(i + 7);
        int i7 = cursor.getInt(i + 8);
        int i8 = i + 9;
        java.lang.String string3 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 10;
        java.lang.String string4 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = cursor.getInt(i + 11);
        int i11 = cursor.getInt(i + 12);
        long j3 = cursor.getLong(i + 13);
        long j4 = cursor.getLong(i + 14);
        int i12 = i + 15;
        java.lang.String string5 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = cursor.getInt(i + 16);
        int i14 = i + 17;
        java.lang.String string6 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 18;
        java.lang.String string7 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 19;
        return new com.up366.mobile.common.logic.log.model.BatchUploadLog(lValueOf, string, string2, i4, i5, j, j2, i6, i7, string3, string4, i10, i11, j3, j4, string5, i13, string6, string7, cursor.isNull(i16) ? null : cursor.getString(i16));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, int i) {
        batchUploadLog.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        batchUploadLog.setBatchId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        batchUploadLog.setRefKey(cursor.isNull(i3) ? null : cursor.getString(i3));
        batchUploadLog.setType(cursor.getInt(i + 3));
        batchUploadLog.setState(cursor.getInt(i + 4));
        batchUploadLog.setAddTime(cursor.getLong(i + 5));
        batchUploadLog.setUpdateTime(cursor.getLong(i + 6));
        batchUploadLog.setTryCount(cursor.getInt(i + 7));
        batchUploadLog.setErrCode(cursor.getInt(i + 8));
        int i4 = i + 9;
        batchUploadLog.setErrInfo(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 10;
        batchUploadLog.setErrHistory(cursor.isNull(i5) ? null : cursor.getString(i5));
        batchUploadLog.setTaskCount(cursor.getInt(i + 11));
        batchUploadLog.setUploadTaskCount(cursor.getInt(i + 12));
        batchUploadLog.setTotalFileSize(cursor.getLong(i + 13));
        batchUploadLog.setUploadFileSize(cursor.getLong(i + 14));
        int i6 = i + 15;
        batchUploadLog.setParams(cursor.isNull(i6) ? null : cursor.getString(i6));
        batchUploadLog.setPriority(cursor.getInt(i + 16));
        int i7 = i + 17;
        batchUploadLog.setTaskId(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 18;
        batchUploadLog.setStudyTaskId(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 19;
        batchUploadLog.setOpLogId(cursor.isNull(i9) ? null : cursor.getString(i9));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, long j) {
        batchUploadLog.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        if (batchUploadLog != null) {
            return batchUploadLog.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        return batchUploadLog.getRowId() != null;
    }
}
