package com.up366.asecengine.englishengine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecEngineHelper {
    private static final int FFT_STYLE_BAR = 1;
    private static final int FFT_STYLE_NONE = 0;
    private static final int FFT_STYLE_UNSPECIFIED = -1;
    private static final int FFT_STYLE_WAVE = 2;
    public static final java.lang.String NO_RECORD_FILE_COPY_ERROR = "录音文件复制失败";
    public static final java.lang.String NO_RECORD_FILE_NO_READ = "录音文件无数据";
    public static final java.lang.String NO_RECORD_FILE_TIME_OUT = "获取音频数据超时";
    private static final int RECORD_CHANNELS = 1;
    private static final int RECORD_MP3_BITRATE = 32;
    private static final int RECORD_SAMPLE_RATE = 16000;
    private static com.up366.asecengine.englishengine.AsecEngineHelper helper;
    private final com.up366.asecengine.jni.AsesJni asesJni;
    private com.up366.asecengine.asecmgr.ISpeechStatCallBack callBack;
    private android.app.Application context;
    private com.up366.asecengine.englishengine.AsecSession curSession;
    private com.up366.asecengine.englishengine.EngineV2Wrapper engineV2Wrapper;
    private final com.up366.common.task.TaskExecutor executorEngine;
    private com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener fftUpdateListener;
    private long startRecordTime;
    private com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener waveUpdateListener;
    private java.lang.String stateChangeListenerOwner = "unset";
    private int barNum = 12;
    private byte[] fftOutput = new byte[12];
    private int avgIndex = 0;
    private int[] avgs = new int[5];
    private final com.up366.library.opusencoder.OpusHelper opusHelper = new com.up366.library.opusencoder.OpusHelper();
    private final com.up366.library.opusencoder.OpusParams defaultOpusParams = new com.up366.library.opusencoder.OpusParams();
    private final com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager onlineScoringManager = new com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager();
    private final com.up366.common.task.TaskExecutor executorRecord = com.up366.common.task.TaskUtils.createSerialExecutor("asec_record");

    public interface IFFTUpdateListener {
        void update(byte[] bArr, int i);
    }

    public interface IOnlineTransportLogListener {
        void onLog(java.lang.String str);
    }

    public interface IWaveUpdateListener {
        void update(byte[] bArr);
    }

    private AsecEngineHelper(android.content.Context context) {
        com.up366.common.task.TaskExecutor taskExecutorCreateSerialExecutor = com.up366.common.task.TaskUtils.createSerialExecutor("asec_engine");
        this.executorEngine = taskExecutorCreateSerialExecutor;
        com.up366.asecengine.jni.AsesJni asesJni = new com.up366.asecengine.jni.AsesJni();
        this.asesJni = asesJni;
        this.context = (android.app.Application) context;
        this.engineV2Wrapper = new com.up366.asecengine.englishengine.EngineV2Wrapper(context, asesJni, taskExecutorCreateSerialExecutor);
        com.up366.library.opusencoder.OpusParams opusParams = new com.up366.library.opusencoder.OpusParams();
        opusParams.setEnable(false);
        updateOpusParams(opusParams);
    }

    public static com.up366.asecengine.englishengine.AsecEngineHelper create(android.content.Context context) {
        if (helper == null) {
            helper = new com.up366.asecengine.englishengine.AsecEngineHelper(context);
            com.up366.asecengine.asecmgr.RecordFactory3.init(context);
        }
        return helper;
    }

    public void updateOpusParams(com.up366.library.opusencoder.OpusParams opusParams) {
        synchronized (this.defaultOpusParams) {
            copyOpusParams(opusParams, this.defaultOpusParams);
        }
        this.opusHelper.updateOpusParams(this.defaultOpusParams);
    }

    public void setUseNewRecordFactory(boolean z) {
        com.up366.common.log.Logger.info("setUseNewRecordFactory " + z);
    }

    public void setOnStateChangeListener(com.up366.asecengine.asecmgr.ISpeechStatCallBack iSpeechStatCallBack) {
        this.callBack = iSpeechStatCallBack;
        this.stateChangeListenerOwner = resolveStateChangeListenerOwner();
        com.up366.common.log.Logger.info("TAG - AsecEngineHelper - setOnStateChangeListener - owner=[" + this.stateChangeListenerOwner + "], listener=[" + describeStateChangeListener(iSpeechStatCallBack) + "]");
    }

    private java.lang.String resolveStateChangeListenerOwner() {
        for (java.lang.StackTraceElement stackTraceElement : java.lang.Thread.currentThread().getStackTrace()) {
            java.lang.String className = stackTraceElement.getClassName();
            if (!java.lang.Thread.class.getName().equals(className) && !com.up366.asecengine.englishengine.AsecEngineHelper.class.getName().equals(className) && !className.startsWith("java.lang.reflect.") && !className.startsWith("sun.reflect.")) {
                return className + "#" + stackTraceElement.getMethodName();
            }
        }
        return "unknown";
    }

    private java.lang.String describeStateChangeListener(com.up366.asecengine.asecmgr.ISpeechStatCallBack iSpeechStatCallBack) {
        if (iSpeechStatCallBack == null) {
            return com.igexin.push.core.b.m;
        }
        return iSpeechStatCallBack.getClass().getName() + "@" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(iSpeechStatCallBack));
    }

    public void setWaveUpdateListener(com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener iWaveUpdateListener) {
        this.waveUpdateListener = iWaveUpdateListener;
    }

    public void setOnFFTUpdateListener(com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener iFFTUpdateListener) {
        this.fftUpdateListener = iFFTUpdateListener;
    }

    public void setOnOnlineTransportLogListener(final com.up366.asecengine.englishengine.AsecEngineHelper.IOnlineTransportLogListener iOnlineTransportLogListener) {
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.TransportLogListener transportLogListener;
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager asecOnlineScoringManager = this.onlineScoringManager;
        if (iOnlineTransportLogListener == null) {
            transportLogListener = null;
        } else {
            java.util.Objects.requireNonNull(iOnlineTransportLogListener);
            transportLogListener = new com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.TransportLogListener() { // from class: com.up366.asecengine.englishengine.AsecEngineHelper$$ExternalSyntheticLambda0
                @Override // com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.TransportLogListener
                public final void onLog(java.lang.String str) {
                    iOnlineTransportLogListener.onLog(str);
                }
            };
        }
        asecOnlineScoringManager.setTransportLogListener(transportLogListener);
    }

    public boolean startRecord(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, boolean z, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.asecengine.model.KeyValue("score_factor", "1"));
        arrayList.add(new com.up366.asecengine.model.KeyValue("audio_quality", "1"));
        return startRecord(str, i, str2, str3, z, i2, 12, arrayList);
    }

    public boolean startRecord(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, boolean z, int i2, int i3, java.util.List<com.up366.asecengine.model.KeyValue> list) {
        if (i == 7) {
            throw new java.lang.IllegalArgumentException("段落评分请使用 startParagraphRecord 或 startRecordV2");
        }
        return startLocalRecord(str, i, str2, str3, z, i2, i3, list, null);
    }

    public boolean startParagraphRecord(java.lang.String str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig, java.lang.String str2, boolean z, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.asecengine.model.KeyValue("score_factor", "1"));
        arrayList.add(new com.up366.asecengine.model.KeyValue("audio_quality", "1"));
        return startParagraphRecord(str, asecParagraphScoringConfig, str2, z, i, 12, arrayList);
    }

    public boolean startParagraphRecord(java.lang.String str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig, java.lang.String str2, boolean z, int i, int i2, java.util.List<com.up366.asecengine.model.KeyValue> list) {
        validateParagraphScoringConfig(asecParagraphScoringConfig);
        return startLocalRecord(str, 7, null, str2, z, i, i2, list, asecParagraphScoringConfig);
    }

    private boolean startLocalRecord(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, boolean z, int i2, int i3, java.util.List<com.up366.asecengine.model.KeyValue> list, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig) {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.curSession;
        if (asecSession != null) {
            asecSession.destroy();
            this.curSession = null;
        }
        com.up366.asecengine.englishengine.AsecSession asecSession2 = new com.up366.asecengine.englishengine.AsecSession(str, i, str2, str3, z);
        asecSession2.setJsonResultType(i2);
        asecSession2.setOnMediaStateChangeListener(this.callBack);
        asecSession2.setSessionParams(list);
        asecSession2.setBarNum(i3);
        asecSession2.setFftStyle(-1);
        asecSession2.setParagraphScoringConfig(asecParagraphScoringConfig);
        this.curSession = asecSession2;
        this.startRecordTime = android.os.SystemClock.uptimeMillis();
        startRecordLoop(asecSession2);
        return startLocalEngine(asecSession2);
    }

    public boolean connectWebSocket(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig) {
        return this.onlineScoringManager.connect(asecWebSocketConfig);
    }

    public boolean restartWebSocket(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig) {
        return this.onlineScoringManager.restart(asecWebSocketConfig);
    }

    public boolean restartWebSocket(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig, java.lang.String str) {
        return this.onlineScoringManager.restart(asecWebSocketConfig, str);
    }

    public boolean disconnectWebSocket() {
        return this.onlineScoringManager.disconnect();
    }

    public boolean stopOutgoingHeartbeat() {
        return this.onlineScoringManager.stopOutgoingHeartbeat();
    }

    public boolean startRecordV2(com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config asecRecordV2Config) {
        int barNum;
        if (asecRecordV2Config == null) {
            return false;
        }
        if (asecRecordV2Config.getRecordId() == null || asecRecordV2Config.getRecordId().trim().length() == 0) {
            throw new java.lang.IllegalArgumentException("recordId is empty");
        }
        if (asecRecordV2Config.getWavPath() == null || asecRecordV2Config.getWavPath().trim().length() == 0) {
            throw new java.lang.IllegalArgumentException("wavPath is empty");
        }
        this.onlineScoringManager.clearRetryableFallbackSession(asecRecordV2Config.getRecordId());
        com.up366.asecengine.englishengine.AsecSession asecSession = this.curSession;
        if (asecSession != null) {
            this.onlineScoringManager.abortSession(asecSession);
            this.curSession.destroy();
            this.curSession = null;
        }
        com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig localScoringConfig = asecRecordV2Config.getLocalScoringConfig();
        int dualModeStartPolicy = asecRecordV2Config.getDualModeStartPolicy();
        int scoringType = asecRecordV2Config.getScoringType();
        boolean z = scoringType == 1 || scoringType == 2;
        boolean z2 = scoringType == 0 || scoringType == 2;
        int partType = localScoringConfig != null ? localScoringConfig.getPartType() : 11;
        com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig paragraphScoringConfig = localScoringConfig != null ? localScoringConfig.getParagraphScoringConfig() : null;
        if (z && partType == 7) {
            validateParagraphScoringConfig(paragraphScoringConfig);
        }
        java.lang.String netFiles = localScoringConfig != null ? localScoringConfig.getNetFiles() : null;
        boolean z3 = z && localScoringConfig != null && localScoringConfig.isAsync();
        if (asecRecordV2Config.getSamplingRate() > 0) {
            barNum = asecRecordV2Config.getSamplingRate();
        } else {
            barNum = localScoringConfig != null ? localScoringConfig.getBarNum() : 12;
        }
        int i = barNum;
        com.up366.asecengine.englishengine.AsecSession asecSession2 = new com.up366.asecengine.englishengine.AsecSession(asecRecordV2Config.getRecordId(), partType, netFiles, asecRecordV2Config.getWavPath(), z3);
        com.up366.common.log.Logger.info("TAG - AsecEngineHelper - startRecordV2 - bind state listener owner=[" + this.stateChangeListenerOwner + "], recordId=[" + asecRecordV2Config.getRecordId() + "], listener=[" + describeStateChangeListener(this.callBack) + "]");
        asecSession2.setOnMediaStateChangeListener(this.callBack, this.stateChangeListenerOwner);
        asecSession2.setScoringType(scoringType);
        asecSession2.setLocalScoringEnabled(z);
        asecSession2.setOnlineScoringEnabled(z2);
        asecSession2.setGiveUpScoring(false);
        asecSession2.setDualModeStartPolicy(dualModeStartPolicy);
        asecSession2.setBarNum(i);
        asecSession2.setFftStyle(asecRecordV2Config.getFftStyle());
        asecSession2.setJsonResultType(localScoringConfig != null ? localScoringConfig.getJsonType() : 0);
        asecSession2.setSessionParams(localScoringConfig != null ? localScoringConfig.getSessionParams() : new java.util.ArrayList<>());
        asecSession2.setParagraphScoringConfig(paragraphScoringConfig);
        this.curSession = asecSession2;
        this.startRecordTime = android.os.SystemClock.uptimeMillis();
        if (z2) {
            if (!isOnlineStreamEncoderSupported()) {
                asecSession2.setOnlineMessage("OpusStreamEncoder not available");
                if (!z || dualModeStartPolicy != 1) {
                    asecSession2.destroy(-9, "在线编码器不可用");
                    this.curSession = null;
                    return false;
                }
                asecSession2.setOnlineScoringEnabled(false);
            } else if (!this.onlineScoringManager.startSession(asecSession2, asecRecordV2Config.getOnlineScoringConfig(), asecRecordV2Config.getUserId())) {
                asecSession2.setOnlineScoringEnabled(false);
                if (!z || dualModeStartPolicy != 1) {
                    asecSession2.destroy(-9, asecSession2.getOnlineMessage() != null ? asecSession2.getOnlineMessage() : "在线评分启动失败");
                    this.curSession = null;
                    return false;
                }
            }
        }
        startRecordLoop(asecSession2);
        if (z) {
            return startLocalEngine(asecSession2);
        }
        return true;
    }

    public void stopRecordV2(java.lang.String str, int i) {
        if (i == 1) {
            giveUpRecordV2(str);
        } else {
            stopRecordInternal(str, false);
        }
    }

    public void giveUpRecordV2(java.lang.String str) {
        stopRecordInternal(str, true);
    }

    public boolean reportUploadedOpusUrl(java.lang.String str, java.lang.String str2) {
        return this.onlineScoringManager.reportUploadedOpusUrl(str, str2);
    }

    public boolean reportUploadedOpusRetryBegin(java.lang.String str) {
        return this.onlineScoringManager.reportUploadedOpusRetryBegin(str);
    }

    public boolean reportUploadedOpusRetryBegin(java.lang.String str, java.lang.String str2) {
        return this.onlineScoringManager.reportUploadedOpusRetryBegin(str, str2);
    }

    public boolean reportUploadedOpusFailed(java.lang.String str, java.lang.String str2) {
        return this.onlineScoringManager.reportUploadedOpusFailed(str, str2);
    }

    public boolean reportUploadedMp3Url(java.lang.String str, java.lang.String str2) {
        return this.onlineScoringManager.reportUploadedMp3Url(str, str2);
    }

    public void endRecord(java.lang.String str) {
        stopRecordInternal(str, false);
    }

    public void forceStopAll() {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.curSession;
        if (asecSession != null) {
            asecSession.destroy();
            this.curSession = null;
        }
    }

    private void stopRecordInternal(java.lang.String str, boolean z) {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.curSession;
        if (asecSession != null && asecSession.recordId != null && this.curSession.recordId.equals(str)) {
            if (z) {
                this.curSession.setGiveUpScoring(true);
                this.curSession.destroy();
            } else {
                this.curSession.stop();
            }
            this.curSession = null;
            return;
        }
        forceStopAll();
        com.up366.common.log.Logger.error("endRecord invalid recordId : " + str);
    }

    private boolean startLocalEngine(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession.isAsync) {
            this.engineV2Wrapper.startRecordWavConsumer(asecSession);
            return true;
        }
        try {
            int type = asecSession.getType();
            if (type == 3 || type == 4 || type == 5 || type == 6 || type == 7) {
                this.engineV2Wrapper.startRecord(asecSession);
            } else if (type == 11) {
                this.engineV2Wrapper.startRecordPart_No_Score(asecSession);
            } else {
                throw new java.lang.IllegalStateException("未知的评分类型 ：" + asecSession.getType());
            }
            return true;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
            if (asecSession.isCurrentSession()) {
                asecSession.destroy(-100, e.getMessage());
            }
            throw e;
        }
    }

    private void startRecordLoop(final com.up366.asecengine.englishengine.AsecSession asecSession) {
        this.executorRecord.post(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.AsecEngineHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.m15xa143ca79(asecSession);
            }
        });
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX INFO: renamed from: lambda$startRecordLoop$2$com-up366-asecengine-englishengine-AsecEngineHelper, reason: not valid java name */
    /* synthetic */ void m15xa143ca79(com.up366.asecengine.englishengine.AsecSession r64) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 4331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.asecengine.englishengine.AsecEngineHelper.m15xa143ca79(com.up366.asecengine.englishengine.AsecSession):void");
    }

    /* JADX INFO: renamed from: lambda$startRecordLoop$0$com-up366-asecengine-englishengine-AsecEngineHelper, reason: not valid java name */
    /* synthetic */ void m13x86ce6777(com.up366.asecengine.englishengine.AsecSession asecSession, long j, byte[] bArr, int i) {
        this.onlineScoringManager.onOpusPacket(asecSession, bArr, j);
    }

    /* JADX INFO: renamed from: lambda$startRecordLoop$1$com-up366-asecengine-englishengine-AsecEngineHelper, reason: not valid java name */
    /* synthetic */ void m14x140918f8(com.up366.asecengine.englishengine.AsecSession asecSession, byte[] bArr, int i) {
        this.onlineScoringManager.onOpusPacket(asecSession, bArr, java.lang.System.currentTimeMillis());
    }

    private com.up366.library.opusencoder.OpusHelper createRecordOpusHelper(com.up366.asecengine.englishengine.AsecSession asecSession) {
        com.up366.library.opusencoder.OpusParams opusParams = new com.up366.library.opusencoder.OpusParams();
        synchronized (this.defaultOpusParams) {
            copyOpusParams(this.defaultOpusParams, opusParams);
        }
        if (asecSession.isOnlineScoringEnabled()) {
            opusParams.setEnable(true);
            opusParams.setSampleRate(16000);
            opusParams.setChannels(1);
            opusParams.setBitrate(com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.ONLINE_BITRATE);
            opusParams.setFrameMs(20);
        }
        com.up366.library.opusencoder.OpusHelper opusHelper = new com.up366.library.opusencoder.OpusHelper();
        opusHelper.updateOpusParams(opusParams);
        return opusHelper;
    }

    private com.up366.library.opusencoder.OpusParams buildOnlineStreamOpusParams(com.up366.asecengine.englishengine.AsecSession asecSession) {
        com.up366.library.opusencoder.OpusParams opusParams = new com.up366.library.opusencoder.OpusParams();
        opusParams.setEnable(true);
        opusParams.setSampleRate(16000);
        opusParams.setChannels(1);
        opusParams.setBitrate(com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.ONLINE_BITRATE);
        opusParams.setFrameMs(20);
        return opusParams;
    }

    private boolean shouldDispatchFft(com.up366.asecengine.englishengine.AsecSession asecSession) {
        int fftStyle = asecSession == null ? -1 : asecSession.getFftStyle();
        return fftStyle == -1 || fftStyle == 1;
    }

    private boolean shouldDispatchWave(com.up366.asecengine.englishengine.AsecSession asecSession) {
        int fftStyle = asecSession == null ? -1 : asecSession.getFftStyle();
        return fftStyle == -1 || fftStyle == 2;
    }

    private boolean isOnlineStreamEncoderSupported() {
        try {
            new com.up366.library.opusencoder.OpusStreamEncoder();
            return true;
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("AsecEngineHelper OpusStreamEncoder error", th);
            return false;
        }
    }

    private com.up366.library.opusencoder.OpusStreamEncoder createOnlineStreamEncoder(com.up366.asecengine.englishengine.AsecSession asecSession) {
        com.up366.library.opusencoder.OpusStreamEncoder opusStreamEncoder = new com.up366.library.opusencoder.OpusStreamEncoder(buildOnlineStreamOpusParams(asecSession));
        if (opusStreamEncoder.init()) {
            return opusStreamEncoder;
        }
        throw new java.lang.IllegalStateException("online opus stream encoder init failed");
    }

    private void closeOnlineStreamEncoder(com.up366.library.opusencoder.OpusStreamEncoder opusStreamEncoder) {
        if (opusStreamEncoder == null) {
            return;
        }
        try {
            opusStreamEncoder.close();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("AsecEngineHelper close online opus stream encoder error", e);
        }
    }

    private java.lang.String buildOpusPath(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV)) {
            return str.substring(0, str.length() - 4) + ".opus";
        }
        return str + ".opus";
    }

    private java.lang.String buildMp3Path(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV)) {
            return str.substring(0, str.length() - 4) + com.up366.medialibrary.common.utils.MimeTypeUtils.MP3;
        }
        return str + com.up366.medialibrary.common.utils.MimeTypeUtils.MP3;
    }

    private com.up366.lamelibrary.Mp3StreamEncoder createRealtimeMp3Encoder(com.up366.asecengine.englishengine.AsecSession asecSession) {
        com.up366.lamelibrary.Mp3StreamEncoder mp3StreamEncoder;
        java.lang.String strBuildMp3Path = buildMp3Path(asecSession.wavPath);
        try {
            mp3StreamEncoder = new com.up366.lamelibrary.Mp3StreamEncoder(strBuildMp3Path, 16000, 1, 32, 3, 1);
        } catch (java.lang.Exception e) {
            e = e;
            mp3StreamEncoder = null;
        }
        try {
            if (!mp3StreamEncoder.init()) {
                throw new java.lang.IllegalStateException("mp3 stream encoder init failed");
            }
            asecSession.setMp3Path(strBuildMp3Path);
            return mp3StreamEncoder;
        } catch (java.lang.Exception e2) {
            e = e2;
            if (mp3StreamEncoder != null) {
                mp3StreamEncoder.close();
            }
            asecSession.setMp3Path(null);
            com.up366.common.log.Logger.error("初始化实时 MP3 编码器失败: " + e.getMessage(), e);
            return null;
        }
    }

    private void copyOpusParams(com.up366.library.opusencoder.OpusParams opusParams, com.up366.library.opusencoder.OpusParams opusParams2) {
        if (opusParams == null || opusParams2 == null) {
            return;
        }
        opusParams2.setEnable(opusParams.isEnable());
        opusParams2.setSampleRate(opusParams.getSampleRate());
        opusParams2.setChannels(opusParams.getChannels());
        opusParams2.setBitrate(opusParams.getBitrate());
        opusParams2.setFrameMs(opusParams.getFrameMs());
    }

    private void finalizeRecordArtifacts(com.up366.asecengine.englishengine.AsecSession asecSession, com.up366.asecengine.englishengine.log.RecordTraceLogger recordTraceLogger, java.lang.String str, java.io.File file, long j, long j2, com.up366.asecengine.utils.AsesMD5 asesMD5, boolean z) throws java.lang.Throwable {
        if (j <= 0) {
            if (z) {
                throw new com.up366.asecengine.exception.NoRecordFileException(NO_RECORD_FILE_NO_READ);
            }
            com.up366.common.FileUtilsUp.deleteDirOrFile(file.getAbsolutePath());
            return;
        }
        asecSession.duration = android.os.SystemClock.uptimeMillis() - j2;
        writeRecordDataLengthToFile(str, j);
        asecSession.setMd5Str(asesMD5.build());
        attachDefaultWavCheckerResult(asecSession);
        com.up366.common.log.Logger.info("TAG - AsecEngineHelper - run - 录音时长：" + asecSession.duration + "ms 音频时长：" + (j / 32) + "ms");
        java.io.File file2 = new java.io.File(asecSession.wavPath);
        recordTraceLogger.onTmpFileState(file);
        com.up366.common.FileUtilsUp.deleteDirOrFile(file2.getAbsolutePath());
        copyTmpFile(file, file2);
        recordTraceLogger.onFinalFileState(file2);
    }

    private void cleanupForceOverArtifacts(com.up366.asecengine.englishengine.AsecSession asecSession, java.io.File file) {
        com.up366.common.FileUtilsUp.deleteDirOrFile(file.getAbsolutePath());
        if (asecSession.getOpusPath() != null) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(asecSession.getOpusPath());
            asecSession.setOpusPath(null);
        }
        if (asecSession.getMp3Path() != null) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(asecSession.getMp3Path());
            asecSession.setMp3Path(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachDefaultWavCheckerResult(com.up366.asecengine.englishengine.AsecSession asecSession) {
        asecSession.setWavCheckerJsonResult(com.up366.asecengine.englishengine.WavCheckerCompat.compat(null));
    }

    private void copyTmpFile(java.io.File file, java.io.File file2) throws java.lang.Throwable {
        if (file.renameTo(file2)) {
            return;
        }
        com.up366.common.log.Logger.error("AsecEngineHelper - run - rename file error! try copy...");
        java.lang.String str = (((("tmpFileExists:" + file.exists() + "\n") + "tmpFileLength:" + file.length() + "\n") + "recordFile:" + file2.exists() + "\n") + "recordFileLength:" + file2.length() + "\n") + "rename file error! try copy...\n";
        com.up366.common.FileUtilsUp.copyFileOrDir(file, file2);
        if (!com.up366.common.FileUtilsUp.isFileExists(file2)) {
            com.up366.common.log.Logger.error("AsecEngineHelper - run - copy wav error!");
            com.up366.common.global.GB.get().sendLog("ASES-rename-tmp-wav-error", str + "AsecEngineHelper - run - copy wav error!\n");
            throw new com.up366.asecengine.exception.NoRecordFileException(NO_RECORD_FILE_COPY_ERROR);
        }
        com.up366.common.global.GB.get().sendLog("ASES-rename-tmp-wav-error", str + "AsecEngineHelper - run - copy wav success!\n");
    }

    private void countFFTOutput(byte[] bArr, int i, byte[] bArr2) {
        this.asesJni.fft(1, 16, bArr, 1024, bArr2, i);
        this.avgs[this.avgIndex] = 0;
        for (byte b : bArr2) {
            int[] iArr = this.avgs;
            int i2 = this.avgIndex;
            iArr[i2] = iArr[i2] + b;
        }
        int[] iArr2 = this.avgs;
        int i3 = this.avgIndex;
        iArr2[i3] = iArr2[i3] / bArr2.length;
        int i4 = i3 + 1;
        this.avgIndex = i4;
        this.avgIndex = i4 % iArr2.length;
        int i5 = 0;
        for (int i6 : iArr2) {
            i5 += i6;
        }
        int length = i5 / this.avgs.length;
        int i7 = length <= 50 ? length : 50;
        if (length < 20) {
            i7 = 20;
        }
        this.asesJni.delNoice(bArr2, bArr2.length, i7);
    }

    private void writeRecordDataLengthToFile(java.lang.String str, long j) {
        byte[] waveHeader = com.up366.asecengine.asecmgr.MediaUtils.getWaveHeader(j);
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.write(waveHeader);
            randomAccessFile.close();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void testWav2(int i, java.lang.String str, java.lang.String str2, java.util.List<com.up366.asecengine.model.KeyValue> list) throws java.lang.Exception {
        if (i == 7) {
            throw new java.lang.IllegalArgumentException("段落评分请使用 testParagraphWav2");
        }
        testWav2Internal(i, str, str2, list, null);
    }

    public void testParagraphWav2(java.lang.String str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig, java.util.List<com.up366.asecengine.model.KeyValue> list) throws java.lang.Exception {
        validateParagraphScoringConfig(asecParagraphScoringConfig);
        testWav2Internal(7, str, null, list, asecParagraphScoringConfig);
    }

    private void testWav2Internal(int i, java.lang.String str, java.lang.String str2, java.util.List<com.up366.asecengine.model.KeyValue> list, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig) throws java.lang.Exception {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.curSession;
        if (asecSession != null) {
            asecSession.destroy();
            this.curSession = null;
        }
        com.up366.asecengine.englishengine.AsecSession asecSession2 = new com.up366.asecengine.englishengine.AsecSession("testAses", i, str2, str, false);
        asecSession2.setSessionParams(list);
        asecSession2.setParagraphScoringConfig(asecParagraphScoringConfig);
        asecSession2.setOnMediaStateChangeListener(this.callBack);
        this.curSession = asecSession2;
        asecSession2.start();
        try {
            if (i == 3 || i == 4 || i == 5 || i == 6 || i == 7) {
                this.engineV2Wrapper.startRecord2(asecSession2);
            } else if (i == 11) {
                this.engineV2Wrapper.startRecordPart_No_Score(asecSession2);
            } else {
                throw new java.lang.IllegalStateException("未知的评分类型 ：" + i);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
            if (asecSession2.isCurrentSession()) {
                asecSession2.destroy(-100, e.getMessage());
            }
            throw e;
        }
    }

    public void testWav(int i, java.lang.String str, java.lang.String str2, java.util.List<com.up366.asecengine.model.KeyValue> list, boolean z) throws java.lang.Exception {
        if (i == 7) {
            throw new java.lang.IllegalArgumentException("段落评分请使用 testParagraphWav");
        }
        testWavInternal(i, str, str2, list, z, null);
    }

    public void testParagraphWav(java.lang.String str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig, java.util.List<com.up366.asecengine.model.KeyValue> list, boolean z) throws java.lang.Exception {
        validateParagraphScoringConfig(asecParagraphScoringConfig);
        testWavInternal(7, str, null, list, z, asecParagraphScoringConfig);
    }

    private void testWavInternal(int i, java.lang.String str, java.lang.String str2, java.util.List<com.up366.asecengine.model.KeyValue> list, final boolean z, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig) throws java.lang.Exception {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.curSession;
        if (asecSession != null) {
            asecSession.destroy();
            this.curSession = null;
        }
        final com.up366.asecengine.englishengine.AsecSession asecSession2 = new com.up366.asecengine.englishengine.AsecSession("testAses", i, str2, str, false);
        asecSession2.setSessionParams(list);
        asecSession2.setParagraphScoringConfig(asecParagraphScoringConfig);
        asecSession2.setOnMediaStateChangeListener(this.callBack);
        this.curSession = asecSession2;
        this.executorRecord.post(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.AsecEngineHelper.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v18 */
            /* JADX WARN: Type inference failed for: r2v19 */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r2v5 */
            /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
            /* JADX WARN: Type inference failed for: r2v8 */
            /* JADX WARN: Type inference failed for: r2v9 */
            @Override // com.up366.common.task.Task
            public void run() throws java.lang.Exception {
                java.io.RandomAccessFile randomAccessFile;
                com.up366.common.log.Logger.info("TAG - AsecEngineHelper - testWav - skip wavchecker invoke, enableWavChecker:" + z);
                asecSession2.start();
                ?? r2 = 0;
                java.io.RandomAccessFile randomAccessFile2 = null;
                try {
                    try {
                        randomAccessFile = new java.io.RandomAccessFile(new java.io.File(asecSession2.wavPath), "rw");
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                } catch (java.io.IOException e) {
                    e = e;
                }
                try {
                    byte[] bArr = new byte[4096];
                    long jSkipWavHeader = com.up366.asecengine.englishengine.AsecEngineHelper.this.skipWavHeader(randomAccessFile);
                    com.up366.common.log.Logger.info("TAG - AsecEngineHelper - testWav - WavHeader size : " + randomAccessFile.getFilePointer());
                    com.up366.asecengine.utils.AsesMD5 asesMD5 = new com.up366.asecengine.utils.AsesMD5();
                    while (true) {
                        int i2 = randomAccessFile.read(bArr);
                        if (i2 <= 0 || jSkipWavHeader <= 0) {
                            break;
                        }
                        jSkipWavHeader -= (long) i2;
                        byte[] bArr2 = new byte[i2];
                        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i2);
                        asecSession2.writeData(bArr2);
                        asesMD5.append(bArr);
                    }
                    java.lang.String strBuild = asesMD5.build();
                    asecSession2.setMd5Str(strBuild);
                    com.up366.asecengine.englishengine.AsecEngineHelper.this.attachDefaultWavCheckerResult(asecSession2);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.lang.String str3 = "TAG - AsecEngineHelper - run - md5 :";
                    sb.append("TAG - AsecEngineHelper - run - md5 :");
                    sb.append(strBuild);
                    com.up366.common.log.Logger.info(sb.toString());
                    com.up366.common.IOUtils.close(randomAccessFile);
                    r2 = str3;
                } catch (java.io.IOException e2) {
                    e = e2;
                    randomAccessFile2 = randomAccessFile;
                    com.up366.common.log.Logger.error("testWav IO error " + e.getMessage(), e);
                    com.up366.common.IOUtils.close(randomAccessFile2);
                    r2 = randomAccessFile2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    r2 = randomAccessFile;
                    com.up366.common.IOUtils.close(r2);
                    throw th;
                }
                if (asecSession2.state != -1) {
                    com.up366.asecengine.englishengine.AsecEngineHelper.this.attachDefaultWavCheckerResult(asecSession2);
                    com.up366.asecengine.englishengine.AsecEngineHelper.this.endRecord("testAses");
                    asecSession2.onRecordStateChange(2);
                }
            }
        });
        try {
            if (i == 3 || i == 4 || i == 5 || i == 6 || i == 7) {
                this.engineV2Wrapper.startRecord(asecSession2);
            } else if (i == 11) {
                this.engineV2Wrapper.startRecordPart_No_Score(asecSession2);
            } else {
                throw new java.lang.IllegalStateException("未知的评分类型 ：" + i);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
            if (asecSession2.isCurrentSession()) {
                asecSession2.destroy(-100, e.getMessage());
            }
            throw e;
        }
    }

    private void validateParagraphScoringConfig(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig) {
        if (asecParagraphScoringConfig == null) {
            throw new java.lang.IllegalArgumentException("缺少段落评分配置");
        }
        asecParagraphScoringConfig.validate();
        validateParagraphInputPath("段落原始评分资源", asecParagraphScoringConfig.getSourceData(), asecParagraphScoringConfig.getSourceDataType());
        if (asecParagraphScoringConfig.getScope() == 1) {
            validateParagraphInputPath("段落子资源规则", asecParagraphScoringConfig.getRuleData(), asecParagraphScoringConfig.getRuleDataType());
        }
    }

    private void validateParagraphInputPath(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH.equals(str3)) {
            if (str2 == null || !new java.io.File(str2).isFile()) {
                throw new java.lang.IllegalArgumentException(str + "文件不存在：" + str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long skipWavHeader(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        byte[] bArr = new byte[4];
        randomAccessFile.read(bArr);
        if (!"RIFF".equals(new java.lang.String(bArr))) {
            com.up366.common.log.Logger.error("TAG - AsecEngineHelper - skipWavHeader - file sign:".concat(new java.lang.String(bArr)));
            return Long.MAX_VALUE;
        }
        randomAccessFile.seek(12L);
        while (randomAccessFile.read(bArr) > 0) {
            java.lang.String str = new java.lang.String(bArr);
            randomAccessFile.read(bArr);
            int i = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
            if (i >= 0) {
                long j = i;
                if (j <= randomAccessFile.length() - randomAccessFile.getFilePointer()) {
                    if ("data".equals(str)) {
                        return j;
                    }
                    randomAccessFile.seek(randomAccessFile.getFilePointer() + j);
                }
            }
            randomAccessFile.seek(0L);
            com.up366.common.log.Logger.error("TAG - AsecEngineHelper - skipWavHeader - size:" + i);
            return Long.MAX_VALUE;
        }
        return Long.MAX_VALUE;
    }

    public java.lang.String getNetText(java.util.List<java.lang.String> list) {
        return this.engineV2Wrapper.getNetText(list);
    }

    public com.up366.asecengine.englishengine.AsecSession getCurSession() {
        return this.curSession;
    }

    public java.lang.String checkWav(java.lang.String str) {
        java.lang.String strCompat = com.up366.asecengine.englishengine.WavCheckerCompat.compat(null);
        com.up366.common.log.Logger.info("TAG - AsecEngineHelper - checkWav - wavchecker removed, return compat result - wav:" + str + " result:" + strCompat);
        return strCompat;
    }
}
