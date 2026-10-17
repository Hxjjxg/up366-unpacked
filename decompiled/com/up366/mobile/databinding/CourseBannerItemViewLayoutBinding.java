package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseBannerItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView img;
    public final com.up366.mobile.common.views.rotationmap.RotationMapCirclePointView pointView;
    public final androidx.constraintlayout.widget.ConstraintLayout root;
    public final androidx.viewpager.widget.ViewPager viewPager;

    protected CourseBannerItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, com.up366.mobile.common.views.rotationmap.RotationMapCirclePointView rotationMapCirclePointView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, androidx.viewpager.widget.ViewPager viewPager) {
        super(obj, view, i);
        this.img = imageView;
        this.pointView = rotationMapCirclePointView;
        this.root = constraintLayout;
        this.viewPager = viewPager;
    }

    public static com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_banner_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_banner_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.course_banner_item_view_layout);
    }
}
