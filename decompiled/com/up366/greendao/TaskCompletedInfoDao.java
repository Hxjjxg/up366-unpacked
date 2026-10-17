package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskCompletedInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.course.task.model.TaskCompletedInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "task_completed_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Uid = new org.greenrobot.greendao.Property(1, java.lang.Integer.TYPE, "uid", false, "uid");
        public static final org.greenrobot.greendao.Property CourseId = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, false, "course_id");
        public static final org.greenrobot.greendao.Property StudyTaskId = new org.greenrobot.greendao.Property(3, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, false, "study_task_id");
        public static final org.greenrobot.greendao.Property StudyTaskPid = new org.greenrobot.greendao.Property(4, java.lang.String.class, "studyTaskPid", false, "study_task_pid");
        public static final org.greenrobot.greendao.Property Score = new org.greenrobot.greendao.Property(5, java.lang.Float.TYPE, "score", false, "score");
        public static final org.greenrobot.greendao.Property JobScore = new org.greenrobot.greendao.Property(6, java.lang.String.class, "jobScore", false, "job_score");
        public static final org.greenrobot.greendao.Property AddDate = new org.greenrobot.greendao.Property(7, java.lang.Long.TYPE, "addDate", false, "add_date");
        public static final org.greenrobot.greendao.Property MarkStatus = new org.greenrobot.greendao.Property(8, java.lang.Integer.TYPE, "markStatus", false, "mark_status");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public TaskCompletedInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public TaskCompletedInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"task_completed_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"uid\" INTEGER NOT NULL ,\"course_id\" INTEGER NOT NULL ,\"study_task_id\" TEXT,\"study_task_pid\" TEXT,\"score\" REAL NOT NULL ,\"job_score\" TEXT,\"add_date\" INTEGER NOT NULL ,\"mark_status\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_task_completed_info_study_task_id ON \"task_completed_info\" (\"study_task_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"task_completed_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = taskCompletedInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        databaseStatement.bindLong(2, taskCompletedInfo.getUid());
        databaseStatement.bindLong(3, taskCompletedInfo.getCourseId());
        java.lang.String studyTaskId = taskCompletedInfo.getStudyTaskId();
        if (studyTaskId != null) {
            databaseStatement.bindString(4, studyTaskId);
        }
        java.lang.String studyTaskPid = taskCompletedInfo.getStudyTaskPid();
        if (studyTaskPid != null) {
            databaseStatement.bindString(5, studyTaskPid);
        }
        databaseStatement.bindDouble(6, taskCompletedInfo.getScore());
        java.lang.String jobScore = taskCompletedInfo.getJobScore();
        if (jobScore != null) {
            databaseStatement.bindString(7, jobScore);
        }
        databaseStatement.bindLong(8, taskCompletedInfo.getAddDate());
        databaseStatement.bindLong(9, taskCompletedInfo.getMarkStatus());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = taskCompletedInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        sQLiteStatement.bindLong(2, taskCompletedInfo.getUid());
        sQLiteStatement.bindLong(3, taskCompletedInfo.getCourseId());
        java.lang.String studyTaskId = taskCompletedInfo.getStudyTaskId();
        if (studyTaskId != null) {
            sQLiteStatement.bindString(4, studyTaskId);
        }
        java.lang.String studyTaskPid = taskCompletedInfo.getStudyTaskPid();
        if (studyTaskPid != null) {
            sQLiteStatement.bindString(5, studyTaskPid);
        }
        sQLiteStatement.bindDouble(6, taskCompletedInfo.getScore());
        java.lang.String jobScore = taskCompletedInfo.getJobScore();
        if (jobScore != null) {
            sQLiteStatement.bindString(7, jobScore);
        }
        sQLiteStatement.bindLong(8, taskCompletedInfo.getAddDate());
        sQLiteStatement.bindLong(9, taskCompletedInfo.getMarkStatus());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m128readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.course.task.model.TaskCompletedInfo m127readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = cursor.getInt(i + 1);
        int i3 = cursor.getInt(i + 2);
        int i4 = i + 3;
        java.lang.String string = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        java.lang.String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 6;
        return new com.up366.mobile.course.task.model.TaskCompletedInfo(lValueOf, i2, i3, string, string2, cursor.getFloat(i + 5), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getLong(i + 7), cursor.getInt(i + 8));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo, int i) {
        taskCompletedInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        taskCompletedInfo.setUid(cursor.getInt(i + 1));
        taskCompletedInfo.setCourseId(cursor.getInt(i + 2));
        int i2 = i + 3;
        taskCompletedInfo.setStudyTaskId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 4;
        taskCompletedInfo.setStudyTaskPid(cursor.isNull(i3) ? null : cursor.getString(i3));
        taskCompletedInfo.setScore(cursor.getFloat(i + 5));
        int i4 = i + 6;
        taskCompletedInfo.setJobScore(cursor.isNull(i4) ? null : cursor.getString(i4));
        taskCompletedInfo.setAddDate(cursor.getLong(i + 7));
        taskCompletedInfo.setMarkStatus(cursor.getInt(i + 8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo, long j) {
        taskCompletedInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo) {
        if (taskCompletedInfo != null) {
            return taskCompletedInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo) {
        return taskCompletedInfo.getRowId() != null;
    }
}
