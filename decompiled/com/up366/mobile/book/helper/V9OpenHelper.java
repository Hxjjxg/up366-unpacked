package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V9OpenHelper {
    private static final java.lang.String FROM_TASK_LIST_KEY = "fromTaskList";
    private final android.app.Activity context;
    private final com.up366.mobile.book.studyviews.StudyV9View studyV9View;

    public V9OpenHelper(com.up366.mobile.book.studyviews.StudyV9View studyV9View) {
        this.context = studyV9View.context;
        this.studyV9View = studyV9View;
    }

    public void openWebView(java.lang.String str) {
        openWebView(this.context, str, new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closeWebView();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void openWebView(android.app.Activity r7, java.lang.String r8, java.lang.Runnable r9) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.V9OpenHelper.openWebView(android.app.Activity, java.lang.String, java.lang.Runnable):void");
    }

    private static void openXOT(android.app.Activity activity, com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams) {
        com.alibaba.fastjson.JSONObject extraDataJsonObject = v9OpenWebViewParams.getExtraDataJsonObject();
        java.lang.String string = extraDataJsonObject.getString("type");
        com.alibaba.fastjson.JSONObject jSONObject = extraDataJsonObject.getJSONObject("data");
        if (jSONObject == null) {
            jSONObject = new com.alibaba.fastjson.JSONObject();
        }
        jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.getUserInfo().getUid()));
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", string);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        activity.startActivity(intent);
    }

    private static void open2016(android.app.Activity activity, com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams) {
        com.up366.common.log.Logger.info("TAG - V9OpenHelper - open2016 - params:" + v9OpenWebViewParams.toString());
        skipBook(activity, v9OpenWebViewParams);
    }

    private static void skipBook(final android.app.Activity activity, final com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams) {
        final com.alibaba.fastjson.JSONObject extraDataJsonObject = v9OpenWebViewParams.getExtraDataJsonObject();
        boolean zFromHistory = v9OpenWebViewParams.fromHistory();
        java.lang.String string = extraDataJsonObject.getString("studyTaskDetail");
        if (!com.up366.common.StringUtils.isEmptyOrNull(v9OpenWebViewParams.getBookInfo()) && !com.up366.common.StringUtils.isEmptyOrNull(v9OpenWebViewParams.getLinkedData()) && !com.up366.common.StringUtils.isEmptyOrNull(string)) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(string, com.up366.mobile.course.task.TaskInfoV2.class);
            taskInfoV2.setFinish(zFromHistory);
            com.up366.mobile.course.task.TaskOpenBookStudyHelper.openStudyPageImpl(activity, taskInfoV2, v9OpenWebViewParams.isReTest(), v9OpenWebViewParams.isReport());
        } else {
            final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
            bookInfoStudy.setBookId(v9OpenWebViewParams.getBookId());
            bookInfoStudy.setBookType(1);
            com.up366.mobile.common.logic.Auth.cur().course().selectCourseIdContainsBook(activity, v9OpenWebViewParams.getBookId(), v9OpenWebViewParams.getCourseId(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda4
                public final void accept(java.lang.Object obj) throws org.json.JSONException {
                    com.up366.mobile.book.helper.V9OpenHelper.lambda$skipBook$0(bookInfoStudy, v9OpenWebViewParams, extraDataJsonObject, activity, (java.lang.Integer) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$skipBook$0(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams, com.alibaba.fastjson.JSONObject jSONObject, android.app.Activity activity, java.lang.Integer num) throws org.json.JSONException {
        bookInfoStudy.setCourseId(num.intValue());
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.title = v9OpenWebViewParams.getTitle();
        openConfigInfo.openUrl = v9OpenWebViewParams.getServiceUrl();
        openConfigInfo.chapterId = null;
        openConfigInfo.pageNo = -1;
        openConfigInfo.range = null;
        openConfigInfo.taskId = v9OpenWebViewParams.getTaskId();
        openConfigInfo.studyTaskId = v9OpenWebViewParams.getStudyTaskId();
        openConfigInfo.bookId = v9OpenWebViewParams.getBookId();
        openConfigInfo.xotParam = v9OpenWebViewParams.getXotParam();
        openConfigInfo.exerciseData = jSONObject.toJSONString();
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(bookInfoStudy, openConfigInfo, v9OpenWebViewParams);
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("cfg", openConfigInfo);
        intent.putExtra("book", bookInfoStudy);
        activity.startActivity(intent);
    }

    private static void open2019(android.app.Activity activity, com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams) {
        com.up366.common.log.Logger.info("TAG - V9OpenHelper - open2016Or2019 - params:" + v9OpenWebViewParams.toString());
        java.lang.String serviceUrl = v9OpenWebViewParams.getServiceUrl();
        if (!com.up366.common.StringUtils.isEmptyOrNull(serviceUrl) && serviceUrl.contains("http")) {
            com.up366.mobile.jssdk.JsSdk2019CommonActivity.start(activity, serviceUrl);
        } else {
            skipBook(activity, v9OpenWebViewParams);
        }
    }

    private static void openExternal(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str2);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL_NAME, str);
        activity.startActivity(intent);
    }

    private static void openNetBrowser(android.app.Activity activity, java.lang.String str) {
        com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.open(activity, com.up366.common.global.GB.get().getServerUrl(str));
    }

    private static void openCommon(final android.app.Activity activity, final com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams) {
        final com.alibaba.fastjson.JSONObject extraDataJsonObject = v9OpenWebViewParams.getExtraDataJsonObject();
        java.lang.String string = extraDataJsonObject.getString("scenario");
        java.lang.String string2 = extraDataJsonObject.getString("studyTaskDetail");
        boolean zFromHistory = v9OpenWebViewParams.fromHistory();
        if (("_SELF_STUDY_".equals(string) || "_OPEN_STYLE_PRACTICE_".equals(string)) && !com.up366.common.StringUtils.isEmptyOrNull(string2)) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(string2, com.up366.mobile.course.task.TaskInfoV2.class);
            taskInfoV2.setFinish(zFromHistory);
            if ("_OPEN_STYLE_PRACTICE_".equals(string)) {
                com.up366.mobile.course.task.TaskOpenBookStudyHelper.openHomework(activity, taskInfoV2);
                return;
            } else {
                com.up366.mobile.course.task.TaskJumpHelper.openSelfStudyPageNoCheck(activity, taskInfoV2, extraDataJsonObject.getIntValue("difficulty"));
                return;
            }
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(v9OpenWebViewParams.getBookInfo()) && !com.up366.common.StringUtils.isEmptyOrNull(v9OpenWebViewParams.getLinkedData()) && !com.up366.common.StringUtils.isEmptyOrNull(string2)) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV22 = (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(string2, com.up366.mobile.course.task.TaskInfoV2.class);
            taskInfoV22.setFinish(zFromHistory);
            com.up366.mobile.course.task.TaskOpenBookStudyHelper.openStudyPageImpl(activity, taskInfoV22, v9OpenWebViewParams.isReTest(), v9OpenWebViewParams.isReport());
        } else {
            final java.lang.String bookId = v9OpenWebViewParams.getBookId();
            com.up366.mobile.common.logic.Auth.cur().course().selectCourseIdContainsBook(activity, bookId, v9OpenWebViewParams.getCourseId(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda6
                public final void accept(java.lang.Object obj) throws org.json.JSONException {
                    com.up366.mobile.book.helper.V9OpenHelper.lambda$openCommon$1(bookId, activity, v9OpenWebViewParams, extraDataJsonObject, (java.lang.Integer) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$openCommon$1(java.lang.String str, android.app.Activity activity, com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams, com.alibaba.fastjson.JSONObject jSONObject, java.lang.Integer num) throws org.json.JSONException {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(str);
        if (android.text.TextUtils.isEmpty(str)) {
            bookInfoStudy.setBookId(com.up366.mobile.book.helper.Tools.commonBookId);
        }
        bookInfoStudy.setCourseId(num.intValue());
        bookInfoStudy.setBookType(1);
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("book", bookInfoStudy);
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo(bookInfoStudy);
        openConfigInfo.openUrl = v9OpenWebViewParams.getServiceUrl();
        openConfigInfo.title = v9OpenWebViewParams.getTitle();
        openConfigInfo.studyTaskId = v9OpenWebViewParams.getStudyTaskId();
        openConfigInfo.exerciseData = jSONObject.toJSONString();
        java.lang.String fileId = v9OpenWebViewParams.getFileId();
        if (!android.text.TextUtils.isEmpty(fileId)) {
            openConfigInfo.extFileIds = com.alibaba.fastjson.JSONObject.toJSONString(com.up366.mobile.book.helper.Tools.buildPendingInfosFileId(fileId));
        }
        intent.putExtra("cfg", openConfigInfo);
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(bookInfoStudy, openConfigInfo, v9OpenWebViewParams);
        activity.startActivity(intent);
    }

    private static void open2025(final android.app.Activity activity, final com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams) {
        final com.alibaba.fastjson.JSONObject extraDataJsonObject = v9OpenWebViewParams.getExtraDataJsonObject();
        java.lang.String string = extraDataJsonObject.getString("scenario");
        java.lang.String string2 = extraDataJsonObject.getString("studyTaskDetail");
        boolean zFromHistory = v9OpenWebViewParams.fromHistory();
        if (("_SELF_STUDY_".equals(string) || "_OPEN_STYLE_PRACTICE_".equals(string)) && !com.up366.common.StringUtils.isEmptyOrNull(string2)) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(string2, com.up366.mobile.course.task.TaskInfoV2.class);
            taskInfoV2.setFinish(zFromHistory);
            if ("_OPEN_STYLE_PRACTICE_".equals(string)) {
                com.up366.mobile.course.task.TaskOpenBookStudyHelper.openHomework(activity, taskInfoV2);
                return;
            } else {
                com.up366.mobile.course.task.TaskJumpHelper.openSelfStudyPageNoCheck(activity, taskInfoV2, extraDataJsonObject.getIntValue("difficulty"));
                return;
            }
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(v9OpenWebViewParams.getBookInfo()) && !com.up366.common.StringUtils.isEmptyOrNull(v9OpenWebViewParams.getLinkedData()) && !com.up366.common.StringUtils.isEmptyOrNull(string2)) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV22 = (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(string2, com.up366.mobile.course.task.TaskInfoV2.class);
            taskInfoV22.setFinish(zFromHistory);
            com.up366.mobile.course.task.TaskOpenBookStudyHelper.openStudyPageImpl(activity, taskInfoV22, v9OpenWebViewParams.isReTest(), v9OpenWebViewParams.isReport());
        } else {
            final java.lang.String bookId = v9OpenWebViewParams.getBookId();
            com.up366.mobile.common.logic.Auth.cur().course().selectCourseIdContainsBook(activity, bookId, v9OpenWebViewParams.getCourseId(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda11
                public final void accept(java.lang.Object obj) throws org.json.JSONException {
                    com.up366.mobile.book.helper.V9OpenHelper.lambda$open2025$2(bookId, activity, v9OpenWebViewParams, extraDataJsonObject, (java.lang.Integer) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$open2025$2(java.lang.String str, android.app.Activity activity, com.up366.mobile.book.helper.model.V9OpenWebViewParams v9OpenWebViewParams, com.alibaba.fastjson.JSONObject jSONObject, java.lang.Integer num) throws org.json.JSONException {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(str);
        if (android.text.TextUtils.isEmpty(str)) {
            bookInfoStudy.setBookId(com.up366.mobile.book.helper.Tools.commonBookId);
        }
        bookInfoStudy.setCourseId(num.intValue());
        bookInfoStudy.setBookType(1);
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("book", bookInfoStudy);
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo(bookInfoStudy);
        openConfigInfo.openUrl = v9OpenWebViewParams.getServiceUrl();
        openConfigInfo.title = v9OpenWebViewParams.getTitle();
        openConfigInfo.studyTaskId = v9OpenWebViewParams.getStudyTaskId();
        openConfigInfo.exerciseData = jSONObject.toJSONString();
        openConfigInfo.taskId = v9OpenWebViewParams.getTaskId();
        java.lang.String fileId = v9OpenWebViewParams.getFileId();
        if (!android.text.TextUtils.isEmpty(fileId)) {
            openConfigInfo.extFileIds = com.alibaba.fastjson.JSONObject.toJSONString(com.up366.mobile.book.helper.Tools.buildPendingInfosFileId(fileId));
        }
        intent.putExtra("cfg", openConfigInfo);
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(bookInfoStudy, openConfigInfo, v9OpenWebViewParams);
        activity.startActivity(intent);
    }

    public void closeWebView() {
        this.studyV9View.registerHelper.unRegister("beforeGoBack");
        this.context.onBackPressed();
    }

    /* JADX INFO: renamed from: openWrongQuestion, reason: merged with bridge method [inline-methods] */
    public void lambda$gotoNativeModule$8(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject.containsKey(FROM_TASK_LIST_KEY)) {
            int intValue = jSONObject.getIntValue(FROM_TASK_LIST_KEY);
            if (intValue == 0) {
                goToWrongNote(this.context);
                return;
            }
            int intValue2 = jSONObject.getIntValue("stageId");
            int intValue3 = jSONObject.getIntValue("subjectId");
            if (intValue2 == 0 || intValue3 == 0) {
                this.context.startActivity(new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class));
                return;
            }
            int intValue4 = jSONObject.getIntValue("assignId");
            java.lang.String string = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            java.lang.String string2 = jSONObject.getString("bookName");
            int intValue5 = jSONObject.getIntValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
            java.lang.String string3 = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
            java.lang.String str = com.up366.common.StringUtils.isEmptyOrNull(string) ? "0" : string;
            if (com.up366.common.StringUtils.isEmptyOrNull(string2)) {
                string2 = "";
            }
            int i = "0".equals(str) ? 1 : 2;
            android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
            intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
            intent.putExtra("bookName", string2);
            intent.putExtra("stageId", intValue2);
            intent.putExtra("subjectId", intValue3);
            intent.putExtra("type", i);
            intent.putExtra("fromType", 1);
            intent.putExtra("isCurJob", intValue == 1);
            intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, intValue5);
            intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, string3);
            if (intValue4 > 0) {
                intent.putExtra("assignId", intValue4);
            }
            this.context.startActivity(intent);
            return;
        }
        final android.content.Intent intent2 = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
        intent2.putExtra("stageId", jSONObject.getIntValue("stageId"));
        intent2.putExtra("subjectId", jSONObject.getIntValue("subjectId"));
        intent2.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID));
        intent2.putExtra("bookName", jSONObject.getString("bookName"));
        intent2.putExtra("type", 2);
        intent2.putExtra("fromType", 2);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WRONGNOTE).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openWrongQuestion$3(intent2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWrongQuestion$3(android.content.Intent intent) {
        this.context.startActivity(intent);
    }

    private void goToWrongNote(final android.app.Activity activity) {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "数据加载中");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.V9OpenHelper.lambda$goToWrongNote$6(activity);
            }
        });
    }

    static /* synthetic */ void lambda$goToWrongNote$6(final android.app.Activity activity) throws java.lang.Exception {
        final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolderLoad = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWrongNoteList(coursePageCountHolderLoad, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.book.helper.V9OpenHelper.lambda$goToWrongNote$5(coursePageCountHolderLoad, activity, response, (java.util.List) obj);
            }
        });
    }

    static /* synthetic */ void lambda$goToWrongNote$5(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, final android.app.Activity activity, com.up366.common.http.Response response, java.util.List list) {
        java.util.Objects.requireNonNull(coursePageCountHolder);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.mobile.book.helper.V8OpenHelper$$ExternalSyntheticLambda10(coursePageCountHolder));
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(activity, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
            return;
        }
        final android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
        intent.putExtra("type", 1);
        intent.putExtra("fromType", 0);
        if (list == null || list.size() != 1) {
            intent.putExtra(com.up366.mobile.course.wrongnote.WrongNoteActivity.INTENT_WRONG_SUBJECT, (java.io.Serializable) list);
            activity.startActivity(intent);
            return;
        }
        com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo wrongNoteSubjectInfo = (com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo) list.get(0);
        intent.putExtra("stageId", wrongNoteSubjectInfo.getStageId());
        intent.putExtra("subjectId", wrongNoteSubjectInfo.getSubjectId());
        intent.putExtra(com.up366.mobile.course.wrongnote.WrongNoteActivity.INTENT_WRONG_SUBJECT, (java.io.Serializable) list);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WRONGNOTE).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                activity.startActivity(intent);
            }
        });
    }

    public void openDictionary(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V9ExerciseOpenHelper - openDictionary - word:" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD));
        com.up366.mobile.book.StudyActivityDialog.openDict(this.context, this.studyV9View.getRootView(), str);
    }

    public void openDictionaryV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V9ExerciseOpenHelper - openDictionaryV2 - json:" + str);
        com.up366.mobile.book.StudyActivity2025Dialog.openDict(this.context, this.studyV9View.getRootView(), str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void gotoNativeModule(java.lang.String str) {
        com.up366.common.log.Logger.info("gotoNativeModule -  params: " + str);
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("moduleId");
        boolean booleanValue = object.getBooleanValue("openNewWebView");
        final com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("data");
        string.hashCode();
        byte b = -1;
        switch (string.hashCode()) {
            case -1967967534:
                if (string.equals("NETWORK_HELP")) {
                    b = 0;
                }
                break;
            case -1723475381:
                if (string.equals("INTELLIGENT_CLASSROOM")) {
                    b = 1;
                }
                break;
            case -856745345:
                if (string.equals("ACCOUNT_SAFE")) {
                    b = 2;
                }
                break;
            case -588875769:
                if (string.equals("WORD_NOTE")) {
                    b = 3;
                }
                break;
            case -81313789:
                if (string.equals("APP_FEEDBACK")) {
                    b = 4;
                }
                break;
            case -29421844:
                if (string.equals("BIND_PARENT")) {
                    b = 5;
                }
                break;
            case 40956507:
                if (string.equals("STUDY_TASK")) {
                    b = 6;
                }
                break;
            case 42378261:
                if (string.equals("USERINFO_PAGE")) {
                    b = 7;
                }
                break;
            case 181374932:
                if (string.equals("APP_HELPCENTER")) {
                    b = 8;
                }
                break;
            case 648915242:
                if (string.equals("SCAN_PAPER")) {
                    b = 9;
                }
                break;
            case 772496228:
                if (string.equals("WRONG_NOTE")) {
                    b = 10;
                }
                break;
            case 1544818849:
                if (string.equals("APP_SETTINGS")) {
                    b = com.igexin.push.core.b.n.l;
                }
                break;
            case 1556290227:
                if (string.equals(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.FROM_TYPE_SCAN_PAPER_GENERAL)) {
                    b = 12;
                }
                break;
        }
        switch (b) {
            case 0:
                com.up366.mobile.book.helper.OpenHelper.openNetHelp(this.context);
                break;
            case 1:
                final android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(2));
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda8
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$gotoNativeModule$7(intent);
                    }
                });
                break;
            case 2:
                com.up366.mobile.book.helper.OpenHelper.openAccountSafe(this.context);
                break;
            case 3:
                com.up366.mobile.common.helper.PageFunctionCheckHelper.checkFunCheck(com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WORDNOE, new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$gotoNativeModule$9(jSONObject);
                    }
                });
                break;
            case 4:
                com.up366.mobile.book.helper.OpenHelper.openFeedBack(this.context, jSONObject);
                break;
            case 5:
                com.up366.mobile.book.helper.OpenHelper.openBindParent(this.context);
                break;
            case 6:
                com.up366.mobile.book.helper.OpenHelper.openTaskList(this.context, jSONObject);
                break;
            case 7:
                com.up366.mobile.book.helper.OpenHelper.openUserInfoPage(this.context);
                break;
            case 8:
                com.up366.mobile.book.helper.OpenHelper.openHelpCenter(this.context, jSONObject);
                break;
            case 9:
                com.up366.mobile.book.helper.OpenHelper.openScanPaper(this.context, jSONObject);
                break;
            case 10:
                com.up366.mobile.common.helper.PageFunctionCheckHelper.checkFunCheck(com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WRONGNOTE, new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$gotoNativeModule$8(jSONObject);
                    }
                });
                break;
            case 11:
                com.up366.mobile.book.helper.OpenHelper.openAppSystemSettings(this.context);
                break;
            case 12:
                com.up366.mobile.book.helper.OpenHelper.openScanPaperV2(this.context, jSONObject, this.studyV9View.getCurrentWebViewId());
                break;
            default:
                com.up366.mobile.common.utils.ToastPopupUtil.show(this.context, "未定义：" + string);
                break;
        }
        if (booleanValue) {
            return;
        }
        closeWebView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$gotoNativeModule$7(android.content.Intent intent) throws java.lang.Exception {
        this.context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: openWordNote, reason: merged with bridge method [inline-methods] */
    public void lambda$gotoNativeModule$9(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject.containsKey(FROM_TASK_LIST_KEY)) {
            int intValue = jSONObject.getIntValue(FROM_TASK_LIST_KEY);
            if (intValue == 0) {
                android.content.Intent intent = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
                intent.putExtra("type", 1);
                intent.putExtra("fromType", 0);
                this.context.startActivity(intent);
                return;
            }
            int intValue2 = jSONObject.getIntValue("assignId");
            java.lang.String string = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            java.lang.String string2 = jSONObject.getString("bookName");
            if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
                string = "0";
            }
            if (com.up366.common.StringUtils.isEmptyOrNull(string2)) {
                string2 = "";
            }
            int i = "0".equals(string) ? 1 : 2;
            android.content.Intent intent2 = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
            intent2.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, string);
            intent2.putExtra("bookName", string2);
            intent2.putExtra("type", i);
            intent2.putExtra("fromType", 1);
            intent2.putExtra("isCurJob", intValue == 1);
            intent2.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, jSONObject.getIntValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID));
            intent2.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID));
            if (intValue2 > 0) {
                intent2.putExtra("assignId", intValue2);
            }
            this.context.startActivity(intent2);
            return;
        }
        final android.content.Intent intent3 = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
        intent3.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID));
        intent3.putExtra("bookName", jSONObject.getString("bookName"));
        intent3.putExtra("type", 2);
        intent3.putExtra("fromType", 0);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WORDS).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V9OpenHelper$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openWordNote$10(intent3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWordNote$10(android.content.Intent intent) {
        this.context.startActivity(intent);
    }
}
