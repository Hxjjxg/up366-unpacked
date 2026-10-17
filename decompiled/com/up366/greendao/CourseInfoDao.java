package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.course.mgr.CourseInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "course_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property CourseId = new org.greenrobot.greendao.Property(1, java.lang.Integer.TYPE, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, false, "course_id");
        public static final org.greenrobot.greendao.Property CourseCode = new org.greenrobot.greendao.Property(2, java.lang.String.class, "courseCode", false, "course_code");
        public static final org.greenrobot.greendao.Property CourseName = new org.greenrobot.greendao.Property(3, java.lang.String.class, "courseName", false, "course_name");
        public static final org.greenrobot.greendao.Property IsShelf = new org.greenrobot.greendao.Property(4, java.lang.Integer.TYPE, "isShelf", false, "is_shelf");
        public static final org.greenrobot.greendao.Property OrganId = new org.greenrobot.greendao.Property(5, java.lang.Integer.TYPE, "organId", false, "organ_id");
        public static final org.greenrobot.greendao.Property StageId = new org.greenrobot.greendao.Property(6, java.lang.Integer.TYPE, "stageId", false, "stage_id");
        public static final org.greenrobot.greendao.Property SubjectId = new org.greenrobot.greendao.Property(7, java.lang.Integer.TYPE, "subjectId", false, "subject_id");
        public static final org.greenrobot.greendao.Property DisplayOrder = new org.greenrobot.greendao.Property(8, java.lang.Integer.TYPE, "displayOrder", false, "display_order");
        public static final org.greenrobot.greendao.Property IsGoods = new org.greenrobot.greendao.Property(9, java.lang.Integer.TYPE, "isGoods", false, "is_goods");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public CourseInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public CourseInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"course_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"course_id\" INTEGER NOT NULL UNIQUE ,\"course_code\" TEXT,\"course_name\" TEXT,\"is_shelf\" INTEGER NOT NULL ,\"organ_id\" INTEGER NOT NULL ,\"stage_id\" INTEGER NOT NULL ,\"subject_id\" INTEGER NOT NULL ,\"display_order\" INTEGER NOT NULL ,\"is_goods\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"course_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = courseInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        databaseStatement.bindLong(2, courseInfo.getCourseId());
        java.lang.String courseCode = courseInfo.getCourseCode();
        if (courseCode != null) {
            databaseStatement.bindString(3, courseCode);
        }
        java.lang.String courseName = courseInfo.getCourseName();
        if (courseName != null) {
            databaseStatement.bindString(4, courseName);
        }
        databaseStatement.bindLong(5, courseInfo.getIsShelf());
        databaseStatement.bindLong(6, courseInfo.getOrganId());
        databaseStatement.bindLong(7, courseInfo.getStageId());
        databaseStatement.bindLong(8, courseInfo.getSubjectId());
        databaseStatement.bindLong(9, courseInfo.getDisplayOrder());
        databaseStatement.bindLong(10, courseInfo.getIsGoods());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = courseInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        sQLiteStatement.bindLong(2, courseInfo.getCourseId());
        java.lang.String courseCode = courseInfo.getCourseCode();
        if (courseCode != null) {
            sQLiteStatement.bindString(3, courseCode);
        }
        java.lang.String courseName = courseInfo.getCourseName();
        if (courseName != null) {
            sQLiteStatement.bindString(4, courseName);
        }
        sQLiteStatement.bindLong(5, courseInfo.getIsShelf());
        sQLiteStatement.bindLong(6, courseInfo.getOrganId());
        sQLiteStatement.bindLong(7, courseInfo.getStageId());
        sQLiteStatement.bindLong(8, courseInfo.getSubjectId());
        sQLiteStatement.bindLong(9, courseInfo.getDisplayOrder());
        sQLiteStatement.bindLong(10, courseInfo.getIsGoods());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m102readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.course.mgr.CourseInfo m101readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = cursor.getInt(i + 1);
        int i3 = i + 2;
        java.lang.String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        return new com.up366.mobile.course.mgr.CourseInfo(lValueOf, i2, string, cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getInt(i + 4), cursor.getInt(i + 5), cursor.getInt(i + 6), cursor.getInt(i + 7), cursor.getInt(i + 8), cursor.getInt(i + 9));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.course.mgr.CourseInfo courseInfo, int i) {
        courseInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        courseInfo.setCourseId(cursor.getInt(i + 1));
        int i2 = i + 2;
        courseInfo.setCourseCode(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 3;
        courseInfo.setCourseName(cursor.isNull(i3) ? null : cursor.getString(i3));
        courseInfo.setIsShelf(cursor.getInt(i + 4));
        courseInfo.setOrganId(cursor.getInt(i + 5));
        courseInfo.setStageId(cursor.getInt(i + 6));
        courseInfo.setSubjectId(cursor.getInt(i + 7));
        courseInfo.setDisplayOrder(cursor.getInt(i + 8));
        courseInfo.setIsGoods(cursor.getInt(i + 9));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.course.mgr.CourseInfo courseInfo, long j) {
        courseInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        if (courseInfo != null) {
            return courseInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        return courseInfo.getRowId() != null;
    }
}
