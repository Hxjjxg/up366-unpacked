package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeTearchingClassFragmentLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;

    protected MeTearchingClassFragmentLayoutBinding(java.lang.Object obj, android.view.View view, int i, androidx.recyclerview.widget.RecyclerView recyclerView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout) {
        super(obj, view, i);
        this.recycleView = recyclerView;
        this.refreshLayout = pullRefreshLayout;
    }

    public static com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_tearching_class_fragment_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_tearching_class_fragment_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_tearching_class_fragment_layout);
    }
}
