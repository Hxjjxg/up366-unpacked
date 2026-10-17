package com.up366.mobile.user.account.update;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class PageAccountUpdateMobile {
    private android.app.Activity activity;
    private com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding b;
    private boolean fromConfig;
    private android.os.CountDownTimer timer;
    private final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    private boolean timerStart = false;
    private java.lang.String mobileRightText = "获取验证码";

    /* JADX WARN: Multi-variable type inference failed */
    public PageAccountUpdateMobile(com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, android.widget.TextView textView, boolean z) {
        this.activity = accountUpdateActivity;
        this.toolbarLayout = collapsingToolbarLayout;
        this.fromConfig = z;
        collapsingToolbarLayout.setTitle("修改手机号");
        com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding accountUpdateActivityMobileLayoutBinding = (com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding) androidx.databinding.DataBindingUtil.inflate(accountUpdateActivity.getLayoutInflater(), com.up366.mobile.R.layout.account_update_activity_mobile_layout, frameLayout, true);
        this.b = accountUpdateActivityMobileLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountUpdateActivityMobileLayoutBinding.root.getPaddingLeft());
        initView(accountUpdateActivity, textView);
    }

    private void initView(final android.app.Activity activity, android.widget.TextView textView) {
        java.lang.String mobile = com.up366.mobile.common.logic.Auth.getUserInfo().getMobile();
        java.lang.String maskMobile = com.up366.mobile.common.logic.Auth.getUserInfo().getMaskMobile();
        if (com.up366.common.StringUtils.isEmptyOrNull(mobile)) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.currentMobile, textView);
            textView.setText(java.lang.String.format("我叫%s", com.up366.mobile.common.logic.Auth.getRealName()));
            this.b.currentMobile.setText("绑定手机号后登录更快捷，还有利于找回账号和密码哦~");
            this.toolbarLayout.setTitle("绑定手机号");
            this.b.btnChange.setText("完成");
            this.b.unbindMobile.setVisibility(4);
        } else {
            com.up366.mobile.common.utils.ViewUtil.gone(textView);
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.currentMobile);
            this.b.currentMobile.setText(java.lang.String.format("当前手机号：%s", maskMobile));
            this.toolbarLayout.setTitle("更换手机号");
            this.b.btnChange.setText("立即更换");
            this.b.unbindMobile.setVisibility(0);
        }
        this.timer = new android.os.CountDownTimer(60000L, 1000L) { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.user.account.update.PageAccountUpdateMobile.this.b.captcha.setRightText("重新获取(" + ((j / 1000) + 1) + ")");
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.user.account.update.PageAccountUpdateMobile.this.resetTimer();
                com.up366.mobile.user.account.update.PageAccountUpdateMobile.this.refreshState();
            }
        };
        this.b.mobile.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$0(appEditTextView);
            }
        });
        this.b.mobile.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$1(view, z);
            }
        });
        this.b.errorTip.setVisibility(4);
        this.b.captcha.setRightClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$4(activity, view);
            }
        });
        this.b.captcha.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$5(appEditTextView);
            }
        });
        this.b.btnChange.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$6(activity, view);
            }
        });
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$7();
            }
        });
        this.b.unbindMobile.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.update.AccountUpdateActivity.openPage(activity, 2);
            }
        });
        com.up366.mobile.main.NoMessageCodeTipHelper.INSTANCE.initView(this.b.btnNoCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view, boolean z) {
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
    public /* synthetic */ void lambda$initView$4(final android.app.Activity activity, android.view.View view) {
        this.b.captcha.setRightEnable(false);
        this.mobileRightText = "重新获取";
        this.timerStart = true;
        this.timer.start();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "获取验证码中");
        com.up366.mobile.common.logic.Auth.cur().info().getVerificationCode(this.b.mobile.getTrimText(), 0, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initView$3(activity, response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(android.app.Activity activity, com.up366.common.http.Response response, java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageAccountUpdateMobile - PageAccountUpdateMobile - 发送验证码 result : ");
        sb.append(!response.isError());
        com.up366.common.log.Logger.info(sb.toString());
        if (response.isError()) {
            resetTimer();
            refreshState();
            if (response.getCode() == 3) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "今日获取验证码次数已达\n上限（10次）请明日再试");
                return;
            }
            if (response.getCode() == 5) {
                com.up366.mobile.common.utils.ToastPopupUtil.showError(activity, response.getInfo());
                return;
            } else if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "验证码获取失败:网络原因\n请稍后再试！");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(activity, activity.getString(com.up366.mobile.R.string.code_send_success));
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2() throws java.lang.Exception {
        this.b.captcha.showSoftInput(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(android.app.Activity activity, android.view.View view) {
        doChange(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$7() throws java.lang.Exception {
        this.b.mobile.showSoftInput(true);
    }

    private void doChange(final android.app.Activity activity) {
        com.up366.common.log.Logger.info("TAG - PageAccountUpdateMobile - doChange - 修改手机号");
        final boolean z = this.b.currentMobile.getVisibility() != 0;
        if (z) {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "正在加载");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "修改中");
        }
        final java.lang.String trimText = this.b.mobile.getTrimText();
        com.up366.mobile.common.logic.Auth.cur().info().updateUserPhone(trimText, this.b.captcha.getTrimText(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$doChange$12(activity, trimText, z, response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doChange$12(final android.app.Activity activity, final java.lang.String str, final boolean z, com.up366.common.http.Response response, java.lang.Object obj) {
        if (response.isError()) {
            if (response.getCode() == 12) {
                com.up366.mobile.main.ChangeMobileDialog.show(activity, (com.up366.mobile.main.ChangeMobileDialog.TipUserInfo) com.alibaba.fastjson.JSON.parseObject(response.getResponse(), com.up366.mobile.main.ChangeMobileDialog.TipUserInfo.class), str, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda0
                    @Override // com.up366.common.callback.ICallbackCode
                    public final void onResult(int i) {
                        this.f$0.lambda$doChange$11(activity, str, z, i);
                    }
                });
                return;
            }
            com.up366.common.log.Logger.info("TAG - PageAccountUpdateMobile - doChange - " + response.toString());
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, z ? "绑定失败:网络原因，请稍\n后再试！" : "修改失败:网络原因，请稍\n后再试！");
                return;
            } else if (response.getCode() == 5) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "手机号或验证码错误，请\n修改");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        updateSuccess(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doChange$11(final android.app.Activity activity, final java.lang.String str, final boolean z, int i) {
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "");
            com.up366.mobile.main.ChangeMobileDialog.show1(activity, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda3
                @Override // com.up366.common.callback.ICallbackCode
                public final void onResult(int i2) {
                    this.f$0.lambda$doChange$10(activity, str, z, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doChange$10(final android.app.Activity activity, java.lang.String str, final boolean z, int i) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        if (i != 0) {
            return;
        }
        com.up366.mobile.common.logic.Auth.mgr().transformPhone(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateMobile$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$doChange$9(activity, z, response, (java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doChange$9(android.app.Activity activity, boolean z, com.up366.common.http.Response response, java.lang.String str) {
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(activity, response.getInfo());
        } else {
            updateSuccess(z);
        }
    }

    private void updateSuccess(boolean z) {
        com.up366.mobile.common.logic.Auth.getUserInfo().setMobile(this.b.mobile.getTrimText());
        com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
        if (!this.fromConfig) {
            if (z) {
                com.up366.mobile.common.utils.ViewDataInvalidRecord.$("account_bind_mobile_success").invalid();
            } else {
                com.up366.mobile.common.utils.ViewDataInvalidRecord.$("account_update_mobile_success").invalid();
            }
        }
        this.activity.finish();
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
            this.b.btnChange.setEnabled(true);
        } else {
            this.b.btnChange.setEnabled(false);
        }
    }
}
