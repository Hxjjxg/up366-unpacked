package com.up366.medialibrary.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RecyclerPreloadView extends androidx.recyclerview.widget.RecyclerView {
    private static final int BOTTOM_DEFAULT = 1;
    public static final int BOTTOM_PRELOAD = 2;
    private static final java.lang.String TAG = "RecyclerPreloadView";
    public boolean isEnabledLoadMore;
    public boolean isInTheBottom;
    private int mFirstVisiblePosition;
    private int mLastVisiblePosition;
    private com.up366.medialibrary.listener.OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadListener;
    private int reachBottomRow;

    public RecyclerPreloadView(android.content.Context context) {
        super(context);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }

    public RecyclerPreloadView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }

    public RecyclerPreloadView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }

    public void setReachBottomRow(int i) {
        if (i < 1) {
            i = 1;
        }
        this.reachBottomRow = i;
    }

    public void setEnabledLoadMore(boolean z) {
        this.isEnabledLoadMore = z;
    }

    public boolean isEnabledLoadMore() {
        return this.isEnabledLoadMore;
    }

    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0 || i == 1) {
            androidx.recyclerview.widget.GridLayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager) {
                androidx.recyclerview.widget.GridLayoutManager gridLayoutManager = layoutManager;
                this.mFirstVisiblePosition = gridLayoutManager.findFirstVisibleItemPosition();
                this.mLastVisiblePosition = gridLayoutManager.findLastVisibleItemPosition();
            }
        }
    }

    public int getFirstVisiblePosition() {
        return this.mFirstVisiblePosition;
    }

    public int getLastVisiblePosition() {
        return this.mLastVisiblePosition;
    }

    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        if (this.onRecyclerViewPreloadListener == null || !this.isEnabledLoadMore) {
            return;
        }
        androidx.recyclerview.widget.GridLayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            throw new java.lang.RuntimeException("LayoutManager is null,Please check it!");
        }
        androidx.recyclerview.widget.RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            throw new java.lang.RuntimeException("Adapter is null,Please check it!");
        }
        if (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager) {
            androidx.recyclerview.widget.GridLayoutManager gridLayoutManager = layoutManager;
            if (gridLayoutManager.findLastVisibleItemPosition() / gridLayoutManager.getSpanCount() >= (adapter.getItemCount() / gridLayoutManager.getSpanCount()) - this.reachBottomRow) {
                if (this.isInTheBottom) {
                    if (i2 == 0) {
                        this.isInTheBottom = false;
                        return;
                    }
                    return;
                } else {
                    this.onRecyclerViewPreloadListener.onRecyclerViewPreloadMore();
                    if (i2 > 0) {
                        this.isInTheBottom = true;
                        return;
                    }
                    return;
                }
            }
        }
        this.isInTheBottom = false;
    }

    public void setOnRecyclerViewPreloadListener(com.up366.medialibrary.listener.OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadMoreListener) {
        this.onRecyclerViewPreloadListener = onRecyclerViewPreloadMoreListener;
    }
}
