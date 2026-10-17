package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class PraiseDialogLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnClose;
    public final android.widget.TextView btnPraise;
    public final android.widget.TextView btnRoast;
    public final android.widget.LinearLayout container;
    public final android.widget.TextView title;

    protected PraiseDialogLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.LinearLayout linearLayout, android.widget.TextView textView4) {
        super(obj, view, i);
        this.btnClose = textView;
        this.btnPraise = textView2;
        this.btnRoast = textView3;
        this.container = linearLayout;
        this.title = textView4;
    }

    public static com.up366.mobile.databinding.PraiseDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PraiseDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PraiseDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.praise_dialog_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.PraiseDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PraiseDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PraiseDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.praise_dialog_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.PraiseDialogLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PraiseDialogLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PraiseDialogLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.praise_dialog_layout);
    }
}
