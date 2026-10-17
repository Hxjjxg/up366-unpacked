package com.up366.qmui.widget.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIWebViewBridgeHandler {
    private static final java.lang.String MESSAGE_CALLBACK_ID = "callbackId";
    private static final java.lang.String MESSAGE_DATA = "data";
    private static final java.lang.String MESSAGE_JS_FETCH_SCRIPT = "QMUIBridge._fetchQueueFromNative()";
    private static final java.lang.String MESSAGE_JS_RESPONSE_SCRIPT = "QMUIBridge._handleResponseFromNative($data$)";
    private static final java.lang.String MESSAGE_PARAM_HOLDER = "$data$";
    private static final java.lang.String MESSAGE_RESPONSE_ID = "id";
    private java.util.List<android.util.Pair<java.lang.String, android.webkit.ValueCallback<java.lang.String>>> mStartupMessageList = new java.util.ArrayList();
    private android.webkit.WebView mWebView;

    protected abstract org.json.JSONObject handleMessage(java.lang.String str);

    public QMUIWebViewBridgeHandler(android.webkit.WebView webView) {
        this.mWebView = webView;
    }

    public final void evaluateBridgeScript(java.lang.String str, android.webkit.ValueCallback<java.lang.String> valueCallback) {
        java.util.List<android.util.Pair<java.lang.String, android.webkit.ValueCallback<java.lang.String>>> list = this.mStartupMessageList;
        if (list != null) {
            list.add(new android.util.Pair<>(str, valueCallback));
        } else {
            this.mWebView.evaluateJavascript(str, valueCallback);
        }
    }

    void onBridgeLoaded() {
        java.util.List<android.util.Pair<java.lang.String, android.webkit.ValueCallback<java.lang.String>>> list = this.mStartupMessageList;
        if (list != null) {
            for (android.util.Pair<java.lang.String, android.webkit.ValueCallback<java.lang.String>> pair : list) {
                this.mWebView.evaluateJavascript("", null);
            }
            this.mStartupMessageList = null;
        }
    }

    void fetchAndMessageFromJs() {
        this.mWebView.evaluateJavascript(MESSAGE_JS_FETCH_SCRIPT, new android.webkit.ValueCallback<java.lang.String>() { // from class: com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(java.lang.String str) {
                java.lang.String strUnescape = com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.unescape(str);
                if (strUnescape != null) {
                    try {
                        org.json.JSONArray jSONArray = new org.json.JSONArray(strUnescape);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                            java.lang.String string = jSONObject.getString(com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.MESSAGE_CALLBACK_ID);
                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                            org.json.JSONObject jSONObjectHandleMessage = com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.this.handleMessage(jSONObject.getString(com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.MESSAGE_DATA));
                            if (string != null) {
                                jSONObject2.put("id", string);
                                jSONObject2.put(com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.MESSAGE_DATA, jSONObjectHandleMessage);
                                com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.this.mWebView.evaluateJavascript(com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.MESSAGE_JS_RESPONSE_SCRIPT.replace(com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.MESSAGE_PARAM_HOLDER, com.up366.qmui.widget.webview.QMUIWebViewBridgeHandler.escape(jSONObject2.toString())), null);
                            }
                        }
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static java.lang.String unescape(java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        java.lang.String strReplace = str.substring(1, str.length() - 1).replace("\\\\", "\\").replace("\\\"", "\"");
        if (com.igexin.push.core.b.m.equals(strReplace)) {
            return null;
        }
        return strReplace;
    }

    public static java.lang.String escape(java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return "\"null\"";
        }
        return "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }
}
