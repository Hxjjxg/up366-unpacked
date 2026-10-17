package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskInfoV2Dao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.course.task.TaskInfoV2, java.lang.Long> {
    public static final java.lang.String TABLENAME = "task_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property JobId = new org.greenrobot.greendao.Property(1, java.lang.String.class, "jobId", false, "job_id");
        public static final org.greenrobot.greendao.Property Type = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, "type", false, "type");
        public static final org.greenrobot.greendao.Property AssignId = new org.greenrobot.greendao.Property(3, java.lang.Integer.TYPE, "assignId", false, "assign_id");
        public static final org.greenrobot.greendao.Property BeginTime = new org.greenrobot.greendao.Property(4, java.lang.Long.TYPE, "beginTime", false, "begin_time");
        public static final org.greenrobot.greendao.Property EndTime = new org.greenrobot.greendao.Property(5, java.lang.Long.TYPE, "endTime", false, "end_time");
        public static final org.greenrobot.greendao.Property JobName = new org.greenrobot.greendao.Property(6, java.lang.String.class, "jobName", false, "job_name");
        public static final org.greenrobot.greendao.Property ContentId = new org.greenrobot.greendao.Property(7, java.lang.String.class, "contentId", false, "content_id");
        public static final org.greenrobot.greendao.Property ExtParamString = new org.greenrobot.greendao.Property(8, java.lang.String.class, "extParamString", false, "ext_param");
        public static final org.greenrobot.greendao.Property IsFinish = new org.greenrobot.greendao.Property(9, java.lang.Boolean.TYPE, com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_FINISH, false, "is_finish");
        public static final org.greenrobot.greendao.Property CourseName = new org.greenrobot.greendao.Property(10, java.lang.String.class, "courseName", false, "course_name");
        public static final org.greenrobot.greendao.Property CourseId = new org.greenrobot.greendao.Property(11, java.lang.Integer.TYPE, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, false, "course_id");
        public static final org.greenrobot.greendao.Property JobComment = new org.greenrobot.greendao.Property(12, java.lang.String.class, "jobComment", false, "job_comment");
        public static final org.greenrobot.greendao.Property JobScore = new org.greenrobot.greendao.Property(13, java.lang.String.class, "jobScore", false, "job_score");
        public static final org.greenrobot.greendao.Property StudyPlanId = new org.greenrobot.greendao.Property(14, java.lang.Integer.TYPE, "studyPlanId", false, "study_plan_id");
        public static final org.greenrobot.greendao.Property AriseTime = new org.greenrobot.greendao.Property(15, java.lang.Long.TYPE, "ariseTime", false, "arise_time");
        public static final org.greenrobot.greendao.Property AriseType = new org.greenrobot.greendao.Property(16, java.lang.Integer.TYPE, "ariseType", false, "arise_type");
        public static final org.greenrobot.greendao.Property DisplayOrder = new org.greenrobot.greendao.Property(17, java.lang.Integer.TYPE, "displayOrder", false, "display_order");
        public static final org.greenrobot.greendao.Property SubmitTime = new org.greenrobot.greendao.Property(18, java.lang.Long.TYPE, "submitTime", false, "submit_time");
        public static final org.greenrobot.greendao.Property Flevel = new org.greenrobot.greendao.Property(19, java.lang.Integer.TYPE, "flevel", false, "flevel");
        public static final org.greenrobot.greendao.Property StudyTaskPid = new org.greenrobot.greendao.Property(20, java.lang.String.class, "studyTaskPid", false, "study_task_pid");
        public static final org.greenrobot.greendao.Property Statement = new org.greenrobot.greendao.Property(21, java.lang.String.class, "statement", false, "statement");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public TaskInfoV2Dao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public TaskInfoV2Dao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"task_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"job_id\" TEXT,\"type\" INTEGER NOT NULL ,\"assign_id\" INTEGER NOT NULL ,\"begin_time\" INTEGER NOT NULL ,\"end_time\" INTEGER NOT NULL ,\"job_name\" TEXT,\"content_id\" TEXT,\"ext_param\" TEXT,\"is_finish\" INTEGER NOT NULL ,\"course_name\" TEXT,\"course_id\" INTEGER NOT NULL ,\"job_comment\" TEXT,\"job_score\" TEXT,\"study_plan_id\" INTEGER NOT NULL ,\"arise_time\" INTEGER NOT NULL ,\"arise_type\" INTEGER NOT NULL ,\"display_order\" INTEGER NOT NULL ,\"submit_time\" INTEGER NOT NULL ,\"flevel\" INTEGER NOT NULL ,\"study_task_pid\" TEXT,\"statement\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_task_info_job_id ON \"task_info\" (\"job_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"task_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = taskInfoV2.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String jobId = taskInfoV2.getJobId();
        if (jobId != null) {
            databaseStatement.bindString(2, jobId);
        }
        databaseStatement.bindLong(3, taskInfoV2.getType());
        databaseStatement.bindLong(4, taskInfoV2.getAssignId());
        databaseStatement.bindLong(5, taskInfoV2.getBeginTime());
        databaseStatement.bindLong(6, taskInfoV2.getEndTime());
        java.lang.String jobName = taskInfoV2.getJobName();
        if (jobName != null) {
            databaseStatement.bindString(7, jobName);
        }
        java.lang.String contentId = taskInfoV2.getContentId();
        if (contentId != null) {
            databaseStatement.bindString(8, contentId);
        }
        java.lang.String extParamString = taskInfoV2.getExtParamString();
        if (extParamString != null) {
            databaseStatement.bindString(9, extParamString);
        }
        databaseStatement.bindLong(10, taskInfoV2.getIsFinish() ? 1L : 0L);
        java.lang.String courseName = taskInfoV2.getCourseName();
        if (courseName != null) {
            databaseStatement.bindString(11, courseName);
        }
        databaseStatement.bindLong(12, taskInfoV2.getCourseId());
        java.lang.String jobComment = taskInfoV2.getJobComment();
        if (jobComment != null) {
            databaseStatement.bindString(13, jobComment);
        }
        java.lang.String jobScore = taskInfoV2.getJobScore();
        if (jobScore != null) {
            databaseStatement.bindString(14, jobScore);
        }
        databaseStatement.bindLong(15, taskInfoV2.getStudyPlanId());
        databaseStatement.bindLong(16, taskInfoV2.getAriseTime());
        databaseStatement.bindLong(17, taskInfoV2.getAriseType());
        databaseStatement.bindLong(18, taskInfoV2.getDisplayOrder());
        databaseStatement.bindLong(19, taskInfoV2.getSubmitTime());
        databaseStatement.bindLong(20, taskInfoV2.getFlevel());
        java.lang.String studyTaskPid = taskInfoV2.getStudyTaskPid();
        if (studyTaskPid != null) {
            databaseStatement.bindString(21, studyTaskPid);
        }
        java.lang.String statement = taskInfoV2.getStatement();
        if (statement != null) {
            databaseStatement.bindString(22, statement);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = taskInfoV2.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String jobId = taskInfoV2.getJobId();
        if (jobId != null) {
            sQLiteStatement.bindString(2, jobId);
        }
        sQLiteStatement.bindLong(3, taskInfoV2.getType());
        sQLiteStatement.bindLong(4, taskInfoV2.getAssignId());
        sQLiteStatement.bindLong(5, taskInfoV2.getBeginTime());
        sQLiteStatement.bindLong(6, taskInfoV2.getEndTime());
        java.lang.String jobName = taskInfoV2.getJobName();
        if (jobName != null) {
            sQLiteStatement.bindString(7, jobName);
        }
        java.lang.String contentId = taskInfoV2.getContentId();
        if (contentId != null) {
            sQLiteStatement.bindString(8, contentId);
        }
        java.lang.String extParamString = taskInfoV2.getExtParamString();
        if (extParamString != null) {
            sQLiteStatement.bindString(9, extParamString);
        }
        sQLiteStatement.bindLong(10, taskInfoV2.getIsFinish() ? 1L : 0L);
        java.lang.String courseName = taskInfoV2.getCourseName();
        if (courseName != null) {
            sQLiteStatement.bindString(11, courseName);
        }
        sQLiteStatement.bindLong(12, taskInfoV2.getCourseId());
        java.lang.String jobComment = taskInfoV2.getJobComment();
        if (jobComment != null) {
            sQLiteStatement.bindString(13, jobComment);
        }
        java.lang.String jobScore = taskInfoV2.getJobScore();
        if (jobScore != null) {
            sQLiteStatement.bindString(14, jobScore);
        }
        sQLiteStatement.bindLong(15, taskInfoV2.getStudyPlanId());
        sQLiteStatement.bindLong(16, taskInfoV2.getAriseTime());
        sQLiteStatement.bindLong(17, taskInfoV2.getAriseType());
        sQLiteStatement.bindLong(18, taskInfoV2.getDisplayOrder());
        sQLiteStatement.bindLong(19, taskInfoV2.getSubmitTime());
        sQLiteStatement.bindLong(20, taskInfoV2.getFlevel());
        java.lang.String studyTaskPid = taskInfoV2.getStudyTaskPid();
        if (studyTaskPid != null) {
            sQLiteStatement.bindString(21, studyTaskPid);
        }
        java.lang.String statement = taskInfoV2.getStatement();
        if (statement != null) {
            sQLiteStatement.bindString(22, statement);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m130readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.course.task.TaskInfoV2 m129readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = cursor.getInt(i + 2);
        int i4 = cursor.getInt(i + 3);
        long j = cursor.getLong(i + 4);
        long j2 = cursor.getLong(i + 5);
        int i5 = i + 6;
        java.lang.String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 7;
        java.lang.String string3 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 8;
        java.lang.String string4 = cursor.isNull(i7) ? null : cursor.getString(i7);
        boolean z = cursor.getShort(i + 9) != 0;
        int i8 = i + 10;
        java.lang.String string5 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = cursor.getInt(i + 11);
        int i10 = i + 12;
        java.lang.String string6 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 13;
        java.lang.String string7 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = cursor.getInt(i + 14);
        long j3 = cursor.getLong(i + 15);
        int i13 = cursor.getInt(i + 16);
        int i14 = cursor.getInt(i + 17);
        long j4 = cursor.getLong(i + 18);
        int i15 = cursor.getInt(i + 19);
        int i16 = i + 20;
        java.lang.String string8 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 21;
        return new com.up366.mobile.course.task.TaskInfoV2(lValueOf, string, i3, i4, j, j2, string2, string3, string4, z, string5, i9, string6, string7, i12, j3, i13, i14, j4, i15, string8, cursor.isNull(i17) ? null : cursor.getString(i17));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, int i) {
        taskInfoV2.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        taskInfoV2.setJobId(cursor.isNull(i2) ? null : cursor.getString(i2));
        taskInfoV2.setType(cursor.getInt(i + 2));
        taskInfoV2.setAssignId(cursor.getInt(i + 3));
        taskInfoV2.setBeginTime(cursor.getLong(i + 4));
        taskInfoV2.setEndTime(cursor.getLong(i + 5));
        int i3 = i + 6;
        taskInfoV2.setJobName(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 7;
        taskInfoV2.setContentId(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 8;
        taskInfoV2.setExtParamString(cursor.isNull(i5) ? null : cursor.getString(i5));
        taskInfoV2.setIsFinish(cursor.getShort(i + 9) != 0);
        int i6 = i + 10;
        taskInfoV2.setCourseName(cursor.isNull(i6) ? null : cursor.getString(i6));
        taskInfoV2.setCourseId(cursor.getInt(i + 11));
        int i7 = i + 12;
        taskInfoV2.setJobComment(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 13;
        taskInfoV2.setJobScore(cursor.isNull(i8) ? null : cursor.getString(i8));
        taskInfoV2.setStudyPlanId(cursor.getInt(i + 14));
        taskInfoV2.setAriseTime(cursor.getLong(i + 15));
        taskInfoV2.setAriseType(cursor.getInt(i + 16));
        taskInfoV2.setDisplayOrder(cursor.getInt(i + 17));
        taskInfoV2.setSubmitTime(cursor.getLong(i + 18));
        taskInfoV2.setFlevel(cursor.getInt(i + 19));
        int i9 = i + 20;
        taskInfoV2.setStudyTaskPid(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 21;
        taskInfoV2.setStatement(cursor.isNull(i10) ? null : cursor.getString(i10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, long j) {
        taskInfoV2.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        if (taskInfoV2 != null) {
            return taskInfoV2.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        return taskInfoV2.getRowId() != null;
    }
}
