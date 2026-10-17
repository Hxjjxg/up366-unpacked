package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class NoNotificationPermissionView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.ViewNoNotificationPermissionBinding binding;

    public NoNotificationPermissionView(android.content.Context context) {
        this(context, null);
    }

    public NoNotificationPermissionView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoNotificationPermissionView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        com.up366.mobile.databinding.ViewNoNotificationPermissionBinding viewNoNotificationPermissionBinding = (com.up366.mobile.databinding.ViewNoNotificationPermissionBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.view_no_notification_permission, this, true);
        this.binding = viewNoNotificationPermissionBinding;
        viewNoNotificationPermissionBinding.btNotifyClose.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.NoNotificationPermissionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        this.binding.btNotifyOpen.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.NoNotificationPermissionView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(android.view.View view) {
        try {
            android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(android.net.Uri.fromParts("package", getContext().getPackageName(), null));
            getContext().startActivity(intent);
        } catch (java.lang.Exception unused) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this, "操作失败了，请到应用设置页手动设置");
        }
    }
}
