package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerDialogWebviewBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.Button btnCancel;
    public final android.widget.ImageView btnClose;
    public final android.widget.Button btnRetry;
    public final android.widget.FrameLayout contentContainer;
    public final android.widget.LinearLayout errorContainer;
    public final android.widget.ImageView errorIcon;
    public final android.widget.ProgressBar loadingView;
    private final android.widget.FrameLayout rootView;
    public final android.webkit.WebView webView;

    private Up366PhotoPickerDialogWebviewBinding(android.widget.FrameLayout frameLayout, android.widget.Button button, android.widget.ImageView imageView, android.widget.Button button2, android.widget.FrameLayout frameLayout2, android.widget.LinearLayout linearLayout, android.widget.ImageView imageView2, android.widget.ProgressBar progressBar, android.webkit.WebView webView) {
        this.rootView = frameLayout;
        this.btnCancel = button;
        this.btnClose = imageView;
        this.btnRetry = button2;
        this.contentContainer = frameLayout2;
        this.errorContainer = linearLayout;
        this.errorIcon = imageView2;
        this.loadingView = progressBar;
        this.webView = webView;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerDialogWebviewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerDialogWebviewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_dialog_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerDialogWebviewBinding bind(android.view.View view) {
        int i = com.up366.photopicker.R.id.btnCancel;
        android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = com.up366.photopicker.R.id.btnClose;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.up366.photopicker.R.id.btnRetry;
                android.widget.Button button2 = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = com.up366.photopicker.R.id.contentContainer;
                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = com.up366.photopicker.R.id.errorContainer;
                        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = com.up366.photopicker.R.id.errorIcon;
                            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = com.up366.photopicker.R.id.loadingView;
                                android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
                                    i = com.up366.photopicker.R.id.webView;
                                    android.webkit.WebView webView = (android.webkit.WebView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (webView != null) {
                                        return new com.up366.photopicker.databinding.Up366PhotoPickerDialogWebviewBinding((android.widget.FrameLayout) view, button, imageView, button2, frameLayout, linearLayout, imageView2, progressBar, webView);
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
