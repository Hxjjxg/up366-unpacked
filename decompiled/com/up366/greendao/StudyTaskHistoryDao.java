package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyTaskHistoryDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.StudyTaskHistory, java.lang.Long> {
    public static final java.lang.String TABLENAME = "study_task_history";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Guid = new org.greenrobot.greendao.Property(1, java.lang.String.class, "guid", false, "guid");
        public static final org.greenrobot.greendao.Property TaskId = new org.greenrobot.greendao.Property(2, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, false, "task_id");
        public static final org.greenrobot.greendao.Property InsertTime = new org.greenrobot.greendao.Property(3, java.lang.Long.TYPE, "insertTime", false, "insert_time");
        public static final org.greenrobot.greendao.Property Score = new org.greenrobot.greendao.Property(4, java.lang.Float.TYPE, "score", false, "score");
        public static final org.greenrobot.greendao.Property StudyTaskId = new org.greenrobot.greendao.Property(5, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, false, "study_task_id");
        public static final org.greenrobot.greendao.Property KillBy = new org.greenrobot.greendao.Property(6, java.lang.Integer.TYPE, "killBy", false, "kill_by");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public StudyTaskHistoryDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public StudyTaskHistoryDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"study_task_history\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"guid\" TEXT,\"task_id\" TEXT,\"insert_time\" INTEGER NOT NULL ,\"score\" REAL NOT NULL ,\"study_task_id\" TEXT,\"kill_by\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_study_task_history_guid ON \"study_task_history\" (\"guid\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"study_task_history\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = studyTaskHistory.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = studyTaskHistory.getGuid();
        if (guid != null) {
            databaseStatement.bindString(2, guid);
        }
        java.lang.String taskId = studyTaskHistory.getTaskId();
        if (taskId != null) {
            databaseStatement.bindString(3, taskId);
        }
        databaseStatement.bindLong(4, studyTaskHistory.getInsertTime());
        databaseStatement.bindDouble(5, studyTaskHistory.getScore());
        java.lang.String studyTaskId = studyTaskHistory.getStudyTaskId();
        if (studyTaskId != null) {
            databaseStatement.bindString(6, studyTaskId);
        }
        databaseStatement.bindLong(7, studyTaskHistory.getKillBy());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = studyTaskHistory.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = studyTaskHistory.getGuid();
        if (guid != null) {
            sQLiteStatement.bindString(2, guid);
        }
        java.lang.String taskId = studyTaskHistory.getTaskId();
        if (taskId != null) {
            sQLiteStatement.bindString(3, taskId);
        }
        sQLiteStatement.bindLong(4, studyTaskHistory.getInsertTime());
        sQLiteStatement.bindDouble(5, studyTaskHistory.getScore());
        java.lang.String studyTaskId = studyTaskHistory.getStudyTaskId();
        if (studyTaskId != null) {
            sQLiteStatement.bindString(6, studyTaskId);
        }
        sQLiteStatement.bindLong(7, studyTaskHistory.getKillBy());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m126readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.StudyTaskHistory m125readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 5;
        return new com.up366.mobile.book.model.StudyTaskHistory(lValueOf, string, string2, cursor.getLong(i + 3), cursor.getFloat(i + 4), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getInt(i + 6));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory, int i) {
        studyTaskHistory.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        studyTaskHistory.setGuid(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        studyTaskHistory.setTaskId(cursor.isNull(i3) ? null : cursor.getString(i3));
        studyTaskHistory.setInsertTime(cursor.getLong(i + 3));
        studyTaskHistory.setScore(cursor.getFloat(i + 4));
        int i4 = i + 5;
        studyTaskHistory.setStudyTaskId(cursor.isNull(i4) ? null : cursor.getString(i4));
        studyTaskHistory.setKillBy(cursor.getInt(i + 6));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory, long j) {
        studyTaskHistory.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory) {
        if (studyTaskHistory != null) {
            return studyTaskHistory.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory) {
        return studyTaskHistory.getRowId() != null;
    }
}
