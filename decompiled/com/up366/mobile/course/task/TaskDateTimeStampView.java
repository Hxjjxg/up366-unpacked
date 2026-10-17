package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskDateTimeStampView extends android.widget.LinearLayout {
    com.up366.mobile.databinding.TaskItemDayTimeStampLayoutBinding binding;

    public TaskDateTimeStampView(android.content.Context context) {
        super(context);
        init();
    }

    private void init() {
        this.binding = (com.up366.mobile.databinding.TaskItemDayTimeStampLayoutBinding) androidx.databinding.DataBindingUtil.inflate(((android.app.Activity) getContext()).getLayoutInflater(), com.up366.mobile.R.layout.task_item_day_time_stamp_layout, this, true);
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
    }

    public void setTimeStamp(java.lang.String str) {
        this.binding.weekTimeStamp.setText(str);
    }
}
