package com.up366.mobile.me.logoff;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LogOffAccountConfirmActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding binding;
    private android.os.CountDownTimer timer;
    private boolean timerStart = false;
    private java.lang.String mobileRightText = "获取验证码";
    private boolean canBack = true;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_setting_account_delete_phone";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void start(com.up366.mobile.me.logoff.LogOffAccountActivity logOffAccountActivity) {
        logOffAccountActivity.startActivity(new android.content.Intent((android.content.Context) logOffAccountActivity, (java.lang.Class<?>) com.up366.mobile.me.logoff.LogOffAccountConfirmActivity.class));
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding userLogOffActivityConfirmLayoutBindingInflate = com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding.inflate(getLayoutInflater());
        this.binding = userLogOffActivityConfirmLayoutBindingInflate;
        setContentView(userLogOffActivityConfirmLayoutBindingInflate.getRoot());
        this.timer = new android.os.CountDownTimer(60000L, 1000L) { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.me.logoff.LogOffAccountConfirmActivity.this.binding.captcha.setRightText("重新获取(" + ((j / 1000) + 1) + ")");
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.me.logoff.LogOffAccountConfirmActivity.this.resetTimer();
                com.up366.mobile.me.logoff.LogOffAccountConfirmActivity.this.refreshState();
            }
        };
        this.binding.toLogin.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.username.setText("我叫" + com.up366.mobile.common.logic.Auth.getUserInfo().getRealname());
        this.binding.mobile.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile());
        this.binding.mobile.setEnabled(false);
        this.binding.captcha.setRightClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.captcha.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$onCreate$4(appEditTextView);
            }
        });
        this.binding.btnChange.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        android.text.SpannableString spannableString = new android.text.SpannableString("此账号进入冻结期，为期10天，你可在冻结期间拨打\n客服电话4006426166撤回注销；\n冻结期结束后，系统将自动清除该账号及其关联的\n所有信息");
        spannableString.setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity.2
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                try {
                    android.content.Intent intent = new android.content.Intent("android.intent.action.DIAL");
                    intent.setData(android.net.Uri.parse("tel:4006426166"));
                    com.up366.mobile.me.logoff.LogOffAccountConfirmActivity.this.startActivity(intent);
                } catch (java.lang.Exception unused) {
                    com.up366.mobile.common.utils.ToastPopupUtil.show("启动拨号失败，无法调起拨号");
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(-9661697);
                textPaint.setUnderlineText(false);
            }
        }, 28, 38, 17);
        this.binding.tip.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.binding.tip.setHighlightColor(0);
        this.binding.tip.setText(spannableString);
        com.up366.mobile.main.NoMessageCodeTipHelper.INSTANCE.initView(this.binding.btnNoCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        com.up366.mobile.user.account.login.AccountLoginActivity.open(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(android.view.View view) {
        this.binding.captcha.setRightEnable(false);
        this.mobileRightText = "重新获取";
        this.timerStart = true;
        this.timer.start();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "获取验证码中");
        com.up366.mobile.common.logic.Auth.cur().info().getVerificationCode(this.binding.mobile.getTrimText(), 2, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$onCreate$2(response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(com.up366.common.http.Response response, java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageAccountUpdateMobile - PageAccountUpdateMobile - 发送验证码 result : ");
        sb.append(!response.isError());
        com.up366.common.log.Logger.info(sb.toString());
        if (response.isError()) {
            resetTimer();
            refreshState();
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, response.getInfo());
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, getString(com.up366.mobile.R.string.code_send_success));
            com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onCreate$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() throws java.lang.Exception {
        this.binding.captcha.showSoftInput(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$6(android.view.View view) {
        java.lang.String trimText = this.binding.captcha.getTrimText();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "正在注销账号...");
        com.up366.mobile.common.logic.Auth.cur().info().applyCancelAccount(trimText, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.logoff.LogOffAccountConfirmActivity$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$onCreate$5(response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(com.up366.common.http.Response response, java.lang.Object obj) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, "注销失败,失败原因：" + response.getInfo());
        } else {
            com.up366.mobile.common.logic.Auth.logoutNoSkip();
            this.canBack = false;
            invisible(this.binding.backBtn, this.binding.titleLayout, this.binding.root);
            visible(this.binding.askForSuccessLayout);
        }
    }

    public void onBackPressed() {
        if (this.canBack) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void resetTimer() {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        this.timerStart = false;
        this.timer.cancel();
        this.binding.captcha.setRightText(this.mobileRightText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshState() {
        if (this.binding.mobile.getTrimText().length() == 11) {
            if (!this.timerStart) {
                this.binding.captcha.setRightEnable(true);
            }
        } else {
            this.binding.captcha.setRightEnable(false);
            resetTimer();
        }
        if (this.binding.captcha.getTrimText().length() > 0 && this.binding.mobile.getTrimText().length() == 11) {
            this.binding.btnChange.setEnabled(true);
        } else {
            this.binding.btnChange.setEnabled(false);
        }
    }
}
