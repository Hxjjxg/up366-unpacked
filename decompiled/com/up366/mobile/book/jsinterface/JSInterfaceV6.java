package com.up366.mobile.book.jsinterface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class JSInterfaceV6 {
    private final com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    public final com.up366.mobile.book.helper.V6AudioHelper audioHelper;
    private final com.up366.mobile.book.helper.BookTaskLogHelper bookTaskLogHelper;
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.helper.DataHelper dataHelper;
    private final com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView;
    private final com.up366.mobile.book.helper.HeadsetHelper headsetHelper;
    private final com.up366.mobile.book.helper.V6HttpHelper httpHelper;
    private final com.up366.mobile.book.helper.InputHelper inputHelper;
    private final com.up366.mobile.book.helper.LocalMediaHelper localMediaHelper;
    private final com.up366.mobile.book.helper.MuxAVHelper muxAVHelper;
    private final com.up366.mobile.book.helper.V6ExerciseOpenHelper openHelper;
    private final com.up366.mobile.book.model.CatalogPage page;
    private final com.up366.mobile.book.helper.V6PageInfoHelper pageInfoHelper;
    private final int position;
    private final com.up366.mobile.book.helper.V6RecordHelper recordHelper;
    private final com.up366.mobile.book.helper.V6RegisterHelper registerHelper;
    private final com.up366.mobile.book.helper.ShareHelper shareHelper;
    private final com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    private final com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private final com.up366.mobile.book.helper.JSUploadFileHelper uploadFileHelper;
    public final com.up366.mobile.book.helper.V6VideoHelper videoHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    @android.webkit.JavascriptInterface
    public void hideTbsVideoFullscreenButton() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JSInterfaceV6(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.studyviews.view.V6ExerciseView v6ExerciseView, com.up366.mobile.book.model.CatalogPage catalogPage, int i) {
        this.studyActivityInterface = studyActivity;
        this.context = studyActivity;
        this.exerciseView = v6ExerciseView;
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = v6ExerciseView.webView;
        this.webView = studyPageWebView;
        this.page = catalogPage;
        this.position = i;
        this.bookTaskLogHelper = v6ExerciseView.bookTaskLogHelper;
        com.up366.mobile.book.helper.V6RegisterHelper v6RegisterHelper = v6ExerciseView.registerHelper;
        this.registerHelper = v6RegisterHelper;
        this.inputHelper = new com.up366.mobile.book.helper.InputHelper(studyPageWebView);
        this.pageInfoHelper = new com.up366.mobile.book.helper.V6PageInfoHelper(studyActivity, catalogPage);
        com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();
        this.dataHelper = dataHelper;
        this.recordHelper = v6ExerciseView.recordHelper;
        this.audioHelper = v6ExerciseView.audioHelper;
        this.videoHelper = new com.up366.mobile.book.helper.V6VideoHelper(studyActivity, v6ExerciseView, v6ExerciseView.webView, v6ExerciseView.dataHelper, catalogPage);
        this.httpHelper = new com.up366.mobile.book.helper.V6HttpHelper(studyPageWebView, v6RegisterHelper);
        this.openHelper = new com.up366.mobile.book.helper.V6ExerciseOpenHelper(studyActivity);
        this.appInfoHelper = new com.up366.mobile.book.helper.AppInfoHelper(studyActivity, studyPageWebView);
        this.shareHelper = new com.up366.mobile.book.helper.ShareHelper(studyActivity);
        this.localMediaHelper = new com.up366.mobile.book.helper.LocalMediaHelper(studyActivity, v6RegisterHelper);
        this.muxAVHelper = new com.up366.mobile.book.helper.MuxAVHelper(studyActivity, studyPageWebView, v6ExerciseView.dataHelper, catalogPage, v6RegisterHelper);
        this.uploadFileHelper = new com.up366.mobile.book.helper.JSUploadFileHelper(dataHelper);
        this.takePhotoHelper = studyActivity.takePhotoHelper;
        this.headsetHelper = studyActivity.headsetHelper;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getClientInfo - ");
        return this.appInfoHelper.getClientInfo();
    }

    @android.webkit.JavascriptInterface
    public int playAudio(java.lang.String str, java.lang.String str2, int i, int i2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - playAudio - audioPlayerId = [" + str + "], mediaSource = [" + str2 + "], mode = [" + i + "], seek = [" + i2 + "]");
        return this.audioHelper.playAudio(str, str2, i, i2);
    }

    @android.webkit.JavascriptInterface
    public int playAudioWithParams(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - playAudioWithParams - params = [" + str + "]");
        return this.audioHelper.playAudioWithParams(str);
    }

    @android.webkit.JavascriptInterface
    public int getAudioCurrentTime(java.lang.String str) {
        int currentTime = this.audioHelper.getCurrentTime(str);
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV6 - getAudioCurrentTime - audioPlayerId = [" + str + "], time = [" + currentTime + "]");
        return currentTime;
    }

    @android.webkit.JavascriptInterface
    public void seekPlayAudio(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - seekPlayAudio - audioPlayerId = [" + str + "], position = [" + i + "]");
        this.audioHelper.seekPlay(str, i);
    }

    @android.webkit.JavascriptInterface
    public void pausePlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - pausePlayAudio - audioPlayerId = [" + str + "]");
        this.audioHelper.pausePlay(str);
    }

    @android.webkit.JavascriptInterface
    public void resumePlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - resumePlayAudio - audioPlayerId = [" + str + "]");
        this.audioHelper.resumePlaying(str);
    }

    @android.webkit.JavascriptInterface
    public void stopPlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - stopPlayAudio - audioPlayerId = [" + str + "]");
        this.audioHelper.stopPlay(str);
    }

    @android.webkit.JavascriptInterface
    public void setVolume(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - setVolume - audioPlayerId = [" + str + "], volume = [" + i + "]");
        this.audioHelper.setVolume(str, i);
    }

    @android.webkit.JavascriptInterface
    public void setAudioRate(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - setAudioRate - param = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        this.audioHelper.setRate(object.getString("audioId"), object.getFloatValue("rate"));
    }

    @android.webkit.JavascriptInterface
    public float getAudioRate(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getAudioRate - audioId = [" + str + "]");
        return this.audioHelper.getRate(str);
    }

    @android.webkit.JavascriptInterface
    public void submitEleAttr(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - submitEleAttr - answer = [" + str + "]");
        this.bookTaskLogHelper.submitEleAttr(this.page, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUUID() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getUUID - ");
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    @android.webkit.JavascriptInterface
    public void showIMM(boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - showIMM - show = [" + z + "]");
        this.inputHelper.showIMM(z);
    }

    @android.webkit.JavascriptInterface
    public void submitTask(java.lang.String str, java.lang.String str2, float f) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - submitTask - taskId = [" + str + "], taskNo = [" + str2 + "], score = [" + f + "]");
        this.bookTaskLogHelper.submitTask(str, str2, f, 100, this.page);
    }

    @android.webkit.JavascriptInterface
    public void submitTaskV1(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - submitTaskV1 - jsonStr = [" + str + "]");
        this.bookTaskLogHelper.submitTaskV1(str, this.page);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTaskCallback = new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$submitTaskV1$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitTaskV1$0() {
        this.webView.callJSMethod("onSubmitTask({\"taskId\":\"" + this.page.obj.getTaskId() + "\"})");
    }

    @android.webkit.JavascriptInterface
    public void callNextPage() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - callNextPage - ");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPageIds() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getPageIds - ");
        return this.pageInfoHelper.getPageIds();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPageParams() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getPageParams - ");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(this.studyActivityInterface.getOpenConfigInfo().exerciseData);
        if (object == null) {
            object = new com.alibaba.fastjson.JSONObject();
        }
        if (this.page != null && !object.containsKey(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID)) {
            object.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, this.studyActivityInterface.getOpenConfigInfo().studyTaskId);
        }
        return object.toJSONString();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getBookId() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getBookId - ");
        return this.page.obj.getBookId();
    }

    @android.webkit.JavascriptInterface
    public void submitPageEleInfo(java.lang.String str, java.lang.String str2, int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - submitPageEleInfo - taskId = [" + str + "], elementId = [" + str2 + "], elementType = [" + i + "]");
    }

    @android.webkit.JavascriptInterface
    public void saveData(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV6 - saveData - dataId = [" + str2 + "], data.length() = [" + str.length() + "]");
        this.dataHelper.saveData(str2, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(java.lang.String str) {
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV6 - loadData - dataId = [" + str + "]");
        return this.dataHelper.loadData(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadPageInfo() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - loadPageInfo - ");
        return this.pageInfoHelper.loadPageInfo();
    }

    @android.webkit.JavascriptInterface
    public void toast(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - toast - msg = [" + str + "]");
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, str);
    }

    @android.webkit.JavascriptInterface
    public void hideBackBtn(final boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - hideBackBtn - isHide = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda18
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$hideBackBtn$1(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideBackBtn$1(boolean z) throws java.lang.Exception {
        this.context.titleBar.showBack(!z);
    }

    @android.webkit.JavascriptInterface
    public void showInput(final java.lang.String str, final java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - showInput - oldText = [" + str + "], tip = [" + str2 + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showInput$2(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInput$2(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        this.inputHelper.showInput(str, str2);
    }

    @android.webkit.JavascriptInterface
    public boolean isAuthed() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - isAuthed - ");
        return com.up366.mobile.common.logic.Auth.isAuth();
    }

    @android.webkit.JavascriptInterface
    public int getUserType() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getUserType - ");
        return com.up366.mobile.common.logic.Auth.getUserInfo().getUtype();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUserInfo() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getUserInfo - ");
        return this.appInfoHelper.getUserInfo();
    }

    @android.webkit.JavascriptInterface
    public void startRecord(java.lang.String str, java.lang.String str2, int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - startRecord - recordId = [" + str + "], netFile = [" + str2 + "], recordType = [" + i + "]");
        this.recordHelper.startRecord(str, str2, i);
    }

    @android.webkit.JavascriptInterface
    public void startRecordWithParams(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - startRecordWithParams - params = [" + str + "]");
        this.recordHelper.startRecordWithParams(str);
    }

    @android.webkit.JavascriptInterface
    public void startRecordWithParamsV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - startRecordWithParamsV2 - params = [" + str + "]");
        this.recordHelper.startRecordWithParamsV2(str);
    }

    @android.webkit.JavascriptInterface
    public void endRecord(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - endRecord - recordId = [" + str + "]");
        this.recordHelper.endRecord(str);
    }

    @android.webkit.JavascriptInterface
    public void playResVedio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - playResVedio - videoSrc = [" + str + "]");
        this.videoHelper.playResVedio(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAsecResult(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getAsecResult - recordId = [" + str + "]");
        return this.recordHelper.getAsecResult(str);
    }

    @android.webkit.JavascriptInterface
    public int delAsecResult(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - delAsecResult - recordId = [" + str + "]");
        this.recordHelper.deleteByRecordId(str);
        return 0;
    }

    @android.webkit.JavascriptInterface
    public void initVedioView(final java.lang.String str, final int i, final int i2, final int i3, final int i4, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - initVedioView - videoPlayerId = [" + str + "], left = [" + i + "], top = [" + i2 + "], width = [" + i3 + "], height = [" + i4 + "], poster = [" + str2 + "], videoSrc = [" + str3 + "], tips = [" + str4 + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initVedioView$3(str, i, i2, i3, i4, str2, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVedioView$3(java.lang.String str, int i, int i2, int i3, int i4, java.lang.String str2, java.lang.String str3, java.lang.String str4) throws java.lang.Exception {
        this.videoHelper.initVideoView(str, i, i2, i3, i4, str2, str3, str4);
    }

    @android.webkit.JavascriptInterface
    public void initNewVedioView(final java.lang.String str, final int i, final int i2, final int i3, final int i4, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final java.lang.String str5) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - initNewVedioView - videoPlayerId = [" + str + "], left = [" + i + "], top = [" + i2 + "], width = [" + i3 + "], height = [" + i4 + "], poster = [" + str2 + "], fileId = [" + str3 + "], videoSrc = [" + str4 + "], tips = [" + str5 + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda32
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initNewVedioView$4(str, i, i2, i3, i4, str2, str3, str4, str5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initNewVedioView$4(java.lang.String str, int i, int i2, int i3, int i4, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) throws java.lang.Exception {
        this.videoHelper.initNewVideoView(str, i, i2, i3, i4, str2, str3, str4, str5);
    }

    @android.webkit.JavascriptInterface
    public boolean isShowVideo() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - isShowVideo - ");
        return this.videoHelper.isShowVideo();
    }

    @android.webkit.JavascriptInterface
    public void isShowVideo(java.lang.String str, final boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - isShowVideo - videoPlayerId = [" + str + "], showFlag = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda23
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$isShowVideo$5(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isShowVideo$5(boolean z) throws java.lang.Exception {
        this.videoHelper.setVisiable(z);
    }

    @android.webkit.JavascriptInterface
    public void setVideoMute(java.lang.String str, boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - setVideoMute - videoPlayerId = [" + str + "], muteFlag = [" + z + "]");
        this.videoHelper.setVideoMute(str, z);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getVideoImage(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getVideoImage - videoPlayerId = [" + str + "]");
        return this.videoHelper.getVideoImage(str);
    }

    @android.webkit.JavascriptInterface
    public void pausePlayVideo(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - pausePlayVideo - videoPlayerId = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda27
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$pausePlayVideo$6(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pausePlayVideo$6(java.lang.String str) throws java.lang.Exception {
        this.videoHelper.pausePlayVideo(str);
    }

    @android.webkit.JavascriptInterface
    public void resumePlayVideo(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - resumePlayVideo - videoPlayerId = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$resumePlayVideo$7(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resumePlayVideo$7(java.lang.String str) throws java.lang.Exception {
        this.videoHelper.resumePlayVideo(str);
    }

    @android.webkit.JavascriptInterface
    public void startPlayVideo(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - startPlayVideo - videoPlayerId = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda35
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$startPlayVideo$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPlayVideo$8() throws java.lang.Exception {
        com.up366.mobile.book.helper.V6VideoHelper v6VideoHelper = this.videoHelper;
        v6VideoHelper.startPlayVideo(v6VideoHelper);
    }

    @android.webkit.JavascriptInterface
    public void stopPlayVideo(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - stopPlayVideo - videoPlayerId = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda31
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$stopPlayVideo$9(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopPlayVideo$9(java.lang.String str) throws java.lang.Exception {
        this.videoHelper.stopPlayVideo(str);
    }

    @android.webkit.JavascriptInterface
    public int getVideoCurrentTime(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getVideoCurrentTime - videoPlayerId = [" + str + "]");
        return this.videoHelper.getVideoCurrentTime(str);
    }

    @android.webkit.JavascriptInterface
    public int getVideoDuration(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getVideoDuration - videoPlayerId = [" + str + "]");
        return this.videoHelper.getVideoDuration(str);
    }

    @android.webkit.JavascriptInterface
    public void activeVideoControl(java.lang.String str, final boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - activeVideoControl - videoPlayerId = [" + str + "], enableFlag = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda25
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$activeVideoControl$10(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$activeVideoControl$10(boolean z) throws java.lang.Exception {
        this.videoHelper.activeVideoControl(z);
    }

    @android.webkit.JavascriptInterface
    public void setVideoControlVisible(final java.lang.String str, final boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - setVideoControlVisible - videoPlayerId = [" + str + "], enableFlag = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda28
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$setVideoControlVisible$11(str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideoControlVisible$11(java.lang.String str, boolean z) throws java.lang.Exception {
        this.videoHelper.setVideoControlVisible(str, z);
    }

    @android.webkit.JavascriptInterface
    public void manualUploadTask() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - manualUploadTask - ");
        com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
        com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
    }

    @android.webkit.JavascriptInterface
    public void doCorrect(final java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - doCorrect - questionId = [" + str + "], data = [" + str2 + "]");
        final com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str2);
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.fyapi, false) { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("essay", object.getString("cont"));
                map.put("ref", object.getString("refrence"));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str3) {
                if (response.isError()) {
                    com.up366.mobile.book.jsinterface.JSInterfaceV6.this.webView.callJSMethod("onDoneCorrect('%s','%s')", str, "{ \"reqError\":\"请求失败！\" }");
                } else {
                    com.up366.mobile.book.jsinterface.JSInterfaceV6.this.webView.callJSMethod("onDoneCorrect('%s','%s')", str, str3);
                }
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void open(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - open - url = [" + str + "], mode = [" + i + "]");
        this.exerciseView.studyFragment.openNewPageHelper.openPage(str, i, this.webView.getCurrentDir(), this.position);
    }

    @android.webkit.JavascriptInterface
    public void closePage() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - closePage - ");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda14
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$closePage$12();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closePage$12() throws java.lang.Exception {
        com.up366.mobile.book.studyviews.view.V6ExerciseView currentExerciseView = this.exerciseView.studyFragment.getCurrentExerciseView();
        if (currentExerciseView != null) {
            currentExerciseView.registerHelper.unRegister(com.up366.mobile.book.helper.V6RegisterHelper.EVT_BACKBTN_CLICK);
        }
        this.context.onBackPressed();
    }

    @android.webkit.JavascriptInterface
    public void backToCatalog(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - backToCatalog - file = [" + str + "]");
        this.openHelper.backToCatalog();
    }

    @android.webkit.JavascriptInterface
    public void gotoNextPage() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - gotoNextPage - ");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda19
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$gotoNextPage$13();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$gotoNextPage$13() throws java.lang.Exception {
        this.exerciseView.studyFragment.gotoNextPage();
    }

    @android.webkit.JavascriptInterface
    public void gotoPrevPage() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - gotoPrevPage - ");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$gotoPrevPage$15();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$gotoPrevPage$14() throws java.lang.Exception {
        this.exerciseView.studyFragment.gotoPrevPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$gotoPrevPage$15() throws java.lang.Exception {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$gotoPrevPage$14();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void disableSlide(int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - disableSlide - state = [" + i + "]");
        this.exerciseView.studyFragment.disableSlide(i);
    }

    @android.webkit.JavascriptInterface
    public void disableSlideDirection(int i, int i2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - disableSlideDirection - direction = [" + i + "], state = [" + i2 + "]");
        this.exerciseView.studyFragment.disableSlideDirection(i, i2);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadBookInfo() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - loadBookInfo - ");
        return this.pageInfoHelper.loadBookInfo();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadChapterInfo() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - loadChapterInfo - ");
        return this.pageInfoHelper.loadChapterInfo();
    }

    @android.webkit.JavascriptInterface
    public void gotoTask(final java.lang.String str, final java.lang.String str2, final int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - gotoTask - taskId = [" + str + "], pageId = [" + str2 + "], mode = [" + i + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda24
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$gotoTask$16(str, str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$gotoTask$16(java.lang.String str, java.lang.String str2, int i) throws java.lang.Exception {
        this.exerciseView.studyFragment.gotoTask(str, str2, i);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadTaskInfo() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - loadTaskInfo - ");
        return this.pageInfoHelper.loadTaskInfo();
    }

    @android.webkit.JavascriptInterface
    public void requestDataFromServer(int i, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - requestDataFromServer - sessionId = [" + i + "], url = [" + str + "]");
        this.httpHelper.httpSend(i, str);
    }

    @android.webkit.JavascriptInterface
    public void submitDataForServer(int i, java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - submitDataForServer - sessionId = [" + i + "], url = [" + str + "]");
        this.httpHelper.httpSendToQueue(i, str, str2);
    }

    @android.webkit.JavascriptInterface
    public int httpRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - httpRequest - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        return this.httpHelper.httpRequest(str);
    }

    @android.webkit.JavascriptInterface
    public void similarQuestion(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - similarQuestion - questionId = [" + str + "], num = [" + i + "]");
        android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.SIMILAR);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("questionId", str);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.page.obj.getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, this.page.obj.getTaskId());
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        this.context.startActivity(intent);
    }

    @android.webkit.JavascriptInterface
    public void registerEvent(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - registerEvent - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegisterEvent(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - unRegisterEvent - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public void redownloadChapter() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - redownloadChapter - ");
        com.up366.mobile.book.model.ChapterInfo chapterInfo = this.page.obj;
        if (!this.page.obj.isContent()) {
            chapterInfo = this.page.getContentPPage().obj;
        }
        this.context.contentDownloadHelper.downloadContent(chapterInfo);
    }

    @android.webkit.JavascriptInterface
    public void updateNavigationTitle(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - updateNavigationTitle - title = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda15
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateNavigationTitle$17(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateNavigationTitle$17(java.lang.String str) throws java.lang.Exception {
        this.context.setTitle(str);
    }

    @android.webkit.JavascriptInterface
    public void writeJSErrorLog(java.lang.String str) {
        com.up366.common.log.Logger.info("JS-LOG:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getTasksUploadStatus() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getTasksUploadStatus - ");
        return com.up366.mobile.book.helper.TaskUploadStatusHelper.get();
    }

    @android.webkit.JavascriptInterface
    public void buyBook(final int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - buyBook - productId = [" + i + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda26
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$buyBook$18(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buyBook$18(int i) throws java.lang.Exception {
        this.context.buyBookHelper.buy(i);
    }

    @android.webkit.JavascriptInterface
    public void skipToAppointPage(final java.lang.String str, final java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - skipToAppointPage - chapterId = [" + str + "], pageId = [" + str2 + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$skipToAppointPage$19(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$skipToAppointPage$19(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        this.context.bookOpenStudyHelper.study(str, str2, 1);
        this.context.finish();
    }

    @android.webkit.JavascriptInterface
    public void trainingMode(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final java.lang.String str5) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - trainingMode - stage = [" + str + "], subject = [" + str2 + "], knowlege = [" + str3 + "], diff = [" + str4 + "], num = [" + str5 + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$trainingMode$20(str, str2, str3, str4, str5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trainingMode$20(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) throws java.lang.Exception {
        this.openHelper.trainingMode(str, str2, str3, str4, str5);
    }

    @android.webkit.JavascriptInterface
    public void uploadFile(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - uploadFile - params = [" + str + "]");
        this.uploadFileHelper.upload(str);
    }

    @android.webkit.JavascriptInterface
    public void share(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - share - params = [" + str + "]");
        this.shareHelper.share(str, this.webView);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCourseId() {
        int courseId = this.context.book.getCourseId();
        return courseId < 1 ? "" : java.lang.String.valueOf(courseId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$login$21() throws java.lang.Exception {
        com.up366.mobile.user.account.login.AccountLoginActivity.open(this.context);
    }

    @android.webkit.JavascriptInterface
    public void login() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$login$21();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void feedBackRec(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterface - feedBackRec - params = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            string = object.getString("testId");
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda33
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$feedBackRec$22(string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$feedBackRec$22(java.lang.String str) throws java.lang.Exception {
        new com.up366.mobile.common.compat.FeedbackTaskRecord(this.webView.getContext(), str).show();
    }

    @android.webkit.JavascriptInterface
    public void questionFeedBackRec(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - questionFeedBackRec - params = [" + str + "]");
        com.up366.mobile.common.utils.ViewUtil.runTapAction(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda20
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$questionFeedBackRec$24(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$questionFeedBackRec$24(java.lang.String str) throws java.lang.Exception {
        new com.up366.mobile.common.views.OralFeedbackDialog(this.webView.getContext(), str, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                this.f$0.lambda$questionFeedBackRec$23(i, str2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$questionFeedBackRec$23(int i, java.lang.String str) {
        this.webView.callJSMethod("questionfeedbackupload({code:" + i + "})");
    }

    @android.webkit.JavascriptInterface
    public void mixAudioVideo(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - mixAudioVideo - params = [" + str + "]");
        this.muxAVHelper.mux(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getBookInfo() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getBookInfo - ");
        return this.context.bookChapterInfo.getHtmlJsonStr();
    }

    @android.webkit.JavascriptInterface
    public void study(final java.lang.String str, final java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - study - chapterId = [" + str + "], pageId = [" + str2 + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$study$25(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$study$25(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        this.context.bookOpenStudyHelper.study(str, str2, 0);
        this.context.finish();
    }

    @android.webkit.JavascriptInterface
    public void saveToGallery(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - saveToGallery - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$saveToGallery$26(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToGallery$26(java.lang.String str) throws java.lang.Exception {
        this.localMediaHelper.saveToGallery(str);
    }

    @android.webkit.JavascriptInterface
    public int getStudyTaskNum() {
        return com.up366.mobile.course.task.model.CoursePageCountHolder.load().getCurrentTaskNum();
    }

    @android.webkit.JavascriptInterface
    public void gotoNativeModule(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - gotoNativeModule - params = [" + str + "]");
        this.openHelper.gotoNativeModule(str);
    }

    @android.webkit.JavascriptInterface
    public void ocr(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - ocr - json = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.igexin.push.core.b.C);
        int intValue = object.getIntValue("skipConfirm");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - ocr - ");
        this.takePhotoHelper.getPictureCropAndRecognition(intValue, new com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback
            public final void onResult(java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.f$0.lambda$ocr$27(string, str2, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ocr$27(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.igexin.push.core.b.C, str);
        if (str2 == null) {
            jSONObject.put("result", "");
        } else {
            jSONObject.put("result", com.alibaba.fastjson.JSONObject.parseObject(str2));
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str3)) {
            str3 = "";
        }
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str3);
        if (com.up366.common.StringUtils.isEmptyOrNull(str4)) {
            str4 = "";
        }
        jSONObject.put("tid", str4);
        this.webView.callJSMethod("onOCRFinished(%s)", jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public void copyToClipboard(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - copyToClipboard - text = [" + str + "]");
        new com.up366.mobile.book.helper.ClipBoardHelper(this.context).copyTextToClipboard(str);
    }

    @android.webkit.JavascriptInterface
    public void openDictionary(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - openDictionary - json = [" + str + "]");
        this.openHelper.openDictionary(str);
    }

    @android.webkit.JavascriptInterface
    public void openDictionaryV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - openDictionaryV2 - json = [" + str + "]");
        this.openHelper.openDictionaryV2(str);
    }

    @android.webkit.JavascriptInterface
    public void uploadUserLog(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - uploadUserLog - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda34
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$uploadUserLog$28(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$28(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.ActionLogRecord.recordJS(this.webView, com.alibaba.fastjson.JSON.parseObject(str));
    }

    @android.webkit.JavascriptInterface
    public int getHeadSetStatus() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - getHeadSetStatus");
        return this.headsetHelper.getHeadsetState() == 1 ? 1 : 0;
    }

    @android.webkit.JavascriptInterface
    public void giveMark() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - giveMark ");
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$giveMark$29();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$giveMark$29() throws java.lang.Exception {
        com.up366.mobile.common.dialog.PraiseDialog.create(this.context).show();
    }

    @android.webkit.JavascriptInterface
    public void launchXotEngine(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString("type");
        final java.lang.String string2 = object.getString("data");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - launchXotEngine - type = [" + string + "], data = [" + string2 + "], openNewWebView = [true]");
        final boolean z = true;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda29
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$launchXotEngine$30(string, string2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchXotEngine$30(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Exception {
        this.openHelper.launchXotEngine(str, str2, z);
    }

    @android.webkit.JavascriptInterface
    public void disableScreenCapture(final boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - disableScreenCapture - disable = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda22
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$disableScreenCapture$31(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disableScreenCapture$31(boolean z) throws java.lang.Exception {
        if (z) {
            this.context.getWindow().setFlags(io.objectbox.model.PropertyFlags.UNSIGNED, io.objectbox.model.PropertyFlags.UNSIGNED);
        } else {
            this.context.getWindow().clearFlags(io.objectbox.model.PropertyFlags.UNSIGNED);
        }
    }

    @android.webkit.JavascriptInterface
    public void upgradeClient() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - upgradeClient - ");
        com.up366.mobile.book.helper.AppInfoHelper.upgradeClient(this.context);
    }

    @android.webkit.JavascriptInterface
    public void openWebView(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - openWebView - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebView$32(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$32(java.lang.String str) throws java.lang.Exception {
        this.webView.getCurrentDir();
        this.exerciseView.studyFragment.openNewPageHelper.openWebView(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebViewV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - openWebViewV2 - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda21
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebViewV2$33(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebViewV2$33(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.V8OpenHelper.openWebView(this.context, str, new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closePage();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void postMessage(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV6 - postMessage - msg = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV6$$ExternalSyntheticLambda30
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$postMessage$34(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$34(java.lang.String str) throws java.lang.Exception {
        this.registerHelper.postMessage(str);
    }
}
