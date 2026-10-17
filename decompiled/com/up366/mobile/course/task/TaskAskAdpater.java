package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskAskAdpater extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.TaskAskHeaderView(viewGroup.getContext()));
        }
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.TaskAskItemView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        int i2 = dataHolder.viewType;
        if (i2 == 0) {
            ((com.up366.mobile.common.views.TaskAskHeaderView) viewHolder.itemView).setData((com.up366.mobile.course.task.TaskInfoV2) dataHolder.o);
        } else if (i2 == 1) {
            ((com.up366.mobile.common.views.TaskAskItemView) viewHolder.itemView).setData((com.up366.mobile.course.task.TaskInfoV2) dataHolder.o);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
