package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIWindowInsetLayout2 extends com.up366.qmui.layout.QMUIConstraintLayout implements com.up366.qmui.widget.IWindowInsetLayout {
    protected com.up366.qmui.util.QMUIWindowInsetHelper mQMUIWindowInsetHelper;

    public QMUIWindowInsetLayout2(android.content.Context context) {
        this(context, null);
    }

    public QMUIWindowInsetLayout2(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QMUIWindowInsetLayout2(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQMUIWindowInsetHelper = new com.up366.qmui.util.QMUIWindowInsetHelper(this, this);
    }

    protected boolean fitSystemWindows(android.graphics.Rect rect) {
        return super.fitSystemWindows(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets19(android.graphics.Rect rect) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets19(this, rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.widget.IWindowInsetLayout
    public boolean applySystemWindowInsets21(java.lang.Object obj) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets21(this, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.core.view.ViewCompat.requestApplyInsets(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.core.view.ViewCompat.requestApplyInsets(this);
    }
}
