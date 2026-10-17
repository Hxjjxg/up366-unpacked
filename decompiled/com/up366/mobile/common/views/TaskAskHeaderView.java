package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskAskHeaderView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.TaskTeacherAskHeaderItemViewBinding binding;

    public TaskAskHeaderView(android.content.Context context) {
        this(context, null);
    }

    public TaskAskHeaderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaskAskHeaderView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = (com.up366.mobile.databinding.TaskTeacherAskHeaderItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.task_teacher_ask_header_item_view, this, true);
    }

    public void setData(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        java.lang.String time = com.up366.common.TimeUtils.formatTime(taskInfoV2.getBeginTime(), "MM");
        if (time.startsWith("0")) {
            time = time.substring(1);
        }
        java.lang.String time2 = com.up366.common.TimeUtils.formatTime(taskInfoV2.getBeginTime(), "dd");
        if (time2.startsWith("0")) {
            time2 = time2.substring(1);
        }
        this.binding.tvTaskAskDay.setText(com.up366.common.StringUtils.format("%s月%s日的练习", time, time2));
    }
}
