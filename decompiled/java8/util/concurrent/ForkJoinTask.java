package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ForkJoinTask<V> implements java.util.concurrent.Future<V>, java.io.Serializable {
    static final int CANCELLED = -1073741824;
    static final int DONE_MASK = -268435456;
    static final int EXCEPTIONAL = Integer.MIN_VALUE;
    static final int NORMAL = -268435456;
    static final int SIGNAL = 65536;
    static final int SMASK = 65535;
    private static final long STATUS;
    private static final sun.misc.Unsafe U;
    private static final java8.util.concurrent.ForkJoinTask.ExceptionNode[] exceptionTable = new java8.util.concurrent.ForkJoinTask.ExceptionNode[32];
    private static final java.util.concurrent.locks.ReentrantLock exceptionTableLock = new java.util.concurrent.locks.ReentrantLock();
    private static final java.lang.ref.ReferenceQueue<java8.util.concurrent.ForkJoinTask<?>> exceptionTableRefQueue = new java.lang.ref.ReferenceQueue<>();
    private static final long serialVersionUID = -7721805057305804111L;
    volatile int status;

    protected abstract boolean exec();

    public abstract V getRawResult();

    void internalPropagateException(java.lang.Throwable th) {
    }

    protected abstract void setRawResult(V v);

    private int setCompletion(int i) {
        int i2;
        do {
            i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
        } while (!U.compareAndSwapInt(this, STATUS, i2, i2 | i));
        if ((i2 >>> 16) != 0) {
            synchronized (this) {
                notifyAll();
            }
        }
        return i;
    }

    final int doExec() {
        int i = this.status;
        if (i < 0) {
            return i;
        }
        try {
            return exec() ? setCompletion(-268435456) : i;
        } catch (java.lang.Throwable th) {
            return setExceptionalCompletion(th);
        }
    }

    final void internalWait(long j) {
        int i = this.status;
        if (i < 0 || !U.compareAndSwapInt(this, STATUS, i, i | 65536)) {
            return;
        }
        synchronized (this) {
            if (this.status >= 0) {
                try {
                    wait(j);
                } catch (java.lang.InterruptedException unused) {
                }
            } else {
                notifyAll();
            }
        }
    }

    private int externalAwaitDone() {
        int iDoExec;
        boolean z = false;
        if (this instanceof java8.util.concurrent.CountedCompleter) {
            iDoExec = java8.util.concurrent.ForkJoinPool.common.externalHelpComplete((java8.util.concurrent.CountedCompleter) this, 0);
        } else {
            iDoExec = java8.util.concurrent.ForkJoinPool.common.tryExternalUnpush(this) ? doExec() : 0;
        }
        if (iDoExec < 0) {
            return iDoExec;
        }
        int i = this.status;
        if (i < 0) {
            return i;
        }
        int i2 = i;
        do {
            if (U.compareAndSwapInt(this, STATUS, i2, i2 | 65536)) {
                synchronized (this) {
                    if (this.status >= 0) {
                        try {
                            wait(0L);
                        } catch (java.lang.InterruptedException unused) {
                            z = true;
                        }
                    } else {
                        notifyAll();
                    }
                }
            }
            i2 = this.status;
        } while (i2 >= 0);
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
        return i2;
    }

    private int externalInterruptibleAwaitDone() throws java.lang.InterruptedException {
        int iDoExec;
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        int i = this.status;
        if (i < 0) {
            return i;
        }
        if (this instanceof java8.util.concurrent.CountedCompleter) {
            iDoExec = java8.util.concurrent.ForkJoinPool.common.externalHelpComplete((java8.util.concurrent.CountedCompleter) this, 0);
        } else {
            iDoExec = java8.util.concurrent.ForkJoinPool.common.tryExternalUnpush(this) ? doExec() : 0;
        }
        if (iDoExec < 0) {
            return iDoExec;
        }
        while (true) {
            int i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
            if (U.compareAndSwapInt(this, STATUS, i2, i2 | 65536)) {
                synchronized (this) {
                    if (this.status >= 0) {
                        wait(0L);
                    } else {
                        notifyAll();
                    }
                }
            }
        }
    }

    private int doJoin() {
        int iDoExec;
        int i = this.status;
        if (i < 0) {
            return i;
        }
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (!(threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread)) {
            return externalAwaitDone();
        }
        java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = (java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread;
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = forkJoinWorkerThread.workQueue;
        return (!workQueue.tryUnpush(this) || (iDoExec = doExec()) >= 0) ? forkJoinWorkerThread.pool.awaitJoin(workQueue, this, 0L) : iDoExec;
    }

    private int doInvoke() {
        int iDoExec = doExec();
        if (iDoExec < 0) {
            return iDoExec;
        }
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = (java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread;
            return forkJoinWorkerThread.pool.awaitJoin(forkJoinWorkerThread.workQueue, this, 0L);
        }
        return externalAwaitDone();
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.concurrent.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            STATUS = unsafe.objectFieldOffset(java8.util.concurrent.ForkJoinTask.class.getDeclaredField("status"));
        } catch (java.lang.Exception e) {
            throw new java.lang.ExceptionInInitializerError(e);
        }
    }

    static final class ExceptionNode extends java.lang.ref.WeakReference<java8.util.concurrent.ForkJoinTask<?>> {
        final java.lang.Throwable ex;
        final int hashCode;
        java8.util.concurrent.ForkJoinTask.ExceptionNode next;
        final long thrower;

        ExceptionNode(java8.util.concurrent.ForkJoinTask<?> forkJoinTask, java.lang.Throwable th, java8.util.concurrent.ForkJoinTask.ExceptionNode exceptionNode, java.lang.ref.ReferenceQueue<java8.util.concurrent.ForkJoinTask<?>> referenceQueue) {
            super(forkJoinTask, referenceQueue);
            this.ex = th;
            this.next = exceptionNode;
            this.thrower = java.lang.Thread.currentThread().getId();
            this.hashCode = java.lang.System.identityHashCode(forkJoinTask);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        r2[r0] = new java8.util.concurrent.ForkJoinTask.ExceptionNode(r6, r7, r2[r0], java8.util.concurrent.ForkJoinTask.exceptionTableRefQueue);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int recordExceptionalCompletion(java.lang.Throwable r7) {
        /*
            r6 = this;
            int r0 = r6.status
            if (r0 < 0) goto L3e
            int r0 = java.lang.System.identityHashCode(r6)
            java.util.concurrent.locks.ReentrantLock r1 = java8.util.concurrent.ForkJoinTask.exceptionTableLock
            r1.lock()
            expungeStaleExceptions()     // Catch: java.lang.Throwable -> L39
            java8.util.concurrent.ForkJoinTask$ExceptionNode[] r2 = java8.util.concurrent.ForkJoinTask.exceptionTable     // Catch: java.lang.Throwable -> L39
            int r3 = r2.length     // Catch: java.lang.Throwable -> L39
            int r3 = r3 + (-1)
            r0 = r0 & r3
            r3 = r2[r0]     // Catch: java.lang.Throwable -> L39
        L18:
            if (r3 != 0) goto L26
            java8.util.concurrent.ForkJoinTask$ExceptionNode r3 = new java8.util.concurrent.ForkJoinTask$ExceptionNode     // Catch: java.lang.Throwable -> L39
            r4 = r2[r0]     // Catch: java.lang.Throwable -> L39
            java.lang.ref.ReferenceQueue<java8.util.concurrent.ForkJoinTask<?>> r5 = java8.util.concurrent.ForkJoinTask.exceptionTableRefQueue     // Catch: java.lang.Throwable -> L39
            r3.<init>(r6, r7, r4, r5)     // Catch: java.lang.Throwable -> L39
            r2[r0] = r3     // Catch: java.lang.Throwable -> L39
            goto L2c
        L26:
            java.lang.Object r4 = r3.get()     // Catch: java.lang.Throwable -> L39
            if (r4 != r6) goto L36
        L2c:
            r1.unlock()
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = r6.setCompletion(r7)
            goto L3e
        L36:
            java8.util.concurrent.ForkJoinTask$ExceptionNode r3 = r3.next     // Catch: java.lang.Throwable -> L39
            goto L18
        L39:
            r7 = move-exception
            r1.unlock()
            throw r7
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinTask.recordExceptionalCompletion(java.lang.Throwable):int");
    }

    private int setExceptionalCompletion(java.lang.Throwable th) {
        int iRecordExceptionalCompletion = recordExceptionalCompletion(th);
        if (((-268435456) & iRecordExceptionalCompletion) == Integer.MIN_VALUE) {
            internalPropagateException(th);
        }
        return iRecordExceptionalCompletion;
    }

    static final void cancelIgnoringExceptions(java8.util.concurrent.ForkJoinTask<?> forkJoinTask) {
        if (forkJoinTask == null || forkJoinTask.status < 0) {
            return;
        }
        try {
            forkJoinTask.cancel(false);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void clearExceptionalCompletion() {
        int iIdentityHashCode = java.lang.System.identityHashCode(this);
        java.util.concurrent.locks.ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            java8.util.concurrent.ForkJoinTask.ExceptionNode[] exceptionNodeArr = exceptionTable;
            int length = iIdentityHashCode & (exceptionNodeArr.length - 1);
            java8.util.concurrent.ForkJoinTask.ExceptionNode exceptionNode = exceptionNodeArr[length];
            java8.util.concurrent.ForkJoinTask.ExceptionNode exceptionNode2 = null;
            while (true) {
                if (exceptionNode == null) {
                    break;
                }
                java8.util.concurrent.ForkJoinTask.ExceptionNode exceptionNode3 = exceptionNode.next;
                if (exceptionNode.get() != this) {
                    exceptionNode2 = exceptionNode;
                    exceptionNode = exceptionNode3;
                } else if (exceptionNode2 == null) {
                    exceptionNodeArr[length] = exceptionNode3;
                } else {
                    exceptionNode2.next = exceptionNode3;
                }
            }
            expungeStaleExceptions();
            this.status = 0;
        } finally {
            reentrantLock.unlock();
        }
    }

    private java.lang.Throwable getThrowableException() {
        java.lang.Throwable th;
        int iIdentityHashCode = java.lang.System.identityHashCode(this);
        java.util.concurrent.locks.ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            expungeStaleExceptions();
            java8.util.concurrent.ForkJoinTask.ExceptionNode[] exceptionNodeArr = exceptionTable;
            java8.util.concurrent.ForkJoinTask.ExceptionNode exceptionNode = exceptionNodeArr[iIdentityHashCode & (exceptionNodeArr.length - 1)];
            while (exceptionNode != null) {
                if (exceptionNode.get() == this) {
                    break;
                }
                exceptionNode = exceptionNode.next;
            }
            reentrantLock.unlock();
            if (exceptionNode == null || (th = exceptionNode.ex) == null) {
                return null;
            }
            if (exceptionNode.thrower != java.lang.Thread.currentThread().getId()) {
                try {
                    java.lang.reflect.Constructor<?> constructor = null;
                    for (java.lang.reflect.Constructor<?> constructor2 : th.getClass().getConstructors()) {
                        java.lang.Class<?>[] parameterTypes = constructor2.getParameterTypes();
                        if (parameterTypes.length == 0) {
                            constructor = constructor2;
                        } else if (parameterTypes.length == 1 && parameterTypes[0] == java.lang.Throwable.class) {
                            return (java.lang.Throwable) constructor2.newInstance(th);
                        }
                    }
                    if (constructor != null) {
                        java.lang.Throwable th2 = (java.lang.Throwable) constructor.newInstance(null);
                        th2.initCause(th);
                        return th2;
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            return th;
        } catch (java.lang.Throwable th3) {
            reentrantLock.unlock();
            throw th3;
        }
    }

    private static void expungeStaleExceptions() {
        while (true) {
            java.lang.ref.Reference<? extends java8.util.concurrent.ForkJoinTask<?>> referencePoll = exceptionTableRefQueue.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof java8.util.concurrent.ForkJoinTask.ExceptionNode) {
                java8.util.concurrent.ForkJoinTask.ExceptionNode[] exceptionNodeArr = exceptionTable;
                int length = ((java8.util.concurrent.ForkJoinTask.ExceptionNode) referencePoll).hashCode & (exceptionNodeArr.length - 1);
                java8.util.concurrent.ForkJoinTask.ExceptionNode exceptionNode = exceptionNodeArr[length];
                java8.util.concurrent.ForkJoinTask.ExceptionNode exceptionNode2 = null;
                while (true) {
                    if (exceptionNode != null) {
                        java8.util.concurrent.ForkJoinTask.ExceptionNode exceptionNode3 = exceptionNode.next;
                        if (exceptionNode != referencePoll) {
                            exceptionNode2 = exceptionNode;
                            exceptionNode = exceptionNode3;
                        } else if (exceptionNode2 == null) {
                            exceptionNodeArr[length] = exceptionNode3;
                        } else {
                            exceptionNode2.next = exceptionNode3;
                        }
                    }
                }
            }
        }
    }

    static final void helpExpungeStaleExceptions() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = exceptionTableLock;
        if (reentrantLock.tryLock()) {
            try {
                expungeStaleExceptions();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    static void rethrow(java.lang.Throwable th) throws java.lang.Throwable {
        uncheckedThrow(th);
    }

    static <T extends java.lang.Throwable> void uncheckedThrow(java.lang.Throwable th) throws java.lang.Throwable {
        if (th != null) {
            throw th;
        }
        throw new java.lang.Error("Unknown Exception");
    }

    private void reportException(int i) throws java.lang.Throwable {
        if (i == CANCELLED) {
            throw new java.util.concurrent.CancellationException();
        }
        if (i == Integer.MIN_VALUE) {
            rethrow(getThrowableException());
        }
    }

    public final java8.util.concurrent.ForkJoinTask<V> fork() throws java.lang.Throwable {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            ((java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).workQueue.push(this);
        } else {
            java8.util.concurrent.ForkJoinPool.common.externalPush(this);
        }
        return this;
    }

    public final V join() throws java.lang.Throwable {
        int iDoJoin = doJoin() & (-268435456);
        if (iDoJoin != -268435456) {
            reportException(iDoJoin);
        }
        return getRawResult();
    }

    public final V invoke() throws java.lang.Throwable {
        int iDoInvoke = doInvoke() & (-268435456);
        if (iDoInvoke != -268435456) {
            reportException(iDoInvoke);
        }
        return getRawResult();
    }

    public static void invokeAll(java8.util.concurrent.ForkJoinTask<?> forkJoinTask, java8.util.concurrent.ForkJoinTask<?> forkJoinTask2) throws java.lang.Throwable {
        forkJoinTask2.fork();
        int iDoInvoke = forkJoinTask.doInvoke() & (-268435456);
        if (iDoInvoke != -268435456) {
            forkJoinTask.reportException(iDoInvoke);
        }
        int iDoJoin = forkJoinTask2.doJoin() & (-268435456);
        if (iDoJoin != -268435456) {
            forkJoinTask2.reportException(iDoJoin);
        }
    }

    public static void invokeAll(java8.util.concurrent.ForkJoinTask<?>... forkJoinTaskArr) throws java.lang.Throwable {
        int length = forkJoinTaskArr.length - 1;
        java.lang.Throwable exception = null;
        for (int i = length; i >= 0; i--) {
            java8.util.concurrent.ForkJoinTask<?> forkJoinTask = forkJoinTaskArr[i];
            if (forkJoinTask == null) {
                if (exception == null) {
                    exception = new java.lang.NullPointerException();
                }
            } else if (i != 0) {
                forkJoinTask.fork();
            } else if (forkJoinTask.doInvoke() < -268435456 && exception == null) {
                exception = forkJoinTask.getException();
            }
        }
        for (int i2 = 1; i2 <= length; i2++) {
            java8.util.concurrent.ForkJoinTask<?> forkJoinTask2 = forkJoinTaskArr[i2];
            if (forkJoinTask2 != null) {
                if (exception != null) {
                    forkJoinTask2.cancel(false);
                } else if (forkJoinTask2.doJoin() < -268435456) {
                    exception = forkJoinTask2.getException();
                }
            }
        }
        if (exception != null) {
            rethrow(exception);
        }
    }

    public static <T extends java8.util.concurrent.ForkJoinTask<?>> java.util.Collection<T> invokeAll(java.util.Collection<T> collection) throws java.lang.Throwable {
        if (!(collection instanceof java.util.RandomAccess) || !(collection instanceof java.util.List)) {
            invokeAll((java8.util.concurrent.ForkJoinTask<?>[]) collection.toArray(new java8.util.concurrent.ForkJoinTask[0]));
            return collection;
        }
        java.util.List list = (java.util.List) collection;
        int size = list.size() - 1;
        java.lang.Throwable exception = null;
        for (int i = size; i >= 0; i--) {
            java8.util.concurrent.ForkJoinTask forkJoinTask = (java8.util.concurrent.ForkJoinTask) list.get(i);
            if (forkJoinTask == null) {
                if (exception == null) {
                    exception = new java.lang.NullPointerException();
                }
            } else if (i != 0) {
                forkJoinTask.fork();
            } else if (forkJoinTask.doInvoke() < -268435456 && exception == null) {
                exception = forkJoinTask.getException();
            }
        }
        for (int i2 = 1; i2 <= size; i2++) {
            java8.util.concurrent.ForkJoinTask forkJoinTask2 = (java8.util.concurrent.ForkJoinTask) list.get(i2);
            if (forkJoinTask2 != null) {
                if (exception != null) {
                    forkJoinTask2.cancel(false);
                } else if (forkJoinTask2.doJoin() < -268435456) {
                    exception = forkJoinTask2.getException();
                }
            }
        }
        if (exception != null) {
            rethrow(exception);
        }
        return collection;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return (setCompletion(CANCELLED) & (-268435456)) == CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.status < 0;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return (this.status & (-268435456)) == CANCELLED;
    }

    public final boolean isCompletedAbnormally() {
        return this.status < -268435456;
    }

    public final boolean isCompletedNormally() {
        return (this.status & (-268435456)) == -268435456;
    }

    public final java.lang.Throwable getException() {
        int i = this.status & (-268435456);
        if (i >= -268435456) {
            return null;
        }
        if (i == CANCELLED) {
            return new java.util.concurrent.CancellationException();
        }
        return getThrowableException();
    }

    public void completeExceptionally(java.lang.Throwable th) {
        if (!(th instanceof java.lang.RuntimeException) && !(th instanceof java.lang.Error)) {
            th = new java.lang.RuntimeException(th);
        }
        setExceptionalCompletion(th);
    }

    public void complete(V v) {
        try {
            setRawResult(v);
            setCompletion(-268435456);
        } catch (java.lang.Throwable th) {
            setExceptionalCompletion(th);
        }
    }

    public final void quietlyComplete() {
        setCompletion(-268435456);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        int iDoJoin = (java.lang.Thread.currentThread() instanceof java8.util.concurrent.ForkJoinWorkerThread ? doJoin() : externalInterruptibleAwaitDone()) & (-268435456);
        if (iDoJoin == CANCELLED) {
            throw new java.util.concurrent.CancellationException();
        }
        if (iDoJoin == Integer.MIN_VALUE) {
            throw new java.util.concurrent.ExecutionException(getThrowableException());
        }
        return getRawResult();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[LOOP:0: B:23:0x0052->B:66:0x0052, LOOP_START] */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get(long r11, java.util.concurrent.TimeUnit r13) throws java.lang.Throwable {
        /*
            r10 = this;
            long r11 = r13.toNanos(r11)
            boolean r13 = java.lang.Thread.interrupted()
            if (r13 != 0) goto Lb8
            int r13 = r10.status
            if (r13 < 0) goto L8b
            r0 = 0
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 <= 0) goto L8b
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 + r11
            int r11 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r11 != 0) goto L1f
            r2 = 1
        L1f:
            java.lang.Thread r11 = java.lang.Thread.currentThread()
            boolean r12 = r11 instanceof java8.util.concurrent.ForkJoinWorkerThread
            if (r12 == 0) goto L32
            java8.util.concurrent.ForkJoinWorkerThread r11 = (java8.util.concurrent.ForkJoinWorkerThread) r11
            java8.util.concurrent.ForkJoinPool r12 = r11.pool
            java8.util.concurrent.ForkJoinPool$WorkQueue r11 = r11.workQueue
            int r13 = r12.awaitJoin(r11, r10, r2)
            goto L8b
        L32:
            boolean r11 = r10 instanceof java8.util.concurrent.CountedCompleter
            r12 = 0
            if (r11 == 0) goto L42
            java8.util.concurrent.ForkJoinPool r11 = java8.util.concurrent.ForkJoinPool.common
            r13 = r10
            java8.util.concurrent.CountedCompleter r13 = (java8.util.concurrent.CountedCompleter) r13
            int r11 = r11.externalHelpComplete(r13, r12)
        L40:
            r13 = r11
            goto L50
        L42:
            java8.util.concurrent.ForkJoinPool r11 = java8.util.concurrent.ForkJoinPool.common
            boolean r11 = r11.tryExternalUnpush(r10)
            if (r11 == 0) goto L4f
            int r11 = r10.doExec()
            goto L40
        L4f:
            r13 = r12
        L50:
            if (r13 < 0) goto L8b
        L52:
            int r8 = r10.status
            if (r8 < 0) goto L8a
            long r11 = java.lang.System.nanoTime()
            long r11 = r2 - r11
            int r13 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r13 <= 0) goto L8a
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r11 = r13.toMillis(r11)
            int r13 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r13 <= 0) goto L52
            sun.misc.Unsafe r4 = java8.util.concurrent.ForkJoinTask.U
            long r6 = java8.util.concurrent.ForkJoinTask.STATUS
            r13 = 65536(0x10000, float:9.18355E-41)
            r9 = r8 | r13
            r5 = r10
            boolean r13 = r4.compareAndSwapInt(r5, r6, r8, r9)
            if (r13 == 0) goto L52
            monitor-enter(r10)
            int r13 = r10.status     // Catch: java.lang.Throwable -> L87
            if (r13 < 0) goto L82
            r10.wait(r11)     // Catch: java.lang.Throwable -> L87
            goto L85
        L82:
            r10.notifyAll()     // Catch: java.lang.Throwable -> L87
        L85:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L87
            goto L52
        L87:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L87
            throw r11
        L8a:
            r13 = r8
        L8b:
            if (r13 < 0) goto L8f
            int r13 = r10.status
        L8f:
            r11 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r12 = r13 & r11
            if (r12 == r11) goto Lb3
            r11 = -1073741824(0xffffffffc0000000, float:-2.0)
            if (r12 == r11) goto Lad
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r11) goto La3
            java.util.concurrent.TimeoutException r11 = new java.util.concurrent.TimeoutException
            r11.<init>()
            throw r11
        La3:
            java.util.concurrent.ExecutionException r11 = new java.util.concurrent.ExecutionException
            java.lang.Throwable r12 = r10.getThrowableException()
            r11.<init>(r12)
            throw r11
        Lad:
            java.util.concurrent.CancellationException r11 = new java.util.concurrent.CancellationException
            r11.<init>()
            throw r11
        Lb3:
            java.lang.Object r11 = r10.getRawResult()
            return r11
        Lb8:
            java.lang.InterruptedException r11 = new java.lang.InterruptedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinTask.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public final void quietlyJoin() {
        doJoin();
    }

    public final void quietlyInvoke() {
        doInvoke();
    }

    public static void helpQuiesce() {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = (java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread;
            forkJoinWorkerThread.pool.helpQuiescePool(forkJoinWorkerThread.workQueue);
        } else {
            java8.util.concurrent.ForkJoinPool.quiesceCommonPool();
        }
    }

    public void reinitialize() {
        if ((this.status & (-268435456)) == Integer.MIN_VALUE) {
            clearExceptionalCompletion();
        } else {
            this.status = 0;
        }
    }

    public static java8.util.concurrent.ForkJoinPool getPool() {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            return ((java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).pool;
        }
        return null;
    }

    public static boolean inForkJoinPool() {
        return java.lang.Thread.currentThread() instanceof java8.util.concurrent.ForkJoinWorkerThread;
    }

    public boolean tryUnfork() {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            return ((java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).workQueue.tryUnpush(this);
        }
        return java8.util.concurrent.ForkJoinPool.common.tryExternalUnpush(this);
    }

    public static int getQueuedTaskCount() {
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueueCommonSubmitterQueue;
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            workQueueCommonSubmitterQueue = ((java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).workQueue;
        } else {
            workQueueCommonSubmitterQueue = java8.util.concurrent.ForkJoinPool.commonSubmitterQueue();
        }
        if (workQueueCommonSubmitterQueue == null) {
            return 0;
        }
        return workQueueCommonSubmitterQueue.queueSize();
    }

    public static int getSurplusQueuedTaskCount() {
        return java8.util.concurrent.ForkJoinPool.getSurplusQueuedTaskCount();
    }

    protected static java8.util.concurrent.ForkJoinTask<?> peekNextLocalTask() {
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueueCommonSubmitterQueue;
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            workQueueCommonSubmitterQueue = ((java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).workQueue;
        } else {
            workQueueCommonSubmitterQueue = java8.util.concurrent.ForkJoinPool.commonSubmitterQueue();
        }
        if (workQueueCommonSubmitterQueue == null) {
            return null;
        }
        return workQueueCommonSubmitterQueue.peek();
    }

    protected static java8.util.concurrent.ForkJoinTask<?> pollNextLocalTask() {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            return ((java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).workQueue.nextLocalTask();
        }
        return null;
    }

    protected static java8.util.concurrent.ForkJoinTask<?> pollTask() {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (!(threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread)) {
            return null;
        }
        java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = (java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread;
        return forkJoinWorkerThread.pool.nextTaskFor(forkJoinWorkerThread.workQueue);
    }

    protected static java8.util.concurrent.ForkJoinTask<?> pollSubmission() {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            return ((java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).pool.pollSubmission();
        }
        return null;
    }

    public final short getForkJoinTaskTag() {
        return (short) this.status;
    }

    public final short setForkJoinTaskTag(short s) {
        sun.misc.Unsafe unsafe;
        long j;
        int i;
        do {
            unsafe = U;
            j = STATUS;
            i = this.status;
        } while (!unsafe.compareAndSwapInt(this, j, i, ((-65536) & i) | (SMASK & s)));
        return (short) i;
    }

    public final boolean compareAndSetForkJoinTaskTag(short s, short s2) {
        int i;
        do {
            i = this.status;
            if (((short) i) != s) {
                return false;
            }
        } while (!U.compareAndSwapInt(this, STATUS, i, (SMASK & s2) | ((-65536) & i)));
        return true;
    }

    static final class AdaptedRunnable<T> extends java8.util.concurrent.ForkJoinTask<T> implements java.util.concurrent.RunnableFuture<T> {
        private static final long serialVersionUID = 5232453952276885070L;
        T result;
        final java.lang.Runnable runnable;

        AdaptedRunnable(java.lang.Runnable runnable, T t) {
            this.runnable = (java.lang.Runnable) java8.util.Objects.requireNonNull(runnable);
            this.result = t;
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public java.lang.String toString() {
            return super.toString() + "[Wrapped task = " + this.runnable + "]";
        }
    }

    static final class AdaptedRunnableAction extends java8.util.concurrent.ForkJoinTask<java.lang.Void> implements java.util.concurrent.RunnableFuture<java.lang.Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final java.lang.Runnable runnable;

        @Override // java8.util.concurrent.ForkJoinTask
        public final java.lang.Void getRawResult() {
            return null;
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final void setRawResult(java.lang.Void r1) {
        }

        AdaptedRunnableAction(java.lang.Runnable runnable) {
            this.runnable = (java.lang.Runnable) java8.util.Objects.requireNonNull(runnable);
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public java.lang.String toString() {
            return super.toString() + "[Wrapped task = " + this.runnable + "]";
        }
    }

    static final class RunnableExecuteAction extends java8.util.concurrent.ForkJoinTask<java.lang.Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final java.lang.Runnable runnable;

        @Override // java8.util.concurrent.ForkJoinTask
        public final java.lang.Void getRawResult() {
            return null;
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final void setRawResult(java.lang.Void r1) {
        }

        RunnableExecuteAction(java.lang.Runnable runnable) {
            this.runnable = (java.lang.Runnable) java8.util.Objects.requireNonNull(runnable);
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java8.util.concurrent.ForkJoinTask
        void internalPropagateException(java.lang.Throwable th) {
            rethrow(th);
        }
    }

    static final class AdaptedCallable<T> extends java8.util.concurrent.ForkJoinTask<T> implements java.util.concurrent.RunnableFuture<T> {
        private static final long serialVersionUID = 2838392045355241008L;
        final java.util.concurrent.Callable<? extends T> callable;
        T result;

        AdaptedCallable(java.util.concurrent.Callable<? extends T> callable) {
            this.callable = (java.util.concurrent.Callable) java8.util.Objects.requireNonNull(callable);
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }

        @Override // java8.util.concurrent.ForkJoinTask
        public final boolean exec() {
            try {
                this.result = this.callable.call();
                return true;
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception e2) {
                throw new java.lang.RuntimeException(e2);
            }
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public java.lang.String toString() {
            return super.toString() + "[Wrapped task = " + this.callable + "]";
        }
    }

    public static java8.util.concurrent.ForkJoinTask<?> adapt(java.lang.Runnable runnable) {
        return new java8.util.concurrent.ForkJoinTask.AdaptedRunnableAction(runnable);
    }

    public static <T> java8.util.concurrent.ForkJoinTask<T> adapt(java.lang.Runnable runnable, T t) {
        return new java8.util.concurrent.ForkJoinTask.AdaptedRunnable(runnable, t);
    }

    public static <T> java8.util.concurrent.ForkJoinTask<T> adapt(java.util.concurrent.Callable<? extends T> callable) {
        return new java8.util.concurrent.ForkJoinTask.AdaptedCallable(callable);
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getException());
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.lang.ClassNotFoundException, java.io.IOException {
        objectInputStream.defaultReadObject();
        java.lang.Object object = objectInputStream.readObject();
        if (object != null) {
            setExceptionalCompletion((java.lang.Throwable) object);
        }
    }
}
