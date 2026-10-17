package com.up366.mobile.book.jsinterface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterJSInterface {
    private final com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    public final com.up366.mobile.book.helper.V6AudioHelper audioHelper;
    private final com.up366.mobile.book.helper.ChapterFileDataHelper chapterDataHelper;
    private final com.up366.mobile.book.studyviews.ChapterHtmlView chapterFragment;
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.helper.DataHelper dataHelper;
    private final com.up366.mobile.book.helper.V6HttpHelper httpHelper;
    private final com.up366.mobile.book.helper.InputHelper inputHelper;
    private final com.up366.mobile.book.helper.V6ExerciseOpenHelper openHelper;
    private final com.up366.mobile.book.helper.ChapterRecordHelper recordHelper;
    private final com.up366.mobile.book.helper.V6RegisterHelper registerHelper;
    private final com.up366.mobile.book.helper.ShareHelper shareHelper;
    private final com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    private final com.up366.mobile.book.helper.JSUploadFileHelper uploadFileHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    @android.webkit.JavascriptInterface
    public void hideTbsVideoFullscreenButton() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChapterJSInterface(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.studyviews.ChapterHtmlView chapterHtmlView) {
        this.context = studyActivity;
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = chapterHtmlView.b.webView;
        this.webView = studyPageWebView;
        this.registerHelper = chapterHtmlView.registerHelper;
        this.httpHelper = chapterHtmlView.httpHelper;
        this.chapterFragment = chapterHtmlView;
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(studyActivity, studyPageWebView);
        com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(studyActivity);
        this.speechRecordHelper = speechRecordHelper;
        com.up366.mobile.book.helper.ChapterFileDataHelper chapterFileDataHelper = new com.up366.mobile.book.helper.ChapterFileDataHelper(studyActivity.bookChapterInfo.getBook());
        this.chapterDataHelper = chapterFileDataHelper;
        com.up366.mobile.book.helper.ChapterRecordHelper chapterRecordHelper = new com.up366.mobile.book.helper.ChapterRecordHelper(studyPageWebView, chapterFileDataHelper, speechRecordHelper);
        this.recordHelper = chapterRecordHelper;
        this.audioHelper = new com.up366.mobile.book.helper.ChapterAudioHelper(studyPageWebView, studyActivity, chapterRecordHelper);
        com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();
        this.dataHelper = dataHelper;
        this.inputHelper = new com.up366.mobile.book.helper.InputHelper(studyPageWebView);
        this.openHelper = new com.up366.mobile.book.helper.V6ExerciseOpenHelper(studyActivity);
        this.shareHelper = new com.up366.mobile.book.helper.ShareHelper(studyActivity);
        this.uploadFileHelper = new com.up366.mobile.book.helper.JSUploadFileHelper(dataHelper);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getClientInfo - ");
        return this.appInfoHelper.getClientInfo();
    }

    @android.webkit.JavascriptInterface
    public int playAudio(java.lang.String str, java.lang.String str2, int i, int i2) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - playAudio - audioPlayerId = [" + str + "], mediaSource = [" + str2 + "], mode = [" + i + "], seek = [" + i2 + "]");
        return this.audioHelper.playAudio(str, str2, i, i2);
    }

    @android.webkit.JavascriptInterface
    public int playAudioWithParams(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/28 - ChapterJSInterface - playAudioWithParams - params = [" + str + "]");
        return this.audioHelper.playAudioWithParams(str);
    }

    @android.webkit.JavascriptInterface
    public int getAudioCurrentTime(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getAudioCurrentTime - audioPlayerId = [" + str + "]");
        return this.audioHelper.getCurrentTime(str);
    }

    @android.webkit.JavascriptInterface
    public int seekPlayAudio(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - seekPlayAudio - audioPlayerId = [" + str + "], position = [" + i + "]");
        this.audioHelper.resumePlaying(str);
        this.audioHelper.seekPlay(str, i);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public void pausePlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - pausePlayAudio - audioPlayerId = [" + str + "]");
        this.audioHelper.pausePlay(str);
    }

    @android.webkit.JavascriptInterface
    public void resumePlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - resumePlayAudio - audioPlayerId = [" + str + "]");
        this.audioHelper.resumePlaying(str);
    }

    @android.webkit.JavascriptInterface
    public void stopPlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - stopPlayAudio - audioPlayerId = [" + str + "]");
        this.audioHelper.stopPlay(str);
    }

    @android.webkit.JavascriptInterface
    public void setAudioRate(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - setAudioRate - param = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        this.audioHelper.setRate(object.getString("audioId"), object.getFloatValue("rate"));
    }

    @android.webkit.JavascriptInterface
    public float getAudioRate(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getAudioRate - audioId = [" + str + "]");
        return this.audioHelper.getRate(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUUID() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getUUID - ");
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    @android.webkit.JavascriptInterface
    public int saveData(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - saveData - data = [" + str + "], dataId = [" + str2 + "]");
        this.dataHelper.saveData(str2, str);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - loadData - dataId = [" + str + "]");
        return this.dataHelper.loadData(str);
    }

    @android.webkit.JavascriptInterface
    public void toast(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - toast - msg = [" + str + "]");
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, str);
    }

    @android.webkit.JavascriptInterface
    public void showIMM(boolean z) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - showIMM - show = [" + z + "]");
        this.inputHelper.showIMM(z);
    }

    @android.webkit.JavascriptInterface
    public void showInput(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - showInput - oldText = [" + str + "], tip = [" + str2 + "]");
        this.inputHelper.showInput(str, str2);
    }

    @android.webkit.JavascriptInterface
    public boolean isAuthed() {
        return com.up366.mobile.common.logic.Auth.isAuth();
    }

    @android.webkit.JavascriptInterface
    public int getUserType() {
        return com.up366.mobile.common.logic.Auth.getUserInfo().getUtype();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUserInfo() {
        com.up366.common.log.Logger.info("TAG - 2019/1/29 - ChapterJSInterface - getUserInfo - ");
        return this.appInfoHelper.getUserInfo();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getBookInfo() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getBookInfo - ");
        return this.context.bookChapterInfo.getHtmlJsonStr();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getBookId() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getBookId - ");
        return this.context.bookChapterInfo.getBook().getBookId();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getLatestStudyInfo() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getLatestStudyInfo - ");
        return this.context.bookStudyInfoHelper.getLatestStudyInfo();
    }

    @android.webkit.JavascriptInterface
    public void downloadChapter(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - downloadChapter - chapterId = [" + str + "]");
        com.up366.mobile.book.model.CatalogChapter chapter = this.context.bookChapterInfo.getChapter(str);
        if (chapter != null) {
            this.context.contentDownloadHelper.downloadContentFromJS(chapter.getObj());
        }
    }

    @android.webkit.JavascriptInterface
    public void pauseDownloadChapter(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - pauseDownloadChapter - chapterId = [" + str + "]");
        com.up366.common.download.DownloadManager.getInstance().pauseAllDownload();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getTasksUploadStatus() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getTasksUploadStatus - ");
        return com.up366.mobile.book.helper.TaskUploadStatusHelper.get();
    }

    @android.webkit.JavascriptInterface
    public void buyBook(final int i) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - buyBook - productId = [" + i + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$buyBook$0(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buyBook$0(int i) throws java.lang.Exception {
        this.context.buyBookHelper.buy(i);
    }

    @android.webkit.JavascriptInterface
    public void study(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - study - chapterId = [" + str + "], pageId = [" + str2 + "]");
        gotoChapter(str, str2, 0);
    }

    @android.webkit.JavascriptInterface
    public void gotoChapter(final java.lang.String str, final java.lang.String str2, final int i) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - gotoChapter - chapterId = [" + str + "], pageId = [" + str2 + "], mode = [" + i + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$gotoChapter$1(str, str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$gotoChapter$1(java.lang.String str, java.lang.String str2, int i) throws java.lang.Exception {
        this.context.bookOpenStudyHelper.study(str, str2, i);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getChapterSize(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - getChapterSize - chapterId = [" + str + "]");
        return java.lang.String.format(java.util.Locale.getDefault(), "%.2fM", java.lang.Float.valueOf(((((int) this.context.bookChapterInfo.getChapterSize(str)) * 1.0f) / 1024.0f) / 1024.0f));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getContentChapterDownloadState(java.lang.String str) {
        return this.context.contentDownloadHelper.getChapterDownloadState(str);
    }

    @android.webkit.JavascriptInterface
    public void refreshChapters(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - refreshChapters - bookId = [" + str + "]");
        com.up366.mobile.common.logic.Auth.cur().book().fetchChapterPlanAndFinishedTask(this.context.bookChapterInfo, android.text.TextUtils.isEmpty(this.context.cfg.studyTaskId) ^ true);
    }

    @android.webkit.JavascriptInterface
    public void deleteChapter(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - deleteChapter - chapterId = [" + str + "]");
        this.context.contentDownloadHelper.deleteChapter(str);
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$deleteChapter$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteChapter$2(java.lang.String str) throws java.lang.Exception {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("chapterId", str);
        jSONObject.put("progress", "100%");
        jSONObject.put("state", 4);
        jSONObject.put("errmsg", "success");
        this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_DOWNLOAD_PROGRESS, "(%s)", jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public void backToBookshelf() {
        com.up366.common.log.Logger.info("TAG - 2019/6/17 - ChapterJSInterface - backToBookshelf - ");
        final com.up366.mobile.book.StudyActivity studyActivity = this.context;
        java.util.Objects.requireNonNull(studyActivity);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() {
                studyActivity.backToBookshelf();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void backToCatalog(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - backToCatalog - file = [" + str + "]");
        toast("这个接口不用实现了，JS不要调这个！");
    }

    @android.webkit.JavascriptInterface
    public void open(final java.lang.String str, final int i) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - open - url = [" + str + "], mode = [" + i + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda15
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$open$3(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$open$3(java.lang.String str, int i) throws java.lang.Exception {
        this.chapterFragment.openNewPageHelper.openPage(str, i);
    }

    @android.webkit.JavascriptInterface
    public void closePage() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - closePage - ");
        this.registerHelper.unRegister(com.up366.mobile.book.helper.V6RegisterHelper.EVT_BACKBTN_CLICK);
        final com.up366.mobile.book.StudyActivity studyActivity = this.context;
        java.util.Objects.requireNonNull(studyActivity);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                studyActivity.onBackPressed();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void disableRefresh(int i) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - disableRefresh - mode = [" + i + "]");
        this.chapterFragment.b.refreshLayout.setEnable(i == 0);
    }

    @android.webkit.JavascriptInterface
    public void requestDataFromServer(int i, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - requestDataFromServer - sessionId = [" + i + "], url = [" + str + "]");
        this.httpHelper.httpSend(i, str);
    }

    @android.webkit.JavascriptInterface
    public void submitDataForServer(int i, java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - submitDataForServer - sessionId = [" + i + "], url = [" + str + "]");
        this.httpHelper.httpSendToQueue(i, str, str2);
    }

    @android.webkit.JavascriptInterface
    public int httpRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - httpRequest - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        return this.httpHelper.httpRequest(str);
    }

    @android.webkit.JavascriptInterface
    public void registerEvent(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - registerEvent - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegisterEvent(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - unRegisterEvent - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public void openTestChapter(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - openTestChapter - chapterId = [" + str + "], paperId = [" + str2 + "]");
        gotoChapter(str, null, 0);
    }

    @android.webkit.JavascriptInterface
    public void trainingMode(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final java.lang.String str5) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - trainingMode - stage = [" + str + "], subject = [" + str2 + "], knowlege = [" + str3 + "], diff = [" + str4 + "], num = [" + str5 + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda17
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$trainingMode$4(str, str2, str3, str4, str5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trainingMode$4(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) throws java.lang.Exception {
        this.openHelper.trainingMode(str, str2, str3, str4, str5);
    }

    @android.webkit.JavascriptInterface
    public void openWrongQuestion() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - openWrongQuestion - ");
        final com.up366.mobile.book.helper.V6ExerciseOpenHelper v6ExerciseOpenHelper = this.openHelper;
        java.util.Objects.requireNonNull(v6ExerciseOpenHelper);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() {
                v6ExerciseOpenHelper.openWrongQuestion();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void openWordNote() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - openWordNote - ");
        final com.up366.mobile.book.helper.V6ExerciseOpenHelper v6ExerciseOpenHelper = this.openHelper;
        java.util.Objects.requireNonNull(v6ExerciseOpenHelper);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda14
            @Override // com.up366.common.task.Task
            public final void run() {
                v6ExerciseOpenHelper.openWordNote();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void writeJSErrorLog(java.lang.String str) {
        com.up366.common.log.Logger.error("JS-LOG:" + str);
    }

    @android.webkit.JavascriptInterface
    public void updateNavigationTitle(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - updateNavigationTitle - title = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateNavigationTitle$5(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateNavigationTitle$5(java.lang.String str) throws java.lang.Exception {
        this.context.setTitle(str);
    }

    @android.webkit.JavascriptInterface
    public void share(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/1/29 - ChapterJSInterface - share - params = [" + str + "]");
        this.shareHelper.share(str, this.webView);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCourseId() {
        int courseId = this.context.bookChapterInfo.getBook().getCourseId();
        return courseId < 1 ? "" : java.lang.String.valueOf(courseId);
    }

    @android.webkit.JavascriptInterface
    public void startRecord(java.lang.String str, java.lang.String str2, int i) {
        com.up366.common.log.Logger.info("TAG - 2019/1/29 - ChapterJSInterface - startRecord - recordId = [" + str + "], netFile = [" + str2 + "], recordType = [" + i + "]");
        this.recordHelper.startRecord(str, str2, i);
    }

    @android.webkit.JavascriptInterface
    public void startRecordWithParams(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/1/29 - ChapterJSInterface - startRecordWithParams - params = [" + str + "]");
        this.recordHelper.startRecordWithParams(str);
    }

    @android.webkit.JavascriptInterface
    public void startRecordWithParamsV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/4/9 - ChapterJSInterface - startRecordWithParamsV2 - json = [" + str + "]");
        this.recordHelper.startRecordWithParamsV2(str);
    }

    @android.webkit.JavascriptInterface
    public void endRecord(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/1/29 - ChapterJSInterface - endRecord - recordId = [" + str + "]");
        this.recordHelper.endRecord(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAsecResult(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/1/29 - ChapterJSInterface - getAsecResult - recordId = [" + str + "]");
        return this.recordHelper.getAsecResult(str);
    }

    @android.webkit.JavascriptInterface
    public int delAsecResult(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/1/29 - ChapterJSInterface - delAsecResult - recordId = [" + str + "]");
        this.recordHelper.deleteByRecordId(str);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$login$6() throws java.lang.Exception {
        com.up366.mobile.user.account.login.AccountLoginActivity.open(this.context);
    }

    @android.webkit.JavascriptInterface
    public void login() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$login$6();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void uploadFile(java.lang.String str) {
        com.up366.common.log.Logger.info("ChapterJSInterface - uploadFile - params = [" + str + "]");
        this.uploadFileHelper.upload(str);
    }

    @android.webkit.JavascriptInterface
    public void showDashboard() {
        com.up366.common.log.Logger.info("ChapterJSInterface - showDashboard - ");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda13
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showDashboard$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDashboard$7() throws java.lang.Exception {
        this.chapterFragment.courseCountHelper.showDashboard();
    }

    @android.webkit.JavascriptInterface
    public void copyToClipboard(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - copyToClipboard - text = [" + str + "]");
        new com.up366.mobile.book.helper.ClipBoardHelper(this.context).copyTextToClipboard(str);
    }

    @android.webkit.JavascriptInterface
    public void openDictionary(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - openDictionary - json = [" + str + "]");
        this.openHelper.openDictionary(str);
    }

    @android.webkit.JavascriptInterface
    public void openDictionaryV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - openDictionaryV2 - json = [" + str + "]");
        this.openHelper.openDictionaryV2(str);
    }

    @android.webkit.JavascriptInterface
    public void uploadUserLog(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - uploadUserLog - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$uploadUserLog$8(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$8(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.ActionLogRecord.recordJS(this.webView, com.alibaba.fastjson.JSON.parseObject(str));
    }

    @android.webkit.JavascriptInterface
    public void launchXotEngine(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString("type");
        final java.lang.String string2 = object.getString("data");
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - launchXotEngine - type = [" + string + "], data = [" + string2 + "], openNewWebView = [true]");
        final boolean z = true;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$launchXotEngine$9(string, string2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchXotEngine$9(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Exception {
        this.openHelper.launchXotEngine(str, str2, z);
    }

    @android.webkit.JavascriptInterface
    public void disableScreenCapture(final boolean z) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - disableScreenCapture - disable = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$disableScreenCapture$10(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disableScreenCapture$10(boolean z) throws java.lang.Exception {
        if (z) {
            this.context.getWindow().setFlags(io.objectbox.model.PropertyFlags.UNSIGNED, io.objectbox.model.PropertyFlags.UNSIGNED);
        } else {
            this.context.getWindow().clearFlags(io.objectbox.model.PropertyFlags.UNSIGNED);
        }
    }

    @android.webkit.JavascriptInterface
    public void upgradeClient() {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - upgradeClient - ");
        com.up366.mobile.book.helper.AppInfoHelper.upgradeClient(this.context);
    }

    @android.webkit.JavascriptInterface
    public void openWebView(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - openWebView - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda18
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebView$11(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$11(java.lang.String str) throws java.lang.Exception {
        this.chapterFragment.openNewPageHelper.openWebView(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebViewV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - openWebViewV2 - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebViewV2$12(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebViewV2$12(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.V8OpenHelper.openWebView(this.context, str, new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closePage();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void postMessage(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - postMessage - msg = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.ChapterJSInterface$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$postMessage$13(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$13(java.lang.String str) throws java.lang.Exception {
        this.registerHelper.postMessage(str);
    }

    @android.webkit.JavascriptInterface
    public void openScanPaper(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ChapterJSInterface - openScanPaper - json = [" + str + "]");
        com.up366.mobile.course.photoanswer.PhotoAnswerOpenHelper.openScanPaper(this.context, str);
    }
}
