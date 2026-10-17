package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseRateItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout clRateItem;
    public final android.widget.ImageView imgAvg;
    public final android.widget.ImageView imgMax;
    public final android.widget.TextView month;
    public final android.widget.TextView percentTextAvg;
    public final android.widget.TextView percentTextMax;
    public final com.up366.mobile.common.views.PaddingShadowLayout pslBg;
    public final android.widget.TextView rateTip;
    public final android.view.View rateTipArrow;
    public final android.widget.TextView scoreAvg;
    public final android.widget.TextView scoreMax;
    public final android.widget.TextView subject;
    public final android.widget.TextView textAvg;
    public final android.widget.TextView textMax;

    protected CourseRateItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout, android.widget.TextView textView4, android.view.View view2, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8, android.widget.TextView textView9) {
        super(obj, view, i);
        this.clRateItem = constraintLayout;
        this.imgAvg = imageView;
        this.imgMax = imageView2;
        this.month = textView;
        this.percentTextAvg = textView2;
        this.percentTextMax = textView3;
        this.pslBg = paddingShadowLayout;
        this.rateTip = textView4;
        this.rateTipArrow = view2;
        this.scoreAvg = textView5;
        this.scoreMax = textView6;
        this.subject = textView7;
        this.textAvg = textView8;
        this.textMax = textView9;
    }

    public static com.up366.mobile.databinding.CourseRateItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseRateItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseRateItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_rate_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseRateItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseRateItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseRateItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_rate_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseRateItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseRateItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseRateItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.course_rate_item_view_layout);
    }
}
