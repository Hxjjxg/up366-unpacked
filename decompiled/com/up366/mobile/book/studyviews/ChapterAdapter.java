package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterAdapter extends com.up366.mobile.common.base.BaseRecyclerAdapter {
    private java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> realDatas;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.book.studyviews.view.ChapterHeadView(viewGroup.getContext()));
        }
        return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.book.studyviews.view.ChapterItemView(viewGroup.getContext(), this));
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        int i2 = dataHolder.viewType;
        if (i2 == 0) {
            ((com.up366.mobile.book.studyviews.view.ChapterHeadView) viewHolder.itemView).setData((com.up366.mobile.book.model.TreeBookChapter) dataHolder.o);
        } else {
            if (i2 != 1) {
                return;
            }
            ((com.up366.mobile.book.studyviews.view.ChapterItemView) viewHolder.itemView).setNode((com.up366.mobile.book.model.TreeNode) dataHolder.o);
        }
    }

    @Override // com.up366.mobile.common.base.BaseRecyclerAdapter
    /* JADX INFO: renamed from: setDatas */
    public void lambda$setDatas$0(java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list) {
        this.realDatas = list;
        this.datas.clear();
        for (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder : this.realDatas) {
            if (dataHolder.viewType == 0) {
                this.datas.add(dataHolder);
            }
            if (dataHolder.viewType == 1 && ((com.up366.mobile.book.model.TreeNode) dataHolder.o).isVisible()) {
                this.datas.add(dataHolder);
            }
        }
        notifyDataSetChanged();
    }

    public void onItemClick(com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> treeNode) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder next;
        java.util.Iterator<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> it = this.datas.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.viewType == 1 && next.o.equals(treeNode)) {
                break;
            }
        }
        if (next == null) {
            return;
        }
        com.up366.mobile.book.model.TreeNode treeNode2 = (com.up366.mobile.book.model.TreeNode) next.o;
        if (treeNode2.hasSub) {
            treeNode2.isExpand = !treeNode2.isExpand;
            initDatas();
        }
    }

    private void initDatas() {
        this.datas.clear();
        for (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder : this.realDatas) {
            if (dataHolder.viewType != 1) {
                this.datas.add(dataHolder);
            } else if (((com.up366.mobile.book.model.TreeNode) dataHolder.o).isVisible()) {
                this.datas.add(dataHolder);
            }
        }
        notifyDataSetChanged();
    }
}
