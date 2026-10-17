package com.up366.common.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface TaskExecutor {
    void post(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task);

    void post(com.up366.common.task.Task task);

    boolean postDelayed(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task, long j);

    boolean postDelayed(com.up366.common.task.Task task, long j);
}
