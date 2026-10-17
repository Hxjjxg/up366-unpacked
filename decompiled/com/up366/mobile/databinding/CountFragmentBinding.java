package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CountFragmentBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ProgressBar anim;
    public final com.up366.mobile.common.views.HeadSemicircleBackgroundView bg;
    public final android.widget.FrameLayout countHtmlContent;
    public final android.widget.LinearLayout htmlCountNoTextbook;
    public final android.widget.ImageView noDataLoginIv;
    public final android.widget.TextView noDataLoginTv;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;
    public final com.up366.mobile.common.views.TitleBarView titleBar;

    protected CountFragmentBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ProgressBar progressBar, com.up366.mobile.common.views.HeadSemicircleBackgroundView headSemicircleBackgroundView, android.widget.FrameLayout frameLayout, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, android.widget.TextView textView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, com.up366.mobile.common.views.TitleBarView titleBarView) {
        super(obj, view, i);
        this.anim = progressBar;
        this.bg = headSemicircleBackgroundView;
        this.countHtmlContent = frameLayout;
        this.htmlCountNoTextbook = linearLayout;
        this.noDataLoginIv = imageView;
        this.noDataLoginTv = textView;
        this.refreshLayout = pullRefreshLayout;
        this.titleBar = titleBarView;
    }

    public static com.up366.mobile.databinding.CountFragmentBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CountFragmentBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CountFragmentBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.count_fragment, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CountFragmentBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CountFragmentBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CountFragmentBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.count_fragment, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CountFragmentBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CountFragmentBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CountFragmentBinding) bind(obj, view, com.up366.mobile.R.layout.count_fragment);
    }
}
