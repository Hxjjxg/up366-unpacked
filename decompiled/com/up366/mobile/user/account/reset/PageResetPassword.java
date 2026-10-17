package com.up366.mobile.user.account.reset;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageResetPassword {
    private final android.app.Activity activity;
    private final com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding b;
    private java.util.List<java.lang.String> weakPasswordList = null;

    public PageResetPassword(android.app.Activity activity, androidx.core.widget.NestedScrollView nestedScrollView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, android.widget.TextView textView) {
        this.activity = activity;
        initData();
        android.content.Intent intent = activity.getIntent();
        final java.lang.String stringExtra = intent.getStringExtra("mobile");
        java.lang.String stringExtra2 = intent.getStringExtra("realName");
        final java.lang.String stringExtra3 = intent.getStringExtra("username");
        collapsingToolbarLayout.setTitle("重置密码");
        com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding accountActivityResetPasswordLayoutBinding = (com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_activity_reset_password_layout, nestedScrollView, true);
        this.b = accountActivityResetPasswordLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountActivityResetPasswordLayoutBinding.getRoot().getPaddingLeft());
        textView.setVisibility(0);
        textView.setText(java.lang.String.format("我叫%s", stringExtra2));
        accountActivityResetPasswordLayoutBinding.password.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$new$0(appEditTextView);
            }
        });
        accountActivityResetPasswordLayoutBinding.passwordAgain.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$new$1(appEditTextView);
            }
        });
        accountActivityResetPasswordLayoutBinding.btnReset.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$2(stringExtra, stringExtra3, view);
            }
        });
        accountActivityResetPasswordLayoutBinding.errorTipPassword.setVisibility(4);
        accountActivityResetPasswordLayoutBinding.password.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(android.view.View view, boolean z) {
                this.f$0.lambda$new$3(view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        refreshState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(java.lang.String str, java.lang.String str2, android.view.View view) {
        resetPassword(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(android.view.View view, boolean z) {
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

    private void resetPassword(final java.lang.String str, final java.lang.String str2) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$resetPassword$8(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetPassword$8(java.lang.String str, final java.lang.String str2) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - PageResetPassword - PageResetPassword - 重置密码");
        final java.lang.String trimText = this.b.password.getTrimText();
        java.util.List<java.lang.String> list = this.weakPasswordList;
        if (list == null || list.size() == 0) {
            com.up366.common.http.NetHolder<java.lang.String> netHolderFetchWeakPassword = com.up366.mobile.common.logic.Auth.mgr().fetchWeakPassword();
            if (!netHolderFetchWeakPassword.resp.isError()) {
                this.weakPasswordList = com.alibaba.fastjson.JSON.parseArray(netHolderFetchWeakPassword.info, java.lang.String.class);
                return;
            }
        }
        if (isWeakPassword(trimText)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda6
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$resetPassword$4();
                }
            });
            return;
        }
        if (!com.up366.mobile.common.utils.PasswordValidateUtils.verifyPasswordV2(trimText)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda7
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$resetPassword$5();
                }
            });
        } else if (!trimText.equals(this.b.passwordAgain.getTrimText())) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda8
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$resetPassword$6();
                }
            });
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.activity, "密码重置中");
            com.up366.mobile.common.logic.Auth.mgr().resetPassword(str, trimText, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda9
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$resetPassword$7(trimText, str2, response, (java.lang.String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetPassword$4() throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.activity, "密码过于简单，请重新输入");
        this.b.password.setText("");
        this.b.passwordAgain.setText("");
        this.b.passwordAgain.clearFocus();
        this.b.password.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetPassword$5() throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.activity, "密码强度不够，密码至少由数字、大小写字母组成的8-16位字符");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetPassword$6() throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.activity, "密码不一致，请修改");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetPassword$7(java.lang.String str, java.lang.String str2, com.up366.common.http.Response response, java.lang.String str3) {
        if (response.isError()) {
            if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.activity, "重置失败:网络原因，请稍后\n再试！");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.activity, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.activity);
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("account-reset-password-success", "密码重置成功", 1000L);
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("account-reset-password-success").invalid();
            java.lang.String lowerCase = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5(str).toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase();
            com.up366.common.log.Logger.info("TAG - PageResetPassword - resetPassword - update auth info");
            com.up366.mobile.common.logic.Auth.updateAuthInfo(com.up366.mobile.common.logic.Auth.UID(), com.up366.mobile.common.logic.Auth.getUserInfo().getUsername(), lowerCase);
            this.activity.finish();
            return;
        }
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("auto-fill-username", str2, 1000L);
        com.up366.mobile.user.account.login.AccountLoginActivity.open(this.activity);
        this.activity.finish();
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

    private void initData() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.reset.PageResetPassword$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initData$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$9() throws java.lang.Exception {
        com.up366.common.http.NetHolder<java.lang.String> netHolderFetchWeakPassword = com.up366.mobile.common.logic.Auth.mgr().fetchWeakPassword();
        if (netHolderFetchWeakPassword.resp.isError()) {
            return;
        }
        this.weakPasswordList = com.alibaba.fastjson.JSON.parseArray(netHolderFetchWeakPassword.info, java.lang.String.class);
    }

    private void refreshState() {
        if (this.b.password.getTrimText().length() > 7 && this.b.passwordAgain.getTrimText().length() > 7) {
            this.b.btnReset.setEnabled(true);
        } else {
            this.b.btnReset.setEnabled(false);
        }
    }
}
