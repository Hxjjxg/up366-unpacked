package com.up366.photopicker.ui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class WebViewDialog {
    private static final int CONTENT_READY_PROGRESS = 35;
    private static final long LOADING_TIMEOUT_MS = 8000;
    private static final java.lang.String TAG = "PhotoPickerGuideDialog";
    private android.app.Dialog dialog;
    private android.widget.LinearLayout errorContainer;
    private final com.up366.photopicker.ui.GuideWebFlowCoordinator flowCoordinator = new com.up366.photopicker.ui.GuideWebFlowCoordinator();
    private final java.lang.Runnable loadingTimeoutRunnable = new java.lang.Runnable() { // from class: com.up366.photopicker.ui.WebViewDialog$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.handleLoadingTimeout();
        }
    };
    private android.widget.ProgressBar loadingView;
    private android.webkit.WebView webView;

    static /* synthetic */ boolean lambda$new$3(android.view.View view, android.view.MotionEvent motionEvent) {
        return false;
    }

    public WebViewDialog(final android.content.Context context) {
        logInfo("初始化引导弹窗 WebViewDialog");
        this.dialog = new android.app.Dialog(context, android.R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.up366.photopicker.R.layout.up366_photo_picker_dialog_webview, (android.view.ViewGroup) null);
        this.dialog.setContentView(viewInflate);
        android.view.Window window = this.dialog.getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.parseColor("#80000000")));
            try {
                window.getDecorView().setSystemUiVisibility(1280);
                window.addFlags(768);
                if (android.os.Build.VERSION.SDK_INT >= 28) {
                    android.view.WindowManager.LayoutParams attributes = window.getAttributes();
                    com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 1);
                    window.setAttributes(attributes);
                }
                window.setStatusBarColor(0);
            } catch (java.lang.Exception unused) {
            }
        }
        this.webView = (android.webkit.WebView) viewInflate.findViewById(com.up366.photopicker.R.id.webView);
        this.errorContainer = (android.widget.LinearLayout) viewInflate.findViewById(com.up366.photopicker.R.id.errorContainer);
        this.loadingView = (android.widget.ProgressBar) viewInflate.findViewById(com.up366.photopicker.R.id.loadingView);
        logState("初始化完成");
        setupWebView();
        ((android.widget.ImageView) viewInflate.findViewById(com.up366.photopicker.R.id.btnClose)).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.WebViewDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1371lambda$new$0$comup366photopickeruiWebViewDialog(context, view);
            }
        });
        ((android.widget.Button) viewInflate.findViewById(com.up366.photopicker.R.id.btnRetry)).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.WebViewDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1372lambda$new$1$comup366photopickeruiWebViewDialog(view);
            }
        });
        ((android.widget.Button) viewInflate.findViewById(com.up366.photopicker.R.id.btnCancel)).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.WebViewDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1373lambda$new$2$comup366photopickeruiWebViewDialog(view);
            }
        });
        viewInflate.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.photopicker.ui.WebViewDialog$$ExternalSyntheticLambda5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return com.up366.photopicker.ui.WebViewDialog.lambda$new$3(view, motionEvent);
            }
        });
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE.other((android.app.Activity) context, "tutorial_loaded", null, null);
    }

    /* JADX INFO: renamed from: lambda$new$0$com-up366-photopicker-ui-WebViewDialog, reason: not valid java name */
    /* synthetic */ void m1371lambda$new$0$comup366photopickeruiWebViewDialog(android.content.Context context, android.view.View view) {
        dismiss();
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE.click((android.app.Activity) context, "tutorial_close_button", null);
    }

    /* JADX INFO: renamed from: lambda$new$1$com-up366-photopicker-ui-WebViewDialog, reason: not valid java name */
    /* synthetic */ void m1372lambda$new$1$comup366photopickeruiWebViewDialog(android.view.View view) {
        java.lang.String currentUrl = this.flowCoordinator.getCurrentUrl();
        if (currentUrl == null || currentUrl.isEmpty()) {
            return;
        }
        logInfo("点击重试，重新加载 url=" + currentUrl);
        loadUrl(currentUrl);
    }

    /* JADX INFO: renamed from: lambda$new$2$com-up366-photopicker-ui-WebViewDialog, reason: not valid java name */
    /* synthetic */ void m1373lambda$new$2$comup366photopickeruiWebViewDialog(android.view.View view) {
        dismiss();
    }

    private void setupWebView() {
        android.webkit.WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(2);
        settings.setMixedContentMode(2);
        this.webView.setBackgroundColor(-1);
        this.webView.setOverScrollMode(2);
        try {
            android.webkit.WebView.setWebContentsDebuggingEnabled(true);
        } catch (java.lang.Throwable unused) {
        }
        logInfo("WebView settings prepared, mixedContentMode=" + settings.getMixedContentMode() + ", userAgent=" + settings.getUserAgentString());
        this.webView.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.up366.photopicker.ui.WebViewDialog.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                com.up366.photopicker.ui.WebViewDialog.this.logInfo("onPageStarted, url=" + com.up366.photopicker.ui.WebViewDialog.this.safeUrl(str) + ", blankLoadReason=" + com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.getBlankLoadReason());
                if (!com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.onPageStarted(str)) {
                    com.up366.photopicker.ui.WebViewDialog.this.logDebug("onPageStarted 忽略预清屏 about:blank");
                } else {
                    com.up366.photopicker.ui.WebViewDialog.this.showLoadingState();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
                super.onPageFinished(webView, str);
                com.up366.photopicker.ui.WebViewDialog.this.logInfo("onPageFinished, url=" + com.up366.photopicker.ui.WebViewDialog.this.safeUrl(str) + ", progress=" + webView.getProgress() + ", contentHeight=" + webView.getContentHeight() + ", hasMainFrameError=" + com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.hasMainFrameError() + ", blankLoadReason=" + com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.getBlankLoadReason());
                com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision pageDecisionOnPageFinished = com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.onPageFinished(str, webView.getUrl(), webView.getProgress(), 35);
                if (pageDecisionOnPageFinished == com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.SHOW_ERROR) {
                    com.up366.photopicker.ui.WebViewDialog.this.showErrorPage();
                    return;
                }
                if (pageDecisionOnPageFinished == com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.WAIT && "about:blank".equals(str)) {
                    com.up366.photopicker.ui.WebViewDialog.this.logDebug("onPageFinished 命中预清屏 about:blank，等待真实页面加载");
                } else if (pageDecisionOnPageFinished == com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.REVEAL) {
                    com.up366.photopicker.ui.WebViewDialog.this.revealWebContent();
                } else {
                    com.up366.photopicker.ui.WebViewDialog.this.logDebug("onPageFinished 不展示内容：等待 commitVisible 或更高加载进度");
                    com.up366.photopicker.ui.WebViewDialog.this.logState("onPageFinished 延后展示");
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageCommitVisible(android.webkit.WebView webView, java.lang.String str) {
                super.onPageCommitVisible(webView, str);
                com.up366.photopicker.ui.WebViewDialog.this.logInfo("onPageCommitVisible, url=" + com.up366.photopicker.ui.WebViewDialog.this.safeUrl(str) + ", progress=" + webView.getProgress() + ", contentHeight=" + webView.getContentHeight());
                if (com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.onPageCommitVisible(str, webView.getUrl(), webView.getProgress(), 35)) {
                    com.up366.photopicker.ui.WebViewDialog.this.revealWebContent();
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
                if (webResourceRequest != null) {
                    com.up366.photopicker.ui.WebViewDialog.this.logInfo("shouldOverrideUrlLoading reqUrl=" + webResourceRequest.getUrl() + ", isMainFrame=" + webResourceRequest.isForMainFrame() + ", method=" + webResourceRequest.getMethod());
                }
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    com.up366.photopicker.ui.WebViewDialog webViewDialog = com.up366.photopicker.ui.WebViewDialog.this;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("页面资源加载失败 reqUrl=");
                    sb.append(webResourceRequest.getUrl());
                    sb.append(" error=");
                    sb.append(webResourceError != null ? webResourceError.toString() : com.igexin.push.core.b.m);
                    webViewDialog.logError(sb.toString());
                    com.up366.photopicker.ui.WebViewDialog.this.handleMainFrameFailure(webView);
                    return;
                }
                if (webResourceRequest != null) {
                    com.up366.photopicker.ui.WebViewDialog.this.logDebug("onReceivedError 子资源失败忽略 reqUrl=" + webResourceRequest.getUrl() + ", isMainFrame=" + webResourceRequest.isForMainFrame());
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
                if (str2 != null && str2.equals(webView.getUrl())) {
                    com.up366.photopicker.ui.WebViewDialog.this.logError("页面加载失败(deprecated) failingUrl=" + str2 + " viewUrl=" + webView.getUrl() + " errorCode=" + i + " desc=" + str);
                    com.up366.photopicker.ui.WebViewDialog.this.handleMainFrameFailure(webView);
                    return;
                }
                com.up366.photopicker.ui.WebViewDialog webViewDialog = com.up366.photopicker.ui.WebViewDialog.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("onReceivedError(deprecated) 忽略 failingUrl=");
                sb.append(str2);
                sb.append(", viewUrl=");
                sb.append(com.up366.photopicker.ui.WebViewDialog.this.safeUrl(webView != null ? webView.getUrl() : null));
                webViewDialog.logDebug(sb.toString());
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame() && webResourceResponse != null && webResourceResponse.getStatusCode() >= 400) {
                    com.up366.photopicker.ui.WebViewDialog.this.logError("页面 Http 资源错误 reqUrl=" + webResourceRequest.getUrl() + " status=" + webResourceResponse.getStatusCode());
                    com.up366.photopicker.ui.WebViewDialog.this.handleMainFrameFailure(webView);
                    return;
                }
                if (webResourceRequest != null && webResourceResponse != null) {
                    com.up366.photopicker.ui.WebViewDialog.this.logDebug("onReceivedHttpError 子资源错误忽略 reqUrl=" + webResourceRequest.getUrl() + ", status=" + webResourceResponse.getStatusCode());
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
                com.up366.photopicker.ui.WebViewDialog webViewDialog = com.up366.photopicker.ui.WebViewDialog.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("页面 SSL 错误 url=");
                sb.append(sslError != null ? sslError.getUrl() : com.igexin.push.core.b.m);
                webViewDialog.logError(sb.toString());
                if (sslErrorHandler != null) {
                    sslErrorHandler.cancel();
                }
                com.up366.photopicker.ui.WebViewDialog.this.handleMainFrameFailure(webView);
            }

            @Override // android.webkit.WebViewClient
            public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    com.up366.photopicker.ui.WebViewDialog.this.logDebug("shouldInterceptRequest mainFrame reqUrl=" + webResourceRequest.getUrl() + ", hasMainFrameError=" + com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.hasMainFrameError());
                }
                if (webResourceRequest != null && webResourceRequest.isForMainFrame() && com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.hasMainFrameError()) {
                    return new android.webkit.WebResourceResponse(gdut.bsx.share2.ShareContentType.TEXT, "UTF-8", new java.io.ByteArrayInputStream(new byte[0]));
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(android.webkit.WebView webView, android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    com.up366.photopicker.ui.WebViewDialog webViewDialog = com.up366.photopicker.ui.WebViewDialog.this;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("onRenderProcessGone, didCrash=");
                    sb.append(renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash());
                    webViewDialog.logError(sb.toString());
                }
                com.up366.photopicker.ui.WebViewDialog.this.handleMainFrameFailure(webView);
                return true;
            }
        });
        this.webView.setWebChromeClient(new android.webkit.WebChromeClient() { // from class: com.up366.photopicker.ui.WebViewDialog.2
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
                if (consoleMessage != null) {
                    com.up366.photopicker.ui.WebViewDialog.this.logInfo("console " + consoleMessage.messageLevel() + " line=" + consoleMessage.lineNumber() + " source=" + consoleMessage.sourceId() + " message=" + consoleMessage.message());
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(android.webkit.WebView webView, int i) {
                super.onProgressChanged(webView, i);
                com.up366.photopicker.ui.WebViewDialog webViewDialog = com.up366.photopicker.ui.WebViewDialog.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("onProgressChanged progress=");
                sb.append(i);
                sb.append(", url=");
                sb.append(com.up366.photopicker.ui.WebViewDialog.this.safeUrl(webView.getUrl()));
                sb.append(", blankLoadReason=");
                sb.append(com.up366.photopicker.ui.WebViewDialog.this.flowCoordinator.getBlankLoadReason());
                sb.append(", contentHeight=");
                sb.append(webView.getContentHeight());
                sb.append(", webViewVisibility=");
                com.up366.photopicker.ui.WebViewDialog webViewDialog2 = com.up366.photopicker.ui.WebViewDialog.this;
                sb.append(webViewDialog2.visibilityToString(webViewDialog2.webView.getVisibility()));
                webViewDialog.logDebug(sb.toString());
                if (!com.up366.photopicker.ui.WebViewDialog.this.isPreparingBlankPage(webView)) {
                    if (com.up366.photopicker.ui.WebViewDialog.this.canRevealWebContent(webView)) {
                        com.up366.photopicker.ui.WebViewDialog.this.revealWebContent();
                    }
                } else {
                    com.up366.photopicker.ui.WebViewDialog.this.logDebug("onProgressChanged 忽略预清屏 about:blank progress=" + i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingState() {
        logInfo("showLoadingState");
        cancelLoadingTimeout();
        com.up366.photopicker.ui.GuideWebUiStateHelper.showLoading(this.webView, this.loadingView, this.errorContainer);
        this.webView.postDelayed(this.loadingTimeoutRunnable, LOADING_TIMEOUT_MS);
        logState("进入 loading 状态");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void revealWebContent() {
        if (isPreparingBlankPage(this.webView)) {
            logDebug("revealWebContent 被拦截：当前是预清屏 about:blank");
            return;
        }
        if (!canRevealWebContent(this.webView)) {
            logDebug("revealWebContent 被拦截：页面尚未达到可展示条件");
            logState("reveal 被延后");
            return;
        }
        logInfo("revealWebContent, url=" + safeUrl(this.webView.getUrl()) + ", progress=" + this.webView.getProgress() + ", contentHeight=" + this.webView.getContentHeight());
        cancelLoadingTimeout();
        if (!this.flowCoordinator.hasMainFrameError()) {
            com.up366.photopicker.ui.GuideWebUiStateHelper.showContent(this.webView, this.loadingView, this.errorContainer);
        }
        logState("展示 Web 内容");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelLoadingTimeout() {
        logDebug("cancelLoadingTimeout");
        this.webView.removeCallbacks(this.loadingTimeoutRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadingTimeout() {
        if (this.flowCoordinator.hasMainFrameError()) {
            logDebug("handleLoadingTimeout 忽略：已经处于错误态");
            return;
        }
        logInfo("加载超时 progress=" + this.webView.getProgress() + " contentHeight=" + this.webView.getContentHeight() + ", url=" + safeUrl(this.webView.getUrl()) + ", lastStartedUrl=" + this.flowCoordinator.getLastPageStartedUrl() + ", lastFinishedUrl=" + this.flowCoordinator.getLastPageFinishedUrl());
        if (canRevealWebContent(this.webView)) {
            revealWebContent();
        } else {
            showErrorPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canRevealWebContent(android.webkit.WebView webView) {
        return webView != null && this.flowCoordinator.canReveal(webView.getUrl(), webView.getProgress(), 35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorPage() {
        logInfo("showErrorPage");
        cancelLoadingTimeout();
        com.up366.photopicker.ui.GuideWebUiStateHelper.showError(this.webView, this.loadingView, this.errorContainer);
        logState("展示错误页");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMainFrameFailure(final android.webkit.WebView webView) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("handleMainFrameFailure, currentWebUrl=");
        sb.append(safeUrl(webView != null ? webView.getUrl() : null));
        sb.append(", targetUrl=");
        sb.append(this.flowCoordinator.getCurrentUrl());
        logError(sb.toString());
        this.flowCoordinator.onMainFrameFailure();
        cancelLoadingTimeout();
        this.loadingView.setVisibility(8);
        if (webView == null) {
            showErrorPage();
        } else {
            webView.post(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.WebViewDialog$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1370xf4e2394f(webView);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$handleMainFrameFailure$4$com-up366-photopicker-ui-WebViewDialog, reason: not valid java name */
    /* synthetic */ void m1370xf4e2394f(android.webkit.WebView webView) {
        try {
            webView.stopLoading();
            webView.clearCache(true);
            webView.clearHistory();
        } catch (java.lang.Exception e) {
            logError("handleMainFrameFailure stop/clear 失败", e);
        }
        showErrorPage();
    }

    public void loadUrl(java.lang.String str) {
        logInfo("loadUrl, url=" + str);
        com.up366.photopicker.ui.GuideWebReloadHelper.reload(this.webView, str, this.flowCoordinator, 150L, true, "dialog.loadUrl", new com.up366.photopicker.ui.GuideWebReloadHelper.Hooks() { // from class: com.up366.photopicker.ui.WebViewDialog.3
            @Override // com.up366.photopicker.ui.GuideWebReloadHelper.Hooks
            public void onBeforeRealLoad() {
            }

            @Override // com.up366.photopicker.ui.GuideWebReloadHelper.Hooks
            public void onBeforeLoad() {
                com.up366.photopicker.ui.WebViewDialog.this.showLoadingState();
            }

            @Override // com.up366.photopicker.ui.GuideWebReloadHelper.Hooks
            public void onEmptyUrl() {
                com.up366.photopicker.ui.WebViewDialog.this.cancelLoadingTimeout();
                com.up366.photopicker.ui.WebViewDialog.this.webView.setVisibility(0);
                com.up366.photopicker.ui.WebViewDialog.this.errorContainer.setVisibility(8);
                com.up366.photopicker.ui.WebViewDialog.this.loadingView.setVisibility(8);
                com.up366.photopicker.ui.WebViewDialog.this.webView.loadData("<html><body><h2>使用说明</h2><p>暂无说明内容</p></body></html>", "text/html", "UTF-8");
                com.up366.photopicker.ui.WebViewDialog.this.logState("loadUrl 空地址，展示默认说明");
            }
        }, null, new com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate() { // from class: com.up366.photopicker.ui.WebViewDialog.4
            @Override // com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate
            public void debug(java.lang.String str2) {
                com.up366.photopicker.ui.WebViewDialog.this.logDebug(str2);
            }

            @Override // com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate
            public void error(java.lang.String str2, java.lang.Throwable th) {
                com.up366.photopicker.ui.WebViewDialog.this.logError(str2, th);
            }
        });
    }

    public void show() {
        if (this.dialog.isShowing()) {
            return;
        }
        logInfo("show dialog");
        this.dialog.show();
        logState("dialog.show 之后");
    }

    public void dismiss() {
        if (this.dialog.isShowing()) {
            logInfo("dismiss dialog");
            cancelLoadingTimeout();
            this.dialog.dismiss();
        }
    }

    public boolean isShowing() {
        return this.dialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPreparingBlankPage(android.webkit.WebView webView) {
        return webView != null && this.flowCoordinator.isPreparingBlankUrl(webView.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logState(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(", currentUrl=");
        sb.append(this.flowCoordinator.getCurrentUrl());
        sb.append(", webUrl=");
        android.webkit.WebView webView = this.webView;
        sb.append(safeUrl(webView != null ? webView.getUrl() : null));
        sb.append(", progress=");
        android.webkit.WebView webView2 = this.webView;
        sb.append(webView2 != null ? webView2.getProgress() : -1);
        sb.append(", contentHeight=");
        android.webkit.WebView webView3 = this.webView;
        sb.append(webView3 != null ? webView3.getContentHeight() : -1);
        sb.append(", blankLoadReason=");
        sb.append(this.flowCoordinator.getBlankLoadReason());
        sb.append(", hasMainFrameError=");
        sb.append(this.flowCoordinator.hasMainFrameError());
        sb.append(", hasCommittedVisible=");
        sb.append(this.flowCoordinator.hasCommittedVisible());
        sb.append(", webViewVisibility=");
        android.webkit.WebView webView4 = this.webView;
        sb.append(visibilityToString(webView4 != null ? webView4.getVisibility() : -1));
        sb.append(", loadingVisibility=");
        android.widget.ProgressBar progressBar = this.loadingView;
        sb.append(visibilityToString(progressBar != null ? progressBar.getVisibility() : -1));
        sb.append(", errorVisibility=");
        android.widget.LinearLayout linearLayout = this.errorContainer;
        sb.append(visibilityToString(linearLayout != null ? linearLayout.getVisibility() : -1));
        logDebug(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String safeUrl(java.lang.String str) {
        return str == null ? com.igexin.push.core.b.m : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String visibilityToString(int i) {
        if (i == 0) {
            return "VISIBLE";
        }
        if (i == 4) {
            return "INVISIBLE";
        }
        if (i == 8) {
            return "GONE";
        }
        return "UNKNOWN(" + i + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logDebug(java.lang.String str) {
        android.util.Log.d(TAG, str);
        try {
            com.up366.common.log.Logger.info(str);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logInfo(java.lang.String str) {
        android.util.Log.i(TAG, str);
        try {
            com.up366.common.log.Logger.info(str);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logError(java.lang.String str) {
        android.util.Log.e(TAG, str);
        try {
            com.up366.common.log.Logger.error(str);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logError(java.lang.String str, java.lang.Throwable th) {
        android.util.Log.e(TAG, str, th);
        try {
            try {
                com.up366.common.log.Logger.error(str, th);
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
            com.up366.common.log.Logger.error(str + ", throwable=" + th);
        }
    }
}
