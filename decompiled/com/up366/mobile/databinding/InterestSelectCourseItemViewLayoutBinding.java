package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class InterestSelectCourseItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.CheckableImageView check;
    public final android.view.View line;
    public final android.widget.TextView text;

    protected InterestSelectCourseItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.CheckableImageView checkableImageView, android.view.View view2, android.widget.TextView textView) {
        super(obj, view, i);
        this.check = checkableImageView;
        this.line = view2;
        this.text = textView;
    }

    public static com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.interest_select_course_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.interest_select_course_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.interest_select_course_item_view_layout);
    }
}
