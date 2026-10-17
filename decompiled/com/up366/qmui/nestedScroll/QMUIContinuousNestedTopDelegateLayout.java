package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIContinuousNestedTopDelegateLayout extends android.widget.FrameLayout implements androidx.core.view.NestedScrollingChild2, androidx.core.view.NestedScrollingParent2, com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView {
    public static final java.lang.String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_top_dl_offset";
    private java.lang.Runnable mCheckLayoutAction;
    private final androidx.core.view.NestedScrollingChildHelper mChildHelper;
    private com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView mDelegateView;
    private com.up366.qmui.util.QMUIViewOffsetHelper mDelegateViewOffsetHelper;
    private android.view.View mFooterView;
    private com.up366.qmui.util.QMUIViewOffsetHelper mFooterViewOffsetHelper;
    private android.view.View mHeaderView;
    private com.up366.qmui.util.QMUIViewOffsetHelper mHeaderViewOffsetHelper;
    private int mOffsetCurrent;
    private int mOffsetRange;
    private final androidx.core.view.NestedScrollingParentHelper mParentHelper;
    private com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier mScrollNotifier;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        return false;
    }

    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public QMUIContinuousNestedTopDelegateLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedTopDelegateLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIContinuousNestedTopDelegateLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOffsetCurrent = 0;
        this.mOffsetRange = 0;
        this.mCheckLayoutAction = new java.lang.Runnable() { // from class: com.up366.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout.1
            @Override // java.lang.Runnable
            public void run() {
                com.up366.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout.this.checkLayout();
            }
        };
        this.mParentHelper = new androidx.core.view.NestedScrollingParentHelper(this);
        this.mChildHelper = new androidx.core.view.NestedScrollingChildHelper(this);
        androidx.core.view.ViewCompat.setNestedScrollingEnabled(this, true);
        setClipToPadding(false);
    }

    public void setHeaderView(android.view.View view) {
        this.mHeaderView = view;
        this.mHeaderViewOffsetHelper = new com.up366.qmui.util.QMUIViewOffsetHelper(view);
        addView(view, new android.widget.FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setDelegateView(com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView) {
        if (!(iQMUIContinuousNestedTopView instanceof android.view.View)) {
            throw new java.lang.IllegalArgumentException("delegateView must be a instance of View");
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView2 = this.mDelegateView;
        if (iQMUIContinuousNestedTopView2 != null) {
            iQMUIContinuousNestedTopView2.injectScrollNotifier(null);
        }
        this.mDelegateView = iQMUIContinuousNestedTopView;
        android.view.View view = (android.view.View) iQMUIContinuousNestedTopView;
        this.mDelegateViewOffsetHelper = new com.up366.qmui.util.QMUIViewOffsetHelper(view);
        addView(view, new android.widget.FrameLayout.LayoutParams(-1, -2));
    }

    public void setFooterView(android.view.View view) {
        this.mFooterView = view;
        this.mFooterViewOffsetHelper = new com.up366.qmui.util.QMUIViewOffsetHelper(view);
        addView(view, new android.widget.FrameLayout.LayoutParams(-1, -2));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop();
        android.view.View view = this.mHeaderView;
        if (view != null) {
            view.measure(i, android.view.View.MeasureSpec.makeMeasureSpec(size2, 0));
            paddingTop += this.mHeaderView.getMeasuredHeight();
        }
        java.lang.Object obj = this.mDelegateView;
        if (obj != null) {
            android.view.View view2 = (android.view.View) obj;
            view2.measure(i, android.view.View.MeasureSpec.makeMeasureSpec(size2, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER));
            paddingTop += view2.getMeasuredHeight();
        }
        android.view.View view3 = this.mFooterView;
        if (view3 != null) {
            view3.measure(i, android.view.View.MeasureSpec.makeMeasureSpec(size2, 0));
            paddingTop += this.mFooterView.getMeasuredHeight();
        }
        int paddingBottom = paddingTop + getPaddingBottom();
        if (paddingBottom < size2) {
            setMeasuredDimension(size, paddingBottom);
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingTop = getPaddingTop();
        android.view.View view = this.mHeaderView;
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight() + paddingTop;
            this.mHeaderView.layout(0, paddingTop, i5, measuredHeight);
            paddingTop = measuredHeight;
        }
        java.lang.Object obj = this.mDelegateView;
        if (obj != null) {
            android.view.View view2 = (android.view.View) obj;
            int measuredHeight2 = view2.getMeasuredHeight() + paddingTop;
            view2.layout(0, paddingTop, i5, measuredHeight2);
            paddingTop = measuredHeight2;
        }
        android.view.View view3 = this.mFooterView;
        if (view3 != null) {
            int measuredHeight3 = view3.getMeasuredHeight() + paddingTop;
            this.mFooterView.layout(0, paddingTop, i5, measuredHeight3);
            paddingTop = measuredHeight3;
        }
        this.mOffsetRange = java.lang.Math.max(0, (paddingTop + getPaddingBottom()) - i6);
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.mHeaderViewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            qMUIViewOffsetHelper.onViewLayout();
            this.mOffsetCurrent = -this.mHeaderViewOffsetHelper.getTopAndBottomOffset();
        }
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper2 = this.mDelegateViewOffsetHelper;
        if (qMUIViewOffsetHelper2 != null) {
            qMUIViewOffsetHelper2.onViewLayout();
            this.mOffsetCurrent = -this.mDelegateViewOffsetHelper.getTopAndBottomOffset();
        }
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper3 = this.mFooterViewOffsetHelper;
        if (qMUIViewOffsetHelper3 != null) {
            qMUIViewOffsetHelper3.onViewLayout();
            this.mOffsetCurrent = -this.mFooterViewOffsetHelper.getTopAndBottomOffset();
        }
        int i7 = this.mOffsetCurrent;
        int i8 = this.mOffsetRange;
        if (i7 > i8) {
            offsetTo(i8);
        }
        postCheckLayout();
    }

    public void postCheckLayout() {
        removeCallbacks(this.mCheckLayoutAction);
        post(this.mCheckLayoutAction);
    }

    public void checkLayout() {
        int i;
        if ((this.mHeaderView == null && this.mFooterView == null) || this.mDelegateView == null) {
            return;
        }
        int containerHeaderOffsetRange = getContainerHeaderOffsetRange();
        int currentScroll = this.mDelegateView.getCurrentScroll();
        int scrollOffsetRange = this.mDelegateView.getScrollOffsetRange();
        if (currentScroll > 0 && this.mHeaderView != null && (i = this.mOffsetCurrent) < containerHeaderOffsetRange) {
            int i2 = containerHeaderOffsetRange - i;
            if (i2 >= currentScroll) {
                this.mDelegateView.consumeScroll(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
                offsetTo(this.mOffsetCurrent + currentScroll);
            } else {
                this.mDelegateView.consumeScroll(-i2);
                offsetTo(containerHeaderOffsetRange);
            }
        }
        int i3 = this.mOffsetCurrent;
        if (i3 <= containerHeaderOffsetRange || currentScroll >= scrollOffsetRange || this.mFooterView == null) {
            return;
        }
        int i4 = i3 - containerHeaderOffsetRange;
        int i5 = scrollOffsetRange - currentScroll;
        if (i4 >= i5) {
            this.mDelegateView.consumeScroll(Integer.MAX_VALUE);
            offsetTo((containerHeaderOffsetRange + i4) - i5);
        } else {
            this.mDelegateView.consumeScroll(i4);
            offsetTo(containerHeaderOffsetRange);
        }
    }

    private void offsetTo(int i) {
        this.mOffsetCurrent = i;
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.mHeaderViewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            qMUIViewOffsetHelper.setTopAndBottomOffset(-i);
        }
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper2 = this.mDelegateViewOffsetHelper;
        if (qMUIViewOffsetHelper2 != null) {
            qMUIViewOffsetHelper2.setTopAndBottomOffset(-i);
        }
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper3 = this.mFooterViewOffsetHelper;
        if (qMUIViewOffsetHelper3 != null) {
            qMUIViewOffsetHelper3.setTopAndBottomOffset(-i);
        }
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
        if (onScrollNotifier != null) {
            onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
        }
    }

    public com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView getDelegateView() {
        return this.mDelegateView;
    }

    public android.view.View getHeaderView() {
        return this.mHeaderView;
    }

    public android.view.View getFooterView() {
        return this.mFooterView;
    }

    public int getContainerOffsetCurrent() {
        return this.mOffsetCurrent;
    }

    public int getContainerOffsetRange() {
        return this.mOffsetRange;
    }

    public int getContainerHeaderOffsetRange() {
        if (this.mOffsetRange == 0 || this.mHeaderView == null) {
            return 0;
        }
        return java.lang.Math.min(getPaddingTop() + this.mHeaderView.getHeight(), this.mOffsetRange);
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int consumeScroll(int i) {
        int i2 = this.mOffsetRange;
        if (i2 <= 0) {
            com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
            return iQMUIContinuousNestedTopView != null ? iQMUIContinuousNestedTopView.consumeScroll(i) : i;
        }
        if (i > 0) {
            if (this.mDelegateView == null) {
                if (i == Integer.MAX_VALUE) {
                    offsetTo(i2);
                    return i;
                }
                int i3 = this.mOffsetCurrent;
                if (i3 + i <= i2) {
                    offsetTo(i3 + i);
                    return 0;
                }
                if (i3 >= i2) {
                    return i;
                }
                int i4 = i - (i2 - i3);
                offsetTo(i2);
                return i4;
            }
            int paddingTop = getPaddingTop();
            android.view.View view = this.mHeaderView;
            int iMin = java.lang.Math.min(i2, paddingTop + (view == null ? 0 : view.getHeight()));
            if (i == Integer.MAX_VALUE) {
                offsetTo(iMin);
            } else {
                int i5 = this.mOffsetCurrent;
                if (i5 + i <= iMin) {
                    offsetTo(i5 + i);
                    return 0;
                }
                if (i5 < iMin) {
                    i -= iMin - i5;
                    offsetTo(iMin);
                }
            }
            int iConsumeScroll = this.mDelegateView.consumeScroll(i);
            if (iConsumeScroll <= 0) {
                return iConsumeScroll;
            }
            if (iConsumeScroll == Integer.MAX_VALUE) {
                offsetTo(this.mOffsetRange);
                return iConsumeScroll;
            }
            int i6 = this.mOffsetCurrent;
            int i7 = i6 + iConsumeScroll;
            int i8 = this.mOffsetRange;
            if (i7 <= i8) {
                offsetTo(i6 + iConsumeScroll);
                return 0;
            }
            int i9 = iConsumeScroll - (i8 - i6);
            offsetTo(i8);
            return i9;
        }
        if (i >= 0) {
            return i;
        }
        if (this.mDelegateView == null) {
            if (i == Integer.MIN_VALUE) {
                offsetTo(0);
                return i;
            }
            int i10 = this.mOffsetCurrent;
            if (i10 + i >= 0) {
                offsetTo(i10 + i);
                return 0;
            }
            if (i10 <= 0) {
                return i;
            }
            int i11 = i + i10;
            offsetTo(0);
            return i11;
        }
        int paddingBottom = i2 - getPaddingBottom();
        android.view.View view2 = this.mFooterView;
        int iMax = java.lang.Math.max(0, paddingBottom - (view2 == null ? 0 : view2.getHeight()));
        if (i == Integer.MIN_VALUE) {
            offsetTo(iMax);
        } else {
            int i12 = this.mOffsetCurrent;
            if (i12 + i > iMax) {
                offsetTo(i12 + i);
                return 0;
            }
            if (i12 > iMax) {
                i += i12 - iMax;
                offsetTo(iMax);
            }
        }
        int iConsumeScroll2 = this.mDelegateView.consumeScroll(i);
        if (iConsumeScroll2 >= 0) {
            return iConsumeScroll2;
        }
        if (iConsumeScroll2 == Integer.MIN_VALUE) {
            offsetTo(0);
            return iConsumeScroll2;
        }
        int i13 = this.mOffsetCurrent;
        if (i13 + iConsumeScroll2 > 0) {
            offsetTo(i13 + iConsumeScroll2);
            return 0;
        }
        if (i13 <= 0) {
            return iConsumeScroll2;
        }
        int i14 = iConsumeScroll2 + i13;
        offsetTo(0);
        return i14;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getCurrentScroll() {
        int i = this.mOffsetCurrent;
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        return iQMUIContinuousNestedTopView != null ? i + iQMUIContinuousNestedTopView.getCurrentScroll() : i;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getScrollOffsetRange() {
        int i = this.mOffsetRange;
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        return iQMUIContinuousNestedTopView != null ? i + iQMUIContinuousNestedTopView.getScrollOffsetRange() : i;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(final com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mScrollNotifier = onScrollNotifier;
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.injectScrollNotifier(new com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier() { // from class: com.up366.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout.2
                @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
                public void onScrollStateChange(android.view.View view, int i) {
                }

                @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
                public void notify(int i, int i2) {
                    onScrollNotifier.notify(com.up366.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout.this.getCurrentScroll(), com.up366.qmui.nestedScroll.QMUIContinuousNestedTopDelegateLayout.this.getScrollOffsetRange());
                }
            });
        }
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void saveScrollInfo(android.os.Bundle bundle) {
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, -this.mOffsetCurrent);
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.saveScrollInfo(bundle);
        }
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void restoreScrollInfo(android.os.Bundle bundle) {
        offsetTo(com.up366.qmui.util.QMUILangHelper.constrain(-bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0), 0, getContainerOffsetRange()));
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.restoreScrollInfo(bundle);
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
        int i6 = 0;
        if (i4 > 0) {
            int i7 = this.mOffsetCurrent;
            int i8 = i7 + i4;
            int i9 = this.mOffsetRange;
            if (i8 <= i9) {
                offsetTo(i7 + i4);
                i6 = i4;
            } else if (i7 <= i9) {
                i6 = i9 - i7;
                offsetTo(i9);
            }
        } else if (i4 < 0) {
            int i10 = this.mOffsetCurrent;
            if (i10 + i4 >= 0) {
                offsetTo(i10 + i4);
                i6 = i4;
            } else if (i10 >= 0) {
                offsetTo(0);
                i6 = -i10;
            }
        }
        dispatchNestedScroll(0, i2 + i6, 0, i4 - i6, null, i5);
    }

    public void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
        int i4 = i2 - iArr[1];
        if (i4 > 0) {
            int i5 = this.mOffsetRange;
            int paddingTop = getPaddingTop();
            android.view.View view2 = this.mHeaderView;
            int iMin = java.lang.Math.min(i5, paddingTop + (view2 != null ? view2.getHeight() : 0));
            int i6 = this.mOffsetCurrent;
            if (i6 + i4 <= iMin) {
                offsetTo(i6 + i4);
                iArr[1] = iArr[1] + i4;
                return;
            } else {
                if (i6 < iMin) {
                    iArr[1] = iArr[1] + (iMin - i6);
                    offsetTo(iMin);
                    return;
                }
                return;
            }
        }
        if (i4 < 0) {
            int paddingBottom = getPaddingBottom();
            android.view.View view3 = this.mFooterView;
            int height = this.mOffsetRange - (paddingBottom + (view3 != null ? view3.getHeight() : 0));
            int i7 = this.mOffsetCurrent;
            if (i7 + i4 >= height) {
                offsetTo(i7 + i4);
                iArr[1] = iArr[1] + i4;
            } else if (i7 > height) {
                iArr[1] = iArr[1] + (height - i7);
                offsetTo(height);
            }
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
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }
}
