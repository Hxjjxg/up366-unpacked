package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeTeachingClassDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.user.setting.MeTeachingClass, java.lang.Long> {
    public static final java.lang.String TABLENAME = "teaching_class";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property CourseId = new org.greenrobot.greendao.Property(1, java.lang.Integer.TYPE, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, false, "course_id");
        public static final org.greenrobot.greendao.Property CourseName = new org.greenrobot.greendao.Property(2, java.lang.String.class, "courseName", false, "course_name");
        public static final org.greenrobot.greendao.Property LecturerName = new org.greenrobot.greendao.Property(3, java.lang.String.class, "lecturerName", false, "lecturer_name");
        public static final org.greenrobot.greendao.Property Status = new org.greenrobot.greendao.Property(4, java.lang.Integer.TYPE, "status", false, "status");
        public static final org.greenrobot.greendao.Property CreateTime = new org.greenrobot.greendao.Property(5, java.lang.Long.TYPE, "createTime", false, "create_time");
        public static final org.greenrobot.greendao.Property EndTime = new org.greenrobot.greendao.Property(6, java.lang.Long.TYPE, "endTime", false, "end_time");
        public static final org.greenrobot.greendao.Property JoinTime = new org.greenrobot.greendao.Property(7, java.lang.Long.TYPE, "joinTime", false, "join_time");
        public static final org.greenrobot.greendao.Property CourseCode = new org.greenrobot.greendao.Property(8, java.lang.String.class, "courseCode", false, "course_code");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public MeTeachingClassDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public MeTeachingClassDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"teaching_class\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"course_id\" INTEGER NOT NULL ,\"course_name\" TEXT,\"lecturer_name\" TEXT,\"status\" INTEGER NOT NULL ,\"create_time\" INTEGER NOT NULL ,\"end_time\" INTEGER NOT NULL ,\"join_time\" INTEGER NOT NULL ,\"course_code\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_teaching_class_course_id ON \"teaching_class\" (\"course_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"teaching_class\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.user.setting.MeTeachingClass meTeachingClass) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = meTeachingClass.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        databaseStatement.bindLong(2, meTeachingClass.getCourseId());
        java.lang.String courseName = meTeachingClass.getCourseName();
        if (courseName != null) {
            databaseStatement.bindString(3, courseName);
        }
        java.lang.String lecturerName = meTeachingClass.getLecturerName();
        if (lecturerName != null) {
            databaseStatement.bindString(4, lecturerName);
        }
        databaseStatement.bindLong(5, meTeachingClass.getStatus());
        databaseStatement.bindLong(6, meTeachingClass.getCreateTime());
        databaseStatement.bindLong(7, meTeachingClass.getEndTime());
        databaseStatement.bindLong(8, meTeachingClass.getJoinTime());
        java.lang.String courseCode = meTeachingClass.getCourseCode();
        if (courseCode != null) {
            databaseStatement.bindString(9, courseCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.user.setting.MeTeachingClass meTeachingClass) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = meTeachingClass.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        sQLiteStatement.bindLong(2, meTeachingClass.getCourseId());
        java.lang.String courseName = meTeachingClass.getCourseName();
        if (courseName != null) {
            sQLiteStatement.bindString(3, courseName);
        }
        java.lang.String lecturerName = meTeachingClass.getLecturerName();
        if (lecturerName != null) {
            sQLiteStatement.bindString(4, lecturerName);
        }
        sQLiteStatement.bindLong(5, meTeachingClass.getStatus());
        sQLiteStatement.bindLong(6, meTeachingClass.getCreateTime());
        sQLiteStatement.bindLong(7, meTeachingClass.getEndTime());
        sQLiteStatement.bindLong(8, meTeachingClass.getJoinTime());
        java.lang.String courseCode = meTeachingClass.getCourseCode();
        if (courseCode != null) {
            sQLiteStatement.bindString(9, courseCode);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m112readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.user.setting.MeTeachingClass m111readEntity(android.database.Cursor cursor, int i) {
        int i2 = i + 2;
        int i3 = i + 3;
        int i4 = i + 8;
        return new com.up366.mobile.user.setting.MeTeachingClass(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)), cursor.getInt(i + 1), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.getInt(i + 4), cursor.getLong(i + 5), cursor.getLong(i + 6), cursor.getLong(i + 7), cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.user.setting.MeTeachingClass meTeachingClass, int i) {
        meTeachingClass.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        meTeachingClass.setCourseId(cursor.getInt(i + 1));
        int i2 = i + 2;
        meTeachingClass.setCourseName(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 3;
        meTeachingClass.setLecturerName(cursor.isNull(i3) ? null : cursor.getString(i3));
        meTeachingClass.setStatus(cursor.getInt(i + 4));
        meTeachingClass.setCreateTime(cursor.getLong(i + 5));
        meTeachingClass.setEndTime(cursor.getLong(i + 6));
        meTeachingClass.setJoinTime(cursor.getLong(i + 7));
        int i4 = i + 8;
        meTeachingClass.setCourseCode(cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.user.setting.MeTeachingClass meTeachingClass, long j) {
        meTeachingClass.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.user.setting.MeTeachingClass meTeachingClass) {
        if (meTeachingClass != null) {
            return meTeachingClass.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.user.setting.MeTeachingClass meTeachingClass) {
        return meTeachingClass.getRowId() != null;
    }
}
