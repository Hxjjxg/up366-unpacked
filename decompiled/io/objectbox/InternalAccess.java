package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class InternalAccess {
    public static io.objectbox.Transaction getActiveTx(io.objectbox.BoxStore boxStore) {
        io.objectbox.Transaction transaction = boxStore.activeTx.get();
        if (transaction == null) {
            throw new java.lang.IllegalStateException("No active transaction");
        }
        transaction.checkOpen();
        return transaction;
    }

    public static long getHandle(io.objectbox.Transaction transaction) {
        return transaction.internalHandle();
    }

    public static void setSyncClient(io.objectbox.BoxStore boxStore, @javax.annotation.Nullable io.objectbox.sync.SyncClient syncClient) {
        boxStore.setSyncClient(syncClient);
    }

    public static <T> io.objectbox.Cursor<T> getWriter(io.objectbox.Box<T> box) {
        return box.getWriter();
    }

    public static <T> io.objectbox.Cursor<T> getActiveTxCursor(io.objectbox.Box<T> box) {
        return box.getActiveTxCursor();
    }

    public static <T> long getActiveTxCursorHandle(io.objectbox.Box<T> box) {
        return box.getActiveTxCursor().internalHandle();
    }

    public static <T> void commitWriter(io.objectbox.Box<T> box, io.objectbox.Cursor<T> cursor) {
        box.commitWriter(cursor);
    }

    public static void enableCreationStackTracking() {
        io.objectbox.Transaction.TRACK_CREATION_STACK = true;
        io.objectbox.Cursor.TRACK_CREATION_STACK = true;
    }
}
