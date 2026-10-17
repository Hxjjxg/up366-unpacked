package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MainBottomViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.BottomMenuView course;
    public final com.up366.mobile.common.views.BottomMenuView schoolHouse;
    public final com.up366.mobile.common.views.BottomMenuView user;

    protected MainBottomViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.BottomMenuView bottomMenuView, com.up366.mobile.common.views.BottomMenuView bottomMenuView2, com.up366.mobile.common.views.BottomMenuView bottomMenuView3) {
        super(obj, view, i);
        this.course = bottomMenuView;
        this.schoolHouse = bottomMenuView2;
        this.user = bottomMenuView3;
    }

    public static com.up366.mobile.databinding.MainBottomViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MainBottomViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MainBottomViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.main_bottom_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MainBottomViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MainBottomViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MainBottomViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.main_bottom_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MainBottomViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MainBottomViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MainBottomViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.main_bottom_view_layout);
    }
}
