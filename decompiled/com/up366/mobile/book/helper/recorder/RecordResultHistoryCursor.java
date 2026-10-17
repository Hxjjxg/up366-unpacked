package com.up366.mobile.book.helper.recorder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class RecordResultHistoryCursor extends io.objectbox.Cursor<com.up366.mobile.book.helper.recorder.RecordResultHistory> {
    private static final com.up366.mobile.book.helper.recorder.RecordResultHistory_.RecordResultHistoryIdGetter ID_GETTER = com.up366.mobile.book.helper.recorder.RecordResultHistory_.__ID_GETTER;
    private static final int __ID_objectId = com.up366.mobile.book.helper.recorder.RecordResultHistory_.objectId.id;
    private static final int __ID_buffer = com.up366.mobile.book.helper.recorder.RecordResultHistory_.buffer.id;

    static final class Factory implements io.objectbox.internal.CursorFactory<com.up366.mobile.book.helper.recorder.RecordResultHistory> {
        Factory() {
        }

        @Override // io.objectbox.internal.CursorFactory
        public io.objectbox.Cursor<com.up366.mobile.book.helper.recorder.RecordResultHistory> createCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
            return new com.up366.mobile.book.helper.recorder.RecordResultHistoryCursor(transaction, j, boxStore);
        }
    }

    public RecordResultHistoryCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
        super(transaction, j, com.up366.mobile.book.helper.recorder.RecordResultHistory_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    public long getId(com.up366.mobile.book.helper.recorder.RecordResultHistory recordResultHistory) {
        return ID_GETTER.getId(recordResultHistory);
    }

    @Override // io.objectbox.Cursor
    public long put(com.up366.mobile.book.helper.recorder.RecordResultHistory recordResultHistory) {
        java.lang.String str = recordResultHistory.objectId;
        int i = str != null ? __ID_objectId : 0;
        byte[] bArr = recordResultHistory.buffer;
        long jCollect313311 = collect313311(this.cursor, recordResultHistory.rowId, 3, i, str, 0, null, 0, null, bArr != null ? __ID_buffer : 0, bArr, 0, 0L, 0, 0L, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0d);
        recordResultHistory.rowId = jCollect313311;
        return jCollect313311;
    }
}
