package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterHtmlView extends android.widget.FrameLayout {
    public com.up366.mobile.databinding.HtmlBookActivityMainBinding b;
    public com.up366.mobile.book.model.OpenConfigInfo cfg;
    private com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.helper.CourseCountHelper courseCountHelper;
    public com.up366.mobile.book.helper.V6HttpHelper httpHelper;
    private com.up366.mobile.book.jsinterface.ChapterJSInterface jsInterface;
    public com.up366.mobile.book.helper.HtmlChapterOpenNewPageHelper openNewPageHelper;
    public com.up366.mobile.book.helper.V6RegisterHelper registerHelper;
    private int remeberProductId;

    public ChapterHtmlView(android.content.Context context) {
        this(context, null);
    }

    public ChapterHtmlView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChapterHtmlView(android.content.Context context, android.util.AttributeSet attributeSet, int i) throws java.lang.Throwable {
        super(context, attributeSet, i);
        this.remeberProductId = -1;
        this.context = (com.up366.mobile.book.StudyActivity) getContext();
        this.openNewPageHelper = new com.up366.mobile.book.helper.HtmlChapterOpenNewPageHelper(this.context, this);
        this.b = (com.up366.mobile.databinding.HtmlBookActivityMainBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.html_book_activity_main, this, true);
        this.courseCountHelper = new com.up366.mobile.book.helper.CourseCountHelper(this.context.titleBar, this.context.book);
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = (com.up366.mobile.book.model.OpenConfigInfo) this.context.getIntent().getSerializableExtra("cfg");
        this.cfg = openConfigInfo;
        if (openConfigInfo == null) {
            com.up366.mobile.book.model.OpenConfigInfo openConfigInfo2 = new com.up366.mobile.book.model.OpenConfigInfo();
            this.cfg = openConfigInfo2;
            openConfigInfo2.pageNo = -1;
            this.cfg.title = this.context.bookChapterInfo.getBook().getBookName();
        }
        initView();
    }

    private void initView() throws java.lang.Throwable {
        this.context.titleBar.setTitle(this.cfg.title);
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.book.studyviews.ChapterHtmlView$$ExternalSyntheticLambda1
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$initView$0();
            }
        });
        this.registerHelper = new com.up366.mobile.book.helper.V6RegisterHelper(this.b.webView);
        this.httpHelper = new com.up366.mobile.book.helper.V6HttpHelper(this.b.webView, this.registerHelper);
        this.b.webView.setOnFinishedInterface(new com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface() { // from class: com.up366.mobile.book.studyviews.ChapterHtmlView$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface
            public final void onFinish() {
                this.f$0.lambda$initView$1();
            }
        });
        this.jsInterface = new com.up366.mobile.book.jsinterface.ChapterJSInterface(this.context, this);
        this.b.webView.addJavascriptInterface(this.jsInterface, "jsChapterObj");
        loadUrl();
        com.up366.mobile.book.StudyActivity studyActivity = this.context;
        studyActivity.buildBookPagePath(studyActivity.book, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        com.up366.mobile.common.logic.Auth.cur().book().fetchChapterPlanAndFinishedTask(this.context.bookChapterInfo, !android.text.TextUtils.isEmpty(this.cfg.studyTaskId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1() {
        this.b.webView.callJSMethod("onEnterPage()");
        this.context.showLoading(false);
    }

    private void loadUrl() throws java.lang.Throwable {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.cfg.openUrl)) {
            java.lang.String htmlCatalogPath = this.context.bookFilePathHelper.getHtmlCatalogPath();
            com.up366.common.log.Logger.debug("html chapter - page path : " + htmlCatalogPath);
            this.b.webView.loadUrlInQueue("file://" + htmlCatalogPath, 0);
            return;
        }
        com.up366.common.log.Logger.debug("html chapter - page path : " + this.cfg.openUrl);
        this.b.webView.loadUrlInQueue(this.cfg.openUrl, 0);
    }

    public void refreshData() {
        this.b.webView.callJSMethod("refreshSubCatalog()");
        this.b.webView.callJSMethod("onCatalogDataChange()");
        this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_CHAPTER_REFRESHED);
        if (this.remeberProductId > -1) {
            this.b.webView.callJSMethod("onBuySuccess(%d)", java.lang.Integer.valueOf(this.remeberProductId));
            this.remeberProductId = -1;
        }
    }

    public void onResumeBack() {
        this.b.refreshLayout.setContentView(this.b.webView);
        this.b.webView.callJSMethod("refreshSubCatalog()");
        this.b.webView.callJSMethod("onResume()");
    }

    public boolean onBackPressed() {
        if (!this.registerHelper.hasRegister(com.up366.mobile.book.helper.V6RegisterHelper.EVT_BACKBTN_CLICK)) {
            return false;
        }
        this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_BACKBTN_CLICK);
        return true;
    }

    public void onPageDestroy() {
        this.jsInterface.audioHelper.release();
        this.b.webView.callJSMethod("onPageExchange()");
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.ChapterHtmlView$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onPageDestroy$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$2() throws java.lang.Exception {
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "jsChapterObj");
    }

    public void onBuySuccess(int i) {
        com.up366.common.log.Logger.info("TAG - 2018/6/7 - ChapterHtmlFragment - onBuySuccess - productId = [" + i + "]");
        this.b.webView.callJSMethod("onBuySuccess(%d)", java.lang.Integer.valueOf(i));
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.TaskScoreUpdateEvent taskScoreUpdateEvent) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.ChapterHtmlView$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$4(taskScoreUpdateEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$4(com.up366.mobile.common.event.TaskScoreUpdateEvent taskScoreUpdateEvent) throws java.lang.Exception {
        com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo = this.context.bookChapterInfo.getTaskMap().get(taskScoreUpdateEvent.getTaskId());
        if (bookTaskFinishedInfo == null) {
            bookTaskFinishedInfo = (com.up366.mobile.book.model.BookTaskFinishedInfo) com.up366.mobile.common.logic.Auth.cur().db().getBookTaskFinishedInfoDao().queryBuilder().where(com.up366.greendao.BookTaskFinishedInfoDao.Properties.TaskId.eq(taskScoreUpdateEvent.getTaskId()), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
            this.context.bookChapterInfo.getTaskMap().put(taskScoreUpdateEvent.getTaskId(), bookTaskFinishedInfo);
        }
        if (bookTaskFinishedInfo.getAddDate() == 0) {
            bookTaskFinishedInfo.setAddDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            bookTaskFinishedInfo.setChapterId(taskScoreUpdateEvent.getChapterId());
        }
        bookTaskFinishedInfo.setScore(taskScoreUpdateEvent.getScore());
        bookTaskFinishedInfo.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        bookTaskFinishedInfo.setPercent(taskScoreUpdateEvent.getPercent());
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(this.context.book.getBookId());
        final com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("chapterId", bookScheduleInfo.getChapterId());
        com.up366.mobile.book.model.CatalogChapter chapter = this.context.bookChapterInfo.getChapter(bookScheduleInfo.getChapterId());
        jSONObject.put("taskStudyNum", java.lang.Integer.valueOf(chapter != null ? chapter.getStudyTaskNum() : 0));
        this.context.bookChapterInfo.init(this.context.bookChapterInfo.getBook());
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.ChapterHtmlView$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$3(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$3(com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Exception {
        refreshData();
        if (this.registerHelper.hasRegister(com.up366.mobile.book.helper.V6RegisterHelper.EVT_REFRESH_CHAPTER)) {
            this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_REFRESH_CHAPTER, "(%s)", jSONObject.toString());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.getType() == 1 && (commonUploadLogEvent.isSuccess() || commonUploadLogEvent.isFailed())) {
            this.b.webView.callJSMethod("onCatalogDataChange()");
        }
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
    public void onMessageEvent(com.up366.mobile.common.event.JSGlobalEvent jSGlobalEvent) {
        this.registerHelper.callJsEvent("message", "(%s)", jSGlobalEvent.getMsg());
    }

    private void callJsOnUploadPro(int i, int i2, com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        this.b.webView.callJSMethod("onFileUploadPro({\n      result: {\n          code: %d,   \n          msg: \"%s\",   \n      },\n      data: {        \n          id: '%s',    \n          status: %d,\n          percent: %d,\n      }\n  })", java.lang.Integer.valueOf(i), commonUploadLogEvent.getErrInfo(), commonUploadLogEvent.getRefKey(), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(commonUploadLogEvent.getPercent()));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @Override // android.view.View
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public void onPause() {
        this.jsInterface.audioHelper.pauseAll();
        this.b.webView.callJSMethod("onPause()");
        com.up366.mobile.common.logic.Auth.cur().bookProgress().save(this.context.book);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.BookChapterRefresh bookChapterRefresh) {
        if (bookChapterRefresh.getResp() != null) {
            this.b.refreshLayout.complete();
        }
    }
}
