package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ViewP1pImageLookBackBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView ivShow;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView scivShow;

    private ViewP1pImageLookBackBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView) {
        this.rootView = constraintLayout;
        this.ivShow = imageView;
        this.scivShow = subsamplingScaleImageView;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ViewP1pImageLookBackBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ViewP1pImageLookBackBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.view_p1p_image_look_back, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ViewP1pImageLookBackBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.iv_show;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_show);
        if (imageView != null) {
            i = com.up366.mobile.R.id.sciv_show;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.sciv_show);
            if (subsamplingScaleImageView != null) {
                return new com.up366.mobile.databinding.ViewP1pImageLookBackBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, subsamplingScaleImageView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
