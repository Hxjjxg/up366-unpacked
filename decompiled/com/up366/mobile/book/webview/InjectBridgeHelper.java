package com.up366.mobile.book.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class InjectBridgeHelper {
    private static java.lang.String bridgeCode;
    private int asyncResultUniqueId;
    private int clientCallbackUniqueId;
    private boolean documentStartBridgeInstallAttempted;
    private boolean documentStartBridgeInstalled;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;
    private boolean enable = false;
    private android.util.SparseArray<com.up366.mobile.book.webview.InjectBridgeHelper.IJSCallback> callbackMap = new android.util.SparseArray<>();

    interface IJSCallback {
        void onResult(java.lang.String str);
    }

    public InjectBridgeHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        this.webView = studyPageWebView;
    }

    public void setEnable(boolean z) {
        this.enable = z;
        if (z) {
            installDocumentStartBridgeIfSupported();
        }
    }

    java.lang.String convert(java.lang.String str, int i) {
        if (!this.enable) {
            return str;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("clientCallbackUniqueId", java.lang.Integer.valueOf(i));
        jSONObject.put("jsFunc", str);
        return java.lang.String.format("window.WebViewJavascriptBridge._callJsFuncWithResult(%s)", jSONObject.toString());
    }

    void injectBridgeCode() {
        if (this.enable) {
            try {
                final java.lang.String bridgeCode2 = getBridgeCode();
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.webview.InjectBridgeHelper$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$injectBridgeCode$0(bridgeCode2);
                    }
                });
            } catch (java.io.IOException e) {
                com.up366.common.log.Logger.error("InjectBridgeHelper injectBridgeCode: inject error : ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$injectBridgeCode$0(java.lang.String str) throws java.lang.Exception {
        this.webView.evaluateJavascript(str, null);
        com.up366.common.log.Logger.info("TAG - InjectBridgeHelper - injectBridgeCode - inject over! length : " + str.length());
    }

    private void installDocumentStartBridgeIfSupported() {
        if (this.documentStartBridgeInstalled || this.documentStartBridgeInstallAttempted) {
            return;
        }
        this.documentStartBridgeInstallAttempted = true;
        try {
            if (!androidx.webkit.WebViewFeature.isFeatureSupported("DOCUMENT_START_SCRIPT")) {
                com.up366.common.log.Logger.info("TAG - InjectBridgeHelper - document start bridge not supported");
                return;
            }
            java.lang.String bridgeCode2 = getBridgeCode();
            androidx.webkit.WebViewCompat.addDocumentStartJavaScript(this.webView, bridgeCode2, java.util.Collections.singleton("*"));
            this.documentStartBridgeInstalled = true;
            com.up366.common.log.Logger.info("TAG - InjectBridgeHelper - document start bridge installed! length : " + bridgeCode2.length());
        } catch (java.io.IOException | java.lang.LinkageError | java.lang.RuntimeException e) {
            com.up366.common.log.Logger.error("InjectBridgeHelper installDocumentStartBridgeIfSupported: inject error : ", e);
        }
    }

    private java.lang.String getBridgeCode() throws java.io.IOException {
        if (bridgeCode == null) {
            java.io.InputStream inputStreamOpen = this.webView.getContext().getAssets().open("WebViewJavascriptBridge.js");
            byte[] bArr = new byte[inputStreamOpen.available()];
            com.up366.common.log.Logger.info("TAG - InjectBridgeHelper - getBridgeCode: read count : " + inputStreamOpen.read(bArr));
            inputStreamOpen.close();
            bridgeCode = new java.lang.String(bArr, java.nio.charset.StandardCharsets.UTF_8);
        }
        return bridgeCode;
    }

    public void callJSMethod(java.lang.String str, com.up366.mobile.book.webview.InjectBridgeHelper.IJSCallback iJSCallback, java.lang.Object... objArr) {
        this.webView.callJSMethodImpl(java.lang.String.format(str, objArr), buildClientCallbackUniqueId(iJSCallback), false);
    }

    private int buildClientCallbackUniqueId(com.up366.mobile.book.webview.InjectBridgeHelper.IJSCallback iJSCallback) {
        int i = this.clientCallbackUniqueId + 1;
        this.clientCallbackUniqueId = i;
        this.callbackMap.put(i, iJSCallback);
        return this.clientCallbackUniqueId;
    }

    public void responseAsyncResult(final java.lang.String str, final java.lang.Object obj) {
        this.webView.post(new java.lang.Runnable() { // from class: com.up366.mobile.book.webview.InjectBridgeHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$responseAsyncResult$1(str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$responseAsyncResult$1(java.lang.String str, java.lang.Object obj) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("key", str);
        jSONObject.put("data", obj);
        this.webView.evaluateJavascript(java.lang.String.format("window.WebViewJavascriptBridge._onAsyncFuncResult(%s)", jSONObject.toString()), null);
    }

    public void onResponseData(int i, java.lang.String str) {
        com.up366.mobile.book.webview.InjectBridgeHelper.IJSCallback iJSCallback = this.callbackMap.get(i);
        if (iJSCallback != null) {
            this.callbackMap.remove(i);
            iJSCallback.onResult(str);
        }
    }

    public java.lang.String getAsyncUniqueKey() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("async_callback_key_");
        int i = this.asyncResultUniqueId;
        this.asyncResultUniqueId = i + 1;
        sb.append(i);
        return sb.toString();
    }
}
