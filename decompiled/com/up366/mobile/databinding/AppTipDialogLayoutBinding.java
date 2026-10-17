package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AppTipDialogLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnOne;
    public final android.widget.ImageView img;
    public final android.widget.TextView message;

    protected AppTipDialogLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.btnOne = textView;
        this.img = imageView;
        this.message = textView2;
    }

    public static com.up366.mobile.databinding.AppTipDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppTipDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppTipDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.app_tip_dialog_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AppTipDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppTipDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppTipDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.app_tip_dialog_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AppTipDialogLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppTipDialogLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppTipDialogLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.app_tip_dialog_layout);
    }
}
