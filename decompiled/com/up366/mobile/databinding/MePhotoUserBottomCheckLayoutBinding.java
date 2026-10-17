package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MePhotoUserBottomCheckLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView albumBtn;
    public final android.widget.TextView cancelBtn;
    public final android.widget.TextView closeBtn;
    public final android.view.View meDivider1;
    public final android.view.View meDivider2;
    public final android.widget.TextView takePhoto;

    protected MePhotoUserBottomCheckLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.view.View view2, android.view.View view3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.albumBtn = textView;
        this.cancelBtn = textView2;
        this.closeBtn = textView3;
        this.meDivider1 = view2;
        this.meDivider2 = view3;
        this.takePhoto = textView4;
    }

    public static com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_photo_user_bottom_check_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_photo_user_bottom_check_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoUserBottomCheckLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_photo_user_bottom_check_layout);
    }
}
