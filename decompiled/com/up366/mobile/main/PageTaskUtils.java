package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageTaskUtils {
    private static final int LEVEL_ACCOUNT = -1;
    private static final int LEVEL_COMMENT = 2;
    private static final int LEVEL_GUIDE = 3;
    private static final int LEVEL_NET = 5;
    private static final int LEVEL_RESOURCE = 4;
    private static final int LEVEL_SAFE = 1;
    private static final int LEVEL_SAFE_PASSWORD = 1;
    private static final int LEVEL_SAFE_PHONE = 0;
    private static final int LEVEL_STUDY_CARD = 6;
    public static final java.lang.String NAME_ACCOUNT_NOTIFY = "个人注册通知";
    public static final java.lang.String NAME_GUIDE = "引导图";
    public static final java.lang.String NAME_MESSAGE_DIALOG = "产品消息提示框";
    public static final java.lang.String NAME_NET_ERROR = "网络错误";
    public static final java.lang.String NAME_RESOURCE = "资源升级";
    public static final java.lang.String NAME_STUDY_CARD = "学习卡弹框";
    private static volatile boolean isAddingStudyCard;

    public static void addCommentTask(com.up366.organize.inter.PageTaskRunListener pageTaskRunListener) {
        com.up366.organize.PageTask pageTaskCreateTask = com.up366.organize.PageTaskManager.getBuilder().createTask(NAME_MESSAGE_DIALOG, 2);
        com.up366.organize.PageTaskManager.getInst().addTask(pageTaskCreateTask).addPageTaskRunListener(pageTaskCreateTask.getTaskId(), pageTaskRunListener);
    }

    public static void addAccountNotifyTask(com.up366.organize.inter.PageTaskRunListener pageTaskRunListener) {
        com.up366.organize.PageTask pageTaskCreateTask = com.up366.organize.PageTaskManager.getBuilder().createTask(NAME_ACCOUNT_NOTIFY, -1);
        com.up366.organize.PageTaskManager.getInst().addTask(pageTaskCreateTask).addPageTaskRunListener(pageTaskCreateTask.getTaskId(), pageTaskRunListener);
    }

    public static void addNetworkErrorTipTask(final com.up366.organize.inter.PageTaskRunListener pageTaskRunListener) {
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().setHasShow(true);
        com.up366.organize.PageTaskManager.getInst().cancel(NAME_GUIDE);
        com.up366.organize.PageTaskManager.getInst().cancel(NAME_MESSAGE_DIALOG);
        com.up366.organize.PageTaskManager.getInst().cancel(NAME_ACCOUNT_NOTIFY);
        com.up366.organize.PageTaskManager.getInst().cancel(NAME_RESOURCE);
        com.up366.organize.PageTaskManager.getInst().cancel(NAME_STUDY_CARD);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.ClearPageTaskEvent());
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.main.PageTaskUtils$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.main.PageTaskUtils.lambda$addNetworkErrorTipTask$0(pageTaskRunListener);
            }
        });
    }

    static /* synthetic */ void lambda$addNetworkErrorTipTask$0(com.up366.organize.inter.PageTaskRunListener pageTaskRunListener) throws java.lang.Exception {
        com.up366.organize.PageTask pageTaskCreateTask = com.up366.organize.PageTaskManager.getBuilder().createTask(NAME_NET_ERROR, 5);
        com.up366.organize.PageTaskManager.getInst().addTask(pageTaskCreateTask).addPageTaskRunListener(pageTaskCreateTask.getTaskId(), pageTaskRunListener);
        com.up366.organize.PageTaskManager.getInst().ready(NAME_NET_ERROR);
    }

    public static void addShowDialogTask() {
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            addResourceTask();
            if (!com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
                addGuideTask();
            }
            addStudyCardTask();
        }
    }

    private static void addGuideTask() {
        if (com.up366.mobile.common.helper.GuideDialogHelper.getInst().isHasShow()) {
            return;
        }
        com.up366.organize.PageTask pageTaskCreateTask = com.up366.organize.PageTaskManager.getBuilder().createTask(NAME_GUIDE, 3);
        com.up366.organize.PageTaskManager.getInst().addTask(pageTaskCreateTask).addPageTaskRunListener(pageTaskCreateTask.getTaskId(), new com.up366.organize.inter.PageTaskRunListener() { // from class: com.up366.mobile.main.PageTaskUtils$$ExternalSyntheticLambda3
            @Override // com.up366.organize.inter.PageTaskRunListener
            public final void onWaitRunning() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().showTip();
            }
        });
    }

    private static void addResourceTask() {
        com.up366.organize.PageTaskManager.getInst().addTask(com.up366.organize.PageTaskManager.getBuilder().createTask(NAME_RESOURCE, 4));
    }

    public static void addStudyCardTask() {
        if (isAddingStudyCard) {
            return;
        }
        isAddingStudyCard = true;
        if (!com.up366.mobile.common.helper.UserFunAccreditHelper.INSTANCE.canUseFun(com.up366.mobile.common.helper.UserFunAccreditHelper.STUDY_CARD)) {
            isAddingStudyCard = false;
        } else {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.PageTaskUtils$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.main.PageTaskUtils.lambda$addStudyCardTask$2();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$addStudyCardTask$2() throws java.lang.Exception {
        try {
            com.up366.common.http.NetHolder netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.STUDY_CARD_REMIND));
            addStudyCard((java.lang.String) netHolderPostSync.info);
            isAddingStudyCard = false;
            com.up366.common.log.Logger.info("TAG - AppConfigMgr - fetchStudyCardRemind - " + netHolderPostSync.resp.toString());
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - AppConfigMgr - fetchStudyCardRemind - error " + e.getMessage());
        }
    }

    private static void addStudyCard(java.lang.String str) {
        if (str == null) {
            com.up366.common.log.Logger.info("TAG - PageTaskUtils - addStudyCardTask - 学习卡弹框数据为空，取消学习卡弹框展示");
            return;
        }
        com.up366.organize.PageTaskManager.getInst().reset(NAME_STUDY_CARD);
        final com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        com.up366.common.log.Logger.info("TAG - PageTaskUtils - addStudyCardTask - 添加学习卡弹框任务");
        com.up366.organize.PageTask pageTaskCreateTask = com.up366.organize.PageTaskManager.getBuilder().createTask(NAME_STUDY_CARD, 6);
        com.up366.organize.PageTaskManager.getInst().addTask(pageTaskCreateTask).addPageTaskRunListener(pageTaskCreateTask.getTaskId(), new com.up366.organize.inter.PageTaskRunListener() { // from class: com.up366.mobile.main.PageTaskUtils$$ExternalSyntheticLambda1
            @Override // com.up366.organize.inter.PageTaskRunListener
            public final void onWaitRunning() {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.PageTaskUtils$$ExternalSyntheticLambda2
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.main.PageTaskUtils.lambda$addStudyCard$4(jSONObject);
                    }
                });
            }
        });
        com.up366.organize.PageTaskManager.getInst().ready(NAME_STUDY_CARD);
    }

    static /* synthetic */ void lambda$addStudyCard$4(com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Exception {
        com.up366.organize.PageTaskManager.getInst().startRun(NAME_STUDY_CARD);
        android.app.Activity currentActivity = com.up366.common.global.GB.get().getCurrentActivity();
        if (!(currentActivity instanceof com.up366.mobile.main.MainActivity)) {
            com.up366.common.log.Logger.info("TAG - PageTaskUtils - addStudyCardTask - 当前页面非MainActivity，取消学习卡弹框展示");
            com.up366.organize.PageTaskManager.getInst().finished(NAME_STUDY_CARD);
            return;
        }
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString("last_fetch_study_card_remind_time" + com.up366.mobile.common.logic.Auth.UID(), "");
        java.lang.String time = com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd");
        if (string.equals(time)) {
            com.up366.organize.PageTaskManager.getInst().finished(NAME_STUDY_CARD);
            return;
        }
        com.up366.mobile.common.utils.PreferenceUtils.putString("last_fetch_study_card_remind_time" + com.up366.mobile.common.logic.Auth.UID(), time);
        com.up366.mobile.main.StudyCardDialog.showStudyCardDialog(currentActivity, jSONObject, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.main.PageTaskUtils$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                com.up366.organize.PageTaskManager.getInst().finished(com.up366.mobile.main.PageTaskUtils.NAME_STUDY_CARD);
            }
        });
    }
}
