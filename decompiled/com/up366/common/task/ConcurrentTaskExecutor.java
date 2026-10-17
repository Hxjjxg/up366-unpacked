package com.up366.common.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class ConcurrentTaskExecutor implements com.up366.common.task.TaskExecutor {
    private static final int kDefaultThreadPoolSize = 4;
    private static final int kKeepAliveTime = 30;
    private static final java.util.concurrent.TimeUnit kTimeUnit = java.util.concurrent.TimeUnit.SECONDS;
    private static int maxActiveThreadSize = 0;
    private static final int maxThreadPoolSize = 1000;
    private final java.util.concurrent.ThreadPoolExecutor executorService;
    java.util.concurrent.RejectedExecutionHandler handler = new java.util.concurrent.RejectedExecutionHandler() { // from class: com.up366.common.task.ConcurrentTaskExecutor.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            java.lang.String str = "Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString();
            com.up366.common.log.Logger.error("TAG - ConcurrentTaskExecutor - rejectedExecution - " + str);
            throw new java.util.concurrent.RejectedExecutionException(str);
        }
    };

    public ConcurrentTaskExecutor(java.lang.String str) {
        this.executorService = new java.util.concurrent.ThreadPoolExecutor(4, 1000, 30L, kTimeUnit, new java.util.concurrent.SynchronousQueue(), com.up366.common.task.TaskThreadFactoryBuilder.newThreadFactory(str), this.handler);
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
        java.lang.String str = "TAG - ConcurrentTaskExecutor - post - thread size :  ActiveCount : " + this.executorService.getActiveCount() + " CompletedTaskCount : " + this.executorService.getCompletedTaskCount() + " LargestPoolSize : " + this.executorService.getLargestPoolSize() + " PoolSize : " + this.executorService.getPoolSize() + " TaskCount : " + this.executorService.getTaskCount();
        android.util.Log.v("ConcurrentTaskExecutor", str);
        int activeCount = this.executorService.getActiveCount();
        if (activeCount > maxActiveThreadSize) {
            maxActiveThreadSize = activeCount;
            if (activeCount > 20) {
                com.up366.common.global.GB.get().sendLog("base-max-active-thread-size", "maxActiveThreadSize:" + maxActiveThreadSize);
                com.up366.common.log.Logger.info(str);
            }
        }
        maxActiveThreadSize = java.lang.Math.max(maxActiveThreadSize, this.executorService.getActiveCount());
    }

    @Override // com.up366.common.task.TaskExecutor
    public boolean postDelayed(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task, long j) {
        com.up366.common.log.Logger.error("postDelayed is not support in ConcurrentTaskExecutor");
        return false;
    }
}
