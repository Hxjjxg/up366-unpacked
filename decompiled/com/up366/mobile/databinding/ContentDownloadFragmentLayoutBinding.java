package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ContentDownloadFragmentLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.airbnb.lottie.LottieAnimationView animationView;
    public final android.widget.ImageView error;
    public final android.widget.TextView percentText;
    public final com.up366.mobile.common.views.DownloadProgressView progress;
    public final android.widget.TextView tip;
    public final com.up366.mobile.common.views.TitleBarView titleBar;

    protected ContentDownloadFragmentLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.airbnb.lottie.LottieAnimationView lottieAnimationView, android.widget.ImageView imageView, android.widget.TextView textView, com.up366.mobile.common.views.DownloadProgressView downloadProgressView, android.widget.TextView textView2, com.up366.mobile.common.views.TitleBarView titleBarView) {
        super(obj, view, i);
        this.animationView = lottieAnimationView;
        this.error = imageView;
        this.percentText = textView;
        this.progress = downloadProgressView;
        this.tip = textView2;
        this.titleBar = titleBarView;
    }

    public static com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.content_download_fragment_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.content_download_fragment_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.content_download_fragment_layout);
    }
}
