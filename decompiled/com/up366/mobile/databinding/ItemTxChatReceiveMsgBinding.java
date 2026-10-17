package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ItemTxChatReceiveMsgBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView ivUserHead;
    public final android.widget.LinearLayout llMsgTitle;
    public final com.sunhapper.x.spedit.view.SpXTextView stvMessage;
    public final android.widget.TextView tvMessageTime;
    public final android.widget.TextView tvUserName;
    public final com.up366.mobile.common.views.RoundBorderTextView tvUserRole;

    protected ItemTxChatReceiveMsgBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout, com.sunhapper.x.spedit.view.SpXTextView spXTextView, android.widget.TextView textView, android.widget.TextView textView2, com.up366.mobile.common.views.RoundBorderTextView roundBorderTextView) {
        super(obj, view, i);
        this.ivUserHead = imageView;
        this.llMsgTitle = linearLayout;
        this.stvMessage = spXTextView;
        this.tvMessageTime = textView;
        this.tvUserName = textView2;
        this.tvUserRole = roundBorderTextView;
    }

    public static com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.item_tx_chat_receive_msg, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.item_tx_chat_receive_msg, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding) bind(obj, view, com.up366.mobile.R.layout.item_tx_chat_receive_msg);
    }
}
