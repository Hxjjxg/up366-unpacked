package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PersonCommentDialog {
    private static final java.lang.String TAG = "PersonCommentDialog";
    private static long newMessageCache;

    public static void handleCommentMessage(java.util.List<com.up366.mobile.common.logic.model.Messages> list) {
        long sendTime = newMessageCache;
        if (sendTime == 0) {
            sendTime = getNeedShowLastMessage().getSendTime();
        }
        newMessageCache = sendTime;
        final com.up366.mobile.common.logic.model.Messages messages = null;
        for (com.up366.mobile.common.logic.model.Messages messages2 : list) {
            if (newMessageCache < messages2.getSendTime() && messages2.getExt().isNeedShow()) {
                newMessageCache = messages2.getSendTime();
                messages = messages2;
            }
        }
        if (messages == null || com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return;
        }
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_NOTICE).run(new java.lang.Runnable() { // from class: com.up366.mobile.common.dialog.PersonCommentDialog$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.dialog.PersonCommentDialog.showDialog(messages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showDialog(final com.up366.mobile.common.logic.model.Messages messages) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.PersonCommentDialog$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.dialog.PersonCommentDialog.lambda$showDialog$2(messages);
            }
        });
    }

    static /* synthetic */ void lambda$showDialog$2(final com.up366.mobile.common.logic.model.Messages messages) throws java.lang.Exception {
        com.up366.mobile.main.PageTaskUtils.addCommentTask(new com.up366.organize.inter.PageTaskRunListener() { // from class: com.up366.mobile.common.dialog.PersonCommentDialog$$ExternalSyntheticLambda0
            @Override // com.up366.organize.inter.PageTaskRunListener
            public final void onWaitRunning() {
                com.up366.mobile.common.dialog.PersonCommentDialog.lambda$showDialog$1(messages);
            }
        });
        com.up366.organize.PageTaskManager.getInst().ready(com.up366.mobile.main.PageTaskUtils.NAME_MESSAGE_DIALOG);
    }

    static /* synthetic */ void lambda$showDialog$1(com.up366.mobile.common.logic.model.Messages messages) {
        if (com.up366.common.global.GB.get().getCurrentActivity() instanceof com.up366.mobile.main.MainActivity) {
            show(com.up366.common.global.GB.get().getCurrentActivity(), messages);
        }
    }

    private static void show(final android.app.Activity activity, final com.up366.mobile.common.logic.model.Messages messages) {
        com.up366.organize.PageTaskManager.getInst().startRun(com.up366.mobile.main.PageTaskUtils.NAME_MESSAGE_DIALOG);
        if (com.up366.common.task.TaskUtils.isMainThread()) {
            showDialog(activity, messages);
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.PersonCommentDialog$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.dialog.PersonCommentDialog.showDialog(activity, messages);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showDialog(final android.app.Activity activity, final com.up366.mobile.common.logic.model.Messages messages) {
        com.up366.mobile.common.dialog.AppDialog.create(activity).headImage(com.up366.mobile.R.drawable.icon_head_photo_default).title(java.lang.String.format("%s，快去查看", messages.getSubject())).btnBig("立即查看", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.PersonCommentDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                android.app.Activity activity2 = activity;
                activity2.startActivity(new android.content.Intent(activity2, (java.lang.Class<?>) com.up366.mobile.user.message.UserMessageActivity.class));
            }
        }).setCancelable(false).setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.dialog.PersonCommentDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                com.up366.mobile.common.dialog.PersonCommentDialog.lambda$showDialog$5(messages, dialogInterface);
            }
        }).show();
    }

    static /* synthetic */ void lambda$showDialog$5(com.up366.mobile.common.logic.model.Messages messages, android.content.DialogInterface dialogInterface) {
        saveNeedShowMessage(messages);
        com.up366.organize.PageTaskManager.getInst().finished(com.up366.mobile.main.PageTaskUtils.NAME_MESSAGE_DIALOG);
    }

    private static void saveNeedShowMessage(com.up366.mobile.common.logic.model.Messages messages) {
        com.up366.mobile.common.utils.PreferenceUtils.putString(com.up366.mobile.common.logic.Auth.UID() + TAG, com.alibaba.fastjson.JSON.toJSONString(messages));
    }

    private static com.up366.mobile.common.logic.model.Messages getNeedShowLastMessage() {
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString(com.up366.mobile.common.logic.Auth.UID() + TAG, com.up366.common.NetworkUtilsUp.TYPE_NO);
        if (com.up366.common.NetworkUtilsUp.TYPE_NO.equals(string)) {
            return new com.up366.mobile.common.logic.model.Messages();
        }
        return (com.up366.mobile.common.logic.model.Messages) com.alibaba.fastjson.JSON.parseObject(string, com.up366.mobile.common.logic.model.Messages.class);
    }
}
