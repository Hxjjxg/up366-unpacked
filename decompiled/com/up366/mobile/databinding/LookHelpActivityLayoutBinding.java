package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class LookHelpActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.view.View lookHelpDot1;
    public final android.view.View lookHelpDot2;
    public final android.widget.TextView lookHelpToSetting;
    public final android.widget.TextView text1;
    public final android.widget.TextView text2;
    public final android.widget.TextView text3;
    public final android.widget.TextView text4;
    public final android.widget.TextView text5;
    public final android.widget.TextView text6;
    public final android.widget.TextView text7;
    public final android.widget.TextView text8;
    public final android.widget.TextView text9;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected LookHelpActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.view.View view2, android.view.View view3, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8, android.widget.TextView textView9, android.widget.TextView textView10, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.lookHelpDot1 = view2;
        this.lookHelpDot2 = view3;
        this.lookHelpToSetting = textView;
        this.text1 = textView2;
        this.text2 = textView3;
        this.text3 = textView4;
        this.text4 = textView5;
        this.text5 = textView6;
        this.text6 = textView7;
        this.text7 = textView8;
        this.text8 = textView9;
        this.text9 = textView10;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.LookHelpActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.LookHelpActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.LookHelpActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.look_help_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.LookHelpActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.LookHelpActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.LookHelpActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.look_help_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.LookHelpActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.LookHelpActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.LookHelpActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.look_help_activity_layout);
    }
}
