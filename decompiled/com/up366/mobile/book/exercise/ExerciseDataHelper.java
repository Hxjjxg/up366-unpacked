package com.up366.mobile.book.exercise;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseDataHelper {
    public com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.exercise.model.ExerciseData d;
    public com.up366.mobile.book.exercise.model.ExerciseDataHolder dataHolder;

    public void init(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.exercise.model.ExerciseDataHolder exerciseDataHolder) {
        this.context = studyActivity;
        this.dataHolder = exerciseDataHolder;
    }

    public void initExerciseData(final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.book.exercise.model.ExerciseData> iCallbackCodeInfoObj) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.ExerciseDataHelper$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initExerciseData$0(iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initExerciseData$0(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        java.lang.String str = this.dataHolder.exerciseType;
        str.hashCode();
        switch (str) {
            case "textbook":
                initCourseBookExerciseData(this.dataHolder, iCallbackCodeInfoObj);
                break;
            case "homework":
            case "homework_report":
                initHomeworkExerciseData(this.dataHolder, iCallbackCodeInfoObj);
                break;
            default:
                initSimpleExerciseData(iCallbackCodeInfoObj);
                break;
        }
    }

    private void initSimpleExerciseData(final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.book.exercise.model.ExerciseData> iCallbackCodeInfoObj) {
        java.lang.String str = this.dataHolder.exerciseId;
        if (this.d == null) {
            com.up366.mobile.book.exercise.model.ExerciseData exerciseData = new com.up366.mobile.book.exercise.model.ExerciseData();
            this.d = exerciseData;
            exerciseData.setExerciseId(str);
        }
        this.d.setResourceDir(com.up366.mobile.common.utils.AppFileUtils.getCacheDir());
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.ExerciseDataHelper$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initSimpleExerciseData$1(iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSimpleExerciseData$1(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        iCallbackCodeInfoObj.onResult(0, "", this.d);
    }

    private void initCourseBookExerciseData(com.up366.mobile.book.exercise.model.ExerciseDataHolder exerciseDataHolder, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.book.exercise.model.ExerciseData> iCallbackCodeInfoObj) {
        java.lang.String str = exerciseDataHolder.exerciseId;
        final com.up366.mobile.book.exercise.model.ExerciseData exerciseData = (com.up366.mobile.book.exercise.model.ExerciseData) com.up366.mobile.common.logic.Auth.cur().db().getExerciseDataDao().queryBuilder().where(com.up366.greendao.ExerciseDataDao.Properties.ExerciseId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
        if (exerciseData == null) {
            exerciseData = new com.up366.mobile.book.exercise.model.ExerciseData();
            exerciseData.setExerciseId(str);
            exerciseData.setHasSubmit(0);
        }
        this.dataHolder.exerciseType = "textbook";
        java.lang.String string = this.dataHolder.exerciseData.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        java.lang.String string2 = this.dataHolder.exerciseData.getString("contentChapterId");
        exerciseData.setPaperXml(com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), string, string2, "paper.xml")));
        exerciseData.setStandardXml(com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), string, string2, "correctAnswer.xml")));
        exerciseData.setResourceDir(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), string, string2));
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.ExerciseDataHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                iCallbackCodeInfoObj.onResult(0, "", exerciseData);
            }
        });
    }

    private void initHomeworkExerciseData(com.up366.mobile.book.exercise.model.ExerciseDataHolder exerciseDataHolder, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.book.exercise.model.ExerciseData> iCallbackCodeInfoObj) {
        java.lang.String str = exerciseDataHolder.exerciseId;
        final com.up366.mobile.book.exercise.model.ExerciseData exerciseData = (com.up366.mobile.book.exercise.model.ExerciseData) com.up366.mobile.common.logic.Auth.cur().db().getExerciseDataDao().queryBuilder().where(com.up366.greendao.ExerciseDataDao.Properties.ExerciseId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
        if (exerciseData == null) {
            exerciseData = new com.up366.mobile.book.exercise.model.ExerciseData();
            exerciseData.setExerciseId(str);
            exerciseData.setHasSubmit(0);
        }
        java.lang.String str2 = exerciseDataHolder.exerciseType;
        str2.hashCode();
        if (str2.equals("homework")) {
            exerciseData.setHasSubmit(0);
        } else if (str2.equals(com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.HOMEWORK_REPORT)) {
            exerciseData.setHasSubmit(1);
        }
        exerciseData.setPaperXml(com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(getHomeworkDir(), "paper.xml")));
        exerciseData.setStandardXml(com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(getHomeworkDir(), "correctAnswer.xml")));
        exerciseData.setResourceDir(getHomeworkDir());
        if (exerciseDataHolder.exerciseType.equals("homework")) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.ExerciseDataHelper$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfoObj.onResult(0, "", exerciseData);
                }
            });
        } else {
            com.up366.mobile.common.logic.Auth.cur().homework().fetchUserAnswer(this.dataHolder.exerciseData.getString("testId"), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.exercise.ExerciseDataHelper$$ExternalSyntheticLambda3
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$initHomeworkExerciseData$6(exerciseData, iCallbackCodeInfoObj, response, (com.up366.mobile.course.homework.model.AnswerDataOfTest) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHomeworkExerciseData$6(final com.up366.mobile.book.exercise.model.ExerciseData exerciseData, final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, com.up366.common.http.Response response, com.up366.mobile.course.homework.model.AnswerDataOfTest answerDataOfTest) {
        if (response.isError()) {
            if (com.up366.common.StringUtils.isEmptyOrNull(exerciseData.getAnswerXml())) {
                new androidx.appcompat.app.AlertDialog.Builder(this.context).setTitle("答案加载失败").setMessage(response.getInfo()).setPositiveButton("确定", (android.content.DialogInterface.OnClickListener) null).show();
                return;
            } else {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.ExerciseDataHelper$$ExternalSyntheticLambda4
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        iCallbackCodeInfoObj.onResult(0, "", exerciseData);
                    }
                });
                return;
            }
        }
        exerciseData.setMarkXml(answerDataOfTest.getUserAnswer().getMarkData());
        exerciseData.setAnswerXml(answerDataOfTest.getUserAnswer().getAnswerData());
        if (this.dataHolder.exerciseData.getInteger("status").intValue() == 0) {
            this.dataHolder.exerciseData.put("status", java.lang.Integer.valueOf(answerDataOfTest.getUserAnswer().getTestStatus()));
        } else {
            this.dataHolder.exerciseData.put("status", java.lang.Integer.valueOf(answerDataOfTest.getUserAnswer().getTestStatus() > 2 ? answerDataOfTest.getUserAnswer().getTestStatus() : 2));
        }
        if (this.dataHolder.exerciseData.getIntValue("status") == 3) {
            exerciseData.setHasMark(1);
        } else {
            exerciseData.setHasMark(0);
        }
        exerciseData.setScore(answerDataOfTest.getUserAnswer().getScore());
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.ExerciseDataHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() {
                iCallbackCodeInfoObj.onResult(0, "", exerciseData);
            }
        });
    }

    public java.lang.String getPath() {
        if (com.up366.mobile.book.exercise.ExerciseResourceHelper.isTestDir()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "加载测试版作答引擎");
        }
        java.lang.String exerciseRootDir = com.up366.mobile.book.exercise.ExerciseResourceHelper.getExerciseRootDir();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.book.exercise.ExerciseResourceHelper.getExerciseConfig());
        if (object == null) {
            com.up366.common.log.Logger.error("TAG - ExerciseDataHelper - getPath - configJson == null");
            return "about:blank";
        }
        java.lang.String string = object.getJSONObject(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH).getString(this.dataHolder.exerciseType);
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.ExerciseDataHelper$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$getPath$7();
                }
            });
        }
        return "file://" + com.up366.common.FileUtilsUp.join(exerciseRootDir, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPath$7() throws java.lang.Exception {
        new androidx.appcompat.app.AlertDialog.Builder(this.context).setTitle("提示").setMessage("未定义类型的页面(" + this.dataHolder.exerciseType + ")").setPositiveButton("确定", (android.content.DialogInterface.OnClickListener) null).show();
        com.up366.common.log.Logger.error("TAG - 2018/5/17 - ExercisePageHelper - getPath - dataHolder.exerciseType = " + this.dataHolder.exerciseType + " hasSubmit:" + this.d.hasSubmit());
    }

    public java.lang.String getHomeworkDir() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getHomeworkDir(), this.dataHolder.exerciseData.getString("testId"));
    }
}
