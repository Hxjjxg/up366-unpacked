package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class HtmlBookActivityMainBinding extends androidx.databinding.ViewDataBinding {
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;
    public final com.up366.mobile.book.webview.StudyPageWebView webView;

    protected HtmlBookActivityMainBinding(java.lang.Object obj, android.view.View view, int i, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        super(obj, view, i);
        this.refreshLayout = pullRefreshLayout;
        this.webView = studyPageWebView;
    }

    public static com.up366.mobile.databinding.HtmlBookActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.HtmlBookActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.HtmlBookActivityMainBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.html_book_activity_main, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.HtmlBookActivityMainBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.HtmlBookActivityMainBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.HtmlBookActivityMainBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.html_book_activity_main, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.HtmlBookActivityMainBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.HtmlBookActivityMainBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.HtmlBookActivityMainBinding) bind(obj, view, com.up366.mobile.R.layout.html_book_activity_main);
    }
}
