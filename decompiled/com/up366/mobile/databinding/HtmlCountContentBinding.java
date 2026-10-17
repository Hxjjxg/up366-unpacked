package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class HtmlCountContentBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout countHtmlWebView;

    protected HtmlCountContentBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout) {
        super(obj, view, i);
        this.countHtmlWebView = frameLayout;
    }

    public static com.up366.mobile.databinding.HtmlCountContentBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.HtmlCountContentBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.HtmlCountContentBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.html_count_content, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.HtmlCountContentBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.HtmlCountContentBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.HtmlCountContentBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.html_count_content, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.HtmlCountContentBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.HtmlCountContentBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.HtmlCountContentBinding) bind(obj, view, com.up366.mobile.R.layout.html_count_content);
    }
}
