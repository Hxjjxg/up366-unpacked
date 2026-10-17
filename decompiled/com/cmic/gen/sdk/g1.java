package com.cmic.gen.sdk;

/* JADX INFO: compiled from: ServerClauseDialog.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class g1 extends android.app.Dialog {
    private android.webkit.WebView a;
    private java.lang.String b;
    private java.lang.String c;
    private android.widget.LinearLayout d;

    /* JADX INFO: compiled from: ServerClauseDialog.java */
    class a implements android.view.View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.cmic.gen.sdk.g1.this.a.stopLoading();
            com.cmic.gen.sdk.g1.this.a();
        }
    }

    /* JADX INFO: compiled from: ServerClauseDialog.java */
    class b implements android.view.View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.cmic.gen.sdk.g1.this.a.stopLoading();
            com.cmic.gen.sdk.g1.this.a();
        }
    }

    /* JADX INFO: compiled from: ServerClauseDialog.java */
    class c extends android.webkit.WebViewClient {
        final /* synthetic */ com.cmic.gen.sdk.view.GenAuthThemeConfig a;

        c(com.cmic.gen.sdk.view.GenAuthThemeConfig genAuthThemeConfig) {
            this.a = genAuthThemeConfig;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if (this.a.isGetWebViewTitle()) {
                ((android.widget.TextView) com.cmic.gen.sdk.g1.this.d.findViewById(1118481).findViewById(3355443)).setText(com.cmic.gen.sdk.g1.this.a.getTitle());
            }
        }
    }

    public g1(android.content.Context context, int i, java.lang.String str, java.lang.String str2) {
        super(context, i);
        try {
            this.c = str;
            this.b = str2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private android.view.ViewGroup c() {
        android.view.View viewFindViewById;
        try {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
            this.d = linearLayout;
            linearLayout.setOrientation(1);
            this.d.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
            com.cmic.gen.sdk.view.GenAuthThemeConfig authThemeConfig = com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(getContext()).getAuthThemeConfig();
            int clauseLayoutResID = authThemeConfig.getClauseLayoutResID();
            java.lang.String str = android.text.TextUtils.isEmpty(this.c) ? com.cmic.gen.sdk.l.g[authThemeConfig.getAppLanguageType()] : this.c;
            if (authThemeConfig.isGetWebViewTitle()) {
                str = "";
            }
            java.lang.String str2 = str;
            if (clauseLayoutResID != -1) {
                java.lang.String clauseLayoutReturnID = authThemeConfig.getClauseLayoutReturnID();
                android.widget.RelativeLayout relativeLayoutA = com.cmic.gen.sdk.r1.a(getContext(), getLayoutInflater().inflate(clauseLayoutResID, (android.view.ViewGroup) this.d, false), 1118481, com.cmic.gen.sdk.z0.c(getContext(), clauseLayoutReturnID), str2, null);
                if (!android.text.TextUtils.isEmpty(clauseLayoutReturnID) && (viewFindViewById = relativeLayoutA.findViewById(com.cmic.gen.sdk.z0.c(getContext(), clauseLayoutReturnID))) != null) {
                    viewFindViewById.setOnClickListener(new com.cmic.gen.sdk.g1.a());
                }
                this.d.addView(relativeLayoutA);
            } else {
                this.d.addView(com.cmic.gen.sdk.r1.a(getContext(), null, 1118481, 2236962, str2, new com.cmic.gen.sdk.g1.b()));
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return this.d;
    }

    private void d() {
        com.cmic.gen.sdk.view.GenAuthThemeConfig authThemeConfig = com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(getContext()).getAuthThemeConfig();
        android.webkit.WebView webView = new android.webkit.WebView(getContext());
        this.a = webView;
        android.webkit.WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setSavePassword(false);
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setDomStorageEnabled(authThemeConfig.getWebStorage());
        settings.setJavaScriptEnabled(true);
        this.d.addView(this.a, new android.widget.LinearLayout.LayoutParams(-1, -1));
        this.a.setWebViewClient(new com.cmic.gen.sdk.g1.c(authThemeConfig));
        this.a.loadUrl(this.b);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        android.webkit.WebView webView = this.a;
        if (webView != null) {
            webView.stopLoading();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.d == null) {
            b();
        }
        if (this.a == null) {
            d();
        }
        super.show();
    }

    public void a() {
        if (this.a.canGoBack()) {
            this.a.goBack();
        } else {
            dismiss();
        }
    }

    protected void b() {
        requestWindowFeature(1);
        getWindow().setFeatureDrawableAlpha(0, 0);
        com.cmic.gen.sdk.view.GenAuthThemeConfig authThemeConfig = com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(getContext()).getAuthThemeConfig();
        if (authThemeConfig.isPrivacyPageFullScreen()) {
            getWindow().setFlags(1024, 1024);
            android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 1);
            }
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().setStatusBarColor(0);
        } else {
            if (authThemeConfig.getStatusBarColor() != 0) {
                getWindow().addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
                getWindow().clearFlags(67108864);
                getWindow().setStatusBarColor(authThemeConfig.getClauseStatusColor());
                getWindow().setNavigationBarColor(authThemeConfig.getStatusBarColor());
            }
            int i = authThemeConfig.isLightColor() ? io.objectbox.model.PropertyFlags.UNSIGNED : 0;
            if (authThemeConfig.isNavHidden()) {
                i |= 4098;
            }
            getWindow().getDecorView().setSystemUiVisibility(i);
        }
        setContentView(c());
    }
}
