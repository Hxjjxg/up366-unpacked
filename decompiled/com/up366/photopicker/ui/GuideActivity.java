package com.up366.photopicker.ui;

/* JADX INFO: compiled from: GuideActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0012\u0010 \u001a\u00020\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0012H\u0002J\b\u0010+\u001a\u00020\u001dH\u0016J\u0012\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010.H\u0015J\b\u0010/\u001a\u00020\u001dH\u0014J\b\u00100\u001a\u00020\u001dH\u0014J\b\u00101\u001a\u00020\u001dH\u0014J\b\u00102\u001a\u00020\u001dH\u0002J\u0012\u00103\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u00104\u001a\u0004\u0018\u00010\u00122\b\u00105\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u00106\u001a\u00020\u001dH\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\u0012\u00108\u001a\u00020\u001d2\b\u00105\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u00109\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/up366/photopicker/ui/GuideActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "contentReadyProgress", "", "errorContainer", "Landroid/widget/LinearLayout;", "flowCoordinator", "Lcom/up366/photopicker/ui/GuideWebFlowCoordinator;", "isMainFrameLoading", "", "loadingTimeoutMs", "", "loadingTimeoutRunnable", "Ljava/lang/Runnable;", "loadingView", "Landroid/widget/ProgressBar;", "pendingPageTitle", "", "tag", "titleView", "Landroid/widget/TextView;", "webView", "Landroid/webkit/WebView;", "webViewDialog", "Lcom/up366/photopicker/ui/WebViewDialog;", "canRevealWebContent", "view", "cancelLoadingTimeout", "", "closeGuidePage", "handleLoadingTimeout", "handleMainFrameFailure", "loadGuideUrl", com.up366.mobile.commonui.CommonWebViewActivity.URL, "logDebug", "message", "logError", "throwable", "", "logInfo", "logState", "scene", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "revealWebContent", "safeUrl", "sanitizePageTitle", "title", "showErrorPage", "showLoadingState", "updatePageTitle", "urlIsPreparingBlank", "visibilityToString", "visibility", "Companion", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GuideActivity extends androidx.appcompat.app.AppCompatActivity {
    public static final java.lang.String EXTRA_USE_DIALOG = "useDialog";
    private android.widget.LinearLayout errorContainer;
    private boolean isMainFrameLoading;
    private android.widget.ProgressBar loadingView;
    private java.lang.String pendingPageTitle;
    private android.widget.TextView titleView;
    private android.webkit.WebView webView;
    private com.up366.photopicker.ui.WebViewDialog webViewDialog;
    private final java.lang.String tag = "PhotoPickerGuidePage";
    private final long loadingTimeoutMs = 8000;
    private final int contentReadyProgress = 35;
    private final com.up366.photopicker.ui.GuideWebFlowCoordinator flowCoordinator = new com.up366.photopicker.ui.GuideWebFlowCoordinator();
    private final java.lang.Runnable loadingTimeoutRunnable = new java.lang.Runnable() { // from class: com.up366.photopicker.ui.GuideActivity$$ExternalSyntheticLambda4
        @Override // java.lang.Runnable
        public final void run() {
            com.up366.photopicker.ui.GuideActivity.loadingTimeoutRunnable$lambda$0(this.f$0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadingTimeoutRunnable$lambda$0(com.up366.photopicker.ui.GuideActivity guideActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(guideActivity, "this$0");
        guideActivity.handleLoadingTimeout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_USE_DIALOG, false);
        java.lang.String stringExtra = getIntent().getStringExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.flowCoordinator.resetForLoad(stringExtra);
        logInfo("onCreate, useDialog=" + booleanExtra + ", url=" + stringExtra);
        if (booleanExtra) {
            setContentView(android.R.layout.activity_list_item);
            com.up366.photopicker.ui.WebViewDialog webViewDialog = new com.up366.photopicker.ui.WebViewDialog((android.content.Context) this);
            this.webViewDialog = webViewDialog;
            webViewDialog.loadUrl(stringExtra);
            com.up366.photopicker.ui.WebViewDialog webViewDialog2 = this.webViewDialog;
            if (webViewDialog2 != null) {
                webViewDialog2.show();
                return;
            }
            return;
        }
        setContentView(com.up366.photopicker.R.layout.up366_photo_picker_activity_guide);
        android.view.View viewFindViewById = findViewById(com.up366.photopicker.R.id.webView);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.webView)");
        this.webView = (android.webkit.WebView) viewFindViewById;
        this.titleView = (android.widget.TextView) findViewById(com.up366.photopicker.R.id.tvTitle);
        this.loadingView = (android.widget.ProgressBar) findViewById(com.up366.photopicker.R.id.loadingView);
        this.errorContainer = (android.widget.LinearLayout) findViewById(com.up366.photopicker.R.id.errorContainer);
        android.widget.Button button = (android.widget.Button) findViewById(com.up366.photopicker.R.id.btnRetry);
        android.widget.Button button2 = (android.widget.Button) findViewById(com.up366.photopicker.R.id.btnCancel);
        android.widget.ImageButton imageButton = (android.widget.ImageButton) findViewById(com.up366.photopicker.R.id.btnBack);
        android.webkit.WebView webView = this.webView;
        android.webkit.WebView webView2 = null;
        if (webView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        android.webkit.WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(2);
        settings.setMixedContentMode(2);
        android.webkit.WebView webView3 = this.webView;
        if (webView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.setBackgroundColor(-1);
        android.webkit.WebView webView4 = this.webView;
        if (webView4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        webView4.setOverScrollMode(2);
        try {
            android.webkit.WebView.setWebContentsDebuggingEnabled(true);
        } catch (java.lang.Throwable unused) {
        }
        try {
            android.webkit.WebView webView5 = this.webView;
            if (webView5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView5 = null;
            }
            webView5.setLayerType(2, null);
        } catch (java.lang.Exception e) {
            logError("setLayerType 失败", e);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("WebView settings prepared, mixedContentMode=");
        android.webkit.WebView webView6 = this.webView;
        if (webView6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView6 = null;
        }
        sb.append(webView6.getSettings().getMixedContentMode());
        sb.append(", userAgent=");
        android.webkit.WebView webView7 = this.webView;
        if (webView7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView7 = null;
        }
        sb.append(webView7.getSettings().getUserAgentString());
        logInfo(sb.toString());
        android.webkit.WebView webView8 = this.webView;
        if (webView8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView8 = null;
        }
        webView8.setWebChromeClient(new android.webkit.WebChromeClient() { // from class: com.up366.photopicker.ui.GuideActivity.onCreate.2
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
                if (consoleMessage != null) {
                    com.up366.photopicker.ui.GuideActivity.this.logInfo("console " + consoleMessage.messageLevel() + " line=" + consoleMessage.lineNumber() + " source=" + consoleMessage.sourceId() + " message=" + consoleMessage.message());
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(android.webkit.WebView view, java.lang.String title) {
                super.onReceivedTitle(view, title);
                com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                guideActivity.pendingPageTitle = guideActivity.sanitizePageTitle(title);
                java.lang.String str = com.up366.photopicker.ui.GuideActivity.this.pendingPageTitle;
                if (str == null || str.length() == 0) {
                    return;
                }
                com.up366.photopicker.ui.GuideActivity.this.logInfo("捕获页面标题 title=" + com.up366.photopicker.ui.GuideActivity.this.pendingPageTitle);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(android.webkit.WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("onProgressChanged progress=");
                sb2.append(newProgress);
                sb2.append(", url=");
                sb2.append(com.up366.photopicker.ui.GuideActivity.this.safeUrl(view != null ? view.getUrl() : null));
                sb2.append(", contentHeight=");
                sb2.append(view != null ? java.lang.Integer.valueOf(view.getContentHeight()) : null);
                sb2.append(", blankLoadReason=");
                sb2.append(com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.getBlankLoadReason());
                sb2.append(", hasCommittedVisible=");
                sb2.append(com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.hasCommittedVisible());
                guideActivity.logDebug(sb2.toString());
                if (com.up366.photopicker.ui.GuideActivity.this.isMainFrameLoading) {
                    if (com.up366.photopicker.ui.GuideActivity.this.urlIsPreparingBlank(view != null ? view.getUrl() : null)) {
                        com.up366.photopicker.ui.GuideActivity.this.logDebug("onProgressChanged 忽略预清屏 about:blank");
                    } else if (com.up366.photopicker.ui.GuideActivity.this.canRevealWebContent(view)) {
                        com.up366.photopicker.ui.GuideActivity.this.revealWebContent();
                    }
                }
            }
        });
        android.webkit.WebView webView9 = this.webView;
        if (webView9 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView9 = null;
        }
        webView9.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.up366.photopicker.ui.GuideActivity.onCreate.3
            @Override // android.webkit.WebViewClient
            public void onPageStarted(android.webkit.WebView view, java.lang.String url, android.graphics.Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                com.up366.photopicker.ui.GuideActivity.this.logInfo("onPageStarted, url=" + com.up366.photopicker.ui.GuideActivity.this.safeUrl(url) + ", blankLoadReason=" + com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.getBlankLoadReason());
                if (!com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.onPageStarted(url)) {
                    com.up366.photopicker.ui.GuideActivity.this.logDebug("onPageStarted 忽略预清屏 about:blank");
                } else {
                    com.up366.photopicker.ui.GuideActivity.this.pendingPageTitle = null;
                    com.up366.photopicker.ui.GuideActivity.this.showLoadingState();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(android.webkit.WebView view, java.lang.String url) {
                super.onPageFinished(view, url);
                com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("onPageFinished, url=");
                sb2.append(com.up366.photopicker.ui.GuideActivity.this.safeUrl(url));
                sb2.append(", progress=");
                sb2.append(view != null ? java.lang.Integer.valueOf(view.getProgress()) : null);
                sb2.append(", contentHeight=");
                sb2.append(view != null ? java.lang.Integer.valueOf(view.getContentHeight()) : null);
                sb2.append(", hasMainFrameError=");
                sb2.append(com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.hasMainFrameError());
                sb2.append(", blankLoadReason=");
                sb2.append(com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.getBlankLoadReason());
                guideActivity.logInfo(sb2.toString());
                com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision pageDecisionOnPageFinished = com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.onPageFinished(url, view != null ? view.getUrl() : null, view != null ? view.getProgress() : 0, com.up366.photopicker.ui.GuideActivity.this.contentReadyProgress);
                if (pageDecisionOnPageFinished == com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.SHOW_ERROR) {
                    com.up366.photopicker.ui.GuideActivity.this.showErrorPage();
                    return;
                }
                if (pageDecisionOnPageFinished == com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.WAIT && kotlin.jvm.internal.Intrinsics.areEqual(url, "about:blank")) {
                    com.up366.photopicker.ui.GuideActivity.this.logDebug("onPageFinished 命中预清屏 about:blank，等待真实页面加载");
                } else if (pageDecisionOnPageFinished == com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.REVEAL) {
                    com.up366.photopicker.ui.GuideActivity.this.revealWebContent();
                } else {
                    com.up366.photopicker.ui.GuideActivity.this.logDebug("onPageFinished 不展示内容：等待 commitVisible 或更高加载进度");
                    com.up366.photopicker.ui.GuideActivity.this.logState("onPageFinished 延后展示");
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageCommitVisible(android.webkit.WebView view, java.lang.String url) {
                super.onPageCommitVisible(view, url);
                com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("onPageCommitVisible, url=");
                sb2.append(com.up366.photopicker.ui.GuideActivity.this.safeUrl(url));
                sb2.append(", progress=");
                sb2.append(view != null ? java.lang.Integer.valueOf(view.getProgress()) : null);
                sb2.append(", contentHeight=");
                sb2.append(view != null ? java.lang.Integer.valueOf(view.getContentHeight()) : null);
                guideActivity.logInfo(sb2.toString());
                if (com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.onPageCommitVisible(url, view != null ? view.getUrl() : null, view != null ? view.getProgress() : 0, com.up366.photopicker.ui.GuideActivity.this.contentReadyProgress)) {
                    com.up366.photopicker.ui.GuideActivity.this.revealWebContent();
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, android.webkit.WebResourceRequest request) {
                if (request != null) {
                    com.up366.photopicker.ui.GuideActivity.this.logInfo("shouldOverrideUrlLoading reqUrl=" + request.getUrl() + ", isMainFrame=" + request.isForMainFrame() + ", method=" + request.getMethod());
                }
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView view, android.webkit.WebResourceRequest request, android.webkit.WebResourceError error) {
                if (request != null && request.isForMainFrame()) {
                    com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("页面资源加载失败 reqUrl=");
                    sb2.append(request.getUrl());
                    sb2.append(" error=");
                    sb2.append((java.lang.Object) (error != null ? error.getDescription() : null));
                    guideActivity.logError(sb2.toString());
                    com.up366.photopicker.ui.GuideActivity.this.handleMainFrameFailure(view);
                    return;
                }
                if (request != null) {
                    com.up366.photopicker.ui.GuideActivity.this.logDebug("onReceivedError 子资源失败忽略 reqUrl=" + request.getUrl() + ", isMainFrame=" + request.isForMainFrame());
                }
                super.onReceivedError(view, request, error);
            }

            @Override // android.webkit.WebViewClient
            @kotlin.Deprecated(message = "Deprecated WebView callback retained for old-system compatibility")
            public void onReceivedError(android.webkit.WebView view, int errorCode, java.lang.String description, java.lang.String failingUrl) {
                if (view != null && failingUrl != null && kotlin.jvm.internal.Intrinsics.areEqual(failingUrl, view.getUrl())) {
                    com.up366.photopicker.ui.GuideActivity.this.logError("页面加载失败(deprecated) failingUrl=" + failingUrl + " errorCode=" + errorCode + " description=" + description);
                    com.up366.photopicker.ui.GuideActivity.this.handleMainFrameFailure(view);
                    return;
                }
                com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("onReceivedError(deprecated) 忽略 failingUrl=");
                sb2.append(failingUrl);
                sb2.append(", viewUrl=");
                sb2.append(com.up366.photopicker.ui.GuideActivity.this.safeUrl(view != null ? view.getUrl() : null));
                guideActivity.logDebug(sb2.toString());
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(android.webkit.WebView view, android.webkit.WebResourceRequest request, android.webkit.WebResourceResponse errorResponse) {
                if (request != null && request.isForMainFrame()) {
                    if ((errorResponse != null ? errorResponse.getStatusCode() : 0) >= 400) {
                        com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("页面 Http 资源错误 reqUrl=");
                        sb2.append(request.getUrl());
                        sb2.append(" status=");
                        sb2.append(errorResponse != null ? java.lang.Integer.valueOf(errorResponse.getStatusCode()) : null);
                        guideActivity.logError(sb2.toString());
                        com.up366.photopicker.ui.GuideActivity.this.handleMainFrameFailure(view);
                        return;
                    }
                }
                if (request != null && errorResponse != null) {
                    com.up366.photopicker.ui.GuideActivity.this.logDebug("onReceivedHttpError 子资源错误忽略 reqUrl=" + request.getUrl() + ", status=" + errorResponse.getStatusCode());
                }
                super.onReceivedHttpError(view, request, errorResponse);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(android.webkit.WebView view, android.webkit.SslErrorHandler handler, android.net.http.SslError error) {
                com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("页面 SSL 错误 url=");
                sb2.append(error != null ? error.getUrl() : null);
                guideActivity.logError(sb2.toString());
                if (handler != null) {
                    handler.cancel();
                }
                com.up366.photopicker.ui.GuideActivity.this.handleMainFrameFailure(view);
            }

            @Override // android.webkit.WebViewClient
            public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView view, android.webkit.WebResourceRequest request) {
                if (request != null && request.isForMainFrame()) {
                    com.up366.photopicker.ui.GuideActivity.this.logDebug("shouldInterceptRequest mainFrame reqUrl=" + request.getUrl() + ", hasMainFrameError=" + com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.hasMainFrameError());
                }
                if (request != null && request.isForMainFrame() && com.up366.photopicker.ui.GuideActivity.this.flowCoordinator.hasMainFrameError()) {
                    return new android.webkit.WebResourceResponse(gdut.bsx.share2.ShareContentType.TEXT, "UTF-8", new java.io.ByteArrayInputStream(new byte[0]));
                }
                return super.shouldInterceptRequest(view, request);
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(android.webkit.WebView view, android.webkit.RenderProcessGoneDetail detail) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    com.up366.photopicker.ui.GuideActivity guideActivity = com.up366.photopicker.ui.GuideActivity.this;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("onRenderProcessGone, didCrash=");
                    sb2.append(detail != null ? java.lang.Boolean.valueOf(detail.didCrash()) : null);
                    guideActivity.logError(sb2.toString());
                }
                com.up366.photopicker.ui.GuideActivity.this.handleMainFrameFailure(view);
                return true;
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.GuideActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.GuideActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        button2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.GuideActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.GuideActivity.onCreate$lambda$3(this.f$0, view);
            }
        });
        imageButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.GuideActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.GuideActivity.onCreate$lambda$4(this.f$0, view);
            }
        });
        getOnBackPressedDispatcher().addCallback((androidx.lifecycle.LifecycleOwner) this, new androidx.activity.OnBackPressedCallback() { // from class: com.up366.photopicker.ui.GuideActivity.onCreate.7
            {
                super(true);
            }

            public void handleOnBackPressed() {
                com.up366.photopicker.ui.GuideActivity.this.logInfo("拦截系统返回/侧滑返回");
            }
        });
        if (stringExtra.length() > 0) {
            updatePageTitle(null);
            loadGuideUrl(stringExtra);
            return;
        }
        updatePageTitle(null);
        this.isMainFrameLoading = false;
        android.widget.ProgressBar progressBar = this.loadingView;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        android.widget.LinearLayout linearLayout = this.errorContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        android.webkit.WebView webView10 = this.webView;
        if (webView10 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView10 = null;
        }
        webView10.setVisibility(0);
        android.webkit.WebView webView11 = this.webView;
        if (webView11 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView11;
        }
        webView2.loadData("<html><body><h2>使用说明</h2><p>暂无说明内容</p></body></html>", "text/html", "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(com.up366.photopicker.ui.GuideActivity guideActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(guideActivity, "this$0");
        java.lang.String currentUrl = guideActivity.flowCoordinator.getCurrentUrl();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(currentUrl, "currentUrl");
        if (currentUrl.length() > 0) {
            guideActivity.logInfo("点击重试，重新加载 url=" + currentUrl);
            guideActivity.loadGuideUrl(currentUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(com.up366.photopicker.ui.GuideActivity guideActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(guideActivity, "this$0");
        guideActivity.closeGuidePage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(com.up366.photopicker.ui.GuideActivity guideActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(guideActivity, "this$0");
        guideActivity.closeGuidePage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePageTitle(java.lang.String title) {
        java.lang.String string = title != null ? kotlin.text.StringsKt.trim(title).toString() : null;
        if (string == null) {
            string = "";
        }
        java.lang.String str = string;
        if (str.length() > 0 && !kotlin.jvm.internal.Intrinsics.areEqual(string, "about:blank")) {
            logInfo("更新标题 title=" + string);
        }
        android.widget.TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(str);
        }
        android.widget.TextView textView2 = this.titleView;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility((str.length() <= 0 || kotlin.jvm.internal.Intrinsics.areEqual(string, "about:blank")) ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorPage() {
        logInfo("showErrorPage");
        cancelLoadingTimeout();
        this.pendingPageTitle = null;
        android.webkit.WebView webView = this.webView;
        if (webView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        com.up366.photopicker.ui.GuideWebUiStateHelper.showError(webView, this.loadingView, this.errorContainer);
        updatePageTitle(null);
        logState("展示错误页");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMainFrameFailure(final android.webkit.WebView view) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("handleMainFrameFailure, currentWebUrl=");
        sb.append(safeUrl(view != null ? view.getUrl() : null));
        sb.append(", targetUrl=");
        sb.append(this.flowCoordinator.getCurrentUrl());
        logError(sb.toString());
        this.flowCoordinator.onMainFrameFailure();
        this.isMainFrameLoading = false;
        this.pendingPageTitle = null;
        android.widget.ProgressBar progressBar = this.loadingView;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (view != null) {
            view.post(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.GuideActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.photopicker.ui.GuideActivity.handleMainFrameFailure$lambda$7(this.f$0, view);
                }
            });
        } else {
            showErrorPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMainFrameFailure$lambda$7(com.up366.photopicker.ui.GuideActivity guideActivity, android.webkit.WebView webView) {
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(guideActivity, "this$0");
        try {
            kotlin.Result.Companion companion = kotlin.Result.Companion;
            webView.stopLoading();
            webView.clearCache(true);
            webView.clearHistory();
            obj = kotlin.Result.constructor-impl(kotlin.Unit.INSTANCE);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.Companion;
            obj = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
        }
        java.lang.Throwable th2 = kotlin.Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            guideActivity.logError("handleMainFrameFailure stop/clear 失败", th2);
        }
        guideActivity.showErrorPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.String sanitizePageTitle(java.lang.String title) {
        java.lang.String string = title != null ? kotlin.text.StringsKt.trim(title).toString() : null;
        if (string == null) {
            string = "";
        }
        if (kotlin.text.StringsKt.isBlank(string) || kotlin.jvm.internal.Intrinsics.areEqual(string, "about:blank")) {
            return null;
        }
        java.lang.String lowerCase = string.toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (!kotlin.text.StringsKt.startsWith$default(lowerCase, com.up366.mobile.cloud.PrivateCloudMgr.HTTP, false, 2, (java.lang.Object) null) && !kotlin.text.StringsKt.startsWith$default(lowerCase, "https://", false, 2, (java.lang.Object) null) && !kotlin.text.StringsKt.startsWith$default(lowerCase, "file://", false, 2, (java.lang.Object) null) && !kotlin.text.StringsKt.startsWith$default(lowerCase, "about:", false, 2, (java.lang.Object) null) && !kotlin.text.StringsKt.contains$default(lowerCase, "net::", false, 2, (java.lang.Object) null)) {
            return string;
        }
        logInfo("忽略异常标题 title=" + string);
        return null;
    }

    private final void closeGuidePage() {
        logInfo("通过页面按钮关闭");
        finish();
    }

    private final void loadGuideUrl(java.lang.String url) {
        logInfo("loadGuideUrl, url=" + url);
        android.webkit.WebView webView = this.webView;
        if (webView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        com.up366.photopicker.ui.GuideWebReloadHelper.reload(webView, url, this.flowCoordinator, 120L, true, "loadGuideUrl", new com.up366.photopicker.ui.GuideWebReloadHelper.Hooks() { // from class: com.up366.photopicker.ui.GuideActivity.loadGuideUrl.1
            @Override // com.up366.photopicker.ui.GuideWebReloadHelper.Hooks
            public void onBeforeRealLoad() {
            }

            @Override // com.up366.photopicker.ui.GuideWebReloadHelper.Hooks
            public void onBeforeLoad() {
                com.up366.photopicker.ui.GuideActivity.this.pendingPageTitle = null;
                com.up366.photopicker.ui.GuideActivity.this.showLoadingState();
            }

            @Override // com.up366.photopicker.ui.GuideWebReloadHelper.Hooks
            public void onEmptyUrl() {
                android.webkit.WebView webView2 = null;
                com.up366.photopicker.ui.GuideActivity.this.updatePageTitle(null);
                com.up366.photopicker.ui.GuideActivity.this.isMainFrameLoading = false;
                android.widget.ProgressBar progressBar = com.up366.photopicker.ui.GuideActivity.this.loadingView;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                android.widget.LinearLayout linearLayout = com.up366.photopicker.ui.GuideActivity.this.errorContainer;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                android.webkit.WebView webView3 = com.up366.photopicker.ui.GuideActivity.this.webView;
                if (webView3 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                    webView3 = null;
                }
                webView3.setVisibility(0);
                android.webkit.WebView webView4 = com.up366.photopicker.ui.GuideActivity.this.webView;
                if (webView4 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    webView2 = webView4;
                }
                webView2.loadData("<html><body><h2>使用说明</h2><p>暂无说明内容</p></body></html>", "text/html", "UTF-8");
            }
        }, new com.up366.photopicker.ui.GuideWebLoadScheduler.ProceedChecker() { // from class: com.up366.photopicker.ui.GuideActivity$$ExternalSyntheticLambda3
            @Override // com.up366.photopicker.ui.GuideWebLoadScheduler.ProceedChecker
            public final boolean canProceed() {
                return com.up366.photopicker.ui.GuideActivity.loadGuideUrl$lambda$8(this.f$0);
            }
        }, new com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate() { // from class: com.up366.photopicker.ui.GuideActivity.loadGuideUrl.3
            @Override // com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate
            public void debug(java.lang.String message) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
                com.up366.photopicker.ui.GuideActivity.this.logDebug(message);
            }

            @Override // com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate
            public void error(java.lang.String message, java.lang.Throwable throwable) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(throwable, "throwable");
                com.up366.photopicker.ui.GuideActivity.this.logError(message, throwable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadGuideUrl$lambda$8(com.up366.photopicker.ui.GuideActivity guideActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(guideActivity, "this$0");
        return (guideActivity.isFinishing() || guideActivity.isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingState() {
        logInfo("showLoadingState");
        cancelLoadingTimeout();
        this.isMainFrameLoading = true;
        android.webkit.WebView webView = this.webView;
        if (webView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        com.up366.photopicker.ui.GuideWebUiStateHelper.showLoading(webView, this.loadingView, this.errorContainer);
        android.webkit.WebView webView2 = this.webView;
        if (webView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView2 = null;
        }
        webView2.postDelayed(this.loadingTimeoutRunnable, this.loadingTimeoutMs);
        updatePageTitle(null);
        logState("进入 loading 状态");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void revealWebContent() {
        android.webkit.WebView webView = this.webView;
        android.webkit.WebView webView2 = null;
        if (webView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        if (urlIsPreparingBlank(webView.getUrl())) {
            logDebug("revealWebContent 被拦截：当前是预清屏 about:blank");
            return;
        }
        android.webkit.WebView webView3 = this.webView;
        if (webView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        if (!canRevealWebContent(webView3)) {
            logDebug("revealWebContent 被拦截：页面尚未达到可展示条件");
            logState("reveal 被延后");
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("revealWebContent, url=");
        android.webkit.WebView webView4 = this.webView;
        if (webView4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        sb.append(safeUrl(webView4.getUrl()));
        sb.append(", progress=");
        android.webkit.WebView webView5 = this.webView;
        if (webView5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView5 = null;
        }
        sb.append(webView5.getProgress());
        sb.append(", contentHeight=");
        android.webkit.WebView webView6 = this.webView;
        if (webView6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView6 = null;
        }
        sb.append(webView6.getContentHeight());
        logInfo(sb.toString());
        cancelLoadingTimeout();
        this.isMainFrameLoading = false;
        android.webkit.WebView webView7 = this.webView;
        if (webView7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView7;
        }
        com.up366.photopicker.ui.GuideWebUiStateHelper.showContent(webView2, this.loadingView, this.errorContainer);
        updatePageTitle(this.pendingPageTitle);
        logState("展示 Web 内容");
    }

    private final void handleLoadingTimeout() {
        if (this.flowCoordinator.hasMainFrameError()) {
            logDebug("handleLoadingTimeout 忽略：已经处于错误态");
            return;
        }
        android.webkit.WebView webView = this.webView;
        android.webkit.WebView webView2 = null;
        if (webView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        int progress = webView.getProgress();
        android.webkit.WebView webView3 = this.webView;
        if (webView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        int contentHeight = webView3.getContentHeight();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("加载超时 progress=");
        sb.append(progress);
        sb.append(" contentHeight=");
        sb.append(contentHeight);
        sb.append(", url=");
        android.webkit.WebView webView4 = this.webView;
        if (webView4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        sb.append(safeUrl(webView4.getUrl()));
        sb.append(", lastStartedUrl=");
        sb.append(this.flowCoordinator.getLastPageStartedUrl());
        sb.append(", lastFinishedUrl=");
        sb.append(this.flowCoordinator.getLastPageFinishedUrl());
        logInfo(sb.toString());
        android.webkit.WebView webView5 = this.webView;
        if (webView5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView5;
        }
        if (canRevealWebContent(webView2)) {
            revealWebContent();
        } else {
            showErrorPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canRevealWebContent(android.webkit.WebView view) {
        return view != null && this.flowCoordinator.canReveal(view.getUrl(), view.getProgress(), this.contentReadyProgress);
    }

    private final void cancelLoadingTimeout() {
        logDebug("cancelLoadingTimeout");
        android.webkit.WebView webView = this.webView;
        if (webView != null) {
            if (webView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            webView.removeCallbacks(this.loadingTimeoutRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean urlIsPreparingBlank(java.lang.String url) {
        return this.flowCoordinator.isPreparingBlankUrl(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.String safeUrl(java.lang.String url) {
        return url == null ? com.igexin.push.core.b.m : url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logState(java.lang.String scene) {
        java.lang.String url;
        int progress;
        int contentHeight;
        int visibility;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(scene);
        sb.append(", currentUrl=");
        sb.append(this.flowCoordinator.getCurrentUrl());
        sb.append(", webUrl=");
        android.webkit.WebView webView = this.webView;
        android.webkit.WebView webView2 = null;
        if (webView != null) {
            if (webView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            url = webView.getUrl();
        } else {
            url = null;
        }
        sb.append(safeUrl(url));
        sb.append(", progress=");
        android.webkit.WebView webView3 = this.webView;
        if (webView3 != null) {
            if (webView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView3 = null;
            }
            progress = webView3.getProgress();
        } else {
            progress = -1;
        }
        sb.append(progress);
        sb.append(", contentHeight=");
        android.webkit.WebView webView4 = this.webView;
        if (webView4 != null) {
            if (webView4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView4 = null;
            }
            contentHeight = webView4.getContentHeight();
        } else {
            contentHeight = -1;
        }
        sb.append(contentHeight);
        sb.append(", blankLoadReason=");
        sb.append(this.flowCoordinator.getBlankLoadReason());
        sb.append(", hasMainFrameError=");
        sb.append(this.flowCoordinator.hasMainFrameError());
        sb.append(", hasCommittedVisible=");
        sb.append(this.flowCoordinator.hasCommittedVisible());
        sb.append(", webViewVisibility=");
        android.webkit.WebView webView5 = this.webView;
        if (webView5 != null) {
            if (webView5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                webView2 = webView5;
            }
            visibility = webView2.getVisibility();
        } else {
            visibility = -1;
        }
        sb.append(visibilityToString(visibility));
        sb.append(", loadingVisibility=");
        android.widget.ProgressBar progressBar = this.loadingView;
        sb.append(visibilityToString(progressBar != null ? progressBar.getVisibility() : -1));
        sb.append(", errorVisibility=");
        android.widget.LinearLayout linearLayout = this.errorContainer;
        sb.append(visibilityToString(linearLayout != null ? linearLayout.getVisibility() : -1));
        logDebug(sb.toString());
    }

    private final java.lang.String visibilityToString(int visibility) {
        if (visibility == 0) {
            return "VISIBLE";
        }
        if (visibility == 4) {
            return "INVISIBLE";
        }
        if (visibility == 8) {
            return "GONE";
        }
        return "UNKNOWN(" + visibility + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logDebug(java.lang.String message) {
        android.util.Log.d(this.tag, message);
        try {
            kotlin.Result.Companion companion = kotlin.Result.Companion;
            com.up366.photopicker.ui.GuideActivity guideActivity = this;
            com.up366.common.log.Logger.info(message);
            kotlin.Result.constructor-impl(kotlin.Unit.INSTANCE);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.Companion;
            kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logInfo(java.lang.String message) {
        android.util.Log.i(this.tag, message);
        try {
            kotlin.Result.Companion companion = kotlin.Result.Companion;
            com.up366.photopicker.ui.GuideActivity guideActivity = this;
            com.up366.common.log.Logger.info(message);
            kotlin.Result.constructor-impl(kotlin.Unit.INSTANCE);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.Companion;
            kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logError(java.lang.String message) {
        android.util.Log.e(this.tag, message);
        try {
            kotlin.Result.Companion companion = kotlin.Result.Companion;
            com.up366.photopicker.ui.GuideActivity guideActivity = this;
            com.up366.common.log.Logger.error(message);
            kotlin.Result.constructor-impl(kotlin.Unit.INSTANCE);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.Companion;
            kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logError(java.lang.String message, java.lang.Throwable throwable) {
        java.lang.Object obj;
        android.util.Log.e(this.tag, message, throwable);
        try {
            kotlin.Result.Companion companion = kotlin.Result.Companion;
            com.up366.photopicker.ui.GuideActivity guideActivity = this;
            com.up366.common.log.Logger.error(message, throwable);
            obj = kotlin.Result.constructor-impl(kotlin.Unit.INSTANCE);
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.Companion;
            obj = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
        }
        if (kotlin.Result.exceptionOrNull-impl(obj) != null) {
            try {
                kotlin.Result.Companion companion3 = kotlin.Result.Companion;
                com.up366.photopicker.ui.GuideActivity guideActivity2 = this;
                com.up366.common.log.Logger.error(message + ", throwable=" + throwable);
                kotlin.Result.constructor-impl(kotlin.Unit.INSTANCE);
            } catch (java.lang.Throwable th2) {
                kotlin.Result.Companion companion4 = kotlin.Result.Companion;
                kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th2));
            }
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.webView != null) {
            logInfo("onPause");
            android.webkit.WebView webView = this.webView;
            android.webkit.WebView webView2 = null;
            if (webView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            webView.onPause();
            android.webkit.WebView webView3 = this.webView;
            if (webView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                webView2 = webView3;
            }
            webView2.pauseTimers();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.webView != null) {
            logInfo("onResume");
            android.webkit.WebView webView = this.webView;
            android.webkit.WebView webView2 = null;
            if (webView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            webView.onResume();
            android.webkit.WebView webView3 = this.webView;
            if (webView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                webView2 = webView3;
            }
            webView2.resumeTimers();
        }
    }

    public void onBackPressed() {
        com.up366.photopicker.ui.WebViewDialog webViewDialog = this.webViewDialog;
        if (webViewDialog != null && webViewDialog != null && webViewDialog.isShowing()) {
            com.up366.photopicker.ui.WebViewDialog webViewDialog2 = this.webViewDialog;
            if (webViewDialog2 != null) {
                webViewDialog2.dismiss();
            }
            finish();
            return;
        }
        logInfo("忽略 onBackPressed");
    }

    protected void onDestroy() {
        super.onDestroy();
        cancelLoadingTimeout();
        logInfo("onDestroy");
        com.up366.photopicker.ui.WebViewDialog webViewDialog = this.webViewDialog;
        if (webViewDialog != null) {
            webViewDialog.dismiss();
        }
        this.webViewDialog = null;
    }
}
