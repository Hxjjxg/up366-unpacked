package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityUnfamiliarWordRankBinding extends androidx.databinding.ViewDataBinding {
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;
    public final androidx.recyclerview.widget.RecyclerView rvRankList;
    public final com.up366.mobile.common.views.TitleBarView titleBar;

    protected ActivityUnfamiliarWordRankBinding(java.lang.Object obj, android.view.View view, int i, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.mobile.common.views.TitleBarView titleBarView) {
        super(obj, view, i);
        this.refreshLayout = pullRefreshLayout;
        this.rvRankList = recyclerView;
        this.titleBar = titleBarView;
    }

    public static com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_unfamiliar_word_rank, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_unfamiliar_word_rank, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding) bind(obj, view, com.up366.mobile.R.layout.activity_unfamiliar_word_rank);
    }
}
