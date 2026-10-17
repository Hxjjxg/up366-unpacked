package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeHowGetCourseCodeAcivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final com.up366.mobile.common.views.TitleCloseGroupView close;
    public final androidx.core.widget.NestedScrollView content;
    public final android.widget.TextView searchText;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected MeHowGetCourseCodeAcivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, com.up366.mobile.common.views.TitleCloseGroupView titleCloseGroupView, androidx.core.widget.NestedScrollView nestedScrollView, android.widget.TextView textView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.close = titleCloseGroupView;
        this.content = nestedScrollView;
        this.searchText = textView;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_how_get_course_code_acivity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_how_get_course_code_acivity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeHowGetCourseCodeAcivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_how_get_course_code_acivity_layout);
    }
}
