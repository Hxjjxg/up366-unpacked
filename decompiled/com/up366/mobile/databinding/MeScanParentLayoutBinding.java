package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeScanParentLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.CircleImageView parentPhoto;
    public final android.widget.TextView parentText;
    public final android.widget.ImageView scanBtn;

    protected MeScanParentLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.CircleImageView circleImageView, android.widget.TextView textView, android.widget.ImageView imageView) {
        super(obj, view, i);
        this.parentPhoto = circleImageView;
        this.parentText = textView;
        this.scanBtn = imageView;
    }

    public static com.up366.mobile.databinding.MeScanParentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeScanParentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeScanParentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_scan_parent_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeScanParentLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeScanParentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeScanParentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_scan_parent_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeScanParentLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeScanParentLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeScanParentLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_scan_parent_layout);
    }
}
