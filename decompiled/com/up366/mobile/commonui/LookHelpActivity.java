package com.up366.mobile.commonui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LookHelpActivity extends com.up366.mobile.common.base.BaseActivity {
    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "look_help";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.LookHelpActivityLayoutBinding lookHelpActivityLayoutBinding = (com.up366.mobile.databinding.LookHelpActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.look_help_activity_layout);
        lookHelpActivityLayoutBinding.lookHelpToSetting.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 4 : 0);
        lookHelpActivityLayoutBinding.lookHelpToSetting.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.LookHelpActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        try {
            startActivity(new android.content.Intent("android.settings.SETTINGS"));
        } catch (java.lang.Exception unused) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "无法打开设置界面，请您手动打开");
        }
    }

    public static void openPage(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.LookHelpActivity.class));
    }
}
