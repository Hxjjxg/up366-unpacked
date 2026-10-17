package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SoftKeyboardChangeHelperV2 {
    private static final java.lang.String TAG = "SoftKeyboardChangeHelperV2";
    private final android.view.View child;
    private final android.view.View container;
    private final float dp;
    private int keyboardHeight;
    private boolean keyboardShowState;
    private final java.lang.Runnable lazeNotifyChange = new java.lang.Runnable() { // from class: com.up366.mobile.common.helper.SoftKeyboardChangeHelperV2$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.notifyChange();
        }
    };
    private com.up366.mobile.common.helper.SoftKeyboardChangeHelperV2.IOnChangeListener listener;
    private int oldChildHeight;
    private int oldContainerHeight;

    public interface IOnChangeListener {
        void onChange(boolean z, int i);
    }

    public SoftKeyboardChangeHelperV2(android.view.View view, android.view.View view2) {
        this.container = view;
        this.child = view2;
        this.dp = view.getResources().getDisplayMetrics().density;
    }

    public com.up366.mobile.common.helper.SoftKeyboardChangeHelperV2 onChange(com.up366.mobile.common.helper.SoftKeyboardChangeHelperV2.IOnChangeListener iOnChangeListener) {
        this.listener = iOnChangeListener;
        return this;
    }

    public com.up366.mobile.common.helper.SoftKeyboardChangeHelperV2 watch() {
        this.container.getViewTreeObserver().addOnGlobalLayoutListener(new com.up366.mobile.common.helper.SoftKeyboardChangeHelperV2$$ExternalSyntheticLambda0(this));
        return this;
    }

    public void destroy() {
        this.container.getViewTreeObserver().removeOnGlobalLayoutListener(new com.up366.mobile.common.helper.SoftKeyboardChangeHelperV2$$ExternalSyntheticLambda0(this));
    }

    public void notifyChange() {
        int measuredHeight = this.container.getMeasuredHeight();
        int measuredHeight2 = this.child.getMeasuredHeight();
        if (measuredHeight == this.oldContainerHeight && measuredHeight2 == this.oldChildHeight) {
            return;
        }
        this.oldContainerHeight = measuredHeight;
        this.oldChildHeight = measuredHeight2;
        this.container.removeCallbacks(this.lazeNotifyChange);
        this.container.postDelayed(this.lazeNotifyChange, 10L);
        int i = measuredHeight2 - measuredHeight;
        float f = i;
        float f2 = this.dp;
        if (f > f2 * 100.0f) {
            this.keyboardHeight = i;
        } else if (this.keyboardHeight < f2 * 100.0f) {
            this.keyboardHeight = (int) (250.0f * f2);
        }
        boolean z = f > f2 * 100.0f;
        this.keyboardShowState = z;
        if (!z) {
            android.view.ViewGroup.LayoutParams layoutParams = this.child.getLayoutParams();
            int measuredHeight3 = layoutParams.height - this.container.getMeasuredHeight();
            if (measuredHeight3 != 0) {
                com.up366.common.log.Logger.info("TAG - SoftKeyboardChangeHelperV2 - notifyChange - no keyboard diff:" + measuredHeight3);
                layoutParams.height = layoutParams.height - measuredHeight3;
                this.child.setLayoutParams(layoutParams);
            }
        }
        this.listener.onChange(this.keyboardShowState, this.keyboardHeight);
    }

    public boolean isKeyboardShow() {
        return this.keyboardShowState;
    }

    public int getKeyboardHeight() {
        return this.keyboardHeight;
    }
}
