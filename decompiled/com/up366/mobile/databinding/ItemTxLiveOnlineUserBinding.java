package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ItemTxLiveOnlineUserBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView ivUserHead;
    public final android.widget.TextView tvUserName;
    public final com.up366.mobile.common.views.RoundBorderTextView tvUserRole;

    protected ItemTxLiveOnlineUserBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.TextView textView, com.up366.mobile.common.views.RoundBorderTextView roundBorderTextView) {
        super(obj, view, i);
        this.ivUserHead = imageView;
        this.tvUserName = textView;
        this.tvUserRole = roundBorderTextView;
    }

    public static com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.item_tx_live_online_user, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.item_tx_live_online_user, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ItemTxLiveOnlineUserBinding) bind(obj, view, com.up366.mobile.R.layout.item_tx_live_online_user);
    }
}
