package com.up366.mobile.commonui.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonWebJSInterface {
    private final com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    private com.up366.mobile.course.task.TaskOpenWrongNoteBookInfo book;
    private final com.up366.mobile.book.helper.ClipBoardHelper clipBoardHelper;
    private android.app.Activity context;
    private final com.up366.mobile.book.helper.DataHelper dataHelper;
    private final com.up366.mobile.commonui.js.CommonWebHttpHelper httpHelper;
    public final com.up366.mobile.commonui.js.CommonWebRegisterHelper registerHelper;
    private final com.up366.mobile.book.helper.V7ShareHelper shareHelper;
    private final com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public CommonWebJSInterface(android.app.Activity activity, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper) {
        this.context = activity;
        this.webView = studyPageWebView;
        com.up366.mobile.commonui.js.CommonWebRegisterHelper commonWebRegisterHelper = new com.up366.mobile.commonui.js.CommonWebRegisterHelper(studyPageWebView);
        this.registerHelper = commonWebRegisterHelper;
        this.httpHelper = new com.up366.mobile.commonui.js.CommonWebHttpHelper(studyPageWebView, commonWebRegisterHelper);
        this.dataHelper = new com.up366.mobile.book.helper.DataHelper();
        this.shareHelper = new com.up366.mobile.book.helper.V7ShareHelper(activity);
        this.takePhotoHelper = takePhotoHelper;
        this.clipBoardHelper = new com.up366.mobile.book.helper.ClipBoardHelper(activity);
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(activity, studyPageWebView);
    }

    public void setBookInfoStudy(com.up366.mobile.course.task.TaskOpenWrongNoteBookInfo taskOpenWrongNoteBookInfo) {
        this.book = taskOpenWrongNoteBookInfo;
    }

    private java.lang.String getParam(java.lang.String str, java.lang.String str2) {
        return com.alibaba.fastjson.JSON.parseObject(str).getString(str2);
    }

    @android.webkit.JavascriptInterface
    public void openWrongQuestion(java.lang.String str) {
        final android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
        intent.putExtra("stageId", this.book.getStageId());
        intent.putExtra("subjectId", this.book.getSubjectId());
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
        intent.putExtra("bookName", this.book.getBookName());
        intent.putExtra("type", 2);
        intent.putExtra("fromType", 2);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WRONGNOTE).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openWrongQuestion$0(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWrongQuestion$0(android.content.Intent intent) {
        this.context.startActivity(intent);
    }

    @android.webkit.JavascriptInterface
    public long getNTPTimestamp() {
        return com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    }

    @android.webkit.JavascriptInterface
    public void launchXotEngine(final java.lang.String str, final java.lang.String str2, boolean z) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface.1
            @Override // com.up366.common.task.Task
            public void run() throws java.lang.Exception {
                android.content.Intent intent = new android.content.Intent(com.up366.mobile.commonui.js.CommonWebJSInterface.this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
                intent.putExtra("exercise_type", str);
                intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, str2);
                com.up366.mobile.commonui.js.CommonWebJSInterface.this.context.startActivity(intent);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - getClientInfo - ");
        return this.appInfoHelper.getClientInfo();
    }

    @android.webkit.JavascriptInterface
    public void register(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - register - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegister(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - unRegister - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public void httpRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - httpRequest - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        this.httpHelper.httpRequest(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebview(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - openWebview - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebview$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebview$1(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, com.up366.mobile.commonui.CommonWebViewActivity.URL);
        android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, com.up366.common.global.GB.get().getServerUrl(param));
        intent.putExtra("TYPE", 0);
        this.context.startActivity(intent);
    }

    @android.webkit.JavascriptInterface
    public void openWebViewV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - openWebViewV2 - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebViewV2$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebViewV2$2(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.V8OpenHelper.openWebView(this.context, str, new java.lang.Runnable() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closeWebview();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void closeWebview() {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - closeWebview - ");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$closeWebview$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeWebview$3() throws java.lang.Exception {
        this.context.finish();
    }

    @android.webkit.JavascriptInterface
    public void saveData(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - saveData - dataId = [" + str2 + "], data.length() = [" + str.length() + "]");
        this.dataHelper.saveData(str2, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - loadData - dataId = [" + str + "]");
        return this.dataHelper.loadData(str);
    }

    @android.webkit.JavascriptInterface
    public void copyToClipboard(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - copyToClipboard - text = [" + str + "]");
        this.clipBoardHelper.copyTextToClipboard(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUT(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - getUT - data = [" + str + "], salt = [" + str2 + "]");
        return com.up366.common.StringUtils.getUtV2(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void postMessage(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - postMessage - msg = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$postMessage$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$4(java.lang.String str) throws java.lang.Exception {
        this.registerHelper.postMessage(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String pasteFromClipboard() {
        java.lang.String text = this.clipBoardHelper.getText();
        com.up366.common.log.Logger.info("TAG -  CommonWebJSInterface - pasteFromClipboard - return = [" + text + "]");
        return text;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUserInfo() {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - getUserInfo - ");
        return this.appInfoHelper.getUserInfoV7();
    }

    @android.webkit.JavascriptInterface
    public void share(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - share - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$share$6(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$6(java.lang.String str) throws java.lang.Exception {
        this.shareHelper.share(str, this.webView, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.commonui.js.CommonWebJSInterface$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                this.f$0.lambda$share$5(i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$5(int i, java.lang.String str) {
        if (i == 0) {
            if (com.up366.common.FileUtilsUp.isFileExists(str)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.context, "保存成功");
            }
            this.registerHelper.callJsEvent(com.up366.mobile.commonui.js.CommonWebRegisterHelper.EVENT_SHARE_RESULT, "({\"result\":%d})", 1);
            return;
        }
        com.up366.common.log.Logger.info("TAG - CommonWebJSInterface - share - result - code:" + i + " info:" + str);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.webView, str);
        this.registerHelper.callJsEvent(com.up366.mobile.commonui.js.CommonWebRegisterHelper.EVENT_SHARE_RESULT, "({\"result\":%d})", 0);
    }
}
