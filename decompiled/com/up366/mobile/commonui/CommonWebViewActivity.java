package com.up366.mobile.commonui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonWebViewActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final java.lang.String TITLE_BAR_COLOR = "title-color";
    public static final java.lang.String TITLE_NO_SCROLL = "title_scroll";
    public static final java.lang.String TYPE = "TYPE";
    public static final int TYPE_APP_UPDATE = 3;
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_FEEDBACK = 1;
    public static final int TYPE_NO_TITLE = 4;
    public static final int TYPE_TASK_REPORT = 2;
    public static final java.lang.String URL = "url";
    public static final java.lang.String URL_NAME = "urlName";
    private com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding b;
    private com.up366.mobile.course.task.TaskOpenWrongNoteBookInfo bookInfoStudy;
    private com.up366.mobile.commonui.js.CommonWebJSInterface jsInterface;
    private java.lang.String mUrl;
    private java.lang.String mUrlName;
    private com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private java.lang.String titleBarColor;
    private int type = 0;
    private boolean noTitleScroll = false;
    private boolean noTitle = false;
    private final android.view.View.OnClickListener retryListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.CommonWebViewActivity$$ExternalSyntheticLambda3
        @Override // android.view.View.OnClickListener
        public final void onClick(android.view.View view) {
            this.f$0.lambda$new$1(view);
        }
    };
    android.webkit.WebChromeClient mWebChromeClient = new android.webkit.WebChromeClient() { // from class: com.up366.mobile.commonui.CommonWebViewActivity.2
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(android.webkit.WebView webView, int i) {
            if (i < 100 && com.up366.mobile.commonui.CommonWebViewActivity.this.b.commonWebviewProgressbar.getVisibility() == 8) {
                com.up366.mobile.commonui.CommonWebViewActivity.this.b.commonWebviewProgressbar.setVisibility(0);
            }
            com.up366.mobile.commonui.CommonWebViewActivity.this.b.commonWebviewProgressbar.setProgress(i);
            if (i == 100) {
                com.up366.mobile.commonui.CommonWebViewActivity.this.b.commonWebviewProgressbar.setVisibility(8);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            super.onReceivedTitle(webView, str);
            if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.commonui.CommonWebViewActivity.this.mUrlName)) {
                com.up366.mobile.commonui.CommonWebViewActivity.this.setTitle(str);
            }
            if (com.up366.mobile.commonui.CommonWebViewActivity.this.type == 1) {
                com.up366.mobile.commonui.CommonWebViewActivity.this.setTitle("帮助中心");
            }
        }
    };
    private boolean isError = false;
    android.webkit.WebViewClient mWebViewClient = new android.webkit.WebViewClient() { // from class: com.up366.mobile.commonui.CommonWebViewActivity.3
        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                com.up366.mobile.commonui.CommonWebViewActivity.this.showErrorPage();
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
            if (com.up366.mobile.commonui.CommonWebViewActivity.this.isError) {
                return;
            }
            com.up366.mobile.commonui.CommonWebViewActivity.this.b.emptyStateViewLayout.setVisibility(4);
            com.up366.mobile.commonui.CommonWebViewActivity.this.b.webView.requestLayout();
            com.up366.mobile.commonui.CommonWebViewActivity.this.b.webView.setVisibility(0);
        }
    };
    java.lang.Long exitTime = 0L;

    static /* synthetic */ boolean lambda$initWebView$3(android.view.View view) {
        return true;
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.mUrl) && this.mUrl.equals(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.TAKE_PHOTO_ANSWER_EXAMPLE_URL))) {
            return "smartroom_take_picture_tutorial";
        }
        return super.getCurrentPageName();
    }

    public static void openPhotoAnswerGuideActivity(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
        intent.putExtra(URL, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.TAKE_PHOTO_ANSWER_EXAMPLE_URL));
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(android.view.View view) {
        this.b.emptyStateView.showLoadingState();
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.CommonWebViewActivity$$ExternalSyntheticLambda4
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

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.CommonWebViewActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.common_web_view_activity_layout);
        initIntent();
        initView();
        initWebView();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStart() {
        super.onStart();
        com.up366.mobile.commonui.js.CommonWebJSInterface commonWebJSInterface = this.jsInterface;
        if (commonWebJSInterface != null) {
            commonWebJSInterface.registerHelper.callJsEvent("resume");
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStop() {
        super.onStop();
        com.up366.mobile.commonui.js.CommonWebJSInterface commonWebJSInterface = this.jsInterface;
        if (commonWebJSInterface != null) {
            commonWebJSInterface.registerHelper.callJsEvent("pause");
        }
    }

    private void initIntent() {
        android.content.Intent intent = getIntent();
        this.mUrl = intent.getStringExtra(URL);
        this.mUrlName = intent.getStringExtra(URL_NAME);
        this.type = intent.getIntExtra("TYPE", 0);
        this.titleBarColor = intent.getStringExtra(TITLE_BAR_COLOR);
        this.noTitleScroll = intent.getBooleanExtra(TITLE_NO_SCROLL, false);
        if (com.up366.common.StringUtils.isEmptyOrNull(this.mUrl)) {
            this.mUrl = "http://www.up366.com/";
            com.up366.common.log.Logger.error("mUrl == null");
        } else {
            try {
                java.lang.String strEncode = android.net.Uri.encode(this.mUrl, "#-![.:/,%?&=]");
                this.mUrl = strEncode;
                java.lang.String host = java.net.URI.create(strEncode).getHost();
                if (host != null && host.toLowerCase().contains("weixin.qq.com")) {
                    this.noTitleScroll = true;
                    this.noTitle = true;
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("initIntent error:" + e.getMessage(), e);
            }
        }
        if (this.type == 2) {
            this.bookInfoStudy = (com.up366.mobile.course.task.TaskOpenWrongNoteBookInfo) getIntent().getSerializableExtra("bookInfoStudy");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.b.emptyStateView.showPoorNetStateError(this.retryListener);
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.mUrlName)) {
            setTitle(this.mUrlName);
        } else {
            setTitle("");
        }
        if (this.type == 3) {
            this.b.toolbarLayout.setExpandedTitleColor(-65536);
            this.b.toolbarLayout.setCollapsedTitleTextColor(-65536);
            this.b.title.setTextColor(-65536);
        }
        final java.lang.Runnable runnableBind = new com.up366.mobile.common.helper.AppBarOffsetChangeHelper().with(this.b.appBar, this.b.toolbarLayout).left(this.b.titleBack).bind(this.b.title);
        if (!android.text.TextUtils.isEmpty(this.titleBarColor)) {
            this.b.toolbarLayout.setBackgroundColor(android.graphics.Color.parseColor(this.titleBarColor));
            this.b.toolbar.setBackgroundColor(android.graphics.Color.parseColor(this.titleBarColor));
            getWindow().setStatusBarColor(android.graphics.Color.parseColor(this.titleBarColor));
        }
        if (this.type == 2 || this.noTitleScroll) {
            this.b.appBar.post(new java.lang.Runnable() { // from class: com.up366.mobile.commonui.CommonWebViewActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initView$2(runnableBind);
                }
            });
            runnableBind.run();
        }
        if (this.type == 4) {
            ((android.view.ViewGroup.MarginLayoutParams) this.b.webView.getLayoutParams()).topMargin = com.up366.notchtools.helper.NotchStatusBarUtils.getStatusBarHeight(this);
            this.b.appBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(final java.lang.Runnable runnable) {
        this.b.appBar.setExpanded(false, false);
        runnable.run();
        this.b.appBar.addOnOffsetChangedListener(new com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener() { // from class: com.up366.mobile.commonui.CommonWebViewActivity.1
            int verticalOffset = 0;

            public void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
                if (this.verticalOffset != i) {
                    this.verticalOffset = i;
                    com.up366.mobile.commonui.CommonWebViewActivity.this.b.appBar.setExpanded(false, false);
                    runnable.run();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(java.lang.String str) {
        com.up366.mobile.common.views.MarqueeTextView marqueeTextView = this.b.title;
        if (this.noTitle) {
            str = "";
        }
        marqueeTextView.setText(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initWebView() {
        this.b.webView.getLayoutParams().width = -1;
        this.b.webView.getLayoutParams().height = -1;
        this.b.webView.getSettings().setJavaScriptEnabled(true);
        this.b.webView.getSettings().setSavePassword(false);
        this.b.webView.setWebChromeClient(this.mWebChromeClient);
        this.b.webView.setWebViewClient(this.mWebViewClient);
        if (com.up366.qmui.util.QMUIDeviceHelper.isTablet(this)) {
            this.b.webView.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.mobile.commonui.CommonWebViewActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(android.view.View view) {
                    return com.up366.mobile.commonui.CommonWebViewActivity.lambda$initWebView$3(view);
                }
            });
        }
        this.b.webView.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.up366.mobile.commonui.CommonWebViewActivity$$ExternalSyntheticLambda1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
                this.f$0.lambda$initWebView$4(str, str2, str3, str4, j);
            }
        });
        this.takePhotoHelper = new com.up366.mobile.book.exercise.js.TakePhotoHelper((android.app.Activity) this);
        com.up366.mobile.commonui.js.CommonWebJSInterface commonWebJSInterface = new com.up366.mobile.commonui.js.CommonWebJSInterface(this, this.b.webView, this.takePhotoHelper);
        this.jsInterface = commonWebJSInterface;
        commonWebJSInterface.setBookInfoStudy(this.bookInfoStudy);
        this.b.webView.addJavascriptInterface(this.jsInterface, "jsObj");
        loadUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initWebView$4(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(str));
        if (intent.resolveActivity(getPackageManager()) != null) {
            try {
                startActivity(intent);
                finish();
                return;
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - CommonWebViewActivity - initWebView - startActivity " + e.getMessage(), e);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, "下载失败");
    }

    private void loadUrl() {
        this.b.webView.loadUrlInQueue(this.mUrl, 0);
        this.isError = false;
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        com.up366.mobile.commonui.js.CommonWebJSInterface commonWebJSInterface = this.jsInterface;
        if (commonWebJSInterface != null) {
            commonWebJSInterface.registerHelper.clear();
        }
        this.b.webView.clearCache(true);
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.webView, "jsObj");
        this.jsInterface = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorPage() {
        this.b.webView.setVisibility(4);
        this.isError = true;
        if (this.type == 1) {
            setTitle("帮助中心");
        } else {
            setTitle("");
        }
        this.b.commonWebviewProgressbar.setVisibility(8);
        this.b.emptyStateViewLayout.setVisibility(0);
        this.b.emptyStateView.showPoorNetStateError(this.retryListener);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.PictureLoadEvent pictureLoadEvent) {
        com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper = this.takePhotoHelper;
        if (takePhotoHelper != null) {
            takePhotoHelper.onMessageEvent(pictureLoadEvent);
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.JSGlobalEvent jSGlobalEvent) {
        com.up366.mobile.commonui.js.CommonWebJSInterface commonWebJSInterface = this.jsInterface;
        if (commonWebJSInterface != null) {
            commonWebJSInterface.registerHelper.callJsEvent("message", "(%s)", jSGlobalEvent.getMsg());
        }
    }

    public void onBackPressed() {
        com.up366.mobile.commonui.js.CommonWebJSInterface commonWebJSInterface = this.jsInterface;
        if (commonWebJSInterface != null && commonWebJSInterface.registerHelper.hasRegister("backpressed")) {
            com.up366.common.log.Logger.info("TAG - CommonWebViewActivity - onBackPressed - has CommonWebRegisterHelper.EVENT_ON_BACK_PRESSED");
            this.jsInterface.registerHelper.callJsEvent("backpressed");
            return;
        }
        if (this.b.webView.canGoBack()) {
            this.b.webView.goBack();
            return;
        }
        if (this.type != 3) {
            super.onBackPressed();
            return;
        }
        if (java.lang.System.currentTimeMillis() - this.exitTime.longValue() > 2000) {
            android.widget.Toast.makeText(getApplicationContext(), "再按一次退出应用", 0).show();
            this.exitTime = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
        } else {
            android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(67108864);
            startActivity(intent);
        }
    }
}
