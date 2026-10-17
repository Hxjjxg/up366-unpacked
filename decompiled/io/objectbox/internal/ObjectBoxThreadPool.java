package io.objectbox.internal;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ObjectBoxThreadPool extends java.util.concurrent.ThreadPoolExecutor {
    private final io.objectbox.BoxStore boxStore;

    public ObjectBoxThreadPool(io.objectbox.BoxStore boxStore) {
        super(0, Integer.MAX_VALUE, 20L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new io.objectbox.internal.ObjectBoxThreadPool.ObjectBoxThreadFactory());
        this.boxStore = boxStore;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
        super.afterExecute(runnable, th);
        this.boxStore.closeThreadResources();
    }

    static class ObjectBoxThreadFactory implements java.util.concurrent.ThreadFactory {
        private static final java.util.concurrent.atomic.AtomicInteger POOL_COUNT = new java.util.concurrent.atomic.AtomicInteger();
        private final java.lang.ThreadGroup group;
        private final java.lang.String namePrefix = "ObjectBox-" + POOL_COUNT.incrementAndGet() + "-Thread-";
        private final java.util.concurrent.atomic.AtomicInteger threadCount = new java.util.concurrent.atomic.AtomicInteger();

        ObjectBoxThreadFactory() {
            java.lang.ThreadGroup threadGroup;
            java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = java.lang.Thread.currentThread().getThreadGroup();
            }
            this.group = threadGroup;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(this.group, runnable, this.namePrefix + this.threadCount.incrementAndGet());
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    }
}
