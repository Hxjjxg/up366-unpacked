package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class UserFeedbackActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.TextView cancelBtn;
    public final android.widget.TextView feedEmail;
    public final android.widget.TextView feedPhone;
    public final android.widget.TextView feedTip;
    public final com.up366.mobile.common.views.CustomEditText feedbackContentEt;
    public final android.view.View feedbackDivider;
    public final com.up366.mobile.common.views.CommonEditText feedbackPhoneEt;
    public final com.up366.multimedia.views.PictureVideoGridView feedbackPic;
    public final android.widget.FrameLayout feedbackPicLayout;
    public final android.widget.ScrollView feedbackScrollview;
    public final android.widget.TextView feedbackSubmitBtn;
    public final android.widget.TextView feedbackText1;
    public final android.widget.TextView feedbackText2;
    public final android.widget.TextView feedbackText3;
    public final android.widget.TextView iconFeedWechat;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected UserFeedbackActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, com.up366.mobile.common.views.CustomEditText customEditText, android.view.View view2, com.up366.mobile.common.views.CommonEditText commonEditText, com.up366.multimedia.views.PictureVideoGridView pictureVideoGridView, android.widget.FrameLayout frameLayout, android.widget.ScrollView scrollView, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8, android.widget.TextView textView9, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.cancelBtn = textView;
        this.feedEmail = textView2;
        this.feedPhone = textView3;
        this.feedTip = textView4;
        this.feedbackContentEt = customEditText;
        this.feedbackDivider = view2;
        this.feedbackPhoneEt = commonEditText;
        this.feedbackPic = pictureVideoGridView;
        this.feedbackPicLayout = frameLayout;
        this.feedbackScrollview = scrollView;
        this.feedbackSubmitBtn = textView5;
        this.feedbackText1 = textView6;
        this.feedbackText2 = textView7;
        this.feedbackText3 = textView8;
        this.iconFeedWechat = textView9;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_feedback_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_feedback_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserFeedbackActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.user_feedback_activity_layout);
    }
}
