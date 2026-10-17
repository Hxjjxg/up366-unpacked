package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIViewOffsetBehavior<V extends android.view.View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private com.up366.qmui.util.QMUIViewOffsetHelper viewOffsetHelper;

    public QMUIViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public QMUIViewOffsetBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new com.up366.qmui.util.QMUIViewOffsetHelper(v);
        }
        this.viewOffsetHelper.onViewLayout();
        int i2 = this.tempTopBottomOffset;
        if (i2 != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(i2);
            this.tempTopBottomOffset = 0;
        }
        int i3 = this.tempLeftRightOffset;
        if (i3 == 0) {
            return true;
        }
        this.viewOffsetHelper.setLeftAndRightOffset(i3);
        this.tempLeftRightOffset = 0;
        return true;
    }

    protected void layoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    public boolean setTopAndBottomOffset(int i) {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.setTopAndBottomOffset(i);
        }
        this.tempTopBottomOffset = i;
        return false;
    }

    public boolean setLeftAndRightOffset(int i) {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.setLeftAndRightOffset(i);
        }
        this.tempLeftRightOffset = i;
        return false;
    }

    public int getTopAndBottomOffset() {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.getTopAndBottomOffset();
        }
        return 0;
    }

    public int getLeftAndRightOffset() {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.getLeftAndRightOffset();
        }
        return 0;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            qMUIViewOffsetHelper.setVerticalOffsetEnabled(z);
        }
    }

    public int getLayoutTop() {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.getLayoutTop();
        }
        return 0;
    }

    public int getLayoutLeft() {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.getLayoutLeft();
        }
        return 0;
    }

    public boolean isVerticalOffsetEnabled() {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        return qMUIViewOffsetHelper != null && qMUIViewOffsetHelper.isVerticalOffsetEnabled();
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            qMUIViewOffsetHelper.setHorizontalOffsetEnabled(z);
        }
    }

    public boolean isHorizontalOffsetEnabled() {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        return qMUIViewOffsetHelper != null && qMUIViewOffsetHelper.isHorizontalOffsetEnabled();
    }
}
