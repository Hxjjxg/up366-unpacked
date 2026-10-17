package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SoftKeyboardChangeHelper {
    private static final java.lang.String TAG = "SoftKeyboardChangeHelper";
    private final android.view.View container;
    private final android.view.inputmethod.InputMethodManager imm;
    private int lastMinBottom;
    private com.up366.mobile.common.helper.SoftKeyboardChangeHelper.IOnChangeListener listener;
    private java.lang.Boolean oldIsKeyboardShow = null;
    private final android.graphics.Rect rect = new android.graphics.Rect();
    private final android.graphics.Rect rectView = new android.graphics.Rect();
    private android.view.View[] views;

    public interface IOnChangeListener {
        void onChange(boolean z, boolean z2, int i, int i2);
    }

    public SoftKeyboardChangeHelper(android.view.View view) {
        this.container = view;
        android.util.DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.lastMinBottom = displayMetrics.heightPixels - (displayMetrics.widthPixels / 2);
        this.imm = (android.view.inputmethod.InputMethodManager) view.getContext().getSystemService("input_method");
    }

    public com.up366.mobile.common.helper.SoftKeyboardChangeHelper onChange(com.up366.mobile.common.helper.SoftKeyboardChangeHelper.IOnChangeListener iOnChangeListener) {
        this.listener = iOnChangeListener;
        return this;
    }

    public com.up366.mobile.common.helper.SoftKeyboardChangeHelper watch(android.view.View... viewArr) {
        this.views = viewArr;
        this.container.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.up366.mobile.common.helper.SoftKeyboardChangeHelper$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.notifyChange();
            }
        });
        return this;
    }

    public void notifyChange() {
        this.container.getWindowVisibleDisplayFrame(this.rect);
        android.view.View childAt = ((android.view.ViewGroup) this.container.getRootView()).getChildAt(0);
        childAt.getGlobalVisibleRect(this.rectView);
        childAt.getWindowVisibleDisplayFrame(new android.graphics.Rect());
        boolean zIsActive = false;
        for (android.view.View view : this.views) {
            zIsActive |= this.imm.isActive(view);
        }
        if (zIsActive) {
            android.graphics.Rect rect = this.rect;
            rect.bottom = java.lang.Math.min(rect.bottom, this.lastMinBottom);
        }
        boolean z = this.rect.bottom != this.rectView.bottom;
        boolean zBooleanValue = !z;
        java.lang.Boolean bool = this.oldIsKeyboardShow;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        }
        if (!zIsActive && z) {
            this.lastMinBottom = this.rect.bottom;
        }
        this.listener.onChange(zBooleanValue, z, this.rectView.bottom - this.rect.bottom, this.rect.height());
        this.oldIsKeyboardShow = java.lang.Boolean.valueOf(z);
    }
}
