package com.up366.mobile.user.account.register;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountRegisterActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final int PAGE_INPUT_MOBILE = 0;
    public static final int PAGE_INPUT_PASSWORD = 1;
    private com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding b;
    private int page;
    private com.up366.mobile.user.account.register.PageInputMobile pageInputMobile;
    private com.up366.mobile.user.account.register.PageInputPassword pageInputPassword;
    private com.up366.mobile.common.helper.SoftKeyboardChangeHelper softKeyboardChangeHelper;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface PageType {
    }

    static /* synthetic */ void lambda$onCreate$1(android.view.View view) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.b = (com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.account_register_activity_layout);
        this.page = getIntent().getIntExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, 0);
        com.up366.common.log.Logger.info("TAG - AccountRegisterActivity - onCreate - page : " + this.page);
        int i = this.page;
        if (i == 0) {
            this.pageInputMobile = new com.up366.mobile.user.account.register.PageInputMobile(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.pager);
        } else if (i == 1) {
            this.pageInputPassword = new com.up366.mobile.user.account.register.PageInputPassword(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.pager);
        }
        if (this.pageInputMobile != null) {
            this.softKeyboardChangeHelper = new com.up366.mobile.common.helper.SoftKeyboardChangeHelper(this.b.content).onChange(new com.up366.mobile.common.helper.SoftKeyboardChangeHelper.IOnChangeListener() { // from class: com.up366.mobile.user.account.register.AccountRegisterActivity$$ExternalSyntheticLambda0
                @Override // com.up366.mobile.common.helper.SoftKeyboardChangeHelper.IOnChangeListener
                public final void onChange(boolean z, boolean z2, int i2, int i3) {
                    this.f$0.lambda$onCreate$0(z, z2, i2, i3);
                }
            }).watch(this.pageInputMobile.b.password, this.pageInputMobile.b.passwordAgain);
        }
        this.b.btnNoCode.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.register.AccountRegisterActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(boolean z, boolean z2, int i, int i2) {
        if (z == z2) {
            return;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        this.b.content.getWindowVisibleDisplayFrame(rect);
        if (z2) {
            this.b.content.getLayoutParams().height = i2 - rect.top;
            this.b.content.requestLayout();
        } else {
            this.b.content.getLayoutParams().height = -1;
            this.b.content.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(android.view.View view) {
        com.up366.mobile.common.dialog.AppDialog.create(this).title(getString(com.up366.mobile.R.string.code_no_send_title)).messageTitle(getString(com.up366.mobile.R.string.code_no_send_content)).setMessageLeft().btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.register.AccountRegisterActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.user.account.register.AccountRegisterActivity.lambda$onCreate$1(view2);
            }
        }).setBtnCloseVisibility(4).show();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
        super.onDestroy();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.user.account.register.PageInputMobile pageInputMobile = this.pageInputMobile;
        if (pageInputMobile != null) {
            com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside(motionEvent, pageInputMobile.b.mobile, this.pageInputMobile.b.captcha, this.pageInputMobile.b.password, this.pageInputMobile.b.passwordAgain);
            if (motionEvent.getAction() == 1) {
                this.softKeyboardChangeHelper.notifyChange();
            }
        }
        com.up366.mobile.user.account.register.PageInputPassword pageInputPassword = this.pageInputPassword;
        if (pageInputPassword != null) {
            com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside(motionEvent, pageInputPassword.b.password, this.pageInputPassword.b.passwordAgain);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public static void openPage(android.app.Activity activity, int i) {
        android.content.Intent intent = new android.content.Intent(activity.getIntent());
        intent.setClass(activity, com.up366.mobile.user.account.register.AccountRegisterActivity.class);
        intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, i);
        activity.startActivity(intent);
    }

    public static void open(final android.app.Activity activity) {
        final android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(activity);
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().openLoginAuth(activity, frameLayout, "手机号注册", "一键注册", "换个手机号注册", "请勾选下方协议再注册哦~", new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.register.AccountRegisterActivity$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                com.up366.mobile.user.account.register.AccountRegisterActivity.lambda$open$4(activity, frameLayout, i, str, (java.lang.String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$open$4(final android.app.Activity activity, final android.view.ViewGroup viewGroup, int i, java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - AccountRegisterActivity - onResult - code = [" + i + "], info = [" + str + "], obj = [" + str2 + "]");
        if (i == -2) {
            com.up366.common.log.Logger.info("TAG - AccountRegisterActivity - 获取token失败");
            if (com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, "服务器异常，请稍后重试");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, "注册失败:网络原因\n请稍后再试！");
                return;
            }
        }
        if (i == -1) {
            com.up366.common.log.Logger.info("TAG - AccountRegisterActivity - 打开闪验失败，使用手动输入手机号页面");
            openPage(activity, 0);
            return;
        }
        if (i == 0) {
            com.up366.common.log.Logger.info("TAG - AccountRegisterActivity - openPage - 打开闪验成功");
            return;
        }
        if (i == 1) {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(viewGroup, "正在加载");
            com.up366.mobile.common.logic.Auth.mgr().flashTokenValidate(str2, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.register.AccountRegisterActivity$$ExternalSyntheticLambda3
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    com.up366.mobile.user.account.register.AccountRegisterActivity.lambda$open$3(viewGroup, activity, response, (com.up366.mobile.common.logic.model.ShanYanMobileInfo) obj);
                }
            });
        } else if (i == 2) {
            com.up366.common.log.Logger.info("TAG - AccountRegisterActivity - 换个手机号，使用手动输入手机号页面");
            openPage(activity, 0);
            com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
        } else {
            if (i != 3) {
                return;
            }
            com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
            activity.finish();
        }
    }

    static /* synthetic */ void lambda$open$3(android.view.ViewGroup viewGroup, android.app.Activity activity, com.up366.common.http.Response response, com.up366.mobile.common.logic.model.ShanYanMobileInfo shanYanMobileInfo) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(viewGroup);
        com.up366.common.log.Logger.info("TAG - 2020/5/28 - AccountRegisterActivity - open - " + response.toString());
        if (response.isError()) {
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, "注册失败:网络原因\n请稍后再试！");
                return;
            } else if (response.getCode() == 4) {
                com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(viewGroup, "该手机号已绑定账号\n无法注册~");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.clean(viewGroup);
        activity.getIntent().putExtra("fromOneKey", true);
        activity.getIntent().putExtra("mobile", shanYanMobileInfo.getMobile());
        activity.getIntent().putExtra("captcha", shanYanMobileInfo.getCode());
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
        openPage(activity, 1);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.RegisterSuccess registerSuccess) {
        finish();
    }
}
