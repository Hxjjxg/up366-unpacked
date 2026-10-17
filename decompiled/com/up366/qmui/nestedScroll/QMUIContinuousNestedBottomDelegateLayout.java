package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIContinuousNestedBottomDelegateLayout extends com.up366.qmui.layout.QMUIFrameLayout implements androidx.core.view.NestedScrollingChild2, androidx.core.view.NestedScrollingParent2, com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView {
    private static final int INVALID_POINTER = -1;
    public static final java.lang.String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_bottom_dl_offset";
    private int activePointerId;
    private boolean isBeingDragged;
    private int lastMotionY;
    private java.lang.Runnable mCheckLayoutAction;
    private final androidx.core.view.NestedScrollingChildHelper mChildHelper;
    private android.view.View mContentView;
    private com.up366.qmui.util.QMUIViewOffsetHelper mContentViewOffsetHelper;
    private android.view.View mHeaderView;
    private com.up366.qmui.util.QMUIViewOffsetHelper mHeaderViewOffsetHelper;
    private int mNestedOffsetY;
    private com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier mOnScrollNotifier;
    private final androidx.core.view.NestedScrollingParentHelper mParentHelper;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private android.graphics.Rect mTempRect;
    private final com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.ViewFlinger mViewFlinger;
    private int touchSlop;
    private android.view.VelocityTracker velocityTracker;

    protected int getContentBottomMargin() {
        return 0;
    }

    protected int getHeaderHeightLayoutParam() {
        return -2;
    }

    protected int getHeaderStickyHeight() {
        return 0;
    }

    protected abstract android.view.View onCreateContentView();

    protected abstract android.view.View onCreateHeaderView();

    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public QMUIContinuousNestedBottomDelegateLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedBottomDelegateLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public QMUIContinuousNestedBottomDelegateLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.activePointerId = -1;
        this.touchSlop = -1;
        this.mScrollConsumed = new int[2];
        this.mScrollOffset = new int[2];
        this.mTempRect = new android.graphics.Rect();
        this.mNestedOffsetY = 0;
        this.mCheckLayoutAction = new java.lang.Runnable() { // from class: com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.1
            @Override // java.lang.Runnable
            public void run() {
                com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.checkLayout();
            }
        };
        this.mParentHelper = new androidx.core.view.NestedScrollingParentHelper(this);
        this.mChildHelper = new androidx.core.view.NestedScrollingChildHelper(this);
        androidx.core.view.ViewCompat.setNestedScrollingEnabled(this, true);
        this.mHeaderView = onCreateHeaderView();
        android.view.View viewOnCreateContentView = onCreateContentView();
        this.mContentView = viewOnCreateContentView;
        if (!(viewOnCreateContentView instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView)) {
            throw new java.lang.IllegalStateException("the view create by onCreateContentView() should implement from IQMUIContinuousNestedBottomView");
        }
        addView(this.mHeaderView, new android.widget.FrameLayout.LayoutParams(-1, getHeaderHeightLayoutParam()));
        addView(this.mContentView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.mHeaderViewOffsetHelper = new com.up366.qmui.util.QMUIViewOffsetHelper(this.mHeaderView);
        this.mContentViewOffsetHelper = new com.up366.qmui.util.QMUIViewOffsetHelper(this.mContentView);
        this.mViewFlinger = new com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.ViewFlinger();
    }

    public android.view.View getHeaderView() {
        return this.mHeaderView;
    }

    public android.view.View getContentView() {
        return this.mContentView;
    }

    public int getOffsetCurrent() {
        return -this.mHeaderViewOffsetHelper.getTopAndBottomOffset();
    }

    public int getOffsetRange() {
        return -getMiniOffset();
    }

    private int getMiniOffset() {
        int contentHeight = ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).getContentHeight();
        int headerStickyHeight = ((-this.mHeaderView.getHeight()) - ((android.widget.FrameLayout.LayoutParams) this.mHeaderView.getLayoutParams()).bottomMargin) + getHeaderStickyHeight();
        return contentHeight != -1 ? java.lang.Math.min(headerStickyHeight + (this.mContentView.getHeight() - contentHeight), 0) : headerStickyHeight;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getContentHeight() {
        int contentHeight = ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).getContentHeight();
        if (contentHeight == -1 || contentHeight > this.mContentView.getHeight()) {
            return -1;
        }
        int contentBottomMargin = getContentBottomMargin();
        if (this.mHeaderView.getHeight() + contentHeight + contentBottomMargin > getHeight()) {
            return -1;
        }
        return this.mHeaderView.getHeight() + contentHeight + contentBottomMargin;
    }

    @Override // com.up366.qmui.layout.QMUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mContentView.measure(i, android.view.View.MeasureSpec.makeMeasureSpec((android.view.View.MeasureSpec.getSize(i2) - getHeaderStickyHeight()) - getContentBottomMargin(), com.up366.medialibrary.common.utils.PictureFileUtils.GB));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.view.View view = this.mHeaderView;
        view.layout(0, 0, view.getMeasuredWidth(), this.mHeaderView.getMeasuredHeight());
        int bottom = this.mHeaderView.getBottom();
        android.view.View view2 = this.mContentView;
        view2.layout(0, bottom, view2.getMeasuredWidth(), this.mContentView.getMeasuredHeight() + bottom);
        this.mHeaderViewOffsetHelper.onViewLayout();
        this.mContentViewOffsetHelper.onViewLayout();
        postCheckLayout();
    }

    public void postCheckLayout() {
        removeCallbacks(this.mCheckLayoutAction);
        post(this.mCheckLayoutAction);
    }

    public void checkLayout() {
        int offsetCurrent = getOffsetCurrent();
        int offsetRange = getOffsetRange();
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView;
        if (offsetCurrent >= offsetRange || iQMUIContinuousNestedBottomView.getCurrentScroll() <= 0) {
            return;
        }
        iQMUIContinuousNestedBottomView.consumeScroll(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
    }

    private int offsetBy(int i) {
        int iMax;
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mHeaderView.getLayoutParams();
        int miniOffset = getMiniOffset();
        if (i > 0) {
            iMax = java.lang.Math.min(this.mHeaderView.getTop() - miniOffset, i);
        } else {
            iMax = i < 0 ? java.lang.Math.max(this.mHeaderView.getTop() - layoutParams.topMargin, i) : 0;
        }
        if (iMax != 0) {
            com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.mHeaderViewOffsetHelper;
            qMUIViewOffsetHelper.setTopAndBottomOffset(qMUIViewOffsetHelper.getTopAndBottomOffset() - iMax);
            com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper2 = this.mContentViewOffsetHelper;
            qMUIViewOffsetHelper2.setTopAndBottomOffset(qMUIViewOffsetHelper2.getTopAndBottomOffset() - iMax);
        }
        this.mOnScrollNotifier.notify(-this.mHeaderViewOffsetHelper.getTopAndBottomOffset(), this.mHeaderView.getHeight() + ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).getScrollOffsetRange());
        return i - iMax;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void consumeScroll(int i) {
        if (i == Integer.MAX_VALUE) {
            offsetBy(i);
            ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).consumeScroll(Integer.MAX_VALUE);
        } else if (i == Integer.MIN_VALUE) {
            ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).consumeScroll(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            offsetBy(i);
        } else {
            ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).consumeScroll(i);
        }
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void smoothScrollYBy(int i, int i2) {
        ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).smoothScrollYBy(i, i2);
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void stopScroll() {
        ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).stopScroll();
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getCurrentScroll() {
        return (-this.mHeaderViewOffsetHelper.getTopAndBottomOffset()) + ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).getCurrentScroll();
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getScrollOffsetRange() {
        if (getContentHeight() != -1) {
            return 0;
        }
        return (this.mHeaderView.getHeight() - getHeaderStickyHeight()) + ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).getScrollOffsetRange();
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(final com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mOnScrollNotifier = onScrollNotifier;
        android.view.KeyEvent.Callback callback = this.mContentView;
        if (callback instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) {
            ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) callback).injectScrollNotifier(new com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier() { // from class: com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.2
                @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
                public void notify(int i, int i2) {
                    onScrollNotifier.notify(i - com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.mHeaderView.getTop(), i2 + com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.mHeaderView.getHeight());
                }

                @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
                public void onScrollStateChange(android.view.View view, int i) {
                    onScrollNotifier.onScrollStateChange(view, i);
                }
            });
        }
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void saveScrollInfo(android.os.Bundle bundle) {
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, this.mHeaderViewOffsetHelper.getTopAndBottomOffset());
        android.view.KeyEvent.Callback callback = this.mContentView;
        if (callback != null) {
            ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) callback).saveScrollInfo(bundle);
        }
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void restoreScrollInfo(android.os.Bundle bundle) {
        int iConstrain = com.up366.qmui.util.QMUILangHelper.constrain(bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0), getMiniOffset(), 0);
        this.mHeaderViewOffsetHelper.setTopAndBottomOffset(iConstrain);
        this.mContentViewOffsetHelper.setTopAndBottomOffset(iConstrain);
        android.view.KeyEvent.Callback callback = this.mContentView;
        if (callback != null) {
            ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) callback).restoreScrollInfo(bundle);
        }
    }

    public boolean startNestedScroll(int i, int i2) {
        return this.mChildHelper.startNestedScroll(i, i2);
    }

    public void stopNestedScroll(int i) {
        this.mChildHelper.stopNestedScroll(i);
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.mChildHelper.hasNestedScrollingParent(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
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
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i, int i2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
        startNestedScroll(2, i2);
    }

    public void onStopNestedScroll(android.view.View view, int i) {
        this.mParentHelper.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int i5) {
        int iOffsetBy = offsetBy(i4);
        dispatchNestedScroll(0, i4 - iOffsetBy, 0, iOffsetBy, null, i5);
    }

    public void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
        int i4 = iArr[1];
        int i5 = i2 - i4;
        if (i5 > 0) {
            iArr[1] = i4 + (i5 - offsetBy(i5));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(android.view.View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        this.mViewFlinger.fling((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    private boolean isPointInHeaderBounds(int i, int i2) {
        com.up366.qmui.util.QMUIViewHelper.getDescendantRect(this, this.mHeaderView, this.mTempRect);
        return this.mTempRect.contains(i, i2);
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = android.view.VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.touchSlop
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r5.touchSlop = r0
        L12:
            int r0 = r6.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r5.isBeingDragged
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r6.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L86
            r4 = -1
            if (r0 == r2) goto L7e
            if (r0 == r1) goto L5c
            r1 = 3
            if (r0 == r1) goto L7e
            r1 = 5
            if (r0 == r1) goto L33
            goto La8
        L33:
            int r0 = r6.getActionIndex()
            if (r0 == 0) goto L5a
            float r1 = r6.getX()
            int r1 = (int) r1
            float r4 = r6.getY()
            int r4 = (int) r4
            boolean r1 = r5.isPointInHeaderBounds(r1, r4)
            if (r1 != 0) goto L5a
            float r1 = r6.getX(r0)
            int r1 = (int) r1
            float r6 = r6.getY(r0)
            int r6 = (int) r6
            boolean r6 = r5.isPointInHeaderBounds(r1, r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            r2 = r3
        L5b:
            return r2
        L5c:
            int r0 = r5.activePointerId
            if (r0 != r4) goto L61
            goto La8
        L61:
            int r0 = r6.findPointerIndex(r0)
            if (r0 != r4) goto L68
            goto La8
        L68:
            float r6 = r6.getY(r0)
            int r6 = (int) r6
            int r0 = r5.lastMotionY
            int r0 = r6 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r5.touchSlop
            if (r0 <= r1) goto La8
            r5.isBeingDragged = r2
            r5.lastMotionY = r6
            goto La8
        L7e:
            r5.isBeingDragged = r3
            r5.activePointerId = r4
            r5.stopNestedScroll(r3)
            goto La8
        L86:
            com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout$ViewFlinger r0 = r5.mViewFlinger
            r0.stop()
            r5.isBeingDragged = r3
            float r0 = r6.getX()
            int r0 = (int) r0
            float r2 = r6.getY()
            int r2 = (int) r2
            boolean r0 = r5.isPointInHeaderBounds(r0, r2)
            if (r0 == 0) goto La8
            r5.lastMotionY = r2
            int r6 = r6.getPointerId(r3)
            r5.activePointerId = r6
            r5.startNestedScroll(r1, r3)
        La8:
            boolean r6 = r5.isBeingDragged
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.touchSlop < 0) {
            this.touchSlop = android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 0) {
            this.mNestedOffsetY = 0;
        }
        android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.mNestedOffsetY);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mViewFlinger.stop();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!isPointInHeaderBounds(x, y)) {
                return false;
            }
            this.lastMotionY = y;
            this.activePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
            startNestedScroll(2, 0);
        } else {
            if (actionMasked == 1) {
                android.view.VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEventObtain);
                    this.velocityTracker.computeCurrentVelocity(1000);
                    this.mViewFlinger.fling(-((int) (this.velocityTracker.getYVelocity(this.activePointerId) + 0.5f)));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.lastMotionY - y2;
                if (!this.isBeingDragged) {
                    int iAbs = java.lang.Math.abs(i);
                    int i2 = this.touchSlop;
                    if (iAbs > i2) {
                        this.isBeingDragged = true;
                        i = i > 0 ? i - i2 : i + i2;
                    }
                }
                if (this.isBeingDragged) {
                    this.lastMotionY = y2;
                    if (i < 0 && ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) this.mContentView).getCurrentScroll() > 0) {
                        return true;
                    }
                    int[] iArr = this.mScrollConsumed;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    if (dispatchNestedPreScroll(0, i, iArr, this.mScrollOffset)) {
                        i -= this.mScrollConsumed[1];
                        int i3 = this.mScrollOffset[1];
                        this.lastMotionY = y2 - i3;
                        motionEventObtain.offsetLocation(0.0f, i3);
                        this.mNestedOffsetY += this.mScrollOffset[1];
                    }
                    int iOffsetBy = offsetBy(i);
                    if (dispatchNestedScroll(0, i - iOffsetBy, 0, iOffsetBy, this.mScrollOffset, 0)) {
                        int i4 = this.mScrollOffset[1];
                        this.lastMotionY = y2 - i4;
                        motionEventObtain.offsetLocation(0.0f, i4);
                        this.mNestedOffsetY += this.mScrollOffset[1];
                    }
                }
            } else if (actionMasked == 3) {
            }
            this.isBeingDragged = false;
            this.activePointerId = -1;
            android.view.VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
            stopNestedScroll(0);
        }
        android.view.VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    class ViewFlinger implements java.lang.Runnable {
        private int mLastFlingY;
        android.widget.OverScroller mOverScroller;
        android.view.animation.Interpolator mInterpolator = com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
        private boolean mEatRunOnAnimationRequest = false;
        private boolean mReSchedulePostAnimationCallback = false;

        ViewFlinger() {
            this.mOverScroller = new android.widget.OverScroller(com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.getContext(), com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            android.widget.OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currY = overScroller.getCurrY();
                int i = currY - this.mLastFlingY;
                this.mLastFlingY = currY;
                com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.mContentView;
                if (i <= 0 || iQMUIContinuousNestedBottomView.getCurrentScroll() < iQMUIContinuousNestedBottomView.getScrollOffsetRange()) {
                    if (!com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.mChildHelper.hasNestedScrollingParent(1)) {
                        com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.startNestedScroll(2, 1);
                    }
                    com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.consumeScroll(i);
                    postOnAnimation();
                } else {
                    stop();
                }
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
            } else {
                com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.stopNestedScroll(1);
            }
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        private void internalPostOnAnimation() {
            com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.removeCallbacks(this);
            androidx.core.view.ViewCompat.postOnAnimation(com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this, this);
        }

        public void fling(int i) {
            com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.startNestedScroll(2, 1);
            this.mLastFlingY = 0;
            if (this.mInterpolator != com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR) {
                this.mInterpolator = com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
                this.mOverScroller = new android.widget.OverScroller(com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.getContext(), com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
            }
            this.mOverScroller.fling(0, 0, 0, i, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER, Integer.MAX_VALUE, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void stop() {
            com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }
}
