package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ItemTxSendMsgBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView ivUserHead;
    public final android.widget.LinearLayout llMsgTitle;
    public final com.sunhapper.x.spedit.view.SpXTextView stvMessage;
    public final android.widget.TextView tvMessageTime;
    public final android.widget.TextView tvUserName;

    protected ItemTxSendMsgBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout, com.sunhapper.x.spedit.view.SpXTextView spXTextView, android.widget.TextView textView, android.widget.TextView textView2) {
        super(obj, view, i);
        this.ivUserHead = imageView;
        this.llMsgTitle = linearLayout;
        this.stvMessage = spXTextView;
        this.tvMessageTime = textView;
        this.tvUserName = textView2;
    }

    public static com.up366.mobile.databinding.ItemTxSendMsgBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxSendMsgBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxSendMsgBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.item_tx_send_msg, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ItemTxSendMsgBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxSendMsgBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxSendMsgBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.item_tx_send_msg, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ItemTxSendMsgBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxSendMsgBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxSendMsgBinding) bind(obj, view, com.up366.mobile.R.layout.item_tx_send_msg);
    }
}
