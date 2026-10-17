package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppDialog {
    public final com.up366.mobile.databinding.AppDialogLayoutBinding b;
    private final android.app.Dialog dialog;
    private boolean autoDismiss = true;
    private int mWidth = 0;

    private AppDialog(android.content.Context context) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(context, com.up366.mobile.R.style.AppDialogTheme);
        this.dialog = baseDialog;
        com.up366.mobile.databinding.AppDialogLayoutBinding appDialogLayoutBinding = (com.up366.mobile.databinding.AppDialogLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.app_dialog_layout, (android.view.ViewGroup) null, false);
        this.b = appDialogLayoutBinding;
        baseDialog.setContentView(appDialogLayoutBinding.getRoot());
        baseDialog.setCancelable(false);
        init();
    }

    public static com.up366.mobile.common.dialog.AppDialog create(android.content.Context context) {
        return new com.up366.mobile.common.dialog.AppDialog(context);
    }

    private AppDialog(android.content.Context context, int i) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(context, i);
        this.dialog = baseDialog;
        com.up366.mobile.databinding.AppDialogLayoutBinding appDialogLayoutBinding = (com.up366.mobile.databinding.AppDialogLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.app_dialog_layout, (android.view.ViewGroup) null, false);
        this.b = appDialogLayoutBinding;
        baseDialog.setContentView(appDialogLayoutBinding.getRoot());
        baseDialog.setCancelable(false);
        init();
    }

    public static com.up366.mobile.common.dialog.AppDialog create(android.content.Context context, int i) {
        return new com.up366.mobile.common.dialog.AppDialog(context, i);
    }

    private void init() {
        this.b.headImg.setVisibility(8);
        this.b.title.setVisibility(8);
        this.b.titleScrollView.setVisibility(8);
        this.b.contentScrollView.setVisibility(8);
        this.b.btnLeft.setVisibility(8);
        this.b.btnRight.setVisibility(8);
        this.b.btnOne.setVisibility(8);
        this.b.btnBig.setVisibility(8);
        this.b.tip.setVisibility(8);
        this.b.clickTip.setVisibility(8);
        this.b.buttonContainerV2.setVisibility(8);
        this.b.btnClose.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        dismiss();
    }

    public com.up366.mobile.common.dialog.AppDialog title(java.lang.CharSequence charSequence) {
        this.b.title.setVisibility(0);
        this.b.title.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog title(java.lang.CharSequence charSequence, android.text.method.MovementMethod movementMethod) {
        this.b.title.setVisibility(0);
        this.b.title.setText(charSequence);
        this.b.title.setMovementMethod(movementMethod);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog title(java.lang.CharSequence charSequence, int i, int i2) {
        this.b.title.setVisibility(0);
        this.b.title.setText(charSequence);
        this.b.title.setTextColor(i);
        this.b.title.setTextSize(i2);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog message(java.lang.CharSequence charSequence) {
        this.b.contentScrollView.setVisibility(0);
        this.b.message.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog message(java.lang.CharSequence charSequence, int i) {
        this.b.contentScrollView.setVisibility(0);
        this.b.message.setText(charSequence);
        this.b.message.setGravity(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog setMessageMovementMethod() {
        this.b.message.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog setMessageColor(int i) {
        this.b.message.setTextColor(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog btnBigV2(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        this.b.buttonContainer.setVisibility(8);
        this.b.buttonContainerV2.setVisibility(0);
        this.b.btnV2Left.setVisibility(8);
        this.b.lineV2Center.setVisibility(8);
        setOnClickListener(charSequence, onClickListener, this.b.btnV2Right);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog btnTwoBottomV2(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, android.view.View.OnClickListener onClickListener, android.view.View.OnClickListener onClickListener2) {
        this.b.buttonContainer.setVisibility(8);
        this.b.buttonContainerV2.setVisibility(0);
        setOnClickListener(charSequence2, onClickListener2, this.b.btnV2Right);
        setOnClickListener(charSequence, onClickListener, this.b.btnV2Left);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog messageTitle(java.lang.CharSequence charSequence) {
        this.b.titleScrollView.setVisibility(0);
        this.b.messageTitle.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog message(java.lang.CharSequence charSequence, android.text.method.MovementMethod movementMethod, int i) {
        this.b.contentScrollView.setVisibility(0);
        this.b.message.setText(charSequence);
        this.b.message.setMovementMethod(movementMethod);
        this.b.message.setHighlightColor(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog messageTitle(java.lang.CharSequence charSequence, int i) {
        this.b.titleScrollView.setVisibility(0);
        this.b.messageTitle.setText(charSequence);
        this.b.messageTitle.setGravity(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog setButtonContainerVisibility(int i) {
        this.b.buttonContainer.setVisibility(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog message(java.lang.CharSequence charSequence, int i, int i2) {
        this.b.contentScrollView.setVisibility(0);
        this.b.message.setText(charSequence);
        this.b.message.setTextColor(i);
        this.b.message.setTextSize(i2);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog setMessageLeft() {
        this.b.messageTitle.setGravity(3);
        this.b.message.setGravity(3);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog left(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        setOnClickListener(charSequence, onClickListener, this.b.btnLeft);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog right(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        setOnClickListener(charSequence, onClickListener, this.b.btnRight);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog right(java.lang.CharSequence charSequence, int i, android.view.View.OnClickListener onClickListener) {
        this.b.btnRight.getLayoutParams().width = i;
        setOnClickListener(charSequence, onClickListener, this.b.btnRight);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog left(java.lang.CharSequence charSequence, int i, android.view.View.OnClickListener onClickListener) {
        this.b.btnLeft.getLayoutParams().width = i;
        setOnClickListener(charSequence, onClickListener, this.b.btnLeft);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog exchange() {
        this.b.btnLeft.bringToFront();
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog btnOne(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        setOnClickListener(charSequence, onClickListener, this.b.btnOne);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog btnBig(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        setOnClickListener(charSequence, onClickListener, this.b.btnBig);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog tip(java.lang.CharSequence charSequence) {
        this.b.tip.setVisibility(0);
        this.b.tip.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog clickTip(java.lang.CharSequence charSequence, android.view.View.OnClickListener onClickListener) {
        setOnClickListener(charSequence, onClickListener, this.b.clickTip);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog setAutoDismiss(boolean z) {
        this.autoDismiss = z;
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog setWidth(int i) {
        this.mWidth = i;
        return this;
    }

    private void setOnClickListener(java.lang.CharSequence charSequence, final android.view.View.OnClickListener onClickListener, android.widget.TextView textView) {
        textView.setVisibility(0);
        textView.setText(charSequence);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setOnClickListener$1(onClickListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnClickListener$1(android.view.View.OnClickListener onClickListener, android.view.View view) {
        onClickListener.onClick(view);
        if (this.autoDismiss) {
            dismiss();
        }
    }

    public com.up366.mobile.common.dialog.AppDialog headImage(int i) {
        this.b.headImg.setVisibility(0);
        this.b.headImg.setImageResource(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog headImage(int i, int i2, int i3) {
        this.b.headImg.setVisibility(0);
        this.b.headImg.getLayoutParams().width = i2;
        this.b.headImg.getLayoutParams().height = i3;
        com.up366.common.BitmapUtilsUp.display(this.b.headImg, i);
        return this;
    }

    public void dismiss() {
        this.dialog.dismiss();
    }

    public com.up366.mobile.common.dialog.AppDialog show() {
        if (!this.dialog.isShowing()) {
            this.dialog.show();
        }
        final android.widget.ScrollView scrollView = this.b.contentScrollView;
        scrollView.post(new java.lang.Runnable() { // from class: com.up366.mobile.common.dialog.AppDialog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$2(scrollView);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$2(android.widget.ScrollView scrollView) {
        if (scrollView.getHeight() > 100 && scrollView.getHeight() < scrollView.getChildAt(0).getHeight()) {
            android.view.WindowManager.LayoutParams attributes = this.dialog.getWindow().getAttributes();
            float f = android.content.res.Resources.getSystem().getDisplayMetrics().heightPixels * 0.9f;
            if (this.mWidth > 0) {
                this.dialog.getWindow().setLayout(this.mWidth, (int) f);
                return;
            } else {
                this.dialog.getWindow().setLayout(attributes.width, (int) f);
                return;
            }
        }
        android.view.WindowManager.LayoutParams attributes2 = this.dialog.getWindow().getAttributes();
        if (this.mWidth > 0) {
            this.dialog.getWindow().setLayout(this.mWidth, attributes2.height);
        }
    }

    public com.up366.mobile.common.dialog.AppDialog setOnDissmissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(onDismissListener);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog setBtnCloseVisibility(int i) {
        this.b.btnClose.setVisibility(i);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog setCancelable(boolean z) {
        this.dialog.setCancelable(z);
        return this;
    }

    public com.up366.mobile.common.dialog.AppDialog btnClose(final android.view.View.OnClickListener onClickListener) {
        this.b.btnClose.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$btnClose$3(onClickListener, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$btnClose$3(android.view.View.OnClickListener onClickListener, android.view.View view) {
        onClickListener.onClick(view);
        dismiss();
    }

    public com.up366.mobile.common.dialog.AppDialog setDialogRootBackGround(int i) {
        this.b.getRoot().setBackgroundResource(i);
        return this;
    }
}
