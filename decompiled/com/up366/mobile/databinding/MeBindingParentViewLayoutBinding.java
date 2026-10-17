package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeBindingParentViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView codeTip1;
    public final com.up366.mobile.common.views.PaddingShadowLayout content;
    public final android.widget.ImageView parentLoading;
    public final android.widget.ImageView qrParent;
    public final android.view.View qrParentBg;
    public final android.widget.TextView retryBtn;
    public final android.widget.LinearLayout tipLayout;
    public final android.view.View tipMask;
    public final android.widget.TextView tipMessage;
    public final com.up366.mobile.common.views.CircleImageView userPhoto;
    public final android.widget.TextView userPublic;
    public final android.widget.TextView userRealname;

    protected MeBindingParentViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.view.View view2, android.widget.TextView textView2, android.widget.LinearLayout linearLayout, android.view.View view3, android.widget.TextView textView3, com.up366.mobile.common.views.CircleImageView circleImageView, android.widget.TextView textView4, android.widget.TextView textView5) {
        super(obj, view, i);
        this.codeTip1 = textView;
        this.content = paddingShadowLayout;
        this.parentLoading = imageView;
        this.qrParent = imageView2;
        this.qrParentBg = view2;
        this.retryBtn = textView2;
        this.tipLayout = linearLayout;
        this.tipMask = view3;
        this.tipMessage = textView3;
        this.userPhoto = circleImageView;
        this.userPublic = textView4;
        this.userRealname = textView5;
    }

    public static com.up366.mobile.databinding.MeBindingParentViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_binding_parent_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeBindingParentViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_binding_parent_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeBindingParentViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeBindingParentViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeBindingParentViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_binding_parent_view_layout);
    }
}
