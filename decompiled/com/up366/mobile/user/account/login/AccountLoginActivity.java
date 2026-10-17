package com.up366.mobile.user.account.login;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountLoginActivity extends com.up366.mobile.common.base.BaseActivity {
    private static final java.lang.String INTENT_KEY_FROM_SWITCH = "isFromSwitch";
    private static final java.lang.String INTENT_KEY_USER_NAME = "username";
    public static final int LOGIN_TYPE_COMMON = 0;
    public static final int LOGIN_TYPE_STUDENT_NUMBER = 1;
    private com.up366.mobile.databinding.AccountLoginActivityLayoutBinding b;
    private boolean isFromSwitch;
    private int authType = 0;
    private boolean isCheckedAgreement = false;
    private final java.util.List<android.text.style.ClickableSpan> reference = new java.util.ArrayList();
    private volatile boolean loginByWechatIng = false;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface LoginType {
    }

    static /* synthetic */ void lambda$initView$21() throws java.lang.Exception {
    }

    static /* synthetic */ void lambda$onPause$8() {
    }

    static /* synthetic */ void lambda$showFreezeByUserLogOffDialog$50(android.view.View view) {
    }

    static /* synthetic */ void lambda$showLoginFailedCount$37(android.view.View view) {
    }

    static /* synthetic */ void lambda$showTipDialog$51(android.view.View view) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "login_pwd";
    }

    public static void open(android.content.Context context) {
        open(context, false, "");
    }

    public static void open(android.content.Context context, boolean z, java.lang.String str) {
        if (context instanceof com.up366.mobile.user.account.login.AccountLoginActivity) {
            com.up366.common.log.Logger.info("TAG - AccountLoginActivity - open - context = [self]");
            return;
        }
        if (context == null) {
            context = com.up366.common.global.GB.get().getApplicationContext();
        }
        if (context == null) {
            com.up366.common.log.Logger.error("TAG - AccountLoginActivity - open - context is null");
            return;
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.user.account.login.AccountLoginActivity.class);
        if (!(context instanceof android.app.Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra(INTENT_KEY_FROM_SWITCH, z);
        intent.putExtra(INTENT_KEY_USER_NAME, str);
        context.startActivity(intent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.b = (com.up366.mobile.databinding.AccountLoginActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.account_login_activity_layout);
        disableAutofillIfNeeded();
        this.b.forget.setText("忘记密码");
        this.isFromSwitch = getIntent().getBooleanExtra(INTENT_KEY_FROM_SWITCH, false);
        java.lang.String stringExtra = getIntent().getStringExtra(INTENT_KEY_USER_NAME);
        initView();
        this.b.username.setFocusable(false);
        this.b.password.setFocusable(false);
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString("remember_uname", "");
        com.up366.mobile.common.views.AppEditTextView appEditTextView = this.b.username;
        if (!this.isFromSwitch) {
            stringExtra = string;
        }
        appEditTextView.setText(stringExtra);
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda48
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() throws java.lang.Exception {
        this.b.username.setFocusable(true);
        this.b.password.setFocusable(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$onCreate$2(android.view.View view) {
        com.up366.mobile.common.utils.PlatformUtils.switchTargetHost(this, new java.lang.Runnable() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() {
        this.b.host.setText(com.up366.mobile.common.utils.PlatformUtils.getTargetHostInner());
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("AccountLoginActivityResume").invalid();
        if (this.loginByWechatIng) {
            com.up366.common.task.TaskUtils.postLazyTaskMain("btnLoginWechatClick", 3000, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda32
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onResume$3();
                }
            });
        }
        java.lang.String str = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("auto-fill-username");
        if (str != null) {
            this.b.username.setText(str);
            com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda34
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onResume$4();
                }
            });
        }
        java.lang.String str2 = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("register-success-tip");
        if (!com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, str2);
        }
        java.lang.String str3 = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("account-reset-password-success");
        if (!com.up366.common.StringUtils.isEmptyOrNull(str3)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, str3);
        }
        initIMReloginDialog();
        initAutoLoginFailedDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onResume$3() throws java.lang.Exception {
        if (this.loginByWechatIng) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            com.up366.mobile.common.utils.ToastPopupUtil.show("登录失败，请稍后重试");
        }
        refreshBtnState();
        this.loginByWechatIng = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$4() throws java.lang.Exception {
        this.b.password.showSoftInput(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initAutoLoginFailedDialog() {
        com.up366.common.http.Response response = (com.up366.common.http.Response) com.up366.mobile.common.logic.Auth.mgr().cache().loadMemorySync(com.up366.mobile.common.base.Constants.APP_CACHE_AUTO_LOGIN_FAILED);
        if (response == null) {
            return;
        }
        com.up366.mobile.common.logic.Auth.mgr().cache().clear(com.up366.mobile.common.base.Constants.APP_CACHE_AUTO_LOGIN_FAILED);
        int code = response.getCode();
        if (code != -50) {
            if (code != -27) {
                switch (code) {
                    case com.up366.common.http.Response.RESULT_SSO_LOGIN_LOCKED_TERMINAL /* -31 */:
                        com.up366.mobile.common.dialog.LoginAccountLockDialog.show("lock-device", response.getInfo());
                        break;
                    case com.up366.common.http.Response.RESULT_SSO_LOGIN_FREEZE /* -30 */:
                        showFreezeDialog(this);
                        break;
                    case com.up366.common.http.Response.RESULT_SSO_LOGIN_LOCKED /* -29 */:
                        com.up366.mobile.common.dialog.LoginAccountLockDialog.show("lock-account", response.getInfo());
                        break;
                }
                return;
            }
            showTipDialog(this, "登录失败，请重新登录");
            return;
        }
        showFreezeByUserLogOffDialog(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initIMReloginDialog() {
        if (((java.lang.Boolean) com.up366.mobile.common.logic.Auth.mgr().cache().loadMemorySync("logout-reason-im-user_login_another_device")) != null) {
            final java.lang.String str = (java.lang.String) com.up366.mobile.common.logic.Auth.mgr().cache().loadMemorySync("logout-reason-im-user_login_another_device-auth-text");
            com.up366.mobile.common.logic.Auth.mgr().cache().clear("logout-reason-im-user_login_another_device");
            com.up366.mobile.common.logic.Auth.mgr().cache().clear("logout-reason-im-user_login_another_device-auth-text");
            com.up366.mobile.common.dialog.AppDialog.create(this).title("提示").message("您的账号已在其他设备登录！").btnOne("重新登录", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda18
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$initIMReloginDialog$7(str, view);
                }
            }).setCancelable(false).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initIMReloginDialog$7(final java.lang.String str, android.view.View view) {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.b.getRoot(), "登录中");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda19
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initIMReloginDialog$6(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initIMReloginDialog$6(java.lang.String str) throws java.lang.Exception {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        final com.up366.common.http.NetHolder<java.lang.Object> netHolderDoLoginSync = com.up366.mobile.common.logic.Auth.mgr().doLoginSync(object.getString(INTENT_KEY_USER_NAME), object.getString("password"), true, object.getIntValue("authType"), object.getString("openId"), this.isFromSwitch);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda22
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initIMReloginDialog$5(netHolderDoLoginSync);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initIMReloginDialog$5(com.up366.common.http.NetHolder netHolder) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.b.getRoot());
        if (netHolder.resp.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(this.b.getRoot(), netHolder.resp.getInfo());
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("AccountLoginActivityResume").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.user.account.login.AccountLoginActivity.lambda$onPause$8();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (this.isFromSwitch) {
            finish();
            return;
        }
        if (com.up366.mobile.closepad.PadConfigHelper.INSTANCE.isTX18Pad()) {
            com.up366.common.log.Logger.info("TAG - AccountLoginActivity - onBackPressed - PadConfigHelper.INSTANCE.isTX18Pad()");
            return;
        }
        if (com.up366.mobile.common.utils.DataPostDelay.isNoOutOfDate("press_back")) {
            if (com.up366.qmui.util.QMUIDeviceHelper.isTablet(this)) {
                java.lang.System.exit(0);
                return;
            } else {
                finishAffinity();
                return;
            }
        }
        com.up366.mobile.common.utils.DataPostDelay.addCacheFlag("press_back", 3);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "再按一次返回键退出应用。");
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside(motionEvent, this.b.username, this.b.password);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void disableAutofillIfNeeded() {
        if (android.os.Build.VERSION.SDK_INT < 26 || !isHuaweiOrHonorDevice()) {
            return;
        }
        this.b.container.setImportantForAutofill(8);
        this.b.username.setImportantForAutofill(8);
        this.b.password.setImportantForAutofill(8);
    }

    private boolean isHuaweiOrHonorDevice() {
        java.lang.String lowerCase = android.os.Build.BRAND == null ? "" : android.os.Build.BRAND.toLowerCase(java.util.Locale.ROOT);
        java.lang.String lowerCase2 = android.os.Build.MANUFACTURER != null ? android.os.Build.MANUFACTURER.toLowerCase(java.util.Locale.ROOT) : "";
        return lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_HW) || lowerCase2.contains(com.igexin.assist.util.AssistUtils.BRAND_HW) || lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_HON) || lowerCase2.contains(com.igexin.assist.util.AssistUtils.BRAND_HON);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.b.toolbarLayout.setExpandedTitleMarginStart(this.b.container.getPaddingLeft());
        this.b.titleBackView.setVisibility(this.isFromSwitch ? 0 : 8);
        this.b.username.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda33
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$9(appEditTextView);
            }
        });
        this.b.password.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda52
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$10(appEditTextView);
            }
        });
        this.b.username.setOnEditActionListener(new com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda53
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener
            public final void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$11(appEditTextView);
            }
        });
        this.b.password.setOnEditActionListener(new com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener
            public final void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$12(appEditTextView);
            }
        });
        this.b.btnLogin.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$15(view);
            }
        });
        this.b.btnLoginTourist.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append(this.b.btnLoginTourist.getText()).setSpan(new android.text.style.UnderlineSpan()).build());
        this.b.btnLoginTourist.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$18(view);
            }
        });
        this.b.btnLoginWechat.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$24(view);
            }
        });
        this.b.btnLoginQq.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$27(view);
            }
        });
        this.b.btnMobileLogin.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$31(view);
            }
        });
        this.b.btnLoginStudentNum.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$32(view);
            }
        });
        this.b.forget.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$33(view);
            }
        });
        this.b.register.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$34(view);
            }
        });
        this.b.ivEvs.setAlpha(0.0f);
        this.b.ivHideIcon.setAlpha(1.0f);
        this.b.password.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda50
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$35(view, z);
            }
        });
        if (com.up366.mobile.common.logic.Auth.cur().config().isEnableThirdLogin() && !com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            visible(this.b.btnLoginQq, this.b.btnLoginWechat, this.b.descQq, this.b.descWechat, this.b.btnLoginTourist, this.b.btnLoginStudentNum, this.b.descStudentNum);
        } else {
            gone(this.b.btnLoginQq, this.b.descQq, this.b.btnLoginWechat, this.b.descWechat, this.b.btnLoginTourist, this.b.btnLoginStudentNum, this.b.descStudentNum);
        }
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            gone(this.b.btnMobileLogin);
        }
        this.b.acceptDealChecbox.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$36(view);
            }
        });
        android.text.SpannableString spannableString = new android.text.SpannableString(this.b.licenseText.getText());
        spannableString.setSpan(getClickSpan(this, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.LICENSE_URL)), 10, 18, 18);
        spannableString.setSpan(getClickSpan(this, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL)), 18, 24, 18);
        spannableString.setSpan(getClickSpan(this, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL)), 24, 34, 18);
        this.b.licenseText.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.b.licenseText.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$9(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshBtnState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$10(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshBtnState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$11(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        this.b.password.showSoftInput(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$12(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        if (this.b.btnLogin.isEnabled()) {
            this.b.btnLogin.callOnClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$15(android.view.View view) {
        if (!this.isCheckedAgreement) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("请先阅读并勾选相关协议");
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "登录中");
        disableLoginButtons();
        final java.lang.String lowerCase = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5(this.b.password.getTrimText()).toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase();
        com.up366.common.http.HttpUtilsUp.clearCookies();
        this.authType = 0;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda14
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$14(lowerCase);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$14(java.lang.String str) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<java.lang.Object> netHolderDoLoginSync = com.up366.mobile.common.logic.Auth.mgr().doLoginSync(this.b.username.getTrimText(), str, true, 0, "", this.isFromSwitch);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$13(netHolderDoLoginSync);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$13(com.up366.common.http.NetHolder netHolder) throws java.lang.Exception {
        refreshBtnState();
        if (netHolder.resp.getCode() == -27) {
            showLoginFailedCount(this, netHolder);
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put(INTENT_KEY_USER_NAME, this.b.username.getTrimText());
            jSONObject.put("errorCode", java.lang.Integer.valueOf(netHolder.resp.getCode()));
            jSONObject.put("errorMessage", netHolder.resp.getInfo());
            com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.USER, "failed", com.up366.mobile.common.onlinelog.OpLogData.Event.LOG_IN, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$18(android.view.View view) {
        if (!this.isCheckedAgreement) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("请先阅读并勾选相关协议");
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "登录中");
        disableLoginButtons();
        com.up366.common.http.HttpUtilsUp.clearCookies();
        this.authType = 0;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda15
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$17();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$17() throws java.lang.Exception {
        final com.up366.common.http.NetHolder<java.lang.String> touristUsername = com.up366.mobile.common.logic.Auth.mgr().getTouristUsername();
        if (touristUsername.resp.isError()) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda28
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initView$16(touristUsername);
                }
            });
        } else {
            com.up366.mobile.common.logic.Auth.mgr().loginTourist(touristUsername.info);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda10(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$16(com.up366.common.http.NetHolder netHolder) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.show(netHolder.resp.getInfo());
        refreshBtnState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$24(android.view.View view) {
        if (!this.isCheckedAgreement) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("请先阅读并勾选相关协议");
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "登录中");
        disableLoginButtons();
        this.loginByWechatIng = true;
        com.up366.common.task.TaskUtils.postLazyTaskMain("btnLoginWechatClick", 3000, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda20
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$20();
            }
        });
        new com.up366.mobile.common.helper.WeixinAuthHelper().getOpenId(this, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda21
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$initView$23(i, str, (java.lang.String[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$20() throws java.lang.Exception {
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("AccountLoginActivityResume").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initView$19();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$19() {
        enable(this.b.btnLoginWechat);
        this.b.btnLoginWechat.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$23(int i, java.lang.String str, final java.lang.String[] strArr) {
        com.up366.common.task.TaskUtils.postLazyTaskMain("btnLoginWechatClick", 0, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda26
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.user.account.login.AccountLoginActivity.lambda$initView$21();
            }
        });
        this.loginByWechatIng = false;
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            refreshBtnState();
            if (i == -3) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "取消登录");
                return;
            }
            if (i == -1) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "登录失败:你未安装微信！");
                return;
            } else if (i == -4) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "登录失败:授权失败！");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "登录失败:网络原因，请稍\n后再试！");
                return;
            }
        }
        this.authType = 1;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda27
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$22(strArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$22(java.lang.String[] strArr) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.mgr().doLoginSync(null, null, true, 1, strArr[0], this.isFromSwitch);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda10(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$27(android.view.View view) {
        if (!this.isCheckedAgreement) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("请先阅读并勾选相关协议");
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "登录中");
        disableLoginButtons();
        new com.up366.mobile.common.helper.QQAuthHelper().getOpenId(this, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda17
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$initView$26(i, str, (java.lang.String[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$26(int i, java.lang.String str, final java.lang.String[] strArr) {
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            refreshBtnState();
            if (i == -3) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "取消登录");
                return;
            } else if (i == -1) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "登录失败:你未安装QQ！");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "登录失败:网络原因，请稍\n后再试！");
                return;
            }
        }
        this.authType = 2;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$25(strArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$25(java.lang.String[] strArr) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.mgr().doLoginSync(null, null, true, 2, strArr[0], this.isFromSwitch);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda10(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$31(android.view.View view) {
        if (!this.isCheckedAgreement) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("请先阅读并勾选相关协议");
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "处理中");
        disableLoginButtons();
        final android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this);
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().openLoginAuth(this, frameLayout, "手机号登录", "一键登录", "换个手机号登录", "请勾选下方协议再登录哦~", new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda31
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$initView$30(frameLayout, i, str, (java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$30(final android.view.ViewGroup viewGroup, int i, java.lang.String str, final java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - AccountLoginActivity - onResult - code = [" + i + "], info = [" + str + "], obj = [" + str2 + "]");
        if (i == -2) {
            com.up366.common.log.Logger.info("TAG - AccountLoginActivity - 获取token失败 ：" + viewGroup);
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            refreshBtnState();
            if (com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, "服务器异常，请稍后重试");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, "网络好像走丢了\n请稍后重试!");
                return;
            }
        }
        if (i == -1) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            refreshBtnState();
            com.up366.common.log.Logger.info("TAG - AccountLoginActivity - 打开失败，使用手动输入手机号登录页面");
            com.up366.mobile.user.account.AccountActivity.openPage(this, 5, this.isFromSwitch);
            return;
        }
        if (i == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            refreshBtnState();
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("currentpage", "login_quick_login");
            com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.APP, "push", com.up366.mobile.common.onlinelog.OpLogData.Event.NAVIGATE, jSONObject);
            com.up366.common.log.Logger.info("TAG - AccountLoginActivity - 打开成功");
            return;
        }
        if (i == 1) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(viewGroup, "登录中");
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda23
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initView$29(str2, viewGroup);
                }
            });
        } else if (i == 2) {
            com.up366.common.log.Logger.info("TAG - AccountLoginActivity - 换个手机号登录");
            com.up366.mobile.user.account.AccountActivity.openPage(this, 5, this.isFromSwitch);
            finishShanYanActivity();
        } else {
            if (i != 3) {
                return;
            }
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            refreshBtnState();
            finishShanYanActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$29(java.lang.String str, final android.view.ViewGroup viewGroup) throws java.lang.Exception {
        com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.startLogin(3);
        final com.up366.common.http.Response response = com.up366.mobile.common.logic.Auth.mgr().handleOnceLoginHolder(com.up366.mobile.common.logic.Auth.mgr().validateFlash(str), this.isFromSwitch).resp;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda29
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$28(viewGroup, response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$28(android.view.ViewGroup viewGroup, com.up366.common.http.Response response) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(viewGroup);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, response.getInfo());
        } else {
            finishShanYanActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$32(android.view.View view) {
        doLoginByStudentNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$33(android.view.View view) {
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().getPhoneInfo(null);
        com.up366.mobile.user.account.reset.PageSelectReset.openResetPasswordBySmsPage(this, new android.widget.FrameLayout(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$34(android.view.View view) {
        com.up366.mobile.user.account.register.AccountRegisterActivity.open(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$35(android.view.View view, boolean z) {
        if (z) {
            this.b.ivEvs.animate().setDuration(500L).alpha(1.0f).start();
            this.b.ivHideIcon.animate().setDuration(500L).alpha(0.0f).start();
        } else {
            this.b.ivEvs.animate().setDuration(500L).alpha(0.0f).start();
            this.b.ivHideIcon.animate().setDuration(500L).alpha(1.0f).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$36(android.view.View view) {
        if (this.isCheckedAgreement) {
            this.isCheckedAgreement = false;
            this.b.acceptDealChecbox.setImageResource(com.up366.mobile.R.drawable.multiple_selection_regist_gray);
        } else {
            this.isCheckedAgreement = true;
            this.b.acceptDealChecbox.setImageResource(com.up366.mobile.R.drawable.multiple_selection_regist);
        }
    }

    private void finishShanYanActivity() {
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("from", "login_quick_login");
        jSONObject.put("to", "smartroom_home");
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.APP, com.up366.mobile.common.onlinelog.OpLogData.Control.NAVIGATION_POP, com.up366.mobile.common.onlinelog.OpLogData.Event.NAVIGATE, jSONObject);
    }

    private void disableLoginButtons() {
        disable(this.b.btnLogin, this.b.btnLoginQq, this.b.btnLoginWechat, this.b.btnMobileLogin, this.b.btnLoginTourist);
    }

    static void showLoginFailedCount(android.app.Activity activity, com.up366.common.http.NetHolder<java.lang.Object> netHolder) {
        int intValue = com.alibaba.fastjson.JSON.parseObject(netHolder.resp.getResponse()).getIntValue("errorCount");
        if (intValue > 6) {
            android.text.SpannableStringBuilder spannableStringBuilderBuild = new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("密码连续错误10次，账号将被锁定\n").append("你还剩 ").append(java.lang.String.valueOf(10 - intValue)).setSpan(new android.text.style.TextAppearanceSpan(activity, com.up366.mobile.R.style.LoginCount)).append(" 次机会").build();
            new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("我知道了").setSpan(new android.text.style.ForegroundColorSpan(-6710887)).build();
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
            com.up366.mobile.common.dialog.AppDialog.create(activity).title("提示").message(spannableStringBuilderBuild).setBtnCloseVisibility(4).btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda25
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.user.account.login.AccountLoginActivity.lambda$showLoginFailedCount$37(view);
                }
            }).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void doLoginByStudentNumber() {
        com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.open(this, this.isFromSwitch);
    }

    private android.text.style.ClickableSpan getClickSpan(final android.content.Context context, final java.lang.String str) {
        return new com.up366.mobile.common.utils.WeakReferenceClickableSpan(this.reference, new android.text.style.ClickableSpan() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
                intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
                context.startActivity(intent);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(-10715905);
                textPaint.setUnderlineText(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshBtnState() {
        enable(this.b.btnLoginQq, this.b.btnLoginWechat, this.b.btnMobileLogin, this.b.btnLoginTourist);
        if (this.b.username.getTrimText().length() > 0 && this.b.password.getTrimText().length() > 5) {
            this.b.btnLogin.setEnabled(true);
        } else {
            this.b.btnLogin.setEnabled(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        if (com.up366.mobile.common.logic.Auth.cur().config().isMoLiYingUser()) {
            com.up366.common.log.Logger.info("TAG - AccountLoginActivity - onMessageEvent - 跳转到魔法学院");
            com.up366.mobile.AiSkipHelper.skipToMain(this);
        } else {
            startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class));
        }
        java.lang.String username = com.up366.mobile.common.logic.Auth.getUserInfo().getUsername();
        if (!com.up366.mobile.common.logic.Auth.isTourist()) {
            if (this.authType == 0) {
                com.up366.mobile.common.utils.PreferenceUtils.putString("remember_uname", this.b.username.getTrimText());
            } else {
                com.up366.mobile.common.utils.PreferenceUtils.putString("remember_uname", username);
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginFailed authLoginFailed) {
        com.up366.common.log.Logger.info("TAG - AccountLoginActivity - onMessageEvent - code:" + authLoginFailed.getCode() + "  info : " + authLoginFailed.getInfo());
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        refreshBtnState();
        int code = authLoginFailed.getCode();
        java.lang.String info = authLoginFailed.getInfo();
        handleLoginErrorCode(this, code, info, this.authType, 0);
        if (info.contains("-40014") && this.authType == 1 && this.b.btnLoginWechat.getTag() == null) {
            this.b.btnLoginWechat.setTag("btnLoginWechat");
            this.b.btnLoginWechat.callOnClick();
        }
    }

    static void handleLoginErrorCode(final android.app.Activity activity, final int i, final java.lang.String str, final int i2, final int i3) {
        new com.up366.mobile.common.helper.IfHelper().IF(i == -32 && i2 == 1, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda36
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "登录失败:该微信未被绑定！");
            }
        }).IF(i == -32 && i2 == 2, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda38
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "登录失败:该QQ未被绑定！");
            }
        }).IF(i == -32, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda39
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, str);
            }
        }).IF(i == -27, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda40
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.user.account.login.AccountLoginActivity.lambda$handleLoginErrorCode$41(i2, i3, activity, str);
            }
        }).IF(i == -10000, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda41
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "当前没有网络，请检\n查网络后再试！！");
            }
        }).IF(i == -10001 || i == -10002, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda42
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.user.account.login.AccountLoginActivity.lambda$handleLoginErrorCode$44(activity, i);
            }
        }).IF(i == -29, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda43
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.common.dialog.LoginAccountLockDialog.show("lock-account", str);
            }
        }).IF(i == -31, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda45
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.common.dialog.LoginAccountLockDialog.show("lock-device", str);
            }
        }).IF(i == -30, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda46
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.user.account.login.AccountLoginActivity.showFreezeDialog(activity);
            }
        }).IF(i == -50, new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda47
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.user.account.login.AccountLoginActivity.showFreezeByUserLogOffDialog(activity);
            }
        }).DEFAULT(new com.up366.mobile.common.helper.IfHelper.ICallback() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda37
            @Override // com.up366.mobile.common.helper.IfHelper.ICallback
            public final void onResult() {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, str);
            }
        });
    }

    static /* synthetic */ void lambda$handleLoginErrorCode$41(int i, int i2, android.app.Activity activity, java.lang.String str) {
        if (i == 0) {
            if (i2 == 1) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "账号或密码错误");
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, str);
            }
        }
    }

    static /* synthetic */ void lambda$handleLoginErrorCode$44(android.app.Activity activity, int i) {
        if (com.up366.mobile.common.dialog.DialogBlockUser.checkNeedIntercept()) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
            com.up366.mobile.common.dialog.DialogBlockUser.show(activity, 0, i, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda9
                @Override // com.up366.common.callback.ICallbackCode
                public final void onResult(int i2) {
                    com.up366.mobile.common.onlinelog.OpLog.report("5_1_retry_login", "code:" + i2);
                }
            });
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "登录失败:网络原因，请稍\n后再试！");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showFreezeDialog(android.content.Context context) {
        showTipDialog(context, new android.text.SpannableStringBuilder("账号已禁用，请联系客服\n").append(tel(context)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showFreezeByUserLogOffDialog(android.content.Context context) {
        com.up366.mobile.common.dialog.AppDialog.create(context).title("提示").message(new android.text.SpannableStringBuilder("该账号已申请注销，处于冻结期，若你想撤回注销，请拨打客服电话\n").append(tel(context)), android.text.method.LinkMovementMethod.getInstance(), 0).btnBig("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.login.AccountLoginActivity.lambda$showFreezeByUserLogOffDialog$50(view);
            }
        }).show();
    }

    static void showTipDialog(android.content.Context context, java.lang.CharSequence charSequence) {
        com.up366.mobile.common.dialog.AppDialog.create(context).title("提示").message(charSequence, android.text.method.LinkMovementMethod.getInstance(), 0).btnOne("确定", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.login.AccountLoginActivity.lambda$showTipDialog$51(view);
            }
        }).show();
    }

    private static java.lang.CharSequence tel(final android.content.Context context) {
        return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("4006426166").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.user.account.login.AccountLoginActivity.2
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                try {
                    android.content.Intent intent = new android.content.Intent("android.intent.action.DIAL");
                    intent.setData(android.net.Uri.parse("tel:4006426166"));
                    context.startActivity(intent);
                } catch (java.lang.Exception unused) {
                    com.up366.mobile.common.utils.ToastPopupUtil.show("启动拨号失败，无法调起拨号");
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(-9661697);
                textPaint.setUnderlineText(false);
            }
        }).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.ShowJumpErrorInfoEvent showJumpErrorInfoEvent) {
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, showJumpErrorInfoEvent.errorInfo);
    }
}
