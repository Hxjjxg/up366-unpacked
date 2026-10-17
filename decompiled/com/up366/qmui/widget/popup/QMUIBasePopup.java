package com.up366.qmui.widget.popup;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIBasePopup<T extends com.up366.qmui.widget.popup.QMUIBasePopup> {
    public static final float DIM_AMOUNT_NOT_EXIST = -1.0f;
    public static final int NOT_SET = -1;
    protected java.lang.ref.WeakReference<android.view.View> mAttachedViewRf;
    protected android.content.Context mContext;
    private android.widget.PopupWindow.OnDismissListener mDismissListener;
    private com.up366.qmui.skin.QMUISkinManager mSkinManager;
    protected final android.widget.PopupWindow mWindow;
    protected android.view.WindowManager mWindowManager;
    private float mDimAmount = -1.0f;
    private int mDimAmountAttr = 0;
    private boolean mDismissIfOutsideTouch = true;
    private com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener mOnSkinChangeListener = new com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener() { // from class: com.up366.qmui.widget.popup.QMUIBasePopup.1
        @Override // com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener
        public void onSkinChange(com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, int i2) {
            if (com.up366.qmui.widget.popup.QMUIBasePopup.this.mDimAmountAttr != 0) {
                android.content.res.Resources.Theme theme = qMUISkinManager.getTheme(i2);
                com.up366.qmui.widget.popup.QMUIBasePopup qMUIBasePopup = com.up366.qmui.widget.popup.QMUIBasePopup.this;
                qMUIBasePopup.mDimAmount = com.up366.qmui.util.QMUIResHelper.getAttrFloatValue(theme, qMUIBasePopup.mDimAmountAttr);
                com.up366.qmui.widget.popup.QMUIBasePopup qMUIBasePopup2 = com.up366.qmui.widget.popup.QMUIBasePopup.this;
                qMUIBasePopup2.updateDimAmount(qMUIBasePopup2.mDimAmount);
                com.up366.qmui.widget.popup.QMUIBasePopup.this.onSkinChange(i, i2);
            }
        }
    };
    private android.view.View.OnAttachStateChangeListener mOnAttachStateChangeListener = new android.view.View.OnAttachStateChangeListener() { // from class: com.up366.qmui.widget.popup.QMUIBasePopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            com.up366.qmui.widget.popup.QMUIBasePopup.this.dismiss();
        }
    };
    private android.view.View.OnTouchListener mOutsideTouchDismissListener = new android.view.View.OnTouchListener() { // from class: com.up366.qmui.widget.popup.QMUIBasePopup.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            if (motionEvent.getAction() != 4) {
                return false;
            }
            com.up366.qmui.widget.popup.QMUIBasePopup.this.mWindow.dismiss();
            return true;
        }
    };

    protected void modifyWindowLayoutParams(android.view.WindowManager.LayoutParams layoutParams) {
    }

    protected void onDismiss() {
    }

    protected void onSkinChange(int i, int i2) {
    }

    public QMUIBasePopup(android.content.Context context) {
        this.mContext = context;
        this.mWindowManager = (android.view.WindowManager) context.getSystemService("window");
        this.mWindow = new android.widget.PopupWindow(context);
        initWindow();
    }

    private void initWindow() {
        this.mWindow.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        this.mWindow.setFocusable(true);
        this.mWindow.setTouchable(true);
        this.mWindow.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.up366.qmui.widget.popup.QMUIBasePopup.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                com.up366.qmui.widget.popup.QMUIBasePopup.this.onDismiss();
                if (com.up366.qmui.widget.popup.QMUIBasePopup.this.mDismissListener != null) {
                    com.up366.qmui.widget.popup.QMUIBasePopup.this.mDismissListener.onDismiss();
                }
            }
        });
        dismissIfOutsideTouch(this.mDismissIfOutsideTouch);
    }

    public com.up366.qmui.skin.QMUISkinManager getSkinManager() {
        return this.mSkinManager;
    }

    public T dimAmount(float f) {
        this.mDimAmount = f;
        return this;
    }

    public T dimAmountAttr(int i) {
        this.mDimAmountAttr = i;
        return this;
    }

    public T skinManager(com.up366.qmui.skin.QMUISkinManager qMUISkinManager) {
        this.mSkinManager = qMUISkinManager;
        return this;
    }

    public T dismissIfOutsideTouch(boolean z) {
        this.mDismissIfOutsideTouch = z;
        this.mWindow.setOutsideTouchable(z);
        if (z) {
            this.mWindow.setTouchInterceptor(this.mOutsideTouchDismissListener);
        } else {
            this.mWindow.setTouchInterceptor(null);
        }
        return this;
    }

    public T onDismiss(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
        return this;
    }

    private void removeOldAttachStateChangeListener() {
        android.view.View view;
        java.lang.ref.WeakReference<android.view.View> weakReference = this.mAttachedViewRf;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.removeOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
    }

    public android.view.View getDecorView() {
        android.view.View view;
        try {
            if (this.mWindow.getBackground() == null) {
                view = (android.view.View) this.mWindow.getContentView().getParent();
            } else {
                view = (android.view.View) this.mWindow.getContentView().getParent().getParent();
            }
            return view;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    protected void showAtLocation(android.view.View view, int i, int i2) {
        if (androidx.core.view.ViewCompat.isAttachedToWindow(view)) {
            removeOldAttachStateChangeListener();
            view.addOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
            this.mAttachedViewRf = new java.lang.ref.WeakReference<>(view);
            this.mWindow.showAtLocation(view, 0, i, i2);
            com.up366.qmui.skin.QMUISkinManager qMUISkinManager = this.mSkinManager;
            if (qMUISkinManager != null) {
                qMUISkinManager.register(this.mWindow);
                this.mSkinManager.addSkinChangeListener(this.mOnSkinChangeListener);
                if (this.mDimAmountAttr != 0) {
                    android.content.res.Resources.Theme currentTheme = this.mSkinManager.getCurrentTheme();
                    if (currentTheme == null) {
                        currentTheme = view.getContext().getTheme();
                    }
                    this.mDimAmount = com.up366.qmui.util.QMUIResHelper.getAttrFloatValue(currentTheme, this.mDimAmountAttr);
                }
            }
            float f = this.mDimAmount;
            if (f != -1.0f) {
                updateDimAmount(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDimAmount(float f) {
        android.view.View decorView = getDecorView();
        if (decorView != null) {
            android.view.WindowManager.LayoutParams layoutParams = (android.view.WindowManager.LayoutParams) decorView.getLayoutParams();
            layoutParams.flags |= 2;
            layoutParams.dimAmount = f;
            modifyWindowLayoutParams(layoutParams);
            this.mWindowManager.updateViewLayout(decorView, layoutParams);
        }
    }

    public final void dismiss() {
        removeOldAttachStateChangeListener();
        this.mAttachedViewRf = null;
        com.up366.qmui.skin.QMUISkinManager qMUISkinManager = this.mSkinManager;
        if (qMUISkinManager != null) {
            qMUISkinManager.unRegister(this.mWindow);
            this.mSkinManager.removeSkinChangeListener(this.mOnSkinChangeListener);
        }
        this.mWindow.dismiss();
    }
}
