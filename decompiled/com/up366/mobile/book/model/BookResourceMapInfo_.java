package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class BookResourceMapInfo_ implements io.objectbox.EntityInfo<com.up366.mobile.book.model.BookResourceMapInfo> {
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo>[] __ALL_PROPERTIES;
    public static final java.lang.String __DB_NAME = "BookResourceMapInfo";
    public static final int __ENTITY_ID = 11;
    public static final java.lang.String __ENTITY_NAME = "BookResourceMapInfo";
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> __ID_PROPERTY;
    public static final com.up366.mobile.book.model.BookResourceMapInfo_ __INSTANCE;
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> addTime;
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> bookId;
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> expireTime;
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> fileId;
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> key;
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> path;
    public static final io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> rowId;
    public static final java.lang.Class<com.up366.mobile.book.model.BookResourceMapInfo> __ENTITY_CLASS = com.up366.mobile.book.model.BookResourceMapInfo.class;
    public static final io.objectbox.internal.CursorFactory<com.up366.mobile.book.model.BookResourceMapInfo> __CURSOR_FACTORY = new com.up366.mobile.book.model.BookResourceMapInfoCursor.Factory();
    static final com.up366.mobile.book.model.BookResourceMapInfo_.BookResourceMapInfoIdGetter __ID_GETTER = new com.up366.mobile.book.model.BookResourceMapInfo_.BookResourceMapInfoIdGetter();

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 11;
    }

    static {
        com.up366.mobile.book.model.BookResourceMapInfo_ bookResourceMapInfo_ = new com.up366.mobile.book.model.BookResourceMapInfo_();
        __INSTANCE = bookResourceMapInfo_;
        io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> property = new io.objectbox.Property<>(bookResourceMapInfo_, 0, 1, java.lang.Long.TYPE, "rowId", true, "rowId");
        rowId = property;
        io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> property2 = new io.objectbox.Property<>(bookResourceMapInfo_, 1, 2, java.lang.String.class, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        path = property2;
        io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> property3 = new io.objectbox.Property<>(bookResourceMapInfo_, 2, 3, java.lang.String.class, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        bookId = property3;
        io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> property4 = new io.objectbox.Property<>(bookResourceMapInfo_, 3, 4, java.lang.String.class, "fileId");
        fileId = property4;
        io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> property5 = new io.objectbox.Property<>(bookResourceMapInfo_, 4, 5, java.lang.String.class, "key");
        key = property5;
        io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> property6 = new io.objectbox.Property<>(bookResourceMapInfo_, 5, 6, java.lang.Long.TYPE, "expireTime");
        expireTime = property6;
        io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> property7 = new io.objectbox.Property<>(bookResourceMapInfo_, 6, 7, java.lang.Long.TYPE, "addTime");
        addTime = property7;
        __ALL_PROPERTIES = new io.objectbox.Property[]{property, property2, property3, property4, property5, property6, property7};
        __ID_PROPERTY = property;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getEntityName() {
        return "BookResourceMapInfo";
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.Class<com.up366.mobile.book.model.BookResourceMapInfo> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getDbName() {
        return "BookResourceMapInfo";
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.book.model.BookResourceMapInfo> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.IdGetter<com.up366.mobile.book.model.BookResourceMapInfo> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.CursorFactory<com.up366.mobile.book.model.BookResourceMapInfo> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class BookResourceMapInfoIdGetter implements io.objectbox.internal.IdGetter<com.up366.mobile.book.model.BookResourceMapInfo> {
        BookResourceMapInfoIdGetter() {
        }

        @Override // io.objectbox.internal.IdGetter
        public long getId(com.up366.mobile.book.model.BookResourceMapInfo bookResourceMapInfo) {
            return bookResourceMapInfo.rowId;
        }
    }
}
