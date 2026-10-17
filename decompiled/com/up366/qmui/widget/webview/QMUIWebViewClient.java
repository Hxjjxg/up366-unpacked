package com.up366.qmui.widget.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWebViewClient extends android.webkit.WebViewClient {
    public static final int JS_FAKE_KEY_CODE_EVENT = 112;
    private boolean mDisableVideoFullscreenBtnAlways;
    private boolean mIsPageFinished = false;
    private boolean mNeedDispatchSafeAreaInset;

    public QMUIWebViewClient(boolean z, boolean z2) {
        this.mNeedDispatchSafeAreaInset = z;
        this.mDisableVideoFullscreenBtnAlways = z2;
    }

    public void setNeedDispatchSafeAreaInset(com.up366.qmui.widget.webview.QMUIWebView qMUIWebView) {
        if (this.mNeedDispatchSafeAreaInset) {
            return;
        }
        this.mNeedDispatchSafeAreaInset = true;
        if (this.mIsPageFinished) {
            dispatchFullscreenRequestAction(qMUIWebView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        this.mIsPageFinished = false;
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
        super.onPageFinished(webView, str);
        this.mIsPageFinished = true;
        if (this.mDisableVideoFullscreenBtnAlways) {
            runJsCode(webView, getJsCodeForDisableVideoFullscreenBtn(), null);
        }
        if (this.mNeedDispatchSafeAreaInset && (webView instanceof com.up366.qmui.widget.webview.QMUIWebView)) {
            dispatchFullscreenRequestAction((com.up366.qmui.widget.webview.QMUIWebView) webView);
        }
    }

    private java.lang.String getJsCodeForDisableVideoFullscreenBtn() {
        return "(function(){\n   var head = document.getElementsByTagName('head')[0];\n   var style = document.createElement('style');\n   style.type = 'text/css';   style.innerHTML = 'video::-webkit-media-controls-fullscreen-button{display: none !important;}'\n   head.appendChild(style);\n})()";
    }

    private java.lang.String getJsCodeForFullscreenHtml() {
        return "(function(){\n   document.body.addEventListener('keydown', function(e){\n        if(e.keyCode == 112){\n             var html = document.documentElement;\n             var requestFullscreen = html.requestFullscreen || html.webkitRequestFullscreen;\n             requestFullscreen.call(html);\n        }\n    })\n})()";
    }

    private void dispatchFullscreenRequestAction(final com.up366.qmui.widget.webview.QMUIWebView qMUIWebView) {
        if (qMUIWebView.isNotSupportChangeCssEnv()) {
            return;
        }
        if (!this.mDisableVideoFullscreenBtnAlways) {
            runJsCode(qMUIWebView, getJsCodeForDisableVideoFullscreenBtn(), null);
        }
        runJsCode(qMUIWebView, getJsCodeForFullscreenHtml(), new java.lang.Runnable() { // from class: com.up366.qmui.widget.webview.QMUIWebViewClient.1
            @Override // java.lang.Runnable
            public void run() {
                com.up366.qmui.widget.webview.QMUIWebViewClient.this.dispatchFullscreenRequestEvent(qMUIWebView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFullscreenRequestEvent(android.webkit.WebView webView) {
        webView.dispatchKeyEvent(new android.view.KeyEvent(android.os.SystemClock.uptimeMillis(), android.os.SystemClock.uptimeMillis(), 0, 131, 0, 0, -1, 0));
    }

    private void runJsCode(android.webkit.WebView webView, java.lang.String str, final java.lang.Runnable runnable) {
        if (runnable == null) {
            webView.evaluateJavascript(str, null);
        } else {
            webView.evaluateJavascript(str, new android.webkit.ValueCallback<java.lang.String>() { // from class: com.up366.qmui.widget.webview.QMUIWebViewClient.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(java.lang.String str2) {
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.up366.qmui.widget.webview.QMUIWebViewClient$3, reason: invalid class name */
    class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Runnable val$finishAction;

        AnonymousClass3(java.lang.Runnable runnable) {
            this.val$finishAction = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$finishAction.run();
        }
    }
}
