package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountActivityLoginByMobileLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button btnLogin;
    public final android.widget.TextView btnLoginShanyan;
    public final com.up366.mobile.common.views.AppEditTextView captcha;
    public final android.widget.TextView errorTip;
    public final com.up366.mobile.common.views.AppEditTextView mobile;

    protected AccountActivityLoginByMobileLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, android.widget.TextView textView, com.up366.mobile.common.views.AppEditTextView appEditTextView, android.widget.TextView textView2, com.up366.mobile.common.views.AppEditTextView appEditTextView2) {
        super(obj, view, i);
        this.btnLogin = button;
        this.btnLoginShanyan = textView;
        this.captcha = appEditTextView;
        this.errorTip = textView2;
        this.mobile = appEditTextView2;
    }

    public static com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_login_by_mobile_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_login_by_mobile_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityLoginByMobileLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_activity_login_by_mobile_layout);
    }
}
