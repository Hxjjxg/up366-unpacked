package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TwoBtnDialog {
    public final com.up366.mobile.databinding.TwoBtnDialogLayoutBinding b;
    private final android.app.Dialog dialog;

    private void init() {
    }

    private TwoBtnDialog(android.content.Context context) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(context, com.up366.mobile.R.style.AppDialogTheme);
        this.dialog = baseDialog;
        com.up366.mobile.databinding.TwoBtnDialogLayoutBinding twoBtnDialogLayoutBinding = (com.up366.mobile.databinding.TwoBtnDialogLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.two_btn_dialog_layout, (android.view.ViewGroup) null, false);
        this.b = twoBtnDialogLayoutBinding;
        baseDialog.setContentView(twoBtnDialogLayoutBinding.getRoot());
        baseDialog.setCancelable(false);
        init();
    }

    public static com.up366.mobile.common.dialog.TwoBtnDialog create(android.content.Context context) {
        return new com.up366.mobile.common.dialog.TwoBtnDialog(context);
    }

    public com.up366.mobile.common.dialog.TwoBtnDialog title(java.lang.CharSequence charSequence) {
        this.b.title.setVisibility(0);
        this.b.title.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.TwoBtnDialog message(java.lang.CharSequence charSequence) {
        this.b.contentScrollView.setVisibility(0);
        this.b.message.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.TwoBtnDialog message(java.lang.CharSequence charSequence, int i) {
        this.b.contentScrollView.setVisibility(0);
        this.b.message.setText(charSequence);
        this.b.message.setGravity(i);
        return this;
    }

    public com.up366.mobile.common.dialog.TwoBtnDialog left(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        setOnClickListener(charSequence, onClickListener, this.b.btnLeft);
        return this;
    }

    public com.up366.mobile.common.dialog.TwoBtnDialog right(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        setOnClickListener(charSequence, onClickListener, this.b.btnRight);
        return this;
    }

    private void setOnClickListener(java.lang.CharSequence charSequence, final android.view.View.OnClickListener onClickListener, android.widget.TextView textView) {
        textView.setVisibility(0);
        textView.setText(charSequence);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.TwoBtnDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setOnClickListener$0(onClickListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnClickListener$0(android.view.View.OnClickListener onClickListener, android.view.View view) {
        onClickListener.onClick(view);
        dismiss();
    }

    public void dismiss() {
        this.dialog.dismiss();
    }

    public com.up366.mobile.common.dialog.TwoBtnDialog show() {
        if (!this.dialog.isShowing()) {
            this.dialog.show();
        }
        final android.widget.ScrollView scrollView = this.b.contentScrollView;
        scrollView.post(new java.lang.Runnable() { // from class: com.up366.mobile.common.dialog.TwoBtnDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$1(scrollView);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(android.widget.ScrollView scrollView) {
        if (scrollView.getHeight() <= 100 || scrollView.getHeight() >= scrollView.getChildAt(0).getHeight()) {
            return;
        }
        this.dialog.getWindow().setLayout(this.dialog.getWindow().getAttributes().width, (int) (android.content.res.Resources.getSystem().getDisplayMetrics().heightPixels * 0.9f));
    }

    public com.up366.mobile.common.dialog.TwoBtnDialog setOnDissmissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(onDismissListener);
        return this;
    }
}
