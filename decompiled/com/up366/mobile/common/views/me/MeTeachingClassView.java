package com.up366.mobile.common.views.me;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeTeachingClassView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding binding;

    public MeTeachingClassView(android.content.Context context) {
        super(context);
        initAttr(context, null, 0);
    }

    public MeTeachingClassView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttr(context, attributeSet, 0);
    }

    public MeTeachingClassView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(context, attributeSet, i);
    }

    private void initAttr(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this.binding = (com.up366.mobile.databinding.MeTearchingClassItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_tearching_class_item_view_layout, this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
        requestLayout();
    }

    public void setData(com.up366.mobile.user.setting.MeTeachingClass meTeachingClass) {
        java.lang.String time;
        this.binding.courseName.setText(meTeachingClass.getCourseName());
        this.binding.courseTeacher.setText(meTeachingClass.getLecturerName());
        if (meTeachingClass.getJoinTime() == 0) {
            time = "";
        } else {
            time = com.up366.mobile.common.utils.TimeUtilsApp.formatTime(meTeachingClass.getJoinTime(), "yyyy-MM-dd加入");
        }
        this.binding.time.setText(time);
        this.binding.courseCode.setText(com.up366.common.StringUtils.format("课程码:%s", meTeachingClass.getCourseCode()));
    }
}
