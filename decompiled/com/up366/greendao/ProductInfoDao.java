package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ProductInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.common.logic.model.ProductInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "product_info";

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
        public static final org.greenrobot.greendao.Property IsShelf = new org.greenrobot.greendao.Property(20, java.lang.Integer.TYPE, "isShelf", false, "is_shelf");
        public static final org.greenrobot.greendao.Property IsGoods = new org.greenrobot.greendao.Property(21, java.lang.Integer.TYPE, "isGoods", false, "is_goods");
        public static final org.greenrobot.greendao.Property GoodsPrice = new org.greenrobot.greendao.Property(22, java.lang.Float.TYPE, "goodsPrice", false, "goods_price");
        public static final org.greenrobot.greendao.Property AuthorName = new org.greenrobot.greendao.Property(23, java.lang.String.class, "authorName", false, "author_name");
        public static final org.greenrobot.greendao.Property MobileRevision = new org.greenrobot.greendao.Property(24, java.lang.String.class, "mobileRevision", false, "mobile_revision");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public ProductInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public ProductInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"product_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"book_id\" TEXT,\"book_name\" TEXT,\"goods_id\" INTEGER NOT NULL ,\"goods_big_img\" TEXT,\"goods_img\" TEXT,\"add_time\" INTEGER NOT NULL ,\"start_date\" INTEGER NOT NULL ,\"end_date\" INTEGER NOT NULL ,\"valid_days\" INTEGER NOT NULL ,\"stage_id\" INTEGER NOT NULL ,\"subject_id\" INTEGER NOT NULL ,\"category_type\" INTEGER NOT NULL ,\"pack_type\" INTEGER NOT NULL ,\"file_id\" TEXT,\"pc_file_id\" TEXT,\"sp_id\" INTEGER NOT NULL ,\"book_type\" INTEGER NOT NULL ,\"to_p_c\" INTEGER NOT NULL ,\"to_mobile\" INTEGER NOT NULL ,\"is_shelf\" INTEGER NOT NULL ,\"is_goods\" INTEGER NOT NULL ,\"goods_price\" REAL NOT NULL ,\"author_name\" TEXT,\"mobile_revision\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_product_info_book_id ON \"product_info\" (\"book_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"product_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = productInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String bookId = productInfo.getBookId();
        if (bookId != null) {
            databaseStatement.bindString(2, bookId);
        }
        java.lang.String bookName = productInfo.getBookName();
        if (bookName != null) {
            databaseStatement.bindString(3, bookName);
        }
        databaseStatement.bindLong(4, productInfo.getGoodsId());
        java.lang.String goodsBigImg = productInfo.getGoodsBigImg();
        if (goodsBigImg != null) {
            databaseStatement.bindString(5, goodsBigImg);
        }
        java.lang.String goodsImg = productInfo.getGoodsImg();
        if (goodsImg != null) {
            databaseStatement.bindString(6, goodsImg);
        }
        databaseStatement.bindLong(7, productInfo.getAddTime());
        databaseStatement.bindLong(8, productInfo.getStartDate());
        databaseStatement.bindLong(9, productInfo.getEndDate());
        databaseStatement.bindLong(10, productInfo.getValidDays());
        databaseStatement.bindLong(11, productInfo.getStageId());
        databaseStatement.bindLong(12, productInfo.getSubjectId());
        databaseStatement.bindLong(13, productInfo.getCategoryType());
        databaseStatement.bindLong(14, productInfo.getPackType());
        java.lang.String fileId = productInfo.getFileId();
        if (fileId != null) {
            databaseStatement.bindString(15, fileId);
        }
        java.lang.String pcFileId = productInfo.getPcFileId();
        if (pcFileId != null) {
            databaseStatement.bindString(16, pcFileId);
        }
        databaseStatement.bindLong(17, productInfo.getSpId());
        databaseStatement.bindLong(18, productInfo.getBookType());
        databaseStatement.bindLong(19, productInfo.getToPC());
        databaseStatement.bindLong(20, productInfo.getToMobile());
        databaseStatement.bindLong(21, productInfo.getIsShelf());
        databaseStatement.bindLong(22, productInfo.getIsGoods());
        databaseStatement.bindDouble(23, productInfo.getGoodsPrice());
        java.lang.String authorName = productInfo.getAuthorName();
        if (authorName != null) {
            databaseStatement.bindString(24, authorName);
        }
        java.lang.String mobileRevision = productInfo.getMobileRevision();
        if (mobileRevision != null) {
            databaseStatement.bindString(25, mobileRevision);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = productInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String bookId = productInfo.getBookId();
        if (bookId != null) {
            sQLiteStatement.bindString(2, bookId);
        }
        java.lang.String bookName = productInfo.getBookName();
        if (bookName != null) {
            sQLiteStatement.bindString(3, bookName);
        }
        sQLiteStatement.bindLong(4, productInfo.getGoodsId());
        java.lang.String goodsBigImg = productInfo.getGoodsBigImg();
        if (goodsBigImg != null) {
            sQLiteStatement.bindString(5, goodsBigImg);
        }
        java.lang.String goodsImg = productInfo.getGoodsImg();
        if (goodsImg != null) {
            sQLiteStatement.bindString(6, goodsImg);
        }
        sQLiteStatement.bindLong(7, productInfo.getAddTime());
        sQLiteStatement.bindLong(8, productInfo.getStartDate());
        sQLiteStatement.bindLong(9, productInfo.getEndDate());
        sQLiteStatement.bindLong(10, productInfo.getValidDays());
        sQLiteStatement.bindLong(11, productInfo.getStageId());
        sQLiteStatement.bindLong(12, productInfo.getSubjectId());
        sQLiteStatement.bindLong(13, productInfo.getCategoryType());
        sQLiteStatement.bindLong(14, productInfo.getPackType());
        java.lang.String fileId = productInfo.getFileId();
        if (fileId != null) {
            sQLiteStatement.bindString(15, fileId);
        }
        java.lang.String pcFileId = productInfo.getPcFileId();
        if (pcFileId != null) {
            sQLiteStatement.bindString(16, pcFileId);
        }
        sQLiteStatement.bindLong(17, productInfo.getSpId());
        sQLiteStatement.bindLong(18, productInfo.getBookType());
        sQLiteStatement.bindLong(19, productInfo.getToPC());
        sQLiteStatement.bindLong(20, productInfo.getToMobile());
        sQLiteStatement.bindLong(21, productInfo.getIsShelf());
        sQLiteStatement.bindLong(22, productInfo.getIsGoods());
        sQLiteStatement.bindDouble(23, productInfo.getGoodsPrice());
        java.lang.String authorName = productInfo.getAuthorName();
        if (authorName != null) {
            sQLiteStatement.bindString(24, authorName);
        }
        java.lang.String mobileRevision = productInfo.getMobileRevision();
        if (mobileRevision != null) {
            sQLiteStatement.bindString(25, mobileRevision);
        }
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m116readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.common.logic.model.ProductInfo m115readEntity(android.database.Cursor cursor, int i) {
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
        float f = cursor.getFloat(i + 22);
        int i20 = i + 23;
        java.lang.String string7 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 24;
        return new com.up366.mobile.common.logic.model.ProductInfo(lValueOf, string, string2, i4, string3, string4, j, j2, j3, i7, i8, i9, i10, i11, string5, string6, i14, i15, i16, i17, i18, i19, f, string7, cursor.isNull(i21) ? null : cursor.getString(i21));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.common.logic.model.ProductInfo productInfo, int i) {
        productInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        productInfo.setBookId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        productInfo.setBookName(cursor.isNull(i3) ? null : cursor.getString(i3));
        productInfo.setGoodsId(cursor.getInt(i + 3));
        int i4 = i + 4;
        productInfo.setGoodsBigImg(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 5;
        productInfo.setGoodsImg(cursor.isNull(i5) ? null : cursor.getString(i5));
        productInfo.setAddTime(cursor.getLong(i + 6));
        productInfo.setStartDate(cursor.getLong(i + 7));
        productInfo.setEndDate(cursor.getLong(i + 8));
        productInfo.setValidDays(cursor.getInt(i + 9));
        productInfo.setStageId(cursor.getInt(i + 10));
        productInfo.setSubjectId(cursor.getInt(i + 11));
        productInfo.setCategoryType(cursor.getInt(i + 12));
        productInfo.setPackType(cursor.getInt(i + 13));
        int i6 = i + 14;
        productInfo.setFileId(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 15;
        productInfo.setPcFileId(cursor.isNull(i7) ? null : cursor.getString(i7));
        productInfo.setSpId(cursor.getInt(i + 16));
        productInfo.setBookType(cursor.getInt(i + 17));
        productInfo.setToPC(cursor.getInt(i + 18));
        productInfo.setToMobile(cursor.getInt(i + 19));
        productInfo.setIsShelf(cursor.getInt(i + 20));
        productInfo.setIsGoods(cursor.getInt(i + 21));
        productInfo.setGoodsPrice(cursor.getFloat(i + 22));
        int i8 = i + 23;
        productInfo.setAuthorName(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 24;
        productInfo.setMobileRevision(cursor.isNull(i9) ? null : cursor.getString(i9));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.common.logic.model.ProductInfo productInfo, long j) {
        productInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        if (productInfo != null) {
            return productInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        return productInfo.getRowId() != null;
    }
}
