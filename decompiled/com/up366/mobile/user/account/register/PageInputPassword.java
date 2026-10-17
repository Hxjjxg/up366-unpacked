package com.up366.mobile.user.account.register;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageInputPassword {
    private final android.app.Activity activity;
    public final com.up366.mobile.databinding.AccountRegisterActivityPageInputPasswordLayoutBinding b;
    private final java.lang.String captcha;
    private final boolean fromOneKey;
    private final java.lang.String mobile;

    public PageInputPassword(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView) {
        this.activity = activity;
        android.content.Intent intent = activity.getIntent();
        this.fromOneKey = intent.getBooleanExtra("fromOneKey", false);
        this.mobile = intent.getStringExtra("mobile");
        this.captcha = intent.getStringExtra("captcha");
        textView.setVisibility(4);
        com.up366.mobile.databinding.AccountRegisterActivityPageInputPasswordLayoutBinding accountRegisterActivityPageInputPasswordLayoutBinding = (com.up366.mobile.databinding.AccountRegisterActivityPageInputPasswordLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_register_activity_page_input_password_layout, frameLayout, true);
        this.b = accountRegisterActivityPageInputPasswordLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountRegisterActivityPageInputPasswordLayoutBinding.getRoot().getPaddingLeft());
        collapsingToolbarLayout.setTitle("设置密码");
        initView(activity, appBarLayout);
    }

    private void initView(final android.app.Activity activity, com.google.android.material.appbar.AppBarLayout appBarLayout) {
        this.b.password.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputPassword$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$0(appEditTextView);
            }
        });
        this.b.passwordAgain.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputPassword$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$1(appEditTextView);
            }
        });
        this.b.passwordAgain.setOnEditActionListener(new com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener() { // from class: com.up366.mobile.user.account.register.PageInputPassword$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener
            public final void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$2(appEditTextView);
            }
        });
        this.b.errorTipPassword.setVisibility(4);
        this.b.password.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.register.PageInputPassword$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$initView$3(view, z);
            }
        });
        this.b.btnRegister.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.register.PageInputPassword$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$4(activity, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        this.b.btnRegister.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(android.view.View view, boolean z) {
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
    public /* synthetic */ void lambda$initView$4(android.app.Activity activity, android.view.View view) {
        if (this.b.btnRegister.isEnabled()) {
            com.up366.common.log.Logger.info("TAG - PageInputPassword - PageInputPassword - 注册");
            doRegister(activity, view, this.b.password.getTrimText(), this.b.passwordAgain.getTrimText(), this.mobile, this.captcha);
        }
    }

    public static void doRegister(final android.app.Activity activity, final android.view.View view, final java.lang.String str, java.lang.String str2, final java.lang.String str3, java.lang.String str4) {
        if (!com.up366.mobile.common.utils.PasswordValidateUtils.verifyPasswordV2(str)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "密码强度不够，密码至少由数字、大小写字母组成的8-16位字符");
        } else if (!str.equals(str2)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "密码不一致，请修改");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "注册中");
            com.up366.mobile.common.logic.Auth.mgr().registerUser(str3, str4, str, str3, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.register.PageInputPassword$$ExternalSyntheticLambda7
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    com.up366.mobile.user.account.register.PageInputPassword.lambda$doRegister$7(activity, view, str, str3, response, obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$doRegister$7(final android.app.Activity activity, android.view.View view, final java.lang.String str, final java.lang.String str2, com.up366.common.http.Response response, java.lang.Object obj) {
        com.up366.common.log.Logger.info("TAG - PageInputPassword - initView - " + response.toString());
        if (response.isError()) {
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "注册失败:网络原因，请稍\n后再试！");
                return;
            }
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(view);
            if (response.getCode() == 4) {
                com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(activity, "该手机号已绑定账号\n无法注册~");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
                return;
            }
        }
        com.up366.common.log.Logger.info("TAG - PageInputPassword - 注册成功");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.register.PageInputPassword$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.user.account.register.PageInputPassword.lambda$doRegister$6(str, str2, activity);
            }
        });
    }

    static /* synthetic */ void lambda$doRegister$6(java.lang.String str, final java.lang.String str2, final android.app.Activity activity) throws java.lang.Exception {
        java.lang.String lowerCase = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5(str).toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageInputPassword - initView - auto login : ");
        sb.append(str2);
        com.up366.common.log.Logger.info(sb.toString());
        com.up366.common.http.NetHolder<java.lang.Object> netHolderDoLoginSync = com.up366.mobile.common.logic.Auth.mgr().doLoginSync(str2, lowerCase, true, 0, null);
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("register-success-tip", "注册成功", 1000L);
        if (netHolderDoLoginSync.resp.isError()) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.register.PageInputPassword$$ExternalSyntheticLambda6
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.user.account.register.PageInputPassword.lambda$doRegister$5(activity, str2);
                }
            });
        } else {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RegisterSuccess());
        }
    }

    static /* synthetic */ void lambda$doRegister$5(android.app.Activity activity, java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("auto-fill-username", str, 1000L);
        com.up366.mobile.user.account.login.AccountLoginActivity.open(activity);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RegisterSuccess());
    }

    private void refreshState() {
        if (this.b.password.getTrimText().length() > 7 && this.b.passwordAgain.getTrimText().length() > 7) {
            this.b.btnRegister.setEnabled(true);
        } else {
            this.b.btnRegister.setEnabled(false);
        }
    }
}
