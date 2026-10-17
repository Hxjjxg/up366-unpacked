package com.up366.qmui.recyclerView;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIRVDraggableScrollBar extends androidx.recyclerview.widget.RecyclerView.ItemDecoration implements com.up366.qmui.skin.IQMUISkinHandlerDecoration, com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration {
    private static final long DEFAULT_KEE_SHOW_DURATION = 800;
    private static final long DEFAULT_TRANSITION_DURATION = 100;
    private int[] STATE_NORMAL;
    private int[] STATE_PRESSED;
    private int mBeginAlpha;
    private com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.Callback mCallback;
    private int mCurrentAlpha;
    private int mDragInnerStart;
    private boolean mEnableScrollBarFadeInOut;
    private final int mEndMargin;
    private java.lang.Runnable mFadeScrollBarAction;
    private final int mInwardOffset;
    private boolean mIsDraggable;
    private boolean mIsInDragging;
    private final boolean mIsLocationInOppositeSide;
    private final boolean mIsVerticalScroll;
    private long mKeepShownTime;
    private final androidx.recyclerview.widget.RecyclerView.OnItemTouchListener mOnItemTouchListener;
    private float mPercent;
    androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private android.graphics.drawable.Drawable mScrollBarDrawable;
    private int mScrollBarSkinRes;
    private int mScrollBarSkinTintColorRes;
    private androidx.recyclerview.widget.RecyclerView.OnScrollListener mScrollListener;
    private final int mStartMargin;
    private long mStartTransitionTime;
    com.up366.qmui.widget.section.QMUIStickySectionLayout mStickySectionLayout;
    private int mTargetAlpha;
    private long mTransitionDuration;

    interface Callback {
        void onDragEnd();

        void onDragStarted();

        void onDragToPercent(float f);
    }

    @Override // com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration
    public void onDraw(android.graphics.Canvas canvas, com.up366.qmui.widget.section.QMUIStickySectionLayout qMUIStickySectionLayout) {
    }

    public QMUIRVDraggableScrollBar(int i, int i2, int i3, boolean z, boolean z2) {
        this.STATE_PRESSED = new int[]{android.R.attr.state_pressed};
        this.STATE_NORMAL = new int[0];
        this.mEnableScrollBarFadeInOut = false;
        this.mIsDraggable = true;
        this.mKeepShownTime = 800L;
        this.mTransitionDuration = 100L;
        this.mStartTransitionTime = 0L;
        this.mBeginAlpha = -1;
        this.mTargetAlpha = -1;
        this.mCurrentAlpha = 255;
        this.mPercent = 0.0f;
        this.mDragInnerStart = 0;
        this.mScrollBarSkinRes = 0;
        this.mScrollBarSkinTintColorRes = 0;
        this.mFadeScrollBarAction = new java.lang.Runnable() { // from class: com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.1
            @Override // java.lang.Runnable
            public void run() {
                com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mTargetAlpha = 0;
                com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this;
                qMUIRVDraggableScrollBar.mBeginAlpha = qMUIRVDraggableScrollBar.mCurrentAlpha;
                com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mStartTransitionTime = java.lang.System.currentTimeMillis();
                com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.invalidate();
            }
        };
        this.mOnItemTouchListener = new androidx.recyclerview.widget.RecyclerView.OnItemTouchListener() { // from class: com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.2
            public boolean onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent) {
                if (!com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mIsDraggable || com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mScrollBarDrawable == null || !com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.needDrawScrollBar(recyclerView)) {
                    return false;
                }
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (action == 0) {
                    android.graphics.Rect bounds = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mScrollBarDrawable.getBounds();
                    if (com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mCurrentAlpha > 0 && bounds.contains(x, y)) {
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.startDrag();
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar.mDragInnerStart = qMUIRVDraggableScrollBar.mIsVerticalScroll ? y - bounds.top : x - bounds.left;
                    }
                } else if (action == 2) {
                    if (com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mIsInDragging) {
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar2 = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar2.onDragging(recyclerView, qMUIRVDraggableScrollBar2.mScrollBarDrawable, x, y);
                    }
                } else if ((action == 1 || action == 3) && com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mIsInDragging) {
                    com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar3 = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this;
                    qMUIRVDraggableScrollBar3.onDragging(recyclerView, qMUIRVDraggableScrollBar3.mScrollBarDrawable, x, y);
                    com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.endDrag();
                }
                return com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mIsInDragging;
            }

            public void onTouchEvent(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent) {
                if (com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mIsDraggable && com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mScrollBarDrawable != null && com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.needDrawScrollBar(recyclerView)) {
                    int action = motionEvent.getAction();
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (action == 0) {
                        android.graphics.Rect bounds = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mScrollBarDrawable.getBounds();
                        if (com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mCurrentAlpha <= 0 || !bounds.contains(x, y)) {
                            return;
                        }
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.startDrag();
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar.mDragInnerStart = qMUIRVDraggableScrollBar.mIsVerticalScroll ? y - bounds.top : x - bounds.left;
                        return;
                    }
                    if (action == 2) {
                        if (com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mIsInDragging) {
                            com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar2 = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this;
                            qMUIRVDraggableScrollBar2.onDragging(recyclerView, qMUIRVDraggableScrollBar2.mScrollBarDrawable, x, y);
                            return;
                        }
                        return;
                    }
                    if ((action == 1 || action == 3) && com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mIsInDragging) {
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar3 = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar3.onDragging(recyclerView, qMUIRVDraggableScrollBar3.mScrollBarDrawable, x, y);
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.endDrag();
                    }
                }
            }

            public void onRequestDisallowInterceptTouchEvent(boolean z3) {
                if (z3 && com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mIsInDragging) {
                    com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.endDrag();
                }
            }
        };
        this.mScrollListener = new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.3
            private int mPrevStatus = 0;

            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i4) {
                if (com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mEnableScrollBarFadeInOut) {
                    if (this.mPrevStatus == 0 && i4 != 0) {
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mStartTransitionTime = java.lang.System.currentTimeMillis();
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar = com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar.mBeginAlpha = qMUIRVDraggableScrollBar.mCurrentAlpha;
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mTargetAlpha = 255;
                        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.invalidate();
                    } else if (i4 == 0) {
                        recyclerView.postDelayed(com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mFadeScrollBarAction, com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.this.mKeepShownTime);
                    }
                }
                this.mPrevStatus = i4;
            }
        };
        this.mStartMargin = i;
        this.mEndMargin = i2;
        this.mInwardOffset = i3;
        this.mIsVerticalScroll = z;
        this.mIsLocationInOppositeSide = z2;
    }

    public QMUIRVDraggableScrollBar(int i, int i2, int i3) {
        this(i, i2, i3, true, false);
    }

    public void setCallback(com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.Callback callback) {
        this.mCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        com.up366.qmui.widget.section.QMUIStickySectionLayout qMUIStickySectionLayout = this.mStickySectionLayout;
        if (qMUIStickySectionLayout != null) {
            qMUIStickySectionLayout.invalidate();
            return;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.invalidate();
        }
    }

    public void setScrollBarDrawable(android.graphics.drawable.Drawable drawable) {
        this.mScrollBarDrawable = drawable;
        if (drawable != null) {
            drawable.setState(this.mIsInDragging ? this.STATE_PRESSED : this.STATE_NORMAL);
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            com.up366.qmui.skin.QMUISkinHelper.refreshRVItemDecoration(recyclerView, this);
        }
        invalidate();
    }

    public void setScrollBarSkinRes(int i) {
        this.mScrollBarSkinRes = i;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            com.up366.qmui.skin.QMUISkinHelper.refreshRVItemDecoration(recyclerView, this);
        }
        invalidate();
    }

    public void setScrollBarSkinTintColorRes(int i) {
        this.mScrollBarSkinTintColorRes = i;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            com.up366.qmui.skin.QMUISkinHelper.refreshRVItemDecoration(recyclerView, this);
        }
        invalidate();
    }

    public void setDraggable(boolean z) {
        this.mIsDraggable = z;
    }

    public boolean isDraggable() {
        return this.mIsDraggable;
    }

    public void setEnableScrollBarFadeInOut(boolean z) {
        if (this.mEnableScrollBarFadeInOut != z) {
            this.mEnableScrollBarFadeInOut = z;
            if (!z) {
                this.mBeginAlpha = -1;
                this.mTargetAlpha = -1;
                this.mCurrentAlpha = 255;
            } else {
                androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null || recyclerView.getScrollState() == 0) {
                    this.mCurrentAlpha = 0;
                }
            }
            invalidate();
        }
    }

    public boolean isEnableScrollBarFadeInOut() {
        return this.mEnableScrollBarFadeInOut;
    }

    private void commonAttachToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            com.up366.qmui.skin.QMUISkinHelper.refreshRVItemDecoration(recyclerView, this);
        }
    }

    public void attachToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        com.up366.qmui.widget.section.QMUIStickySectionLayout qMUIStickySectionLayout = this.mStickySectionLayout;
        if (qMUIStickySectionLayout != null) {
            qMUIStickySectionLayout.removeDrawDecoration(this);
            this.mStickySectionLayout = null;
        }
        commonAttachToRecyclerView(recyclerView);
    }

    public void attachToStickSectionLayout(com.up366.qmui.widget.section.QMUIStickySectionLayout qMUIStickySectionLayout) {
        com.up366.qmui.widget.section.QMUIStickySectionLayout qMUIStickySectionLayout2 = this.mStickySectionLayout;
        if (qMUIStickySectionLayout2 == qMUIStickySectionLayout) {
            return;
        }
        if (qMUIStickySectionLayout2 != null) {
            qMUIStickySectionLayout2.removeDrawDecoration(this);
        }
        this.mStickySectionLayout = qMUIStickySectionLayout;
        if (qMUIStickySectionLayout != null) {
            qMUIStickySectionLayout.addDrawDecoration(this);
            commonAttachToRecyclerView(qMUIStickySectionLayout.getRecyclerView());
        }
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeCallbacks(this.mFadeScrollBarAction);
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDrag() {
        this.mIsInDragging = true;
        android.graphics.drawable.Drawable drawable = this.mScrollBarDrawable;
        if (drawable != null) {
            drawable.setState(this.STATE_PRESSED);
        }
        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDragStarted();
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.mFadeScrollBarAction);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endDrag() {
        this.mIsInDragging = false;
        android.graphics.drawable.Drawable drawable = this.mScrollBarDrawable;
        if (drawable != null) {
            drawable.setState(this.STATE_NORMAL);
        }
        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDragEnd();
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDragging(androidx.recyclerview.widget.RecyclerView recyclerView, android.graphics.drawable.Drawable drawable, int i, int i2) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int usefulSpace = getUsefulSpace(recyclerView);
        boolean z = this.mIsVerticalScroll;
        if (z) {
            intrinsicWidth = intrinsicHeight;
        }
        int i3 = usefulSpace - intrinsicWidth;
        if (z) {
            i = i2;
        }
        float fConstrain = com.up366.qmui.util.QMUILangHelper.constrain((((i - this.mStartMargin) - this.mDragInnerStart) * 1.0f) / i3, 0.0f, 1.0f);
        com.up366.qmui.recyclerView.QMUIRVDraggableScrollBar.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDragToPercent(fConstrain);
        }
        this.mPercent = fConstrain;
        if (fConstrain <= 0.0f) {
            recyclerView.scrollToPosition(0);
        } else if (fConstrain >= 1.0f) {
            if (recyclerView.getAdapter() != null) {
                recyclerView.scrollToPosition(r5.getItemCount() - 1);
            }
        } else {
            int scrollRange = (int) ((getScrollRange(recyclerView) * this.mPercent) - getCurrentOffset(recyclerView));
            if (this.mIsVerticalScroll) {
                recyclerView.scrollBy(0, scrollRange);
            } else {
                recyclerView.scrollBy(scrollRange, 0);
            }
        }
        invalidate();
    }

    public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        if (this.mStickySectionLayout == null) {
            drawScrollBar(canvas, recyclerView);
        }
    }

    @Override // com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration
    public void onDrawOver(android.graphics.Canvas canvas, com.up366.qmui.widget.section.QMUIStickySectionLayout qMUIStickySectionLayout) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            drawScrollBar(canvas, recyclerView);
        }
    }

    private void drawScrollBar(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView) {
        android.graphics.drawable.Drawable drawableEnsureScrollBar = ensureScrollBar(recyclerView.getContext());
        if (drawableEnsureScrollBar == null || !needDrawScrollBar(recyclerView)) {
            return;
        }
        if (this.mTargetAlpha != -1 && this.mBeginAlpha != -1) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.mStartTransitionTime;
            long jAbs = (this.mTransitionDuration * ((long) java.lang.Math.abs(this.mTargetAlpha - this.mBeginAlpha))) / 255;
            if (jCurrentTimeMillis >= jAbs) {
                this.mCurrentAlpha = this.mTargetAlpha;
                this.mTargetAlpha = -1;
                this.mBeginAlpha = -1;
            } else {
                this.mCurrentAlpha = (int) (this.mBeginAlpha + (((((long) (this.mTargetAlpha - r1)) * jCurrentTimeMillis) * 1.0f) / jAbs));
                recyclerView.postInvalidateOnAnimation();
            }
        }
        drawableEnsureScrollBar.setAlpha(this.mCurrentAlpha);
        if (!this.mIsInDragging) {
            this.mPercent = calculatePercent(recyclerView);
        }
        setScrollBarBounds(recyclerView, drawableEnsureScrollBar);
        drawableEnsureScrollBar.draw(canvas);
    }

    private int getUsefulSpace(androidx.recyclerview.widget.RecyclerView recyclerView) {
        int width;
        int i;
        if (this.mIsVerticalScroll) {
            width = recyclerView.getHeight() - this.mStartMargin;
            i = this.mEndMargin;
        } else {
            width = recyclerView.getWidth() - this.mStartMargin;
            i = this.mEndMargin;
        }
        return width - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needDrawScrollBar(androidx.recyclerview.widget.RecyclerView recyclerView) {
        return this.mIsVerticalScroll ? recyclerView.canScrollVertically(-1) || recyclerView.canScrollVertically(1) : recyclerView.canScrollHorizontally(-1) || recyclerView.canScrollHorizontally(1);
    }

    private void setScrollBarBounds(androidx.recyclerview.widget.RecyclerView recyclerView, android.graphics.drawable.Drawable drawable) {
        int height;
        int width;
        int usefulSpace = getUsefulSpace(recyclerView);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.mIsVerticalScroll) {
            height = (int) ((usefulSpace - intrinsicHeight) * this.mPercent);
            width = this.mIsLocationInOppositeSide ? this.mInwardOffset : (recyclerView.getWidth() - intrinsicWidth) - this.mInwardOffset;
        } else {
            int i = (int) ((usefulSpace - intrinsicWidth) * this.mPercent);
            height = this.mIsLocationInOppositeSide ? this.mInwardOffset : (recyclerView.getHeight() - intrinsicHeight) - this.mInwardOffset;
            width = i;
        }
        drawable.setBounds(width, height, intrinsicWidth + width, intrinsicHeight + height);
    }

    private int getScrollRange(androidx.recyclerview.widget.RecyclerView recyclerView) {
        int iComputeHorizontalScrollRange;
        int width;
        if (this.mIsVerticalScroll) {
            iComputeHorizontalScrollRange = recyclerView.computeVerticalScrollRange();
            width = recyclerView.getHeight();
        } else {
            iComputeHorizontalScrollRange = recyclerView.computeHorizontalScrollRange();
            width = recyclerView.getWidth();
        }
        return iComputeHorizontalScrollRange - width;
    }

    private int getCurrentOffset(androidx.recyclerview.widget.RecyclerView recyclerView) {
        if (this.mIsVerticalScroll) {
            return recyclerView.computeVerticalScrollOffset();
        }
        return recyclerView.computeHorizontalScrollOffset();
    }

    private float calculatePercent(androidx.recyclerview.widget.RecyclerView recyclerView) {
        return com.up366.qmui.util.QMUILangHelper.constrain((getCurrentOffset(recyclerView) * 1.0f) / getScrollRange(recyclerView), 0.0f, 1.0f);
    }

    public android.graphics.drawable.Drawable ensureScrollBar(android.content.Context context) {
        if (this.mScrollBarDrawable == null) {
            setScrollBarDrawable(androidx.core.content.ContextCompat.getDrawable(context, com.qmuiteam.qmui.R.drawable.qmui_icon_scroll_bar));
        }
        return this.mScrollBarDrawable;
    }

    @Override // com.up366.qmui.skin.IQMUISkinHandlerDecoration
    public void handle(androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, android.content.res.Resources.Theme theme) {
        android.graphics.drawable.Drawable drawable;
        if (this.mScrollBarSkinRes != 0) {
            this.mScrollBarDrawable = com.up366.qmui.util.QMUIResHelper.getAttrDrawable(recyclerView.getContext(), theme, this.mScrollBarSkinRes);
        } else if (this.mScrollBarSkinTintColorRes != 0 && (drawable = this.mScrollBarDrawable) != null) {
            androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, com.up366.qmui.util.QMUIResHelper.getAttrColorStateList(recyclerView.getContext(), theme, this.mScrollBarSkinTintColorRes));
        }
        invalidate();
    }
}
