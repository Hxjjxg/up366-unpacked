package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseTipViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    protected CourseTipViewLayoutBinding(java.lang.Object obj, android.view.View view, int i) {
        super(obj, view, i);
    }

    public static com.up366.mobile.databinding.CourseTipViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseTipViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseTipViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_tip_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseTipViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseTipViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseTipViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_tip_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseTipViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseTipViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseTipViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.course_tip_view_layout);
    }
}
