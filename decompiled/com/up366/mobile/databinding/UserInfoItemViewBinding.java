package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class UserInfoItemViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView mePhotoImgMeng;
    public final com.up366.mobile.common.views.CircleImageView userInfoImg;
    public final android.widget.TextView userInfoItemContent;
    public final android.view.View userInfoItemLine;
    public final android.widget.TextView userInfoItemText;
    public final android.widget.ImageView userInfoRightArrow;

    protected UserInfoItemViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, com.up366.mobile.common.views.CircleImageView circleImageView, android.widget.TextView textView2, android.view.View view2, android.widget.TextView textView3, android.widget.ImageView imageView) {
        super(obj, view, i);
        this.mePhotoImgMeng = textView;
        this.userInfoImg = circleImageView;
        this.userInfoItemContent = textView2;
        this.userInfoItemLine = view2;
        this.userInfoItemText = textView3;
        this.userInfoRightArrow = imageView;
    }

    public static com.up366.mobile.databinding.UserInfoItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserInfoItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserInfoItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_info_item_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.UserInfoItemViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserInfoItemViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserInfoItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_info_item_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.UserInfoItemViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserInfoItemViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserInfoItemViewBinding) bind(obj, view, com.up366.mobile.R.layout.user_info_item_view);
    }
}
