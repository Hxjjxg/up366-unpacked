package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIContinuousNestedTopAreaBehavior extends com.up366.qmui.nestedScroll.QMUIViewOffsetBehavior<android.view.View> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;
    private boolean isBeingDragged;
    private boolean isInFlingOrScroll;
    private boolean isInTouch;
    private int lastMotionY;
    private com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback mCallback;
    private final int[] mScrollConsumed;
    private final com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.ViewFlinger mViewFlinger;
    private int touchSlop;
    private android.view.VelocityTracker velocityTracker;

    public interface Callback {
        void onTopAreaOffset(int i);

        void onTopBehaviorFlingOrScrollEnd();

        void onTopBehaviorFlingOrScrollStart();

        void onTopBehaviorTouchBegin();

        void onTopBehaviorTouchEnd();
    }

    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2, android.view.View view3, int i, int i2) {
        return (i & 2) != 0;
    }

    public QMUIContinuousNestedTopAreaBehavior(android.content.Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedTopAreaBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollConsumed = new int[2];
        this.activePointerId = -1;
        this.touchSlop = -1;
        this.isInTouch = false;
        this.isInFlingOrScroll = false;
        this.mViewFlinger = new com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.ViewFlinger(context);
    }

    public void setCallback(com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback callback) {
        this.mCallback = callback;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r6, android.view.View r7, android.view.MotionEvent r8) {
        /*
            r5 = this;
            int r0 = r5.touchSlop
            if (r0 >= 0) goto L12
            android.content.Context r0 = r6.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r5.touchSlop = r0
        L12:
            int r0 = r8.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r5.isBeingDragged
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r8.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L96
            r4 = -1
            if (r0 == r2) goto L85
            if (r0 == r1) goto L5c
            r1 = 3
            if (r0 == r1) goto L85
            r1 = 5
            if (r0 == r1) goto L33
            goto Lba
        L33:
            int r0 = r8.getActionIndex()
            if (r0 == 0) goto L5a
            float r1 = r8.getX()
            int r1 = (int) r1
            float r4 = r8.getY()
            int r4 = (int) r4
            boolean r1 = r6.isPointInChildBounds(r7, r1, r4)
            if (r1 != 0) goto L5a
            float r1 = r8.getX(r0)
            int r1 = (int) r1
            float r8 = r8.getY(r0)
            int r8 = (int) r8
            boolean r6 = r6.isPointInChildBounds(r7, r1, r8)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            r2 = r3
        L5b:
            return r2
        L5c:
            int r6 = r5.activePointerId
            if (r6 != r4) goto L61
            goto Lba
        L61:
            int r6 = r8.findPointerIndex(r6)
            if (r6 != r4) goto L68
            goto Lba
        L68:
            float r6 = r8.getY(r6)
            int r6 = (int) r6
            int r7 = r5.lastMotionY
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r0 = r5.touchSlop
            if (r7 <= r0) goto Lba
            r5.isBeingDragged = r2
            r5.lastMotionY = r6
            com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior$Callback r6 = r5.mCallback
            if (r6 == 0) goto Lba
            r6.onTopBehaviorTouchBegin()
            goto Lba
        L85:
            r5.isInTouch = r3
            r5.isBeingDragged = r3
            r5.activePointerId = r4
            android.view.VelocityTracker r6 = r5.velocityTracker
            if (r6 == 0) goto Lba
            r6.recycle()
            r6 = 0
            r5.velocityTracker = r6
            goto Lba
        L96:
            com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior$ViewFlinger r0 = r5.mViewFlinger
            r0.stop()
            r5.isInTouch = r2
            r5.isBeingDragged = r3
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            boolean r6 = r6.isPointInChildBounds(r7, r0, r1)
            if (r6 == 0) goto Lba
            r5.lastMotionY = r1
            int r6 = r8.getPointerId(r3)
            r5.activePointerId = r6
            r5.ensureVelocityTracker()
        Lba:
            android.view.VelocityTracker r6 = r5.velocityTracker
            if (r6 == 0) goto Lc1
            r6.addMovement(r8)
        Lc1:
            boolean r6 = r5.isBeingDragged
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.MotionEvent motionEvent) {
        if (this.touchSlop < 0) {
            this.touchSlop = android.view.ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mViewFlinger.stop();
            this.isInTouch = true;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!coordinatorLayout.isPointInChildBounds(view, x, y)) {
                return false;
            }
            this.lastMotionY = y;
            this.activePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
        } else {
            if (actionMasked == 1) {
                this.isInTouch = false;
                com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onTopBehaviorTouchEnd();
                }
                android.view.VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.velocityTracker.computeCurrentVelocity(1000);
                    this.mViewFlinger.fling(coordinatorLayout, view, -((int) (this.velocityTracker.getYVelocity(this.activePointerId) + 0.5f)));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.lastMotionY - y2;
                if (!this.isBeingDragged && java.lang.Math.abs(i) > this.touchSlop) {
                    this.isBeingDragged = true;
                    com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback callback2 = this.mCallback;
                    if (callback2 != null) {
                        callback2.onTopBehaviorTouchBegin();
                    }
                    i = i > 0 ? i - this.touchSlop : i + this.touchSlop;
                }
                if (this.isBeingDragged) {
                    this.lastMotionY = y2;
                    scroll(coordinatorLayout, view, i);
                }
            } else if (actionMasked == 3) {
            }
            if (this.isInTouch) {
                this.isInTouch = false;
                com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback callback3 = this.mCallback;
                if (callback3 != null) {
                    callback3.onTopBehaviorTouchEnd();
                }
            }
            this.isBeingDragged = false;
            this.activePointerId = -1;
            android.view.VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
        }
        android.view.VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void scroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i) {
        int[] iArr = this.mScrollConsumed;
        iArr[0] = 0;
        iArr[1] = 0;
        onNestedPreScroll(coordinatorLayout, view, view, 0, i, iArr, 0);
        int iConsumeScroll = i - this.mScrollConsumed[1];
        if (view instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView) {
            iConsumeScroll = ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView) view).consumeScroll(iConsumeScroll);
        }
        int i2 = iConsumeScroll;
        onNestedScroll(coordinatorLayout, view, view, 0, i - i2, 0, i2, 0);
    }

    void smoothScrollBy(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i, int i2) {
        this.mViewFlinger.startScroll(coordinatorLayout, view, i, i2);
    }

    void stopFlingOrScroll() {
        this.mViewFlinger.stop();
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = android.view.VelocityTracker.obtain();
        }
    }

    public boolean onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        int size = android.view.View.MeasureSpec.getSize(i3);
        if (i5 == -1) {
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.onMeasureChild(view, i, i2, android.view.View.MeasureSpec.makeMeasureSpec(size, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER), i4);
            return true;
        }
        coordinatorLayout.onMeasureChild(view, i, i2, android.view.View.MeasureSpec.makeMeasureSpec(16777215, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER), i4);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2, int i, int i2, int[] iArr, int i3) {
        int height;
        int height2;
        if (view2.getParent() != coordinatorLayout) {
            return;
        }
        if (view2 == view) {
            if (i2 < 0) {
                if (view.getTop() <= i2) {
                    setTopAndBottomOffset((view.getTop() - i2) - getLayoutTop());
                    iArr[1] = iArr[1] + i2;
                    return;
                } else {
                    if (view.getTop() < 0) {
                        int top = view.getTop();
                        setTopAndBottomOffset(0 - getLayoutTop());
                        iArr[1] = iArr[1] + top;
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i2 <= 0 || !(view2 instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView)) {
            return;
        }
        int contentHeight = ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) view2).getContentHeight();
        if (contentHeight != -1) {
            height = coordinatorLayout.getHeight() - contentHeight;
            height2 = view.getHeight();
        } else {
            height = coordinatorLayout.getHeight() - view.getHeight();
            height2 = view2.getHeight();
        }
        int i4 = height - height2;
        if (view.getTop() - i2 >= i4) {
            setTopAndBottomOffset((view.getTop() - i2) - getLayoutTop());
            iArr[1] = iArr[1] + i2;
        } else if (view.getTop() > i4) {
            int top2 = view.getTop() - i4;
            setTopAndBottomOffset(i4);
            iArr[1] = iArr[1] + top2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2, int i, int i2, int i3, int i4, int i5) {
        if (view2.getParent() != coordinatorLayout) {
            return;
        }
        boolean z = false;
        if (view2 != view) {
            if (i4 < 0) {
                if (view.getTop() <= i4) {
                    setTopAndBottomOffset((view.getTop() - i4) - getLayoutTop());
                    return;
                }
                if (view.getTop() < 0) {
                    int top = view.getTop();
                    setTopAndBottomOffset(0 - getLayoutTop());
                    if (i4 != Integer.MIN_VALUE) {
                        i2 = i4 - top;
                    }
                    i4 = i2;
                }
                if (view instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView) {
                    ((com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView) view).consumeScroll(i4);
                    return;
                }
                return;
            }
            return;
        }
        if (i4 > 0) {
            android.view.View viewFindBottomView = findBottomView(coordinatorLayout);
            if (viewFindBottomView == 0 || viewFindBottomView.getVisibility() == 8) {
                int height = coordinatorLayout.getHeight();
                if (view2.getBottom() - height >= i4) {
                    setTopAndBottomOffset((view2.getTop() - i4) - getLayoutTop());
                    return;
                } else {
                    if (view2.getBottom() - height > 0) {
                        setTopAndBottomOffset((view2.getTop() - (view2.getBottom() - height)) - getLayoutTop());
                        return;
                    }
                    return;
                }
            }
            com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) viewFindBottomView;
            int contentHeight = iQMUIContinuousNestedBottomView.getContentHeight();
            int height2 = coordinatorLayout.getHeight();
            if (contentHeight != -1) {
                height2 = (coordinatorLayout.getHeight() + viewFindBottomView.getHeight()) - contentHeight;
            } else {
                z = true;
            }
            if (viewFindBottomView.getBottom() - height2 > i4) {
                setTopAndBottomOffset((view2.getTop() - i4) - getLayoutTop());
                return;
            }
            if (viewFindBottomView.getBottom() - height2 > 0) {
                int bottom = viewFindBottomView.getBottom() - height2;
                setTopAndBottomOffset((view2.getTop() - bottom) - getLayoutTop());
                if (i4 != Integer.MAX_VALUE) {
                    i4 -= bottom;
                }
            }
            if (z) {
                iQMUIContinuousNestedBottomView.consumeScroll(i4);
            }
        }
    }

    private android.view.View findBottomView(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout) {
        for (int i = 0; i < coordinatorLayout.getChildCount(); i++) {
            android.view.View childAt = coordinatorLayout.getChildAt(i);
            if (childAt instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) {
                return childAt;
            }
        }
        return null;
    }

    class ViewFlinger implements java.lang.Runnable {
        private android.view.View mCurrentChild;
        private androidx.coordinatorlayout.widget.CoordinatorLayout mCurrentParent;
        private int mLastFlingY;
        android.widget.OverScroller mOverScroller;
        android.view.animation.Interpolator mInterpolator = com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
        private boolean mEatRunOnAnimationRequest = false;
        private boolean mReSchedulePostAnimationCallback = false;

        ViewFlinger(android.content.Context context) {
            this.mOverScroller = new android.widget.OverScroller(context, com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                r0 = 0
                r5.mReSchedulePostAnimationCallback = r0
                r1 = 1
                r5.mEatRunOnAnimationRequest = r1
                android.widget.OverScroller r1 = r5.mOverScroller
                boolean r2 = r1.computeScrollOffset()
                if (r2 == 0) goto L4d
                int r1 = r1.getCurrY()
                int r2 = r5.mLastFlingY
                int r2 = r1 - r2
                r5.mLastFlingY = r1
                androidx.coordinatorlayout.widget.CoordinatorLayout r1 = r5.mCurrentParent
                if (r1 == 0) goto L4d
                android.view.View r3 = r5.mCurrentChild
                if (r3 == 0) goto L4d
                boolean r3 = r1 instanceof com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout
                if (r3 == 0) goto L41
                com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout r1 = (com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout) r1
                if (r2 <= 0) goto L33
                int r3 = r1.getCurrentScroll()
                int r4 = r1.getScrollRange()
                if (r3 < r4) goto L33
                goto L3b
            L33:
                if (r2 >= 0) goto L41
                int r1 = r1.getCurrentScroll()
                if (r1 > 0) goto L41
            L3b:
                android.widget.OverScroller r1 = r5.mOverScroller
                r1.abortAnimation()
                goto L4d
            L41:
                com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior r1 = com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.this
                androidx.coordinatorlayout.widget.CoordinatorLayout r3 = r5.mCurrentParent
                android.view.View r4 = r5.mCurrentChild
                r1.scroll(r3, r4, r2)
                r5.postOnAnimation()
            L4d:
                r5.mEatRunOnAnimationRequest = r0
                boolean r0 = r5.mReSchedulePostAnimationCallback
                if (r0 == 0) goto L57
                r5.internalPostOnAnimation()
                goto L5f
            L57:
                r0 = 0
                r5.mCurrentParent = r0
                r5.mCurrentChild = r0
                r5.onFlingOrScrollEnd()
            L5f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.ViewFlinger.run():void");
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        private void internalPostOnAnimation() {
            if (this.mCurrentChild != null) {
                this.mCurrentParent.removeCallbacks(this);
                androidx.core.view.ViewCompat.postOnAnimation(this.mCurrentChild, this);
            }
        }

        public void fling(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i) {
            onFlingOrScrollStart(coordinatorLayout, view);
            this.mOverScroller.fling(0, 0, 0, i, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER, Integer.MAX_VALUE, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void startScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i, int i2) {
            onFlingOrScrollStart(coordinatorLayout, view);
            this.mOverScroller.startScroll(0, 0, 0, i, i2);
            postOnAnimation();
        }

        private void onFlingOrScrollStart(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view) {
            com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.this.isInFlingOrScroll = true;
            if (com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.this.mCallback != null) {
                com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.this.mCallback.onTopBehaviorFlingOrScrollStart();
            }
            this.mCurrentParent = coordinatorLayout;
            this.mCurrentChild = view;
            this.mLastFlingY = 0;
            if (this.mInterpolator != com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR) {
                this.mInterpolator = com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
                this.mOverScroller = new android.widget.OverScroller(this.mCurrentParent.getContext(), com.up366.qmui.QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
            }
        }

        public void stop() {
            android.view.View view = this.mCurrentChild;
            if (view != null) {
                view.removeCallbacks(this);
            }
            this.mOverScroller.abortAnimation();
            this.mCurrentChild = null;
            this.mCurrentParent = null;
            onFlingOrScrollEnd();
        }

        private void onFlingOrScrollEnd() {
            if (com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.this.mCallback != null && com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.this.isInFlingOrScroll) {
                com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.this.mCallback.onTopBehaviorFlingOrScrollEnd();
            }
            com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.this.isInFlingOrScroll = false;
        }
    }

    @Override // com.up366.qmui.nestedScroll.QMUIViewOffsetBehavior
    public boolean setTopAndBottomOffset(int i) {
        boolean topAndBottomOffset = super.setTopAndBottomOffset(i);
        com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onTopAreaOffset(i);
        }
        return topAndBottomOffset;
    }
}
