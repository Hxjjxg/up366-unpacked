package com.up366.common.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class MainThreadTaskExecutor implements com.up366.common.task.TaskExecutor {
    private static final android.os.Handler h = new android.os.Handler(android.os.Looper.getMainLooper());

    MainThreadTaskExecutor() {
    }

    @Override // com.up366.common.task.TaskExecutor
    public void post(com.up366.common.task.Task task) {
        post(new com.up366.common.task.StackRecordException(), task);
    }

    @Override // com.up366.common.task.TaskExecutor
    public void post(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task) {
        h.post(new com.up366.common.task.TaskWrapper(stackRecordException, task));
    }

    @Override // com.up366.common.task.TaskExecutor
    public boolean postDelayed(com.up366.common.task.Task task, long j) {
        return postDelayed(new com.up366.common.task.StackRecordException(), task, j);
    }

    @Override // com.up366.common.task.TaskExecutor
    public boolean postDelayed(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task, long j) {
        return h.postDelayed(new com.up366.common.task.TaskWrapper(stackRecordException, task), j);
    }
}
