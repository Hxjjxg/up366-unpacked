package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIContinuousNestedTopRecyclerView extends androidx.recyclerview.widget.RecyclerView implements com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView {
    public static final java.lang.String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_top_rv_offset";
    public static final java.lang.String KEY_SCROLL_INFO_POSITION = "@qmui_scroll_info_top_rv_pos";
    private final int[] mScrollConsumed;
    private com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier mScrollNotifier;

    public QMUIContinuousNestedTopRecyclerView(android.content.Context context) {
        this(context, null);
        init();
    }

    public QMUIContinuousNestedTopRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public QMUIContinuousNestedTopRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollConsumed = new int[2];
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int consumeScroll(int i) {
        if (i == Integer.MIN_VALUE) {
            scrollToPosition(0);
            return com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
        }
        boolean z = true;
        if (i == Integer.MAX_VALUE) {
            androidx.recyclerview.widget.RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null) {
                scrollToPosition(adapter.getItemCount() - 1);
            }
            return Integer.MAX_VALUE;
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
        return 0;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getCurrentScroll() {
        return computeVerticalScrollOffset();
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getScrollOffsetRange() {
        return java.lang.Math.max(0, computeVerticalScrollRange() - getHeight());
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mScrollNotifier = onScrollNotifier;
    }

    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
        if (onScrollNotifier != null) {
            onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
        }
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
            com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
            if (onScrollNotifier != null) {
                onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
            }
        }
    }
}
