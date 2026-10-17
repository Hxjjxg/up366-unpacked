package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class WordSourceHeaderItemBinding extends androidx.databinding.ViewDataBinding {
    public final com.airbnb.lottie.LottieAnimationView ivPlayIcon;
    public final android.widget.TextView tvAddCount;
    public final android.widget.TextView tvContent;
    public final android.widget.TextView tvExplain;
    public final android.widget.TextView tvWordCategory;
    public final android.view.View vLine;

    protected WordSourceHeaderItemBinding(java.lang.Object obj, android.view.View view, int i, com.airbnb.lottie.LottieAnimationView lottieAnimationView, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.view.View view2) {
        super(obj, view, i);
        this.ivPlayIcon = lottieAnimationView;
        this.tvAddCount = textView;
        this.tvContent = textView2;
        this.tvExplain = textView3;
        this.tvWordCategory = textView4;
        this.vLine = view2;
    }

    public static com.up366.mobile.databinding.WordSourceHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordSourceHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordSourceHeaderItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.word_source_header_item, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.WordSourceHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordSourceHeaderItemBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordSourceHeaderItemBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.word_source_header_item, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.WordSourceHeaderItemBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.WordSourceHeaderItemBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.WordSourceHeaderItemBinding) bind(obj, view, com.up366.mobile.R.layout.word_source_header_item);
    }
}
