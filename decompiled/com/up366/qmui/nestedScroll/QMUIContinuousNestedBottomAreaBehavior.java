package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIContinuousNestedBottomAreaBehavior extends com.up366.qmui.nestedScroll.QMUIViewOffsetBehavior<android.view.View> {
    private final android.graphics.Rect tempRect1 = new android.graphics.Rect();
    private final android.graphics.Rect tempRect2 = new android.graphics.Rect();
    private int mTopInset = 0;

    private static int resolveGravity(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    public void setTopInset(int i) {
        this.mTopInset = i;
    }

    public boolean onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 != -1 && i5 != -2) {
            return false;
        }
        int size = android.view.View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.onMeasureChild(view, i, i2, android.view.View.MeasureSpec.makeMeasureSpec(size - this.mTopInset, i5 == -1 ? com.up366.medialibrary.common.utils.PictureFileUtils.GB : com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER), i4);
        return true;
    }

    @Override // com.up366.qmui.nestedScroll.QMUIViewOffsetBehavior
    protected void layoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i) {
        java.util.List dependencies = coordinatorLayout.getDependencies(view);
        if (!dependencies.isEmpty()) {
            android.view.View view2 = (android.view.View) dependencies.get(0);
            androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams = view.getLayoutParams();
            android.graphics.Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, view2.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + view2.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            android.graphics.Rect rect2 = this.tempRect2;
            androidx.core.view.GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            return;
        }
        super.layoutChild(coordinatorLayout, view, i);
    }

    @Override // com.up366.qmui.nestedScroll.QMUIViewOffsetBehavior
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, view, i);
        java.util.List dependencies = coordinatorLayout.getDependencies(view);
        if (!dependencies.isEmpty()) {
            setTopAndBottomOffset(((android.view.View) dependencies.get(0)).getBottom() - getLayoutTop());
        }
        return zOnLayoutChild;
    }

    public boolean layoutDependsOn(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2) {
        return view2 instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView;
    }

    public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2) {
        setTopAndBottomOffset(view2.getBottom() - getLayoutTop());
        return false;
    }
}
