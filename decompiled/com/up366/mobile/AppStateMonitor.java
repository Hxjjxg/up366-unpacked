package com.up366.mobile;

/* JADX INFO: compiled from: AppStateMonitor.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u00011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u0018J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\bJ\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0014J\u0006\u0010&\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\bJ\u000e\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-J\u001a\u0010.\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00142\b\b\u0002\u0010/\u001a\u00020\u000bH\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\b\u00100\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/up366/mobile/AppStateMonitor;", "", "<init>", "()V", "startTime", "", "bootTime", "lastPausedActivity", "", "batchId", "isForeground", "", "isFirstBoot", "handler", "Landroid/os/Handler;", "exitDataRunnable", "com/up366/mobile/AppStateMonitor$exitDataRunnable$1", "Lcom/up366/mobile/AppStateMonitor$exitDataRunnable$1;", "activityStack", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/app/Activity;", "batchIdState", "Lcom/up366/mobile/AppStateMonitor$BatchIdState;", "updateBatchIdState", "", "reason", "onBoot", "startExitDataTimer", "stopExitDataTimer", "onForeground", "onBackGround", "uploadLastExitAppExtData", "saveExitAppData", "pageName", "getCurrentPageName", "Lcom/alibaba/fastjson/JSONObject;", "getPageName", "activity", "getBatchId", "backgroundAllowedEvents", "", "canRecordEvent", "message", "init", "application", "Landroid/app/Application;", "logNavigationEvent", "isClearTop", "getTopAliveActivity", "BatchIdState", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppStateMonitor {
    private static long batchId;
    private static long bootTime;
    private static boolean isForeground;
    private static java.lang.String lastPausedActivity;
    private static long startTime;
    public static final com.up366.mobile.AppStateMonitor INSTANCE = new com.up366.mobile.AppStateMonitor();
    private static boolean isFirstBoot = true;
    private static final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
    private static final com.up366.mobile.AppStateMonitor$exitDataRunnable$1 exitDataRunnable = new java.lang.Runnable() { // from class: com.up366.mobile.AppStateMonitor$exitDataRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            if (com.up366.mobile.AppStateMonitor.isForeground) {
                com.up366.mobile.AppStateMonitor.INSTANCE.saveExitAppData(com.up366.mobile.AppStateMonitor.lastPausedActivity);
                com.up366.mobile.AppStateMonitor.handler.postDelayed(this, com.igexin.push.config.c.s);
            }
        }
    };
    private static final java.util.concurrent.CopyOnWriteArrayList<android.app.Activity> activityStack = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static volatile com.up366.mobile.AppStateMonitor.BatchIdState batchIdState = com.up366.mobile.AppStateMonitor.BatchIdState.TimeManipulated.INSTANCE;
    private static final java.util.Set<java.lang.String> backgroundAllowedEvents = kotlin.collections.SetsKt.setOf(".def");

    private AppStateMonitor() {
    }

    /* JADX INFO: compiled from: AppStateMonitor.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/AppStateMonitor$BatchIdState;", "", "<init>", "()V", "longValue", "", "getLongValue", "()J", "canRecord", "", "getCanRecord", "()Z", "TimeManipulated", "Provisional", "Valid", "Lcom/up366/mobile/AppStateMonitor$BatchIdState$Provisional;", "Lcom/up366/mobile/AppStateMonitor$BatchIdState$TimeManipulated;", "Lcom/up366/mobile/AppStateMonitor$BatchIdState$Valid;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static abstract class BatchIdState {
        public /* synthetic */ BatchIdState(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AppStateMonitor.kt */
        @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/up366/mobile/AppStateMonitor$BatchIdState$TimeManipulated;", "Lcom/up366/mobile/AppStateMonitor$BatchIdState;", "<init>", "()V", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class TimeManipulated extends com.up366.mobile.AppStateMonitor.BatchIdState {
            public static final com.up366.mobile.AppStateMonitor.BatchIdState.TimeManipulated INSTANCE = new com.up366.mobile.AppStateMonitor.BatchIdState.TimeManipulated();

            private TimeManipulated() {
                super(null);
            }
        }

        private BatchIdState() {
        }

        /* JADX INFO: compiled from: AppStateMonitor.kt */
        @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/AppStateMonitor$BatchIdState$Provisional;", "Lcom/up366/mobile/AppStateMonitor$BatchIdState;", "bootElapsed", "", "<init>", "(J)V", "getBootElapsed", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Provisional extends com.up366.mobile.AppStateMonitor.BatchIdState {
            private final long bootElapsed;

            public static /* synthetic */ com.up366.mobile.AppStateMonitor.BatchIdState.Provisional copy$default(com.up366.mobile.AppStateMonitor.BatchIdState.Provisional provisional, long j, int i, java.lang.Object obj) {
                if ((i & 1) != 0) {
                    j = provisional.bootElapsed;
                }
                return provisional.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getBootElapsed() {
                return this.bootElapsed;
            }

            public final com.up366.mobile.AppStateMonitor.BatchIdState.Provisional copy(long bootElapsed) {
                return new com.up366.mobile.AppStateMonitor.BatchIdState.Provisional(bootElapsed);
            }

            public boolean equals(java.lang.Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof com.up366.mobile.AppStateMonitor.BatchIdState.Provisional) && this.bootElapsed == ((com.up366.mobile.AppStateMonitor.BatchIdState.Provisional) other).bootElapsed;
            }

            public int hashCode() {
                return com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(this.bootElapsed);
            }

            public java.lang.String toString() {
                return "Provisional(bootElapsed=" + this.bootElapsed + ")";
            }

            public Provisional(long j) {
                super(null);
                this.bootElapsed = j;
            }

            public final long getBootElapsed() {
                return this.bootElapsed;
            }
        }

        /* JADX INFO: compiled from: AppStateMonitor.kt */
        @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/AppStateMonitor$BatchIdState$Valid;", "Lcom/up366/mobile/AppStateMonitor$BatchIdState;", "value", "", "<init>", "(J)V", "getValue", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Valid extends com.up366.mobile.AppStateMonitor.BatchIdState {
            private final long value;

            public static /* synthetic */ com.up366.mobile.AppStateMonitor.BatchIdState.Valid copy$default(com.up366.mobile.AppStateMonitor.BatchIdState.Valid valid, long j, int i, java.lang.Object obj) {
                if ((i & 1) != 0) {
                    j = valid.value;
                }
                return valid.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getValue() {
                return this.value;
            }

            public final com.up366.mobile.AppStateMonitor.BatchIdState.Valid copy(long value) {
                return new com.up366.mobile.AppStateMonitor.BatchIdState.Valid(value);
            }

            public boolean equals(java.lang.Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof com.up366.mobile.AppStateMonitor.BatchIdState.Valid) && this.value == ((com.up366.mobile.AppStateMonitor.BatchIdState.Valid) other).value;
            }

            public int hashCode() {
                return com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(this.value);
            }

            public java.lang.String toString() {
                return "Valid(value=" + this.value + ")";
            }

            public Valid(long j) {
                super(null);
                this.value = j;
            }

            public final long getValue() {
                return this.value;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final long getLongValue() throws kotlin.NoWhenBranchMatchedException {
            if (this instanceof com.up366.mobile.AppStateMonitor.BatchIdState.TimeManipulated) {
                return 0L;
            }
            if (this instanceof com.up366.mobile.AppStateMonitor.BatchIdState.Provisional) {
                return ((com.up366.mobile.AppStateMonitor.BatchIdState.Provisional) this).getBootElapsed();
            }
            if (this instanceof com.up366.mobile.AppStateMonitor.BatchIdState.Valid) {
                return ((com.up366.mobile.AppStateMonitor.BatchIdState.Valid) this).getValue();
            }
            throw new kotlin.NoWhenBranchMatchedException();
        }

        public final boolean getCanRecord() {
            return !(this instanceof com.up366.mobile.AppStateMonitor.BatchIdState.TimeManipulated);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void updateBatchIdState(java.lang.String reason) throws kotlin.NoWhenBranchMatchedException {
        com.up366.mobile.AppStateMonitor.BatchIdState.Valid valid;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reason, "reason");
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (com.up366.mobile.common.utils.TimeSyncMgr.isTimeManipulated()) {
            com.up366.common.log.Logger.info("BatchIdState: Time manipulated (" + reason + "), set to provisional=" + jElapsedRealtime);
            valid = new com.up366.mobile.AppStateMonitor.BatchIdState.Provisional(jElapsedRealtime);
        } else if (batchIdState instanceof com.up366.mobile.AppStateMonitor.BatchIdState.Provisional) {
            com.up366.mobile.AppStateMonitor.BatchIdState batchIdState2 = batchIdState;
            kotlin.jvm.internal.Intrinsics.checkNotNull(batchIdState2, "null cannot be cast to non-null type com.up366.mobile.AppStateMonitor.BatchIdState.Provisional");
            long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - (jElapsedRealtime - ((com.up366.mobile.AppStateMonitor.BatchIdState.Provisional) batchIdState2).getBootElapsed());
            com.up366.common.log.Logger.info("BatchIdState: Time recovered (" + reason + "), corrected batchId=" + currentNtpTimeInMillisecond);
            valid = new com.up366.mobile.AppStateMonitor.BatchIdState.Valid(currentNtpTimeInMillisecond);
        } else if (batchIdState instanceof com.up366.mobile.AppStateMonitor.BatchIdState.TimeManipulated) {
            long currentNtpTimeInMillisecond2 = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
            com.up366.common.log.Logger.info("BatchIdState: Time first reliable (" + reason + "), batchId=" + currentNtpTimeInMillisecond2);
            valid = new com.up366.mobile.AppStateMonitor.BatchIdState.Valid(currentNtpTimeInMillisecond2);
        } else {
            com.up366.common.log.Logger.info("BatchIdState: Keep existing (" + reason + "): " + batchIdState.getLongValue());
            valid = batchIdState;
        }
        batchIdState = valid;
        batchId = batchIdState.getLongValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void onBoot() throws kotlin.NoWhenBranchMatchedException {
        bootTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        updateBatchIdState("boot");
        uploadLastExitAppExtData();
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.APP, com.up366.mobile.common.onlinelog.OpLogData.Control.HOME_PAGE, com.up366.mobile.common.onlinelog.OpLogData.Event.BOOT_APP, new com.alibaba.fastjson.JSONObject());
    }

    private final void startExitDataTimer() {
        android.os.Handler handler2 = handler;
        com.up366.mobile.AppStateMonitor$exitDataRunnable$1 appStateMonitor$exitDataRunnable$1 = exitDataRunnable;
        handler2.removeCallbacks(appStateMonitor$exitDataRunnable$1);
        handler2.postDelayed(appStateMonitor$exitDataRunnable$1, com.igexin.push.config.c.s);
    }

    private final void stopExitDataTimer() {
        handler.removeCallbacks(exitDataRunnable);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void onForeground() throws kotlin.NoWhenBranchMatchedException {
        isForeground = true;
        updateBatchIdState(isFirstBoot ? "first_foreground" : "resume_foreground");
        startTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        startExitDataTimer();
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.APP, com.up366.mobile.common.onlinelog.OpLogData.Control.FOREGROUND, com.up366.mobile.common.onlinelog.OpLogData.Event.BECOME_ACTIVE, getCurrentPageName());
    }

    public final void onBackGround() {
        com.up366.mobile.common.onlinelog.OpLog.report(".def.app.resignactive", "app使用时长", (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.AppStateMonitor$$ExternalSyntheticLambda0
            public final void accept(java.lang.Object obj) {
                com.up366.mobile.AppStateMonitor.onBackGround$lambda$0((com.alibaba.fastjson.JSONObject) obj);
            }
        });
        com.up366.common.task.TaskUtils.postMainTaskDelay(15L, new com.up366.common.task.Task() { // from class: com.up366.mobile.AppStateMonitor$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.AppStateMonitor.onBackGround$lambda$1();
            }
        });
        isFirstBoot = false;
        stopExitDataTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackGround$lambda$0(com.alibaba.fastjson.JSONObject jSONObject) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject);
        java.util.Map map = (java.util.Map) jSONObject;
        map.put("start", java.lang.Long.valueOf(startTime));
        map.put("duration", java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - startTime));
        map.put("boottime", java.lang.Long.valueOf(bootTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackGround$lambda$1() {
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.APP, "background", com.up366.mobile.common.onlinelog.OpLogData.Event.RESIGN_ACTIVE, INSTANCE.getCurrentPageName());
        isForeground = false;
    }

    private final void uploadLastExitAppExtData() {
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString("exitAppExtData", null);
        com.up366.common.log.Logger.info("AppStateMonitor uploadLastExitAppExtData get : " + string);
        if (string == null) {
            return;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(string);
            java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
            java.util.Map jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("evTime", object.getString("evTime"));
            jSONObject2.put("currentpage", object.getString("currentpage"));
            jSONObject.put("extData", jSONObject2);
            jSONObject.put("batchId", java.lang.Long.valueOf(object.getLongValue("batchId")));
            com.up366.mobile.common.onlinelog.ActionLogRecord.record(com.up366.mobile.common.onlinelog.OpLogData.Event.EXIT_APP, com.up366.mobile.common.onlinelog.OpLogData.Page.APP, com.up366.mobile.common.onlinelog.OpLogData.Control.TERMINATION, jSONObject);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("Error parsing exitAppExtData: " + string, e);
        }
    }

    public final void saveExitAppData(java.lang.String pageName) {
        if (com.up366.mobile.common.utils.TimeSyncMgr.isTimeManipulated()) {
            com.up366.common.log.Logger.info("AppStateMonitor saveExitAppData skipped for time manipulated");
            return;
        }
        if (pageName == null && (pageName = lastPausedActivity) == null) {
            pageName = "splash";
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("currentpage", pageName);
        jSONObject.put("evTime", com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd HH:mm:ss.SSS"));
        jSONObject.put("batchId", java.lang.Long.valueOf(batchId));
        com.up366.mobile.common.utils.PreferenceUtils.putStringSync("exitAppExtData", jSONObject.toJSONString());
    }

    private final com.alibaba.fastjson.JSONObject getCurrentPageName() {
        java.lang.String str = lastPausedActivity;
        if (str == null) {
            str = "splash";
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("currentpage", str);
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java.lang.String getPageName(android.app.Activity activity) {
        if (activity == 0 || (activity instanceof com.up366.mobile.SplashActivity)) {
            return "splash";
        }
        if (activity instanceof com.up366.mobile.common.base.BaseActivity) {
            java.lang.String currentPageName = ((com.up366.mobile.common.base.BaseActivity) activity).getCurrentPageName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(currentPageName, "getCurrentPageName(...)");
            return currentPageName;
        }
        java.lang.String simpleName = activity.getClass().getSimpleName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final long getBatchId() {
        return batchIdState.getLongValue();
    }

    public final boolean canRecordEvent(java.lang.String message) {
        if (!batchIdState.getCanRecord()) {
            com.up366.common.log.Logger.info("canRecordEvent false: batchId not valid");
            return false;
        }
        if (!isForeground) {
            if (message == null) {
                return false;
            }
            java.util.Set<java.lang.String> set = backgroundAllowedEvents;
            if ((set instanceof java.util.Collection) && set.isEmpty()) {
                return false;
            }
            java.util.Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (kotlin.text.StringsKt.contains$default(message, (java.lang.String) it.next(), false, 2, (java.lang.Object) null)) {
                }
            }
            return false;
        }
        return true;
    }

    public final void init(android.app.Application application) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(new android.app.Application.ActivityLifecycleCallbacks() { // from class: com.up366.mobile.AppStateMonitor.init.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle outState) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(android.app.Activity activity) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(android.app.Activity activity) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(android.app.Activity activity, android.os.Bundle savedInstanceState) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
                com.up366.mobile.AppStateMonitor.activityStack.add(activity);
                com.up366.common.log.Logger.info("AppStateMonitor ActivityCreated: " + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(android.app.Activity activity) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
                com.up366.mobile.AppStateMonitor.logNavigationEvent$default(com.up366.mobile.AppStateMonitor.INSTANCE, activity, false, 2, null);
                com.up366.common.log.Logger.info("AppStateMonitor ActivityResumed: " + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(android.app.Activity activity) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
                com.up366.mobile.AppStateMonitor appStateMonitor = com.up366.mobile.AppStateMonitor.INSTANCE;
                com.up366.mobile.AppStateMonitor.lastPausedActivity = com.up366.mobile.AppStateMonitor.INSTANCE.getPageName(activity);
                com.up366.common.log.Logger.info("AppStateMonitor ActivityPaused: " + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(android.app.Activity activity) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
                com.up366.mobile.AppStateMonitor.activityStack.remove(activity);
            }
        });
    }

    static /* synthetic */ void logNavigationEvent$default(com.up366.mobile.AppStateMonitor appStateMonitor, android.app.Activity activity, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        appStateMonitor.logNavigationEvent(activity, z);
    }

    private final void logNavigationEvent(android.app.Activity activity, boolean isClearTop) {
        if (isFirstBoot) {
            com.up366.common.log.Logger.info("AppStateMonitor logNavigationEvent skipped for first boot");
            return;
        }
        java.lang.String pageName = getPageName(activity);
        java.lang.String str = lastPausedActivity;
        if (str == null) {
            str = "";
        }
        java.lang.String str2 = com.up366.mobile.common.onlinelog.OpLogData.Control.NAVIGATION_POP;
        if (!isClearTop) {
            java.util.concurrent.CopyOnWriteArrayList<android.app.Activity> copyOnWriteArrayList = activityStack;
            if (copyOnWriteArrayList.size() < 1 || copyOnWriteArrayList.indexOf(activity) >= copyOnWriteArrayList.size() - 1) {
                str2 = "push";
            }
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("to", pageName);
        if (str.length() > 0) {
            jSONObject.put("from", str);
        }
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.APP, str2, com.up366.mobile.common.onlinelog.OpLogData.Event.NAVIGATE, jSONObject);
        com.up366.common.log.Logger.info("NavigationEvent: " + pageName + " from " + str + " (type=" + str2 + ")");
    }

    public final boolean isForeground() {
        return isForeground;
    }

    public final android.app.Activity getTopAliveActivity() {
        int size = activityStack.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return null;
            }
            android.app.Activity activity = activityStack.get(size);
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                return activity;
            }
        }
    }
}
