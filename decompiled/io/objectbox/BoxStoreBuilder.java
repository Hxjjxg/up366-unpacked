package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BoxStoreBuilder {
    public static final int DEFAULT_MAX_DB_SIZE_KBYTE = 1048576;
    public static final java.lang.String DEFAULT_NAME = "objectbox";
    private java.io.File baseDirectory;

    @javax.annotation.Nullable
    java.lang.Object context;
    int debugFlags;
    boolean debugRelations;
    java.io.File directory;
    final java.util.List<io.objectbox.EntityInfo<?>> entityInfoList;
    io.objectbox.TxCallback<?> failedReadTxAttemptCallback;
    int fileMode;
    private java.lang.String inMemory;
    private io.objectbox.Factory<java.io.InputStream> initialDbFileFactory;
    long maxDataSizeInKByte;
    int maxReaders;
    long maxSizeInKByte;
    final byte[] model;
    io.objectbox.ideasonly.ModelUpdate modelUpdate;
    private java.lang.String name;
    boolean noReaderThreadLocals;
    int queryAttempts;
    boolean readOnly;

    @javax.annotation.Nullable
    java.lang.Object relinker;
    boolean skipReadSchema;
    boolean usePreviousCommit;
    short validateOnOpenModeKv;
    short validateOnOpenModePages;
    long validateOnOpenPageLimit;

    public static io.objectbox.BoxStoreBuilder createDebugWithoutModel() {
        io.objectbox.BoxStoreBuilder boxStoreBuilder = new io.objectbox.BoxStoreBuilder();
        boxStoreBuilder.skipReadSchema = true;
        return boxStoreBuilder;
    }

    private BoxStoreBuilder() {
        this.maxSizeInKByte = com.up366.medialibrary.config.PictureConstants.MB;
        this.entityInfoList = new java.util.ArrayList();
        this.model = null;
    }

    public BoxStoreBuilder(byte[] bArr) {
        this.maxSizeInKByte = com.up366.medialibrary.config.PictureConstants.MB;
        this.entityInfoList = new java.util.ArrayList();
        if (bArr == null) {
            throw new java.lang.IllegalArgumentException("Model may not be null");
        }
        this.model = java.util.Arrays.copyOf(bArr, bArr.length);
    }

    public io.objectbox.BoxStoreBuilder name(java.lang.String str) {
        checkIsNull(this.directory, "Already has directory, cannot assign name");
        checkIsNull(this.inMemory, "Already set to in-memory database, cannot assign name");
        if (str.contains("/") || str.contains("\\")) {
            throw new java.lang.IllegalArgumentException("Name may not contain (back) slashes. Use baseDirectory() or directory() to configure alternative directories");
        }
        this.name = str;
        return this;
    }

    public io.objectbox.BoxStoreBuilder directory(java.io.File file) {
        checkIsNull(this.name, "Already has name, cannot assign directory");
        checkIsNull(this.inMemory, "Already set to in-memory database, cannot assign directory");
        checkIsNull(this.baseDirectory, "Already has base directory, cannot assign directory");
        this.directory = file;
        return this;
    }

    public io.objectbox.BoxStoreBuilder baseDirectory(java.io.File file) {
        checkIsNull(this.directory, "Already has directory, cannot assign base directory");
        checkIsNull(this.inMemory, "Already set to in-memory database, cannot assign base directory");
        this.baseDirectory = file;
        return this;
    }

    public io.objectbox.BoxStoreBuilder inMemory(java.lang.String str) {
        checkIsNull(this.name, "Already has name, cannot switch to in-memory database");
        checkIsNull(this.directory, "Already has directory, cannot switch to in-memory database");
        checkIsNull(this.baseDirectory, "Already has base directory, cannot switch to in-memory database");
        this.inMemory = str;
        return this;
    }

    private static void checkIsNull(@javax.annotation.Nullable java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public io.objectbox.BoxStoreBuilder androidContext(java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.NullPointerException("Context may not be null");
        }
        this.context = getApplicationContext(obj);
        return this;
    }

    private java.lang.Object getApplicationContext(java.lang.Object obj) {
        try {
            return obj.getClass().getMethod("getApplicationContext", null).invoke(obj, null);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("context must be a valid Android Context", e);
        }
    }

    public io.objectbox.BoxStoreBuilder androidReLinker(java.lang.Object obj) {
        if (this.context == null) {
            throw new java.lang.IllegalArgumentException("Set a Context using androidContext(context) first");
        }
        if (obj == null) {
            throw new java.lang.NullPointerException("ReLinkerInstance may not be null");
        }
        this.relinker = obj;
        return this;
    }

    static java.io.File getAndroidDbDir(java.lang.Object obj, @javax.annotation.Nullable java.lang.String str) {
        return new java.io.File(getAndroidBaseDir(obj), dbName(str));
    }

    private static java.lang.String dbName(@javax.annotation.Nullable java.lang.String str) {
        return str != null ? str : DEFAULT_NAME;
    }

    static java.io.File getAndroidBaseDir(java.lang.Object obj) {
        return new java.io.File(getAndroidFilesDir(obj), DEFAULT_NAME);
    }

    @javax.annotation.Nonnull
    private static java.io.File getAndroidFilesDir(java.lang.Object obj) {
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod("getFilesDir", null);
            java.io.File file = (java.io.File) method.invoke(obj, null);
            if (file == null) {
                java.lang.System.err.println("getFilesDir() returned null - retrying once...");
                file = (java.io.File) method.invoke(obj, null);
            }
            if (file == null) {
                throw new java.lang.IllegalStateException("Android files dir is null");
            }
            if (file.exists()) {
                return file;
            }
            throw new java.lang.IllegalStateException("Android files dir does not exist");
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("Could not init with given Android context (must be sub class of android.content.Context)", e);
        }
    }

    public io.objectbox.BoxStoreBuilder fileMode(int i) {
        this.fileMode = i;
        return this;
    }

    public io.objectbox.BoxStoreBuilder maxReaders(int i) {
        this.maxReaders = i;
        return this;
    }

    public io.objectbox.BoxStoreBuilder noReaderThreadLocals() {
        this.noReaderThreadLocals = true;
        return this;
    }

    public void entity(io.objectbox.EntityInfo<?> entityInfo) {
        this.entityInfoList.add(entityInfo);
    }

    io.objectbox.BoxStoreBuilder modelUpdate(io.objectbox.ideasonly.ModelUpdate modelUpdate) {
        throw new java.lang.UnsupportedOperationException("Not yet implemented");
    }

    public io.objectbox.BoxStoreBuilder maxSizeInKByte(long j) {
        if (j <= this.maxDataSizeInKByte) {
            throw new java.lang.IllegalArgumentException("maxSizeInKByte must be larger than maxDataSizeInKByte.");
        }
        this.maxSizeInKByte = j;
        return this;
    }

    public io.objectbox.BoxStoreBuilder maxDataSizeInKByte(long j) {
        if (j >= this.maxSizeInKByte) {
            throw new java.lang.IllegalArgumentException("maxDataSizeInKByte must be smaller than maxSizeInKByte.");
        }
        this.maxDataSizeInKByte = j;
        return this;
    }

    public io.objectbox.BoxStoreBuilder readOnly() {
        this.readOnly = true;
        return this;
    }

    public io.objectbox.BoxStoreBuilder usePreviousCommit() {
        this.usePreviousCommit = true;
        return this;
    }

    public io.objectbox.BoxStoreBuilder validateOnOpen(short s) {
        if (s < 1 || s > 5) {
            throw new java.lang.IllegalArgumentException("Must be one of ValidateOnOpenModePages");
        }
        this.validateOnOpenModePages = s;
        return this;
    }

    public io.objectbox.BoxStoreBuilder validateOnOpenPageLimit(long j) {
        short s = this.validateOnOpenModePages;
        if (s != 2 && s != 3) {
            throw new java.lang.IllegalStateException("Must call validateOnOpen(mode) with mode Regular or WithLeaves first");
        }
        if (j < 1) {
            throw new java.lang.IllegalArgumentException("limit must be positive");
        }
        this.validateOnOpenPageLimit = j;
        return this;
    }

    public io.objectbox.BoxStoreBuilder validateOnOpenKv() {
        this.validateOnOpenModeKv = (short) 1;
        return this;
    }

    public io.objectbox.BoxStoreBuilder validateOnOpenKv(short s) {
        if (s < 1 || s > 1) {
            throw new java.lang.IllegalArgumentException("Must be one of ValidateOnOpenModeKv");
        }
        this.validateOnOpenModeKv = s;
        return this;
    }

    @java.lang.Deprecated
    public io.objectbox.BoxStoreBuilder debugTransactions() {
        this.debugFlags |= 3;
        return this;
    }

    public io.objectbox.BoxStoreBuilder debugFlags(int i) {
        this.debugFlags = i;
        return this;
    }

    public io.objectbox.BoxStoreBuilder debugRelations() {
        this.debugRelations = true;
        return this;
    }

    public io.objectbox.BoxStoreBuilder queryAttempts(int i) {
        if (i < 1) {
            throw new java.lang.IllegalArgumentException("Query attempts must >= 1");
        }
        this.queryAttempts = i;
        return this;
    }

    public io.objectbox.BoxStoreBuilder failedReadTxAttemptCallback(io.objectbox.TxCallback<?> txCallback) {
        this.failedReadTxAttemptCallback = txCallback;
        return this;
    }

    static /* synthetic */ java.io.InputStream lambda$initialDbFile$0(java.io.File file) throws java.lang.Exception {
        return new java.io.FileInputStream(file);
    }

    public io.objectbox.BoxStoreBuilder initialDbFile(final java.io.File file) {
        return initialDbFile(new io.objectbox.Factory() { // from class: io.objectbox.BoxStoreBuilder$$ExternalSyntheticLambda0
            @Override // io.objectbox.Factory
            public final java.lang.Object provide() {
                return io.objectbox.BoxStoreBuilder.lambda$initialDbFile$0(file);
            }
        });
    }

    public io.objectbox.BoxStoreBuilder initialDbFile(io.objectbox.Factory<java.io.InputStream> factory) {
        this.initialDbFileFactory = factory;
        return this;
    }

    byte[] buildFlatStoreOptions(java.lang.String str) {
        io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder = new io.objectbox.flatbuffers.FlatBufferBuilder();
        flatBufferBuilder.forceDefaults(true);
        int iCreateString = flatBufferBuilder.createString(str);
        io.objectbox.config.FlatStoreOptions.startFlatStoreOptions(flatBufferBuilder);
        io.objectbox.config.FlatStoreOptions.addDirectoryPath(flatBufferBuilder, iCreateString);
        io.objectbox.config.FlatStoreOptions.addMaxDbSizeInKbyte(flatBufferBuilder, this.maxSizeInKByte);
        io.objectbox.config.FlatStoreOptions.addFileMode(flatBufferBuilder, this.fileMode);
        io.objectbox.config.FlatStoreOptions.addMaxReaders(flatBufferBuilder, this.maxReaders);
        short s = this.validateOnOpenModePages;
        if (s != 0) {
            io.objectbox.config.FlatStoreOptions.addValidateOnOpenPages(flatBufferBuilder, s);
            long j = this.validateOnOpenPageLimit;
            if (j != 0) {
                io.objectbox.config.FlatStoreOptions.addValidateOnOpenPageLimit(flatBufferBuilder, j);
            }
        }
        short s2 = this.validateOnOpenModeKv;
        if (s2 != 0) {
            io.objectbox.config.FlatStoreOptions.addValidateOnOpenKv(flatBufferBuilder, s2);
        }
        if (this.skipReadSchema) {
            io.objectbox.config.FlatStoreOptions.addSkipReadSchema(flatBufferBuilder, true);
        }
        if (this.usePreviousCommit) {
            io.objectbox.config.FlatStoreOptions.addUsePreviousCommit(flatBufferBuilder, true);
        }
        if (this.readOnly) {
            io.objectbox.config.FlatStoreOptions.addReadOnly(flatBufferBuilder, true);
        }
        if (this.noReaderThreadLocals) {
            io.objectbox.config.FlatStoreOptions.addNoReaderThreadLocals(flatBufferBuilder, true);
        }
        int i = this.debugFlags;
        if (i != 0) {
            io.objectbox.config.FlatStoreOptions.addDebugFlags(flatBufferBuilder, i);
        }
        long j2 = this.maxDataSizeInKByte;
        if (j2 > 0) {
            io.objectbox.config.FlatStoreOptions.addMaxDataSizeInKbyte(flatBufferBuilder, j2);
        }
        flatBufferBuilder.finish(io.objectbox.config.FlatStoreOptions.endFlatStoreOptions(flatBufferBuilder));
        return flatBufferBuilder.sizedByteArray();
    }

    public io.objectbox.BoxStore build() throws java.lang.Throwable {
        java.lang.Object obj;
        if (this.inMemory != null) {
            this.directory = new java.io.File(io.objectbox.BoxStore.IN_MEMORY_PREFIX + this.inMemory);
        }
        if (this.directory == null && this.baseDirectory == null && (obj = this.context) != null) {
            java.io.File androidBaseDir = getAndroidBaseDir(obj);
            if (!androidBaseDir.exists()) {
                androidBaseDir.mkdir();
                if (!androidBaseDir.exists()) {
                    throw new java.lang.RuntimeException("Could not init Android base dir at " + androidBaseDir.getAbsolutePath());
                }
            }
            if (!androidBaseDir.isDirectory()) {
                throw new java.lang.RuntimeException("Android base dir is not a dir: " + androidBaseDir.getAbsolutePath());
            }
            this.baseDirectory = androidBaseDir;
        }
        if (this.directory == null) {
            this.directory = getDbDir(this.baseDirectory, this.name);
        }
        if (this.inMemory == null) {
            checkProvisionInitialDbFile();
        }
        return new io.objectbox.BoxStore(this);
    }

    private void checkProvisionInitialDbFile() throws java.lang.Throwable {
        java.io.InputStream inputStreamProvide;
        java.lang.Throwable th;
        java.io.BufferedOutputStream bufferedOutputStream;
        java.lang.Exception e;
        if (this.initialDbFileFactory == null) {
            return;
        }
        java.io.File file = new java.io.File(io.objectbox.BoxStore.getCanonicalPath(this.directory), "data.mdb");
        if (file.exists()) {
            return;
        }
        try {
            inputStreamProvide = this.initialDbFileFactory.provide();
            try {
                if (inputStreamProvide == null) {
                    throw new io.objectbox.exception.DbException("Factory did not provide a resource");
                }
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStreamProvide);
                try {
                    java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
                    try {
                        org.greenrobot.essentials.io.IoUtils.copyAllBytes(bufferedInputStream, bufferedOutputStream2);
                        org.greenrobot.essentials.io.IoUtils.safeClose(bufferedOutputStream2);
                        org.greenrobot.essentials.io.IoUtils.safeClose(bufferedInputStream);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        bufferedOutputStream = bufferedOutputStream2;
                        inputStreamProvide = bufferedInputStream;
                        try {
                            throw new io.objectbox.exception.DbException("Could not provision initial data file", e);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            org.greenrobot.essentials.io.IoUtils.safeClose(bufferedOutputStream);
                            org.greenrobot.essentials.io.IoUtils.safeClose(inputStreamProvide);
                            throw th;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        bufferedOutputStream = bufferedOutputStream2;
                        inputStreamProvide = bufferedInputStream;
                        org.greenrobot.essentials.io.IoUtils.safeClose(bufferedOutputStream);
                        org.greenrobot.essentials.io.IoUtils.safeClose(inputStreamProvide);
                        throw th;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    inputStreamProvide = bufferedInputStream;
                    java.lang.Exception exc = e;
                    bufferedOutputStream = null;
                    e = exc;
                    throw new io.objectbox.exception.DbException("Could not provision initial data file", e);
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    inputStreamProvide = bufferedInputStream;
                    java.lang.Throwable th5 = th;
                    bufferedOutputStream = null;
                    th = th5;
                    org.greenrobot.essentials.io.IoUtils.safeClose(bufferedOutputStream);
                    org.greenrobot.essentials.io.IoUtils.safeClose(inputStreamProvide);
                    throw th;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        } catch (java.lang.Exception e5) {
            inputStreamProvide = null;
            e = e5;
            bufferedOutputStream = null;
        } catch (java.lang.Throwable th7) {
            inputStreamProvide = null;
            th = th7;
            bufferedOutputStream = null;
        }
    }

    static java.io.File getDbDir(@javax.annotation.Nullable java.io.File file, @javax.annotation.Nullable java.lang.String str) {
        java.lang.String strDbName = dbName(str);
        if (file != null) {
            return new java.io.File(file, strDbName);
        }
        return new java.io.File(strDbName);
    }

    public io.objectbox.BoxStore buildDefault() throws java.lang.Throwable {
        io.objectbox.BoxStore boxStoreBuild = build();
        io.objectbox.BoxStore.setDefault(boxStoreBuild);
        return boxStoreBuild;
    }
}
