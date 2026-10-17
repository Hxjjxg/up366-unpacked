package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeMainFragmentLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.me.views.MeFragmentHeadPhotoItemView headView;
    public final com.up366.mobile.common.views.me.MeCourseBookView meCourseView;
    public final android.view.View meDivider4;
    public final android.view.View meDivider5;
    public final android.view.View meDivider6;
    public final com.up366.mobile.common.views.me.MeItemView meFeedback;
    public final com.up366.mobile.common.views.me.MeItemView meHelp;
    public final com.up366.mobile.common.views.me.MeItemView meSetUp;
    public final com.up366.mobile.common.views.me.MeStudyCardUpdateView meStudyCardUpdate;
    public final com.up366.mobile.common.views.me.MeItemView meTeachingClass;
    public final android.widget.ImageView parentTipClose;
    public final android.widget.TextView parentTipText;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;
    public final android.widget.FrameLayout rootView;
    public final com.up366.mobile.me.views.MeFragmentScanPhotoView scanTitle;
    public final androidx.core.widget.NestedScrollView scrollView;

    protected MeMainFragmentLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.me.views.MeFragmentHeadPhotoItemView meFragmentHeadPhotoItemView, com.up366.mobile.common.views.me.MeCourseBookView meCourseBookView, android.view.View view2, android.view.View view3, android.view.View view4, com.up366.mobile.common.views.me.MeItemView meItemView, com.up366.mobile.common.views.me.MeItemView meItemView2, com.up366.mobile.common.views.me.MeItemView meItemView3, com.up366.mobile.common.views.me.MeStudyCardUpdateView meStudyCardUpdateView, com.up366.mobile.common.views.me.MeItemView meItemView4, android.widget.ImageView imageView, android.widget.TextView textView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, android.widget.FrameLayout frameLayout, com.up366.mobile.me.views.MeFragmentScanPhotoView meFragmentScanPhotoView, androidx.core.widget.NestedScrollView nestedScrollView) {
        super(obj, view, i);
        this.headView = meFragmentHeadPhotoItemView;
        this.meCourseView = meCourseBookView;
        this.meDivider4 = view2;
        this.meDivider5 = view3;
        this.meDivider6 = view4;
        this.meFeedback = meItemView;
        this.meHelp = meItemView2;
        this.meSetUp = meItemView3;
        this.meStudyCardUpdate = meStudyCardUpdateView;
        this.meTeachingClass = meItemView4;
        this.parentTipClose = imageView;
        this.parentTipText = textView;
        this.refreshLayout = pullRefreshLayout;
        this.rootView = frameLayout;
        this.scanTitle = meFragmentScanPhotoView;
        this.scrollView = nestedScrollView;
    }

    public static com.up366.mobile.databinding.MeMainFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMainFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMainFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_main_fragment_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeMainFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMainFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMainFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_main_fragment_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeMainFragmentLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMainFragmentLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMainFragmentLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_main_fragment_layout);
    }
}
