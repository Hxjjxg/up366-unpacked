package com.up366.common.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class TaskThreadFactoryBuilder {
    private final java.util.concurrent.atomic.AtomicLong seq = new java.util.concurrent.atomic.AtomicLong(0);
    private final java.lang.String threadPrefix;

    static java.util.concurrent.ThreadFactory newThreadFactory(java.lang.String str) {
        return new com.up366.common.task.TaskThreadFactoryBuilder(str).build();
    }

    private TaskThreadFactoryBuilder(java.lang.String str) {
        this.threadPrefix = str;
    }

    private java.util.concurrent.ThreadFactory build() {
        return new java.util.concurrent.ThreadFactory() { // from class: com.up366.common.task.TaskThreadFactoryBuilder.1
            @Override // java.util.concurrent.ThreadFactory
            public java.lang.Thread newThread(java.lang.Runnable runnable) {
                java.lang.Thread threadNewThread = java.util.concurrent.Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName(com.up366.common.task.TaskThreadFactoryBuilder.this.threadPrefix + "-" + com.up366.common.task.TaskThreadFactoryBuilder.this.seq.incrementAndGet());
                return threadNewThread;
            }
        };
    }
}
