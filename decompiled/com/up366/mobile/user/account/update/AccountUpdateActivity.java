package com.up366.mobile.user.account.update;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountUpdateActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final int PAGE_UNBIND_MOBILE = 2;
    public static final int PAGE_UPDATE_HOME = 0;
    public static final int PAGE_UPDATE_MOBILE = 1;
    private com.up366.mobile.databinding.AccountUpdateActivityLayoutBinding b;
    private int page;
    private com.up366.mobile.user.account.update.PageAccountUpdateHome pageAccountUpdateHome;
    private boolean fromConfig = false;
    protected java.lang.String currentPageName = "user_setting_account";

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface PageType {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return this.currentPageName;
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.AccountUpdateActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.account_update_activity_layout);
        this.page = getIntent().getIntExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, 0);
        this.fromConfig = getIntent().getBooleanExtra("fromConfig", false);
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.common.log.Logger.info("TAG - AccountActivity - onCreate - page : " + this.page);
        int i = this.page;
        if (i == 0) {
            gone(this.b.username);
            this.currentPageName = "user_setting_account";
            this.pageAccountUpdateHome = new com.up366.mobile.user.account.update.PageAccountUpdateHome(this, this.b.content, this.b.toolbarLayout);
        } else if (i == 1) {
            this.currentPageName = "user_setting_account_bind_phone";
            new com.up366.mobile.user.account.update.PageAccountUpdateMobile(this, this.b.content, this.b.toolbarLayout, this.b.username, this.fromConfig);
        } else if (i == 2) {
            new com.up366.mobile.user.account.update.PageAccountUnBindMobile(this, this.b.content, this.b.toolbarLayout, this.b.username);
        }
        this.b.toolbarBack.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.AccountUpdateActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        if (this.fromConfig && com.up366.mobile.common.logic.Auth.cur().config().isMustBindPhone()) {
            com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.removeAccount(com.up366.mobile.common.logic.Auth.UID());
            com.up366.mobile.user.account.login.AccountLoginActivity.open(this);
        }
        finish();
    }

    public void onBackPressed() {
        if (this.fromConfig && com.up366.mobile.common.logic.Auth.cur().config().isMustBindPhone()) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside((android.app.Activity) this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public static void openPage(android.app.Activity activity, int i) {
        android.content.Intent intent = new android.content.Intent(activity.getIntent());
        intent.setClass(activity, com.up366.mobile.user.account.update.AccountUpdateActivity.class);
        intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, i);
        activity.startActivity(intent);
    }

    public static void openPageFromConfig(android.app.Activity activity, int i) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.user.account.update.AccountUpdateActivity.class);
        intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, i);
        intent.putExtra("fromConfig", true);
        activity.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        if (this.page == 0) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("account_update_mobile_success").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.update.AccountUpdateActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$1();
                }
            });
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("account_bind_mobile_success").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.update.AccountUpdateActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$3();
                }
            });
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("PAGE_UPDATE_HOME", "account_unbind_mobile_success").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.update.AccountUpdateActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$5();
                }
            });
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("AccountUpdateActivity", "account-reset-password-success").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.update.AccountUpdateActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$6();
                }
            });
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("AccountUpdateActivity", "record_status_update").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.update.AccountUpdateActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$7();
                }
            });
            java.lang.String str = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("account-reset-password-success");
            if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
                return;
            }
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onResume$1() {
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, "修改手机号成功");
        this.pageAccountUpdateHome.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$3() {
        this.pageAccountUpdateHome.update();
        finish();
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.update.AccountUpdateActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(com.up366.common.global.GB.get().getCurrentActivity(), "绑定手机号成功");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$5() {
        this.pageAccountUpdateHome.update();
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.update.AccountUpdateActivity$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(com.up366.common.global.GB.get().getCurrentActivity(), "解绑成功");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$6() {
        this.pageAccountUpdateHome.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$7() {
        this.pageAccountUpdateHome.fetchPersonInfo(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.ClosePageUpdateMobileEvent closePageUpdateMobileEvent) {
        if (this.page == 1) {
            finish();
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
        if (this.fromConfig) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.StartPageTaskEvent());
        }
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
    }
}
