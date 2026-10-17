package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityAboutUp366Binding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.SettingItemView addPraise;
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final com.up366.mobile.common.views.SettingItemView checkVersion;
    public final com.up366.mobile.common.views.SettingItemView contentExtDecryptTest;
    public final android.widget.TextView host;
    public final android.widget.TextView icp;
    public final android.widget.ImageView ivUp366Head;
    public final com.up366.mobile.common.views.TitleBackView tbvTrailBack;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    public final android.widget.TextView tvCopyRight;
    public final android.widget.TextView tvCurrentVersion;
    public final android.widget.TextView tvUp366Name;

    protected ActivityAboutUp366Binding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.SettingItemView settingItemView, com.google.android.material.appbar.AppBarLayout appBarLayout, com.up366.mobile.common.views.SettingItemView settingItemView2, com.up366.mobile.common.views.SettingItemView settingItemView3, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ImageView imageView, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5) {
        super(obj, view, i);
        this.addPraise = settingItemView;
        this.appBar = appBarLayout;
        this.checkVersion = settingItemView2;
        this.contentExtDecryptTest = settingItemView3;
        this.host = textView;
        this.icp = textView2;
        this.ivUp366Head = imageView;
        this.tbvTrailBack = titleBackView;
        this.toolbarLayout = collapsingToolbarLayout;
        this.tvCopyRight = textView3;
        this.tvCurrentVersion = textView4;
        this.tvUp366Name = textView5;
    }

    public static com.up366.mobile.databinding.ActivityAboutUp366Binding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityAboutUp366Binding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityAboutUp366Binding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_about_up366, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityAboutUp366Binding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityAboutUp366Binding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityAboutUp366Binding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_about_up366, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityAboutUp366Binding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityAboutUp366Binding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityAboutUp366Binding) bind(obj, view, com.up366.mobile.R.layout.activity_about_up366);
    }
}
