package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserOrderDao extends org.greenrobot.greendao.AbstractDao<com.up366.mobile.common.logic.model.UserOrder, java.lang.Long> {
    public static final java.lang.String TABLENAME = "user_order";

    public static class Properties {
        public static final org.greenrobot.greendao.Property RowId = new org.greenrobot.greendao.Property(0, java.lang.Long.class, "rowId", true, "_id");
        public static final org.greenrobot.greendao.Property OrderId = new org.greenrobot.greendao.Property(1, java.lang.String.class, "orderId", false, "order_id");
        public static final org.greenrobot.greendao.Property AuditorId = new org.greenrobot.greendao.Property(2, java.lang.String.class, "auditorId", false, "auditor_id");
        public static final org.greenrobot.greendao.Property Bonus = new org.greenrobot.greendao.Property(3, java.lang.Integer.TYPE, "bonus", false, "bonus");
        public static final org.greenrobot.greendao.Property ConfirmTime = new org.greenrobot.greendao.Property(4, java.lang.Long.TYPE, "confirmTime", false, "confirm_time");
        public static final org.greenrobot.greendao.Property CreateTime = new org.greenrobot.greendao.Property(5, java.lang.Long.TYPE, "createTime", false, "create_time");
        public static final org.greenrobot.greendao.Property CreatorId = new org.greenrobot.greendao.Property(6, java.lang.String.class, "creatorId", false, "creator_id");
        public static final org.greenrobot.greendao.Property FullName = new org.greenrobot.greendao.Property(7, java.lang.String.class, "fullName", false, "full_name");
        public static final org.greenrobot.greendao.Property GoodsList = new org.greenrobot.greendao.Property(8, java.lang.String.class, "goodsList", false, "goodsList");
        public static final org.greenrobot.greendao.Property Integral = new org.greenrobot.greendao.Property(9, java.lang.Double.TYPE, "integral", false, "integral");
        public static final org.greenrobot.greendao.Property IntegralMoney = new org.greenrobot.greendao.Property(10, java.lang.Double.TYPE, "integralMoney", false, "integral_money");
        public static final org.greenrobot.greendao.Property IsAgent = new org.greenrobot.greendao.Property(11, java.lang.Integer.TYPE, "isAgent", false, "is_agent");
        public static final org.greenrobot.greendao.Property MoneyPaid = new org.greenrobot.greendao.Property(12, java.lang.Integer.TYPE, "moneyPaid", false, "money_paid");
        public static final org.greenrobot.greendao.Property OrderAmount = new org.greenrobot.greendao.Property(13, java.lang.Double.TYPE, "orderAmount", false, "order_amount");
        public static final org.greenrobot.greendao.Property OrderDiscount = new org.greenrobot.greendao.Property(14, java.lang.Double.TYPE, "orderDiscount", false, "order_discount");
        public static final org.greenrobot.greendao.Property OrderGoodsAmount = new org.greenrobot.greendao.Property(15, java.lang.Double.TYPE, "orderGoodsAmount", false, "order_goods_amount");
        public static final org.greenrobot.greendao.Property OrderSn = new org.greenrobot.greendao.Property(16, java.lang.String.class, "orderSn", false, "order_sn");
        public static final org.greenrobot.greendao.Property OrderStatus = new org.greenrobot.greendao.Property(17, java.lang.Integer.TYPE, "orderStatus", false, "order_status");
        public static final org.greenrobot.greendao.Property PayAmount = new org.greenrobot.greendao.Property(18, java.lang.Double.TYPE, "payAmount", false, "pay_amount");
        public static final org.greenrobot.greendao.Property PayStatus = new org.greenrobot.greendao.Property(19, java.lang.Integer.TYPE, "payStatus", false, "pay_status");
        public static final org.greenrobot.greendao.Property PayTime = new org.greenrobot.greendao.Property(20, java.lang.Long.TYPE, "payTime", false, "pay_time");
        public static final org.greenrobot.greendao.Property Type = new org.greenrobot.greendao.Property(21, java.lang.String.class, "type", false, "type");
        public static final org.greenrobot.greendao.Property UserId = new org.greenrobot.greendao.Property(22, java.lang.String.class, "userId", false, "user_id");
        public static final org.greenrobot.greendao.Property UserName = new org.greenrobot.greendao.Property(23, java.lang.String.class, "userName", false, "user_name");
        public static final org.greenrobot.greendao.Property GoodsAmount = new org.greenrobot.greendao.Property(24, java.lang.Double.TYPE, "goodsAmount", false, "goods_amount");
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public UserOrderDao(org.greenrobot.greendao.internal.DaoConfig daoConfig) {
        super(daoConfig);
    }

    public UserOrderDao(org.greenrobot.greendao.internal.DaoConfig daoConfig, com.up366.greendao.DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"user_order\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"order_id\" TEXT,\"auditor_id\" TEXT,\"bonus\" INTEGER NOT NULL ,\"confirm_time\" INTEGER NOT NULL ,\"create_time\" INTEGER NOT NULL ,\"creator_id\" TEXT,\"full_name\" TEXT,\"goodsList\" TEXT,\"integral\" REAL NOT NULL ,\"integral_money\" REAL NOT NULL ,\"is_agent\" INTEGER NOT NULL ,\"money_paid\" INTEGER NOT NULL ,\"order_amount\" REAL NOT NULL ,\"order_discount\" REAL NOT NULL ,\"order_goods_amount\" REAL NOT NULL ,\"order_sn\" TEXT,\"order_status\" INTEGER NOT NULL ,\"pay_amount\" REAL NOT NULL ,\"pay_status\" INTEGER NOT NULL ,\"pay_time\" INTEGER NOT NULL ,\"type\" TEXT,\"user_id\" TEXT,\"user_name\" TEXT,\"goods_amount\" REAL NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_user_order_order_id ON \"user_order\" (\"order_id\" ASC);");
    }

    public static void dropTable(org.greenrobot.greendao.database.Database database, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"user_order\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(org.greenrobot.greendao.database.DatabaseStatement databaseStatement, com.up366.mobile.common.logic.model.UserOrder userOrder) {
        databaseStatement.clearBindings();
        java.lang.Long rowId = userOrder.getRowId();
        if (rowId != null) {
            databaseStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String orderId = userOrder.getOrderId();
        if (orderId != null) {
            databaseStatement.bindString(2, orderId);
        }
        java.lang.String auditorId = userOrder.getAuditorId();
        if (auditorId != null) {
            databaseStatement.bindString(3, auditorId);
        }
        databaseStatement.bindLong(4, userOrder.getBonus());
        databaseStatement.bindLong(5, userOrder.getConfirmTime());
        databaseStatement.bindLong(6, userOrder.getCreateTime());
        java.lang.String creatorId = userOrder.getCreatorId();
        if (creatorId != null) {
            databaseStatement.bindString(7, creatorId);
        }
        java.lang.String fullName = userOrder.getFullName();
        if (fullName != null) {
            databaseStatement.bindString(8, fullName);
        }
        java.lang.String goodsList = userOrder.getGoodsList();
        if (goodsList != null) {
            databaseStatement.bindString(9, goodsList);
        }
        databaseStatement.bindDouble(10, userOrder.getIntegral());
        databaseStatement.bindDouble(11, userOrder.getIntegralMoney());
        databaseStatement.bindLong(12, userOrder.getIsAgent());
        databaseStatement.bindLong(13, userOrder.getMoneyPaid());
        databaseStatement.bindDouble(14, userOrder.getOrderAmount());
        databaseStatement.bindDouble(15, userOrder.getOrderDiscount());
        databaseStatement.bindDouble(16, userOrder.getOrderGoodsAmount());
        java.lang.String orderSn = userOrder.getOrderSn();
        if (orderSn != null) {
            databaseStatement.bindString(17, orderSn);
        }
        databaseStatement.bindLong(18, userOrder.getOrderStatus());
        databaseStatement.bindDouble(19, userOrder.getPayAmount());
        databaseStatement.bindLong(20, userOrder.getPayStatus());
        databaseStatement.bindLong(21, userOrder.getPayTime());
        java.lang.String type = userOrder.getType();
        if (type != null) {
            databaseStatement.bindString(22, type);
        }
        java.lang.String userId = userOrder.getUserId();
        if (userId != null) {
            databaseStatement.bindString(23, userId);
        }
        java.lang.String userName = userOrder.getUserName();
        if (userName != null) {
            databaseStatement.bindString(24, userName);
        }
        databaseStatement.bindDouble(25, userOrder.getGoodsAmount());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bindValues(android.database.sqlite.SQLiteStatement sQLiteStatement, com.up366.mobile.common.logic.model.UserOrder userOrder) {
        sQLiteStatement.clearBindings();
        java.lang.Long rowId = userOrder.getRowId();
        if (rowId != null) {
            sQLiteStatement.bindLong(1, rowId.longValue());
        }
        java.lang.String orderId = userOrder.getOrderId();
        if (orderId != null) {
            sQLiteStatement.bindString(2, orderId);
        }
        java.lang.String auditorId = userOrder.getAuditorId();
        if (auditorId != null) {
            sQLiteStatement.bindString(3, auditorId);
        }
        sQLiteStatement.bindLong(4, userOrder.getBonus());
        sQLiteStatement.bindLong(5, userOrder.getConfirmTime());
        sQLiteStatement.bindLong(6, userOrder.getCreateTime());
        java.lang.String creatorId = userOrder.getCreatorId();
        if (creatorId != null) {
            sQLiteStatement.bindString(7, creatorId);
        }
        java.lang.String fullName = userOrder.getFullName();
        if (fullName != null) {
            sQLiteStatement.bindString(8, fullName);
        }
        java.lang.String goodsList = userOrder.getGoodsList();
        if (goodsList != null) {
            sQLiteStatement.bindString(9, goodsList);
        }
        sQLiteStatement.bindDouble(10, userOrder.getIntegral());
        sQLiteStatement.bindDouble(11, userOrder.getIntegralMoney());
        sQLiteStatement.bindLong(12, userOrder.getIsAgent());
        sQLiteStatement.bindLong(13, userOrder.getMoneyPaid());
        sQLiteStatement.bindDouble(14, userOrder.getOrderAmount());
        sQLiteStatement.bindDouble(15, userOrder.getOrderDiscount());
        sQLiteStatement.bindDouble(16, userOrder.getOrderGoodsAmount());
        java.lang.String orderSn = userOrder.getOrderSn();
        if (orderSn != null) {
            sQLiteStatement.bindString(17, orderSn);
        }
        sQLiteStatement.bindLong(18, userOrder.getOrderStatus());
        sQLiteStatement.bindDouble(19, userOrder.getPayAmount());
        sQLiteStatement.bindLong(20, userOrder.getPayStatus());
        sQLiteStatement.bindLong(21, userOrder.getPayTime());
        java.lang.String type = userOrder.getType();
        if (type != null) {
            sQLiteStatement.bindString(22, type);
        }
        java.lang.String userId = userOrder.getUserId();
        if (userId != null) {
            sQLiteStatement.bindString(23, userId);
        }
        java.lang.String userName = userOrder.getUserName();
        if (userName != null) {
            sQLiteStatement.bindString(24, userName);
        }
        sQLiteStatement.bindDouble(25, userOrder.getGoodsAmount());
    }

    /* JADX INFO: renamed from: readKey, reason: merged with bridge method [inline-methods] */
    public java.lang.Long m132readKey(android.database.Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return java.lang.Long.valueOf(cursor.getLong(i));
    }

    /* JADX INFO: renamed from: readEntity, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.common.logic.model.UserOrder m131readEntity(android.database.Cursor cursor, int i) {
        java.lang.Long lValueOf = cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i));
        int i2 = i + 1;
        java.lang.String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 2;
        java.lang.String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = cursor.getInt(i + 3);
        long j = cursor.getLong(i + 4);
        long j2 = cursor.getLong(i + 5);
        int i5 = i + 6;
        java.lang.String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 7;
        java.lang.String string4 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 8;
        java.lang.String string5 = cursor.isNull(i7) ? null : cursor.getString(i7);
        double d = cursor.getDouble(i + 9);
        double d2 = cursor.getDouble(i + 10);
        int i8 = cursor.getInt(i + 11);
        int i9 = cursor.getInt(i + 12);
        double d3 = cursor.getDouble(i + 13);
        double d4 = cursor.getDouble(i + 14);
        double d5 = cursor.getDouble(i + 15);
        int i10 = i + 16;
        java.lang.String string6 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = cursor.getInt(i + 17);
        double d6 = cursor.getDouble(i + 18);
        int i12 = cursor.getInt(i + 19);
        long j3 = cursor.getLong(i + 20);
        int i13 = i + 21;
        java.lang.String string7 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i + 22;
        java.lang.String string8 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 23;
        return new com.up366.mobile.common.logic.model.UserOrder(lValueOf, string, string2, i4, j, j2, string3, string4, string5, d, d2, i8, i9, d3, d4, d5, string6, i11, d6, i12, j3, string7, string8, cursor.isNull(i15) ? null : cursor.getString(i15), cursor.getDouble(i + 24));
    }

    public void readEntity(android.database.Cursor cursor, com.up366.mobile.common.logic.model.UserOrder userOrder, int i) {
        userOrder.setRowId(cursor.isNull(i) ? null : java.lang.Long.valueOf(cursor.getLong(i)));
        int i2 = i + 1;
        userOrder.setOrderId(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 2;
        userOrder.setAuditorId(cursor.isNull(i3) ? null : cursor.getString(i3));
        userOrder.setBonus(cursor.getInt(i + 3));
        userOrder.setConfirmTime(cursor.getLong(i + 4));
        userOrder.setCreateTime(cursor.getLong(i + 5));
        int i4 = i + 6;
        userOrder.setCreatorId(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 7;
        userOrder.setFullName(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 8;
        userOrder.setGoodsList(cursor.isNull(i6) ? null : cursor.getString(i6));
        userOrder.setIntegral(cursor.getDouble(i + 9));
        userOrder.setIntegralMoney(cursor.getDouble(i + 10));
        userOrder.setIsAgent(cursor.getInt(i + 11));
        userOrder.setMoneyPaid(cursor.getInt(i + 12));
        userOrder.setOrderAmount(cursor.getDouble(i + 13));
        userOrder.setOrderDiscount(cursor.getDouble(i + 14));
        userOrder.setOrderGoodsAmount(cursor.getDouble(i + 15));
        int i7 = i + 16;
        userOrder.setOrderSn(cursor.isNull(i7) ? null : cursor.getString(i7));
        userOrder.setOrderStatus(cursor.getInt(i + 17));
        userOrder.setPayAmount(cursor.getDouble(i + 18));
        userOrder.setPayStatus(cursor.getInt(i + 19));
        userOrder.setPayTime(cursor.getLong(i + 20));
        int i8 = i + 21;
        userOrder.setType(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 22;
        userOrder.setUserId(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 23;
        userOrder.setUserName(cursor.isNull(i10) ? null : cursor.getString(i10));
        userOrder.setGoodsAmount(cursor.getDouble(i + 24));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final java.lang.Long updateKeyAfterInsert(com.up366.mobile.common.logic.model.UserOrder userOrder, long j) {
        userOrder.setRowId(java.lang.Long.valueOf(j));
        return java.lang.Long.valueOf(j);
    }

    public java.lang.Long getKey(com.up366.mobile.common.logic.model.UserOrder userOrder) {
        if (userOrder != null) {
            return userOrder.getRowId();
        }
        return null;
    }

    public boolean hasKey(com.up366.mobile.common.logic.model.UserOrder userOrder) {
        return userOrder.getRowId() != null;
    }
}
