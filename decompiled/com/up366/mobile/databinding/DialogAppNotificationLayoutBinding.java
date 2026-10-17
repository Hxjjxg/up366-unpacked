package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class DialogAppNotificationLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView agree;
    public final android.widget.ImageView btnClose;
    public final android.widget.TextView ok;
    public final android.widget.TextView quit;
    public final android.widget.TextView title;
    public final com.up366.mobile.common.views.TitleBarView titleBar;

    protected DialogAppNotificationLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, com.up366.mobile.common.views.TitleBarView titleBarView) {
        super(obj, view, i);
        this.agree = textView;
        this.btnClose = imageView;
        this.ok = textView2;
        this.quit = textView3;
        this.title = textView4;
        this.titleBar = titleBarView;
    }

    public static com.up366.mobile.databinding.DialogAppNotificationLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogAppNotificationLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogAppNotificationLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.dialog_app_notification_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.DialogAppNotificationLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogAppNotificationLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogAppNotificationLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.dialog_app_notification_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.DialogAppNotificationLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogAppNotificationLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogAppNotificationLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.dialog_app_notification_layout);
    }
}
