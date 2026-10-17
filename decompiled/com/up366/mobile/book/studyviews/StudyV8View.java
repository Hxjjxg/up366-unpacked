package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyV8View extends android.widget.FrameLayout {
    public com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    public com.up366.mobile.book.helper.V8AudioHelper audioHelper;
    public com.up366.mobile.databinding.BookStudyV8FragmentLayoutBinding b;
    private com.up366.mobile.book.model.BookInfoStudy book;
    public com.up366.mobile.book.helper.V8BookTaskLogHelper bookTaskLogHelper;
    public com.up366.mobile.book.model.OpenConfigInfo cfg;
    public android.app.Activity context;
    public final java.lang.String currentWebViewId;
    public com.up366.mobile.book.helper.V8ResourceHelper dataHelper;
    private boolean exerciseDataShowLoading;
    private boolean exerciseDataShowTitleBar;
    private com.up366.mobile.book.helper.V8FileUploadHelper fileUploadHelper;
    private com.up366.mobile.book.jsinterface.JSInterfaceV8 jsInterface;
    private boolean launchOptionsRestoreScheduled;
    private java.lang.String mActivityCode;
    private java.lang.String mInstanceId;
    public com.up366.mobile.book.helper.V8OpenHelper openHelper;
    private java.lang.String pendingRestorePageRoute;
    public com.up366.mobile.book.helper.V8RecordHelper recordHelper;
    public com.up366.mobile.book.helper.V8RegisterHelper registerHelper;
    private java.lang.String restoredPageRoute;
    public com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    private com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    boolean updateTitleFromPage;
    private int visibility;

    public StudyV8View(android.content.Context context) {
        this(context, null);
    }

    public StudyV8View(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StudyV8View(android.content.Context context, android.util.AttributeSet attributeSet, int i) throws java.lang.Throwable {
        boolean z;
        super(context, attributeSet, i);
        this.currentWebViewId = java.lang.String.valueOf(android.os.SystemClock.uptimeMillis());
        this.updateTitleFromPage = false;
        this.exerciseDataShowTitleBar = false;
        this.exerciseDataShowLoading = true;
        this.b = (com.up366.mobile.databinding.BookStudyV8FragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.book_study_v8_fragment_layout, this, true);
        initData(context);
        initHelpers(context);
        initViewData();
        loadHtmlPage();
        this.mInstanceId = generateUniqueId();
        this.mActivityCode = generateUniqueCode(context);
        if (this.cfg.openUrl != null) {
            z = !this.cfg.openUrl.contains("js-hide-loading=0");
            updateTitleBarVisibility(this.cfg.openUrl.contains("show-navigationbar=1") ? 0 : 8);
        } else {
            z = true;
        }
        if (this.exerciseDataShowLoading) {
            this.studyActivityInterface.showLoading(true, z);
        }
        if (this.exerciseDataShowTitleBar) {
            updateTitleBarVisibility(0);
        }
    }

    private void initViewData() {
        this.b.webView.setHasAnim(false);
        updateTitleBarText(this.cfg.title);
        this.b.webView.getBridgeHelper().setEnable(true);
        this.b.webView.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.up366.mobile.book.studyviews.StudyV8View.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (android.text.TextUtils.equals(webResourceRequest.getUrl().toString(), com.up366.mobile.book.studyviews.StudyV8View.this.b.webView.getUrl())) {
                    com.up366.common.log.Logger.error("TAG - StudyV8View - onReceivedError - load url error " + webResourceRequest.getUrl());
                    com.up366.mobile.book.studyviews.StudyV8View.this.studyActivityInterface.showLoadErrorTip("加载失败", "网络错误，建议更换网络环境或稍后重试。");
                }
            }
        });
        this.b.webView.setWebChromeClient(new android.webkit.WebChromeClient() { // from class: com.up366.mobile.book.studyviews.StudyV8View.2
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
                super.onReceivedTitle(webView, str);
                if (com.up366.mobile.book.studyviews.StudyV8View.this.updateTitleFromPage) {
                    com.up366.mobile.book.studyviews.StudyV8View.this.updateTitleBarText(str);
                }
            }
        });
    }

    private void initHelpers(android.content.Context context) {
        this.dataHelper = new com.up366.mobile.book.helper.V8ResourceHelper();
        this.speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(context);
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(this.context, this.b.webView);
        this.openHelper = new com.up366.mobile.book.helper.V8OpenHelper(this);
        this.registerHelper = new com.up366.mobile.book.helper.V8RegisterHelper(this.studyActivityInterface, this.b.webView);
        this.fileUploadHelper = new com.up366.mobile.book.helper.V8FileUploadHelper(this);
        this.bookTaskLogHelper = new com.up366.mobile.book.helper.V8BookTaskLogHelper(this.studyActivityInterface.getOpenConfigInfo());
        this.recordHelper = new com.up366.mobile.book.helper.V8RecordHelper(this.b.webView, this.speechRecordHelper, this.registerHelper);
        this.audioHelper = new com.up366.mobile.book.helper.V8AudioHelper(this.b.webView, this.recordHelper, this.registerHelper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData(android.content.Context context) {
        this.context = (android.app.Activity) context;
        com.up366.mobile.book.StudyActivityInterface studyActivityInterface = (com.up366.mobile.book.StudyActivityInterface) context;
        this.studyActivityInterface = studyActivityInterface;
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = studyActivityInterface.getOpenConfigInfo();
        this.cfg = openConfigInfo;
        java.lang.String strNormalizeRestorePageRoute = normalizeRestorePageRoute(openConfigInfo.restoredPageRoute);
        this.restoredPageRoute = strNormalizeRestorePageRoute;
        this.pendingRestorePageRoute = strNormalizeRestorePageRoute;
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.cfg.exerciseData)) {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(this.cfg.exerciseData);
            this.exerciseDataShowLoading = !object.getBooleanValue(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_DISMISS_LOADING);
            this.exerciseDataShowTitleBar = object.getBooleanValue(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_SHOW_TITLE_BAR);
            this.updateTitleFromPage = object.getBooleanValue(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_UPDATE_TITLE_FROM_HTML);
        }
        updateTitleBarVisibility(8);
        this.studyActivityInterface.showLoadingTitleBar(!this.exerciseDataShowTitleBar);
        this.book = this.studyActivityInterface.getBookInfoStudy();
    }

    private void updateTitleBarVisibility(int i) {
        if (this.studyActivityInterface.getTitleBar() == null) {
            return;
        }
        this.studyActivityInterface.getTitleBar().setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleBarText(java.lang.String str) {
        if (this.studyActivityInterface.getTitleBar() == null) {
            return;
        }
        this.studyActivityInterface.getTitleBar().setTitle(str);
    }

    private void onEnterPage() {
        final com.up366.mobile.book.callback.FinishCallback finishCallback = new com.up366.mobile.book.callback.FinishCallback(this.studyActivityInterface);
        if (this.b.webView.isPageHasLoaded()) {
            this.b.webView.setOnFinishedInterface(null);
            restorePageRouteIfNeeded();
            finishCallback.onFinish();
        } else {
            this.b.webView.setOnFinishedInterface(new com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface() { // from class: com.up366.mobile.book.studyviews.StudyV8View$$ExternalSyntheticLambda0
                @Override // com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface
                public final void onFinish() {
                    this.f$0.lambda$onEnterPage$0(finishCallback);
                }
            });
        }
        com.up366.mobile.book.StudyActivityInterface studyActivityInterface = this.studyActivityInterface;
        studyActivityInterface.buildBookPagePathV8(studyActivityInterface.getBookInfoStudy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$0(com.up366.mobile.book.callback.FinishCallback finishCallback) {
        restorePageRouteIfNeeded();
        finishCallback.onFinish();
    }

    private java.lang.String normalizeRestorePageRoute(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return null;
        }
        int iIndexOf = str.indexOf(35);
        if (iIndexOf >= 0) {
            str = str.substring(iIndexOf);
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || "#".equals(str)) {
            return null;
        }
        if (str.startsWith("#")) {
            return str;
        }
        return "#" + str;
    }

    private void restorePageRouteIfNeeded() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.pendingRestorePageRoute)) {
            return;
        }
        java.lang.String str = this.pendingRestorePageRoute;
        this.pendingRestorePageRoute = null;
        com.up366.common.log.Logger.info("TAG - StudyV8View - restorePageRouteIfNeeded - route : " + str);
        applyRestorePageRoute(str, 50, "pageFinished");
    }

    public void scheduleRestorePageRouteAfterLaunchOptions() {
        final java.lang.String str = this.restoredPageRoute;
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV8View$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$scheduleRestorePageRouteAfterLaunchOptions$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleRestorePageRouteAfterLaunchOptions$1(java.lang.String str) throws java.lang.Exception {
        if (this.launchOptionsRestoreScheduled) {
            return;
        }
        this.launchOptionsRestoreScheduled = true;
        com.up366.common.log.Logger.info("TAG - StudyV8View - scheduleRestorePageRouteAfterLaunchOptions - route : " + str);
        applyRestorePageRoute(str, 300, "launchOptions");
    }

    private void applyRestorePageRoute(final java.lang.String str, int i, final java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        if (i > 0) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(i, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV8View$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$applyRestorePageRoute$2(str2, str);
                }
            });
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV8View$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$applyRestorePageRoute$3(str2, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyRestorePageRoute$2(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - StudyV8View - applyRestorePageRoute - source = [" + str + "], route = [" + str2 + "]");
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = this.b.webView;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(function(){var route=");
        sb.append(com.alibaba.fastjson.JSON.toJSONString(str2));
        sb.append(";if(window.location.hash!==route){window.location.hash=route;}})();");
        studyPageWebView.callJSMethodIgnoreBridge(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyRestorePageRoute$3(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - StudyV8View - applyRestorePageRoute - source = [" + str + "], route = [" + str2 + "]");
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = this.b.webView;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(function(){var route=");
        sb.append(com.alibaba.fastjson.JSON.toJSONString(str2));
        sb.append(";if(window.location.hash!==route){window.location.hash=route;}})();");
        studyPageWebView.callJSMethodIgnoreBridge(sb.toString());
    }

    private void loadHtmlPage() throws java.lang.Throwable {
        java.lang.String str;
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.cfg.openUrl)) {
            str = this.cfg.openUrl;
            com.up366.common.log.Logger.debug("html open - page path : " + this.cfg.openUrl);
        } else {
            java.lang.String mainHtmlPagePath = this.studyActivityInterface.getV8FilePathHelper().getMainHtmlPagePath(this.book.getFileId());
            com.up366.common.log.Logger.debug("html chapter - page path : " + mainHtmlPagePath);
            if (com.up366.common.FileUtilsUp.isFile(mainHtmlPagePath)) {
                str = "file://" + mainHtmlPagePath;
            } else {
                com.up366.common.log.Logger.error("TAG - V8ExerciseView - loadHtmlCatalog - 文件不存在:" + mainHtmlPagePath);
                str = "about:blank";
            }
        }
        com.up366.common.log.Logger.info("TAG - StudyV8View - loadHtmlPage - ");
        this.jsInterface = new com.up366.mobile.book.jsinterface.JSInterfaceV8(this.studyActivityInterface, this);
        this.b.webView.removeJavascriptInterface("_android_js_obj_");
        this.b.webView.addJavascriptInterface(this.jsInterface, "_android_js_obj_");
        boolean zLoadUrlInQueue = this.b.webView.loadUrlInQueue(wrapUrl(str), this.cfg.pageNo);
        com.up366.common.log.Logger.info("TAG - V8ExerciseView - loadHtmlPage - " + str);
        if (zLoadUrlInQueue) {
            onEnterPage();
        }
    }

    private java.lang.String wrapUrl(java.lang.String str) {
        if (str.contains("?")) {
            return str + "&app-version=" + this.appInfoHelper.getAppVersion();
        }
        return str + "?app-version=" + this.appInfoHelper.getAppVersion();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().registerNewId(this.mActivityCode, this.mInstanceId);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.registerHelper.callJsEvent("pause");
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.visibility = i;
    }

    public int getRealVisibility() {
        return this.visibility;
    }

    public void onResume() {
        this.registerHelper.callJsEvent("resume");
    }

    public boolean onBackPress() {
        if (this.registerHelper.hasRegister("beforeGoBack")) {
            this.registerHelper.callJsEvent("beforeGoBack");
            return true;
        }
        stopPlayback();
        return false;
    }

    public void stopPlayback() {
        this.audioHelper.release();
        this.speechRecordHelper.forceStopAll();
    }

    public void onPageDestroy() {
        onPageDestroy(false);
    }

    public void onPageDestroy(boolean z) {
        boolean zHasRegister = this.registerHelper.hasRegister("beforeLeavePage");
        this.registerHelper.callJsEvent("beforeLeavePage");
        if (com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().isValidId(this.mActivityCode, this.mInstanceId)) {
            this.registerHelper.destroy();
            com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().clearId(this.mActivityCode);
        }
        this.b.webView.setOnFinishedInterface(null);
        this.b.webView.clearCache(z);
        if (zHasRegister) {
            postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.book.studyviews.StudyV8View$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPageDestroy$4();
                }
            }, 500L);
        } else {
            com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "_android_js_obj_");
        }
        stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$4() {
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "_android_js_obj_");
    }

    @Override // android.view.View
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.JSGlobalEvent jSGlobalEvent) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(jSGlobalEvent.getMsg());
        com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("webviewIdList");
        if (jSONArray == null || jSONArray.size() <= 0 || jSONArray.contains(this.currentWebViewId)) {
            if (android.text.TextUtils.equals("_EVT_HEADSET_STATUS_CHANGE_", object.getString("type"))) {
                this.registerHelper.callJsEvent("headSetStatusChange", "(%s)", object.getJSONObject("detail").toJSONString());
            } else {
                com.up366.common.log.Logger.info("TAG - StudyV8View - JSGlobalEvent - " + jSGlobalEvent.getMsg());
                this.registerHelper.callJsEvent("message", "(%s)", jSGlobalEvent.getMsg());
            }
        }
    }

    public void refreshData() {
        this.registerHelper.callJsEvent("bookdataupdate");
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.common.event.NetStatusChangeEvent netStatusChangeEvent) {
        java.lang.String netWorkInfo = this.appInfoHelper.getNetWorkInfo();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("type", "_EVT_NETWORK_CHANGE_");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("networkType", netWorkInfo);
        jSONObject.put("detail", jSONObject2);
        this.registerHelper.callJsEvent("message", "(%s)", jSONObject.toJSONString());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("type", "_EVT_LOGIN_STATE_CHANGE_");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("status", 1);
        jSONObject.put("detail", jSONObject2);
        this.registerHelper.callJsEvent("message", "(%s)", jSONObject.toJSONString());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.EventScanPaperGeneralSubmitData eventScanPaperGeneralSubmitData) {
        com.up366.common.log.Logger.info("onMessageEvent - EventScanPaperGeneralSubmitData - " + eventScanPaperGeneralSubmitData.getSubmitData());
        if (eventScanPaperGeneralSubmitData.getSubmitData() == null || !java.util.Objects.equals(this.currentWebViewId, eventScanPaperGeneralSubmitData.getCurWebViewId())) {
            return;
        }
        com.up366.common.log.Logger.info("TAG - StudyV8View - onMessageEvent - EventScanPaperGeneralSubmitData call ");
        this.registerHelper.callJsEvent("scanPaperDataObtained", "(%s)", eventScanPaperGeneralSubmitData.getSubmitData().toJSONString());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        this.fileUploadHelper.onMessageEvent_BATCH_JS_UPLOAD(commonUploadLogEvent);
        this.fileUploadHelper.onMessageEvent_BATCH_TASK(commonUploadLogEvent);
        this.fileUploadHelper.onMessageEvent_BATCH_APP_LOG(commonUploadLogEvent);
        this.fileUploadHelper.onMessageEvent_BATCH_JS_UPLOAD_COMMON_V8(commonUploadLogEvent);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.UpdateCookiesEvent updateCookiesEvent) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("code", java.lang.Integer.valueOf(updateCookiesEvent.getCode()));
        jSONObject.put("type", updateCookiesEvent.getType());
        jSONObject.put("detail", new com.alibaba.fastjson.JSONObject());
        this.registerHelper.callJsEvent("message", "(%s)", jSONObject.toJSONString());
    }

    public void onTopResumedActivityChanged(boolean z) {
        if (this.registerHelper.hasRegister("onTopResumedActivityChanged")) {
            this.registerHelper.callJsEvent("onTopResumedActivityChanged", "(%s)", java.lang.Boolean.valueOf(z));
        }
    }

    public java.lang.String getCurrentPageUrl() {
        return this.b.webView.getCurrentPageUrl();
    }

    public java.lang.String getCurrentWebViewId() {
        return this.currentWebViewId;
    }

    private java.lang.String generateUniqueId() {
        return java.util.UUID.randomUUID().toString() + "_" + java.lang.System.currentTimeMillis();
    }

    private java.lang.String generateUniqueCode(android.content.Context context) {
        return context != null ? java.lang.String.valueOf(context.hashCode()) : "";
    }
}
