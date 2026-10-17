package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UpdatePhonePasswordActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding binding;
    private android.os.CountDownTimer timer;
    private boolean timerStart = false;
    private java.lang.String mobileRightText = "获取验证码";
    private boolean isMustUpdate = false;
    private java.util.List<java.lang.String> weakPasswordList = null;
    private final java.lang.String CACHE_WEAK_PASSWORD_KEY = "CACHE_WEAK_PASSWORD_KEY";

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "login_set_phone_pwd";
    }

    public static void start(android.app.Activity activity) {
        activity.startActivity(new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.main.UpdatePhonePasswordActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_update_phone_password_layout);
        initData();
        initView();
    }

    private void initData() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda17
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initData$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$2() throws java.lang.Exception {
        java.lang.String str = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadSync("CACHE_WEAK_PASSWORD_KEY", java.lang.String.class);
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            str = "[]";
        }
        this.weakPasswordList = com.alibaba.fastjson.JSON.parseArray(str, java.lang.String.class);
        com.up366.mobile.common.logic.Auth.cur().info().fetchPersonInfo(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda13
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initData$1(response, (java.lang.String) obj);
            }
        });
        com.up366.common.http.NetHolder<java.lang.String> netHolderFetchWeakPassword = com.up366.mobile.common.logic.Auth.mgr().fetchWeakPassword();
        if (netHolderFetchWeakPassword.resp.isError()) {
            return;
        }
        com.up366.mobile.common.logic.Auth.cur().cache().put("CACHE_WEAK_PASSWORD_KEY", netHolderFetchWeakPassword.info, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_6);
        this.weakPasswordList = com.alibaba.fastjson.JSON.parseArray(netHolderFetchWeakPassword.info, java.lang.String.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$1(com.up366.common.http.Response response, java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initData$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$0() throws java.lang.Exception {
        this.binding.toolbarLayout.setTitle(com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile()) ? "绑定手机号并修改密码" : "修改密码");
        if (!com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile())) {
            this.binding.mobile.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile());
            if (!com.up366.mobile.common.logic.Auth.getUserInfo().getMobile().contains("*")) {
                this.binding.mobile.setEnabled(false);
                return;
            } else {
                this.binding.mobile.setEnabled(true);
                return;
            }
        }
        this.binding.mobile.setEnabled(true);
    }

    private void initView() {
        this.isMustUpdate = com.up366.mobile.common.logic.Auth.cur().config().isMustChangePwd() || com.up366.mobile.common.logic.Auth.cur().config().isMustBindPhone();
        this.binding.titleBack.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$3(view);
            }
        });
        this.binding.toolbarLayout.setTitle(com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile()) ? "绑定手机号并修改密码" : "修改密码");
        this.timer = new android.os.CountDownTimer(60000L, 1000L) { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.main.UpdatePhonePasswordActivity.this.binding.captcha.setRightText("重新获取(" + ((j / 1000) + 1) + ")");
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.main.UpdatePhonePasswordActivity.this.resetTimer();
                com.up366.mobile.main.UpdatePhonePasswordActivity.this.refreshState();
            }
        };
        this.binding.errorTip.setVisibility(4);
        this.binding.errorTipPassword.setVisibility(4);
        this.binding.errorTipAgainPassword.setVisibility(4);
        this.binding.mobile.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$4(view, z);
            }
        });
        this.binding.password.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$5(view, z);
            }
        });
        this.binding.passwordAgain.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$6(view, z);
            }
        });
        this.binding.mobile.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$7(appEditTextView);
            }
        });
        this.binding.password.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$8(appEditTextView);
            }
        });
        this.binding.passwordAgain.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$9(appEditTextView);
            }
        });
        this.binding.mobile.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$10(view, z);
            }
        });
        this.binding.captcha.setRightClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$11(view);
            }
        });
        this.binding.captcha.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda10
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$12(appEditTextView);
            }
        });
        this.binding.btnSubmit.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$13(view);
            }
        });
        com.up366.mobile.main.NoMessageCodeTipHelper.INSTANCE.initView(this.binding.btnNoCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$3(android.view.View view) {
        if (this.isMustUpdate) {
            com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.removeAccount(com.up366.mobile.common.logic.Auth.UID());
            com.up366.mobile.user.account.login.AccountLoginActivity.open(this);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(android.view.View view, boolean z) {
        if (!z) {
            java.lang.String trimText = this.binding.mobile.getTrimText();
            if (trimText.length() > 0 && (trimText.length() != 11 || !trimText.startsWith("1"))) {
                this.binding.errorTip.setVisibility(0);
                return;
            } else {
                this.binding.errorTip.setVisibility(4);
                return;
            }
        }
        this.binding.errorTip.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(android.view.View view, boolean z) {
        if (!z) {
            if (this.binding.password.getTrimText().length() > 0 && !com.up366.mobile.common.utils.PasswordValidateUtils.verifyPasswordV2(this.binding.password.getTrimText())) {
                this.binding.errorTipPassword.setVisibility(0);
                this.binding.errorTipPassword.setText("密码至少由数字、大小写字母组成的8-16位字符");
            } else if (this.binding.password.getTrimText().length() > 0 && isWeakPassword(this.binding.password.getTrimText())) {
                this.binding.errorTipPassword.setVisibility(0);
                this.binding.errorTipPassword.setText("密码过于简单，请重新输入");
            } else {
                this.binding.errorTipPassword.setVisibility(4);
            }
            showAgainPasswordTip();
            return;
        }
        this.binding.errorTipPassword.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(android.view.View view, boolean z) {
        if (!z) {
            showAgainPasswordTip();
            return;
        }
        if (this.binding.errorTipAgainPassword.getVisibility() == 0) {
            this.binding.passwordAgain.setText("");
        }
        this.binding.errorTipAgainPassword.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$7(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$8(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$9(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$10(android.view.View view, boolean z) {
        if (!z) {
            java.lang.String trimText = this.binding.mobile.getTrimText();
            if (trimText.length() > 0 && (trimText.length() != 11 || !trimText.startsWith("1"))) {
                this.binding.errorTip.setVisibility(0);
                return;
            } else {
                this.binding.errorTip.setVisibility(4);
                return;
            }
        }
        this.binding.errorTip.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$11(android.view.View view) {
        sendCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$12(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$13(android.view.View view) {
        if (this.binding.btnSubmit.isEnabled()) {
            doValid(this, view);
        }
    }

    private void showAgainPasswordTip() {
        if (this.binding.passwordAgain.getTrimText().length() > 0 && !this.binding.passwordAgain.getTrimText().equals(this.binding.password.getTrimText())) {
            this.binding.errorTipAgainPassword.setVisibility(0);
        } else {
            this.binding.errorTipAgainPassword.setVisibility(4);
        }
    }

    private void doValid(final android.app.Activity activity, android.view.View view) {
        final java.lang.String trimText = this.binding.mobile.getTrimText();
        final java.lang.String trimText2 = this.binding.captcha.getTrimText();
        final java.lang.String trimText3 = this.binding.password.getTrimText();
        if (!trimText3.equals(this.binding.passwordAgain.getTrimText())) {
            this.binding.errorTipAgainPassword.setVisibility(0);
            this.binding.passwordAgain.clearFocus();
        } else if (trimText.length() != 11 || !trimText.startsWith("1")) {
            this.binding.errorTip.setVisibility(0);
            this.binding.mobile.clearFocus();
        } else {
            final int i = hasMobile() ? 1 : 2;
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "");
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda14
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.main.UpdatePhonePasswordActivity.lambda$doValid$19(trimText3, trimText, trimText2, i, activity);
                }
            });
        }
    }

    static /* synthetic */ void lambda$doValid$19(java.lang.String str, final java.lang.String str2, java.lang.String str3, int i, final android.app.Activity activity) throws java.lang.Exception {
        final java.lang.String lowerCase = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5(str).toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase();
        com.up366.mobile.common.logic.Auth.mgr().resetPassword(str2, lowerCase, str3, i, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda15
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.main.UpdatePhonePasswordActivity.lambda$doValid$18(activity, str2, lowerCase, response, (java.lang.String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$doValid$18(final android.app.Activity activity, final java.lang.String str, final java.lang.String str2, com.up366.common.http.Response response, java.lang.String str3) {
        if (response.isError()) {
            if (response.getCode() == 12) {
                final com.up366.mobile.main.ChangeMobileDialog.TipUserInfo tipUserInfo = (com.up366.mobile.main.ChangeMobileDialog.TipUserInfo) com.alibaba.fastjson.JSON.parseObject(response.getResponse(), com.up366.mobile.main.ChangeMobileDialog.TipUserInfo.class);
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        android.app.Activity activity2 = activity;
                        com.up366.mobile.main.ChangeMobileDialog.TipUserInfo tipUserInfo2 = tipUserInfo;
                        java.lang.String str4 = str;
                        com.up366.mobile.main.ChangeMobileDialog.show(activity2, tipUserInfo2, str4, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda19
                            @Override // com.up366.common.callback.ICallbackCode
                            public final void onResult(int i) {
                                com.up366.mobile.main.UpdatePhonePasswordActivity.lambda$doValid$16(activity2, str4, str, i);
                            }
                        });
                    }
                });
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.show(activity, response.getInfo());
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        com.up366.mobile.common.logic.Auth.updateAuthInfo(com.up366.mobile.common.logic.Auth.UID(), com.up366.mobile.common.logic.Auth.getUserInfo().getUsername(), str2);
        com.up366.mobile.common.logic.Auth.getUserInfo().setMobile(str);
        com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
        activity.finish();
    }

    static /* synthetic */ void lambda$doValid$16(final android.app.Activity activity, final java.lang.String str, final java.lang.String str2, int i) {
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "");
            com.up366.mobile.main.ChangeMobileDialog.show1(activity, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda20
                @Override // com.up366.common.callback.ICallbackCode
                public final void onResult(int i2) {
                    com.up366.mobile.main.UpdatePhonePasswordActivity.lambda$doValid$15(activity, str, str2, i2);
                }
            });
        }
    }

    static /* synthetic */ void lambda$doValid$15(final android.app.Activity activity, final java.lang.String str, final java.lang.String str2, int i) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        if (i != 0) {
            return;
        }
        com.up366.mobile.common.logic.Auth.mgr().transformPhonePassword(str, str2, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda11
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.main.UpdatePhonePasswordActivity.lambda$doValid$14(activity, str2, str, response, (java.lang.String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$doValid$14(android.app.Activity activity, java.lang.String str, java.lang.String str2, com.up366.common.http.Response response, java.lang.String str3) {
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(activity, response.getInfo());
            return;
        }
        com.up366.mobile.common.logic.Auth.updateAuthInfo(com.up366.mobile.common.logic.Auth.UID(), com.up366.mobile.common.logic.Auth.getUserInfo().getUsername(), str);
        com.up366.mobile.common.logic.Auth.getUserInfo().setMobile(str2);
        com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
        activity.finish();
    }

    private boolean isWeakPassword(java.lang.String str) {
        java.util.List<java.lang.String> list = this.weakPasswordList;
        if (list != null && list.size() != 0) {
            java.util.Iterator<java.lang.String> it = this.weakPasswordList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void sendCode() {
        this.binding.mobile.clearFocus();
        this.binding.captcha.setRightEnable(false);
        this.timerStart = true;
        this.timer.start();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "获取验证码中");
        this.mobileRightText = "重新获取";
        com.up366.mobile.common.logic.Auth.mgr().sendVerificationCode(this.binding.mobile.getTrimText(), 0, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda18
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$sendCode$21(response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$sendCode$21(com.up366.common.http.Response response, java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageResetBySms - PageResetBySms - 发送验证码 result : ");
        sb.append(!response.isError());
        sb.append(" code:");
        sb.append(response.getCode());
        com.up366.common.log.Logger.info(sb.toString());
        if (response.isError()) {
            resetTimer();
            refreshState();
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "验证码获取失败:网络原因\n请稍后再试！");
                return;
            }
            if (response.getCode() == 5) {
                com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, response.getInfo());
                return;
            } else if (response.getCode() == 3) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "今日获取验证码次数已达\n上限（10次）请明日再试");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, getString(com.up366.mobile.R.string.code_send_success));
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.main.UpdatePhonePasswordActivity$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$sendCode$20();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendCode$20() throws java.lang.Exception {
        this.binding.captcha.showSoftInput(true);
    }

    public void onBackPressed() {
        if (this.isMustUpdate) {
            return;
        }
        super.onBackPressed();
    }

    private boolean hasMobile() {
        return !com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile());
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
        this.binding.btnSubmit.setEnabled(this.binding.captcha.getTrimText().length() > 0 && this.binding.mobile.getTrimText().length() == 11 && this.binding.password.getTrimText().length() > 7 && this.binding.passwordAgain.getTrimText().length() > 7 && !isWeakPassword(this.binding.password.getTrimText()));
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.StartPageTaskEvent());
    }
}
