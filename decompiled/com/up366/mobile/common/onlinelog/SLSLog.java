package com.up366.mobile.common.onlinelog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SLSLog {
    private static final java.lang.String appVersion = "6.0.1.8b928e8";
    private static final com.up366.mobile.common.onlinelog.SLSLog instance = new com.up366.mobile.common.onlinelog.SLSLog();
    private static final java.lang.String appType = com.up366.mobile.common.utils.PlatformUtils.getAppType();
    private static final java.lang.String device = android.os.Build.MODEL + "(" + android.os.Build.VERSION.SDK_INT + ":" + android.os.Build.VERSION.RELEASE + ")";
    private com.aliyun.sls.android.producer.LogProducerConfig config = null;
    private com.aliyun.sls.android.producer.LogProducerClient client = null;
    private final java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", java.util.Locale.getDefault());
    private final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("SLSLogger");

    private SLSLog() {
    }

    public static com.up366.mobile.common.onlinelog.SLSLog getInstance() {
        return instance;
    }

    public void init(android.content.Context context) {
        initProducer(context);
        com.up366.common.log.Logger.addLogWriter(new com.up366.common.log.ILogWriter() { // from class: com.up366.mobile.common.onlinelog.SLSLog$$ExternalSyntheticLambda0
            @Override // com.up366.common.log.ILogWriter
            public final void logMessage(long j, long j2, int i, java.lang.String str, com.up366.common.log.LogLevel logLevel, java.lang.String str2) {
                this.f$0.lambda$init$1(j, j2, i, str, logLevel, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(final long j, final long j2, final int i, final java.lang.String str, final com.up366.common.log.LogLevel logLevel, final java.lang.String str2) {
        this.executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.onlinelog.SLSLog$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$init$0(logLevel, j, j2, i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(com.up366.common.log.LogLevel logLevel, long j, long j2, int i, java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        if (com.up366.mobile.common.logic.Auth.cur().config().getSLSLevel().ordinal() > logLevel.ordinal()) {
            return;
        }
        writeLogImpl(formatMessage(j, j2, i, str, logLevel, str2, new java.lang.Object[0]));
    }

    public void initProducer(android.content.Context context) {
        try {
            com.aliyun.sls.android.producer.LogProducerConfig logProducerConfig = new com.aliyun.sls.android.producer.LogProducerConfig(context);
            this.config = logProducerConfig;
            logProducerConfig.setTopic(appType);
            this.config.setDropDelayLog(0);
            this.config.setDropUnauthorizedLog(0);
            startPersistent();
            final java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(0L);
            this.client = new com.aliyun.sls.android.producer.LogProducerClient(this.config, new com.aliyun.sls.android.producer.LogProducerCallback() { // from class: com.up366.mobile.common.onlinelog.SLSLog$$ExternalSyntheticLambda1
                public final void onCall(int i, java.lang.String str, java.lang.String str2, int i2, int i3) {
                    this.f$0.lambda$initProducer$2(atomicLong, i, str, str2, i2, i3);
                }
            });
            com.up366.common.log.Logger.info("TAG - SLSLog - init success!");
        } catch (com.aliyun.sls.android.producer.LogProducerException e) {
            com.up366.common.log.Logger.error("TAG - SLSLog - initProducer - error ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initProducer$2(java.util.concurrent.atomic.AtomicLong atomicLong, int i, java.lang.String str, java.lang.String str2, int i2, int i3) {
        com.aliyun.sls.android.producer.LogProducerResult logProducerResultFromInt = com.aliyun.sls.android.producer.LogProducerResult.fromInt(i);
        if (!logProducerResultFromInt.isLogProducerResultOk() && android.os.SystemClock.uptimeMillis() - atomicLong.get() >= 60000) {
            atomicLong.set(android.os.SystemClock.uptimeMillis());
            if (com.aliyun.sls.android.producer.LogProducerResult.LOG_PRODUCER_PARAMETERS_INVALID != logProducerResultFromInt && com.aliyun.sls.android.producer.LogProducerResult.LOG_PRODUCER_SEND_NETWORK_ERROR != logProducerResultFromInt) {
                com.up366.common.log.Logger.error("TAG - SLSLog - onCall - resultCode = [" + i + "], reqId = [" + str + "], errorMessage = [" + str2 + "], logBytes = [" + i2 + "], compressedBytes = [" + i3 + "]");
            }
            if (com.aliyun.sls.android.producer.LogProducerResult.LOG_PRODUCER_SEND_UNAUTHORIZED == logProducerResultFromInt || com.aliyun.sls.android.producer.LogProducerResult.LOG_PRODUCER_PARAMETERS_INVALID == logProducerResultFromInt) {
                requestAccessKey();
            } else {
                com.up366.mobile.common.onlinelog.OpLog.report("sls_error", logProducerResultFromInt.name(), com.up366.mobile.common.onlinelog.OpLogData.Event.OTHER, new com.alibaba.fastjson.JSONObject());
            }
        }
    }

    private void startPersistent() {
        try {
            this.config.setPersistent(1);
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir(), "sls/log_data");
            com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
            this.config.setPersistentFilePath(strJoin);
            this.config.setPersistentMaxFileCount(10);
            this.config.setPersistentMaxFileSize(2097152);
            this.config.setPersistentMaxLogCount(65536);
        } catch (java.lang.Exception e) {
            this.config.setPersistent(0);
            com.up366.common.log.Logger.error(e);
        }
    }

    private java.lang.String formatMessage(long j, long j2, int i, java.lang.String str, com.up366.common.log.LogLevel logLevel, java.lang.String str2, java.lang.Object... objArr) {
        try {
            java.lang.String string = logLevel.toString();
            if (objArr != null && objArr.length > 0) {
                str2 = java.lang.String.format(str2, objArr);
            }
            return java.lang.String.format(java.util.Locale.CHINA, "%s [0x%08x] [%-5s] - %s (%s:%d)", this.dateFormat.format(new java.util.Date(j2)), java.lang.Long.valueOf(j), string, str2, str, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception unused) {
            return "log format error at com.up366.mobile.common.onlinelog.SLSLog (SLSLog.java:136)";
        }
    }

    private void requestAccessKey() {
        try {
            com.up366.common.http.NetHolder<com.up366.mobile.common.logic.AppConfigMgr.SLSToken> netHolderFetchSLSToken = com.up366.mobile.common.logic.Auth.cur().config().fetchSLSToken();
            if (netHolderFetchSLSToken.resp.isError()) {
                com.up366.common.log.Logger.error("TAG - SLSLog - requestAccessKey - fetchSLSToken " + netHolderFetchSLSToken.resp);
                return;
            }
            updateAccessKey(netHolderFetchSLSToken.info);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - SLSLog - requestAccessKey - ", e);
        }
    }

    private void updateAccessKey(com.up366.mobile.common.logic.AppConfigMgr.SLSToken sLSToken) {
        this.config.setEndpoint("https://cn-beijing.log.aliyuncs.com");
        this.config.setProject(sLSToken.projectName);
        this.config.setLogstore(sLSToken.logStoreName);
        this.config.resetSecurityToken(sLSToken.accessKeyId, sLSToken.accessKeySecret, sLSToken.securityToken);
    }

    private void writeLogImpl(java.lang.String str) {
        if (isEnableSLS() && this.client != null) {
            java.lang.String deviceId = com.up366.mobile.common.helper.DeviceIdHelper.getDeviceId();
            if (android.text.TextUtils.isEmpty(deviceId)) {
                return;
            }
            com.aliyun.sls.android.producer.Log log = new com.aliyun.sls.android.producer.Log();
            log.putContent("appType", appType);
            log.putContent("appVersion", appVersion);
            log.putContent("organId", com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId());
            log.putContent("platform", com.up366.mobile.common.utils.PlatformUtils.getTargetHost());
            log.putContent("device", device);
            log.putContent("uid", com.up366.mobile.common.logic.Auth.UID());
            log.putContent("username", com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
            log.putContent("clientId", deviceId);
            log.putContent("message", str);
            log.putContent("os", android.os.Build.VERSION.RELEASE);
            this.client.addLog(log);
        }
    }

    private boolean isEnableSLS() {
        return com.up366.mobile.common.logic.Auth.cur().config().isEnableSLS();
    }
}
