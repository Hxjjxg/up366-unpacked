package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskAskItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.TaskAskItemViewBinding binding;

    public TaskAskItemView(android.content.Context context) {
        this(context, null);
    }

    public TaskAskItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaskAskItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = (com.up366.mobile.databinding.TaskAskItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.task_ask_item_view, this, true);
    }

    public void setData(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        this.binding.tvAskTime.setText(com.up366.common.TimeUtils.formatTime(taskInfoV2.getBeginTime(), "MM.dd HH:mm"));
        this.binding.tvTaskAskMessage.setText(taskInfoV2.getStatement());
    }
}
