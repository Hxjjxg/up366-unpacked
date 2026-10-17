package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookTaskFinishedInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.BookTaskFinishedInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "book_task_finished_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property TaskId = new org.greenrobot.greendao.Property(1, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, false, "task_id");
        public static final org.greenrobot.greendao.Property Uid = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, "uid", false, "uid");
        public static final org.greenrobot.greendao.Property BookId = new org.greenrobot.greendao.Property(3, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, false, "book_id");
        public static final org.greenrobot.greendao.Property ChapterId = new org.greenrobot.greendao.Property(4, java.lang.String.class, "chapterId", false, "chapter_id");
        public static final org.greenrobot.greendao.Property Score = new org.greenrobot.greendao.Property(5, java.lang.Float.TYPE, "score", false, "score");
        public static final org.greenrobot.greendao.Property Percent = new org.greenrobot.greendao.Property(6, java.lang.Float.TYPE, "percent", false, "percent");
        public static final org.greenrobot.greendao.Property Seconds = new org.greenrobot.greendao.Property(7, java.lang.Integer.TYPE, "seconds", false, "seconds");
        public static final org.greenrobot.greendao.Property StudyDate = new org.greenrobot.greendao.Property(8, java.lang.Long.TYPE, "studyDate", false, "study_date");
        public static final org.greenrobot.greendao.Property AddDate = new org.greenrobot.greendao.Property(9, java.lang.Long.TYPE, "addDate", false, "add_date");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public BookTaskFinishedInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BookTaskFinishedInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"book_task_finished_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"task_id\" TEXT,\"uid\" INTEGER NOT NULL ,\"book_id\" TEXT,\"chapter_id\" TEXT,\"score\" REAL NOT NULL ,\"percent\" REAL NOT NULL ,\"seconds\" INTEGER NOT NULL ,\"study_date\" INTEGER NOT NULL ,\"add_date\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_book_task_finished_info_task_id ON \"book_task_finished_info\" (\"task_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"book_task_finished_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = bookTaskFinishedInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String taskId = bookTaskFinishedInfo.getTaskId();
        if (taskId != null) {
            databaseStatement.bindString(2, taskId);
        }
        databaseStatement.bindLong(3, bookTaskFinishedInfo.getUid());
        java.lang.String bookId = bookTaskFinishedInfo.getBookId();
        if (bookId != null) {
            databaseStatement.bindString(4, bookId);
        }
        java.lang.String chapterId = bookTaskFinishedInfo.getChapterId();
        if (chapterId != null) {
            databaseStatement.bindString(5, chapterId);
        }
        databaseStatement.bindDouble(6, bookTaskFinishedInfo.getScore());
        databaseStatement.bindDouble(7, bookTaskFinishedInfo.getPercent());
        databaseStatement.bindLong(8, bookTaskFinishedInfo.getSeconds());
        databaseStatement.bindLong(9, bookTaskFinishedInfo.getStudyDate());
        databaseStatement.bindLong(10, bookTaskFinishedInfo.getAddDate());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = bookTaskFinishedInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String taskId = bookTaskFinishedInfo.getTaskId();
        if (taskId != null) {
            sQLiteStatement.bindString(2, taskId);
        }
        sQLiteStatement.bindLong(3, bookTaskFinishedInfo.getUid());
        java.lang.String bookId = bookTaskFinishedInfo.getBookId();
        if (bookId != null) {
            sQLiteStatement.bindString(4, bookId);
        }
        java.lang.String chapterId = bookTaskFinishedInfo.getChapterId();
        if (chapterId != null) {
            sQLiteStatement.bindString(5, chapterId);
        }
        sQLiteStatement.bindDouble(6, bookTaskFinishedInfo.getScore());
        sQLiteStatement.bindDouble(7, bookTaskFinishedInfo.getPercent());
        sQLiteStatement.bindLong(8, bookTaskFinishedInfo.getSeconds());
        sQLiteStatement.bindLong(9, bookTaskFinishedInfo.getStudyDate());
        sQLiteStatement.bindLong(10, bookTaskFinishedInfo.getAddDate());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m90readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.BookTaskFinishedInfo m89readEntity(android.database.Cursor cursor, int i) {
        int i2 = i + 1;
        int i3 = i + 3;
        int i4 = i + 4;
        return new com.up366.mobile.book.model.BookTaskFinishedInfo(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.getInt(i + 2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getFloat(i + 5), cursor.getFloat(i + 6), cursor.getInt(i + 7), cursor.getLong(i + 8), cursor.getLong(i + 9));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo, int i) {
        bookTaskFinishedInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        bookTaskFinishedInfo.setTaskId(cursor.isNull(i2) ? null : cursor.getString(i2));
        bookTaskFinishedInfo.setUid(cursor.getInt(i + 2));
        int i3 = i + 3;
        bookTaskFinishedInfo.setBookId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        bookTaskFinishedInfo.setChapterId(cursor.isNull(i4) ? null : cursor.getString(i4));
        bookTaskFinishedInfo.setScore(cursor.getFloat(i + 5));
        bookTaskFinishedInfo.setPercent(cursor.getFloat(i + 6));
        bookTaskFinishedInfo.setSeconds(cursor.getInt(i + 7));
        bookTaskFinishedInfo.setStudyDate(cursor.getLong(i + 8));
        bookTaskFinishedInfo.setAddDate(cursor.getLong(i + 9));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo, long j) {
        bookTaskFinishedInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo) {
        if (bookTaskFinishedInfo != null) {
            return bookTaskFinishedInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo) {
        return bookTaskFinishedInfo.getRowId() != null;
    }
}
