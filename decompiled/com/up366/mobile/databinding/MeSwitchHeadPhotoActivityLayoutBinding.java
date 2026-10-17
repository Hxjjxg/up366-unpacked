package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeSwitchHeadPhotoActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.TextView confirmCancelBtn;
    public final android.widget.TextView confirmUpdateBtn;
    public final android.widget.ImageView headPhotoBg;
    public final android.widget.TextView headPhotoRule;
    public final android.widget.ImageView jiao;
    public final android.widget.TextView mePhotoErrorText;
    public final com.up366.mobile.common.views.CircleImageView mePhotoImg;
    public final android.widget.ImageView mePhotoImgLoading;
    public final android.widget.TextView mePhotoImgMeng;
    public final android.widget.TextView tipText;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    public final android.widget.TextView updateBySystem;
    public final android.widget.TextView updateByUser;

    protected MeSwitchHeadPhotoActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ImageView imageView, android.widget.TextView textView3, android.widget.ImageView imageView2, android.widget.TextView textView4, com.up366.mobile.common.views.CircleImageView circleImageView, android.widget.ImageView imageView3, android.widget.TextView textView5, android.widget.TextView textView6, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, android.widget.TextView textView7, android.widget.TextView textView8) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.confirmCancelBtn = textView;
        this.confirmUpdateBtn = textView2;
        this.headPhotoBg = imageView;
        this.headPhotoRule = textView3;
        this.jiao = imageView2;
        this.mePhotoErrorText = textView4;
        this.mePhotoImg = circleImageView;
        this.mePhotoImgLoading = imageView3;
        this.mePhotoImgMeng = textView5;
        this.tipText = textView6;
        this.toolbarLayout = collapsingToolbarLayout;
        this.updateBySystem = textView7;
        this.updateByUser = textView8;
    }

    public static com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_switch_head_photo_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_switch_head_photo_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_switch_head_photo_activity_layout);
    }
}
