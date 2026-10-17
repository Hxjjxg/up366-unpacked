package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BookStudyV4FragmentLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.TitleBarView titleBar;
    public final androidx.viewpager.widget.ViewPager viewPager;

    protected BookStudyV4FragmentLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.TitleBarView titleBarView, androidx.viewpager.widget.ViewPager viewPager) {
        super(obj, view, i);
        this.titleBar = titleBarView;
        this.viewPager = viewPager;
    }

    public static com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_study_v4_fragment_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_study_v4_fragment_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.book_study_v4_fragment_layout);
    }
}
