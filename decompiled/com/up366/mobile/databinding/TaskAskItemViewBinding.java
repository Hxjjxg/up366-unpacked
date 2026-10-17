package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class TaskAskItemViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView tvAskTime;
    public final android.widget.TextView tvTaskAskMessage;

    protected TaskAskItemViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.tvAskTime = textView;
        this.tvTaskAskMessage = textView2;
    }

    public static com.up366.mobile.databinding.TaskAskItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskAskItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskAskItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.task_ask_item_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.TaskAskItemViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskAskItemViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskAskItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.task_ask_item_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.TaskAskItemViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskAskItemViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskAskItemViewBinding) bind(obj, view, com.up366.mobile.R.layout.task_ask_item_view);
    }
}
