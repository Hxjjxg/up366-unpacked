package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskTeacherAskViewHelper {
    private com.up366.mobile.course.task.TaskAskAdpater askAdapter = new com.up366.mobile.course.task.TaskAskAdpater();
    private com.up366.mobile.databinding.ActivityTaskBinding binding;
    private int mTopMargin;
    private boolean opened;

    public TaskTeacherAskViewHelper(final com.up366.mobile.databinding.ActivityTaskBinding activityTaskBinding, androidx.lifecycle.Lifecycle lifecycle, androidx.lifecycle.Lifecycle lifecycle2) {
        this.binding = activityTaskBinding;
        this.mTopMargin = ((android.widget.FrameLayout.LayoutParams) activityTaskBinding.llTeacherAsk.getLayoutParams()).topMargin;
        activityTaskBinding.rvAsk.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(activityTaskBinding.getRoot().getContext()));
        activityTaskBinding.rvAsk.setAdapter(this.askAdapter);
        lifecycle.addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: com.up366.mobile.course.task.TaskTeacherAskViewHelper$$ExternalSyntheticLambda0
            public final void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
                this.f$0.lambda$new$0(activityTaskBinding, lifecycleOwner, event);
            }
        });
        lifecycle2.addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: com.up366.mobile.course.task.TaskTeacherAskViewHelper$$ExternalSyntheticLambda1
            public final void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
                this.f$0.lambda$new$1(activityTaskBinding, lifecycleOwner, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(com.up366.mobile.databinding.ActivityTaskBinding activityTaskBinding, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        if (event == androidx.lifecycle.Lifecycle.Event.ON_RESUME || !this.opened) {
            return;
        }
        this.opened = false;
        androidx.transition.ChangeBounds changeBounds = new androidx.transition.ChangeBounds();
        changeBounds.setDuration(200L);
        androidx.transition.TransitionManager.beginDelayedTransition(activityTaskBinding.llTeacherAsk, changeBounds);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) activityTaskBinding.llTeacherAsk.getLayoutParams();
        layoutParams.topMargin = this.mTopMargin;
        activityTaskBinding.llTeacherAsk.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(com.up366.mobile.databinding.ActivityTaskBinding activityTaskBinding, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        if (event == androidx.lifecycle.Lifecycle.Event.ON_RESUME || !this.opened) {
            return;
        }
        this.opened = false;
        androidx.transition.ChangeBounds changeBounds = new androidx.transition.ChangeBounds();
        changeBounds.setDuration(200L);
        androidx.transition.TransitionManager.beginDelayedTransition(activityTaskBinding.llTeacherAsk, changeBounds);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) activityTaskBinding.llTeacherAsk.getLayoutParams();
        layoutParams.topMargin = this.mTopMargin;
        activityTaskBinding.llTeacherAsk.setLayoutParams(layoutParams);
    }

    public void open(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(0, list.get(0)));
        java.util.Iterator<com.up366.mobile.course.task.TaskInfoV2> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, it.next()));
        }
        this.binding.rvAsk.scrollToPosition(0);
        this.askAdapter.reset();
        this.askAdapter.lambda$setDatas$0(arrayList);
        final android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.binding.llTeacherAsk.getLayoutParams();
        androidx.transition.ChangeBounds changeBounds = new androidx.transition.ChangeBounds();
        changeBounds.setDuration(200L);
        androidx.transition.TransitionManager.beginDelayedTransition(this.binding.llTeacherAsk, changeBounds);
        layoutParams.topMargin = 0;
        this.binding.llTeacherAsk.setLayoutParams(layoutParams);
        this.opened = true;
        this.binding.btClose.setExitListener(new com.up366.mobile.common.views.UpScrollExitFrameLayout.ExitListener() { // from class: com.up366.mobile.course.task.TaskTeacherAskViewHelper.1
            @Override // com.up366.mobile.common.views.UpScrollExitFrameLayout.ExitListener
            public void exit(boolean z) {
                androidx.transition.ChangeBounds changeBounds2 = new androidx.transition.ChangeBounds();
                changeBounds2.setDuration(200L);
                androidx.transition.TransitionManager.beginDelayedTransition(com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.binding.llTeacherAsk, changeBounds2);
                android.widget.FrameLayout.LayoutParams layoutParams2 = (android.widget.FrameLayout.LayoutParams) com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.binding.llTeacherAsk.getLayoutParams();
                if (z || java.lang.Math.abs(layoutParams2.topMargin) >= java.lang.Math.abs(com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.mTopMargin) / 3) {
                    layoutParams.topMargin = com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.mTopMargin;
                    com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.binding.llTeacherAsk.setLayoutParams(layoutParams);
                    com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.opened = false;
                    return;
                }
                layoutParams.topMargin = 0;
                com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.binding.llTeacherAsk.setLayoutParams(layoutParams);
                com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.opened = true;
            }

            @Override // com.up366.mobile.common.views.UpScrollExitFrameLayout.ExitListener
            public void scrollY(int i) {
                android.widget.FrameLayout.LayoutParams layoutParams2 = (android.widget.FrameLayout.LayoutParams) com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.binding.llTeacherAsk.getLayoutParams();
                if (layoutParams2.topMargin < 0 || i < 0) {
                    layoutParams2.topMargin += i;
                    com.up366.mobile.course.task.TaskTeacherAskViewHelper.this.binding.llTeacherAsk.setLayoutParams(layoutParams2);
                }
            }
        });
    }
}
