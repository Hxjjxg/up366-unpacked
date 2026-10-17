package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MessageViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView msgIcon;
    public final android.widget.TextView tvNum;

    protected MessageViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.TextView textView) {
        super(obj, view, i);
        this.msgIcon = imageView;
        this.tvNum = textView;
    }

    public static com.up366.mobile.databinding.MessageViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MessageViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MessageViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.message_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MessageViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MessageViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MessageViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.message_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MessageViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MessageViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MessageViewBinding) bind(obj, view, com.up366.mobile.R.layout.message_view);
    }
}
