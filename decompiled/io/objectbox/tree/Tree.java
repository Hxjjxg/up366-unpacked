package io.objectbox.tree;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Tree implements java.io.Closeable {
    private long handle;
    private java.lang.String pathSeparatorRegex = "\\.";
    private long rootId;
    private final io.objectbox.BoxStore store;

    static native long nativeCreate(long j, long j2);

    static native long nativeCreateWithUid(long j, java.lang.String str);

    static native void nativeDelete(long j);

    native void nativeClearTransaction(long j);

    native io.objectbox.tree.LeafNode nativeGetLeafById(long j, long j2);

    native long nativeGetRootId(long j);

    native long nativePutBranch(long j, long j2, long j3, long j4, @javax.annotation.Nullable java.lang.String str);

    native long nativePutMetaBranch(long j, long j2, long j3, java.lang.String str, @javax.annotation.Nullable java.lang.String str2);

    native long[] nativePutMetaBranches(long j, long j2, java.lang.String[] strArr);

    native long nativePutMetaLeaf(long j, long j2, long j3, java.lang.String str, short s, boolean z, @javax.annotation.Nullable java.lang.String str2);

    native long nativePutValueFP(long j, long j2, long j3, long j4, double d);

    native long nativePutValueInteger(long j, long j2, long j3, long j4, long j5);

    native long nativePutValueString(long j, long j2, long j3, long j4, @javax.annotation.Nullable java.lang.String str);

    native boolean nativeSetTransaction(long j, long j2);

    public Tree(io.objectbox.BoxStore boxStore, java.lang.String str) {
        this.store = boxStore;
        if (boxStore == null) {
            throw new java.lang.IllegalArgumentException("store must not be null");
        }
        if (str == null || str.length() == 0) {
            throw new java.lang.IllegalArgumentException("uid must be 0 or not empty");
        }
        this.handle = nativeCreateWithUid(boxStore.getNativeStore(), str);
    }

    public Tree(io.objectbox.BoxStore boxStore, long j) {
        this.store = boxStore;
        this.rootId = j;
        if (boxStore == null) {
            throw new java.lang.IllegalArgumentException("store must not be null");
        }
        this.handle = nativeCreate(boxStore.getNativeStore(), j);
    }

    long getHandle() {
        return this.handle;
    }

    public java.lang.String getPathSeparatorRegex() {
        return this.pathSeparatorRegex;
    }

    public void setPathSeparatorRegex(java.lang.String str) {
        this.pathSeparatorRegex = str;
    }

    public long getRootId() {
        return this.rootId;
    }

    public io.objectbox.BoxStore getStore() {
        return this.store;
    }

    public io.objectbox.tree.Branch getRoot() {
        return new io.objectbox.tree.Branch(this, nativeGetRootId(this.handle));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        nativeDelete(this.handle);
        this.handle = 0L;
    }

    public void runInTx(java.lang.Runnable runnable) {
        this.store.runInTx(createTxRunnable(runnable));
    }

    public void runInReadTx(java.lang.Runnable runnable) {
        this.store.runInReadTx(createTxRunnable(runnable));
    }

    public <T> T callInTx(java.util.concurrent.Callable<T> callable) throws java.lang.Exception {
        return (T) this.store.callInTx(createTxCallable(callable));
    }

    public <T> T callInTxNoThrow(java.util.concurrent.Callable<T> callable) {
        try {
            return (T) this.store.callInTx(createTxCallable(callable));
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Callable threw exception", e);
        }
    }

    public <T> T callInReadTx(java.util.concurrent.Callable<T> callable) {
        return (T) this.store.callInReadTx(createTxCallable(callable));
    }

    private java.lang.Runnable createTxRunnable(final java.lang.Runnable runnable) {
        return new java.lang.Runnable() { // from class: io.objectbox.tree.Tree$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1431lambda$createTxRunnable$0$ioobjectboxtreeTree(runnable);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$createTxRunnable$0$io-objectbox-tree-Tree, reason: not valid java name */
    /* synthetic */ void m1431lambda$createTxRunnable$0$ioobjectboxtreeTree(java.lang.Runnable runnable) {
        boolean zNativeSetTransaction = nativeSetTransaction(this.handle, io.objectbox.InternalAccess.getHandle(io.objectbox.InternalAccess.getActiveTx(this.store)));
        try {
            runnable.run();
        } finally {
            if (zNativeSetTransaction) {
                nativeClearTransaction(this.handle);
            }
        }
    }

    private <T> java.util.concurrent.Callable<T> createTxCallable(final java.util.concurrent.Callable<T> callable) {
        return new java.util.concurrent.Callable() { // from class: io.objectbox.tree.Tree$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1430lambda$createTxCallable$1$ioobjectboxtreeTree(callable);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$createTxCallable$1$io-objectbox-tree-Tree, reason: not valid java name */
    /* synthetic */ java.lang.Object m1430lambda$createTxCallable$1$ioobjectboxtreeTree(java.util.concurrent.Callable callable) throws java.lang.Exception {
        boolean zNativeSetTransaction = nativeSetTransaction(this.handle, io.objectbox.InternalAccess.getHandle(io.objectbox.InternalAccess.getActiveTx(this.store)));
        try {
            return callable.call();
        } finally {
            if (zNativeSetTransaction) {
                nativeClearTransaction(this.handle);
            }
        }
    }

    @javax.annotation.Nullable
    public io.objectbox.tree.Leaf getLeaf(long j) {
        io.objectbox.tree.LeafNode leafNodeNativeGetLeafById = nativeGetLeafById(this.handle, j);
        if (leafNodeNativeGetLeafById == null) {
            return null;
        }
        return new io.objectbox.tree.Leaf(leafNodeNativeGetLeafById);
    }

    @javax.annotation.Nullable
    public java.lang.String getString(long j) {
        io.objectbox.tree.Leaf leaf = getLeaf(j);
        if (leaf != null) {
            return leaf.asString();
        }
        return null;
    }

    @javax.annotation.Nullable
    public java.lang.Long getInteger(long j) {
        io.objectbox.tree.Leaf leaf = getLeaf(j);
        if (leaf != null) {
            return leaf.asInt();
        }
        return null;
    }

    @javax.annotation.Nullable
    public java.lang.Double getDouble(long j) {
        io.objectbox.tree.Leaf leaf = getLeaf(j);
        if (leaf != null) {
            return leaf.asDouble();
        }
        return null;
    }

    public long putMetaBranch(long j, long j2, java.lang.String str) {
        return nativePutMetaBranch(this.handle, j, j2, str, null);
    }

    public long putMetaBranch(long j, long j2, java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
        return nativePutMetaBranch(this.handle, j, j2, str, str2);
    }

    public long[] putMetaBranches(java.lang.String[] strArr) {
        return nativePutMetaBranches(this.handle, 0L, strArr);
    }

    public long[] putMetaBranches(long j, java.lang.String[] strArr) {
        return nativePutMetaBranches(this.handle, j, strArr);
    }

    public long putMetaLeaf(long j, long j2, java.lang.String str, short s) {
        return nativePutMetaLeaf(this.handle, j, j2, str, s, false, null);
    }

    public long putMetaLeaf(long j, long j2, java.lang.String str, short s, boolean z) {
        return nativePutMetaLeaf(this.handle, j, j2, str, s, z, null);
    }

    public long putMetaLeaf(long j, long j2, java.lang.String str, short s, boolean z, @javax.annotation.Nullable java.lang.String str2) {
        return nativePutMetaLeaf(this.handle, j, j2, str, s, z, str2);
    }

    public long putBranch(long j, long j2, long j3, @javax.annotation.Nullable java.lang.String str) {
        return nativePutBranch(this.handle, j, j2, j3, str);
    }

    public long putBranch(long j, long j2, @javax.annotation.Nullable java.lang.String str) {
        return nativePutBranch(this.handle, 0L, j, j2, str);
    }

    public long putBranch(long j, long j2) {
        return nativePutBranch(this.handle, 0L, j, j2, null);
    }

    public long putValue(long j, long j2, long j3, long j4) {
        return nativePutValueInteger(this.handle, j, j2, j3, j4);
    }

    public long putValue(long j, long j2, long j3) {
        return nativePutValueInteger(this.handle, 0L, j, j2, j3);
    }

    public long putValue(long j, long j2, double d) {
        return nativePutValueFP(this.handle, 0L, j, j2, d);
    }

    public long putValue(long j, long j2, long j3, double d) {
        return nativePutValueFP(this.handle, j, j2, j3, d);
    }

    public long putValue(long j, long j2, long j3, java.lang.String str) {
        return nativePutValueString(this.handle, j, j2, j3, str);
    }

    public long putValue(long j, long j2, java.lang.String str) {
        return nativePutValueString(this.handle, 0L, j, j2, str);
    }

    public long put(io.objectbox.tree.Leaf leaf) {
        long id = leaf.getId();
        long parentBranchId = leaf.getParentBranchId();
        long metaId = leaf.getMetaId();
        short valueType = leaf.getValueType();
        if (valueType != 23) {
            switch (valueType) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return nativePutValueInteger(this.handle, id, parentBranchId, metaId, leaf.getInt());
                case 7:
                case 8:
                    return nativePutValueFP(this.handle, id, parentBranchId, metaId, leaf.getDouble());
                case 9:
                    break;
                default:
                    throw new java.lang.UnsupportedOperationException("Unsupported value type: " + ((int) leaf.getValueType()));
            }
        }
        return nativePutValueString(this.handle, id, parentBranchId, metaId, leaf.getString());
    }
}
