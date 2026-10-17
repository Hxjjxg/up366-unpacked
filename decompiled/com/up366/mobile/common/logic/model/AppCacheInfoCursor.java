package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class AppCacheInfoCursor extends io.objectbox.Cursor<com.up366.mobile.common.logic.model.AppCacheInfo> {
    private static final com.up366.mobile.common.logic.model.AppCacheInfo_.AppCacheInfoIdGetter ID_GETTER = com.up366.mobile.common.logic.model.AppCacheInfo_.__ID_GETTER;
    private static final int __ID_key = com.up366.mobile.common.logic.model.AppCacheInfo_.key.id;
    private static final int __ID_expireTime = com.up366.mobile.common.logic.model.AppCacheInfo_.expireTime.id;
    private static final int __ID_addTime = com.up366.mobile.common.logic.model.AppCacheInfo_.addTime.id;
    private static final int __ID_updateTime = com.up366.mobile.common.logic.model.AppCacheInfo_.updateTime.id;
    private static final int __ID_updateCount = com.up366.mobile.common.logic.model.AppCacheInfo_.updateCount.id;
    private static final int __ID_info = com.up366.mobile.common.logic.model.AppCacheInfo_.info.id;

    static final class Factory implements io.objectbox.internal.CursorFactory<com.up366.mobile.common.logic.model.AppCacheInfo> {
        Factory() {
        }

        @Override // io.objectbox.internal.CursorFactory
        public io.objectbox.Cursor<com.up366.mobile.common.logic.model.AppCacheInfo> createCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
            return new com.up366.mobile.common.logic.model.AppCacheInfoCursor(transaction, j, boxStore);
        }
    }

    public AppCacheInfoCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
        super(transaction, j, com.up366.mobile.common.logic.model.AppCacheInfo_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    public long getId(com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo) {
        return ID_GETTER.getId(appCacheInfo);
    }

    @Override // io.objectbox.Cursor
    public long put(com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo) {
        java.lang.String key = appCacheInfo.getKey();
        int i = key != null ? __ID_key : 0;
        java.lang.String info = appCacheInfo.getInfo();
        collect313311(this.cursor, 0L, 1, i, key, info != null ? __ID_info : 0, info, 0, null, 0, null, __ID_expireTime, appCacheInfo.getExpireTime(), __ID_addTime, appCacheInfo.getAddTime(), __ID_updateTime, appCacheInfo.getUpdateTime(), 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0d);
        long jCollect004000 = collect004000(this.cursor, appCacheInfo.rowId, 2, __ID_updateCount, appCacheInfo.getUpdateCount(), 0, 0L, 0, 0L, 0, 0L);
        appCacheInfo.rowId = jCollect004000;
        return jCollect004000;
    }
}
