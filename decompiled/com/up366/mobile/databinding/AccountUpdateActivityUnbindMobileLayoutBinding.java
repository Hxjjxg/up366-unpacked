package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountUpdateActivityUnbindMobileLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button btnUnbind;
    public final com.up366.mobile.common.views.CaptchaEditText captcha;
    public final android.widget.TextView captchaTip;
    public final android.widget.TextView currentMobile;
    public final androidx.constraintlayout.widget.ConstraintLayout root;
    public final android.widget.TextView sendCaptcha;

    protected AccountUpdateActivityUnbindMobileLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, com.up366.mobile.common.views.CaptchaEditText captchaEditText, android.widget.TextView textView, android.widget.TextView textView2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView3) {
        super(obj, view, i);
        this.btnUnbind = button;
        this.captcha = captchaEditText;
        this.captchaTip = textView;
        this.currentMobile = textView2;
        this.root = constraintLayout;
        this.sendCaptcha = textView3;
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_update_activity_unbind_mobile_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_update_activity_unbind_mobile_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityUnbindMobileLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_update_activity_unbind_mobile_layout);
    }
}
