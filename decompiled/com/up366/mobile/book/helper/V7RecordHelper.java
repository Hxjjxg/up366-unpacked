package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7RecordHelper {
    static final int JS_STATE_FORCE_OVER = 4;
    static final int JS_STATE_RECORDING = 0;
    static final int JS_STATE_RECORD_FAILED = -1;
    static final int JS_STATE_RECORD_OVER = 3;
    static final int JS_STATE_RECORD_SUCCESS = 1;
    static final int JS_STATE_SCORE_FAILED = -2;
    static final int JS_STATE_SCORING = 2;
    protected com.up366.mobile.book.helper.V7ChapterDataHelper dataHelper;
    protected com.up366.mobile.book.model.CatalogPage page;
    private final com.up366.mobile.book.helper.V7RegisterHelper registerHelper;
    protected com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    protected com.up366.mobile.book.webview.StudyPageWebView webView;

    public V7RecordHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V7ChapterDataHelper v7ChapterDataHelper, com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper, com.up366.mobile.book.helper.V7RegisterHelper v7RegisterHelper) {
        this.webView = studyPageWebView;
        this.dataHelper = v7ChapterDataHelper;
        this.page = catalogPage;
        this.speechRecordHelper = speechRecordHelper;
        this.registerHelper = v7RegisterHelper;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startRecordWithParamsV2(java.lang.String r19) {
        /*
            r18 = this;
            com.up366.mobile.book.helper.Tools$StudyTrackContext r0 = com.up366.mobile.book.helper.Tools.alarmLogTrackContext
            r1 = r19
            r0.params = r1
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.fastjson.JSON.parseObject(r19)
            java.lang.String r1 = "recordId"
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r1 = "netFiles"
            java.lang.String r4 = r0.getString(r1)
            java.lang.String r1 = "partType"
            int r5 = r0.getIntValue(r1)
            java.lang.String r1 = "fingerprintPath"
            java.lang.String r12 = r0.getString(r1)
            java.lang.String r1 = "diff"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L2f
            float r1 = r0.getFloatValue(r1)
            goto L31
        L2f:
            r1 = 1065353216(0x3f800000, float:1.0)
        L31:
            r6 = r1
            java.lang.String r1 = "fftStyle"
            boolean r2 = r0.containsKey(r1)
            r7 = 1
            if (r2 == 0) goto L4c
            int r1 = r0.getIntValue(r1)
            if (r1 != r7) goto L43
            r2 = r7
            goto L44
        L43:
            r2 = 0
        L44:
            r9 = 2
            if (r1 != r9) goto L4a
            r1 = r2
            r9 = r7
            goto L4e
        L4a:
            r1 = r2
            goto L4d
        L4c:
            r1 = 0
        L4d:
            r9 = 0
        L4e:
            java.lang.String r2 = "samplingRate"
            int r10 = r0.getIntValue(r2)
            java.lang.String r2 = "isAsyncAsec"
            boolean r11 = r0.containsKey(r2)
            if (r11 == 0) goto L66
            java.lang.Boolean r2 = r0.getBoolean(r2)
            boolean r2 = r2.booleanValue()
            goto L67
        L66:
            r2 = 0
        L67:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.lang.String r13 = "fakeNetIndexes"
            boolean r14 = r0.containsKey(r13)
            if (r14 == 0) goto La5
            java.lang.String r13 = r0.getString(r13)
            java.lang.String r14 = ","
            java.lang.String[] r14 = r13.split(r14)
            int r15 = r14.length
            r8 = 0
        L80:
            if (r8 >= r15) goto La5
            r7 = r14[r8]
            boolean r16 = com.up366.common.StringUtils.isEmptyOrNull(r13)
            if (r16 != 0) goto L99
            r16 = r13
            com.up366.asecengine.model.KeyValue r13 = new com.up366.asecengine.model.KeyValue
            r17 = r14
            java.lang.String r14 = "fake_net"
            r13.<init>(r14, r7)
            r11.add(r13)
            goto L9d
        L99:
            r16 = r13
            r17 = r14
        L9d:
            int r8 = r8 + 1
            r13 = r16
            r14 = r17
            r7 = 1
            goto L80
        La5:
            r13 = r2 ^ 1
            java.lang.String r2 = "isEngineErrorSupported"
            boolean r7 = r0.containsKey(r2)
            if (r7 == 0) goto Lb8
            java.lang.Boolean r0 = r0.getBoolean(r2)
            boolean r0 = r0.booleanValue()
            goto Lb9
        Lb8:
            r0 = 0
        Lb9:
            r2 = r18
            r7 = r1
            r8 = r9
            r9 = r10
            r10 = r13
            r13 = r0
            r2.startRecordImpl(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.V7RecordHelper.startRecordWithParamsV2(java.lang.String):void");
    }

    private void startRecordImpl(final java.lang.String str, java.lang.String str2, int i, float f, boolean z, boolean z2, final int i2, boolean z3, java.util.List<com.up366.asecengine.model.KeyValue> list, java.lang.String str3, final boolean z4) {
        com.up366.common.log.Logger.info("TAG - V7RecordHelper - startRecordImpl - recordId = [" + str + "], netFile = [" + str2 + "], recordType = [" + i + "], diff = [" + f + "], isFFT = [" + z + "], isWave = [" + z2 + "], barNum = [" + i2 + "], isSync = [" + z3 + "]");
        java.lang.String recordPath = getRecordPath(str);
        this.speechRecordHelper.setPartAScoreFactor(f);
        final com.up366.asecengine.englishengine.AsecSession[] asecSessionArr = new com.up366.asecengine.englishengine.AsecSession[1];
        this.speechRecordHelper.setCallBack(new com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack() { // from class: com.up366.mobile.book.helper.V7RecordHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack
            public final void onResult(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
                this.f$0.lambda$startRecordImpl$0(asecSessionArr, z4, asecCallbackDataHolder);
            }
        });
        this.speechRecordHelper.startRecord(str, str2, i, recordPath, getCurrentPath(), z ? new com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener() { // from class: com.up366.mobile.book.helper.V7RecordHelper$$ExternalSyntheticLambda1
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener
            public final void update(byte[] bArr, int i3) {
                this.f$0.lambda$startRecordImpl$1(str, asecSessionArr, bArr, i3);
            }
        } : null, z2 ? new com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener() { // from class: com.up366.mobile.book.helper.V7RecordHelper$$ExternalSyntheticLambda2
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener
            public final void update(byte[] bArr) {
                this.f$0.lambda$startRecordImpl$2(i2, str, bArr);
            }
        } : null, z3, 1, list, i2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$0(com.up366.asecengine.englishengine.AsecSession[] asecSessionArr, boolean z, com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
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
            int engineErrorCode = asecCallbackDataHolder.session.getEngineErrorCode();
            com.up366.common.log.Logger.info("TAG - V7RecordHelper - engineErrorCode = " + engineErrorCode);
            if (z && engineErrorCode != 0) {
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
        this.registerHelper.callJsEvent("recordstatechange", "(%s)", jSONObject3.toJSONString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$1(java.lang.String str, com.up366.asecengine.englishengine.AsecSession[] asecSessionArr, byte[] bArr, int i) {
        com.alibaba.fastjson.JSONObject jSONObject;
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
        this.registerHelper.callJsEvent("recordfftupdate", "(%s)", jSONObject.toJSONString());
    }

    public java.lang.String getRecordPath(java.lang.String str) {
        com.up366.mobile.book.model.CatalogPage catalogPage = this.page;
        if (catalogPage == null) {
            return com.up366.common.FileUtilsUp.join(this.dataHelper.getBookDataPath(), "catalog", str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
        }
        return com.up366.common.FileUtilsUp.join(this.dataHelper.getChapterRootDataDir(catalogPage), this.page.obj.getId(), str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
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
            com.up366.common.log.Logger.error("TAG - V6RecordHelper - getAsecResult - 没有找到录音记录 recordId:" + str);
            return buildErrorResult(str, -3002, "没有找到录音记录");
        }
        if (asecSessionModelFindByRecordId.getState() == 3) {
            com.up366.common.log.Logger.error("TAG - V6RecordHelper - getAsecResult - 录音评分失败 recordId:" + str + "  model:" + com.alibaba.fastjson.JSON.toJSONString(asecSessionModelFindByRecordId));
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
            jSONObject.put("result", com.alibaba.fastjson.JSON.parse(object.getString("result")));
            return jSONObject.toJSONString();
        }
        com.up366.common.log.Logger.error("录音记录状态错误：" + com.alibaba.fastjson.JSON.toJSONString(asecSessionModelFindByRecordId));
        return buildErrorResult(str, -3099, "录音记录状态错误");
    }

    private java.lang.String buildErrorResult(java.lang.String str, int i, java.lang.String str2) {
        return "{\n    \"code\": " + i + ",\n    \"duration\": 0,\n    \"result\": {},\n    \"msg\": \"" + str2 + "\",\n    \"uploadURL\": \"\"\n}";
    }

    public void deleteByRecordId(java.lang.String str) {
        this.speechRecordHelper.deleteByRecordId(str);
    }
}
