package com.up366.mobile.user.account.update;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class PageAccountUpdateHome {
    private final com.up366.mobile.user.account.update.AccountUpdateActivity activity;
    private final com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding b;

    static /* synthetic */ void lambda$bindQq$7(android.view.View view) {
    }

    static /* synthetic */ void lambda$bindWechat$12(android.view.View view) {
    }

    public PageAccountUpdateHome(com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        this.activity = accountUpdateActivity;
        collapsingToolbarLayout.setTitle("账号安全");
        this.b = (com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding) androidx.databinding.DataBindingUtil.inflate(accountUpdateActivity.getLayoutInflater(), com.up366.mobile.R.layout.account_update_activity_home_layout, frameLayout, true);
        initView();
        if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile())) {
            com.up366.mobile.common.helper.ShanYanHelper.getInstance().getPhoneInfo(null);
        }
        fetchPersonInfo(accountUpdateActivity);
    }

    public void fetchPersonInfo(final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity) {
        com.up366.mobile.common.logic.Auth.cur().info().fetchPersonInfo(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda6
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$fetchPersonInfo$0(accountUpdateActivity, response, (java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$fetchPersonInfo$0(com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, com.up366.common.http.Response response, java.lang.String str) {
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, response);
        } else {
            update();
        }
    }

    private void initView() {
        java.lang.String qqOpenid = com.up366.mobile.common.logic.Auth.getUserInfo().getQqOpenid();
        java.lang.String weixinOpenid = com.up366.mobile.common.logic.Auth.getUserInfo().getWeixinOpenid();
        final boolean z = !com.up366.common.StringUtils.isEmptyOrNull(qqOpenid);
        final boolean z2 = !com.up366.common.StringUtils.isEmptyOrNull(weixinOpenid);
        if (com.up366.mobile.common.logic.Auth.cur().config().isEnableThirdLogin() && !com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            this.b.changeQq.setVisibility(0);
            this.b.changeWechat.setVisibility(0);
            this.b.line2.setVisibility(0);
            this.b.line1.setVisibility(0);
        } else {
            this.b.line1.setVisibility(8);
            this.b.line2.setVisibility(8);
            this.b.changeQq.setVisibility(8);
            this.b.changeWechat.setVisibility(8);
        }
        this.b.changeMobile.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.b.changePassword.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
        this.b.setVoice.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$3(view);
            }
        });
        this.b.changeWechat.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$4(z2, view);
            }
        });
        this.b.changeQq.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$5(z, view);
            }
        });
        this.b.cancellation.getPaint().setUnderlineText(true);
        this.b.cancellation.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$6(view);
            }
        });
        java.lang.String mobile = com.up366.mobile.common.logic.Auth.getUserInfo().getMobile();
        java.lang.String maskMobile = com.up366.mobile.common.logic.Auth.getUserInfo().getMaskMobile();
        if (com.up366.common.StringUtils.isEmptyOrNull(mobile)) {
            this.b.changeMobile.setSubTitle("未绑定");
            this.b.changeMobile.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c1));
        } else {
            this.b.changeMobile.setSubTitle(maskMobile);
            this.b.changeMobile.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c5));
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(qqOpenid)) {
            this.b.changeQq.setSubTitle("去绑定");
            this.b.changeQq.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c1));
        } else {
            this.b.changeQq.setSubTitle("已绑定");
            this.b.changeQq.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c5));
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(weixinOpenid)) {
            this.b.changeWechat.setSubTitle("去绑定");
            this.b.changeWechat.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c1));
        } else {
            this.b.changeWechat.setSubTitle("已绑定");
            this.b.changeWechat.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c5));
        }
        if (com.up366.mobile.common.logic.Auth.cur().info().isPlainPassword()) {
            this.b.changePassword.setSubTitle("去设置");
            this.b.changePassword.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c1));
        } else {
            this.b.changePassword.setSubTitle("已设置");
            this.b.changePassword.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c5));
        }
        if (!com.up366.mobile.common.logic.Auth.getUserInfo().isVoiceSetted()) {
            this.b.setVoice.setSubTitle("去设置");
            this.b.setVoice.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c1));
        } else {
            this.b.setVoice.setSubTitle("已设置");
            this.b.setVoice.setSubTitleColor(this.activity.getResources().getColor(com.up366.mobile.R.color.c5));
        }
        this.b.username.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        com.up366.mobile.user.account.update.AccountUpdateActivity.openPage(this.activity, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile())) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this.activity, "请先绑定手机号");
        } else {
            this.activity.getIntent().putExtra("mobile", com.up366.mobile.common.logic.Auth.getUserInfo().getMobile());
            com.up366.mobile.user.account.AccountActivity.openPage(this.activity, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(android.view.View view) {
        if (com.up366.mobile.common.logic.Auth.getUserInfo().isVoiceSetted()) {
            com.up366.mobile.user.account.voice.VoiceSettedActivity.openPage(this.activity);
        } else {
            com.up366.mobile.user.account.voice.VoiceSetActivity.openPage(this.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(boolean z, android.view.View view) {
        if (z) {
            unBindWechat(this.activity, "解绑微信", "解除微信绑定后，你将无法使用微信登录“天学网学生”账号，是否继续解绑", 1, "微信解绑成功");
        } else {
            bindWechat(this.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(boolean z, android.view.View view) {
        if (z) {
            unBindWechat(this.activity, "解绑QQ", "解除QQ绑定后，你将无法使用QQ登录“天学网学生”账号，是否继续解绑", 2, "QQ解绑成功");
        } else {
            bindQq(this.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(android.view.View view) {
        this.activity.startActivity(new android.content.Intent((android.content.Context) this.activity, (java.lang.Class<?>) com.up366.mobile.me.logoff.LogOffAccountActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindQq(final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity) {
        com.up366.mobile.common.dialog.AppDialog.create(accountUpdateActivity).title("“天学网”想要打开“QQ”").left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.update.PageAccountUpdateHome.lambda$bindQq$7(view);
            }
        }).right("打开", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$bindQq$11(accountUpdateActivity, view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$bindQq$11(final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, android.view.View view) {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) accountUpdateActivity, "QQ绑定中");
        new com.up366.mobile.common.helper.QQAuthHelper().getOpenId(accountUpdateActivity, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda10
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$bindQq$10(accountUpdateActivity, i, str, (java.lang.String[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$bindQq$10(final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, int i, java.lang.String str, final java.lang.String[] strArr) {
        if (i == 0) {
            com.up366.mobile.common.logic.Auth.mgr().validateQQNoLogin(strArr[0], strArr[1], new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda17
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$bindQq$9(strArr, accountUpdateActivity, response, obj);
                }
            });
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$bindQq$9(final java.lang.String[] strArr, final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, com.up366.common.http.Response response, java.lang.Object obj) {
        com.up366.common.log.Logger.info("TAG - PageAccountUpdateHome - " + response.toString());
        if (response.getCode() == -32) {
            com.up366.mobile.common.logic.Auth.cur().info().bindWechatOrQq(strArr[0], 2, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda13
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response2, java.lang.Object obj2) {
                    this.f$0.lambda$bindQq$8(accountUpdateActivity, strArr, response2, obj2);
                }
            });
        } else if (response.getCode() == -36) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, "绑定失败:QQ已绑定其他账号");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, response);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$bindQq$8(com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, java.lang.String[] strArr, com.up366.common.http.Response response, java.lang.Object obj) {
        if (response.isError()) {
            com.up366.common.log.Logger.info("TAG - PageAccountUpdateHome - " + response.toString());
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, response);
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) accountUpdateActivity, "QQ绑定成功");
        com.up366.mobile.common.logic.Auth.getUserInfo().setQqOpenid(strArr[0]);
        com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindWechat(final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity) {
        com.up366.mobile.common.dialog.AppDialog.create(accountUpdateActivity).title("“天学网”想要打开“微信”").left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.update.PageAccountUpdateHome.lambda$bindWechat$12(view);
            }
        }).right("打开", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$bindWechat$16(accountUpdateActivity, view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$bindWechat$16(final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, android.view.View view) {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) accountUpdateActivity, "微信绑定中");
        new com.up366.mobile.common.helper.WeixinAuthHelper().getOpenId(accountUpdateActivity, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$bindWechat$15(accountUpdateActivity, i, str, (java.lang.String[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$bindWechat$15(final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, int i, java.lang.String str, final java.lang.String[] strArr) {
        if (i == 0) {
            com.up366.mobile.common.logic.Auth.mgr().validateWeChatNoLogin(strArr[0], strArr[1], new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda9
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$bindWechat$14(strArr, accountUpdateActivity, response, obj);
                }
            });
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$bindWechat$14(final java.lang.String[] strArr, final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, com.up366.common.http.Response response, java.lang.Object obj) {
        com.up366.common.log.Logger.info("TAG - PageAccountUpdateHome - " + response.toString());
        if (response.getCode() == -32) {
            com.up366.mobile.common.logic.Auth.cur().info().bindWechatOrQq(strArr[0], 1, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda11
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response2, java.lang.Object obj2) {
                    this.f$0.lambda$bindWechat$13(accountUpdateActivity, strArr, response2, obj2);
                }
            });
        } else if (response.getCode() == -34) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, "绑定失败:微信已绑定其他账号");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, response);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$bindWechat$13(com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, java.lang.String[] strArr, com.up366.common.http.Response response, java.lang.Object obj) {
        if (response.isError()) {
            com.up366.common.log.Logger.info("TAG - PageAccountUpdateHome - " + response.toString());
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, response);
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) accountUpdateActivity, "微信绑定成功");
        com.up366.mobile.common.logic.Auth.getUserInfo().setWeixinOpenid(strArr[0]);
        com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void unBindWechat(final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, java.lang.String str, java.lang.String str2, final int i, final java.lang.String str3) {
        com.up366.common.log.Logger.info("TAG - 2020/6/2 - PageAccountUpdateHome - unBindWechat - activity = [" + accountUpdateActivity + "], title = [" + str + "], message = [" + str2 + "], type = [" + i + "], successTip = [" + str3 + "]");
        new com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog(accountUpdateActivity).title(str).message(str2).onClick(new com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog.IOnClickListener() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda12
            @Override // com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog.IOnClickListener
            public final void onClick() {
                this.f$0.lambda$unBindWechat$18(i, accountUpdateActivity, str3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unBindWechat$18(final int i, final com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, final java.lang.String str) {
        com.up366.mobile.common.logic.Auth.cur().info().unBindWechatOrQq(i, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.update.PageAccountUpdateHome$$ExternalSyntheticLambda16
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$unBindWechat$17(accountUpdateActivity, str, i, response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$unBindWechat$17(com.up366.mobile.user.account.update.AccountUpdateActivity accountUpdateActivity, java.lang.String str, int i, com.up366.common.http.Response response, java.lang.Object obj) {
        if (response.isError()) {
            com.up366.common.log.Logger.info("TAG - PageAccountUpdateHome - " + response.toString());
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) accountUpdateActivity, response);
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) accountUpdateActivity, str);
        if (i == 1) {
            com.up366.mobile.common.logic.Auth.getUserInfo().setWeixinOpenid(null);
        }
        if (i == 2) {
            com.up366.mobile.common.logic.Auth.getUserInfo().setQqOpenid(null);
        }
        com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
        initView();
    }

    public void update() {
        initView();
    }
}
