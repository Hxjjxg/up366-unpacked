package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BottomMenuViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.airbnb.lottie.LottieAnimationView icon;
    public final android.widget.TextView name;
    public final android.widget.TextView number;

    protected BottomMenuViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.airbnb.lottie.LottieAnimationView lottieAnimationView, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.icon = lottieAnimationView;
        this.name = textView;
        this.number = textView2;
    }

    public static com.up366.mobile.databinding.BottomMenuViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomMenuViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomMenuViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.bottom_menu_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BottomMenuViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomMenuViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomMenuViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.bottom_menu_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BottomMenuViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BottomMenuViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BottomMenuViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.bottom_menu_view_layout);
    }
}
