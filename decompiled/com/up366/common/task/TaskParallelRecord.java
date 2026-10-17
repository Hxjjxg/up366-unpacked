package com.up366.common.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskParallelRecord {
    private final java.util.concurrent.atomic.AtomicInteger atomicInteger;
    private com.up366.common.task.TaskParallelRecord.ICallback callBackGlobalThread;
    private com.up366.common.task.TaskParallelRecord.ICallback callBackMainThread;
    private final java.lang.Object[] results;
    private boolean stop = false;

    public interface ICallback {
        void onResult(int i, java.lang.String str, java.lang.Object[] objArr);
    }

    public TaskParallelRecord(int i) {
        this.atomicInteger = new java.util.concurrent.atomic.AtomicInteger(i);
        this.results = new java.lang.Object[i];
    }

    public com.up366.common.task.TaskParallelRecord onEndInMainThread(com.up366.common.task.TaskParallelRecord.ICallback iCallback) {
        this.callBackMainThread = iCallback;
        return this;
    }

    public com.up366.common.task.TaskParallelRecord onEndInGlobalThread(com.up366.common.task.TaskParallelRecord.ICallback iCallback) {
        this.callBackGlobalThread = iCallback;
        return this;
    }

    public void success(int i, java.lang.Object obj) {
        if (this.stop) {
            com.up366.common.log.Logger.warn("TAG - 2018/4/28 - TaskParallelRecord 1 - call on end record :" + i);
            return;
        }
        java.lang.Object[] objArr = this.results;
        if (i >= objArr.length) {
            throw new java.lang.IllegalStateException("index(" + i + ") 不能超过 " + (this.results.length - 1));
        }
        objArr[i] = obj;
        if (this.atomicInteger.decrementAndGet() == 0) {
            this.stop = true;
            fireCallback(0, "success", this.results);
        }
    }

    public void error(int i, java.lang.String str) {
        this.stop = true;
        fireCallback(i, str, null);
    }

    private void fireCallback(final int i, final java.lang.String str, final java.lang.Object[] objArr) {
        if (this.callBackGlobalThread != null) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.common.task.TaskParallelRecord.1
                @Override // com.up366.common.task.Task
                public void run() throws java.lang.Exception {
                    com.up366.common.task.TaskParallelRecord.this.callBackGlobalThread.onResult(i, str, objArr);
                }
            });
        }
        if (this.callBackMainThread != null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.common.task.TaskParallelRecord.2
                @Override // com.up366.common.task.Task
                public void run() throws java.lang.Exception {
                    com.up366.common.task.TaskParallelRecord.this.callBackMainThread.onResult(i, str, objArr);
                }
            });
        }
    }
}
