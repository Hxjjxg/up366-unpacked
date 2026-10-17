package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ForkJoinWorkerThread extends java.lang.Thread {
    private static final java.lang.String NAME_PLACEHOLDER = "aForkJoinWorkerThread";
    final java8.util.concurrent.ForkJoinPool pool;
    final java8.util.concurrent.ForkJoinPool.WorkQueue workQueue;

    void afterTopLevelExec() {
    }

    protected void onStart() {
    }

    protected void onTermination(java.lang.Throwable th) {
    }

    protected ForkJoinWorkerThread(java8.util.concurrent.ForkJoinPool forkJoinPool) {
        super(NAME_PLACEHOLDER);
        this.pool = forkJoinPool;
        this.workQueue = forkJoinPool.registerWorker(this);
    }

    ForkJoinWorkerThread(java8.util.concurrent.ForkJoinPool forkJoinPool, java.lang.ClassLoader classLoader) {
        super(NAME_PLACEHOLDER);
        java8.util.concurrent.TLRandom.setContextClassLoader(this, classLoader);
        this.pool = forkJoinPool;
        this.workQueue = forkJoinPool.registerWorker(this);
    }

    ForkJoinWorkerThread(java8.util.concurrent.ForkJoinPool forkJoinPool, java.lang.ClassLoader classLoader, java.lang.ThreadGroup threadGroup, java.security.AccessControlContext accessControlContext) {
        super(threadGroup, NAME_PLACEHOLDER);
        super.setContextClassLoader(classLoader);
        java8.util.concurrent.TLRandom.setInheritedAccessControlContext(this, accessControlContext);
        java8.util.concurrent.TLRandom.eraseThreadLocals(this);
        this.pool = forkJoinPool;
        this.workQueue = forkJoinPool.registerWorker(this);
    }

    public java8.util.concurrent.ForkJoinPool getPool() {
        return this.pool;
    }

    public int getPoolIndex() {
        return this.workQueue.getPoolIndex();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws java.lang.Throwable {
        if (this.workQueue.array == null) {
            try {
                onStart();
                this.pool.runWorker(this.workQueue);
                th = null;
                try {
                    onTermination(null);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    onTermination(th);
                } catch (java.lang.Throwable unused) {
                }
            }
            this.pool.deregisterWorker(this, th);
        }
    }

    static final class InnocuousForkJoinWorkerThread extends java8.util.concurrent.ForkJoinWorkerThread {
        private static final java.lang.ThreadGroup innocuousThreadGroup = (java.lang.ThreadGroup) java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java.lang.ThreadGroup>() { // from class: java8.util.concurrent.ForkJoinWorkerThread.InnocuousForkJoinWorkerThread.1
            @Override // java.security.PrivilegedAction
            public java.lang.ThreadGroup run() {
                java.lang.ThreadGroup threadGroup = java.lang.Thread.currentThread().getThreadGroup();
                while (true) {
                    java.lang.ThreadGroup parent = threadGroup.getParent();
                    if (parent == null) {
                        return new java.lang.ThreadGroup(threadGroup, "InnocuousForkJoinWorkerThreadGroup");
                    }
                    threadGroup = parent;
                }
            }
        });
        private static final java.security.AccessControlContext INNOCUOUS_ACC = new java.security.AccessControlContext(new java.security.ProtectionDomain[]{new java.security.ProtectionDomain(null, null)});

        @Override // java.lang.Thread
        public void setUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        }

        InnocuousForkJoinWorkerThread(java8.util.concurrent.ForkJoinPool forkJoinPool) {
            super(forkJoinPool, java.lang.ClassLoader.getSystemClassLoader(), innocuousThreadGroup, INNOCUOUS_ACC);
        }

        @Override // java8.util.concurrent.ForkJoinWorkerThread
        void afterTopLevelExec() {
            java8.util.concurrent.TLRandom.eraseThreadLocals(this);
        }

        @Override // java.lang.Thread
        public void setContextClassLoader(java.lang.ClassLoader classLoader) {
            if (classLoader != null && java.lang.ClassLoader.getSystemClassLoader() != classLoader) {
                throw new java.lang.SecurityException("setContextClassLoader");
            }
        }
    }
}
