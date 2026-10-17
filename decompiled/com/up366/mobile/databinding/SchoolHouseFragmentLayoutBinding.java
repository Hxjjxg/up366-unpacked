package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class SchoolHouseFragmentLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout content;
    public final com.up366.mobile.common.views.CommonLoadingView loadingView;
    public final com.up366.mobile.common.views.TitleBarView titleBar;

    protected SchoolHouseFragmentLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CommonLoadingView commonLoadingView, com.up366.mobile.common.views.TitleBarView titleBarView) {
        super(obj, view, i);
        this.content = frameLayout;
        this.loadingView = commonLoadingView;
        this.titleBar = titleBarView;
    }

    public static com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.school_house_fragment_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.school_house_fragment_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SchoolHouseFragmentLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.school_house_fragment_layout);
    }
}
