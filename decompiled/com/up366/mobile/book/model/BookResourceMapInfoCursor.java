package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class BookResourceMapInfoCursor extends io.objectbox.Cursor<com.up366.mobile.book.model.BookResourceMapInfo> {
    private static final com.up366.mobile.book.model.BookResourceMapInfo_.BookResourceMapInfoIdGetter ID_GETTER = com.up366.mobile.book.model.BookResourceMapInfo_.__ID_GETTER;
    private static final int __ID_path = com.up366.mobile.book.model.BookResourceMapInfo_.path.id;
    private static final int __ID_bookId = com.up366.mobile.book.model.BookResourceMapInfo_.bookId.id;
    private static final int __ID_fileId = com.up366.mobile.book.model.BookResourceMapInfo_.fileId.id;
    private static final int __ID_key = com.up366.mobile.book.model.BookResourceMapInfo_.key.id;
    private static final int __ID_expireTime = com.up366.mobile.book.model.BookResourceMapInfo_.expireTime.id;
    private static final int __ID_addTime = com.up366.mobile.book.model.BookResourceMapInfo_.addTime.id;

    static final class Factory implements io.objectbox.internal.CursorFactory<com.up366.mobile.book.model.BookResourceMapInfo> {
        Factory() {
        }

        @Override // io.objectbox.internal.CursorFactory
        public io.objectbox.Cursor<com.up366.mobile.book.model.BookResourceMapInfo> createCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
            return new com.up366.mobile.book.model.BookResourceMapInfoCursor(transaction, j, boxStore);
        }
    }

    public BookResourceMapInfoCursor(io.objectbox.Transaction transaction, long j, io.objectbox.BoxStore boxStore) {
        super(transaction, j, com.up366.mobile.book.model.BookResourceMapInfo_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    public long getId(com.up366.mobile.book.model.BookResourceMapInfo bookResourceMapInfo) {
        return ID_GETTER.getId(bookResourceMapInfo);
    }

    @Override // io.objectbox.Cursor
    public long put(com.up366.mobile.book.model.BookResourceMapInfo bookResourceMapInfo) {
        java.lang.String str = bookResourceMapInfo.path;
        int i = str != null ? __ID_path : 0;
        java.lang.String str2 = bookResourceMapInfo.bookId;
        int i2 = str2 != null ? __ID_bookId : 0;
        java.lang.String str3 = bookResourceMapInfo.fileId;
        int i3 = str3 != null ? __ID_fileId : 0;
        java.lang.String str4 = bookResourceMapInfo.key;
        collect400000(this.cursor, 0L, 1, i, str, i2, str2, i3, str3, str4 != null ? __ID_key : 0, str4);
        long jCollect004000 = collect004000(this.cursor, bookResourceMapInfo.rowId, 2, __ID_expireTime, bookResourceMapInfo.expireTime, __ID_addTime, bookResourceMapInfo.addTime, 0, 0L, 0, 0L);
        bookResourceMapInfo.rowId = jCollect004000;
        return jCollect004000;
    }
}
