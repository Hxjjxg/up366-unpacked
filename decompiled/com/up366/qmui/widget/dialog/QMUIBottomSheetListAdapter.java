package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH> {
    public static final int ITEM_TYPE_FOOTER = 2;
    public static final int ITEM_TYPE_HEADER = 1;
    public static final int ITEM_TYPE_NORMAL = 3;
    private android.view.View mFooterView;
    private final boolean mGravityCenter;
    private android.view.View mHeaderView;
    private final boolean mNeedMark;
    private com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.OnItemClickListener mOnItemClickListener;
    private final boolean mRightMarkSelectedFalseVisible;
    private java.util.List<com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel> mData = new java.util.ArrayList();
    private int mCheckedIndex = -1;

    interface OnItemClickListener {
        void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH vh, int i, com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel qMUIBottomSheetListItemModel);
    }

    public QMUIBottomSheetListAdapter(boolean z, boolean z2, boolean z3) {
        this.mNeedMark = z;
        this.mGravityCenter = z3;
        this.mRightMarkSelectedFalseVisible = z2;
    }

    public void setCheckedIndex(int i) {
        this.mCheckedIndex = i;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setData(android.view.View view, android.view.View view2, java.util.List<com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel> list) {
        this.mHeaderView = view;
        this.mFooterView = view2;
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public int getItemViewType(int i) {
        if (this.mHeaderView == null || i != 0) {
            return (i != getItemCount() - 1 || this.mFooterView == null) ? 3 : 2;
        }
        return 1;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH(this.mHeaderView);
        }
        if (i == 2) {
            return new com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH(this.mFooterView);
        }
        final com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH vh = new com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH(new com.up366.qmui.widget.dialog.QMUIBottomSheetListItemView(viewGroup.getContext(), this.mNeedMark, this.mRightMarkSelectedFalseVisible, this.mGravityCenter));
        vh.itemView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.this.mOnItemClickListener != null) {
                    int adapterPosition = vh.getAdapterPosition();
                    if (com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.this.mHeaderView != null) {
                        adapterPosition--;
                    }
                    com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.this.mOnItemClickListener.onClick(vh, adapterPosition, (com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel) com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.this.mData.get(adapterPosition));
                }
            }
        });
        return vh;
    }

    public void onBindViewHolder(com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH vh, int i) {
        if (vh.getItemViewType() != 3) {
            return;
        }
        if (this.mHeaderView != null) {
            i--;
        }
        ((com.up366.qmui.widget.dialog.QMUIBottomSheetListItemView) vh.itemView).render(this.mData.get(i), i == this.mCheckedIndex);
    }

    public int getItemCount() {
        return this.mData.size() + (this.mHeaderView != null ? 1 : 0) + (this.mFooterView == null ? 0 : 1);
    }

    static class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public VH(android.view.View view) {
            super(view);
        }
    }
}
