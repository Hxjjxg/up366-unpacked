package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogTaskReturnTipBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView btnClose;
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnRight;
    public final android.widget.TextView errorMsg;
    public final android.widget.ImageView errorTipImg;
    public final android.widget.TextView errorTxt;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tipTxt1;
    public final android.widget.TextView tvTitle;

    private DialogTaskReturnTipBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.ImageView imageView2, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6) {
        this.rootView = constraintLayout;
        this.btnClose = imageView;
        this.btnLeft = textView;
        this.btnRight = textView2;
        this.errorMsg = textView3;
        this.errorTipImg = imageView2;
        this.errorTxt = textView4;
        this.tipTxt1 = textView5;
        this.tvTitle = textView6;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogTaskReturnTipBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogTaskReturnTipBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_task_return_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogTaskReturnTipBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_close;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_close);
        if (imageView != null) {
            i = com.up366.mobile.R.id.btn_left;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_left);
            if (textView != null) {
                i = com.up366.mobile.R.id.btn_right;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_right);
                if (textView2 != null) {
                    i = com.up366.mobile.R.id.error_msg;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.error_msg);
                    if (textView3 != null) {
                        i = com.up366.mobile.R.id.error_tip_img;
                        android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.error_tip_img);
                        if (imageView2 != null) {
                            i = com.up366.mobile.R.id.error_txt;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.error_txt);
                            if (textView4 != null) {
                                i = com.up366.mobile.R.id.tip_txt1;
                                android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt1);
                                if (textView5 != null) {
                                    i = com.up366.mobile.R.id.tv_title;
                                    android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_title);
                                    if (textView6 != null) {
                                        return new com.up366.mobile.databinding.DialogTaskReturnTipBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, textView, textView2, textView3, imageView2, textView4, textView5, textView6);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
