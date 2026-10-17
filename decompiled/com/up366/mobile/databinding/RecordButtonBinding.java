package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class RecordButtonBinding extends androidx.databinding.ViewDataBinding {
    public final android.view.View recordBg;
    public final android.widget.ImageView recordImg;
    public final android.widget.TextView recordTxt;

    protected RecordButtonBinding(java.lang.Object obj, android.view.View view, int i, android.view.View view2, android.widget.ImageView imageView, android.widget.TextView textView) {
        super(obj, view, i);
        this.recordBg = view2;
        this.recordImg = imageView;
        this.recordTxt = textView;
    }

    public static com.up366.mobile.databinding.RecordButtonBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RecordButtonBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RecordButtonBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.record_button, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.RecordButtonBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RecordButtonBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RecordButtonBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.record_button, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.RecordButtonBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.RecordButtonBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.RecordButtonBinding) bind(obj, view, com.up366.mobile.R.layout.record_button);
    }
}
