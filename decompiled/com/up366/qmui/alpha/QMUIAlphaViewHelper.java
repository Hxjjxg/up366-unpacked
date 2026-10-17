package com.up366.qmui.alpha;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIAlphaViewHelper {
    private float mDisabledAlpha;
    private float mPressedAlpha;
    private java.lang.ref.WeakReference<android.view.View> mTarget;
    private boolean mChangeAlphaWhenPress = true;
    private boolean mChangeAlphaWhenDisable = true;
    private float mNormalAlpha = 1.0f;

    public QMUIAlphaViewHelper(android.view.View view) {
        this.mPressedAlpha = 0.5f;
        this.mDisabledAlpha = 0.5f;
        this.mTarget = new java.lang.ref.WeakReference<>(view);
        this.mPressedAlpha = com.up366.qmui.util.QMUIResHelper.getAttrFloatValue(view.getContext(), com.qmuiteam.qmui.R.attr.qmui_alpha_pressed);
        this.mDisabledAlpha = com.up366.qmui.util.QMUIResHelper.getAttrFloatValue(view.getContext(), com.qmuiteam.qmui.R.attr.qmui_alpha_disabled);
    }

    public QMUIAlphaViewHelper(android.view.View view, float f, float f2) {
        this.mPressedAlpha = 0.5f;
        this.mDisabledAlpha = 0.5f;
        this.mTarget = new java.lang.ref.WeakReference<>(view);
        this.mPressedAlpha = f;
        this.mDisabledAlpha = f2;
    }

    public void onPressedChanged(android.view.View view, boolean z) {
        android.view.View view2 = this.mTarget.get();
        if (view2 == null) {
            return;
        }
        if (view.isEnabled()) {
            view2.setAlpha((this.mChangeAlphaWhenPress && z && view.isClickable()) ? this.mPressedAlpha : this.mNormalAlpha);
        } else if (this.mChangeAlphaWhenDisable) {
            view2.setAlpha(this.mDisabledAlpha);
        }
    }

    public void onEnabledChanged(android.view.View view, boolean z) {
        android.view.View view2 = this.mTarget.get();
        if (view2 == null) {
            return;
        }
        float f = (!this.mChangeAlphaWhenDisable || z) ? this.mNormalAlpha : this.mDisabledAlpha;
        if (view != view2 && view2.isEnabled() != z) {
            view2.setEnabled(z);
        }
        view2.setAlpha(f);
    }

    public void setChangeAlphaWhenPress(boolean z) {
        this.mChangeAlphaWhenPress = z;
    }

    public void setChangeAlphaWhenDisable(boolean z) {
        this.mChangeAlphaWhenDisable = z;
        android.view.View view = this.mTarget.get();
        if (view != null) {
            onEnabledChanged(view, view.isEnabled());
        }
    }
}
