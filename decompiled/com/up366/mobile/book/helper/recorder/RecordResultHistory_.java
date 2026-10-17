package com.up366.mobile.book.helper.recorder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class RecordResultHistory_ implements io.objectbox.EntityInfo<com.up366.mobile.book.helper.recorder.RecordResultHistory> {
    public static final io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory>[] __ALL_PROPERTIES;
    public static final java.lang.String __DB_NAME = "RecordResultHistory";
    public static final int __ENTITY_ID = 9;
    public static final java.lang.String __ENTITY_NAME = "RecordResultHistory";
    public static final io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory> __ID_PROPERTY;
    public static final com.up366.mobile.book.helper.recorder.RecordResultHistory_ __INSTANCE;
    public static final io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory> buffer;
    public static final io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory> objectId;
    public static final io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory> rowId;
    public static final java.lang.Class<com.up366.mobile.book.helper.recorder.RecordResultHistory> __ENTITY_CLASS = com.up366.mobile.book.helper.recorder.RecordResultHistory.class;
    public static final io.objectbox.internal.CursorFactory<com.up366.mobile.book.helper.recorder.RecordResultHistory> __CURSOR_FACTORY = new com.up366.mobile.book.helper.recorder.RecordResultHistoryCursor.Factory();
    static final com.up366.mobile.book.helper.recorder.RecordResultHistory_.RecordResultHistoryIdGetter __ID_GETTER = new com.up366.mobile.book.helper.recorder.RecordResultHistory_.RecordResultHistoryIdGetter();

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 9;
    }

    static {
        com.up366.mobile.book.helper.recorder.RecordResultHistory_ recordResultHistory_ = new com.up366.mobile.book.helper.recorder.RecordResultHistory_();
        __INSTANCE = recordResultHistory_;
        io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory> property = new io.objectbox.Property<>(recordResultHistory_, 0, 1, java.lang.Long.TYPE, "rowId", true, "rowId");
        rowId = property;
        io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory> property2 = new io.objectbox.Property<>(recordResultHistory_, 1, 2, java.lang.String.class, "objectId");
        objectId = property2;
        io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory> property3 = new io.objectbox.Property<>(recordResultHistory_, 2, 3, byte[].class, "buffer");
        buffer = property3;
        __ALL_PROPERTIES = new io.objectbox.Property[]{property, property2, property3};
        __ID_PROPERTY = property;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getEntityName() {
        return "RecordResultHistory";
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.Class<com.up366.mobile.book.helper.recorder.RecordResultHistory> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public java.lang.String getDbName() {
        return "RecordResultHistory";
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.Property<com.up366.mobile.book.helper.recorder.RecordResultHistory> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.IdGetter<com.up366.mobile.book.helper.recorder.RecordResultHistory> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public io.objectbox.internal.CursorFactory<com.up366.mobile.book.helper.recorder.RecordResultHistory> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class RecordResultHistoryIdGetter implements io.objectbox.internal.IdGetter<com.up366.mobile.book.helper.recorder.RecordResultHistory> {
        RecordResultHistoryIdGetter() {
        }

        @Override // io.objectbox.internal.IdGetter
        public long getId(com.up366.mobile.book.helper.recorder.RecordResultHistory recordResultHistory) {
            return recordResultHistory.rowId;
        }
    }
}
