package com.up366.mobile.common.logic.log;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskMapRunner {
    private final java.util.List<?> list;
    private final java.util.List<com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner> maps = new java.util.ArrayList();
    private final int[] nums;

    public interface IMapRunner {
        java.lang.Object run(com.up366.mobile.common.logic.log.TaskMapRunner.MapRunnerCtx mapRunnerCtx, java.lang.Object obj);
    }

    public static class MapRunnerCtx {
        boolean stop = false;
    }

    private TaskMapRunner(java.util.List<?> list, int[] iArr) {
        this.list = list;
        this.nums = iArr;
    }

    public static com.up366.mobile.common.logic.log.TaskMapRunner create(java.util.List<?> list, int[] iArr) {
        return new com.up366.mobile.common.logic.log.TaskMapRunner(list, iArr);
    }

    public com.up366.mobile.common.logic.log.TaskMapRunner map(com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner iMapRunner) {
        this.maps.add(iMapRunner);
        return this;
    }

    public <T> java.util.List<T> start() {
        if (com.up366.common.task.TaskUtils.isMainThread()) {
            throw new java.lang.IllegalStateException("start 应该在子线程中调用");
        }
        int[] iArr = this.nums;
        java.util.List<com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner> list = this.maps;
        final java.lang.Object[] array = this.list.toArray();
        for (int i = 0; i < list.size(); i++) {
            int i2 = iArr[i];
            final com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner iMapRunner = list.get(i);
            final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);
            java.util.concurrent.atomic.AtomicInteger atomicInteger2 = new java.util.concurrent.atomic.AtomicInteger(0);
            int i3 = 0;
            while (i3 < i2) {
                final com.up366.mobile.common.logic.log.TaskMapRunner.MapRunnerCtx mapRunnerCtx = new com.up366.mobile.common.logic.log.TaskMapRunner.MapRunnerCtx();
                final java.util.concurrent.atomic.AtomicInteger atomicInteger3 = atomicInteger;
                final java.util.concurrent.atomic.AtomicInteger atomicInteger4 = atomicInteger2;
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.log.TaskMapRunner$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.common.logic.log.TaskMapRunner.lambda$start$0(array, countDownLatch, atomicInteger3, mapRunnerCtx, iMapRunner, atomicInteger4);
                    }
                });
                i3++;
                atomicInteger2 = atomicInteger4;
                atomicInteger = atomicInteger;
            }
            try {
                countDownLatch.await();
            } catch (java.lang.InterruptedException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : array) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    static /* synthetic */ void lambda$start$0(java.lang.Object[] objArr, java.util.concurrent.CountDownLatch countDownLatch, java.util.concurrent.atomic.AtomicInteger atomicInteger, com.up366.mobile.common.logic.log.TaskMapRunner.MapRunnerCtx mapRunnerCtx, com.up366.mobile.common.logic.log.TaskMapRunner.IMapRunner iMapRunner, java.util.concurrent.atomic.AtomicInteger atomicInteger2) throws java.lang.Exception {
        if (objArr.length == 0) {
            countDownLatch.countDown();
            return;
        }
        do {
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement >= objArr.length || mapRunnerCtx.stop) {
                return;
            }
            objArr[andIncrement] = iMapRunner.run(mapRunnerCtx, objArr[andIncrement]);
            if (mapRunnerCtx.stop) {
                countDownLatch.countDown();
                return;
            }
        } while (atomicInteger2.addAndGet(1) < objArr.length);
        countDownLatch.countDown();
    }
}
