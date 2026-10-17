package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class InterestSelectCourseActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.Button btnOk;
    public final android.widget.LinearLayout content;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final android.widget.TextView tip;
    public final android.widget.TextView title;
    public final com.up366.mobile.common.views.TitleBackView titleBack;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected InterestSelectCourseActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.Button button, android.widget.LinearLayout linearLayout, androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.TextView textView, android.widget.TextView textView2, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.btnOk = button;
        this.content = linearLayout;
        this.recycleView = recyclerView;
        this.tip = textView;
        this.title = textView2;
        this.titleBack = titleBackView;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.interest_select_course_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.interest_select_course_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.interest_select_course_activity_layout);
    }
}
