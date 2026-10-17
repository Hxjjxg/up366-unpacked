package com.up366.mobile.me.teacherclass;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class TeacherClassFragmentAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.me.MeTeachingClassView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        if (this.datas.get(i).viewType == 1) {
            ((com.up366.mobile.common.views.me.MeTeachingClassView) viewHolder.itemView).setData((com.up366.mobile.user.setting.MeTeachingClass) this.datas.get(i).o);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
