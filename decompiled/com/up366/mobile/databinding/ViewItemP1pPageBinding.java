package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ViewItemP1pPageBinding implements androidx.viewbinding.ViewBinding {
    public final androidx.constraintlayout.widget.ConstraintLayout clRoot;
    public final com.up366.mobile.common.views.CircleImageView ivShowGuide;
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton qrbPageIndex;
    public final com.up366.qmui.widget.QMUIRadiusImageView qrvImage;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;

    private ViewItemP1pPageBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, com.up366.mobile.common.views.CircleImageView circleImageView, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton, com.up366.qmui.widget.QMUIRadiusImageView qMUIRadiusImageView) {
        this.rootView = constraintLayout;
        this.clRoot = constraintLayout2;
        this.ivShowGuide = circleImageView;
        this.qrbPageIndex = qMUIRoundButton;
        this.qrvImage = qMUIRadiusImageView;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ViewItemP1pPageBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ViewItemP1pPageBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.view_item_p1p_page, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ViewItemP1pPageBinding bind(android.view.View view) {
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
        int i = com.up366.mobile.R.id.iv_show_guide;
        com.up366.mobile.common.views.CircleImageView circleImageView = (com.up366.mobile.common.views.CircleImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_show_guide);
        if (circleImageView != null) {
            i = com.up366.mobile.R.id.qrb_page_index;
            com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = (com.up366.qmui.widget.roundwidget.QMUIRoundButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.qrb_page_index);
            if (qMUIRoundButton != null) {
                i = com.up366.mobile.R.id.qrv_image;
                com.up366.qmui.widget.QMUIRadiusImageView qMUIRadiusImageView = (com.up366.qmui.widget.QMUIRadiusImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.qrv_image);
                if (qMUIRadiusImageView != null) {
                    return new com.up366.mobile.databinding.ViewItemP1pPageBinding(constraintLayout, constraintLayout, circleImageView, qMUIRoundButton, qMUIRadiusImageView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
