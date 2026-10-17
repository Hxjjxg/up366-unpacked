package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityJssdk2023CommonBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout content;
    public final com.up366.mobile.common.views.CommonLoadingView loadingView;
    public final com.up366.mobile.common.views.TitleBarView titleBar;

    protected ActivityJssdk2023CommonBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CommonLoadingView commonLoadingView, com.up366.mobile.common.views.TitleBarView titleBarView) {
        super(obj, view, i);
        this.content = frameLayout;
        this.loadingView = commonLoadingView;
        this.titleBar = titleBarView;
    }

    public static com.up366.mobile.databinding.ActivityJssdk2023CommonBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityJssdk2023CommonBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityJssdk2023CommonBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_jssdk_2023_common, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityJssdk2023CommonBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityJssdk2023CommonBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityJssdk2023CommonBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_jssdk_2023_common, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityJssdk2023CommonBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityJssdk2023CommonBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityJssdk2023CommonBinding) bind(obj, view, com.up366.mobile.R.layout.activity_jssdk_2023_common);
    }
}
