package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookTaskLogV2Dao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.BookTaskLogV2, java.lang.Long> {
    public static final java.lang.String TABLENAME = "book_task_log_v2";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property TaskId = new org.greenrobot.greendao.Property(1, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, false, "task_id");
        public static final org.greenrobot.greendao.Property BookId = new org.greenrobot.greendao.Property(2, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, false, "book_id");
        public static final org.greenrobot.greendao.Property StudyTime = new org.greenrobot.greendao.Property(3, java.lang.Integer.TYPE, "studyTime", false, "study_time");
        public static final org.greenrobot.greendao.Property Answers = new org.greenrobot.greendao.Property(4, java.lang.String.class, "answers", false, "answers");
        public static final org.greenrobot.greendao.Property Score = new org.greenrobot.greendao.Property(5, java.lang.Float.TYPE, "score", false, "score");
        public static final org.greenrobot.greendao.Property AddTime = new org.greenrobot.greendao.Property(6, java.lang.Long.TYPE, "addTime", false, "add_time");
        public static final org.greenrobot.greendao.Property StudyDate = new org.greenrobot.greendao.Property(7, java.lang.Long.TYPE, "studyDate", false, "study_date");
        public static final org.greenrobot.greendao.Property TaskNo = new org.greenrobot.greendao.Property(8, java.lang.String.class, "taskNo", false, "task_no");
        public static final org.greenrobot.greendao.Property Percent = new org.greenrobot.greendao.Property(9, java.lang.Float.TYPE, "percent", false, "percent");
        public static final org.greenrobot.greendao.Property SubmitType = new org.greenrobot.greendao.Property(10, java.lang.Integer.TYPE, "submitType", false, "submit_type");
        public static final org.greenrobot.greendao.Property Guid = new org.greenrobot.greendao.Property(11, java.lang.String.class, "guid", false, "GUID");
        public static final org.greenrobot.greendao.Property FileUrls = new org.greenrobot.greendao.Property(12, java.lang.String.class, "fileUrls", false, "FILE_URLS");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public BookTaskLogV2Dao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BookTaskLogV2Dao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"book_task_log_v2\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"task_id\" TEXT,\"book_id\" TEXT,\"study_time\" INTEGER NOT NULL ,\"answers\" TEXT,\"score\" REAL NOT NULL ,\"add_time\" INTEGER NOT NULL ,\"study_date\" INTEGER NOT NULL ,\"task_no\" TEXT,\"percent\" REAL NOT NULL ,\"submit_type\" INTEGER NOT NULL ,\"GUID\" TEXT,\"FILE_URLS\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_book_task_log_v2_task_id ON \"book_task_log_v2\" (\"task_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"book_task_log_v2\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = bookTaskLogV2.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String taskId = bookTaskLogV2.getTaskId();
        if (taskId != null) {
            databaseStatement.bindString(2, taskId);
        }
        java.lang.String bookId = bookTaskLogV2.getBookId();
        if (bookId != null) {
            databaseStatement.bindString(3, bookId);
        }
        databaseStatement.bindLong(4, bookTaskLogV2.getStudyTime());
        java.lang.String answers = bookTaskLogV2.getAnswers();
        if (answers != null) {
            databaseStatement.bindString(5, answers);
        }
        databaseStatement.bindDouble(6, bookTaskLogV2.getScore());
        databaseStatement.bindLong(7, bookTaskLogV2.getAddTime());
        databaseStatement.bindLong(8, bookTaskLogV2.getStudyDate());
        java.lang.String taskNo = bookTaskLogV2.getTaskNo();
        if (taskNo != null) {
            databaseStatement.bindString(9, taskNo);
        }
        databaseStatement.bindDouble(10, bookTaskLogV2.getPercent());
        databaseStatement.bindLong(11, bookTaskLogV2.getSubmitType());
        java.lang.String guid = bookTaskLogV2.getGuid();
        if (guid != null) {
            databaseStatement.bindString(12, guid);
        }
        java.lang.String fileUrls = bookTaskLogV2.getFileUrls();
        if (fileUrls != null) {
            databaseStatement.bindString(13, fileUrls);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = bookTaskLogV2.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String taskId = bookTaskLogV2.getTaskId();
        if (taskId != null) {
            sQLiteStatement.bindString(2, taskId);
        }
        java.lang.String bookId = bookTaskLogV2.getBookId();
        if (bookId != null) {
            sQLiteStatement.bindString(3, bookId);
        }
        sQLiteStatement.bindLong(4, bookTaskLogV2.getStudyTime());
        java.lang.String answers = bookTaskLogV2.getAnswers();
        if (answers != null) {
            sQLiteStatement.bindString(5, answers);
        }
        sQLiteStatement.bindDouble(6, bookTaskLogV2.getScore());
        sQLiteStatement.bindLong(7, bookTaskLogV2.getAddTime());
        sQLiteStatement.bindLong(8, bookTaskLogV2.getStudyDate());
        java.lang.String taskNo = bookTaskLogV2.getTaskNo();
        if (taskNo != null) {
            sQLiteStatement.bindString(9, taskNo);
        }
        sQLiteStatement.bindDouble(10, bookTaskLogV2.getPercent());
        sQLiteStatement.bindLong(11, bookTaskLogV2.getSubmitType());
        java.lang.String guid = bookTaskLogV2.getGuid();
        if (guid != null) {
            sQLiteStatement.bindString(12, guid);
        }
        java.lang.String fileUrls = bookTaskLogV2.getFileUrls();
        if (fileUrls != null) {
            sQLiteStatement.bindString(13, fileUrls);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m94readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.BookTaskLogV2 m93readEntity(android.database.Cursor cursor, int i) {
        int i2 = i + 1;
        int i3 = i + 2;
        int i4 = i + 4;
        int i5 = i + 8;
        int i6 = i + 11;
        int i7 = i + 12;
        return new com.up366.mobile.book.model.BookTaskLogV2(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.getInt(i + 3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getFloat(i + 5), cursor.getLong(i + 6), cursor.getLong(i + 7), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.getFloat(i + 9), cursor.getInt(i + 10), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2, int i) {
        bookTaskLogV2.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        bookTaskLogV2.setTaskId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        bookTaskLogV2.setBookId(cursor.isNull(i3) ? null : cursor.getString(i3));
        bookTaskLogV2.setStudyTime(cursor.getInt(i + 3));
        int i4 = i + 4;
        bookTaskLogV2.setAnswers(cursor.isNull(i4) ? null : cursor.getString(i4));
        bookTaskLogV2.setScore(cursor.getFloat(i + 5));
        bookTaskLogV2.setAddTime(cursor.getLong(i + 6));
        bookTaskLogV2.setStudyDate(cursor.getLong(i + 7));
        int i5 = i + 8;
        bookTaskLogV2.setTaskNo(cursor.isNull(i5) ? null : cursor.getString(i5));
        bookTaskLogV2.setPercent(cursor.getFloat(i + 9));
        bookTaskLogV2.setSubmitType(cursor.getInt(i + 10));
        int i6 = i + 11;
        bookTaskLogV2.setGuid(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 12;
        bookTaskLogV2.setFileUrls(cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2, long j) {
        bookTaskLogV2.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) {
        if (bookTaskLogV2 != null) {
            return bookTaskLogV2.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) {
        return bookTaskLogV2.getRowId() != null;
    }
}
