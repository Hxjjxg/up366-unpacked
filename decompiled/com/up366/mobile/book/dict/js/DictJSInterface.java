package com.up366.mobile.book.dict.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DictJSInterface extends com.up366.mobile.book.jsbase.BaseJSInterface {
    private final com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    private final com.up366.mobile.book.dict.js.DictAudioHelper audioHelper;
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.dict.js.DictHelper dictHelper;
    private final com.up366.mobile.book.helper.HeadsetHelper headsetHelper;
    public final com.up366.mobile.book.dict.js.DictOpenHelper openHelper;
    private final com.up366.mobile.book.dict.js.DictRecordHelper recordHelper;
    private final com.up366.mobile.book.dict.js.DictRegisterHelper registerHelper;
    private final com.up366.mobile.book.helper.V7ShareHelper shareHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;
    private final com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();
    private final com.up366.mobile.book.helper.V7HttpHelper httpHelper = new com.up366.mobile.book.helper.V7HttpHelper();

    /* JADX WARN: Multi-variable type inference failed */
    public DictJSInterface(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.dict.DictHtmlView dictHtmlView) {
        this.context = studyActivity;
        this.webView = dictHtmlView.b.webView;
        this.registerHelper = dictHtmlView.registerHelper;
        this.openHelper = dictHtmlView.openHelper;
        this.audioHelper = dictHtmlView.audioHelper;
        this.recordHelper = dictHtmlView.recordHelper;
        this.appInfoHelper = dictHtmlView.appInfoHelper;
        this.dictHelper = dictHtmlView.dictHelper;
        this.shareHelper = new com.up366.mobile.book.helper.V7ShareHelper(studyActivity);
        this.headsetHelper = studyActivity.headsetHelper;
    }

    @android.webkit.JavascriptInterface
    public void registerEvent(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - registerEvent - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegisterEvent(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - unRegisterEvent - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebView(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - openWebView - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebView$0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$0(java.lang.String str) throws java.lang.Exception {
        this.openHelper.openWebView(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebViewV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - openWebViewV2 - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda23
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebViewV2$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebViewV2$1(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.V8OpenHelper.openWebView(this.context, str, new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closeWebView();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void closeWebView() {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - closeWebView - ");
        final com.up366.mobile.book.dict.js.DictOpenHelper dictOpenHelper = this.openHelper;
        java.util.Objects.requireNonNull(dictOpenHelper);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                dictOpenHelper.closeWebView();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String saveData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda32
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
        com.up366.common.log.Logger.debug("TAG - DictJSInterface - saveData - key = [" + string + "], value = [" + string2 + "]");
        if (this.dataHelper.saveData(string, string2) == 1) {
            return;
        }
        throw new java.lang.IllegalStateException("保存失败:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda31
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$loadData$3(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$loadData$3(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "key");
        com.up366.common.log.Logger.debug("TAG - DictJSInterface - loadData - key = [" + param + "]");
        return this.dataHelper.loadData(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String playAudio(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda29
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$playAudio$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$playAudio$4(java.lang.String str) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - playAudio - audioConfig = [" + str + "]");
        return java.lang.Integer.valueOf(this.audioHelper.playAudioWithParams(str));
    }

    @android.webkit.JavascriptInterface
    public void pauseAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - pauseAudio - audioId = [" + param + "]");
        this.audioHelper.pausePlay(param);
    }

    @android.webkit.JavascriptInterface
    public void resumeAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - resumeAudio - audioId = [" + param + "]");
        this.audioHelper.resumePlaying(param);
    }

    @android.webkit.JavascriptInterface
    public void stopAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - stopAudio - audioId = [" + param + "]");
        this.audioHelper.stopPlay(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCurrentAudioTime(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda18
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getCurrentAudioTime$5(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getCurrentAudioTime$5(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getCurrentAudioTime - audioId = [" + param + "]");
        return java.lang.Integer.valueOf(this.audioHelper.getCurrentTime(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setAudioRate(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setAudioRate$6(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAudioRate$6(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        float paramFloat = getParamFloat(str, "rate");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - setAudioRate - audioId = [" + param + "], rate = [" + paramFloat + "]");
        this.audioHelper.setRate(param, paramFloat);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAudioRate(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAudioRate$7(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAudioRate$7(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getAudioRate - audioId = [" + param + "]");
        float rate = this.audioHelper.getRate(param);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("rate", java.lang.Float.valueOf(rate));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public void startRecord(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - startRecord - recConfig = [" + str + "]");
        this.recordHelper.startRecordWithParamsV2(str);
    }

    @android.webkit.JavascriptInterface
    public void stopRecord(java.lang.String str) {
        java.lang.String param = getParam(str, "recordId");
        int paramInt = getParamInt(str, "giveup");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - stopRecord - recordId = [" + param + "]");
        if (paramInt == 0) {
            this.recordHelper.endRecord(param);
        } else {
            this.recordHelper.forceStopAll();
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPageParams() {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getPageParams - ");
        final com.up366.mobile.book.dict.js.DictHelper dictHelper = this.dictHelper;
        java.util.Objects.requireNonNull(dictHelper);
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return dictHelper.getPageParams();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void updateTitleBar(java.lang.String str) {
        final java.lang.String param = getParam(str, "title");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - updateTitleBar - title = [" + param + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda26
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateTitleBar$8(param);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTitleBar$8(java.lang.String str) throws java.lang.Exception {
        this.context.titleBar.setTitle(str);
    }

    @android.webkit.JavascriptInterface
    public void launchXotEngine(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString("type");
        final java.lang.String string2 = object.getString("data");
        final boolean booleanValue = object.getBooleanValue("openNewWebview");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - launchXotEngine - type = [" + string + "], data = [" + string2 + "], openNewWebView = [" + booleanValue + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda30
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$launchXotEngine$9(string, string2, booleanValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchXotEngine$9(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Exception {
        this.openHelper.launchXotEngine(str, str2, z);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getClientInfo$10();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getClientInfo$10() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getClientInfo - ");
        return this.appInfoHelper.getClientInfoV7();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUserInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda17
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getUserInfo$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getUserInfo$11() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getUserInfo - ");
        return com.alibaba.fastjson.JSON.parse(this.appInfoHelper.getUserInfoV7());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAsecResult(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda20
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAsecResult$12(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAsecResult$12(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "recordId");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getAsecResult - recordId = [" + param + "]");
        return com.alibaba.fastjson.JSON.parse(this.recordHelper.getAsecResult(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String delAsecResult(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$delAsecResult$13(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$delAsecResult$13(java.lang.String str) {
        java.lang.String param = getParam(str, "recordId");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - delAsecResult - recordId = [" + param + "]");
        this.recordHelper.deleteByRecordId(param);
    }

    @android.webkit.JavascriptInterface
    public void postMessage(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - postMessage - msg = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$postMessage$14(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$14(java.lang.String str) throws java.lang.Exception {
        this.registerHelper.postMessage(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getNetWorkInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda24
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getNetWorkInfo$15();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getNetWorkInfo$15() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getNetWorkInfo - ");
        return this.appInfoHelper.getNetWorkInfo();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String removeData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeData$16(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeData$16(java.lang.String str) {
        java.lang.String param = getParam(str, "key");
        com.up366.common.log.Logger.info("TAG - DictJSInterface - removeData - key = [" + param + "]");
        if (this.dataHelper.deleteData(param) == 1) {
            return;
        }
        throw new java.lang.IllegalStateException("删除失败:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String share(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - share - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$share$18(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$18(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.shareHelper.share(str, this.webView, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda25
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                this.f$0.lambda$share$17(str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$17(java.lang.String str, int i, java.lang.String str2) {
        if (i == 0) {
            if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this.context, "保存成功");
            }
            this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(1));
            return;
        }
        com.up366.common.log.Logger.info("TAG - DictJSInterface - share - result - code:" + i + " info:" + str2);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.webView, str2);
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(-2, str2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String httpRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - httpRequest - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.httpHelper.httpSend(str, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda6
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                this.f$0.lambda$httpRequest$19(asyncUniqueKey, i, str2, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$httpRequest$19(java.lang.String str, int i, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        this.webView.getBridgeHelper().responseAsyncResult(str, jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String httpQueue(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - httpQueue - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$httpQueue$20(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$httpQueue$20(java.lang.String str) {
        this.httpHelper.httpSendToQueue(str);
    }

    @android.webkit.JavascriptInterface
    public void seekPlayAudio(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - seekPlayAudio - audioPlayerId = [" + str + "], position = [" + i + "]");
        this.audioHelper.seekPlay(str, i);
    }

    @android.webkit.JavascriptInterface
    public void setVolume(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - setVolume - audioPlayerId = [" + str + "], volume = [" + i + "]");
        this.audioHelper.setVolume(str, i);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUUID() {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getUUID - ");
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCourseId() {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getCourseId - ");
        int courseId = this.context.book.getCourseId();
        return courseId < 1 ? "" : java.lang.String.valueOf(courseId);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getModeInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.book.dict.js.DictJSInterface.lambda$getModeInfo$21();
            }
        });
    }

    static /* synthetic */ java.lang.Object lambda$getModeInfo$21() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getModeInfo - ");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("darkMode", false);
        jSONObject.put("fullScreenMode", false);
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getStudyTaskDetail() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.book.dict.js.DictJSInterface.lambda$getStudyTaskDetail$22();
            }
        });
    }

    static /* synthetic */ java.lang.Object lambda$getStudyTaskDetail$22() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getStudyTaskDetail - ");
        com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolderLoad = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("length", java.lang.Integer.valueOf(coursePageCountHolderLoad.getCurrentTaskNum()));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public void uploadUserLog(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - uploadUserLog - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda21
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$uploadUserLog$23(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$23(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.ActionLogRecord.recordJS(this.webView, com.alibaba.fastjson.JSON.parseObject(str));
    }

    @android.webkit.JavascriptInterface
    public void __onResponseJSResult(int i, java.lang.String str) {
        this.webView.getBridgeHelper().onResponseData(i, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String copyToClipboard(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - copyToClipboard - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$copyToClipboard$24(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyToClipboard$24(java.lang.String str) {
        new com.up366.mobile.book.helper.ClipBoardHelper(this.context).copyTextToClipboard(getParam(str, "text"));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String showLoading(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - showLoading - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLoading$26(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$26(java.lang.String str) {
        final boolean paramBoolean = getParamBoolean(str, "showFlag");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showLoading$25(paramBoolean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$25(boolean z) throws java.lang.Exception {
        this.context.showLoading(z, true);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String searchDB(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - searchDB - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        java.lang.String param = getParam(str, "sql");
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.dictHelper.searchDB("db", param, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda15
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                this.f$0.lambda$searchDB$27(asyncUniqueKey, jCurrentTimeMillis, i, str2, (com.alibaba.fastjson.JSONArray) obj);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDB$27(java.lang.String str, long j, int i, java.lang.String str2, com.alibaba.fastjson.JSONArray jSONArray) {
        java.lang.String jSONString;
        if (jSONArray == null) {
            jSONString = "[]";
        } else {
            jSONString = jSONArray.toJSONString();
        }
        this.webView.getBridgeHelper().responseAsyncResult(str, "{\"data\": " + jSONString + ",\"result\": {\"code\": " + i + ",\"msg\": " + com.alibaba.fastjson.JSON.toJSONString(str2) + "}}");
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - DictJSInterface - searchDB - used time : ");
        sb.append(java.lang.System.currentTimeMillis() - j);
        com.up366.common.log.Logger.info(sb.toString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String pasteFromClipboard() {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - pasteFromClipboard");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda12
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$pasteFromClipboard$28();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$pasteFromClipboard$28() throws java.lang.Exception {
        return new com.up366.mobile.book.helper.ClipBoardHelper(this.context).getText();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getHeadSetStatus() {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getHeadSetStatus");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.dict.js.DictJSInterface$$ExternalSyntheticLambda28
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getHeadSetStatus$29();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getHeadSetStatus$29() throws java.lang.Exception {
        if (this.headsetHelper.getHeadsetState() == 1) {
            return "{\"status\":1}";
        }
        return "{\"status\":0}";
    }
}
