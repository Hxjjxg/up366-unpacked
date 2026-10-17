package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class EmptyStateViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnEmptyStateLeft;
    public final android.widget.TextView btnEmptyStateRight;
    public final android.widget.ImageView emptyLoadingImg;
    public final android.widget.LinearLayout emptyLoadingLayout;
    public final android.widget.ImageView ivEmptyStateTipimg;
    public final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tvEmptyViewTip;

    protected EmptyStateViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView3) {
        super(obj, view, i);
        this.btnEmptyStateLeft = textView;
        this.btnEmptyStateRight = textView2;
        this.emptyLoadingImg = imageView;
        this.emptyLoadingLayout = linearLayout;
        this.ivEmptyStateTipimg = imageView2;
        this.rootView = constraintLayout;
        this.tvEmptyViewTip = textView3;
    }

    public static com.up366.mobile.databinding.EmptyStateViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.EmptyStateViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.EmptyStateViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.empty_state_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.EmptyStateViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.EmptyStateViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.EmptyStateViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.empty_state_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.EmptyStateViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.EmptyStateViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.EmptyStateViewBinding) bind(obj, view, com.up366.mobile.R.layout.empty_state_view);
    }
}
