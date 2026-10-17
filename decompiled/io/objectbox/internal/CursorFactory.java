package io.objectbox.internal;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface CursorFactory<T> {
    io.objectbox.Cursor<T> createCursor(io.objectbox.Transaction transaction, long j, @javax.annotation.Nullable io.objectbox.BoxStore boxStore);
}
