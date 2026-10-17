package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountNotifyDialog {
    private static boolean hasShow;

    public static void handleCommentMessage(java.util.List<com.up366.mobile.common.logic.model.Messages> list) {
        com.up366.mobile.common.logic.model.Messages next;
        java.util.Iterator<com.up366.mobile.common.logic.model.Messages> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!next.hasRead() && next.getExt().isUpdateAccountNotice()) {
                break;
            }
        }
        if (next == null) {
            return;
        }
        showDialog(next);
    }

    private static void showDialog(final com.up366.mobile.common.logic.model.Messages messages) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.AccountNotifyDialog$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.dialog.AccountNotifyDialog.lambda$showDialog$1(messages);
            }
        });
    }

    static /* synthetic */ void lambda$showDialog$1(final com.up366.mobile.common.logic.model.Messages messages) throws java.lang.Exception {
        com.up366.mobile.main.PageTaskUtils.addAccountNotifyTask(new com.up366.organize.inter.PageTaskRunListener() { // from class: com.up366.mobile.common.dialog.AccountNotifyDialog$$ExternalSyntheticLambda1
            @Override // com.up366.organize.inter.PageTaskRunListener
            public final void onWaitRunning() {
                com.up366.mobile.common.dialog.AccountNotifyDialog.lambda$showDialog$0(messages);
            }
        });
        com.up366.organize.PageTaskManager.getInst().ready(com.up366.mobile.main.PageTaskUtils.NAME_ACCOUNT_NOTIFY);
    }

    static /* synthetic */ void lambda$showDialog$0(com.up366.mobile.common.logic.model.Messages messages) {
        if (com.up366.common.global.GB.get().getCurrentActivity() instanceof com.up366.mobile.main.MainActivity) {
            show(com.up366.common.global.GB.get().getCurrentActivity(), messages);
        }
    }

    private static void show(final android.app.Activity activity, final com.up366.mobile.common.logic.model.Messages messages) {
        com.up366.organize.PageTaskManager.getInst().startRun(com.up366.mobile.main.PageTaskUtils.NAME_ACCOUNT_NOTIFY);
        if (com.up366.common.task.TaskUtils.isMainThread()) {
            showDialog(activity, messages);
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.AccountNotifyDialog$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.dialog.AccountNotifyDialog.showDialog(activity, messages);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void showDialog(android.app.Activity activity, final com.up366.mobile.common.logic.model.Messages messages) {
        if (hasShow) {
            return;
        }
        hasShow = true;
        final com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(activity);
        android.view.WindowManager.LayoutParams attributes = baseDialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        int i = 0;
        baseDialog.getWindow().getDecorView().setPadding(80, 0, 80, 0);
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(com.up366.mobile.R.layout.dialog_account_notify_layout, (android.view.ViewGroup) null);
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.account_tx);
        android.widget.TextView textView2 = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.realname_tx);
        viewInflate.findViewById(com.up366.mobile.R.id.dialog_common_confirm).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AccountNotifyDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.dialog.AccountNotifyDialog.lambda$showDialog$4(messages, baseDialog, view);
            }
        });
        textView.setText("账号：" + messages.getExt().getUsername() + "（不可修改）");
        textView2.setText("姓名：" + messages.getExt().getRealname() + "（可前往个人资料页修改）");
        if (!com.up366.mobile.common.utils.RealNameUtils.isSystemCreate(messages.getExt().getRealname())) {
            i = 8;
        }
        textView2.setVisibility(i);
        baseDialog.create(viewInflate).setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.dialog.AccountNotifyDialog$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                com.up366.organize.PageTaskManager.getInst().finished(com.up366.mobile.main.PageTaskUtils.NAME_ACCOUNT_NOTIFY);
            }
        }).show();
    }

    static /* synthetic */ void lambda$showDialog$4(final com.up366.mobile.common.logic.model.Messages messages, com.up366.mobile.common.dialog.BaseDialog baseDialog, android.view.View view) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.AccountNotifyDialog$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.dialog.AccountNotifyDialog.lambda$showDialog$3(messages);
            }
        });
        baseDialog.dismiss();
    }

    static /* synthetic */ void lambda$showDialog$3(com.up366.mobile.common.logic.model.Messages messages) throws java.lang.Exception {
        messages.setReadFlag(1);
        com.up366.mobile.common.logic.Auth.cur().info().updateMessage(messages);
    }
}
