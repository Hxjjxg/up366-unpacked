package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DialogOkCancleV2 {
    private com.up366.mobile.common.dialog.BaseDialog dialog;

    public DialogOkCancleV2(android.content.Context context) {
        this.dialog = new com.up366.mobile.common.dialog.BaseDialog(context).defaultCreate();
    }

    public static com.up366.mobile.common.dialog.DialogOkCancleV2 create(android.content.Context context) {
        return new com.up366.mobile.common.dialog.DialogOkCancleV2(context);
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 show() {
        this.dialog.showIfNot();
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 dismiss() {
        this.dialog.dismiss();
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 title(java.lang.String str) {
        this.dialog.setText(com.up366.mobile.R.id.dialog_common_title, str);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 message(java.lang.CharSequence charSequence) {
        this.dialog.setText(com.up366.mobile.R.id.dialog_common_msg, charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 ok(java.lang.String str) {
        ok(str, null);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 cancle(java.lang.String str) {
        cancle(str, null);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 ok(final android.view.View.OnClickListener onClickListener) {
        this.dialog.getView(com.up366.mobile.R.id.dialog_common_confirm).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogOkCancleV2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$ok$1(onClickListener, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ok$0() throws java.lang.Exception {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ok$1(android.view.View.OnClickListener onClickListener, android.view.View view) {
        com.up366.common.task.TaskUtils.postMainTaskDelay(80L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.DialogOkCancleV2$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$ok$0();
            }
        });
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 cancle(final android.view.View.OnClickListener onClickListener) {
        this.dialog.getView(com.up366.mobile.R.id.dialog_common_cancel).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogOkCancleV2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$cancle$2(onClickListener, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancle$2(android.view.View.OnClickListener onClickListener, android.view.View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this.dialog.dismiss();
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 ok(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.dialog.setText(com.up366.mobile.R.id.dialog_common_confirm, str);
        ok(onClickListener);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 ok(java.lang.String str, int i, android.view.View.OnClickListener onClickListener) {
        android.widget.TextView textView = (android.widget.TextView) this.dialog.getView(com.up366.mobile.R.id.dialog_common_confirm);
        textView.setText(str);
        textView.setTextColor(i);
        ok(onClickListener);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 cancle(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.dialog.setText(com.up366.mobile.R.id.dialog_common_cancel, str);
        cancle(onClickListener);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 cancle(java.lang.String str, int i, android.view.View.OnClickListener onClickListener) {
        android.widget.TextView textView = (android.widget.TextView) this.dialog.getView(com.up366.mobile.R.id.dialog_common_cancel);
        textView.setText(str);
        textView.setTextColor(i);
        cancle(onClickListener);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 hideCancel() {
        android.widget.TextView textView = (android.widget.TextView) this.dialog.getView(com.up366.mobile.R.id.dialog_common_cancel);
        android.view.View view = this.dialog.getView(com.up366.mobile.R.id.btn_hor_spilt);
        textView.setVisibility(8);
        view.setVisibility(8);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 hideConfirm() {
        android.widget.TextView textView = (android.widget.TextView) this.dialog.getView(com.up366.mobile.R.id.dialog_common_confirm);
        android.view.View view = this.dialog.getView(com.up366.mobile.R.id.btn_hor_spilt);
        textView.setVisibility(8);
        view.setVisibility(8);
        return this;
    }

    public boolean isShowing() {
        return this.dialog.isShowing();
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 onBackPress(com.up366.mobile.common.dialog.BaseDialog.BackPressedListener backPressedListener) {
        this.dialog.setBackListener(backPressedListener);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 setCancelable(boolean z) {
        this.dialog.setCancelable(z);
        return this;
    }

    public com.up366.mobile.common.dialog.DialogOkCancleV2 setCanceledOnTouchOutside(boolean z) {
        this.dialog.setCanceledOnTouchOutside(z);
        return this;
    }
}
