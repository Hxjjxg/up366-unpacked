package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeMyBookSearchAcivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final android.widget.TextView searchCancel;
    public final com.up366.mobile.common.views.AppEditTextView searchText;

    protected MeMyBookSearchAcivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.TextView textView, com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        super(obj, view, i);
        this.pullRefreshLayout = pullRefreshLayout;
        this.recycleView = recyclerView;
        this.searchCancel = textView;
        this.searchText = appEditTextView;
    }

    public static com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_my_book_search_acivity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_my_book_search_acivity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_my_book_search_acivity_layout);
    }
}
