package com.up366.mobile.me.userinfo;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeSwitchHeadPhotoActivityAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.me.HeadPhotoItemView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        if (dataHolder.viewType == 1) {
            ((com.up366.mobile.common.views.me.HeadPhotoItemView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.UserPhoto) dataHolder.o);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
