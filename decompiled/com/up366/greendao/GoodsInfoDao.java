package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GoodsInfoDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.market.GoodsInfo, java.lang.Long> {
    public static final java.lang.String TABLENAME = "goods_info";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property Guid = new org.greenrobot.greendao.Property(1, java.lang.String.class, "guid", false, "guid");
        public static final org.greenrobot.greendao.Property GoodsId = new org.greenrobot.greendao.Property(2, java.lang.Integer.TYPE, "goodsId", false, "goods_id");
        public static final org.greenrobot.greendao.Property BuyCount = new org.greenrobot.greendao.Property(3, java.lang.String.class, "buyCount", false, "buy_count");
        public static final org.greenrobot.greendao.Property GoodsBrief = new org.greenrobot.greendao.Property(4, java.lang.String.class, "goodsBrief", false, "goods_brief");
        public static final org.greenrobot.greendao.Property HasBuy = new org.greenrobot.greendao.Property(5, java.lang.Boolean.TYPE, "hasBuy", false, "has_buy");
        public static final org.greenrobot.greendao.Property CategoryId = new org.greenrobot.greendao.Property(6, java.lang.Integer.TYPE, "categoryId", false, "category_id");
        public static final org.greenrobot.greendao.Property CategoryType = new org.greenrobot.greendao.Property(7, java.lang.Integer.TYPE, "categoryType", false, "category_type");
        public static final org.greenrobot.greendao.Property GoodsBigImg = new org.greenrobot.greendao.Property(8, java.lang.String.class, "goodsBigImg", false, "goods_big_img");
        public static final org.greenrobot.greendao.Property GoodsImg = new org.greenrobot.greendao.Property(9, java.lang.String.class, "goodsImg", false, "goods_img");
        public static final org.greenrobot.greendao.Property GoodsName = new org.greenrobot.greendao.Property(10, java.lang.String.class, "goodsName", false, "goods_name");
        public static final org.greenrobot.greendao.Property GoodsPrice = new org.greenrobot.greendao.Property(11, java.lang.Float.TYPE, "goodsPrice", false, "goods_price");
        public static final org.greenrobot.greendao.Property IsGroup = new org.greenrobot.greendao.Property(12, java.lang.Integer.TYPE, "isGroup", false, "is_group");
        public static final org.greenrobot.greendao.Property MarketPrice = new org.greenrobot.greendao.Property(13, java.lang.Float.TYPE, "marketPrice", false, "market_price");
        public static final org.greenrobot.greendao.Property PackType = new org.greenrobot.greendao.Property(14, java.lang.Integer.TYPE, "packType", false, "pack_type");
        public static final org.greenrobot.greendao.Property SortOrder = new org.greenrobot.greendao.Property(15, java.lang.Integer.TYPE, "sortOrder", false, "sort_order");
        public static final org.greenrobot.greendao.Property SpGoodsId = new org.greenrobot.greendao.Property(16, java.lang.String.class, "spGoodsId", false, "sp_goods_id");
        public static final org.greenrobot.greendao.Property SpId = new org.greenrobot.greendao.Property(17, java.lang.Integer.TYPE, "spId", false, "sp_id");
        public static final org.greenrobot.greendao.Property StageId = new org.greenrobot.greendao.Property(18, java.lang.Integer.TYPE, "stageId", false, "stage_id");
        public static final org.greenrobot.greendao.Property SubjectId = new org.greenrobot.greendao.Property(19, java.lang.Integer.TYPE, "subjectId", false, "subject_id");
        public static final org.greenrobot.greendao.Property RecommentId = new org.greenrobot.greendao.Property(20, java.lang.Integer.TYPE, "recommentId", false, "recommend_id");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public GoodsInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public GoodsInfoDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"goods_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"guid\" TEXT UNIQUE ,\"goods_id\" INTEGER NOT NULL ,\"buy_count\" TEXT,\"goods_brief\" TEXT,\"has_buy\" INTEGER NOT NULL ,\"category_id\" INTEGER NOT NULL ,\"category_type\" INTEGER NOT NULL ,\"goods_big_img\" TEXT,\"goods_img\" TEXT,\"goods_name\" TEXT,\"goods_price\" REAL NOT NULL ,\"is_group\" INTEGER NOT NULL ,\"market_price\" REAL NOT NULL ,\"pack_type\" INTEGER NOT NULL ,\"sort_order\" INTEGER NOT NULL ,\"sp_goods_id\" TEXT,\"sp_id\" INTEGER NOT NULL ,\"stage_id\" INTEGER NOT NULL ,\"subject_id\" INTEGER NOT NULL ,\"recommend_id\" INTEGER NOT NULL );");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"goods_info\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.market.GoodsInfo goodsInfo) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = goodsInfo.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = goodsInfo.getGuid();
        if (guid != null) {
            databaseStatement.bindString(2, guid);
        }
        databaseStatement.bindLong(3, goodsInfo.getGoodsId());
        java.lang.String buyCount = goodsInfo.getBuyCount();
        if (buyCount != null) {
            databaseStatement.bindString(4, buyCount);
        }
        java.lang.String goodsBrief = goodsInfo.getGoodsBrief();
        if (goodsBrief != null) {
            databaseStatement.bindString(5, goodsBrief);
        }
        databaseStatement.bindLong(6, goodsInfo.getHasBuy() ? 1L : 0L);
        databaseStatement.bindLong(7, goodsInfo.getCategoryId());
        databaseStatement.bindLong(8, goodsInfo.getCategoryType());
        java.lang.String goodsBigImg = goodsInfo.getGoodsBigImg();
        if (goodsBigImg != null) {
            databaseStatement.bindString(9, goodsBigImg);
        }
        java.lang.String goodsImg = goodsInfo.getGoodsImg();
        if (goodsImg != null) {
            databaseStatement.bindString(10, goodsImg);
        }
        java.lang.String goodsName = goodsInfo.getGoodsName();
        if (goodsName != null) {
            databaseStatement.bindString(11, goodsName);
        }
        databaseStatement.bindDouble(12, goodsInfo.getGoodsPrice());
        databaseStatement.bindLong(13, goodsInfo.getIsGroup());
        databaseStatement.bindDouble(14, goodsInfo.getMarketPrice());
        databaseStatement.bindLong(15, goodsInfo.getPackType());
        databaseStatement.bindLong(16, goodsInfo.getSortOrder());
        java.lang.String spGoodsId = goodsInfo.getSpGoodsId();
        if (spGoodsId != null) {
            databaseStatement.bindString(17, spGoodsId);
        }
        databaseStatement.bindLong(18, goodsInfo.getSpId());
        databaseStatement.bindLong(19, goodsInfo.getStageId());
        databaseStatement.bindLong(20, goodsInfo.getSubjectId());
        databaseStatement.bindLong(21, goodsInfo.getRecommentId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.market.GoodsInfo goodsInfo) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = goodsInfo.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String guid = goodsInfo.getGuid();
        if (guid != null) {
            sQLiteStatement.bindString(2, guid);
        }
        sQLiteStatement.bindLong(3, goodsInfo.getGoodsId());
        java.lang.String buyCount = goodsInfo.getBuyCount();
        if (buyCount != null) {
            sQLiteStatement.bindString(4, buyCount);
        }
        java.lang.String goodsBrief = goodsInfo.getGoodsBrief();
        if (goodsBrief != null) {
            sQLiteStatement.bindString(5, goodsBrief);
        }
        sQLiteStatement.bindLong(6, goodsInfo.getHasBuy() ? 1L : 0L);
        sQLiteStatement.bindLong(7, goodsInfo.getCategoryId());
        sQLiteStatement.bindLong(8, goodsInfo.getCategoryType());
        java.lang.String goodsBigImg = goodsInfo.getGoodsBigImg();
        if (goodsBigImg != null) {
            sQLiteStatement.bindString(9, goodsBigImg);
        }
        java.lang.String goodsImg = goodsInfo.getGoodsImg();
        if (goodsImg != null) {
            sQLiteStatement.bindString(10, goodsImg);
        }
        java.lang.String goodsName = goodsInfo.getGoodsName();
        if (goodsName != null) {
            sQLiteStatement.bindString(11, goodsName);
        }
        sQLiteStatement.bindDouble(12, goodsInfo.getGoodsPrice());
        sQLiteStatement.bindLong(13, goodsInfo.getIsGroup());
        sQLiteStatement.bindDouble(14, goodsInfo.getMarketPrice());
        sQLiteStatement.bindLong(15, goodsInfo.getPackType());
        sQLiteStatement.bindLong(16, goodsInfo.getSortOrder());
        java.lang.String spGoodsId = goodsInfo.getSpGoodsId();
        if (spGoodsId != null) {
            sQLiteStatement.bindString(17, spGoodsId);
        }
        sQLiteStatement.bindLong(18, goodsInfo.getSpId());
        sQLiteStatement.bindLong(19, goodsInfo.getStageId());
        sQLiteStatement.bindLong(20, goodsInfo.getSubjectId());
        sQLiteStatement.bindLong(21, goodsInfo.getRecommentId());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m110readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.market.GoodsInfo m109readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = cursor.getInt(i + 2);
        int i4 = i + 3;
        java.lang.String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        java.lang.String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        boolean z = cursor.getShort(i + 5) != 0;
        int i6 = cursor.getInt(i + 6);
        int i7 = cursor.getInt(i + 7);
        int i8 = i + 8;
        java.lang.String string4 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 9;
        java.lang.String string5 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 10;
        java.lang.String string6 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 16;
        return new com.up366.mobile.market.GoodsInfo(lValueOf, string, i3, string2, string3, z, i6, i7, string4, string5, string6, cursor.getFloat(i + 11), cursor.getInt(i + 12), cursor.getFloat(i + 13), cursor.getInt(i + 14), cursor.getInt(i + 15), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.getInt(i + 17), cursor.getInt(i + 18), cursor.getInt(i + 19), cursor.getInt(i + 20));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.market.GoodsInfo goodsInfo, int i) {
        goodsInfo.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        goodsInfo.setGuid(cursor.isNull(i2) ? null : cursor.getString(i2));
        goodsInfo.setGoodsId(cursor.getInt(i + 2));
        int i3 = i + 3;
        goodsInfo.setBuyCount(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 4;
        goodsInfo.setGoodsBrief(cursor.isNull(i4) ? null : cursor.getString(i4));
        goodsInfo.setHasBuy(cursor.getShort(i + 5) != 0);
        goodsInfo.setCategoryId(cursor.getInt(i + 6));
        goodsInfo.setCategoryType(cursor.getInt(i + 7));
        int i5 = i + 8;
        goodsInfo.setGoodsBigImg(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 9;
        goodsInfo.setGoodsImg(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 10;
        goodsInfo.setGoodsName(cursor.isNull(i7) ? null : cursor.getString(i7));
        goodsInfo.setGoodsPrice(cursor.getFloat(i + 11));
        goodsInfo.setIsGroup(cursor.getInt(i + 12));
        goodsInfo.setMarketPrice(cursor.getFloat(i + 13));
        goodsInfo.setPackType(cursor.getInt(i + 14));
        goodsInfo.setSortOrder(cursor.getInt(i + 15));
        int i8 = i + 16;
        goodsInfo.setSpGoodsId(cursor.isNull(i8) ? null : cursor.getString(i8));
        goodsInfo.setSpId(cursor.getInt(i + 17));
        goodsInfo.setStageId(cursor.getInt(i + 18));
        goodsInfo.setSubjectId(cursor.getInt(i + 19));
        goodsInfo.setRecommentId(cursor.getInt(i + 20));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.market.GoodsInfo goodsInfo, long j) {
        goodsInfo.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.market.GoodsInfo goodsInfo) {
        if (goodsInfo != null) {
            return goodsInfo.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.market.GoodsInfo goodsInfo) {
        return goodsInfo.getRowId() != null;
    }
}
