package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIContinuousNestedBottomRecyclerView extends androidx.recyclerview.widget.RecyclerView implements com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView {
    public static final java.lang.String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_bottom_rv_offset";
    public static final java.lang.String KEY_SCROLL_INFO_POSITION = "@qmui_scroll_info_bottom_rv_pos";
    private com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier mOnScrollNotifier;
    private final int[] mScrollConsumed;

    public QMUIContinuousNestedBottomRecyclerView(android.content.Context context) {
        super(context);
        this.mScrollConsumed = new int[2];
        init();
    }

    public QMUIContinuousNestedBottomRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollConsumed = new int[2];
        init();
    }

    public QMUIContinuousNestedBottomRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollConsumed = new int[2];
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
        addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView.1
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
                if (com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier != null) {
                    if (i == 0) {
                        com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier.onScrollStateChange(recyclerView, 0);
                    } else if (i == 2) {
                        com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier.onScrollStateChange(recyclerView, 2);
                    } else if (i == 1) {
                        com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier.onScrollStateChange(recyclerView, 1);
                    }
                }
            }

            public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                if (com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier != null) {
                    com.up366.qmui.nestedScroll.QMUIContinuousNestedBottomRecyclerView.this.mOnScrollNotifier.notify(recyclerView.computeVerticalScrollOffset(), java.lang.Math.max(0, recyclerView.computeVerticalScrollRange() - recyclerView.getHeight()));
                }
            }
        });
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void consumeScroll(int i) {
        if (i == Integer.MIN_VALUE) {
            scrollToPosition(0);
            return;
        }
        boolean z = true;
        if (i == Integer.MAX_VALUE) {
            androidx.recyclerview.widget.RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                scrollToPosition(adapter.getItemCount() - 1);
                return;
            }
            return;
        }
        if (hasNestedScrollingParent(0)) {
            z = false;
        } else {
            startNestedScroll(2, 0);
            int[] iArr = this.mScrollConsumed;
            iArr[0] = 0;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i, iArr, null, 0);
            i -= this.mScrollConsumed[1];
        }
        scrollBy(0, i);
        if (z) {
            stopNestedScroll(0);
        }
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getContentHeight() {
        if (getAdapter() == null || getLayoutManager() == null) {
            return 0;
        }
        int iComputeVerticalScrollRange = computeVerticalScrollRange();
        if (iComputeVerticalScrollRange > getHeight()) {
            return -1;
        }
        return iComputeVerticalScrollRange;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mOnScrollNotifier = onScrollNotifier;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getCurrentScroll() {
        return computeVerticalScrollOffset();
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getScrollOffsetRange() {
        return java.lang.Math.max(0, computeVerticalScrollRange() - getHeight());
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void smoothScrollYBy(int i, int i2) {
        startNestedScroll(2, 1);
        smoothScrollBy(0, i, null);
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void saveScrollInfo(android.os.Bundle bundle) {
        androidx.recyclerview.widget.LinearLayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = layoutManager;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            android.view.View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            int top = viewFindViewByPosition == null ? 0 : viewFindViewByPosition.getTop();
            bundle.putInt(KEY_SCROLL_INFO_POSITION, iFindFirstVisibleItemPosition);
            bundle.putInt(KEY_SCROLL_INFO_OFFSET, top);
        }
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void restoreScrollInfo(android.os.Bundle bundle) {
        androidx.recyclerview.widget.LinearLayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            layoutManager.scrollToPositionWithOffset(bundle.getInt(KEY_SCROLL_INFO_POSITION, 0), bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0));
            com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mOnScrollNotifier;
            if (onScrollNotifier != null) {
                onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
            }
        }
    }
}
