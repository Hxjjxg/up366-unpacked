package com.up366.common.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class TaskWrapper implements java.lang.Runnable {
    private static final java.lang.ThreadLocal<com.up366.common.task.StackRecordException> local = new java.lang.ThreadLocal<>();
    private final com.up366.common.task.StackRecordException suppressed;
    private final com.up366.common.task.Task task;

    TaskWrapper(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task) {
        com.up366.common.task.StackRecordException stackRecordException2 = local.get();
        if (stackRecordException2 != null && stackRecordException != stackRecordException2) {
            stackRecordException.addSuppressed(stackRecordException2);
        }
        this.suppressed = stackRecordException;
        this.task = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                java.lang.ThreadLocal<com.up366.common.task.StackRecordException> threadLocal = local;
                threadLocal.set(this.suppressed);
                this.task.run();
                threadLocal.remove();
            } finally {
                local.remove();
            }
        } catch (java.lang.Error e) {
            e.addSuppressed(this.suppressed);
            com.up366.common.log.Logger.error("error msg:" + e.getMessage(), e);
        } catch (java.lang.Exception e2) {
            e2.addSuppressed(this.suppressed);
            com.up366.common.log.Logger.error("exception msg:" + e2.getMessage(), e2);
        } catch (java.lang.Throwable th) {
            th.addSuppressed(this.suppressed);
            com.up366.common.log.Logger.error("error exception msg:" + th.getMessage(), th);
        }
    }
}
