package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView image;
    public final android.widget.ImageView imageEnter;
    public final com.up366.mobile.common.views.RedPointImageView redPoint;
    public final android.widget.TextView text;
    public final android.widget.TextView textRight;

    protected MeItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.ImageView imageView2, com.up366.mobile.common.views.RedPointImageView redPointImageView, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.image = imageView;
        this.imageEnter = imageView2;
        this.redPoint = redPointImageView;
        this.text = textView;
        this.textRight = textView2;
    }

    public static com.up366.mobile.databinding.MeItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_item_view_layout);
    }
}
