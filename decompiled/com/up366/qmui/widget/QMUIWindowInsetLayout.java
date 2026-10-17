package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWindowInsetLayout extends com.up366.qmui.layout.QMUIFrameLayout implements com.up366.qmui.widget.IWindowInsetLayout {
    protected com.up366.qmui.util.QMUIWindowInsetHelper mQMUIWindowInsetHelper;

    public QMUIWindowInsetLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUIWindowInsetLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIWindowInsetLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQMUIWindowInsetHelper = new com.up366.qmui.util.QMUIWindowInsetHelper(this, this);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(android.graphics.Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets19(android.graphics.Rect rect) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets19(this, rect);
    }

    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets21(java.lang.Object obj) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets21(this, obj);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.core.view.ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.core.view.ViewCompat.requestApplyInsets(this);
    }
}
