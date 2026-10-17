package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppTipDialog {
    private boolean autoDismiss = true;
    public final com.up366.mobile.databinding.AppTipDialogLayoutBinding b;
    private final android.app.Dialog dialog;

    private AppTipDialog(android.content.Context context) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(context, com.up366.mobile.R.style.AppDialogTheme);
        this.dialog = baseDialog;
        com.up366.mobile.databinding.AppTipDialogLayoutBinding appTipDialogLayoutBinding = (com.up366.mobile.databinding.AppTipDialogLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.app_tip_dialog_layout, (android.view.ViewGroup) null, false);
        this.b = appTipDialogLayoutBinding;
        baseDialog.setContentView(appTipDialogLayoutBinding.getRoot());
        baseDialog.setCancelable(false);
        init();
    }

    public static com.up366.mobile.common.dialog.AppTipDialog create(android.content.Context context) {
        return new com.up366.mobile.common.dialog.AppTipDialog(context);
    }

    private AppTipDialog(android.content.Context context, int i) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(context, i);
        this.dialog = baseDialog;
        com.up366.mobile.databinding.AppTipDialogLayoutBinding appTipDialogLayoutBinding = (com.up366.mobile.databinding.AppTipDialogLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.app_tip_dialog_layout, (android.view.ViewGroup) null, false);
        this.b = appTipDialogLayoutBinding;
        baseDialog.setContentView(appTipDialogLayoutBinding.getRoot());
        baseDialog.setCancelable(false);
        init();
    }

    public static com.up366.mobile.common.dialog.AppTipDialog create(android.content.Context context, int i) {
        return new com.up366.mobile.common.dialog.AppTipDialog(context, i);
    }

    private void init() {
        this.b.img.setVisibility(8);
        this.b.message.setVisibility(8);
        this.b.btnOne.setVisibility(8);
    }

    public com.up366.mobile.common.dialog.AppTipDialog message(java.lang.CharSequence charSequence) {
        this.b.message.setVisibility(0);
        this.b.message.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.AppTipDialog message(java.lang.CharSequence charSequence, android.text.method.MovementMethod movementMethod, int i) {
        this.b.message.setVisibility(0);
        this.b.message.setText(charSequence);
        this.b.message.setMovementMethod(movementMethod);
        this.b.message.setHighlightColor(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppTipDialog message(java.lang.CharSequence charSequence, int i, int i2) {
        this.b.message.setVisibility(0);
        this.b.message.setText(charSequence);
        this.b.message.setTextColor(i);
        this.b.message.setTextSize(i2);
        return this;
    }

    public com.up366.mobile.common.dialog.AppTipDialog btnOne(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        setOnClickListener(charSequence, onClickListener, this.b.btnOne);
        return this;
    }

    private void setOnClickListener(java.lang.CharSequence charSequence, final android.view.View.OnClickListener onClickListener, android.widget.TextView textView) {
        textView.setVisibility(0);
        textView.setText(charSequence);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppTipDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setOnClickListener$0(onClickListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnClickListener$0(android.view.View.OnClickListener onClickListener, android.view.View view) {
        onClickListener.onClick(view);
        if (this.autoDismiss) {
            dismiss();
        }
    }

    public com.up366.mobile.common.dialog.AppTipDialog image(int i) {
        this.b.img.setVisibility(0);
        this.b.img.setImageResource(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppTipDialog image(int i, int i2, int i3) {
        this.b.img.setVisibility(0);
        this.b.img.getLayoutParams().width = i2;
        this.b.img.getLayoutParams().height = i3;
        com.up366.common.BitmapUtilsUp.display(this.b.img, i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppTipDialog setAutoDismiss(boolean z) {
        this.autoDismiss = z;
        return this;
    }

    public void dismiss() {
        this.dialog.dismiss();
    }

    public com.up366.mobile.common.dialog.AppTipDialog show() {
        if (!this.dialog.isShowing()) {
            this.dialog.show();
        }
        return this;
    }

    public com.up366.mobile.common.dialog.AppTipDialog setOnDissmissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(onDismissListener);
        return this;
    }

    public com.up366.mobile.common.dialog.AppTipDialog setCancelable(boolean z) {
        this.dialog.setCancelable(z);
        return this;
    }
}
