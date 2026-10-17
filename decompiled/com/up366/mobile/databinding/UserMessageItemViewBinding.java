package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class UserMessageItemViewBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.CircleImageView civMsgNoRead;
    public final android.widget.ImageView ivMsgIcon;
    public final android.widget.TextView tvMsgContent;
    public final android.widget.TextView tvMsgEndTime;
    public final android.widget.TextView tvMsgTitle;

    protected UserMessageItemViewBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.CircleImageView circleImageView, android.widget.ImageView imageView, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        super(obj, view, i);
        this.civMsgNoRead = circleImageView;
        this.ivMsgIcon = imageView;
        this.tvMsgContent = textView;
        this.tvMsgEndTime = textView2;
        this.tvMsgTitle = textView3;
    }

    public static com.up366.mobile.databinding.UserMessageItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserMessageItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserMessageItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_message_item_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.UserMessageItemViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserMessageItemViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserMessageItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_message_item_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.UserMessageItemViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserMessageItemViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserMessageItemViewBinding) bind(obj, view, com.up366.mobile.R.layout.user_message_item_view);
    }
}
