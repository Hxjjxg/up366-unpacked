package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class DialogMessageMainLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView messageBtn;
    public final android.widget.ImageView messageClose;
    public final android.widget.TextView messageContent;
    public final android.widget.ImageView messageImg;
    public final android.widget.TextView messageMore;
    public final android.widget.TextView messageSubject;
    public final android.widget.TextView messageTitle;
    public final android.widget.TextView updateDialogBackground;

    protected DialogMessageMainLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.TextView textView2, android.widget.ImageView imageView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6) {
        super(obj, view, i);
        this.messageBtn = textView;
        this.messageClose = imageView;
        this.messageContent = textView2;
        this.messageImg = imageView2;
        this.messageMore = textView3;
        this.messageSubject = textView4;
        this.messageTitle = textView5;
        this.updateDialogBackground = textView6;
    }

    public static com.up366.mobile.databinding.DialogMessageMainLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogMessageMainLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogMessageMainLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.dialog_message_main_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.DialogMessageMainLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogMessageMainLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogMessageMainLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.dialog_message_main_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.DialogMessageMainLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DialogMessageMainLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DialogMessageMainLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.dialog_message_main_layout);
    }
}
