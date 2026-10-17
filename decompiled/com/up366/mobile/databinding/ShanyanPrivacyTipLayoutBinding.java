package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ShanyanPrivacyTipLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.view.View arrow;
    public final com.up366.mobile.common.views.AppTextView text;

    protected ShanyanPrivacyTipLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.view.View view2, com.up366.mobile.common.views.AppTextView appTextView) {
        super(obj, view, i);
        this.arrow = view2;
        this.text = appTextView;
    }

    public static com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.shanyan_privacy_tip_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.shanyan_privacy_tip_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.shanyan_privacy_tip_layout);
    }
}
