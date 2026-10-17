package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseHelper {
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.exercise.ExerciseDataHelper dataHelper;
    private final com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView;
    private final com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;

    public ExerciseHelper(com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView, com.up366.mobile.book.exercise.ExerciseDataHelper exerciseDataHelper, com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper) {
        this.exerciseHtmlView = exerciseHtmlView;
        this.dataHelper = exerciseDataHelper;
        this.context = studyActivity;
        this.takePhotoHelper = takePhotoHelper;
    }

    public java.lang.String getPageParams() {
        java.lang.String str = this.dataHelper.dataHolder.exerciseType;
        str.hashCode();
        switch (str) {
            case "textbook":
                return getCourseBookPageParams();
            case "homework":
            case "homework_report":
                return getHomeworkPageParams();
            default:
                return this.dataHelper.dataHolder.exerciseData.toJSONString();
        }
    }

    public java.lang.String getPageParamValue(java.lang.String str) {
        return com.alibaba.fastjson.JSON.parseObject(getPageParams()).getString(str);
    }

    private java.lang.String getCourseBookPageParams() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject(this.dataHelper.dataHolder.exerciseData);
        jSONObject.put("resPrefix", this.dataHelper.d.getLocalResourceDir());
        jSONObject.put("score", java.lang.Float.valueOf(this.dataHelper.d.getScore()));
        jSONObject.put("isSubmited", java.lang.Integer.valueOf(this.dataHelper.d.hasSubmit() ? 1 : 0));
        return jSONObject.toJSONString();
    }

    private java.lang.String getHomeworkPageParams() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject(this.dataHelper.dataHolder.exerciseData);
        jSONObject.put("resPrefix", this.dataHelper.d.getLocalResourceDir());
        jSONObject.put("score", java.lang.Float.valueOf(this.dataHelper.d.getScore()));
        jSONObject.put("answerDuration", java.lang.Long.valueOf(this.dataHelper.d.getAnswerTime()));
        return jSONObject.toJSONString();
    }

    public void submitTest(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        str2.hashCode();
        switch (str2) {
            case "textbook":
                submitCourseBook(str3);
                break;
            case "homework":
            case "homework_report":
                submitHomework(str3);
                break;
            case "stu_tlpy_tspy_personal_practice":
                submitPersonalPractice(str, str3);
                break;
            default:
                new androidx.appcompat.app.AlertDialog.Builder(com.up366.common.global.GB.get().getCurrentActivity()).setTitle("提示").setMessage("还没有做这种作答场景的提交！").setPositiveButton("确定", (android.content.DialogInterface.OnClickListener) null).show();
                break;
        }
    }

    public void clearAnswerData(java.lang.String str, java.lang.String str2) {
        this.dataHelper.d.resetExercise();
        this.dataHelper.d.save();
    }

    private void submitCourseBook(final java.lang.String str) {
        final java.lang.String string = this.dataHelper.dataHolder.exerciseData.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, string);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("code", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("info", "上传中");
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("status", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("max", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("progress", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("percent", 0);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$submitCourseBook$0(str, string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitCourseBook$0(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        this.dataHelper.d.setAnswerXml(object.getString("userAnswerXmlStr"));
        this.dataHelper.d.setMarkXml(object.getString("markDataXmlStr"));
        this.dataHelper.d.setHasMark(1);
        this.dataHelper.d.setHasSubmit(1);
        this.dataHelper.d.setAnswerTime(object.getLongValue("duration"));
        this.dataHelper.d.setScore(object.getFloatValue("score"));
        this.dataHelper.d.setWordIds(object.getString("wordIds"));
        this.dataHelper.d.save();
        com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2 = new com.up366.mobile.book.model.BookTaskLogV2();
        com.up366.mobile.book.model.AnswerEleAttrInfo answerEleAttrInfo = new com.up366.mobile.book.model.AnswerEleAttrInfo();
        bookTaskLogV2.setGuid(com.up366.mobile.book.model.AnswerEleAttrInfo.UUID());
        java.lang.String string = this.dataHelper.dataHolder.exerciseData.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        java.lang.String string2 = this.dataHelper.dataHolder.exerciseData.getString("taskNo");
        java.lang.String string3 = this.dataHelper.dataHolder.exerciseData.getString("chapterId");
        int intValue = this.dataHelper.dataHolder.exerciseData.getIntValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
        java.lang.String string4 = this.dataHelper.dataHolder.exerciseData.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
        bookTaskLogV2.setBookId(string);
        bookTaskLogV2.setTaskId(str2);
        bookTaskLogV2.setTaskNo(string2);
        if (object.containsKey("submitType")) {
            bookTaskLogV2.setSubmitType(object.getIntValue("submitType"));
        }
        bookTaskLogV2.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        answerEleAttrInfo.setBookId(string);
        answerEleAttrInfo.setTaskId(str2);
        answerEleAttrInfo.setTaskNo(string2);
        answerEleAttrInfo.setChapterId(string3);
        answerEleAttrInfo.setCourseId(java.lang.Integer.valueOf(intValue));
        answerEleAttrInfo.setStudyTaskId(string4);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("studentid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("answerdata", object.getString("userAnswerXmlStr"));
        jSONObject2.put("markdatao", object.getString("markDataXmlStr"));
        java.lang.String string5 = object.getString("timeData");
        java.lang.String string6 = object.getString("playData");
        if (!com.up366.common.StringUtils.isEmptyOrNull(string6)) {
            jSONObject2.put("playdata", string6);
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(string5)) {
            jSONObject2.put("timedata", string5);
        }
        jSONObject.put("testInfo", jSONObject2);
        answerEleAttrInfo.setResult(jSONObject.toJSONString());
        answerEleAttrInfo.setSeconds((int) (this.dataHelper.d.getAnswerTime() / 1000));
        answerEleAttrInfo.setPercent(object.getFloatValue("percent"));
        float floatValue = object.getFloatValue("score");
        int floatValue2 = (int) object.getFloatValue("percent");
        answerEleAttrInfo.setScore(floatValue);
        bookTaskLogV2.setScore(answerEleAttrInfo.getScore());
        bookTaskLogV2.setPercent(floatValue2);
        answerEleAttrInfo.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        bookTaskLogV2.setAnswers(com.alibaba.fastjson.JSON.toJSONString(answerEleAttrInfo));
        bookTaskLogV2.setFileUrls(object.getString("urls"));
        bookTaskLogV2.setStudyTaskId(string4);
        com.up366.mobile.common.logic.Auth.cur().bookLog().addBookTaskLog(bookTaskLogV2);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.TaskScoreUpdateEvent(string3, str2, floatValue, floatValue2));
        submitWrongWordIds(string, object.getString("wordIds"));
    }

    private void submitPersonalPractice(final java.lang.String str, final java.lang.String str2) {
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("uploadId", str);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("code", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("info", "上传中");
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("status", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("max", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("progress", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("percent", 0);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$submitPersonalPractice$1(str2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitPersonalPractice$1(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.lang.String string = this.dataHelper.dataHolder.exerciseData.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        int intValue = this.dataHelper.dataHolder.exerciseData.getIntValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("extendParams");
        float floatValue = jSONObject.getFloatValue("percent");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("studentid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
        jSONObject3.put("answerdata", object.get("userAnswerXmlStr"));
        jSONObject3.put("markdatao", object.get("markDataXmlStr"));
        jSONObject3.put("timedata", object.get("timedata"));
        jSONObject2.put("testInfo", jSONObject3);
        float floatValue2 = object.getFloatValue("score");
        com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2 = new com.up366.mobile.book.model.BookTaskLogV2();
        bookTaskLogV2.setGuid(str2);
        bookTaskLogV2.setSubmitType(object.getIntValue("submitType"));
        bookTaskLogV2.setFileUrls(object.getString("urls"));
        com.up366.mobile.book.model.AnswerEleAttrInfo answerEleAttrInfo = new com.up366.mobile.book.model.AnswerEleAttrInfo();
        answerEleAttrInfo.setBookId(string);
        answerEleAttrInfo.setCourseId(java.lang.Integer.valueOf(intValue));
        answerEleAttrInfo.setChapterId(null);
        answerEleAttrInfo.setTaskId(null);
        answerEleAttrInfo.setResult(jSONObject2.toJSONString());
        answerEleAttrInfo.setPercent(floatValue);
        answerEleAttrInfo.setScore(floatValue2);
        answerEleAttrInfo.setSeconds(0);
        answerEleAttrInfo.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        answerEleAttrInfo.setExtendParams(jSONObject.toJSONString());
        bookTaskLogV2.setAnswers(com.alibaba.fastjson.JSON.toJSONString(answerEleAttrInfo));
        com.up366.mobile.common.logic.Auth.cur().bookLog().addPersonalPracticeLog(bookTaskLogV2);
    }

    private void submitWrongWordIds(final java.lang.String str, final java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            return;
        }
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(8, java.lang.String.valueOf(java.lang.Math.random()));
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.submitWrongWords) { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
                map.put("wordIds", str2);
            }
        });
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
    }

    private void submitHomework(java.lang.String str) {
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask = new com.alibaba.fastjson.JSONObject();
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("testId", this.dataHelper.dataHolder.exerciseData.getString("testId"));
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("code", 0);
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("info", "上传中");
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("status", 0);
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("max", 0);
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("progress", 0);
            com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("percent", 0);
            this.dataHelper.d.setHasSubmit(1);
            this.dataHelper.d.setStartTime(object.getLongValue("startTime"));
            this.dataHelper.d.setSubmitTime(object.getLongValue("submitTime"));
            this.dataHelper.d.setAnswerXml(object.getString("userAnswerXmlStr"));
            this.dataHelper.d.setAnswerTime(object.getLongValue("duration"));
            java.lang.String string = object.getString("urls");
            java.lang.String string2 = object.getString("timeData");
            java.lang.String string3 = object.getString("playData");
            this.dataHelper.d.save();
            com.alibaba.fastjson.JSONObject jSONObject = this.dataHelper.dataHolder.exerciseData;
            new com.up366.mobile.book.exercise.js.HwUploadHelper().lambda$submitToServer$0(jSONObject.getString("testId"), jSONObject.getString("paperId"), this.dataHelper.d.getStartTime(), this.dataHelper.d.getSubmitTime(), (int) this.dataHelper.d.getAnswerTime(), this.dataHelper.d.getAnswerXml(), string, string2, string3);
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "数据格式错误");
            com.up366.common.log.Logger.error("TAG - 2018/6/11 - ExerciseHelper - submitHomework - ", e);
        }
    }

    public void ocr(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final java.lang.String string = object.getString(com.igexin.push.core.b.C);
        this.takePhotoHelper.getPictureCropAndRecognition(object.getIntValue("skipConfirm"), new com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback
            public final void onResult(java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.f$0.lambda$ocr$2(string, str2, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ocr$2(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.up366.mobile.book.exercise.js.RegisterHelper registerHelper = this.exerciseHtmlView.jsInterface.registerHelper;
        if (registerHelper.hasRegister("onOCRFinished")) {
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
            registerHelper.callJsEvent("onOCRFinished", "(%s)", jSONObject.toJSONString());
        }
    }

    public void getPhoto(final java.lang.String str, int i) {
        this.takePhotoHelper.getPhotoNew(this.dataHelper.d.getAnswerDir(), "作答页面图片选择", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda8
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i2, java.lang.String str2) {
                this.f$0.lambda$getPhoto$4(str, i2, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoto$4(final java.lang.String str, int i, final java.lang.String str2) {
        final com.up366.mobile.book.exercise.js.RegisterHelper registerHelper = this.exerciseHtmlView.jsInterface.registerHelper;
        if (registerHelper.hasRegister("pickphoto")) {
            com.up366.mobile.common.logic.Auth.cur().fileMgr().save(str2, null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda4
                @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                    com.up366.mobile.book.exercise.js.ExerciseHelper.lambda$getPhoto$3(str2, registerHelper, str, fileMapInfo);
                }
            });
        }
    }

    static /* synthetic */ void lambda$getPhoto$3(java.lang.String str, com.up366.mobile.book.exercise.js.RegisterHelper registerHelper, java.lang.String str2, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("localPath", str);
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfo.getUrl());
        jSONObject.put("size", java.lang.Long.valueOf(new java.io.File(str).length()));
        jSONArray.add(jSONObject);
        registerHelper.callJsEvent("pickphoto", "('%s',%s)", str2, jSONArray.toJSONString());
    }

    public void getPhotoV2(java.lang.String str, int i, final com.up366.common.callback.ICallbackCodeInfoObj<com.alibaba.fastjson.JSONArray> iCallbackCodeInfoObj) {
        this.takePhotoHelper.getPhotoNew(this.dataHelper.d.getAnswerDir(), "作答页面图片选择", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i2, java.lang.String str2) {
                com.up366.mobile.common.logic.Auth.cur().fileMgr().save(str2, null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda1
                    @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                    public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                        com.up366.mobile.book.exercise.js.ExerciseHelper.lambda$getPhotoV2$5(str2, iCallbackCodeInfoObj, fileMapInfo);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$getPhotoV2$5(java.lang.String str, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("localPath", str);
        jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfo.getUrl());
        jSONObject.put("size", java.lang.Long.valueOf(new java.io.File(str).length()));
        jSONArray.add(jSONObject);
        iCallbackCodeInfoObj.onResult(0, null, jSONArray);
    }

    public void deletePhoto(java.lang.String str) {
        com.up366.common.FileUtilsUp.deleteDirOrFile(str);
    }

    public void launchXotEngine(java.lang.String str, java.lang.String str2, boolean z) {
        if (z) {
            android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
            intent.putExtra("exercise_type", str);
            intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, str2);
            this.context.startActivity(intent);
            return;
        }
        this.dataHelper.dataHolder.init(str, str2);
        this.exerciseHtmlView.refresh();
    }

    public void showLoading(boolean z) {
        if (z) {
            this.context.setTitle(getLoadingTitle());
            this.context.showLoading(true);
        } else {
            this.context.showLoading(false);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public java.lang.String getLoadingTitle() {
        java.lang.String str = this.dataHelper.dataHolder.exerciseType;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1959177109:
                if (str.equals("teacher_preview")) {
                    b = 0;
                }
                break;
            case -1672548867:
                if (str.equals("selfstudy")) {
                    b = 1;
                }
                break;
            case -1030340122:
                if (str.equals(com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.QUESTION_TEXT)) {
                    b = 2;
                }
                break;
            case -1003216490:
                if (str.equals("textbook")) {
                    b = 3;
                }
                break;
            case -911415368:
                if (str.equals("student_report")) {
                    b = 4;
                }
                break;
            case -889496186:
                if (str.equals("teacher_homework_report")) {
                    b = 5;
                }
                break;
            case -702693629:
                if (str.equals(com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.STATISTIC_REPORT)) {
                    b = 6;
                }
                break;
            case -584514440:
                if (str.equals(com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.WRONG_NOTE_REVIEW)) {
                    b = 7;
                }
                break;
            case -545423585:
                if (str.equals("wrongnote")) {
                    b = 8;
                }
                break;
            case -485149584:
                if (str.equals("homework")) {
                    b = 9;
                }
                break;
            case -300648032:
                if (str.equals("teacher_textbook_report")) {
                    b = 10;
                }
                break;
            case 29155836:
                if (str.equals("wordnote")) {
                    b = com.igexin.push.core.b.n.l;
                }
                break;
            case 78135267:
                if (str.equals(com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.HOMEWORK_REPORT)) {
                    b = 12;
                }
                break;
            case 642560082:
                if (str.equals("weaktraining")) {
                    b = 13;
                }
                break;
            case 1220300821:
                if (str.equals("paper_preview")) {
                    b = 14;
                }
                break;
            case 2093667819:
                if (str.equals(com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.SIMILAR)) {
                    b = 15;
                }
                break;
        }
        switch (b) {
            case 0:
                return this.dataHelper.dataHolder.exerciseData.getString("testName");
            case 1:
                return "专项练习";
            case 2:
                return "查看原文";
            case 3:
                return this.dataHelper.dataHolder.exerciseData.getString("name");
            case 4:
            case 9:
            case 12:
                return this.dataHelper.dataHolder.exerciseData.getString("testName");
            case 5:
            case 6:
                return this.dataHelper.dataHolder.exerciseData.getString("nodeName");
            case 7:
                return this.dataHelper.dataHolder.exerciseData.getString("knowledgeName");
            case 8:
                return "消灭错题";
            case 10:
                return this.dataHelper.dataHolder.exerciseData.getString("name");
            case 11:
                return "消灭生词";
            case 13:
                return "弱项练习";
            case 14:
                return "";
            case 15:
                return "同类题";
            default:
                com.up366.common.log.Logger.warn("TAG - ExerciseHelper - showLoading - type:" + this.dataHelper.dataHolder.exerciseType + " : " + this.dataHelper.dataHolder.exerciseData.toJSONString());
                return "";
        }
    }

    public void closePage() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$closePage$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closePage$7() throws java.lang.Exception {
        this.exerciseHtmlView.jsInterface.registerHelper.unRegister("backpressed");
        this.exerciseHtmlView.jsInterfaceV2.registerHelper.unRegister("beforegoback");
        this.context.onBackPressed();
    }

    public void openWebView(java.lang.String str) {
        final com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("title");
        java.lang.String string2 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        final java.lang.String string3 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        final java.lang.String string4 = object.getString("pageId");
        int intValue = object.getIntValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
        java.lang.String string5 = object.getString("params");
        java.lang.String string6 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
        java.lang.String string7 = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        openConfigInfo.exerciseData = string5;
        openConfigInfo.studyTaskId = string6;
        if (!android.text.TextUtils.isEmpty(string2)) {
            final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
            bookInfoStudy.setBookId(string2);
            bookInfoStudy.setBookType(1);
            if (!android.text.TextUtils.isEmpty(string6)) {
                bookInfoStudy.setJumpStudyTaskId(string6);
            }
            com.up366.mobile.common.logic.Auth.cur().course().selectCourseIdContainsBook(this.context, string2, intValue, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.exercise.js.ExerciseHelper$$ExternalSyntheticLambda5
                public final void accept(java.lang.Object obj) {
                    this.f$0.lambda$openWebView$8(bookInfoStudy, openConfigInfo, string4, string3, (java.lang.Integer) obj);
                }
            });
            return;
        }
        openConfigInfo.exerciseType = this.exerciseHtmlView.dataHelper.dataHolder.exerciseType;
        com.alibaba.fastjson.JSONObject jSONObject = this.exerciseHtmlView.dataHelper.dataHolder.exerciseData;
        jSONObject.put("name", string);
        openConfigInfo.title = string;
        openConfigInfo.pageId = string4;
        openConfigInfo.openUrl = string7;
        openConfigInfo.exerciseData = jSONObject.toJSONString();
        if (com.up366.common.StringUtils.isEmptyOrNull(string7)) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this.exerciseHtmlView, "格式错误");
            com.up366.common.log.Logger.error("TAG - ExerciseOpenHelper - openWebView - 格式错误 ： " + str);
            return;
        }
        this.exerciseHtmlView.context.openPage(openConfigInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWebView$8(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, java.lang.String str, java.lang.String str2, java.lang.Integer num) {
        bookInfoStudy.setCourseId(num.intValue());
        openConfigInfo.chapterId = null;
        openConfigInfo.pageNo = -1;
        openConfigInfo.range = null;
        openConfigInfo.pageId = str;
        openConfigInfo.taskId = str2;
        android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("cfg", openConfigInfo);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", "_STANDARD_BOOK_");
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("bookType", java.lang.Integer.valueOf(bookInfoStudy.getBookType()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        this.context.startActivity(intent);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.app.Activity, com.up366.mobile.book.StudyActivity] */
    public void openDictionary(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V7ExerciseOpenHelper - openDictionary - word:" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD));
        ?? r0 = this.context;
        com.up366.mobile.book.StudyActivityDialog.openDict(r0, r0.rootView, str);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Activity, com.up366.mobile.book.StudyActivity] */
    public void openDictionaryV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V7ExerciseOpenHelper - openDictionaryV2 - : " + str);
        ?? r0 = this.context;
        com.up366.mobile.book.StudyActivity2025Dialog.openDict(r0, r0.rootView, str);
    }
}
