package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class FragmentHistoryTaskListBinding extends androidx.databinding.ViewDataBinding {
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefresh;
    public final androidx.recyclerview.widget.RecyclerView recycleView;

    protected FragmentHistoryTaskListBinding(java.lang.Object obj, android.view.View view, int i, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, androidx.recyclerview.widget.RecyclerView recyclerView) {
        super(obj, view, i);
        this.pullRefresh = pullRefreshLayout;
        this.recycleView = recyclerView;
    }

    public static com.up366.mobile.databinding.FragmentHistoryTaskListBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FragmentHistoryTaskListBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FragmentHistoryTaskListBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.fragment_history_task_list, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.FragmentHistoryTaskListBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FragmentHistoryTaskListBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FragmentHistoryTaskListBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.fragment_history_task_list, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.FragmentHistoryTaskListBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FragmentHistoryTaskListBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FragmentHistoryTaskListBinding) bind(obj, view, com.up366.mobile.R.layout.fragment_history_task_list);
    }
}
