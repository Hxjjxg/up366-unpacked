package com.up366.qmui.widget.section;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIStickySectionLayout extends com.up366.qmui.layout.QMUIFrameLayout implements com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback {
    private java.util.List<com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration> mDrawDecorations;
    private java.lang.Runnable mPendingScrollAction;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private com.up366.qmui.widget.section.QMUIStickySectionItemDecoration mStickySectionItemDecoration;
    private int mStickySectionViewHeight;
    private com.up366.qmui.layout.QMUIFrameLayout mStickySectionWrapView;

    public interface DrawDecoration {
        void onDraw(android.graphics.Canvas canvas, com.up366.qmui.widget.section.QMUIStickySectionLayout qMUIStickySectionLayout);

        void onDrawOver(android.graphics.Canvas canvas, com.up366.qmui.widget.section.QMUIStickySectionLayout qMUIStickySectionLayout);
    }

    public interface StickySectionWrapViewConfig {
        void config(com.up366.qmui.layout.QMUIFrameLayout qMUIFrameLayout);
    }

    public QMUIStickySectionLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUIStickySectionLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIStickySectionLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStickySectionViewHeight = -1;
        this.mPendingScrollAction = null;
        this.mStickySectionWrapView = new com.up366.qmui.layout.QMUIFrameLayout(context);
        androidx.recyclerview.widget.RecyclerView recyclerView = new androidx.recyclerview.widget.RecyclerView(context);
        this.mRecyclerView = recyclerView;
        addView((android.view.View) recyclerView, (android.view.ViewGroup.LayoutParams) new android.widget.FrameLayout.LayoutParams(-1, -1));
        addView(this.mStickySectionWrapView, new android.widget.FrameLayout.LayoutParams(-1, -2));
        this.mStickySectionWrapView.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() { // from class: com.up366.qmui.widget.section.QMUIStickySectionLayout.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                com.up366.qmui.widget.section.QMUIStickySectionLayout.this.mStickySectionViewHeight = i5 - i3;
                if (com.up366.qmui.widget.section.QMUIStickySectionLayout.this.mStickySectionViewHeight <= 0 || com.up366.qmui.widget.section.QMUIStickySectionLayout.this.mPendingScrollAction == null) {
                    return;
                }
                com.up366.qmui.widget.section.QMUIStickySectionLayout.this.mPendingScrollAction.run();
                com.up366.qmui.widget.section.QMUIStickySectionLayout.this.mPendingScrollAction = null;
            }
        });
    }

    public void addDrawDecoration(com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration drawDecoration) {
        if (this.mDrawDecorations == null) {
            this.mDrawDecorations = new java.util.ArrayList();
        }
        this.mDrawDecorations.add(drawDecoration);
    }

    public void removeDrawDecoration(com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration drawDecoration) {
        java.util.List<com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration> list = this.mDrawDecorations;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mDrawDecorations.remove(drawDecoration);
    }

    public void configStickySectionWrapView(com.up366.qmui.widget.section.QMUIStickySectionLayout.StickySectionWrapViewConfig stickySectionWrapViewConfig) {
        if (stickySectionWrapViewConfig != null) {
            stickySectionWrapViewConfig.config(this.mStickySectionWrapView);
        }
    }

    public com.up366.qmui.layout.QMUIFrameLayout getStickySectionWrapView() {
        return this.mStickySectionWrapView;
    }

    public androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public android.view.View getStickySectionView() {
        if (this.mStickySectionWrapView.getVisibility() != 0 || this.mStickySectionWrapView.getChildCount() == 0) {
            return null;
        }
        return this.mStickySectionWrapView.getChildAt(0);
    }

    public void setLayoutManager(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        this.mRecyclerView.setLayoutManager(layoutManager);
    }

    public <H extends com.up366.qmui.widget.section.QMUISection.Model<H>, T extends com.up366.qmui.widget.section.QMUISection.Model<T>, VH extends com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder> void setAdapter(com.up366.qmui.widget.section.QMUIStickySectionAdapter<H, T, VH> qMUIStickySectionAdapter) {
        setAdapter(qMUIStickySectionAdapter, true);
    }

    public <H extends com.up366.qmui.widget.section.QMUISection.Model<H>, T extends com.up366.qmui.widget.section.QMUISection.Model<T>, VH extends com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder> void setAdapter(final com.up366.qmui.widget.section.QMUIStickySectionAdapter<H, T, VH> qMUIStickySectionAdapter, boolean z) {
        if (z) {
            com.up366.qmui.widget.section.QMUIStickySectionItemDecoration qMUIStickySectionItemDecoration = new com.up366.qmui.widget.section.QMUIStickySectionItemDecoration(this.mStickySectionWrapView, new com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback<VH>() { // from class: com.up366.qmui.widget.section.QMUIStickySectionLayout.2
                @Override // com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public void onHeaderVisibilityChanged(boolean z2) {
                }

                @Override // com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public int getRelativeStickyItemPosition(int i) {
                    return qMUIStickySectionAdapter.getRelativeStickyPosition(i);
                }

                @Override // com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public boolean isHeaderItem(int i) {
                    return qMUIStickySectionAdapter.getItemViewType(i) == 0;
                }

                /* JADX WARN: Incorrect return type in method signature: (Landroid/view/ViewGroup;I)TVH; */
                @Override // com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder createViewHolder(android.view.ViewGroup viewGroup, int i) {
                    return (com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder) qMUIStickySectionAdapter.createViewHolder(viewGroup, i);
                }

                /* JADX WARN: Incorrect types in method signature: (TVH;I)V */
                @Override // com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public void bindViewHolder(com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder viewHolder, int i) {
                    qMUIStickySectionAdapter.bindViewHolder(viewHolder, i);
                }

                @Override // com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public int getItemViewType(int i) {
                    return qMUIStickySectionAdapter.getItemViewType(i);
                }

                @Override // com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public void registerAdapterDataObserver(androidx.recyclerview.widget.RecyclerView.AdapterDataObserver adapterDataObserver) {
                    qMUIStickySectionAdapter.registerAdapterDataObserver(adapterDataObserver);
                }

                @Override // com.up366.qmui.widget.section.QMUIStickySectionItemDecoration.Callback
                public void invalidate() {
                    com.up366.qmui.widget.section.QMUIStickySectionLayout.this.mRecyclerView.invalidate();
                }
            });
            this.mStickySectionItemDecoration = qMUIStickySectionItemDecoration;
            this.mRecyclerView.addItemDecoration(qMUIStickySectionItemDecoration);
        }
        qMUIStickySectionAdapter.setViewCallback(this);
        this.mRecyclerView.setAdapter(qMUIStickySectionAdapter);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mStickySectionItemDecoration != null) {
            com.up366.qmui.layout.QMUIFrameLayout qMUIFrameLayout = this.mStickySectionWrapView;
            qMUIFrameLayout.layout(qMUIFrameLayout.getLeft(), this.mStickySectionItemDecoration.getTargetTop(), this.mStickySectionWrapView.getRight(), this.mStickySectionItemDecoration.getTargetTop() + this.mStickySectionWrapView.getHeight());
        }
    }

    @Override // com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback
    public void scrollToPosition(final int i, boolean z, final boolean z2) {
        int height;
        this.mPendingScrollAction = null;
        androidx.recyclerview.widget.RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        if (adapter == null || i < 0 || i >= adapter.getItemCount()) {
            return;
        }
        androidx.recyclerview.widget.LinearLayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = layoutManager;
            int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if (z) {
                height = 0;
            } else {
                if (this.mStickySectionViewHeight <= 0) {
                    this.mPendingScrollAction = new java.lang.Runnable() { // from class: com.up366.qmui.widget.section.QMUIStickySectionLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.up366.qmui.widget.section.QMUIStickySectionLayout.this.scrollToPosition(i, false, z2);
                        }
                    };
                }
                height = this.mStickySectionWrapView.getHeight();
            }
            if (i < iFindFirstCompletelyVisibleItemPosition + 1 || i > iFindLastCompletelyVisibleItemPosition || z2) {
                linearLayoutManager.scrollToPositionWithOffset(i, height);
                return;
            }
            return;
        }
        this.mRecyclerView.scrollToPosition(i);
    }

    @Override // com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback
    public androidx.recyclerview.widget.RecyclerView.ViewHolder findViewHolderForAdapterPosition(int i) {
        return this.mRecyclerView.findViewHolderForAdapterPosition(i);
    }

    @Override // com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback
    public void requestChildFocus(android.view.View view) {
        this.mRecyclerView.requestChildFocus(view, (android.view.View) null);
    }

    @Override // com.up366.qmui.layout.QMUIFrameLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        java.util.List<com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration> list = this.mDrawDecorations;
        if (list != null) {
            java.util.Iterator<com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration> it = list.iterator();
            while (it.hasNext()) {
                it.next().onDraw(canvas, this);
            }
        }
        super.dispatchDraw(canvas);
        java.util.List<com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration> list2 = this.mDrawDecorations;
        if (list2 != null) {
            java.util.Iterator<com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().onDrawOver(canvas, this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(android.view.View view, android.view.View view2) {
        java.util.List<com.up366.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration> list;
        super.onDescendantInvalidated(view, view2);
        if (view2 != this.mRecyclerView || (list = this.mDrawDecorations) == null || list.isEmpty()) {
            return;
        }
        invalidate();
    }
}
