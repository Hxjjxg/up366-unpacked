package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CommonWebViewActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.ProgressBar commonWebviewProgressbar;
    public final android.widget.FrameLayout contentLayout;
    public final com.up366.mobile.common.views.EmptyStateView emptyStateView;
    public final androidx.core.widget.NestedScrollView emptyStateViewLayout;
    public final com.up366.mobile.common.views.MarqueeTextView title;
    public final com.up366.mobile.common.views.TitleBackView titleBack;
    public final androidx.appcompat.widget.Toolbar toolbar;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    public final com.up366.mobile.book.webview.StudyPageWebView webView;

    protected CommonWebViewActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.ProgressBar progressBar, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.EmptyStateView emptyStateView, androidx.core.widget.NestedScrollView nestedScrollView, com.up366.mobile.common.views.MarqueeTextView marqueeTextView, com.up366.mobile.common.views.TitleBackView titleBackView, androidx.appcompat.widget.Toolbar toolbar, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.commonWebviewProgressbar = progressBar;
        this.contentLayout = frameLayout;
        this.emptyStateView = emptyStateView;
        this.emptyStateViewLayout = nestedScrollView;
        this.title = marqueeTextView;
        this.titleBack = titleBackView;
        this.toolbar = toolbar;
        this.toolbarLayout = collapsingToolbarLayout;
        this.webView = studyPageWebView;
    }

    public static com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.common_web_view_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.common_web_view_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.common_web_view_activity_layout);
    }
}
