package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyV7View extends android.widget.FrameLayout {
    public com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    public com.up366.mobile.book.helper.V7AudioHelper audioHelper;
    public com.up366.mobile.databinding.BookStudyV7FragmentLayoutBinding b;
    private com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    public com.up366.mobile.book.helper.V7BookTaskLogHelper bookTaskLogHelper;
    public com.up366.mobile.book.model.OpenConfigInfo cfg;
    public android.app.Activity context;
    public com.up366.mobile.book.helper.V7ChapterDataHelper dataHelper;
    public com.up366.mobile.book.helper.V7FileUploadHelper fileUploadHelper;
    private java.lang.String mActivityCode;
    private java.lang.String mInstanceId;
    public com.up366.mobile.book.helper.V7ExerciseOpenHelper openHelper;
    private com.up366.mobile.book.model.CatalogPage page;
    public com.up366.mobile.book.helper.V7RecordHelper recordHelper;
    public com.up366.mobile.book.helper.V7RegisterHelper registerHelper;
    public com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    public com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    private int visibility;

    public StudyV7View(android.content.Context context) {
        this(context, null);
    }

    public StudyV7View(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StudyV7View(android.content.Context context, android.util.AttributeSet attributeSet, int i) throws java.lang.Throwable {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.BookStudyV7FragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.book_study_v7_fragment_layout, this, true);
        initData(context);
        initChapterPageData(this.bookChapterInfo);
        initHelpers(context);
        initViewData();
        loadHtmlPage();
        this.mInstanceId = generateUniqueId();
        this.mActivityCode = generateUniqueCode(context);
        this.studyActivityInterface.showLoading(true, true);
    }

    private void initViewData() {
        this.b.webView.setHasAnim(false);
        if (this.studyActivityInterface.getTitleBar() != null) {
            this.studyActivityInterface.getTitleBar().setTitle(this.cfg.title);
        }
        this.b.webView.getBridgeHelper().setEnable(true);
    }

    private void initHelpers(android.content.Context context) {
        this.dataHelper = new com.up366.mobile.book.helper.V7ChapterDataHelper();
        this.speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(context);
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(this.context, this.b.webView);
        this.dataHelper.init(this.bookChapterInfo.getBook(), this.studyActivityInterface.getBookFilePathHelper());
        this.openHelper = new com.up366.mobile.book.helper.V7ExerciseOpenHelper(this);
        this.registerHelper = new com.up366.mobile.book.helper.V7RegisterHelper(this.studyActivityInterface, this.b.webView, this.openHelper);
        this.fileUploadHelper = new com.up366.mobile.book.helper.V7FileUploadHelper(this);
        this.bookTaskLogHelper = new com.up366.mobile.book.helper.V7BookTaskLogHelper(this.page, this.studyActivityInterface.getBookInfoStudy(), this.studyActivityInterface.getOpenConfigInfo());
        this.recordHelper = new com.up366.mobile.book.helper.V7RecordHelper(this.b.webView, this.dataHelper, this.page, this.speechRecordHelper, this.registerHelper);
        this.audioHelper = new com.up366.mobile.book.helper.V7AudioHelper(this.b.webView, this.recordHelper, this.registerHelper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData(android.content.Context context) {
        this.context = (android.app.Activity) context;
        com.up366.mobile.book.StudyActivityInterface studyActivityInterface = (com.up366.mobile.book.StudyActivityInterface) context;
        this.studyActivityInterface = studyActivityInterface;
        if (studyActivityInterface.getTitleBar() != null) {
            this.studyActivityInterface.getTitleBar().setVisibility(8);
        }
        this.studyActivityInterface.showLoadingTitleBar(false);
        this.bookChapterInfo = this.studyActivityInterface.getBookChapterInfo();
        this.cfg = this.studyActivityInterface.getOpenConfigInfo();
    }

    private void initChapterPageData(com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
        if (this.cfg.isCatalog()) {
            return;
        }
        this.studyActivityInterface.getBookChapterInfo().getChapter(this.cfg.chapterId);
        this.page = treeBookChapter.getPages().get(this.cfg.pageNo);
        com.up366.mobile.common.logic.Auth.cur().bookProgress().set(treeBookChapter.getBook(), this.page);
    }

    private void onEnterPage() {
        if (!this.cfg.isCatalog()) {
            this.bookTaskLogHelper.onEnterPage();
        }
        if (this.b.webView.isPageHasLoaded()) {
            this.b.webView.setOnFinishedInterface(null);
            com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV7View$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onEnterPage$0();
                }
            });
        } else {
            this.b.webView.setOnFinishedInterface(new com.up366.mobile.book.callback.FinishCallback(this.studyActivityInterface));
        }
        com.up366.mobile.book.StudyActivityInterface studyActivityInterface = this.studyActivityInterface;
        studyActivityInterface.buildBookPagePath(studyActivityInterface.getBookInfoStudy(), this.page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$0() throws java.lang.Exception {
        this.studyActivityInterface.showLoading(false);
    }

    private void loadHtmlPage() throws java.lang.Throwable {
        java.lang.String str;
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.cfg.openUrl)) {
            str = this.cfg.openUrl;
            com.up366.common.log.Logger.debug("html open - page path : " + this.cfg.openUrl);
        } else if (this.cfg.isCatalog()) {
            java.lang.String htmlCatalogPath = this.studyActivityInterface.getBookFilePathHelper().getHtmlCatalogPath();
            com.up366.common.log.Logger.debug("html chapter - page path : " + htmlCatalogPath);
            if (com.up366.common.FileUtilsUp.isFile(htmlCatalogPath)) {
                str = "file://" + htmlCatalogPath;
            } else {
                com.up366.common.log.Logger.error("TAG - V7ExerciseView - loadHtmlCatalog - 文件不存在:" + htmlCatalogPath);
                str = "about:blank";
            }
        } else {
            java.lang.String v7StudyPagePath = this.studyActivityInterface.getBookFilePathHelper().getV7StudyPagePath();
            if (com.up366.common.FileUtilsUp.isFile(v7StudyPagePath)) {
                str = "file://" + v7StudyPagePath;
            } else {
                com.up366.common.log.Logger.error("TAG - V7ExerciseView - loadHtmlPage - 文件不存在:" + v7StudyPagePath);
                str = "about:blank";
            }
        }
        com.up366.common.log.Logger.info("TAG - StudyV7View - loadHtmlPage - cfg.pageNo : " + this.cfg.pageNo);
        com.up366.mobile.book.jsinterface.JSInterfaceV7 jSInterfaceV7 = new com.up366.mobile.book.jsinterface.JSInterfaceV7(this.studyActivityInterface, this, this.page, this.cfg.pageNo);
        this.b.webView.removeJavascriptInterface("_android_js_obj_");
        this.b.webView.addJavascriptInterface(jSInterfaceV7, "_android_js_obj_");
        boolean zLoadUrlInQueue = this.b.webView.loadUrlInQueue(str, this.cfg.pageNo);
        com.up366.common.log.Logger.info("TAG - V7ExerciseView - loadHtmlPage - " + str);
        if (zLoadUrlInQueue) {
            onEnterPage();
        }
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
        if (this.cfg.isCatalog()) {
            return;
        }
        this.bookTaskLogHelper.onPause();
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
        if (this.cfg.isCatalog()) {
            return;
        }
        this.bookTaskLogHelper.onResume();
    }

    public boolean onBackPress() {
        if (this.registerHelper.hasRegister("beforegoback")) {
            this.registerHelper.callJsEvent("beforegoback");
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
        this.registerHelper.callJsEvent("beforewebviewdestory");
        if (com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().isValidId(this.mActivityCode, this.mInstanceId)) {
            this.registerHelper.destroy();
            com.up366.mobile.book.studyviews.ViewLifecycleManager.getInstance().clearId(this.mActivityCode);
        }
        this.b.webView.setOnFinishedInterface(null);
        postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.book.studyviews.StudyV7View$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPageDestroy$2();
            }
        }, 500L);
        stopPlayback();
        if (this.cfg.isCatalog()) {
            return;
        }
        this.bookTaskLogHelper.onStop();
        com.up366.mobile.common.logic.Auth.cur().bookProgress().setCurrentPageId(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$1() throws java.lang.Exception {
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "_android_js_obj_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$2() {
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV7View$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onPageDestroy$1();
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
        this.registerHelper.callJsEvent("message", "(%s)", jSGlobalEvent.getMsg());
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
    public void onMessageEvent(com.up366.mobile.common.event.UpdateCookiesEvent updateCookiesEvent) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("code", java.lang.Integer.valueOf(updateCookiesEvent.getCode()));
        jSONObject.put("type", updateCookiesEvent.getType());
        jSONObject.put("detail", new com.alibaba.fastjson.JSONObject());
        this.registerHelper.callJsEvent("message", "(%s)", jSONObject.toJSONString());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        this.fileUploadHelper.onMessageEvent_BATCH_JS_UPLOAD(commonUploadLogEvent);
        this.fileUploadHelper.onMessageEvent_BATCH_TASK(commonUploadLogEvent);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.TaskScoreUpdateEvent taskScoreUpdateEvent) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV7View$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$3(taskScoreUpdateEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$3(com.up366.mobile.common.event.TaskScoreUpdateEvent taskScoreUpdateEvent) throws java.lang.Exception {
        com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo = this.studyActivityInterface.getBookChapterInfo().getTaskMap().get(taskScoreUpdateEvent.getTaskId());
        if (bookTaskFinishedInfo == null) {
            bookTaskFinishedInfo = (com.up366.mobile.book.model.BookTaskFinishedInfo) com.up366.mobile.common.logic.Auth.cur().db().getBookTaskFinishedInfoDao().queryBuilder().where(com.up366.greendao.BookTaskFinishedInfoDao.Properties.TaskId.eq(taskScoreUpdateEvent.getTaskId()), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
            this.studyActivityInterface.getBookChapterInfo().getTaskMap().put(taskScoreUpdateEvent.getTaskId(), bookTaskFinishedInfo);
        }
        if (bookTaskFinishedInfo.getAddDate() == 0) {
            bookTaskFinishedInfo.setAddDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            bookTaskFinishedInfo.setChapterId(taskScoreUpdateEvent.getChapterId());
        }
        bookTaskFinishedInfo.setScore(taskScoreUpdateEvent.getScore());
        bookTaskFinishedInfo.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        bookTaskFinishedInfo.setPercent(taskScoreUpdateEvent.getPercent());
        this.studyActivityInterface.getBookChapterInfo().init(this.studyActivityInterface.getBookChapterInfo().getBook());
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV7View$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() {
                this.f$0.refreshData();
            }
        });
    }

    public boolean checkPageChange() {
        if (this.cfg.pageNo < 0 || this.page == null || this.cfg.pageNo == this.page.getPageNo()) {
            return false;
        }
        com.up366.common.log.Logger.warn("TAG - StudyV7View - checkPageChange - cfg.pageNo:" + this.cfg.pageNo + " page.getPageNo():" + this.page.getPageNo() + " cfg:" + this.cfg);
        com.up366.mobile.common.onlinelog.OpLog.report("checkPageChange", "StudyV7View cfg.pageNo:" + this.cfg.pageNo + " page.getPageNo():" + this.page.getPageNo() + " cfg:" + this.cfg);
        return true;
    }

    public void onTopResumedActivityChanged(boolean z) {
        if (this.registerHelper.hasRegister("onTopResumedActivityChanged")) {
            this.registerHelper.callJsEvent("onTopResumedActivityChanged", "(%s)", java.lang.Boolean.valueOf(z));
        }
    }

    private java.lang.String generateUniqueId() {
        return java.util.UUID.randomUUID().toString() + "_" + java.lang.System.currentTimeMillis();
    }

    private java.lang.String generateUniqueCode(android.content.Context context) {
        return context != null ? java.lang.String.valueOf(context.hashCode()) : "";
    }
}
