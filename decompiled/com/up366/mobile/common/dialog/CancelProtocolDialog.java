package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CancelProtocolDialog {
    private final java.util.Timer timer = new java.util.Timer();
    private int start = 0;

    public void show(android.content.Context context, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        final com.up366.mobile.common.dialog.BaseDialog baseDialogCreate = new com.up366.mobile.common.dialog.BaseDialog(context, com.up366.mobile.R.style.LargeDialog).create(com.up366.mobile.R.layout.dialog_cancel_layout);
        baseDialogCreate.setCancelable(false);
        baseDialogCreate.setCanceledOnTouchOutside(false);
        android.widget.TextView textView = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.ok);
        android.widget.TextView textView2 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.quit);
        ((android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.content_text)).setText(android.text.Html.fromHtml(context.getResources().getString(com.up366.mobile.R.string.cancel_dialog_text_1)));
        android.view.WindowManager.LayoutParams attributes = baseDialogCreate.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        baseDialogCreate.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        this.timer.schedule(new com.up366.mobile.common.dialog.CancelProtocolDialog.AnonymousClass1(textView), 1000L, 1000L);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.CancelProtocolDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.dialog.CancelProtocolDialog.lambda$show$0(baseDialogCreate, iCallbackCode, view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView2, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.CancelProtocolDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.dialog.CancelProtocolDialog.lambda$show$1(baseDialogCreate, iCallbackCode, view);
            }
        });
        baseDialogCreate.show();
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.dialog.CancelProtocolDialog$1, reason: invalid class name */
    class AnonymousClass1 extends java.util.TimerTask {
        final /* synthetic */ android.widget.TextView val$ok;

        AnonymousClass1(android.widget.TextView textView) {
            this.val$ok = textView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(android.widget.TextView textView) throws java.lang.Exception {
            textView.setText(java.lang.String.format("我已阅读并同意（%ds)", java.lang.Integer.valueOf(3 - com.up366.mobile.common.dialog.CancelProtocolDialog.this.start)));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final android.widget.TextView textView = this.val$ok;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.CancelProtocolDialog$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$run$0(textView);
                }
            });
            com.up366.mobile.common.dialog.CancelProtocolDialog.this.start++;
            if (com.up366.mobile.common.dialog.CancelProtocolDialog.this.start == 3) {
                final android.widget.TextView textView2 = this.val$ok;
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.CancelProtocolDialog$1$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.common.dialog.CancelProtocolDialog.AnonymousClass1.lambda$run$1(textView2);
                    }
                });
                com.up366.mobile.common.dialog.CancelProtocolDialog.this.timer.cancel();
            }
        }

        static /* synthetic */ void lambda$run$1(android.widget.TextView textView) throws java.lang.Exception {
            textView.setEnabled(true);
            textView.setText("我已阅读并同意");
        }
    }

    static /* synthetic */ void lambda$show$0(com.up366.mobile.common.dialog.BaseDialog baseDialog, com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        baseDialog.dismiss();
        iCallbackCode.onResult(0);
    }

    static /* synthetic */ void lambda$show$1(com.up366.mobile.common.dialog.BaseDialog baseDialog, com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        baseDialog.dismiss();
        iCallbackCode.onResult(-1);
    }
}
