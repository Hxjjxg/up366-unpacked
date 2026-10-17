package com.up366.mobile.me.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeHomeMyBookAdpter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int PLACE_HOLDER = -10001;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == -10001) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.me.views.MeHomeMyBookPlaceHolderView(viewGroup.getContext()));
        }
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.me.MeHomeMyBookItemView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        if (this.datas.get(i).viewType == 1) {
            ((com.up366.mobile.common.views.me.MeHomeMyBookItemView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.MyBook) this.datas.get(i).o);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
