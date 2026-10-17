package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PhotoCorrectNoPaperCodeDialogBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnRight;
    public final android.widget.ImageView clear;
    public final android.widget.EditText content;
    public final android.widget.FrameLayout contentTx;
    public final android.widget.TextView errorTipInfo;
    public final android.widget.ImageView loading;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView taskName;
    public final android.widget.TextView tipTxt;
    public final android.widget.TextView tp2;
    public final android.widget.TextView tp3;
    public final android.widget.ImageView tp3Img;
    public final android.widget.TextView tvTitle;

    private PhotoCorrectNoPaperCodeDialogBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ImageView imageView, android.widget.EditText editText, android.widget.FrameLayout frameLayout, android.widget.TextView textView3, android.widget.ImageView imageView2, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.ImageView imageView3, android.widget.TextView textView8) {
        this.rootView = constraintLayout;
        this.btnLeft = textView;
        this.btnRight = textView2;
        this.clear = imageView;
        this.content = editText;
        this.contentTx = frameLayout;
        this.errorTipInfo = textView3;
        this.loading = imageView2;
        this.taskName = textView4;
        this.tipTxt = textView5;
        this.tp2 = textView6;
        this.tp3 = textView7;
        this.tp3Img = imageView3;
        this.tvTitle = textView8;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PhotoCorrectNoPaperCodeDialogBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PhotoCorrectNoPaperCodeDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.photo_correct_no_paper_code_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PhotoCorrectNoPaperCodeDialogBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_left;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_left);
        if (textView != null) {
            i = com.up366.mobile.R.id.btn_right;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_right);
            if (textView2 != null) {
                i = com.up366.mobile.R.id.clear;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.clear);
                if (imageView != null) {
                    i = 2131362178;
                    android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362178);
                    if (editText != null) {
                        i = com.up366.mobile.R.id.content_tx;
                        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.content_tx);
                        if (frameLayout != null) {
                            i = com.up366.mobile.R.id.error_tip_info;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.error_tip_info);
                            if (textView3 != null) {
                                i = com.up366.mobile.R.id.loading;
                                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.loading);
                                if (imageView2 != null) {
                                    i = com.up366.mobile.R.id.task_name;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.task_name);
                                    if (textView4 != null) {
                                        i = com.up366.mobile.R.id.tip_txt;
                                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt);
                                        if (textView5 != null) {
                                            i = com.up366.mobile.R.id.tp2;
                                            android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tp2);
                                            if (textView6 != null) {
                                                i = com.up366.mobile.R.id.tp3;
                                                android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tp3);
                                                if (textView7 != null) {
                                                    i = com.up366.mobile.R.id.tp3_img;
                                                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tp3_img);
                                                    if (imageView3 != null) {
                                                        i = com.up366.mobile.R.id.tv_title;
                                                        android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_title);
                                                        if (textView8 != null) {
                                                            return new com.up366.mobile.databinding.PhotoCorrectNoPaperCodeDialogBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, imageView, editText, frameLayout, textView3, imageView2, textView4, textView5, textView6, textView7, imageView3, textView8);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
