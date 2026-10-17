package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBaseDialog extends androidx.appcompat.app.AppCompatDialog {
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private com.up366.qmui.skin.QMUISkinManager mSkinManager;

    protected void onSetCancelable(boolean z) {
    }

    public QMUIBaseDialog(android.content.Context context, int i) {
        super(context, i);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.mSkinManager = null;
        supportRequestWindowFeature(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSkinManager(com.up366.qmui.skin.QMUISkinManager qMUISkinManager) {
        com.up366.qmui.skin.QMUISkinManager qMUISkinManager2 = this.mSkinManager;
        if (qMUISkinManager2 != null) {
            qMUISkinManager2.unRegister((android.app.Dialog) this);
        }
        this.mSkinManager = qMUISkinManager;
        if (!isShowing() || qMUISkinManager == null) {
            return;
        }
        this.mSkinManager.register((android.app.Dialog) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        super.onStart();
        com.up366.qmui.skin.QMUISkinManager qMUISkinManager = this.mSkinManager;
        if (qMUISkinManager != null) {
            qMUISkinManager.register((android.app.Dialog) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        super.onStop();
        com.up366.qmui.skin.QMUISkinManager qMUISkinManager = this.mSkinManager;
        if (qMUISkinManager != null) {
            qMUISkinManager.unRegister((android.app.Dialog) this);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.cancelable != z) {
            this.cancelable = z;
            onSetCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = true;
    }

    protected boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }
}
