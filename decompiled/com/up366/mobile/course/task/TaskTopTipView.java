package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskTopTipView extends android.widget.LinearLayout {
    public TaskTopTipView(android.content.Context context, boolean z) {
        super(context);
        com.up366.mobile.databinding.TaskCurrentTopTipsLayoutBinding taskCurrentTopTipsLayoutBinding = (com.up366.mobile.databinding.TaskCurrentTopTipsLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.task_current_top_tips_layout, this, true);
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        if (z) {
            com.up366.mobile.common.utils.ViewUtil.visible(taskCurrentTopTipsLayoutBinding.tip);
        } else {
            com.up366.mobile.common.utils.ViewUtil.gone(taskCurrentTopTipsLayoutBinding.tip);
        }
    }
}
