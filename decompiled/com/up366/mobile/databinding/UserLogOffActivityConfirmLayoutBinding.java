package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class UserLogOffActivityConfirmLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout askForSuccessLayout;
    public final com.up366.mobile.common.views.TitleBackView backBtn;
    public final android.widget.Button btnChange;
    public final android.widget.TextView btnNoCode;
    public final com.up366.mobile.common.views.AppEditTextView captcha;
    public final android.widget.TextView errorTip;
    public final com.up366.mobile.common.views.AppEditTextView mobile;
    public final androidx.constraintlayout.widget.ConstraintLayout root;
    public final android.widget.ImageView successImg;
    public final android.widget.TextView successTip;
    public final android.widget.TextView tip;
    public final android.widget.TextView tip1;
    public final android.widget.LinearLayout titleLayout;
    public final android.widget.TextView toLogin;
    public final android.widget.TextView tx1;
    public final android.widget.TextView username;

    protected UserLogOffActivityConfirmLayoutBinding(java.lang.Object obj, android.view.View view, int i, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, com.up366.mobile.common.views.TitleBackView titleBackView, android.widget.Button button, android.widget.TextView textView, com.up366.mobile.common.views.AppEditTextView appEditTextView, android.widget.TextView textView2, com.up366.mobile.common.views.AppEditTextView appEditTextView2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, android.widget.ImageView imageView, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.LinearLayout linearLayout, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8) {
        super(obj, view, i);
        this.askForSuccessLayout = constraintLayout;
        this.backBtn = titleBackView;
        this.btnChange = button;
        this.btnNoCode = textView;
        this.captcha = appEditTextView;
        this.errorTip = textView2;
        this.mobile = appEditTextView2;
        this.root = constraintLayout2;
        this.successImg = imageView;
        this.successTip = textView3;
        this.tip = textView4;
        this.tip1 = textView5;
        this.titleLayout = linearLayout;
        this.toLogin = textView6;
        this.tx1 = textView7;
        this.username = textView8;
    }

    public static com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_log_off_activity_confirm_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_log_off_activity_confirm_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserLogOffActivityConfirmLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.user_log_off_activity_confirm_layout);
    }
}
