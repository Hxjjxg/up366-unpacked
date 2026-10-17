package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountFindActivitySelectCityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.LetterSelectView letterSelect;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;
    public final android.widget.TextView select;
    public final android.widget.TextView tip;

    protected AccountFindActivitySelectCityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.LetterSelectView letterSelectView, androidx.recyclerview.widget.RecyclerView recyclerView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.letterSelect = letterSelectView;
        this.recycleView = recyclerView;
        this.refreshLayout = pullRefreshLayout;
        this.select = textView;
        this.tip = textView2;
    }

    public static com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_find_activity_select_city_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_find_activity_select_city_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_find_activity_select_city_layout);
    }
}
