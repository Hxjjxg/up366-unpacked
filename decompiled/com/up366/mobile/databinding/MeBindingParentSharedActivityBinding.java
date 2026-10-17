package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeBindingParentSharedActivityBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView codeTip1;
    public final com.up366.mobile.common.views.PaddingShadowLayout content;
    public final android.widget.TextView expireTime;
    public final com.up366.mobile.common.views.RoundImageView image;
    public final android.widget.ImageView qrParent;
    public final android.view.View qrParentBg;
    public final androidx.constraintlayout.widget.ConstraintLayout shareLayout;
    public final android.widget.LinearLayout sharedBotoomDashboard;
    public final android.widget.TextView sharedCancle;
    public final android.widget.TextView sharedSaveToLocal;
    public final android.widget.TextView sharedToQq;
    public final android.widget.TextView sharedToQqSpace;
    public final android.widget.TextView sharedToWechatFriend;
    public final android.widget.TextView sharedToWechatSpace;
    public final com.up366.mobile.common.views.CircleImageView userPhoto;
    public final android.widget.TextView userPublic;
    public final android.widget.TextView userRealname;

    protected MeBindingParentSharedActivityBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout, android.widget.TextView textView2, com.up366.mobile.common.views.RoundImageView roundImageView, android.widget.ImageView imageView, android.view.View view2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.LinearLayout linearLayout, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8, com.up366.mobile.common.views.CircleImageView circleImageView, android.widget.TextView textView9, android.widget.TextView textView10) {
        super(obj, view, i);
        this.codeTip1 = textView;
        this.content = paddingShadowLayout;
        this.expireTime = textView2;
        this.image = roundImageView;
        this.qrParent = imageView;
        this.qrParentBg = view2;
        this.shareLayout = constraintLayout;
        this.sharedBotoomDashboard = linearLayout;
        this.sharedCancle = textView3;
        this.sharedSaveToLocal = textView4;
        this.sharedToQq = textView5;
        this.sharedToQqSpace = textView6;
        this.sharedToWechatFriend = textView7;
        this.sharedToWechatSpace = textView8;
        this.userPhoto = circleImageView;
        this.userPublic = textView9;
        this.userRealname = textView10;
    }

    public static com.up366.mobile.databinding.MeBindingParentSharedActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentSharedActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentSharedActivityBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_binding_parent_shared_activity, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeBindingParentSharedActivityBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentSharedActivityBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentSharedActivityBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_binding_parent_shared_activity, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeBindingParentSharedActivityBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentSharedActivityBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentSharedActivityBinding) bind(obj, view, com.up366.mobile.R.layout.me_binding_parent_shared_activity);
    }
}
