package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookDetailInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.book.model.BookDetailInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "book_detail_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property BookId = new org.greenrobot.greendao.Property(1, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, false, "book_id");
        public static final org.greenrobot.greendao.Property BookName = new org.greenrobot.greendao.Property(2, java.lang.String.class, "bookName", false, "book_name");
        public static final org.greenrobot.greendao.Property GoodsId = new org.greenrobot.greendao.Property(3, java.lang.Integer.TYPE, "goodsId", false, "goods_id");
        public static final org.greenrobot.greendao.Property GoodsBigImg = new org.greenrobot.greendao.Property(4, java.lang.String.class, "goodsBigImg", false, "goods_big_img");
        public static final org.greenrobot.greendao.Property GoodsImg = new org.greenrobot.greendao.Property(5, java.lang.String.class, "goodsImg", false, "goods_img");
        public static final org.greenrobot.greendao.Property AddTime = new org.greenrobot.greendao.Property(6, java.lang.Long.TYPE, "addTime", false, "add_time");
        public static final org.greenrobot.greendao.Property StartDate = new org.greenrobot.greendao.Property(7, java.lang.Long.TYPE, "startDate", false, "start_date");
        public static final org.greenrobot.greendao.Property EndDate = new org.greenrobot.greendao.Property(8, java.lang.Long.TYPE, "endDate", false, "end_date");
        public static final org.greenrobot.greendao.Property ValidDays = new org.greenrobot.greendao.Property(9, java.lang.Integer.TYPE, "validDays", false, "valid_days");
        public static final org.greenrobot.greendao.Property StageId = new org.greenrobot.greendao.Property(10, java.lang.Integer.TYPE, "stageId", false, "stage_id");
        public static final org.greenrobot.greendao.Property SubjectId = new org.greenrobot.greendao.Property(11, java.lang.Integer.TYPE, "subjectId", false, "subject_id");
        public static final org.greenrobot.greendao.Property CategoryType = new org.greenrobot.greendao.Property(12, java.lang.Integer.TYPE, "categoryType", false, "category_type");
        public static final org.greenrobot.greendao.Property PackType = new org.greenrobot.greendao.Property(13, java.lang.Integer.TYPE, "packType", false, "pack_type");
        public static final org.greenrobot.greendao.Property FileId = new org.greenrobot.greendao.Property(14, java.lang.String.class, "fileId", false, "file_id");
        public static final org.greenrobot.greendao.Property PcFileId = new org.greenrobot.greendao.Property(15, java.lang.String.class, "pcFileId", false, "pc_file_id");
        public static final org.greenrobot.greendao.Property SpId = new org.greenrobot.greendao.Property(16, java.lang.Integer.TYPE, "spId", false, "sp_id");
        public static final org.greenrobot.greendao.Property BookType = new org.greenrobot.greendao.Property(17, java.lang.Integer.TYPE, "bookType", false, "book_type");
        public static final org.greenrobot.greendao.Property ToPC = new org.greenrobot.greendao.Property(18, java.lang.Integer.TYPE, "toPC", false, "to_p_c");
        public static final org.greenrobot.greendao.Property ToMobile = new org.greenrobot.greendao.Property(19, java.lang.Integer.TYPE, "toMobile", false, "to_mobile");
        public static final org.greenrobot.greendao.Property IsOwned = new org.greenrobot.greendao.Property(20, java.lang.Integer.TYPE, "isOwned", false, "is_owned");
        public static final org.greenrobot.greendao.Property IsShelf = new org.greenrobot.greendao.Property(21, java.lang.Integer.TYPE, "isShelf", false, "is_shelf");
        public static final org.greenrobot.greendao.Property IsGoods = new org.greenrobot.greendao.Property(22, java.lang.Integer.TYPE, "isGoods", false, "is_goods");
        public static final org.greenrobot.greendao.Property GoodsPrice = new org.greenrobot.greendao.Property(23, java.lang.Float.TYPE, "goodsPrice", false, "goods_price");
        public static final org.greenrobot.greendao.Property Configs = new org.greenrobot.greendao.Property(24, java.lang.String.class, "configs", false, "configs");
        public static final org.greenrobot.greendao.Property ResourceList = new org.greenrobot.greendao.Property(25, java.lang.String.class, "resourceList", false, "resource_list");
        public static final org.greenrobot.greendao.Property OpenUrl = new org.greenrobot.greendao.Property(26, java.lang.String.class, "openUrl", false, "open_url");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public BookDetailInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public BookDetailInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"book_detail_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"book_id\" TEXT,\"book_name\" TEXT,\"goods_id\" INTEGER NOT NULL ,\"goods_big_img\" TEXT,\"goods_img\" TEXT,\"add_time\" INTEGER NOT NULL ,\"start_date\" INTEGER NOT NULL ,\"end_date\" INTEGER NOT NULL ,\"valid_days\" INTEGER NOT NULL ,\"stage_id\" INTEGER NOT NULL ,\"subject_id\" INTEGER NOT NULL ,\"category_type\" INTEGER NOT NULL ,\"pack_type\" INTEGER NOT NULL ,\"file_id\" TEXT,\"pc_file_id\" TEXT,\"sp_id\" INTEGER NOT NULL ,\"book_type\" INTEGER NOT NULL ,\"to_p_c\" INTEGER NOT NULL ,\"to_mobile\" INTEGER NOT NULL ,\"is_owned\" INTEGER NOT NULL ,\"is_shelf\" INTEGER NOT NULL ,\"is_goods\" INTEGER NOT NULL ,\"goods_price\" REAL NOT NULL ,\"configs\" TEXT,\"resource_list\" TEXT,\"open_url\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_book_detail_info_book_id ON \"book_detail_info\" (\"book_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"book_detail_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = bookDetailInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String bookId = bookDetailInfo.getBookId();
        if (bookId != null) {
            databaseStatement.bindString(2, bookId);
        }
        java.lang.String bookName = bookDetailInfo.getBookName();
        if (bookName != null) {
            databaseStatement.bindString(3, bookName);
        }
        databaseStatement.bindLong(4, bookDetailInfo.getGoodsId());
        java.lang.String goodsBigImg = bookDetailInfo.getGoodsBigImg();
        if (goodsBigImg != null) {
            databaseStatement.bindString(5, goodsBigImg);
        }
        java.lang.String goodsImg = bookDetailInfo.getGoodsImg();
        if (goodsImg != null) {
            databaseStatement.bindString(6, goodsImg);
        }
        databaseStatement.bindLong(7, bookDetailInfo.getAddTime());
        databaseStatement.bindLong(8, bookDetailInfo.getStartDate());
        databaseStatement.bindLong(9, bookDetailInfo.getEndDate());
        databaseStatement.bindLong(10, bookDetailInfo.getValidDays());
        databaseStatement.bindLong(11, bookDetailInfo.getStageId());
        databaseStatement.bindLong(12, bookDetailInfo.getSubjectId());
        databaseStatement.bindLong(13, bookDetailInfo.getCategoryType());
        databaseStatement.bindLong(14, bookDetailInfo.getPackType());
        java.lang.String fileId = bookDetailInfo.getFileId();
        if (fileId != null) {
            databaseStatement.bindString(15, fileId);
        }
        java.lang.String pcFileId = bookDetailInfo.getPcFileId();
        if (pcFileId != null) {
            databaseStatement.bindString(16, pcFileId);
        }
        databaseStatement.bindLong(17, bookDetailInfo.getSpId());
        databaseStatement.bindLong(18, bookDetailInfo.getBookType());
        databaseStatement.bindLong(19, bookDetailInfo.getToPC());
        databaseStatement.bindLong(20, bookDetailInfo.getToMobile());
        databaseStatement.bindLong(21, bookDetailInfo.getIsOwned());
        databaseStatement.bindLong(22, bookDetailInfo.getIsShelf());
        databaseStatement.bindLong(23, bookDetailInfo.getIsGoods());
        databaseStatement.bindDouble(24, bookDetailInfo.getGoodsPrice());
        java.lang.String configs = bookDetailInfo.getConfigs();
        if (configs != null) {
            databaseStatement.bindString(25, configs);
        }
        java.lang.String resourceList = bookDetailInfo.getResourceList();
        if (resourceList != null) {
            databaseStatement.bindString(26, resourceList);
        }
        java.lang.String openUrl = bookDetailInfo.getOpenUrl();
        if (openUrl != null) {
            databaseStatement.bindString(27, openUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = bookDetailInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String bookId = bookDetailInfo.getBookId();
        if (bookId != null) {
            sQLiteStatement.bindString(2, bookId);
        }
        java.lang.String bookName = bookDetailInfo.getBookName();
        if (bookName != null) {
            sQLiteStatement.bindString(3, bookName);
        }
        sQLiteStatement.bindLong(4, bookDetailInfo.getGoodsId());
        java.lang.String goodsBigImg = bookDetailInfo.getGoodsBigImg();
        if (goodsBigImg != null) {
            sQLiteStatement.bindString(5, goodsBigImg);
        }
        java.lang.String goodsImg = bookDetailInfo.getGoodsImg();
        if (goodsImg != null) {
            sQLiteStatement.bindString(6, goodsImg);
        }
        sQLiteStatement.bindLong(7, bookDetailInfo.getAddTime());
        sQLiteStatement.bindLong(8, bookDetailInfo.getStartDate());
        sQLiteStatement.bindLong(9, bookDetailInfo.getEndDate());
        sQLiteStatement.bindLong(10, bookDetailInfo.getValidDays());
        sQLiteStatement.bindLong(11, bookDetailInfo.getStageId());
        sQLiteStatement.bindLong(12, bookDetailInfo.getSubjectId());
        sQLiteStatement.bindLong(13, bookDetailInfo.getCategoryType());
        sQLiteStatement.bindLong(14, bookDetailInfo.getPackType());
        java.lang.String fileId = bookDetailInfo.getFileId();
        if (fileId != null) {
            sQLiteStatement.bindString(15, fileId);
        }
        java.lang.String pcFileId = bookDetailInfo.getPcFileId();
        if (pcFileId != null) {
            sQLiteStatement.bindString(16, pcFileId);
        }
        sQLiteStatement.bindLong(17, bookDetailInfo.getSpId());
        sQLiteStatement.bindLong(18, bookDetailInfo.getBookType());
        sQLiteStatement.bindLong(19, bookDetailInfo.getToPC());
        sQLiteStatement.bindLong(20, bookDetailInfo.getToMobile());
        sQLiteStatement.bindLong(21, bookDetailInfo.getIsOwned());
        sQLiteStatement.bindLong(22, bookDetailInfo.getIsShelf());
        sQLiteStatement.bindLong(23, bookDetailInfo.getIsGoods());
        sQLiteStatement.bindDouble(24, bookDetailInfo.getGoodsPrice());
        java.lang.String configs = bookDetailInfo.getConfigs();
        if (configs != null) {
            sQLiteStatement.bindString(25, configs);
        }
        java.lang.String resourceList = bookDetailInfo.getResourceList();
        if (resourceList != null) {
            sQLiteStatement.bindString(26, resourceList);
        }
        java.lang.String openUrl = bookDetailInfo.getOpenUrl();
        if (openUrl != null) {
            sQLiteStatement.bindString(27, openUrl);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m86readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.BookDetailInfo m85readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = cursor.getInt(i + 3);
        int i5 = i + 4;
        java.lang.String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        java.lang.String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        long j = cursor.getLong(i + 6);
        long j2 = cursor.getLong(i + 7);
        long j3 = cursor.getLong(i + 8);
        int i7 = cursor.getInt(i + 9);
        int i8 = cursor.getInt(i + 10);
        int i9 = cursor.getInt(i + 11);
        int i10 = cursor.getInt(i + 12);
        int i11 = cursor.getInt(i + 13);
        int i12 = i + 14;
        java.lang.String string5 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i + 15;
        java.lang.String string6 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = cursor.getInt(i + 16);
        int i15 = cursor.getInt(i + 17);
        int i16 = cursor.getInt(i + 18);
        int i17 = cursor.getInt(i + 19);
        int i18 = cursor.getInt(i + 20);
        int i19 = cursor.getInt(i + 21);
        int i20 = cursor.getInt(i + 22);
        float f = cursor.getFloat(i + 23);
        int i21 = i + 24;
        java.lang.String string7 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = i + 25;
        java.lang.String string8 = cursor.isNull(i22) ? null : cursor.getString(i22);
        int i23 = i + 26;
        return new com.up366.mobile.book.model.BookDetailInfo(lValueOf, string, string2, i4, string3, string4, j, j2, j3, i7, i8, i9, i10, i11, string5, string6, i14, i15, i16, i17, i18, i19, i20, f, string7, string8, cursor.isNull(i23) ? null : cursor.getString(i23));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo, int i) {
        bookDetailInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        bookDetailInfo.setBookId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        bookDetailInfo.setBookName(cursor.isNull(i3) ? null : cursor.getString(i3));
        bookDetailInfo.setGoodsId(cursor.getInt(i + 3));
        int i4 = i + 4;
        bookDetailInfo.setGoodsBigImg(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 5;
        bookDetailInfo.setGoodsImg(cursor.isNull(i5) ? null : cursor.getString(i5));
        bookDetailInfo.setAddTime(cursor.getLong(i + 6));
        bookDetailInfo.setStartDate(cursor.getLong(i + 7));
        bookDetailInfo.setEndDate(cursor.getLong(i + 8));
        bookDetailInfo.setValidDays(cursor.getInt(i + 9));
        bookDetailInfo.setStageId(cursor.getInt(i + 10));
        bookDetailInfo.setSubjectId(cursor.getInt(i + 11));
        bookDetailInfo.setCategoryType(cursor.getInt(i + 12));
        bookDetailInfo.setPackType(cursor.getInt(i + 13));
        int i6 = i + 14;
        bookDetailInfo.setFileId(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 15;
        bookDetailInfo.setPcFileId(cursor.isNull(i7) ? null : cursor.getString(i7));
        bookDetailInfo.setSpId(cursor.getInt(i + 16));
        bookDetailInfo.setBookType(cursor.getInt(i + 17));
        bookDetailInfo.setToPC(cursor.getInt(i + 18));
        bookDetailInfo.setToMobile(cursor.getInt(i + 19));
        bookDetailInfo.setIsOwned(cursor.getInt(i + 20));
        bookDetailInfo.setIsShelf(cursor.getInt(i + 21));
        bookDetailInfo.setIsGoods(cursor.getInt(i + 22));
        bookDetailInfo.setGoodsPrice(cursor.getFloat(i + 23));
        int i8 = i + 24;
        bookDetailInfo.setConfigs(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 25;
        bookDetailInfo.setResourceList(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 26;
        bookDetailInfo.setOpenUrl(cursor.isNull(i10) ? null : cursor.getString(i10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.book.model.BookDetailInfo bookDetailInfo, long j) {
        bookDetailInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        if (bookDetailInfo != null) {
            return bookDetailInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        return bookDetailInfo.getRowId() != null;
    }
}
