package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountFindActivityValidRealNameLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button btnNext;
    public final com.up366.mobile.common.views.AppEditTextView edit;
    public final android.widget.TextView tip;
    public final android.widget.LinearLayout tipLayout;

    protected AccountFindActivityValidRealNameLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, com.up366.mobile.common.views.AppEditTextView appEditTextView, android.widget.TextView textView, android.widget.LinearLayout linearLayout) {
        super(obj, view, i);
        this.btnNext = button;
        this.edit = appEditTextView;
        this.tip = textView;
        this.tipLayout = linearLayout;
    }

    public static com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_find_activity_valid_real_name_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_find_activity_valid_real_name_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_find_activity_valid_real_name_layout);
    }
}
