package com.up366.asecengine.englishengine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecSession {
    public static final int DUAL_MODE_START_POLICY_LOCAL_ONLY_ONLINE_FAILED = 1;
    public static final int DUAL_MODE_START_POLICY_STRICT = 0;
    public static final int ERR_CODE_COPY_MODEL_FAILED = -3;
    public static final int ERR_CODE_DOWNLOAD_NET_FAILED = -7;
    public static final int ERR_CODE_NO_NET = -1;
    public static final int ERR_CODE_NO_PERMISSION = -4;
    public static final int ERR_CODE_NO_SDCARD_SPACE = -5;
    public static final int ERR_CODE_NO_WAV_FILE = -6;
    public static final int ERR_CODE_OK = 0;
    public static final int ERR_CODE_ONLINE_CONNECTION_FAILED = -10;
    public static final int ERR_CODE_ONLINE_FALLBACK_FAILED = -12;
    public static final int ERR_CODE_ONLINE_START_FAILED = -9;
    public static final int ERR_CODE_ONLINE_UPLOAD_FAILED = -11;
    public static final int ERR_CODE_PARAGRAPH_RESOURCE = -13;
    public static final int ERR_CODE_RECORD_TIMEOUT = -8;
    public static final int ERR_CODE_START_RECORD_FAILED = -2;
    public static final int ERR_CODE_SUB_RESOURCE = -14;
    public static final int ERR_CODE_UNKNOWN = -100;
    public static final int ONLINE_UPLOAD_STATE_FALLBACK_BEGIN = 6;
    public static final int ONLINE_UPLOAD_STATE_FALLBACK_FAILED = 7;
    public static final int ONLINE_UPLOAD_STATE_FALLBACK_SUCCESS = 8;
    public static final int ONLINE_UPLOAD_STATE_IDLE = 0;
    public static final int ONLINE_UPLOAD_STATE_READY = 1;
    public static final int ONLINE_UPLOAD_STATE_REALTIME_SUCCESS = 5;
    public static final int ONLINE_UPLOAD_STATE_RESUME_PENDING = 2;
    public static final int ONLINE_UPLOAD_STATE_STOP_RESUME_BEGIN = 3;
    public static final int PART_ASR = 6;
    public static final int PART_A_V2 = 3;
    public static final int PART_B_V2 = 4;
    public static final int PART_C_V2 = 5;
    public static final int PART_NO_SCORE = 11;
    public static final int PART_PARAGRAPH = 7;
    public static final int SCORING_TYPE_LOCAL = 1;
    public static final int SCORING_TYPE_LOCAL_AND_ONLINE = 2;
    public static final int SCORING_TYPE_ONLINE = 0;
    public static final int SCORING_TYPE_RECORD_ONLY = 3;
    public static java.util.Comparator<java.lang.String> netfileComparator = new java.util.Comparator<java.lang.String>() { // from class: com.up366.asecengine.englishengine.AsecSession.2
        @Override // java.util.Comparator
        public int compare(java.lang.String str, java.lang.String str2) {
            return com.up366.asecengine.englishengine.AsecSession.replaceConsecutiveNumbers(str).compareToIgnoreCase(com.up366.asecengine.englishengine.AsecSession.replaceConsecutiveNumbers(str2));
        }
    };
    private java.lang.String audioPracticeId;
    private int barNum;
    long duration;
    private java.lang.String engineErrorStack;
    boolean isAsync;
    private java.lang.String jsonResult;
    private int jsonResultType;
    private java.lang.String md5Str;
    private java.lang.String message;
    private java.lang.String mp3Path;
    java.lang.String netFiles;
    private com.up366.asecengine.asecmgr.ISpeechStatCallBack onMediaStateChangeListener;
    private java.lang.String onlineMessage;
    private java.lang.String onlineSessionId;
    private java.lang.String opusPath;
    private com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig paragraphScoringConfig;
    java.lang.String recordId;
    int state;
    int type;
    private java.lang.String wavCheckerJsonResult;
    final java.lang.String wavPath;
    private int engineErrorCode = 0;
    private java.lang.String onMediaStateChangeListenerOwner = "unset";
    private int code = 0;
    private int extErrCode = 0;
    private int scoringType = 1;
    private boolean localScoringEnabled = true;
    private boolean onlineScoringEnabled = false;
    private boolean giveUpScoring = false;
    private int dualModeStartPolicy = 0;
    private int onlineUploadState = 0;
    private java.util.List<com.up366.asecengine.model.KeyValue> sessionParams = new java.util.ArrayList();
    private int fftStyle = -1;
    private boolean autoCleanLog = true;
    private final long sessionId = java.lang.System.currentTimeMillis();
    private final java.util.concurrent.LinkedBlockingDeque<byte[]> blockingDeque = new java.util.concurrent.LinkedBlockingDeque<>();
    private boolean isCurrentSession = true;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PartType {
    }

    private boolean shouldUpdateSessionState(int i) {
        return i != 9;
    }

    public AsecSession(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, boolean z) {
        this.isAsync = false;
        this.recordId = str;
        this.type = i;
        this.netFiles = str2;
        this.wavPath = str3;
        this.isAsync = z;
    }

    public void writeData(byte[] bArr) {
        this.blockingDeque.add(bArr);
    }

    public byte[] readData() {
        try {
            return this.blockingDeque.poll(500L, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.InterruptedException e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
            return null;
        }
    }

    public boolean hasData() {
        return this.blockingDeque.size() > 0;
    }

    public boolean isCurrentSession(com.up366.asecengine.englishengine.AsecSession asecSession) {
        return asecSession != null && this.sessionId == asecSession.sessionId;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public void start() {
        onRecordStateChange(0);
    }

    public void stop() {
        onRecordStateChange(1);
    }

    public void destroy() {
        this.isCurrentSession = false;
        int i = this.state;
        if (i == 99 || i == -1 || i == 4) {
            return;
        }
        onRecordStateChange(99);
    }

    public void forceStopRecord(int i, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - AsecSession - forceStopRecord - code = [" + i + "], info = [" + str + "]");
        this.isCurrentSession = false;
        this.code = i;
        this.message = str;
        int i2 = this.state;
        if (i2 == 99 || i2 == -1 || i2 == 4) {
            return;
        }
        onRecordStateChange(99);
    }

    public void destroy(int i, java.lang.String str) {
        destroy(i, 0, str);
    }

    public void destroy(int i, int i2, java.lang.String str) {
        this.isCurrentSession = false;
        this.code = i;
        this.extErrCode = i2;
        this.message = str;
        int i3 = this.state;
        if (i3 == 99 || i3 == -1 || i3 == 4) {
            return;
        }
        onRecordStateChange(-1);
    }

    public void onRecordStateChange(final int i) {
        final com.up366.asecengine.asecmgr.ISpeechStatCallBack iSpeechStatCallBack = this.onMediaStateChangeListener;
        final java.lang.String str = this.onMediaStateChangeListenerOwner;
        com.up366.common.log.Logger.info("TAG - AsecSession - onRecordStateChange - recordId:" + this.recordId + " - state:" + getStateName(i) + " - listenerOwner:" + str);
        if (shouldUpdateSessionState(i)) {
            this.state = i;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.AsecSession.1
            @Override // com.up366.common.task.Task
            public void run() throws java.lang.Exception {
                com.up366.common.log.Logger.info("TAG - AsecSession - dispatchStateChange - recordId:" + com.up366.asecengine.englishengine.AsecSession.this.recordId + " - state:" + com.up366.asecengine.englishengine.AsecSession.this.getStateName(i) + " - listenerOwner:" + str);
                com.up366.asecengine.asecmgr.ISpeechStatCallBack iSpeechStatCallBack2 = iSpeechStatCallBack;
                if (iSpeechStatCallBack2 == null) {
                    com.up366.common.log.Logger.error("TAG - AsecSession - dispatchStateChange - listener is null - recordId:" + com.up366.asecengine.englishengine.AsecSession.this.recordId + " - state:" + com.up366.asecengine.englishengine.AsecSession.this.getStateName(i) + " - listenerOwner:" + str);
                    return;
                }
                iSpeechStatCallBack2.onMediaStateResult(com.up366.asecengine.englishengine.AsecSession.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getStateName(int i) {
        if (i != 99) {
            switch (i) {
                case -1:
                    return "RECORD_STATE_FAILED";
                case 0:
                    return "RECORD_STATE_BEGIN";
                case 1:
                    return "RECORD_STATE_RECORD_STOP";
                case 2:
                    return "RECORD_STATE_RECORD_OVER";
                case 3:
                    return "RECORD_STATE_SCORE";
                case 4:
                    return "RECORD_STATE_OVER";
                case 5:
                    return "RECORD_STATE_ONLINE_UPLOAD_SUCCESS";
                case 6:
                    return "RECORD_STATE_ONLINE_FALLBACK_BEGIN";
                case 7:
                    return "RECORD_STATE_ONLINE_FALLBACK_FAILED";
                case 8:
                    return "RECORD_STATE_ONLINE_FALLBACK_SUCCESS";
                case 9:
                    return "RECORD_STATE_ONLINE_RESUME_REQUIRED";
                case 10:
                    return "RECORD_STATE_ONLINE_STOP_RESUME_BEGIN";
                default:
                    return "UNKNOWN_STATE";
            }
        }
        return "RECORD_STATE_FORCE_OVER";
    }

    public boolean isCurrentSession() {
        return this.isCurrentSession;
    }

    public boolean isRecord() {
        return this.state == 0;
    }

    public java.lang.String getRecordId() {
        return this.recordId;
    }

    public void setOnMediaStateChangeListener(com.up366.asecengine.asecmgr.ISpeechStatCallBack iSpeechStatCallBack) {
        setOnMediaStateChangeListener(iSpeechStatCallBack, "unknown");
    }

    public void setOnMediaStateChangeListener(com.up366.asecengine.asecmgr.ISpeechStatCallBack iSpeechStatCallBack, java.lang.String str) {
        this.onMediaStateChangeListener = iSpeechStatCallBack;
        if (str == null) {
            str = "unknown";
        }
        this.onMediaStateChangeListenerOwner = str;
    }

    public java.lang.String getWavPath() {
        return this.wavPath;
    }

    public java.lang.String getNetFiles() {
        return this.netFiles;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public boolean isAsync() {
        return this.isAsync;
    }

    public int getType() {
        return this.type;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public int getJsonResultType() {
        return this.jsonResultType;
    }

    public void setJsonResultType(int i) {
        this.jsonResultType = i;
    }

    public java.lang.String getJsonResult() {
        return this.jsonResult;
    }

    public void setJsonResult(java.lang.String str) {
        this.jsonResult = str;
    }

    public void setJsonResult(byte[] bArr) {
        try {
            this.jsonResult = new java.lang.String(bArr, "GBK");
        } catch (java.io.UnsupportedEncodingException e) {
            com.up366.common.log.Logger.info("TAG - AsecSession - setJsonResult - ", e);
        }
    }

    public java.lang.String getMd5Str() {
        return this.md5Str;
    }

    protected void setMd5Str(java.lang.String str) {
        this.md5Str = str;
    }

    public java.util.List<com.up366.asecengine.model.KeyValue> getSessionParams() {
        return this.sessionParams;
    }

    public void setSessionParams(java.util.List<com.up366.asecengine.model.KeyValue> list) {
        if (list != null) {
            this.sessionParams = list;
        }
        com.up366.asecengine.englishengine.AsesLogHelper.addLogParams(list);
    }

    public int getEngineErrorCode() {
        return this.engineErrorCode;
    }

    public java.lang.String getEngineErrorStack() {
        return this.engineErrorStack;
    }

    public void setError(int i) {
        this.engineErrorCode = i;
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        new java.lang.Throwable().printStackTrace(new java.io.PrintWriter(stringWriter));
        this.engineErrorStack = stringWriter.toString();
    }

    public java.lang.String getHtmlResult() {
        if (this.type != 3) {
            return "";
        }
        return new com.up366.asecengine.utils.JsonToColorHtml().parse(this.jsonResult);
    }

    public void setBarNum(int i) {
        this.barNum = i;
    }

    public int getBarNum() {
        return this.barNum;
    }

    public int getFftStyle() {
        return this.fftStyle;
    }

    public void setFftStyle(int i) {
        this.fftStyle = i;
    }

    public int getCode() {
        return this.code;
    }

    public java.lang.String getWavCheckerJsonResult() {
        return this.wavCheckerJsonResult;
    }

    public void setWavCheckerJsonResult(java.lang.String str) {
        this.wavCheckerJsonResult = str;
    }

    public int getScoringType() {
        return this.scoringType;
    }

    public void setScoringType(int i) {
        this.scoringType = i;
    }

    public boolean isLocalScoringEnabled() {
        return this.localScoringEnabled;
    }

    public void setLocalScoringEnabled(boolean z) {
        this.localScoringEnabled = z;
    }

    public boolean isOnlineScoringEnabled() {
        return this.onlineScoringEnabled;
    }

    public void setOnlineScoringEnabled(boolean z) {
        this.onlineScoringEnabled = z;
    }

    public boolean isGiveUpScoring() {
        return this.giveUpScoring;
    }

    public void setGiveUpScoring(boolean z) {
        this.giveUpScoring = z;
    }

    public int getDualModeStartPolicy() {
        return this.dualModeStartPolicy;
    }

    public void setDualModeStartPolicy(int i) {
        this.dualModeStartPolicy = i;
    }

    public java.lang.String getAudioPracticeId() {
        return this.audioPracticeId;
    }

    public void setAudioPracticeId(java.lang.String str) {
        this.audioPracticeId = str;
    }

    public java.lang.String getOnlineSessionId() {
        return this.onlineSessionId;
    }

    public void setOnlineSessionId(java.lang.String str) {
        this.onlineSessionId = str;
    }

    public java.lang.String getOpusPath() {
        return this.opusPath;
    }

    public void setOpusPath(java.lang.String str) {
        this.opusPath = str;
    }

    public java.lang.String getMp3Path() {
        return this.mp3Path;
    }

    public void setMp3Path(java.lang.String str) {
        this.mp3Path = str;
    }

    public int getOnlineUploadState() {
        return this.onlineUploadState;
    }

    public void setOnlineUploadState(int i) {
        this.onlineUploadState = i;
    }

    public java.lang.String getOnlineMessage() {
        return this.onlineMessage;
    }

    public void setOnlineMessage(java.lang.String str) {
        this.onlineMessage = str;
    }

    public boolean isAutoCleanLog() {
        return this.autoCleanLog;
    }

    public void setAutoCleanLog(boolean z) {
        this.autoCleanLog = z;
    }

    public int getExtErrCode() {
        return this.extErrCode;
    }

    public void setExtErrCode(int i) {
        this.extErrCode = i;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig getParagraphScoringConfig() {
        return this.paragraphScoringConfig;
    }

    public void setParagraphScoringConfig(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig) {
        this.paragraphScoringConfig = asecParagraphScoringConfig;
    }

    public java.lang.String toString() {
        return "AsecSession{type=" + this.type + ", isAsync=" + this.isAsync + ", recordId='" + this.recordId + "', sessionId=" + this.sessionId + ", wavPath='" + this.wavPath + "', netFiles='" + this.netFiles + "', duration=" + this.duration + ", state=" + this.state + ", engineErrorCode=" + this.engineErrorCode + ", engineErrorStack='" + this.engineErrorStack + "', isCurrentSession=" + this.isCurrentSession + ", code=" + this.code + ", message='" + this.message + "', jsonResultType=" + this.jsonResultType + ", jsonResult='" + this.jsonResult + "', wavCheckerJsonResult='" + this.wavCheckerJsonResult + "', md5Str='" + this.md5Str + "', scoringType=" + this.scoringType + ", localScoringEnabled=" + this.localScoringEnabled + ", onlineScoringEnabled=" + this.onlineScoringEnabled + ", giveUpScoring=" + this.giveUpScoring + ", dualModeStartPolicy=" + this.dualModeStartPolicy + ", audioPracticeId='" + this.audioPracticeId + "', onlineSessionId='" + this.onlineSessionId + "', opusPath='" + this.opusPath + "', mp3Path='" + this.mp3Path + "', onlineUploadState=" + this.onlineUploadState + ", onlineMessage='" + this.onlineMessage + "', paragraphScoringConfig=" + this.paragraphScoringConfig + ", sessionParams=" + this.sessionParams + ", barNum=" + this.barNum + '}';
    }

    public static java.lang.String replaceConsecutiveNumbers(java.lang.String str) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\d+").matcher(str);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, java.lang.String.format(java.util.Locale.getDefault(), "%08d", java.lang.Integer.valueOf(java.lang.Integer.parseInt(matcher.group()))));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
