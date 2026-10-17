package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AppEditTextViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView clear;
    public final com.up366.mobile.common.views.CommonEditText edit;
    public final com.up366.mobile.common.views.CheckableImageView eye;
    public final android.widget.TextView rightBtn;

    protected AppEditTextViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, com.up366.mobile.common.views.CommonEditText commonEditText, com.up366.mobile.common.views.CheckableImageView checkableImageView, android.widget.TextView textView) {
        super(obj, view, i);
        this.clear = imageView;
        this.edit = commonEditText;
        this.eye = checkableImageView;
        this.rightBtn = textView;
    }

    public static com.up366.mobile.databinding.AppEditTextViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppEditTextViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppEditTextViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.app_edit_text_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AppEditTextViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppEditTextViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppEditTextViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.app_edit_text_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AppEditTextViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppEditTextViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppEditTextViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.app_edit_text_view_layout);
    }
}
