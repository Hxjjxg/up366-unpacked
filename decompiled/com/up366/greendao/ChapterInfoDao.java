package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.ChapterInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "chapter_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Id = new org.greenrobot.greendao.Property(1, java.lang.String.class, com.igexin.push.core.b.C, false, com.igexin.push.core.b.C);
        public static final org.greenrobot.greendao.Property ParentId = new org.greenrobot.greendao.Property(2, java.lang.String.class, "parentId", false, "parent_id");
        public static final org.greenrobot.greendao.Property BookId = new org.greenrobot.greendao.Property(3, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, false, "book_id");
        public static final org.greenrobot.greendao.Property Name = new org.greenrobot.greendao.Property(4, java.lang.String.class, "name", false, "name");
        public static final org.greenrobot.greendao.Property WelFileName = new org.greenrobot.greendao.Property(5, java.lang.String.class, "welFileName", false, "wel_file_name");
        public static final org.greenrobot.greendao.Property Type = new org.greenrobot.greendao.Property(6, java.lang.Integer.TYPE, "type", false, "type");
        public static final org.greenrobot.greendao.Property Level = new org.greenrobot.greendao.Property(7, java.lang.Integer.TYPE, "level", false, "level");
        public static final org.greenrobot.greendao.Property DisplayOrder = new org.greenrobot.greendao.Property(8, java.lang.Integer.TYPE, "displayOrder", false, "display_order");
        public static final org.greenrobot.greendao.Property IsContent = new org.greenrobot.greendao.Property(9, java.lang.Integer.TYPE, "isContent", false, "is_content");
        public static final org.greenrobot.greendao.Property IsFree = new org.greenrobot.greendao.Property(10, java.lang.Integer.TYPE, "isFree", false, "is_free");
        public static final org.greenrobot.greendao.Property ChapterType = new org.greenrobot.greendao.Property(11, java.lang.Integer.TYPE, "chapterType", false, "chapter_type");
        public static final org.greenrobot.greendao.Property Weight = new org.greenrobot.greendao.Property(12, java.lang.Float.TYPE, "weight", false, "weight");
        public static final org.greenrobot.greendao.Property TaskId = new org.greenrobot.greendao.Property(13, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, false, "task_id");
        public static final org.greenrobot.greendao.Property PcStatus = new org.greenrobot.greendao.Property(14, java.lang.Integer.TYPE, "pcStatus", false, "pc_status");
        public static final org.greenrobot.greendao.Property FileId = new org.greenrobot.greendao.Property(15, java.lang.String.class, "fileId", false, "file_id");
        public static final org.greenrobot.greendao.Property MobileStatus = new org.greenrobot.greendao.Property(16, java.lang.String.class, "mobileStatus", false, "mobile_status");
        public static final org.greenrobot.greendao.Property XotPaperId = new org.greenrobot.greendao.Property(17, java.lang.String.class, "xotPaperId", false, "xot_paper_id");
        public static final org.greenrobot.greendao.Property PictureUrl = new org.greenrobot.greendao.Property(18, java.lang.String.class, "pictureUrl", false, "picture_url");
        public static final org.greenrobot.greendao.Property IsTest = new org.greenrobot.greendao.Property(19, java.lang.Integer.TYPE, "isTest", false, "is_test");
        public static final org.greenrobot.greendao.Property TotalScore = new org.greenrobot.greendao.Property(20, java.lang.Float.TYPE, "totalScore", false, "total_score");
        public static final org.greenrobot.greendao.Property ExtendParams = new org.greenrobot.greendao.Property(21, java.lang.String.class, "extendParams", false, "extend_params");
        public static final org.greenrobot.greendao.Property AddTime = new org.greenrobot.greendao.Property(22, java.lang.Long.TYPE, "addTime", false, "add_time");
        public static final org.greenrobot.greendao.Property PaperId = new org.greenrobot.greendao.Property(23, java.lang.String.class, "paperId", false, "paper_id");
        public static final org.greenrobot.greendao.Property IsShelf = new org.greenrobot.greendao.Property(24, java.lang.Integer.TYPE, "isShelf", false, "is_shelf");
        public static final org.greenrobot.greendao.Property GrayConfig = new org.greenrobot.greendao.Property(25, java.lang.String.class, "grayConfig", false, "gray_config");
        public static final org.greenrobot.greendao.Property ResourceList = new org.greenrobot.greendao.Property(26, java.lang.String.class, "resourceList", false, "resource_list");
        public static final org.greenrobot.greendao.Property IsLock = new org.greenrobot.greendao.Property(27, java.lang.Integer.TYPE, "isLock", false, "IS_LOCK");
        public static final org.greenrobot.greendao.Property UnitStudyPercent = new org.greenrobot.greendao.Property(28, java.lang.Float.TYPE, "unitStudyPercent", false, "UNIT_STUDY_PERCENT");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public ChapterInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public ChapterInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"chapter_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"id\" TEXT,\"parent_id\" TEXT,\"book_id\" TEXT,\"name\" TEXT,\"wel_file_name\" TEXT,\"type\" INTEGER NOT NULL ,\"level\" INTEGER NOT NULL ,\"display_order\" INTEGER NOT NULL ,\"is_content\" INTEGER NOT NULL ,\"is_free\" INTEGER NOT NULL ,\"chapter_type\" INTEGER NOT NULL ,\"weight\" REAL NOT NULL ,\"task_id\" TEXT,\"pc_status\" INTEGER NOT NULL ,\"file_id\" TEXT,\"mobile_status\" TEXT,\"xot_paper_id\" TEXT,\"picture_url\" TEXT,\"is_test\" INTEGER NOT NULL ,\"total_score\" REAL NOT NULL ,\"extend_params\" TEXT,\"add_time\" INTEGER NOT NULL ,\"paper_id\" TEXT,\"is_shelf\" INTEGER NOT NULL ,\"gray_config\" TEXT,\"resource_list\" TEXT,\"IS_LOCK\" INTEGER NOT NULL ,\"UNIT_STUDY_PERCENT\" REAL NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_chapter_info_id ON \"chapter_info\" (\"id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"chapter_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = chapterInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String id = chapterInfo.getId();
        if (id != null) {
            databaseStatement.bindString(2, id);
        }
        java.lang.String parentId = chapterInfo.getParentId();
        if (parentId != null) {
            databaseStatement.bindString(3, parentId);
        }
        java.lang.String bookId = chapterInfo.getBookId();
        if (bookId != null) {
            databaseStatement.bindString(4, bookId);
        }
        java.lang.String name = chapterInfo.getName();
        if (name != null) {
            databaseStatement.bindString(5, name);
        }
        java.lang.String welFileName = chapterInfo.getWelFileName();
        if (welFileName != null) {
            databaseStatement.bindString(6, welFileName);
        }
        databaseStatement.bindLong(7, chapterInfo.getType());
        databaseStatement.bindLong(8, chapterInfo.getLevel());
        databaseStatement.bindLong(9, chapterInfo.getDisplayOrder());
        databaseStatement.bindLong(10, chapterInfo.getIsContent());
        databaseStatement.bindLong(11, chapterInfo.getIsFree());
        databaseStatement.bindLong(12, chapterInfo.getChapterType());
        databaseStatement.bindDouble(13, chapterInfo.getWeight());
        java.lang.String taskId = chapterInfo.getTaskId();
        if (taskId != null) {
            databaseStatement.bindString(14, taskId);
        }
        databaseStatement.bindLong(15, chapterInfo.getPcStatus());
        java.lang.String fileId = chapterInfo.getFileId();
        if (fileId != null) {
            databaseStatement.bindString(16, fileId);
        }
        java.lang.String mobileStatus = chapterInfo.getMobileStatus();
        if (mobileStatus != null) {
            databaseStatement.bindString(17, mobileStatus);
        }
        java.lang.String xotPaperId = chapterInfo.getXotPaperId();
        if (xotPaperId != null) {
            databaseStatement.bindString(18, xotPaperId);
        }
        java.lang.String pictureUrl = chapterInfo.getPictureUrl();
        if (pictureUrl != null) {
            databaseStatement.bindString(19, pictureUrl);
        }
        databaseStatement.bindLong(20, chapterInfo.getIsTest());
        databaseStatement.bindDouble(21, chapterInfo.getTotalScore());
        java.lang.String extendParams = chapterInfo.getExtendParams();
        if (extendParams != null) {
            databaseStatement.bindString(22, extendParams);
        }
        databaseStatement.bindLong(23, chapterInfo.getAddTime());
        java.lang.String paperId = chapterInfo.getPaperId();
        if (paperId != null) {
            databaseStatement.bindString(24, paperId);
        }
        databaseStatement.bindLong(25, chapterInfo.getIsShelf());
        java.lang.String grayConfig = chapterInfo.getGrayConfig();
        if (grayConfig != null) {
            databaseStatement.bindString(26, grayConfig);
        }
        java.lang.String resourceList = chapterInfo.getResourceList();
        if (resourceList != null) {
            databaseStatement.bindString(27, resourceList);
        }
        databaseStatement.bindLong(28, chapterInfo.getIsLock());
        databaseStatement.bindDouble(29, chapterInfo.getUnitStudyPercent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = chapterInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String id = chapterInfo.getId();
        if (id != null) {
            sQLiteStatement.bindString(2, id);
        }
        java.lang.String parentId = chapterInfo.getParentId();
        if (parentId != null) {
            sQLiteStatement.bindString(3, parentId);
        }
        java.lang.String bookId = chapterInfo.getBookId();
        if (bookId != null) {
            sQLiteStatement.bindString(4, bookId);
        }
        java.lang.String name = chapterInfo.getName();
        if (name != null) {
            sQLiteStatement.bindString(5, name);
        }
        java.lang.String welFileName = chapterInfo.getWelFileName();
        if (welFileName != null) {
            sQLiteStatement.bindString(6, welFileName);
        }
        sQLiteStatement.bindLong(7, chapterInfo.getType());
        sQLiteStatement.bindLong(8, chapterInfo.getLevel());
        sQLiteStatement.bindLong(9, chapterInfo.getDisplayOrder());
        sQLiteStatement.bindLong(10, chapterInfo.getIsContent());
        sQLiteStatement.bindLong(11, chapterInfo.getIsFree());
        sQLiteStatement.bindLong(12, chapterInfo.getChapterType());
        sQLiteStatement.bindDouble(13, chapterInfo.getWeight());
        java.lang.String taskId = chapterInfo.getTaskId();
        if (taskId != null) {
            sQLiteStatement.bindString(14, taskId);
        }
        sQLiteStatement.bindLong(15, chapterInfo.getPcStatus());
        java.lang.String fileId = chapterInfo.getFileId();
        if (fileId != null) {
            sQLiteStatement.bindString(16, fileId);
        }
        java.lang.String mobileStatus = chapterInfo.getMobileStatus();
        if (mobileStatus != null) {
            sQLiteStatement.bindString(17, mobileStatus);
        }
        java.lang.String xotPaperId = chapterInfo.getXotPaperId();
        if (xotPaperId != null) {
            sQLiteStatement.bindString(18, xotPaperId);
        }
        java.lang.String pictureUrl = chapterInfo.getPictureUrl();
        if (pictureUrl != null) {
            sQLiteStatement.bindString(19, pictureUrl);
        }
        sQLiteStatement.bindLong(20, chapterInfo.getIsTest());
        sQLiteStatement.bindDouble(21, chapterInfo.getTotalScore());
        java.lang.String extendParams = chapterInfo.getExtendParams();
        if (extendParams != null) {
            sQLiteStatement.bindString(22, extendParams);
        }
        sQLiteStatement.bindLong(23, chapterInfo.getAddTime());
        java.lang.String paperId = chapterInfo.getPaperId();
        if (paperId != null) {
            sQLiteStatement.bindString(24, paperId);
        }
        sQLiteStatement.bindLong(25, chapterInfo.getIsShelf());
        java.lang.String grayConfig = chapterInfo.getGrayConfig();
        if (grayConfig != null) {
            sQLiteStatement.bindString(26, grayConfig);
        }
        java.lang.String resourceList = chapterInfo.getResourceList();
        if (resourceList != null) {
            sQLiteStatement.bindString(27, resourceList);
        }
        sQLiteStatement.bindLong(28, chapterInfo.getIsLock());
        sQLiteStatement.bindDouble(29, chapterInfo.getUnitStudyPercent());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m96readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.ChapterInfo m95readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        java.lang.String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        java.lang.String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        java.lang.String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = cursor.getInt(i + 6);
        int i8 = cursor.getInt(i + 7);
        int i9 = cursor.getInt(i + 8);
        int i10 = cursor.getInt(i + 9);
        int i11 = cursor.getInt(i + 10);
        int i12 = cursor.getInt(i + 11);
        float f = cursor.getFloat(i + 12);
        int i13 = i + 13;
        java.lang.String string6 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = cursor.getInt(i + 14);
        int i15 = i + 15;
        java.lang.String string7 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 16;
        java.lang.String string8 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 17;
        java.lang.String string9 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i + 18;
        java.lang.String string10 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = cursor.getInt(i + 19);
        float f2 = cursor.getFloat(i + 20);
        int i20 = i + 21;
        java.lang.String string11 = cursor.isNull(i20) ? null : cursor.getString(i20);
        long j = cursor.getLong(i + 22);
        int i21 = i + 23;
        java.lang.String string12 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = cursor.getInt(i + 24);
        int i23 = i + 25;
        java.lang.String string13 = cursor.isNull(i23) ? null : cursor.getString(i23);
        int i24 = i + 26;
        return new com.up366.mobile.book.model.ChapterInfo(lValueOf, string, string2, string3, string4, string5, i7, i8, i9, i10, i11, i12, f, string6, i14, string7, string8, string9, string10, i19, f2, string11, j, string12, i22, string13, cursor.isNull(i24) ? null : cursor.getString(i24), cursor.getInt(i + 27), cursor.getFloat(i + 28));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.ChapterInfo chapterInfo, int i) {
        chapterInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        chapterInfo.setId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        chapterInfo.setParentId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        chapterInfo.setBookId(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        chapterInfo.setName(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        chapterInfo.setWelFileName(cursor.isNull(i6) ? null : cursor.getString(i6));
        chapterInfo.setType(cursor.getInt(i + 6));
        chapterInfo.setLevel(cursor.getInt(i + 7));
        chapterInfo.setDisplayOrder(cursor.getInt(i + 8));
        chapterInfo.setIsContent(cursor.getInt(i + 9));
        chapterInfo.setIsFree(cursor.getInt(i + 10));
        chapterInfo.setChapterType(cursor.getInt(i + 11));
        chapterInfo.setWeight(cursor.getFloat(i + 12));
        int i7 = i + 13;
        chapterInfo.setTaskId(cursor.isNull(i7) ? null : cursor.getString(i7));
        chapterInfo.setPcStatus(cursor.getInt(i + 14));
        int i8 = i + 15;
        chapterInfo.setFileId(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 16;
        chapterInfo.setMobileStatus(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 17;
        chapterInfo.setXotPaperId(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 18;
        chapterInfo.setPictureUrl(cursor.isNull(i11) ? null : cursor.getString(i11));
        chapterInfo.setIsTest(cursor.getInt(i + 19));
        chapterInfo.setTotalScore(cursor.getFloat(i + 20));
        int i12 = i + 21;
        chapterInfo.setExtendParams(cursor.isNull(i12) ? null : cursor.getString(i12));
        chapterInfo.setAddTime(cursor.getLong(i + 22));
        int i13 = i + 23;
        chapterInfo.setPaperId(cursor.isNull(i13) ? null : cursor.getString(i13));
        chapterInfo.setIsShelf(cursor.getInt(i + 24));
        int i14 = i + 25;
        chapterInfo.setGrayConfig(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i + 26;
        chapterInfo.setResourceList(cursor.isNull(i15) ? null : cursor.getString(i15));
        chapterInfo.setIsLock(cursor.getInt(i + 27));
        chapterInfo.setUnitStudyPercent(cursor.getFloat(i + 28));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.ChapterInfo chapterInfo, long j) {
        chapterInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        if (chapterInfo != null) {
            return chapterInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        return chapterInfo.getRowId() != null;
    }
}
