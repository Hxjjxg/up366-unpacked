package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ListItemDragLayout extends android.widget.FrameLayout {
    private static final java.lang.String TAG = "ListItemDragLayout";
    private static java.util.Set<com.up366.mobile.common.views.ListItemDragLayout> sets = new java.util.HashSet();
    private static final float speed = 10.0f;
    android.widget.FrameLayout content;
    android.graphics.PointF downPos;
    android.view.View dragView;
    boolean enable;
    boolean hasClick;
    private com.up366.mobile.common.views.ListItemDragLayout.OnDragListener mDragListener;
    private androidx.customview.widget.ViewDragHelper mDragger;
    android.view.View vLeft;
    private int vLw;
    android.view.View vRight;
    private int vRw;
    private int visibility;

    public interface OnDragListener {
        void onDragIn();

        void onDragOut();
    }

    public ListItemDragLayout(android.content.Context context) {
        this(context, null);
    }

    public ListItemDragLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListItemDragLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hasClick = false;
        this.downPos = new android.graphics.PointF();
        this.enable = true;
        init();
    }

    private void init() {
        this.mDragger = androidx.customview.widget.ViewDragHelper.create(this, 1.0f, new androidx.customview.widget.ViewDragHelper.Callback() { // from class: com.up366.mobile.common.views.ListItemDragLayout.1
            public int clampViewPositionVertical(android.view.View view, int i, int i2) {
                return 0;
            }

            public boolean tryCaptureView(android.view.View view, int i) {
                com.up366.mobile.common.views.ListItemDragLayout.this.dragView = view;
                if (view == com.up366.mobile.common.views.ListItemDragLayout.this.vLeft) {
                    return true;
                }
                android.view.View view2 = com.up366.mobile.common.views.ListItemDragLayout.this.vRight;
                return true;
            }

            public int clampViewPositionHorizontal(android.view.View view, int i, int i2) {
                com.up366.mobile.common.views.ListItemDragLayout.this.postInvalidate();
                if (view != com.up366.mobile.common.views.ListItemDragLayout.this.vLeft) {
                    return i2 > 0 ? i < com.up366.mobile.common.views.ListItemDragLayout.this.vLw ? i : com.up366.mobile.common.views.ListItemDragLayout.this.vLw : i > com.up366.mobile.common.views.ListItemDragLayout.this.vLw - com.up366.mobile.common.views.ListItemDragLayout.this.vRw ? i : com.up366.mobile.common.views.ListItemDragLayout.this.vLw - com.up366.mobile.common.views.ListItemDragLayout.this.vRw;
                }
                if (i2 <= 0) {
                    return i > (-com.up366.mobile.common.views.ListItemDragLayout.this.vRw) ? i : -com.up366.mobile.common.views.ListItemDragLayout.this.vRw;
                }
                if (i < 0) {
                    return i;
                }
                return 0;
            }

            public void onViewPositionChanged(android.view.View view, int i, int i2, int i3, int i4) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                if (view == com.up366.mobile.common.views.ListItemDragLayout.this.vLeft) {
                    com.up366.mobile.common.views.ListItemDragLayout.this.vRight.offsetLeftAndRight(i3);
                }
                if (view == com.up366.mobile.common.views.ListItemDragLayout.this.vRight) {
                    com.up366.mobile.common.views.ListItemDragLayout.this.vLeft.offsetLeftAndRight(i3);
                }
            }

            public int getViewHorizontalDragRange(android.view.View view) {
                return com.up366.mobile.common.views.ListItemDragLayout.this.getMeasuredWidth();
            }

            public void onViewReleased(android.view.View view, float f, float f2) {
                if (com.up366.mobile.common.views.ListItemDragLayout.this.hasClick && com.up366.mobile.common.views.ListItemDragLayout.this.vLeft.getLeft() < 0) {
                    if (view == com.up366.mobile.common.views.ListItemDragLayout.this.vLeft) {
                        if (com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener != null) {
                            com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener.onDragIn();
                        }
                        com.up366.mobile.common.views.ListItemDragLayout.this.mDragger.settleCapturedViewAt(0, 0);
                        com.up366.mobile.common.views.ListItemDragLayout.this.postInvalidate();
                        return;
                    }
                    android.view.View view2 = com.up366.mobile.common.views.ListItemDragLayout.this.vRight;
                    return;
                }
                if (java.lang.Math.abs(f) > 40.0f) {
                    if (view == com.up366.mobile.common.views.ListItemDragLayout.this.vLeft) {
                        int i = f < 0.0f ? -com.up366.mobile.common.views.ListItemDragLayout.this.vRw : 0;
                        if (i == 0 && com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener != null) {
                            com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener.onDragIn();
                        } else if (i != 0 && com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener != null) {
                            com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener.onDragOut();
                        }
                        com.up366.mobile.common.views.ListItemDragLayout.this.mDragger.settleCapturedViewAt(i, 0);
                        com.up366.mobile.common.views.ListItemDragLayout.this.postInvalidate();
                        return;
                    }
                    if (view == com.up366.mobile.common.views.ListItemDragLayout.this.vRight) {
                        int i2 = com.up366.mobile.common.views.ListItemDragLayout.this.vLw;
                        if (f < 0.0f) {
                            i2 = com.up366.mobile.common.views.ListItemDragLayout.this.vLw - com.up366.mobile.common.views.ListItemDragLayout.this.vRw;
                        }
                        if (com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener != null) {
                            com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener.onDragOut();
                        }
                        com.up366.mobile.common.views.ListItemDragLayout.this.mDragger.settleCapturedViewAt(i2, 0);
                        com.up366.mobile.common.views.ListItemDragLayout.this.postInvalidate();
                        return;
                    }
                    return;
                }
                int left = (com.up366.mobile.common.views.ListItemDragLayout.this.vRw / 2) + com.up366.mobile.common.views.ListItemDragLayout.this.vLeft.getLeft();
                if (view == com.up366.mobile.common.views.ListItemDragLayout.this.vLeft) {
                    int i3 = left < 0 ? -com.up366.mobile.common.views.ListItemDragLayout.this.vRw : 0;
                    if (i3 == 0 && com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener != null) {
                        com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener.onDragIn();
                    } else if (i3 != 0 && com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener != null) {
                        com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener.onDragOut();
                    }
                    com.up366.mobile.common.views.ListItemDragLayout.this.mDragger.settleCapturedViewAt(i3, 0);
                    com.up366.mobile.common.views.ListItemDragLayout.this.postInvalidate();
                    return;
                }
                if (view == com.up366.mobile.common.views.ListItemDragLayout.this.vRight) {
                    int i4 = com.up366.mobile.common.views.ListItemDragLayout.this.vLw;
                    if (left < 0) {
                        i4 = com.up366.mobile.common.views.ListItemDragLayout.this.vLw - com.up366.mobile.common.views.ListItemDragLayout.this.vRw;
                    }
                    if (com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener != null) {
                        com.up366.mobile.common.views.ListItemDragLayout.this.mDragListener.onDragOut();
                    }
                    com.up366.mobile.common.views.ListItemDragLayout.this.mDragger.settleCapturedViewAt(i4, 0);
                    com.up366.mobile.common.views.ListItemDragLayout.this.postInvalidate();
                }
            }
        });
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mDragger.continueSettling(true)) {
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.enable) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            if (motionEvent.getPointerId(0) != 0) {
                motionEvent.setAction(3);
                return this.mDragger.shouldInterceptTouchEvent(motionEvent);
            }
            initDragView(this.vLeft, motionEvent);
            initDragView(this.vRight, motionEvent);
            this.downPos.set(motionEvent.getX(), motionEvent.getY());
        }
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() - motionEvent.getDownTime() < 200 && java.lang.Math.abs(this.downPos.x - motionEvent.getX()) + java.lang.Math.abs(this.downPos.y - motionEvent.getY()) < 10.0f && this.vLeft.getLeft() < (-this.vRw) / 2) {
            resetDragView();
        }
        return this.mDragger.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!this.enable) {
            return false;
        }
        this.hasClick = false;
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() - motionEvent.getDownTime() < 200 && java.lang.Math.abs(this.downPos.x - motionEvent.getX()) + java.lang.Math.abs(this.downPos.y - motionEvent.getY()) < 10.0f) {
            this.hasClick = true;
        }
        if (java.lang.Math.abs(this.downPos.x - motionEvent.getX()) / java.lang.Math.abs(this.downPos.y - motionEvent.getY()) > 1.0f) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        this.mDragger.processTouchEvent(motionEvent);
        return true;
    }

    public void performScroll() {
        for (final com.up366.mobile.common.views.ListItemDragLayout listItemDragLayout : sets) {
            if (listItemDragLayout != this && listItemDragLayout.vLeft.getLeft() < (-listItemDragLayout.vRw) / 2) {
                postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.common.views.ListItemDragLayout$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.up366.mobile.common.views.ListItemDragLayout.lambda$performScroll$0(this.f$0);
                    }
                }, 10L);
            }
        }
        this.mDragger.captureChildView(this.vRight, 0);
        this.mDragger.smoothSlideViewTo(this.vRight, this.vLeft.getRight() - this.vRight.getWidth(), 0);
        com.up366.mobile.common.views.ListItemDragLayout.OnDragListener onDragListener = this.mDragListener;
        if (onDragListener != null) {
            onDragListener.onDragOut();
        }
        postInvalidate();
    }

    static /* synthetic */ void lambda$performScroll$0(com.up366.mobile.common.views.ListItemDragLayout listItemDragLayout) {
        android.view.View view = listItemDragLayout.vLeft;
        listItemDragLayout.dragView = view;
        listItemDragLayout.mDragger.smoothSlideViewTo(view, 0, 0);
        listItemDragLayout.postInvalidate();
        com.up366.mobile.common.views.ListItemDragLayout.OnDragListener onDragListener = listItemDragLayout.mDragListener;
        if (onDragListener != null) {
            onDragListener.onDragIn();
        }
    }

    public void setOnDragListener(com.up366.mobile.common.views.ListItemDragLayout.OnDragListener onDragListener) {
        this.mDragListener = onDragListener;
    }

    private void initDragView(android.view.View view, android.view.MotionEvent motionEvent) {
        if (this.mDragger.isViewUnder(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            this.dragView = view;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() < 2) {
            return;
        }
        if (getChildCount() > 2) {
            throw new java.lang.IllegalStateException("ListItemDragLayout can't hold more than two childs!");
        }
        this.vLeft = getChildAt(0);
        this.vRight = getChildAt(1);
        this.vLw = this.vLeft.getMeasuredWidth();
        this.vRw = this.vRight.getMeasuredWidth();
        ((android.widget.FrameLayout.LayoutParams) this.vRight.getLayoutParams()).setMargins(0, 0, -this.vRw, 0);
        requestLayout();
        setFocusableInTouchMode(true);
    }

    public void resetDragView() {
        if (this.dragView == null) {
            return;
        }
        postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.common.views.ListItemDragLayout$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resetDragView$1();
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetDragView$1() {
        android.view.View view = this.vLeft;
        this.dragView = view;
        this.mDragger.smoothSlideViewTo(view, 0, 0);
        postInvalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public static class MotionEventHandler {
        public android.graphics.PointF p = new android.graphics.PointF();
        public boolean move = false;
        public boolean longClick = false;

        public void handle(android.view.MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.move = false;
                this.longClick = false;
                this.p.set(motionEvent.getX(), motionEvent.getY());
            } else if (java.lang.Math.abs(this.p.x - motionEvent.getX()) > 20.0f || java.lang.Math.abs(this.p.y - motionEvent.getY()) > 20.0f) {
                this.move = true;
            }
            if (motionEvent.getEventTime() - motionEvent.getDownTime() <= 500 || this.move) {
                return;
            }
            this.longClick = true;
        }

        public boolean isLongClick() {
            if (!this.longClick) {
                return false;
            }
            this.longClick = false;
            this.move = true;
            return true;
        }

        public boolean isLongClick(android.view.MotionEvent motionEvent) {
            handle(motionEvent);
            return isLongClick();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sets.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sets.remove(this);
    }

    public static void resetState(android.view.MotionEvent motionEvent) {
        if (sets.size() == 0) {
            return;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = new int[2];
        android.graphics.Rect rect = new android.graphics.Rect();
        for (com.up366.mobile.common.views.ListItemDragLayout listItemDragLayout : sets) {
            listItemDragLayout.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            rect.set(i, i2, listItemDragLayout.getWidth() + i, listItemDragLayout.getHeight() + i2);
            if (!rect.contains(rawX, rawY) && listItemDragLayout.visibility == 0 && listItemDragLayout.vLeft.getLeft() < (-listItemDragLayout.vRw) / 2) {
                listItemDragLayout.closeLayout();
            }
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.visibility = i;
        closeLayout();
    }

    private void closeLayout() {
        postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.common.views.ListItemDragLayout$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$closeLayout$2();
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeLayout$2() {
        android.view.View view = this.vLeft;
        this.dragView = view;
        this.mDragger.smoothSlideViewTo(view, 0, 0);
        postInvalidate();
        com.up366.mobile.common.views.ListItemDragLayout.OnDragListener onDragListener = this.mDragListener;
        if (onDragListener != null) {
            onDragListener.onDragIn();
        }
    }
}
