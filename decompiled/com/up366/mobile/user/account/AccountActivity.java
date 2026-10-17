package com.up366.mobile.user.account;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final int PAGE_GET_ACCOUNT = 4;
    public static final int PAGE_LOGIN_BY_MOBILE = 5;
    public static final int PAGE_RESET_BY_SMS = 2;
    public static final int PAGE_RESET_PASSWORD = 3;
    public static final int PAGE_SELECT_RESET_METHOD = 1;
    private com.up366.mobile.databinding.AccountActivityLayoutBinding b;
    private boolean fromSwitchAccount;
    private int page;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface PageType {
    }

    static /* synthetic */ void lambda$onCreate$0(android.view.View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.AccountActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.account_activity_layout);
        this.page = getIntent().getIntExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, 1);
        this.fromSwitchAccount = getIntent().getBooleanExtra("fromSwitchAccount", false);
        com.up366.common.log.Logger.info("TAG - AccountActivity - onCreate - page : " + this.page);
        int i = this.page;
        if (i == 1) {
            new com.up366.mobile.user.account.reset.PageSelectReset(this, this.b.content, this.b.toolbarLayout);
        } else if (i == 2) {
            this.currentPageName = getIntent().getBooleanExtra("find_password", false) ? "login_find_pwd" : "user_setting_account_change_pwd_phone";
            new com.up366.mobile.user.account.reset.PageResetBySms(this, this.b.content, this.b.toolbarLayout, this.b.username);
        } else if (i == 3) {
            this.currentPageName = "user_setting_account_change_pwd";
            new com.up366.mobile.user.account.reset.PageResetPassword(this, this.b.content, this.b.toolbarLayout, this.b.username);
        } else if (i == 4) {
            this.b.titleBack.setVisibility(8);
            this.b.titleClose.setVisibility(0);
            new com.up366.mobile.user.account.PageGetAccount(this, this.b.content, this.b.toolbarLayout);
        } else if (i == 5) {
            this.b.titleBack.setImageResource(com.up366.mobile.R.drawable.icon_close);
            this.currentPageName = "login_code_login";
            new com.up366.mobile.user.account.login.PageLoginByMobile(this, this.b.content, this.b.toolbarLayout, this.fromSwitchAccount);
        }
        this.b.btnNoCode.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.AccountActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(android.view.View view) {
        com.up366.mobile.common.dialog.AppDialog.create(this).title(getString(com.up366.mobile.R.string.code_no_send_title)).messageTitle(getString(com.up366.mobile.R.string.code_no_send_content)).setMessageLeft().btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.AccountActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.user.account.AccountActivity.lambda$onCreate$0(view2);
            }
        }).setBtnCloseVisibility(4).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside((android.app.Activity) this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public static void openPage(android.app.Activity activity, int i) {
        openPage(activity, i, false);
    }

    public static void openPage(android.app.Activity activity, int i, boolean z) {
        android.content.Intent intent = new android.content.Intent(activity.getIntent());
        intent.setClass(activity, com.up366.mobile.user.account.AccountActivity.class);
        intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, i);
        intent.putExtra("fromSwitchAccount", z);
        activity.startActivity(intent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        if (this.page == 1) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("account-reset-password-success").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.AccountActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onResume$2() {
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, "密码重置成功");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
    }
}
