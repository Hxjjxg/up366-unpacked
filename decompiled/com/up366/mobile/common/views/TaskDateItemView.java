package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskDateItemView extends android.widget.FrameLayout {
    private java.util.List<com.up366.mobile.course.task.TaskInfoV2> askTasks;
    private com.up366.mobile.databinding.ViewHomeworkItemDateBinding binding;
    private com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder;

    public TaskDateItemView(android.content.Context context) {
        this(context, null);
    }

    public TaskDateItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaskDateItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.askTasks = new java.util.ArrayList();
        com.up366.mobile.databinding.ViewHomeworkItemDateBinding viewHomeworkItemDateBinding = (com.up366.mobile.databinding.ViewHomeworkItemDateBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.view_homework_item_date, this, true);
        this.binding = viewHomeworkItemDateBinding;
        viewHomeworkItemDateBinding.flTaskAsk.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TaskDateItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.ShowTaskAskEvent(this.askTasks));
    }

    public void setData(java.lang.String str, java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
            int i = java.lang.Integer.parseInt(str.substring(0, 2));
            int i2 = java.lang.Integer.parseInt(str.substring(3, 5));
            this.binding.tvItemHomeworkTime.setText(i + "月" + i2 + "日练习");
        }
        this.askTasks.clear();
        java.util.ArrayList<com.up366.mobile.course.task.TaskInfoV2> arrayList = new java.util.ArrayList(list);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) it.next();
            if (!android.text.TextUtils.equals(str, com.up366.common.TimeUtils.formatTime(taskInfoV2.getBeginTime(), "MM-dd")) || com.up366.common.StringUtils.isEmptyOrNull(taskInfoV2.getStatement())) {
                it.remove();
            }
        }
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV22 : arrayList) {
            java.util.Iterator<com.up366.mobile.course.task.TaskInfoV2> it2 = this.askTasks.iterator();
            boolean z = true;
            while (it2.hasNext()) {
                if (taskInfoV22.getAssignId() == it2.next().getAssignId()) {
                    z = false;
                }
            }
            if (z) {
                this.askTasks.add(taskInfoV22);
            }
        }
        this.binding.flTaskAsk.setVisibility(this.askTasks.isEmpty() ? 8 : 0);
        this.binding.ivTaskAskTips.setVisibility(this.askTasks.isEmpty() ? 8 : 0);
    }
}
