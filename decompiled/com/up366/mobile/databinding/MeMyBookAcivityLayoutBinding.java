package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeMyBookAcivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.TextView meMyBookSelector;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final android.widget.ImageView searchIcon;
    public final androidx.appcompat.widget.Toolbar toolbar;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected MeMyBookAcivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.ImageView imageView, androidx.appcompat.widget.Toolbar toolbar, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.meMyBookSelector = textView;
        this.pullRefreshLayout = pullRefreshLayout;
        this.recycleView = recyclerView;
        this.searchIcon = imageView;
        this.toolbar = toolbar;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_my_book_acivity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_my_book_acivity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_my_book_acivity_layout);
    }
}
