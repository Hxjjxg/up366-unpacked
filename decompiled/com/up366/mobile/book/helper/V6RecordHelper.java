package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6RecordHelper {
    protected com.up366.mobile.book.helper.V6ChapterDataHelper dataHelper;
    protected com.up366.mobile.book.model.CatalogPage page;
    protected com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    protected com.up366.mobile.book.webview.StudyPageWebView webView;

    public V6RecordHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V6ChapterDataHelper v6ChapterDataHelper, com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper) {
        this.webView = studyPageWebView;
        this.dataHelper = v6ChapterDataHelper;
        this.page = catalogPage;
        this.speechRecordHelper = speechRecordHelper;
    }

    V6RecordHelper() {
    }

    public void startRecord(java.lang.String str, java.lang.String str2, int i) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("recordId", str);
        jSONObject.put("netFile", str2);
        jSONObject.put("recordType", java.lang.Integer.valueOf(i));
        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.params = jSONObject.toJSONString();
        startRecordImpl(str, str2, i, 1.0f, false, false, 0, true, 0, new java.util.ArrayList(), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startRecordWithParams(java.lang.String r20) {
        /*
            r19 = this;
            com.up366.mobile.book.helper.Tools$StudyTrackContext r0 = com.up366.mobile.book.helper.Tools.alarmLogTrackContext
            r1 = r20
            r0.params = r1
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.fastjson.JSON.parseObject(r20)
            java.lang.String r1 = "recordName"
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r1 = "netFiles"
            java.lang.String r4 = r0.getString(r1)
            java.lang.String r1 = "partType"
            int r5 = r0.getIntValue(r1)
            java.lang.String r1 = "fingerprintPath"
            java.lang.String r13 = r0.getString(r1)
            java.lang.String r1 = "cbType"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L30
            int r1 = r0.getIntValue(r1)
            r11 = r1
            goto L31
        L30:
            r11 = 0
        L31:
            java.lang.String r1 = "diff"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L3e
            float r1 = r0.getFloatValue(r1)
            goto L40
        L3e:
            r1 = 1065353216(0x3f800000, float:1.0)
        L40:
            java.lang.String r2 = "fftStyle"
            boolean r7 = r0.containsKey(r2)
            r8 = 1
            if (r7 == 0) goto L57
            int r2 = r0.getIntValue(r2)
            if (r2 != r8) goto L51
            r7 = r8
            goto L52
        L51:
            r7 = 0
        L52:
            r9 = 2
            if (r2 != r9) goto L58
            r9 = r8
            goto L59
        L57:
            r7 = 0
        L58:
            r9 = 0
        L59:
            java.lang.String r2 = "samplingRate"
            int r10 = r0.getIntValue(r2)
            java.lang.String r2 = "isAsyncAsec"
            boolean r12 = r0.containsKey(r2)
            if (r12 == 0) goto L6d
            int r2 = r0.getIntValue(r2)
            goto L6e
        L6d:
            r2 = 0
        L6e:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.lang.String r14 = "fakeNetIndexes"
            boolean r15 = r0.containsKey(r14)
            if (r15 == 0) goto Lac
            java.lang.String r0 = r0.getString(r14)
            java.lang.String r14 = ","
            java.lang.String[] r14 = r0.split(r14)
            int r15 = r14.length
            r6 = 0
        L87:
            if (r6 >= r15) goto Lac
            r8 = r14[r6]
            boolean r17 = com.up366.common.StringUtils.isEmptyOrNull(r0)
            if (r17 != 0) goto La0
            r17 = r0
            com.up366.asecengine.model.KeyValue r0 = new com.up366.asecengine.model.KeyValue
            r18 = r14
            java.lang.String r14 = "fake_net"
            r0.<init>(r14, r8)
            r12.add(r0)
            goto La4
        La0:
            r17 = r0
            r18 = r14
        La4:
            int r6 = r6 + 1
            r0 = r17
            r14 = r18
            r8 = 1
            goto L87
        Lac:
            if (r2 != 0) goto Lb1
            r16 = 1
            goto Lb3
        Lb1:
            r16 = 0
        Lb3:
            r2 = r19
            r6 = r1
            r8 = r9
            r9 = r10
            r10 = r16
            r2.startRecordImpl(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.V6RecordHelper.startRecordWithParams(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startRecordWithParamsV2(java.lang.String r20) {
        /*
            r19 = this;
            com.up366.mobile.book.helper.Tools$StudyTrackContext r0 = com.up366.mobile.book.helper.Tools.alarmLogTrackContext
            r1 = r20
            r0.params = r1
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.fastjson.JSON.parseObject(r20)
            java.lang.String r1 = "recordName"
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r1 = "netFiles"
            java.lang.String r4 = r0.getString(r1)
            java.lang.String r1 = "partType"
            int r5 = r0.getIntValue(r1)
            java.lang.String r1 = "fingerprintPath"
            java.lang.String r13 = r0.getString(r1)
            java.lang.String r1 = "cbType"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L30
            int r1 = r0.getIntValue(r1)
            r11 = r1
            goto L31
        L30:
            r11 = 0
        L31:
            java.lang.String r1 = "diff"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L3e
            float r1 = r0.getFloatValue(r1)
            goto L40
        L3e:
            r1 = 1065353216(0x3f800000, float:1.0)
        L40:
            java.lang.String r2 = "fftStyle"
            boolean r7 = r0.containsKey(r2)
            r8 = 1
            if (r7 == 0) goto L57
            int r2 = r0.getIntValue(r2)
            if (r2 != r8) goto L51
            r7 = r8
            goto L52
        L51:
            r7 = 0
        L52:
            r9 = 2
            if (r2 != r9) goto L58
            r9 = r8
            goto L59
        L57:
            r7 = 0
        L58:
            r9 = 0
        L59:
            java.lang.String r2 = "samplingRate"
            int r10 = r0.getIntValue(r2)
            java.lang.String r2 = "isAsyncAsec"
            boolean r12 = r0.containsKey(r2)
            if (r12 == 0) goto L6d
            int r2 = r0.getIntValue(r2)
            goto L6e
        L6d:
            r2 = 0
        L6e:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.lang.String r14 = "fakeNetIndexes"
            boolean r15 = r0.containsKey(r14)
            if (r15 == 0) goto Lac
            java.lang.String r0 = r0.getString(r14)
            java.lang.String r14 = ","
            java.lang.String[] r14 = r0.split(r14)
            int r15 = r14.length
            r6 = 0
        L87:
            if (r6 >= r15) goto Lac
            r8 = r14[r6]
            boolean r17 = com.up366.common.StringUtils.isEmptyOrNull(r0)
            if (r17 != 0) goto La0
            r17 = r0
            com.up366.asecengine.model.KeyValue r0 = new com.up366.asecengine.model.KeyValue
            r18 = r14
            java.lang.String r14 = "fake_net"
            r0.<init>(r14, r8)
            r12.add(r0)
            goto La4
        La0:
            r17 = r0
            r18 = r14
        La4:
            int r6 = r6 + 1
            r0 = r17
            r14 = r18
            r8 = 1
            goto L87
        Lac:
            if (r2 != 0) goto Lb1
            r16 = 1
            goto Lb3
        Lb1:
            r16 = 0
        Lb3:
            r2 = r19
            r6 = r1
            r8 = r9
            r9 = r10
            r10 = r16
            r2.startRecordImpl(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.V6RecordHelper.startRecordWithParamsV2(java.lang.String):void");
    }

    private void startRecordImpl(final java.lang.String str, java.lang.String str2, int i, float f, boolean z, boolean z2, final int i2, boolean z3, final int i3, java.util.List<com.up366.asecengine.model.KeyValue> list, java.lang.String str3) {
        com.up366.common.log.Logger.info("TAG - V6RecordHelper - startRecordImpl - recordId = [" + str + "], netFile = [" + str2 + "], recordType = [" + i + "], diff = [" + f + "], isFFT = [" + z + "], isWave = [" + z2 + "], barNum = [" + i2 + "], isSync = [" + z3 + "], cbType = [" + i3 + "], params = [" + list + "], fingerprintPath = [" + str3 + "]");
        java.lang.String recordPath = getRecordPath(str);
        this.speechRecordHelper.setPartAScoreFactor(f);
        final com.up366.asecengine.englishengine.AsecSession[] asecSessionArr = new com.up366.asecengine.englishengine.AsecSession[1];
        this.speechRecordHelper.setCallBack(new com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack() { // from class: com.up366.mobile.book.helper.V6RecordHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.recorder.SpeechRecordHelper.ICallBack
            public final void onResult(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
                this.f$0.lambda$startRecordImpl$0(asecSessionArr, i3, asecCallbackDataHolder);
            }
        });
        this.speechRecordHelper.startRecord(str, str2, i, recordPath, getCurrentPath(), z ? new com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener() { // from class: com.up366.mobile.book.helper.V6RecordHelper$$ExternalSyntheticLambda1
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IFFTUpdateListener
            public final void update(byte[] bArr, int i4) {
                this.f$0.lambda$startRecordImpl$1(asecSessionArr, str, bArr, i4);
            }
        } : null, z2 ? new com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener() { // from class: com.up366.mobile.book.helper.V6RecordHelper$$ExternalSyntheticLambda2
            @Override // com.up366.asecengine.englishengine.AsecEngineHelper.IWaveUpdateListener
            public final void update(byte[] bArr) {
                this.f$0.lambda$startRecordImpl$2(i2, str, bArr);
            }
        } : null, z3, i3, list, i2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$0(com.up366.asecengine.englishengine.AsecSession[] asecSessionArr, int i, com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
        int i2;
        asecSessionArr[0] = asecCallbackDataHolder.session;
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
            this.webView.callJSMethod("onRecorderStateChange('%s',%d,'%s',%s,%s,'%s',%d,{})", asecCallbackDataHolder.recordName, java.lang.Integer.valueOf(i2), asecCallbackDataHolder.result, java.lang.String.valueOf(asecCallbackDataHolder.score), java.lang.String.valueOf(asecCallbackDataHolder.score100), asecCallbackDataHolder.recordUrl, java.lang.Long.valueOf(asecCallbackDataHolder.duration));
            if (asecCallbackDataHolder.rawState == -1) {
                com.up366.mobile.common.utils.ToastPopupUtil.showError(this.webView, "启动录音失败：" + asecCallbackDataHolder.session.getMessage());
                this.webView.callJSMethod("onRecorderStateChange('%s',%d,'%s',%s,%s,'%s',%d,{})", asecCallbackDataHolder.recordName, -1, asecCallbackDataHolder.result, java.lang.String.valueOf(asecCallbackDataHolder.score), java.lang.String.valueOf(asecCallbackDataHolder.score100), asecCallbackDataHolder.recordUrl, java.lang.Long.valueOf(asecCallbackDataHolder.duration));
                return;
            }
            return;
        }
        if (i == 1) {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("recordName", asecCallbackDataHolder.recordName);
            jSONObject.put("state", java.lang.Integer.valueOf(i2));
            jSONObject.put("duration", java.lang.Long.valueOf(asecCallbackDataHolder.duration));
            jSONObject.put("recordUrl", asecCallbackDataHolder.recordUrl);
            jSONObject.put("errCode", 0);
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(asecCallbackDataHolder.session.getJsonResult());
            if (object == null) {
                object = new com.alibaba.fastjson.JSONObject();
            }
            this.webView.callJSMethod("onRecStateChangeV1(%s,%s)", jSONObject.toJSONString(), object.toJSONString());
            if (asecCallbackDataHolder.rawState == -1) {
                jSONObject.put("state", -1);
                jSONObject.put("msg", asecCallbackDataHolder.session.getMessage());
                jSONObject.put("errCode", java.lang.Integer.valueOf(asecCallbackDataHolder.session.getCode()));
                this.webView.callJSMethod("onRecStateChangeV1(%s,%s)", jSONObject.toJSONString(), object.toJSONString());
                return;
            }
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showError(this.webView, "cbType 类型错误：" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$1(com.up366.asecengine.englishengine.AsecSession[] asecSessionArr, java.lang.String str, byte[] bArr, int i) {
        com.up366.asecengine.englishengine.AsecSession asecSession = asecSessionArr[0];
        com.alibaba.fastjson.JSONObject object = asecSession != null ? com.alibaba.fastjson.JSON.parseObject(asecSession.getWavCheckerJsonResult()) : null;
        if (object == null) {
            object = new com.alibaba.fastjson.JSONObject();
        }
        this.webView.callJSMethod("onRecordFFTUpdate('%s', %s, %d, %s)", str, java.util.Arrays.toString(bArr), java.lang.Integer.valueOf(i), object.toJSONString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordImpl$2(int i, java.lang.String str, byte[] bArr) {
        if (i < 0 || i > 2048) {
            i = 1024;
        }
        byte[] bArr2 = new byte[i];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
        this.webView.callJSMethod("onRecordFFTUpdate('%s', %s)", str, java.util.Arrays.toString(bArr2));
    }

    public java.lang.String getRecordPath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(this.dataHelper.getChapterRootDataDir(this.page), this.page.obj.getId(), str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
    }

    public void endRecord(java.lang.String str) {
        this.speechRecordHelper.endRecord(str);
    }

    protected java.lang.String getCurrentPath() {
        if (this.page == null) {
            return this.dataHelper.getBookPath();
        }
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
            return "{}";
        }
        if (asecSessionModelFindByRecordId.getState() == 2) {
            com.up366.common.log.Logger.info("STATE_SUCCESS getAsecResult - " + asecSessionModelFindByRecordId.getResult());
            return asecSessionModelFindByRecordId.getResult();
        }
        com.up366.common.log.Logger.error("录音记录状态错误：" + com.alibaba.fastjson.JSON.toJSONString(asecSessionModelFindByRecordId));
        return buildErrorResult(str, -3099, "录音记录状态错误");
    }

    private java.lang.String buildErrorResult(java.lang.String str, int i, java.lang.String str2) {
        return "{\n    \"code\": " + i + ",\n    \"durationInMs\": 0,\n    \"recordId\": \"" + str + "\",\n    \"result\": \"\",\n    \"score\": 0,\n    \"score100\": 0,\n    \"msg\": \"" + str2 + "\",\n    \"uploadURL\": \"\"\n}";
    }

    public void deleteByRecordId(java.lang.String str) {
        this.speechRecordHelper.deleteByRecordId(str);
    }
}
