package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountUpdateActivityHomeLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView cancellation;
    public final com.up366.mobile.common.views.AccountSettingItemView changeMobile;
    public final com.up366.mobile.common.views.AccountSettingItemView changePassword;
    public final com.up366.mobile.common.views.AccountSettingItemView changeQq;
    public final com.up366.mobile.common.views.AccountSettingItemView changeWechat;
    public final android.view.View line1;
    public final android.view.View line2;
    public final com.up366.mobile.common.views.AccountSettingItemView setVoice;
    public final android.widget.TextView username;

    protected AccountUpdateActivityHomeLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, com.up366.mobile.common.views.AccountSettingItemView accountSettingItemView, com.up366.mobile.common.views.AccountSettingItemView accountSettingItemView2, com.up366.mobile.common.views.AccountSettingItemView accountSettingItemView3, com.up366.mobile.common.views.AccountSettingItemView accountSettingItemView4, android.view.View view2, android.view.View view3, com.up366.mobile.common.views.AccountSettingItemView accountSettingItemView5, android.widget.TextView textView2) {
        super(obj, view, i);
        this.cancellation = textView;
        this.changeMobile = accountSettingItemView;
        this.changePassword = accountSettingItemView2;
        this.changeQq = accountSettingItemView3;
        this.changeWechat = accountSettingItemView4;
        this.line1 = view2;
        this.line2 = view3;
        this.setVoice = accountSettingItemView5;
        this.username = textView2;
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_update_activity_home_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_update_activity_home_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityHomeLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_update_activity_home_layout);
    }
}
