package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class NestedWrapperLayout extends android.view.ViewGroup implements androidx.core.view.NestedScrollingChild3 {
    private static final java.lang.String TAG = "NestedWrapperLayout";
    private androidx.core.view.NestedScrollingChildHelper childHelper;
    private boolean consumedFling;
    private int lastTouchY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private android.view.VelocityTracker mVelocityTracker;
    private java.lang.reflect.Method methodComputeVerticalScrollExtent;
    private java.lang.reflect.Method methodComputeVerticalScrollOffset;
    private java.lang.reflect.Method methodComputeVerticalScrollRange;
    private int[] scrollConsumed;
    private int[] scrollOffset;
    private float[] yDiffHis;
    private float[] yDiffHisRaw;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedWrapperLayout(android.content.Context context) {
        this(context, null);
    }

    public NestedWrapperLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedWrapperLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.childHelper = new androidx.core.view.NestedScrollingChildHelper(this);
        this.scrollConsumed = new int[2];
        this.scrollOffset = new int[2];
        this.yDiffHis = new float[2];
        this.yDiffHisRaw = new float[2];
        this.consumedFling = true;
        setNestedScrollingEnabled(true);
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        try {
            this.methodComputeVerticalScrollOffset = android.view.View.class.getDeclaredMethod("computeVerticalScrollOffset", null);
            this.methodComputeVerticalScrollRange = android.view.View.class.getDeclaredMethod("computeVerticalScrollRange", null);
            this.methodComputeVerticalScrollExtent = android.view.View.class.getDeclaredMethod("computeVerticalScrollExtent", null);
            this.methodComputeVerticalScrollOffset.setAccessible(true);
            this.methodComputeVerticalScrollRange.setAccessible(true);
            this.methodComputeVerticalScrollExtent.setAccessible(true);
        } catch (java.lang.Exception e) {
            throw new java.lang.IllegalStateException(e);
        }
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new android.view.ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new android.view.ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new android.view.ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (getChildCount() == 0) {
            return;
        }
        if (getChildCount() > 1) {
            throw new java.lang.IllegalStateException("getChildCount() > 1");
        }
        android.view.View childAt = getChildAt(0);
        measureChildWithMargins(childAt, i, 0, i2, 0);
        int iCombineMeasuredStates = combineMeasuredStates(0, childAt.getMeasuredState());
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int i3 = iCombineMeasuredStates << 16;
        setMeasuredDimension(resolveSizeAndState(java.lang.Math.max(getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight() + childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin), i, i3), resolveSizeAndState(java.lang.Math.max(getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom() + childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin), i2, i3));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 0) {
            return;
        }
        android.view.View childAt = getChildAt(0);
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int paddingLeft = getPaddingLeft() + marginLayoutParams.leftMargin;
        int paddingTop = getPaddingTop() + marginLayoutParams.topMargin;
        childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
    }

    public void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.childHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean startNestedScroll(int i, int i2) {
        return this.childHelper.startNestedScroll(i, i2);
    }

    public void stopNestedScroll(int i) {
        this.childHelper.stopNestedScroll(i);
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.childHelper.hasNestedScrollingParent(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.childHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.childHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.childHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.childHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.childHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.childHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.childHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view) {
        if (getChildCount() > 0) {
            throw new java.lang.IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i) {
        if (getChildCount() > 0) {
            throw new java.lang.IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new java.lang.IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new java.lang.IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    private void initOrResetVelocityTracker() {
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) {
            return false;
        }
        android.view.View childAt = getChildAt(0);
        return childAt.canScrollVertically(-1) || childAt.canScrollVertically(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.views.NestedWrapperLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private int computeChildVerticalScrollOffset() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return ((java.lang.Integer) this.methodComputeVerticalScrollOffset.invoke(getChildAt(0), null)).intValue();
    }

    private int computeChildVerticalScrollRange() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return ((java.lang.Integer) this.methodComputeVerticalScrollRange.invoke(getChildAt(0), null)).intValue();
    }

    private int computeChildVerticalScrollExtent() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return ((java.lang.Integer) this.methodComputeVerticalScrollExtent.invoke(getChildAt(0), null)).intValue();
    }
}
