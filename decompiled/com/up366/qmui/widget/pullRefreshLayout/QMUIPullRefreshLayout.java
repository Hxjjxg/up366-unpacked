package com.up366.qmui.widget.pullRefreshLayout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIPullRefreshLayout extends android.view.ViewGroup implements androidx.core.view.NestedScrollingParent {
    private static final int FLAG_NEED_DELIVER_VELOCITY = 8;
    private static final int FLAG_NEED_DO_REFRESH = 4;
    private static final int FLAG_NEED_SCROLL_TO_INIT_POSITION = 1;
    private static final int FLAG_NEED_SCROLL_TO_REFRESH_POSITION = 2;
    private static final int INVALID_POINTER = -1;
    private static final java.lang.String TAG = "QMUIPullRefreshLayout";
    private int mActivePointerId;
    private boolean mAutoCalculateRefreshEndOffset;
    private boolean mAutoCalculateRefreshInitOffset;
    private int mAutoScrollToRefreshMinOffset;
    private com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnChildScrollUpCallback mChildScrollUpCallback;
    private boolean mDisableNestScrollImpl;
    private float mDragRate;
    private boolean mEnableOverPull;
    private boolean mEqualTargetRefreshOffsetToRefreshViewHeight;
    private com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.IRefreshView mIRefreshView;
    private float mInitialDownX;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsDragging;
    boolean mIsRefreshing;
    private float mLastMotionY;
    private com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnPullListener mListener;
    private float mMaxVelocity;
    private float mMiniVelocity;
    private boolean mNestScrollDurationRefreshing;
    private boolean mNestedScrollInProgress;
    private final androidx.core.view.NestedScrollingParentHelper mNestedScrollingParentHelper;
    private java.lang.Runnable mPendingRefreshDirectlyAction;
    private int mRefreshCurrentOffset;
    private int mRefreshEndOffset;
    private int mRefreshInitOffset;
    private com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshOffsetCalculator mRefreshOffsetCalculator;
    private android.view.View mRefreshView;
    private int mRefreshZIndex;
    private boolean mSafeDisallowInterceptTouchEvent;
    private int mScrollFlag;
    private android.widget.Scroller mScroller;
    private int mSystemTouchSlop;
    private int mTargetCurrentOffset;
    private int mTargetInitOffset;
    private int mTargetRefreshOffset;
    private android.view.View mTargetView;
    private int mTouchSlop;
    private android.view.VelocityTracker mVelocityTracker;

    public interface IRefreshView {
        void doRefresh();

        void onPull(int i, int i2, int i3);

        void stop();
    }

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout qMUIPullRefreshLayout, android.view.View view);
    }

    public interface OnPullListener {
        void onMoveRefreshView(int i);

        void onMoveTarget(int i);

        void onRefresh();
    }

    public interface RefreshOffsetCalculator {
        int calculateRefreshOffset(int i, int i2, int i3, int i4, int i5, int i6);
    }

    private void info(java.lang.String str) {
    }

    protected void onFinishPull(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
    }

    protected void onMoveRefreshView(int i) {
    }

    protected void onMoveTargetView(int i) {
    }

    protected void onSureTargetView(android.view.View view) {
    }

    public QMUIPullRefreshLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUIPullRefreshLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUIPullRefreshLayoutStyle);
    }

    public QMUIPullRefreshLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsRefreshing = false;
        this.mRefreshZIndex = -1;
        boolean z = true;
        this.mAutoCalculateRefreshInitOffset = true;
        this.mAutoCalculateRefreshEndOffset = true;
        this.mEqualTargetRefreshOffsetToRefreshViewHeight = false;
        this.mAutoScrollToRefreshMinOffset = -1;
        this.mDisableNestScrollImpl = false;
        this.mEnableOverPull = true;
        this.mActivePointerId = -1;
        this.mDragRate = 0.65f;
        this.mScrollFlag = 0;
        this.mNestScrollDurationRefreshing = false;
        this.mPendingRefreshDirectlyAction = null;
        this.mSafeDisallowInterceptTouchEvent = false;
        setWillNotDraw(false);
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMiniVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mSystemTouchSlop = scaledTouchSlop;
        this.mTouchSlop = com.up366.qmui.util.QMUIDisplayHelper.px2dp(context, scaledTouchSlop);
        android.widget.Scroller scroller = new android.widget.Scroller(getContext());
        this.mScroller = scroller;
        scroller.setFriction(getScrollerFriction());
        addRefreshView();
        androidx.core.view.ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.mNestedScrollingParentHelper = new androidx.core.view.NestedScrollingParentHelper(this);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIPullRefreshLayout, i, 0);
        try {
            this.mRefreshInitOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPullRefreshLayout_qmui_refresh_init_offset, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            this.mRefreshEndOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPullRefreshLayout_qmui_refresh_end_offset, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            this.mTargetInitOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPullRefreshLayout_qmui_target_init_offset, 0);
            this.mTargetRefreshOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPullRefreshLayout_qmui_target_refresh_offset, com.up366.qmui.util.QMUIDisplayHelper.dp2px(getContext(), 72));
            this.mAutoCalculateRefreshInitOffset = this.mRefreshInitOffset == Integer.MIN_VALUE || typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIPullRefreshLayout_qmui_auto_calculate_refresh_init_offset, false);
            if (this.mRefreshEndOffset != Integer.MIN_VALUE && !typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIPullRefreshLayout_qmui_auto_calculate_refresh_end_offset, false)) {
                z = false;
            }
            this.mAutoCalculateRefreshEndOffset = z;
            this.mEqualTargetRefreshOffsetToRefreshViewHeight = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIPullRefreshLayout_qmui_equal_target_refresh_offset_to_refresh_view_height, false);
            typedArrayObtainStyledAttributes.recycle();
            this.mRefreshCurrentOffset = this.mRefreshInitOffset;
            this.mTargetCurrentOffset = this.mTargetInitOffset;
        } catch (java.lang.Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean defaultCanScrollUp(android.view.View view) {
        if (view == 0) {
            return false;
        }
        if (view instanceof com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout) {
            return ((com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout) view).getCurrentScroll() > 0;
        }
        if (view instanceof com.up366.qmui.widget.section.QMUIStickySectionLayout) {
            return defaultCanScrollUp(((com.up366.qmui.widget.section.QMUIStickySectionLayout) view).getRecyclerView());
        }
        return androidx.core.view.ViewCompat.canScrollVertically(view, -1);
    }

    public void setOnPullListener(com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnPullListener onPullListener) {
        this.mListener = onPullListener;
    }

    public void setDisableNestScrollImpl(boolean z) {
        this.mDisableNestScrollImpl = z;
    }

    public void setDragRate(float f) {
        this.mDisableNestScrollImpl = true;
        this.mDragRate = f;
    }

    public void setChildScrollUpCallback(com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnChildScrollUpCallback onChildScrollUpCallback) {
        this.mChildScrollUpCallback = onChildScrollUpCallback;
    }

    protected float getScrollerFriction() {
        return android.view.ViewConfiguration.getScrollFriction();
    }

    public void setAutoScrollToRefreshMinOffset(int i) {
        this.mAutoScrollToRefreshMinOffset = i;
    }

    protected android.view.View createRefreshView() {
        return new com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshView(getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addRefreshView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = createRefreshView();
        }
        android.view.View view = this.mRefreshView;
        if (!(view instanceof com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.IRefreshView)) {
            throw new java.lang.RuntimeException("refreshView must be a instance of IRefreshView");
        }
        this.mIRefreshView = (com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.IRefreshView) view;
        if (view.getLayoutParams() == null) {
            this.mRefreshView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        }
        addView(this.mRefreshView);
    }

    public void setRefreshOffsetCalculator(com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshOffsetCalculator refreshOffsetCalculator) {
        this.mRefreshOffsetCalculator = refreshOffsetCalculator;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mRefreshZIndex;
        return i3 < 0 ? i2 : i2 == i3 ? i - 1 : i2 > i3 ? i2 - 1 : i2;
    }

    public void openSafeDisallowInterceptTouchEvent() {
        this.mSafeDisallowInterceptTouchEvent = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.mSafeDisallowInterceptTouchEvent) {
            super.requestDisallowInterceptTouchEvent(z);
            this.mSafeDisallowInterceptTouchEvent = false;
        }
        android.view.View view = this.mTargetView;
        if (view == null || androidx.core.view.ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        ensureTargetView();
        if (this.mTargetView == null) {
            android.util.Log.d(TAG, "onMeasure: mTargetView == null");
            return;
        }
        this.mTargetView.measure(android.view.View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), com.up366.medialibrary.common.utils.PictureFileUtils.GB), android.view.View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), com.up366.medialibrary.common.utils.PictureFileUtils.GB));
        measureChild(this.mRefreshView, i, i2);
        this.mRefreshZIndex = -1;
        int i4 = 0;
        while (true) {
            if (i4 >= getChildCount()) {
                break;
            }
            if (getChildAt(i4) == this.mRefreshView) {
                this.mRefreshZIndex = i4;
                break;
            }
            i4++;
        }
        int measuredHeight = this.mRefreshView.getMeasuredHeight();
        if (this.mAutoCalculateRefreshInitOffset && this.mRefreshInitOffset != (i3 = -measuredHeight)) {
            this.mRefreshInitOffset = i3;
            this.mRefreshCurrentOffset = i3;
        }
        if (this.mEqualTargetRefreshOffsetToRefreshViewHeight) {
            this.mTargetRefreshOffset = measuredHeight;
        }
        if (this.mAutoCalculateRefreshEndOffset) {
            this.mRefreshEndOffset = (this.mTargetRefreshOffset - measuredHeight) / 2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        ensureTargetView();
        if (this.mTargetView == null) {
            android.util.Log.d(TAG, "onLayout: mTargetView == null");
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int paddingTop2 = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        android.view.View view = this.mTargetView;
        int i5 = this.mTargetCurrentOffset;
        view.layout(paddingLeft, paddingTop + i5, paddingLeft2 + paddingLeft, paddingTop + paddingTop2 + i5);
        int measuredWidth2 = this.mRefreshView.getMeasuredWidth();
        int measuredHeight2 = this.mRefreshView.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.mRefreshCurrentOffset;
        this.mRefreshView.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            r3.ensureTargetView()
            int r0 = r4.getAction()
            boolean r1 = r3.isEnabled()
            r2 = 0
            if (r1 == 0) goto L6c
            boolean r1 = r3.canChildScrollUp()
            if (r1 != 0) goto L6c
            boolean r1 = r3.mNestedScrollInProgress
            if (r1 == 0) goto L19
            goto L6c
        L19:
            if (r0 == 0) goto L4e
            r1 = 1
            if (r0 == r1) goto L48
            r1 = 2
            if (r0 == r1) goto L2c
            r1 = 3
            if (r0 == r1) goto L48
            r1 = 6
            if (r0 == r1) goto L28
            goto L69
        L28:
            r3.onSecondaryPointerUp(r4)
            goto L69
        L2c:
            int r0 = r3.mActivePointerId
            int r0 = r4.findPointerIndex(r0)
            if (r0 >= 0) goto L3c
            java.lang.String r4 = "QMUIPullRefreshLayout"
            java.lang.String r0 = "Got ACTION_MOVE event but have an invalid active pointer id."
            android.util.Log.e(r4, r0)
            return r2
        L3c:
            float r1 = r4.getX(r0)
            float r4 = r4.getY(r0)
            r3.startDragging(r1, r4)
            goto L69
        L48:
            r3.mIsDragging = r2
            r4 = -1
            r3.mActivePointerId = r4
            goto L69
        L4e:
            r3.mIsDragging = r2
            int r0 = r4.getPointerId(r2)
            r3.mActivePointerId = r0
            int r0 = r4.findPointerIndex(r0)
            if (r0 >= 0) goto L5d
            return r2
        L5d:
            float r1 = r4.getX(r0)
            r3.mInitialDownX = r1
            float r4 = r4.getY(r0)
            r3.mInitialDownY = r4
        L69:
            boolean r4 = r3.mIsDragging
            return r4
        L6c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!isEnabled() || canChildScrollUp() || this.mNestedScrollInProgress) {
            android.util.Log.d(TAG, "fast end onTouchEvent: isEnabled = " + isEnabled() + "; canChildScrollUp = " + canChildScrollUp() + " ; mNestedScrollInProgress = " + this.mNestedScrollInProgress);
            return false;
        }
        acquireVelocityTracker(motionEvent);
        if (action != 0) {
            if (action == 1) {
                if (motionEvent.findPointerIndex(this.mActivePointerId) < 0) {
                    android.util.Log.e(TAG, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.mIsDragging) {
                    this.mIsDragging = false;
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    finishPull((int) (java.lang.Math.abs(yVelocity) >= this.mMiniVelocity ? yVelocity : 0.0f));
                }
                this.mActivePointerId = -1;
                releaseVelocityTracker();
                return false;
            }
            if (action == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex < 0) {
                    android.util.Log.e(TAG, "onTouchEvent Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                startDragging(x, y);
                if (this.mIsDragging) {
                    float f = (y - this.mLastMotionY) * this.mDragRate;
                    if (f >= 0.0f) {
                        moveTargetView(f, true);
                    } else {
                        float fAbs = java.lang.Math.abs(f) - java.lang.Math.abs(moveTargetView(f, true));
                        if (fAbs > 0.0f) {
                            motionEvent.setAction(0);
                            float f2 = this.mSystemTouchSlop + 1;
                            if (fAbs <= f2) {
                                fAbs = f2;
                            }
                            motionEvent.offsetLocation(0.0f, fAbs);
                            super.dispatchTouchEvent(motionEvent);
                            motionEvent.setAction(action);
                            motionEvent.offsetLocation(0.0f, -fAbs);
                            super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    this.mLastMotionY = y;
                }
            } else {
                if (action == 3) {
                    releaseVelocityTracker();
                    return false;
                }
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        android.util.Log.e(TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            }
        } else {
            this.mIsDragging = false;
            this.mScrollFlag = 0;
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        return true;
    }

    private void ensureTargetView() {
        java.lang.Runnable runnable;
        if (this.mTargetView == null) {
            int i = 0;
            while (true) {
                if (i >= getChildCount()) {
                    break;
                }
                android.view.View childAt = getChildAt(i);
                if (!childAt.equals(this.mRefreshView)) {
                    onSureTargetView(childAt);
                    this.mTargetView = childAt;
                    break;
                }
                i++;
            }
        }
        if (this.mTargetView == null || (runnable = this.mPendingRefreshDirectlyAction) == null) {
            return;
        }
        this.mPendingRefreshDirectlyAction = null;
        runnable.run();
    }

    private void finishPull(int i) {
        info("finishPull: vy = " + i + " ; mTargetCurrentOffset = " + this.mTargetCurrentOffset + " ; mTargetRefreshOffset = " + this.mTargetRefreshOffset + " ; mTargetInitOffset = " + this.mTargetInitOffset + " ; mScroller.isFinished() = " + this.mScroller.isFinished());
        int i2 = i / 1000;
        onFinishPull(i2, this.mRefreshInitOffset, this.mRefreshEndOffset, this.mRefreshView.getHeight(), this.mTargetCurrentOffset, this.mTargetInitOffset, this.mTargetRefreshOffset);
        int i3 = this.mTargetCurrentOffset;
        int i4 = this.mTargetRefreshOffset;
        if (i3 >= i4) {
            if (i2 > 0) {
                this.mScrollFlag = 6;
                this.mScroller.fling(0, i3, 0, i2, 0, 0, this.mTargetInitOffset, Integer.MAX_VALUE);
                invalidate();
                return;
            }
            if (i2 < 0) {
                this.mScroller.fling(0, i3, 0, i, 0, 0, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER, Integer.MAX_VALUE);
                if (this.mScroller.getFinalY() < this.mTargetInitOffset) {
                    this.mScrollFlag = 8;
                } else if (this.mScroller.getFinalY() < this.mTargetRefreshOffset) {
                    int i5 = this.mTargetInitOffset;
                    int i6 = this.mTargetCurrentOffset;
                    this.mScroller.startScroll(0, i6, 0, i5 - i6);
                } else {
                    int finalY = this.mScroller.getFinalY();
                    int i7 = this.mTargetRefreshOffset;
                    if (finalY == i7) {
                        this.mScrollFlag = 4;
                    } else {
                        android.widget.Scroller scroller = this.mScroller;
                        int i8 = this.mTargetCurrentOffset;
                        scroller.startScroll(0, i8, 0, i7 - i8);
                        this.mScrollFlag = 4;
                    }
                }
                invalidate();
                return;
            }
            if (i3 > i4) {
                this.mScroller.startScroll(0, i3, 0, i4 - i3);
            }
            this.mScrollFlag = 4;
            invalidate();
            return;
        }
        if (i2 > 0) {
            this.mScroller.fling(0, i3, 0, i2, 0, 0, this.mTargetInitOffset, Integer.MAX_VALUE);
            if (this.mScroller.getFinalY() > this.mTargetRefreshOffset) {
                this.mScrollFlag = 6;
            } else if (this.mAutoScrollToRefreshMinOffset >= 0 && this.mScroller.getFinalY() > this.mAutoScrollToRefreshMinOffset) {
                android.widget.Scroller scroller2 = this.mScroller;
                int i9 = this.mTargetCurrentOffset;
                scroller2.startScroll(0, i9, 0, this.mTargetRefreshOffset - i9);
                this.mScrollFlag = 4;
            } else {
                this.mScrollFlag = 1;
            }
            invalidate();
            return;
        }
        if (i2 < 0) {
            this.mScrollFlag = 0;
            this.mScroller.fling(0, i3, 0, i, 0, 0, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER, Integer.MAX_VALUE);
            int finalY2 = this.mScroller.getFinalY();
            int i10 = this.mTargetInitOffset;
            if (finalY2 < i10) {
                this.mScrollFlag = 8;
            } else {
                android.widget.Scroller scroller3 = this.mScroller;
                int i11 = this.mTargetCurrentOffset;
                scroller3.startScroll(0, i11, 0, i10 - i11);
                this.mScrollFlag = 0;
            }
            invalidate();
            return;
        }
        int i12 = this.mTargetInitOffset;
        if (i3 == i12) {
            return;
        }
        int i13 = this.mAutoScrollToRefreshMinOffset;
        if (i13 >= 0 && i3 >= i13) {
            this.mScroller.startScroll(0, i3, 0, i4 - i3);
            this.mScrollFlag = 4;
        } else {
            this.mScroller.startScroll(0, i3, 0, i12 - i3);
            this.mScrollFlag = 0;
        }
        invalidate();
    }

    protected void onRefresh() {
        if (this.mIsRefreshing) {
            return;
        }
        this.mIsRefreshing = true;
        this.mIRefreshView.doRefresh();
        com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnPullListener onPullListener = this.mListener;
        if (onPullListener != null) {
            onPullListener.onRefresh();
        }
    }

    public void finishRefresh() {
        this.mIsRefreshing = false;
        this.mIRefreshView.stop();
        this.mScrollFlag = 1;
        this.mScroller.forceFinished(true);
        invalidate();
    }

    public void setToRefreshDirectly() {
        setToRefreshDirectly(0L);
    }

    public void setToRefreshDirectly(final long j) {
        if (this.mTargetView != null) {
            postDelayed(new java.lang.Runnable() { // from class: com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout qMUIPullRefreshLayout = com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.this;
                    qMUIPullRefreshLayout.setTargetViewToTop(qMUIPullRefreshLayout.mTargetView);
                    com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.this.onRefresh();
                    com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.this.mScrollFlag = 2;
                    com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.this.invalidate();
                }
            }, j);
        } else {
            this.mPendingRefreshDirectlyAction = new java.lang.Runnable() { // from class: com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.this.setToRefreshDirectly(j);
                }
            };
        }
    }

    public void setEnableOverPull(boolean z) {
        this.mEnableOverPull = z;
    }

    protected void setTargetViewToTop(android.view.View view) {
        if (view instanceof androidx.recyclerview.widget.RecyclerView) {
            ((androidx.recyclerview.widget.RecyclerView) view).scrollToPosition(0);
        } else if (view instanceof android.widget.AbsListView) {
            ((android.widget.AbsListView) view).setSelectionFromTop(0, 0);
        } else {
            view.scrollTo(0, 0);
        }
    }

    private void onSecondaryPointerUp(android.view.MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public void reset() {
        moveTargetViewTo(this.mTargetInitOffset, false);
        this.mIRefreshView.stop();
        this.mIsRefreshing = false;
        this.mScroller.forceFinished(true);
        this.mScrollFlag = 0;
    }

    protected void startDragging(float f, float f2) {
        float f3 = f - this.mInitialDownX;
        float f4 = f2 - this.mInitialDownY;
        if (isYDrag(f3, f4)) {
            int i = this.mTouchSlop;
            if ((f4 > i || (f4 < (-i) && this.mTargetCurrentOffset > this.mTargetInitOffset)) && !this.mIsDragging) {
                float f5 = this.mInitialDownY + i;
                this.mInitialMotionY = f5;
                this.mLastMotionY = f5;
                this.mIsDragging = true;
            }
        }
    }

    protected boolean isYDrag(float f, float f2) {
        return java.lang.Math.abs(f2) > java.lang.Math.abs(f);
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        reset();
        invalidate();
    }

    public boolean canChildScrollUp() {
        com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnChildScrollUpCallback onChildScrollUpCallback = this.mChildScrollUpCallback;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.mTargetView);
        }
        return defaultCanScrollUp(this.mTargetView);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i) {
        info("onStartNestedScroll: nestedScrollAxes = " + i);
        return (this.mDisableNestScrollImpl || !isEnabled() || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i) {
        info("onNestedScrollAccepted: axes = " + i);
        this.mScroller.abortAnimation();
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        this.mNestedScrollInProgress = true;
        this.mIsDragging = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr) {
        info("onNestedPreScroll: dx = " + i + " ; dy = " + i2);
        int i3 = this.mTargetCurrentOffset;
        int i4 = this.mTargetInitOffset;
        int i5 = i3 - i4;
        if (i2 <= 0 || i5 <= 0) {
            return;
        }
        if (i2 >= i5) {
            iArr[1] = i5;
            moveTargetViewTo(i4, true);
        } else {
            iArr[1] = i2;
            moveTargetView(-i2, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4) {
        info("onNestedScroll: dxConsumed = " + i + " ; dyConsumed = " + i2 + " ; dxUnconsumed = " + i3 + " ; dyUnconsumed = " + i4);
        if (i4 >= 0 || canChildScrollUp() || !this.mScroller.isFinished() || this.mScrollFlag != 0) {
            return;
        }
        moveTargetView(-i4, true);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(android.view.View view) {
        info("onStopNestedScroll: mNestedScrollInProgress = " + this.mNestedScrollInProgress);
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        if (this.mNestedScrollInProgress) {
            this.mNestedScrollInProgress = false;
            this.mIsDragging = false;
            if (this.mNestScrollDurationRefreshing) {
                return;
            }
            finishPull(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        info("onNestedPreFling: mTargetCurrentOffset = " + this.mTargetCurrentOffset + " ; velocityX = " + f + " ; velocityY = " + f2);
        if (this.mTargetCurrentOffset <= this.mTargetInitOffset) {
            return false;
        }
        this.mNestedScrollInProgress = false;
        this.mIsDragging = false;
        if (this.mNestScrollDurationRefreshing) {
            return true;
        }
        finishPull((int) (-f2));
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        try {
            return super.onNestedFling(view, f, f2, z);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private int moveTargetView(float f, boolean z) {
        return moveTargetViewTo((int) (this.mTargetCurrentOffset + f), z);
    }

    private int moveTargetViewTo(int i, boolean z) {
        return moveTargetViewTo(i, z, false);
    }

    private int moveTargetViewTo(int i, boolean z, boolean z2) {
        int iCalculateTargetOffset = calculateTargetOffset(i, this.mTargetInitOffset, this.mTargetRefreshOffset, this.mEnableOverPull);
        int i2 = this.mTargetCurrentOffset;
        if (iCalculateTargetOffset == i2 && !z2) {
            return 0;
        }
        int i3 = iCalculateTargetOffset - i2;
        androidx.core.view.ViewCompat.offsetTopAndBottom(this.mTargetView, i3);
        this.mTargetCurrentOffset = iCalculateTargetOffset;
        int i4 = this.mTargetRefreshOffset;
        int i5 = this.mTargetInitOffset;
        int i6 = i4 - i5;
        if (z) {
            this.mIRefreshView.onPull(java.lang.Math.min(iCalculateTargetOffset - i5, i6), i6, this.mTargetCurrentOffset - this.mTargetRefreshOffset);
        }
        onMoveTargetView(this.mTargetCurrentOffset);
        com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnPullListener onPullListener = this.mListener;
        if (onPullListener != null) {
            onPullListener.onMoveTarget(this.mTargetCurrentOffset);
        }
        if (this.mRefreshOffsetCalculator == null) {
            this.mRefreshOffsetCalculator = new com.up366.qmui.widget.pullRefreshLayout.QMUIDefaultRefreshOffsetCalculator();
        }
        int iCalculateRefreshOffset = this.mRefreshOffsetCalculator.calculateRefreshOffset(this.mRefreshInitOffset, this.mRefreshEndOffset, this.mRefreshView.getHeight(), this.mTargetCurrentOffset, this.mTargetInitOffset, this.mTargetRefreshOffset);
        int i7 = this.mRefreshCurrentOffset;
        if (iCalculateRefreshOffset != i7) {
            androidx.core.view.ViewCompat.offsetTopAndBottom(this.mRefreshView, iCalculateRefreshOffset - i7);
            this.mRefreshCurrentOffset = iCalculateRefreshOffset;
            onMoveRefreshView(iCalculateRefreshOffset);
            com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnPullListener onPullListener2 = this.mListener;
            if (onPullListener2 != null) {
                onPullListener2.onMoveRefreshView(this.mRefreshCurrentOffset);
            }
        }
        return i3;
    }

    protected int calculateTargetOffset(int i, int i2, int i3, boolean z) {
        int iMax = java.lang.Math.max(i, i2);
        return !z ? java.lang.Math.min(iMax, i3) : iMax;
    }

    private void acquireVelocityTracker(android.view.MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void releaseVelocityTracker() {
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public int getRefreshInitOffset() {
        return this.mRefreshInitOffset;
    }

    public int getRefreshEndOffset() {
        return this.mRefreshEndOffset;
    }

    public int getTargetInitOffset() {
        return this.mTargetInitOffset;
    }

    public int getTargetRefreshOffset() {
        return this.mTargetRefreshOffset;
    }

    public void setTargetRefreshOffset(int i) {
        this.mEqualTargetRefreshOffsetToRefreshViewHeight = false;
        this.mTargetRefreshOffset = i;
    }

    public android.view.View getTargetView() {
        return this.mTargetView;
    }

    private boolean hasFlag(int i) {
        return (this.mScrollFlag & i) == i;
    }

    private void removeFlag(int i) {
        this.mScrollFlag = (~i) & this.mScrollFlag;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            moveTargetViewTo(currY, false);
            if (currY <= 0 && hasFlag(8)) {
                deliverVelocity();
                this.mScroller.forceFinished(true);
            }
            invalidate();
            return;
        }
        if (hasFlag(1)) {
            removeFlag(1);
            int i = this.mTargetCurrentOffset;
            int i2 = this.mTargetInitOffset;
            if (i != i2) {
                this.mScroller.startScroll(0, i, 0, i2 - i);
            }
            invalidate();
            return;
        }
        if (hasFlag(2)) {
            removeFlag(2);
            int i3 = this.mTargetCurrentOffset;
            int i4 = this.mTargetRefreshOffset;
            if (i3 != i4) {
                this.mScroller.startScroll(0, i3, 0, i4 - i3);
            } else {
                moveTargetViewTo(i4, false, true);
            }
            invalidate();
            return;
        }
        if (hasFlag(4)) {
            removeFlag(4);
            onRefresh();
            moveTargetViewTo(this.mTargetRefreshOffset, false, true);
            return;
        }
        deliverVelocity();
    }

    private void deliverVelocity() {
        if (hasFlag(8)) {
            removeFlag(8);
            if (this.mScroller.getCurrVelocity() > this.mMiniVelocity) {
                info("deliver velocity: " + this.mScroller.getCurrVelocity());
                androidx.recyclerview.widget.RecyclerView recyclerView = this.mTargetView;
                if (recyclerView instanceof androidx.recyclerview.widget.RecyclerView) {
                    recyclerView.fling(0, (int) this.mScroller.getCurrVelocity());
                } else if (recyclerView instanceof android.widget.AbsListView) {
                    ((android.widget.AbsListView) this.mTargetView).fling((int) this.mScroller.getCurrVelocity());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 0) {
            if (!this.mIsRefreshing && (this.mScrollFlag & 4) == 0) {
                z = false;
            }
            this.mNestScrollDurationRefreshing = z;
        } else if (this.mNestScrollDurationRefreshing) {
            if (action == 2) {
                if (!this.mIsRefreshing && this.mScroller.isFinished() && this.mScrollFlag == 0) {
                    motionEvent.offsetLocation(0.0f, (-this.mSystemTouchSlop) - 1);
                    motionEvent.setAction(0);
                    super.dispatchTouchEvent(motionEvent);
                    this.mNestScrollDurationRefreshing = false;
                    motionEvent.setAction(action);
                    motionEvent.offsetLocation(0.0f, this.mSystemTouchSlop + 1);
                }
            } else {
                this.mNestScrollDurationRefreshing = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public static class RefreshView extends androidx.appcompat.widget.AppCompatImageView implements com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.IRefreshView, com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
        static final int CIRCLE_DIAMETER = 40;
        static final int CIRCLE_DIAMETER_LARGE = 56;
        private static final int MAX_ALPHA = 255;
        private static final float TRIM_OFFSET = 0.4f;
        private static final float TRIM_RATE = 0.85f;
        private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultSkinAttrs;
        private int mCircleDiameter;
        private androidx.swiperefreshlayout.widget.CircularProgressDrawable mProgress;

        static {
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(4);
            sDefaultSkinAttrs = simpleArrayMap;
            simpleArrayMap.put(com.up366.qmui.skin.QMUISkinValueBuilder.TINT_COLOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_pull_refresh_view_color));
        }

        public RefreshView(android.content.Context context) {
            super(context);
            this.mProgress = new androidx.swiperefreshlayout.widget.CircularProgressDrawable(context);
            setColorSchemeColors(com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_pull_refresh_view_color));
            this.mProgress.setStyle(0);
            this.mProgress.setAlpha(MAX_ALPHA);
            this.mProgress.setArrowScale(0.8f);
            setImageDrawable(this.mProgress);
            this.mCircleDiameter = (int) (getResources().getDisplayMetrics().density * 40.0f);
        }

        protected void onMeasure(int i, int i2) {
            int i3 = this.mCircleDiameter;
            setMeasuredDimension(i3, i3);
        }

        @Override // com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.IRefreshView
        public void onPull(int i, int i2, int i3) {
            if (this.mProgress.isRunning()) {
                return;
            }
            float f = i;
            float f2 = i2;
            float f3 = (TRIM_RATE * f) / f2;
            float f4 = (f * TRIM_OFFSET) / f2;
            if (i3 > 0) {
                f4 += (i3 * TRIM_OFFSET) / f2;
            }
            this.mProgress.setArrowEnabled(true);
            this.mProgress.setStartEndTrim(0.0f, f3);
            this.mProgress.setProgressRotation(f4);
        }

        public void setSize(int i) {
            if (i == 0 || i == 1) {
                android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                if (i == 0) {
                    this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
                } else {
                    this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
                }
                setImageDrawable(null);
                this.mProgress.setStyle(i);
                setImageDrawable(this.mProgress);
            }
        }

        @Override // com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.IRefreshView
        public void stop() {
            this.mProgress.stop();
        }

        @Override // com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.IRefreshView
        public void doRefresh() {
            this.mProgress.start();
        }

        public void setColorSchemeResources(int... iArr) {
            android.content.Context context = getContext();
            int[] iArr2 = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                iArr2[i] = androidx.core.content.ContextCompat.getColor(context, iArr[i]);
            }
            setColorSchemeColors(iArr2);
        }

        public void setColorSchemeColors(int... iArr) {
            this.mProgress.setColorSchemeColors(iArr);
        }

        @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
        public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
            return sDefaultSkinAttrs;
        }
    }
}
