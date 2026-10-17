package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseWrongDetailBottomViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.LinearLayout bgLayout;
    public final android.widget.Button killQuestion;

    protected CourseWrongDetailBottomViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.LinearLayout linearLayout, android.widget.Button button) {
        super(obj, view, i);
        this.bgLayout = linearLayout;
        this.killQuestion = button;
    }

    public static com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_wrong_detail_bottom_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_wrong_detail_bottom_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding) bind(obj, view, com.up366.mobile.R.layout.course_wrong_detail_bottom_view);
    }
}
