package com.up366.mobile.user.account.reset;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageSelectReset {
    private com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding b;

    /* JADX WARN: Multi-variable type inference failed */
    public PageSelectReset(final com.up366.mobile.user.account.AccountActivity accountActivity, androidx.core.widget.NestedScrollView nestedScrollView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        collapsingToolbarLayout.setTitle("选择重置密码方式");
        final android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(accountActivity);
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().getPhoneInfo(null);
        com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding accountActivitySelectResetOptionLayoutBinding = (com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding) androidx.databinding.DataBindingUtil.inflate(accountActivity.getLayoutInflater(), com.up366.mobile.R.layout.account_activity_select_reset_option_layout, nestedScrollView, true);
        this.b = accountActivitySelectResetOptionLayoutBinding;
        accountActivitySelectResetOptionLayoutBinding.btnSms.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.reset.PageSelectReset.openResetPasswordBySmsPage(accountActivity, frameLayout);
            }
        });
        this.b.btnWeixin.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$3(accountActivity, view);
            }
        });
        this.b.btnQq.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$6(accountActivity, view);
            }
        });
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.mobile.common.logic.user.UserInfo userInfo = com.up366.mobile.common.logic.Auth.getUserInfo();
            if (com.up366.common.StringUtils.isEmptyOrNull(userInfo.getQqOpenid())) {
                this.b.btnQq.setVisibility(8);
                this.b.lineQq.setVisibility(8);
            }
            if (com.up366.common.StringUtils.isEmptyOrNull(userInfo.getWeixinOpenid())) {
                this.b.btnWeixin.setVisibility(8);
                this.b.lineWeixin.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$3(final com.up366.mobile.user.account.AccountActivity accountActivity, android.view.View view) {
        com.up366.common.log.Logger.info("TAG - PageSelectReset - 通过微信找回密码");
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.b.btnWeixin, "正在加载");
        new com.up366.mobile.common.helper.WeixinAuthHelper().getOpenId(accountActivity, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$new$2(accountActivity, i, str, (java.lang.String[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(final com.up366.mobile.user.account.AccountActivity accountActivity, int i, java.lang.String str, final java.lang.String[] strArr) {
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.btnWeixin, str);
        } else {
            com.up366.mobile.common.logic.Auth.mgr().validateWeChatNoLogin(strArr[0], strArr[1], new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda4
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$new$1(accountActivity, strArr, response, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$1(com.up366.mobile.user.account.AccountActivity accountActivity, java.lang.String[] strArr, com.up366.common.http.Response response, java.lang.Object obj) {
        com.up366.common.log.Logger.info("TAG - PageSelectReset - " + response.toString());
        if (response.getCode() == -32) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.btnWeixin, "验证微信失败：该微信未被绑定");
        } else if (response.getCode() == -34) {
            openResetPasswordPage(accountActivity, this.b.btnWeixin, 3, null, null, null, strArr[0], null);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.btnWeixin, response);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$6(final com.up366.mobile.user.account.AccountActivity accountActivity, android.view.View view) {
        com.up366.common.log.Logger.info("TAG - PageSelectReset - 通过QQ找回密码");
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.b.btnQq, "正在加载");
        new com.up366.mobile.common.helper.QQAuthHelper().getOpenId(accountActivity, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda8
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$new$5(accountActivity, i, str, (java.lang.String[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(final com.up366.mobile.user.account.AccountActivity accountActivity, int i, java.lang.String str, final java.lang.String[] strArr) {
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.btnQq, str);
        } else {
            com.up366.mobile.common.logic.Auth.mgr().validateQQNoLogin(strArr[0], strArr[1], new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda2
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$new$4(accountActivity, strArr, response, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$4(com.up366.mobile.user.account.AccountActivity accountActivity, java.lang.String[] strArr, com.up366.common.http.Response response, java.lang.Object obj) {
        com.up366.common.log.Logger.info("TAG - PageSelectReset - " + response.toString());
        if (response.getCode() == -32) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.btnQq, "验证QQ失败：该QQ未被绑定");
        } else if (response.getCode() == -36) {
            openResetPasswordPage(accountActivity, this.b.btnQq, 4, null, null, null, null, strArr[0]);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.btnQq, response);
        }
    }

    public static void openResetPasswordBySmsPage(final android.app.Activity activity, final android.view.ViewGroup viewGroup) {
        com.up366.common.log.Logger.info("TAG - PageSelectReset - PageSelectReset - 通过短信找回密码");
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().openLoginAuth(activity, viewGroup, "短信重置密码", "一键短信验证", "换个手机号验证", "请勾选下方协议再验证哦~", new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                com.up366.mobile.user.account.reset.PageSelectReset.lambda$openResetPasswordBySmsPage$7(activity, viewGroup, i, str, (java.lang.String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$openResetPasswordBySmsPage$7(android.app.Activity activity, android.view.ViewGroup viewGroup, int i, java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - PageSelectReset - onResult - code = [" + i + "], info = [" + str + "], obj = [" + str2 + "]");
        if (i == -2) {
            com.up366.common.log.Logger.info("TAG - PageSelectReset - 获取token失败 ：" + viewGroup);
            if (com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, "服务器异常，请稍后重试");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(viewGroup, "网络好像走丢了\n请稍后重试!");
                return;
            }
        }
        if (i == -1) {
            com.up366.common.log.Logger.info("TAG - PageSelectReset - 打开失败，使用手动输入手机号页面");
            activity.getIntent().putExtra("find_password", true);
            com.up366.mobile.user.account.AccountActivity.openPage(activity, 2);
            return;
        }
        if (i == 0) {
            com.up366.common.log.Logger.info("TAG - PageSelectReset - 打开成功");
            return;
        }
        if (i == 1) {
            openResetPasswordPage(activity, viewGroup, 2, null, null, str2, null, null);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
            activity.finish();
            return;
        }
        com.up366.common.log.Logger.info("TAG - PageSelectReset - 换个手机号验证");
        com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
        activity.getIntent().putExtra("find_password", true);
        com.up366.mobile.user.account.AccountActivity.openPage(activity, 2);
    }

    private static void openResetPasswordPage(final android.app.Activity activity, final android.view.View view, final int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(view, "正在加载");
        com.up366.mobile.common.logic.Auth.mgr().findUserInfoByThirdParty(i, str, str2, str3, str4, str5, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.reset.PageSelectReset$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.user.account.reset.PageSelectReset.lambda$openResetPasswordPage$8(view, i, activity, response, (com.up366.mobile.common.logic.model.ThirdPartyUserInfo) obj);
            }
        });
    }

    static /* synthetic */ void lambda$openResetPasswordPage$8(android.view.View view, int i, android.app.Activity activity, com.up366.common.http.Response response, com.up366.mobile.common.logic.model.ThirdPartyUserInfo thirdPartyUserInfo) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - PageResetBySms - PageResetBySms - 获取用户信息 : ");
        sb.append(!response.isError());
        sb.append(" code:");
        sb.append(response.getCode());
        com.up366.common.log.Logger.info(sb.toString());
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(view);
            if (response.getCode() != -4) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, response);
                return;
            }
            if (i == 3) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "验证微信失败：该微信未被注册");
                return;
            } else if (i == 4) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "验证QQ失败：该QQ未被注册");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "验证手机号失败：该手机号\n未被注册");
                return;
            }
        }
        if (com.up366.mobile.common.logic.Auth.isAuth() && !com.up366.mobile.common.logic.Auth.getUserInfo().getUsername().equals(thirdPartyUserInfo.getUsername())) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(view);
            if (i == 3) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "验证微信失败：该微信未被绑定");
                return;
            } else if (i == 4) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "验证QQ失败：该QQ未被绑定");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "验证手机号失败：该手机\n号不是绑定的手机号");
                return;
            }
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(thirdPartyUserInfo.getMobile())) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(view);
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "该账号未绑定手机号，无法使用该功能");
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(view);
        activity.getIntent().putExtra("mobile", thirdPartyUserInfo.getMobile());
        activity.getIntent().putExtra("realName", thirdPartyUserInfo.getRealname());
        activity.getIntent().putExtra("username", thirdPartyUserInfo.getUsername());
        com.up366.mobile.user.account.AccountActivity.openPage(activity, 3);
        if (i == 2) {
            com.up366.mobile.common.utils.ToastPopupUtil.clean(view);
            com.up366.mobile.common.helper.ShanYanHelper.getInstance().finishAuthActivity();
        }
    }
}
