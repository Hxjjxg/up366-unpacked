package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskJumpHelper {
    public static void jumpToDetailTaskPage(final android.content.Context context, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        com.up366.common.log.Logger.info("jumpToDetailTaskPage, " + com.alibaba.fastjson.JSON.toJSONString(taskInfoV2));
        int type = taskInfoV2.getType();
        if (type == 1) {
            jumpToTaoti(context, taskInfoV2);
        } else if (type == 2) {
            jumpToZhuanxiang(context, taskInfoV2);
        } else if (type == 3) {
            com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_HOMEWORK).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskJumpHelper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.course.task.TaskJumpHelper.jumpToHomework(context, taskInfoV2);
                }
            });
        } else if (type == 4) {
            com.up366.mobile.common.helper.PageFunctionCheckHelper.checkFunCheck(com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WRONGNOTE, new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskJumpHelper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.course.task.TaskJumpHelper.jumpToCuotiben(context, taskInfoV2);
                }
            });
        } else if (type == 5) {
            com.up366.mobile.common.helper.PageFunctionCheckHelper.checkFunCheck(com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WORDNOE, new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskJumpHelper$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.course.task.TaskJumpHelper.jumpToShengciben(context, taskInfoV2);
                }
            });
        } else if (type == 8) {
            jumpToRuoXiang(context, taskInfoV2);
        } else if (type == 11) {
            jumpToMokao(context, taskInfoV2);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show("不支持的任务单类型：" + taskInfoV2.getType());
        }
        java.lang.String str = "当前位置：" + taskInfoV2.getJobName() + "\n课程ID：" + taskInfoV2.getCourseId() + "\n";
        if (taskInfoV2.getType() == 1) {
            str = str + "TaskID：" + taskInfoV2.getContentId();
        }
        if (taskInfoV2.getType() == 3) {
            str = str + "TestID：" + taskInfoV2.getContentId();
        }
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("jump-job-study-page-path", str, 60000L);
    }

    public static void jumpToTaskReport(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, int i3) {
        com.up366.mobile.common.onlinelog.OpLog.report("JS打开任务单报告", "jobId:" + str3 + ", bookName:" + str2);
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = new com.up366.mobile.course.task.TaskInfoV2();
        taskInfoV2.setCourseId(i);
        taskInfoV2.setJobId(str3);
        taskInfoV2.setExtParam(new com.up366.mobile.course.task.TaskInfoV2.ExtParam());
        taskInfoV2.getExtParam().setBookId(str);
        taskInfoV2.getExtParam().setBookName(str2);
        taskInfoV2.getExtParam().setStageId(i2);
        taskInfoV2.getExtParam().setSubjectId(i3);
        jumpToTaskReport(context, taskInfoV2);
    }

    public static void jumpToTaskReport(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        if (taskInfoV2.getType() == 3) {
            jumpToHomeworkReport(context, taskInfoV2);
        } else {
            jumpToTaotiReport(context, taskInfoV2);
        }
    }

    private static void jumpToZhuanxiang(final android.content.Context context, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        if (taskInfoV2.getExtParam().getDifficulty() > 0) {
            openSelfStudyPage(context, taskInfoV2, taskInfoV2.getExtParam().getDifficulty());
        } else {
            new com.up366.mobile.common.views.DifficultyLevelDialog(taskInfoV2).show(context, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskJumpHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    com.up366.mobile.course.task.TaskJumpHelper.openSelfStudyPage(context, taskInfoV2, ((java.lang.Integer) obj).intValue());
                }
            });
        }
    }

    public static void openSelfStudyPage(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, int i) {
        openSelfStudyPage(context, taskInfoV2, i, true);
    }

    public static void openSelfStudyPageNoCheck(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, int i) {
        openSelfStudyPage(context, taskInfoV2, i, false);
    }

    public static void openSelfStudyPage(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, int i, boolean z) {
        int courseId = taskInfoV2.getCourseId();
        java.lang.String bookId = taskInfoV2.getExtParam().getBookId();
        int assignId = taskInfoV2.getAssignId();
        if (z && !com.up366.mobile.common.logic.Auth.cur().book().hasBuy(courseId, bookId, true)) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("您还没有该教材的使用权，请联系管理员进行授权");
            return;
        }
        java.lang.String jobId = taskInfoV2.getJobId();
        com.up366.mobile.book.model.StudyTaskJsonMapInfo studyTaskJsonMapInfo = (com.up366.mobile.book.model.StudyTaskJsonMapInfo) com.up366.mobile.common.logic.Auth.cur().db1().findOne(com.up366.mobile.book.model.StudyTaskJsonMapInfo_.jobId, jobId);
        if (studyTaskJsonMapInfo == null) {
            studyTaskJsonMapInfo = new com.up366.mobile.book.model.StudyTaskJsonMapInfo(jobId, com.alibaba.fastjson.JSON.toJSONString(taskInfoV2));
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(studyTaskJsonMapInfo.json);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("stageId", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getStageId()));
        jSONObject.put("subjectId", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getSubjectId()));
        jSONObject.put("knowledgeId", taskInfoV2.getExtParam().getKnowledgeId());
        jSONObject.put("difficulty", java.lang.Integer.valueOf(i));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, taskInfoV2.getExtParam().getBookId());
        jSONObject.put("fromJob", true);
        jSONObject.put("isCurJob", java.lang.Boolean.valueOf(!taskInfoV2.isFinish()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(taskInfoV2.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, taskInfoV2.getJobId());
        if (assignId > 0) {
            jSONObject.put("assignId", java.lang.Integer.valueOf(assignId));
        }
        jSONObject.put("studyTaskDetail", object);
        com.up366.mobile.book.helper.V8OpenHelper.openV8Page(context, "_SELF_STUDY_", jSONObject, taskInfoV2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jumpToShengciben(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        int assignId = taskInfoV2.getAssignId();
        java.lang.String bookId = taskInfoV2.getExtParam().getBookId();
        java.lang.String bookName = taskInfoV2.getExtParam().getBookName();
        if (com.up366.common.StringUtils.isEmptyOrNull(bookId)) {
            bookId = "0";
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(bookName)) {
            bookName = "";
        }
        int i = "0".equals(bookId) ? 1 : 2;
        if (i == 1) {
            com.up366.mobile.common.onlinelog.OpLog.report("TASK-NO-BOOK-ID_shengci", com.alibaba.fastjson.JSON.toJSONString(taskInfoV2));
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookId);
        intent.putExtra("bookName", bookName);
        intent.putExtra("type", i);
        intent.putExtra("fromType", 1);
        intent.putExtra("isCurJob", !taskInfoV2.isFinish());
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, taskInfoV2.getCourseId());
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, taskInfoV2.getJobId());
        if (assignId > 0) {
            intent.putExtra("assignId", assignId);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jumpToCuotiben(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        if (taskInfoV2.getExtParam().getStageId() == 0 || taskInfoV2.getExtParam().getSubjectId() == 0) {
            context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class));
            return;
        }
        int assignId = taskInfoV2.getAssignId();
        java.lang.String bookId = taskInfoV2.getExtParam().getBookId();
        java.lang.String bookName = taskInfoV2.getExtParam().getBookName();
        if (com.up366.common.StringUtils.isEmptyOrNull(bookId)) {
            bookId = "0";
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(bookName)) {
            bookName = "";
        }
        int i = "0".equals(bookId) ? 1 : 2;
        if (i == 1) {
            com.up366.mobile.common.onlinelog.OpLog.report("TASK-NO-BOOK-ID_cuoti", com.alibaba.fastjson.JSON.toJSONString(taskInfoV2));
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookId);
        intent.putExtra("bookName", bookName);
        intent.putExtra("stageId", taskInfoV2.getExtParam().getStageId());
        intent.putExtra("subjectId", taskInfoV2.getExtParam().getSubjectId());
        intent.putExtra("type", i);
        intent.putExtra("fromType", 1);
        intent.putExtra("isCurJob", !taskInfoV2.isFinish());
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, taskInfoV2.getCourseId());
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, taskInfoV2.getJobId());
        if (assignId > 0) {
            intent.putExtra("assignId", assignId);
        }
        context.startActivity(intent);
    }

    private static void jumpToMokao(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.getUserInfo().getUid()));
        jSONObject.put("nodeName", taskInfoV2.getJobName());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, taskInfoV2.getExtParam().getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(taskInfoV2.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, taskInfoV2.getContentId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, taskInfoV2.getJobId());
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.STATISTIC_REPORT);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(taskInfoV2, intent, false, taskInfoV2.isFinish());
        context.startActivity(intent);
    }

    private static void jumpToRuoXiang(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("stageId", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getStageId()));
        jSONObject.put("subjectId", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getSubjectId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, taskInfoV2.getExtParam().getBookId());
        jSONObject.put("fromJob", true);
        jSONObject.put("isCurJob", java.lang.Boolean.valueOf(true ^ taskInfoV2.isFinish()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(taskInfoV2.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, taskInfoV2.getJobId());
        jSONObject.put("type", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getQuestionType()));
        jSONObject.put("difficulty", java.lang.Integer.valueOf(taskInfoV2.getExtParam().getDifficulty()));
        jSONObject.put("studyPlanId", java.lang.Integer.valueOf(taskInfoV2.getStudyPlanId()));
        if (taskInfoV2.getAssignId() > 0) {
            jSONObject.put("assignId", java.lang.Integer.valueOf(taskInfoV2.getAssignId()));
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", "weaktraining");
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(taskInfoV2, intent, false, taskInfoV2.isFinish());
        context.startActivity(intent);
    }

    private static void jumpToTaoti(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        new com.up366.mobile.course.task.TaskOpenBookStudyHelper().open(context, taskInfoV2);
    }

    private static void jumpToTaotiReport(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        new com.up366.mobile.course.task.TaskOpenBookStudyHelper().openTaotiReport(context, taskInfoV2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jumpToHomework(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        com.up366.mobile.course.task.TaskOpenBookStudyHelper.openHomework(context, taskInfoV2);
    }

    private static void jumpToHomeworkReport(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        new com.up366.mobile.course.task.TaskOpenBookStudyHelper().openHomeworkReport(context, taskInfoV2);
    }
}
