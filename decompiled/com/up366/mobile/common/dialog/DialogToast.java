package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DialogToast {
    private static com.up366.mobile.common.dialog.DialogToast dialogToast = new com.up366.mobile.common.dialog.DialogToast();
    private com.up366.mobile.common.dialog.BaseDialog dialog;

    private DialogToast() {
    }

    public static com.up366.mobile.common.dialog.DialogToast getInst() {
        return dialogToast;
    }

    public void showDialog(java.lang.String str) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = this.dialog;
        if (baseDialog != null && baseDialog.isShowing()) {
            this.dialog.dismiss();
        }
        com.up366.mobile.common.dialog.BaseDialog baseDialog2 = new com.up366.mobile.common.dialog.BaseDialog(com.up366.common.global.GB.get().getCurrentActivity());
        this.dialog = baseDialog2;
        baseDialog2.create(com.up366.mobile.R.layout.dialog_toast_layout).setText(com.up366.mobile.R.id.dialog_common_msg, str).showIfNot();
        this.dialog.setCanceledOnTouchOutside(false);
        android.view.Window window = this.dialog.getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = 8;
            window.setAttributes(attributes);
            window.setDimAmount(0.0f);
            window.setGravity(80);
        }
        com.up366.common.task.TaskUtils.postLazyTaskMain("DialogToast", 2000, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.DialogToast$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showDialog$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$0() throws java.lang.Exception {
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }
}
