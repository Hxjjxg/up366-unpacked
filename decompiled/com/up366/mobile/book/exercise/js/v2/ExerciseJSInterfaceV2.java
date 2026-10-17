package com.up366.mobile.book.exercise.js.v2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseJSInterfaceV2 extends com.up366.mobile.book.jsbase.BaseJSInterface {
    public com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    public com.up366.mobile.book.exercise.js.v2.AudioHelperV2 audioHelper;
    private com.up366.mobile.book.helper.ClipBoardHelper clipBoardHelper;
    private final com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper clippedPhotoV2Helper;
    private com.up366.mobile.book.StudyActivity context;
    private com.up366.mobile.book.exercise.js.ExerciseHelper exerciseHelper;
    private com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView;
    private final com.up366.mobile.book.helper.HeadsetHelper headsetHelper;
    private com.up366.mobile.book.exercise.js.PathHelper pathHelper;
    public com.up366.mobile.book.exercise.js.v2.RecordHelperV2 recordHelper;
    public com.up366.mobile.book.exercise.js.v2.RegisterHelperV2 registerHelper;
    private final com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private com.up366.mobile.book.helper.V7ShareHelper v7ShareHelper;
    private com.up366.mobile.book.webview.StudyPageWebView webView;
    private com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();
    private com.up366.mobile.book.helper.V7HttpHelper httpHelper = new com.up366.mobile.book.helper.V7HttpHelper();

    public ExerciseJSInterfaceV2(com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView, com.up366.mobile.book.exercise.js.ExerciseHelper exerciseHelper) {
        this.webView = exerciseHtmlView.b.webView;
        this.context = exerciseHtmlView.context;
        this.exerciseHtmlView = exerciseHtmlView;
        this.exerciseHelper = exerciseHelper;
        this.registerHelper = new com.up366.mobile.book.exercise.js.v2.RegisterHelperV2(this.webView, exerciseHtmlView);
        this.pathHelper = new com.up366.mobile.book.exercise.js.PathHelper(exerciseHtmlView.dataHelper);
        this.audioHelper = new com.up366.mobile.book.exercise.js.v2.AudioHelperV2(this.webView, this.pathHelper, this.registerHelper);
        this.recordHelper = new com.up366.mobile.book.exercise.js.v2.RecordHelperV2(this.webView, this.pathHelper, this.registerHelper);
        this.v7ShareHelper = new com.up366.mobile.book.helper.V7ShareHelper(exerciseHtmlView.context);
        this.clipBoardHelper = new com.up366.mobile.book.helper.ClipBoardHelper(exerciseHtmlView.context);
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(exerciseHtmlView.context, exerciseHtmlView.b.webView);
        this.takePhotoHelper = exerciseHtmlView.context.takePhotoHelper;
        this.headsetHelper = exerciseHtmlView.context.headsetHelper;
        this.clippedPhotoV2Helper = exerciseHtmlView.context.pickerClippedPhotoV2Helper;
    }

    @android.webkit.JavascriptInterface
    public void registerEvent(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.debug("TAG - ExerciseJSInterfaceV2 - registerEvent - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegisterEvent(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - unRegisterEvent - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebView(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - openWebView - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebView$0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$0(java.lang.String str) throws java.lang.Exception {
        this.exerciseHelper.openWebView(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebViewV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - openWebViewV2 - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebViewV2$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebViewV2$1(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.V8OpenHelper.openWebView(this.context, str, new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closeWebView();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void closeWebView() {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - closeWebView - ");
        final com.up366.mobile.book.exercise.js.ExerciseHelper exerciseHelper = this.exerciseHelper;
        java.util.Objects.requireNonNull(exerciseHelper);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda58
            @Override // com.up366.common.task.Task
            public final void run() {
                exerciseHelper.closePage();
            }
        });
        this.audioHelper.release();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String saveData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveData$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveData$2(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("key");
        java.lang.String string2 = object.getString("value");
        com.up366.common.log.Logger.debug("TAG - ExerciseJSInterfaceV2 - saveData - key = [" + string + "], value = [" + string2 + "]");
        if (this.dataHelper.saveData(string, string2) == 1) {
            return;
        }
        throw new java.lang.IllegalStateException("保存失败:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String removeData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeData$3(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeData$3(java.lang.String str) {
        java.lang.String param = getParam(str, "key");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - removeData - key = [" + param + "]");
        if (this.dataHelper.deleteData(param) == 1) {
            return;
        }
        throw new java.lang.IllegalStateException("删除失败:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda46
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$loadData$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$loadData$4(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "key");
        com.up366.common.log.Logger.debug("TAG - ExerciseJSInterfaceV2 - loadData - key = [" + param + "]");
        return this.dataHelper.loadData(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String playAudio(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$playAudio$5(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$playAudio$5(java.lang.String str) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - playAudio - audioConfig = [" + str + "]");
        return java.lang.Integer.valueOf(this.audioHelper.playAudioWithParams(str));
    }

    @android.webkit.JavascriptInterface
    public void pauseAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - pauseAudio - audioId = [" + param + "]");
        this.audioHelper.pausePlayAudio(param);
    }

    @android.webkit.JavascriptInterface
    public void resumeAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - resumeAudio - audioId = [" + param + "]");
        this.audioHelper.resumePlayAudio(param);
    }

    @android.webkit.JavascriptInterface
    public void stopAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - stopAudio - audioId = [" + param + "]");
        this.audioHelper.stopPlayAudio(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCurrentAudioTime(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda14
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getCurrentAudioTime$6(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getCurrentAudioTime$6(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getCurrentAudioTime - audioId = [" + param + "]");
        return java.lang.Integer.valueOf(this.audioHelper.getAudioCurrentTime(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setAudioRate(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setAudioRate$7(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAudioRate$7(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        float paramFloat = getParamFloat(str, "rate");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - setAudioRate - audioId = [" + param + "], rate = [" + paramFloat + "]");
        this.audioHelper.setRate(param, paramFloat);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAudioRate(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda56
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAudioRate$8(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAudioRate$8(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getAudioRate - audioId = [" + param + "]");
        float rate = this.audioHelper.getRate(param);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("rate", java.lang.Float.valueOf(rate));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public void startRecord(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - startRecord - recConfig = [" + str + "]");
        this.recordHelper.startRecordWithParamsV2(str);
    }

    @android.webkit.JavascriptInterface
    public void stopRecord(java.lang.String str) {
        java.lang.String param = getParam(str, "recordId");
        int paramInt = getParamInt(str, "giveup");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - stopRecord - recordId = [" + param + "]");
        if (paramInt == 0) {
            this.recordHelper.endRecord(param);
        } else {
            this.recordHelper.forceStopAll();
        }
    }

    @android.webkit.JavascriptInterface
    public void launchXotEngine(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString("type");
        final java.lang.String string2 = object.getString("data");
        final boolean booleanValue = object.getBooleanValue("openNewWebview");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - launchXotEngine - type = [" + string + "], data = [" + string2 + "], openNewWebView = [" + booleanValue + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$launchXotEngine$9(string, string2, booleanValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchXotEngine$9(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Exception {
        this.exerciseHelper.launchXotEngine(str, str2, z);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getClientInfo$10();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getClientInfo$10() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getClientInfo - ");
        return this.appInfoHelper.getClientInfoV7();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUserInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda16
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getUserInfo$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getUserInfo$11() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getUserInfo - ");
        return com.alibaba.fastjson.JSON.parse(this.appInfoHelper.getUserInfoV7());
    }

    @android.webkit.JavascriptInterface
    public void postMessage(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - postMessage - msg = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda32
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$postMessage$12(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$12(java.lang.String str) throws java.lang.Exception {
        this.registerHelper.postMessage(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getNetWorkInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda18
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getNetWorkInfo$13();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getNetWorkInfo$13() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getNetWorkInfo - ");
        return this.appInfoHelper.getNetWorkInfo();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String share(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - share - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda28
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$share$15(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$15(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.v7ShareHelper.share(str, this.webView, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda15
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                this.f$0.lambda$share$14(str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$14(java.lang.String str, int i, java.lang.String str2) {
        if (i == 0) {
            if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.webView, "保存成功");
            }
            this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(1));
            return;
        }
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - share - result - code:" + i + " info:" + str2);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.webView, str2);
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(-2, str2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String httpRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - httpRequest - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.httpHelper.httpSend(str, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda36
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                this.f$0.lambda$httpRequest$16(asyncUniqueKey, i, str2, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$httpRequest$16(java.lang.String str, int i, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        this.webView.getBridgeHelper().responseAsyncResult(str, jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String httpQueue(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - httpQueue - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$httpQueue$17(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$httpQueue$17(java.lang.String str) {
        this.httpHelper.httpSendToQueue(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String ocr(java.lang.String str) {
        com.up366.mobile.common.onlinelog.OpLog.record("TAG - ExerciseJSInterfaceV2", "ocr - json = [" + str + "]");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - ocr - json = [" + str + "]");
        int intValue = com.alibaba.fastjson.JSON.parseObject(str).getIntValue("skipConfirm");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.takePhotoHelper.getPictureCropAndRecognition(intValue, new com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda20
            @Override // com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback
            public final void onResult(java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.f$0.lambda$ocr$18(asyncUniqueKey, str2, str3, str4);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ocr$18(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (str2 == null) {
            jSONObject.put("code", 1);
            jSONObject.put("result", "");
        } else {
            jSONObject.put("code", 0);
            jSONObject.put("result", com.alibaba.fastjson.JSONObject.parseObject(str2));
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str3)) {
            str3 = "";
        }
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str3);
        if (com.up366.common.StringUtils.isEmptyOrNull(str4)) {
            str4 = "";
        }
        jSONObject.put("tid", str4);
        this.webView.getBridgeHelper().responseAsyncResult(str, "{\"data\": " + jSONObject.toJSONString() + ",\"result\": {\"code\": 0,\"msg\": \"success\"}}");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getModeInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda17
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2.lambda$getModeInfo$19();
            }
        });
    }

    static /* synthetic */ java.lang.Object lambda$getModeInfo$19() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getModeInfo ");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("darkMode", false);
        jSONObject.put("fullScreenMode", false);
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String copyToClipboard(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - copyToClipboard - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$copyToClipboard$20(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyToClipboard$20(java.lang.String str) {
        this.clipBoardHelper.copyTextToClipboard(getParam(str, "text"));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openDictionary(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - openDictionary - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openDictionary$22(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionary$21(java.lang.String str) throws java.lang.Exception {
        this.exerciseHelper.openDictionary(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionary$22(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda45
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openDictionary$21(str);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openDictionaryV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - openDictionaryV2 - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda51
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openDictionaryV2$24(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionaryV2$23(java.lang.String str) throws java.lang.Exception {
        this.exerciseHelper.openDictionaryV2(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionaryV2$24(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda42
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openDictionaryV2$23(str);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPageParams() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda29
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getPageParams$25();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getPageParams$25() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getPageParams - ");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(this.exerciseHelper.getPageParams());
        object.put("env", "Product");
        return object;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String showLoading(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - showLoading - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLoading$27(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$27(java.lang.String str) {
        final boolean paramBoolean = getParamBoolean(str, "showFlag");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda57
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showLoading$26(paramBoolean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$26(boolean z) throws java.lang.Exception {
        this.exerciseHelper.showLoading(z);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setBackgroundColor(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - setBackgroundColor - json = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda30
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$setBackgroundColor$28(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$setBackgroundColor$28(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.setSystemViewColor(this.context, getParam(str, "color"), getParam(str, "backgroundColor"), getParam(str, "backgroundColorTop"), getParam(str, "backgroundColorBottom"));
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setStatusBar(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - setStatusBar - json = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda34
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$setStatusBar$29(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$setStatusBar$29(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.setStatusBarTextHidden(this.context, getParamBoolean(str, "hidden"));
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String uploadUserLog(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadUserLog$31(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$31(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - uploadUserLog - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda52
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$uploadUserLog$30(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$30(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.ActionLogRecord.recordJS(this.webView, com.alibaba.fastjson.JSON.parseObject(str));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String pasteFromClipboard() {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - pasteFromClipboard");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda40
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$pasteFromClipboard$32();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$pasteFromClipboard$32() throws java.lang.Exception {
        return this.clipBoardHelper.getText();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openAttachment(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openAttachment$34(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openAttachment$34(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - openAttachment - json = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        final java.lang.String string2 = object.getString("mimeType");
        final java.lang.String string3 = object.getString("fileName");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda21
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openAttachment$33(string2, string, string3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openAttachment$33(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        if ("text/html".equals(str)) {
            com.up366.mobile.common.utils.AttachmentUtils.openUrl(this.webView.getContext(), str2, str3);
        } else {
            com.up366.mobile.common.utils.AttachmentUtils.openFile(new java.io.File(com.up366.common.FileUtilsUp.join(this.pathHelper.getCurrentPath()), str2), str);
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getNTPTimestamp() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda35
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2.lambda$getNTPTimestamp$35();
            }
        });
    }

    static /* synthetic */ java.lang.Object lambda$getNTPTimestamp$35() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getNTPTimestamp - ");
        return java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPhoto(java.lang.String str) {
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        final java.lang.String param = getParam(str, "quesId");
        final int paramInt = getParamInt(str, "limit");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getPhoto - questionId = [" + param + "], maxNum = [" + paramInt + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda48
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getPhoto$37(param, paramInt, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$37(java.lang.String str, int i, final java.lang.String str2) throws java.lang.Exception {
        this.exerciseHelper.getPhotoV2(str, i, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda10
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i2, java.lang.String str3, java.lang.Object obj) {
                this.f$0.lambda$getPhoto$36(str2, i2, str3, (com.alibaba.fastjson.JSONArray) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$36(java.lang.String str, int i, java.lang.String str2, com.alibaba.fastjson.JSONArray jSONArray) {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(jSONArray));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClippedPhotoV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getClippedPhotoV2 - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda50
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getClippedPhotoV2$39(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhotoV2$39(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.clippedPhotoV2Helper.launch(str, new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda43
            @Override // com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback
            public final void onResult(com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult, java.util.List list) {
                this.f$0.lambda$getClippedPhotoV2$38(str2, photoPickerLaunchResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhotoV2$38(java.lang.String str, com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult, java.util.List list) {
        if (!photoPickerLaunchResult.getSuccess()) {
            if (com.up366.common.StringUtils.isEmptyOrNull(photoPickerLaunchResult.getErrorCode())) {
                this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(-2, "未知错误"));
                return;
            } else {
                this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(java.lang.Integer.parseInt(photoPickerLaunchResult.getErrorCode()), photoPickerLaunchResult.getErrorMessage()));
                return;
            }
        }
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.photopicker.PhotoPickerPhotoResult photoPickerPhotoResult = (com.up366.photopicker.PhotoPickerPhotoResult) it.next();
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(photoPickerPhotoResult.getLocalPath(), null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("localPath", fileMapInfoSaveSync.getPath());
            jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfoSaveSync.getUrl());
            jSONObject.put("size", java.lang.Long.valueOf(new java.io.File(fileMapInfoSaveSync.getPath()).length()));
            jSONObject.put("isRectAdjusted", java.lang.Boolean.valueOf(photoPickerPhotoResult.isRectAdjusted()));
            jSONArray.add(jSONObject);
        }
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(jSONArray));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String deletePhoto(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deletePhoto$40(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deletePhoto$40(java.lang.String str) {
        java.lang.String param = getParam(str, "picUrl");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - deletePhoto - picPath = [" + param + "]");
        this.exerciseHelper.deletePhoto(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String submitAnswerData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$submitAnswerData$41(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitAnswerData$41(java.lang.String str) {
        java.lang.String param = getParam(str, "uploadId");
        java.lang.String param2 = getParam(str, "type");
        java.lang.String param3 = getParam(str, "data");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - submitAnswerData - uploadId = [" + param + "], type = [" + param2 + "], json = [" + str + "]");
        this.exerciseHelper.submitTest(param, param2, param3);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUploadProgressInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda22
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2.lambda$getUploadProgressInfo$42();
            }
        });
    }

    static /* synthetic */ java.lang.Object lambda$getUploadProgressInfo$42() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getUploadProgressInfo - ");
        return com.alibaba.fastjson.JSON.parse(com.up366.mobile.book.exercise.js.ExerciseUploadStatusHelper.get());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String continueUploadAnswerData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$continueUploadAnswerData$43(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$continueUploadAnswerData$43(java.lang.String str) {
        java.lang.String param = getParam(str, "uploadId");
        java.lang.String param2 = getParam(str, "type");
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - continueUploadAnswerData - uploadId = [" + param + "], type = [" + param2 + "]");
        com.up366.mobile.common.onlinelog.OpLog.record("continueUploadAnswerData", "uploadId = [" + param + "], type = [" + param2 + "]");
        com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
        com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String feedBackRec(java.lang.String str) {
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - feedBackRec - params = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            string = object.getString("testId");
        }
        com.up366.mobile.common.utils.ViewUtil.runTapAction(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda54
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$feedBackRec$45(string, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$feedBackRec$45(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        new com.up366.mobile.common.compat.FeedbackTaskRecord(this.webView.getContext(), str, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda49
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                this.f$0.lambda$feedBackRec$44(str2, i, str3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$feedBackRec$44(java.lang.String str, int i, java.lang.String str2) {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(i, str2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String questionFeedBackRec(final java.lang.String str) {
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - questionFeedBackRec - params = [" + str + "]");
        com.up366.mobile.common.utils.ViewUtil.runTapAction(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda59
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$questionFeedBackRec$47(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$questionFeedBackRec$47(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        new com.up366.mobile.common.views.OralFeedbackDialog(this.webView.getContext(), str, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda38
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                this.f$0.lambda$questionFeedBackRec$46(str2, i, str3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$questionFeedBackRec$46(java.lang.String str, int i, java.lang.String str2) {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(i, str2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadPaperData() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda37
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$loadPaperData$48();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$loadPaperData$48() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - loadPaperData");
        com.up366.mobile.book.exercise.model.ExerciseData exerciseData = this.exerciseHtmlView.dataHelper.d;
        java.lang.String paperXml = exerciseData.getPaperXml();
        java.lang.String standardXml = exerciseData.getStandardXml();
        java.lang.String answerXml = exerciseData.getAnswerXml();
        java.lang.String markXml = exerciseData.getMarkXml();
        if (paperXml == null) {
            paperXml = "";
        }
        if (standardXml == null) {
            standardXml = "";
        }
        if (answerXml == null) {
            answerXml = "";
        }
        if (markXml == null) {
            markXml = "";
        }
        java.lang.String strReplaceAll = android.util.Base64.encodeToString(paperXml.getBytes(), 0).replaceAll("\\s", "");
        java.lang.String strReplaceAll2 = android.util.Base64.encodeToString(standardXml.getBytes(), 0).replaceAll("\\s", "");
        java.lang.String strReplaceAll3 = android.util.Base64.encodeToString(answerXml.getBytes(), 0).replaceAll("\\s", "");
        java.lang.String strReplaceAll4 = android.util.Base64.encodeToString(markXml.getBytes(), 0).replaceAll("\\s", "");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("paperXmlStr", strReplaceAll);
        jSONObject.put("answerXmlStr", strReplaceAll2);
        jSONObject.put("userAnsXmlStr", strReplaceAll3);
        jSONObject.put("markXmlStr", strReplaceAll4);
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getHeadSetStatus() {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getHeadSetStatus");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda33
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getHeadSetStatus$49();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getHeadSetStatus$49() throws java.lang.Exception {
        if (this.headsetHelper.getHeadsetState() == 1) {
            return "{\"status\":1}";
        }
        return "{\"status\":0}";
    }

    @android.webkit.JavascriptInterface
    public java.lang.String readFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - readFile - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$readFile$50(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$readFile$50(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "filename");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.igexin.sdk.FlymePushReceiver.CONTENT, new com.up366.mobile.book.webview.DecryptFileHelper().getEncFileContent(param));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String downloadFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - downloadFile - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$downloadFile$54(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$54(java.lang.String str) {
        final java.lang.String param = getParam(str, "fileId");
        final java.lang.Runnable[] runnableArr = {runnable};
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$downloadFile$53(param, runnableArr);
            }
        };
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$53(final java.lang.String str, final java.lang.Runnable[] runnableArr) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda24
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$downloadFile$52(str, runnableArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$52(final java.lang.String str, final java.lang.Runnable[] runnableArr) throws java.lang.Exception {
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.context.contentDownloadHelper;
        final java.lang.String tempResourcePath = contentDownloadHelper.getTempResourcePath(str);
        this.context.showDownloadLoadingView();
        contentDownloadHelper.downloadTempResource(str, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda31
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$downloadFile$51(runnableArr, str, tempResourcePath, (com.up366.common.event.DownloadEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$51(java.lang.Runnable[] runnableArr, java.lang.String str, java.lang.String str2, com.up366.common.event.DownloadEvent downloadEvent) {
        int i;
        int errCode;
        this.context.updateDownloadLoadingView(downloadEvent.getState(), downloadEvent.getCurrent(), downloadEvent.getTotal(), downloadEvent.getErrInfo(), runnableArr[0]);
        int percent = downloadEvent.getPercent();
        int state = downloadEvent.getState();
        java.lang.String str3 = "";
        if (state != 3) {
            i = 4;
            if (state != 4) {
                i = 5;
                if (state == 5) {
                    int errCode2 = downloadEvent.getErrCode();
                    int i2 = errCode2 != -111 ? 2 : 3;
                    java.lang.String errInfo = downloadEvent.getErrInfo();
                    if (errInfo != null && !errInfo.contains("失败")) {
                        errInfo = "下载失败：" + errInfo;
                    } else if (errInfo == null) {
                        errInfo = "下载失败";
                    }
                    str3 = errInfo;
                    errCode = errCode2;
                    i = i2;
                } else if (state != 6) {
                    errCode = 0;
                    i = 0;
                } else {
                    errCode = downloadEvent.getErrCode();
                    str3 = "取消下载";
                }
            }
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("fileId", str);
            jSONObject.put("status", java.lang.Integer.valueOf(i));
            jSONObject.put("errorCode", java.lang.Integer.valueOf(errCode));
            jSONObject.put("msg", str3);
            jSONObject.put("progress", java.lang.Integer.valueOf(percent));
            jSONObject.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, str2);
            this.registerHelper.callJsEvent("filedownload", "(%s)", jSONObject.toJSONString());
        }
        i = 1;
        errCode = 0;
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("fileId", str);
        jSONObject2.put("status", java.lang.Integer.valueOf(i));
        jSONObject2.put("errorCode", java.lang.Integer.valueOf(errCode));
        jSONObject2.put("msg", str3);
        jSONObject2.put("progress", java.lang.Integer.valueOf(percent));
        jSONObject2.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, str2);
        this.registerHelper.callJsEvent("filedownload", "(%s)", jSONObject2.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getDownloadFileStatus(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - getDownloadFileStatus - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda44
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getDownloadFileStatus$55(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getDownloadFileStatus$55(java.lang.String str) throws java.lang.Exception {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(str);
        for (int i = 0; i < array.size(); i++) {
            java.lang.String string = array.getString(i);
            com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.context.contentDownloadHelper;
            java.lang.String tempResourcePath = contentDownloadHelper.getTempResourcePath(string);
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            if (contentDownloadHelper.isTempResourceExists(string)) {
                jSONObject.put("code", 1);
                jSONObject.put("msg", "success");
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("msg", "not exists");
            }
            jSONObject.put("fileId", string);
            jSONObject.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, tempResourcePath);
            jSONArray.add(jSONObject);
        }
        return jSONArray;
    }

    @android.webkit.JavascriptInterface
    public void uploadFile(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterfaceV2 - uploadFile - params = [" + str + "]");
        new com.up366.mobile.book.helper.JSUploadFileHelper(this.dataHelper).upload(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openScanPaper(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - openScanPaper - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openScanPaper$57(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openScanPaper$56(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.course.photoanswer.PhotoAnswerOpenHelper.openScanPaper(this.context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openScanPaper$57(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openScanPaper$56(str);
            }
        });
    }
}
