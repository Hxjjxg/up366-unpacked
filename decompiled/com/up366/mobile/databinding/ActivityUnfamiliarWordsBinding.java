package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityUnfamiliarWordsBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.LinearLayout bottomView;
    public final com.up366.mobile.common.views.BlueButtonBottomView bottomViewReadWord;
    public final com.up366.mobile.common.views.BlueButtonBottomView bottomViewSelectWord;
    public final android.widget.ImageButton ibRankingList;
    public final android.widget.ImageButton ibTip;
    public final android.widget.LinearLayout llSelectClass;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;
    public final android.widget.CheckedTextView selectBtn;
    public final com.up366.mobile.common.views.TitleBackView tbvTrailBack;
    public final com.up366.mobile.common.views.MarqueeTextView title;
    public final androidx.appcompat.widget.Toolbar toolbar;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected ActivityUnfamiliarWordsBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.LinearLayout linearLayout, com.up366.mobile.common.views.BlueButtonBottomView blueButtonBottomView, com.up366.mobile.common.views.BlueButtonBottomView blueButtonBottomView2, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, android.widget.LinearLayout linearLayout2, androidx.recyclerview.widget.RecyclerView recyclerView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, android.widget.CheckedTextView checkedTextView, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.MarqueeTextView marqueeTextView, androidx.appcompat.widget.Toolbar toolbar, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.bottomView = linearLayout;
        this.bottomViewReadWord = blueButtonBottomView;
        this.bottomViewSelectWord = blueButtonBottomView2;
        this.ibRankingList = imageButton;
        this.ibTip = imageButton2;
        this.llSelectClass = linearLayout2;
        this.recycleView = recyclerView;
        this.refreshLayout = pullRefreshLayout;
        this.selectBtn = checkedTextView;
        this.tbvTrailBack = titleBackView;
        this.title = marqueeTextView;
        this.toolbar = toolbar;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_unfamiliar_words, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_unfamiliar_words, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding) bind(obj, view, com.up366.mobile.R.layout.activity_unfamiliar_words);
    }
}
