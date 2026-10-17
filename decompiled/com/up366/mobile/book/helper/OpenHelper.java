package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OpenHelper {
    public static void openTaskList(android.content.Context context, com.alibaba.fastjson.JSONObject jSONObject) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) context, com.up366.mobile.R.string.tip_tourist);
        } else if (jSONObject == null) {
            com.up366.mobile.course.task.TaskActivity.startTaskActivity(context);
        } else {
            com.up366.mobile.course.task.TaskActivity.startTaskActivityByBookId(context, jSONObject.getInteger(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID).intValue(), jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID));
        }
    }

    public static void openNetHelp(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.LookHelpActivity.class));
    }

    public static void openWordNote(com.up366.mobile.book.StudyActivityInterface studyActivityInterface) {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = studyActivityInterface.getBookInfoStudy();
        final android.app.Activity context = studyActivityInterface.m1148getContext();
        final android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        intent.putExtra("bookName", bookInfoStudy.getBookName());
        intent.putExtra("type", 2);
        intent.putExtra("fromType", 0);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WORDS).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.OpenHelper$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                context.startActivity(intent);
            }
        });
    }

    public static void openWordNote(final android.content.Context context, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        final android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        intent.putExtra("bookName", bookInfoStudy.getBookName());
        intent.putExtra("type", 2);
        intent.putExtra("fromType", 0);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WORDS).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.OpenHelper$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                context.startActivity(intent);
            }
        });
    }

    public static void openPersonalReport(android.content.Context context, com.alibaba.fastjson.JSONObject jSONObject) {
        java.lang.String string = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        java.lang.String string2 = jSONObject.getString("bookName");
        java.lang.String string3 = jSONObject.getString("jobId");
        int iIntValue = jSONObject.getInteger(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID).intValue();
        int iIntValue2 = jSONObject.getInteger("stageId").intValue();
        int iIntValue3 = jSONObject.getInteger("subjectId").intValue();
        com.up366.common.log.Logger.info("TAG - V7ExerciseOpenHelper - openPersonalReport - bookId:" + string + ";bookName:" + string2 + ";jobId" + string3 + ";courseId" + iIntValue + ";stageId" + iIntValue2 + ";subjectId" + iIntValue3);
        com.up366.mobile.course.task.TaskJumpHelper.jumpToTaskReport(context, string, string2, string3, iIntValue, iIntValue2, iIntValue3);
    }

    public static void reboot(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.SplashActivity.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static void quit(android.content.Context context) {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static void sendIMMessage(com.alibaba.fastjson.JSONObject jSONObject) {
        com.up366.common.log.Logger.info("TAG - OpenHelper - sendIMMessage - detail:" + jSONObject.toJSONString());
    }

    public static void openAccountSafe(android.app.Activity activity) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, com.up366.mobile.R.string.tip_tourist);
        } else if (com.up366.mobile.common.logic.Auth.getUserInfo().isBackUpPassword()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "临时密码无法操作~");
        } else {
            com.up366.mobile.user.account.update.AccountUpdateActivity.openPage(activity, 0);
        }
    }

    public static void openBindParent(android.app.Activity activity) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, com.up366.mobile.R.string.tip_tourist);
        } else {
            com.up366.common.global.GB.get().getCurrentActivity().startActivity(new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.me.bindingparent.MeBindingParentActivity.class));
        }
    }

    public static void openScanPaper(final android.app.Activity activity, final com.alibaba.fastjson.JSONObject jSONObject) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, com.up366.mobile.R.string.tip_tourist);
            return;
        }
        final java.lang.String string = jSONObject.getString("scenario");
        if (jSONObject.containsKey("fromHistory")) {
            boolean booleanValue = jSONObject.getBooleanValue("fromHistory");
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(jSONObject.toJSONString(), com.up366.mobile.course.task.TaskInfoV2.class);
            taskInfoV2.setFinish(booleanValue);
            skipScanPaper(activity, taskInfoV2, string);
            return;
        }
        final java.lang.String string2 = jSONObject.getString("xotParam");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.OpenHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.OpenHelper.lambda$openScanPaper$3(jSONObject, string2, activity, string);
            }
        });
    }

    static /* synthetic */ void lambda$openScanPaper$3(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, final android.app.Activity activity, java.lang.String str2) throws java.lang.Exception {
        try {
            int iIntValue = jSONObject.containsKey("jobType") ? jSONObject.getInteger("jobType").intValue() : 0;
            java.lang.String string = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(jSONObject.toJSONString(), com.up366.mobile.course.task.TaskInfoV2.class);
            taskInfoV2.setType(iIntValue);
            taskInfoV2.getExtParam().setXotParam(str);
            taskInfoV2.getExtParam().setBookId(string);
            skipScanPaper(activity, taskInfoV2, str2);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - OpenHelper - openScanPaper - error:" + e.getMessage());
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.OpenHelper$$ExternalSyntheticLambda7
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "打开失败，未找到练习信息");
                }
            });
        }
    }

    private static void skipScanPaper(final android.app.Activity activity, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.OpenHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() {
                android.app.Activity activity2 = activity;
                com.up366.mobile.common.utils.PermissionUtils.checkPermission(activity2, new java.lang.String[]{"相机权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, com.up366.mobile.common.utils.ViewUtil.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.OpenHelper$$ExternalSyntheticLambda0
                    @Override // com.up366.common.callback.ICallbackCodeInfo
                    public final void onResult(int i, java.lang.String str2) {
                        com.up366.mobile.book.helper.OpenHelper.lambda$skipScanPaper$4(activity2, taskInfoV2, str, i, str2);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$skipScanPaper$4(android.app.Activity activity, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, java.lang.String str, int i, java.lang.String str2) {
        if (i == 0) {
            if (str == null) {
                str = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.FROM_TYPE_TASK_INFO;
            }
            com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.openPage(activity, taskInfoV2, str);
        }
    }

    public static void openUserInfoPage(android.app.Activity activity) {
        com.up366.mobile.me.userinfo.MeUserInfoActivity.openPage(activity);
    }

    public static void openAppSystemSettings(android.app.Activity activity) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(android.net.Uri.parse("package:" + activity.getPackageName()));
            activity.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("跳转失败，请手动设置");
            com.up366.common.log.Logger.error("openAppSystemSettings", e);
        }
    }

    public static void openFeedBack(android.app.Activity activity, com.alibaba.fastjson.JSONObject jSONObject) {
        com.up366.mobile.me.feedback.FeedbackActivity.openPage(activity, jSONObject.containsKey("type") ? jSONObject.getIntValue("type") : 1);
    }

    public static void openScanPaperV2(final android.app.Activity activity, com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, com.up366.mobile.R.string.tip_tourist);
            return;
        }
        java.lang.String string = jSONObject.getString("paperId");
        java.lang.String string2 = jSONObject.getString("jobName");
        final com.up366.mobile.course.photoanswer.model.ScanPaperModel scanPaperModel = new com.up366.mobile.course.photoanswer.model.ScanPaperModel();
        scanPaperModel.setPaperId(string);
        scanPaperModel.setJobName(string2);
        scanPaperModel.setFromType(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.FROM_TYPE_SCAN_PAPER_GENERAL);
        scanPaperModel.setCurWebViewId(str);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.OpenHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() {
                android.app.Activity activity2 = activity;
                com.up366.mobile.common.utils.PermissionUtils.checkPermission(activity2, new java.lang.String[]{"相机权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, com.up366.mobile.common.utils.ViewUtil.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.OpenHelper$$ExternalSyntheticLambda1
                    @Override // com.up366.common.callback.ICallbackCodeInfo
                    public final void onResult(int i, java.lang.String str2) {
                        com.up366.mobile.book.helper.OpenHelper.lambda$openScanPaperV2$6(activity2, scanPaperModel, i, str2);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$openScanPaperV2$6(android.app.Activity activity, com.up366.mobile.course.photoanswer.model.ScanPaperModel scanPaperModel, int i, java.lang.String str) {
        if (i == 0) {
            com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.openPage(activity, scanPaperModel);
        }
    }

    public static void openHelpCenter(android.app.Activity activity, com.alibaba.fastjson.JSONObject jSONObject) {
        com.up366.mobile.me.MeFragment.openHelpCenter(activity);
    }
}
