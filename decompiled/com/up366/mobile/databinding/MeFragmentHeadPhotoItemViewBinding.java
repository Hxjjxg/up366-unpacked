package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeFragmentHeadPhotoItemViewBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView account;
    public final android.widget.TextView dayStudyTime;
    public final android.widget.ImageView imageEnter;
    public final androidx.constraintlayout.widget.ConstraintLayout meHeadView;
    public final com.up366.mobile.common.views.CircleImageView mePhoto;
    public final android.widget.TextView name;
    public final android.widget.LinearLayout nameLayout;
    public final android.widget.ImageView studyCardIcon;
    public final android.widget.TextView tipCardTime;

    protected MeFragmentHeadPhotoItemViewBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ImageView imageView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, com.up366.mobile.common.views.CircleImageView circleImageView, android.widget.TextView textView3, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView2, android.widget.TextView textView4) {
        super(obj, view, i);
        this.account = textView;
        this.dayStudyTime = textView2;
        this.imageEnter = imageView;
        this.meHeadView = constraintLayout;
        this.mePhoto = circleImageView;
        this.name = textView3;
        this.nameLayout = linearLayout;
        this.studyCardIcon = imageView2;
        this.tipCardTime = textView4;
    }

    public static com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_fragment_head_photo_item_view, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_fragment_head_photo_item_view, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding) bind(obj, view, com.up366.mobile.R.layout.me_fragment_head_photo_item_view);
    }
}
