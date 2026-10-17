package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeUserInfoActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final com.up366.mobile.me.views.UserInfoItemView meClassname;
    public final com.up366.mobile.me.views.UserInfoItemView mePhoto;
    public final com.up366.mobile.me.views.UserInfoItemView meRealname;
    public final com.up366.mobile.me.views.UserInfoItemView meSchool;
    public final com.up366.mobile.me.views.UserInfoItemView meStudentNumber;
    public final com.up366.mobile.me.views.UserInfoItemView meUsername;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected MeUserInfoActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, com.up366.mobile.me.views.UserInfoItemView userInfoItemView, com.up366.mobile.me.views.UserInfoItemView userInfoItemView2, com.up366.mobile.me.views.UserInfoItemView userInfoItemView3, com.up366.mobile.me.views.UserInfoItemView userInfoItemView4, com.up366.mobile.me.views.UserInfoItemView userInfoItemView5, com.up366.mobile.me.views.UserInfoItemView userInfoItemView6, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.meClassname = userInfoItemView;
        this.mePhoto = userInfoItemView2;
        this.meRealname = userInfoItemView3;
        this.meSchool = userInfoItemView4;
        this.meStudentNumber = userInfoItemView5;
        this.meUsername = userInfoItemView6;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_user_info_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_user_info_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeUserInfoActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_user_info_activity_layout);
    }
}
