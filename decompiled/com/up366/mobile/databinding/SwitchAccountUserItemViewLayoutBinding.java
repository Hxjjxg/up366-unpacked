package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class SwitchAccountUserItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView clearBtn;
    public final android.widget.TextView curUse;
    public final android.view.View mask;
    public final com.up366.mobile.common.views.PaddingShadowLayout pslBg;
    public final android.widget.TextView realName;
    public final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView statusGroup;
    public final android.widget.TextView userName;
    public final com.up366.mobile.common.views.RoundImageView userPhoto;

    protected SwitchAccountUserItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.view.View view2, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout, android.widget.TextView textView3, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView4, android.widget.TextView textView5, com.up366.mobile.common.views.RoundImageView roundImageView) {
        super(obj, view, i);
        this.clearBtn = textView;
        this.curUse = textView2;
        this.mask = view2;
        this.pslBg = paddingShadowLayout;
        this.realName = textView3;
        this.rootView = constraintLayout;
        this.statusGroup = textView4;
        this.userName = textView5;
        this.userPhoto = roundImageView;
    }

    public static com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.switch_account_user_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.switch_account_user_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.switch_account_user_item_view_layout);
    }
}
