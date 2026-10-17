package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountFindActivityValidClassmatesLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.Button btnNext;
    public final androidx.recyclerview.widget.RecyclerView recycleView;

    protected AccountFindActivityValidClassmatesLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.Button button, androidx.recyclerview.widget.RecyclerView recyclerView) {
        super(obj, view, i);
        this.btnNext = button;
        this.recycleView = recyclerView;
    }

    public static com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_find_activity_valid_classmates_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_find_activity_valid_classmates_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_find_activity_valid_classmates_layout);
    }
}
