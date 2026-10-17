package com.up366.mobile.book.jsinterface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class JSInterfaceV8 extends com.up366.mobile.book.jsbase.BaseJSInterface {
    private final com.up366.mobile.book.helper.AppInfoHelper appInfoHelper;
    private final com.up366.mobile.book.helper.V8AudioHelper audioHelper;
    private final com.up366.mobile.book.helper.V8BookTaskLogHelper bookTaskLogHelper;
    private final com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper clippedPhotoV2Helper;
    private final com.up366.mobile.book.helper.recordv2.CommonRecordHelper commonRecordHelper;
    private final android.content.Context context;
    private final com.up366.mobile.book.helper.DataHelper dataHelper;
    private final com.up366.mobile.book.helper.HeadsetHelper headsetHelper;
    private final com.up366.mobile.book.helper.V8HttpHelper httpHelper;
    private final com.up366.mobile.book.helper.InputHelper inputHelper;
    private final com.up366.mobile.book.helper.LaunchOptionsHelper launchOptionsHelper;
    private final com.up366.mobile.book.helper.V7LocalMediaHelper localMediaHelper;
    private final com.up366.mobile.book.helper.mux.IMuxAVHelper muxAVHelper;
    private final com.up366.mobile.book.helper.V8OpenHelper openHelper;
    private final com.up366.mobile.book.helper.V8RecordHelper recordHelper;
    private final com.up366.mobile.book.helper.V8RegisterHelper registerHelper;
    private final com.up366.mobile.book.helper.V8ResourceHelper resourceHelper;
    private final com.up366.mobile.book.helper.V7ShareHelper shareHelper;
    private final com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    private final com.up366.mobile.book.studyviews.StudyV8View studyV8View;
    private final com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public JSInterfaceV8(com.up366.mobile.book.StudyActivityInterface studyActivityInterface, com.up366.mobile.book.studyviews.StudyV8View studyV8View) {
        this.studyActivityInterface = studyActivityInterface;
        this.studyV8View = studyV8View;
        android.app.Activity context = studyActivityInterface.m1148getContext();
        this.context = context;
        com.up366.mobile.book.webview.StudyPageWebView studyPageWebView = studyV8View.b.webView;
        this.webView = studyPageWebView;
        this.bookTaskLogHelper = studyV8View.bookTaskLogHelper;
        this.registerHelper = studyV8View.registerHelper;
        this.headsetHelper = studyActivityInterface.getHeadsetHelper();
        this.inputHelper = new com.up366.mobile.book.helper.InputHelper(studyPageWebView);
        com.up366.mobile.book.helper.V8ResourceHelper v8ResourceHelper = studyV8View.dataHelper;
        this.resourceHelper = v8ResourceHelper;
        this.dataHelper = new com.up366.mobile.book.helper.DataHelper();
        this.recordHelper = studyV8View.recordHelper;
        this.audioHelper = studyV8View.audioHelper;
        this.openHelper = studyV8View.openHelper;
        this.appInfoHelper = studyV8View.appInfoHelper;
        this.httpHelper = new com.up366.mobile.book.helper.V8HttpHelper();
        this.shareHelper = new com.up366.mobile.book.helper.V7ShareHelper(context);
        this.muxAVHelper = new com.up366.mobile.book.helper.V8MuxAVHelperV2(context, studyPageWebView, v8ResourceHelper);
        this.localMediaHelper = new com.up366.mobile.book.helper.V7LocalMediaHelper(context);
        this.takePhotoHelper = studyActivityInterface.getTakePhotoHelper();
        this.launchOptionsHelper = new com.up366.mobile.book.helper.LaunchOptionsHelper();
        this.clippedPhotoV2Helper = studyActivityInterface.getPhotoPickerClippedPhotoV2Helper();
        this.commonRecordHelper = new com.up366.mobile.book.helper.recordv2.CommonRecordHelper(studyV8View.b.webView, studyV8View.registerHelper);
    }

    @android.webkit.JavascriptInterface
    public void registerEvent(java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - registerEvent - event = [" + str + "], callback = [" + str2 + "]");
        this.registerHelper.register(str, str2);
    }

    @android.webkit.JavascriptInterface
    public void unRegisterEvent(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - unRegisterEvent - event = [" + str + "]");
        this.registerHelper.unRegister(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String canIUse(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - canIUse - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda67
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return java.lang.Boolean.valueOf(com.up366.mobile.book.helper.Tools.canIUse(str));
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAppInfo(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getAppInfo - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda32
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAppInfo$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAppInfo$1() throws java.lang.Exception {
        return this.appInfoHelper.getAppInfo("common");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getLaunchOptions(final java.lang.String str) {
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV8 - getLaunchOptions - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda59
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getLaunchOptions$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getLaunchOptions$2(java.lang.String str) throws java.lang.Exception {
        com.alibaba.fastjson.JSONObject launchOptions = this.launchOptionsHelper.getLaunchOptions(this.studyActivityInterface, str);
        this.studyV8View.scheduleRestorePageRouteAfterLaunchOptions();
        return launchOptions;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getUserInfo(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getUserInfo - json = [" + str + "]");
        final com.up366.mobile.book.helper.AppInfoHelper appInfoHelper = this.appInfoHelper;
        java.util.Objects.requireNonNull(appInfoHelper);
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return appInfoHelper.getUserInfoV8();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getNTPTimestamp(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getNTPTimestamp - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda20());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String searchDB(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - searchDB - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        java.lang.String param = getParam(str, "db");
        java.lang.String param2 = getParam(str, "sql");
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.resourceHelper.searchDB(param, param2, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda64
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                this.f$0.lambda$searchDB$3(asyncUniqueKey, jCurrentTimeMillis, i, str2, (com.alibaba.fastjson.JSONArray) obj);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDB$3(java.lang.String str, long j, int i, java.lang.String str2, com.alibaba.fastjson.JSONArray jSONArray) {
        java.lang.String jSONString;
        if (jSONArray == null) {
            jSONString = "[]";
        } else {
            jSONString = jSONArray.toJSONString();
        }
        this.webView.getBridgeHelper().responseAsyncResult(str, "{\"data\": " + jSONString + ",\"result\": {\"code\": " + i + ",\"msg\": " + com.alibaba.fastjson.JSON.toJSONString(str2) + "}}");
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - JSInterfaceV8 - searchDB - used time : ");
        sb.append(java.lang.System.currentTimeMillis() - j);
        com.up366.common.log.Logger.info(sb.toString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String writeTextToClipboard(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - copyToClipboard - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$writeTextToClipboard$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$writeTextToClipboard$4(java.lang.String str) {
        new com.up366.mobile.book.helper.ClipBoardHelper(this.context).copyTextToClipboard(getParam(str, "text"));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String readTextFromClipboard(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - readTextFromClipboard - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda80
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$readTextFromClipboard$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$readTextFromClipboard$5() throws java.lang.Exception {
        return new com.up366.mobile.book.helper.ClipBoardHelper(this.context).getText();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String share(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - share - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda91
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$share$7(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$7(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.shareHelper.share(str, this.webView, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda78
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str3) {
                this.f$0.lambda$share$6(str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$6(java.lang.String str, int i, java.lang.String str2) {
        if (i == 0) {
            if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this.context, "保存成功");
            }
            this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(null));
            return;
        }
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - share - result - code:" + i + " info:" + str2);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.webView, str2);
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultError(-2, str2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String reboot(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - reboot - params = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda61
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reboot$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reboot$8() {
        com.up366.mobile.book.helper.OpenHelper.reboot(this.context);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String quit(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - quit - params = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$quit$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$quit$9() {
        com.up366.mobile.book.helper.OpenHelper.quit(this.context);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getBookInfo(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getBookInfo - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda37
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getBookInfo$10(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBookInfo$10(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.common.http.NetHolder<com.alibaba.fastjson.JSONObject> bookInfo = com.up366.mobile.book.helper.Tools.getBookInfo(this.studyActivityInterface.getOpenConfigInfo().bookId, getParam(str, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID), getParamInt(str, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID));
        java.lang.String strBuildResultError = buildResultError(bookInfo.resp.getCode(), bookInfo.resp.getInfo());
        if (!bookInfo.resp.isError()) {
            strBuildResultError = buildResultSuccess(bookInfo.info);
        }
        this.webView.getBridgeHelper().responseAsyncResult(str2, strBuildResultError);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String submitTask(final java.lang.String str) {
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda90
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$submitTask$12(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitTask$12(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        try {
            com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - submitTask - taskData = [" + str + "]");
            this.bookTaskLogHelper.submitTaskV1(this.studyActivityInterface.getOpenConfigInfo().bookId, str);
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTaskCallback = new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$submitTask$11(str2);
                }
            };
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - JSInterfaceV8 - submitTask - " + e.getMessage(), e);
            this.webView.getBridgeHelper().responseAsyncResult(str2, buildResultError(-2, e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitTask$11(java.lang.String str) {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(null));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getTasksUploadStatus(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getTasksUploadStatus - params = [" + str + "]");
        return buildResultSuccess(com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.book.helper.TaskUploadStatusHelper.getV8()));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String manualUploadTask(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - manualUploadTask - params = [" + str + "]");
        com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
        com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        return buildResultSuccess(null);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String refreshJobList(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - refreshJobList - params = [" + str + "]");
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
        return buildResultSuccess(null);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCourseInfo(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getCourseInfo - params = [" + str + "]");
        return runInTryCatchAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda65
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getCourseInfo$13();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getCourseInfo$13() throws java.lang.Exception {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.course.mgr.CourseInfo courseInfo = com.up366.mobile.common.logic.Auth.cur().course().getCourseInfo(this.studyActivityInterface.getBookInfoStudy().getCourseId());
        if (courseInfo == null) {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, -1);
            jSONObject.put("courseName", "");
        } else {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(courseInfo.getCourseId()));
            jSONObject.put("courseName", courseInfo.getCourseName());
        }
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String postMessage(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - postMessage - params = [" + str + "]");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$postMessage$14(str);
            }
        });
        return buildResultSuccess(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$14(java.lang.String str) throws java.lang.Exception {
        this.registerHelper.postMessage(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getRootPath(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getRootPath - params = [" + str + "]");
        return buildResultSuccess(this.studyActivityInterface.getV8FilePathHelper().getResourceRootDir());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String exists(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - exists - params = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda82
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$exists$15(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$exists$15(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        boolean paramBoolean = getParamBoolean(str, "checkDir");
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        return java.lang.Boolean.valueOf(com.up366.mobile.book.webview.DecryptFileHelper.isAbsolute(param, paramBoolean));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String stat(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - stat - params = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda47
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$stat$16(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$stat$16(java.lang.String str) throws java.lang.Exception {
        return com.up366.mobile.book.webview.DecryptFileHelper.stat(getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String writeFile(final java.lang.String str) {
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV8 - writeFile - params = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda21
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$writeFile$17(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$writeFile$17(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - writeFile - params = [" + str.length() + "] dest:" + param);
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        java.lang.String param2 = getParam(str, "data");
        java.lang.String param3 = getParam(str, "encoding");
        java.lang.String param4 = getParam(str, "flag");
        if (android.text.TextUtils.isEmpty(param3)) {
            param3 = "utf8";
        }
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(param, android.text.TextUtils.equals("a", param4));
        try {
            fileOutputStream.write(param2.getBytes(java.nio.charset.Charset.forName(param3)));
            fileOutputStream.close();
            return null;
        } catch (java.lang.Throwable th) {
            try {
                fileOutputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String copyFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - copyFile - params = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() throws java.lang.Throwable {
                this.f$0.lambda$copyFile$18(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyFile$18(java.lang.String str) throws java.lang.Throwable {
        java.lang.String param = getParam(str, com.up366.qmui.skin.QMUISkinValueBuilder.SRC);
        java.lang.String param2 = getParam(str, "dest");
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param2);
        com.up366.common.FileUtilsUp.copyFileOrDir(param, param2);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String mkdir(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - mkdir - params = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda69
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$mkdir$19(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mkdir$19(java.lang.String str) {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        if (getParamBoolean(str, "recursive")) {
            new java.io.File(param).mkdirs();
        } else {
            new java.io.File(param).mkdir();
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String readFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - readFile - params = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda17
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$readFile$20(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$readFile$20(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        android.text.TextUtils.isEmpty(getParam(str, "encoding"));
        com.up366.mobile.book.webview.DecryptFileHelper.isAbsolute(param);
        return new com.up366.mobile.book.webview.DecryptFileHelper().getEncFileContent(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String readDir(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - readDir - params = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda55
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$readDir$21(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$readDir$21(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        return com.up366.mobile.book.helper.Tools.readDir(null, param, getParamBoolean(str, "recursive"));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String unlink(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - unlink - params = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$unlink$22(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unlink$22(java.lang.String str) {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        java.io.File file = new java.io.File(param);
        if (file.isFile()) {
            file.delete();
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String rmdir(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - rmdir - params = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda66
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$rmdir$23(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$rmdir$23(java.lang.String str) {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        if (getParamBoolean(str, "recursive")) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(param);
        } else {
            new java.io.File(param).delete();
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String rename(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - rename - params = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda54
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$rename$24(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$rename$24(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "newPath");
        java.lang.String param2 = getParam(str, "oldPath");
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param2);
        return java.lang.Boolean.valueOf(new java.io.File(param2).renameTo(new java.io.File(param)));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String unzip(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - unzip - params = [" + str + "]");
        return runInTryCatchAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$unzip$25(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$unzip$25(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "zipFilePath");
        java.lang.String param2 = getParam(str, "targetPath");
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param2);
        return java.lang.Boolean.valueOf(com.up366.mobile.book.helper.Tools.unzip(param, param2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String zip(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - zip - params = [" + str + "]");
        return runInTryCatchAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda94
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$zip$26(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$zip$26(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        java.lang.String param2 = getParam(str, "name");
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        java.lang.String str2 = param.replaceAll("/*$", "") + "_zip_";
        if (com.up366.mobile.book.helper.Tools.zip(param, str2)) {
            return java.lang.Boolean.valueOf(new java.io.File(str2).renameTo(new java.io.File(param + "/" + param2)));
        }
        return false;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String isDir(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - isDir - params = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda42
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$isDir$27(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$isDir$27(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH);
        com.up366.mobile.book.helper.Tools.checkResourceRootDir(param);
        return java.lang.Boolean.valueOf(new java.io.File(param).isDirectory());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String uploadUserLog(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadUserLog$29(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadUserLog$29(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - uploadUserLog - json = [" + str + "]");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda25
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
    public java.lang.String uploadAppLogs(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda93
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadAppLogs$30(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadAppLogs$30(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - uploadAppLogs - json = [" + str + "]");
        com.up366.mobile.book.helper.Tools.uploadAppLogs(getParam(str, com.igexin.push.core.b.C), this.registerHelper);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String cancelAppLogs(final java.lang.String str) {
        return runInTryCatchAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda30
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$cancelAppLogs$31(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$cancelAppLogs$31(java.lang.String str) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - cancelAppLogs - json = [" + str + "]");
        com.up366.mobile.book.helper.Tools.cancelAppLogs(getParam(str, com.igexin.push.core.b.C), this.registerHelper);
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String playAudio(final java.lang.String str) {
        return runInTryCatchAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda19
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$playAudio$32(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$playAudio$32(java.lang.String str) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - playAudio - audioConfig = [" + str + "]");
        return java.lang.Integer.valueOf(this.audioHelper.playAudioWithParams(str));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String pauseAudio(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda72
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$pauseAudio$33(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pauseAudio$33(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - pauseAudio - audioId = [" + param + "]");
        this.audioHelper.pausePlay(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String resumeAudio(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda63
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resumeAudio$34(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resumeAudio$34(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - resumeAudio - audioId = [" + param + "]");
        this.audioHelper.resumePlaying(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String stopAudio(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopAudio$35(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopAudio$35(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - stopAudio - audioId = [" + param + "]");
        this.audioHelper.stopPlay(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getCurrentAudioTime(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda36
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getCurrentAudioTime$36(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getCurrentAudioTime$36(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV8 - getCurrentAudioTime - audioId = [" + param + "]");
        return java.lang.Integer.valueOf(this.audioHelper.getCurrentTime(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setVolume(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda68
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setVolume$37(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVolume$37(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        float paramFloat = getParamFloat(str, "volume");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - setVolume - audioPlayerId = [" + param + "], volume = [" + paramFloat + "]");
        this.audioHelper.setVolume(param, paramFloat);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getVolume(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda41
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getVolume$38(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getVolume$38(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getVolume - json = [" + str + "]");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("volume", java.lang.Float.valueOf(this.audioHelper.getVolume(param)));
        return jSONObject;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setAudioRate(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda62
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setAudioRate$39(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAudioRate$39(java.lang.String str) {
        java.lang.String param = getParam(str, "audioId");
        float paramFloat = getParamFloat(str, "rate");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - setAudioRate - audioId = [" + param + "], rate = [" + paramFloat + "]");
        this.audioHelper.setRate(param, paramFloat);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAudioRate(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAudioRate$40(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAudioRate$40(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "audioId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getAudioRate - audioId = [" + param + "]");
        return java.lang.Float.valueOf(this.audioHelper.getRate(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAudioInfo(final java.lang.String str) {
        return runInTryCatchAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAudioInfo$41(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAudioInfo$41(java.lang.String str) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getAudioInfo - audioConfig = [" + str + "]");
        return this.audioHelper.getAudioInfo(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String startRecord(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - startRecord - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startRecord$42(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecord$42(java.lang.String str) {
        this.recordHelper.startRecordWithParamsV2(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String startRecordV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - startRecordV2 - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startRecordV2$43(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordV2$43(java.lang.String str) {
        this.commonRecordHelper.startRecordV2(str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String stopRecord(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda79
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopRecord$44(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopRecord$44(java.lang.String str) {
        java.lang.String param = getParam(str, "recordId");
        int paramInt = getParamInt(str, "giveup");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - stopRecord - recordId = [" + param + "]");
        if (paramInt == 0) {
            this.recordHelper.endRecord(param);
        } else {
            this.recordHelper.forceStopAll();
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String stopRecordV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - stopRecordV2 - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda56
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopRecordV2$45(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopRecordV2$45(java.lang.String str) {
        this.commonRecordHelper.stopRecordV2(str);
    }

    public void destroy() {
        this.commonRecordHelper.destroy();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getAsecResult(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda29
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getAsecResult$46(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getAsecResult$46(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "recordId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getAsecResult - recordId = [" + param + "]");
        return com.alibaba.fastjson.JSON.parse(this.recordHelper.getAsecResult(param));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String delAsecResult(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda77
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$delAsecResult$47(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$delAsecResult$47(java.lang.String str) {
        java.lang.String param = getParam(str, "recordId");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - delAsecResult - recordId = [" + param + "]");
        this.recordHelper.deleteByRecordId(param);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String ocr(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - ocr - json = [" + str + "]");
        int intValue = com.alibaba.fastjson.JSON.parseObject(str).getIntValue("skipConfirm");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.takePhotoHelper.getPictureCropAndRecognition(intValue, new com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback
            public final void onResult(java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.f$0.lambda$ocr$48(asyncUniqueKey, str2, str3, str4);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ocr$48(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
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
    public java.lang.String mixAudioVideo(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - mixAudioVideo - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.muxAVHelper.mux(str, new com.up366.mobile.book.helper.mux.IMuxCallback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda39
            @Override // com.up366.mobile.book.helper.mux.IMuxCallback
            public final void onResult(int i, java.lang.String str2, java.lang.String str3) {
                this.f$0.lambda$mixAudioVideo$49(asyncUniqueKey, i, str2, str3);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mixAudioVideo$49(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("code", java.lang.Integer.valueOf(i));
        jSONObject.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, str2);
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str3);
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(jSONObject));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String saveToGallery(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - saveToGallery - params = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda87
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$saveToGallery$51(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToGallery$51(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.localMediaHelper.saveToGallery(str, new com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda44
            @Override // com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback
            public final void onResult(int i) {
                this.f$0.lambda$saveToGallery$50(str2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToGallery$50(java.lang.String str, int i) {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(null));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getPhoto(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getPhoto - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        getParamInt(str, "limit");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda50
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getPhoto$54(asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$54(final java.lang.String str) throws java.lang.Exception {
        this.takePhotoHelper.getPhotoNew(com.up366.mobile.book.helper.V8FilePathHelper.getPhotoDir(), "作答页面图片选择", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda73
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                this.f$0.lambda$getPhoto$53(str, i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$53(final java.lang.String str, int i, java.lang.String str2) {
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(str2, null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda84
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$getPhoto$52(str, fileMapInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$52(java.lang.String str, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
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
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getClippedPhoto - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda89
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getClippedPhoto$56(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhoto$56(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.takePhotoHelper.getPictureCrop(com.up366.mobile.book.helper.V8FilePathHelper.getPhotoDir(), com.alibaba.fastjson.JSON.parseObject(str), new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda40
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str3, java.lang.Object obj) {
                this.f$0.lambda$getClippedPhoto$55(str2, i, str3, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhoto$55(java.lang.String str, int i, java.lang.String str2, java.util.List list) {
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
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getClippedPhotoV2$58(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhotoV2$58(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        this.clippedPhotoV2Helper.launch(str, new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda83
            @Override // com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback
            public final void onResult(com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult, java.util.List list) {
                this.f$0.lambda$getClippedPhotoV2$57(str2, photoPickerLaunchResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getClippedPhotoV2$57(java.lang.String str, com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult, java.util.List list) {
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
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - deletePhoto - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda86
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deletePhoto$60(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deletePhoto$60(java.lang.String str) {
        java.lang.String param = getParam(str, "picUrl");
        if (com.up366.common.FileUtilsUp.isFileExists(param)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(param);
        } else {
            com.up366.mobile.common.logic.Auth.cur().fileMgr().load(param, null, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda35
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                    com.up366.mobile.book.jsinterface.JSInterfaceV8.lambda$deletePhoto$59(i, str2, (com.up366.mobile.common.utils.alifile.FileMapInfo) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$deletePhoto$59(int i, java.lang.String str, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        if (i == 0) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(fileMapInfo.getPath());
        }
    }

    @android.webkit.JavascriptInterface
    public java.lang.String scan(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - scan - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.studyActivityInterface.getQRScanHelper().open(new com.up366.mobile.common.helper.QRScanHelper.IScanResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda26
            @Override // com.up366.mobile.common.helper.QRScanHelper.IScanResult
            public final void onResult(int i, java.lang.String str2) {
                this.f$0.lambda$scan$61(asyncUniqueKey, i, str2);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scan$61(java.lang.String str, int i, java.lang.String str2) {
        this.webView.getBridgeHelper().responseAsyncResult(str, buildResultSuccess(str2));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String request(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - request - url = [" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL) + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        this.httpHelper.httpSend(str, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda15
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                this.f$0.lambda$request$62(asyncUniqueKey, i, str2, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$request$62(java.lang.String str, int i, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        this.webView.getBridgeHelper().responseAsyncResult(str, jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String downloadFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - downloadFile - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda95
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$downloadFile$66(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$downloadFile$66(java.lang.String str) throws java.lang.Exception {
        final java.lang.String uuid = com.up366.mobile.book.helper.Tools.getUUID();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("fileList");
        final boolean booleanValue = object.getBooleanValue("disableAnimation");
        final java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$downloadFile$65(booleanValue, jSONArray, uuid, atomicReference);
            }
        };
        atomicReference.set(runnable);
        runnable.run();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("batchId", uuid);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$65(final boolean z, final com.alibaba.fastjson.JSONArray jSONArray, final java.lang.String str, final java.util.concurrent.atomic.AtomicReference atomicReference) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda49
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$downloadFile$64(z, jSONArray, str, atomicReference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$64(final boolean z, com.alibaba.fastjson.JSONArray jSONArray, final java.lang.String str, final java.util.concurrent.atomic.AtomicReference atomicReference) throws java.lang.Exception {
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.studyActivityInterface.getContentDownloadHelper();
        if (!z) {
            this.studyActivityInterface.showDownloadLoadingView();
        }
        final com.alibaba.fastjson.JSONArray multiTempResourcePathListV2 = contentDownloadHelper.getMultiTempResourcePathListV2(jSONArray);
        contentDownloadHelper.downloadMultiTempResourceV2(str, jSONArray, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda88
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$downloadFile$63(z, atomicReference, str, multiTempResourcePathListV2, (com.up366.common.event.DownloadEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadFile$63(boolean z, java.util.concurrent.atomic.AtomicReference atomicReference, java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray, com.up366.common.event.DownloadEvent downloadEvent) {
        if (!z) {
            this.studyActivityInterface.updateDownloadLoadingView(downloadEvent.getState(), downloadEvent.getCurrent(), downloadEvent.getTotal(), downloadEvent.getErrInfo(), (java.lang.Runnable) atomicReference.get());
        }
        java.lang.Object[] objArrConvertDownloadErrorCodeInfo = com.up366.mobile.book.helper.Tools.convertDownloadErrorCodeInfo(downloadEvent);
        java.lang.Integer num = (java.lang.Integer) objArrConvertDownloadErrorCodeInfo[0];
        num.intValue();
        java.lang.Integer num2 = (java.lang.Integer) objArrConvertDownloadErrorCodeInfo[1];
        num2.intValue();
        java.lang.String str2 = (java.lang.String) objArrConvertDownloadErrorCodeInfo[2];
        int percent = downloadEvent.getPercent();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("batchId", str);
        jSONObject.put("status", num);
        jSONObject.put("errorCode", num2);
        jSONObject.put("msg", str2);
        jSONObject.put("progress", java.lang.Integer.valueOf(percent));
        jSONObject.put("pathList", jSONArray);
        this.registerHelper.callJsEvent("fileDownload", "(%s)", jSONObject.toJSONString());
    }

    @android.webkit.JavascriptInterface
    public java.lang.String cancelDownload(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - cancelDownload - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelDownload$67(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelDownload$67(java.lang.String str) {
        this.studyActivityInterface.getContentDownloadHelper().cancelDownload(com.alibaba.fastjson.JSON.parseObject(str).getString("batchId"));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String uploadFile(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - uploadFile - params = [" + str + "]");
        return runInTryCatchAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda45
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$uploadFile$68(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$uploadFile$68(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.uploadFile(str, this.registerHelper);
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String saveData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveData$69(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveData$69(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("key");
        java.lang.String string2 = object.getString("value");
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV8 - saveData - key = [" + string + "], value = [" + string2.length() + "]");
        if (this.dataHelper.saveData(string, string2) == 1) {
            return;
        }
        throw new java.lang.IllegalStateException("保存失败:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String removeData(final java.lang.String str) {
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeData$70(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeData$70(java.lang.String str) {
        java.lang.String param = getParam(str, "key");
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - removeData - key = [" + param + "]");
        if (this.dataHelper.deleteData(param) == 1) {
            return;
        }
        throw new java.lang.IllegalStateException("删除失败:" + str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getData(final java.lang.String str) {
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda33
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getData$71(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getData$71(java.lang.String str) throws java.lang.Exception {
        java.lang.String param = getParam(str, "key");
        java.lang.String strLoadData = this.dataHelper.loadData(param);
        if (strLoadData == null) {
            strLoadData = "";
        }
        com.up366.common.log.Logger.debug("TAG - JSInterfaceV8 - getData - key = [" + param + "] data:" + strLoadData.length());
        return strLoadData;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openWebView(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - openWebView - params = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda60
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$openWebView$72(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$openWebView$72(java.lang.String str) throws java.lang.Exception {
        this.openHelper.openWebView(str);
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String closeWebView() {
        return closeWebView("");
    }

    @android.webkit.JavascriptInterface
    public java.lang.String closeWebView(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - closeWebView - json = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda24
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$closeWebView$73();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$closeWebView$73() throws java.lang.Exception {
        this.openHelper.closeWebView();
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String gotoNativeModule(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - gotoNativeModule - params = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda92
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$gotoNativeModule$74(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$gotoNativeModule$74(java.lang.String str) throws java.lang.Exception {
        this.openHelper.gotoNativeModule(str);
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String loginOut(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - loginOut - params = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda22
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.book.jsinterface.JSInterfaceV8.lambda$loginOut$75();
            }
        });
    }

    static /* synthetic */ java.lang.Object lambda$loginOut$75() throws java.lang.Exception {
        com.up366.common.log.Logger.info("logout");
        com.up366.mobile.common.logic.Auth.logout();
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String showLoading(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - showLoading - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLoading$77(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$77(java.lang.String str) {
        final boolean paramBoolean = getParamBoolean(str, "showFlag");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda14
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showLoading$76(paramBoolean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$76(boolean z) throws java.lang.Exception {
        this.studyActivityInterface.showLoading(z, true);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setBackgroundColor(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - setBackgroundColor - json = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda58
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$setBackgroundColor$78(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$setBackgroundColor$78(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.setSystemViewColor((android.app.Activity) this.context, getParam(str, "color"), getParam(str, "backgroundColor"), getParam(str, "backgroundColorTop"), getParam(str, "backgroundColorBottom"));
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setStatusBar(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - setStatusBar - json = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda70
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$setStatusBar$79(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$setStatusBar$79(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.setStatusBarTextHidden((android.app.Activity) this.context, getParamBoolean(str, "hidden"));
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String setFullScreen(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - setFullScreen - json = [" + str + "]");
        return runInTryCatchMainAsync(this.webView, new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda48
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$setFullScreen$80(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$setFullScreen$80(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.setFullScreen((android.app.Activity) this.context, getParamBoolean(str, "isFullScreen"));
        return null;
    }

    @android.webkit.JavascriptInterface
    public java.lang.String giveMark(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - giveMark - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$giveMark$82();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$giveMark$82() {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$giveMark$81();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$giveMark$81() throws java.lang.Exception {
        com.up366.mobile.common.dialog.PraiseDialog.create(this.context).show();
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openDictionary(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - openDictionary - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda85
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openDictionary$84(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionary$83(java.lang.String str) throws java.lang.Exception {
        this.openHelper.openDictionary(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionary$84(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openDictionary$83(str);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String openDictionaryV2(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - openDictionaryV2 - json = [" + str + "]");
        return runInTryCatch(new java.lang.Runnable() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openDictionaryV2$86(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionaryV2$85(java.lang.String str) throws java.lang.Exception {
        this.openHelper.openDictionaryV2(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openDictionaryV2$86(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda81
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$openDictionaryV2$85(str);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void __onResponseJSResult(int i, java.lang.String str) {
        this.webView.getBridgeHelper().onResponseData(i, str);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String submitBatch(final java.lang.String str) {
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$submitBatch$87(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitBatch$87(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - submitBatch - json = [" + str + "]");
        com.up366.mobile.book.helper.V8BookTaskLogHelper.Holder holderSubmitBatch = this.bookTaskLogHelper.submitBatch(str);
        if (holderSubmitBatch.code != 0) {
            com.up366.common.log.Logger.error("TAG - JSInterfaceV8 - submitBatch - error " + holderSubmitBatch.message);
        }
        this.webView.getBridgeHelper().responseAsyncResult(str2, buildResult(holderSubmitBatch.code, holderSubmitBatch.message, null));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String buildOSSURL(final java.lang.String str) {
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda74
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$buildOSSURL$88(str, asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildOSSURL$88(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - buildOSSURL - json = [" + str + "]");
        this.webView.getBridgeHelper().responseAsyncResult(str2, buildResultSuccess(com.up366.mobile.book.helper.Tools.buildOSSURLBatch(com.alibaba.fastjson.JSON.parseObject(str).getJSONArray("filePaths").toJavaList(java.lang.String.class))));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getSubmitTaskInfoList(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getSubmitTaskInfoList - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda57
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$getSubmitTaskInfoList$89(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$getSubmitTaskInfoList$89(java.lang.String str) throws java.lang.Exception {
        java.util.List<com.up366.mobile.common.logic.model.SubmitTaskInfo> submitTaskInfoByTaskId = com.up366.mobile.common.logic.Auth.cur().taskMgr().getSubmitTaskInfoByTaskId(getParam(str, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID));
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getSubmitTaskInfoList - taskInfo = [" + submitTaskInfoByTaskId + "]");
        if (submitTaskInfoByTaskId == null) {
            return new com.alibaba.fastjson.JSONArray();
        }
        return com.alibaba.fastjson.JSON.toJSON(submitTaskInfoByTaskId);
    }

    @android.webkit.JavascriptInterface
    public java.lang.String addSubmitTaskInfo(final java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - addSubmitTaskInfo - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda75
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return this.f$0.lambda$addSubmitTaskInfo$91(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$addSubmitTaskInfo$91(final java.lang.String str) throws java.lang.Exception {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda51
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$addSubmitTaskInfo$90(str);
            }
        });
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSubmitTaskInfo$90(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().taskMgr().saveSubmitTaskInfo(getParam(str, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID), getParam(str, com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID), getParamFloat(str, "score"), getParamLong(str, "submitTime"));
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getOpenTypeBookIdDict(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getOpenTypeBookIdDict - json = [" + str + "]");
        return runInTryCatch(new com.up366.mobile.book.jsinterface.IRunnableResult() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda76
            @Override // com.up366.mobile.book.jsinterface.IRunnableResult
            public final java.lang.Object run() {
                return com.up366.mobile.common.logic.Auth.cur().config().getBookOpenType();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public java.lang.String getTaskList(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - JSInterfaceV8 - getTaskList - json = [" + str + "]");
        final java.lang.String asyncUniqueKey = this.webView.getBridgeHelper().getAsyncUniqueKey();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.jsinterface.JSInterfaceV8$$ExternalSyntheticLambda71
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getTaskList$93(asyncUniqueKey);
            }
        });
        return asyncUniqueKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTaskList$93(java.lang.String str) throws java.lang.Exception {
        com.up366.common.http.NetHolder<com.alibaba.fastjson.JSONObject> taskList = com.up366.mobile.book.helper.Tools.getTaskList();
        java.lang.String strBuildResultError = buildResultError(taskList.resp.getCode(), taskList.resp.getInfo());
        if (!taskList.resp.isError()) {
            strBuildResultError = buildResultSuccess(taskList.info);
        }
        this.webView.getBridgeHelper().responseAsyncResult(str, strBuildResultError);
    }
}
