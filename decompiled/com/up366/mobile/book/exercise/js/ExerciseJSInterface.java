package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseJSInterface {
    public com.up366.mobile.book.exercise.js.AudioHelper audioHelper;
    private com.up366.mobile.book.helper.ClipBoardHelper clipBoardHelper;
    private com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();
    private com.up366.mobile.book.exercise.js.ExerciseHelper exerciseHelper;
    private com.up366.mobile.book.exercise.js.HttpHelper httpHelper;
    private com.up366.mobile.book.exercise.js.PathHelper pathHelper;
    public com.up366.mobile.book.exercise.js.RecordHelper recordHelper;
    public com.up366.mobile.book.exercise.js.RegisterHelper registerHelper;
    private com.up366.mobile.book.helper.ShareHelper shareHelper;
    private com.up366.mobile.book.webview.StudyPageWebView webView;

    @android.webkit.JavascriptInterface
    public void hideTbsVideoFullscreenButton() {
    }

    public ExerciseJSInterface(com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView, com.up366.mobile.book.exercise.js.ExerciseHelper exerciseHelper) {
        this.webView = exerciseHtmlView.b.webView;
        this.exerciseHelper = exerciseHelper;
        this.registerHelper = new com.up366.mobile.book.exercise.js.RegisterHelper(this.webView, exerciseHtmlView);
        this.pathHelper = new com.up366.mobile.book.exercise.js.PathHelper(exerciseHtmlView.dataHelper);
        this.audioHelper = new com.up366.mobile.book.exercise.js.AudioHelper(this.webView, this.pathHelper, this.registerHelper);
        this.recordHelper = new com.up366.mobile.book.exercise.js.RecordHelper(this.webView, this.pathHelper, this.registerHelper);
        this.httpHelper = new com.up366.mobile.book.exercise.js.HttpHelper(this.webView, this.registerHelper);
        this.shareHelper = new com.up366.mobile.book.helper.ShareHelper(exerciseHtmlView.context);
        this.clipBoardHelper = new com.up366.mobile.book.helper.ClipBoardHelper(exerciseHtmlView.context);
    }

    @android.webkit.JavascriptInterface
    public void register(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - register - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegister(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - unRegister - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public void saveData(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.debug("TAG - 2018/5/31 - ExerciseJSInterface - saveData - key = [" + str + "], data = [" + str2 + "]");
        this.dataHelper.saveData(str, str2);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(java.lang.String str) {
        com.up366.common.log.Logger.debug("TAG - 2018/5/31 - ExerciseJSInterface - loadData - key = [" + str + "]");
        return this.dataHelper.loadData(str);
    }

    @android.webkit.JavascriptInterface
    public int playAudioWithParams(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterface - playAudioWithParams - json = [" + str + "]");
        return this.audioHelper.playAudioWithParams(str);
    }

    @android.webkit.JavascriptInterface
    public void pausePlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - pausePlayAudio - audioId = [" + str + "]");
        this.audioHelper.pausePlayAudio(str);
    }

    @android.webkit.JavascriptInterface
    public void resumePlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - resumePlayAudio - audioId = [" + str + "]");
        this.audioHelper.resumePlayAudio(str);
    }

    @android.webkit.JavascriptInterface
    public void stopPlayAudio(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - stopPlayAudio - audioId = [" + str + "]");
        this.audioHelper.stopPlayAudio(str);
    }

    @android.webkit.JavascriptInterface
    public int getAudioCurrentTime(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - getAudioCurrentTime - audioId = [" + str + "]");
        return this.audioHelper.getAudioCurrentTime(str);
    }

    @android.webkit.JavascriptInterface
    public void seekPlayAudio(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - seekPlayAudio - audioId = [" + str + "], seek = [" + i + "]");
        this.audioHelper.seekPlayAudio(str, i);
    }

    @android.webkit.JavascriptInterface
    public void startRecordWithParams(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - startRecordWithParams - json = [" + str + "]");
        this.recordHelper.startRecordWithParams(str);
    }

    @android.webkit.JavascriptInterface
    public void startRecordWithParamsV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/4/9 - ExerciseJSInterface - startRecordWithParamsV2 - json = [" + str + "]");
        this.recordHelper.startRecordWithParamsV2(str);
    }

    @android.webkit.JavascriptInterface
    public void endRecord(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - endRecord - recordId = [" + str + "]");
        this.recordHelper.endRecord(str);
    }

    @android.webkit.JavascriptInterface
    public void httpRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - httpRequest - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        this.httpHelper.httpRequest(str);
    }

    @android.webkit.JavascriptInterface
    public long getNTPTimestamp() {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - getNTPTimestamp - ");
        return com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPageParams() {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - getPageParams - ");
        return this.exerciseHelper.getPageParams();
    }

    @android.webkit.JavascriptInterface
    public void submitAnswerData(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.up366.common.log.Logger.info("TAG - 2018/5/17 - ExerciseJSInterface - submitAnswerData - uploadId = [" + str + "], type = [" + str2 + "], json = [" + str3 + "]");
        this.exerciseHelper.submitTest(str, str2, str3);
    }

    @android.webkit.JavascriptInterface
    public void reset(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - 2018/5/21 - ExerciseJSInterface - clearAnswerData - uploadId = [" + str + "], type = [" + str2 + "]");
        this.exerciseHelper.clearAnswerData(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void ocr(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2020/8/20 - ExerciseJSInterface - ocr - params=" + str);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$ocr$0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ocr$0(java.lang.String str) throws java.lang.Exception {
        this.exerciseHelper.ocr(str);
    }

    @android.webkit.JavascriptInterface
    public void getPhoto(final java.lang.String str, final int i) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - getPhoto - questionId = [" + str + "], maxNum = [" + i + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getPhoto$1(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$1(java.lang.String str, int i) throws java.lang.Exception {
        this.exerciseHelper.getPhoto(str, i);
    }

    @android.webkit.JavascriptInterface
    public void deletePhoto(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - deletePhoto - picPath = [" + str + "]");
        this.exerciseHelper.deletePhoto(str);
    }

    @android.webkit.JavascriptInterface
    public void closePage() {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - closePage - ");
        this.exerciseHelper.closePage();
        this.audioHelper.release();
    }

    @android.webkit.JavascriptInterface
    public void showLoading(final boolean z) {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - showLoading - show = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda13
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showLoading$2(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$2(boolean z) throws java.lang.Exception {
        this.exerciseHelper.showLoading(z);
    }

    @android.webkit.JavascriptInterface
    public void launchXotEngine(final java.lang.String str, final java.lang.String str2, final boolean z) {
        com.up366.common.log.Logger.info("TAG - 2018/5/17 - ExerciseJSInterface - launchXotEngine - type = [" + str + "], json = [" + str2 + "], openNewWebview = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$launchXotEngine$3(str, str2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchXotEngine$3(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Exception {
        this.exerciseHelper.launchXotEngine(str, str2, z);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUploadProgressInfo() {
        com.up366.common.log.Logger.info("TAG - 2018/5/31 - ExerciseJSInterface - getUploadProgressInfo - ");
        return com.up366.mobile.book.exercise.js.ExerciseUploadStatusHelper.get();
    }

    @android.webkit.JavascriptInterface
    public void writeJSErrorLog(java.lang.String str) {
        com.up366.common.log.Logger.error("JS-LOG:" + str);
    }

    @android.webkit.JavascriptInterface
    public void continueUploadAnswerData(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - 2018/8/23 - ExerciseJSInterface - continueUploadAnswerData - uploadId = [" + str + "], type = [" + str2 + "]");
        com.up366.mobile.common.onlinelog.OpLog.record("continueUploadAnswerData", "uploadId = [" + str + "], type = [" + str2 + "]");
        com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
        com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        com.up366.common.log.Logger.info("TAG - 2018/11/23 - ExerciseJSInterface - getClientInfo - ");
        return this.webView.getContext().getString(com.up366.mobile.R.string.js_interface_client_info_prefix) + com.up366.common.PackageUtils.getVersionName();
    }

    @android.webkit.JavascriptInterface
    public void share(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/3/26 - ExerciseJSInterface - share - params = [" + str + "]");
        this.shareHelper.share(str, this.webView);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3 A[PHI: r3 r6 r12
  0x00d3: PHI (r3v3 java.lang.String) = (r3v2 java.lang.String), (r3v5 java.lang.String) binds: [B:27:0x009c, B:38:0x00c8] A[DONT_GENERATE, DONT_INLINE]
  0x00d3: PHI (r6v2 java.lang.String) = (r6v1 java.lang.String), (r6v4 java.lang.String) binds: [B:27:0x009c, B:38:0x00c8] A[DONT_GENERATE, DONT_INLINE]
  0x00d3: PHI (r12v1 int) = (r12v0 int), (r12v3 int) binds: [B:27:0x009c, B:38:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showConfirm(java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.exercise.js.ExerciseJSInterface.showConfirm(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConfirm$4(java.lang.String str, android.view.View view) {
        if (str != null) {
            this.webView.callJSMethod(str + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConfirm$5(java.lang.String str, android.view.View view) {
        if (str != null) {
            this.webView.callJSMethod(str + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConfirm$6(java.lang.String str, android.view.View view) {
        if (str != null) {
            this.webView.callJSMethod(str + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConfirm$7(java.lang.String str, android.view.View view) {
        if (str != null) {
            this.webView.callJSMethod(str + "()");
        }
    }

    @android.webkit.JavascriptInterface
    public void showInfo(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/3/26 - ExerciseJSInterface - showInfo - params = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString(com.igexin.sdk.FlymePushReceiver.CONTENT);
        int intValue = object.getIntValue("type");
        if (intValue == 1) {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(this.webView, string);
            return;
        }
        if (intValue == 2) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(this.webView, string);
        } else if (intValue == 3) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, string);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, string);
        }
    }

    @android.webkit.JavascriptInterface
    public void editHomework(int i) {
        com.up366.common.log.Logger.info("TAG - 2019/3/26 - ExerciseJSInterface - editHomework - ");
    }

    @android.webkit.JavascriptInterface
    public void publishHomework() {
        com.up366.common.log.Logger.info("TAG - 2019/4/10 - ExerciseJSInterface - publishHomework - ");
    }

    @android.webkit.JavascriptInterface
    public void openAttachment(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/8/16 - ExerciseJSInterface - openAttachment - json = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        final java.lang.String string2 = object.getString("mimeType");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openAttachment$8(string, string2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openAttachment$8(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.mobile.common.utils.AttachmentUtils.openFile(new java.io.File(com.up366.common.FileUtilsUp.join(this.pathHelper.getCurrentPath()), str), str2);
    }

    @android.webkit.JavascriptInterface
    public void feedBackRec(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/8/27 - ExerciseJSInterface - feedBackRec - params = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            string = object.getString("testId");
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$feedBackRec$9(string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$feedBackRec$9(java.lang.String str) throws java.lang.Exception {
        new com.up366.mobile.common.compat.FeedbackTaskRecord(this.webView.getContext(), str).show();
    }

    @android.webkit.JavascriptInterface
    public void refreshList(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/10/21 - ExerciseJSInterface - refreshList - params = [" + str + "]");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("type");
        object.getIntValue("status");
        string.hashCode();
        if (string.equals("job")) {
            com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("course-stat-list").invalid();
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("task-list").invalid();
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, "未定义:" + string);
        com.up366.common.log.Logger.info("TAG - 2019/10/21 - ExerciseJSInterface - refreshList - 未定义:" + string);
    }

    @android.webkit.JavascriptInterface
    public void questionFeedBackRec(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - 2019/10/21 - ExerciseJSInterface - questionFeedBackRec - params = [" + str + "]");
        com.up366.mobile.common.utils.ViewUtil.runTapAction(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$questionFeedBackRec$10(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$questionFeedBackRec$10(java.lang.String str) throws java.lang.Exception {
        new com.up366.mobile.common.views.OralFeedbackDialog(this.webView.getContext(), str).show();
    }

    @android.webkit.JavascriptInterface
    public void copyToClipboard(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG -  ExerciseJSInterface - copyToClipboard - text = [" + str + "]");
        this.clipBoardHelper.copyTextToClipboard(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String pasteFromClipboard() {
        java.lang.String text = this.clipBoardHelper.getText();
        com.up366.common.log.Logger.info("TAG -  ExerciseJSInterface - pasteFromClipboard - return = [" + text + "]");
        return text;
    }

    @android.webkit.JavascriptInterface
    public void openDictionary(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterface - openDictionary - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openDictionary$11(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionary$11(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.StudyActivityDialog.openDict((android.app.Activity) this.webView.getContext(), this.webView, str);
    }

    public void openDictionaryV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ExerciseJSInterface - openDictionaryV2 - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openDictionaryV2$12(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionaryV2$12(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.StudyActivity2025Dialog.openDict((android.app.Activity) this.webView.getContext(), this.webView, str);
    }

    @android.webkit.JavascriptInterface
    public void openScanPaper(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - openScanPaper - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseJSInterface$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openScanPaper$13(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openScanPaper$13(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.course.photoanswer.PhotoAnswerOpenHelper.openScanPaper((android.app.Activity) this.webView.getContext(), str);
    }
}
