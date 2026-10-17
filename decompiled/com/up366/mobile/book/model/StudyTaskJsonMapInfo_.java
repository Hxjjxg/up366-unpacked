package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class StudyTaskJsonMapInfo_ implements io.objectbox.EntityInfo<com.up366.mobile.book.model.StudyTaskJsonMapInfo> {
    public static final io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo>[] __ALL_PROPERTIES;
    public static final java.lang.String __DB_NAME = "StudyTaskJsonMapInfo";
    public static final int __ENTITY_ID = 12;
    public static final java.lang.String __ENTITY_NAME = "StudyTaskJsonMapInfo";
    public static final io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> __ID_PROPERTY;
    public static final com.up366.mobile.book.model.StudyTaskJsonMapInfo_ __INSTANCE;
    public static final io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> addTime;
    public static final io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> expireTime;
    public static final io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> jobId;
    public static final io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> json;
    public static final io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> rowId;
    public static final java.lang.Class<com.up366.mobile.book.model.StudyTaskJsonMapInfo> __ENTITY_CLASS = com.up366.mobile.book.model.StudyTaskJsonMapInfo.class;
    public static final io.objectbox.internal.CursorFactory<com.up366.mobile.book.model.StudyTaskJsonMapInfo> __CURSOR_FACTORY = new com.up366.mobile.book.model.StudyTaskJsonMapInfoCursor.Factory();
    static final com.up366.mobile.book.model.StudyTaskJsonMapInfo_.StudyTaskJsonMapInfoIdGetter __ID_GETTER = new com.up366.mobile.book.model.StudyTaskJsonMapInfo_.StudyTaskJsonMapInfoIdGetter();

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 12;
    }

    static {
        com.up366.mobile.book.model.StudyTaskJsonMapInfo_ studyTaskJsonMapInfo_ = new com.up366.mobile.book.model.StudyTaskJsonMapInfo_();
        __INSTANCE = studyTaskJsonMapInfo_;
        io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> property = new io.objectbox.Property<>(studyTaskJsonMapInfo_, 0, 1, java.lang.Long.TYPE, "rowId", true, "rowId");
        rowId = property;
        io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> property2 = new io.objectbox.Property<>(studyTaskJsonMapInfo_, 1, 2, java.lang.String.class, "jobId");
        jobId = property2;
        io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> property3 = new io.objectbox.Property<>(studyTaskJsonMapInfo_, 2, 3, java.lang.String.class, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON);
        json = property3;
        io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> property4 = new io.objectbox.Property<>(studyTaskJsonMapInfo_, 3, 4, java.lang.Long.TYPE, "expireTime");
        expireTime = property4;
        io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> property5 = new io.objectbox.Property<>(studyTaskJsonMapInfo_, 4, 5, java.lang.Long.TYPE, "addTime");
        addTime = property5;
        __ALL_PROPERTIES = new io.objectbox.Property[]{property, property2, property3, property4, property5};
        __ID_PROPERTY = property;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getEntityName() {
        return "StudyTaskJsonMapInfo";
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.Class<com.up366.mobile.book.model.StudyTaskJsonMapInfo> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getDbName() {
        return "StudyTaskJsonMapInfo";
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.book.model.StudyTaskJsonMapInfo> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.IdGetter<com.up366.mobile.book.model.StudyTaskJsonMapInfo> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.CursorFactory<com.up366.mobile.book.model.StudyTaskJsonMapInfo> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class StudyTaskJsonMapInfoIdGetter implements io.objectbox.internal.IdGetter<com.up366.mobile.book.model.StudyTaskJsonMapInfo> {
        StudyTaskJsonMapInfoIdGetter() {
        }

        @Override // io.objectbox.internal.IdGetter
        public long getId(com.up366.mobile.book.model.StudyTaskJsonMapInfo studyTaskJsonMapInfo) {
            return studyTaskJsonMapInfo.rowId;
        }
    }
}
