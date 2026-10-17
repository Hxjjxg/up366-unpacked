package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountActivityResetPasswordLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button btnReset;
    public final android.widget.TextView errorTipPassword;
    public final com.up366.mobile.common.views.AppEditTextView password;
    public final com.up366.mobile.common.views.AppEditTextView passwordAgain;
    public final android.widget.TextView tip;

    protected AccountActivityResetPasswordLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, android.widget.TextView textView, com.up366.mobile.common.views.AppEditTextView appEditTextView, com.up366.mobile.common.views.AppEditTextView appEditTextView2, android.widget.TextView textView2) {
        super(obj, view, i);
        this.btnReset = button;
        this.errorTipPassword = textView;
        this.password = appEditTextView;
        this.passwordAgain = appEditTextView2;
        this.tip = textView2;
    }

    public static com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_reset_password_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_reset_password_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityResetPasswordLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_activity_reset_password_layout);
    }
}
