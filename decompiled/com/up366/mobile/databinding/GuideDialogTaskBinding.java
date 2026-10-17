package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class GuideDialogTaskBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView focus;
    public final android.widget.ImageView tipImage;

    protected GuideDialogTaskBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.ImageView imageView) {
        super(obj, view, i);
        this.focus = textView;
        this.tipImage = imageView;
    }

    public static com.up366.mobile.databinding.GuideDialogTaskBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.GuideDialogTaskBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.GuideDialogTaskBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.guide_dialog_task, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.GuideDialogTaskBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.GuideDialogTaskBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.GuideDialogTaskBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.guide_dialog_task, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.GuideDialogTaskBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.GuideDialogTaskBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.GuideDialogTaskBinding) bind(obj, view, com.up366.mobile.R.layout.guide_dialog_task);
    }
}
