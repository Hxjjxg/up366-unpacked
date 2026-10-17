package com.up366.mobile.book.exercise;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseHtmlView extends android.widget.FrameLayout {
    public com.up366.mobile.databinding.HtmlExerciseContentBinding b;
    private com.up366.mobile.book.model.OpenConfigInfo cfg;
    public com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.exercise.ExerciseDataHelper dataHelper;
    private com.up366.mobile.book.exercise.model.ExerciseDataHolder dataHolder;
    private com.up366.mobile.book.helper.ContentDownloadHelper downloadHelper;
    private com.up366.mobile.book.exercise.js.ExerciseHelper exerciseHelper;
    public com.up366.mobile.book.exercise.js.v2.FileUploadHelper fileUploadHelper;
    public com.up366.mobile.book.exercise.js.ExerciseJSInterface jsInterface;
    public com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2 jsInterfaceV2;
    private long lastLoadUrlErrorTime;
    private boolean loadRedirectUrlError;
    public com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private int visibility;

    public ExerciseHtmlView(android.content.Context context) {
        this(context, null);
    }

    public ExerciseHtmlView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExerciseHtmlView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadRedirectUrlError = false;
        this.lastLoadUrlErrorTime = 0L;
        this.dataHelper = new com.up366.mobile.book.exercise.ExerciseDataHelper();
        this.b = (com.up366.mobile.databinding.HtmlExerciseContentBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.html_exercise_content, this, true);
        com.up366.mobile.book.StudyActivity studyActivity = (com.up366.mobile.book.StudyActivity) context;
        this.context = studyActivity;
        this.downloadHelper = studyActivity.contentDownloadHelper;
        this.takePhotoHelper = this.context.takePhotoHelper;
        this.exerciseHelper = new com.up366.mobile.book.exercise.js.ExerciseHelper(this, this.dataHelper, this.context, this.takePhotoHelper);
        this.jsInterface = new com.up366.mobile.book.exercise.js.ExerciseJSInterface(this, this.exerciseHelper);
        this.jsInterfaceV2 = new com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2(this, this.exerciseHelper);
        this.dataHelper.init(this.context, this.dataHolder);
        this.context.titleBar.setVisibility(8);
        this.context.showLoadingTitleBar(true);
        this.fileUploadHelper = new com.up366.mobile.book.exercise.js.v2.FileUploadHelper(this);
        this.b.webView.getBridgeHelper().setEnable(true);
        this.b.webView.setWebViewClient(new com.up366.mobile.book.exercise.ExerciseHtmlView.AnonymousClass1(context));
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.exercise.ExerciseHtmlView$1, reason: invalid class name */
    class AnonymousClass1 extends android.webkit.WebViewClient {
        final /* synthetic */ android.content.Context val$context;

        AnonymousClass1(android.content.Context context) {
            this.val$context = context;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.up366.common.log.Logger.info("TAG - ExerciseHtmlView - onPageStarted - load url " + str);
            com.up366.mobile.book.exercise.ExerciseHtmlView.this.loadRedirectUrlError = false;
            com.up366.mobile.book.exercise.ExerciseHtmlView.this.lastLoadUrlErrorTime = java.lang.System.currentTimeMillis();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.up366.common.log.Logger.info("TAG - ExerciseHtmlView - onPageFinished - load url " + str + " " + (java.lang.System.currentTimeMillis() - com.up366.mobile.book.exercise.ExerciseHtmlView.this.lastLoadUrlErrorTime));
            if (java.lang.System.currentTimeMillis() - com.up366.mobile.book.exercise.ExerciseHtmlView.this.lastLoadUrlErrorTime > 100) {
                com.up366.mobile.book.exercise.ExerciseHtmlView.this.loadRedirectUrlError = false;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
            com.up366.common.log.Logger.error("TAG - ExerciseHtmlView - onReceivedError - load url error " + webResourceRequest.getUrl());
            if (android.text.TextUtils.equals(webResourceRequest.getUrl().toString(), com.up366.mobile.book.exercise.ExerciseHtmlView.this.b.webView.getUrl())) {
                com.up366.mobile.book.exercise.ExerciseHtmlView.this.loadRedirectUrlError = true;
                com.up366.mobile.book.exercise.ExerciseHtmlView.this.lastLoadUrlErrorTime = java.lang.System.currentTimeMillis();
                ((com.up366.mobile.book.StudyActivity) this.val$context).showLoadUrlErrorTip("加载失败", "网络错误，建议更换网络环境或稍后重试。", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.exercise.ExerciseHtmlView$1$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        this.f$0.lambda$onReceivedError$0(view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedError$0(android.view.View view) {
            if (com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.REDIRECT.equals(com.up366.mobile.book.exercise.ExerciseHtmlView.this.cfg.exerciseType)) {
                com.up366.mobile.book.exercise.ExerciseHtmlView.this.b.webView.loadUrl(com.up366.mobile.book.exercise.ExerciseHtmlView.this.b.webView.getUrl());
            } else {
                com.up366.mobile.book.exercise.ExerciseHtmlView.this.refresh();
            }
        }
    }

    public boolean onBackPress() {
        if (this.jsInterface.registerHelper.hasRegister("backpressed")) {
            this.jsInterface.registerHelper.callJsEvent("backpressed");
            return true;
        }
        if (this.loadRedirectUrlError || !this.jsInterfaceV2.registerHelper.hasRegister("beforegoback")) {
            return false;
        }
        this.jsInterfaceV2.registerHelper.callJsEvent("beforegoback");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$0() throws java.lang.Exception {
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "hwObj", "_android_js_obj_");
    }

    public void onPageDestroy() {
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.ExerciseHtmlView$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onPageDestroy$0();
            }
        });
        com.up366.mobile.book.exercise.js.ExerciseJSInterface exerciseJSInterface = this.jsInterface;
        if (exerciseJSInterface != null) {
            exerciseJSInterface.audioHelper.release();
        }
        com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2 exerciseJSInterfaceV2 = this.jsInterfaceV2;
        if (exerciseJSInterfaceV2 != null) {
            exerciseJSInterfaceV2.audioHelper.release();
        }
    }

    public void refresh() {
        this.context.setTitle(this.exerciseHelper.getLoadingTitle());
        this.dataHelper.initExerciseData(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.exercise.ExerciseHtmlView$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$refresh$1(i, str, (com.up366.mobile.book.exercise.model.ExerciseData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$1(int i, java.lang.String str, com.up366.mobile.book.exercise.model.ExerciseData exerciseData) {
        this.dataHelper.d = exerciseData;
        this.b.webView.removeJavascriptInterface("hwObj");
        this.b.webView.addJavascriptInterface(this.jsInterface, "hwObj");
        this.b.webView.removeJavascriptInterface("_android_js_obj_");
        this.b.webView.addJavascriptInterface(this.jsInterfaceV2, "_android_js_obj_");
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.cfg;
        if (openConfigInfo != null && !com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.openUrl) && this.cfg.openUrl.startsWith("http")) {
            this.b.webView.loadUrlInQueue(com.up366.common.global.GB.get().getServerUrl(this.cfg.openUrl), 0);
            return;
        }
        java.lang.String path = this.dataHelper.getPath();
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseHtmlFragment - refresh - " + path);
        this.b.webView.loadUrlInQueue(path, 0);
    }

    public void setParams() {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.context.cfg;
        this.cfg = openConfigInfo;
        com.up366.mobile.book.exercise.model.ExerciseDataHolder exerciseDataHolder = new com.up366.mobile.book.exercise.model.ExerciseDataHolder(openConfigInfo.exerciseType, this.cfg.exerciseData);
        this.dataHolder = exerciseDataHolder;
        this.dataHelper.init(this.context, exerciseDataHolder);
        this.jsInterface.registerHelper.clear();
        refresh();
    }

    public void setParams(int i) {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.context.cfg;
        java.lang.String str = openConfigInfo.chapterId;
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        com.up366.mobile.book.model.CatalogChapter chapter = this.context.bookChapterInfo.getChapter(str);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("stageId", java.lang.Integer.valueOf(bookInfoStudy.getStageId()));
        jSONObject.put("subjectId", java.lang.Integer.valueOf(bookInfoStudy.getSubjectId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, chapter.obj.getBookId());
        jSONObject.put("chapterId", chapter.getChapterPPage().obj.getId());
        jSONObject.put("contentChapterId", chapter.obj.getId());
        if (i == 0) {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, chapter.obj.getId());
            jSONObject.put("taskNo", java.lang.Integer.valueOf(chapter.obj.getDisplayOrder()));
        } else {
            com.up366.mobile.book.model.CatalogChapter catalogChapter = chapter.tasks.get(0);
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, catalogChapter.obj.getId());
            jSONObject.put("taskNo", java.lang.Integer.valueOf(catalogChapter.obj.getDisplayOrder()));
        }
        jSONObject.put("name", chapter.obj.getName());
        jSONObject.put("paperId", chapter.obj.getXotPaperId());
        jSONObject.put("type", java.lang.Integer.valueOf(i));
        jSONObject.put("scoreType", 0);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, openConfigInfo.studyTaskId);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.book.model.CatalogPage catalogPage = chapter; catalogPage != null; catalogPage = catalogPage.getpPage()) {
            if (catalogPage.getObj() != null) {
                arrayList.add(0, catalogPage.getObj().getName());
            }
        }
        java.lang.String strJoin = com.up366.common.StringUtils.join(arrayList, "/");
        com.up366.mobile.course.mgr.CourseInfo courseInfo = com.up366.mobile.common.logic.Auth.cur().course().getCourseInfo(bookInfoStudy.getCourseId());
        if (courseInfo != null) {
            strJoin = courseInfo.getCourseName() + "/" + strJoin;
        }
        jSONObject.put("chapterFullName", strJoin);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("retest", java.lang.Integer.valueOf(openConfigInfo.reTest ? 1 : 0));
        com.up366.mobile.book.exercise.model.ExerciseDataHolder exerciseDataHolder = new com.up366.mobile.book.exercise.model.ExerciseDataHolder("textbook", jSONObject.toJSONString());
        this.dataHolder = exerciseDataHolder;
        exerciseDataHolder.catalogPage = chapter;
        this.dataHelper.init(this.context, this.dataHolder);
        com.up366.mobile.book.exercise.js.ExerciseJSInterface exerciseJSInterface = this.jsInterface;
        if (exerciseJSInterface != null) {
            exerciseJSInterface.registerHelper.clear();
        }
        com.up366.mobile.common.logic.Auth.cur().bookProgress().set(bookInfoStudy, chapter);
        refresh();
    }

    public void notifyPaperDataUpdate() {
        com.up366.mobile.book.exercise.js.RegisterHelper registerHelper = this.jsInterface.registerHelper;
        if (registerHelper.hasRegister("loadpaperdata")) {
            com.up366.mobile.book.exercise.model.ExerciseData exerciseData = this.dataHelper.d;
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
            registerHelper.callJsEvent("loadpaperdata", "('%s','%s','%s','%s')", android.util.Base64.encodeToString(paperXml.getBytes(), 0).replaceAll("\\s", ""), android.util.Base64.encodeToString(standardXml.getBytes(), 0).replaceAll("\\s", ""), android.util.Base64.encodeToString(answerXml.getBytes(), 0).replaceAll("\\s", ""), android.util.Base64.encodeToString(markXml.getBytes(), 0).replaceAll("\\s", ""));
        }
    }

    public void onPause() {
        com.up366.mobile.book.exercise.js.RegisterHelper registerHelper = this.jsInterface.registerHelper;
        com.up366.mobile.book.exercise.js.v2.RegisterHelperV2 registerHelperV2 = this.jsInterfaceV2.registerHelper;
        if (registerHelper.hasRegister("pause")) {
            registerHelper.callJsEvent("pause");
        }
        if (registerHelperV2.hasRegister("pause")) {
            registerHelperV2.callJsEvent("pause");
        }
        com.up366.mobile.book.exercise.js.ExerciseJSInterface exerciseJSInterface = this.jsInterface;
        if (exerciseJSInterface != null) {
            exerciseJSInterface.recordHelper.forceStopAll();
            this.jsInterface.audioHelper.pauseAll();
        }
        com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2 exerciseJSInterfaceV2 = this.jsInterfaceV2;
        if (exerciseJSInterfaceV2 != null) {
            exerciseJSInterfaceV2.recordHelper.forceStopAll();
            this.jsInterfaceV2.audioHelper.pauseAll();
        }
    }

    public void onResume() {
        com.up366.mobile.book.exercise.js.RegisterHelper registerHelper = this.jsInterface.registerHelper;
        com.up366.mobile.book.exercise.js.v2.RegisterHelperV2 registerHelperV2 = this.jsInterfaceV2.registerHelper;
        if (registerHelper.hasRegister("resume")) {
            registerHelper.callJsEvent("resume");
        }
        if (registerHelperV2.hasRegister("resume")) {
            registerHelperV2.callJsEvent("resume");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDetachedFromWindow();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.FeedbackTaskUploadSuccess feedbackTaskUploadSuccess) {
        this.jsInterface.registerHelper.callJsEvent("feedbackupload", "({code:0})");
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.FeedbackOralUploadSuccess feedbackOralUploadSuccess) {
        this.jsInterface.registerHelper.callJsEvent("questionfeedbackupload", "({code:0})");
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.common.event.NetStatusChangeEvent netStatusChangeEvent) {
        java.lang.String netWorkInfo = this.jsInterfaceV2.appInfoHelper.getNetWorkInfo();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("type", "_EVT_NETWORK_CHANGE_");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("networkType", netWorkInfo);
        jSONObject.put("detail", jSONObject2);
        this.jsInterfaceV2.registerHelper.callJsEvent("message", "(%s)", jSONObject.toJSONString());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        this.fileUploadHelper.onMessageEvent_BATCH_JS_UPLOAD(commonUploadLogEvent);
        this.fileUploadHelper.onMessageEvent_BATCH_TASK(commonUploadLogEvent);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.JSGlobalEvent jSGlobalEvent) {
        com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2 exerciseJSInterfaceV2 = this.jsInterfaceV2;
        if (exerciseJSInterfaceV2 != null) {
            exerciseJSInterfaceV2.registerHelper.callJsEvent("message", "(%s)", jSGlobalEvent.getMsg());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.visibility = i;
    }

    public int getRealVisibility() {
        return this.visibility;
    }

    public void onTopResumedActivityChanged(boolean z) {
        com.up366.mobile.book.exercise.js.v2.ExerciseJSInterfaceV2 exerciseJSInterfaceV2 = this.jsInterfaceV2;
        if (exerciseJSInterfaceV2 == null || !exerciseJSInterfaceV2.registerHelper.hasRegister("onTopResumedActivityChanged")) {
            return;
        }
        this.jsInterfaceV2.registerHelper.callJsEvent("onTopResumedActivityChanged", "(%s)", java.lang.Boolean.valueOf(z));
    }
}
