package io.objectbox.exception;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DbDetachedException extends io.objectbox.exception.DbException {
    public DbDetachedException() {
        this("Cannot perform this action on a detached entity. Ensure it was loaded by ObjectBox, or attach it manually.");
    }

    public DbDetachedException(java.lang.String str) {
        super(str);
    }
}
