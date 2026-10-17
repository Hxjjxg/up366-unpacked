package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class FragmentTxLiveChatBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout clRoot;
    public final com.sunhapper.x.spedit.view.SpXEditText etInputMsg;
    public final com.up366.mobile.common.views.CommonEditText etTemp;
    public final android.widget.FrameLayout flInput;
    public final android.widget.ImageButton ibFaceMsg;
    public final android.widget.ImageButton ibMsgSend;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout liveChatPullRefreshLayout;
    public final androidx.constraintlayout.widget.ConstraintLayout llInputSend;
    public final androidx.recyclerview.widget.RecyclerView rvMessage;

    protected FragmentTxLiveChatBinding(java.lang.Object obj, android.view.View view, int i, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, com.sunhapper.x.spedit.view.SpXEditText spXEditText, com.up366.mobile.common.views.CommonEditText commonEditText, android.widget.FrameLayout frameLayout, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, androidx.recyclerview.widget.RecyclerView recyclerView) {
        super(obj, view, i);
        this.clRoot = constraintLayout;
        this.etInputMsg = spXEditText;
        this.etTemp = commonEditText;
        this.flInput = frameLayout;
        this.ibFaceMsg = imageButton;
        this.ibMsgSend = imageButton2;
        this.liveChatPullRefreshLayout = pullRefreshLayout;
        this.llInputSend = constraintLayout2;
        this.rvMessage = recyclerView;
    }

    public static com.up366.mobile.databinding.FragmentTxLiveChatBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FragmentTxLiveChatBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FragmentTxLiveChatBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.fragment_tx_live_chat, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.FragmentTxLiveChatBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FragmentTxLiveChatBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FragmentTxLiveChatBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.fragment_tx_live_chat, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.FragmentTxLiveChatBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FragmentTxLiveChatBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FragmentTxLiveChatBinding) bind(obj, view, com.up366.mobile.R.layout.fragment_tx_live_chat);
    }
}
