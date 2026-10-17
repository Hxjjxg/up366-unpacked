package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CountMainActivityBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout content;

    protected CountMainActivityBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout) {
        super(obj, view, i);
        this.content = frameLayout;
    }

    public static com.up366.mobile.databinding.CountMainActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CountMainActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CountMainActivityBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.count_main_activity, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CountMainActivityBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CountMainActivityBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CountMainActivityBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.count_main_activity, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CountMainActivityBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CountMainActivityBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CountMainActivityBinding) bind(obj, view, com.up366.mobile.R.layout.count_main_activity);
    }
}
