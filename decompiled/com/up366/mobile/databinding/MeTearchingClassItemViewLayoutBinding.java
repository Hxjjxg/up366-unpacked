package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeTearchingClassItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView courseCode;
    public final android.widget.TextView courseName;
    public final android.widget.TextView courseTeacher;
    public final android.view.View divider;
    public final android.widget.TextView time;

    protected MeTearchingClassItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.view.View view2, android.widget.TextView textView4) {
        super(obj, view, i);
        this.courseCode = textView;
        this.courseName = textView2;
        this.courseTeacher = textView3;
        this.divider = view2;
        this.time = textView4;
    }

    public static com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_tearching_class_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_tearching_class_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_tearching_class_item_view_layout);
    }
}
