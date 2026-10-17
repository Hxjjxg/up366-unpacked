package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AttachmentAdapter extends com.up366.multimedia.base.BaseAdapter<com.up366.multimedia.model.MediaAttachInfo> {
    private int attTextSize;
    private int dividerHeight;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new com.up366.multimedia.base.BaseAdapter.BaseViewHolder(new com.up366.multimedia.views.AttachHeaderItemView(parent.getContext()));
        }
        if (viewType != 4) {
            if (viewType == 5) {
                return new com.up366.multimedia.base.BaseAdapter.BaseViewHolder(new com.up366.multimedia.views.AttachItemView(parent.getContext()));
            }
            if (viewType != 6) {
                return new com.up366.multimedia.base.BaseAdapter.BaseViewHolder(new com.up366.multimedia.views.AttachItemView(parent.getContext()));
            }
        }
        return new com.up366.multimedia.base.BaseAdapter.BaseViewHolder(new com.up366.multimedia.views.AttachPicVideoItemView(parent.getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        com.up366.multimedia.base.BaseAdapter.DataHolder dataHolder = this.datas.get(position);
        int i = dataHolder.viewType;
        if (i != 1) {
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        return;
                    }
                }
            }
            ((com.up366.multimedia.views.AttachPicVideoItemView) holder.itemView).setDividerHeight(this.dividerHeight);
            ((com.up366.multimedia.views.AttachPicVideoItemView) holder.itemView).setData((java.util.ArrayList) dataHolder.o);
            return;
        }
        ((com.up366.multimedia.views.AttachItemView) holder.itemView).setNameTextSize(this.attTextSize);
        ((com.up366.multimedia.views.AttachItemView) holder.itemView).setData((com.up366.multimedia.model.MediaAttachInfo) dataHolder.o, isFirst(position), isLast(position));
    }

    private boolean isFirst(int position) {
        if (position == 0) {
            return true;
        }
        return !(this.datas.get(position - 1).o instanceof com.up366.multimedia.model.MediaAttachInfo);
    }

    private boolean isLast(int position) {
        if (position == this.datas.size() - 1) {
            return true;
        }
        return !(this.datas.get(position + 1).o instanceof com.up366.multimedia.model.MediaAttachInfo);
    }

    public void setAttrs(int dividerHeight, int attTextSize) {
        this.dividerHeight = dividerHeight;
        this.attTextSize = attTextSize;
    }
}
