package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountRegisterActivityPageInputMobileLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button btnRegister;
    public final com.up366.mobile.common.views.AppEditTextView captcha;
    public final android.widget.TextView errorTip;
    public final android.widget.TextView errorTipPassword;
    public final android.widget.CheckBox license;
    public final com.up366.mobile.common.views.AppTextView licenseText;
    public final com.up366.mobile.common.views.AppEditTextView mobile;
    public final com.up366.mobile.common.views.AppEditTextView password;
    public final com.up366.mobile.common.views.AppEditTextView passwordAgain;
    public final android.widget.TextView tip;

    protected AccountRegisterActivityPageInputMobileLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, com.up366.mobile.common.views.AppEditTextView appEditTextView, android.widget.TextView textView, android.widget.TextView textView2, android.widget.CheckBox checkBox, com.up366.mobile.common.views.AppTextView appTextView, com.up366.mobile.common.views.AppEditTextView appEditTextView2, com.up366.mobile.common.views.AppEditTextView appEditTextView3, com.up366.mobile.common.views.AppEditTextView appEditTextView4, android.widget.TextView textView3) {
        super(obj, view, i);
        this.btnRegister = button;
        this.captcha = appEditTextView;
        this.errorTip = textView;
        this.errorTipPassword = textView2;
        this.license = checkBox;
        this.licenseText = appTextView;
        this.mobile = appEditTextView2;
        this.password = appEditTextView3;
        this.passwordAgain = appEditTextView4;
        this.tip = textView3;
    }

    public static com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_register_activity_page_input_mobile_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_register_activity_page_input_mobile_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountRegisterActivityPageInputMobileLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_register_activity_page_input_mobile_layout);
    }
}
