package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ViewNoNotificationPermissionBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageButton btNotifyClose;
    public final android.widget.Button btNotifyOpen;

    protected ViewNoNotificationPermissionBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageButton imageButton, android.widget.Button button) {
        super(obj, view, i);
        this.btNotifyClose = imageButton;
        this.btNotifyOpen = button;
    }

    public static com.up366.mobile.databinding.ViewNoNotificationPermissionBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewNoNotificationPermissionBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewNoNotificationPermissionBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_no_notification_permission, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ViewNoNotificationPermissionBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewNoNotificationPermissionBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewNoNotificationPermissionBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.view_no_notification_permission, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ViewNoNotificationPermissionBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ViewNoNotificationPermissionBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ViewNoNotificationPermissionBinding) bind(obj, view, com.up366.mobile.R.layout.view_no_notification_permission);
    }
}
