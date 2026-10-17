package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityEngineSourceUpdateLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.ClipCornerLayout cornerBg;
    public final com.airbnb.lottie.LottieAnimationView lottie;
    public final android.widget.TextView percentText;
    public final com.up366.mobile.common.views.DownloadResourceProgressBarView progress;
    public final android.widget.TextView tip;

    protected ActivityEngineSourceUpdateLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.ClipCornerLayout clipCornerLayout, com.airbnb.lottie.LottieAnimationView lottieAnimationView, android.widget.TextView textView, com.up366.mobile.common.views.DownloadResourceProgressBarView downloadResourceProgressBarView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.cornerBg = clipCornerLayout;
        this.lottie = lottieAnimationView;
        this.percentText = textView;
        this.progress = downloadResourceProgressBarView;
        this.tip = textView2;
    }

    public static com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_engine_source_update_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_engine_source_update_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.activity_engine_source_update_layout);
    }
}
