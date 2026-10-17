package com.up366.mobile.user.setting;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SettingAuthorActivity extends com.up366.mobile.common.base.BaseActivity implements android.view.View.OnClickListener {
    private com.up366.mobile.databinding.ActivitySystemAuthorBinding binding;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_setting_system";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.ActivitySystemAuthorBinding activitySystemAuthorBinding = (com.up366.mobile.databinding.ActivitySystemAuthorBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_system_author);
        this.binding = activitySystemAuthorBinding;
        activitySystemAuthorBinding.audioManage.setOnClickListener(this);
        this.binding.camaraManage.setOnClickListener(this);
        this.binding.storageManage.setOnClickListener(this);
        this.binding.installManage.setOnClickListener(this);
        this.binding.flowManage.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        boolean zLacksPermission = lacksPermission(com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO);
        this.binding.audioManage.setText(zLacksPermission ? "已允许" : "权限设置");
        android.widget.TextView textView = this.binding.audioManage;
        android.content.res.Resources resources = getResources();
        int i = com.up366.mobile.R.color.link_grey;
        textView.setTextColor(resources.getColor(zLacksPermission ? 2131099834 : 2131099833));
        boolean zLacksPermission2 = lacksPermission(com.up366.mobile.common.utils.permissions.Permission.CAMERA);
        this.binding.camaraManage.setText(zLacksPermission2 ? "已允许" : "权限设置");
        this.binding.camaraManage.setTextColor(getResources().getColor(zLacksPermission2 ? 2131099834 : 2131099833));
        boolean zLacksPermission3 = lacksPermission(com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE);
        this.binding.storageManage.setText(zLacksPermission3 ? "已允许" : "权限设置");
        this.binding.storageManage.setTextColor(getResources().getColor(zLacksPermission3 ? 2131099834 : 2131099833));
        boolean zLacksPermission4 = lacksPermission(com.up366.mobile.common.utils.permissions.Permission.REQUEST_INSTALL_PACKAGES);
        this.binding.installManage.setText(zLacksPermission4 ? "已允许" : "权限设置");
        this.binding.installManage.setTextColor(getResources().getColor(zLacksPermission4 ? 2131099834 : 2131099833));
        boolean zHasPermission = com.up366.mobile.common.mask.MaskHelper.hasPermission(this);
        this.binding.flowManage.setText(zHasPermission ? "已允许" : "权限设置");
        android.widget.TextView textView2 = this.binding.flowManage;
        android.content.res.Resources resources2 = getResources();
        if (!zHasPermission) {
            i = 2131099833;
        }
        textView2.setTextColor(resources2.getColor(i));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        try {
            if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
                com.up366.mobile.common.utils.ToastPopupUtil.show("打开失败，平板设备无法设置权限");
                return;
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(android.net.Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("跳转失败，请手动设置");
            com.up366.common.log.Logger.error("SettingAuthorActivity", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean lacksPermission(java.lang.String str) {
        return androidx.core.content.ContextCompat.checkSelfPermission(this, str) != -1;
    }

    public static void open(android.app.Activity activity) {
        activity.startActivity(new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.user.setting.SettingAuthorActivity.class));
    }
}
