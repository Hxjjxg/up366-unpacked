package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DialogTip {
    public static void showDialog(java.lang.String str) {
        showDialog(com.up366.common.global.GB.get().getCurrentActivity().getResources().getString(com.up366.mobile.R.string.tip_common_tip), str);
    }

    public static void showDialog(java.lang.String str, java.lang.String str2) {
        showDialog(str, str2, 2000L);
    }

    public static void showDialog(java.lang.String str, java.lang.String str2, long j) {
        final com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(com.up366.common.global.GB.get().getCurrentActivity());
        baseDialog.defaultCreate().setText(com.up366.mobile.R.id.dialog_common_msg, str2).setText(com.up366.mobile.R.id.dialog_common_title, str).setVisible(new int[]{com.up366.mobile.R.id.dialog_btn_layout, com.up366.mobile.R.id.dialog_msg_btn_line}, 8).showIfNot();
        com.up366.common.task.TaskUtils.postMainTaskDelay(j, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.DialogTip.1
            @Override // com.up366.common.task.Task
            public void run() {
                if (baseDialog.isShowing()) {
                    baseDialog.dismiss();
                }
            }
        });
    }
}
