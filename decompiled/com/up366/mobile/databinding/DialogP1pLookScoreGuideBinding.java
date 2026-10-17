package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogP1pLookScoreGuideBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView ivOpenGuide;
    public final android.widget.LinearLayout llContent;
    public final android.widget.LinearLayout llOpenSetting;
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton qrbKnow;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tvOpen;
    public final android.widget.TextView tvTitle;
    public final android.widget.TextView tvWayOne;
    public final android.widget.TextView tvWayTwoTitle;

    private DialogP1pLookScoreGuideBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout, android.widget.LinearLayout linearLayout2, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        this.rootView = constraintLayout;
        this.ivOpenGuide = imageView;
        this.llContent = linearLayout;
        this.llOpenSetting = linearLayout2;
        this.qrbKnow = qMUIRoundButton;
        this.tvOpen = textView;
        this.tvTitle = textView2;
        this.tvWayOne = textView3;
        this.tvWayTwoTitle = textView4;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogP1pLookScoreGuideBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogP1pLookScoreGuideBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_p1p_look_score_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogP1pLookScoreGuideBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.iv_open_guide;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_open_guide);
        if (imageView != null) {
            i = com.up366.mobile.R.id.ll_content;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ll_content);
            if (linearLayout != null) {
                i = com.up366.mobile.R.id.ll_open_setting;
                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ll_open_setting);
                if (linearLayout2 != null) {
                    i = com.up366.mobile.R.id.qrb_know;
                    com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = (com.up366.qmui.widget.roundwidget.QMUIRoundButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.qrb_know);
                    if (qMUIRoundButton != null) {
                        i = com.up366.mobile.R.id.tv_open;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_open);
                        if (textView != null) {
                            i = com.up366.mobile.R.id.tv_title;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_title);
                            if (textView2 != null) {
                                i = com.up366.mobile.R.id.tv_way_one;
                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_way_one);
                                if (textView3 != null) {
                                    i = com.up366.mobile.R.id.tv_way_two_title;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_way_two_title);
                                    if (textView4 != null) {
                                        return new com.up366.mobile.databinding.DialogP1pLookScoreGuideBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, linearLayout, linearLayout2, qMUIRoundButton, textView, textView2, textView3, textView4);
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
