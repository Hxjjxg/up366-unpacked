package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ApplicationHelper {
    private static final int SCAN_MODEL_PREWARM_DELAY_MILLIS = 8000;
    private static final long SCAN_MODEL_PREWARM_MIN_FREE_BYTES = 536870912;
    private android.content.Context context;
    private final com.up366.common.global.IGlobalUp gbCallBack;
    private boolean hasMainStart;
    private java.util.concurrent.atomic.AtomicInteger studyActivityCount;

    private ApplicationHelper() {
        this.hasMainStart = false;
        this.studyActivityCount = new java.util.concurrent.atomic.AtomicInteger(0);
        this.gbCallBack = new com.up366.mobile.common.helper.ApplicationHelper.AnonymousClass1();
    }

    private static class Holder {
        public static com.up366.mobile.common.helper.ApplicationHelper helper = new com.up366.mobile.common.helper.ApplicationHelper();

        private Holder() {
        }
    }

    public static com.up366.mobile.common.helper.ApplicationHelper getInst() {
        return com.up366.mobile.common.helper.ApplicationHelper.Holder.helper;
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.helper.ApplicationHelper$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.common.global.IGlobalUp {
        private android.app.Activity currentActivity;

        @Override // com.up366.common.global.IGlobalUp
        public void addCommonHttpParams(java.util.Map<java.lang.String, java.lang.Object> map) {
        }

        @Override // com.up366.common.global.IGlobalUp
        public java.lang.String addSign(android.view.View view, java.lang.String str, int i, int i2) {
            return str;
        }

        @Override // com.up366.common.global.IGlobalUp
        public java.lang.String wrapUrl(java.lang.String str) {
            return str;
        }

        AnonymousClass1() {
        }

        private boolean isAlive(android.app.Activity activity) {
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            return !activity.isDestroyed();
        }

        @Override // com.up366.common.global.IGlobalUp
        public android.content.Context getApplicationContext() {
            return com.up366.mobile.common.helper.ApplicationHelper.this.context;
        }

        @Override // com.up366.common.global.IGlobalUp
        public java.lang.String getHttpCacheDir() {
            return com.up366.mobile.common.utils.AppFileUtils.getHttpCacheDir();
        }

        @Override // com.up366.common.global.IGlobalUp
        public java.lang.String getImgCacheDir() {
            return com.up366.mobile.common.utils.AppFileUtils.getImgCacheDir();
        }

        @Override // com.up366.common.global.IGlobalUp
        public java.lang.String getUniqueDeviceId() {
            return com.up366.mobile.common.helper.DeviceIdHelper.getDeviceId();
        }

        @Override // com.up366.common.global.IGlobalUp
        public java.lang.String getApplicationId() {
            return com.up366.mobile.BuildConfig.APPLICATION_ID;
        }

        @Override // com.up366.common.global.IGlobalUp
        public android.app.Activity getCurrentActivity() {
            if (isAlive(this.currentActivity)) {
                return this.currentActivity;
            }
            android.app.Activity topAliveActivity = com.up366.mobile.AppStateMonitor.INSTANCE.getTopAliveActivity();
            if (isAlive(topAliveActivity)) {
                this.currentActivity = topAliveActivity;
                return topAliveActivity;
            }
            this.currentActivity = null;
            return null;
        }

        @Override // com.up366.common.global.IGlobalUp
        public void sendLog(java.lang.String str) {
            com.up366.common.log.Logger.info("TAG - Up366Application sendLog " + str);
        }

        @Override // com.up366.common.global.IGlobalUp
        public void sendLog(java.lang.String str, final java.lang.String str2) {
            if (str == com.up366.asecengine.englishengine.log.RecordTraceLogger.RECORD_PAGE) {
                com.up366.mobile.common.onlinelog.OpLog.report(str, "record_every_one_log", (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.common.helper.ApplicationHelper$1$$ExternalSyntheticLambda0
                    public final void accept(java.lang.Object obj) {
                        ((com.alibaba.fastjson.JSONObject) obj).putAll(com.alibaba.fastjson.JSONObject.parseObject(str2));
                    }
                });
                return;
            }
            com.up366.common.log.Logger.info("TAG - Up366Application - sendLog - type = [" + str + "], body = [" + str2 + "]");
        }

        @Override // com.up366.common.global.IGlobalUp
        public com.alibaba.fastjson.JSONObject getConfig() {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("HTTP_DNS_SWITCH", true);
            jSONObject.put("is_debug", false);
            return jSONObject;
        }

        @Override // com.up366.common.global.IGlobalUp
        public void addCommonHttpHeaders(com.up366.common.http.RequestParams<?> requestParams, java.util.Map<java.lang.String, java.lang.Object> map) {
            map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
            java.lang.String xotVersionName = com.up366.mobile.book.exercise.ExerciseResourceHelper.getXotVersionName();
            if (xotVersionName != null) {
                map.put("XOT", xotVersionName);
            }
            map.put("u3r", java.util.UUID.randomUUID().toString());
        }

        @Override // com.up366.common.global.IGlobalUp
        public long getNtpDiffTime() {
            return com.up366.mobile.common.utils.TimeSyncMgr.getNtpDeltaTime();
        }

        @Override // com.up366.common.global.IGlobalUp
        public long getReliableTime() {
            return com.up366.mobile.common.utils.TimeSyncMgr.getReliableTime();
        }

        @Override // com.up366.common.global.IGlobalUp
        public java.lang.String getServerUrl(java.lang.String str) {
            if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
                return str;
            }
            if (com.up366.mobile.common.utils.PlatformUtils.isGray()) {
                if (str.contains("share.up366.cn")) {
                    str = str.replace("share.up366.cn", "share-gray.up366.cn");
                } else if (str.contains("student.up366.cn")) {
                    str = str.replace("student.up366.cn", "student-gray.up366.cn");
                } else if (str.contains("teacher.up366.cn")) {
                    str = str.replace("teacher.up366.cn", "teacher-gray.up366.cn");
                } else if (str.contains("qlib.up366.cn")) {
                    str = str.replace("qlib.up366.cn", "qlib-gray.up366.cn");
                }
            }
            java.lang.String strReplace = str.replace("up366.cn", com.up366.mobile.common.utils.PlatformUtils.getTargetHost());
            return com.up366.mobile.common.http.HttpMgrUtils.GET_NTP_TIME.equals(strReplace) ? strReplace : strReplace.replace("http:", "https:");
        }

        @Override // com.up366.common.global.IGlobalUp
        public void setCurrentActivity(android.app.Activity activity) {
            if (!isAlive(activity)) {
                activity = null;
            }
            this.currentActivity = activity;
        }
    }

    public void initGbCallBack(android.app.Application application) {
        this.context = application;
        com.up366.common.global.GB.setCallBack(this.gbCallBack);
    }

    public void onCreate(final android.app.Application application) {
        this.context = application;
        java.lang.String appProcessName = com.up366.mobile.common.utils.ProcessUtils.getAppProcessName();
        if (!com.up366.mobile.BuildConfig.APPLICATION_ID.equals(appProcessName)) {
            com.up366.common.log.Logger.info("TAG - ApplicationHelper - onCreate - processName not match, current: " + appProcessName + ", expected: com.up366.mobile");
            return;
        }
        com.up366.mobile.common.utils.AppFileUtils.initPaths(application);
        com.up366.common.global.GB.setCallBack(this.gbCallBack);
        com.up366.common.BitmapUtilsUp.initDrawable(com.up366.mobile.R.drawable.default_book_picture, com.up366.mobile.R.drawable.default_book_picture);
        initLogger();
        java.lang.String packageName = application.getPackageName();
        com.tencent.bugly.crashreport.CrashReport.UserStrategy userStrategy = new com.tencent.bugly.crashreport.CrashReport.UserStrategy(application);
        userStrategy.setEnableANRCrashMonitor(true);
        userStrategy.setEnableNativeCrashMonitor(true);
        userStrategy.setEnableUserInfo(false);
        userStrategy.setDeviceID("不收集deviceId");
        userStrategy.setUploadProcess(appProcessName.equals(packageName));
        com.tencent.bugly.crashreport.CrashReport.initCrashReport(application, com.up366.mobile.BuildConfig.BUGLY_APPID, false, userStrategy);
        com.tencent.bugly.crashreport.CrashReport.setUserId("StartUpNoAuth");
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.ApplicationHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.helper.ApplicationHelper.cleanBuglyConfigFile(application);
            }
        });
        com.up366.mobile.common.utils.TimeSyncMgr.init();
        java.lang.Thread.setDefaultUncaughtExceptionHandler(new com.up366.mobile.common.utils.LogExceptionHandler());
        com.up366.mobile.common.helper.DeviceIdHelper.initDeviceId(application);
        final java.lang.String str = android.os.Build.MODEL + "(" + android.os.Build.VERSION.SDK_INT + ":" + android.os.Build.VERSION.RELEASE + ")";
        com.up366.common.log.Logger.info("--------------- Up366Application - onCreate - APP START 6.0.1.8b928e8 " + str + " " + com.up366.mobile.common.utils.PlatformUtils.getTargetHostInner() + " ---------------------");
        com.up366.common.http.RequestParams.setUserAgent("Android-Up366-Moblie " + android.os.Build.BRAND + " " + android.os.Build.MODEL + " " + android.os.Build.VERSION.RELEASE + " ");
        com.up366.common.download.DownloadManager.getInstance().setPrivateCloudHandle(new com.up366.mobile.cloud.PrivateCloudDownloadHandle());
        com.up366.common.NetworkUtilsUp.checkNetworkConnect();
        com.up366.common.utils.EncryptUtil.enc(com.up366.mobile.common.base.Constants.sign, 1235);
        new com.up366.mobile.common.receiver.NetBroadcastReceiver().registerNetListener(application);
        com.up366.mobile.common.logic.Auth.init();
        com.up366.mobile.common.onlinelog.SLSLog.getInstance().init(application);
        com.up366.mobile.common.views.BreakReminderUtils.init();
        com.up366.mobile.AppStateMonitor.INSTANCE.init(application);
        com.tencent.bugly.crashreport.CrashReport.setUserId(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        com.up366.mobile.common.compat.FastJsonParserHacker.hack();
        com.igexin.sdk.PushManager.getInstance().initialize(application);
        com.igexin.sdk.PushManager.getInstance().setHeartbeatInterval(application, 300);
        com.igexin.sdk.PushManager.getInstance().setAppListInterval(application, 6L);
        com.igexin.sdk.PushManager.getInstance().setLocationInterval(application, 1800L);
        com.igexin.sdk.PushManager.getInstance().setImeiEnable(application, false);
        com.igexin.sdk.PushManager.getInstance().setImsiEnable(application, false);
        com.igexin.sdk.PushManager.getInstance().setMacEnable(application, false);
        com.igexin.sdk.PushManager.getInstance().setIccIdEnable(application, false);
        com.igexin.sdk.PushManager.getInstance().setSerialNumberEnable(application, false);
        com.igexin.sdk.PushManager.getInstance().setCellInfoEnable(application, false);
        com.igexin.sdk.PushManager.getInstance().setIpEnable(application, false);
        com.igexin.sdk.PushManager.getInstance().setAdvertisingIdEnable(application, false);
        com.igexin.sdk.PushManager.getInstance().setLinkMerge(application, false);
        com.igexin.sdk.PushManager.getInstance().setEmergencyPush(application, false);
        com.igexin.sdk.PushManager.getInstance().setIndividuationPush(application, false);
        com.igexin.sdk.PushManager.getInstance().setScenePush(application, false);
        com.up366.mobile.common.utils.AndroidPCompatUtils.closeAndroidPDialog();
        java.io.File externalFilesDir = application.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = application.getFilesDir();
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(externalFilesDir.getAbsolutePath(), "ases_model/");
        com.up366.common.log.Logger.info("TAG - ApplicationHelper - asesModelDir - " + strJoin);
        com.up366.asecengine.englishengine.AsesModelHelper.create().setModelDir(strJoin);
        com.up366.mobile.book.helper.recorder.RecordResultHelper.reportEngineError();
        com.up366.multimediav2.activity.SmartAnswerCameraActivity.INSTANCE.setClosePad(com.up366.mobile.common.utils.PlatformUtils.isClosePad());
        final java.lang.String str2 = "6.0.1.8b928e8";
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.ApplicationHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$3(application, str2, str);
            }
        });
        com.up366.mobile.common.utils.CookieUtils.handleGrayCookie();
        androidx.lifecycle.ProcessLifecycleOwner.get().getLifecycle().addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: com.up366.mobile.common.helper.ApplicationHelper$$ExternalSyntheticLambda3
            public final void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
                com.up366.mobile.common.helper.ApplicationHelper.lambda$onCreate$4(lifecycleOwner, event);
            }
        });
        org.greenrobot.eventbus.EventBus.builder().addIndex(new com.up366.mobile.MyEventBusIndex()).build();
        com.up366.mobile.common.utils.MainThreadMonitor.monitor();
        com.up366.mobile.book.helper.V9FontHelper.copyFontsToLocalStorage(application);
        scheduleScanModelPrewarm(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(android.app.Application application, java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.common.http.HttpUtilsUp.setErrCodeHandle(new com.up366.mobile.common.http.ErrCodeHandleV2());
        com.up366.mobile.common.utils.Up366AppMonitor.initUmeng(application);
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().init(application, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.helper.ApplicationHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                com.up366.mobile.common.helper.ApplicationHelper.lambda$onCreate$2(i, str3);
            }
        });
        fixOppoAssetManager();
        com.up366.mobile.common.compat.SDCardFilesCompat.compat(application);
        com.up366.mobile.common.onlinelog.OpLog.report("cpu_abi", com.up366.mobile.common.utils.PlatformUtils.getCPUABI());
        com.up366.mobile.common.logic.AppConfigMgr.fetchDynamicConfig();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("IS_PAD", java.lang.Boolean.valueOf(com.up366.qmui.util.QMUIDeviceHelper.isTablet(application)));
        jSONObject.put("storage", com.up366.mobile.common.utils.AppFileUtils.getStorageSizeString(application));
        com.up366.common.log.Logger.info("--------------- Up366Application SLS Init " + str + " " + str2 + " " + com.up366.mobile.common.utils.PlatformUtils.getTargetHostInner() + " ---------------------" + jSONObject.toJSONString());
    }

    static /* synthetic */ void lambda$onCreate$2(int i, java.lang.String str) {
        com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().setFullReport(false);
        com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().setDeviceInfo(false);
        com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().setNetworkInfo(false);
        com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().setSimcardInfo(false);
        com.up366.common.log.Logger.debug("TAG - ApplicationHelper - ShanYanHelper init - code:" + i + " info:" + str);
    }

    static /* synthetic */ void lambda$onCreate$4(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        com.up366.common.log.Logger.info("TAG - Application - -CurrentState: " + lifecycleOwner.getLifecycle().getCurrentState() + "   event name : " + event.name());
        if (event == androidx.lifecycle.Lifecycle.Event.ON_PAUSE || event == androidx.lifecycle.Lifecycle.Event.ON_STOP) {
            com.up366.mobile.common.mask.MaskManager.getMgr().dismissMaskOnBackGround();
            com.up366.mobile.book.helper.recorder.RecordResultHelper.resetRecordLog();
        }
    }

    private void scheduleScanModelPrewarm(final android.app.Application application) {
        com.up366.common.task.TaskUtils.postMainTaskDelay(8000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.ApplicationHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.helper.ApplicationHelper.lambda$scheduleScanModelPrewarm$5(application);
            }
        });
    }

    static /* synthetic */ void lambda$scheduleScanModelPrewarm$5(android.app.Application application) throws java.lang.Exception {
        java.io.File filesDir = application.getFilesDir();
        long usableSpace = filesDir == null ? 0L : filesDir.getUsableSpace();
        if (usableSpace < SCAN_MODEL_PREWARM_MIN_FREE_BYTES) {
            com.up366.common.log.Logger.warn("ScanEngine model prewarm skipped, usableSpace:" + usableSpace);
            return;
        }
        com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.prewarmModel(application);
    }

    public boolean gotoMain(boolean z) {
        if (!z) {
            com.up366.common.log.Logger.info("TAG - ApplicationHelper - gotoMain - isMoLiYingBook false");
            return false;
        }
        com.up366.common.log.Logger.info("TAG - ApplicationHelper - gotoMain - " + this.studyActivityCount.get() + " " + this.hasMainStart);
        return !this.hasMainStart && this.studyActivityCount.get() <= 1;
    }

    public void addStudyActivityCount() {
        this.studyActivityCount.incrementAndGet();
        com.up366.common.log.Logger.info("TAG - ApplicationHelper - addStudyActivityCount - " + this.studyActivityCount.get());
    }

    public void subStudyActivityCount() {
        this.studyActivityCount.decrementAndGet();
        com.up366.common.log.Logger.info("TAG - ApplicationHelper - subStudyActivityCount - " + this.studyActivityCount.get());
    }

    public void setMainStart(boolean z) {
        this.hasMainStart = z;
    }

    public static void initLogger() {
        com.up366.common.log.LogLevel logLevel = com.up366.common.log.LogLevel.DEBUG;
        com.up366.common.log.Logger.init(com.up366.common.log.LogLevel.INFO, "Up366Mobile", com.up366.mobile.common.utils.AppFileUtils.getLogPath());
    }

    private void fixOppoAssetManager() {
        java.lang.String str = android.os.Build.MODEL;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains("OPPO R9") || str.contains("OPPO A5") || str.contains("OPPO A3")) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon");
                java.lang.reflect.Method declaredMethod = cls.getSuperclass().getDeclaredMethod("stop", null);
                declaredMethod.setAccessible(true);
                java.lang.reflect.Field declaredField = cls.getDeclaredField("INSTANCE");
                declaredField.setAccessible(true);
                declaredMethod.invoke(declaredField.get(null), null);
            } catch (java.lang.Throwable th) {
                com.up366.common.log.Logger.error("fixOppoAssetManager error " + th.getMessage(), th);
            }
        }
    }

    public static void cleanBuglyConfigFile(android.content.Context context) {
        try {
            java.io.File file = new java.io.File(context.getFilesDir().getParentFile(), "shared_prefs/BUGLY_COMMON_VALUES.xml");
            if (file.exists()) {
                com.up366.common.log.Logger.info("Bugly 配置文件清理完成。策略：，结果：".concat(file.delete() ? "成功" : "失败"));
            } else {
                com.up366.common.log.Logger.info("Bugly 配置文件不存在，无需清理");
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("Bugly cleanBuglyConfigFile error " + e.getMessage());
        }
    }
}
