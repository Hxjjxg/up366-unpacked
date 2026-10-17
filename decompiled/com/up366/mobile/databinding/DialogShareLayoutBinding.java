package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class DialogShareLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.ClipCornerLayout cornerLayout;
    public final android.widget.ImageView img;
    public final com.up366.mobile.common.views.ShareView shareView;

    protected DialogShareLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.ClipCornerLayout clipCornerLayout, android.widget.ImageView imageView, com.up366.mobile.common.views.ShareView shareView) {
        super(obj, view, i);
        this.cornerLayout = clipCornerLayout;
        this.img = imageView;
        this.shareView = shareView;
    }

    public static com.up366.mobile.databinding.DialogShareLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogShareLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogShareLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.dialog_share_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.DialogShareLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogShareLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogShareLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.dialog_share_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.DialogShareLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogShareLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogShareLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.dialog_share_layout);
    }
}
