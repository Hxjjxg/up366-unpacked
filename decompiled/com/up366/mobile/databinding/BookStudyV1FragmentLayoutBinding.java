package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BookStudyV1FragmentLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView tip;
    public final androidx.viewpager.widget.ViewPager viewpager;

    protected BookStudyV1FragmentLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, androidx.viewpager.widget.ViewPager viewPager) {
        super(obj, view, i);
        this.tip = imageView;
        this.viewpager = viewPager;
    }

    public static com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_study_v1_fragment_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.book_study_v1_fragment_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.book_study_v1_fragment_layout);
    }
}
