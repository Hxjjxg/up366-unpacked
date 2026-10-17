package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int TYPE_CURRENT_TOP_TIPS = 6;
    public static final int TYPE_SPACE_2DP = 7;
    public static final int TYPE_TASK_DATE = 5;
    public static final int TYPE_TASK_YEAR = 8;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.task.TaskItemViewV2(viewGroup.getContext()));
        }
        if (i == 5) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.TaskDateItemView(viewGroup.getContext()));
        }
        if (i == 6) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.task.TaskTopTipView(viewGroup.getContext(), true));
        }
        if (i == 7) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.adapter_snippets_space_2dp));
        }
        if (i == 8) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.TaskYearItemView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        int i2 = dataHolder.viewType;
        if (i2 == 1) {
            ((com.up366.mobile.course.task.TaskItemViewV2) viewHolder.itemView).setTaskInfo((com.up366.mobile.course.task.TaskInfoV2) dataHolder.o);
            return;
        }
        if (i2 == 5) {
            ((com.up366.mobile.common.views.TaskDateItemView) viewHolder.itemView).setData((java.lang.String) dataHolder.o, (java.util.List) dataHolder.o2);
        } else if (i2 == 8) {
            ((com.up366.mobile.common.views.TaskYearItemView) viewHolder.itemView).setYear((java.lang.String) dataHolder.o);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
