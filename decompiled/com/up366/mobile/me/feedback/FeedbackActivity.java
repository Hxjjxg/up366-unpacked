package com.up366.mobile.me.feedback;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FeedbackActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding binding;
    private int type;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_feedback";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding userFeedbackActivityLayoutBinding = (com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.user_feedback_activity_layout);
        this.binding = userFeedbackActivityLayoutBinding;
        com.up366.qmui.util.QMUIKeyboardHelper.showKeyboard((android.widget.EditText) userFeedbackActivityLayoutBinding.feedbackContentEt, 200);
        this.type = getIntent().getIntExtra("type", 1);
        initView();
    }

    private void initView() {
        this.binding.cancelBtn.setVisibility(8);
        this.binding.cancelBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.feedback.FeedbackActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
        this.binding.feedPhone.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.feedback.FeedbackActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.binding.feedbackPhoneEt.addTextChangedListener(new android.text.TextWatcher() { // from class: com.up366.mobile.me.feedback.FeedbackActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                com.up366.mobile.me.feedback.FeedbackActivity.this.binding.cancelBtn.setVisibility(com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.me.feedback.FeedbackActivity.this.binding.feedbackPhoneEt.getText().toString()) ? 8 : 0);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.feedbackSubmitBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.feedback.FeedbackActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$3(view);
            }
        });
        this.binding.feedbackText3.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.iconFeedWechat.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.feedEmail.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.feedPhone.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.feedTip.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.feedbackPic.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.feedbackPic.setAddListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.feedback.FeedbackActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        this.binding.feedbackPhoneEt.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.DIAL");
            intent.setData(android.net.Uri.parse("tel:4006426166"));
            startActivity(intent);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("call error " + e.getMessage());
            android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) com.up366.common.global.GB.get().getCurrentActivity().getSystemService("clipboard");
            android.content.ClipData clipDataNewPlainText = android.content.ClipData.newPlainText("电话", "4006426166");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(clipDataNewPlainText);
                com.up366.mobile.common.utils.ToastPopupUtil.show("无法启动拨号，您复制到粘贴板，你可直接拨号处粘贴");
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.show("启动拨号失败，无法调起拨号");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$3(android.view.View view) {
        com.up366.mobile.common.utils.PermissionUtils.checkReadStoragePermission(this, "反馈", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.me.feedback.FeedbackActivity$$ExternalSyntheticLambda6
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$initView$2(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(int i, java.lang.String str) {
        if (i != 0) {
            return;
        }
        submit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$4(android.view.View view) {
        com.up366.mobile.common.utils.PhotoSelectUtils.showPictureDialog(this, "反馈", true, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside(motionEvent, this.binding.feedbackContentEt, this.binding.feedbackPhoneEt);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) throws java.lang.Throwable {
        super.onActivityResult(i, i2, intent);
        com.up366.multimedia.util.MediaHelper.getInstance().onActivityResult(i, i2, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void submit() {
        com.up366.qmui.util.QMUIKeyboardHelper.hideKeyboard(this.binding.feedbackContentEt);
        final java.lang.String string = this.binding.feedbackContentEt.getText().toString();
        final java.lang.String string2 = this.binding.feedbackPhoneEt.getText().toString();
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "请简单描述一下反馈的内容！");
            return;
        }
        if (com.up366.common.ValidateUtilsUp.containsEmoji(string)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "不能输入表情符号哦");
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(string2)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "请填写一下您的手机号！");
            return;
        }
        if (!com.up366.common.ValidateUtilsUp.isMobile(string2)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "手机号格式不正确！");
        } else {
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "网络好像走丢了\n请稍后重试!");
                return;
            }
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.me.feedback.FeedbackActivity$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$submit$5(string, string2);
                }
            });
            com.up366.common.task.TaskUtils.postMainTaskDelay(150L, new com.up366.common.task.Task() { // from class: com.up366.mobile.me.feedback.FeedbackActivity$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(com.up366.common.global.GB.get().getCurrentActivity(), "感谢您的反馈，我们的工作\n人员会尽快联系您！");
                }
            });
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submit$5(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().feedback().uploadFeedBack(this.type, str, str2, true, this.binding.feedbackPic.getDatas());
    }

    public static void openPage(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.feedback.FeedbackActivity.class));
    }

    public static void openPage(android.content.Context context, int i) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.feedback.FeedbackActivity.class);
        intent.putExtra("type", i);
        context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
    }
}
