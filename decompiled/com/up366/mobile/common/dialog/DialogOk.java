package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DialogOk {
    public static void showDialog(java.lang.String str) {
        showDialog(com.up366.common.global.GB.get().getCurrentActivity().getResources().getString(com.up366.mobile.R.string.tip_common_tip), str);
    }

    public static void showDialog(java.lang.String str, java.lang.String str2) {
        showDialog(str, str2, com.up366.common.global.GB.get().getCurrentActivity().getResources().getString(com.up366.mobile.R.string.confirm));
    }

    public static void showDialog(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        showDialog(str, str2, str3, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogOk.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.up366.common.log.Logger.info("点击的确定按钮!");
            }
        });
    }

    public static void showDialog(java.lang.String str, java.lang.String str2, android.view.View.OnClickListener onClickListener) {
        showDialog("提 示", str, str2, onClickListener);
    }

    public static void showDialog(java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, android.view.View.OnClickListener onClickListener) {
        showDialog(str, charSequence, str2, 0, onClickListener, null, true);
    }

    public static void showDialog(android.content.Context context, java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, android.view.View.OnClickListener onClickListener) {
        showDialog(context, str, charSequence, str2, 0, onClickListener, null, true);
    }

    public static void showDialog(java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, android.view.View.OnClickListener onClickListener, boolean z) {
        showDialog(str, charSequence, str2, 0, onClickListener, null, z);
    }

    public static void showDialog(java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, android.view.View.OnClickListener onClickListener, android.content.DialogInterface.OnDismissListener onDismissListener) {
        showDialog(str, charSequence, str2, 0, onClickListener, onDismissListener, true);
    }

    public static void showDialog(java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, int i, android.view.View.OnClickListener onClickListener) {
        showDialog(str, charSequence, str2, i, onClickListener, null, true);
    }

    public static void showDialog(java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, int i, android.view.View.OnClickListener onClickListener, android.content.DialogInterface.OnDismissListener onDismissListener, boolean z) {
        showDialog(com.up366.common.global.GB.get().getCurrentActivity(), str, charSequence, str2, i, onClickListener, onDismissListener, z);
    }

    public static void showDialog(android.content.Context context, java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, int i, android.view.View.OnClickListener onClickListener, android.content.DialogInterface.OnDismissListener onDismissListener, boolean z) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(context);
        baseDialog.defaultCreate().setText(com.up366.mobile.R.id.dialog_common_msg, charSequence).setText(com.up366.mobile.R.id.dialog_common_title, str).setText(com.up366.mobile.R.id.dialog_common_confirm, str2).setVisible(new int[]{com.up366.mobile.R.id.btn_hor_spilt, com.up366.mobile.R.id.dialog_common_cancel}, 8).setOnClickListener(new int[]{com.up366.mobile.R.id.dialog_common_confirm}, onClickListener).setCancelable(z);
        if (i != 0) {
            baseDialog.setTextColor(com.up366.mobile.R.id.dialog_common_confirm, i);
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            baseDialog.findViewById(com.up366.mobile.R.id.dialog_common_title).setVisibility(8);
        }
        baseDialog.setOnDissmissListener(onDismissListener);
        baseDialog.showIfNot();
    }

    public static void showSyncTimeErrorDialog(java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, android.view.View.OnClickListener onClickListener) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(com.up366.common.global.GB.get().getCurrentActivity());
        baseDialog.defaultCreate().setText(com.up366.mobile.R.id.dialog_common_msg, charSequence).setText(com.up366.mobile.R.id.dialog_common_title, str).setText(com.up366.mobile.R.id.dialog_common_confirm, str2).setVisible(new int[]{com.up366.mobile.R.id.btn_hor_spilt, com.up366.mobile.R.id.dialog_common_cancel}, 8).setOnClickListener(new int[]{com.up366.mobile.R.id.dialog_common_confirm}, onClickListener).setCancelable(false);
        baseDialog.setCancelable(false);
        baseDialog.showIfNot();
    }

    public static void showDialogWithAutoDismiss(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        final com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(com.up366.common.global.GB.get().getCurrentActivity());
        baseDialog.defaultCreate().setText(com.up366.mobile.R.id.dialog_common_msg, str2).setText(com.up366.mobile.R.id.dialog_common_title, str).setText(com.up366.mobile.R.id.dialog_common_confirm, str3).setVisible(new int[]{com.up366.mobile.R.id.btn_hor_spilt, com.up366.mobile.R.id.dialog_common_cancel}, 8).setOnClickListener(new int[]{com.up366.mobile.R.id.dialog_common_confirm}, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogOk$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                baseDialog.dismiss();
            }
        }).setCancelable(false);
        baseDialog.showIfNot();
        com.up366.common.task.TaskUtils.postMainTaskDelay(i, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.DialogOk$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                baseDialog.dismiss();
            }
        });
    }
}
