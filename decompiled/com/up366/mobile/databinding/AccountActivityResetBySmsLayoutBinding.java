package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountActivityResetBySmsLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button btnNext;
    public final com.up366.mobile.common.views.AppEditTextView captcha;
    public final android.widget.TextView errorTip;
    public final com.up366.mobile.common.views.AppEditTextView mobile;
    public final android.widget.TextView tipMessage;

    protected AccountActivityResetBySmsLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, com.up366.mobile.common.views.AppEditTextView appEditTextView, android.widget.TextView textView, com.up366.mobile.common.views.AppEditTextView appEditTextView2, android.widget.TextView textView2) {
        super(obj, view, i);
        this.btnNext = button;
        this.captcha = appEditTextView;
        this.errorTip = textView;
        this.mobile = appEditTextView2;
        this.tipMessage = textView2;
    }

    public static com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_reset_by_sms_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_reset_by_sms_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityResetBySmsLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_activity_reset_by_sms_layout);
    }
}
