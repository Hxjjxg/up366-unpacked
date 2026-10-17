package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUINotchConsumeLayout extends android.widget.FrameLayout implements com.up366.qmui.widget.INotchInsetConsumer {
    public QMUINotchConsumeLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUINotchConsumeLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUINotchConsumeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFitsSystemWindows(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (com.up366.qmui.util.QMUINotchHelper.isNotchOfficialSupport()) {
            return;
        }
        notifyInsetMaybeChanged();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (com.up366.qmui.util.QMUINotchHelper.isNotchOfficialSupport()) {
            return;
        }
        notifyInsetMaybeChanged();
    }

    @Override // com.up366.qmui.widget.INotchInsetConsumer
    public boolean notifyInsetMaybeChanged() {
        setPadding(com.up366.qmui.util.QMUINotchHelper.getSafeInsetLeft(this), com.up366.qmui.util.QMUINotchHelper.getSafeInsetTop(this), com.up366.qmui.util.QMUINotchHelper.getSafeInsetRight(this), com.up366.qmui.util.QMUINotchHelper.getSafeInsetBottom(this));
        return true;
    }
}
