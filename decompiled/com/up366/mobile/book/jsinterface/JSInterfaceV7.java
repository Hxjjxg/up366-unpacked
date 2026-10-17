package com.up366.mobile.book.jsinterface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class JSInterfaceV7 extends com.up366.mobile.book.jsbase.BaseJSInterface {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    private final com.up366.mobile.book.helper.V7AudioHelper audioHelper;
    private final com.up366.mobile.book.helper.V7BookTaskLogHelper bookTaskLogHelper;
    private final com.up366.mobile.book.helper.V7ChapterDataHelper chapterDataHelper;
    private final com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper clippedPhotoV2Helper;
    private final android.app.Activity context;
    private final com.up366.mobile.book.helper.DataHelper dataHelper;
    private final com.up366.mobile.book.helper.HeadsetHelper headsetHelper;
    private final com.up366.mobile.book.helper.V7HttpHelper httpHelper;
    private final com.up366.mobile.book.helper.InputHelper inputHelper;
    private final com.up366.mobile.book.helper.V7LocalMediaHelper localMediaHelper;
    private final com.up366.mobile.book.helper.mux.IMuxAVHelper muxAVHelper;
    public final com.up366.mobile.book.helper.V7ExerciseOpenHelper openHelper;
    private final com.up366.mobile.book.model.CatalogPage page;
    private final com.up366.mobile.book.helper.V7PageInfoHelper pageInfoHelper;
    private final int position;
    private final com.up366.mobile.book.helper.V7RecordHelper recordHelper;
    private final com.up366.mobile.book.helper.V7RegisterHelper registerHelper;
    private final com.up366.mobile.book.helper.V7ShareHelper shareHelper;
    private final com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    private final com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private final com.up366.mobile.book.helper.JSUploadFileHelper uploadFileHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public JSInterfaceV7(com.up366.mobile.book.StudyActivityInterface studyActivityInterface, com.up366.mobile.book.studyviews.StudyV7View studyV7View, com.up366.mobile.book.model.CatalogPage catalogPage, int i) {
        this.studyActivityInterface = studyActivityInterface;
        android.app.Activity context = studyActivityInterface.m1148getContext();
        this.context = context;
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = studyV7View.b.webView;
        this.webView = studyPageWebView;
        this.page = catalogPage;
        this.position = i;
        this.bookTaskLogHelper = studyV7View.bookTaskLogHelper;
        this.registerHelper = studyV7View.registerHelper;
        this.headsetHelper = studyActivityInterface.getHeadsetHelper();
        this.inputHelper = new com.up366.mobile.book.helper.InputHelper(studyPageWebView);
        com.up366.mobile.book.helper.V7ChapterDataHelper v7ChapterDataHelper = studyV7View.dataHelper;
        this.chapterDataHelper = v7ChapterDataHelper;
        this.pageInfoHelper = new com.up366.mobile.book.helper.V7PageInfoHelper(studyActivityInterface, catalogPage, v7ChapterDataHelper);
        com.up366.mobile.book.helper.DataHelper dataHelper = new com.up366.mobile.book.helper.DataHelper();
        this.dataHelper = dataHelper;
        this.recordHelper = studyV7View.recordHelper;
        this.audioHelper = studyV7View.audioHelper;
        this.openHelper = studyV7View.openHelper;
        this.appInfoHelper = studyV7View.appInfoHelper;
        this.httpHelper = new com.up366.mobile.book.helper.V7HttpHelper();
        this.shareHelper = new com.up366.mobile.book.helper.V7ShareHelper(context);
        this.uploadFileHelper = new com.up366.mobile.book.helper.JSUploadFileHelper(dataHelper);
        this.muxAVHelper = new com.up366.mobile.book.helper.V7MuxAVHelperV2(studyActivityInterface, studyPageWebView, v7ChapterDataHelper, catalogPage);
        this.localMediaHelper = new com.up366.mobile.book.helper.V7LocalMediaHelper(context);
        this.takePhotoHelper = studyActivityInterface.getTakePhotoHelper();
        this.clippedPhotoV2Helper = studyActivityInterface.getPhotoPickerClippedPhotoV2Helper();
    }

    @android.webkit.JavascriptInterface
    public void registerEvent(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV7 - registerEvent - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegisterEvent(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - unRegisterEvent - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebView(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - openWebView - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda75
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebView$0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$0(java.lang.String str) throws java.lang.Exception {
        this.openHelper.openWebView(str);
    }

    @android.webkit.JavascriptInterface
    public void openWebViewV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - openWebViewV2 - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda15
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openWebViewV2$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebViewV2$1(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.V8OpenHelper.openWebView(this.context, str, new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closeWebView();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void closeWebView() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - closeWebView - ");
        final com.up366.mobile.book.helper.V7ExerciseOpenHelper v7ExerciseOpenHelper = this.openHelper;
        java.util.Objects.requireNonNull(v7ExerciseOpenHelper);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda17
            @Override // com.up366.common.task.Task
            public final void run() {
                v7ExerciseOpenHelper.closeWebView();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPageParams() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda76
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getPageParams$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getPageParams$2() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getPageParams - ");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(this.studyActivityInterface.getOpenConfigInfo().exerciseData);
        if (object == null) {
            object = new com.alibaba.fastjson.JSONObject();
        }
        if (this.page != null && !object.containsKey(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID)) {
            object.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, this.studyActivityInterface.getOpenConfigInfo().studyTaskId);
        }
        return object;
    }

    @android.webkit.JavascriptInterface
    public void backToBookShelf() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - backToBookShelf - ");
        final com.up366.mobile.book.helper.V7ExerciseOpenHelper v7ExerciseOpenHelper = this.openHelper;
        java.util.Objects.requireNonNull(v7ExerciseOpenHelper);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda13
            @Override // com.up366.common.task.Task
            public final void run() {
                v7ExerciseOpenHelper.backToBookShelf();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void backToCatalog() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - backToBookShelf - ");
        final com.up366.mobile.book.helper.V7ExerciseOpenHelper v7ExerciseOpenHelper = this.openHelper;
        java.util.Objects.requireNonNull(v7ExerciseOpenHelper);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() {
                v7ExerciseOpenHelper.backToCatalog();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String saveData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveData$3(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveData$3(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("key");
        java.lang.String string2 = object.getString("value");
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV7 - saveData - key = [" + string + "], value.length() = [" + string2.length() + "]");
        if (this.dataHelper.saveData(string, string2) == 1) {
            return;
        }
        throw new java.lang.IllegalStateException("保存失败:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loadData(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda44
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$loadData$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$loadData$4(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "key");
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV7 - loadData - key = [" + param + "]");
        return this.dataHelper.loadData(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String playAudio(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda61
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$playAudio$5(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$playAudio$5(java.lang.String str) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - playAudio - audioConfig = [" + str + "]");
        return java.lang.Integer.valueOf(this.audioHelper.playAudioWithParams(str));
    }

    @android.webkit.JavascriptInterface
    public void pauseAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - pauseAudio - audioId = [" + param + "]");
        this.audioHelper.pausePlay(param);
    }

    @android.webkit.JavascriptInterface
    public void resumeAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - resumeAudio - audioId = [" + param + "]");
        this.audioHelper.resumePlaying(param);
    }

    @android.webkit.JavascriptInterface
    public void stopAudio(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - stopAudio - audioId = [" + param + "]");
        this.audioHelper.stopPlay(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCurrentAudioTime(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda34
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getCurrentAudioTime$6(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getCurrentAudioTime$6(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV7 - getCurrentAudioTime - audioId = [" + param + "]");
        return java.lang.Integer.valueOf(this.audioHelper.getCurrentTime(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setAudioRate(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda78
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setAudioRate$7(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAudioRate$7(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        float paramFloat = getParamFloat(str, "rate");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - setAudioRate - audioId = [" + param + "], rate = [" + paramFloat + "]");
        this.audioHelper.setRate(param, paramFloat);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAudioRate(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda83
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAudioRate$8(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAudioRate$8(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getAudioRate - audioId = [" + param + "]");
        float rate = this.audioHelper.getRate(param);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("rate", java.lang.Float.valueOf(rate));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public void startRecord(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - startRecord - recConfig = [" + str + "]");
        this.recordHelper.startRecordWithParamsV2(str);
    }

    @android.webkit.JavascriptInterface
    public void stopRecord(java.lang.String str) {
        java.lang.String param = getParam(str, "recordId");
        int paramInt = getParamInt(str, "giveup");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - stopRecord - recordId = [" + param + "]");
        if (paramInt == 0) {
            this.recordHelper.endRecord(param);
        } else {
            this.recordHelper.forceStopAll();
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getBookData() {
        final com.up366.mobile.book.model.TreeBookChapter bookChapterInfo = this.studyActivityInterface.getBookChapterInfo();
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getBookData - hasLoad : " + bookChapterInfo.isHasLoadTreeChapterData());
        if (bookChapterInfo.isHasLoadTreeChapterData()) {
            return "{\"data\": " + bookChapterInfo.getHtmlJsonStr() + ",\"result\": {\"code\": 0,\"msg\": \"success\"}}";
        }
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        bookChapterInfo.setAsyncTreeDataLoadedCallbackRunnable(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda50
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getBookData$9(bookChapterInfo, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBookData$9(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, java.lang.String str) throws java.lang.Exception {
        this.webView.getBridgeHelper().responseAsyncResult(str, "{\"data\": " + treeBookChapter.getHtmlJsonStr() + ",\"result\": {\"code\": 0,\"msg\": \"success\"}}");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getBookInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda72
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getBookInfo$10();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getBookInfo$10() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getBookInfo - ");
        return com.alibaba.fastjson.JSON.parse(this.pageInfoHelper.loadBookInfo());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getChapterInfo(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda54
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getChapterInfo$11(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getChapterInfo$11(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "chapterId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getChapterInfo - chapterId : " + param);
        if (com.up366.common.StringUtils.isEmptyOrNull(param)) {
            param = this.page.getChapterPPage().obj.getId();
        }
        return com.alibaba.fastjson.JSON.parse(this.pageInfoHelper.loadChapterInfo(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getTaskInfo(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getTaskInfo - json = [" + str + "]");
        try {
            if (com.up366.common.StringUtils.isEmptyOrNull(getParam(str, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID)) && this.page == null) {
                com.up366.common.log.Logger.warn("TAG - JSInterfaceV7 - getTaskInfo : 当前页面不存在page信息");
                return buildResultError(-100, "当前页面不存在page信息");
            }
        } catch (java.lang.Exception unused) {
        }
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda40
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getTaskInfo$12(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getTaskInfo$12(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        if (com.up366.common.StringUtils.isEmptyOrNull(param)) {
            param = this.page.obj.getTaskId();
        }
        return com.alibaba.fastjson.JSON.parse(this.pageInfoHelper.loadTaskInfo(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPageInfo(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda68
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getPageInfo$13(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getPageInfo$13(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "pageId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getPageInfo - pageId = [" + param + "]");
        return com.alibaba.fastjson.JSON.parse(this.pageInfoHelper.loadPageInfo(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String deleteChapter(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteChapter$14(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteChapter$14(java.lang.String str) {
        java.lang.String param = getParam(str, "chapterId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - deleteChapter - chapterId = [" + param + "]");
        this.studyActivityInterface.getContentDownloadHelper().deleteChapter(param);
    }

    @android.webkit.JavascriptInterface
    public void downloadChapter(java.lang.String str) {
        java.lang.String param = getParam(str, "chapterId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - downloadChapter - chapterId = [" + param + "]");
        com.up366.mobile.book.model.CatalogChapter chapter = this.studyActivityInterface.getBookChapterInfo().getChapter(param);
        if (chapter != null) {
            this.studyActivityInterface.getContentDownloadHelper().downloadContentFromJS(chapter.getObj());
        }
    }

    @android.webkit.JavascriptInterface
    public void updateTitleBar(java.lang.String str) {
        final java.lang.String param = getParam(str, "title");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - updateTitleBar - title = [" + param + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda48
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateTitleBar$15(param);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTitleBar$15(java.lang.String str) throws java.lang.Exception {
        this.studyActivityInterface.getTitleBar().setTitle(str);
    }

    @android.webkit.JavascriptInterface
    public void launchXotEngine(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString("type");
        final java.lang.String string2 = object.getString("data");
        final boolean booleanValue = object.getBooleanValue("openNewWebview");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - launchXotEngine - type = [" + string + "], data = [" + string2 + "], openNewWebView = [" + booleanValue + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda14
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$launchXotEngine$16(string, string2, booleanValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchXotEngine$16(java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Exception {
        this.openHelper.launchXotEngine(str, str2, z);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClientInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda36
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getClientInfo$17();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getClientInfo$17() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getClientInfo - ");
        return this.appInfoHelper.getClientInfoV7();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUserInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getUserInfo$18();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getUserInfo$18() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getUserInfo - ");
        return com.alibaba.fastjson.JSON.parse(this.appInfoHelper.getUserInfoV7());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String submitTask(final java.lang.String str) {
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda74
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$submitTask$20(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitTask$20(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        try {
            com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - submitTask - taskData = [" + str + "]");
            this.bookTaskLogHelper.submitTaskV1(str, this.page);
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTaskCallback = new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda46
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$submitTask$19(str2);
                }
            };
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - JSInterfaceV7 - submitTask - " + e.getMessage(), e);
            this.webView.getBridgeHelper().responseAsyncResult(str2, buildResultError(-2, e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitTask$19(java.lang.String str) {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(null));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getTasksUploadStatus() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getTasksUploadStatus - ");
        return buildResultSuccess(com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.book.helper.TaskUploadStatusHelper.get()));
    }

    @android.webkit.JavascriptInterface
    public void manualUploadTask() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - manualUploadTask - ");
        com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
        com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAsecResult(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAsecResult$21(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAsecResult$21(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "recordId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getAsecResult - recordId = [" + param + "]");
        return com.alibaba.fastjson.JSON.parse(this.recordHelper.getAsecResult(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String delAsecResult(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$delAsecResult$22(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$delAsecResult$22(java.lang.String str) {
        java.lang.String param = getParam(str, "recordId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - delAsecResult - recordId = [" + param + "]");
        this.recordHelper.deleteByRecordId(param);
    }

    @android.webkit.JavascriptInterface
    public void postMessage(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - postMessage - msg = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda53
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$postMessage$23(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$23(java.lang.String str) throws java.lang.Exception {
        this.registerHelper.postMessage(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getNetWorkInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda67
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getNetWorkInfo$24();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getNetWorkInfo$24() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getNetWorkInfo - ");
        return this.appInfoHelper.getNetWorkInfo();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String removeData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeData$25(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeData$25(java.lang.String str) {
        java.lang.String param = getParam(str, "key");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - removeData - key = [" + param + "]");
        if (this.dataHelper.deleteData(param) == 1) {
            return;
        }
        throw new java.lang.IllegalStateException("删除失败:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String share(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - share - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda28
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$share$27(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$27(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.shareHelper.share(str, this.webView, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda66
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                this.f$0.lambda$share$26(str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$26(java.lang.String str, int i, java.lang.String str2) {
        if (i == 0) {
            if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.context, "保存成功");
            }
            this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(1));
            return;
        }
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - share - result - code:" + i + " info:" + str2);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.webView, str2);
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(-2, str2));
    }

    @android.webkit.JavascriptInterface
    public void uploadFile(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - uploadFile - params = [" + str + "]");
        this.uploadFileHelper.upload(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String httpRequest(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - httpRequest - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.httpHelper.httpSend(str, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda59
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                this.f$0.lambda$httpRequest$28(asyncUniqueKey, i, str2, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$httpRequest$28(java.lang.String str, int i, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        this.webView.getBridgeHelper().responseAsyncResult(str, jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String httpQueue(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - httpQueue - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda80
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$httpQueue$29(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$httpQueue$29(java.lang.String str) {
        this.httpHelper.httpSendToQueue(str);
    }

    @android.webkit.JavascriptInterface
    public void seekPlayAudio(java.lang.String str, int i) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - seekPlayAudio - audioPlayerId = [" + str + "], position = [" + i + "]");
        this.audioHelper.seekPlay(str, i);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setVolume(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setVolume$30(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVolume$30(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        int paramInt = getParamInt(str, "volume");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - setVolume - audioPlayerId = [" + param + "], volume = [" + paramInt + "]");
        this.audioHelper.setVolume(param, paramInt);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String mixAudioVideo(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - mixAudioVideo - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.muxAVHelper.mux(str, new com.up366.mobile.book.helper.mux.IMuxCallback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda62
            @Override // com.up366.mobile.book.helper.mux.IMuxCallback
            public final void onResult(int i, java.lang.String str2, java.lang.String str3) {
                this.f$0.lambda$mixAudioVideo$31(asyncUniqueKey, i, str2, str3);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mixAudioVideo$31(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("code", java.lang.Integer.valueOf(i));
        jSONObject.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, str2);
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str3);
        this.webView.getBridgeHelper().responseAsyncResult(str, "{\"data\": " + jSONObject.toJSONString() + ",\"result\": {\"code\": 0,\"msg\": \"success\"}}");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String saveToGallery(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - saveToGallery - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda35
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$saveToGallery$33(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToGallery$33(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.localMediaHelper.saveToGallery(str, new com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda18
            @Override // com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback
            public final void onResult(int i) {
                this.f$0.lambda$saveToGallery$32(str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToGallery$32(java.lang.String str, int i) {
        this.webView.getBridgeHelper().responseAsyncResult(str, "{\"result\": {\"code\": " + i + ",\"msg\": \"success\"}}");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUUID() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getUUID - ");
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    @android.webkit.JavascriptInterface
    public void showIMM(boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - showIMM - show = [" + z + "]");
        this.inputHelper.showIMM(z);
    }

    @android.webkit.JavascriptInterface
    public void toast(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - toast - msg = [" + str + "]");
        com.up366.mobile.common.utils.ToastPopupUtil.show(this.webView, str);
    }

    @android.webkit.JavascriptInterface
    public void hideBackBtn(final boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - hideBackBtn - isHide = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda26
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$hideBackBtn$34(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideBackBtn$34(boolean z) throws java.lang.Exception {
        this.studyActivityInterface.getTitleBar().showBack(!z);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCourseId() {
        com.up366.common.log.Logger.info("TAG - 2019/5/17 - JSInterfaceV7 - getCourseId - ");
        int courseId = this.studyActivityInterface.getBookInfoStudy().getCourseId();
        return courseId < 1 ? "" : java.lang.String.valueOf(courseId);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String ocr(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - ocr - json = [" + str + "]");
        int intValue = com.alibaba.fastjson.JSON.parseObject(str).getIntValue("skipConfirm");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.takePhotoHelper.getPictureCropAndRecognition(intValue, new com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback
            public final void onResult(java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.f$0.lambda$ocr$35(asyncUniqueKey, str2, str3, str4);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ocr$35(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (str2 == null) {
            jSONObject.put("code", 1);
            jSONObject.put("result", "");
        } else {
            jSONObject.put("code", 0);
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
        this.webView.getBridgeHelper().responseAsyncResult(str, "{\"data\": " + jSONObject.toJSONString() + ",\"result\": {\"code\": 0,\"msg\": \"success\"}}");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getModeInfo() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda51
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.book.jsinterface.JSInterfaceV7.lambda$getModeInfo$36();
            }
        });
    }

    static /* synthetic */ java.lang.Object lambda$getModeInfo$36() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getModeInfo - ");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("darkMode", false);
        jSONObject.put("fullScreenMode", false);
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getStudyTaskDetail() {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda30
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.book.jsinterface.JSInterfaceV7.lambda$getStudyTaskDetail$37();
            }
        });
    }

    static /* synthetic */ java.lang.Object lambda$getStudyTaskDetail$37() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getStudyTaskDetail - ");
        com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolderLoad = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("length", java.lang.Integer.valueOf(coursePageCountHolderLoad.getCurrentTaskNum()));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String uploadUserLog(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadUserLog$39(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$39(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - recordActionLog - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda20
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$uploadUserLog$38(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$38(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.ActionLogRecord.recordJS(this.webView, com.alibaba.fastjson.JSON.parseObject(str));
    }

    @android.webkit.JavascriptInterface
    public void __onResponseJSResult(int i, java.lang.String str) {
        this.webView.getBridgeHelper().onResponseData(i, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String copyToClipboard(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - copyToClipboard - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$copyToClipboard$40(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyToClipboard$40(java.lang.String str) {
        new com.up366.mobile.book.helper.ClipBoardHelper(this.context).copyTextToClipboard(getParam(str, "text"));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openDictionary(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - openDictionary - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda64
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openDictionary$42(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionary$41(java.lang.String str) throws java.lang.Exception {
        this.openHelper.openDictionary(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionary$42(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda73
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openDictionary$41(str);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openDictionaryV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - openDictionaryV2 - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openDictionaryV2$44(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionaryV2$43(java.lang.String str) throws java.lang.Exception {
        this.openHelper.openDictionaryV2(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionaryV2$44(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda49
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openDictionaryV2$43(str);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String showLoading(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - showLoading - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLoading$46(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$46(java.lang.String str) {
        final boolean paramBoolean = getParamBoolean(str, "showFlag");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda41
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showLoading$45(paramBoolean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$45(boolean z) throws java.lang.Exception {
        this.studyActivityInterface.showLoading(z, true);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setBackgroundColor(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - setBackgroundColor - json = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda60
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$setBackgroundColor$47(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$setBackgroundColor$47(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.setSystemViewColor(this.context, getParam(str, "color"), getParam(str, "backgroundColor"), getParam(str, "backgroundColorTop"), getParam(str, "backgroundColorBottom"));
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setStatusBar(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - setStatusBar - json = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda21
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$setStatusBar$48(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$setStatusBar$48(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.setStatusBarTextHidden(this.context, getParamBoolean(str, "hidden"));
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String pasteFromClipboard() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - pasteFromClipboard");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda57
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$pasteFromClipboard$49();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$pasteFromClipboard$49() throws java.lang.Exception {
        return new com.up366.mobile.book.helper.ClipBoardHelper(this.context).getText();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getHeadSetStatus() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getHeadSetStatus");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda79
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getHeadSetStatus$50();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getHeadSetStatus$50() throws java.lang.Exception {
        if (this.headsetHelper.getHeadsetState() == 1) {
            return "{\"status\":1}";
        }
        return "{\"status\":0}";
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPhoto(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getPhoto - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        getParam(str, "quesId");
        getParamInt(str, "limit");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda77
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getPhoto$53(asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$53(final java.lang.String str) throws java.lang.Exception {
        this.takePhotoHelper.getPhotoNew(this.chapterDataHelper.getAnswerDataDir(this.page), "作答页面图片选择", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda19
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                this.f$0.lambda$getPhoto$52(str, i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$52(final java.lang.String str, int i, java.lang.String str2) {
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(str2, null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda45
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$getPhoto$51(str, fileMapInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$51(java.lang.String str, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("localPath", fileMapInfo.getPath());
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfo.getUrl());
        jSONObject.put("size", java.lang.Long.valueOf(new java.io.File(fileMapInfo.getPath()).length()));
        jSONArray.add(jSONObject);
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(jSONArray));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClippedPhoto(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getClippedPhoto - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda84
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getClippedPhoto$55(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhoto$55(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.takePhotoHelper.getPictureCrop(com.up366.mobile.book.helper.V8FilePathHelper.getPhotoDir(), com.alibaba.fastjson.JSON.parseObject(str), new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda71
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str3, java.lang.Object obj) {
                this.f$0.lambda$getClippedPhoto$54(str2, i, str3, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhoto$54(java.lang.String str, int i, java.lang.String str2, java.util.List list) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync((java.lang.String) it.next(), null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("localPath", fileMapInfoSaveSync.getPath());
            jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfoSaveSync.getUrl());
            jSONObject.put("size", java.lang.Long.valueOf(new java.io.File(fileMapInfoSaveSync.getPath()).length()));
            jSONArray.add(jSONObject);
        }
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(jSONArray));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getClippedPhotoV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getClippedPhotoV2 - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda70
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getClippedPhotoV2$57(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhotoV2$57(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.clippedPhotoV2Helper.launch(str, new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda16
            @Override // com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback
            public final void onResult(com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult, java.util.List list) {
                this.f$0.lambda$getClippedPhotoV2$56(str2, photoPickerLaunchResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhotoV2$56(java.lang.String str, com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult, java.util.List list) {
        if (!photoPickerLaunchResult.getSuccess()) {
            if (com.up366.common.StringUtils.isEmptyOrNull(photoPickerLaunchResult.getErrorCode())) {
                this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(-2, "未知错误"));
                return;
            } else {
                this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(java.lang.Integer.parseInt(photoPickerLaunchResult.getErrorCode()), photoPickerLaunchResult.getErrorMessage()));
                return;
            }
        }
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.photopicker.PhotoPickerPhotoResult photoPickerPhotoResult = (com.up366.photopicker.PhotoPickerPhotoResult) it.next();
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(photoPickerPhotoResult.getLocalPath(), null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("localPath", fileMapInfoSaveSync.getPath());
            jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfoSaveSync.getUrl());
            jSONObject.put("size", java.lang.Long.valueOf(new java.io.File(fileMapInfoSaveSync.getPath()).length()));
            jSONObject.put("isRectAdjusted", java.lang.Boolean.valueOf(photoPickerPhotoResult.isRectAdjusted()));
            jSONArray.add(jSONObject);
        }
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(jSONArray));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String deletePhoto(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - deletePhoto - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deletePhoto$59(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deletePhoto$59(java.lang.String str) {
        java.lang.String param = getParam(str, "picUrl");
        if (com.up366.common.FileUtilsUp.isFileExists(param)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(param);
        } else {
            com.up366.mobile.common.logic.Auth.cur().fileMgr().load(param, null, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda24
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                    com.up366.mobile.book.jsinterface.JSInterfaceV7.lambda$deletePhoto$58(i, str2, (com.up366.mobile.common.utils.alifile.FileMapInfo) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$deletePhoto$58(int i, java.lang.String str, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        if (i == 0) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(fileMapInfo.getPath());
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String readFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - readFile - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$readFile$60(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$readFile$60(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "filename");
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(this.chapterDataHelper.getBookPath(), param);
        if (!com.up366.mobile.book.webview.DecryptFileHelper.isAbsolute(param)) {
            param = strJoin;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.igexin.sdk.FlymePushReceiver.CONTENT, new com.up366.mobile.book.webview.DecryptFileHelper().getEncFileContent(param));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String questionFeedBackRec(final java.lang.String str) {
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - questionFeedBackRec - params = [" + str + "]");
        com.up366.mobile.common.utils.ViewUtil.runTapAction(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda25
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$questionFeedBackRec$62(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$questionFeedBackRec$62(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        new com.up366.mobile.common.views.OralFeedbackDialog(this.webView.getContext(), str, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda8
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                this.f$0.lambda$questionFeedBackRec$61(str2, i, str3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$questionFeedBackRec$61(java.lang.String str, int i, java.lang.String str2) {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(i, str2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String changeOrientation(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - changeOrientation - params = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda56
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$changeOrientation$65(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeOrientation$65(java.lang.String str) {
        int paramInt = getParamInt(str, "orientation");
        if (paramInt == 0) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda22
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$changeOrientation$63();
                }
            });
        }
        if (paramInt == 1) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda33
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$changeOrientation$64();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeOrientation$63() throws java.lang.Exception {
        this.context.setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeOrientation$64() throws java.lang.Exception {
        this.context.setRequestedOrientation(11);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setupIMConnect() {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - setupIMConnect - ");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$setupIMConnect$66(asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupIMConnect$66(java.lang.String str) throws java.lang.Exception {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(null));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String downloadFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - downloadFile - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda69
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$downloadFile$70(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$70(java.lang.String str) {
        final java.lang.String param = getParam(str, "fileId");
        final java.lang.Runnable[] runnableArr = {runnable};
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda63
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$downloadFile$69(param, runnableArr);
            }
        };
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$69(final java.lang.String str, final java.lang.Runnable[] runnableArr) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda65
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$downloadFile$68(str, runnableArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$68(final java.lang.String str, final java.lang.Runnable[] runnableArr) throws java.lang.Exception {
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.studyActivityInterface.getContentDownloadHelper();
        final java.lang.String tempResourcePath = contentDownloadHelper.getTempResourcePath(str);
        this.studyActivityInterface.showDownloadLoadingView();
        contentDownloadHelper.downloadTempResource(str, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda12
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$downloadFile$67(runnableArr, str, tempResourcePath, (com.up366.common.event.DownloadEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$67(java.lang.Runnable[] runnableArr, java.lang.String str, java.lang.String str2, com.up366.common.event.DownloadEvent downloadEvent) {
        this.studyActivityInterface.updateDownloadLoadingView(downloadEvent.getState(), downloadEvent.getCurrent(), downloadEvent.getTotal(), downloadEvent.getErrInfo(), runnableArr[0]);
        java.lang.Object[] objArrConvertErrorCodeInfo = convertErrorCodeInfo(downloadEvent);
        java.lang.Integer num = (java.lang.Integer) objArrConvertErrorCodeInfo[0];
        num.intValue();
        java.lang.Integer num2 = (java.lang.Integer) objArrConvertErrorCodeInfo[1];
        num2.intValue();
        java.lang.String str3 = (java.lang.String) objArrConvertErrorCodeInfo[2];
        int percent = downloadEvent.getPercent();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("fileId", str);
        jSONObject.put("status", num);
        jSONObject.put("errorCode", num2);
        jSONObject.put("msg", str3);
        jSONObject.put("progress", java.lang.Integer.valueOf(percent));
        jSONObject.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, str2);
        this.registerHelper.callJsEvent("filedownload", "(%s)", jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getDownloadFileStatus(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - getDownloadFileStatus - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda32
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getDownloadFileStatus$71(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getDownloadFileStatus$71(java.lang.String str) throws java.lang.Exception {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(str);
        for (int i = 0; i < array.size(); i++) {
            java.lang.String string = array.getString(i);
            com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.studyActivityInterface.getContentDownloadHelper();
            java.lang.String tempResourcePath = contentDownloadHelper.getTempResourcePath(string);
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            if (contentDownloadHelper.isTempResourceExists(string)) {
                jSONObject.put("code", 1);
                jSONObject.put("msg", "success");
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("msg", "not exists");
            }
            jSONObject.put("fileId", string);
            jSONObject.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, tempResourcePath);
            jSONArray.add(jSONObject);
        }
        return jSONArray;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String giveMark(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - giveMark ");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$giveMark$73();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$giveMark$73() {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$giveMark$72();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$giveMark$72() throws java.lang.Exception {
        com.up366.mobile.common.dialog.PraiseDialog.create(this.context).show();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String batchDownloadFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - batchDownloadFile - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda82
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$batchDownloadFile$77(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$batchDownloadFile$77(java.lang.String str) throws java.lang.Exception {
        final java.lang.String uuid = getUUID();
        final com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(str);
        final java.lang.Runnable[] runnableArr = {runnable};
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$batchDownloadFile$76(array, uuid, runnableArr);
            }
        };
        runnable.run();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("batchId", uuid);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$batchDownloadFile$76(final com.alibaba.fastjson.JSONArray jSONArray, final java.lang.String str, final java.lang.Runnable[] runnableArr) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$batchDownloadFile$75(jSONArray, str, runnableArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$batchDownloadFile$75(com.alibaba.fastjson.JSONArray jSONArray, final java.lang.String str, final java.lang.Runnable[] runnableArr) throws java.lang.Exception {
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.studyActivityInterface.getContentDownloadHelper();
        this.studyActivityInterface.showDownloadLoadingView();
        final com.alibaba.fastjson.JSONArray multiTempResourcePathList = contentDownloadHelper.getMultiTempResourcePathList(jSONArray);
        contentDownloadHelper.downloadMultiTempResource(str, jSONArray, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda58
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$batchDownloadFile$74(runnableArr, str, multiTempResourcePathList, (com.up366.common.event.DownloadEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$batchDownloadFile$74(java.lang.Runnable[] runnableArr, java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray, com.up366.common.event.DownloadEvent downloadEvent) {
        this.studyActivityInterface.updateDownloadLoadingView(downloadEvent.getState(), downloadEvent.getCurrent(), downloadEvent.getTotal(), downloadEvent.getErrInfo(), runnableArr[0]);
        java.lang.Object[] objArrConvertErrorCodeInfo = convertErrorCodeInfo(downloadEvent);
        java.lang.Integer num = (java.lang.Integer) objArrConvertErrorCodeInfo[0];
        num.intValue();
        java.lang.Integer num2 = (java.lang.Integer) objArrConvertErrorCodeInfo[1];
        num2.intValue();
        java.lang.String str2 = (java.lang.String) objArrConvertErrorCodeInfo[2];
        int percent = downloadEvent.getPercent();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("batchId", str);
        jSONObject.put("status", num);
        jSONObject.put("errorCode", num2);
        jSONObject.put("msg", str2);
        jSONObject.put("progress", java.lang.Integer.valueOf(percent));
        jSONObject.put("pathList", jSONArray);
        this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V7RegisterHelper.EVT_BATCH_FILE_DOWNLOAD, "(%s)", jSONObject.toJSONString());
    }

    private java.lang.Object[] convertErrorCodeInfo(com.up366.common.event.DownloadEvent downloadEvent) {
        int i;
        int errCode;
        int state = downloadEvent.getState();
        java.lang.String str = "";
        if (state != 3) {
            i = 4;
            if (state != 4) {
                i = 5;
                if (state == 5) {
                    int errCode2 = downloadEvent.getErrCode();
                    i = errCode2 == -111 ? 3 : 2;
                    java.lang.String errInfo = downloadEvent.getErrInfo();
                    if (errInfo != null && !errInfo.contains("失败")) {
                        errInfo = "下载失败：" + errInfo;
                    } else if (errInfo == null) {
                        errInfo = "下载失败";
                    }
                    str = errInfo;
                    errCode = errCode2;
                } else if (state != 6) {
                    errCode = 0;
                    i = 0;
                } else {
                    errCode = downloadEvent.getErrCode();
                    str = "取消下载";
                }
            }
            return new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(errCode), str};
        }
        i = 1;
        errCode = 0;
        return new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(errCode), str};
    }

    @android.webkit.JavascriptInterface
    public void disableScreenCapture(final boolean z) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - disableScreenCapture - disable = [" + z + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$disableScreenCapture$78(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disableScreenCapture$78(boolean z) throws java.lang.Exception {
        if (z) {
            this.context.getWindow().setFlags(io.objectbox.model.PropertyFlags.UNSIGNED, io.objectbox.model.PropertyFlags.UNSIGNED);
        } else {
            this.context.getWindow().clearFlags(io.objectbox.model.PropertyFlags.UNSIGNED);
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openScanPaper(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV7 - openScanPaper - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda81
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openScanPaper$80(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openScanPaper$79(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.course.photoanswer.PhotoAnswerOpenHelper.openScanPaper(this.context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openScanPaper$80(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV7$$ExternalSyntheticLambda39
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openScanPaper$79(str);
            }
        });
    }
}
