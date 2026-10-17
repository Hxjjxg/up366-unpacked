package com.up366.mobile.me.logoff;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LogOffAccountActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.UserLogOffActivityLayoutBinding b;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_setting_account_log_out";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(this);
        this.b = (com.up366.mobile.databinding.UserLogOffActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.user_log_off_activity_layout);
        com.up366.mobile.common.utils.SpannableStringBuilderUtil spannableStringBuilderUtil = new com.up366.mobile.common.utils.SpannableStringBuilderUtil();
        spannableStringBuilderUtil.append("注销后，系统将自动解绑该账号绑定的微信、QQ、手机号和家长微信号，并清空平台储存的所有历史数据。").append("（若账号仍有余额，将返回到原账户）").setSpan(new android.text.style.ForegroundColorSpan(-10715905));
        this.b.tx8.setText(spannableStringBuilderUtil.build());
        android.text.SpannableString spannableString = new android.text.SpannableString("您也可以在工作日 9:00-18:00 联系我们\n客服电话：4006426166");
        spannableString.setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.me.logoff.LogOffAccountActivity.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                try {
                    android.content.Intent intent = new android.content.Intent("android.intent.action.DIAL");
                    intent.setData(android.net.Uri.parse("tel:4006426166"));
                    com.up366.mobile.me.logoff.LogOffAccountActivity.this.startActivity(intent);
                } catch (java.lang.Exception unused) {
                    com.up366.mobile.common.utils.ToastPopupUtil.show("启动拨号失败，无法调起拨号");
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(-9661697);
                textPaint.setUnderlineText(false);
            }
        }, 30, 40, 17);
        this.b.telephoneTip.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.b.telephoneTip.setHighlightColor(0);
        this.b.telephoneTip.setText(spannableString);
        new com.up366.mobile.common.dialog.CancelProtocolDialog().show(this, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.me.logoff.LogOffAccountActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$onCreate$0(i);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.logOffBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.logoff.LogOffAccountActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(int i) {
        if (i == -1) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(android.view.View view) {
        final com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(this);
        baseDialog.create(com.up366.mobile.R.layout.dialog_log_off_layout);
        final android.widget.TextView textView = (android.widget.TextView) baseDialog.getView(com.up366.mobile.R.id.error_tip);
        final android.widget.EditText editText = (android.widget.EditText) baseDialog.getView(2131362178);
        final android.widget.TextView textView2 = (android.widget.TextView) baseDialog.getView(com.up366.mobile.R.id.dialog_confirm);
        textView2.setEnabled(false);
        editText.addTextChangedListener(new android.text.TextWatcher() { // from class: com.up366.mobile.me.logoff.LogOffAccountActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                textView.setVisibility(4);
                textView2.setEnabled(!com.up366.common.StringUtils.isEmptyOrNull(editText.getText().toString()));
            }
        });
        baseDialog.setOnClickListener(new int[]{com.up366.mobile.R.id.dialog_cancel, com.up366.mobile.R.id.dialog_confirm}, new int[]{com.up366.mobile.R.id.dialog_confirm}, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.logoff.LogOffAccountActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$onCreate$2(editText, textView, baseDialog, view2);
            }
        });
        baseDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(android.widget.EditText editText, android.widget.TextView textView, com.up366.mobile.common.dialog.BaseDialog baseDialog, android.view.View view) {
        if (view.getId() == 2131362276) {
            if (!"我确认注销账号".equals(editText.getText().toString())) {
                textView.setVisibility(0);
                return;
            }
            baseDialog.dismiss();
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "加载中");
            com.up366.mobile.common.logic.Auth.cur().info().fetchPersonInfo(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.logoff.LogOffAccountActivity$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$onCreate$1(response, (java.lang.String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(com.up366.common.http.Response response, java.lang.String str) {
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, "注销失败,失败原因：" + response.getInfo());
        } else if (com.up366.mobile.common.logic.Auth.getUserInfo().isWeakPassword()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, "注销失败,失败原因：账号安全度过低，请绑定手机号并修改密码后再操作");
        } else if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile())) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, "注销失败,失败原因：账号安全度过低，请绑定手机号并修改密码后再操作");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            com.up366.mobile.me.logoff.LogOffAccountConfirmActivity.start(this);
        }
    }
}
