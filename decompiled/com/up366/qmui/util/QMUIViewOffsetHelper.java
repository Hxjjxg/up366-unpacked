package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class QMUIViewOffsetHelper {
    private int mLayoutLeft;
    private int mLayoutTop;
    private int mOffsetLeft;
    private int mOffsetTop;
    private final android.view.View mView;
    private boolean mVerticalOffsetEnabled = true;
    private boolean mHorizontalOffsetEnabled = true;

    public QMUIViewOffsetHelper(android.view.View view) {
        this.mView = view;
    }

    public void onViewLayout() {
        this.mLayoutTop = this.mView.getTop();
        this.mLayoutLeft = this.mView.getLeft();
        updateOffsets();
    }

    private void updateOffsets() {
        android.view.View view = this.mView;
        androidx.core.view.ViewCompat.offsetTopAndBottom(view, this.mOffsetTop - (view.getTop() - this.mLayoutTop));
        android.view.View view2 = this.mView;
        androidx.core.view.ViewCompat.offsetLeftAndRight(view2, this.mOffsetLeft - (view2.getLeft() - this.mLayoutLeft));
    }

    public boolean setTopAndBottomOffset(int i) {
        if (!this.mVerticalOffsetEnabled || this.mOffsetTop == i) {
            return false;
        }
        this.mOffsetTop = i;
        updateOffsets();
        return true;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (!this.mHorizontalOffsetEnabled || this.mOffsetLeft == i) {
            return false;
        }
        this.mOffsetLeft = i;
        updateOffsets();
        return true;
    }

    public boolean setOffset(int i, int i2) {
        boolean z = this.mHorizontalOffsetEnabled;
        if (!z && !this.mVerticalOffsetEnabled) {
            return false;
        }
        if (!z || !this.mVerticalOffsetEnabled) {
            if (z) {
                return setLeftAndRightOffset(i);
            }
            return setTopAndBottomOffset(i2);
        }
        if (this.mOffsetLeft == i && this.mOffsetTop == i2) {
            return false;
        }
        this.mOffsetLeft = i;
        this.mOffsetTop = i2;
        updateOffsets();
        return true;
    }

    public int getTopAndBottomOffset() {
        return this.mOffsetTop;
    }

    public int getLeftAndRightOffset() {
        return this.mOffsetLeft;
    }

    public int getLayoutTop() {
        return this.mLayoutTop;
    }

    public int getLayoutLeft() {
        return this.mLayoutLeft;
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        this.mHorizontalOffsetEnabled = z;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.mHorizontalOffsetEnabled;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        this.mVerticalOffsetEnabled = z;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.mVerticalOffsetEnabled;
    }
}
