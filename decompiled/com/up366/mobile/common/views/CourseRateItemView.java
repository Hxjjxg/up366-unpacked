package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseRateItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.CourseRateItemViewLayoutBinding b;
    private com.up366.mobile.course.task.model.CoursePageCountHolder holder;

    public CourseRateItemView(android.content.Context context) {
        this(context, null);
    }

    public CourseRateItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CourseRateItemView(final android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.CourseRateItemViewLayoutBinding courseRateItemViewLayoutBinding = (com.up366.mobile.databinding.CourseRateItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_rate_item_view_layout, this, true);
        this.b = courseRateItemViewLayoutBinding;
        courseRateItemViewLayoutBinding.clRateItem.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseRateItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                android.content.Context context2 = context;
                context2.startActivity(new android.content.Intent(context2, (java.lang.Class<?>) com.up366.mobile.course.LearnTrailActivity.class));
            }
        });
    }

    public void setData(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        this.holder = coursePageCountHolder;
        if (coursePageCountHolder.getPercent() == 101.0f) {
            com.up366.mobile.common.utils.ViewUtil.invisible(this.b.rateTip, this.b.rateTipArrow);
            this.b.scoreAvg.setText("--");
            this.b.scoreMax.setText("--");
        } else {
            this.b.scoreAvg.setText(java.lang.String.valueOf((int) coursePageCountHolder.getPercent()));
            this.b.scoreMax.setText(java.lang.String.valueOf((int) coursePageCountHolder.getMaxPercent()));
            int compareLast = (int) coursePageCountHolder.getCompareLast();
            int compareGlobal = (int) coursePageCountHolder.getCompareGlobal();
            java.lang.String string = "";
            if (compareLast != 101.0f && compareLast != 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("比上次");
                sb.append(compareLast > 0 ? "+" : "-");
                sb.append(java.lang.Math.abs(compareLast));
                sb.append("%");
                if (compareGlobal != 0 && compareGlobal != 101.0f) {
                    string = "，";
                }
                sb.append(string);
                string = sb.toString();
            }
            if (compareGlobal != 101.0f && compareGlobal != 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(string);
                sb2.append("比全球");
                sb2.append(compareGlobal <= 0 ? "-" : "+");
                sb2.append(java.lang.Math.abs(compareGlobal));
                sb2.append("%");
                string = sb2.toString();
            }
            if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
                com.up366.mobile.common.utils.ViewUtil.invisible(this.b.rateTip, this.b.rateTipArrow);
            } else {
                com.up366.mobile.common.utils.ViewUtil.visible(this.b.rateTip, this.b.rateTipArrow);
                this.b.rateTip.setText(string);
            }
        }
        this.b.month.setText(com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "M月"));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
