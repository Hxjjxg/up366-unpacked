package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskOpenBookStudyHelper {
    public void openHomeworkReport(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.HOMEWORK_REPORT);
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(taskInfoV2, intent, true, true);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        jSONObject.put("testId", taskInfoV2.getContentId());
        jSONObject.put("beginTime", java.lang.Long.valueOf(taskInfoV2.getBeginTime()));
        jSONObject.put("endTime", java.lang.Long.valueOf(taskInfoV2.getEndTime()));
        jSONObject.put("duration", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getDuration()));
        jSONObject.put("paperId", taskInfoV2.getExtParam().getPaperId());
        jSONObject.put("stageId", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getStageId()));
        jSONObject.put("publishRule", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getScoreTime()));
        jSONObject.put("publishStatus", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getPublishScore()));
        jSONObject.put("status", java.lang.Integer.valueOf(!taskInfoV2.isFinish() ? 0 : 2));
        jSONObject.put("testName", taskInfoV2.getJobName());
        jSONObject.put("xotParams", com.alibaba.fastjson.JSON.parseObject(taskInfoV2.getExtParam().getXotParam()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(taskInfoV2.getCourseId()));
        jSONObject.put("courseName", taskInfoV2.getCourseName());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, taskInfoV2.getJobId());
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        context.startActivity(intent);
    }

    public static void openHomework(final android.content.Context context, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(com.up366.mobile.book.helper.Tools.commonBookId);
        bookInfoStudy.setBookType(1);
        bookInfoStudy.setCourseId(taskInfoV2.getCourseId());
        bookInfoStudy.setJumpExtFileIds(com.up366.mobile.book.helper.Tools.buildPendingInfosPaper(taskInfoV2.getExtParam().getPaperId()));
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.course.task.TaskOpenBookStudyHelper.lambda$openHomework$1(taskInfoV2, bookInfoStudy, context);
            }
        });
    }

    static /* synthetic */ void lambda$openHomework$1(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, final android.content.Context context) throws java.lang.Exception {
        java.lang.String jobId = taskInfoV2.getJobId();
        com.up366.mobile.book.model.StudyTaskJsonMapInfo studyTaskJsonMapInfo = (com.up366.mobile.book.model.StudyTaskJsonMapInfo) com.up366.mobile.common.logic.Auth.cur().db1().findOne(com.up366.mobile.book.model.StudyTaskJsonMapInfo_.jobId, jobId);
        if (studyTaskJsonMapInfo == null) {
            studyTaskJsonMapInfo = new com.up366.mobile.book.model.StudyTaskJsonMapInfo(jobId, com.alibaba.fastjson.JSON.toJSONString(taskInfoV2));
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(studyTaskJsonMapInfo.json);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", "_OPEN_STYLE_PRACTICE_");
        jSONObject.put("studyTaskDetail", object);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("fromHistory", java.lang.Boolean.valueOf(taskInfoV2.isHistory()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.onStart(com.up366.mobile.book.helper.Tools.commonBookId, taskInfoV2.getContentId());
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(taskInfoV2, bookInfoStudy, false, taskInfoV2.isHistory());
        final android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("book", bookInfoStudy);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() {
                context.startActivity(intent);
            }
        });
    }

    public void openTaotiReport(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.STU_PAPER_VIEW);
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(taskInfoV2, intent, true, true);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(taskInfoV2.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, taskInfoV2.getJobId());
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        context.startActivity(intent);
    }

    public void open(final android.content.Context context, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        final java.lang.String jobId = taskInfoV2.getJobId();
        final java.lang.String contentId = taskInfoV2.getContentId();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$open$6(contentId, jobId, taskInfoV2, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$open$6(java.lang.String str, java.lang.String str2, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, final android.content.Context context) throws java.lang.Exception {
        final com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory2 : com.up366.mobile.common.logic.Auth.cur().db().getStudyTaskHistoryDao().queryBuilder().where(com.up366.greendao.StudyTaskHistoryDao.Properties.TaskId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).orderAsc(new org.greenrobot.greendao.Property[]{com.up366.greendao.StudyTaskHistoryDao.Properties.InsertTime}).list()) {
            if (com.up366.common.StringUtils.isEmptyOrNull(studyTaskHistory2.getStudyTaskId())) {
                z3 = true;
                studyTaskHistory = studyTaskHistory2;
            } else if (studyTaskHistory2.getStudyTaskId().equals(str2)) {
                z = true;
            } else {
                z2 = true;
            }
        }
        if (taskInfoV2.isFinish()) {
            z = true;
        }
        boolean z4 = taskInfoV2.getExtParam().taskKillFlag == 1;
        if (z || z4) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda8
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$open$2(context, taskInfoV2);
                }
            });
            return;
        }
        if (z2) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda9
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$open$3(context, taskInfoV2);
                }
            });
        } else if (z3) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda10
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$open$4(context, taskInfoV2, studyTaskHistory);
                }
            });
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda11
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$open$5(context, taskInfoV2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: openAutoKillTip, reason: merged with bridge method [inline-methods] */
    public void lambda$open$4(final android.content.Context context, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, final com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory) {
        java.lang.String str;
        if (!taskInfoV2.isFinish() && taskInfoV2.getEndTime() < com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) {
            str = "该份练习你之前练过，是否\n使用上一次成绩提交呢？";
        } else {
            str = "太厉害啦!\n你已经提前完成了该份练习";
        }
        final com.up366.mobile.common.dialog.AppDialog appDialogCreate = com.up366.mobile.common.dialog.AppDialog.create(context);
        appDialogCreate.setAutoDismiss(false).title(str).left("提交练习", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.task.TaskOpenBookStudyHelper.lambda$openAutoKillTip$9(appDialogCreate, taskInfoV2, studyTaskHistory, view);
            }
        }).right("继续查看", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.task.TaskOpenBookStudyHelper.lambda$openAutoKillTip$10(context, taskInfoV2, appDialogCreate, view);
            }
        }).tip("请手动提交或重新测验该份练习,否则老师\n接收不到你的成绩").show();
    }

    static /* synthetic */ void lambda$openAutoKillTip$9(final com.up366.mobile.common.dialog.AppDialog appDialog, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, final com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory, final android.view.View view) {
        view.setEnabled(false);
        com.up366.mobile.common.utils.ToastPopupUtil.setParentView(appDialog.b.getRoot());
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(view, "提交中");
        final com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(taskInfoV2.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, taskInfoV2.getJobId());
        if (taskInfoV2.getAssignId() > 0) {
            jSONObject.put("assignId", java.lang.Integer.valueOf(taskInfoV2.getAssignId()));
        }
        jSONObject.put("score", java.lang.Float.valueOf(studyTaskHistory.getScore()));
        com.up366.mobile.common.logic.Auth.cur().taskMgr().submitTaskToHistory(jSONObject.toJSONString(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda7
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.course.task.TaskOpenBookStudyHelper.lambda$openAutoKillTip$8(view, taskInfoV2, studyTaskHistory, jSONObject, appDialog, response, (java.lang.String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$openAutoKillTip$8(android.view.View view, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, final com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory, final com.alibaba.fastjson.JSONObject jSONObject, com.up366.mobile.common.dialog.AppDialog appDialog, com.up366.common.http.Response response, java.lang.String str) {
        view.setEnabled(true);
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(view);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(view, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
            com.up366.mobile.common.onlinelog.OpLog.report("自动消灭任务单-ERROR", response.toString());
        } else {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.course.task.TaskOpenBookStudyHelper.lambda$openAutoKillTip$7(taskInfoV2, studyTaskHistory, jSONObject);
                }
            });
            appDialog.dismiss();
        }
        com.up366.mobile.common.utils.ToastPopupUtil.clearParentView();
    }

    static /* synthetic */ void lambda$openAutoKillTip$7(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory, com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Exception {
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent(taskInfoV2.getContentId(), taskInfoV2.getJobId());
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(new com.up366.mobile.book.model.StudyTaskHistory(studyTaskHistory, taskInfoV2.getJobId()));
        com.up366.mobile.common.onlinelog.OpLog.report("自动消灭任务单", jSONObject.toJSONString());
    }

    static /* synthetic */ void lambda$openAutoKillTip$10(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, com.up366.mobile.common.dialog.AppDialog appDialog, android.view.View view) {
        openStudyPageImpl(context, taskInfoV2, false);
        appDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: openStudyPageWithReTest, reason: merged with bridge method [inline-methods] */
    public void lambda$open$3(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        openStudyPageImpl(context, taskInfoV2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: openStudyPage, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$open$5(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        openStudyPageImpl(context, taskInfoV2, false);
    }

    public static void openStudyPageImpl(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, boolean z) {
        openStudyPageImpl(context, taskInfoV2, z, false);
    }

    public static void openStudyPageImpl(final android.content.Context context, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, boolean z, boolean z2) {
        final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        final java.lang.String bookId = taskInfoV2.getExtParam().getBookId();
        bookInfoStudy.setBookId(bookId);
        final int bookType = taskInfoV2.getExtParam().getBookType();
        bookInfoStudy.setBookType(bookType);
        boolean z3 = true;
        if (bookInfoStudy.getBookType() == 2) {
            bookInfoStudy.setBookId(com.up366.mobile.book.helper.Tools.commonBookId);
            bookInfoStudy.setBookType(1);
        }
        if (taskInfoV2.getReturnState() == 1) {
            z = true;
        }
        bookInfoStudy.setCourseId(taskInfoV2.getCourseId());
        bookInfoStudy.setJumpOpenChapter(taskInfoV2.getExtParam().getChapterId());
        bookInfoStudy.setJumpOpenTask(taskInfoV2.getContentId());
        bookInfoStudy.setJumpOpenPage(taskInfoV2.getExtParam().getPageId());
        bookInfoStudy.setJumpStudyTaskId(taskInfoV2.getJobId());
        bookInfoStudy.setJumpFromTaskHistory(taskInfoV2.isHistory());
        bookInfoStudy.setJumpXotParam(taskInfoV2.getExtParam().getXotParam());
        bookInfoStudy.setJumpReTest(z);
        bookInfoStudy.setJumpExtFileIds(com.up366.mobile.book.helper.Tools.buildPendingInfosTask(bookId, taskInfoV2.getContentId(), bookType));
        com.up366.mobile.common.onlinelog.OpLogData.Companion companion = com.up366.mobile.common.onlinelog.OpLogData.INSTANCE;
        if (!taskInfoV2.getIsFinish() && !taskInfoV2.isHistory()) {
            z3 = false;
        }
        companion.addBehavior(taskInfoV2, bookInfoStudy, z2, z3);
        final boolean z4 = z;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.course.task.TaskOpenBookStudyHelper.lambda$openStudyPageImpl$12(taskInfoV2, bookType, z4, bookInfoStudy, bookId, context);
            }
        });
    }

    static /* synthetic */ void lambda$openStudyPageImpl$12(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, int i, boolean z, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, java.lang.String str, final android.content.Context context) throws java.lang.Exception {
        java.lang.String jobId = taskInfoV2.getJobId();
        com.up366.mobile.book.model.StudyTaskJsonMapInfo studyTaskJsonMapInfo = (com.up366.mobile.book.model.StudyTaskJsonMapInfo) com.up366.mobile.common.logic.Auth.cur().db1().findOne(com.up366.mobile.book.model.StudyTaskJsonMapInfo_.jobId, jobId);
        if (studyTaskJsonMapInfo == null) {
            studyTaskJsonMapInfo = new com.up366.mobile.book.model.StudyTaskJsonMapInfo(jobId, com.alibaba.fastjson.JSON.toJSONString(taskInfoV2));
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(studyTaskJsonMapInfo.json);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (i == 2) {
            jSONObject.put("scenario", "_SCHOOL_BOOK_PRACTICE_");
        } else {
            jSONObject.put("scenario", "_STANDARD_BOOK_PRACTICE_");
        }
        jSONObject.put("studyTaskDetail", object);
        jSONObject.put("retest", java.lang.Boolean.valueOf(z));
        jSONObject.put("bookType", java.lang.Integer.valueOf(i));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
        jSONObject.put("fromHistory", java.lang.Boolean.valueOf(taskInfoV2.isHistory()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.onStart(str, taskInfoV2.getContentId());
        final android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("book", bookInfoStudy);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskOpenBookStudyHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() {
                context.startActivity(intent);
            }
        });
    }
}
