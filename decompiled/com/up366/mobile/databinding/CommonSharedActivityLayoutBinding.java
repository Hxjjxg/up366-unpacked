package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CommonSharedActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.mobile.common.views.RoundImageView image;
    public final android.widget.LinearLayout sharedBotoomDashboard;
    public final android.widget.TextView sharedCancle;
    public final android.widget.TextView sharedSaveToLocal;
    public final android.widget.TextView sharedToQq;
    public final android.widget.TextView sharedToQqSpace;
    public final android.widget.TextView sharedToWechatFriend;
    public final android.widget.TextView sharedToWechatSpace;

    protected CommonSharedActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.up366.mobile.common.views.RoundImageView roundImageView, android.widget.LinearLayout linearLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6) {
        super(obj, view, i);
        this.image = roundImageView;
        this.sharedBotoomDashboard = linearLayout;
        this.sharedCancle = textView;
        this.sharedSaveToLocal = textView2;
        this.sharedToQq = textView3;
        this.sharedToQqSpace = textView4;
        this.sharedToWechatFriend = textView5;
        this.sharedToWechatSpace = textView6;
    }

    public static com.up366.mobile.databinding.CommonSharedActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonSharedActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonSharedActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.common_shared_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.CommonSharedActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonSharedActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonSharedActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.common_shared_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.CommonSharedActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.CommonSharedActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.CommonSharedActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.common_shared_activity_layout);
    }
}
