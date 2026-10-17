package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class StudyTaskJsonMapInfoCursor extends io.objectbox.Cursor<com.up366.mobile.book.model.StudyTaskJsonMapInfo> {
    private static final com.up366.mobile.book.model.StudyTaskJsonMapInfo_.StudyTaskJsonMapInfoIdGetter ID_GETTER = com.up366.mobile.book.model.StudyTaskJsonMapInfo_.__ID_GETTER;
    private static final int __ID_jobId = com.up366.mobile.book.model.StudyTaskJsonMapInfo_.jobId.id;
    private static final int __ID_json = com.up366.mobile.book.model.StudyTaskJsonMapInfo_.json.id;
    private static final int __ID_expireTime = com.up366.mobile.book.model.StudyTaskJsonMapInfo_.expireTime.id;
    private static final int __ID_addTime = com.up366.mobile.book.model.StudyTaskJsonMapInfo_.addTime.id;

    static final class Factory implements io.objectbox.internal.CursorFactory<com.up366.mobile.book.model.StudyTaskJsonMapInfo> {
        Factory() {
        }

        @Override // io.objectbox.internal.CursorFactory
        public io.objectbox.Cursor<com.up366.mobile.book.model.StudyTaskJsonMapInfo> createCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
            return new com.up366.mobile.book.model.StudyTaskJsonMapInfoCursor(transaction, j, boxStore);
        }
    }

    public StudyTaskJsonMapInfoCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
        super(transaction, j, com.up366.mobile.book.model.StudyTaskJsonMapInfo_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    public long getId(com.up366.mobile.book.model.StudyTaskJsonMapInfo studyTaskJsonMapInfo) {
        return ID_GETTER.getId(studyTaskJsonMapInfo);
    }

    @Override // io.objectbox.Cursor
    public long put(com.up366.mobile.book.model.StudyTaskJsonMapInfo studyTaskJsonMapInfo) {
        java.lang.String str = studyTaskJsonMapInfo.jobId;
        int i = str != null ? __ID_jobId : 0;
        java.lang.String str2 = studyTaskJsonMapInfo.json;
        long jCollect313311 = collect313311(this.cursor, studyTaskJsonMapInfo.rowId, 3, i, str, str2 != null ? __ID_json : 0, str2, 0, null, 0, null, __ID_expireTime, studyTaskJsonMapInfo.expireTime, __ID_addTime, studyTaskJsonMapInfo.addTime, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0d);
        studyTaskJsonMapInfo.rowId = jCollect313311;
        return jCollect313311;
    }
}
