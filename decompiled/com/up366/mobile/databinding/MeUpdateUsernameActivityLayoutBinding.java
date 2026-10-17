package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeUpdateUsernameActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.ImageView clear;
    public final android.widget.TextView errorTip;
    public final android.widget.TextView lengthTip;
    public final android.widget.TextView meRealNameSaveBtn;
    public final android.widget.ImageView meSaveBtnLoading;
    public final com.up366.mobile.common.views.CommonEditText realNameEditText;
    public final android.widget.TextView tipTxt;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected MeUpdateUsernameActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.ImageView imageView, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.ImageView imageView2, com.up366.mobile.common.views.CommonEditText commonEditText, android.widget.TextView textView4, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.clear = imageView;
        this.errorTip = textView;
        this.lengthTip = textView2;
        this.meRealNameSaveBtn = textView3;
        this.meSaveBtnLoading = imageView2;
        this.realNameEditText = commonEditText;
        this.tipTxt = textView4;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_update_username_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_update_username_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeUpdateUsernameActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_update_username_activity_layout);
    }
}
