package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountActivitySelectResetOptionLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.AppMenuItemView btnQq;
    public final com.up366.mobile.common.views.AppMenuItemView btnSms;
    public final com.up366.mobile.common.views.AppMenuItemView btnWeixin;
    public final android.view.View lineQq;
    public final android.view.View lineWeixin;

    protected AccountActivitySelectResetOptionLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.AppMenuItemView appMenuItemView, com.up366.mobile.common.views.AppMenuItemView appMenuItemView2, com.up366.mobile.common.views.AppMenuItemView appMenuItemView3, android.view.View view2, android.view.View view3) {
        super(obj, view, i);
        this.btnQq = appMenuItemView;
        this.btnSms = appMenuItemView2;
        this.btnWeixin = appMenuItemView3;
        this.lineQq = view2;
        this.lineWeixin = view3;
    }

    public static com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_select_reset_option_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_select_reset_option_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivitySelectResetOptionLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_activity_select_reset_option_layout);
    }
}
