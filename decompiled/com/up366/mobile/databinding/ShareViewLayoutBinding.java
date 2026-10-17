package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ShareViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView dialogTitle;
    public final android.widget.TextView sharedCancle;
    public final android.widget.TextView sharedSaveToLocal;
    public final android.widget.TextView sharedToQq;
    public final android.widget.TextView sharedToQqSpace;
    public final android.widget.TextView sharedToWechatFriend;
    public final android.widget.TextView sharedToWechatSpace;

    protected ShareViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7) {
        super(obj, view, i);
        this.dialogTitle = textView;
        this.sharedCancle = textView2;
        this.sharedSaveToLocal = textView3;
        this.sharedToQq = textView4;
        this.sharedToQqSpace = textView5;
        this.sharedToWechatFriend = textView6;
        this.sharedToWechatSpace = textView7;
    }

    public static com.up366.mobile.databinding.ShareViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ShareViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ShareViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.share_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ShareViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ShareViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ShareViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.share_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ShareViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ShareViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ShareViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.share_view_layout);
    }
}
