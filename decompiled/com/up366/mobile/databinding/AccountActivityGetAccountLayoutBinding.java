package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountActivityGetAccountLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView dot1;
    public final android.widget.ImageView dot2;
    public final android.widget.TextView text1;
    public final android.widget.TextView text2;
    public final android.widget.TextView title1;
    public final android.widget.TextView title2;

    protected AccountActivityGetAccountLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.dot1 = imageView;
        this.dot2 = imageView2;
        this.text1 = textView;
        this.text2 = textView2;
        this.title1 = textView3;
        this.title2 = textView4;
    }

    public static com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_get_account_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_activity_get_account_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_activity_get_account_layout);
    }
}
