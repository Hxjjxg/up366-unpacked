package com.up366.mobile.course;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CourseAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    static final int TYPE_BANNER = 6;
    static final int TYPE_GROWTH_REPORT = 12;
    static final int TYPE_HOMEWORK_TIP = 9;
    static final int TYPE_RATE = 5;
    static final int TYPE_TIP = 7;
    static final int TYPE_TITLE = 8;
    static final int TYPE_URGE = 11;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        switch (i) {
            case 5:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.CourseRateItemView(viewGroup.getContext()));
            case 6:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.CourseBannerView(viewGroup.getContext()));
            case 7:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.course_tip_view_layout));
            case 8:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.CourseTitleTextView(viewGroup.getContext()));
            case 9:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.CourseHomeworkTipItemView(viewGroup.getContext()));
            case 10:
            default:
                return defaultHandler(viewGroup, i);
            case 11:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.CourseUrgeBookItemView(viewGroup.getContext()));
            case 12:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.CourseGrowthReportView(viewGroup.getContext()));
        }
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        int i2 = dataHolder.viewType;
        if (i2 == 5) {
            ((com.up366.mobile.common.views.CourseRateItemView) viewHolder.itemView).setData((com.up366.mobile.course.task.model.CoursePageCountHolder) dataHolder.o);
            return;
        }
        if (i2 == 8) {
            ((com.up366.mobile.common.views.CourseTitleTextView) viewHolder.itemView).setData((java.lang.String) dataHolder.o);
            return;
        }
        if (i2 == 9) {
            ((com.up366.mobile.common.views.CourseHomeworkTipItemView) viewHolder.itemView).setData((com.up366.mobile.course.task.model.CoursePageCountHolder) dataHolder.o);
        } else {
            if (i2 == 11) {
                ((com.up366.mobile.common.views.CourseUrgeBookItemView) viewHolder.itemView).setData((com.up366.mobile.course.mgr.DailyInterestInfo) dataHolder.o);
                return;
            }
            if (i2 == 12) {
                ((com.up366.mobile.common.views.CourseGrowthReportView) viewHolder.itemView).setData((java.util.List) dataHolder.o);
            }
            defaultHandler(viewHolder, i);
        }
    }
}
