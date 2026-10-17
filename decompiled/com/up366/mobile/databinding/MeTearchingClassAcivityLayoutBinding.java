package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeTearchingClassAcivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView addTeachingClass;
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final com.up366.mobile.me.teacherclass.ViewPagerCanControl contentViewPager;
    public final android.widget.TextView exitClassBtn;
    public final android.widget.LinearLayout rootView;
    public final com.up366.qmui.widget.tab.QMUITabSegment tabSegment;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected MeTearchingClassAcivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, com.google.android.material.appbar.AppBarLayout appBarLayout, com.up366.mobile.me.teacherclass.ViewPagerCanControl viewPagerCanControl, android.widget.TextView textView2, android.widget.LinearLayout linearLayout, com.up366.qmui.widget.tab.QMUITabSegment qMUITabSegment, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.addTeachingClass = textView;
        this.appBar = appBarLayout;
        this.contentViewPager = viewPagerCanControl;
        this.exitClassBtn = textView2;
        this.rootView = linearLayout;
        this.tabSegment = qMUITabSegment;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_tearching_class_acivity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_tearching_class_acivity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_tearching_class_acivity_layout);
    }
}
