package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerActivityGuideBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageButton btnBack;
    public final android.widget.Button btnCancel;
    public final android.widget.Button btnRetry;
    public final android.widget.LinearLayout errorContainer;
    public final android.widget.ImageView errorIcon;
    public final android.widget.ProgressBar loadingView;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final androidx.constraintlayout.widget.ConstraintLayout topBar;
    public final android.widget.TextView tvTitle;
    public final android.webkit.WebView webView;

    private Up366PhotoPickerActivityGuideBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageButton imageButton, android.widget.Button button, android.widget.Button button2, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, android.widget.ProgressBar progressBar, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, android.widget.TextView textView, android.webkit.WebView webView) {
        this.rootView = constraintLayout;
        this.btnBack = imageButton;
        this.btnCancel = button;
        this.btnRetry = button2;
        this.errorContainer = linearLayout;
        this.errorIcon = imageView;
        this.loadingView = progressBar;
        this.topBar = constraintLayout2;
        this.tvTitle = textView;
        this.webView = webView;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityGuideBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityGuideBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_activity_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityGuideBinding bind(android.view.View view) {
        androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById;
        int i = com.up366.photopicker.R.id.btnBack;
        android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = com.up366.photopicker.R.id.btnCancel;
            android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = com.up366.photopicker.R.id.btnRetry;
                android.widget.Button button2 = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = com.up366.photopicker.R.id.errorContainer;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = com.up366.photopicker.R.id.errorIcon;
                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = com.up366.photopicker.R.id.loadingView;
                            android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (progressBar != null && (constraintLayoutFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.up366.photopicker.R.id.topBar))) != null) {
                                i = com.up366.photopicker.R.id.tvTitle;
                                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = com.up366.photopicker.R.id.webView;
                                    android.webkit.WebView webView = (android.webkit.WebView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (webView != null) {
                                        return new com.up366.photopicker.databinding.Up366PhotoPickerActivityGuideBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageButton, button, button2, linearLayout, imageView, progressBar, constraintLayoutFindChildViewById, textView, webView);
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
