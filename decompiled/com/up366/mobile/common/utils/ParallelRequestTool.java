package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ParallelRequestTool {
    private java.util.List<com.up366.mobile.common.utils.ParallelRequestTool.IRunner> runners = new java.util.ArrayList();

    public interface IRunner {
        void run(com.up366.mobile.common.utils.ParallelRequestTool parallelRequestTool) throws java.lang.InterruptedException;
    }

    public <T> com.up366.mobile.common.utils.ParallelRequestTool add(com.up366.mobile.common.utils.ParallelRequestTool.IRunner iRunner) {
        this.runners.add(iRunner);
        return this;
    }

    public <T> void copy(com.up366.common.http.NetHolder<T> netHolder, com.up366.common.http.NetHolder<T> netHolder2) {
        netHolder.initWith(netHolder2.resp, netHolder2.info);
    }

    public void run() throws java.lang.InterruptedException {
        if (this.runners.size() == 0) {
            return;
        }
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(this.runners.size());
        for (final com.up366.mobile.common.utils.ParallelRequestTool.IRunner iRunner : this.runners) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ParallelRequestTool$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$run$0(iRunner, countDownLatch);
                }
            });
        }
        countDownLatch.await();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$run$0(com.up366.mobile.common.utils.ParallelRequestTool.IRunner iRunner, java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        iRunner.run(this);
        countDownLatch.countDown();
    }
}
