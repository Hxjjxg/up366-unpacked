package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookScheduleInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.BookScheduleInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "book_schedule_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property BookId = new org.greenrobot.greendao.Property(1, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, false, "book_id");
        public static final org.greenrobot.greendao.Property ChapterId = new org.greenrobot.greendao.Property(2, java.lang.String.class, "chapterId", false, "chapter_id");
        public static final org.greenrobot.greendao.Property PageId = new org.greenrobot.greendao.Property(3, java.lang.String.class, "pageId", false, "page_id");
        public static final org.greenrobot.greendao.Property LastStudyTime = new org.greenrobot.greendao.Property(4, java.lang.Long.TYPE, "lastStudyTime", false, "last_study_time");
        public static final org.greenrobot.greendao.Property ChapterStudyTaskNum = new org.greenrobot.greendao.Property(5, java.lang.Integer.TYPE, "chapterStudyTaskNum", false, "chapter_study_task_num");
        public static final org.greenrobot.greendao.Property ShortSchedule = new org.greenrobot.greendao.Property(6, java.lang.String.class, "shortSchedule", false, "short_schedule");
        public static final org.greenrobot.greendao.Property Schedule = new org.greenrobot.greendao.Property(7, java.lang.String.class, "schedule", false, "schedule");
        public static final org.greenrobot.greendao.Property TaskNo = new org.greenrobot.greendao.Property(8, java.lang.Integer.TYPE, "taskNo", false, "task_no");
        public static final org.greenrobot.greendao.Property TaskId = new org.greenrobot.greendao.Property(9, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, false, "task_id");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public BookScheduleInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BookScheduleInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"book_schedule_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"book_id\" TEXT,\"chapter_id\" TEXT,\"page_id\" TEXT,\"last_study_time\" INTEGER NOT NULL ,\"chapter_study_task_num\" INTEGER NOT NULL ,\"short_schedule\" TEXT,\"schedule\" TEXT,\"task_no\" INTEGER NOT NULL ,\"task_id\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_book_schedule_info_book_id ON \"book_schedule_info\" (\"book_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"book_schedule_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = bookScheduleInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String bookId = bookScheduleInfo.getBookId();
        if (bookId != null) {
            databaseStatement.bindString(2, bookId);
        }
        java.lang.String chapterId = bookScheduleInfo.getChapterId();
        if (chapterId != null) {
            databaseStatement.bindString(3, chapterId);
        }
        java.lang.String pageId = bookScheduleInfo.getPageId();
        if (pageId != null) {
            databaseStatement.bindString(4, pageId);
        }
        databaseStatement.bindLong(5, bookScheduleInfo.getLastStudyTime());
        databaseStatement.bindLong(6, bookScheduleInfo.getChapterStudyTaskNum());
        java.lang.String shortSchedule = bookScheduleInfo.getShortSchedule();
        if (shortSchedule != null) {
            databaseStatement.bindString(7, shortSchedule);
        }
        java.lang.String schedule = bookScheduleInfo.getSchedule();
        if (schedule != null) {
            databaseStatement.bindString(8, schedule);
        }
        databaseStatement.bindLong(9, bookScheduleInfo.getTaskNo());
        java.lang.String taskId = bookScheduleInfo.getTaskId();
        if (taskId != null) {
            databaseStatement.bindString(10, taskId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = bookScheduleInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String bookId = bookScheduleInfo.getBookId();
        if (bookId != null) {
            sQLiteStatement.bindString(2, bookId);
        }
        java.lang.String chapterId = bookScheduleInfo.getChapterId();
        if (chapterId != null) {
            sQLiteStatement.bindString(3, chapterId);
        }
        java.lang.String pageId = bookScheduleInfo.getPageId();
        if (pageId != null) {
            sQLiteStatement.bindString(4, pageId);
        }
        sQLiteStatement.bindLong(5, bookScheduleInfo.getLastStudyTime());
        sQLiteStatement.bindLong(6, bookScheduleInfo.getChapterStudyTaskNum());
        java.lang.String shortSchedule = bookScheduleInfo.getShortSchedule();
        if (shortSchedule != null) {
            sQLiteStatement.bindString(7, shortSchedule);
        }
        java.lang.String schedule = bookScheduleInfo.getSchedule();
        if (schedule != null) {
            sQLiteStatement.bindString(8, schedule);
        }
        sQLiteStatement.bindLong(9, bookScheduleInfo.getTaskNo());
        java.lang.String taskId = bookScheduleInfo.getTaskId();
        if (taskId != null) {
            sQLiteStatement.bindString(10, taskId);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m88readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.BookScheduleInfo m87readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        java.lang.String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        long j = cursor.getLong(i + 4);
        int i5 = cursor.getInt(i + 5);
        int i6 = i + 6;
        java.lang.String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 7;
        java.lang.String string5 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = cursor.getInt(i + 8);
        int i9 = i + 9;
        return new com.up366.mobile.book.model.BookScheduleInfo(lValueOf, string, string2, string3, j, i5, string4, string5, i8, cursor.isNull(i9) ? null : cursor.getString(i9));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo, int i) {
        bookScheduleInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        bookScheduleInfo.setBookId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        bookScheduleInfo.setChapterId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        bookScheduleInfo.setPageId(cursor.isNull(i4) ? null : cursor.getString(i4));
        bookScheduleInfo.setLastStudyTime(cursor.getLong(i + 4));
        bookScheduleInfo.setChapterStudyTaskNum(cursor.getInt(i + 5));
        int i5 = i + 6;
        bookScheduleInfo.setShortSchedule(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 7;
        bookScheduleInfo.setSchedule(cursor.isNull(i6) ? null : cursor.getString(i6));
        bookScheduleInfo.setTaskNo(cursor.getInt(i + 8));
        int i7 = i + 9;
        bookScheduleInfo.setTaskId(cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo, long j) {
        bookScheduleInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo) {
        if (bookScheduleInfo != null) {
            return bookScheduleInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo) {
        return bookScheduleInfo.getRowId() != null;
    }
}
