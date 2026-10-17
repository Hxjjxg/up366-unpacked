package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class CustomRefreshHeadLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final com.airbnb.lottie.LottieAnimationView animationView;
    private final android.widget.LinearLayout rootView;

    private CustomRefreshHeadLayoutBinding(android.widget.LinearLayout linearLayout, com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
        this.rootView = linearLayout;
        this.animationView = lottieAnimationView;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.CustomRefreshHeadLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.CustomRefreshHeadLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.custom_refresh_head_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.CustomRefreshHeadLayoutBinding bind(android.view.View view) {
        com.airbnb.lottie.LottieAnimationView lottieAnimationViewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.animationView);
        if (lottieAnimationViewFindChildViewById != null) {
            return new com.up366.mobile.databinding.CustomRefreshHeadLayoutBinding((android.widget.LinearLayout) view, lottieAnimationViewFindChildViewById);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(com.up366.mobile.R.id.animationView)));
    }
}
