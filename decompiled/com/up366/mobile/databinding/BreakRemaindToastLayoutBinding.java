package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class BreakRemaindToastLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView imageView4;
    private final android.widget.LinearLayout rootView;
    public final android.widget.TextView toastTip;
    public final com.up366.mobile.common.views.PaddingShadowLayout userMoneyItemCv;

    private BreakRemaindToastLayoutBinding(android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, android.widget.TextView textView, com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout) {
        this.rootView = linearLayout;
        this.imageView4 = imageView;
        this.toastTip = textView;
        this.userMoneyItemCv = paddingShadowLayout;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.BreakRemaindToastLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.BreakRemaindToastLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.break_remaind_toast_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.BreakRemaindToastLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.imageView4;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.imageView4);
        if (imageView != null) {
            i = com.up366.mobile.R.id.toast_tip;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.toast_tip);
            if (textView != null) {
                i = com.up366.mobile.R.id.user_money_item_cv;
                com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout = (com.up366.mobile.common.views.PaddingShadowLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.user_money_item_cv);
                if (paddingShadowLayout != null) {
                    return new com.up366.mobile.databinding.BreakRemaindToastLayoutBinding((android.widget.LinearLayout) view, imageView, textView, paddingShadowLayout);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
