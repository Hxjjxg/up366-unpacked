package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6ExerciseView extends android.widget.FrameLayout {
    public com.up366.mobile.book.helper.V6AudioHelper audioHelper;
    public com.up366.mobile.book.helper.BookTaskLogHelper bookTaskLogHelper;
    private com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.helper.V6ChapterDataHelper dataHelper;
    private com.up366.mobile.book.jsinterface.JSInterfaceV6 jsInterface;
    private java.lang.String mActivityCode;
    private java.lang.String mInstanceId;
    private com.up366.mobile.book.model.CatalogPage page;
    private int position;
    public com.up366.mobile.book.helper.V6RecordHelper recordHelper;
    public com.up366.mobile.book.helper.V6RegisterHelper registerHelper;
    public com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    public com.up366.mobile.book.studyviews.StudyV6View studyFragment;
    private java.lang.String url;
    public com.up366.mobile.book.studyviews.view.video.AnswerVideoView videoView;
    public com.up366.mobile.book.webview.StudyPageWebView webView;

    public V6ExerciseView(android.content.Context context) {
        this(context, null);
    }

    public V6ExerciseView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V6ExerciseView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = new com.up366.mobile.book.webview.StudyPageWebView(context);
        this.webView = studyPageWebView;
        addView(studyPageWebView, -1, -1);
        this.context = (com.up366.mobile.book.StudyActivity) context;
        this.registerHelper = new com.up366.mobile.book.helper.V6RegisterHelper(this.webView);
        initView();
        this.mInstanceId = generateUniqueId();
        this.mActivityCode = generateUniqueCode(context);
    }

    private void initView() {
        this.webView.setHasAnim(false);
    }

    public void setParams(com.up366.mobile.book.helper.V6ChapterDataHelper v6ChapterDataHelper, com.up366.mobile.book.model.CatalogPage catalogPage, int i, com.up366.mobile.book.studyviews.StudyV6View studyV6View, com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper, java.lang.String str) {
        this.bookTaskLogHelper = new com.up366.mobile.book.helper.BookTaskLogHelper(catalogPage, this.context.book, this.context.cfg);
        this.dataHelper = v6ChapterDataHelper;
        this.page = catalogPage;
        this.position = i;
        this.studyFragment = studyV6View;
        this.speechRecordHelper = speechRecordHelper;
        com.up366.mobile.book.helper.V6RecordHelper v6RecordHelper = new com.up366.mobile.book.helper.V6RecordHelper(this.webView, v6ChapterDataHelper, catalogPage, speechRecordHelper);
        this.recordHelper = v6RecordHelper;
        this.audioHelper = new com.up366.mobile.book.helper.V6AudioHelper(this.webView, v6RecordHelper);
        this.jsInterface = new com.up366.mobile.book.jsinterface.JSInterfaceV6(this.context, this, catalogPage, i);
        this.url = str;
    }

    public void destroy() {
        this.audioHelper.release();
        if (com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().isValidId(this.mActivityCode, this.mInstanceId)) {
            this.registerHelper.destroy();
            com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().clearId(this.mActivityCode);
        }
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.V6ExerciseView$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$destroy$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$destroy$0() throws java.lang.Exception {
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.webView, "jsObj");
    }

    public void onEnterPage() {
        this.jsInterface.videoHelper.onEnterPage();
        this.bookTaskLogHelper.onEnterPage();
        if (this.webView.isPageHasLoaded()) {
            this.webView.setOnFinishedInterface(null);
            this.webView.callJSMethod("onEnterPage()");
            com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.V6ExerciseView$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onEnterPage$1();
                }
            });
        } else {
            this.webView.setOnFinishedInterface(new com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface() { // from class: com.up366.mobile.book.studyviews.view.V6ExerciseView$$ExternalSyntheticLambda2
                @Override // com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface
                public final void onFinish() {
                    this.f$0.lambda$onEnterPage$3();
                }
            });
        }
        com.up366.mobile.book.StudyActivity studyActivity = this.context;
        studyActivity.buildBookPagePath(studyActivity.book, this.page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$1() throws java.lang.Exception {
        this.context.showLoading(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$3() {
        if (this.dataHelper.curPosition == this.position) {
            this.webView.callJSMethod("onEnterPage()");
            com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.V6ExerciseView$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onEnterPage$2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$2() throws java.lang.Exception {
        this.context.showLoading(false);
    }

    public void onPageExchange() {
        this.bookTaskLogHelper.onStop();
        this.webView.callJSMethod("onPageExchange()");
        this.jsInterface.videoHelper.onDestroy();
        this.jsInterface.audioHelper.pauseAll();
    }

    public void refresh() {
        java.lang.String str;
        boolean z = true;
        if (com.up366.common.StringUtils.isEmptyOrNull(this.url)) {
            java.lang.String pageHtmlPath = this.dataHelper.getPageHtmlPath(this.page);
            if (com.up366.common.FileUtilsUp.isFileExists(pageHtmlPath)) {
                str = "file://" + pageHtmlPath;
            } else {
                com.up366.common.log.Logger.error("TAG - 2018/5/30 - V6ExerciseView - refresh - 文件不存在:" + pageHtmlPath);
                str = "about:blank";
                z = false;
            }
        } else {
            str = this.url;
        }
        this.webView.removeJavascriptInterface("jsObj");
        this.webView.addJavascriptInterface(this.jsInterface, "jsObj");
        boolean zLoadUrlInQueue = this.webView.loadUrlInQueue(str, this.position);
        com.up366.common.log.Logger.info("TAG - 2018/6/7 - V6ExerciseView - refresh - " + str);
        if (this.dataHelper.curPosition == this.position && z && zLoadUrlInQueue) {
            onEnterPage();
        }
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public void onPause() {
        this.audioHelper.pauseAll();
        this.bookTaskLogHelper.onPause();
        this.jsInterface.videoHelper.onPause();
        this.webView.callJSMethod("onPause()");
    }

    public void onResume() {
        this.bookTaskLogHelper.onResume();
        this.jsInterface.videoHelper.onResume();
        this.webView.callJSMethod("onResume()");
    }

    public boolean isVideoFullScreen() {
        return this.jsInterface.videoHelper.isVideoFullScreen();
    }

    public void toggleVideoFullScreen() {
        this.jsInterface.videoHelper.toggleVideoFullScreen();
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

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.getType() != 10) {
            return;
        }
        if (commonUploadLogEvent.isProgressUpdate()) {
            callJsOnUploadPro(0, 0, commonUploadLogEvent);
        }
        if (commonUploadLogEvent.isFailed()) {
            com.up366.mobile.common.logic.Auth.cur().logMgr().deleteTask(commonUploadLogEvent.getBatchId());
            callJsOnUploadPro(-1, -1, commonUploadLogEvent);
        }
        if (commonUploadLogEvent.isSuccess()) {
            callJsOnUploadPro(0, 1, commonUploadLogEvent);
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.FeedbackTaskUploadSuccess feedbackTaskUploadSuccess) {
        com.up366.mobile.book.model.CatalogPage catalogPage = this.page;
        if (catalogPage == null) {
            return;
        }
        if (feedbackTaskUploadSuccess.getTaskId().equals(catalogPage.obj.getTaskId())) {
            this.webView.callJSMethod("onFeedbackUpload(0)");
        }
    }

    private void callJsOnUploadPro(int i, int i2, com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        this.webView.callJSMethod("onFileUploadPro({\n      result: {\n          code: %d,   \n          msg: \"%s\",   \n      },\n      data: {        \n          id: '%s',    \n          status: %d,\n          percent: %d,\n      }\n  })", java.lang.Integer.valueOf(i), commonUploadLogEvent.getErrInfo(), commonUploadLogEvent.getRefKey(), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(commonUploadLogEvent.getPercent()));
    }

    @Override // android.view.View
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    private java.lang.String generateUniqueId() {
        return java.util.UUID.randomUUID().toString() + "_" + java.lang.System.currentTimeMillis();
    }

    private java.lang.String generateUniqueCode(android.content.Context context) {
        return context != null ? java.lang.String.valueOf(context.hashCode()) : "";
    }
}
