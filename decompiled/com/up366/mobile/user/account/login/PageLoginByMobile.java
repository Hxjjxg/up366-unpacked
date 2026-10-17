package com.up366.mobile.user.account.login;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageLoginByMobile {
    private final android.app.Activity activity;
    private final com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding b;
    private final android.os.CountDownTimer timer;
    private boolean timerStart = false;
    private java.lang.String mobileRightText = "获取验证码";

    public PageLoginByMobile(final android.app.Activity activity, androidx.core.widget.NestedScrollView nestedScrollView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, final boolean z) {
        this.activity = activity;
        collapsingToolbarLayout.setTitle("手机号登录");
        com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding accountActivityLoginByMobileLayoutBinding = (com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_activity_login_by_mobile_layout, nestedScrollView, true);
        this.b = accountActivityLoginByMobileLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountActivityLoginByMobileLayoutBinding.getRoot().getPaddingLeft());
        this.timer = new android.os.CountDownTimer(60000L, 1000L) { // from class: com.up366.mobile.user.account.login.PageLoginByMobile.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.user.account.login.PageLoginByMobile.this.b.captcha.setRightText("重新获取(" + ((j / 1000) + 1) + ")");
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.user.account.login.PageLoginByMobile.this.resetTimer();
                com.up366.mobile.user.account.login.PageLoginByMobile.this.refreshState();
            }
        };
        accountActivityLoginByMobileLayoutBinding.mobile.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$new$0(appEditTextView);
            }
        });
        accountActivityLoginByMobileLayoutBinding.mobile.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda5
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z2) {
                this.f$0.lambda$new$1(view, z2);
            }
        });
        accountActivityLoginByMobileLayoutBinding.errorTip.setVisibility(4);
        accountActivityLoginByMobileLayoutBinding.captcha.setRightClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$4(activity, view);
            }
        });
        accountActivityLoginByMobileLayoutBinding.captcha.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$new$5(appEditTextView);
            }
        });
        accountActivityLoginByMobileLayoutBinding.btnLogin.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$8(activity, z, view);
            }
        });
        accountActivityLoginByMobileLayoutBinding.btnLoginShanyan.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.login.PageLoginByMobile.lambda$new$12(activity, z, view);
            }
        });
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$13();
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
        com.up366.mobile.common.logic.Auth.mgr().getVerificationCode(this.b.mobile.getTrimText(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda13
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$new$3(activity, response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(android.app.Activity activity, com.up366.common.http.Response response, java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageLoginByMobile - PageLoginByMobile - 发送验证码 result : ");
        sb.append(!response.isError());
        com.up366.common.log.Logger.info(sb.toString());
        if (response.isError()) {
            resetTimer();
            refreshState();
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "验证码获取失败\n网络不佳，请稍后重试！");
                return;
            }
            if (response.getCode() == 8) {
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
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$2();
            }
        });
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
    public /* synthetic */ void lambda$new$8(final android.app.Activity activity, final boolean z, android.view.View view) {
        com.up366.common.log.Logger.info("TAG - PageLoginByMobile - PageLoginByMobile - 立即登录");
        resetTimer();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "正在加载");
        final java.lang.String trimText = this.b.mobile.getTrimText();
        final java.lang.String trimText2 = this.b.captcha.getTrimText();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$7(trimText, trimText2, z, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(java.lang.String str, java.lang.String str2, boolean z, final android.app.Activity activity) throws java.lang.Exception {
        com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.startLogin(2);
        final com.up366.common.http.Response response = com.up366.mobile.common.logic.Auth.mgr().handleOnceLoginHolder(com.up366.mobile.common.logic.Auth.mgr().validateMobileCode(str, str2), z).resp;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$6(activity, response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(android.app.Activity activity, com.up366.common.http.Response response) throws java.lang.Exception {
        refreshState();
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response.getInfo());
            return;
        }
        if (com.up366.mobile.common.logic.Auth.cur().config().isMoLiYingUser()) {
            com.up366.common.log.Logger.info("TAG - PageLoginByMobile - PageLoginByMobile - 立即登录 - 跳转到魔法学院");
            com.up366.mobile.AiSkipHelper.skipToMain(activity);
        } else {
            activity.startActivity(new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class));
        }
        activity.finish();
    }

    static /* synthetic */ void lambda$new$12(final android.app.Activity activity, final boolean z, final android.view.View view) {
        final android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(activity);
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().openLoginAuth(activity, frameLayout, "手机号登录", "一键登录", "换个手机号登录", "请勾选下方协议再登录哦~", new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda12
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                com.up366.mobile.user.account.login.PageLoginByMobile.lambda$new$11(view, frameLayout, z, activity, i, str, (java.lang.String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$new$11(android.view.View view, final android.view.ViewGroup viewGroup, final boolean z, final android.app.Activity activity, int i, java.lang.String str, final java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - PageLoginByMobile - onResult - code = [" + i + "], info = [" + str + "], obj = [" + str2 + "]");
        if (i == -2) {
            com.up366.common.log.Logger.info("TAG - PageLoginByMobile - 获取token失败 ：" + viewGroup);
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "获取本机号码失败");
            return;
        }
        if (i == -1) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "获取本机号码失败");
            return;
        }
        if (i == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(view);
            com.up366.common.log.Logger.info("TAG - PageLoginByMobile - 打开成功");
            return;
        }
        if (i == 1) {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(viewGroup, "登录中");
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.user.account.login.PageLoginByMobile.lambda$new$10(str2, z, viewGroup, activity);
                }
            });
        } else if (i == 2) {
            com.up366.common.log.Logger.info("TAG - PageLoginByMobile - 换个手机号登录");
            com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
        } else {
            if (i != 3) {
                return;
            }
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(view);
            com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
        }
    }

    static /* synthetic */ void lambda$new$10(java.lang.String str, boolean z, final android.view.ViewGroup viewGroup, final android.app.Activity activity) throws java.lang.Exception {
        com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.startLogin(3);
        final com.up366.common.http.Response response = com.up366.mobile.common.logic.Auth.mgr().handleOnceLoginHolder(com.up366.mobile.common.logic.Auth.mgr().validateFlash(str), z).resp;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.PageLoginByMobile$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.user.account.login.PageLoginByMobile.lambda$new$9(viewGroup, response, activity);
            }
        });
    }

    static /* synthetic */ void lambda$new$9(android.view.ViewGroup viewGroup, com.up366.common.http.Response response, android.app.Activity activity) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(viewGroup);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, response.getInfo());
            return;
        }
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
        if (com.up366.mobile.common.logic.Auth.cur().config().isMoLiYingUser()) {
            com.up366.common.log.Logger.info("TAG - PageLoginByMobile - PageLoginByMobile - 立即登录 - 跳转到魔法学院");
            com.up366.mobile.AiSkipHelper.skipToMain(activity);
        } else {
            activity.startActivity(new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class));
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$13() throws java.lang.Exception {
        this.b.mobile.showSoftInput(true);
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
            this.b.btnLogin.setEnabled(true);
        } else {
            this.b.btnLogin.setEnabled(false);
        }
    }
}
