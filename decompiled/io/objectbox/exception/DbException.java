package io.objectbox.exception;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DbException extends java.lang.RuntimeException {
    private final int errorCode;

    public DbException(java.lang.String str) {
        super(str);
        this.errorCode = 0;
    }

    public DbException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.errorCode = 0;
    }

    public DbException(java.lang.String str, int i) {
        super(str);
        this.errorCode = i;
    }

    @Override // java.lang.Throwable
    public java.lang.String toString() {
        if (this.errorCode == 0) {
            return super.toString();
        }
        return super.toString() + " (error code " + this.errorCode + ")";
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
