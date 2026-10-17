package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MessagesDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.common.logic.model.Messages, java.lang.Long> {
    public static final java.lang.String TABLENAME = "messages";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property PushId = new org.greenrobot.greendao.Property(1, java.lang.String.class, "pushId", false, "push_id");
        public static final org.greenrobot.greendao.Property MsgId = new org.greenrobot.greendao.Property(2, java.lang.String.class, "msgId", false, "msg_id");
        public static final org.greenrobot.greendao.Property SendTime = new org.greenrobot.greendao.Property(3, java.lang.Long.TYPE, "sendTime", false, "send_time");
        public static final org.greenrobot.greendao.Property Content = new org.greenrobot.greendao.Property(4, java.lang.String.class, com.igexin.sdk.FlymePushReceiver.CONTENT, false, com.igexin.sdk.FlymePushReceiver.CONTENT);
        public static final org.greenrobot.greendao.Property Subject = new org.greenrobot.greendao.Property(5, java.lang.String.class, "subject", false, "subject");
        public static final org.greenrobot.greendao.Property From = new org.greenrobot.greendao.Property(6, java.lang.String.class, "from", false, "from");
        public static final org.greenrobot.greendao.Property MsgType = new org.greenrobot.greendao.Property(7, java.lang.Integer.TYPE, "msgType", false, "msg_type");
        public static final org.greenrobot.greendao.Property ToUid = new org.greenrobot.greendao.Property(8, java.lang.Integer.TYPE, "toUid", false, "to_uid");
        public static final org.greenrobot.greendao.Property ReadFlag = new org.greenrobot.greendao.Property(9, java.lang.Integer.TYPE, "readFlag", false, "read_flag");
        public static final org.greenrobot.greendao.Property Type = new org.greenrobot.greendao.Property(10, java.lang.Integer.TYPE, "type", false, "type");
        public static final org.greenrobot.greendao.Property ReadTime = new org.greenrobot.greendao.Property(11, java.lang.Long.TYPE, "readTime", false, "read_time");
        public static final org.greenrobot.greendao.Property Extend = new org.greenrobot.greendao.Property(12, java.lang.String.class, com.up366.mobile.book.helper.V9ResourceHelper.DIR_EXTEND, false, com.up366.mobile.book.helper.V9ResourceHelper.DIR_EXTEND);
        public static final org.greenrobot.greendao.Property Selected = new org.greenrobot.greendao.Property(13, java.lang.Boolean.TYPE, "selected", false, "SELECTED");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public MessagesDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public MessagesDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"messages\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"push_id\" TEXT,\"msg_id\" TEXT,\"send_time\" INTEGER NOT NULL ,\"content\" TEXT,\"subject\" TEXT,\"from\" TEXT,\"msg_type\" INTEGER NOT NULL ,\"to_uid\" INTEGER NOT NULL ,\"read_flag\" INTEGER NOT NULL ,\"type\" INTEGER NOT NULL ,\"read_time\" INTEGER NOT NULL ,\"extend\" TEXT,\"SELECTED\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_messages_push_id ON \"messages\" (\"push_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"messages\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.common.logic.model.Messages messages) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = messages.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String pushId = messages.getPushId();
        if (pushId != null) {
            databaseStatement.bindString(2, pushId);
        }
        java.lang.String msgId = messages.getMsgId();
        if (msgId != null) {
            databaseStatement.bindString(3, msgId);
        }
        databaseStatement.bindLong(4, messages.getSendTime());
        java.lang.String content = messages.getContent();
        if (content != null) {
            databaseStatement.bindString(5, content);
        }
        java.lang.String subject = messages.getSubject();
        if (subject != null) {
            databaseStatement.bindString(6, subject);
        }
        java.lang.String from = messages.getFrom();
        if (from != null) {
            databaseStatement.bindString(7, from);
        }
        databaseStatement.bindLong(8, messages.getMsgType());
        databaseStatement.bindLong(9, messages.getToUid());
        databaseStatement.bindLong(10, messages.getReadFlag());
        databaseStatement.bindLong(11, messages.getType());
        databaseStatement.bindLong(12, messages.getReadTime());
        java.lang.String extend = messages.getExtend();
        if (extend != null) {
            databaseStatement.bindString(13, extend);
        }
        databaseStatement.bindLong(14, messages.getSelected() ? 1L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.common.logic.model.Messages messages) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = messages.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String pushId = messages.getPushId();
        if (pushId != null) {
            sQLiteStatement.bindString(2, pushId);
        }
        java.lang.String msgId = messages.getMsgId();
        if (msgId != null) {
            sQLiteStatement.bindString(3, msgId);
        }
        sQLiteStatement.bindLong(4, messages.getSendTime());
        java.lang.String content = messages.getContent();
        if (content != null) {
            sQLiteStatement.bindString(5, content);
        }
        java.lang.String subject = messages.getSubject();
        if (subject != null) {
            sQLiteStatement.bindString(6, subject);
        }
        java.lang.String from = messages.getFrom();
        if (from != null) {
            sQLiteStatement.bindString(7, from);
        }
        sQLiteStatement.bindLong(8, messages.getMsgType());
        sQLiteStatement.bindLong(9, messages.getToUid());
        sQLiteStatement.bindLong(10, messages.getReadFlag());
        sQLiteStatement.bindLong(11, messages.getType());
        sQLiteStatement.bindLong(12, messages.getReadTime());
        java.lang.String extend = messages.getExtend();
        if (extend != null) {
            sQLiteStatement.bindString(13, extend);
        }
        sQLiteStatement.bindLong(14, messages.getSelected() ? 1L : 0L);
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m114readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.common.logic.model.Messages m113readEntity(android.database.Cursor cursor, int i) {
        int i2 = i + 1;
        int i3 = i + 2;
        int i4 = i + 4;
        int i5 = i + 5;
        int i6 = i + 6;
        int i7 = i + 12;
        return new com.up366.mobile.common.logic.model.Messages(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.getLong(i + 3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getInt(i + 7), cursor.getInt(i + 8), cursor.getInt(i + 9), cursor.getInt(i + 10), cursor.getLong(i + 11), cursor.isNull(i7) ? null : cursor.getString(i7), cursor.getShort(i + 13) != 0);
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.common.logic.model.Messages messages, int i) {
        messages.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        messages.setPushId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        messages.setMsgId(cursor.isNull(i3) ? null : cursor.getString(i3));
        messages.setSendTime(cursor.getLong(i + 3));
        int i4 = i + 4;
        messages.setContent(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 5;
        messages.setSubject(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 6;
        messages.setFrom(cursor.isNull(i6) ? null : cursor.getString(i6));
        messages.setMsgType(cursor.getInt(i + 7));
        messages.setToUid(cursor.getInt(i + 8));
        messages.setReadFlag(cursor.getInt(i + 9));
        messages.setType(cursor.getInt(i + 10));
        messages.setReadTime(cursor.getLong(i + 11));
        int i7 = i + 12;
        messages.setExtend(cursor.isNull(i7) ? null : cursor.getString(i7));
        messages.setSelected(cursor.getShort(i + 13) != 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.common.logic.model.Messages messages, long j) {
        messages.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.common.logic.model.Messages messages) {
        if (messages != null) {
            return messages.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.common.logic.model.Messages messages) {
        return messages.getRowId() != null;
    }
}
