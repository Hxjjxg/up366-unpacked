package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CommonJsbWebviewActivityBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout contentLayout;
    public final com.up366.mobile.common.views.EmptyStateView emptyStateView;
    public final androidx.core.widget.NestedScrollView emptyStateViewLayout;
    public final com.up366.mobile.common.views.TitleBarView titleBar;
    public final com.up366.mobile.book.webview.StudyPageWebView webView;

    protected CommonJsbWebviewActivityBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.EmptyStateView emptyStateView, androidx.core.widget.NestedScrollView nestedScrollView, com.up366.mobile.common.views.TitleBarView titleBarView, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        super(obj, view, i);
        this.contentLayout = frameLayout;
        this.emptyStateView = emptyStateView;
        this.emptyStateViewLayout = nestedScrollView;
        this.titleBar = titleBarView;
        this.webView = studyPageWebView;
    }

    public static com.up366.mobile.databinding.CommonJsbWebviewActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonJsbWebviewActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonJsbWebviewActivityBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.common_jsb_webview_activity, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CommonJsbWebviewActivityBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonJsbWebviewActivityBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonJsbWebviewActivityBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.common_jsb_webview_activity, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CommonJsbWebviewActivityBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonJsbWebviewActivityBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonJsbWebviewActivityBinding) bind(obj, view, com.up366.mobile.R.layout.common_jsb_webview_activity);
    }
}
