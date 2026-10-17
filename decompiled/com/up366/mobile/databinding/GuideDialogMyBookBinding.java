package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class GuideDialogMyBookBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView focus;
    public final android.widget.ImageView tipImage;
    public final android.widget.ImageView tipItem;

    protected GuideDialogMyBookBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.ImageView imageView2) {
        super(obj, view, i);
        this.focus = textView;
        this.tipImage = imageView;
        this.tipItem = imageView2;
    }

    public static com.up366.mobile.databinding.GuideDialogMyBookBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.GuideDialogMyBookBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.GuideDialogMyBookBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.guide_dialog_my_book, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.GuideDialogMyBookBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.GuideDialogMyBookBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.GuideDialogMyBookBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.guide_dialog_my_book, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.GuideDialogMyBookBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.GuideDialogMyBookBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.GuideDialogMyBookBinding) bind(obj, view, com.up366.mobile.R.layout.guide_dialog_my_book);
    }
}
