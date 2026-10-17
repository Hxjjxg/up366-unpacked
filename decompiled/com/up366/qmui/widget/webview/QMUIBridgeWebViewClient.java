package com.up366.qmui.widget.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBridgeWebViewClient extends com.up366.qmui.widget.webview.QMUIWebViewClient {
    public static final java.lang.String QMUI_BRIDGE_HAS_MESSAGE = "qmui://__QUEUE_MESSAGE__";
    public static final java.lang.String QMUI_BRIDGE_JS = "QMUIWebviewBridge.js";
    private com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler mWebViewBridgeHandler;

    public QMUIBridgeWebViewClient(boolean z, boolean z2, com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler qMUIWebViewBridgeHandler) {
        super(z, z2);
        this.mWebViewBridgeHandler = qMUIWebViewBridgeHandler;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        if (str.startsWith(QMUI_BRIDGE_HAS_MESSAGE)) {
            this.mWebViewBridgeHandler.fetchAndMessageFromJs();
            return true;
        }
        return onShouldOverrideUrlLoading(webView, str);
    }

    protected boolean onShouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        if (android.os.Build.VERSION.SDK_INT >= 24 && webResourceRequest.getUrl().toString().startsWith(QMUI_BRIDGE_HAS_MESSAGE)) {
            this.mWebViewBridgeHandler.fetchAndMessageFromJs();
            return true;
        }
        return onShouldOverrideUrlLoading(webView, webResourceRequest);
    }

    protected boolean onShouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.up366.qmui.widget.webview.QMUIWebViewClient, android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, java.lang.String str) throws java.lang.Throwable {
        super.onPageFinished(webView, str);
        java.lang.String strLoadBridgeScript = loadBridgeScript(webView.getContext());
        if (strLoadBridgeScript != null) {
            webView.evaluateJavascript(strLoadBridgeScript, null);
            this.mWebViewBridgeHandler.onBridgeLoaded();
        }
    }

    private static java.lang.String loadBridgeScript(android.content.Context context) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.InputStream inputStreamOpen;
        try {
            inputStreamOpen = context.getAssets().open(QMUI_BRIDGE_JS);
            try {
                try {
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStreamOpen));
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (java.lang.String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        sb.append(line);
                        sb.append("\n");
                    }
                    bufferedReader.close();
                    inputStreamOpen.close();
                    java.lang.String string = sb.toString();
                    com.up366.qmui.util.QMUILangHelper.close(inputStreamOpen);
                    return string;
                } catch (java.lang.Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.up366.qmui.util.QMUILangHelper.close(inputStreamOpen);
                    return null;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.up366.qmui.util.QMUILangHelper.close(inputStreamOpen);
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            inputStreamOpen = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStreamOpen = null;
            com.up366.qmui.util.QMUILangHelper.close(inputStreamOpen);
            throw th;
        }
    }
}
