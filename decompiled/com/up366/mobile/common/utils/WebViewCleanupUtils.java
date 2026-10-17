package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class WebViewCleanupUtils {
    private WebViewCleanupUtils() {
    }

    public static void destroy(android.webkit.WebView webView, java.lang.String... strArr) {
        if (webView == null) {
            return;
        }
        try {
            if (webView instanceof com.up366.mobile.book.webview.StudyPageWebView) {
                ((com.up366.mobile.book.webview.StudyPageWebView) webView).prepareForDestroy(strArr);
            } else {
                removeJavascriptInterfaces(webView, strArr);
            }
            webView.stopLoading();
            webView.onPause();
            webView.loadUrl("about:blank");
            webView.clearHistory();
            webView.clearMatches();
            webView.clearFormData();
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.setDownloadListener(null);
            if (webView.getParent() instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) webView.getParent()).removeView(webView);
            }
            webView.removeAllViews();
            webView.destroy();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("WebViewCleanupUtils destroy error", e);
        }
    }

    private static void removeJavascriptInterfaces(android.webkit.WebView webView, java.lang.String... strArr) {
        if (strArr == null) {
            return;
        }
        for (java.lang.String str : strArr) {
            if (str != null && str.length() != 0) {
                try {
                    webView.removeJavascriptInterface(str);
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.error("WebViewCleanupUtils removeJavascriptInterface error: " + str, e);
                }
            }
        }
    }
}
