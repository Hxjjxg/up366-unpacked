package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class FileCacheInfoCursor extends io.objectbox.Cursor<com.up366.mobile.common.utils.alifile.FileCacheInfo> {
    private static final com.up366.mobile.common.utils.alifile.FileCacheInfo_.FileCacheInfoIdGetter ID_GETTER = com.up366.mobile.common.utils.alifile.FileCacheInfo_.__ID_GETTER;
    private static final int __ID_key = com.up366.mobile.common.utils.alifile.FileCacheInfo_.key.id;
    private static final int __ID_expireTime = com.up366.mobile.common.utils.alifile.FileCacheInfo_.expireTime.id;
    private static final int __ID_addTime = com.up366.mobile.common.utils.alifile.FileCacheInfo_.addTime.id;
    private static final int __ID_path = com.up366.mobile.common.utils.alifile.FileCacheInfo_.path.id;

    static final class Factory implements io.objectbox.internal.CursorFactory<com.up366.mobile.common.utils.alifile.FileCacheInfo> {
        Factory() {
        }

        @Override // io.objectbox.internal.CursorFactory
        public io.objectbox.Cursor<com.up366.mobile.common.utils.alifile.FileCacheInfo> createCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
            return new com.up366.mobile.common.utils.alifile.FileCacheInfoCursor(transaction, j, boxStore);
        }
    }

    public FileCacheInfoCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
        super(transaction, j, com.up366.mobile.common.utils.alifile.FileCacheInfo_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    public long getId(com.up366.mobile.common.utils.alifile.FileCacheInfo fileCacheInfo) {
        return ID_GETTER.getId(fileCacheInfo);
    }

    @Override // io.objectbox.Cursor
    public long put(com.up366.mobile.common.utils.alifile.FileCacheInfo fileCacheInfo) {
        java.lang.String str = fileCacheInfo.key;
        int i = str != null ? __ID_key : 0;
        java.lang.String str2 = fileCacheInfo.path;
        long jCollect313311 = collect313311(this.cursor, fileCacheInfo.rowId, 3, i, str, str2 != null ? __ID_path : 0, str2, 0, null, 0, null, __ID_expireTime, fileCacheInfo.expireTime, __ID_addTime, fileCacheInfo.addTime, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0d);
        fileCacheInfo.rowId = jCollect313311;
        return jCollect313311;
    }
}
