package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeMyBookItemViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView bookName;
    public final com.up366.mobile.common.views.RoundImageView bookPicture;
    public final android.widget.ImageView downShelfTip;
    public final android.widget.TextView gotoStudyBtn;
    public final android.widget.TextView gotoTryBtn;
    public final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tipEndTime;
    public final android.widget.TextView tipNew;
    public final android.widget.TextView tipText;

    protected MeMyBookItemViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, com.up366.mobile.common.views.RoundImageView roundImageView, android.widget.ImageView imageView, android.widget.TextView textView2, android.widget.TextView textView3, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6) {
        super(obj, view, i);
        this.bookName = textView;
        this.bookPicture = roundImageView;
        this.downShelfTip = imageView;
        this.gotoStudyBtn = textView2;
        this.gotoTryBtn = textView3;
        this.rootView = constraintLayout;
        this.tipEndTime = textView4;
        this.tipNew = textView5;
        this.tipText = textView6;
    }

    public static com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_my_book_item_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_my_book_item_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_my_book_item_view_layout);
    }
}
