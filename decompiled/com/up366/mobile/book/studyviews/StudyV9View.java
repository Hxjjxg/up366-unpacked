package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyV9View extends android.widget.FrameLayout {
    public com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    public com.up366.mobile.book.helper.V9AudioHelper audioHelper;
    public com.up366.mobile.databinding.BookStudyV9FragmentLayoutBinding b;
    private com.up366.mobile.book.model.BookInfoStudy book;
    public com.up366.mobile.book.helper.V9BookTaskLogHelper bookTaskLogHelper;
    public com.up366.mobile.book.model.OpenConfigInfo cfg;
    public android.app.Activity context;
    public final java.lang.String currentWebViewId;
    public com.up366.mobile.book.helper.V9ResourceHelper dataHelper;
    private com.up366.mobile.book.helper.V9FileUploadHelper fileUploadHelper;
    private com.up366.mobile.book.jsinterface.JSInterfaceV9 jsInterface;
    private boolean launchOptionsRestoreScheduled;
    private java.lang.String mActivityCode;
    private java.lang.String mInstanceId;
    public com.up366.mobile.book.helper.V9OpenHelper openHelper;
    private java.lang.String pendingRestorePageRoute;
    public com.up366.mobile.book.helper.V9RecordHelper recordHelper;
    public com.up366.mobile.book.helper.V9RegisterHelper registerHelper;
    private java.lang.String restoredPageRoute;
    public com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    private com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    boolean updateTitleFromPage;
    private int visibility;

    public StudyV9View(android.content.Context context) {
        this(context, null);
    }

    public StudyV9View(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StudyV9View(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        boolean booleanValue;
        super(context, attributeSet, i);
        this.currentWebViewId = java.lang.String.valueOf(android.os.SystemClock.uptimeMillis());
        this.updateTitleFromPage = false;
        this.b = (com.up366.mobile.databinding.BookStudyV9FragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.book_study_v9_fragment_layout, this, true);
        initData(context);
        initHelpers(context);
        initViewData();
        loadHtmlPage();
        this.mInstanceId = generateUniqueId();
        this.mActivityCode = generateUniqueCode(context);
        if (this.cfg.openUrl != null) {
            this.cfg.openUrl.contains("js-hide-loading=0");
            this.studyActivityInterface.getTitleBar().setVisibility(this.cfg.openUrl.contains("show-navigationbar=1") ? 0 : 8);
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(this.cfg.exerciseData)) {
            booleanValue = false;
        } else {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(this.cfg.exerciseData);
            object.getBooleanValue(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_DISMISS_LOADING);
            booleanValue = object.getBooleanValue(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_SHOW_TITLE_BAR);
            this.updateTitleFromPage = object.getBooleanValue(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_UPDATE_TITLE_FROM_HTML);
        }
        this.studyActivityInterface.showLoading(true, true);
        if (booleanValue) {
            this.studyActivityInterface.getTitleBar().setVisibility(0);
        }
    }

    private void initViewData() {
        this.b.webView.setHasAnim(false);
        this.studyActivityInterface.getTitleBar().setTitle(this.cfg.title);
        this.b.webView.getBridgeHelper().setEnable(true);
        this.b.webView.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.up366.mobile.book.studyviews.StudyV9View.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (android.text.TextUtils.equals(webResourceRequest.getUrl().toString(), com.up366.mobile.book.studyviews.StudyV9View.this.b.webView.getUrl())) {
                    com.up366.common.log.Logger.error("TAG - StudyV9View - onReceivedError - load url error " + webResourceRequest.getUrl());
                    com.up366.mobile.book.studyviews.StudyV9View.this.studyActivityInterface.showLoadErrorTip("加载失败", "网络错误，建议更换网络环境或稍后重试。");
                }
            }
        });
        this.b.webView.setWebChromeClient(new android.webkit.WebChromeClient() { // from class: com.up366.mobile.book.studyviews.StudyV9View.2
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
                super.onReceivedTitle(webView, str);
                if (com.up366.mobile.book.studyviews.StudyV9View.this.updateTitleFromPage) {
                    com.up366.mobile.book.studyviews.StudyV9View.this.studyActivityInterface.getTitleBar().setTitle(str);
                }
            }
        });
    }

    private void initHelpers(android.content.Context context) {
        this.dataHelper = new com.up366.mobile.book.helper.V9ResourceHelper();
        this.speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(context);
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(this.context, this.b.webView);
        this.openHelper = new com.up366.mobile.book.helper.V9OpenHelper(this);
        this.registerHelper = new com.up366.mobile.book.helper.V9RegisterHelper(this.studyActivityInterface, this.b.webView);
        this.fileUploadHelper = new com.up366.mobile.book.helper.V9FileUploadHelper(this);
        this.bookTaskLogHelper = new com.up366.mobile.book.helper.V9BookTaskLogHelper(this.studyActivityInterface.getOpenConfigInfo());
        this.recordHelper = new com.up366.mobile.book.helper.V9RecordHelper(this.b.webView, this.speechRecordHelper, this.registerHelper);
        this.audioHelper = new com.up366.mobile.book.helper.V9AudioHelper(this.b.webView, this.recordHelper, this.registerHelper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData(android.content.Context context) {
        this.context = (android.app.Activity) context;
        com.up366.mobile.book.StudyActivityInterface studyActivityInterface = (com.up366.mobile.book.StudyActivityInterface) context;
        this.studyActivityInterface = studyActivityInterface;
        studyActivityInterface.getTitleBar().setVisibility(8);
        this.studyActivityInterface.showLoadingTitleBar(true);
        this.book = this.studyActivityInterface.getBookInfoStudy();
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.studyActivityInterface.getOpenConfigInfo();
        this.cfg = openConfigInfo;
        java.lang.String strNormalizeRestorePageRoute = normalizeRestorePageRoute(openConfigInfo.restoredPageRoute);
        this.restoredPageRoute = strNormalizeRestorePageRoute;
        this.pendingRestorePageRoute = strNormalizeRestorePageRoute;
    }

    private void onEnterPage() {
        final com.up366.mobile.book.callback.FinishCallback finishCallback = new com.up366.mobile.book.callback.FinishCallback(this.studyActivityInterface);
        if (this.b.webView.isPageHasLoaded()) {
            this.b.webView.setOnFinishedInterface(null);
            restorePageRouteIfNeeded();
            finishCallback.onFinish();
        } else {
            this.b.webView.setOnFinishedInterface(new com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface() { // from class: com.up366.mobile.book.studyviews.StudyV9View$$ExternalSyntheticLambda4
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
        com.up366.common.log.Logger.info("TAG - StudyV9View - restorePageRouteIfNeeded - route : " + str);
        applyRestorePageRoute(str, 50, "pageFinished");
    }

    public void scheduleRestorePageRouteAfterLaunchOptions() {
        final java.lang.String str = this.restoredPageRoute;
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV9View$$ExternalSyntheticLambda3
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
        com.up366.common.log.Logger.info("TAG - StudyV9View - scheduleRestorePageRouteAfterLaunchOptions - route : " + str);
        applyRestorePageRoute(str, 300, "launchOptions");
    }

    private void applyRestorePageRoute(final java.lang.String str, int i, final java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        if (i > 0) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(i, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV9View$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$applyRestorePageRoute$2(str2, str);
                }
            });
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV9View$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$applyRestorePageRoute$3(str2, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyRestorePageRoute$2(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - StudyV9View - applyRestorePageRoute - source = [" + str + "], route = [" + str2 + "]");
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = this.b.webView;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(function(){var route=");
        sb.append(com.alibaba.fastjson.JSON.toJSONString(str2));
        sb.append(";if(window.location.hash!==route){window.location.hash=route;}})();");
        studyPageWebView.callJSMethodIgnoreBridge(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyRestorePageRoute$3(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - StudyV9View - applyRestorePageRoute - source = [" + str + "], route = [" + str2 + "]");
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = this.b.webView;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(function(){var route=");
        sb.append(com.alibaba.fastjson.JSON.toJSONString(str2));
        sb.append(";if(window.location.hash!==route){window.location.hash=route;}})();");
        studyPageWebView.callJSMethodIgnoreBridge(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void loadHtmlPage() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "TAG - StudyV9View - loadHtmlPage - cfg : "
            r0.<init>(r1)
            com.up366.mobile.book.model.OpenConfigInfo r1 = r5.cfg
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.up366.common.log.Logger.info(r0)
            com.up366.mobile.book.model.OpenConfigInfo r0 = r5.cfg
            java.lang.String r0 = r0.taskId
            boolean r0 = com.up366.common.StringUtils.isEmptyOrNull(r0)
            if (r0 != 0) goto L26
            com.up366.mobile.book.model.OpenConfigInfo r0 = r5.cfg
            java.lang.String r0 = r0.taskId
            goto L48
        L26:
            com.up366.mobile.book.model.OpenConfigInfo r0 = r5.cfg
            java.lang.String r0 = r0.exerciseData
            boolean r0 = com.up366.common.StringUtils.isEmptyOrNull(r0)
            if (r0 != 0) goto L46
            com.up366.mobile.book.model.OpenConfigInfo r0 = r5.cfg
            java.lang.String r0 = r0.exerciseData
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.fastjson.JSON.parseObject(r0)
            java.lang.String r1 = "taskId"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L46
            java.lang.String r0 = r0.getString(r1)
            goto L48
        L46:
            java.lang.String r0 = ""
        L48:
            boolean r0 = com.up366.common.StringUtils.isEmptyOrNull(r0)
            if (r0 == 0) goto L77
            com.up366.mobile.book.model.OpenConfigInfo r0 = r5.cfg
            java.lang.String r0 = r0.openUrl
            boolean r0 = com.up366.common.StringUtils.isEmptyOrNull(r0)
            if (r0 != 0) goto L72
            com.up366.mobile.book.model.OpenConfigInfo r0 = r5.cfg
            java.lang.String r0 = r0.openUrl
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "TAG - StudyV9View - html open - page path : "
            r1.<init>(r2)
            com.up366.mobile.book.model.OpenConfigInfo r2 = r5.cfg
            java.lang.String r2 = r2.openUrl
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.up366.common.log.Logger.info(r1)
            goto L7b
        L72:
            java.lang.String r0 = r5.getHtmlPagePath()
            goto L7b
        L77:
            java.lang.String r0 = r5.getHtmlPagePath()
        L7b:
            java.lang.String r1 = "TAG - StudyV9View - loadHtmlPage - "
            com.up366.common.log.Logger.info(r1)
            com.up366.mobile.book.jsinterface.JSInterfaceV9 r2 = new com.up366.mobile.book.jsinterface.JSInterfaceV9
            com.up366.mobile.book.StudyActivityInterface r3 = r5.studyActivityInterface
            r2.<init>(r3, r5)
            r5.jsInterface = r2
            com.up366.mobile.databinding.BookStudyV9FragmentLayoutBinding r2 = r5.b
            com.up366.mobile.book.webview.StudyPageWebView r2 = r2.webView
            java.lang.String r3 = "_android_js_obj_"
            r2.removeJavascriptInterface(r3)
            com.up366.mobile.databinding.BookStudyV9FragmentLayoutBinding r2 = r5.b
            com.up366.mobile.book.webview.StudyPageWebView r2 = r2.webView
            com.up366.mobile.book.jsinterface.JSInterfaceV9 r4 = r5.jsInterface
            r2.addJavascriptInterface(r4, r3)
            com.up366.mobile.databinding.BookStudyV9FragmentLayoutBinding r2 = r5.b
            com.up366.mobile.book.webview.StudyPageWebView r2 = r2.webView
            java.lang.String r3 = r5.wrapUrl(r0)
            com.up366.mobile.book.model.OpenConfigInfo r4 = r5.cfg
            int r4 = r4.pageNo
            boolean r2 = r2.loadUrlInQueue(r3, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.up366.common.log.Logger.info(r0)
            if (r2 == 0) goto Lbf
            r5.onEnterPage()
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.studyviews.StudyV9View.loadHtmlPage():void");
    }

    private java.lang.String getHtmlPagePath() {
        java.lang.String mainHtmlPagePath = com.up366.mobile.book.helper.V9FilePathHelper.getMainHtmlPagePath(this.book.getFileId());
        com.up366.common.log.Logger.info("TAG - StudyV9View - getHtmlPagePath - html page path : " + mainHtmlPagePath);
        if (com.up366.common.FileUtilsUp.isFile(mainHtmlPagePath)) {
            return "file://" + mainHtmlPagePath;
        }
        com.up366.mobile.common.dialog.AppDialog.create(this.context).title("请联系教学顾问").message(this.context.getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-5)").btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.StudyV9View$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$getHtmlPagePath$4(view);
            }
        }).setBtnCloseVisibility(4).setCancelable(false).show();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - StudyV9View - loadHtml - 文件不存在:");
        sb.append(mainHtmlPagePath);
        com.up366.common.log.Logger.error(sb.toString());
        return "about:blank";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getHtmlPagePath$4(android.view.View view) {
        this.context.finish();
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
        this.audioHelper.release();
        this.speechRecordHelper.forceStopAll();
        return false;
    }

    public void onPageDestroy() {
        onPageDestroy(false);
    }

    public void onPageDestroy(boolean z) {
        this.registerHelper.callJsEvent("beforeLeavePage");
        if (com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().isValidId(this.mActivityCode, this.mInstanceId)) {
            this.registerHelper.destroy();
            com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().clearId(this.mActivityCode);
        }
        this.b.webView.setOnFinishedInterface(null);
        this.b.webView.clearCache(z);
        postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.book.studyviews.StudyV9View$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPageDestroy$6();
            }
        }, 500L);
        this.audioHelper.release();
        this.speechRecordHelper.forceStopAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$5() throws java.lang.Exception {
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "_android_js_obj_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$6() {
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV9View$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onPageDestroy$5();
            }
        });
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
                com.up366.common.log.Logger.info("TAG - StudyV9View - JSGlobalEvent - " + jSGlobalEvent.getMsg());
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
        com.up366.common.log.Logger.info("TAG - StudyV9View - onMessageEvent - EventScanPaperGeneralSubmitData call ");
        this.registerHelper.callJsEvent("scanPaperDataObtained", "(%s)", eventScanPaperGeneralSubmitData.getSubmitData().toJSONString());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        this.fileUploadHelper.onMessageEvent_BATCH_JS_UPLOAD(commonUploadLogEvent);
        this.fileUploadHelper.onMessageEvent_BATCH_TASK(commonUploadLogEvent);
        this.fileUploadHelper.onMessageEvent_BATCH_APP_LOG(commonUploadLogEvent);
        this.fileUploadHelper.onMessageEvent_BATCH_JS_UPLOAD_COMMON_V9(commonUploadLogEvent);
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
