package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseWrongDetailHeadViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView killNum;
    public final android.widget.TextView killYesterdayNum;
    public final android.widget.TextView remainNum;
    public final android.widget.TextView textView10;
    public final android.widget.TextView textView11;
    public final android.widget.TextView textView9;
    public final android.view.View vMask;

    protected CourseWrongDetailHeadViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.view.View view2) {
        super(obj, view, i);
        this.killNum = textView;
        this.killYesterdayNum = textView2;
        this.remainNum = textView3;
        this.textView10 = textView4;
        this.textView11 = textView5;
        this.textView9 = textView6;
        this.vMask = view2;
    }

    public static com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_wrong_detail_head_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_wrong_detail_head_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding) bind(obj, view, com.up366.mobile.R.layout.course_wrong_detail_head_view);
    }
}
