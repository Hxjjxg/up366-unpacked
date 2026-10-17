package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountFindActivitySelectClassLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final android.widget.TextView titlePadding;

    protected AccountFindActivitySelectClassLayoutBinding(java.lang.Object obj, android.view.View view, int i, androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.TextView textView) {
        super(obj, view, i);
        this.recycleView = recyclerView;
        this.titlePadding = textView;
    }

    public static com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_find_activity_select_class_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_find_activity_select_class_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_find_activity_select_class_layout);
    }
}
