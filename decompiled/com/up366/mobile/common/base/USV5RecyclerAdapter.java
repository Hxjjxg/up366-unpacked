package com.up366.mobile.common.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class USV5RecyclerAdapter extends com.up366.mobile.common.base.BaseRecyclerAdapter {
    public static final int TYPE_COMMON_BOTTOM_SHADOW = -9992;
    public static final int TYPE_COMMON_TOP_SHADOW = -9991;
    public static final int TYPE_DIVIDER_LINE = -9993;
    public static final int TYPE_DIVIDER_LINE_37DP = -9989;
    public static final int TYPE_NO_DATA_SMALL = -9997;
    public static final int TYPE_NO_DATA_SMALL_MATCH = -9996;
    public static final int TYPE_SPACE_12DP = -9999;
    public static final int TYPE_SPACE_16DP = -9994;
    public static final int TYPE_SPACE_6DP = -9998;
    public static final int TYPE_SPACE_BY_HEIGHT = -9988;
    public static final int TYPE_SPACE_WIDTH_12DP = -9990;
    public static final int TYPE_TITLE_ITEM = -9995;

    protected androidx.recyclerview.widget.RecyclerView.ViewHolder defaultHandler(android.view.ViewGroup viewGroup, int i) {
        if (i == -9999) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_space_12dp));
        }
        if (i == -9998) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_space_6dp));
        }
        if (i == -6) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.RefreshUpView(viewGroup.getContext()));
        }
        if (i == 3 || i == -2 || i == -1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.EmptyStateView(viewGroup.getContext()));
        }
        switch (i) {
            case TYPE_SPACE_16DP /* -9994 */:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_space_16dp));
            case TYPE_DIVIDER_LINE /* -9993 */:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_line_padding));
            case TYPE_COMMON_BOTTOM_SHADOW /* -9992 */:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_bottom_shadow));
            case TYPE_COMMON_TOP_SHADOW /* -9991 */:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_top_shadow));
            case TYPE_SPACE_WIDTH_12DP /* -9990 */:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_space_width_12dp));
            case TYPE_DIVIDER_LINE_37DP /* -9989 */:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_line_padding_37dp));
            case TYPE_SPACE_BY_HEIGHT /* -9988 */:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.RecyclerSpaceItemView(viewGroup.getContext()));
            default:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_line_padding));
        }
    }

    protected void defaultHandler(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        int i2 = dataHolder.viewType;
        if (i2 == -9988) {
            ((com.up366.mobile.common.views.RecyclerSpaceItemView) viewHolder.itemView).setSpaceHeight(((java.lang.Integer) dataHolder.o).intValue());
            return;
        }
        if (i2 == -6) {
            ((com.up366.mobile.common.views.RefreshUpView) viewHolder.itemView).setData((com.up366.mobile.common.views.RefreshUpView.Data) dataHolder.o);
        } else if (i2 == 3 || i2 == -2 || i2 == -1) {
            ((com.up366.mobile.common.views.EmptyStateView) viewHolder.itemView).setData((com.up366.mobile.common.views.viewmodel.EmptyViewModel) dataHolder.o);
        }
    }
}
