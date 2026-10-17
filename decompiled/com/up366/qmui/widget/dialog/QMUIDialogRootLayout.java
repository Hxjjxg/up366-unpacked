package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDialogRootLayout extends android.view.ViewGroup {
    private boolean isOverlayOccurEventNotified;
    private boolean mCheckKeyboardOverlay;
    private com.up366.qmui.widget.dialog.QMUIDialogView mDialogView;
    private android.widget.FrameLayout.LayoutParams mDialogViewLp;
    private int mInsetHor;
    private int mInsetVer;
    private int mLastContentInsetTop;
    private float mMaxPercent;
    private int mMaxWidth;
    private int mMinWidth;
    private com.up366.qmui.widget.dialog.QMUIDialogRootLayout.OverlayOccurInMeasureCallback mOverlayOccurInMeasureCallback;

    interface OverlayOccurInMeasureCallback {
        void call();
    }

    public QMUIDialogRootLayout(android.content.Context context, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.widget.FrameLayout.LayoutParams layoutParams) {
        super(context);
        this.mCheckKeyboardOverlay = false;
        this.mMaxPercent = 0.75f;
        this.isOverlayOccurEventNotified = false;
        this.mLastContentInsetTop = 0;
        this.mDialogView = qMUIDialogView;
        layoutParams = layoutParams == null ? new android.widget.FrameLayout.LayoutParams(-2, -2) : layoutParams;
        this.mDialogViewLp = layoutParams;
        addView((android.view.View) this.mDialogView, (android.view.ViewGroup.LayoutParams) layoutParams);
        this.mMinWidth = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_min_width);
        this.mMaxWidth = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_max_width);
        this.mInsetHor = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_inset_hor);
        this.mInsetVer = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_inset_ver);
    }

    public void setMinWidth(int i) {
        this.mMinWidth = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
    }

    public void setInsetHor(int i) {
        this.mInsetHor = i;
    }

    public void setInsetVer(int i) {
        this.mInsetVer = i;
    }

    public void setOverlayOccurInMeasureCallback(com.up366.qmui.widget.dialog.QMUIDialogRootLayout.OverlayOccurInMeasureCallback overlayOccurInMeasureCallback) {
        this.mOverlayOccurInMeasureCallback = overlayOccurInMeasureCallback;
    }

    public void setCheckKeyboardOverlay(boolean z) {
        this.mCheckKeyboardOverlay = z;
    }

    public void setMaxPercent(float f) {
        this.mMaxPercent = f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int iMakeMeasureSpec;
        int iMin;
        int iMakeMeasureSpec2;
        if (this.mCheckKeyboardOverlay) {
            android.graphics.Rect rectUnSafeGetWindowVisibleInsets = com.up366.qmui.util.QMUIWindowHelper.unSafeGetWindowVisibleInsets(this);
            android.graphics.Rect rectUnSafeGetContentInsets = com.up366.qmui.util.QMUIWindowHelper.unSafeGetContentInsets(this);
            i3 = rectUnSafeGetWindowVisibleInsets != null ? rectUnSafeGetWindowVisibleInsets.bottom : 0;
            if (rectUnSafeGetContentInsets != null) {
                this.mLastContentInsetTop = rectUnSafeGetContentInsets.top;
                i4 = rectUnSafeGetContentInsets.top + rectUnSafeGetContentInsets.bottom;
            } else {
                i4 = 0;
            }
        } else {
            i3 = 0;
            i4 = 0;
        }
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (this.mDialogViewLp.width > 0) {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.mDialogViewLp.width, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        } else {
            int iMin2 = java.lang.Math.min(this.mMaxWidth, size - (this.mInsetHor * 2));
            int i5 = this.mMinWidth;
            if (iMin2 <= i5) {
                iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i5, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
            } else if (this.mDialogViewLp.width == -1) {
                iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(iMin2, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
            } else {
                iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(iMin2, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            }
        }
        if (this.mDialogViewLp.height > 0) {
            iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(this.mDialogViewLp.height, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        } else {
            if (i3 > 0) {
                if (getRootView() != null && getRootView().getHeight() > 0) {
                    size2 = getRootView().getHeight();
                    if (!this.isOverlayOccurEventNotified) {
                        this.isOverlayOccurEventNotified = true;
                        com.up366.qmui.widget.dialog.QMUIDialogRootLayout.OverlayOccurInMeasureCallback overlayOccurInMeasureCallback = this.mOverlayOccurInMeasureCallback;
                        if (overlayOccurInMeasureCallback != null) {
                            overlayOccurInMeasureCallback.call();
                        }
                    }
                }
                iMin = java.lang.Math.max(((size2 - (this.mInsetVer * 2)) - i3) - i4, 0);
            } else {
                this.isOverlayOccurEventNotified = false;
                iMin = java.lang.Math.min((size2 - (this.mInsetVer * 2)) - i4, (int) ((com.up366.qmui.util.QMUIDisplayHelper.getScreenHeight(getContext()) * this.mMaxPercent) - (this.mInsetVer * 2)));
            }
            if (this.mDialogViewLp.height == -1) {
                iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(iMin, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
            } else {
                iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(iMin, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            }
        }
        this.mDialogView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int measuredWidth = this.mDialogView.getMeasuredWidth();
        int i6 = this.mMinWidth;
        if (measuredWidth < i6) {
            this.mDialogView.measure(android.view.View.MeasureSpec.makeMeasureSpec(i6, com.up366.medialibrary.common.utils.PictureFileUtils.GB), iMakeMeasureSpec2);
        }
        setMeasuredDimension(this.mDialogView.getMeasuredWidth(), this.mDialogView.getMeasuredHeight() + (this.mInsetVer * 2) + i3 + i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = ((i3 - i) - this.mDialogView.getMeasuredWidth()) / 2;
        com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView = this.mDialogView;
        qMUIDialogView.layout(measuredWidth, this.mInsetVer, qMUIDialogView.getMeasuredWidth() + measuredWidth, this.mInsetVer + this.mDialogView.getMeasuredHeight());
    }

    public com.up366.qmui.widget.dialog.QMUIDialogView getDialogView() {
        return this.mDialogView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mLastContentInsetTop > 0) {
            motionEvent.offsetLocation(0.0f, -r0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
