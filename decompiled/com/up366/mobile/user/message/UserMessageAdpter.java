package com.up366.mobile.user.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserMessageAdpter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    final com.up366.qmui.recyclerView.QMUISwipeAction mDeleteAction;

    public UserMessageAdpter(android.content.Context context) {
        this.mDeleteAction = new com.up366.qmui.recyclerView.QMUISwipeAction.ActionBuilder().textSize(com.up366.qmui.util.QMUIDisplayHelper.sp2px(context, 14)).textColor(-1).paddingStartEnd(com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 21)).text("删除").backgroundColor(context.getResources().getColor(com.up366.mobile.R.color.c3)).build();
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == -1 || i == 3) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.EmptyStateView(viewGroup.getContext()));
        }
        com.up366.qmui.recyclerView.QMUISwipeViewHolder qMUISwipeViewHolder = new com.up366.qmui.recyclerView.QMUISwipeViewHolder(new com.up366.mobile.common.views.UserMessageItemView(viewGroup.getContext()));
        qMUISwipeViewHolder.addSwipeAction(this.mDeleteAction);
        return qMUISwipeViewHolder;
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = this.datas.get(i).viewType;
        if (i2 == -1) {
            ((com.up366.mobile.common.views.EmptyStateView) viewHolder.itemView).setData((com.up366.mobile.common.views.viewmodel.EmptyViewModel) this.datas.get(i).o);
        } else if (i2 == 1) {
            ((com.up366.mobile.common.views.UserMessageItemView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.Messages) this.datas.get(i).o);
        } else {
            if (i2 != 3) {
                return;
            }
            ((com.up366.mobile.common.views.EmptyStateView) viewHolder.itemView).showEmptyState("什么消息都没有哎");
        }
    }
}
