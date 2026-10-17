package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class TaskTipLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView downloadPaper;
    public final android.widget.TextView takePhotoBtn;
    public final android.widget.LinearLayout tipBg;

    protected TaskTipLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.LinearLayout linearLayout) {
        super(obj, view, i);
        this.downloadPaper = textView;
        this.takePhotoBtn = textView2;
        this.tipBg = linearLayout;
    }

    public static com.up366.mobile.databinding.TaskTipLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskTipLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskTipLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.task_tip_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.TaskTipLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskTipLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskTipLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.task_tip_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.TaskTipLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskTipLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskTipLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.task_tip_layout);
    }
}
