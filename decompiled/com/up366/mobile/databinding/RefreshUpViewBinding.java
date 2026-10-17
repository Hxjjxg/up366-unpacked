package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class RefreshUpViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.LinearLayout endTipLayout;
    public final android.widget.TextView errorTip;
    public final com.airbnb.lottie.LottieAnimationView loadingTip;

    protected RefreshUpViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.LinearLayout linearLayout, android.widget.TextView textView, com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
        super(obj, view, i);
        this.endTipLayout = linearLayout;
        this.errorTip = textView;
        this.loadingTip = lottieAnimationView;
    }

    public static com.up366.mobile.databinding.RefreshUpViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RefreshUpViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RefreshUpViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.refresh_up_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.RefreshUpViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RefreshUpViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RefreshUpViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.refresh_up_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.RefreshUpViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RefreshUpViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RefreshUpViewBinding) bind(obj, view, com.up366.mobile.R.layout.refresh_up_view);
    }
}
