package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class FileCacheInfo_ implements io.objectbox.EntityInfo<com.up366.mobile.common.utils.alifile.FileCacheInfo> {
    public static final io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo>[] __ALL_PROPERTIES;
    public static final java.lang.String __DB_NAME = "FileCacheInfo";
    public static final int __ENTITY_ID = 10;
    public static final java.lang.String __ENTITY_NAME = "FileCacheInfo";
    public static final io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> __ID_PROPERTY;
    public static final com.up366.mobile.common.utils.alifile.FileCacheInfo_ __INSTANCE;
    public static final io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> addTime;
    public static final io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> expireTime;
    public static final io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> key;
    public static final io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> path;
    public static final io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> rowId;
    public static final java.lang.Class<com.up366.mobile.common.utils.alifile.FileCacheInfo> __ENTITY_CLASS = com.up366.mobile.common.utils.alifile.FileCacheInfo.class;
    public static final io.objectbox.internal.CursorFactory<com.up366.mobile.common.utils.alifile.FileCacheInfo> __CURSOR_FACTORY = new com.up366.mobile.common.utils.alifile.FileCacheInfoCursor.Factory();
    static final com.up366.mobile.common.utils.alifile.FileCacheInfo_.FileCacheInfoIdGetter __ID_GETTER = new com.up366.mobile.common.utils.alifile.FileCacheInfo_.FileCacheInfoIdGetter();

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 10;
    }

    static {
        com.up366.mobile.common.utils.alifile.FileCacheInfo_ fileCacheInfo_ = new com.up366.mobile.common.utils.alifile.FileCacheInfo_();
        __INSTANCE = fileCacheInfo_;
        io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> property = new io.objectbox.Property<>(fileCacheInfo_, 0, 1, java.lang.Long.TYPE, "rowId", true, "rowId");
        rowId = property;
        io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> property2 = new io.objectbox.Property<>(fileCacheInfo_, 1, 2, java.lang.String.class, "key");
        key = property2;
        io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> property3 = new io.objectbox.Property<>(fileCacheInfo_, 2, 3, java.lang.Long.TYPE, "expireTime");
        expireTime = property3;
        io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> property4 = new io.objectbox.Property<>(fileCacheInfo_, 3, 4, java.lang.Long.TYPE, "addTime");
        addTime = property4;
        io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> property5 = new io.objectbox.Property<>(fileCacheInfo_, 4, 5, java.lang.String.class, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        path = property5;
        __ALL_PROPERTIES = new io.objectbox.Property[]{property, property2, property3, property4, property5};
        __ID_PROPERTY = property;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getEntityName() {
        return "FileCacheInfo";
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.Class<com.up366.mobile.common.utils.alifile.FileCacheInfo> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getDbName() {
        return "FileCacheInfo";
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.common.utils.alifile.FileCacheInfo> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.IdGetter<com.up366.mobile.common.utils.alifile.FileCacheInfo> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.CursorFactory<com.up366.mobile.common.utils.alifile.FileCacheInfo> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class FileCacheInfoIdGetter implements io.objectbox.internal.IdGetter<com.up366.mobile.common.utils.alifile.FileCacheInfo> {
        FileCacheInfoIdGetter() {
        }

        @Override // io.objectbox.internal.IdGetter
        public long getId(com.up366.mobile.common.utils.alifile.FileCacheInfo fileCacheInfo) {
            return fileCacheInfo.rowId;
        }
    }
}
