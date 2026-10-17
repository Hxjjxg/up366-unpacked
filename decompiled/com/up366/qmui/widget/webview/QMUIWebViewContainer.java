package com.up366.qmui.widget.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWebViewContainer extends com.up366.qmui.widget.QMUIWindowInsetLayout {
    private com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener mOnScrollChangeListener;
    private com.up366.qmui.widget.webview.QMUIWebView mWebView;

    public QMUIWebViewContainer(android.content.Context context) {
        super(context);
    }

    public QMUIWebViewContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addWebView(com.up366.qmui.widget.webview.QMUIWebView qMUIWebView, boolean z) {
        this.mWebView = qMUIWebView;
        qMUIWebView.setNeedDispatchSafeAreaInset(z);
        this.mWebView.addCustomOnScrollChangeListener(new com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener() { // from class: com.up366.qmui.widget.webview.QMUIWebViewContainer.1
            @Override // com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener
            public void onScrollChange(android.webkit.WebView webView, int i, int i2, int i3, int i4) {
                if (com.up366.qmui.widget.webview.QMUIWebViewContainer.this.mOnScrollChangeListener != null) {
                    com.up366.qmui.widget.webview.QMUIWebViewContainer.this.mOnScrollChangeListener.onScrollChange(webView, i, i2, i3, i4);
                }
            }
        });
        addView(this.mWebView, getWebViewLayoutParams());
    }

    protected android.widget.FrameLayout.LayoutParams getWebViewLayoutParams() {
        return new android.widget.FrameLayout.LayoutParams(-1, -1);
    }

    public void setNeedDispatchSafeAreaInset(boolean z) {
        com.up366.qmui.widget.webview.QMUIWebView qMUIWebView = this.mWebView;
        if (qMUIWebView != null) {
            qMUIWebView.setNeedDispatchSafeAreaInset(z);
        }
    }

    public void destroy() {
        removeView(this.mWebView);
        removeAllViews();
        this.mWebView.setWebChromeClient(null);
        this.mWebView.setWebViewClient(null);
        this.mWebView.destroy();
    }

    public void setCustomOnScrollChangeListener(com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    @Override // com.up366.qmui.widget.QMUIWindowInsetLayout, com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets19(android.graphics.Rect rect) {
        if (getFitsSystemWindows()) {
            android.graphics.Rect rect2 = new android.graphics.Rect(rect);
            this.mQMUIWindowInsetHelper.computeInsets(this, rect2);
            setPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
            return true;
        }
        return super.applySystemWindowInsets19(rect);
    }

    @Override // com.up366.qmui.widget.QMUIWindowInsetLayout, com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets21(java.lang.Object obj) {
        int systemWindowInsetLeft;
        int systemWindowInsetBottom;
        int systemWindowInsetRight;
        int systemWindowInsetTop;
        if (getFitsSystemWindows()) {
            if (obj instanceof androidx.core.view.WindowInsetsCompat) {
                androidx.core.view.WindowInsetsCompat windowInsetsCompat = (androidx.core.view.WindowInsetsCompat) obj;
                systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
                systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
                systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                systemWindowInsetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
            } else if (obj instanceof android.view.WindowInsets) {
                android.view.WindowInsets windowInsets = (android.view.WindowInsets) obj;
                systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
                systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
                systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
                systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
            } else {
                systemWindowInsetLeft = 0;
                systemWindowInsetBottom = 0;
                systemWindowInsetRight = 0;
                systemWindowInsetTop = 0;
            }
            if (com.up366.qmui.util.QMUINotchHelper.needFixLandscapeNotchAreaFitSystemWindow(this) && getResources().getConfiguration().orientation == 2) {
                systemWindowInsetLeft = java.lang.Math.max(systemWindowInsetLeft, com.up366.qmui.util.QMUINotchHelper.getSafeInsetLeft(this));
                systemWindowInsetRight = java.lang.Math.max(systemWindowInsetRight, com.up366.qmui.util.QMUINotchHelper.getSafeInsetRight(this));
            }
            android.graphics.Rect rect = new android.graphics.Rect(systemWindowInsetLeft, systemWindowInsetTop, systemWindowInsetRight, systemWindowInsetBottom);
            this.mQMUIWindowInsetHelper.computeInsets(this, rect);
            setPadding(rect.left, rect.top, rect.right, rect.bottom);
            return true;
        }
        return super.applySystemWindowInsets21(obj);
    }
}
