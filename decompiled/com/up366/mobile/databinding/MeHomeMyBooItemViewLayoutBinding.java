package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeHomeMyBooItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView bookPicture;
    public final android.widget.TextView bookPictureName;
    public final android.view.View bookPictureNameBg;
    public final com.up366.mobile.common.views.ClipCornerLayout clipLayout;
    public final android.widget.ImageView downShelfTip;
    public final android.widget.TextView tipNew;

    protected MeHomeMyBooItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.TextView textView, android.view.View view2, com.up366.mobile.common.views.ClipCornerLayout clipCornerLayout, android.widget.ImageView imageView2, android.widget.TextView textView2) {
        super(obj, view, i);
        this.bookPicture = imageView;
        this.bookPictureName = textView;
        this.bookPictureNameBg = view2;
        this.clipLayout = clipCornerLayout;
        this.downShelfTip = imageView2;
        this.tipNew = textView2;
    }

    public static com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_home_my_boo_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_home_my_boo_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_home_my_boo_item_view_layout);
    }
}
