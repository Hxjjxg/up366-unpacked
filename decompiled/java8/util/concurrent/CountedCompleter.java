package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class CountedCompleter<T> extends java8.util.concurrent.ForkJoinTask<T> {
    private static final long PENDING;
    private static final sun.misc.Unsafe U;
    private static final long serialVersionUID = 5232453752276485070L;
    final java8.util.concurrent.CountedCompleter<?> completer;
    volatile int pending;

    public abstract void compute();

    @Override // java8.util.concurrent.ForkJoinTask
    public T getRawResult() {
        return null;
    }

    public void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
    }

    public boolean onExceptionalCompletion(java.lang.Throwable th, java8.util.concurrent.CountedCompleter<?> countedCompleter) {
        return true;
    }

    @Override // java8.util.concurrent.ForkJoinTask
    protected void setRawResult(T t) {
    }

    protected CountedCompleter(java8.util.concurrent.CountedCompleter<?> countedCompleter, int i) {
        this.completer = countedCompleter;
        this.pending = i;
    }

    protected CountedCompleter(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
        this.completer = countedCompleter;
    }

    protected CountedCompleter() {
        this.completer = null;
    }

    public final java8.util.concurrent.CountedCompleter<?> getCompleter() {
        return this.completer;
    }

    public final int getPendingCount() {
        return this.pending;
    }

    public final void setPendingCount(int i) {
        this.pending = i;
    }

    public final void addToPendingCount(int i) {
        sun.misc.Unsafe unsafe;
        long j;
        int i2;
        do {
            unsafe = U;
            j = PENDING;
            i2 = this.pending;
        } while (!unsafe.compareAndSwapInt(this, j, i2, i2 + i));
    }

    public final boolean compareAndSetPendingCount(int i, int i2) {
        return U.compareAndSwapInt(this, PENDING, i, i2);
    }

    public final int decrementPendingCountUnlessZero() {
        int i;
        do {
            i = this.pending;
            if (i == 0) {
                break;
            }
        } while (!U.compareAndSwapInt(this, PENDING, i, i - 1));
        return i;
    }

    public final java8.util.concurrent.CountedCompleter<?> getRoot() {
        java8.util.concurrent.CountedCompleter countedCompleter = this;
        while (true) {
            java8.util.concurrent.CountedCompleter countedCompleter2 = countedCompleter.completer;
            if (countedCompleter2 == null) {
                return countedCompleter;
            }
            countedCompleter = countedCompleter2;
        }
    }

    public final void tryComplete() {
        java8.util.concurrent.CountedCompleter countedCompleter = this;
        java8.util.concurrent.CountedCompleter countedCompleter2 = countedCompleter;
        while (true) {
            int i = countedCompleter.pending;
            if (i == 0) {
                countedCompleter.onCompletion(countedCompleter2);
                java8.util.concurrent.CountedCompleter<?> countedCompleter3 = countedCompleter.completer;
                if (countedCompleter3 == null) {
                    countedCompleter.quietlyComplete();
                    return;
                } else {
                    countedCompleter2 = countedCompleter;
                    countedCompleter = countedCompleter3;
                }
            } else {
                if (U.compareAndSwapInt(countedCompleter, PENDING, i, i - 1)) {
                    return;
                }
            }
        }
    }

    public final void propagateCompletion() {
        java8.util.concurrent.CountedCompleter countedCompleter = this;
        while (true) {
            int i = countedCompleter.pending;
            if (i == 0) {
                java8.util.concurrent.CountedCompleter<?> countedCompleter2 = countedCompleter.completer;
                if (countedCompleter2 == null) {
                    countedCompleter.quietlyComplete();
                    return;
                }
                countedCompleter = countedCompleter2;
            } else {
                if (U.compareAndSwapInt(countedCompleter, PENDING, i, i - 1)) {
                    return;
                }
            }
        }
    }

    @Override // java8.util.concurrent.ForkJoinTask
    public void complete(T t) {
        setRawResult(t);
        onCompletion(this);
        quietlyComplete();
        java8.util.concurrent.CountedCompleter<?> countedCompleter = this.completer;
        if (countedCompleter != null) {
            countedCompleter.tryComplete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java8.util.concurrent.CountedCompleter<?> firstComplete() {
        int i;
        do {
            i = this.pending;
            if (i == 0) {
                return this;
            }
        } while (!U.compareAndSwapInt(this, PENDING, i, i - 1));
        return null;
    }

    public final java8.util.concurrent.CountedCompleter<?> nextComplete() {
        java8.util.concurrent.CountedCompleter<?> countedCompleter = this.completer;
        if (countedCompleter != null) {
            return countedCompleter.firstComplete();
        }
        quietlyComplete();
        return null;
    }

    public final void quietlyCompleteRoot() {
        java8.util.concurrent.CountedCompleter countedCompleter = this;
        while (true) {
            java8.util.concurrent.CountedCompleter<?> countedCompleter2 = countedCompleter.completer;
            if (countedCompleter2 == null) {
                countedCompleter.quietlyComplete();
                return;
            }
            countedCompleter = countedCompleter2;
        }
    }

    public final void helpComplete(int i) {
        if (i <= 0 || this.status < 0) {
            return;
        }
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = (java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread;
            forkJoinWorkerThread.pool.helpComplete(forkJoinWorkerThread.workQueue, this, i);
        } else {
            java8.util.concurrent.ForkJoinPool.common.externalHelpComplete(this, i);
        }
    }

    @Override // java8.util.concurrent.ForkJoinTask
    void internalPropagateException(java.lang.Throwable th) {
        java8.util.concurrent.CountedCompleter<?> countedCompleter;
        java8.util.concurrent.CountedCompleter countedCompleter2 = this;
        java8.util.concurrent.CountedCompleter countedCompleter3 = countedCompleter2;
        while (countedCompleter2.onExceptionalCompletion(th, countedCompleter3) && (countedCompleter = countedCompleter2.completer) != null && countedCompleter.status >= 0 && countedCompleter.recordExceptionalCompletion(th) == Integer.MIN_VALUE) {
            countedCompleter3 = countedCompleter2;
            countedCompleter2 = countedCompleter;
        }
    }

    @Override // java8.util.concurrent.ForkJoinTask
    protected final boolean exec() {
        compute();
        return false;
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.concurrent.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            PENDING = unsafe.objectFieldOffset(java8.util.concurrent.CountedCompleter.class.getDeclaredField("pending"));
        } catch (java.lang.Exception e) {
            throw new java.lang.ExceptionInInitializerError(e);
        }
    }
}
