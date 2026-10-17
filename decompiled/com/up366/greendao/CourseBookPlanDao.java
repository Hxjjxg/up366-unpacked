package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseBookPlanDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.CourseBookPlan, java.lang.Long> {
    public static final java.lang.String TABLENAME = "course_book_plan";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Guid = new org.greenrobot.greendao.Property(1, java.lang.String.class, "guid", false, "guid");
        public static final org.greenrobot.greendao.Property CourseId = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, false, "course_id");
        public static final org.greenrobot.greendao.Property BookId = new org.greenrobot.greendao.Property(3, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, false, "book_id");
        public static final org.greenrobot.greendao.Property ChapterId = new org.greenrobot.greendao.Property(4, java.lang.String.class, "chapterId", false, "chapter_id");
        public static final org.greenrobot.greendao.Property IsClose = new org.greenrobot.greendao.Property(5, java.lang.Integer.TYPE, "isClose", false, "is_close");
        public static final org.greenrobot.greendao.Property IsLock = new org.greenrobot.greendao.Property(6, java.lang.Integer.TYPE, "isLock", false, "is_lock");
        public static final org.greenrobot.greendao.Property BeginTime = new org.greenrobot.greendao.Property(7, java.lang.Long.TYPE, "beginTime", false, "begin_time");
        public static final org.greenrobot.greendao.Property EndTime = new org.greenrobot.greendao.Property(8, java.lang.Long.TYPE, "endTime", false, "end_time");
        public static final org.greenrobot.greendao.Property PublishType = new org.greenrobot.greendao.Property(9, java.lang.Integer.TYPE, "publishType", false, "publish_type");
        public static final org.greenrobot.greendao.Property IsPublished = new org.greenrobot.greendao.Property(10, java.lang.Integer.TYPE, "isPublished", false, "is_published");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public CourseBookPlanDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public CourseBookPlanDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"course_book_plan\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"guid\" TEXT,\"course_id\" INTEGER NOT NULL ,\"book_id\" TEXT,\"chapter_id\" TEXT,\"is_close\" INTEGER NOT NULL ,\"is_lock\" INTEGER NOT NULL ,\"begin_time\" INTEGER NOT NULL ,\"end_time\" INTEGER NOT NULL ,\"publish_type\" INTEGER NOT NULL ,\"is_published\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_course_book_plan_guid ON \"course_book_plan\" (\"guid\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"course_book_plan\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.CourseBookPlan courseBookPlan) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = courseBookPlan.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = courseBookPlan.getGuid();
        if (guid != null) {
            databaseStatement.bindString(2, guid);
        }
        databaseStatement.bindLong(3, courseBookPlan.getCourseId());
        java.lang.String bookId = courseBookPlan.getBookId();
        if (bookId != null) {
            databaseStatement.bindString(4, bookId);
        }
        java.lang.String chapterId = courseBookPlan.getChapterId();
        if (chapterId != null) {
            databaseStatement.bindString(5, chapterId);
        }
        databaseStatement.bindLong(6, courseBookPlan.getIsClose());
        databaseStatement.bindLong(7, courseBookPlan.getIsLock());
        databaseStatement.bindLong(8, courseBookPlan.getBeginTime());
        databaseStatement.bindLong(9, courseBookPlan.getEndTime());
        databaseStatement.bindLong(10, courseBookPlan.getPublishType());
        databaseStatement.bindLong(11, courseBookPlan.getIsPublished());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.CourseBookPlan courseBookPlan) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = courseBookPlan.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = courseBookPlan.getGuid();
        if (guid != null) {
            sQLiteStatement.bindString(2, guid);
        }
        sQLiteStatement.bindLong(3, courseBookPlan.getCourseId());
        java.lang.String bookId = courseBookPlan.getBookId();
        if (bookId != null) {
            sQLiteStatement.bindString(4, bookId);
        }
        java.lang.String chapterId = courseBookPlan.getChapterId();
        if (chapterId != null) {
            sQLiteStatement.bindString(5, chapterId);
        }
        sQLiteStatement.bindLong(6, courseBookPlan.getIsClose());
        sQLiteStatement.bindLong(7, courseBookPlan.getIsLock());
        sQLiteStatement.bindLong(8, courseBookPlan.getBeginTime());
        sQLiteStatement.bindLong(9, courseBookPlan.getEndTime());
        sQLiteStatement.bindLong(10, courseBookPlan.getPublishType());
        sQLiteStatement.bindLong(11, courseBookPlan.getIsPublished());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m100readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.CourseBookPlan m99readEntity(android.database.Cursor cursor, int i) {
        int i2 = i + 1;
        int i3 = i + 3;
        int i4 = i + 4;
        return new com.up366.mobile.book.model.CourseBookPlan(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.getInt(i + 2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getInt(i + 5), cursor.getInt(i + 6), cursor.getLong(i + 7), cursor.getLong(i + 8), cursor.getInt(i + 9), cursor.getInt(i + 10));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.CourseBookPlan courseBookPlan, int i) {
        courseBookPlan.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        courseBookPlan.setGuid(cursor.isNull(i2) ? null : cursor.getString(i2));
        courseBookPlan.setCourseId(cursor.getInt(i + 2));
        int i3 = i + 3;
        courseBookPlan.setBookId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        courseBookPlan.setChapterId(cursor.isNull(i4) ? null : cursor.getString(i4));
        courseBookPlan.setIsClose(cursor.getInt(i + 5));
        courseBookPlan.setIsLock(cursor.getInt(i + 6));
        courseBookPlan.setBeginTime(cursor.getLong(i + 7));
        courseBookPlan.setEndTime(cursor.getLong(i + 8));
        courseBookPlan.setPublishType(cursor.getInt(i + 9));
        courseBookPlan.setIsPublished(cursor.getInt(i + 10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.CourseBookPlan courseBookPlan, long j) {
        courseBookPlan.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.CourseBookPlan courseBookPlan) {
        if (courseBookPlan != null) {
            return courseBookPlan.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.CourseBookPlan courseBookPlan) {
        return courseBookPlan.getRowId() != null;
    }
}
