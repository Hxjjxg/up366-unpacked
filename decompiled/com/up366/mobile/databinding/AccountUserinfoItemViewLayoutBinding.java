package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountUserinfoItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnCopy;
    public final android.widget.TextView btnLogin;
    public final android.widget.ImageView head;
    public final android.widget.TextView nameAndOrgan;
    public final android.widget.TextView username;

    protected AccountUserinfoItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ImageView imageView, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.btnCopy = textView;
        this.btnLogin = textView2;
        this.head = imageView;
        this.nameAndOrgan = textView3;
        this.username = textView4;
    }

    public static com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_userinfo_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_userinfo_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_userinfo_item_view_layout);
    }
}
