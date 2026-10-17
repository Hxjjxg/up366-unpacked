package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityUpdatePhonePasswordLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.TextView btnNoCode;
    public final android.widget.Button btnSubmit;
    public final com.up366.mobile.common.views.AppEditTextView captcha;
    public final androidx.core.widget.NestedScrollView content;
    public final android.widget.TextView errorTip;
    public final android.widget.TextView errorTipAgainPassword;
    public final android.widget.TextView errorTipPassword;
    public final com.up366.mobile.common.views.AppEditTextView mobile;
    public final com.up366.mobile.common.views.AppEditTextView password;
    public final com.up366.mobile.common.views.AppEditTextView passwordAgain;
    public final android.widget.TextView tip;
    public final com.up366.mobile.common.views.TitleBackView titleBack;
    public final com.up366.mobile.common.views.TitleCloseGroupView titleClose;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected ActivityUpdatePhonePasswordLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, android.widget.Button button, com.up366.mobile.common.views.AppEditTextView appEditTextView, androidx.core.widget.NestedScrollView nestedScrollView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, com.up366.mobile.common.views.AppEditTextView appEditTextView2, com.up366.mobile.common.views.AppEditTextView appEditTextView3, com.up366.mobile.common.views.AppEditTextView appEditTextView4, android.widget.TextView textView5, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.TitleCloseGroupView titleCloseGroupView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.btnNoCode = textView;
        this.btnSubmit = button;
        this.captcha = appEditTextView;
        this.content = nestedScrollView;
        this.errorTip = textView2;
        this.errorTipAgainPassword = textView3;
        this.errorTipPassword = textView4;
        this.mobile = appEditTextView2;
        this.password = appEditTextView3;
        this.passwordAgain = appEditTextView4;
        this.tip = textView5;
        this.titleBack = titleBackView;
        this.titleClose = titleCloseGroupView;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_update_phone_password_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_update_phone_password_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUpdatePhonePasswordLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.activity_update_phone_password_layout);
    }
}
