package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BoxStore implements java.io.Closeable {
    public static final java.lang.String IN_MEMORY_PREFIX = "memory:";
    public static final java.lang.String JNI_VERSION = "3.8.0";
    private static final java.lang.String VERSION = "3.8.0-2024-02-13";

    @javax.annotation.Nullable
    private static java.lang.Object context;
    private static io.objectbox.BoxStore defaultStore;
    private static final java.util.Set<java.lang.String> openFiles = new java.util.HashSet();
    private static volatile java.lang.Thread openFilesCheckerThread;

    @javax.annotation.Nullable
    private static java.lang.Object relinker;
    private final int[] allEntityTypeIds;
    private final java.lang.String canonicalPath;
    private volatile boolean closed;
    volatile int commitCount;
    final boolean debugRelations;
    final boolean debugTxRead;
    final boolean debugTxWrite;
    private final java.io.File directory;
    private final io.objectbox.TxCallback<?> failedReadTxAttemptCallback;
    private long handle;
    private int objectBrowserPort;
    private final io.objectbox.ObjectClassPublisher objectClassPublisher;
    private final int queryAttempts;

    @javax.annotation.Nullable
    private io.objectbox.sync.SyncClient syncClient;
    private final java.util.Map<java.lang.Class<?>, java.lang.String> dbNameByClass = new java.util.HashMap();
    private final java.util.Map<java.lang.Class<?>, java.lang.Integer> entityTypeIdByClass = new java.util.HashMap();
    private final java.util.Map<java.lang.Class<?>, io.objectbox.EntityInfo<?>> propertiesByClass = new java.util.HashMap();
    private final org.greenrobot.essentials.collections.LongHashMap<java.lang.Class<?>> classByEntityTypeId = new org.greenrobot.essentials.collections.LongHashMap<>();
    private final java.util.Map<java.lang.Class<?>, io.objectbox.Box<?>> boxes = new java.util.concurrent.ConcurrentHashMap();
    private final java.util.Set<io.objectbox.Transaction> transactions = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());
    private final java.util.concurrent.ExecutorService threadPool = new io.objectbox.internal.ObjectBoxThreadPool(this);
    final java.lang.ThreadLocal<io.objectbox.Transaction> activeTx = new java.lang.ThreadLocal<>();
    final java.lang.Object txCommitCountLock = new java.lang.Object();

    static native long nativeBeginReadTx(long j);

    static native long nativeBeginTx(long j);

    static native int nativeCleanStaleReadTransactions(long j);

    static native long nativeCreateWithFlatOptions(byte[] bArr, byte[] bArr2);

    static native void nativeDelete(long j);

    static native java.lang.String nativeDiagnose(long j);

    static native void nativeDropAllData(long j);

    static native java.lang.String nativeGetVersion();

    static native long nativeGloballyActiveEntityTypes();

    private static native boolean nativeHasFeature(int i);

    static native boolean nativeIsObjectBrowserAvailable();

    static native boolean nativeIsReadOnly(long j);

    static native void nativeRegisterCustomType(long j, int i, int i2, java.lang.String str, java.lang.Class<? extends io.objectbox.converter.PropertyConverter> cls, java.lang.Class<?> cls2);

    static native int nativeRegisterEntityClass(long j, java.lang.String str, java.lang.Class<?> cls);

    static native boolean nativeRemoveDbFiles(java.lang.String str, boolean z);

    static native void nativeSetDbExceptionListener(long j, @javax.annotation.Nullable io.objectbox.exception.DbExceptionListener dbExceptionListener);

    static native void nativeSetDebugFlags(long j, int i);

    private native java.lang.String nativeStartObjectBrowser(long j, @javax.annotation.Nullable java.lang.String str, int i);

    private native boolean nativeStopObjectBrowser(long j);

    static native long nativeSysProcMeminfoKb(java.lang.String str);

    static native long nativeSysProcStatusKb(java.lang.String str);

    native long nativePanicModeRemoveAllObjects(long j, int i);

    native long nativeSizeOnDisk(long j);

    native long nativeValidate(long j, long j2, boolean z);

    @javax.annotation.Nullable
    public static synchronized java.lang.Object getContext() {
        return context;
    }

    @javax.annotation.Nullable
    public static synchronized java.lang.Object getRelinker() {
        return relinker;
    }

    public static synchronized io.objectbox.BoxStore getDefault() {
        io.objectbox.BoxStore boxStore;
        boxStore = defaultStore;
        if (boxStore == null) {
            throw new java.lang.IllegalStateException("Please call buildDefault() before calling this method");
        }
        return boxStore;
    }

    static synchronized void setDefault(io.objectbox.BoxStore boxStore) {
        if (defaultStore != null) {
            throw new java.lang.IllegalStateException("Default store was already built before. ");
        }
        defaultStore = boxStore;
    }

    public static synchronized boolean clearDefaultStore() {
        boolean z;
        z = defaultStore != null;
        defaultStore = null;
        return z;
    }

    public static java.lang.String getVersion() {
        return VERSION;
    }

    public static java.lang.String getVersionNative() {
        io.objectbox.internal.NativeLibraryLoader.ensureLoaded();
        return nativeGetVersion();
    }

    public static boolean hasFeature(io.objectbox.internal.Feature feature) {
        try {
            io.objectbox.internal.NativeLibraryLoader.ensureLoaded();
            return nativeHasFeature(feature.id);
        } catch (java.lang.UnsatisfiedLinkError e) {
            java.lang.System.err.println("Old JNI lib? " + e);
            return false;
        }
    }

    public static boolean isObjectBrowserAvailable() {
        return hasFeature(io.objectbox.internal.Feature.ADMIN);
    }

    public static boolean isSyncAvailable() {
        return hasFeature(io.objectbox.internal.Feature.SYNC);
    }

    public static boolean isSyncServerAvailable() {
        return hasFeature(io.objectbox.internal.Feature.SYNC_SERVER);
    }

    BoxStore(io.objectbox.BoxStoreBuilder boxStoreBuilder) {
        context = boxStoreBuilder.context;
        relinker = boxStoreBuilder.relinker;
        io.objectbox.internal.NativeLibraryLoader.ensureLoaded();
        java.io.File file = boxStoreBuilder.directory;
        this.directory = file;
        java.lang.String canonicalPath = getCanonicalPath(file);
        this.canonicalPath = canonicalPath;
        verifyNotAlreadyOpen(canonicalPath);
        try {
            long jNativeCreateWithFlatOptions = nativeCreateWithFlatOptions(boxStoreBuilder.buildFlatStoreOptions(canonicalPath), boxStoreBuilder.model);
            this.handle = jNativeCreateWithFlatOptions;
            if (jNativeCreateWithFlatOptions == 0) {
                throw new io.objectbox.exception.DbException("Could not create native store");
            }
            int i = boxStoreBuilder.debugFlags;
            if (i != 0) {
                this.debugTxRead = (i & 1) != 0;
                this.debugTxWrite = (i & 2) != 0;
            } else {
                this.debugTxWrite = false;
                this.debugTxRead = false;
            }
            this.debugRelations = boxStoreBuilder.debugRelations;
            for (io.objectbox.EntityInfo<?> entityInfo : boxStoreBuilder.entityInfoList) {
                try {
                    this.dbNameByClass.put(entityInfo.getEntityClass(), entityInfo.getDbName());
                    int iNativeRegisterEntityClass = nativeRegisterEntityClass(this.handle, entityInfo.getDbName(), entityInfo.getEntityClass());
                    this.entityTypeIdByClass.put(entityInfo.getEntityClass(), java.lang.Integer.valueOf(iNativeRegisterEntityClass));
                    this.classByEntityTypeId.put(iNativeRegisterEntityClass, entityInfo.getEntityClass());
                    this.propertiesByClass.put(entityInfo.getEntityClass(), entityInfo);
                    for (io.objectbox.Property<?> property : entityInfo.getAllProperties()) {
                        if (property.customType != null) {
                            if (property.converterClass == null) {
                                throw new java.lang.RuntimeException("No converter class for custom type of " + property);
                            }
                            nativeRegisterCustomType(this.handle, iNativeRegisterEntityClass, 0, property.dbName, property.converterClass, property.customType);
                        }
                    }
                } catch (java.lang.RuntimeException e) {
                    throw new java.lang.RuntimeException("Could not setup up entity " + entityInfo.getEntityClass(), e);
                }
            }
            int size = this.classByEntityTypeId.size();
            this.allEntityTypeIds = new int[size];
            long[] jArrKeys = this.classByEntityTypeId.keys();
            for (int i2 = 0; i2 < size; i2++) {
                this.allEntityTypeIds[i2] = (int) jArrKeys[i2];
            }
            this.objectClassPublisher = new io.objectbox.ObjectClassPublisher(this);
            this.failedReadTxAttemptCallback = boxStoreBuilder.failedReadTxAttemptCallback;
            this.queryAttempts = java.lang.Math.max(boxStoreBuilder.queryAttempts, 1);
        } catch (java.lang.RuntimeException e2) {
            close();
            throw e2;
        }
    }

    static java.lang.String getCanonicalPath(java.io.File file) {
        if (file.getPath().startsWith(IN_MEMORY_PREFIX)) {
            return file.getPath();
        }
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new io.objectbox.exception.DbException("Is not a directory: " + file.getAbsolutePath());
            }
        } else if (!file.mkdirs()) {
            throw new io.objectbox.exception.DbException("Could not create directory: " + file.getAbsolutePath());
        }
        try {
            return file.getCanonicalPath();
        } catch (java.io.IOException e) {
            throw new io.objectbox.exception.DbException("Could not verify dir", e);
        }
    }

    static void verifyNotAlreadyOpen(java.lang.String str) {
        java.util.Set<java.lang.String> set = openFiles;
        synchronized (set) {
            isFileOpen(str);
            if (!set.add(str)) {
                throw new io.objectbox.exception.DbException("Another BoxStore is still open for this directory: " + str + ". Hint: for most apps it's recommended to keep a BoxStore for the app's life time.");
            }
        }
    }

    static boolean isFileOpen(final java.lang.String str) {
        boolean zContains;
        java.util.Set<java.lang.String> set = openFiles;
        synchronized (set) {
            if (!set.contains(str)) {
                return false;
            }
            java.lang.Thread thread = openFilesCheckerThread;
            if (thread == null || !thread.isAlive()) {
                java.lang.Thread thread2 = new java.lang.Thread(new java.lang.Runnable() { // from class: io.objectbox.BoxStore$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        io.objectbox.BoxStore.lambda$isFileOpen$0(str);
                    }
                });
                thread2.setDaemon(true);
                openFilesCheckerThread = thread2;
                thread2.start();
                try {
                    thread2.join(500L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
                java.util.Set<java.lang.String> set2 = openFiles;
                synchronized (set2) {
                    zContains = set2.contains(str);
                }
                return zContains;
            }
            return isFileOpenSync(str, false);
        }
    }

    static /* synthetic */ void lambda$isFileOpen$0(java.lang.String str) {
        isFileOpenSync(str, true);
        openFilesCheckerThread = null;
    }

    static boolean isFileOpenSync(java.lang.String str, boolean z) {
        boolean zContains;
        synchronized (openFiles) {
            int i = 0;
            while (i < 5) {
                java.util.Set<java.lang.String> set = openFiles;
                if (!set.contains(str)) {
                    break;
                }
                i++;
                java.lang.System.gc();
                if (z && i > 1) {
                    java.lang.System.runFinalization();
                }
                java.lang.System.gc();
                if (z && i > 1) {
                    java.lang.System.runFinalization();
                }
                try {
                    set.wait(100L);
                } catch (java.lang.InterruptedException unused) {
                }
            }
            zContains = openFiles.contains(str);
        }
        return zContains;
    }

    public static boolean isDatabaseOpen(java.lang.Object obj, @javax.annotation.Nullable java.lang.String str) throws java.io.IOException {
        return isFileOpen(io.objectbox.BoxStoreBuilder.getAndroidDbDir(obj, str).getCanonicalPath());
    }

    public static boolean isDatabaseOpen(@javax.annotation.Nullable java.io.File file, @javax.annotation.Nullable java.lang.String str) throws java.io.IOException {
        return isFileOpen(io.objectbox.BoxStoreBuilder.getDbDir(file, str).getCanonicalPath());
    }

    public static boolean isDatabaseOpen(java.io.File file) throws java.io.IOException {
        return isFileOpen(file.getCanonicalPath());
    }

    public static long sysProcMeminfoKb(java.lang.String str) {
        io.objectbox.internal.NativeLibraryLoader.ensureLoaded();
        return nativeSysProcMeminfoKb(str);
    }

    public static long sysProcStatusKb(java.lang.String str) {
        io.objectbox.internal.NativeLibraryLoader.ensureLoaded();
        return nativeSysProcStatusKb(str);
    }

    public long sizeOnDisk() {
        return nativeSizeOnDisk(getNativeStore());
    }

    protected void finalize() throws java.lang.Throwable {
        close();
        super.finalize();
    }

    private void checkOpen() {
        if (isClosed()) {
            throw new java.lang.IllegalStateException("Store is closed");
        }
    }

    java.lang.String getDbName(java.lang.Class<?> cls) {
        return this.dbNameByClass.get(cls);
    }

    java.lang.Integer getEntityTypeId(java.lang.Class<?> cls) {
        return this.entityTypeIdByClass.get(cls);
    }

    public int getEntityTypeIdOrThrow(java.lang.Class<?> cls) {
        java.lang.Integer num = this.entityTypeIdByClass.get(cls);
        if (num == null) {
            throw new io.objectbox.exception.DbSchemaException("No entity registered for " + cls);
        }
        return num.intValue();
    }

    public java.util.Collection<java.lang.Class<?>> getAllEntityClasses() {
        return this.dbNameByClass.keySet();
    }

    int[] getAllEntityTypeIds() {
        return this.allEntityTypeIds;
    }

    java.lang.Class<?> getEntityClassOrThrow(int i) {
        java.lang.Class<?> cls = (java.lang.Class) this.classByEntityTypeId.get(i);
        if (cls != null) {
            return cls;
        }
        throw new io.objectbox.exception.DbSchemaException("No entity registered for type ID " + i);
    }

    <T> io.objectbox.EntityInfo<T> getEntityInfo(java.lang.Class<T> cls) {
        return (io.objectbox.EntityInfo) this.propertiesByClass.get(cls);
    }

    public io.objectbox.Transaction beginTx() {
        int i = this.commitCount;
        if (this.debugTxWrite) {
            java.lang.System.out.println("Begin TX with commit count " + i);
        }
        long jNativeBeginTx = nativeBeginTx(getNativeStore());
        if (jNativeBeginTx == 0) {
            throw new io.objectbox.exception.DbException("Could not create native transaction");
        }
        io.objectbox.Transaction transaction = new io.objectbox.Transaction(this, jNativeBeginTx, i);
        synchronized (this.transactions) {
            this.transactions.add(transaction);
        }
        return transaction;
    }

    public io.objectbox.Transaction beginReadTx() {
        int i = this.commitCount;
        if (this.debugTxRead) {
            java.lang.System.out.println("Begin read TX with commit count " + i);
        }
        long jNativeBeginReadTx = nativeBeginReadTx(getNativeStore());
        if (jNativeBeginReadTx == 0) {
            throw new io.objectbox.exception.DbException("Could not create native read transaction");
        }
        io.objectbox.Transaction transaction = new io.objectbox.Transaction(this, jNativeBeginReadTx, i);
        synchronized (this.transactions) {
            this.transactions.add(transaction);
        }
        return transaction;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isReadOnly() {
        return nativeIsReadOnly(getNativeStore());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean z;
        java.util.ArrayList arrayList;
        synchronized (this) {
            z = this.closed;
            if (!this.closed) {
                if (this.objectBrowserPort != 0) {
                    try {
                        stopObjectBrowser();
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.closed = true;
                synchronized (this.transactions) {
                    arrayList = new java.util.ArrayList(this.transactions);
                }
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((io.objectbox.Transaction) it.next()).close();
                }
                long j = this.handle;
                if (j != 0) {
                    nativeDelete(j);
                    this.handle = 0L;
                }
                this.threadPool.shutdown();
                checkThreadTermination();
            }
        }
        if (z) {
            return;
        }
        java.util.Set<java.lang.String> set = openFiles;
        synchronized (set) {
            set.remove(this.canonicalPath);
            set.notifyAll();
        }
    }

    private void checkThreadTermination() {
        try {
            if (this.threadPool.awaitTermination(1L, java.util.concurrent.TimeUnit.SECONDS)) {
                return;
            }
            int iActiveCount = java.lang.Thread.activeCount();
            java.lang.System.err.println("Thread pool not terminated in time; printing stack traces...");
            java.lang.Thread[] threadArr = new java.lang.Thread[iActiveCount + 2];
            int iEnumerate = java.lang.Thread.enumerate(threadArr);
            for (int i = 0; i < iEnumerate; i++) {
                java.lang.System.err.println("Thread: " + threadArr[i].getName());
                java.lang.Thread.dumpStack();
            }
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteAllFiles() {
        if (!isClosed()) {
            throw new java.lang.IllegalStateException("Store must be closed");
        }
        return deleteAllFiles(this.directory);
    }

    public static boolean deleteAllFiles(java.io.File file) {
        java.lang.String canonicalPath = getCanonicalPath(file);
        if (isFileOpen(canonicalPath)) {
            throw new java.lang.IllegalStateException("Cannot delete files: store is still open");
        }
        io.objectbox.internal.NativeLibraryLoader.ensureLoaded();
        return nativeRemoveDbFiles(canonicalPath, true);
    }

    public static boolean deleteAllFiles(java.lang.Object obj, @javax.annotation.Nullable java.lang.String str) {
        return deleteAllFiles(io.objectbox.BoxStoreBuilder.getAndroidDbDir(obj, str));
    }

    public static boolean deleteAllFiles(@javax.annotation.Nullable java.io.File file, @javax.annotation.Nullable java.lang.String str) {
        return deleteAllFiles(io.objectbox.BoxStoreBuilder.getDbDir(file, str));
    }

    public void removeAllObjects() {
        nativeDropAllData(getNativeStore());
    }

    public void unregisterTransaction(io.objectbox.Transaction transaction) {
        synchronized (this.transactions) {
            this.transactions.remove(transaction);
        }
    }

    void txCommitted(io.objectbox.Transaction transaction, @javax.annotation.Nullable int[] iArr) {
        synchronized (this.txCommitCountLock) {
            this.commitCount++;
            if (this.debugTxWrite) {
                java.io.PrintStream printStream = java.lang.System.out;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("TX committed. New commit count: ");
                sb.append(this.commitCount);
                sb.append(", entity types affected: ");
                sb.append(iArr != null ? iArr.length : 0);
                printStream.println(sb.toString());
            }
        }
        java.util.Iterator<io.objectbox.Box<?>> it = this.boxes.values().iterator();
        while (it.hasNext()) {
            it.next().txCommitted(transaction);
        }
        if (iArr != null) {
            this.objectClassPublisher.publish(iArr);
        }
    }

    public <T> io.objectbox.Box<T> boxFor(java.lang.Class<T> cls) {
        io.objectbox.Box<?> box;
        io.objectbox.Box<T> box2 = (io.objectbox.Box) this.boxes.get(cls);
        if (box2 != null) {
            return box2;
        }
        if (!this.dbNameByClass.containsKey(cls)) {
            throw new java.lang.IllegalArgumentException(cls + " is not a known entity. Please add it and trigger generation again.");
        }
        synchronized (this.boxes) {
            box = this.boxes.get(cls);
            if (box == null) {
                box = new io.objectbox.Box<>(this, cls);
                this.boxes.put(cls, box);
            }
        }
        return (io.objectbox.Box<T>) box;
    }

    public void runInTx(java.lang.Runnable runnable) {
        io.objectbox.Transaction transaction = this.activeTx.get();
        if (transaction == null) {
            io.objectbox.Transaction transactionBeginTx = beginTx();
            this.activeTx.set(transactionBeginTx);
            try {
                runnable.run();
                transactionBeginTx.commit();
                return;
            } finally {
                this.activeTx.remove();
                transactionBeginTx.close();
            }
        }
        if (transaction.isReadOnly()) {
            throw new java.lang.IllegalStateException("Cannot start a transaction while a read only transaction is active");
        }
        runnable.run();
    }

    public void runInReadTx(java.lang.Runnable runnable) {
        if (this.activeTx.get() == null) {
            io.objectbox.Transaction transactionBeginReadTx = beginReadTx();
            this.activeTx.set(transactionBeginReadTx);
            try {
                runnable.run();
                return;
            } finally {
                this.activeTx.remove();
                java.util.Iterator<io.objectbox.Box<?>> it = this.boxes.values().iterator();
                while (it.hasNext()) {
                    it.next().readTxFinished(transactionBeginReadTx);
                }
                transactionBeginReadTx.close();
            }
        }
        runnable.run();
    }

    public <T> T callInReadTxWithRetry(java.util.concurrent.Callable<T> callable, int i, int i2, boolean z) {
        if (i == 1) {
            return (T) callInReadTx(callable);
        }
        if (i < 1) {
            throw new java.lang.IllegalArgumentException("Illegal value of attempts: " + i);
        }
        long j = i2;
        io.objectbox.exception.DbException e = null;
        for (int i3 = 1; i3 <= i; i3++) {
            try {
                return (T) callInReadTx(callable);
            } catch (io.objectbox.exception.DbException e2) {
                e = e2;
                java.lang.String strDiagnose = diagnose();
                java.lang.String str = i3 + " of " + i + " attempts of calling a read TX failed:";
                if (z) {
                    java.lang.System.err.println(str);
                    e.printStackTrace();
                    java.lang.System.err.println(strDiagnose);
                    java.lang.System.err.flush();
                    java.lang.System.gc();
                    java.lang.System.runFinalization();
                    cleanStaleReadTransactions();
                }
                io.objectbox.TxCallback<?> txCallback = this.failedReadTxAttemptCallback;
                if (txCallback != null) {
                    txCallback.txFinished(null, new io.objectbox.exception.DbException(str + " \n" + strDiagnose, e));
                }
                try {
                    java.lang.Thread.sleep(j);
                    j *= 2;
                } catch (java.lang.InterruptedException e3) {
                    e3.printStackTrace();
                    throw e;
                }
            }
        }
        throw e;
    }

    public <T> T callInReadTx(java.util.concurrent.Callable<T> callable) {
        if (this.activeTx.get() == null) {
            io.objectbox.Transaction transactionBeginReadTx = beginReadTx();
            this.activeTx.set(transactionBeginReadTx);
            try {
                try {
                    return callable.call();
                } catch (java.lang.RuntimeException e) {
                    throw e;
                } catch (java.lang.Exception e2) {
                    throw new java.lang.RuntimeException("Callable threw exception", e2);
                }
            } finally {
                this.activeTx.remove();
                java.util.Iterator<io.objectbox.Box<?>> it = this.boxes.values().iterator();
                while (it.hasNext()) {
                    it.next().readTxFinished(transactionBeginReadTx);
                }
                transactionBeginReadTx.close();
            }
        }
        try {
            return callable.call();
        } catch (java.lang.Exception e3) {
            throw new java.lang.RuntimeException("Callable threw exception", e3);
        }
    }

    public <R> R callInTx(java.util.concurrent.Callable<R> callable) throws java.lang.Exception {
        io.objectbox.Transaction transaction = this.activeTx.get();
        if (transaction == null) {
            io.objectbox.Transaction transactionBeginTx = beginTx();
            this.activeTx.set(transactionBeginTx);
            try {
                R rCall = callable.call();
                transactionBeginTx.commit();
                return rCall;
            } finally {
                this.activeTx.remove();
                transactionBeginTx.close();
            }
        }
        if (transaction.isReadOnly()) {
            throw new java.lang.IllegalStateException("Cannot start a transaction while a read only transaction is active");
        }
        return callable.call();
    }

    public <R> R callInTxNoException(java.util.concurrent.Callable<R> callable) {
        try {
            return (R) callInTx(callable);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void runInTxAsync(final java.lang.Runnable runnable, @javax.annotation.Nullable final io.objectbox.TxCallback<java.lang.Void> txCallback) {
        this.threadPool.submit(new java.lang.Runnable() { // from class: io.objectbox.BoxStore$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1394lambda$runInTxAsync$1$ioobjectboxBoxStore(runnable, txCallback);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$runInTxAsync$1$io-objectbox-BoxStore, reason: not valid java name */
    /* synthetic */ void m1394lambda$runInTxAsync$1$ioobjectboxBoxStore(java.lang.Runnable runnable, io.objectbox.TxCallback txCallback) {
        try {
            runInTx(runnable);
            if (txCallback != null) {
                txCallback.txFinished(null, null);
            }
        } catch (java.lang.Throwable th) {
            if (txCallback != null) {
                txCallback.txFinished(null, th);
            }
        }
    }

    public <R> void callInTxAsync(final java.util.concurrent.Callable<R> callable, @javax.annotation.Nullable final io.objectbox.TxCallback<R> txCallback) {
        this.threadPool.submit(new java.lang.Runnable() { // from class: io.objectbox.BoxStore$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1393lambda$callInTxAsync$2$ioobjectboxBoxStore(callable, txCallback);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$callInTxAsync$2$io-objectbox-BoxStore, reason: not valid java name */
    /* synthetic */ void m1393lambda$callInTxAsync$2$ioobjectboxBoxStore(java.util.concurrent.Callable callable, io.objectbox.TxCallback txCallback) {
        try {
            java.lang.Object objCallInTx = callInTx(callable);
            if (txCallback != null) {
                txCallback.txFinished(objCallInTx, null);
            }
        } catch (java.lang.Throwable th) {
            if (txCallback != null) {
                txCallback.txFinished(null, th);
            }
        }
    }

    public java.lang.String diagnose() {
        return nativeDiagnose(getNativeStore());
    }

    public long validate(long j, boolean z) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("pageLimit must be zero or positive");
        }
        return nativeValidate(getNativeStore(), j, z);
    }

    public int cleanStaleReadTransactions() {
        return nativeCleanStaleReadTransactions(getNativeStore());
    }

    public void closeThreadResources() {
        java.util.Iterator<io.objectbox.Box<?>> it = this.boxes.values().iterator();
        while (it.hasNext()) {
            it.next().closeThreadResources();
        }
    }

    public io.objectbox.reactive.SubscriptionBuilder<java.lang.Class> subscribe() {
        checkOpen();
        return new io.objectbox.reactive.SubscriptionBuilder<>(this.objectClassPublisher, null);
    }

    public <T> io.objectbox.reactive.SubscriptionBuilder<java.lang.Class<T>> subscribe(java.lang.Class<T> cls) {
        checkOpen();
        return new io.objectbox.reactive.SubscriptionBuilder<>(this.objectClassPublisher, cls);
    }

    @javax.annotation.Nullable
    public java.lang.String startObjectBrowser() {
        java.lang.String strStartObjectBrowser;
        verifyObjectBrowserNotRunning();
        for (int i = 8090; i < 8100; i++) {
            try {
                strStartObjectBrowser = startObjectBrowser(i);
            } catch (io.objectbox.exception.DbException e) {
                if (e.getMessage() == null || !e.getMessage().contains("port")) {
                    throw e;
                }
            }
            if (strStartObjectBrowser != null) {
                return strStartObjectBrowser;
            }
        }
        return null;
    }

    @javax.annotation.Nullable
    public java.lang.String startObjectBrowser(int i) {
        verifyObjectBrowserNotRunning();
        java.lang.String strNativeStartObjectBrowser = nativeStartObjectBrowser(getNativeStore(), null, i);
        if (strNativeStartObjectBrowser != null) {
            this.objectBrowserPort = i;
        }
        return strNativeStartObjectBrowser;
    }

    @javax.annotation.Nullable
    public java.lang.String startObjectBrowser(java.lang.String str) {
        verifyObjectBrowserNotRunning();
        try {
            int port = new java.net.URL(str).getPort();
            java.lang.String strNativeStartObjectBrowser = nativeStartObjectBrowser(getNativeStore(), str, 0);
            if (strNativeStartObjectBrowser != null) {
                this.objectBrowserPort = port;
            }
            return strNativeStartObjectBrowser;
        } catch (java.net.MalformedURLException e) {
            throw new java.lang.RuntimeException("Can not start Object Browser at " + str, e);
        }
    }

    public synchronized boolean stopObjectBrowser() {
        if (this.objectBrowserPort == 0) {
            throw new java.lang.IllegalStateException("ObjectBrowser has not been started before");
        }
        this.objectBrowserPort = 0;
        return nativeStopObjectBrowser(getNativeStore());
    }

    public int getObjectBrowserPort() {
        return this.objectBrowserPort;
    }

    public boolean isObjectBrowserRunning() {
        return this.objectBrowserPort != 0;
    }

    private void verifyObjectBrowserNotRunning() {
        if (this.objectBrowserPort == 0) {
            return;
        }
        throw new io.objectbox.exception.DbException("ObjectBrowser is already running at port " + this.objectBrowserPort);
    }

    public void setDbExceptionListener(@javax.annotation.Nullable io.objectbox.exception.DbExceptionListener dbExceptionListener) {
        nativeSetDbExceptionListener(getNativeStore(), dbExceptionListener);
    }

    public java.util.concurrent.Future<?> internalScheduleThread(java.lang.Runnable runnable) {
        return this.threadPool.submit(runnable);
    }

    public java.util.concurrent.ExecutorService internalThreadPool() {
        return this.threadPool;
    }

    public boolean isDebugRelations() {
        return this.debugRelations;
    }

    public int internalQueryAttempts() {
        return this.queryAttempts;
    }

    public io.objectbox.TxCallback<?> internalFailedReadTxAttemptCallback() {
        return this.failedReadTxAttemptCallback;
    }

    void setDebugFlags(int i) {
        nativeSetDebugFlags(getNativeStore(), i);
    }

    long panicModeRemoveAllObjects(int i) {
        return nativePanicModeRemoveAllObjects(getNativeStore(), i);
    }

    public long getNativeStore() {
        checkOpen();
        return this.handle;
    }

    @javax.annotation.Nullable
    public io.objectbox.sync.SyncClient getSyncClient() {
        return this.syncClient;
    }

    void setSyncClient(@javax.annotation.Nullable io.objectbox.sync.SyncClient syncClient) {
        this.syncClient = syncClient;
    }
}
