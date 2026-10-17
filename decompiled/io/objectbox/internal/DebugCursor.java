package io.objectbox.internal;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DebugCursor implements java.io.Closeable {
    private boolean closed;
    private final long handle;
    private final io.objectbox.Transaction tx;

    static native long nativeCreate(long j);

    static native void nativeDestroy(long j);

    static native byte[] nativeGet(long j, byte[] bArr);

    static native byte[] nativeSeekOrNext(long j, byte[] bArr);

    public static io.objectbox.internal.DebugCursor create(io.objectbox.Transaction transaction) {
        long jNativeCreate = nativeCreate(io.objectbox.InternalAccess.getHandle(transaction));
        if (jNativeCreate == 0) {
            throw new io.objectbox.exception.DbException("Could not create native debug cursor");
        }
        return new io.objectbox.internal.DebugCursor(transaction, jNativeCreate);
    }

    public DebugCursor(io.objectbox.Transaction transaction, long j) {
        this.tx = transaction;
        this.handle = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            io.objectbox.Transaction transaction = this.tx;
            if (transaction != null && !transaction.getStore().isClosed()) {
                nativeDestroy(this.handle);
            }
        }
    }

    protected void finalize() throws java.lang.Throwable {
        if (this.closed) {
            return;
        }
        close();
        super.finalize();
    }

    public byte[] get(byte[] bArr) {
        return nativeGet(this.handle, bArr);
    }

    public byte[] seekOrNext(byte[] bArr) {
        return nativeSeekOrNext(this.handle, bArr);
    }
}
