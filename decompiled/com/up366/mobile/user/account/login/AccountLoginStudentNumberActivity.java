package com.up366.mobile.user.account.login;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountLoginStudentNumberActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final int TYPE_LOGIN = 0;
    public static final int TYPE_VIEW_ORGAN_INFO = 1;
    public static boolean fromSwitch;
    private com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding b;
    private com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo organ;
    private int authType = 0;
    private boolean isCheckedAgreement = false;
    private final java.util.List<android.text.style.ClickableSpan> reference = new java.util.ArrayList();

    public static class OrganInfo implements java.io.Serializable {
        public java.lang.String organId;
        public java.lang.String organName;
        public int type;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface PageType {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "login_city_list";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.b = (com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.account_login_student_number_activity_layout);
        this.organ = (com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo) getIntent().getSerializableExtra("organ");
        fromSwitch = getIntent().getBooleanExtra("from", false);
        initView();
        this.b.studentNumber.setFocusable(false);
        this.b.password.setFocusable(false);
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$0();
            }
        });
        if (this.organ.type == 1) {
            initPreviewView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() throws java.lang.Exception {
        this.b.studentNumber.setFocusable(true);
        this.b.password.setFocusable(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initPreviewView() {
        gone(this.b.btnLogin, this.b.studentNumber, this.b.password, this.b.btnUsernameLogin, this.b.licenseText, this.b.acceptDealChecbox);
        visible(this.b.viewTip, this.b.viewBtnNext, this.b.viewReSelect);
        this.b.viewReSelect.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initPreviewView$1(view);
            }
        });
        this.b.viewBtnNext.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initPreviewView$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initPreviewView$1(android.view.View view) {
        showFindOrganPage(this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initPreviewView$2(android.view.View view) {
        com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo organInfo = new com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo();
        organInfo.type = 0;
        organInfo.organName = this.organ.organName;
        organInfo.organId = this.organ.organId;
        open(this, organInfo, fromSwitch);
        finish();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
        super.onDestroy();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside(motionEvent, this.b.studentNumber, this.b.password);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.b.school.setText(this.organ.organName);
        this.b.studentNumber.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$3(appEditTextView);
            }
        });
        this.b.password.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$4(appEditTextView);
            }
        });
        this.b.studentNumber.setOnEditActionListener(new com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda10
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener
            public final void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$5(appEditTextView);
            }
        });
        this.b.password.setOnEditActionListener(new com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda11
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener
            public final void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$6(appEditTextView);
            }
        });
        this.b.btnLogin.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$7(view);
            }
        });
        this.b.acceptDealChecbox.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$8(view);
            }
        });
        android.text.SpannableStringBuilder spannableStringBuilderBuild = new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("我已阅读并同意").append("《隐私政策》").setSpan(getClickSpan(this, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL))).append("《使用许可协议》").setSpan(getClickSpan(this, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.LICENSE_URL))).append("《儿童隐私保护政策》").setSpan(getClickSpan(this, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL))).build();
        this.b.licenseText.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.b.licenseText.setText(spannableStringBuilderBuild);
        android.text.SpannableStringBuilder spannableStringBuilderBuild2 = new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("没有学号？").append("试试个人信息登录").setSpan(getClickSpan(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.gotoUserinfoLogin();
            }
        })).build();
        this.b.btnUsernameLogin.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.b.btnUsernameLogin.setText(spannableStringBuilderBuild2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshBtnState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshBtnState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        this.b.password.showSoftInput(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        this.b.btnLogin.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$7(android.view.View view) {
        doLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$8(android.view.View view) {
        if (this.isCheckedAgreement) {
            this.isCheckedAgreement = false;
            this.b.acceptDealChecbox.setImageResource(com.up366.mobile.R.drawable.multiple_selection_regist_gray);
        } else {
            this.isCheckedAgreement = true;
            this.b.acceptDealChecbox.setImageResource(com.up366.mobile.R.drawable.multiple_selection_regist);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void doLogin() {
        if (this.b.btnLogin.isEnabled()) {
            if (!this.isCheckedAgreement) {
                com.up366.mobile.common.utils.ToastPopupUtil.show("请先阅读并勾选相关协议");
                return;
            }
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "登录中");
            disable(this.b.btnLogin);
            final java.lang.String lowerCase = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5(this.b.password.getTrimText()).toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase();
            com.up366.common.http.HttpUtilsUp.clearCookies();
            this.authType = 0;
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda5
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$doLogin$10(lowerCase);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doLogin$10(java.lang.String str) throws java.lang.Exception {
        com.up366.common.http.NetHolder<java.lang.String> netHolderFindUsernameByStudentNumber = com.up366.mobile.common.logic.Auth.mgr().findUsernameByStudentNumber(this.organ.organId, this.b.studentNumber.getTrimText());
        if (netHolderFindUsernameByStudentNumber.resp.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(this.b.studentNumber, netHolderFindUsernameByStudentNumber.resp.getInfo());
            return;
        }
        final com.up366.common.http.NetHolder<java.lang.Object> netHolderDoLoginSync = com.up366.mobile.common.logic.Auth.mgr().doLoginSync(netHolderFindUsernameByStudentNumber.info, str, true, 0, "", fromSwitch);
        if (!netHolderDoLoginSync.resp.isError()) {
            com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo organInfo = new com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo();
            organInfo.type = 0;
            organInfo.organId = this.organ.organId;
            organInfo.organName = this.organ.organName;
            saveLastSelectOrganInfo(organInfo);
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$doLogin$9(netHolderDoLoginSync);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$doLogin$9(com.up366.common.http.NetHolder netHolder) throws java.lang.Exception {
        refreshBtnState();
        if (netHolder.resp.getCode() == -27) {
            com.up366.mobile.user.account.login.AccountLoginActivity.showLoginFailedCount(this, netHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void gotoUserinfoLogin() {
        com.up366.mobile.user.account.find.AccountFindActivity.Config config = new com.up366.mobile.user.account.find.AccountFindActivity.Config();
        config.type = 1;
        config.page = 2;
        config.organId = this.organ.organId;
        config.organName = this.organ.organName;
        com.up366.mobile.user.account.find.AccountFindActivity.openPage(this, config);
        finish();
    }

    private android.text.style.ClickableSpan getClickSpan(final android.content.Context context, final java.lang.String str) {
        return getClickSpan(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.lambda$getClickSpan$11(context, str);
            }
        });
    }

    static /* synthetic */ void lambda$getClickSpan$11(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
        context.startActivity(intent);
    }

    private android.text.style.ClickableSpan getClickSpan(final java.lang.Runnable runnable) {
        return new com.up366.mobile.common.utils.WeakReferenceClickableSpan(this.reference, new android.text.style.ClickableSpan() { // from class: com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                runnable.run();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(-10715905);
                textPaint.setUnderlineText(false);
            }
        });
    }

    private void refreshBtnState() {
        if (this.b.studentNumber.getTrimText().length() > 0 && this.b.password.getTrimText().length() > 5) {
            this.b.btnLogin.setEnabled(true);
        } else {
            this.b.btnLogin.setEnabled(false);
        }
    }

    public static void open(android.app.Activity activity, boolean z) {
        com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo organInfoLoadLastSelectOrganInfo = loadLastSelectOrganInfo();
        if (organInfoLoadLastSelectOrganInfo != null) {
            organInfoLoadLastSelectOrganInfo.type = 1;
        }
        open(activity, organInfoLoadLastSelectOrganInfo, z);
    }

    public static void open(android.app.Activity activity, com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo organInfo, boolean z) {
        if (organInfo != null) {
            android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.class);
            intent.putExtra("organ", organInfo);
            intent.putExtra("from", z);
            activity.startActivity(intent);
            return;
        }
        showFindOrganPage(activity);
    }

    private static void showFindOrganPage(android.app.Activity activity) {
        com.up366.mobile.user.account.find.AccountFindActivity.Config config = new com.up366.mobile.user.account.find.AccountFindActivity.Config();
        config.page = 0;
        config.type = 1;
        com.up366.mobile.user.account.find.AccountFindActivity.openPage(activity, config);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class));
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginFailed authLoginFailed) {
        com.up366.common.log.Logger.info("TAG - AccountLoginStudentNumberActivity - onMessageEvent - code:" + authLoginFailed.getCode() + "  info : " + authLoginFailed.getInfo());
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        refreshBtnState();
        com.up366.mobile.user.account.login.AccountLoginActivity.handleLoginErrorCode(this, authLoginFailed.getCode(), authLoginFailed.getInfo(), this.authType, 1);
    }

    static void saveLastSelectOrganInfo(com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo organInfo) {
        com.up366.mobile.common.logic.Auth.mgr().cache().put("login-last-select-school", organInfo);
    }

    static com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo loadLastSelectOrganInfo() {
        return (com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo) com.up366.mobile.common.logic.Auth.mgr().cache().loadSync("login-last-select-school", com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo.class);
    }
}
