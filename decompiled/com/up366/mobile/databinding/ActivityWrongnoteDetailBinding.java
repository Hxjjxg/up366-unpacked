package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityWrongnoteDetailBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;

    protected ActivityWrongnoteDetailBinding(java.lang.Object obj, android.view.View view, int i, androidx.recyclerview.widget.RecyclerView recyclerView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout) {
        super(obj, view, i);
        this.recycleView = recyclerView;
        this.refreshLayout = pullRefreshLayout;
    }

    public static com.up366.mobile.databinding.ActivityWrongnoteDetailBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityWrongnoteDetailBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityWrongnoteDetailBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_wrongnote_detail, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityWrongnoteDetailBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityWrongnoteDetailBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityWrongnoteDetailBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_wrongnote_detail, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityWrongnoteDetailBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityWrongnoteDetailBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityWrongnoteDetailBinding) bind(obj, view, com.up366.mobile.R.layout.activity_wrongnote_detail);
    }
}
