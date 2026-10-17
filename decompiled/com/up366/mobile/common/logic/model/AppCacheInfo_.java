package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class AppCacheInfo_ implements io.objectbox.EntityInfo<com.up366.mobile.common.logic.model.AppCacheInfo> {
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo>[] __ALL_PROPERTIES;
    public static final java.lang.String __DB_NAME = "AppCacheInfo";
    public static final int __ENTITY_ID = 1;
    public static final java.lang.String __ENTITY_NAME = "AppCacheInfo";
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> __ID_PROPERTY;
    public static final com.up366.mobile.common.logic.model.AppCacheInfo_ __INSTANCE;
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> addTime;
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> expireTime;
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> info;
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> key;
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> rowId;
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> updateCount;
    public static final io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> updateTime;
    public static final java.lang.Class<com.up366.mobile.common.logic.model.AppCacheInfo> __ENTITY_CLASS = com.up366.mobile.common.logic.model.AppCacheInfo.class;
    public static final io.objectbox.internal.CursorFactory<com.up366.mobile.common.logic.model.AppCacheInfo> __CURSOR_FACTORY = new com.up366.mobile.common.logic.model.AppCacheInfoCursor.Factory();
    static final com.up366.mobile.common.logic.model.AppCacheInfo_.AppCacheInfoIdGetter __ID_GETTER = new com.up366.mobile.common.logic.model.AppCacheInfo_.AppCacheInfoIdGetter();

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 1;
    }

    static {
        com.up366.mobile.common.logic.model.AppCacheInfo_ appCacheInfo_ = new com.up366.mobile.common.logic.model.AppCacheInfo_();
        __INSTANCE = appCacheInfo_;
        io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> property = new io.objectbox.Property<>(appCacheInfo_, 0, 1, java.lang.Long.TYPE, "rowId", true, "rowId");
        rowId = property;
        io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> property2 = new io.objectbox.Property<>(appCacheInfo_, 1, 2, java.lang.String.class, "key");
        key = property2;
        io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> property3 = new io.objectbox.Property<>(appCacheInfo_, 2, 3, java.lang.Long.TYPE, "expireTime");
        expireTime = property3;
        io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> property4 = new io.objectbox.Property<>(appCacheInfo_, 3, 4, java.lang.Long.TYPE, "addTime");
        addTime = property4;
        io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> property5 = new io.objectbox.Property<>(appCacheInfo_, 4, 5, java.lang.Long.TYPE, com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_UPDATE_TIME);
        updateTime = property5;
        io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> property6 = new io.objectbox.Property<>(appCacheInfo_, 5, 6, java.lang.Long.TYPE, "updateCount");
        updateCount = property6;
        io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> property7 = new io.objectbox.Property<>(appCacheInfo_, 6, 7, java.lang.String.class, "info");
        info = property7;
        __ALL_PROPERTIES = new io.objectbox.Property[]{property, property2, property3, property4, property5, property6, property7};
        __ID_PROPERTY = property;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getEntityName() {
        return "AppCacheInfo";
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.Class<com.up366.mobile.common.logic.model.AppCacheInfo> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getDbName() {
        return "AppCacheInfo";
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.common.logic.model.AppCacheInfo> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.IdGetter<com.up366.mobile.common.logic.model.AppCacheInfo> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.CursorFactory<com.up366.mobile.common.logic.model.AppCacheInfo> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class AppCacheInfoIdGetter implements io.objectbox.internal.IdGetter<com.up366.mobile.common.logic.model.AppCacheInfo> {
        AppCacheInfoIdGetter() {
        }

        @Override // io.objectbox.internal.IdGetter
        public long getId(com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo) {
            return appCacheInfo.rowId;
        }
    }
}
