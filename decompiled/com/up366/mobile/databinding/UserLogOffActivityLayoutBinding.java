package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class UserLogOffActivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout askForLayout;
    public final com.up366.mobile.common.views.TitleBackView backBtn;
    public final android.view.View dot1;
    public final android.view.View dot2;
    public final android.view.View dot3;
    public final android.widget.Button logOffBtn;
    public final android.widget.TextView telephoneTip;
    public final android.widget.TextView tx1;
    public final android.widget.TextView tx2;
    public final android.widget.TextView tx3;
    public final android.widget.TextView tx4;
    public final android.widget.TextView tx5;
    public final android.widget.TextView tx6;
    public final android.widget.TextView tx7;
    public final android.widget.TextView tx8;

    protected UserLogOffActivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, com.up366.mobile.common.views.TitleBackView titleBackView, android.view.View view2, android.view.View view3, android.view.View view4, android.widget.Button button, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8, android.widget.TextView textView9) {
        super(obj, view, i);
        this.askForLayout = constraintLayout;
        this.backBtn = titleBackView;
        this.dot1 = view2;
        this.dot2 = view3;
        this.dot3 = view4;
        this.logOffBtn = button;
        this.telephoneTip = textView;
        this.tx1 = textView2;
        this.tx2 = textView3;
        this.tx3 = textView4;
        this.tx4 = textView5;
        this.tx5 = textView6;
        this.tx6 = textView7;
        this.tx7 = textView8;
        this.tx8 = textView9;
    }

    public static com.up366.mobile.databinding.UserLogOffActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserLogOffActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserLogOffActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_log_off_activity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.UserLogOffActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserLogOffActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserLogOffActivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.user_log_off_activity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.UserLogOffActivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.UserLogOffActivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.UserLogOffActivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.user_log_off_activity_layout);
    }
}
