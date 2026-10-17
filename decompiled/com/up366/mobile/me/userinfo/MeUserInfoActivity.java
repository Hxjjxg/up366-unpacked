package com.up366.mobile.me.userinfo;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeUserInfoActivity extends com.up366.mobile.common.base.BaseActivity implements android.view.View.OnClickListener {
    private com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding binding;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_personal_data";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.binding = (com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_user_info_activity_layout);
        initView();
        com.up366.mobile.common.logic.Auth.cur().info().fetchPersonInfo();
        com.up366.mobile.common.logic.Auth.cur().info().fetchUserClassInfo();
    }

    private void initView() {
        this.binding.meUsername.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        setRealName();
        this.binding.meSchool.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getOrganName());
        this.binding.meClassname.setText(com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getClassName()) ? "无" : com.up366.mobile.common.logic.Auth.getUserInfo().getClassName());
        this.binding.mePhoto.getBinding().userInfoRightArrow.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.mePhoto.setOnClickListener(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? null : this);
        this.binding.meRealname.setOnClickListener(this);
        this.binding.meSchool.setOnClickListener(this);
        this.binding.meClassname.setOnClickListener(this);
        java.lang.String reserved1 = com.up366.mobile.common.logic.Auth.getUserInfo().getReserved1();
        if (android.text.TextUtils.isEmpty(reserved1)) {
            reserved1 = "-";
        }
        this.binding.meStudentNumber.setText(reserved1);
    }

    private void setRealName() {
        java.lang.String realname = com.up366.mobile.common.logic.Auth.getUserInfo().getRealname();
        if (needInputRealName(realname)) {
            this.binding.meRealname.setText("请输入姓名", getResources().getColor(com.up366.mobile.R.color.c1), true);
        } else {
            this.binding.meRealname.setText(realname, getResources().getColor(com.up366.mobile.R.color.c5), false);
        }
    }

    private boolean needInputRealName(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) || com.up366.mobile.common.utils.RealNameUtils.isSystemCreate(str);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        this.binding.mePhoto.reload();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.RefreshUserInfo refreshUserInfo) {
        if (refreshUserInfo.getResp() != null && refreshUserInfo.getResp().isError()) {
            com.up366.common.log.Logger.error("RefreshUserInfo  error " + refreshUserInfo.getResp().getInfo());
            return;
        }
        initView();
    }

    public static void openPage(android.content.Context context) {
        if (context == null || !com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.common.log.Logger.error("open MeUserInfoActivity error, context is null " + com.up366.mobile.common.logic.Auth.isAuth());
            return;
        }
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.userinfo.MeUserInfoActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        switch (view.getId()) {
            case com.up366.mobile.R.id.me_classname /* 2131362795 */:
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "不可修改班级");
                break;
            case com.up366.mobile.R.id.me_photo /* 2131362807 */:
                if (com.up366.mobile.common.logic.Auth.isTourist()) {
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "游客无法修改头像");
                } else {
                    com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.openPage(this);
                }
                break;
            case com.up366.mobile.R.id.me_realname /* 2131362813 */:
                if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "该版本不支持修改姓名");
                } else if (needInputRealName(com.up366.mobile.common.logic.Auth.getUserInfo().getRealname())) {
                    com.up366.mobile.me.userinfo.MeUpdateUserNameActivity.openPage(this);
                } else {
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "不可修改姓名");
                }
                break;
            case com.up366.mobile.R.id.me_school /* 2131362815 */:
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "不可修改学校");
                break;
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MeRealNameUpdateEvent meRealNameUpdateEvent) {
        setRealName();
    }
}
