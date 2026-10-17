package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PhotoAnswerSubmitErrorDialogBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView btnLeft;
    public final android.widget.TextView btnRight;
    public final android.widget.ImageView flBg;
    public final android.widget.ImageView ivPageFullHead;
    public final android.widget.ImageView ivSubmitFailHead;
    public final android.widget.LinearLayout llTaskInfo;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tvNextTips;
    public final android.widget.TextView tvTaskName;
    public final android.widget.TextView tvTitle;

    private PhotoAnswerSubmitErrorDialogBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.ImageView imageView3, android.widget.LinearLayout linearLayout, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5) {
        this.rootView = constraintLayout;
        this.btnLeft = textView;
        this.btnRight = textView2;
        this.flBg = imageView;
        this.ivPageFullHead = imageView2;
        this.ivSubmitFailHead = imageView3;
        this.llTaskInfo = linearLayout;
        this.tvNextTips = textView3;
        this.tvTaskName = textView4;
        this.tvTitle = textView5;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitErrorDialogBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitErrorDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.photo_answer_submit_error_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitErrorDialogBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_left;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_left);
        if (textView != null) {
            i = com.up366.mobile.R.id.btn_right;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_right);
            if (textView2 != null) {
                i = com.up366.mobile.R.id.fl_bg;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.fl_bg);
                if (imageView != null) {
                    i = com.up366.mobile.R.id.iv_page_full_head;
                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_page_full_head);
                    if (imageView2 != null) {
                        i = com.up366.mobile.R.id.iv_submit_fail_head;
                        android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_submit_fail_head);
                        if (imageView3 != null) {
                            i = com.up366.mobile.R.id.ll_task_info;
                            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ll_task_info);
                            if (linearLayout != null) {
                                i = com.up366.mobile.R.id.tv_next_tips;
                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_next_tips);
                                if (textView3 != null) {
                                    i = com.up366.mobile.R.id.tv_task_name;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_task_name);
                                    if (textView4 != null) {
                                        i = com.up366.mobile.R.id.tv_title;
                                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_title);
                                        if (textView5 != null) {
                                            return new com.up366.mobile.databinding.PhotoAnswerSubmitErrorDialogBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, imageView, imageView2, imageView3, linearLayout, textView3, textView4, textView5);
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
