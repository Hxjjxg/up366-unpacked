package com.up366.photopicker.ui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class GuideWebUiStateHelper {
    private GuideWebUiStateHelper() {
    }

    public static void showLoading(android.webkit.WebView webView, android.view.View view, android.view.View view2) {
        if (view != null) {
            view.setVisibility(0);
        }
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (webView != null) {
            webView.setVisibility(8);
        }
    }

    public static void showError(android.webkit.WebView webView, android.view.View view, android.view.View view2) {
        if (view != null) {
            view.setVisibility(8);
        }
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (webView != null) {
            webView.setVisibility(8);
        }
    }

    public static void showContent(android.webkit.WebView webView, android.view.View view, android.view.View view2) {
        if (view != null) {
            view.setVisibility(8);
        }
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (webView != null) {
            webView.setVisibility(0);
        }
    }
}
