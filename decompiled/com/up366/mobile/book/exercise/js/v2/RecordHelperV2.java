package com.up366.mobile.book.exercise.js.v2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RecordHelperV2 {
    static final int JS_STATE_FORCE_OVER = 4;
    static final int JS_STATE_RECORDING = 0;
    static final int JS_STATE_RECORD_FAILED = -1;
    static final int JS_STATE_RECORD_OVER = 3;
    static final int JS_STATE_RECORD_SUCCESS = 1;
    static final int JS_STATE_SCORE_FAILED = -2;
    static final int JS_STATE_SCORING = 2;
    private final com.up366.mobile.book.exercise.js.PathHelper pathHelper;
    private final com.up366.mobile.book.exercise.js.v2.RegisterHelperV2 registerHelper;
    private com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public RecordHelperV2(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.exercise.js.PathHelper pathHelper, com.up366.mobile.book.exercise.js.v2.RegisterHelperV2 registerHelperV2) {
        this.webView = studyPageWebView;
        this.pathHelper = pathHelper;
        this.registerHelper = registerHelperV2;
        this.speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(studyPageWebView.getContext());
    }

    public void startRecordWithParamsV2(java.lang.String str) {
        boolean z;
        boolean z2;
        java.lang.String str2;
        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = str;
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("recordId");
        java.lang.String string2 = object.getString("netFiles");
        int intValue = object.getIntValue("partType");
        java.lang.String string3 = object.getString("fingerprintPath");
        float floatValue = object.containsKey("diff") ? object.getFloatValue("diff") : 1.0f;
        int i = 0;
        boolean z3 = true;
        if (object.containsKey("fftStyle")) {
            int intValue2 = object.getIntValue("fftStyle");
            boolean z4 = intValue2 == 1;
            if (intValue2 == 2) {
                z = z4;
                z2 = true;
            } else {
                z = z4;
                z2 = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        int intValue3 = object.getIntValue("samplingRate");
        boolean zBooleanValue = object.containsKey("isAsyncAsec") ? object.getBoolean("isAsyncAsec").booleanValue() : false;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (object.containsKey("fakeNetIndexes")) {
            java.lang.String string4 = object.getString("fakeNetIndexes");
            java.lang.String[] strArrSplit = string4.split(com.igexin.push.core.b.an);
            int length = strArrSplit.length;
            while (i < length) {
                java.lang.String str3 = strArrSplit[i];
                if (com.up366.common.StringUtils.isEmptyOrNull(string4)) {
                    str2 = string4;
                } else {
                    str2 = string4;
                    arrayList.add(new com.up366.asecengine.model.KeyValue("fake_net", str3));
                }
                i++;
                string4 = str2;
                z3 = true;
            }
        }
        startRecordImpl(string, string2, intValue, floatValue, z, z2, intValue3, z3 ^ zBooleanValue, arrayList, string3);
    }

    private void startRecordImpl(final java.lang.String str, final java.lang.String str2, final int i, float f, boolean z, boolean z2, final int i2, final boolean z3, final java.util.List<com.up366.asecengine.model.KeyValue> list, final java.lang.String str3) {
        com.up366.common.log.Logger.debug("TAG - RecordHelperV2 - startRecordImpl recordId:" + str + " netFile:" + str2 + " recordType : " + i + " diff : " + f + " isFFT : " + z + " barNum : " + i2);
        final java.lang.String voiceRecordPath = this.pathHelper.getVoiceRecordPath(str);
        final java.lang.String currentPath = this.pathHelper.getCurrentPath();
        this.speechRecordHelper.setPartAScoreFactor(f);
        final com.up366.asecengine.englishengine.AsecSession[] asecSessionArr = new com.up366.asecengine.englishengine.AsecSession[1];
        this.speechRecordHelper.setCallBack(new com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack() { // from class: com.up366.mobile.book.exercise.js.v2.RecordHelperV2$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack
            public final void onResult(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
                this.f$0.lambda$startRecordImpl$0(asecSessionArr, asecCallbackDataHolder);
            }
        });
        final com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener iFFTUpdateListener = z ? new com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener() { // from class: com.up366.mobile.book.exercise.js.v2.RecordHelperV2$$ExternalSyntheticLambda1
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener
            public final void update(byte[] bArr, int i3) {
                this.f$0.lambda$startRecordImpl$1(str, asecSessionArr, bArr, i3);
            }
        } : null;
        final com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener iWaveUpdateListener = z2 ? new com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener() { // from class: com.up366.mobile.book.exercise.js.v2.RecordHelperV2$$ExternalSyntheticLambda2
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener
            public final void update(byte[] bArr) {
                this.f$0.lambda$startRecordImpl$2(i2, str, bArr);
            }
        } : null;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.RecordHelperV2$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$startRecordImpl$3(str, str2, i, voiceRecordPath, currentPath, iFFTUpdateListener, iWaveUpdateListener, z3, list, i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$0(com.up366.asecengine.englishengine.AsecSession[] asecSessionArr, com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
        int i;
        asecSessionArr[0] = asecCallbackDataHolder.session;
        int i2 = asecCallbackDataHolder.rawState;
        if (i2 == -1) {
            int code = asecCallbackDataHolder.session.getCode();
            i = (code == -6 || code == -2 || code == -1 || code == 0) ? -1 : -2;
        } else if (i2 != 0) {
            i = 2;
            if (i2 == 2) {
                i = 1;
            } else if (i2 != 3) {
                i = 4;
                if (i2 == 4) {
                    i = 3;
                } else if (i2 != 99) {
                    return;
                }
            }
        } else {
            i = 0;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("recordId", asecCallbackDataHolder.recordName);
        jSONObject.put("state", java.lang.Integer.valueOf(i));
        jSONObject.put("duration", java.lang.Long.valueOf(asecCallbackDataHolder.duration));
        jSONObject.put("recordUrl", asecCallbackDataHolder.recordUrl);
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecCallbackDataHolder.session.getJsonResult());
        if (object == null) {
            object = new com.alibaba.fastjson.JSONObject();
        }
        if (i == -1 || i == -2) {
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put("code", java.lang.Integer.valueOf(asecCallbackDataHolder.session.getCode()));
            jSONObject2.put("msg", asecCallbackDataHolder.session.getMessage());
            jSONObject.put("errorInfo", jSONObject2);
        }
        com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
        jSONObject3.put("recordInfo", jSONObject);
        jSONObject3.put("result", object);
        com.up366.common.log.Logger.info("RecodHelperV2 startRecordImpl recordstatechange result=" + jSONObject3.toJSONString());
        this.registerHelper.callJsEvent("recordstatechange", "(%s)", jSONObject3.toJSONString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$1(java.lang.String str, com.up366.asecengine.englishengine.AsecSession[] asecSessionArr, byte[] bArr, int i) {
        com.alibaba.fastjson.JSONObject jSONObject;
        if (this.registerHelper.hasRegister("recordfftupdate")) {
            int[] iArr = new int[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                iArr[i2] = bArr[i2];
            }
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put("recordId", str);
            jSONObject2.put("datas", iArr);
            jSONObject2.put("audio_quality", java.lang.Integer.valueOf(i));
            com.up366.asecengine.englishengine.AsecSession asecSession = asecSessionArr[0];
            if (asecSession != null) {
                jSONObject = com.alibaba.fastjson.JSON.parseObject(asecSession.getWavCheckerJsonResult());
            } else {
                jSONObject = new com.alibaba.fastjson.JSONObject();
            }
            jSONObject2.put("WavcheckerResult", jSONObject);
            this.registerHelper.callJsEvent("recordfftupdate", "(%s)", jSONObject2.toJSONString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$2(int i, java.lang.String str, byte[] bArr) {
        if (i >= 0) {
        }
        int[] iArr = new int[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            iArr[i2] = bArr[i2];
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("recordId", str);
        jSONObject.put("datas", iArr);
        if (this.registerHelper.hasRegister("recordfftupdate")) {
            this.registerHelper.callJsEvent("recordfftupdate", "(%s)", jSONObject.toJSONString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$3(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener iFFTUpdateListener, com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener iWaveUpdateListener, boolean z, java.util.List list, int i2, java.lang.String str5) throws java.lang.Exception {
        this.speechRecordHelper.startRecord(str, str2, i, str3, str4, iFFTUpdateListener, iWaveUpdateListener, z, 1, list, i2, str5);
    }

    public void endRecord(java.lang.String str) {
        this.speechRecordHelper.endRecord(str);
    }

    public void forceStopAll() {
        this.speechRecordHelper.forceStopAll();
    }
}
