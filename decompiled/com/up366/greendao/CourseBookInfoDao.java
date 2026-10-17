package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseBookInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.course.mgr.CourseBookInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "course_book_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Guid = new org.greenrobot.greendao.Property(1, java.lang.String.class, "guid", false, "guid");
        public static final org.greenrobot.greendao.Property CourseId = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, false, "course_id");
        public static final org.greenrobot.greendao.Property BookId = new org.greenrobot.greendao.Property(3, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, false, "book_id");
        public static final org.greenrobot.greendao.Property BookName = new org.greenrobot.greendao.Property(4, java.lang.String.class, "bookName", false, "book_name");
        public static final org.greenrobot.greendao.Property GoodsId = new org.greenrobot.greendao.Property(5, java.lang.Integer.TYPE, "goodsId", false, "goods_id");
        public static final org.greenrobot.greendao.Property GoodsPrice = new org.greenrobot.greendao.Property(6, java.lang.Float.TYPE, "goodsPrice", false, "goods_price");
        public static final org.greenrobot.greendao.Property MarketPrice = new org.greenrobot.greendao.Property(7, java.lang.Float.TYPE, "marketPrice", false, "market_price");
        public static final org.greenrobot.greendao.Property GoodsImg = new org.greenrobot.greendao.Property(8, java.lang.String.class, "goodsImg", false, "goods_img");
        public static final org.greenrobot.greendao.Property GoodsBigImg = new org.greenrobot.greendao.Property(9, java.lang.String.class, "goodsBigImg", false, "goods_big_img");
        public static final org.greenrobot.greendao.Property IsShelf = new org.greenrobot.greendao.Property(10, java.lang.Integer.TYPE, "isShelf", false, "is_shelf");
        public static final org.greenrobot.greendao.Property BuyCount = new org.greenrobot.greendao.Property(11, java.lang.String.class, "buyCount", false, "buy_count");
        public static final org.greenrobot.greendao.Property BookType = new org.greenrobot.greendao.Property(12, java.lang.Integer.TYPE, "bookType", false, "book_type");
        public static final org.greenrobot.greendao.Property CategoryType = new org.greenrobot.greendao.Property(13, java.lang.Integer.TYPE, "categoryType", false, "category_type");
        public static final org.greenrobot.greendao.Property IsGoods = new org.greenrobot.greendao.Property(14, java.lang.Integer.TYPE, "isGoods", false, "is_goods");
        public static final org.greenrobot.greendao.Property ToPc = new org.greenrobot.greendao.Property(15, java.lang.Integer.TYPE, "toPc", false, "to_pc");
        public static final org.greenrobot.greendao.Property ToMobile = new org.greenrobot.greendao.Property(16, java.lang.Integer.TYPE, "toMobile", false, "to_mobile");
        public static final org.greenrobot.greendao.Property PackType = new org.greenrobot.greendao.Property(17, java.lang.Integer.TYPE, "packType", false, "pack_type");
        public static final org.greenrobot.greendao.Property StageId = new org.greenrobot.greendao.Property(18, java.lang.Integer.TYPE, "stageId", false, "stage_id");
        public static final org.greenrobot.greendao.Property SubjectId = new org.greenrobot.greendao.Property(19, java.lang.Integer.TYPE, "subjectId", false, "subject_id");
        public static final org.greenrobot.greendao.Property FileId = new org.greenrobot.greendao.Property(20, java.lang.String.class, "fileId", false, "file_id");
        public static final org.greenrobot.greendao.Property PcFileId = new org.greenrobot.greendao.Property(21, java.lang.String.class, "pcFileId", false, "pc_file_id");
        public static final org.greenrobot.greendao.Property WordsFlag = new org.greenrobot.greendao.Property(22, java.lang.String.class, "wordsFlag", false, "words_flag");
        public static final org.greenrobot.greendao.Property SpecialFlag = new org.greenrobot.greendao.Property(23, java.lang.String.class, "specialFlag", false, "special_flag");
        public static final org.greenrobot.greendao.Property StudyTraceFlag = new org.greenrobot.greendao.Property(24, java.lang.String.class, "studyTraceFlag", false, "study_trace_flag");
        public static final org.greenrobot.greendao.Property AddCourseTime = new org.greenrobot.greendao.Property(25, java.lang.Long.TYPE, "addCourseTime", false, "add_course_time");
        public static final org.greenrobot.greendao.Property AuthorName = new org.greenrobot.greendao.Property(26, java.lang.String.class, "authorName", false, "author_name");
        public static final org.greenrobot.greendao.Property MobileRevision = new org.greenrobot.greendao.Property(27, java.lang.String.class, "mobileRevision", false, "mobile_revision");
        public static final org.greenrobot.greendao.Property EndTime = new org.greenrobot.greendao.Property(28, java.lang.Long.TYPE, "endTime", false, "END_TIME");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public CourseBookInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public CourseBookInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"course_book_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"guid\" TEXT,\"course_id\" INTEGER NOT NULL ,\"book_id\" TEXT,\"book_name\" TEXT,\"goods_id\" INTEGER NOT NULL ,\"goods_price\" REAL NOT NULL ,\"market_price\" REAL NOT NULL ,\"goods_img\" TEXT,\"goods_big_img\" TEXT,\"is_shelf\" INTEGER NOT NULL ,\"buy_count\" TEXT,\"book_type\" INTEGER NOT NULL ,\"category_type\" INTEGER NOT NULL ,\"is_goods\" INTEGER NOT NULL ,\"to_pc\" INTEGER NOT NULL ,\"to_mobile\" INTEGER NOT NULL ,\"pack_type\" INTEGER NOT NULL ,\"stage_id\" INTEGER NOT NULL ,\"subject_id\" INTEGER NOT NULL ,\"file_id\" TEXT,\"pc_file_id\" TEXT,\"words_flag\" TEXT,\"special_flag\" TEXT,\"study_trace_flag\" TEXT,\"add_course_time\" INTEGER NOT NULL ,\"author_name\" TEXT,\"mobile_revision\" TEXT,\"END_TIME\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_course_book_info_guid ON \"course_book_info\" (\"guid\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"course_book_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = courseBookInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = courseBookInfo.getGuid();
        if (guid != null) {
            databaseStatement.bindString(2, guid);
        }
        databaseStatement.bindLong(3, courseBookInfo.getCourseId());
        java.lang.String bookId = courseBookInfo.getBookId();
        if (bookId != null) {
            databaseStatement.bindString(4, bookId);
        }
        java.lang.String bookName = courseBookInfo.getBookName();
        if (bookName != null) {
            databaseStatement.bindString(5, bookName);
        }
        databaseStatement.bindLong(6, courseBookInfo.getGoodsId());
        databaseStatement.bindDouble(7, courseBookInfo.getGoodsPrice());
        databaseStatement.bindDouble(8, courseBookInfo.getMarketPrice());
        java.lang.String goodsImg = courseBookInfo.getGoodsImg();
        if (goodsImg != null) {
            databaseStatement.bindString(9, goodsImg);
        }
        java.lang.String goodsBigImg = courseBookInfo.getGoodsBigImg();
        if (goodsBigImg != null) {
            databaseStatement.bindString(10, goodsBigImg);
        }
        databaseStatement.bindLong(11, courseBookInfo.getIsShelf());
        java.lang.String buyCount = courseBookInfo.getBuyCount();
        if (buyCount != null) {
            databaseStatement.bindString(12, buyCount);
        }
        databaseStatement.bindLong(13, courseBookInfo.getBookType());
        databaseStatement.bindLong(14, courseBookInfo.getCategoryType());
        databaseStatement.bindLong(15, courseBookInfo.getIsGoods());
        databaseStatement.bindLong(16, courseBookInfo.getToPc());
        databaseStatement.bindLong(17, courseBookInfo.getToMobile());
        databaseStatement.bindLong(18, courseBookInfo.getPackType());
        databaseStatement.bindLong(19, courseBookInfo.getStageId());
        databaseStatement.bindLong(20, courseBookInfo.getSubjectId());
        java.lang.String fileId = courseBookInfo.getFileId();
        if (fileId != null) {
            databaseStatement.bindString(21, fileId);
        }
        java.lang.String pcFileId = courseBookInfo.getPcFileId();
        if (pcFileId != null) {
            databaseStatement.bindString(22, pcFileId);
        }
        java.lang.String wordsFlag = courseBookInfo.getWordsFlag();
        if (wordsFlag != null) {
            databaseStatement.bindString(23, wordsFlag);
        }
        java.lang.String specialFlag = courseBookInfo.getSpecialFlag();
        if (specialFlag != null) {
            databaseStatement.bindString(24, specialFlag);
        }
        java.lang.String studyTraceFlag = courseBookInfo.getStudyTraceFlag();
        if (studyTraceFlag != null) {
            databaseStatement.bindString(25, studyTraceFlag);
        }
        databaseStatement.bindLong(26, courseBookInfo.getAddCourseTime());
        java.lang.String authorName = courseBookInfo.getAuthorName();
        if (authorName != null) {
            databaseStatement.bindString(27, authorName);
        }
        java.lang.String mobileRevision = courseBookInfo.getMobileRevision();
        if (mobileRevision != null) {
            databaseStatement.bindString(28, mobileRevision);
        }
        databaseStatement.bindLong(29, courseBookInfo.getEndTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = courseBookInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = courseBookInfo.getGuid();
        if (guid != null) {
            sQLiteStatement.bindString(2, guid);
        }
        sQLiteStatement.bindLong(3, courseBookInfo.getCourseId());
        java.lang.String bookId = courseBookInfo.getBookId();
        if (bookId != null) {
            sQLiteStatement.bindString(4, bookId);
        }
        java.lang.String bookName = courseBookInfo.getBookName();
        if (bookName != null) {
            sQLiteStatement.bindString(5, bookName);
        }
        sQLiteStatement.bindLong(6, courseBookInfo.getGoodsId());
        sQLiteStatement.bindDouble(7, courseBookInfo.getGoodsPrice());
        sQLiteStatement.bindDouble(8, courseBookInfo.getMarketPrice());
        java.lang.String goodsImg = courseBookInfo.getGoodsImg();
        if (goodsImg != null) {
            sQLiteStatement.bindString(9, goodsImg);
        }
        java.lang.String goodsBigImg = courseBookInfo.getGoodsBigImg();
        if (goodsBigImg != null) {
            sQLiteStatement.bindString(10, goodsBigImg);
        }
        sQLiteStatement.bindLong(11, courseBookInfo.getIsShelf());
        java.lang.String buyCount = courseBookInfo.getBuyCount();
        if (buyCount != null) {
            sQLiteStatement.bindString(12, buyCount);
        }
        sQLiteStatement.bindLong(13, courseBookInfo.getBookType());
        sQLiteStatement.bindLong(14, courseBookInfo.getCategoryType());
        sQLiteStatement.bindLong(15, courseBookInfo.getIsGoods());
        sQLiteStatement.bindLong(16, courseBookInfo.getToPc());
        sQLiteStatement.bindLong(17, courseBookInfo.getToMobile());
        sQLiteStatement.bindLong(18, courseBookInfo.getPackType());
        sQLiteStatement.bindLong(19, courseBookInfo.getStageId());
        sQLiteStatement.bindLong(20, courseBookInfo.getSubjectId());
        java.lang.String fileId = courseBookInfo.getFileId();
        if (fileId != null) {
            sQLiteStatement.bindString(21, fileId);
        }
        java.lang.String pcFileId = courseBookInfo.getPcFileId();
        if (pcFileId != null) {
            sQLiteStatement.bindString(22, pcFileId);
        }
        java.lang.String wordsFlag = courseBookInfo.getWordsFlag();
        if (wordsFlag != null) {
            sQLiteStatement.bindString(23, wordsFlag);
        }
        java.lang.String specialFlag = courseBookInfo.getSpecialFlag();
        if (specialFlag != null) {
            sQLiteStatement.bindString(24, specialFlag);
        }
        java.lang.String studyTraceFlag = courseBookInfo.getStudyTraceFlag();
        if (studyTraceFlag != null) {
            sQLiteStatement.bindString(25, studyTraceFlag);
        }
        sQLiteStatement.bindLong(26, courseBookInfo.getAddCourseTime());
        java.lang.String authorName = courseBookInfo.getAuthorName();
        if (authorName != null) {
            sQLiteStatement.bindString(27, authorName);
        }
        java.lang.String mobileRevision = courseBookInfo.getMobileRevision();
        if (mobileRevision != null) {
            sQLiteStatement.bindString(28, mobileRevision);
        }
        sQLiteStatement.bindLong(29, courseBookInfo.getEndTime());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m98readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.course.mgr.CourseBookInfo m97readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = cursor.getInt(i + 2);
        int i4 = i + 3;
        java.lang.String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        java.lang.String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = cursor.getInt(i + 5);
        float f = cursor.getFloat(i + 6);
        float f2 = cursor.getFloat(i + 7);
        int i7 = i + 8;
        java.lang.String string4 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 9;
        java.lang.String string5 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = cursor.getInt(i + 10);
        int i10 = i + 11;
        java.lang.String string6 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = cursor.getInt(i + 12);
        int i12 = cursor.getInt(i + 13);
        int i13 = cursor.getInt(i + 14);
        int i14 = cursor.getInt(i + 15);
        int i15 = cursor.getInt(i + 16);
        int i16 = cursor.getInt(i + 17);
        int i17 = cursor.getInt(i + 18);
        int i18 = cursor.getInt(i + 19);
        int i19 = i + 20;
        java.lang.String string7 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = i + 21;
        java.lang.String string8 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 22;
        java.lang.String string9 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = i + 23;
        java.lang.String string10 = cursor.isNull(i22) ? null : cursor.getString(i22);
        int i23 = i + 24;
        java.lang.String string11 = cursor.isNull(i23) ? null : cursor.getString(i23);
        long j = cursor.getLong(i + 25);
        int i24 = i + 26;
        java.lang.String string12 = cursor.isNull(i24) ? null : cursor.getString(i24);
        int i25 = i + 27;
        return new com.up366.mobile.course.mgr.CourseBookInfo(lValueOf, string, i3, string2, string3, i6, f, f2, string4, string5, i9, string6, i11, i12, i13, i14, i15, i16, i17, i18, string7, string8, string9, string10, string11, j, string12, cursor.isNull(i25) ? null : cursor.getString(i25), cursor.getLong(i + 28));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo, int i) {
        courseBookInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        courseBookInfo.setGuid(cursor.isNull(i2) ? null : cursor.getString(i2));
        courseBookInfo.setCourseId(cursor.getInt(i + 2));
        int i3 = i + 3;
        courseBookInfo.setBookId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        courseBookInfo.setBookName(cursor.isNull(i4) ? null : cursor.getString(i4));
        courseBookInfo.setGoodsId(cursor.getInt(i + 5));
        courseBookInfo.setGoodsPrice(cursor.getFloat(i + 6));
        courseBookInfo.setMarketPrice(cursor.getFloat(i + 7));
        int i5 = i + 8;
        courseBookInfo.setGoodsImg(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 9;
        courseBookInfo.setGoodsBigImg(cursor.isNull(i6) ? null : cursor.getString(i6));
        courseBookInfo.setIsShelf(cursor.getInt(i + 10));
        int i7 = i + 11;
        courseBookInfo.setBuyCount(cursor.isNull(i7) ? null : cursor.getString(i7));
        courseBookInfo.setBookType(cursor.getInt(i + 12));
        courseBookInfo.setCategoryType(cursor.getInt(i + 13));
        courseBookInfo.setIsGoods(cursor.getInt(i + 14));
        courseBookInfo.setToPc(cursor.getInt(i + 15));
        courseBookInfo.setToMobile(cursor.getInt(i + 16));
        courseBookInfo.setPackType(cursor.getInt(i + 17));
        courseBookInfo.setStageId(cursor.getInt(i + 18));
        courseBookInfo.setSubjectId(cursor.getInt(i + 19));
        int i8 = i + 20;
        courseBookInfo.setFileId(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 21;
        courseBookInfo.setPcFileId(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 22;
        courseBookInfo.setWordsFlag(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 23;
        courseBookInfo.setSpecialFlag(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 24;
        courseBookInfo.setStudyTraceFlag(cursor.isNull(i12) ? null : cursor.getString(i12));
        courseBookInfo.setAddCourseTime(cursor.getLong(i + 25));
        int i13 = i + 26;
        courseBookInfo.setAuthorName(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 27;
        courseBookInfo.setMobileRevision(cursor.isNull(i14) ? null : cursor.getString(i14));
        courseBookInfo.setEndTime(cursor.getLong(i + 28));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo, long j) {
        courseBookInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo) {
        if (courseBookInfo != null) {
            return courseBookInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo) {
        return courseBookInfo.getRowId() != null;
    }
}
