package com.up366.mobile.course.photoanswer.logic.helper;

/* JADX INFO: compiled from: ScanEngineHelper2.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001GB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000bJ&\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0016\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000bJ\u0016\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u000bJ0\u0010,\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0005J0\u00100\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0005J\u000e\u00101\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001aJ\u000e\u00102\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001aJ\u000e\u00103\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001aJ\u000e\u00104\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001aJ.\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b08H\u0002J\u0018\u00109\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020*H\u0002J?\u0010<\u001a\u0002H=\"\u0004\b\u0000\u0010=2\u0006\u0010 \u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H=082\f\u00107\u001a\b\u0012\u0004\u0012\u0002H=08H\u0002¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010A\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u000bH\u0002J\b\u0010D\u001a\u00020\u001cH\u0002J1\u0010E\u001a\u0002H=\"\u0004\b\u0000\u0010=2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010>\u001a\u0002H=2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H=08H\u0002¢\u0006\u0002\u0010FR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2;", "", "<init>", "()V", "INIT_SESSION_CLOSED", "", "NO_SESSION", "", "MODEL_PREPARE_FAILED", "MAX_QUEUE_SIZE", "NOT_INITIALIZED_SCAN_RESULT", "", "sessionIdGenerator", "Ljava/util/concurrent/atomic/AtomicLong;", "activeSessionId", "modelPrewarmScheduled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "engineThread", "Ljava/lang/Thread;", "engineExecutor", "Ljava/util/concurrent/ExecutorService;", "initializedSessionId", "engineInitialized", "", "workPath", "createSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "prewarmModel", "", "context", "Landroid/content/Context;", "initScan", "session", "pathKey", "findConner", "Lcom/up366/smartscan2/ConnerData;", "data", "", "width", "height", "filePath", "recognizePaperCode", "Lcom/up366/mobile/course/photoanswer/logic/model/PaperCodeModel;", "file", "scanOneImage", "jsonLayout", "paperCode", "defaultPageNo", "scanOneImageAutoFix", "closeAsync", "isConnerOk", "isOldPaper", "getLastImageType", "scanImage", "operation", "block", "Lkotlin/Function0;", "updateConnerData", "connerData", "notInitializedPaperCode", "executeForReadySession", "T", "fallback", "(Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isSessionActive", "isSessionReady", "exitEngine", "reason", "invalidateModelCheckFile", "executeBlocking", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Session", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScanEngineHelper2 {
    public static final int INIT_SESSION_CLOSED = -10001;
    private static final int MAX_QUEUE_SIZE = 5;
    private static final int MODEL_PREPARE_FAILED = -1001;
    private static final java.lang.String NOT_INITIALIZED_SCAN_RESULT = "{\"errorCode\":1}";
    private static final long NO_SESSION = 0;
    private static final java.util.concurrent.ExecutorService engineExecutor;
    private static boolean engineInitialized;
    private static volatile java.lang.Thread engineThread;
    private static long initializedSessionId;
    private static java.lang.String workPath;
    public static final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2 INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2();
    private static final java.util.concurrent.atomic.AtomicLong sessionIdGenerator = new java.util.concurrent.atomic.AtomicLong(0);
    private static final java.util.concurrent.atomic.AtomicLong activeSessionId = new java.util.concurrent.atomic.AtomicLong(0);
    private static final java.util.concurrent.atomic.AtomicBoolean modelPrewarmScheduled = new java.util.concurrent.atomic.AtomicBoolean(false);

    private ScanEngineHelper2() {
    }

    static {
        java.util.concurrent.ExecutorService executorServiceNewSingleThreadExecutor = java.util.concurrent.Executors.newSingleThreadExecutor(new java.util.concurrent.ThreadFactory() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.engineExecutor$lambda$1(runnable);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        engineExecutor = executorServiceNewSingleThreadExecutor;
        workPath = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Thread engineExecutor$lambda$1(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable, "SmartScanEngine");
        engineThread = thread;
        return thread;
    }

    /* JADX INFO: compiled from: ScanEngineHelper2.kt */
    @kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001c\u001a\u00020\u001dR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "", com.igexin.push.core.b.C, "", "<init>", "(J)V", "getId$app_normalRelease", "()J", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getClosed$app_normalRelease", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "connerDataQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/up366/smartscan2/ConnerData;", "getConnerDataQueue$app_normalRelease", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "curConnerData", "getCurConnerData$app_normalRelease", "()Lcom/up366/smartscan2/ConnerData;", "setCurConnerData$app_normalRelease", "(Lcom/up366/smartscan2/ConnerData;)V", "lastImageType", "", "getLastImageType$app_normalRelease", "()I", "setLastImageType$app_normalRelease", "(I)V", "isClosed", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Session {
        private final java.util.concurrent.atomic.AtomicBoolean closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        private final java.util.concurrent.ConcurrentLinkedQueue<com.up366.smartscan2.ConnerData> connerDataQueue = new java.util.concurrent.ConcurrentLinkedQueue<>();
        private volatile com.up366.smartscan2.ConnerData curConnerData = new com.up366.smartscan2.ConnerData();
        private final long id;
        private volatile int lastImageType;

        public Session(long j) {
            this.id = j;
        }

        /* JADX INFO: renamed from: getId$app_normalRelease, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: getClosed$app_normalRelease, reason: from getter */
        public final java.util.concurrent.atomic.AtomicBoolean getClosed() {
            return this.closed;
        }

        public final java.util.concurrent.ConcurrentLinkedQueue<com.up366.smartscan2.ConnerData> getConnerDataQueue$app_normalRelease() {
            return this.connerDataQueue;
        }

        /* JADX INFO: renamed from: getCurConnerData$app_normalRelease, reason: from getter */
        public final com.up366.smartscan2.ConnerData getCurConnerData() {
            return this.curConnerData;
        }

        public final void setCurConnerData$app_normalRelease(com.up366.smartscan2.ConnerData connerData) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(connerData, "<set-?>");
            this.curConnerData = connerData;
        }

        /* JADX INFO: renamed from: getLastImageType$app_normalRelease, reason: from getter */
        public final int getLastImageType() {
            return this.lastImageType;
        }

        public final void setLastImageType$app_normalRelease(int i) {
            this.lastImageType = i;
        }

        public final boolean isClosed() {
            return this.closed.get();
        }
    }

    public final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session createSession() {
        com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session = new com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session(sessionIdGenerator.incrementAndGet());
        long andSet = activeSessionId.getAndSet(session.getId());
        com.up366.common.log.Logger.info("ScanEngine createSession id:" + session.getId() + " previous:" + andSet);
        return session;
    }

    @kotlin.jvm.JvmStatic
    public static final void prewarmModel(final android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        if (modelPrewarmScheduled.compareAndSet(false, true)) {
            android.content.Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            engineExecutor.execute(new java.lang.Runnable() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.prewarmModel$lambda$2(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prewarmModel$lambda$2(android.content.Context context) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        try {
            int localVersionNo = com.up366.smartscan2.SmartScan2ConfigHelper.getLocalVersionNo(context);
            com.up366.smartscan2.SmartScan2ConfigHelper.initConfigFile(context);
            com.up366.common.log.Logger.info("ScanEngine model prewarm finished before:" + localVersionNo + " after:" + com.up366.smartscan2.SmartScan2ConfigHelper.getLocalVersionNo(context) + " cost:" + (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime));
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("ScanEngine model prewarm failed cost:" + (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime), th);
        }
    }

    public final int initScan(final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, final java.lang.String pathKey) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pathKey, "pathKey");
        return ((java.lang.Number) executeBlocking("initScan", -10001, new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda7
            public final java.lang.Object invoke() {
                return java.lang.Integer.valueOf(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.initScan$lambda$3(session, pathKey));
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int initScan$lambda$3(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, java.lang.String str) {
        int iInit;
        com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2 scanEngineHelper2 = INSTANCE;
        if (!scanEngineHelper2.isSessionActive(session)) {
            return -10001;
        }
        if (engineInitialized && initializedSessionId != session.getId()) {
            scanEngineHelper2.exitEngine("replaceSession");
        }
        com.up366.common.log.Logger.info("ScanEngine initScan session:" + session.getId() + " pathKey:" + str);
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        try {
            iInit = com.up366.smartscan2.SmartScan2.init(com.up366.common.global.GB.get().getApplicationContext());
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("ScanEngine initScan native error session:" + session.getId(), th);
            iInit = -1;
        }
        if (iInit != 0) {
            com.up366.common.log.Logger.error("ScanEngine initScan failed session:" + session.getId() + " result:" + iInit);
            if (iInit != -1001) {
                INSTANCE.invalidateModelCheckFile();
            }
            return iInit;
        }
        com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2 scanEngineHelper22 = INSTANCE;
        if (!scanEngineHelper22.isSessionActive(session)) {
            engineInitialized = true;
            initializedSessionId = session.getId();
            scanEngineHelper22.exitEngine("sessionClosedDuringInit");
            return -10001;
        }
        engineInitialized = true;
        initializedSessionId = session.getId();
        workPath = com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper.INSTANCE.getTakePhotoPathRoot() + str + java.io.File.separator;
        com.up366.common.log.Logger.info("ScanEngine initScan success session:" + session.getId() + " cost:" + (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime));
        return 0;
    }

    public final com.up366.smartscan2.ConnerData findConner(final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, final byte[] data, final int width, final int height) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        return (com.up366.smartscan2.ConnerData) executeForReadySession(session, "findConner(bytes)", new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda9
            public final java.lang.Object invoke() {
                return session.getCurConnerData();
            }
        }, new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda10
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.findConner$lambda$5(data, width, height, session);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.smartscan2.ConnerData findConner$lambda$5(byte[] bArr, int i, int i2, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        com.up366.smartscan2.ConnerData connerData = new com.up366.smartscan2.ConnerData();
        com.up366.smartscan2.SmartScan2.findConner(bArr, i, i2, connerData);
        if (connerData.getErrorCode() != 0) {
            session.setLastImageType$app_normalRelease(connerData.getErrorCode());
        }
        INSTANCE.updateConnerData(session, connerData);
        return connerData;
    }

    public final com.up366.smartscan2.ConnerData findConner(final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, final java.lang.String filePath) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filePath, "filePath");
        return (com.up366.smartscan2.ConnerData) executeForReadySession(session, "findConner(file)", new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda0
            public final java.lang.Object invoke() {
                return session.getCurConnerData();
            }
        }, new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda6
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.findConner$lambda$7(filePath, session);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.smartscan2.ConnerData findConner$lambda$7(java.lang.String str, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        com.up366.smartscan2.ConnerData connerData = new com.up366.smartscan2.ConnerData();
        com.up366.smartscan2.SmartScan2.findConner(str, connerData);
        INSTANCE.updateConnerData(session, connerData);
        return connerData;
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$recognizePaperCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScanEngineHelper2.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function0<com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel> {
        AnonymousClass1(java.lang.Object obj) {
            super(0, obj, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.class, "notInitializedPaperCode", "notInitializedPaperCode()Lcom/up366/mobile/course/photoanswer/logic/model/PaperCodeModel;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel m958invoke() {
            return ((com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2) this.receiver).notInitializedPaperCode();
        }
    }

    public final com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel recognizePaperCode(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, final java.lang.String file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "file");
        return (com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel) executeForReadySession(session, "recognizePaperCode", new com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.AnonymousClass1(this), new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda1
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.recognizePaperCode$lambda$9(file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel recognizePaperCode$lambda$9(java.lang.String str) {
        com.up366.smartscan2.PaperCodeResult paperCodeResultRecognizePaperCode = com.up366.smartscan2.SmartScan2.recognizePaperCode(str);
        com.up366.common.log.Logger.info("recognizePaperCode result=" + paperCodeResultRecognizePaperCode.paperCode + " " + paperCodeResultRecognizePaperCode.errorCode + " " + paperCodeResultRecognizePaperCode.filePath);
        com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel = new com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel();
        paperCodeModel.setPaperCode(paperCodeResultRecognizePaperCode.paperCode);
        paperCodeModel.setErrorCode(paperCodeResultRecognizePaperCode.errorCode);
        paperCodeModel.setImageIndex(paperCodeResultRecognizePaperCode.paperNumber);
        paperCodeModel.setFilePath(str);
        return paperCodeModel;
    }

    public static /* synthetic */ java.lang.String scanOneImage$default(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2 scanEngineHelper2, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.lang.Object obj) {
        if ((i2 & 16) != 0) {
            i = 0;
        }
        return scanEngineHelper2.scanOneImage(session, str, str2, str3, i);
    }

    public final java.lang.String scanOneImage(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, final java.lang.String file, final java.lang.String jsonLayout, final java.lang.String paperCode, final int defaultPageNo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "file");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jsonLayout, "jsonLayout");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperCode, "paperCode");
        return scanImage(session, "scanOneImage", file, new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda2
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.scanOneImage$lambda$10(file, jsonLayout, paperCode, defaultPageNo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String scanOneImage$lambda$10(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        java.lang.String strScanOneImage = com.up366.smartscan2.SmartScan2.scanOneImage(str, workPath, str2, str3, true, "00001", i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strScanOneImage, "scanOneImage(...)");
        return strScanOneImage;
    }

    public static /* synthetic */ java.lang.String scanOneImageAutoFix$default(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2 scanEngineHelper2, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.lang.Object obj) {
        if ((i2 & 16) != 0) {
            i = 0;
        }
        return scanEngineHelper2.scanOneImageAutoFix(session, str, str2, str3, i);
    }

    public final java.lang.String scanOneImageAutoFix(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, final java.lang.String file, final java.lang.String jsonLayout, final java.lang.String paperCode, final int defaultPageNo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "file");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jsonLayout, "jsonLayout");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperCode, "paperCode");
        return scanImage(session, "scanOneImageAutoFix", file, new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda12
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.scanOneImageAutoFix$lambda$11(file, jsonLayout, paperCode, defaultPageNo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String scanOneImageAutoFix$lambda$11(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        java.lang.String strScanOneImageNoStrictCheck = com.up366.smartscan2.SmartScan2.scanOneImageNoStrictCheck(str, workPath, str2, str3, true, "00001", i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strScanOneImageNoStrictCheck, "scanOneImageNoStrictCheck(...)");
        return strScanOneImageNoStrictCheck;
    }

    public final void closeAsync(final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        if (session.getClosed().compareAndSet(false, true)) {
            activeSessionId.compareAndSet(session.getId(), 0L);
            com.up366.common.log.Logger.info("ScanEngine close requested session:" + session.getId());
            engineExecutor.execute(new java.lang.Runnable() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.closeAsync$lambda$12(session);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeAsync$lambda$12(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        if (engineInitialized && initializedSessionId == session.getId()) {
            INSTANCE.exitEngine("closeSession");
            return;
        }
        com.up366.common.log.Logger.info("ScanEngine close skipped session:" + session.getId() + " initializedSession:" + initializedSessionId + " initialized:" + engineInitialized);
    }

    public final boolean isConnerOk(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        int errorCode = session.getCurConnerData().getErrorCode();
        return errorCode == 1 || errorCode == 3;
    }

    public final boolean isOldPaper(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        java.util.Iterator<com.up366.smartscan2.ConnerData> it = session.getConnerDataQueue$app_normalRelease().iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            if (it.next().getErrorCode() != 2) {
                return false;
            }
        }
        return true;
    }

    public final int getLastImageType(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "session");
        return session.getLastImageType();
    }

    private final java.lang.String scanImage(final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, final java.lang.String operation, final java.lang.String file, final kotlin.jvm.functions.Function0<java.lang.String> block) {
        return (java.lang.String) executeForReadySession(session, operation, new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda3
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.NOT_INITIALIZED_SCAN_RESULT;
            }
        }, new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda4
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.scanImage$lambda$14(block, operation, file, session);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String scanImage$lambda$14(kotlin.jvm.functions.Function0 function0, java.lang.String str, java.lang.String str2, com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        java.lang.String str3 = (java.lang.String) function0.invoke();
        long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime;
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.appendScanDuration((int) jElapsedRealtime2);
        com.up366.common.log.Logger.info(str + " file:" + str2 + " session:" + session.getId() + " cost:" + jElapsedRealtime2);
        return str3;
    }

    private final void updateConnerData(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, com.up366.smartscan2.ConnerData connerData) {
        if (session.getConnerDataQueue$app_normalRelease().size() >= 5) {
            session.getConnerDataQueue$app_normalRelease().poll();
        }
        session.getConnerDataQueue$app_normalRelease().offer(connerData);
        session.setCurConnerData$app_normalRelease(connerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel notInitializedPaperCode() {
        com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel = new com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel();
        paperCodeModel.setErrorCode(1);
        return paperCodeModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T executeForReadySession(final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, final java.lang.String operation, final kotlin.jvm.functions.Function0<? extends T> fallback, final kotlin.jvm.functions.Function0<? extends T> block) {
        if (!isSessionActive(session)) {
            return (T) fallback.invoke();
        }
        return (T) executeBlocking(operation, fallback.invoke(), new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda5
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.executeForReadySession$lambda$16(session, operation, fallback, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object executeForReadySession$lambda$16(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session, java.lang.String str, kotlin.jvm.functions.Function0 function0, kotlin.jvm.functions.Function0 function02) {
        if (!INSTANCE.isSessionReady(session)) {
            com.up366.common.log.Logger.warn("ScanEngine rejected " + str + " session:" + session.getId() + " active:" + activeSessionId.get() + " initialized:" + initializedSessionId + " closed:" + session.getClosed().get());
            return function0.invoke();
        }
        return function02.invoke();
    }

    private final boolean isSessionActive(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        return !session.getClosed().get() && activeSessionId.get() == session.getId();
    }

    private final boolean isSessionReady(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        return isSessionActive(session) && engineInitialized && initializedSessionId == session.getId();
    }

    private final void exitEngine(java.lang.String reason) {
        long jElapsedRealtime;
        java.lang.StringBuilder sb;
        long j = initializedSessionId;
        long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
        try {
            com.up366.smartscan2.SmartScan2.scanExit();
            engineInitialized = false;
            initializedSessionId = 0L;
            workPath = "";
            jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime2;
            sb = new java.lang.StringBuilder("ScanEngine scanExit session:");
        } catch (java.lang.Throwable th) {
            try {
                com.up366.common.log.Logger.error("ScanEngine scanExit error session:" + j + " reason:" + reason, th);
                engineInitialized = false;
                initializedSessionId = 0L;
                workPath = "";
                jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - jElapsedRealtime2;
                sb = new java.lang.StringBuilder("ScanEngine scanExit session:");
            } catch (java.lang.Throwable th2) {
                engineInitialized = false;
                initializedSessionId = 0L;
                workPath = "";
                com.up366.common.log.Logger.info("ScanEngine scanExit session:" + j + " reason:" + reason + " cost:" + (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime2));
                throw th2;
            }
        }
        sb.append(j);
        sb.append(" reason:");
        sb.append(reason);
        sb.append(" cost:");
        sb.append(jElapsedRealtime);
        com.up366.common.log.Logger.info(sb.toString());
    }

    private final void invalidateModelCheckFile() {
        try {
            com.up366.common.FileUtilsUp.deleteDirOrFile(new java.io.File(com.up366.smartscan2.SmartScan2ConfigHelper.getConfigFileDirPath(com.up366.common.global.GB.get().getApplicationContext()), "checkFile").getAbsolutePath());
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("ScanEngine invalidate model check file failed", th);
        }
    }

    private final <T> T executeBlocking(final java.lang.String operation, T fallback, final kotlin.jvm.functions.Function0<? extends T> block) {
        if (java.lang.Thread.currentThread() == engineThread) {
            return (T) block.invoke();
        }
        if (android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread()) {
            com.up366.common.log.Logger.error("ScanEngine rejected blocking operation on main thread: " + operation);
            return fallback;
        }
        final long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        try {
            return engineExecutor.submit(new java.util.concurrent.Callable() { // from class: com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2$$ExternalSyntheticLambda13
                @Override // java.util.concurrent.Callable
                public final java.lang.Object call() {
                    return com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.executeBlocking$lambda$17(jElapsedRealtime, operation, block);
                }
            }).get();
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            com.up366.common.log.Logger.warn("ScanEngine operation interrupted: " + operation);
            return fallback;
        } catch (java.util.concurrent.ExecutionException e) {
            java.lang.String str = "ScanEngine operation failed: " + operation;
            java.util.concurrent.ExecutionException cause = e.getCause();
            if (cause == null) {
                cause = e;
            }
            com.up366.common.log.Logger.error(str, cause);
            return fallback;
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("ScanEngine operation failed: " + operation, th);
            return fallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object executeBlocking$lambda$17(long j, java.lang.String str, kotlin.jvm.functions.Function0 function0) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - j;
        if (jElapsedRealtime >= 500) {
            com.up366.common.log.Logger.warn("ScanEngine operation:" + str + " queueWait:" + jElapsedRealtime);
        }
        return function0.invoke();
    }
}
