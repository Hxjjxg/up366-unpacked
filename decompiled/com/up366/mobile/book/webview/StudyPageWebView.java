package com.up366.mobile.book.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyPageWebView extends android.webkit.WebView {
    private static java.util.Set<java.lang.String> hostSets = new java.util.HashSet();
    private java.lang.String blankPage;
    private com.up366.mobile.book.webview.InjectBridgeHelper bridgeHelper;
    private android.webkit.WebChromeClient chromeClientOutside;
    public android.view.View customView;
    public android.webkit.WebChromeClient.CustomViewCallback customViewCallback;
    private com.up366.mobile.book.webview.DecryptFileHelper decryptFileHelper;
    private java.lang.Runnable delayedOnResumeTask;
    private volatile boolean destroyRequested;
    private java.lang.String emptyPage;
    public com.up366.mobile.book.webview.StudyPageWebView.FullscreenHolder fullscreenContainer;
    boolean hasAnim;
    private float left;
    private int loadTryCount;
    private com.up366.mobile.book.webview.LocalSchemaFileHelper localSchemaFileHelper;
    private android.view.ActionMode.Callback mActionModeCallBack;
    private com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface onFinishedInterface;
    private java.util.concurrent.atomic.AtomicBoolean onResumeSent;
    private volatile boolean pageHasLoaded;
    private java.lang.String pendingUrl;
    private java.util.List<java.lang.String> privacyPageHistory;
    private float top;
    private android.content.BroadcastReceiver unlockReceiver;
    private java.lang.String url;
    private android.view.View video;
    private android.webkit.WebViewClient webViewClientOutside;
    private float webviewScale;

    public interface IOnFinishedInterface {
        void onFinish();
    }

    static /* synthetic */ boolean lambda$initWebView$0(android.view.View view) {
        return true;
    }

    public void setControlsVisible(boolean z) {
    }

    public StudyPageWebView(android.content.Context context) {
        super(context);
        this.hasAnim = true;
        this.pageHasLoaded = false;
        this.url = "null url";
        this.blankPage = "about:blank";
        this.emptyPage = "about:blank";
        this.mActionModeCallBack = new android.view.ActionMode.Callback() { // from class: com.up366.mobile.book.webview.StudyPageWebView.5
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(android.view.ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }
        };
        initWebView(context);
    }

    public StudyPageWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hasAnim = true;
        this.pageHasLoaded = false;
        this.url = "null url";
        this.blankPage = "about:blank";
        this.emptyPage = "about:blank";
        this.mActionModeCallBack = new android.view.ActionMode.Callback() { // from class: com.up366.mobile.book.webview.StudyPageWebView.5
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(android.view.ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                return false;
            }
        };
        initWebView(context);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setHasAnim(boolean z) {
        this.hasAnim = z;
    }

    private void initWebView(android.content.Context context) {
        this.bridgeHelper = new com.up366.mobile.book.webview.InjectBridgeHelper(this);
        this.decryptFileHelper = new com.up366.mobile.book.webview.DecryptFileHelper();
        this.localSchemaFileHelper = new com.up366.mobile.book.webview.LocalSchemaFileHelper();
        super.setWebChromeClient(new android.webkit.WebChromeClient() { // from class: com.up366.mobile.book.webview.StudyPageWebView.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
                if (consoleMessage.messageLevel() == android.webkit.ConsoleMessage.MessageLevel.ERROR) {
                    com.up366.common.log.Logger.error("TAG - StudyPageWebView - onConsoleMessage - " + consoleMessage.messageLevel().name() + " message:" + consoleMessage.message() + " source:" + consoleMessage.sourceId() + " line:" + consoleMessage.lineNumber());
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(android.webkit.WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (com.up366.mobile.book.webview.StudyPageWebView.this.chromeClientOutside != null) {
                    com.up366.mobile.book.webview.StudyPageWebView.this.chromeClientOutside.onProgressChanged(webView, i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
                super.onReceivedTitle(webView, str);
                if (com.up366.mobile.book.webview.StudyPageWebView.this.chromeClientOutside != null) {
                    com.up366.mobile.book.webview.StudyPageWebView.this.chromeClientOutside.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
                com.up366.common.log.Logger.debug("from JS: " + str2);
                return super.onJsAlert(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public android.view.View getVideoLoadingProgressView() {
                android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(com.up366.mobile.book.webview.StudyPageWebView.this.getContext());
                frameLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
                return frameLayout;
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
                com.up366.mobile.book.webview.StudyPageWebView.this.callJSMethod("document.activeElement.blur()");
                showCustomView(view, customViewCallback);
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                com.up366.mobile.book.webview.StudyPageWebView.this.hideCustomView();
            }

            @Override // android.webkit.WebChromeClient
            public android.graphics.Bitmap getDefaultVideoPoster() {
                return android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ALPHA_8);
            }

            private void showCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
                if (com.up366.mobile.book.webview.StudyPageWebView.this.customView != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                com.up366.mobile.book.webview.StudyPageWebView.this.fullscreenContainer = new com.up366.mobile.book.webview.StudyPageWebView.FullscreenHolder(com.up366.mobile.book.webview.StudyPageWebView.this.getContext());
                com.up366.mobile.book.webview.StudyPageWebView.this.fullscreenContainer.addView(view, new android.widget.FrameLayout.LayoutParams(-1, -1));
                ((android.app.Activity) com.up366.mobile.book.webview.StudyPageWebView.this.getContext()).getWindowManager().addView(com.up366.mobile.book.webview.StudyPageWebView.this.fullscreenContainer, new android.view.WindowManager.LayoutParams(99, 1024));
                ((android.app.Activity) com.up366.mobile.book.webview.StudyPageWebView.this.getContext()).setRequestedOrientation(0);
                com.up366.mobile.book.webview.StudyPageWebView.this.customView = view;
                view.setSystemUiVisibility(4102);
                com.up366.mobile.book.webview.StudyPageWebView.this.customViewCallback = customViewCallback;
            }
        });
        addJavascriptInterface(new java.lang.Object() { // from class: com.up366.mobile.book.webview.StudyPageWebView.2
            @android.webkit.JavascriptInterface
            public void exec(int i) {
                if (i == 0) {
                    com.up366.common.log.Logger.warn("TAG - StudyPageWebView - onPageFinished - contentWidth == 0");
                    com.up366.mobile.common.utils.ViewDataInvalidRecord.$("s-o-c-" + com.up366.mobile.book.webview.StudyPageWebView.this.getContext().hashCode()).invalid();
                }
            }
        }, "___get_page_width___");
        super.setWebViewClient(new com.up366.mobile.book.webview.StudyPageWebView.AnonymousClass3(context));
        setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(android.view.View view) {
                return com.up366.mobile.book.webview.StudyPageWebView.lambda$initWebView$0(view);
            }
        });
        android.webkit.WebSettings settings = getSettings();
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setUseWideViewPort(false);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(-1);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptEnabled(true);
        settings.setTextZoom(100);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.webview.StudyPageWebView$3, reason: invalid class name */
    class AnonymousClass3 extends android.webkit.WebViewClient {
        final /* synthetic */ android.content.Context val$context;

        AnonymousClass3(android.content.Context context) {
            this.val$context = context;
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(android.webkit.WebView webView, float f, float f2) {
            super.onScaleChanged(webView, f, f2);
            com.up366.mobile.book.webview.StudyPageWebView.this.webviewScale = f2;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.startLoading();
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.startLoadUrl(str);
            com.up366.mobile.book.webview.StudyPageWebView.this.url = str;
            com.up366.mobile.book.webview.StudyPageWebView.this.pageHasLoaded = false;
            super.onPageStarted(webView, str, bitmap);
            if (com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside != null) {
                com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.endLoadUrl(str, false);
            com.up366.mobile.book.webview.StudyPageWebView.this.bridgeHelper.injectBridgeCode();
            if (com.up366.mobile.book.webview.StudyPageWebView.this.privacyPageHistory != null) {
                com.up366.mobile.book.webview.StudyPageWebView.this.privacyPageHistory.add(str);
            } else if (com.up366.mobile.book.webview.StudyPageWebView.isPrivacyPage(str)) {
                com.up366.mobile.book.webview.StudyPageWebView.this.privacyPageHistory = new java.util.ArrayList();
                com.up366.mobile.book.webview.StudyPageWebView.this.privacyPageHistory.add(str);
            }
            com.up366.mobile.book.webview.StudyPageWebView.this.pageHasLoaded = true;
            if (com.up366.mobile.book.webview.StudyPageWebView.this.getVisibility() != 0) {
                com.up366.mobile.book.webview.StudyPageWebView.this.setVisibility(0);
                if (com.up366.mobile.book.webview.StudyPageWebView.this.hasAnim) {
                    com.up366.mobile.book.webview.StudyPageWebView.this.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this.val$context, com.up366.mobile.R.anim.fade_in_duration300));
                }
            }
            com.up366.mobile.book.webview.StudyPageWebView.this.evaluateJavascript("___get_page_width___.exec(window.innerWidth)", null);
            if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
                com.up366.mobile.book.webview.StudyPageWebView.this.loadUrl("javascript:(function (){document.oncontextmenu = function (e) { e.preventDefault();}})()");
            }
            if (com.up366.mobile.book.webview.StudyPageWebView.this.onFinishedInterface != null && (str.startsWith("file") || str.startsWith("http"))) {
                com.up366.mobile.book.webview.StudyPageWebView.this.onFinishedInterface.onFinish();
            }
            if (com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside != null) {
                com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            try {
                if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
                    java.lang.String host = new java.net.URL(str).getHost();
                    if (!android.text.TextUtils.isEmpty(host) && !com.up366.mobile.book.webview.StudyPageWebView.hostSets.contains(host)) {
                        com.up366.mobile.book.webview.StudyPageWebView.hostSets.add(host);
                        com.up366.mobile.common.onlinelog.OpLog.report("close_pad_request_host", host);
                    }
                    if (!android.text.TextUtils.isEmpty(host) && !host.contains(com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366)) {
                        com.up366.common.log.Logger.warn("TAG - StudyPageWebView - shouldOverrideUrlLoading - block url:" + str);
                        return true;
                    }
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - StudyPageWebView - shouldOverrideUrlLoading - ", e);
            }
            if (com.up366.mobile.book.webview.StudyPageWebView.this.privacyPageHistory != null && !com.up366.mobile.book.webview.StudyPageWebView.this.privacyPageHistory.isEmpty() && com.up366.mobile.book.webview.StudyPageWebView.isPrivacyPage((java.lang.String) com.up366.mobile.book.webview.StudyPageWebView.this.privacyPageHistory.get(0)) && com.up366.mobile.book.webview.StudyPageWebView.this.privacyPageHistory.size() > 1) {
                com.up366.common.log.Logger.warn("TAG - StudyPageWebView - shouldOverrideUrlLoading - privacy block url:" + str);
                return true;
            }
            if (com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside != null && com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            if (str.startsWith("up366mobile://")) {
                com.up366.mobile.jump.JumpIntentUtils.skip(com.up366.mobile.book.webview.StudyPageWebView.this.getContext(), str);
                return true;
            }
            if (str.startsWith("http") || str.startsWith("file")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
            android.net.Uri url = webResourceRequest.getUrl();
            java.lang.String path = url.getPath();
            if ("https://__bridge_loaded__/".equals(url.toString())) {
                com.up366.common.log.Logger.debug("TAG - StudyPageWebView - shouldInterceptRequest - " + url.toString());
                com.up366.mobile.book.webview.StudyPageWebView.this.bridgeHelper.injectBridgeCode();
                return new android.webkit.WebResourceResponse("text/html", "UTF-8", new java.io.ByteArrayInputStream(new byte[0]));
            }
            if (path != null && path.endsWith(".js")) {
                return com.up366.mobile.book.webview.StudyPageWebView.this.decryptFileHelper.getJsWebResourceResponse(path);
            }
            if (path != null && android.text.TextUtils.equals(url.getScheme(), "local")) {
                return com.up366.mobile.book.webview.StudyPageWebView.this.localSchemaFileHelper.getJsWebResourceResponse(path);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(android.webkit.WebView webView, java.lang.String str) {
            super.onLoadResource(webView, str);
            if (com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside != null) {
                com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.endLoadUrl(str2, true);
            com.up366.common.log.Logger.error("TAG - StudyPageWebView - onReceivedError - errorCode = [" + i + "], description = [" + str + "], failingUrl = [" + str2 + "]");
            webView.setBackgroundColor(-1);
            if (com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside != null) {
                com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            com.up366.common.log.Logger.error("TAG - StudyPageWebView - onReceivedError - " + ((java.lang.Object) webResourceError.getDescription()) + " " + webResourceRequest.getUrl());
            if (com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside != null) {
                com.up366.mobile.book.webview.StudyPageWebView.this.webViewClientOutside.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(android.webkit.WebView webView, android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) throws java.lang.Throwable {
            java.lang.String str;
            java.lang.CharSequence charSequence;
            final com.up366.mobile.book.webview.StudyPageWebView.AnonymousClass3 anonymousClass3;
            com.up366.mobile.common.dialog.AppDialog appDialogLeft;
            android.view.View.OnClickListener onClickListener;
            com.alibaba.fastjson.JSONObject jSONObject;
            boolean zIsWebViewCrashEnable = com.up366.mobile.common.logic.Auth.cur().config().isWebViewCrashEnable();
            java.lang.String str2 = com.up366.mobile.common.onlinelog.OpLogData.Control.FOREGROUND;
            str = "crashed";
            if (zIsWebViewCrashEnable) {
                str = renderProcessGoneDetail.didCrash() ? "crashed" : "killed";
                java.lang.String url = webView.getUrl();
                java.lang.String title = webView.getTitle();
                boolean zIsInBackground = com.up366.mobile.common.views.BreakReminderUtils.isInBackground();
                java.lang.Boolean.valueOf(zIsInBackground).getClass();
                java.lang.String str3 = zIsInBackground ? "background" : com.up366.mobile.common.onlinelog.OpLogData.Control.FOREGROUND;
                com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
                com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
                jSONObject3.put("crash_reason", str);
                jSONObject3.put("lifecycle_status", str3);
                jSONObject3.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, url);
                jSONObject3.put("title", title);
                jSONObject2.put("extData", jSONObject3);
                com.up366.common.log.Logger.error("TAG - StudyPageWebView - onRenderProcessGone - 不弹框 - " + url);
                com.up366.mobile.common.onlinelog.ActionLogRecord.record(com.up366.mobile.common.onlinelog.OpLogData.Event.OTHER, getClass().getName(), jSONObject2);
                com.up366.mobile.common.crash.CrashDataManager.getInstance().collectWebViewCrashData(jSONObject3);
                return false;
            }
            try {
                if (!renderProcessGoneDetail.didCrash()) {
                    str = "killed";
                }
                java.lang.String url2 = webView.getUrl();
                java.lang.String title2 = webView.getTitle();
                boolean zIsInBackground2 = com.up366.mobile.common.views.BreakReminderUtils.isInBackground();
                java.lang.Boolean.valueOf(zIsInBackground2).getClass();
                if (zIsInBackground2) {
                    str2 = "background";
                }
                try {
                    jSONObject = new com.alibaba.fastjson.JSONObject();
                } catch (java.lang.Exception unused) {
                    anonymousClass3 = this;
                } catch (java.lang.Throwable th) {
                    th = th;
                    anonymousClass3 = this;
                }
                try {
                    com.alibaba.fastjson.JSONObject jSONObject4 = new com.alibaba.fastjson.JSONObject();
                    jSONObject4.put("crash_reason", str);
                    jSONObject4.put("lifecycle_status", str2);
                    jSONObject4.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, url2);
                    jSONObject4.put("title", title2);
                    jSONObject.put("extData", jSONObject4);
                    com.up366.common.log.Logger.error("TAG - StudyPageWebView - onRenderProcessGone - " + url2);
                    com.up366.mobile.common.onlinelog.ActionLogRecord.record(com.up366.mobile.common.onlinelog.OpLogData.Event.OTHER, getClass().getName(), jSONObject);
                    com.up366.mobile.common.crash.CrashDataManager.getInstance().collectWebViewCrashData(jSONObject4);
                    appDialogLeft = com.up366.mobile.common.dialog.AppDialog.create(com.up366.common.global.GB.get().getCurrentActivity()).title("页面丢失").message("您可以关闭页面，也可以尝试重载页面").setBtnCloseVisibility(8).left("关闭", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            com.up366.mobile.book.webview.StudyPageWebView.AnonymousClass3.lambda$onRenderProcessGone$0(view);
                        }
                    });
                    onClickListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$onRenderProcessGone$2(view);
                        }
                    };
                    charSequence = "重载";
                } catch (java.lang.Exception unused2) {
                    anonymousClass3 = this;
                    charSequence = "重载";
                    try {
                        com.up366.common.log.Logger.error("TAG - StudyPageWebView - onRenderProcessGone - " + com.up366.mobile.book.webview.StudyPageWebView.this.url);
                        appDialogLeft = com.up366.mobile.common.dialog.AppDialog.create(com.up366.common.global.GB.get().getCurrentActivity()).title("页面丢失").message("您可以关闭页面，也可以尝试重载页面").setBtnCloseVisibility(8).left("关闭", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(android.view.View view) {
                                com.up366.mobile.book.webview.StudyPageWebView.AnonymousClass3.lambda$onRenderProcessGone$0(view);
                            }
                        });
                        onClickListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(android.view.View view) {
                                this.f$0.lambda$onRenderProcessGone$2(view);
                            }
                        };
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        com.up366.mobile.common.dialog.AppDialog.create(com.up366.common.global.GB.get().getCurrentActivity()).title("页面丢失").message("您可以关闭页面，也可以尝试重载页面").setBtnCloseVisibility(8).left("关闭", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(android.view.View view) {
                                com.up366.mobile.book.webview.StudyPageWebView.AnonymousClass3.lambda$onRenderProcessGone$0(view);
                            }
                        }).right(charSequence, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(android.view.View view) {
                                this.f$0.lambda$onRenderProcessGone$2(view);
                            }
                        }).show();
                        throw th;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    anonymousClass3 = this;
                    charSequence = "重载";
                    com.up366.mobile.common.dialog.AppDialog.create(com.up366.common.global.GB.get().getCurrentActivity()).title("页面丢失").message("您可以关闭页面，也可以尝试重载页面").setBtnCloseVisibility(8).left("关闭", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            com.up366.mobile.book.webview.StudyPageWebView.AnonymousClass3.lambda$onRenderProcessGone$0(view);
                        }
                    }).right(charSequence, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$onRenderProcessGone$2(view);
                        }
                    }).show();
                    throw th;
                }
            } catch (java.lang.Exception unused3) {
                charSequence = "重载";
                anonymousClass3 = this;
            } catch (java.lang.Throwable th4) {
                th = th4;
                charSequence = "重载";
                anonymousClass3 = this;
            }
            appDialogLeft.right(charSequence, onClickListener).show();
            return true;
        }

        static /* synthetic */ void lambda$onRenderProcessGone$0(android.view.View view) {
            com.up366.common.log.Logger.error("TAG - StudyPageWebView - onRenderProcessGone - AppDialog - Close");
            com.up366.common.global.GB.get().getCurrentActivity().finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRenderProcessGone$2(android.view.View view) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.webview.StudyPageWebView$3$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onRenderProcessGone$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRenderProcessGone$1() throws java.lang.Exception {
            com.up366.common.log.Logger.error("TAG - StudyPageWebView - onRenderProcessGone - AppDialog - Reload");
            com.up366.mobile.book.webview.StudyPageWebView.this.reload();
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(java.lang.String str) {
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView
    public java.lang.String getUrl() {
        try {
            return super.getUrl();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - StudyPageWebView - getUrl - error : ", e);
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cancelPendingOnResume();
        unregisterUnlockReceiver();
        super.onDetachedFromWindow();
    }

    public void prepareForDestroy(java.lang.String... strArr) {
        markDestroyRequested();
        cancelPendingOnResume();
        unregisterUnlockReceiver();
        setOnFinishedInterface(null);
        this.chromeClientOutside = null;
        this.webViewClientOutside = null;
        this.video = null;
        this.pageHasLoaded = false;
        closeFullVideo();
        removeJavascriptInterface("jsObj");
        removeJavascriptInterface("_android_js_obj_");
        if (strArr == null) {
            return;
        }
        for (java.lang.String str : strArr) {
            if (!android.text.TextUtils.isEmpty(str)) {
                removeJavascriptInterface(str);
            }
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        markDestroyRequested();
        super.destroy();
    }

    private void markDestroyRequested() {
        this.destroyRequested = true;
        this.pageHasLoaded = false;
        setOnFinishedInterface(null);
        this.privacyPageHistory = null;
    }

    private boolean shouldSkipJsCall(java.lang.String str) {
        if (!this.destroyRequested) {
            return false;
        }
        com.up366.common.log.Logger.info("skip callJSMethod after destroy: " + str);
        return true;
    }

    public boolean loadUrlInQueue(final java.lang.String str, int i) {
        if (str != null && (str.equals(getUrl()) || str.equals(this.pendingUrl))) {
            com.up366.common.log.Logger.warn("TAG - loadUrlInQueue - 页面重复加载 : " + str);
            return false;
        }
        this.pageHasLoaded = false;
        setVisibility(4);
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            str = "about:blank";
        }
        if ("about:blank".equals(str)) {
            removeJavascriptInterface("jsObj");
            removeJavascriptInterface("_android_js_obj_");
            str = this.emptyPage;
        }
        this.pendingUrl = str;
        com.up366.common.task.TaskUtils.postMainTaskDelay(10L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.webview.StudyPageWebView$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadUrlInQueue$1(str);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadUrlInQueue$1(java.lang.String str) throws java.lang.Exception {
        super.loadUrl(str);
    }

    public boolean isPageHasLoaded() {
        return (!this.pageHasLoaded || this.blankPage.equals(this.url) || this.emptyPage.equals(this.url)) ? false : true;
    }

    public static boolean isPrivacyPage(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return false;
        }
        return str.startsWith(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL)) || str.startsWith(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL)) || str.startsWith("https://beian.miit.gov.cn/");
    }

    public void setVideoContent(android.view.View view) {
        this.video = view;
        this.top = 100.0f;
        this.left = 200.0f;
    }

    public void refreshVideoPosition() {
        onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        android.view.View view = this.video;
        if (view != null) {
            if (view instanceof com.up366.mobile.book.studyviews.view.video.AnswerVideoView) {
                ((com.up366.mobile.book.studyviews.view.video.AnswerVideoView) view).setLeft(this.left - i);
                ((com.up366.mobile.book.studyviews.view.video.AnswerVideoView) this.video).setTop(this.top - i2);
            } else {
                view.setLeft((int) (this.left - i));
                this.video.setTop((int) (this.top - i2));
            }
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(android.webkit.WebChromeClient webChromeClient) {
        this.chromeClientOutside = webChromeClient;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(android.webkit.WebViewClient webViewClient) {
        this.webViewClientOutside = webViewClient;
    }

    public void callJSMethod(java.lang.String str, java.lang.Object... objArr) {
        callJSMethod(java.lang.String.format(str, objArr));
    }

    public void callJSMethod(java.lang.String str) {
        callJSMethodImpl(str, -1, false);
    }

    public void callJSMethodIgnoreBridge(java.lang.String str) {
        callJSMethodImpl(str, -1, true);
    }

    void callJSMethodImpl(final java.lang.String str, final int i, final boolean z) {
        android.app.KeyguardManager keyguardManager;
        final java.lang.String strSubstring = str.length() > 250 ? str.substring(0, 250) : str;
        if (shouldSkipJsCall(strSubstring)) {
            return;
        }
        if (!isPageHasLoaded()) {
            int i2 = this.loadTryCount;
            this.loadTryCount = i2 + 1;
            if (i2 > 5) {
                com.up366.common.log.Logger.info("TAG - 2018/6/21 - StudyPageWebView - callJSMethod - count:" + this.loadTryCount + "  " + str);
                return;
            }
            com.up366.common.log.Logger.info("webview not loaded :  callJSMethod : " + strSubstring + ";");
            java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - 2018/5/29 - StudyPageWebView - callJSMethod - ");
            sb.append(this.url);
            com.up366.common.log.Logger.info(sb.toString());
            postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.book.webview.StudyPageWebView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$callJSMethodImpl$2(strSubstring, z, str);
                }
            }, 800L);
            return;
        }
        this.loadTryCount = 0;
        if (("onResume()".equals(str) || "onResume();;;".equals(str)) && (keyguardManager = (android.app.KeyguardManager) getContext().getSystemService("keyguard")) != null && keyguardManager.isKeyguardLocked()) {
            com.up366.mobile.common.onlinelog.OpLog.record("CallJsKeyguardLocked", "KeyguardLocked-" + str);
            com.up366.common.log.Logger.info("TAG - StudyPageWebView - callJSMethod - (isKeyguardLocked() = true) for " + str);
            java.util.concurrent.atomic.AtomicBoolean atomicBoolean = this.onResumeSent;
            if (atomicBoolean == null) {
                this.onResumeSent = new java.util.concurrent.atomic.AtomicBoolean(false);
            } else {
                atomicBoolean.set(false);
            }
            cancelPendingOnResume();
            registerUnlockReceiver(str, z);
            java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.mobile.book.webview.StudyPageWebView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$callJSMethodImpl$3(str, z);
                }
            };
            this.delayedOnResumeTask = runnable;
            postDelayed(runnable, 300L);
            return;
        }
        post(new java.lang.Runnable() { // from class: com.up366.mobile.book.webview.StudyPageWebView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callJSMethodImpl$4(strSubstring, z, str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callJSMethodImpl$2(java.lang.String str, boolean z, java.lang.String str2) {
        if (shouldSkipJsCall(str)) {
            return;
        }
        if (z) {
            callJSMethodIgnoreBridge(str2);
        } else {
            callJSMethod(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callJSMethodImpl$3(java.lang.String str, boolean z) {
        if (!this.onResumeSent.getAndSet(true)) {
            com.up366.common.log.Logger.info("TAG - Delayed onResume triggered for " + str + " (ignoreBridge: " + z + ")");
            sendOnResumeToJS(str, z);
        }
        unregisterUnlockReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callJSMethodImpl$4(java.lang.String str, boolean z, java.lang.String str2, int i) {
        if (shouldSkipJsCall(str)) {
            return;
        }
        java.lang.String strConvert = z ? str2 : this.bridgeHelper.convert(str2, i);
        java.lang.String[] strArr = {"onPageExchange", "onSubmitTask", "onResume", "onEnterPage", "onHeadsetStateChange", "onPause", "refreshSubCatalog", "onFileUploadPro", "onAudioStateChangeV1", "onCatalogDataChange", "HttpClient", "onAudioStateChange", "onRecordFFTUpdate", "onRecStateChangeV1", "onShareFinished"};
        int i2 = 0;
        while (true) {
            if (i2 >= 15) {
                break;
            }
            java.lang.String str3 = strArr[i2];
            if (strConvert.startsWith(str3)) {
                strConvert = "window." + str3 + "&&" + strConvert;
                break;
            }
            i2++;
        }
        if (shouldSkipJsCall(str)) {
            return;
        }
        evaluateJavascript(strConvert, null);
        java.lang.String url = this.destroyRequested ? "destroyed" : getUrl();
        if (str2.contains("onRecStateChange") || str2.contains("onPause") || str2.contains("onResume")) {
            com.up366.common.log.Logger.info("callJSMethod : " + str + ";" + url);
            return;
        }
        com.up366.common.log.Logger.debug("callJSMethod : " + str + ";" + url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnResumeToJS(java.lang.String str, boolean z) {
        if (z) {
            callJSMethodIgnoreBridge(str);
        } else {
            callJSMethod(str);
        }
    }

    private void registerUnlockReceiver(final java.lang.String str, final boolean z) {
        if (this.unlockReceiver != null) {
            return;
        }
        this.unlockReceiver = new android.content.BroadcastReceiver() { // from class: com.up366.mobile.book.webview.StudyPageWebView.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(android.content.Context context, android.content.Intent intent) {
                if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(intent.getAction())) {
                    com.up366.common.log.Logger.info("TAG - Unlock received, sending " + str);
                    com.up366.mobile.book.webview.StudyPageWebView.this.cancelPendingOnResume();
                    if (com.up366.mobile.book.webview.StudyPageWebView.this.onResumeSent != null && !com.up366.mobile.book.webview.StudyPageWebView.this.onResumeSent.getAndSet(true)) {
                        com.up366.common.log.Logger.info("TAG - Sending onResume to JS: " + str + " (ignoreBridge: " + z + ")");
                        com.up366.mobile.book.webview.StudyPageWebView.this.sendOnResumeToJS(str, z);
                    }
                    com.up366.mobile.book.webview.StudyPageWebView.this.unregisterUnlockReceiver();
                }
            }
        };
        getContext().registerReceiver(this.unlockReceiver, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelPendingOnResume() {
        java.lang.Runnable runnable = this.delayedOnResumeTask;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.delayedOnResumeTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterUnlockReceiver() {
        if (this.unlockReceiver != null) {
            try {
                getContext().unregisterReceiver(this.unlockReceiver);
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("Error unregistering unlock receiver" + e.getMessage());
            }
            this.unlockReceiver = null;
        }
    }

    public void setVideoPosition(int i, int i2) {
        this.left = i;
        this.top = i2;
    }

    public void setOnFinishedInterface(com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface iOnFinishedInterface) {
        this.onFinishedInterface = iOnFinishedInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        java.lang.StringBuilder sb;
        if (this.customView == null || this.fullscreenContainer == null) {
            return;
        }
        android.content.Context context = getContext();
        if (context instanceof android.app.Activity) {
            android.app.Activity activity = (android.app.Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                safeClearFullscreenView();
                return;
            }
            try {
                activity.setRequestedOrientation(1);
                this.fullscreenContainer.removeView(this.customView);
                if (this.fullscreenContainer.getParent() != null) {
                    activity.getWindowManager().removeView(this.fullscreenContainer);
                }
                android.webkit.WebChromeClient.CustomViewCallback customViewCallback = this.customViewCallback;
                if (customViewCallback != null) {
                    try {
                        customViewCallback.onCustomViewHidden();
                    } catch (java.lang.Exception e) {
                        e = e;
                        sb = new java.lang.StringBuilder("hideCustomView  ");
                        sb.append(e.getMessage());
                        com.up366.common.log.Logger.info(sb.toString());
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.up366.common.log.Logger.error("hideCustomView error", th);
                    android.webkit.WebChromeClient.CustomViewCallback customViewCallback2 = this.customViewCallback;
                    if (customViewCallback2 != null) {
                        try {
                            customViewCallback2.onCustomViewHidden();
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            sb = new java.lang.StringBuilder("hideCustomView  ");
                            sb.append(e.getMessage());
                            com.up366.common.log.Logger.info(sb.toString());
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    android.webkit.WebChromeClient.CustomViewCallback customViewCallback3 = this.customViewCallback;
                    if (customViewCallback3 != null) {
                        try {
                            customViewCallback3.onCustomViewHidden();
                        } catch (java.lang.Exception e3) {
                            com.up366.common.log.Logger.info("hideCustomView  " + e3.getMessage());
                        }
                    }
                    safeClearFullscreenView();
                    setVisibility(0);
                    throw th2;
                }
            }
            safeClearFullscreenView();
            setVisibility(0);
        }
    }

    private void safeClearFullscreenView() {
        this.fullscreenContainer = null;
        this.customView = null;
        this.customViewCallback = null;
    }

    public java.lang.String getCurrentDir() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.url)) {
            return null;
        }
        java.lang.String str = this.url;
        if (str.contains("?")) {
            str = str.split("\\?")[0];
        }
        if (str.contains("#")) {
            str = str.split("#")[0];
        }
        return new java.io.File(str.replace("file://", "/")).getParent();
    }

    public java.lang.String getCurrentPageUrl() {
        java.lang.String url = getUrl();
        if (!com.up366.common.StringUtils.isEmptyOrNull(url) && !this.blankPage.equals(url) && !this.emptyPage.equals(url)) {
            return url;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(this.pendingUrl) || this.blankPage.equals(this.pendingUrl) || this.emptyPage.equals(this.pendingUrl)) {
            return null;
        }
        return this.pendingUrl;
    }

    public void closeFullVideo() {
        hideCustomView();
    }

    static class FullscreenHolder extends android.widget.FrameLayout {
        public FullscreenHolder(android.content.Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(android.R.color.black));
        }

        @Override // android.view.View
        public boolean performClick() {
            return super.performClick();
        }

        @Override // android.view.View
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            performClick();
            return true;
        }
    }

    void drawVisible(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
    }

    public void captureAsync(com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener iOnCaptureListener) {
        if (this.webviewScale == 0.0f) {
            this.webviewScale = getScale();
        }
        new com.up366.mobile.book.webview.CaptureHelper().capture(this, this.webviewScale, iOnCaptureListener);
    }

    public com.up366.mobile.book.webview.InjectBridgeHelper getBridgeHelper() {
        return this.bridgeHelper;
    }

    private android.app.Activity findActivity() {
        android.content.Context context = getContext();
        while (context instanceof android.content.ContextWrapper) {
            if (context instanceof android.app.Activity) {
                return (android.app.Activity) context;
            }
            android.content.Context baseContext = ((android.content.ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                break;
            }
            context = baseContext;
        }
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        return null;
    }

    private boolean canStartActionMode() {
        if (this.destroyRequested || getWindowToken() == null) {
            return false;
        }
        android.app.Activity activityFindActivity = findActivity();
        return activityFindActivity == null || !(activityFindActivity.isFinishing() || activityFindActivity.isDestroyed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldFilterProcessTextMenu() {
        java.lang.String lowerCase = android.os.Build.BRAND == null ? "" : android.os.Build.BRAND.toLowerCase(java.util.Locale.ROOT);
        java.lang.String lowerCase2 = android.os.Build.MANUFACTURER != null ? android.os.Build.MANUFACTURER.toLowerCase(java.util.Locale.ROOT) : "";
        return lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_HW) || lowerCase2.contains(com.igexin.assist.util.AssistUtils.BRAND_HW) || lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_HON) || lowerCase2.contains(com.igexin.assist.util.AssistUtils.BRAND_HON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isProcessTextMenuItem(android.view.MenuItem menuItem) {
        android.content.Intent intent;
        return (menuItem == null || (intent = menuItem.getIntent()) == null || !"android.intent.action.PROCESS_TEXT".equals(intent.getAction())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sanitizeActionModeMenu(android.view.Menu menu) {
        if (menu == null || !shouldFilterProcessTextMenu()) {
            return;
        }
        for (int i = 0; i < menu.size(); i++) {
            android.view.MenuItem item = menu.getItem(i);
            if (isProcessTextMenuItem(item)) {
                com.up366.common.log.Logger.warn("TAG - StudyPageWebView - remove process text menu item: " + ((java.lang.Object) item.getTitle()));
                item.setEnabled(false);
                item.setVisible(false);
            }
        }
    }

    private android.view.ActionMode.Callback wrapActionModeCallback(android.view.ActionMode.Callback callback) {
        return (callback == null || callback == this.mActionModeCallBack || (callback instanceof com.up366.mobile.book.webview.StudyPageWebView.SafeActionModeCallback)) ? callback : new com.up366.mobile.book.webview.StudyPageWebView.SafeActionModeCallback(callback);
    }

    private android.view.ActionMode startActionModeSafely(android.view.ActionMode.Callback callback, int i, boolean z) {
        android.view.ActionMode.Callback callbackWrapActionModeCallback = wrapActionModeCallback(callback);
        if (callbackWrapActionModeCallback != null && canStartActionMode()) {
            try {
                if (z) {
                    return super.startActionMode(callbackWrapActionModeCallback, i);
                }
                return super.startActionMode(callbackWrapActionModeCallback);
            } catch (java.lang.RuntimeException e) {
                com.up366.common.log.Logger.error("startActionMode error", e);
            }
        }
        return null;
    }

    @Override // android.view.View
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int i) {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return startActionModeSafely(this.mActionModeCallBack, i, true);
        }
        return startActionModeSafely(callback, i, true);
    }

    @Override // android.view.View
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return startActionModeSafely(this.mActionModeCallBack, 0, false);
        }
        return startActionModeSafely(callback, 0, false);
    }

    private class SafeActionModeCallback implements android.view.ActionMode.Callback {
        private final android.view.ActionMode.Callback delegate;

        SafeActionModeCallback(android.view.ActionMode.Callback callback) {
            this.delegate = callback;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
            boolean zOnCreateActionMode = this.delegate.onCreateActionMode(actionMode, menu);
            com.up366.mobile.book.webview.StudyPageWebView.this.sanitizeActionModeMenu(menu);
            return zOnCreateActionMode;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
            boolean zOnPrepareActionMode = this.delegate.onPrepareActionMode(actionMode, menu);
            com.up366.mobile.book.webview.StudyPageWebView.this.sanitizeActionModeMenu(menu);
            return zOnPrepareActionMode;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
            if (com.up366.mobile.book.webview.StudyPageWebView.this.isProcessTextMenuItem(menuItem) && com.up366.mobile.book.webview.StudyPageWebView.this.shouldFilterProcessTextMenu()) {
                com.up366.common.log.Logger.warn("TAG - StudyPageWebView - block process text click: " + ((java.lang.Object) menuItem.getTitle()));
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(com.up366.mobile.book.webview.StudyPageWebView.this, "当前系统翻译不可用");
                if (actionMode != null) {
                    actionMode.finish();
                }
                return true;
            }
            try {
                return this.delegate.onActionItemClicked(actionMode, menuItem);
            } catch (java.lang.RuntimeException e) {
                if (com.up366.mobile.book.webview.StudyPageWebView.this.isProcessTextMenuItem(menuItem)) {
                    com.up366.common.log.Logger.error("process text action item click error", e);
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo(com.up366.mobile.book.webview.StudyPageWebView.this, "当前系统翻译不可用");
                    if (actionMode != null) {
                        actionMode.finish();
                    }
                    return true;
                }
                throw e;
            }
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(android.view.ActionMode actionMode) {
            this.delegate.onDestroyActionMode(actionMode);
        }
    }
}
