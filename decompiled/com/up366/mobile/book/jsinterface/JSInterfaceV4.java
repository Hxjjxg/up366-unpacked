package com.up366.mobile.book.jsinterface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class JSInterfaceV4 {
    private final com.up366.mobile.book.helper.BookTaskLogHelper bookTaskLogHelper;
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.helper.DataHelper dataHelper;
    private final com.up366.mobile.book.studyviews.view.V4ExerciseView exerciseView;
    private final com.up366.mobile.book.helper.InputHelper inputHelper;
    private final com.up366.mobile.book.model.CatalogPage page;
    private final com.up366.mobile.book.helper.V4PageInfoHelper pageInfoHelper;
    private final int position;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public JSInterfaceV4(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.studyviews.view.V4ExerciseView v4ExerciseView, com.up366.mobile.book.model.CatalogPage catalogPage, int i) {
        this.context = studyActivity;
        this.exerciseView = v4ExerciseView;
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = v4ExerciseView.webView;
        this.webView = studyPageWebView;
        this.page = catalogPage;
        this.position = i;
        this.bookTaskLogHelper = v4ExerciseView.bookTaskLogHelper;
        this.dataHelper = new com.up366.mobile.book.helper.DataHelper();
        this.inputHelper = new com.up366.mobile.book.helper.InputHelper(studyPageWebView);
        this.pageInfoHelper = new com.up366.mobile.book.helper.V4PageInfoHelper(studyActivity, catalogPage);
    }

    @android.webkit.JavascriptInterface
    public void submitEleAttr(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - submitEleAttr - answer = [" + str + "]");
        this.bookTaskLogHelper.submitEleAttr(this.page, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUUID() {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - getUUID - ");
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    @android.webkit.JavascriptInterface
    public void showIMM(boolean z) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - showIMM - show = [" + z + "]");
        this.inputHelper.showIMM(z);
    }

    @android.webkit.JavascriptInterface
    public void submitPageEleInfo(java.lang.String str, java.lang.String str2, int i) {
        com.up366.common.log.Logger.info("submitPageEleInfo('" + str2 + "','" + i + "')");
    }

    @android.webkit.JavascriptInterface
    public int submitTask(java.lang.String str, java.lang.String str2, float f) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - submitTask - taskId = [" + str + "], taskNo = [" + str2 + "], score = [" + f + "]");
        this.bookTaskLogHelper.submitTask(str2, f, 100.0f, null);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public int submitTask(java.lang.String str, java.lang.String str2, float f, java.lang.String str3) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - submitTask - taskId = [" + str + "], taskNo = [" + str2 + "], score = [" + f + "], chapterId = [" + str3 + "]");
        this.bookTaskLogHelper.submitTask(str2, f, 100.0f, null);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public void submitTaskV1(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - submitTaskV1 - jsonStr = [" + str + "]");
        this.bookTaskLogHelper.submitTaskV1(str, this.page);
    }

    @android.webkit.JavascriptInterface
    public void saveSpeechAnswerData(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - saveData - dataId = [" + str2 + "], data = [" + str + "]");
        this.dataHelper.saveData(str2, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadSpeechAnswerData(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - loadSpeechAnswerData - dataId = [" + str + "]");
        return this.dataHelper.loadData(str);
    }

    @android.webkit.JavascriptInterface
    public void saveData(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - saveData - dataId = [" + str2 + "], data = [" + str + "]");
        this.dataHelper.saveData(str2, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - loadData - dataId = [" + str + "]");
        return this.dataHelper.loadData(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadPageInfo() {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - loadPageInfo - ");
        return this.pageInfoHelper.loadPageInfo();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCurrentPageInfo() {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - getCurrentPageInfo - ");
        return this.pageInfoHelper.getCurrentPageInfo();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getBookId() {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - getBookId - ");
        return this.page.obj.getBookId();
    }

    @android.webkit.JavascriptInterface
    public void toast(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - toast - msg = [" + str + "]");
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, str);
    }

    @android.webkit.JavascriptInterface
    public void playResVedio(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - playResVedio - videoId = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV4.1
            @Override // com.up366.common.task.Task
            public void run() {
                android.content.Intent intent = new android.content.Intent((android.content.Context) com.up366.mobile.book.jsinterface.JSInterfaceV4.this.context, (java.lang.Class<?>) com.up366.mobile.book.activity.AnswerVideoActivity.class);
                intent.putExtra("book_id", com.up366.mobile.book.jsinterface.JSInterfaceV4.this.context.book.getBookId());
                intent.putExtra("chapter_id", com.up366.mobile.book.jsinterface.JSInterfaceV4.this.pageInfoHelper.getChapterId());
                intent.putExtra("video_id", str);
                com.up366.mobile.book.jsinterface.JSInterfaceV4.this.context.startActivity(intent);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void hideBackBtn(final boolean z) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - hideBackBtn - isHide = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV4$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$hideBackBtn$0(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideBackBtn$0(boolean z) throws java.lang.Exception {
        this.exerciseView.studyFragment.b.titleBar.showBack(!z);
    }

    @android.webkit.JavascriptInterface
    public boolean isVideoDownloaded(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - isVideoDownloaded - videoId = [" + str + "]");
        new androidx.appcompat.app.AlertDialog.Builder(this.context).setTitle("提示").setMessage("判断视频是否下载完成！").setPositiveButton("确定", (android.content.DialogInterface.OnClickListener) null).show();
        return false;
    }

    @android.webkit.JavascriptInterface
    public boolean isAuthed() {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - isAuthed - ");
        return com.up366.mobile.common.logic.Auth.isAuth();
    }

    @android.webkit.JavascriptInterface
    public void changeMedalState(int i) {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - changeMedalState - state = [" + i + "]");
    }

    @android.webkit.JavascriptInterface
    public void redownloadChapter() {
        com.up366.common.log.Logger.info("TAG - 2018/5/30 - JSInterfaceV4 - redownloadChapter - ");
    }
}
