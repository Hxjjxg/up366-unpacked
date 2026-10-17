package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DialogLoadingXiaoTianBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView closeBtn;
    public final android.widget.ImageView givLoading;
    public final com.up366.mobile.common.views.DownloadProgressView progressBar;
    public final android.widget.TextView progressValue;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tvLoadingTips;

    private DialogLoadingXiaoTianBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.ImageView imageView2, com.up366.mobile.common.views.DownloadProgressView downloadProgressView, android.widget.TextView textView, android.widget.TextView textView2) {
        this.rootView = constraintLayout;
        this.closeBtn = imageView;
        this.givLoading = imageView2;
        this.progressBar = downloadProgressView;
        this.progressValue = textView;
        this.tvLoadingTips = textView2;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.DialogLoadingXiaoTianBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.DialogLoadingXiaoTianBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.dialog_loading_xiao_tian, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.DialogLoadingXiaoTianBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.close_btn;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.close_btn);
        if (imageView != null) {
            i = com.up366.mobile.R.id.giv_loading;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.giv_loading);
            if (imageView2 != null) {
                i = com.up366.mobile.R.id.progress_bar;
                com.up366.mobile.common.views.DownloadProgressView downloadProgressView = (com.up366.mobile.common.views.DownloadProgressView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.progress_bar);
                if (downloadProgressView != null) {
                    i = com.up366.mobile.R.id.progress_value;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.progress_value);
                    if (textView != null) {
                        i = com.up366.mobile.R.id.tv_loading_tips;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_loading_tips);
                        if (textView2 != null) {
                            return new com.up366.mobile.databinding.DialogLoadingXiaoTianBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, imageView2, downloadProgressView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
