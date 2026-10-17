package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AssistantMainFragmentLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.LinearLayout llTitle;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;
    public final android.widget.TextView title;
    public final androidx.appcompat.widget.Toolbar toolbar;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected AssistantMainFragmentLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.LinearLayout linearLayout, androidx.recyclerview.widget.RecyclerView recyclerView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, android.widget.TextView textView, androidx.appcompat.widget.Toolbar toolbar, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.llTitle = linearLayout;
        this.recycleView = recyclerView;
        this.refreshLayout = pullRefreshLayout;
        this.title = textView;
        this.toolbar = toolbar;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.assistant_main_fragment_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.assistant_main_fragment_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AssistantMainFragmentLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.assistant_main_fragment_layout);
    }
}
