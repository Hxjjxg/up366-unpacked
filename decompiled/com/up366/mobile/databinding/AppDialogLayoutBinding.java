package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AppDialogLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnBig;
    public final android.widget.ImageView btnClose;
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnOne;
    public final android.widget.TextView btnRight;
    public final android.widget.TextView btnV2Left;
    public final android.widget.TextView btnV2Right;
    public final android.widget.LinearLayout buttonContainer;
    public final androidx.constraintlayout.widget.ConstraintLayout buttonContainerV2;
    public final android.widget.TextView clickTip;
    public final android.widget.LinearLayout container;
    public final android.widget.ScrollView contentScrollView;
    public final android.widget.ImageView headImg;
    public final android.view.View lineV2Center;
    public final android.view.View lineV2Top;
    public final android.widget.TextView message;
    public final android.widget.TextView messageTitle;
    public final android.widget.TextView tip;
    public final android.widget.TextView title;
    public final android.widget.ScrollView titleScrollView;

    protected AppDialogLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.LinearLayout linearLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView7, android.widget.LinearLayout linearLayout2, android.widget.ScrollView scrollView, android.widget.ImageView imageView2, android.view.View view2, android.view.View view3, android.widget.TextView textView8, android.widget.TextView textView9, android.widget.TextView textView10, android.widget.TextView textView11, android.widget.ScrollView scrollView2) {
        super(obj, view, i);
        this.btnBig = textView;
        this.btnClose = imageView;
        this.btnLeft = textView2;
        this.btnOne = textView3;
        this.btnRight = textView4;
        this.btnV2Left = textView5;
        this.btnV2Right = textView6;
        this.buttonContainer = linearLayout;
        this.buttonContainerV2 = constraintLayout;
        this.clickTip = textView7;
        this.container = linearLayout2;
        this.contentScrollView = scrollView;
        this.headImg = imageView2;
        this.lineV2Center = view2;
        this.lineV2Top = view3;
        this.message = textView8;
        this.messageTitle = textView9;
        this.tip = textView10;
        this.title = textView11;
        this.titleScrollView = scrollView2;
    }

    public static com.up366.mobile.databinding.AppDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.app_dialog_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AppDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.app_dialog_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AppDialogLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AppDialogLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AppDialogLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.app_dialog_layout);
    }
}
