package com.up366.mobile.book.helper.recordv2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonRecordHelper {
    private static final java.lang.String BLUETOOTH_IGNORE_KEY = "hasBluetoothIgnore";
    private static final int DEFAULT_SAMPLING_RATE = 12;
    private static final long DEFAULT_STOP_ACK_WAIT_MS = 500;
    private static final long DEFAULT_WS_CONNECT_TIMEOUT_MS = 3000;
    private static final int FFT_STYLE_BAR = 1;
    private static final int FFT_STYLE_NONE = 0;
    private static final int FFT_STYLE_WAVE = 2;
    private static final int GIVEUP_FALSE = 0;
    private static final int GIVEUP_TRUE = 1;
    private static final int JS_STATE_FORCE_OVER = 4;
    private static final int JS_STATE_ONLINE_UPLOAD_RETRYING = 6;
    private static final int JS_STATE_ONLINE_UPLOAD_RETRY_FAILED = 7;
    private static final int JS_STATE_ONLINE_UPLOAD_RETRY_SUCCESS = 8;
    private static final int JS_STATE_ONLINE_UPLOAD_SUCCESS = 5;
    private static final int JS_STATE_RECORDING = 0;
    private static final int JS_STATE_RECORD_FAILED = -1;
    private static final int JS_STATE_RECORD_OVER = 3;
    private static final int JS_STATE_RECORD_SUCCESS = 1;
    private static final int JS_STATE_SCORE_FAILED = -2;
    private static final int JS_STATE_SCORING = 2;
    private static final java.lang.String TAG = "TAG - CommonRecordHelper";
    private final android.content.Context context;
    private volatile java.lang.String currentFallbackUploadAudioPracticeId;
    private volatile com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest currentRecordRequest;
    private volatile boolean destroyed;
    private final com.up366.asecengine.englishengine.AsecEngineHelper engineHelper;
    private final com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper mp3UploadHelper;
    private final com.up366.mobile.book.helper.recordv2.CommonRecordOpusUploadHelper opusUploadHelper;
    private final com.up366.mobile.book.helper.interfaces.IRegisterHelper registerHelper;
    private final java.lang.Object mp3UploadLock = new java.lang.Object();
    private final java.util.List<java.lang.String> activeMp3UploadPracticeIds = new java.util.ArrayList();
    private final java.util.Map<java.lang.String, java.lang.String> preparedMp3UploadUrls = new java.util.HashMap();

    private boolean isTerminalState(int i) {
        return i == -1 || i == -2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    static /* synthetic */ void lambda$destroy$1(com.up366.asecengine.englishengine.AsecSession asecSession, int i) {
    }

    private boolean requiresOnlineScoring(int i) {
        return i == 0 || i == 2;
    }

    public CommonRecordHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.interfaces.IRegisterHelper iRegisterHelper) {
        this.context = studyPageWebView.getContext();
        this.registerHelper = iRegisterHelper;
        com.up366.asecengine.englishengine.AsecEngineHelper asecEngineHelperCreate = com.up366.asecengine.englishengine.AsecEngineHelper.create(studyPageWebView.getContext().getApplicationContext());
        this.engineHelper = asecEngineHelperCreate;
        this.opusUploadHelper = new com.up366.mobile.book.helper.recordv2.CommonRecordOpusUploadHelper();
        this.mp3UploadHelper = new com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper();
        asecEngineHelperCreate.setOnFFTUpdateListener(new com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda4(this));
        asecEngineHelperCreate.setWaveUpdateListener(new com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda5(this));
        asecEngineHelperCreate.setOnStateChangeListener(new com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda3(this));
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - init");
    }

    public void startRecordV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - startRecordV2 - json = [" + str + "]");
        try {
            final com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest = parseStartRecordRequest(str);
            if (!startRecordRequest.isOnlineOnly()) {
                com.up366.common.log.Logger.error("TAG - CommonRecordHelper - startRecordV2 - unsupported scoringType, " + buildStartRequestSummary(startRecordRequest));
                throw new java.lang.UnsupportedOperationException("当前仅支持 scoringType=0 的在线录音评测");
            }
            this.currentRecordRequest = startRecordRequest;
            final java.lang.String recordPath = getRecordPath(startRecordRequest.recordId);
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - startRecordV2 - parsed request, " + buildStartRequestSummary(startRecordRequest) + ", wavPath=[" + recordPath + "], userId=[" + com.up366.mobile.common.logic.Auth.UID() + "]");
            if (hasRecordPermission()) {
                if (!startRecordV2Internal(startRecordRequest, recordPath)) {
                    throw new java.lang.IllegalStateException("startRecordV2 failed");
                }
                return;
            }
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - startRecordV2 - request record permission, recordId=[" + startRecordRequest.recordId + "]");
            com.up366.mobile.common.utils.PermissionUtils.checkRecordPermission(this.context, "口语录音", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda1
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i, java.lang.String str2) {
                    this.f$0.lambda$startRecordV2$0(startRecordRequest, recordPath, i, str2);
                }
            });
        } catch (java.lang.RuntimeException e) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - startRecordV2 - parse request failed, json = [" + str + "]", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordV2$0(com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest, java.lang.String str, int i, java.lang.String str2) {
        if (i != 0) {
            handleRecordPermissionDenied(startRecordRequest, str, str2);
        } else {
            if (startRecordV2Internal(startRecordRequest, str)) {
                return;
            }
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - startRecordV2 - engine start failed after permission granted, recordId=[" + startRecordRequest.recordId + "]");
        }
    }

    private boolean startRecordV2Internal(com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest, java.lang.String str) {
        if (this.destroyed) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - startRecordV2Internal - helper already destroyed, skip start, recordId=[" + startRecordRequest.recordId + "]");
            return false;
        }
        this.currentRecordRequest = startRecordRequest;
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - startRecordV2Internal - rebind listeners before start, recordId=[" + startRecordRequest.recordId + "]");
        this.engineHelper.setOnStateChangeListener(new com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda3(this));
        this.engineHelper.setOnFFTUpdateListener(new com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda4(this));
        this.engineHelper.setWaveUpdateListener(new com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda5(this));
        com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config onlineScoringConfig = new com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config().setRecordId(startRecordRequest.recordId).setWavPath(str).setFftStyle(startRecordRequest.fftStyle).setSamplingRate(startRecordRequest.samplingRate).setScoringType(startRecordRequest.scoringType).setUserId(java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID())).setOnlineScoringConfig(buildOnlineScoringConfig(startRecordRequest));
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - startRecordV2 - invoke engine start, recordId=[" + startRecordRequest.recordId + "]");
        if (!this.engineHelper.startRecordV2(onlineScoringConfig)) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - startRecordV2 - engine start failed, recordId=[" + startRecordRequest.recordId + "]");
            clearCurrentRecord(startRecordRequest.recordId);
            return false;
        }
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - startRecordV2 - engine start success, recordId=[" + startRecordRequest.recordId + "]");
        return true;
    }

    public void stopRecordV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - stopRecordV2 - json = [" + str + "]");
        try {
            com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StopRecordRequest stopRecordRequest = parseStopRecordRequest(str);
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - stopRecordV2 - parsed request, recordId=[" + stopRecordRequest.recordId + "], giveup=[" + stopRecordRequest.giveup + "]");
            if (stopRecordRequest.isGiveUp()) {
                com.up366.common.log.Logger.info("TAG - CommonRecordHelper - stopRecordV2 - give up record, recordId=[" + stopRecordRequest.recordId + "]");
                this.engineHelper.giveUpRecordV2(stopRecordRequest.recordId);
                return;
            }
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - stopRecordV2 - invoke engine stop, recordId=[" + stopRecordRequest.recordId + "]");
            this.engineHelper.stopRecordV2(stopRecordRequest.recordId, 0);
        } catch (java.lang.RuntimeException e) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - stopRecordV2 - parse request failed, json = [" + str + "]", e);
            throw e;
        }
    }

    public void forceStopAll() {
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - forceStopAll");
        this.engineHelper.forceStopAll();
    }

    private boolean hasRecordPermission() {
        if (!com.up366.mobile.common.utils.permissions.PermissionApi.isGrantedPermission(this.context, com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO)) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 31 && !com.up366.mobile.common.utils.PreferenceUtils.getBoolean(BLUETOOTH_IGNORE_KEY, false)) {
            return com.up366.mobile.common.utils.permissions.PermissionApi.isGrantedPermission(this.context, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_CONNECT);
        }
        return true;
    }

    private void handleRecordPermissionDenied(com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = startRecordRequest == null ? "" : startRecordRequest.recordId;
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - handleRecordPermissionDenied - recordId=[" + str3 + "], info=[" + str2 + "]");
        com.up366.mobile.common.onlinelog.OpLog.report("口语录音", "拒绝麦克风权限：CommonRecordHelper");
        notifyPermissionDeniedToJs(str3, str, str2);
        clearCurrentRecord(str3);
    }

    private void notifyPermissionDeniedToJs(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("code", -1);
        if (str3 == null) {
            str3 = "";
        }
        jSONObject.put("msg", str3);
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("recordId", str != null ? str : "");
        jSONObject2.put("state", -1);
        jSONObject2.put("duration", 0);
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            str2 = resolveLocalPath(null, str);
        }
        jSONObject2.put("localPath", str2);
        jSONObject2.put("errorInfo", jSONObject);
        com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
        jSONObject3.put("recordInfo", jSONObject2);
        jSONObject3.put("result", new com.alibaba.fastjson.JSONObject());
        this.registerHelper.callJsEvent("recordStateChange", "(%s)", jSONObject3.toJSONString());
    }

    public void destroy() {
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - destroy - begin");
        this.destroyed = true;
        this.engineHelper.forceStopAll();
        this.engineHelper.disconnectWebSocket();
        this.engineHelper.setOnFFTUpdateListener(null);
        this.engineHelper.setWaveUpdateListener(null);
        this.engineHelper.setOnStateChangeListener(new com.up366.asecengine.asecmgr.ISpeechStatCallBack() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda2
            @Override // com.up366.asecengine.asecmgr.ISpeechStatCallBack
            public final void onMediaStateResult(com.up366.asecengine.englishengine.AsecSession asecSession, int i) {
                com.up366.mobile.book.helper.recordv2.CommonRecordHelper.lambda$destroy$1(asecSession, i);
            }
        });
        this.currentFallbackUploadAudioPracticeId = null;
        this.currentRecordRequest = null;
        synchronized (this.mp3UploadLock) {
            this.activeMp3UploadPracticeIds.clear();
            this.preparedMp3UploadUrls.clear();
        }
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - destroy - end");
    }

    protected com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig buildOnlineScoringConfig(com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest) {
        return new com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig().setWebSocketConfig(buildWebSocketConfig()).setStopAckWaitMs(500L).setAutoResumePolicy(new com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy().setEnabled(false)).setOnlineScoringParameters(startRecordRequest.onlineScoringParameters);
    }

    protected java.lang.String getRecordPath(java.lang.String str) {
        return com.up366.mobile.book.helper.V8FilePathHelper.getRecordPath(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFftUpdate(byte[] bArr, int i) {
        com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest = this.currentRecordRequest;
        if (startRecordRequest == null || startRecordRequest.fftStyle != 1) {
            return;
        }
        int[] iArr = new int[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            iArr[i2] = bArr[i2];
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("recordId", startRecordRequest.recordId);
        jSONObject.put("datas", iArr);
        jSONObject.put("audio_quality", java.lang.Integer.valueOf(i));
        this.registerHelper.callJsEvent("recordFFTUpdate", "(%s)", jSONObject.toJSONString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWaveUpdate(byte[] bArr) {
        com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest = this.currentRecordRequest;
        if (startRecordRequest == null || startRecordRequest.fftStyle != 2) {
            return;
        }
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = bArr[i];
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("recordId", startRecordRequest.recordId);
        jSONObject.put("datas", iArr);
        jSONObject.put("audio_quality", 1);
        this.registerHelper.callJsEvent("recordFFTUpdate", "(%s)", jSONObject.toJSONString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStateChange(com.up366.asecengine.englishengine.AsecSession asecSession, int i) {
        java.lang.String strResolveRecordId = resolveRecordId(asecSession);
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - handleStateChange - enter, rawState=[" + i + "], recordId=[" + strResolveRecordId + "], session=" + buildSessionSummary(asecSession));
        java.lang.Integer numMapJsState = mapJsState(i, asecSession);
        if (numMapJsState == null) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - handleStateChange - ignore rawState=[" + i + "], session=" + buildSessionSummary(asecSession));
            return;
        }
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - handleStateChange - rawState=[" + i + "], jsState=[" + numMapJsState + "], recordId=[" + strResolveRecordId + "], session=" + buildSessionSummary(asecSession));
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("recordInfo", buildRecordInfo(asecSession, numMapJsState.intValue()));
        jSONObject.put("result", parseResult(asecSession));
        try {
            this.registerHelper.callJsEvent("recordStateChange", "(%s)", jSONObject.toJSONString());
            if (i == 6) {
                uploadFallbackOpus(asecSession);
            }
            if (i == 2) {
                uploadRecordMp3(asecSession);
            }
            if (isTerminalState(numMapJsState.intValue())) {
                java.lang.String audioPracticeId = asecSession == null ? null : asecSession.getAudioPracticeId();
                clearFallbackUpload(audioPracticeId);
                clearPreparedMp3UploadUrl(audioPracticeId);
                com.up366.common.log.Logger.info("TAG - CommonRecordHelper - handleStateChange - terminal state, clear current recordId=[" + strResolveRecordId + "]");
                clearCurrentRecord(strResolveRecordId);
            }
        } catch (java.lang.RuntimeException e) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - handleStateChange - callJsEvent failed, recordId=[" + strResolveRecordId + "], state=[" + numMapJsState + "]", e);
            throw e;
        }
    }

    private void uploadFallbackOpus(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession == null) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadFallbackOpus - session is null");
            return;
        }
        final java.lang.String audioPracticeId = asecSession.getAudioPracticeId();
        if (com.up366.common.StringUtils.isEmptyOrNull(audioPracticeId)) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadFallbackOpus - missing audioPracticeId, session=" + buildSessionSummary(asecSession));
            return;
        }
        if (!markFallbackUploadStarted(audioPracticeId)) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadFallbackOpus - skip duplicate upload, audioPracticeId=[" + audioPracticeId + "]");
            return;
        }
        final java.lang.String strResolveRecordId = resolveRecordId(asecSession);
        java.lang.String opusPath = asecSession.getOpusPath();
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadFallbackOpus - start, recordId=[" + strResolveRecordId + "], audioPracticeId=[" + audioPracticeId + "], opusPath=[" + opusPath + "]");
        this.opusUploadHelper.upload(opusPath, new com.up366.mobile.book.helper.recordv2.CommonRecordOpusUploadHelper.UploadCallback() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.recordv2.CommonRecordOpusUploadHelper.UploadCallback
            public final void onResult(int i, java.lang.String str, java.lang.String str2) {
                this.f$0.lambda$uploadFallbackOpus$2(audioPracticeId, strResolveRecordId, i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadFallbackOpus$2(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4) {
        if (this.destroyed) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadFallbackOpus - helper already destroyed, skip report, audioPracticeId=[" + str + "]");
            clearFallbackUpload(str);
            return;
        }
        if (i != 0 || com.up366.common.StringUtils.isEmptyOrNull(str4)) {
            java.lang.String strBuildUploadedOpusFailedReason = buildUploadedOpusFailedReason(i, str3, str4);
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadFallbackOpus - upload failed, recordId=[" + str2 + "], audioPracticeId=[" + str + "], code=[" + i + "], info=[" + str3 + "], reason=[" + strBuildUploadedOpusFailedReason + "]");
            if (this.engineHelper.reportUploadedOpusFailed(str, strBuildUploadedOpusFailedReason)) {
                com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadFallbackOpus - reportUploadedOpusFailed success, recordId=[" + str2 + "], audioPracticeId=[" + str + "], reason=[" + strBuildUploadedOpusFailedReason + "]");
            } else {
                com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadFallbackOpus - reportUploadedOpusFailed failed, recordId=[" + str2 + "], audioPracticeId=[" + str + "], reason=[" + strBuildUploadedOpusFailedReason + "]");
            }
            clearFallbackUpload(str);
            return;
        }
        if (this.engineHelper.reportUploadedOpusUrl(str, str4)) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadFallbackOpus - reportUploadedOpusUrl success, recordId=[" + str2 + "], audioPracticeId=[" + str + "], uploadedUrl=[" + str4 + "]");
            return;
        }
        com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadFallbackOpus - reportUploadedOpusUrl failed, recordId=[" + str2 + "], audioPracticeId=[" + str + "], uploadedUrl=[" + str4 + "]");
        clearFallbackUpload(str);
    }

    private void uploadRecordMp3(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession == null) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadRecordMp3 - session is null");
            return;
        }
        final java.lang.String audioPracticeId = asecSession.getAudioPracticeId();
        if (com.up366.common.StringUtils.isEmptyOrNull(audioPracticeId)) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadRecordMp3 - missing audioPracticeId, session=" + buildSessionSummary(asecSession));
            return;
        }
        if (!markMp3UploadStarted(audioPracticeId)) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadRecordMp3 - skip duplicate upload, audioPracticeId=[" + audioPracticeId + "]");
            return;
        }
        final java.lang.String strResolveRecordId = resolveRecordId(asecSession);
        java.lang.String mp3Path = asecSession.getMp3Path();
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadRecordMp3 - start, recordId=[" + strResolveRecordId + "], audioPracticeId=[" + audioPracticeId + "], mp3Path=[" + mp3Path + "]");
        this.mp3UploadHelper.upload(mp3Path, audioPracticeId, new com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadCallback() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordHelper.1
            @Override // com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadCallback
            public void onPrepared(com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadInfo uploadInfo) {
                if (uploadInfo == null || com.up366.common.StringUtils.isEmptyOrNull(uploadInfo.getUploadedUrl())) {
                    return;
                }
                com.up366.mobile.book.helper.recordv2.CommonRecordHelper.this.cachePreparedMp3UploadUrl(uploadInfo.getAudioPracticeId(), uploadInfo.getUploadedUrl());
                com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadRecordMp3 - prepared, recordId=[" + strResolveRecordId + "], audioPracticeId=[" + uploadInfo.getAudioPracticeId() + "], uploadedUrl=[" + uploadInfo.getUploadedUrl() + "], uploadPath=[" + uploadInfo.getUploadPath() + "]");
            }

            @Override // com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadCallback
            public void onResult(int i, java.lang.String str, com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadInfo uploadInfo) {
                if (com.up366.mobile.book.helper.recordv2.CommonRecordHelper.this.destroyed) {
                    com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadRecordMp3 - helper already destroyed, skip upload result, audioPracticeId=[" + audioPracticeId + "]");
                    com.up366.mobile.book.helper.recordv2.CommonRecordHelper.this.clearActiveMp3Upload(audioPracticeId);
                    return;
                }
                if (i != 0 || uploadInfo == null || com.up366.common.StringUtils.isEmptyOrNull(uploadInfo.getUploadedUrl())) {
                    com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadRecordMp3 - upload failed, recordId=[" + strResolveRecordId + "], audioPracticeId=[" + audioPracticeId + "], code=[" + i + "], info=[" + str + "]");
                    com.up366.mobile.book.helper.recordv2.CommonRecordHelper.this.clearActiveMp3Upload(audioPracticeId);
                    return;
                }
                if (com.up366.mobile.book.helper.recordv2.CommonRecordHelper.this.engineHelper.reportUploadedMp3Url(uploadInfo.getAudioPracticeId(), uploadInfo.getUploadedUrl())) {
                    com.up366.common.log.Logger.info("TAG - CommonRecordHelper - uploadRecordMp3 - reportUploadedMp3Url success, recordId=[" + strResolveRecordId + "], audioPracticeId=[" + uploadInfo.getAudioPracticeId() + "], uploadedUrl=[" + uploadInfo.getUploadedUrl() + "]");
                } else {
                    com.up366.common.log.Logger.error("TAG - CommonRecordHelper - uploadRecordMp3 - reportUploadedMp3Url failed, recordId=[" + strResolveRecordId + "], audioPracticeId=[" + uploadInfo.getAudioPracticeId() + "], uploadedUrl=[" + uploadInfo.getUploadedUrl() + "]");
                }
                com.up366.mobile.book.helper.recordv2.CommonRecordHelper.this.clearActiveMp3Upload(audioPracticeId);
            }
        });
    }

    private java.lang.String buildUploadedOpusFailedReason(int i, java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("opus upload failed, code=");
        sb.append(i);
        if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
            sb.append(", info=");
            sb.append(str);
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            sb.append(", uploadedUrl=empty");
        }
        return sb.toString();
    }

    private boolean markMp3UploadStarted(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return false;
        }
        synchronized (this.mp3UploadLock) {
            if (this.activeMp3UploadPracticeIds.contains(str)) {
                return false;
            }
            this.activeMp3UploadPracticeIds.add(str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearActiveMp3Upload(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        synchronized (this.mp3UploadLock) {
            this.activeMp3UploadPracticeIds.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cachePreparedMp3UploadUrl(java.lang.String str, java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            return;
        }
        synchronized (this.mp3UploadLock) {
            this.preparedMp3UploadUrls.put(str, str2);
        }
    }

    private void clearPreparedMp3UploadUrl(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        synchronized (this.mp3UploadLock) {
            this.preparedMp3UploadUrls.remove(str);
        }
    }

    private java.lang.String findPreparedMp3UploadUrl(java.lang.String str) {
        java.lang.String str2;
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return "";
        }
        synchronized (this.mp3UploadLock) {
            str2 = this.preparedMp3UploadUrls.get(str);
            if (str2 == null) {
                str2 = "";
            }
        }
        return str2;
    }

    private boolean markFallbackUploadStarted(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || str.equals(this.currentFallbackUploadAudioPracticeId)) {
            return false;
        }
        this.currentFallbackUploadAudioPracticeId = str;
        return true;
    }

    private void clearFallbackUpload(java.lang.String str) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(str) && str.equals(this.currentFallbackUploadAudioPracticeId)) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - clearFallbackUpload - clear current fallback upload, audioPracticeId=[" + str + "]");
            this.currentFallbackUploadAudioPracticeId = null;
        }
    }

    private com.alibaba.fastjson.JSONObject buildRecordInfo(com.up366.asecengine.englishengine.AsecSession asecSession, int i) {
        java.lang.String strResolveRecordId = resolveRecordId(asecSession);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("recordId", strResolveRecordId);
        jSONObject.put("state", java.lang.Integer.valueOf(i));
        jSONObject.put("duration", java.lang.Long.valueOf(asecSession == null ? 0L : asecSession.getDuration()));
        jSONObject.put("localPath", resolveLocalPath(asecSession, strResolveRecordId));
        if ((i == 5 || i == 8) && asecSession != null) {
            jSONObject.put("recordUrl", resolveRecordUrl(asecSession));
            if (!com.up366.common.StringUtils.isEmptyOrNull(asecSession.getAudioPracticeId())) {
                jSONObject.put("audioPracticeId", asecSession.getAudioPracticeId());
            }
        }
        com.alibaba.fastjson.JSONObject jSONObjectBuildErrorInfo = buildErrorInfo(asecSession, i);
        if (jSONObjectBuildErrorInfo != null) {
            jSONObject.put("errorInfo", jSONObjectBuildErrorInfo);
        }
        return jSONObject;
    }

    private com.alibaba.fastjson.JSONObject buildErrorInfo(com.up366.asecengine.englishengine.AsecSession asecSession, int i) {
        if (asecSession == null) {
            return null;
        }
        if (i != -1 && i != -2 && i != 7) {
            return null;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        int engineErrorCode = asecSession.getEngineErrorCode();
        if (engineErrorCode == 0) {
            engineErrorCode = asecSession.getCode();
        }
        jSONObject.put("code", java.lang.Integer.valueOf(engineErrorCode));
        jSONObject.put("msg", resolveErrorMessage(asecSession));
        return jSONObject;
    }

    private com.alibaba.fastjson.JSONObject parseResult(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession == null || com.up366.common.StringUtils.isEmptyOrNull(asecSession.getJsonResult())) {
            return new com.alibaba.fastjson.JSONObject();
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecSession.getJsonResult());
            return object == null ? new com.alibaba.fastjson.JSONObject() : object;
        } catch (java.lang.RuntimeException e) {
            com.up366.common.log.Logger.error("TAG - CommonRecordHelper - parseResult - invalid jsonResult, recordId=[" + resolveRecordId(asecSession) + "], jsonResult=[" + asecSession.getJsonResult() + "]", e);
            throw e;
        }
    }

    private java.lang.Integer mapJsState(int i, com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (i == -1) {
            return java.lang.Integer.valueOf(isRecordFailure(asecSession) ? -1 : -2);
        }
        if (i == 0) {
            return 0;
        }
        if (i != 99) {
            switch (i) {
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                default:
                    return null;
            }
        }
        return 4;
    }

    private boolean isRecordFailure(com.up366.asecengine.englishengine.AsecSession asecSession) {
        int code;
        return asecSession == null || (code = asecSession.getCode()) == -6 || code == -2 || code == -1 || code == 0;
    }

    private java.lang.String resolveRecordId(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession != null && !com.up366.common.StringUtils.isEmptyOrNull(asecSession.getRecordId())) {
            return asecSession.getRecordId();
        }
        com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest = this.currentRecordRequest;
        return startRecordRequest == null ? "" : startRecordRequest.recordId;
    }

    private java.lang.String resolveLocalPath(com.up366.asecengine.englishengine.AsecSession asecSession, java.lang.String str) {
        if (asecSession == null || com.up366.common.StringUtils.isEmptyOrNull(asecSession.getWavPath())) {
            return com.up366.common.StringUtils.isEmptyOrNull(str) ? "" : getRecordPath(str);
        }
        return asecSession.getWavPath();
    }

    private java.lang.String resolveRecordUrl(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession != null && !com.up366.common.StringUtils.isEmptyOrNull(asecSession.getMp3Path())) {
            java.lang.String strFindPreparedMp3UploadUrl = findPreparedMp3UploadUrl(asecSession.getAudioPracticeId());
            if (!com.up366.common.StringUtils.isEmptyOrNull(strFindPreparedMp3UploadUrl)) {
                return strFindPreparedMp3UploadUrl;
            }
            java.lang.String strBuildUploadTargetPath = com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.buildUploadTargetPath(asecSession.getMp3Path(), asecSession.getAudioPracticeId());
            if (com.up366.common.StringUtils.isEmptyOrNull(strBuildUploadTargetPath)) {
                return "";
            }
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSyncByPath = com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSyncByPath(strBuildUploadTargetPath);
            if (fileMapInfoLoadSyncByPath == null || com.up366.common.StringUtils.isEmptyOrNull(fileMapInfoLoadSyncByPath.getUrl())) {
                com.up366.common.log.Logger.error("TAG - CommonRecordHelper - resolveRecordUrl - load copied mp3 url failed, recordId=[" + resolveRecordId(asecSession) + "], audioPracticeId=[" + asecSession.getAudioPracticeId() + "], uploadCopyPath=[" + strBuildUploadTargetPath + "]");
            } else {
                return fileMapInfoLoadSyncByPath.getUrl();
            }
        }
        return "";
    }

    private void clearCurrentRecord(java.lang.String str) {
        com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest = this.currentRecordRequest;
        if (startRecordRequest != null && (com.up366.common.StringUtils.isEmptyOrNull(str) || str.equals(startRecordRequest.recordId))) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - clearCurrentRecord - clear current record, currentRecordId=[" + startRecordRequest.recordId + "], triggerRecordId=[" + str + "]");
            this.currentRecordRequest = null;
            return;
        }
        if (startRecordRequest != null) {
            com.up366.common.log.Logger.info("TAG - CommonRecordHelper - clearCurrentRecord - skip clear, currentRecordId=[" + startRecordRequest.recordId + "], triggerRecordId=[" + str + "]");
        }
    }

    private java.lang.String resolveErrorMessage(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (com.up366.common.StringUtils.isEmptyOrNull(asecSession.getOnlineMessage())) {
            return asecSession.getMessage() == null ? "" : asecSession.getMessage();
        }
        return asecSession.getOnlineMessage();
    }

    public static com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig buildWebSocketConfig() {
        java.lang.String str = com.up366.mobile.common.utils.PlatformUtils.getAppType() + "__6.0.1__" + com.up366.mobile.common.logic.Auth.UID();
        java.lang.String serverUrl = com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.common.http.HttpMgrUtils.ASES_ONLINE_SCORING_WS_URL);
        com.up366.common.log.Logger.info("TAG - CommonRecordHelper - buildWebSocketConfig - url=[" + serverUrl + "], connectionIdPrefix=[" + str + "], connectTimeoutMs=[3000]");
        return new com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig().setWebSocketUrl(serverUrl).setConnectionIdPrefix(str).setConnectTimeoutMs(3000L);
    }

    private java.lang.String buildStartRequestSummary(com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest startRecordRequest) {
        return "recordId=[" + startRecordRequest.recordId + "], fftStyle=[" + startRecordRequest.fftStyle + "], samplingRate=[" + startRecordRequest.samplingRate + "], scoringType=[" + startRecordRequest.scoringType + "], hasOnlineScoringParameters=[" + ((startRecordRequest.onlineScoringParameters == null || startRecordRequest.onlineScoringParameters.isEmpty()) ? false : true) + "]";
    }

    private java.lang.String buildSessionSummary(com.up366.asecengine.englishengine.AsecSession asecSession) {
        if (asecSession == null) {
            return com.igexin.push.core.b.m;
        }
        java.lang.String jsonResult = asecSession.getJsonResult();
        return "{recordId=[" + asecSession.getRecordId() + "], code=[" + asecSession.getCode() + "], engineErrorCode=[" + asecSession.getEngineErrorCode() + "], duration=[" + asecSession.getDuration() + "], wavPath=[" + asecSession.getWavPath() + "], mp3Path=[" + asecSession.getMp3Path() + "], audioPracticeId=[" + asecSession.getAudioPracticeId() + "], message=[" + asecSession.getMessage() + "], onlineMessage=[" + asecSession.getOnlineMessage() + "], jsonResultLength=[" + (com.up366.common.StringUtils.isEmptyOrNull(jsonResult) ? 0 : jsonResult.length()) + "]}";
    }

    private com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest parseStartRecordRequest(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        if (object == null) {
            throw new java.lang.IllegalArgumentException("startRecordV2 参数不能为空");
        }
        java.lang.String string = object.getString("recordId");
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            throw new java.lang.IllegalArgumentException("recordId 不能为空");
        }
        int intValue = object.containsKey("fftStyle") ? object.getIntValue("fftStyle") : 0;
        if (intValue != 0 && intValue != 1 && intValue != 2) {
            throw new java.lang.IllegalArgumentException("fftStyle 仅支持 0 / 1 / 2");
        }
        int intValue2 = object.containsKey("samplingRate") ? object.getIntValue("samplingRate") : 12;
        int i = intValue2 <= 0 ? 12 : intValue2;
        int intValue3 = object.containsKey("scoringType") ? object.getIntValue("scoringType") : 0;
        if (intValue3 < 0 || intValue3 > 3) {
            throw new java.lang.IllegalArgumentException("scoringType 仅支持 0 / 1 / 2 / 3");
        }
        com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("onlineScoringParameters");
        if (requiresOnlineScoring(intValue3) && (jSONObject == null || jSONObject.isEmpty())) {
            throw new java.lang.IllegalArgumentException("onlineScoringParameters 不能为空");
        }
        return new com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StartRecordRequest(string, intValue, i, intValue3, jSONObject);
    }

    private com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StopRecordRequest parseStopRecordRequest(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        if (object == null) {
            throw new java.lang.IllegalArgumentException("stopRecordV2 参数不能为空");
        }
        java.lang.String string = object.getString("recordId");
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            throw new java.lang.IllegalArgumentException("recordId 不能为空");
        }
        return new com.up366.mobile.book.helper.recordv2.CommonRecordHelper.StopRecordRequest(string, object.containsKey("giveup") ? object.getIntValue("giveup") : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class StartRecordRequest {
        final int fftStyle;
        final com.alibaba.fastjson.JSONObject onlineScoringParameters;
        final java.lang.String recordId;
        final int samplingRate;
        final int scoringType;

        private StartRecordRequest(java.lang.String str, int i, int i2, int i3, com.alibaba.fastjson.JSONObject jSONObject) {
            this.recordId = str;
            this.fftStyle = i;
            this.samplingRate = i2;
            this.scoringType = i3;
            this.onlineScoringParameters = jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isOnlineOnly() {
            return this.scoringType == 0;
        }
    }

    private static final class StopRecordRequest {
        final int giveup;
        final java.lang.String recordId;

        private StopRecordRequest(java.lang.String str, int i) {
            this.recordId = str;
            this.giveup = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isGiveUp() {
            return this.giveup == 1;
        }
    }
}
