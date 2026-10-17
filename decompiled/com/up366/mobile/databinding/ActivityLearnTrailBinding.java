package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityLearnTrailBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.Button btFilterByTime;
    public final android.widget.ImageView ivToolbarBg;
    public final android.widget.LinearLayout llTrend;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefresh;
    public final com.up366.mobile.common.views.TitleBackView tbvTrailBack;
    public final androidx.appcompat.widget.Toolbar toolbar;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    public final com.up366.mobile.common.views.TrendView trendHomeworkComplete;
    public final com.up366.mobile.common.views.TrendView trendScoreRatio;

    protected ActivityLearnTrailBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.Button button, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, com.up366.mobile.common.views.TitleBackView titleBackView, androidx.appcompat.widget.Toolbar toolbar, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.up366.mobile.common.views.TrendView trendView, com.up366.mobile.common.views.TrendView trendView2) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.btFilterByTime = button;
        this.ivToolbarBg = imageView;
        this.llTrend = linearLayout;
        this.pullRefresh = pullRefreshLayout;
        this.tbvTrailBack = titleBackView;
        this.toolbar = toolbar;
        this.toolbarLayout = collapsingToolbarLayout;
        this.trendHomeworkComplete = trendView;
        this.trendScoreRatio = trendView2;
    }

    public static com.up366.mobile.databinding.ActivityLearnTrailBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityLearnTrailBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityLearnTrailBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_learn_trail, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityLearnTrailBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityLearnTrailBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityLearnTrailBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_learn_trail, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityLearnTrailBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityLearnTrailBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityLearnTrailBinding) bind(obj, view, com.up366.mobile.R.layout.activity_learn_trail);
    }
}
