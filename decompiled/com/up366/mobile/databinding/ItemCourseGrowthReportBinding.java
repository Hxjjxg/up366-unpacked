package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ItemCourseGrowthReportBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout flRoot;
    public final android.widget.ImageView ivEnter;
    public final android.widget.TextView tvFirst;
    public final android.widget.TextView tvSecond;

    protected ItemCourseGrowthReportBinding(java.lang.Object obj, android.view.View view, int i, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.flRoot = constraintLayout;
        this.ivEnter = imageView;
        this.tvFirst = textView;
        this.tvSecond = textView2;
    }

    public static com.up366.mobile.databinding.ItemCourseGrowthReportBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemCourseGrowthReportBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemCourseGrowthReportBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.item_course_growth_report, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ItemCourseGrowthReportBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemCourseGrowthReportBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemCourseGrowthReportBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.item_course_growth_report, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ItemCourseGrowthReportBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemCourseGrowthReportBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemCourseGrowthReportBinding) bind(obj, view, com.up366.mobile.R.layout.item_course_growth_report);
    }
}
