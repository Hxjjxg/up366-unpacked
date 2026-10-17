package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIContinuousNestedScrollLayout extends androidx.coordinatorlayout.widget.CoordinatorLayout implements com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback, com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback {
    public static final java.lang.String KEY_SCROLL_INFO_OFFSET = "@qmui_nested_scroll_layout_offset";
    private com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomAreaBehavior mBottomAreaBehavior;
    private com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView mBottomView;
    private java.lang.Runnable mCheckLayoutAction;
    private int mCurrentScrollState;
    private float mDismissDownY;
    private com.up366.qmui.nestedScroll.QMUIDraggableScrollBar mDraggableScrollBar;
    private boolean mEnableScrollBarFadeInOut;
    private boolean mIsDismissDownEvent;
    private boolean mIsDraggableScrollBarEnabled;
    private boolean mKeepBottomAreaStableWhenCheckLayout;
    private java.util.List<com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.OnScrollListener> mOnScrollListeners;
    private com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior mTopAreaBehavior;
    private com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView mTopView;
    private int mTouchSlap;

    public interface OnScrollListener {
        void onScroll(com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout, int i, int i2, int i3, int i4, int i5, int i6);

        void onScrollStateChange(com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout, int i, boolean z);
    }

    @Override // com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback
    public void onDragEnd() {
    }

    public QMUIContinuousNestedScrollLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedScrollLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIContinuousNestedScrollLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnScrollListeners = new java.util.ArrayList();
        this.mCheckLayoutAction = new java.lang.Runnable() { // from class: com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.1
            @Override // java.lang.Runnable
            public void run() {
                com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.checkLayout();
            }
        };
        this.mKeepBottomAreaStableWhenCheckLayout = false;
        this.mEnableScrollBarFadeInOut = true;
        this.mIsDraggableScrollBarEnabled = false;
        this.mCurrentScrollState = 0;
        this.mIsDismissDownEvent = false;
        this.mDismissDownY = 0.0f;
        this.mTouchSlap = -1;
    }

    private void ensureScrollBar() {
        if (this.mDraggableScrollBar == null) {
            com.up366.qmui.nestedScroll.QMUIDraggableScrollBar qMUIDraggableScrollBarCreateScrollBar = createScrollBar(getContext());
            this.mDraggableScrollBar = qMUIDraggableScrollBarCreateScrollBar;
            qMUIDraggableScrollBarCreateScrollBar.setEnableFadeInAndOut(this.mEnableScrollBarFadeInOut);
            this.mDraggableScrollBar.setCallback(this);
            androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams = new androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 5;
            addView(this.mDraggableScrollBar, layoutParams);
        }
    }

    public void setDraggableScrollBarEnabled(boolean z) {
        if (this.mIsDraggableScrollBarEnabled != z) {
            this.mIsDraggableScrollBarEnabled = z;
            if (z && !this.mEnableScrollBarFadeInOut) {
                ensureScrollBar();
                this.mDraggableScrollBar.setPercent(getCurrentScrollPercent());
                this.mDraggableScrollBar.awakenScrollBar();
            }
            com.up366.qmui.nestedScroll.QMUIDraggableScrollBar qMUIDraggableScrollBar = this.mDraggableScrollBar;
            if (qMUIDraggableScrollBar != null) {
                qMUIDraggableScrollBar.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void setEnableScrollBarFadeInOut(boolean z) {
        if (this.mEnableScrollBarFadeInOut != z) {
            this.mEnableScrollBarFadeInOut = z;
            if (this.mIsDraggableScrollBarEnabled && !z) {
                ensureScrollBar();
                this.mDraggableScrollBar.setPercent(getCurrentScrollPercent());
                this.mDraggableScrollBar.awakenScrollBar();
            }
            com.up366.qmui.nestedScroll.QMUIDraggableScrollBar qMUIDraggableScrollBar = this.mDraggableScrollBar;
            if (qMUIDraggableScrollBar != null) {
                qMUIDraggableScrollBar.setEnableFadeInAndOut(z);
                this.mDraggableScrollBar.invalidate();
            }
        }
    }

    protected com.up366.qmui.nestedScroll.QMUIDraggableScrollBar createScrollBar(android.content.Context context) {
        return new com.up366.qmui.nestedScroll.QMUIDraggableScrollBar(context);
    }

    @Override // com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback
    public void onDragStarted() {
        stopScroll();
    }

    @Override // com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback
    public void onDragToPercent(float f) {
        scrollBy(((int) (getScrollRange() * f)) - getCurrentScroll());
    }

    public int getCurrentScroll() {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int currentScroll = (iQMUIContinuousNestedTopView != null ? iQMUIContinuousNestedTopView.getCurrentScroll() : 0) + getOffsetCurrent();
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        return iQMUIContinuousNestedBottomView != null ? currentScroll + iQMUIContinuousNestedBottomView.getCurrentScroll() : currentScroll;
    }

    public int getScrollRange() {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int scrollOffsetRange = (iQMUIContinuousNestedTopView != null ? iQMUIContinuousNestedTopView.getScrollOffsetRange() : 0) + getOffsetRange();
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        return iQMUIContinuousNestedBottomView != null ? scrollOffsetRange + iQMUIContinuousNestedBottomView.getScrollOffsetRange() : scrollOffsetRange;
    }

    public float getCurrentScrollPercent() {
        int scrollRange = getScrollRange();
        if (scrollRange == 0) {
            return 0.0f;
        }
        return (getCurrentScroll() * 1.0f) / scrollRange;
    }

    public void addOnScrollListener(com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.OnScrollListener onScrollListener) {
        if (this.mOnScrollListeners.contains(onScrollListener)) {
            return;
        }
        this.mOnScrollListeners.add(onScrollListener);
    }

    public void removeOnScrollListener(com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.OnScrollListener onScrollListener) {
        this.mOnScrollListeners.remove(onScrollListener);
    }

    public void setKeepBottomAreaStableWhenCheckLayout(boolean z) {
        this.mKeepBottomAreaStableWhenCheckLayout = z;
    }

    public boolean isKeepBottomAreaStableWhenCheckLayout() {
        return this.mKeepBottomAreaStableWhenCheckLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTopAreaView(android.view.View view, androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams) {
        if (!(view instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView)) {
            throw new java.lang.IllegalStateException("topView must implement from IQMUIContinuousNestedTopView");
        }
        java.lang.Object obj = this.mTopView;
        if (obj != null) {
            removeView((android.view.View) obj);
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = (com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView) view;
        this.mTopView = iQMUIContinuousNestedTopView;
        iQMUIContinuousNestedTopView.injectScrollNotifier(new com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier() { // from class: com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.2
            @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
            public void onScrollStateChange(android.view.View view2, int i) {
            }

            @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
            public void notify(int i, int i2) {
                int i3 = com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mTopAreaBehavior == null ? 0 : -com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mTopAreaBehavior.getTopAndBottomOffset();
                int currentScroll = com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mBottomView == null ? 0 : com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mBottomView.getCurrentScroll();
                int scrollOffsetRange = com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mBottomView != null ? com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mBottomView.getScrollOffsetRange() : 0;
                com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout = com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this;
                qMUIContinuousNestedScrollLayout.dispatchScroll(i, i2, i3, qMUIContinuousNestedScrollLayout.getOffsetRange(), currentScroll, scrollOffsetRange);
            }
        });
        if (layoutParams == null) {
            layoutParams = new androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams(-1, -2);
        }
        androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
        if (behavior instanceof com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior) {
            this.mTopAreaBehavior = (com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior) behavior;
        } else {
            com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = new com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior(getContext());
            this.mTopAreaBehavior = qMUIContinuousNestedTopAreaBehavior;
            layoutParams.setBehavior(qMUIContinuousNestedTopAreaBehavior);
        }
        this.mTopAreaBehavior.setCallback(this);
        addView(view, 0, layoutParams);
    }

    public com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView getTopView() {
        return this.mTopView;
    }

    public com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView getBottomView() {
        return this.mBottomView;
    }

    public com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior getTopAreaBehavior() {
        return this.mTopAreaBehavior;
    }

    public com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomAreaBehavior getBottomAreaBehavior() {
        return this.mBottomAreaBehavior;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBottomAreaView(android.view.View view, androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams) {
        if (!(view instanceof com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView)) {
            throw new java.lang.IllegalStateException("bottomView must implement from IQMUIContinuousNestedBottomView");
        }
        java.lang.Object obj = this.mBottomView;
        if (obj != null) {
            removeView((android.view.View) obj);
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView) view;
        this.mBottomView = iQMUIContinuousNestedBottomView;
        iQMUIContinuousNestedBottomView.injectScrollNotifier(new com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier() { // from class: com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.3
            @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
            public void notify(int i, int i2) {
                int currentScroll = com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mTopView == null ? 0 : com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mTopView.getCurrentScroll();
                int scrollOffsetRange = com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mTopView == null ? 0 : com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mTopView.getScrollOffsetRange();
                int i3 = com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mTopAreaBehavior != null ? -com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.mTopAreaBehavior.getTopAndBottomOffset() : 0;
                com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout = com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this;
                qMUIContinuousNestedScrollLayout.dispatchScroll(currentScroll, scrollOffsetRange, i3, qMUIContinuousNestedScrollLayout.getOffsetRange(), i, i2);
            }

            @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
            public void onScrollStateChange(android.view.View view2, int i) {
                com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.this.dispatchScrollStateChange(i, false);
            }
        });
        if (layoutParams == null) {
            layoutParams = new androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams(-1, -1);
        }
        androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
        if (behavior instanceof com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomAreaBehavior) {
            this.mBottomAreaBehavior = (com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomAreaBehavior) behavior;
        } else {
            com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomAreaBehavior qMUIContinuousNestedBottomAreaBehavior = new com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomAreaBehavior();
            this.mBottomAreaBehavior = qMUIContinuousNestedBottomAreaBehavior;
            layoutParams.setBehavior(qMUIContinuousNestedBottomAreaBehavior);
        }
        addView(view, 0, layoutParams);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postCheckLayout();
    }

    public void postCheckLayout() {
        removeCallbacks(this.mCheckLayoutAction);
        post(this.mCheckLayoutAction);
    }

    public void checkLayout() {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView == null || this.mBottomView == null) {
            return;
        }
        int currentScroll = iQMUIContinuousNestedTopView.getCurrentScroll();
        int scrollOffsetRange = this.mTopView.getScrollOffsetRange();
        int i = -this.mTopAreaBehavior.getTopAndBottomOffset();
        int offsetRange = getOffsetRange();
        if (offsetRange <= 0) {
            return;
        }
        if (i >= offsetRange || (i > 0 && this.mKeepBottomAreaStableWhenCheckLayout)) {
            this.mTopView.consumeScroll(Integer.MAX_VALUE);
            if (this.mBottomView.getCurrentScroll() > 0) {
                this.mTopAreaBehavior.setTopAndBottomOffset(-offsetRange);
                return;
            }
            return;
        }
        if (this.mBottomView.getCurrentScroll() > 0) {
            this.mBottomView.consumeScroll(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        }
        if (currentScroll >= scrollOffsetRange || i <= 0) {
            return;
        }
        int i2 = scrollOffsetRange - currentScroll;
        if (i >= i2) {
            this.mTopView.consumeScroll(Integer.MAX_VALUE);
            this.mTopAreaBehavior.setTopAndBottomOffset(i2 - i);
        } else {
            this.mTopView.consumeScroll(i);
            this.mTopAreaBehavior.setTopAndBottomOffset(0);
        }
    }

    public void scrollBottomViewToTop() {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.consumeScroll(Integer.MAX_VALUE);
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.consumeScroll(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            int contentHeight = this.mBottomView.getContentHeight();
            if (contentHeight != -1) {
                this.mTopAreaBehavior.setTopAndBottomOffset((getHeight() - contentHeight) - ((android.view.View) this.mTopView).getHeight());
            } else {
                this.mTopAreaBehavior.setTopAndBottomOffset((getHeight() - ((android.view.View) this.mBottomView).getHeight()) - ((android.view.View) this.mTopView).getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchScroll(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mIsDraggableScrollBarEnabled) {
            ensureScrollBar();
            this.mDraggableScrollBar.setPercent(getCurrentScrollPercent());
            this.mDraggableScrollBar.awakenScrollBar();
        }
        java.util.Iterator<com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.OnScrollListener> it = this.mOnScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScroll(this, i, i2, i3, i4, i5, i6);
        }
    }

    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int i5) {
        super.onNestedScroll(view, i, i2, i3, i4, i5);
        if (i4 <= 0 || getCurrentScroll() < getScrollRange()) {
            return;
        }
        stopScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchScrollStateChange(int i, boolean z) {
        java.util.Iterator<com.up366.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.OnScrollListener> it = this.mOnScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollStateChange(this, i, z);
        }
        this.mCurrentScrollState = i;
    }

    public void scrollBy(int i) {
        com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior;
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView;
        if ((i > 0 || this.mBottomView == null) && (qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior) != null) {
            qMUIContinuousNestedTopAreaBehavior.scroll(this, (android.view.View) this.mTopView, i);
        } else {
            if (i == 0 || (iQMUIContinuousNestedBottomView = this.mBottomView) == null) {
                return;
            }
            iQMUIContinuousNestedBottomView.consumeScroll(i);
        }
    }

    public void smoothScrollBy(int i, int i2) {
        com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior;
        if (i == 0) {
            return;
        }
        if ((i > 0 || this.mBottomView == null) && (qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior) != null) {
            qMUIContinuousNestedTopAreaBehavior.smoothScrollBy(this, (android.view.View) this.mTopView, i, i2);
            return;
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.smoothScrollYBy(i, i2);
        }
    }

    public void stopScroll() {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.stopScroll();
        }
        com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior;
        if (qMUIContinuousNestedTopAreaBehavior != null) {
            qMUIContinuousNestedTopAreaBehavior.stopFlingOrScroll();
        }
    }

    public void scrollToTop() {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.consumeScroll(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        }
        if (this.mTopView != null) {
            this.mTopAreaBehavior.setTopAndBottomOffset(0);
            this.mTopView.consumeScroll(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        }
    }

    public void scrollToBottom() {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.consumeScroll(Integer.MAX_VALUE);
            com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
            if (iQMUIContinuousNestedBottomView != null) {
                int contentHeight = iQMUIContinuousNestedBottomView.getContentHeight();
                if (contentHeight != -1) {
                    if (((android.view.View) this.mTopView).getHeight() + contentHeight < getHeight()) {
                        this.mTopAreaBehavior.setTopAndBottomOffset(0);
                    } else {
                        this.mTopAreaBehavior.setTopAndBottomOffset((getHeight() - contentHeight) - ((android.view.View) this.mTopView).getHeight());
                    }
                } else {
                    this.mTopAreaBehavior.setTopAndBottomOffset((getHeight() - ((android.view.View) this.mBottomView).getHeight()) - ((android.view.View) this.mTopView).getHeight());
                }
            }
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView2 = this.mBottomView;
        if (iQMUIContinuousNestedBottomView2 != null) {
            iQMUIContinuousNestedBottomView2.consumeScroll(Integer.MAX_VALUE);
        }
    }

    public int getOffsetCurrent() {
        com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior;
        if (qMUIContinuousNestedTopAreaBehavior == null) {
            return 0;
        }
        return -qMUIContinuousNestedTopAreaBehavior.getTopAndBottomOffset();
    }

    public int getOffsetRange() {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView;
        if (this.mTopView == null || (iQMUIContinuousNestedBottomView = this.mBottomView) == null) {
            return 0;
        }
        int contentHeight = iQMUIContinuousNestedBottomView.getContentHeight();
        if (contentHeight != -1) {
            return java.lang.Math.max(0, (((android.view.View) this.mTopView).getHeight() + contentHeight) - getHeight());
        }
        return java.lang.Math.max(0, (((android.view.View) this.mTopView).getHeight() + ((android.view.View) this.mBottomView).getHeight()) - getHeight());
    }

    @Override // com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopAreaOffset(int i) {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int currentScroll = iQMUIContinuousNestedTopView == null ? 0 : iQMUIContinuousNestedTopView.getCurrentScroll();
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView2 = this.mTopView;
        int scrollOffsetRange = iQMUIContinuousNestedTopView2 == null ? 0 : iQMUIContinuousNestedTopView2.getScrollOffsetRange();
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        int currentScroll2 = iQMUIContinuousNestedBottomView == null ? 0 : iQMUIContinuousNestedBottomView.getCurrentScroll();
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView2 = this.mBottomView;
        dispatchScroll(currentScroll, scrollOffsetRange, -i, getOffsetRange(), currentScroll2, iQMUIContinuousNestedBottomView2 != null ? iQMUIContinuousNestedBottomView2.getScrollOffsetRange() : 0);
    }

    @Override // com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopBehaviorTouchBegin() {
        dispatchScrollStateChange(1, true);
    }

    @Override // com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopBehaviorTouchEnd() {
        dispatchScrollStateChange(0, true);
    }

    @Override // com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopBehaviorFlingOrScrollStart() {
        dispatchScrollStateChange(2, true);
    }

    @Override // com.up366.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopBehaviorFlingOrScrollEnd() {
        dispatchScrollStateChange(0, true);
    }

    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mCurrentScrollState != 0) {
                stopScroll();
                this.mIsDismissDownEvent = true;
                this.mDismissDownY = motionEvent.getY();
                if (this.mTouchSlap < 0) {
                    this.mTouchSlap = android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop();
                }
                return true;
            }
        } else if (motionEvent.getAction() == 2 && this.mIsDismissDownEvent) {
            if (java.lang.Math.abs(motionEvent.getY() - this.mDismissDownY) <= this.mTouchSlap) {
                return true;
            }
            android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(0);
            motionEventObtain.offsetLocation(0.0f, this.mDismissDownY - motionEvent.getY());
            super.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
        this.mIsDismissDownEvent = false;
        return super.dispatchTouchEvent(motionEvent);
    }

    public void saveScrollInfo(android.os.Bundle bundle) {
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.saveScrollInfo(bundle);
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.saveScrollInfo(bundle);
        }
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, getOffsetCurrent());
    }

    public void restoreScrollInfo(android.os.Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.mTopAreaBehavior != null) {
            this.mTopAreaBehavior.setTopAndBottomOffset(com.up366.qmui.util.QMUILangHelper.constrain(-bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0), -getOffsetRange(), 0));
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.restoreScrollInfo(bundle);
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.restoreScrollInfo(bundle);
        }
    }
}
