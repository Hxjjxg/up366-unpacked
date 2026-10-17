package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountLoginActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView acceptDealChecbox;
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.TextView btnLogin;
    public final android.widget.ImageView btnLoginQq;
    public final android.widget.ImageView btnLoginStudentNum;
    public final android.widget.TextView btnLoginTourist;
    public final android.widget.ImageView btnLoginWechat;
    public final android.widget.TextView btnMobileLogin;
    public final androidx.constraintlayout.widget.ConstraintLayout container;
    public final android.widget.TextView descQq;
    public final android.widget.TextView descStudentNum;
    public final android.widget.TextView descWechat;
    public final androidx.constraintlayout.helper.widget.Flow flow;
    public final android.widget.TextView forget;
    public final android.widget.TextView host;
    public final android.widget.ImageView ivEvs;
    public final android.widget.ImageView ivHideIcon;
    public final com.up366.mobile.common.views.AppTextView licenseText;
    public final com.up366.mobile.common.views.AppEditTextView password;
    public final android.widget.TextView register;
    public final android.widget.ScrollView scrollView;
    public final android.widget.TextView tip;
    public final com.up366.mobile.common.views.TitleBackView titleBackView;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    public final com.up366.mobile.common.views.AppEditTextView username;

    protected AccountLoginActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, android.widget.ImageView imageView2, android.widget.ImageView imageView3, android.widget.TextView textView2, android.widget.ImageView imageView4, android.widget.TextView textView3, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, androidx.constraintlayout.helper.widget.Flow flow, android.widget.TextView textView7, android.widget.TextView textView8, android.widget.ImageView imageView5, android.widget.ImageView imageView6, com.up366.mobile.common.views.AppTextView appTextView, com.up366.mobile.common.views.AppEditTextView appEditTextView, android.widget.TextView textView9, android.widget.ScrollView scrollView, android.widget.TextView textView10, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.up366.mobile.common.views.AppEditTextView appEditTextView2) {
        super(obj, view, i);
        this.acceptDealChecbox = imageView;
        this.appBar = appBarLayout;
        this.btnLogin = textView;
        this.btnLoginQq = imageView2;
        this.btnLoginStudentNum = imageView3;
        this.btnLoginTourist = textView2;
        this.btnLoginWechat = imageView4;
        this.btnMobileLogin = textView3;
        this.container = constraintLayout;
        this.descQq = textView4;
        this.descStudentNum = textView5;
        this.descWechat = textView6;
        this.flow = flow;
        this.forget = textView7;
        this.host = textView8;
        this.ivEvs = imageView5;
        this.ivHideIcon = imageView6;
        this.licenseText = appTextView;
        this.password = appEditTextView;
        this.register = textView9;
        this.scrollView = scrollView;
        this.tip = textView10;
        this.titleBackView = titleBackView;
        this.toolbarLayout = collapsingToolbarLayout;
        this.username = appEditTextView2;
    }

    public static com.up366.mobile.databinding.AccountLoginActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountLoginActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountLoginActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_login_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountLoginActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountLoginActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountLoginActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_login_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountLoginActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountLoginActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountLoginActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_login_activity_layout);
    }
}
