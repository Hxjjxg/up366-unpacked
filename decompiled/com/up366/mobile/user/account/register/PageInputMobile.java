package com.up366.mobile.user.account.register;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageInputMobile {
    private final android.app.Activity activity;
    public final com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding b;
    private android.os.CountDownTimer timer;
    private boolean timerStart = false;
    private java.lang.String mobileRightText = "获取验证码";

    static /* synthetic */ void lambda$initView$13(android.view.View view) {
    }

    public PageInputMobile(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView) {
        this.activity = activity;
        textView.setVisibility(4);
        com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding accountRegisterActivityPageInputMobileLayoutBinding = (com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_register_activity_page_input_mobile_layout, frameLayout, true);
        this.b = accountRegisterActivityPageInputMobileLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountRegisterActivityPageInputMobileLayoutBinding.getRoot().getPaddingLeft());
        initView(activity, appBarLayout);
    }

    private void initView(final android.app.Activity activity, com.google.android.material.appbar.AppBarLayout appBarLayout) {
        this.timer = new android.os.CountDownTimer(60000L, 1000L) { // from class: com.up366.mobile.user.account.register.PageInputMobile.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.user.account.register.PageInputMobile.this.b.captcha.setRightText("重新获取(" + ((j / 1000) + 1) + ")");
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.user.account.register.PageInputMobile.this.resetTimer();
                com.up366.mobile.user.account.register.PageInputMobile.this.refreshState();
            }
        };
        this.b.errorTip.setVisibility(4);
        this.b.errorTipPassword.setVisibility(4);
        this.b.mobile.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda8
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$0(view, z);
            }
        });
        this.b.password.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda12
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$1(view, z);
            }
        });
        this.b.mobile.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$2(appEditTextView);
            }
        });
        this.b.password.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda14
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$3(appEditTextView);
            }
        });
        this.b.passwordAgain.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda15
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$4(appEditTextView);
            }
        });
        this.b.mobile.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$5(view, z);
            }
        });
        this.b.errorTip.setVisibility(4);
        this.b.captcha.setRightClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$8(activity, view);
            }
        });
        this.b.captcha.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$9(appEditTextView);
            }
        });
        this.b.passwordAgain.setOnEditActionListener(new com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener
            public final void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$10(appEditTextView);
            }
        });
        this.b.btnRegister.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$11(activity, view);
            }
        });
        this.b.licenseText.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("勾选代表已阅读并同意").append("《使用许可协议》").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.user.account.register.PageInputMobile.4
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
                intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.LICENSE_URL));
                activity.startActivity(intent);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(true);
            }
        }).append("《隐私政策》").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.user.account.register.PageInputMobile.3
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
                intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL));
                activity.startActivity(intent);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(true);
            }
        }).append("《儿童隐私保护政策》").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.user.account.register.PageInputMobile.2
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
                intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL));
                activity.startActivity(intent);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(true);
            }
        }).build());
        this.b.licenseText.postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initView$12();
            }
        }, 100L);
        this.b.licenseText.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.b.license.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.register.PageInputMobile.lambda$initView$13(view);
            }
        });
        this.b.licenseText.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$14(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view, boolean z) {
        if (!z) {
            java.lang.String trimText = this.b.mobile.getTrimText();
            if (trimText.length() > 0 && (trimText.length() != 11 || !trimText.startsWith("1"))) {
                this.b.errorTip.setVisibility(0);
                return;
            } else {
                this.b.errorTip.setVisibility(4);
                return;
            }
        }
        this.b.errorTip.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view, boolean z) {
        if (!z) {
            if (this.b.password.getTrimText().length() > 0 && !com.up366.mobile.common.utils.PasswordValidateUtils.verifyPasswordV2(this.b.password.getTrimText())) {
                this.b.errorTipPassword.setVisibility(0);
                return;
            } else {
                this.b.errorTipPassword.setVisibility(4);
                return;
            }
        }
        this.b.errorTipPassword.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(android.view.View view, boolean z) {
        if (!z) {
            java.lang.String trimText = this.b.mobile.getTrimText();
            if (trimText.length() > 0 && (trimText.length() != 11 || !trimText.startsWith("1"))) {
                this.b.errorTip.setVisibility(0);
                return;
            } else {
                this.b.errorTip.setVisibility(4);
                return;
            }
        }
        this.b.errorTip.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$8(final android.app.Activity activity, android.view.View view) {
        this.b.mobile.clearFocus();
        this.b.captcha.setRightEnable(false);
        this.timerStart = true;
        this.timer.start();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "获取验证码中");
        this.mobileRightText = "重新获取";
        com.up366.mobile.common.logic.Auth.mgr().getVerificationCodeForRegister(this.b.mobile.getTrimText(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initView$7(activity, response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$7(android.app.Activity activity, com.up366.common.http.Response response, java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageResetBySms - PageResetBySms - 发送验证码 result : ");
        sb.append(!response.isError());
        sb.append(" code:");
        sb.append(response.getCode());
        com.up366.common.log.Logger.info(sb.toString());
        if (response.isError()) {
            resetTimer();
            refreshState();
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "验证码获取失败:网络原因\n请稍后再试！");
                return;
            }
            if (response.getCode() == 5) {
                com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(activity, activity.getString(com.up366.mobile.R.string.code_send_success));
                return;
            } else if (response.getCode() == 3) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "今日获取验证码次数已达\n上限（10次）请明日再试");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(activity, activity.getString(com.up366.mobile.R.string.code_send_success));
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6() throws java.lang.Exception {
        this.b.captcha.showSoftInput(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$9(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$10(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        this.b.btnRegister.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$11(android.app.Activity activity, android.view.View view) {
        if (this.b.btnRegister.isEnabled()) {
            if (!this.b.license.isChecked()) {
                com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding shanyanPrivacyTipLayoutBinding = (com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(activity), com.up366.mobile.R.layout.shanyan_privacy_tip_layout, (android.view.ViewGroup) null, false);
                shanyanPrivacyTipLayoutBinding.text.setText("请勾选下方协议再注册哦~");
                com.up366.mobile.common.utils.ToastPopupUtil.showCustomPopWindow(this.b.license, -7, -55, shanyanPrivacyTipLayoutBinding.getRoot());
                return;
            }
            doValid(activity, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$12() {
        this.b.license.setLines(this.b.license.getLayout().getLineCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$14(android.view.View view) {
        this.b.license.toggle();
    }

    private void doValid(final android.app.Activity activity, final android.view.View view) {
        com.up366.common.log.Logger.info("TAG - 2020/5/28 - PageInputMobile - doValid - 判断验证码是否正确");
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "正在加载");
        com.up366.mobile.common.logic.Auth.mgr().checkVerifyCode(this.b.mobile.getTrimText(), this.b.captcha.getTrimText(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.register.PageInputMobile$$ExternalSyntheticLambda7
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$doValid$15(activity, view, response, (java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doValid$15(android.app.Activity activity, android.view.View view, com.up366.common.http.Response response, java.lang.String str) {
        if (response.isError()) {
            if (response.getCode() == -10000) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "注册失败:网络原因\n请稍后再试！");
                return;
            } else if (response.getCode() == 5) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "验证码错误，请修改");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        com.up366.mobile.user.account.register.PageInputPassword.doRegister(activity, view, this.b.password.getTrimText(), this.b.passwordAgain.getTrimText(), this.b.mobile.getTrimText(), this.b.captcha.getTrimText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTimer() {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.activity);
        this.timerStart = false;
        this.timer.cancel();
        this.b.captcha.setRightText(this.mobileRightText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshState() {
        if (this.b.mobile.getTrimText().length() == 11) {
            if (!this.timerStart) {
                this.b.captcha.setRightEnable(true);
            }
        } else {
            this.b.captcha.setRightEnable(false);
            resetTimer();
        }
        if (this.b.captcha.getTrimText().length() > 0 && this.b.mobile.getTrimText().length() == 11 && this.b.password.getTrimText().length() > 7 && this.b.passwordAgain.getTrimText().length() > 7) {
            this.b.btnRegister.setEnabled(true);
        } else {
            this.b.btnRegister.setEnabled(false);
        }
    }
}
