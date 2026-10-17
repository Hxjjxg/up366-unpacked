package com.up366.mobile.commonui.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonJSInterface extends com.up366.mobile.book.jsbase.BaseJSInterface {
    private final com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity activity;
    private final com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    private final com.up366.mobile.book.helper.V7HttpHelper httpHelper = new com.up366.mobile.book.helper.V7HttpHelper();
    private final com.up366.mobile.commonui.webview.CommonWebOpenHelper openHelper;
    public final com.up366.mobile.commonui.webview.CommonWebRegisterHelper registerHelper;
    private final com.up366.mobile.book.helper.V7ShareHelper v7ShareHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonJSInterface(com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity commonJsBridgeWebViewActivity, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        this.activity = commonJsBridgeWebViewActivity;
        this.webView = studyPageWebView;
        this.registerHelper = new com.up366.mobile.commonui.webview.CommonWebRegisterHelper(commonJsBridgeWebViewActivity, studyPageWebView);
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(commonJsBridgeWebViewActivity, studyPageWebView);
        this.openHelper = new com.up366.mobile.commonui.webview.CommonWebOpenHelper(commonJsBridgeWebViewActivity);
        this.v7ShareHelper = new com.up366.mobile.book.helper.V7ShareHelper(commonJsBridgeWebViewActivity);
    }

    @android.webkit.JavascriptInterface
    public void registerEvent(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - registerEvent - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegisterEvent(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - unRegisterEvent - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getClientInfo$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getClientInfo$0() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - DictJSInterface - getClientInfo - ");
        return this.appInfoHelper.getClientInfoV7();
    }

    @android.webkit.JavascriptInterface
    public void closeWebView() {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - closeWebView - ");
        final com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity commonJsBridgeWebViewActivity = this.activity;
        java.util.Objects.requireNonNull(commonJsBridgeWebViewActivity);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() {
                commonJsBridgeWebViewActivity.finish();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void openWebView(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - openWebView - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebView$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$1(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.open(this.activity, getParam(str, com.up366.mobile.commonui.CommonWebViewActivity.URL), getParam(str, "title"));
    }

    @android.webkit.JavascriptInterface
    public void openWebViewV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - openWebViewV2 - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebViewV2$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebViewV2$2(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.V8OpenHelper.openWebView(this.activity, str, new java.lang.Runnable() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closeWebView();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String hideNavigate(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - hideNavigate - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hideNavigate$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideNavigate$3(java.lang.String str) throws java.lang.Exception {
        this.activity.hideNavigate(getParamBoolean(str, "hideFlag"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideNavigate$4(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$hideNavigate$3(str);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String showLoading(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - showLoading - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLoading$6(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$5(java.lang.String str) throws java.lang.Exception {
        this.activity.showLoading(getParamBoolean(str, "showFlag"), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$6(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showLoading$5(str);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String httpRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - httpRequest - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.httpHelper.httpSend(str, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                this.f$0.lambda$httpRequest$7(asyncUniqueKey, i, str2, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$httpRequest$7(java.lang.String str, int i, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        this.webView.getBridgeHelper().responseAsyncResult(str, jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public void launchXotEngine(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString("type");
        final java.lang.String string2 = object.getString("data");
        final boolean booleanValue = object.getBooleanValue("openNewWebview");
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - launchXotEngine - type = [" + string + "], data = [" + string2 + "], openNewWebView = [" + booleanValue + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$launchXotEngine$8(string, string2, booleanValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchXotEngine$8(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Exception {
        this.openHelper.launchXotEngine(str, str2, z);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String share(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - share - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$share$10(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$10(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.v7ShareHelper.share(str, this.webView, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                this.f$0.lambda$share$9(str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$9(java.lang.String str, int i, java.lang.String str2) {
        if (i == 0) {
            if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.webView, "保存成功");
            }
            this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(1));
            return;
        }
        com.up366.common.log.Logger.info("TAG - CommonJSInterface - share - result - code:" + i + " info:" + str2);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.webView, str2);
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(-2, str2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String uploadUserLog(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadUserLog$12(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$12(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - recordActionLog - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJSInterface$$ExternalSyntheticLambda14
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$uploadUserLog$11(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$11(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.ActionLogRecord.recordJS(this.webView, com.alibaba.fastjson.JSON.parseObject(str));
    }
}
