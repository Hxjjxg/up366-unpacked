package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogNetErrorBinding implements androidx.viewbinding.ViewBinding {
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton btnLeft;
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton btnRight;
    public final android.widget.ImageView ivError;
    public final android.widget.LinearLayout llLeftRightClick;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tvErrorTips;

    private DialogNetErrorBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton2, android.widget.ImageView imageView, android.widget.LinearLayout linearLayout, android.widget.TextView textView) {
        this.rootView = constraintLayout;
        this.btnLeft = qMUIRoundButton;
        this.btnRight = qMUIRoundButton2;
        this.ivError = imageView;
        this.llLeftRightClick = linearLayout;
        this.tvErrorTips = textView;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogNetErrorBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogNetErrorBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_net_error, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogNetErrorBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_left;
        com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = (com.up366.qmui.widget.roundwidget.QMUIRoundButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_left);
        if (qMUIRoundButton != null) {
            i = com.up366.mobile.R.id.btn_right;
            com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton2 = (com.up366.qmui.widget.roundwidget.QMUIRoundButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_right);
            if (qMUIRoundButton2 != null) {
                i = com.up366.mobile.R.id.iv_error;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_error);
                if (imageView != null) {
                    i = com.up366.mobile.R.id.ll_left_right_click;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ll_left_right_click);
                    if (linearLayout != null) {
                        i = com.up366.mobile.R.id.tv_error_tips;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_error_tips);
                        if (textView != null) {
                            return new com.up366.mobile.databinding.DialogNetErrorBinding((androidx.constraintlayout.widget.ConstraintLayout) view, qMUIRoundButton, qMUIRoundButton2, imageView, linearLayout, textView);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
