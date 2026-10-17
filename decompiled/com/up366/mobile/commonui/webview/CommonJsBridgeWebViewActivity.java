package com.up366.mobile.commonui.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonJsBridgeWebViewActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.CommonJsbWebviewActivityBinding b;
    private boolean currentLoadingStatus;
    private java.lang.String mUrl;
    private com.up366.mobile.commonui.webview.CommonJSInterface reportJSInterface;
    private java.lang.String title;
    private final android.view.View.OnClickListener retryListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity$$ExternalSyntheticLambda0
        @Override // android.view.View.OnClickListener
        public final void onClick(android.view.View view) {
            this.f$0.lambda$new$1(view);
        }
    };
    private boolean isError = false;
    android.webkit.WebViewClient mWebViewClient = new android.webkit.WebViewClient() { // from class: com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.1
        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.this.showErrorPage();
            }
            com.up366.common.log.Logger.error("commonWebViewError: " + ((java.lang.Object) webResourceError.getDescription()) + " : " + webResourceError.getErrorCode() + " " + webResourceRequest.getUrl());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if (!com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.this.isError) {
                com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.this.b.emptyStateViewLayout.setVisibility(4);
                com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.this.b.webView.requestLayout();
                com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.this.b.webView.setVisibility(0);
                com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.this.b.titleBar.setVisibility(8);
            }
            com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.this.showLoading(false);
        }
    };
    private boolean controlShowLoadingByJs = false;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.mUrl) && this.mUrl.contains("learnCard.html")) {
            return "user_study_card";
        }
        return super.getCurrentPageName();
    }

    public static void open(android.content.Context context, java.lang.String str) {
        open(context, str, null);
    }

    public static void open(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.up366.common.log.Logger.info("TAG - CommonJsBridgeWebViewActivity - open - url = [" + str + "], title = [" + str2 + "]");
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.class);
        intent.putExtra("URL", str);
        if (!android.text.TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(android.view.View view) {
        this.b.emptyStateView.showLoadingState();
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() throws java.lang.Exception {
        this.b.webView.reload();
        this.isError = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.CommonJsbWebviewActivityBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.common_jsb_webview_activity);
        initIntent();
        initView();
        initWebView();
        showLoading(true);
    }

    private void initView() {
        showNetStateError();
        initWebView();
        if (!android.text.TextUtils.isEmpty(this.title)) {
            this.b.titleBar.setTitle(this.title);
        }
        this.b.titleBar.setVisibility(8);
        this.b.titleBar.setOnBackClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        finish();
    }

    private void showNetStateError() {
        this.b.titleBar.setVisibility(0);
        this.b.emptyStateView.showPoorNetStateError(this.retryListener);
    }

    private void initIntent() {
        java.lang.String stringExtra = getIntent().getStringExtra("URL");
        this.mUrl = stringExtra;
        if (stringExtra != null && stringExtra.startsWith(com.up366.mobile.cloud.PrivateCloudMgr.HTTP)) {
            this.mUrl = this.mUrl.replace(com.up366.mobile.cloud.PrivateCloudMgr.HTTP, "https://");
        }
        this.title = getIntent().getStringExtra("title");
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStart() {
        super.onStart();
        this.reportJSInterface.registerHelper.callJsEvent("resume");
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStop() {
        super.onStop();
        this.reportJSInterface.registerHelper.callJsEvent("pause");
    }

    private void initWebView() {
        this.b.webView.setHasAnim(false);
        this.b.webView.getBridgeHelper().setEnable(true);
        this.reportJSInterface = new com.up366.mobile.commonui.webview.CommonJSInterface(this, this.b.webView);
        this.b.webView.removeJavascriptInterface("_android_js_obj_");
        this.b.webView.addJavascriptInterface(this.reportJSInterface, "_android_js_obj_");
        this.b.webView.setWebViewClient(this.mWebViewClient);
        loadUrl();
    }

    private void loadUrl() {
        this.b.webView.loadUrlInQueue(this.mUrl, 0);
        this.isError = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorPage() {
        this.b.webView.setVisibility(4);
        this.isError = true;
        setTitle("");
        this.b.emptyStateViewLayout.setVisibility(0);
        showNetStateError();
    }

    public void hideNavigate(boolean z) {
        this.b.titleBar.setVisibility(z ? 8 : 0);
    }

    public void showLoading(boolean z) {
        showLoading(z, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showLoading(boolean z, boolean z2) {
        if (z2) {
            this.controlShowLoadingByJs = true;
        }
        if (z2 || !this.controlShowLoadingByJs) {
            if (z) {
                if (!this.currentLoadingStatus) {
                    com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "加载中");
                }
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
            }
            this.currentLoadingStatus = z;
        }
    }

    public void onBackPressed() {
        if (this.reportJSInterface.registerHelper.hasRegister("beforegoback")) {
            this.reportJSInterface.registerHelper.callJsEvent("beforegoback");
        } else if (this.b.webView.canGoBack()) {
            this.b.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.mobile.commonui.webview.CommonJSInterface commonJSInterface = this.reportJSInterface;
        if (commonJSInterface != null) {
            commonJSInterface.registerHelper.callJsEvent("beforewebviewdestory");
            this.reportJSInterface.registerHelper.destroy();
        }
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "_android_js_obj_");
        this.reportJSInterface = null;
        super.onDestroy();
    }
}
