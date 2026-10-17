package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIKeyboardHelper {
    public static final int KEYBOARD_VISIBLE_THRESHOLD_DP = 100;
    public static final int SHOW_KEYBOARD_DELAY_TIME = 200;
    private static final java.lang.String TAG = "QMUIKeyboardHelper";

    public interface KeyboardVisibilityEventListener {
        boolean onVisibilityChanged(boolean z, int i);
    }

    public static void showKeyboard(android.widget.EditText editText, boolean z) {
        showKeyboard(editText, z ? 200 : 0);
    }

    public static void showKeyboard(final android.widget.EditText editText, int i) {
        if (editText == null) {
            return;
        }
        if (!editText.requestFocus()) {
            android.util.Log.w(TAG, "showSoftInput() can not get focus");
        } else if (i > 0) {
            editText.postDelayed(new java.lang.Runnable() { // from class: com.up366.qmui.util.QMUIKeyboardHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    ((android.view.inputmethod.InputMethodManager) editText.getContext().getApplicationContext().getSystemService("input_method")).showSoftInput(editText, 1);
                }
            }, i);
        } else {
            ((android.view.inputmethod.InputMethodManager) editText.getContext().getApplicationContext().getSystemService("input_method")).showSoftInput(editText, 1);
        }
    }

    public static boolean hideKeyboard(android.view.View view) {
        if (view == null) {
            return false;
        }
        return ((android.view.inputmethod.InputMethodManager) view.getContext().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    public static void setVisibilityEventListener(android.app.Activity activity, com.up366.qmui.util.QMUIKeyboardHelper.KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        if (activity == null) {
            throw new java.lang.NullPointerException("Parameter:activity must not be null");
        }
        if (keyboardVisibilityEventListener == null) {
            throw new java.lang.NullPointerException("Parameter:listener must not be null");
        }
        final android.view.View activityRoot = com.up366.qmui.util.QMUIViewHelper.getActivityRoot(activity);
        final android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener(activity, activityRoot, keyboardVisibilityEventListener) { // from class: com.up366.qmui.util.QMUIKeyboardHelper.2
            final /* synthetic */ android.app.Activity val$activity;
            final /* synthetic */ android.view.View val$activityRoot;
            final /* synthetic */ com.up366.qmui.util.QMUIKeyboardHelper.KeyboardVisibilityEventListener val$listener;
            private final int visibleThreshold;
            private final android.graphics.Rect r = new android.graphics.Rect();
            private boolean wasOpened = false;

            {
                this.val$activity = activity;
                this.val$activityRoot = activityRoot;
                this.val$listener = keyboardVisibilityEventListener;
                this.visibleThreshold = java.lang.Math.round(com.up366.qmui.util.QMUIDisplayHelper.dp2px(activity, 100));
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                this.val$activityRoot.getWindowVisibleDisplayFrame(this.r);
                int height = this.val$activityRoot.getRootView().getHeight() - this.r.height();
                boolean z = height > this.visibleThreshold;
                if (z == this.wasOpened) {
                    return;
                }
                this.wasOpened = z;
                if (this.val$listener.onVisibilityChanged(z, height)) {
                    this.val$activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        };
        activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        activity.getApplication().registerActivityLifecycleCallbacks(new com.up366.qmui.util.QMUIActivityLifecycleCallbacks(activity) { // from class: com.up366.qmui.util.QMUIKeyboardHelper.3
            @Override // com.up366.qmui.util.QMUIActivityLifecycleCallbacks
            protected void onTargetActivityDestroyed() {
                activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        });
    }

    public static boolean isKeyboardVisible(android.app.Activity activity) {
        android.graphics.Rect rect = new android.graphics.Rect();
        android.view.View activityRoot = com.up366.qmui.util.QMUIViewHelper.getActivityRoot(activity);
        int iRound = java.lang.Math.round(com.up366.qmui.util.QMUIDisplayHelper.dp2px(activity, 100));
        activityRoot.getWindowVisibleDisplayFrame(rect);
        return activityRoot.getRootView().getHeight() - rect.height() > iRound;
    }
}
