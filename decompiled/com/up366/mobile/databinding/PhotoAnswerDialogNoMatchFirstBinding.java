package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PhotoAnswerDialogNoMatchFirstBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnRight;
    public final android.view.View dot1;
    public final android.view.View dot2;
    public final android.widget.ImageView ivExample;
    public final android.widget.TextView paperCodeTxt;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tipTxt;
    public final android.widget.TextView tipTxt1;
    public final android.widget.TextView tipTxt2;
    public final android.widget.TextView tipTxt3;
    public final android.widget.TextView tvTitle;

    private PhotoAnswerDialogNoMatchFirstBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.TextView textView2, android.view.View view, android.view.View view2, android.widget.ImageView imageView, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8) {
        this.rootView = constraintLayout;
        this.btnLeft = textView;
        this.btnRight = textView2;
        this.dot1 = view;
        this.dot2 = view2;
        this.ivExample = imageView;
        this.paperCodeTxt = textView3;
        this.tipTxt = textView4;
        this.tipTxt1 = textView5;
        this.tipTxt2 = textView6;
        this.tipTxt3 = textView7;
        this.tvTitle = textView8;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PhotoAnswerDialogNoMatchFirstBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PhotoAnswerDialogNoMatchFirstBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.photo_answer_dialog_no_match_first, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PhotoAnswerDialogNoMatchFirstBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_left;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_left);
        if (textView != null) {
            i = com.up366.mobile.R.id.btn_right;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_right);
            if (textView2 != null) {
                i = com.up366.mobile.R.id.dot1;
                android.view.View viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dot1);
                if (viewFindChildViewById != null) {
                    i = com.up366.mobile.R.id.dot2;
                    android.view.View viewFindChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.dot2);
                    if (viewFindChildViewById2 != null) {
                        i = com.up366.mobile.R.id.iv_example;
                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_example);
                        if (imageView != null) {
                            i = com.up366.mobile.R.id.paper_code_txt;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.paper_code_txt);
                            if (textView3 != null) {
                                i = com.up366.mobile.R.id.tip_txt;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt);
                                if (textView4 != null) {
                                    i = com.up366.mobile.R.id.tip_txt1;
                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt1);
                                    if (textView5 != null) {
                                        i = com.up366.mobile.R.id.tip_txt2;
                                        android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt2);
                                        if (textView6 != null) {
                                            i = com.up366.mobile.R.id.tip_txt3;
                                            android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt3);
                                            if (textView7 != null) {
                                                i = com.up366.mobile.R.id.tv_title;
                                                android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_title);
                                                if (textView8 != null) {
                                                    return new com.up366.mobile.databinding.PhotoAnswerDialogNoMatchFirstBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, viewFindChildViewById, viewFindChildViewById2, imageView, textView3, textView4, textView5, textView6, textView7, textView8);
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
