package com.chuanglan.shanyan_sdk.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CTCCPrivacyProtocolActivity extends android.app.Activity {
    private static final java.lang.String[] m = {"e.189.cn", "wap.cmpassport.com", "auth.wosms.cn", "ms.zzx9.cn"};
    private android.webkit.WebView a;
    private android.widget.TextView b;
    private android.view.View c;
    private android.widget.RelativeLayout d;
    private android.widget.ImageView e;
    private int f;
    private com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig g;
    private android.widget.LinearLayout h;
    private java.lang.Object i;
    private android.content.Context j;
    private java.lang.String k;
    private java.lang.String l;

    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "CTCCPrivacyProtocolActivity onBackInvoked");
            com.chuanglan.shanyan_sdk.view.CTCCPrivacyProtocolActivity.this.b();
        }
    }

    class b implements android.view.View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.chuanglan.shanyan_sdk.view.CTCCPrivacyProtocolActivity.this.b();
        }
    }

    static class c extends android.webkit.WebViewClient {
        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, android.view.KeyEvent keyEvent) {
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            if (com.chuanglan.shanyan_sdk.view.CTCCPrivacyProtocolActivity.b(str)) {
                webView.loadUrl(str);
            } else {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "WebView blocked unsafe redirect url=", str);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "CTCCPrivacyProtocolActivity onBackPressed");
        android.webkit.WebView webView = this.a;
        if (webView == null || !webView.canGoBack()) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "Finish PrivacyProtocolActivity");
            finish();
        } else {
            this.a.goBack();
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "WebView go back");
        }
    }

    private void c() {
        android.content.Intent intent = getIntent();
        this.k = intent.getStringExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        this.l = intent.getStringExtra("title");
    }

    private void d() {
        this.j = getApplicationContext();
        this.f = getResources().getConfiguration().orientation;
        this.g = com.chuanglan.shanyan_sdk.tool.a.b().a();
        this.c = findViewById(com.chuanglan.shanyan_sdk.O.a(this.j).b("shanyan_view_navigationbar_include"));
        this.d = (android.widget.RelativeLayout) findViewById(com.chuanglan.shanyan_sdk.O.a(this.j).b("shanyan_view_navigationbar_back_root"));
        this.b = (android.widget.TextView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.j).b("shanyan_view_navigationbar_title"));
        this.e = (android.widget.ImageView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.j).b("shanyan_view_navigationbar_back"));
        this.a = (android.webkit.WebView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.j).b("shanyan_view_baseweb_webview"));
        this.h = (android.widget.LinearLayout) findViewById(com.chuanglan.shanyan_sdk.O.a(this.j).b("shanyan_view_privacy_layout"));
    }

    private void e() {
        l();
        h();
    }

    private void f() {
        this.d.setOnClickListener(new com.chuanglan.shanyan_sdk.view.CTCCPrivacyProtocolActivity.b());
    }

    private void g() {
        try {
            m();
            a();
            e();
            i();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "CTCCPrivacyProtocolActivity setViews Exception=", e);
        }
    }

    private void h() {
        android.webkit.WebSettings settings = this.a.getSettings();
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(this.k) && this.k.startsWith("file://")) {
            settings.setJavaScriptEnabled(false);
            settings.setAllowFileAccess(true);
        } else {
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (this.g.isViewPortEnabled()) {
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
        }
        settings.setSupportZoom(true);
        settings.setSavePassword(false);
        settings.setBuiltInZoomControls(true);
        settings.setCacheMode(2);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setPluginState(android.webkit.WebSettings.PluginState.ON);
        this.a.setWebViewClient(new com.chuanglan.shanyan_sdk.view.CTCCPrivacyProtocolActivity.c());
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(this.k) && b(this.k)) {
            this.a.loadUrl(this.k);
        } else {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "CTCCPrivacyProtocolActivity blocked unsafe url=", this.k);
        }
    }

    private void i() {
        try {
            if (this.g.isPrivacyBackNavigationEnabled() && com.chuanglan.shanyan_sdk.view.a.a()) {
                this.i = com.chuanglan.shanyan_sdk.view.a.a((android.app.Activity) this, (java.lang.Runnable) new com.chuanglan.shanyan_sdk.view.CTCCPrivacyProtocolActivity.a());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void j() {
        if (this.g.isPrivacyNavReturnImgHidden()) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        if (this.g.getPrivacyNavReturnImgPath() != null) {
            this.e.setImageDrawable(this.g.getPrivacyNavReturnImgPath());
        } else {
            this.e.setImageResource(this.j.getResources().getIdentifier("umcsdk_return_bg", "drawable", com.chuanglan.shanyan_sdk.C0065v.g().c(this.j)));
        }
        com.chuanglan.shanyan_sdk.w0.a(this.j, this.d, this.g.getPrivacyNavReturnBtnOffsetX(), this.g.getPrivacyNavReturnBtnOffsetY(), this.g.getPrivacyNavReturnBtnOffsetRightX(), this.g.getPrivacyReturnBtnWidth(), this.g.getPrivacyReturnBtnHeight(), this.e);
    }

    private void k() {
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(this.l)) {
            this.b.setVisibility(8);
            return;
        }
        this.b.setVisibility(0);
        this.b.setText(this.l);
        this.b.setTextColor(this.g.getPrivacyNavTextColor());
        this.b.setTextSize(this.g.isTextSizeIsdp() ? 1 : 2, this.g.getPrivacyNavTextSize());
        this.b.setTypeface(android.graphics.Typeface.defaultFromStyle(this.g.isPrivacyNavTextBold() ? 1 : 0));
    }

    private void l() {
        if (this.g.isPrivacyNavHidden()) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        this.c.setBackgroundColor(this.g.getPrivacyNavColor());
        if (this.g.isPrivacyNavTransparent()) {
            this.c.getBackground().setAlpha(0);
        }
        k();
        j();
    }

    private void m() {
        com.chuanglan.shanyan_sdk.tool.a aVarB = com.chuanglan.shanyan_sdk.tool.a.b();
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfigA = aVarB.a();
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfigC = aVarB.c();
        if (shanYanUIConfigC == null) {
            shanYanUIConfigC = shanYanUIConfigA;
        }
        if (this.f != 1) {
            shanYanUIConfigA = shanYanUIConfigC;
        }
        this.g = shanYanUIConfigA;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            a(false);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "CTCCPrivacyProtocolActivity finish Exception=", e);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            int i = configuration.orientation;
            com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "configurationChanged", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.f));
            if (this.f != i) {
                this.f = i;
                g();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "CTCCPrivacyProtocolActivity onConfigurationChanged Exception=", e);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (bundle != null) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "recreate and savedInstanceState is not null");
                finish();
                return;
            }
            setContentView(com.chuanglan.shanyan_sdk.O.a(this).c("layout_shanyan_privacy"));
            d();
            c();
            f();
            g();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "CTCCPrivacyProtocolActivity onCreate Exception=", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            java.lang.Object obj = this.i;
            if (obj != null) {
                com.chuanglan.shanyan_sdk.view.a.a(this, obj);
                this.i = null;
            }
            android.webkit.WebView webView = this.a;
            if (webView != null) {
                webView.stopLoading();
                this.a.setWebViewClient(null);
                this.a.destroy();
                this.a = null;
            }
            android.widget.LinearLayout linearLayout = this.h;
            if (linearLayout != null) {
                com.chuanglan.shanyan_sdk.x0.a(linearLayout);
                this.h = null;
            }
            android.view.View view = this.c;
            if (view != null) {
                com.chuanglan.shanyan_sdk.x0.a(view);
                this.c = null;
            }
            android.widget.RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                com.chuanglan.shanyan_sdk.x0.a(relativeLayout);
                this.d = null;
            }
            this.b = null;
            this.e = null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "CTCCPrivacyProtocolActivity onKeyDown");
        b();
        return true;
    }

    private void a(boolean z) {
        java.lang.String privacyEnterAnim = this.g.getPrivacyEnterAnim();
        java.lang.String privacyExitAnim = this.g.getPrivacyExitAnim();
        if (privacyEnterAnim == null && privacyExitAnim == null) {
            if (android.os.Build.VERSION.SDK_INT >= 34) {
                com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(this, !z ? 1 : 0, 0, 0);
                return;
            } else {
                overridePendingTransition(0, 0);
                return;
            }
        }
        int iA = com.chuanglan.shanyan_sdk.O.a(this.j).a(privacyEnterAnim);
        int iA2 = com.chuanglan.shanyan_sdk.O.a(this.j).a(privacyExitAnim);
        if (android.os.Build.VERSION.SDK_INT >= 34) {
            com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(this, !z ? 1 : 0, iA, iA2);
        } else {
            overridePendingTransition(iA, iA2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(java.lang.String str) {
        if (!com.chuanglan.shanyan_sdk.AbstractC0055l.K) {
            return true;
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
            return false;
        }
        if (str.startsWith("file://")) {
            return true;
        }
        try {
            java.lang.String host = android.net.Uri.parse(str).getHost();
            if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(host)) {
                return false;
            }
            for (java.lang.String str2 : m) {
                if (!host.equals(str2)) {
                    if (!host.endsWith("." + str2)) {
                    }
                }
                return true;
            }
            for (java.lang.String str3 : com.chuanglan.shanyan_sdk.AbstractC0055l.L) {
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(str3)) {
                    if (!host.equals(str3)) {
                        if (host.endsWith("." + str3)) {
                        }
                    }
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "isUrlSafe parse Exception=", e);
            return false;
        }
    }

    private void a() {
        com.chuanglan.shanyan_sdk.z0.a(this, this.g.isPrivacyFlagSecureEnable());
        a(true);
        com.chuanglan.shanyan_sdk.z0.b(this, this.g.isPrivacyFullScreen());
        if (!this.g.isPrivacyFullScreen()) {
            com.chuanglan.shanyan_sdk.z0.b(this, this.g);
        }
        com.chuanglan.shanyan_sdk.z0.a(this.h, this.g.isPrivacyFitsSystemWindows());
    }
}
