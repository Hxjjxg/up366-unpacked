package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetBehavior<V extends android.view.ViewGroup> extends com.google.android.material.bottomsheet.BottomSheetBehavior<V> {
    private com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior.DownDragDecisionMaker mDownDragDecisionMaker;
    private boolean mAllowDrag = true;
    private boolean mMotionEventCanDrag = true;

    public interface DownDragDecisionMaker {
        boolean canDrag(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.MotionEvent motionEvent);
    }

    public void setAllowDrag(boolean z) {
        this.mAllowDrag = z;
    }

    public void setDownDragDecisionMaker(com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior.DownDragDecisionMaker downDragDecisionMaker) {
        this.mDownDragDecisionMaker = downDragDecisionMaker;
    }

    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v, android.view.MotionEvent motionEvent) {
        if (!this.mAllowDrag) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior.DownDragDecisionMaker downDragDecisionMaker = this.mDownDragDecisionMaker;
            this.mMotionEventCanDrag = downDragDecisionMaker == null || downDragDecisionMaker.canDrag(coordinatorLayout, v, motionEvent);
        }
        if (this.mMotionEventCanDrag) {
            return super.onTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v, android.view.MotionEvent motionEvent) {
        if (!this.mAllowDrag) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior.DownDragDecisionMaker downDragDecisionMaker = this.mDownDragDecisionMaker;
            this.mMotionEventCanDrag = downDragDecisionMaker == null || downDragDecisionMaker.canDrag(coordinatorLayout, v, motionEvent);
        }
        if (this.mMotionEventCanDrag) {
            return super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V v, android.view.View view, android.view.View view2, int i, int i2) {
        if (this.mAllowDrag) {
            return super.onStartNestedScroll(coordinatorLayout, v, view, view2, i, i2);
        }
        return false;
    }
}
