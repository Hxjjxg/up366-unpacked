package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RecordHelper {
    private final com.up366.mobile.book.exercise.js.PathHelper pathHelper;
    private final com.up366.mobile.book.exercise.js.RegisterHelper registerHelper;
    private com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public RecordHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.exercise.js.PathHelper pathHelper, com.up366.mobile.book.exercise.js.RegisterHelper registerHelper) {
        this.webView = studyPageWebView;
        this.pathHelper = pathHelper;
        this.registerHelper = registerHelper;
        this.speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(studyPageWebView.getContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startRecordWithParams(java.lang.String r18) {
        /*
            r17 = this;
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.fastjson.JSON.parseObject(r18)
            java.lang.String r1 = "recordName"
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r1 = "netFiles"
            java.lang.String r4 = r0.getString(r1)
            java.lang.String r1 = "partType"
            int r5 = r0.getIntValue(r1)
            java.lang.String r1 = "fingerprintPath"
            java.lang.String r13 = r0.getString(r1)
            java.lang.String r1 = "diff"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L29
            float r1 = r0.getFloatValue(r1)
            goto L2b
        L29:
            r1 = 1065353216(0x3f800000, float:1.0)
        L2b:
            r6 = r1
            java.lang.String r1 = "fftStyle"
            boolean r2 = r0.containsKey(r1)
            r7 = 1
            if (r2 == 0) goto L46
            int r1 = r0.getIntValue(r1)
            if (r1 != r7) goto L3d
            r2 = r7
            goto L3e
        L3d:
            r2 = 0
        L3e:
            r9 = 2
            if (r1 != r9) goto L44
            r1 = r2
            r9 = r7
            goto L48
        L44:
            r1 = r2
            goto L47
        L46:
            r1 = 0
        L47:
            r9 = 0
        L48:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.lang.String r2 = "fakeNetIndexes"
            boolean r10 = r0.containsKey(r2)
            if (r10 == 0) goto L79
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r10 = ","
            java.lang.String[] r10 = r2.split(r10)
            int r11 = r10.length
            r14 = 0
        L61:
            if (r14 >= r11) goto L79
            r15 = r10[r14]
            boolean r16 = com.up366.common.StringUtils.isEmptyOrNull(r2)
            if (r16 != 0) goto L75
            com.up366.asecengine.model.KeyValue r7 = new com.up366.asecengine.model.KeyValue
            java.lang.String r8 = "fake_net"
            r7.<init>(r8, r15)
            r12.add(r7)
        L75:
            int r14 = r14 + 1
            r7 = 1
            goto L61
        L79:
            java.lang.String r2 = "samplingRate"
            int r10 = r0.getIntValue(r2)
            java.lang.String r2 = "isAsyncAsec"
            boolean r7 = r0.containsKey(r2)
            if (r7 == 0) goto L8d
            int r2 = r0.getIntValue(r2)
            goto L8e
        L8d:
            r2 = 0
        L8e:
            if (r2 != 0) goto L92
            r11 = 1
            goto L93
        L92:
            r11 = 0
        L93:
            java.lang.String r2 = "cbType"
            boolean r7 = r0.containsKey(r2)
            if (r7 == 0) goto La2
            int r0 = r0.getIntValue(r2)
            r16 = r0
            goto La4
        La2:
            r16 = 0
        La4:
            r2 = r17
            r7 = r1
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r16
            r2.startRecordImpl(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.exercise.js.RecordHelper.startRecordWithParams(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startRecordWithParamsV2(java.lang.String r18) {
        /*
            r17 = this;
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.fastjson.JSON.parseObject(r18)
            java.lang.String r1 = "recordName"
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r1 = "netFiles"
            java.lang.String r4 = r0.getString(r1)
            java.lang.String r1 = "partType"
            int r5 = r0.getIntValue(r1)
            java.lang.String r1 = "fingerprintPath"
            java.lang.String r13 = r0.getString(r1)
            java.lang.String r1 = "diff"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L29
            float r1 = r0.getFloatValue(r1)
            goto L2b
        L29:
            r1 = 1065353216(0x3f800000, float:1.0)
        L2b:
            r6 = r1
            java.lang.String r1 = "fftStyle"
            boolean r2 = r0.containsKey(r1)
            r7 = 1
            if (r2 == 0) goto L46
            int r1 = r0.getIntValue(r1)
            if (r1 != r7) goto L3d
            r2 = r7
            goto L3e
        L3d:
            r2 = 0
        L3e:
            r9 = 2
            if (r1 != r9) goto L44
            r1 = r2
            r9 = r7
            goto L48
        L44:
            r1 = r2
            goto L47
        L46:
            r1 = 0
        L47:
            r9 = 0
        L48:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.lang.String r2 = "fakeNetIndexes"
            boolean r10 = r0.containsKey(r2)
            if (r10 == 0) goto L79
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r10 = ","
            java.lang.String[] r10 = r2.split(r10)
            int r11 = r10.length
            r14 = 0
        L61:
            if (r14 >= r11) goto L79
            r15 = r10[r14]
            boolean r16 = com.up366.common.StringUtils.isEmptyOrNull(r2)
            if (r16 != 0) goto L75
            com.up366.asecengine.model.KeyValue r7 = new com.up366.asecengine.model.KeyValue
            java.lang.String r8 = "fake_net"
            r7.<init>(r8, r15)
            r12.add(r7)
        L75:
            int r14 = r14 + 1
            r7 = 1
            goto L61
        L79:
            java.lang.String r2 = "samplingRate"
            int r10 = r0.getIntValue(r2)
            java.lang.String r2 = "isAsyncAsec"
            boolean r7 = r0.containsKey(r2)
            if (r7 == 0) goto L8d
            int r2 = r0.getIntValue(r2)
            goto L8e
        L8d:
            r2 = 0
        L8e:
            if (r2 != 0) goto L92
            r11 = 1
            goto L93
        L92:
            r11 = 0
        L93:
            java.lang.String r2 = "cbType"
            boolean r7 = r0.containsKey(r2)
            if (r7 == 0) goto La2
            int r0 = r0.getIntValue(r2)
            r16 = r0
            goto La4
        La2:
            r16 = 0
        La4:
            r2 = r17
            r7 = r1
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r16
            r2.startRecordImpl(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.exercise.js.RecordHelper.startRecordWithParamsV2(java.lang.String):void");
    }

    private void startRecordImpl(final java.lang.String str, java.lang.String str2, int i, float f, boolean z, boolean z2, final int i2, boolean z3, final int i3, java.util.List<com.up366.asecengine.model.KeyValue> list, java.lang.String str3) {
        com.up366.common.log.Logger.debug("SSSSS - startRecordImpl recordId:" + str + " netFile:" + str2 + " recordType : " + i + " diff : " + f + " isFFT : " + z + " barNum : " + i2);
        java.lang.String voiceRecordPath = this.pathHelper.getVoiceRecordPath(str);
        java.lang.String currentPath = this.pathHelper.getCurrentPath();
        this.speechRecordHelper.setPartAScoreFactor(f);
        this.speechRecordHelper.setCallBack(new com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack() { // from class: com.up366.mobile.book.exercise.js.RecordHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack
            public final void onResult(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
                this.f$0.lambda$startRecordImpl$0(i3, asecCallbackDataHolder);
            }
        });
        this.speechRecordHelper.startRecord(str, str2, i, voiceRecordPath, currentPath, z ? new com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener() { // from class: com.up366.mobile.book.exercise.js.RecordHelper$$ExternalSyntheticLambda1
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener
            public final void update(byte[] bArr, int i4) {
                this.f$0.lambda$startRecordImpl$1(str, bArr, i4);
            }
        } : null, z2 ? new com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener() { // from class: com.up366.mobile.book.exercise.js.RecordHelper$$ExternalSyntheticLambda2
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener
            public final void update(byte[] bArr) {
                this.f$0.lambda$startRecordImpl$2(i2, str, bArr);
            }
        } : null, z3, i3, list, i2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$0(int i, com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
        int i2;
        if (!this.registerHelper.hasRegister(com.up366.mobile.book.exercise.js.RegisterHelper.EVENT_RECORD_STATE_CHANGE) && !this.registerHelper.hasRegister(com.up366.mobile.book.exercise.js.RegisterHelper.EVENT_RECORD_STATE_CHANGEV1)) {
            com.up366.common.log.Logger.info("RecordHelper - not register event : recorderstatechange");
            com.up366.common.log.Logger.info("RecordHelper - not register event : recorderstatechangev1");
            return;
        }
        int i3 = asecCallbackDataHolder.rawState;
        if (i3 == -1) {
            i2 = 3;
        } else if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 99) {
                        return;
                    }
                    i2 = 3;
                }
            } else if (!asecCallbackDataHolder.session.isAsync()) {
                i2 = 1;
            }
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (i == 0) {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("recordName", asecCallbackDataHolder.recordName);
            jSONObject.put("state", java.lang.Integer.valueOf(i2));
            jSONObject.put("result", asecCallbackDataHolder.result);
            jSONObject.put("score", java.lang.Float.valueOf(asecCallbackDataHolder.score100));
            jSONObject.put("rejectScore", java.lang.Float.valueOf(asecCallbackDataHolder.score100));
            jSONObject.put("recordUrl", asecCallbackDataHolder.recordUrl);
            jSONObject.put("duration", java.lang.Long.valueOf(asecCallbackDataHolder.duration));
            if (-1 == asecCallbackDataHolder.rawState && !com.up366.common.StringUtils.isEmptyOrNull(asecCallbackDataHolder.session.getMessage())) {
                com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, asecCallbackDataHolder.session.getMessage());
            }
            this.registerHelper.callJsEvent(com.up366.mobile.book.exercise.js.RegisterHelper.EVENT_RECORD_STATE_CHANGE, "(%s)", jSONObject.toJSONString());
            return;
        }
        if (i == 1) {
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put("recordName", asecCallbackDataHolder.recordName);
            jSONObject2.put("state", java.lang.Integer.valueOf(i2));
            jSONObject2.put("duration", java.lang.Long.valueOf(asecCallbackDataHolder.duration));
            jSONObject2.put("recordUrl", asecCallbackDataHolder.recordUrl);
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecCallbackDataHolder.session.getJsonResult());
            if (object == null) {
                object = new com.alibaba.fastjson.JSONObject();
            }
            this.registerHelper.callJsEvent(com.up366.mobile.book.exercise.js.RegisterHelper.EVENT_RECORD_STATE_CHANGEV1, "(%s,%s)", jSONObject2.toJSONString(), object.toJSONString());
            if (asecCallbackDataHolder.rawState == -1) {
                jSONObject2.put("state", -1);
                jSONObject2.put("msg", asecCallbackDataHolder.session.getMessage());
                this.registerHelper.callJsEvent(com.up366.mobile.book.exercise.js.RegisterHelper.EVENT_RECORD_STATE_CHANGEV1, "(%s,%s)", jSONObject2.toJSONString(), object.toJSONString());
                return;
            }
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, "cbType 类型错误：" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$1(java.lang.String str, byte[] bArr, int i) {
        if (this.registerHelper.hasRegister("recordfftupdate")) {
            this.registerHelper.callJsEvent("recordfftupdate", "('%s', %s)", str, java.util.Arrays.toString(bArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$2(int i, java.lang.String str, byte[] bArr) {
        if (i < 0 || i > 2048) {
            i = 1024;
        }
        byte[] bArr2 = new byte[i];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
        if (this.registerHelper.hasRegister("recordfftupdate")) {
            this.registerHelper.callJsEvent("recordfftupdate", "('%s', %s)", str, java.util.Arrays.toString(bArr2));
        }
    }

    public void endRecord(java.lang.String str) {
        this.speechRecordHelper.endRecord(str);
    }

    public void forceStopAll() {
        this.speechRecordHelper.forceStopAll();
    }
}
