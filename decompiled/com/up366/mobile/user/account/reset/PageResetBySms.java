package com.up366.mobile.user.account.reset;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageResetBySms {
    private final android.app.Activity activity;
    private final com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding b;
    private final android.os.CountDownTimer timer;
    private boolean timerStart = false;
    private java.lang.String mobileRightText = "获取验证码";

    public PageResetBySms(final android.app.Activity activity, androidx.core.widget.NestedScrollView nestedScrollView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, android.widget.TextView textView) {
        this.activity = activity;
        boolean booleanExtra = activity.getIntent().getBooleanExtra("find_password", false);
        com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding accountActivityResetBySmsLayoutBinding = (com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_activity_reset_by_sms_layout, nestedScrollView, true);
        this.b = accountActivityResetBySmsLayoutBinding;
        if (booleanExtra) {
            collapsingToolbarLayout.setTitle("找回密码");
            accountActivityResetBySmsLayoutBinding.btnNext.setText("确认");
            accountActivityResetBySmsLayoutBinding.tipMessage.setText("请输入你绑定的手机号哦~");
        } else {
            collapsingToolbarLayout.setTitle("短信重置密码");
        }
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountActivityResetBySmsLayoutBinding.getRoot().getPaddingLeft());
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            textView.setVisibility(0);
            textView.setText(java.lang.String.format("我叫%s", com.up366.mobile.common.logic.Auth.getRealName()));
            accountActivityResetBySmsLayoutBinding.mobile.setText(activity.getIntent().getStringExtra("mobile"));
            accountActivityResetBySmsLayoutBinding.mobile.setEnabled(false);
        }
        this.timer = new android.os.CountDownTimer(60000L, 1000L) { // from class: com.up366.mobile.user.account.reset.PageResetBySms.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.user.account.reset.PageResetBySms.this.b.captcha.setRightText("重新获取(" + ((j / 1000) + 1) + ")");
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.user.account.reset.PageResetBySms.this.resetTimer();
                com.up366.mobile.user.account.reset.PageResetBySms.this.refreshState();
            }
        };
        accountActivityResetBySmsLayoutBinding.mobile.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$new$0(appEditTextView);
            }
        });
        accountActivityResetBySmsLayoutBinding.mobile.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$new$1(view, z);
            }
        });
        accountActivityResetBySmsLayoutBinding.errorTip.setVisibility(4);
        accountActivityResetBySmsLayoutBinding.captcha.setRightClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$4(activity, view);
            }
        });
        accountActivityResetBySmsLayoutBinding.captcha.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$new$5(appEditTextView);
            }
        });
        accountActivityResetBySmsLayoutBinding.btnNext.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$7(activity, view);
            }
        });
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(android.view.View view, boolean z) {
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
    public /* synthetic */ void lambda$new$4(final android.app.Activity activity, android.view.View view) {
        this.b.captcha.setRightEnable(false);
        this.mobileRightText = "重新获取";
        this.timerStart = true;
        this.timer.start();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "获取验证码中");
        com.up366.mobile.common.logic.Auth.mgr().getVerificationCode(this.b.mobile.getTrimText(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$new$3(activity, response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(android.app.Activity activity, com.up366.common.http.Response response, java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageResetBySms - PageResetBySms - 发送验证码 result : ");
        sb.append(!response.isError());
        com.up366.common.log.Logger.info(sb.toString());
        if (response.isError()) {
            resetTimer();
            refreshState();
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(activity, activity.getString(com.up366.mobile.R.string.code_send_success));
            com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda8
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$new$2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() throws java.lang.Exception {
        this.b.captcha.showSoftInput(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(final android.app.Activity activity, android.view.View view) {
        com.up366.common.log.Logger.info("TAG - PageResetBySms - PageResetBySms - 下一步");
        resetTimer();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "正在加载");
        com.up366.mobile.common.logic.Auth.mgr().findUserInfoByThirdParty(1, this.b.mobile.getTrimText(), this.b.captcha.getTrimText(), null, null, null, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.reset.PageResetBySms$$ExternalSyntheticLambda7
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$new$6(activity, response, (com.up366.mobile.common.logic.model.ThirdPartyUserInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(android.app.Activity activity, com.up366.common.http.Response response, com.up366.mobile.common.logic.model.ThirdPartyUserInfo thirdPartyUserInfo) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageResetBySms - PageResetBySms - 获取用户信息 : ");
        sb.append(!response.isError());
        com.up366.common.log.Logger.info(sb.toString());
        if (response.isError()) {
            resetTimer();
            refreshState();
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "验证码校验失败:网络原因\n请稍后再试！");
                return;
            } else if (response.getCode() == 5) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "验证码错误，请修改");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
                return;
            }
        }
        if (com.up366.mobile.common.logic.Auth.isAuth() && !com.up366.mobile.common.logic.Auth.getUserInfo().getUsername().equals(thirdPartyUserInfo.getUsername())) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "暂无该账号");
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        activity.getIntent().putExtra("mobile", thirdPartyUserInfo.getMobile());
        activity.getIntent().putExtra("realName", thirdPartyUserInfo.getRealname());
        activity.getIntent().putExtra("username", thirdPartyUserInfo.getUsername());
        com.up366.mobile.user.account.AccountActivity.openPage(activity, 3);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$8() throws java.lang.Exception {
        if (this.b.mobile.isEnabled()) {
            this.b.mobile.showSoftInput(true);
        } else {
            this.b.captcha.showSoftInput(true);
        }
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
        if (this.b.captcha.getTrimText().length() > 0 && this.b.mobile.getTrimText().length() == 11) {
            this.b.btnNext.setEnabled(true);
        } else {
            this.b.btnNext.setEnabled(false);
        }
    }
}
