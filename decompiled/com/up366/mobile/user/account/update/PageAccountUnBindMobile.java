package com.up366.mobile.user.account.update;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class PageAccountUnBindMobile {
    private android.app.Activity activity;
    private com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding b;
    private android.os.CountDownTimer timer;
    private boolean timerStart = false;
    private final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    /* JADX WARN: Multi-variable type inference failed */
    public PageAccountUnBindMobile(com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, android.widget.TextView textView) {
        this.activity = accountUpdateActivity;
        this.toolbarLayout = collapsingToolbarLayout;
        collapsingToolbarLayout.setTitle("修改手机号");
        com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding accountUpdateActivityUnbindMobileLayoutBindingInflate = com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding.inflate(accountUpdateActivity.getLayoutInflater(), frameLayout, true);
        this.b = accountUpdateActivityUnbindMobileLayoutBindingInflate;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountUpdateActivityUnbindMobileLayoutBindingInflate.root.getPaddingLeft());
        initView(accountUpdateActivity, textView);
    }

    private void initView(final android.app.Activity activity, android.widget.TextView textView) {
        final java.lang.String mobile = com.up366.mobile.common.logic.Auth.getUserInfo().getMobile();
        java.lang.String maskMobile = com.up366.mobile.common.logic.Auth.getUserInfo().getMaskMobile();
        com.up366.mobile.common.utils.ViewUtil.gone(textView);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.currentMobile);
        this.b.currentMobile.setText(java.lang.String.format("当前手机号：%s", maskMobile));
        this.toolbarLayout.setTitle("解绑手机号");
        this.timer = new android.os.CountDownTimer(60000L, 1000L) { // from class: com.up366.mobile.user.account.update.PageAccountUnBindMobile.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.user.account.update.PageAccountUnBindMobile.this.b.captchaTip.setText(com.up366.common.StringUtils.format("重新发送(%d)", java.lang.Long.valueOf((j / 1000) + 1)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.user.account.update.PageAccountUnBindMobile.this.resetTimer();
                com.up366.mobile.user.account.update.PageAccountUnBindMobile.this.refreshState();
                com.up366.mobile.user.account.update.PageAccountUnBindMobile.this.b.captchaTip.setText("");
                com.up366.mobile.user.account.update.PageAccountUnBindMobile.this.b.sendCaptcha.setVisibility(0);
            }
        };
        this.b.sendCaptcha.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUnBindMobile$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(mobile, activity, view);
            }
        });
        this.b.captcha.addTextChangedListener(new com.up366.mobile.common.adapter.TextWatcherAdapter() { // from class: com.up366.mobile.user.account.update.PageAccountUnBindMobile.2
            @Override // com.up366.mobile.common.adapter.TextWatcherAdapter, android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                super.afterTextChanged(editable);
                com.up366.mobile.user.account.update.PageAccountUnBindMobile.this.refreshState();
            }
        });
        refreshState();
        this.b.btnUnbind.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUnBindMobile$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$3(activity, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(java.lang.String str, final android.app.Activity activity, android.view.View view) {
        this.b.sendCaptcha.setVisibility(4);
        this.b.captchaTip.setVisibility(0);
        this.timerStart = true;
        this.timer.start();
        com.up366.mobile.common.logic.Auth.mgr().getVerificationCode(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUnBindMobile$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initView$1(activity, response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.app.Activity activity, com.up366.common.http.Response response, java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageAccountUnBindMobile - PageAccountUnBindMobile - 发送验证码 result : ");
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
                com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(activity, activity.getString(com.up366.mobile.R.string.code_send_success));
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
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.update.PageAccountUnBindMobile$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() throws java.lang.Exception {
        this.b.captcha.showSoftInput(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(android.app.Activity activity, android.view.View view) {
        doUnbind(activity);
    }

    private void doUnbind(final android.app.Activity activity) {
        com.up366.common.log.Logger.info("TAG - PageAccountUnBindMobile - doUnbind - 解绑手机号");
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "解绑中");
        com.up366.mobile.common.logic.Auth.cur().info().unBindUserPhone(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile(), this.b.captcha.getTrimText(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUnBindMobile$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.user.account.update.PageAccountUnBindMobile.lambda$doUnbind$4(activity, response, obj);
            }
        });
    }

    static /* synthetic */ void lambda$doUnbind$4(android.app.Activity activity, com.up366.common.http.Response response, java.lang.Object obj) {
        if (response.isError()) {
            com.up366.common.log.Logger.info("TAG - PageAccountUnBindMobile - doUnbind - " + response.toString());
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "修改失败:网络原因，请稍\n后再试！");
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
        com.up366.mobile.common.logic.Auth.getUserInfo().setMobile("");
        com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("account_unbind_mobile_success").invalid();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.ClosePageUpdateMobileEvent());
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTimer() {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.activity);
        this.timerStart = false;
        this.timer.cancel();
        this.b.captchaTip.setText("");
        this.b.sendCaptcha.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshState() {
        if (this.b.captcha.getTrimText().length() == 6) {
            this.b.btnUnbind.setEnabled(true);
        } else {
            this.b.btnUnbind.setEnabled(false);
        }
    }
}
