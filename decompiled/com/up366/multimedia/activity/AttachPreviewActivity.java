package com.up366.multimedia.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AttachPreviewActivity extends android.app.Activity {
    protected android.app.ProgressDialog progressDialog = null;
    private android.webkit.WebView webView;

    static /* synthetic */ boolean lambda$initWebView$1(android.view.View view) {
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.afollestad.materialcamera.R.layout.media_attachment_preview_activity);
        java.lang.String stringExtra = getIntent().getStringExtra("previewUrl");
        ((android.widget.TextView) findViewById(com.afollestad.materialcamera.R.id.title_tv)).setText(getIntent().getStringExtra("title"));
        this.webView = (android.webkit.WebView) findViewById(com.afollestad.materialcamera.R.id.att_webview);
        initWebView();
        this.webView.loadUrl(stringExtra);
        findViewById(com.afollestad.materialcamera.R.id.back).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.activity.AttachPreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1326x153fa915(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-up366-multimedia-activity-AttachPreviewActivity, reason: not valid java name */
    /* synthetic */ void m1326x153fa915(android.view.View view) {
        finish();
    }

    private void initWebView() {
        this.webView.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.up366.multimedia.activity.AttachPreviewActivity.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(android.webkit.WebView view, java.lang.String url, android.graphics.Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                com.up366.multimedia.activity.AttachPreviewActivity.this.showProgressDialog();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView view, android.webkit.WebResourceRequest request, android.webkit.WebResourceError error) {
                super.onReceivedError(view, request, error);
                android.widget.Toast.makeText(view.getContext(), "加载失败", 1).show();
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(android.webkit.WebView view, java.lang.String url) {
                super.onPageFinished(view, url);
                if (com.up366.multimedia.activity.AttachPreviewActivity.this.getString(com.afollestad.materialcamera.R.string.blank_webview).equals(url)) {
                    com.up366.multimedia.activity.AttachPreviewActivity.this.webView.loadDataWithBaseURL("" + java.lang.Math.random(), com.up366.multimedia.activity.AttachPreviewActivity.this.getHtml(), "text/html", "UTF-8", null);
                }
                com.up366.multimedia.activity.AttachPreviewActivity.this.dismissProgressDilog();
            }
        });
        this.webView.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.multimedia.activity.AttachPreviewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(android.view.View view) {
                return com.up366.multimedia.activity.AttachPreviewActivity.lambda$initWebView$1(view);
            }
        });
        android.webkit.WebSettings settings = this.webView.getSettings();
        settings.setUseWideViewPort(false);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(false);
        settings.setDefaultTextEncodingName(com.igexin.push.g.s.b);
        settings.setJavaScriptEnabled(true);
        settings.setTextZoom(100);
        settings.setSavePassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getHtml() {
        return "<!DOCTYPE html><head><title>错误页面</title></head><body style='background: #eeeeee;'><div style='text-align: center;maggin;margin-top:  100px;font-size: 20px;' >未获取到内容！</div></body></html>";
    }

    protected void initDefaultProgressDialog() {
        if (this.progressDialog == null) {
            android.app.ProgressDialog progressDialog = new android.app.ProgressDialog(this);
            this.progressDialog = progressDialog;
            progressDialog.setMessage("请等待...");
        }
    }

    protected void showProgressDialog() {
        initDefaultProgressDialog();
        if (this.progressDialog.isShowing()) {
            return;
        }
        this.progressDialog.show();
    }

    protected void dismissProgressDilog() {
        android.app.ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
    }
}
