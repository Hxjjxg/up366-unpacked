package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseWrongDetailItemViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView knowledgeName;
    public final android.widget.TextView typeName;
    public final android.widget.TextView wrongCount;

    protected CourseWrongDetailItemViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        super(obj, view, i);
        this.knowledgeName = textView;
        this.typeName = textView2;
        this.wrongCount = textView3;
    }

    public static com.up366.mobile.databinding.CourseWrongDetailItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_wrong_detail_item_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseWrongDetailItemViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailItemViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_wrong_detail_item_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseWrongDetailItemViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseWrongDetailItemViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseWrongDetailItemViewBinding) bind(obj, view, com.up366.mobile.R.layout.course_wrong_detail_item_view);
    }
}
