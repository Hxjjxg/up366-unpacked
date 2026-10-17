package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class Cursor<T> implements java.io.Closeable {
    static boolean LOG_READ_NOT_CLOSED = false;
    protected static final int PUT_FLAG_COMPLETE = 2;
    protected static final int PUT_FLAG_FIRST = 1;
    static boolean TRACK_CREATION_STACK;
    protected final io.objectbox.BoxStore boxStoreForEntities;
    protected boolean closed;
    private final java.lang.Throwable creationThrowable;
    protected final long cursor;
    protected final io.objectbox.EntityInfo<T> entityInfo;
    protected final boolean readOnly;
    protected final io.objectbox.Transaction tx;

    protected static native long collect002033(long j, long j2, int i, int i2, long j3, int i3, long j4, int i4, float f, int i5, float f2, int i6, float f3, int i7, double d, int i8, double d2, int i9, double d3);

    protected static native long collect004000(long j, long j2, int i, int i2, long j3, int i3, long j4, int i4, long j5, int i5, long j6);

    protected static native long collect313311(long j, long j2, int i, int i2, @javax.annotation.Nullable java.lang.String str, int i3, @javax.annotation.Nullable java.lang.String str2, int i4, @javax.annotation.Nullable java.lang.String str3, int i5, @javax.annotation.Nullable byte[] bArr, int i6, long j3, int i7, long j4, int i8, long j5, int i9, int i10, int i11, int i12, int i13, int i14, int i15, float f, int i16, double d);

    protected static native long collect400000(long j, long j2, int i, int i2, @javax.annotation.Nullable java.lang.String str, int i3, @javax.annotation.Nullable java.lang.String str2, int i4, @javax.annotation.Nullable java.lang.String str3, int i5, @javax.annotation.Nullable java.lang.String str4);

    protected static native long collect430000(long j, long j2, int i, int i2, @javax.annotation.Nullable java.lang.String str, int i3, @javax.annotation.Nullable java.lang.String str2, int i4, @javax.annotation.Nullable java.lang.String str3, int i5, @javax.annotation.Nullable java.lang.String str4, int i6, @javax.annotation.Nullable byte[] bArr, int i7, @javax.annotation.Nullable byte[] bArr2, int i8, @javax.annotation.Nullable byte[] bArr3);

    protected static native long collectCharArray(long j, long j2, int i, int i2, @javax.annotation.Nullable char[] cArr);

    protected static native long collectDoubleArray(long j, long j2, int i, int i2, @javax.annotation.Nullable double[] dArr);

    protected static native long collectFloatArray(long j, long j2, int i, int i2, @javax.annotation.Nullable float[] fArr);

    protected static native long collectIntArray(long j, long j2, int i, int i2, @javax.annotation.Nullable int[] iArr);

    protected static native long collectLongArray(long j, long j2, int i, int i2, @javax.annotation.Nullable long[] jArr);

    protected static native long collectShortArray(long j, long j2, int i, int i2, @javax.annotation.Nullable short[] sArr);

    protected static native long collectStringArray(long j, long j2, int i, int i2, @javax.annotation.Nullable java.lang.String[] strArr);

    protected static native long collectStringList(long j, long j2, int i, int i2, @javax.annotation.Nullable java.util.List<java.lang.String> list);

    static native boolean nativeDeleteEntity(long j, long j2);

    static native java.lang.Object nativeFirstEntity(long j);

    static native java.lang.Object nativeGetEntity(long j, long j2);

    static native long nativeLookupKeyUsingIndex(long j, int i, java.lang.String str);

    static native java.lang.Object nativeNextEntity(long j);

    static native boolean nativeSeek(long j, long j2);

    protected abstract long getId(T t);

    native long nativeCount(long j, long j2);

    native void nativeDeleteAll(long j);

    native void nativeDestroy(long j);

    native java.util.List<T> nativeGetAllEntities(long j);

    native java.util.List<T> nativeGetBacklinkEntities(long j, int i, int i2, long j2);

    native long[] nativeGetBacklinkIds(long j, int i, int i2, long j2);

    native long nativeGetCursorFor(long j, int i);

    native java.util.List<T> nativeGetRelationEntities(long j, int i, int i2, long j2, boolean z);

    native long[] nativeGetRelationIds(long j, int i, int i2, long j2, boolean z);

    native void nativeModifyRelations(long j, int i, long j2, long[] jArr, boolean z);

    native void nativeModifyRelationsSingle(long j, int i, long j2, long j3, boolean z);

    native int nativePropertyId(long j, java.lang.String str);

    native long nativeRenew(long j);

    native void nativeSetBoxStoreForEntities(long j, java.lang.Object obj);

    public abstract long put(T t);

    protected Cursor(io.objectbox.Transaction transaction, long j, io.objectbox.EntityInfo<T> entityInfo, io.objectbox.BoxStore boxStore) {
        if (transaction == null) {
            throw new java.lang.IllegalArgumentException("Transaction is null");
        }
        this.tx = transaction;
        this.readOnly = transaction.isReadOnly();
        this.cursor = j;
        this.entityInfo = entityInfo;
        this.boxStoreForEntities = boxStore;
        for (io.objectbox.Property<T> property : entityInfo.getAllProperties()) {
            if (!property.isIdVerified()) {
                property.verifyId(getPropertyId(property.dbName));
            }
        }
        this.creationThrowable = TRACK_CREATION_STACK ? new java.lang.Throwable() : null;
        nativeSetBoxStoreForEntities(j, boxStore);
    }

    protected void finalize() throws java.lang.Throwable {
        if (this.closed) {
            return;
        }
        if (!this.readOnly || LOG_READ_NOT_CLOSED) {
            java.lang.System.err.println("Cursor was not closed.");
            if (this.creationThrowable != null) {
                java.lang.System.err.println("Cursor was initially created here:");
                this.creationThrowable.printStackTrace();
            }
            java.lang.System.err.flush();
        }
        close();
        super.finalize();
    }

    public io.objectbox.EntityInfo<T> getEntityInfo() {
        return this.entityInfo;
    }

    public T get(long j) {
        return (T) nativeGetEntity(this.cursor, j);
    }

    public T next() {
        return (T) nativeNextEntity(this.cursor);
    }

    public T first() {
        return (T) nativeFirstEntity(this.cursor);
    }

    public java.util.List<T> getAll() {
        return nativeGetAllEntities(this.cursor);
    }

    public boolean deleteEntity(long j) {
        return nativeDeleteEntity(this.cursor, j);
    }

    public void deleteAll() {
        nativeDeleteAll(this.cursor);
    }

    public boolean seek(long j) {
        return nativeSeek(this.cursor, j);
    }

    public long count(long j) {
        return nativeCount(this.cursor, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            io.objectbox.Transaction transaction = this.tx;
            if (transaction != null && !transaction.getStore().isClosed()) {
                nativeDestroy(this.cursor);
            }
        }
    }

    public int getPropertyId(java.lang.String str) {
        return nativePropertyId(this.cursor, str);
    }

    long lookupKeyUsingIndex(int i, java.lang.String str) {
        return nativeLookupKeyUsingIndex(this.cursor, i, str);
    }

    public io.objectbox.Transaction getTx() {
        return this.tx;
    }

    public boolean isObsolete() {
        return this.tx.isObsolete();
    }

    public boolean isClosed() {
        return this.closed;
    }

    protected <TARGET> io.objectbox.Cursor<TARGET> getRelationTargetCursor(java.lang.Class<TARGET> cls) {
        io.objectbox.EntityInfo<T> entityInfo = this.boxStoreForEntities.getEntityInfo(cls);
        return entityInfo.getCursorFactory().createCursor(this.tx, nativeGetCursorFor(this.cursor, entityInfo.getEntityId()), this.boxStoreForEntities);
    }

    public void renew() {
        nativeRenew(this.cursor);
    }

    long internalHandle() {
        return this.cursor;
    }

    java.util.List<T> getBacklinkEntities(int i, io.objectbox.Property<?> property, long j) {
        try {
            return nativeGetBacklinkEntities(this.cursor, i, property.getId(), j);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.lang.IllegalArgumentException("Please check if the given property belongs to a valid @Relation: " + property, e);
        }
    }

    long[] getBacklinkIds(int i, io.objectbox.Property<?> property, long j) {
        try {
            return nativeGetBacklinkIds(this.cursor, i, property.getId(), j);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.lang.IllegalArgumentException("Please check if the given property belongs to a valid @Relation: " + property, e);
        }
    }

    public java.util.List<T> getRelationEntities(int i, int i2, long j, boolean z) {
        return nativeGetRelationEntities(this.cursor, i, i2, j, z);
    }

    public long[] getRelationIds(int i, int i2, long j, boolean z) {
        return nativeGetRelationIds(this.cursor, i, i2, j, z);
    }

    public void modifyRelations(int i, long j, long[] jArr, boolean z) {
        nativeModifyRelations(this.cursor, i, j, jArr, z);
    }

    public void modifyRelationsSingle(int i, long j, long j2, boolean z) {
        nativeModifyRelationsSingle(this.cursor, i, j, j2, z);
    }

    protected <TARGET> void checkApplyToManyToDb(java.util.List<TARGET> list, java.lang.Class<TARGET> cls) {
        if (list instanceof io.objectbox.relation.ToMany) {
            io.objectbox.relation.ToMany toMany = (io.objectbox.relation.ToMany) list;
            if (toMany.internalCheckApplyToDbRequired()) {
                io.objectbox.Cursor<TARGET> relationTargetCursor = getRelationTargetCursor(cls);
                try {
                    toMany.internalApplyToDb(this, relationTargetCursor);
                    if (relationTargetCursor != null) {
                        relationTargetCursor.close();
                    }
                } catch (java.lang.Throwable th) {
                    if (relationTargetCursor != null) {
                        try {
                            relationTargetCursor.close();
                        } catch (java.lang.Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Cursor ");
        sb.append(java.lang.Long.toString(this.cursor, 16));
        sb.append(isClosed() ? "(closed)" : "");
        return sb.toString();
    }
}
