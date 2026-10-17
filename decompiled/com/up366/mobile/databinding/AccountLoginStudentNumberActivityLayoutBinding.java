package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AccountLoginStudentNumberActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView acceptDealChecbox;
    public final com.up366.mobile.common.views.TitleBackView back;
    public final android.widget.Button btnLogin;
    public final android.widget.TextView btnUsernameLogin;
    public final androidx.constraintlayout.widget.ConstraintLayout container;
    public final android.widget.ImageView hand;
    public final android.widget.ImageView head;
    public final com.up366.mobile.common.views.AppTextView licenseText;
    public final com.up366.mobile.common.views.AppEditTextView password;
    public final android.widget.TextView school;
    public final android.widget.ScrollView scrollView;
    public final com.up366.mobile.common.views.AppEditTextView studentNumber;
    public final android.widget.Button viewBtnNext;
    public final android.widget.TextView viewReSelect;
    public final android.widget.TextView viewTip;

    protected AccountLoginStudentNumberActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, com.up366.mobile.common.views.TitleBackView titleBackView, android.widget.Button button, android.widget.TextView textView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView2, android.widget.ImageView imageView3, com.up366.mobile.common.views.AppTextView appTextView, com.up366.mobile.common.views.AppEditTextView appEditTextView, android.widget.TextView textView2, android.widget.ScrollView scrollView, com.up366.mobile.common.views.AppEditTextView appEditTextView2, android.widget.Button button2, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.acceptDealChecbox = imageView;
        this.back = titleBackView;
        this.btnLogin = button;
        this.btnUsernameLogin = textView;
        this.container = constraintLayout;
        this.hand = imageView2;
        this.head = imageView3;
        this.licenseText = appTextView;
        this.password = appEditTextView;
        this.school = textView2;
        this.scrollView = scrollView;
        this.studentNumber = appEditTextView2;
        this.viewBtnNext = button2;
        this.viewReSelect = textView3;
        this.viewTip = textView4;
    }

    public static com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_login_student_number_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.account_login_student_number_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AccountLoginStudentNumberActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.account_login_student_number_activity_layout);
    }
}
