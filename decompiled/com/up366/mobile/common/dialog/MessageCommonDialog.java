package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MessageCommonDialog {
    public static void handleCommentMessage(java.util.List<com.up366.mobile.common.logic.model.Messages> list) {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return;
        }
        long sendTime = com.up366.mobile.common.utils.PreferenceUtils.getLong(com.up366.mobile.common.logic.Auth.UID() + "lastMessageTime", 0L);
        final com.up366.mobile.common.logic.model.Messages messages = null;
        for (com.up366.mobile.common.logic.model.Messages messages2 : list) {
            if (messages2.getSendTime() > sendTime && !messages2.hasRead() && "product".equals(getDataFromExtend(messages2, "type"))) {
                sendTime = messages2.getSendTime();
                messages = messages2;
            }
        }
        if (messages == null) {
            return;
        }
        com.up366.mobile.common.utils.PreferenceUtils.putLong(com.up366.mobile.common.logic.Auth.UID() + "lastMessageTime", messages.getSendTime());
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_NOTICE).run(new java.lang.Runnable() { // from class: com.up366.mobile.common.dialog.MessageCommonDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.MessageCommonDialog$$ExternalSyntheticLambda5
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.common.dialog.MessageCommonDialog.lambda$handleCommentMessage$2(messages);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$handleCommentMessage$2(final com.up366.mobile.common.logic.model.Messages messages) throws java.lang.Exception {
        com.up366.mobile.main.PageTaskUtils.addCommentTask(new com.up366.organize.inter.PageTaskRunListener() { // from class: com.up366.mobile.common.dialog.MessageCommonDialog$$ExternalSyntheticLambda1
            @Override // com.up366.organize.inter.PageTaskRunListener
            public final void onWaitRunning() {
                com.up366.mobile.common.dialog.MessageCommonDialog.lambda$handleCommentMessage$1(messages);
            }
        });
        com.up366.organize.PageTaskManager.getInst().ready(com.up366.mobile.main.PageTaskUtils.NAME_MESSAGE_DIALOG);
    }

    static /* synthetic */ void lambda$handleCommentMessage$1(final com.up366.mobile.common.logic.model.Messages messages) {
        if (com.up366.common.global.GB.get().getCurrentActivity() instanceof com.up366.mobile.main.MainActivity) {
            com.up366.organize.PageTaskManager.getInst().startRun(com.up366.mobile.main.PageTaskUtils.NAME_MESSAGE_DIALOG);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.MessageCommonDialog$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.dialog.MessageCommonDialog.showDialog(messages);
                }
            });
        }
    }

    public static void showDialog(final com.up366.mobile.common.logic.model.Messages messages) {
        float f;
        android.view.View viewInflate = android.view.LayoutInflater.from(com.up366.common.global.GB.get().getCurrentActivity()).inflate(com.up366.mobile.R.layout.dialog_message_main_layout, (android.view.ViewGroup) null);
        final androidx.appcompat.app.AlertDialog alertDialogCreate = new androidx.appcompat.app.AlertDialog.Builder(com.up366.common.global.GB.get().getCurrentActivity(), 2132017829).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable());
        }
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.message_title);
        android.widget.TextView textView2 = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.message_subject);
        android.widget.TextView textView3 = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.message_content);
        android.widget.ImageView imageView = (android.widget.ImageView) viewInflate.findViewById(com.up366.mobile.R.id.message_img);
        final android.widget.TextView textView4 = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.message_btn);
        android.widget.TextView textView5 = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.message_more);
        ((android.widget.ImageView) viewInflate.findViewById(com.up366.mobile.R.id.message_close)).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.MessageCommonDialog$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                alertDialogCreate.dismiss();
            }
        });
        textView4.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.MessageCommonDialog$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.dialog.MessageCommonDialog.lambda$showDialog$7(messages, alertDialogCreate, textView4, view);
            }
        });
        addContent(textView, getDataFromExtend(messages, "title"));
        addContent(textView2, getDataFromExtend(messages, "subject"));
        addContent(textView3, getDataFromExtend(messages, com.igexin.sdk.FlymePushReceiver.CONTENT));
        addContent(textView4, getDataFromExtend(messages, "btnName"));
        addContent(textView5, getDataFromExtend(messages, "desc"));
        java.lang.String dataFromExtend = getDataFromExtend(messages, "imgUrl");
        if (!com.up366.common.StringUtils.isEmptyOrNull(dataFromExtend)) {
            imageView.setVisibility(0);
            com.up366.common.BitmapUtilsUp.display(imageView, dataFromExtend);
        } else {
            imageView.setVisibility(8);
        }
        alertDialogCreate.setView(viewInflate);
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
        android.view.Window window = alertDialogCreate.getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            android.util.DisplayMetrics displayMetrics = viewInflate.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels / displayMetrics.density >= 600.0f) {
                f = displayMetrics.density * 600.0f;
            } else {
                f = displayMetrics.widthPixels * 0.85f;
            }
            attributes.width = (int) f;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    static /* synthetic */ void lambda$showDialog$7(final com.up366.mobile.common.logic.model.Messages messages, androidx.appcompat.app.AlertDialog alertDialog, android.widget.TextView textView, android.view.View view) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.MessageCommonDialog$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.dialog.MessageCommonDialog.lambda$showDialog$5(messages);
            }
        });
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.MessageCommonDialog$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.logic.Auth.cur().info().loadMessageList();
            }
        });
        java.lang.String dataFromExtend = getDataFromExtend(messages, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        if (com.up366.common.StringUtils.isEmptyOrNull(dataFromExtend)) {
            alertDialog.dismiss();
            return;
        }
        java.lang.String dataFromExtend2 = getDataFromExtend(messages, "bookName");
        java.lang.String dataFromExtend3 = getDataFromExtend(messages, "bookType");
        java.lang.String dataFromExtend4 = getDataFromExtend(messages, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
        textView.setVisibility("true".equals(getDataFromExtend(messages, "isSkip")) ? 0 : 8);
        try {
            com.up366.mobile.common.utils.UrgeSkipUtils.skipByDialog(dataFromExtend, dataFromExtend2, java.lang.Integer.parseInt(dataFromExtend3), dataFromExtend4);
            alertDialog.dismiss();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("bookTypeInt error " + e.getMessage());
            alertDialog.dismiss();
        }
    }

    static /* synthetic */ void lambda$showDialog$5(com.up366.mobile.common.logic.model.Messages messages) throws java.lang.Exception {
        messages.setReadFlag(1);
        com.up366.mobile.common.logic.Auth.cur().info().updateMessage(messages);
    }

    private static void addContent(android.widget.TextView textView, java.lang.String str) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
            textView.setText(str);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    private static java.lang.String getDataFromExtend(com.up366.mobile.common.logic.model.Messages messages, java.lang.String str) {
        java.lang.String extend = messages.getExtend();
        if (extend == null || extend.length() == 0) {
            return null;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(extend);
            if (object.containsKey(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID) && com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID.equals(str)) {
                return object.getIntValue(str) + "";
            }
            if (object.containsKey("isSkip") && "isSkip".equals(str)) {
                return object.getBooleanValue(str) + "";
            }
            return object.getString(str);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getDataFromExtend error " + e.getMessage());
            return "";
        }
    }
}
