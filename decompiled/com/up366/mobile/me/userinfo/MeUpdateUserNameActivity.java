package com.up366.mobile.me.userinfo;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeUpdateUserNameActivity extends com.up366.mobile.common.base.BaseActivity implements android.view.View.OnClickListener {
    private com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding binding;

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.binding = (com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_update_username_activity_layout);
        initView();
    }

    private void initView() {
        this.binding.clear.setOnClickListener(this);
        this.binding.meRealNameSaveBtn.setOnClickListener(this);
        this.binding.meRealNameSaveBtn.setEnabled(false);
        this.binding.realNameEditText.addTextChangedListener(new android.text.TextWatcher() { // from class: com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                int length = com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.this.binding.realNameEditText.getText().toString().length();
                com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.this.binding.meRealNameSaveBtn.setEnabled(length != 0);
                com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.this.binding.errorTip.setVisibility(4);
                if (length > 10) {
                    com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.this.binding.lengthTip.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("" + length).setSpan(new android.text.style.ForegroundColorSpan(-65536)).append("/10").build());
                } else {
                    com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.this.binding.lengthTip.setText(java.lang.String.format("%d/10", java.lang.Integer.valueOf(length)));
                }
                com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.this.binding.clear.setVisibility(length == 0 ? 4 : 0);
            }
        });
    }

    public static void openPage(android.content.Context context) {
        if (context == null) {
            com.up366.common.log.Logger.error("open MeUpdateUserNameActivity error, context is null");
        } else {
            context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.class));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == 2131362146) {
            this.binding.clear.setVisibility(4);
            this.binding.realNameEditText.setText("");
            return;
        }
        if (id != 2131362812) {
            return;
        }
        java.lang.String string = this.binding.realNameEditText.getText().toString();
        if (com.up366.common.StringUtils.isEmptyOrNull(this.binding.meRealNameSaveBtn.getText().toString())) {
            return;
        }
        if (string.length() > 10) {
            this.binding.errorTip.setVisibility(0);
            this.binding.errorTip.setText("超出最大字数限制");
        } else if (!com.up366.mobile.common.utils.CharUtil.isAllChinese(string) || com.up366.common.ValidateUtilsUp.containsEmoji(string)) {
            this.binding.errorTip.setVisibility(0);
            this.binding.errorTip.setText("请只输入汉字");
        } else {
            this.binding.meRealNameSaveBtn.setText("");
            this.binding.meSaveBtnLoading.setVisibility(0);
            com.up366.mobile.common.utils.AnimUtils.showAnimation(this.binding.meSaveBtnLoading);
            com.up366.mobile.common.logic.Auth.cur().info().updateUserRealName(string);
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MeRealNameUpdateEvent meRealNameUpdateEvent) {
        this.binding.meSaveBtnLoading.setVisibility(4);
        this.binding.meRealNameSaveBtn.setText("立即保存");
        com.up366.mobile.common.utils.AnimUtils.cancelAnimation(this.binding.meSaveBtnLoading);
        if (!meRealNameUpdateEvent.resp.isError()) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.me.userinfo.MeUpdateUserNameActivity$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(com.up366.common.global.GB.get().getCurrentActivity(), "保存成功");
                }
            });
            finish();
            return;
        }
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "保存失败:网络原因，请稍后再试！");
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(meRealNameUpdateEvent.resp.getInfo())) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "服务器异常，请稍后重试");
        } else if (meRealNameUpdateEvent.resp.getCode() == -9) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.me.userinfo.MeUpdateUserNameActivity$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo(com.up366.common.global.GB.get().getCurrentActivity(), "您的姓名已经修改成功，无法重复修改");
                }
            });
            finish();
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, meRealNameUpdateEvent.resp);
        }
    }
}
