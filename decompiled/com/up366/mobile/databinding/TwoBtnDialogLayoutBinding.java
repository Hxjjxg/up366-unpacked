package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class TwoBtnDialogLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnRight;
    public final android.widget.LinearLayout buttonContainer;
    public final android.widget.LinearLayout container;
    public final android.widget.ScrollView contentScrollView;
    public final android.widget.TextView message;
    public final android.widget.TextView title;

    protected TwoBtnDialogLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.LinearLayout linearLayout, android.widget.LinearLayout linearLayout2, android.widget.ScrollView scrollView, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.btnLeft = textView;
        this.btnRight = textView2;
        this.buttonContainer = linearLayout;
        this.container = linearLayout2;
        this.contentScrollView = scrollView;
        this.message = textView3;
        this.title = textView4;
    }

    public static com.up366.mobile.databinding.TwoBtnDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TwoBtnDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TwoBtnDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.two_btn_dialog_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.TwoBtnDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TwoBtnDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TwoBtnDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.two_btn_dialog_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.TwoBtnDialogLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TwoBtnDialogLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TwoBtnDialogLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.two_btn_dialog_layout);
    }
}
