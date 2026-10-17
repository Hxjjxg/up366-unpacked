package com.up366.common.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class SerialTaskExecutor implements com.up366.common.task.TaskExecutor {
    private final java.util.concurrent.ExecutorService executorService;

    @Override // com.up366.common.task.TaskExecutor
    public boolean postDelayed(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task, long j) {
        return false;
    }

    SerialTaskExecutor(java.lang.String str) {
        this.executorService = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), com.up366.common.task.TaskThreadFactoryBuilder.newThreadFactory(str));
    }

    @Override // com.up366.common.task.TaskExecutor
    public void post(com.up366.common.task.Task task) {
        post(new com.up366.common.task.StackRecordException(), task);
    }

    @Override // com.up366.common.task.TaskExecutor
    public boolean postDelayed(com.up366.common.task.Task task, long j) {
        return postDelayed(new com.up366.common.task.StackRecordException(), task, j);
    }

    @Override // com.up366.common.task.TaskExecutor
    public void post(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task) {
        this.executorService.submit(new com.up366.common.task.TaskWrapper(stackRecordException, task));
    }
}
