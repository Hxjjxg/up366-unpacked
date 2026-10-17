package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountActivityForgetSelectLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.AccountForgetItemView btnFindAccount;
    public final com.up366.mobile.common.views.AccountForgetItemView btnFindPassword;

    protected AccountActivityForgetSelectLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.AccountForgetItemView accountForgetItemView, com.up366.mobile.common.views.AccountForgetItemView accountForgetItemView2) {
        super(obj, view, i);
        this.btnFindAccount = accountForgetItemView;
        this.btnFindPassword = accountForgetItemView2;
    }

    public static com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_forget_select_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_forget_select_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityForgetSelectLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_activity_forget_select_layout);
    }
}
