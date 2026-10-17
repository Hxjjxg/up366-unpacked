package com.up366.qmui.widget.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWebView extends android.webkit.WebView implements com.up366.qmui.widget.IWindowInsetLayout {
    private static final java.lang.String TAG = "QMUIWebView";
    private static boolean sIsReflectionOccurError;
    private java.lang.Object mAwContents;
    private com.up366.qmui.widget.webview.QMUIWebView.Callback mCallback;
    private boolean mNeedDispatchSafeAreaInset;
    private java.util.List<com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener> mOnScrollChangeListeners;
    private android.graphics.Rect mSafeAreaRectCache;
    private java.lang.reflect.Method mSetDisplayCutoutSafeAreaMethod;
    private java.lang.Object mWebContents;
    private com.up366.qmui.util.QMUIWindowInsetHelper mWindowInsetHelper;

    public interface Callback {
        void onSureNotSupportChangeCssEnv();
    }

    public interface OnScrollChangeListener {
        void onScrollChange(android.webkit.WebView webView, int i, int i2, int i3, int i4);
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets19(android.graphics.Rect rect) {
        return false;
    }

    protected int getExtraInsetBottom(float f) {
        return 0;
    }

    protected int getExtraInsetLeft(float f) {
        return 0;
    }

    protected int getExtraInsetRight(float f) {
        return 0;
    }

    protected int getExtraInsetTop(float f) {
        return 0;
    }

    public QMUIWebView(android.content.Context context) {
        super(context);
        this.mNeedDispatchSafeAreaInset = false;
        this.mOnScrollChangeListeners = new java.util.ArrayList();
        init();
    }

    public QMUIWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNeedDispatchSafeAreaInset = false;
        this.mOnScrollChangeListeners = new java.util.ArrayList();
        init();
    }

    public QMUIWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNeedDispatchSafeAreaInset = false;
        this.mOnScrollChangeListeners = new java.util.ArrayList();
        init();
    }

    private void init() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.mWindowInsetHelper = new com.up366.qmui.util.QMUIWindowInsetHelper(this, this);
    }

    @java.lang.Deprecated
    public void setCustomOnScrollChangeListener(com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener onScrollChangeListener) {
        addCustomOnScrollChangeListener(onScrollChangeListener);
    }

    public void addCustomOnScrollChangeListener(com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener onScrollChangeListener) {
        if (this.mOnScrollChangeListeners.contains(onScrollChangeListener)) {
            return;
        }
        this.mOnScrollChangeListeners.add(onScrollChangeListener);
    }

    public void removeOnScrollChangeListener(com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListeners.remove(onScrollChangeListener);
    }

    public void removeAllOnScrollChangeListener() {
        this.mOnScrollChangeListeners.clear();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        java.util.Iterator<com.up366.qmui.widget.webview.QMUIWebView.OnScrollChangeListener> it = this.mOnScrollChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollChange(this, i, i2, i3, i4);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(android.webkit.WebViewClient webViewClient) {
        if (webViewClient != null && !(webViewClient instanceof com.up366.qmui.widget.webview.QMUIWebViewClient)) {
            throw new java.lang.IllegalArgumentException("must use the instance of QMUIWebViewClient");
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setNeedDispatchSafeAreaInset(boolean z) {
        if (this.mNeedDispatchSafeAreaInset != z) {
            this.mNeedDispatchSafeAreaInset = z;
            if (androidx.core.view.ViewCompat.isAttachedToWindow(this)) {
                if (z) {
                    androidx.core.view.ViewCompat.requestApplyInsets(this);
                } else {
                    setStyleDisplayCutoutSafeArea(new android.graphics.Rect());
                }
            }
        }
    }

    public boolean isNeedDispatchSafeAreaInset() {
        return this.mNeedDispatchSafeAreaInset;
    }

    public void setCallback(com.up366.qmui.widget.webview.QMUIWebView.Callback callback) {
        this.mCallback = callback;
    }

    private void doNotSupportChangeCssEnv() {
        sIsReflectionOccurError = true;
        com.up366.qmui.widget.webview.QMUIWebView.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onSureNotSupportChangeCssEnv();
        }
    }

    boolean isNotSupportChangeCssEnv() {
        return sIsReflectionOccurError;
    }

    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets21(java.lang.Object obj) {
        int systemWindowInsetLeft;
        int systemWindowInsetTop;
        int systemWindowInsetRight;
        int systemWindowInsetBottom;
        if (!this.mNeedDispatchSafeAreaInset) {
            return false;
        }
        float density = com.up366.qmui.util.QMUIDisplayHelper.getDensity(getContext());
        if (com.up366.qmui.util.QMUINotchHelper.isNotchOfficialSupport()) {
            android.view.WindowInsets windowInsets = (android.view.WindowInsets) obj;
            systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
            systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
            systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
            systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        } else {
            androidx.core.view.WindowInsetsCompat windowInsetsCompat = (androidx.core.view.WindowInsetsCompat) obj;
            systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            systemWindowInsetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
        }
        setStyleDisplayCutoutSafeArea(new android.graphics.Rect((int) ((systemWindowInsetLeft / density) + getExtraInsetLeft(density)), (int) ((systemWindowInsetTop / density) + getExtraInsetTop(density)), (int) ((systemWindowInsetRight / density) + getExtraInsetRight(density)), (int) ((systemWindowInsetBottom / density) + getExtraInsetBottom(density))));
        return true;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.mAwContents = null;
        this.mWebContents = null;
        this.mSetDisplayCutoutSafeAreaMethod = null;
        stopLoading();
        super.destroy();
    }

    private void setStyleDisplayCutoutSafeArea(android.graphics.Rect rect) {
        android.graphics.Rect rect2;
        if (sIsReflectionOccurError || android.os.Build.VERSION.SDK_INT <= 24 || rect == (rect2 = this.mSafeAreaRectCache)) {
            return;
        }
        if (rect2 == null) {
            this.mSafeAreaRectCache = new android.graphics.Rect(rect);
        } else {
            rect2.set(rect);
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.mAwContents == null || this.mWebContents == null || this.mSetDisplayCutoutSafeAreaMethod == null) {
            try {
                java.lang.reflect.Field declaredField = android.webkit.WebView.class.getDeclaredField("mProvider");
                declaredField.setAccessible(true);
                java.lang.Object awContentsFieldValueInProvider = getAwContentsFieldValueInProvider(declaredField.get(this));
                this.mAwContents = awContentsFieldValueInProvider;
                if (awContentsFieldValueInProvider == null) {
                    return;
                }
                java.lang.Object webContentsFieldValueInAwContents = getWebContentsFieldValueInAwContents(awContentsFieldValueInProvider);
                this.mWebContents = webContentsFieldValueInAwContents;
                if (webContentsFieldValueInAwContents == null) {
                    return;
                }
                java.lang.reflect.Method setDisplayCutoutSafeAreaMethodInWebContents = getSetDisplayCutoutSafeAreaMethodInWebContents(webContentsFieldValueInAwContents);
                this.mSetDisplayCutoutSafeAreaMethod = setDisplayCutoutSafeAreaMethodInWebContents;
                if (setDisplayCutoutSafeAreaMethodInWebContents == null) {
                    doNotSupportChangeCssEnv();
                    return;
                }
            } catch (java.lang.Exception e) {
                doNotSupportChangeCssEnv();
                android.util.Log.i(TAG, "setStyleDisplayCutoutSafeArea error: " + e);
            }
        }
        try {
            this.mSetDisplayCutoutSafeAreaMethod.setAccessible(true);
            this.mSetDisplayCutoutSafeAreaMethod.invoke(this.mWebContents, rect);
        } catch (java.lang.Exception e2) {
            sIsReflectionOccurError = true;
            android.util.Log.i(TAG, "setStyleDisplayCutoutSafeArea error: " + e2);
        }
        android.util.Log.i(TAG, "setDisplayCutoutSafeArea speed time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.core.view.ViewCompat.requestApplyInsets(this);
    }

    private java.lang.Object getAwContentsFieldValueInProvider(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField("mAwContents");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            }
        } catch (java.lang.NoSuchFieldException unused) {
        }
        for (java.lang.reflect.Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            java.lang.Object obj2 = field.get(obj);
            if (obj2 != null && obj2.getClass().getSimpleName().equals("AwContents")) {
                return obj2;
            }
        }
        return null;
    }

    private java.lang.Object getWebContentsFieldValueInAwContents(java.lang.Object obj) throws java.lang.IllegalAccessException {
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField("mWebContents");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            }
        } catch (java.lang.NoSuchFieldException unused) {
        }
        for (java.lang.reflect.Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            java.lang.Object obj2 = field.get(obj);
            if (obj2 != null && obj2.getClass().getSimpleName().equals("WebContentsImpl")) {
                return obj2;
            }
        }
        return null;
    }

    private java.lang.reflect.Method getSetDisplayCutoutSafeAreaMethodInWebContents(java.lang.Object obj) {
        try {
            java.lang.reflect.Method declaredMethod = obj.getClass().getDeclaredMethod("setDisplayCutoutSafeArea", android.graphics.Rect.class);
            if (declaredMethod != null) {
                return declaredMethod;
            }
        } catch (java.lang.NoSuchMethodException unused) {
        }
        for (java.lang.reflect.Method method : obj.getClass().getDeclaredMethods()) {
            if (method.getReturnType() == java.lang.Void.TYPE && method.getParameterTypes().length == 1 && method.getParameterTypes()[0] == android.graphics.Rect.class) {
                return method;
            }
        }
        return null;
    }
}
