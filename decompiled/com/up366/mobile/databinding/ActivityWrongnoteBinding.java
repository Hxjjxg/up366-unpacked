package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityWrongnoteBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final com.up366.mobile.common.views.BlueButtonBottomView bottomView;
    public final androidx.constraintlayout.widget.ConstraintLayout emptyView;
    public final android.widget.ImageButton ibRankingList;
    public final android.widget.ImageView ivEmptyStateTipimg;
    public final com.up366.qmui.widget.tab.QMUITabSegment qmTabLayout;
    public final com.up366.mobile.common.views.TitleBackView tbvTrailBack;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    public final android.widget.TextView tvEmptyViewTip;
    public final androidx.viewpager.widget.ViewPager viewPager;

    protected ActivityWrongnoteBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, com.up366.mobile.common.views.BlueButtonBottomView blueButtonBottomView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageButton imageButton, android.widget.ImageView imageView, com.up366.qmui.widget.tab.QMUITabSegment qMUITabSegment, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, android.widget.TextView textView, androidx.viewpager.widget.ViewPager viewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.bottomView = blueButtonBottomView;
        this.emptyView = constraintLayout;
        this.ibRankingList = imageButton;
        this.ivEmptyStateTipimg = imageView;
        this.qmTabLayout = qMUITabSegment;
        this.tbvTrailBack = titleBackView;
        this.toolbarLayout = collapsingToolbarLayout;
        this.tvEmptyViewTip = textView;
        this.viewPager = viewPager;
    }

    public static com.up366.mobile.databinding.ActivityWrongnoteBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityWrongnoteBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityWrongnoteBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_wrongnote, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityWrongnoteBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityWrongnoteBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityWrongnoteBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_wrongnote, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityWrongnoteBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityWrongnoteBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityWrongnoteBinding) bind(obj, view, com.up366.mobile.R.layout.activity_wrongnote);
    }
}
