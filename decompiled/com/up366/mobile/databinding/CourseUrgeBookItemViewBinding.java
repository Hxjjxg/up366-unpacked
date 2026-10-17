package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CourseUrgeBookItemViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnFirstGo;
    public final android.widget.TextView btnGo;
    public final android.view.View focusView;
    public final com.up366.mobile.common.views.RoundImageView icon;
    public final android.widget.TextView iconNew;
    public final com.up366.mobile.common.views.RoundImageView itemBg;
    public final android.widget.TextView name;
    public final android.widget.TextView num;
    public final com.up366.mobile.common.views.PaddingShadowLayout pslBg;
    public final androidx.constraintlayout.widget.ConstraintLayout rootView;

    protected CourseUrgeBookItemViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.view.View view2, com.up366.mobile.common.views.RoundImageView roundImageView, android.widget.TextView textView3, com.up366.mobile.common.views.RoundImageView roundImageView2, android.widget.TextView textView4, android.widget.TextView textView5, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.btnFirstGo = textView;
        this.btnGo = textView2;
        this.focusView = view2;
        this.icon = roundImageView;
        this.iconNew = textView3;
        this.itemBg = roundImageView2;
        this.name = textView4;
        this.num = textView5;
        this.pslBg = paddingShadowLayout;
        this.rootView = constraintLayout;
    }

    public static com.up366.mobile.databinding.CourseUrgeBookItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseUrgeBookItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseUrgeBookItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_urge_book_item_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CourseUrgeBookItemViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseUrgeBookItemViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseUrgeBookItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.course_urge_book_item_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CourseUrgeBookItemViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CourseUrgeBookItemViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CourseUrgeBookItemViewBinding) bind(obj, view, com.up366.mobile.R.layout.course_urge_book_item_view);
    }
}
