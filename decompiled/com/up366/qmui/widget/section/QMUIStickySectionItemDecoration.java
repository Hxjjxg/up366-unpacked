package com.up366.qmui.widget.section;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIStickySectionItemDecoration<VH extends com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder> extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback<VH> mCallback;
    private VH mStickyHeaderViewHolder;
    private int mStickyHeaderViewPosition = -1;
    private int mTargetTop = 0;
    private java.lang.ref.WeakReference<android.view.ViewGroup> mWeakSectionContainer;

    public interface Callback<ViewHolder extends com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder> {
        void bindViewHolder(ViewHolder viewholder, int i);

        ViewHolder createViewHolder(android.view.ViewGroup viewGroup, int i);

        int getItemViewType(int i);

        int getRelativeStickyItemPosition(int i);

        void invalidate();

        boolean isHeaderItem(int i);

        void onHeaderVisibilityChanged(boolean z);

        void registerAdapterDataObserver(androidx.recyclerview.widget.RecyclerView.AdapterDataObserver adapterDataObserver);
    }

    public QMUIStickySectionItemDecoration(android.view.ViewGroup viewGroup, com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback<VH> callback) {
        this.mCallback = callback;
        this.mWeakSectionContainer = new java.lang.ref.WeakReference<>(viewGroup);
        this.mCallback.registerAdapterDataObserver(new androidx.recyclerview.widget.RecyclerView.AdapterDataObserver() { // from class: com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.1
            public void onChanged() {
                super.onChanged();
                com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mCallback.invalidate();
            }

            public void onItemRangeInserted(int i, int i2) {
                super.onItemRangeInserted(i, i2);
                if (i <= com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition) {
                    com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                    com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mCallback.invalidate();
                }
            }

            public void onItemRangeMoved(int i, int i2, int i3) {
                super.onItemRangeMoved(i, i2, i3);
                if (i == com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition || i2 == com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition) {
                    com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                    com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mCallback.invalidate();
                }
            }

            public void onItemRangeChanged(int i, int i2) {
                super.onItemRangeChanged(i, i2);
                if (com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition < i || com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition >= i + i2 || com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewHolder == null || com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mWeakSectionContainer.get() == null) {
                    return;
                }
                com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mCallback.invalidate();
            }

            public void onItemRangeRemoved(int i, int i2) {
                super.onItemRangeRemoved(i, i2);
                if (com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition < i || com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition >= i + i2) {
                    return;
                }
                com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.mStickyHeaderViewPosition = -1;
                com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.this.setHeaderVisibility(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeaderVisibility(boolean z) {
        android.view.ViewGroup viewGroup = this.mWeakSectionContainer.get();
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(z ? 0 : 8);
        this.mCallback.onHeaderVisibilityChanged(z);
    }

    public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        android.view.ViewGroup viewGroup = this.mWeakSectionContainer.get();
        if (viewGroup == null || recyclerView.getChildCount() == 0 || recyclerView.getAdapter() == null) {
            return;
        }
        androidx.recyclerview.widget.LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager)) {
            setHeaderVisibility(false);
            return;
        }
        int iFindFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            setHeaderVisibility(false);
            return;
        }
        int relativeStickyItemPosition = this.mCallback.getRelativeStickyItemPosition(iFindFirstVisibleItemPosition);
        if (relativeStickyItemPosition == -1) {
            setHeaderVisibility(false);
            return;
        }
        int itemViewType = this.mCallback.getItemViewType(relativeStickyItemPosition);
        if (itemViewType == -1) {
            setHeaderVisibility(false);
            return;
        }
        VH vh = this.mStickyHeaderViewHolder;
        if (vh == null || vh.getItemViewType() != itemViewType) {
            this.mStickyHeaderViewHolder = (VH) createStickyViewHolder(recyclerView, relativeStickyItemPosition, itemViewType);
        }
        if (this.mStickyHeaderViewPosition != relativeStickyItemPosition) {
            this.mStickyHeaderViewPosition = relativeStickyItemPosition;
            bindStickyViewHolder(viewGroup, this.mStickyHeaderViewHolder, relativeStickyItemPosition);
        }
        setHeaderVisibility(true);
        android.view.View viewFindChildViewUnder = recyclerView.findChildViewUnder(recyclerView.getWidth() / 2, viewGroup.getHeight() - 1);
        if (viewFindChildViewUnder == null) {
            int top = recyclerView.getTop();
            this.mTargetTop = top;
            androidx.core.view.ViewCompat.offsetTopAndBottom(viewGroup, top - viewGroup.getTop());
        } else if (this.mCallback.isHeaderItem(recyclerView.getChildAdapterPosition(viewFindChildViewUnder))) {
            int top2 = (viewFindChildViewUnder.getTop() + recyclerView.getTop()) - viewGroup.getHeight();
            this.mTargetTop = top2;
            androidx.core.view.ViewCompat.offsetTopAndBottom(viewGroup, top2 - viewGroup.getTop());
        } else {
            int top3 = recyclerView.getTop();
            this.mTargetTop = top3;
            androidx.core.view.ViewCompat.offsetTopAndBottom(viewGroup, top3 - viewGroup.getTop());
        }
    }

    public int getTargetTop() {
        return this.mTargetTop;
    }

    private VH createStickyViewHolder(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        VH vh = (VH) this.mCallback.createViewHolder(recyclerView, i2);
        vh.isForStickyHeader = true;
        return vh;
    }

    private void bindStickyViewHolder(android.view.ViewGroup viewGroup, VH vh, int i) {
        this.mCallback.bindViewHolder(vh, i);
        viewGroup.removeAllViews();
        viewGroup.addView(((com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder) vh).itemView);
    }
}
