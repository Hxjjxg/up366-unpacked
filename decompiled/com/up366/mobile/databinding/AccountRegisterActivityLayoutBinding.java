package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountRegisterActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.TextView btnNoCode;
    public final androidx.core.widget.NestedScrollView content;
    public final android.widget.TextView pager;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected AccountRegisterActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, androidx.core.widget.NestedScrollView nestedScrollView, android.widget.TextView textView2, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.btnNoCode = textView;
        this.content = nestedScrollView;
        this.pager = textView2;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_register_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_register_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountRegisterActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_register_activity_layout);
    }
}
