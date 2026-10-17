package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PhotoAnswerSubmitSuccessActivity1Binding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView ivHead;
    public final android.widget.ImageView ivLookReport;
    public final android.widget.LinearLayout llTitle;
    public final android.widget.TextView qrbKnow;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tvLookReportTips;
    public final android.widget.TextView tvScoreTips;
    public final android.widget.TextView tvSuccessTips;
    public final android.widget.TextView tvWaitTips;

    private PhotoAnswerSubmitSuccessActivity1Binding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.LinearLayout linearLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5) {
        this.rootView = constraintLayout;
        this.ivHead = imageView;
        this.ivLookReport = imageView2;
        this.llTitle = linearLayout;
        this.qrbKnow = textView;
        this.tvLookReportTips = textView2;
        this.tvScoreTips = textView3;
        this.tvSuccessTips = textView4;
        this.tvWaitTips = textView5;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitSuccessActivity1Binding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitSuccessActivity1Binding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.photo_answer_submit_success_activity1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PhotoAnswerSubmitSuccessActivity1Binding bind(android.view.View view) {
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
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.qrb_know);
                    if (textView != null) {
                        i = com.up366.mobile.R.id.tv_look_report_tips;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_look_report_tips);
                        if (textView2 != null) {
                            i = com.up366.mobile.R.id.tv_score_tips;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_score_tips);
                            if (textView3 != null) {
                                i = com.up366.mobile.R.id.tv_success_tips;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_success_tips);
                                if (textView4 != null) {
                                    i = com.up366.mobile.R.id.tv_wait_tips;
                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_wait_tips);
                                    if (textView5 != null) {
                                        return new com.up366.mobile.databinding.PhotoAnswerSubmitSuccessActivity1Binding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, imageView2, linearLayout, textView, textView2, textView3, textView4, textView5);
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
