package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V9RecordHelper {
    static final int JS_STATE_FORCE_OVER = 4;
    static final int JS_STATE_RECORDING = 0;
    static final int JS_STATE_RECORD_FAILED = -1;
    static final int JS_STATE_RECORD_OVER = 3;
    static final int JS_STATE_RECORD_SUCCESS = 1;
    static final int JS_STATE_SCORE_FAILED = -2;
    static final int JS_STATE_SCORING = 2;
    protected com.up366.mobile.book.model.CatalogPage page;
    private final com.up366.mobile.book.helper.V9RegisterHelper registerHelper;
    protected com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    protected com.up366.mobile.book.webview.StudyPageWebView webView;

    public V9RecordHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper, com.up366.mobile.book.helper.V9RegisterHelper v9RegisterHelper) {
        this.webView = studyPageWebView;
        this.speechRecordHelper = speechRecordHelper;
        this.registerHelper = v9RegisterHelper;
    }

    public void startRecordWithParamsV2(java.lang.String str) {
        boolean z;
        boolean z2;
        java.lang.String str2;
        java.lang.String[] strArr;
        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = str;
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("recordId");
        java.lang.String string2 = object.getString("netFiles");
        int intValue = object.getIntValue("partType");
        java.lang.String string3 = object.getString("fingerprintPath");
        float floatValue = object.containsKey("diff") ? object.getFloatValue("diff") : 1.0f;
        int i = 0;
        if (object.containsKey("fftStyle")) {
            int intValue2 = object.getIntValue("fftStyle");
            boolean z3 = intValue2 == 1;
            if (intValue2 == 2) {
                z = z3;
                z2 = true;
            } else {
                z = z3;
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
                    strArr = strArrSplit;
                } else {
                    str2 = string4;
                    strArr = strArrSplit;
                    arrayList.add(new com.up366.asecengine.model.KeyValue("fake_net", str3));
                }
                i++;
                string4 = str2;
                strArrSplit = strArr;
            }
        }
        startRecordImpl(string, string2, intValue, floatValue, z, z2, intValue3, true ^ zBooleanValue, arrayList, string3, object.getBooleanValue("vad"));
    }

    private void startRecordImpl(final java.lang.String str, java.lang.String str2, int i, float f, boolean z, boolean z2, int i2, boolean z3, java.util.List<com.up366.asecengine.model.KeyValue> list, java.lang.String str3, final boolean z4) {
        java.lang.String v9RootResourceDir;
        com.up366.common.log.Logger.info("TAG - V9RecordHelper - startRecordImpl - recordId = [" + str + "], netFile = [" + str2 + "], recordType = [" + i + "], diff = [" + f + "], isFFT = [" + z + "], isWave = [" + z2 + "], barNum = [" + i2 + "], isSync = [" + z3 + "], vad = [" + z4 + "]");
        java.lang.String recordPath = getRecordPath(str);
        this.speechRecordHelper.setPartAScoreFactor(f);
        final com.up366.asecengine.englishengine.AsecSession[] asecSessionArr = new com.up366.asecengine.englishengine.AsecSession[1];
        this.speechRecordHelper.setCallBack(new com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack() { // from class: com.up366.mobile.book.helper.V9RecordHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack
            public final void onResult(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
                this.f$0.lambda$startRecordImpl$0(asecSessionArr, asecCallbackDataHolder);
            }
        });
        com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener iFFTUpdateListener = z ? new com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener() { // from class: com.up366.mobile.book.helper.V9RecordHelper$$ExternalSyntheticLambda1
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener
            public final void update(byte[] bArr, int i3) {
                this.f$0.lambda$startRecordImpl$1(str, z4, asecSessionArr, bArr, i3);
            }
        } : null;
        com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener iWaveUpdateListener = z2 ? new com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener() { // from class: com.up366.mobile.book.helper.V9RecordHelper$$ExternalSyntheticLambda2
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener
            public final void update(byte[] bArr) {
                this.f$0.lambda$startRecordImpl$2(str, z4, asecSessionArr, bArr);
            }
        } : null;
        if (str2.contains(com.up366.mobile.book.helper.V9FilePathHelper.getV9RootResourceDir())) {
            v9RootResourceDir = "";
        } else {
            v9RootResourceDir = com.up366.mobile.book.helper.V9FilePathHelper.getV9RootResourceDir();
        }
        this.speechRecordHelper.startRecord(str, str2, i, recordPath, v9RootResourceDir, iFFTUpdateListener, iWaveUpdateListener, z3, 1, list, i2, str3);
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
        jSONObject.put("localPath", asecCallbackDataHolder.session.getWavPath());
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecCallbackDataHolder.session.getJsonResult());
        if (object == null) {
            object = new com.alibaba.fastjson.JSONObject();
        }
        if (i == -1 || i == -2) {
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            int engineErrorCode = asecCallbackDataHolder.session.getEngineErrorCode();
            com.up366.common.log.Logger.info("TAG - V9RecordHelper - engineErrorCode = " + engineErrorCode);
            if (engineErrorCode != 0) {
                jSONObject2.put("code", java.lang.Integer.valueOf(engineErrorCode));
                jSONObject2.put("msg", com.up366.mobile.book.helper.AsesConfigHelper.getConfigErrorMsg(engineErrorCode));
            } else {
                jSONObject2.put("code", java.lang.Integer.valueOf(asecCallbackDataHolder.session.getCode()));
                jSONObject2.put("msg", asecCallbackDataHolder.session.getMessage());
            }
            jSONObject.put("errorInfo", jSONObject2);
        }
        com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
        jSONObject3.put("recordInfo", jSONObject);
        jSONObject3.put("result", object);
        this.registerHelper.callJsEvent("recordStateChange", "(%s)", jSONObject3.toJSONString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$1(java.lang.String str, boolean z, com.up366.asecengine.englishengine.AsecSession[] asecSessionArr, byte[] bArr, int i) {
        com.alibaba.fastjson.JSONObject jSONObject;
        int[] iArr = new int[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            iArr[i2] = bArr[i2];
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("recordId", str);
        jSONObject2.put("datas", iArr);
        if (z) {
            jSONObject2.put("audio_quality", java.lang.Integer.valueOf(i));
            com.up366.asecengine.englishengine.AsecSession asecSession = asecSessionArr[0];
            if (asecSession != null) {
                jSONObject = com.alibaba.fastjson.JSON.parseObject(asecSession.getWavCheckerJsonResult());
            } else {
                jSONObject = new com.alibaba.fastjson.JSONObject();
            }
            jSONObject2.put("WavcheckerResult", jSONObject);
        }
        this.registerHelper.callJsEvent("recordFFTUpdate", "(%s)", jSONObject2.toJSONString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$2(java.lang.String str, boolean z, com.up366.asecengine.englishengine.AsecSession[] asecSessionArr, byte[] bArr) {
        com.alibaba.fastjson.JSONObject jSONObject;
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = bArr[i];
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("recordId", str);
        jSONObject2.put("datas", iArr);
        if (z) {
            jSONObject2.put("audio_quality", 1);
            com.up366.asecengine.englishengine.AsecSession asecSession = asecSessionArr[0];
            if (asecSession != null) {
                jSONObject = com.alibaba.fastjson.JSON.parseObject(asecSession.getWavCheckerJsonResult());
            } else {
                jSONObject = new com.alibaba.fastjson.JSONObject();
            }
            jSONObject2.put("WavcheckerResult", jSONObject);
        }
        this.registerHelper.callJsEvent("recordFFTUpdate", "(%s)", jSONObject2.toJSONString());
    }

    public java.lang.String getRecordPath(java.lang.String str) {
        return com.up366.mobile.book.helper.V9FilePathHelper.getRecordPath(str);
    }

    public void endRecord(java.lang.String str) {
        this.speechRecordHelper.endRecord(str);
    }

    public void forceStopAll() {
        this.speechRecordHelper.forceStopAll();
    }

    protected java.lang.String getCurrentPath() {
        return this.webView.getCurrentDir();
    }

    public java.lang.String getAsecResult(java.lang.String str) {
        com.up366.mobile.book.helper.recorder.AsecSessionModel asecSessionModelFindByRecordId = this.speechRecordHelper.findByRecordId(str);
        if (asecSessionModelFindByRecordId == null) {
            com.up366.common.log.Logger.error("TAG - V9RecordHelper - getAsecResult - 没有找到录音记录 recordId:" + str);
            return buildErrorResult(str, -3002, "没有找到录音记录");
        }
        if (asecSessionModelFindByRecordId.getState() == 3) {
            com.up366.common.log.Logger.error("TAG - V9RecordHelper - getAsecResult - 录音评分失败 recordId:" + str + "  model:" + com.alibaba.fastjson.JSON.toJSONString(asecSessionModelFindByRecordId));
            return buildErrorResult(str, -3099, "录音评分失败");
        }
        if (asecSessionModelFindByRecordId.getState() == 0 || asecSessionModelFindByRecordId.getState() == 1) {
            return buildErrorResult(str, 100, "评分中");
        }
        if (asecSessionModelFindByRecordId.getState() == 2) {
            com.up366.common.log.Logger.info("STATE_SUCCESS getAsecResult - " + asecSessionModelFindByRecordId.getResult());
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecSessionModelFindByRecordId.getResult());
            jSONObject.put("code", java.lang.Integer.valueOf(object.getIntValue("code")));
            jSONObject.put("uploadURL", object.getString("uploadURL"));
            jSONObject.put("duration", java.lang.Integer.valueOf(object.getIntValue("durationInMs")));
            jSONObject.put("msg", "");
            jSONObject.put("localPath", asecSessionModelFindByRecordId.getWavPath());
            jSONObject.put("result", com.alibaba.fastjson.JSON.parse(object.getString("result")));
            return jSONObject.toJSONString();
        }
        com.up366.common.log.Logger.error("录音记录状态错误：" + com.alibaba.fastjson.JSON.toJSONString(asecSessionModelFindByRecordId));
        return buildErrorResult(str, -3099, "录音记录状态错误");
    }

    private java.lang.String buildErrorResult(java.lang.String str, int i, java.lang.String str2) {
        return "{\n    \"code\": " + i + ",\n    \"duration\": 0,\n    \"result\": {},\n    \"msg\": \"" + str2 + "\",\n    \"localPath\": \"\",\n    \"uploadURL\": \"\"\n}";
    }

    public void deleteByRecordId(java.lang.String str) {
        this.speechRecordHelper.deleteByRecordId(str);
    }
}
