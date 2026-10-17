package com.up366.qmui.alpha;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIAlphaTextView extends com.up366.qmui.widget.textview.QMUISpanTouchFixTextView implements com.up366.qmui.alpha.QMUIAlphaViewInf {
    private com.up366.qmui.alpha.QMUIAlphaViewHelper mAlphaViewHelper;

    public QMUIAlphaTextView(android.content.Context context) {
        super(context);
    }

    public QMUIAlphaTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIAlphaTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.up366.qmui.alpha.QMUIAlphaViewHelper getAlphaViewHelper() {
        if (this.mAlphaViewHelper == null) {
            this.mAlphaViewHelper = new com.up366.qmui.alpha.QMUIAlphaViewHelper(this);
        }
        return this.mAlphaViewHelper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.widget.textview.QMUISpanTouchFixTextView
    protected void onSetPressed(boolean z) {
        super.onSetPressed(z);
        getAlphaViewHelper().onPressedChanged(this, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
