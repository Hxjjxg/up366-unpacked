package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountUpdateActivityMobileLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button btnChange;
    public final android.widget.TextView btnNoCode;
    public final com.up366.mobile.common.views.AppEditTextView captcha;
    public final android.widget.TextView currentMobile;
    public final android.widget.TextView errorTip;
    public final com.up366.mobile.common.views.AppEditTextView mobile;
    public final androidx.constraintlayout.widget.ConstraintLayout root;
    public final android.widget.TextView unbindMobile;

    protected AccountUpdateActivityMobileLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, android.widget.TextView textView, com.up366.mobile.common.views.AppEditTextView appEditTextView, android.widget.TextView textView2, android.widget.TextView textView3, com.up366.mobile.common.views.AppEditTextView appEditTextView2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView4) {
        super(obj, view, i);
        this.btnChange = button;
        this.btnNoCode = textView;
        this.captcha = appEditTextView;
        this.currentMobile = textView2;
        this.errorTip = textView3;
        this.mobile = appEditTextView2;
        this.root = constraintLayout;
        this.unbindMobile = textView4;
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_update_activity_mobile_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_update_activity_mobile_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUpdateActivityMobileLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_update_activity_mobile_layout);
    }
}
