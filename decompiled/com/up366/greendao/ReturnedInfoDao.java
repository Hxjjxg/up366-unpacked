package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ReturnedInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.course.task.model.ReturnedInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "returned_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Uid = new org.greenrobot.greendao.Property(1, java.lang.Integer.TYPE, "uid", false, "uid");
        public static final org.greenrobot.greendao.Property StudyTaskId = new org.greenrobot.greendao.Property(2, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, false, "study_task_id");
        public static final org.greenrobot.greendao.Property CourseId = new org.greenrobot.greendao.Property(3, java.lang.Integer.TYPE, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, false, "course_id");
        public static final org.greenrobot.greendao.Property ReturnCode = new org.greenrobot.greendao.Property(4, java.lang.String.class, "returnCode", false, "return_code");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public ReturnedInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public ReturnedInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"returned_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"uid\" INTEGER NOT NULL ,\"study_task_id\" TEXT,\"course_id\" INTEGER NOT NULL ,\"return_code\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_returned_info_study_task_id ON \"returned_info\" (\"study_task_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"returned_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.course.task.model.ReturnedInfo returnedInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = returnedInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        databaseStatement.bindLong(2, returnedInfo.getUid());
        java.lang.String studyTaskId = returnedInfo.getStudyTaskId();
        if (studyTaskId != null) {
            databaseStatement.bindString(3, studyTaskId);
        }
        databaseStatement.bindLong(4, returnedInfo.getCourseId());
        java.lang.String returnCode = returnedInfo.getReturnCode();
        if (returnCode != null) {
            databaseStatement.bindString(5, returnCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.course.task.model.ReturnedInfo returnedInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = returnedInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        sQLiteStatement.bindLong(2, returnedInfo.getUid());
        java.lang.String studyTaskId = returnedInfo.getStudyTaskId();
        if (studyTaskId != null) {
            sQLiteStatement.bindString(3, studyTaskId);
        }
        sQLiteStatement.bindLong(4, returnedInfo.getCourseId());
        java.lang.String returnCode = returnedInfo.getReturnCode();
        if (returnCode != null) {
            sQLiteStatement.bindString(5, returnCode);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m120readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.course.task.model.ReturnedInfo m119readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = cursor.getInt(i + 1);
        int i3 = i + 2;
        java.lang.String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = cursor.getInt(i + 3);
        int i5 = i + 4;
        return new com.up366.mobile.course.task.model.ReturnedInfo(lValueOf, i2, string, i4, cursor.isNull(i5) ? null : cursor.getString(i5));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.course.task.model.ReturnedInfo returnedInfo, int i) {
        returnedInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        returnedInfo.setUid(cursor.getInt(i + 1));
        int i2 = i + 2;
        returnedInfo.setStudyTaskId(cursor.isNull(i2) ? null : cursor.getString(i2));
        returnedInfo.setCourseId(cursor.getInt(i + 3));
        int i3 = i + 4;
        returnedInfo.setReturnCode(cursor.isNull(i3) ? null : cursor.getString(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.course.task.model.ReturnedInfo returnedInfo, long j) {
        returnedInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.course.task.model.ReturnedInfo returnedInfo) {
        if (returnedInfo != null) {
            return returnedInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.course.task.model.ReturnedInfo returnedInfo) {
        return returnedInfo.getRowId() != null;
    }
}
