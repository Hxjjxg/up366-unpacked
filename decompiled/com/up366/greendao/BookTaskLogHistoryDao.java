package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookTaskLogHistoryDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.BookTaskLogHistory, java.lang.Long> {
    public static final java.lang.String TABLENAME = "book_task_log_history";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Guid = new org.greenrobot.greendao.Property(1, java.lang.String.class, "guid", false, "guid");
        public static final org.greenrobot.greendao.Property TaskId = new org.greenrobot.greendao.Property(2, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, false, "task_id");
        public static final org.greenrobot.greendao.Property InsertTime = new org.greenrobot.greendao.Property(3, java.lang.Long.TYPE, "insertTime", false, "insert_time");
        public static final org.greenrobot.greendao.Property LogData = new org.greenrobot.greendao.Property(4, byte[].class, "logData", false, com.igexin.c.a.c.a.d.d);
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public BookTaskLogHistoryDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BookTaskLogHistoryDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"book_task_log_history\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"guid\" TEXT,\"task_id\" TEXT,\"insert_time\" INTEGER NOT NULL ,\"log_data\" BLOB);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"book_task_log_history\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = bookTaskLogHistory.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = bookTaskLogHistory.getGuid();
        if (guid != null) {
            databaseStatement.bindString(2, guid);
        }
        java.lang.String taskId = bookTaskLogHistory.getTaskId();
        if (taskId != null) {
            databaseStatement.bindString(3, taskId);
        }
        databaseStatement.bindLong(4, bookTaskLogHistory.getInsertTime());
        byte[] logData = bookTaskLogHistory.getLogData();
        if (logData != null) {
            databaseStatement.bindBlob(5, logData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = bookTaskLogHistory.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = bookTaskLogHistory.getGuid();
        if (guid != null) {
            sQLiteStatement.bindString(2, guid);
        }
        java.lang.String taskId = bookTaskLogHistory.getTaskId();
        if (taskId != null) {
            sQLiteStatement.bindString(3, taskId);
        }
        sQLiteStatement.bindLong(4, bookTaskLogHistory.getInsertTime());
        byte[] logData = bookTaskLogHistory.getLogData();
        if (logData != null) {
            sQLiteStatement.bindBlob(5, logData);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m92readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.BookTaskLogHistory m91readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        long j = cursor.getLong(i + 3);
        int i4 = i + 4;
        return new com.up366.mobile.book.model.BookTaskLogHistory(lValueOf, string, string2, j, cursor.isNull(i4) ? null : cursor.getBlob(i4));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory, int i) {
        bookTaskLogHistory.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        bookTaskLogHistory.setGuid(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        bookTaskLogHistory.setTaskId(cursor.isNull(i3) ? null : cursor.getString(i3));
        bookTaskLogHistory.setInsertTime(cursor.getLong(i + 3));
        int i4 = i + 4;
        bookTaskLogHistory.setLogData(cursor.isNull(i4) ? null : cursor.getBlob(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory, long j) {
        bookTaskLogHistory.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory) {
        if (bookTaskLogHistory != null) {
            return bookTaskLogHistory.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory) {
        return bookTaskLogHistory.getRowId() != null;
    }
}
