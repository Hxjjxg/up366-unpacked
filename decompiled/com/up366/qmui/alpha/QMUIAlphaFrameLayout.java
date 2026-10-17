package com.up366.qmui.alpha;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIAlphaFrameLayout extends android.widget.FrameLayout implements com.up366.qmui.alpha.QMUIAlphaViewInf {
    private com.up366.qmui.alpha.QMUIAlphaViewHelper mAlphaViewHelper;

    public QMUIAlphaFrameLayout(android.content.Context context) {
        super(context);
    }

    public QMUIAlphaFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIAlphaFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private com.up366.qmui.alpha.QMUIAlphaViewHelper getAlphaViewHelper() {
        if (this.mAlphaViewHelper == null) {
            this.mAlphaViewHelper = new com.up366.qmui.alpha.QMUIAlphaViewHelper(this);
        }
        return this.mAlphaViewHelper;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        getAlphaViewHelper().onPressedChanged(this, z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        getAlphaViewHelper().onEnabledChanged(this, z);
    }

    @Override // com.up366.qmui.alpha.QMUIAlphaViewInf
    public void setChangeAlphaWhenPress(boolean z) {
        getAlphaViewHelper().setChangeAlphaWhenPress(z);
    }

    @Override // com.up366.qmui.alpha.QMUIAlphaViewInf
    public void setChangeAlphaWhenDisable(boolean z) {
        getAlphaViewHelper().setChangeAlphaWhenDisable(z);
    }
}
