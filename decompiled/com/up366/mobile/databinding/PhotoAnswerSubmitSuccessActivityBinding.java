package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PhotoAnswerSubmitSuccessActivityBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView ivHead;
    public final android.widget.ImageView ivLookReport;
    public final android.widget.LinearLayout llTitle;
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton qrbKnow;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tvScoreTips;
    public final android.widget.TextView tvSuccessTips;
    public final android.widget.TextView tvWaitTips;

    private PhotoAnswerSubmitSuccessActivityBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.LinearLayout linearLayout, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        this.rootView = constraintLayout;
        this.ivHead = imageView;
        this.ivLookReport = imageView2;
        this.llTitle = linearLayout;
        this.qrbKnow = qMUIRoundButton;
        this.tvScoreTips = textView;
        this.tvSuccessTips = textView2;
        this.tvWaitTips = textView3;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitSuccessActivityBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitSuccessActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.photo_answer_submit_success_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitSuccessActivityBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.iv_head;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_head);
        if (imageView != null) {
            i = com.up366.mobile.R.id.iv_look_report;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_look_report);
            if (imageView2 != null) {
                i = com.up366.mobile.R.id.ll_title;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ll_title);
                if (linearLayout != null) {
                    i = com.up366.mobile.R.id.qrb_know;
                    com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = (com.up366.qmui.widget.roundwidget.QMUIRoundButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.qrb_know);
                    if (qMUIRoundButton != null) {
                        i = com.up366.mobile.R.id.tv_score_tips;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_score_tips);
                        if (textView != null) {
                            i = com.up366.mobile.R.id.tv_success_tips;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_success_tips);
                            if (textView2 != null) {
                                i = com.up366.mobile.R.id.tv_wait_tips;
                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_wait_tips);
                                if (textView3 != null) {
                                    return new com.up366.mobile.databinding.PhotoAnswerSubmitSuccessActivityBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, imageView2, linearLayout, qMUIRoundButton, textView, textView2, textView3);
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
