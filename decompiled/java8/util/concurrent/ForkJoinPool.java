package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ForkJoinPool extends java.util.concurrent.AbstractExecutorService {
    private static final int ABASE;
    private static final java.lang.Class<?> ACTCLASS;
    private static final long ADD_WORKER = 140737488355328L;
    private static final int ASHIFT;
    private static final int COMMON_MAX_SPARES;
    static final int COMMON_PARALLELISM;
    private static final long CTL;
    private static final int DEFAULT_COMMON_MAX_SPARES = 256;
    private static final long DEFAULT_KEEPALIVE = 60000;
    static final int DORMANT = -1073741824;
    static final int FIFO = 65536;
    static final int MAX_CAP = 32767;
    private static final long MODE;
    static final int OWNED = 1;
    static final int POLL_LIMIT = 1024;
    static final int QLOCK = 1;
    static final int QUIET = 1073741824;
    private static final long RC_MASK = -281474976710656L;
    private static final int RC_SHIFT = 48;
    private static final long RC_UNIT = 281474976710656L;
    private static final int SEED_INCREMENT = -1640531527;
    static final int SHUTDOWN = 262144;
    static final int SMASK = 65535;
    private static final long SP_MASK = 4294967295L;
    static final int SQMASK = 126;
    static final int SS_SEQ = 65536;
    static final int STOP = Integer.MIN_VALUE;
    static final int SWIDTH = 16;
    private static final long TC_MASK = 281470681743360L;
    private static final int TC_SHIFT = 32;
    private static final long TC_UNIT = 4294967296L;
    static final int TERMINATED = 524288;
    private static final long TIMEOUT_SLOP = 20;
    private static final sun.misc.Unsafe U;
    private static final long UC_MASK = -4294967296L;
    static final int UNSIGNALLED = Integer.MIN_VALUE;
    static final java8.util.concurrent.ForkJoinPool common;
    public static final java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory;
    static final java.lang.RuntimePermission modifyThreadPermission;
    private static int poolNumberSequence;
    final int bounds;
    volatile long ctl;
    final java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory factory;
    int indexSeed;
    final long keepAlive;
    volatile int mode;
    volatile long pad00;
    volatile long pad01;
    volatile long pad02;
    volatile long pad03;
    volatile long pad04;
    volatile long pad05;
    volatile long pad06;
    volatile long pad07;
    volatile long pad08;
    volatile long pad09;
    volatile long pad0a;
    volatile long pad0b;
    volatile long pad0c;
    volatile long pad0d;
    volatile long pad0e;
    volatile long pad0f;
    volatile long pad10;
    volatile long pad11;
    volatile long pad12;
    volatile long pad13;
    volatile long pad14;
    volatile long pad15;
    volatile long pad16;
    volatile long pad17;
    volatile long pad18;
    volatile long pad19;
    volatile long pad1a;
    volatile long pad1b;
    volatile long pad1c;
    volatile long pad1d;
    volatile long pad1e;
    final java8.util.function.Predicate<? super java8.util.concurrent.ForkJoinPool> saturate;
    volatile long stealCount;
    final java.lang.Thread.UncaughtExceptionHandler ueh;
    java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueues;
    final java.lang.String workerNamePrefix;

    public interface ForkJoinWorkerThreadFactory {
        java8.util.concurrent.ForkJoinWorkerThread newThread(java8.util.concurrent.ForkJoinPool forkJoinPool);
    }

    public interface ManagedBlocker {
        boolean block() throws java.lang.InterruptedException;

        boolean isReleasable();
    }

    private static void checkPermission() {
        java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(modifyThreadPermission);
        }
    }

    static java.security.AccessControlContext contextWithPermissions(java.security.Permission... permissionArr) {
        java.security.Permissions permissions = new java.security.Permissions();
        for (java.security.Permission permission : permissionArr) {
            permissions.add(permission);
        }
        return new java.security.AccessControlContext(new java.security.ProtectionDomain[]{new java.security.ProtectionDomain(null, permissions)});
    }

    private static final class DefaultForkJoinWorkerThreadFactory implements java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory {
        private static final java.security.AccessControlContext ACC = java8.util.concurrent.ForkJoinPool.contextWithPermissions(new java.lang.RuntimePermission("getClassLoader"));

        private DefaultForkJoinWorkerThreadFactory() {
        }

        @Override // java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory
        public final java8.util.concurrent.ForkJoinWorkerThread newThread(final java8.util.concurrent.ForkJoinPool forkJoinPool) {
            return (java8.util.concurrent.ForkJoinWorkerThread) java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java8.util.concurrent.ForkJoinWorkerThread>() { // from class: java8.util.concurrent.ForkJoinPool.DefaultForkJoinWorkerThreadFactory.1
                @Override // java.security.PrivilegedAction
                public java8.util.concurrent.ForkJoinWorkerThread run() {
                    return new java8.util.concurrent.ForkJoinWorkerThread(forkJoinPool, java.lang.ClassLoader.getSystemClassLoader());
                }
            }, ACC);
        }
    }

    static final class WorkQueue {
        private static final int ABASE;
        private static final int ASHIFT;
        static final int INITIAL_QUEUE_CAPACITY = 8192;
        static final int MAXIMUM_QUEUE_CAPACITY = 67108864;
        private static final long PHASE;
        private static final sun.misc.Unsafe U;
        java8.util.concurrent.ForkJoinTask<?>[] array;
        int id;
        int nsteals;
        final java8.util.concurrent.ForkJoinWorkerThread owner;
        volatile long pad00;
        volatile long pad01;
        volatile long pad02;
        volatile long pad03;
        volatile long pad04;
        volatile long pad05;
        volatile long pad06;
        volatile long pad07;
        volatile long pad08;
        volatile long pad09;
        volatile long pad0a;
        volatile long pad0b;
        volatile long pad0c;
        volatile long pad0d;
        volatile long pad0e;
        volatile long pad0f;
        volatile java.lang.Object pad10;
        volatile java.lang.Object pad11;
        volatile java.lang.Object pad12;
        volatile java.lang.Object pad13;
        volatile java.lang.Object pad14;
        volatile java.lang.Object pad15;
        volatile java.lang.Object pad16;
        volatile java.lang.Object pad17;
        volatile java.lang.Object pad18;
        volatile java.lang.Object pad19;
        volatile java.lang.Object pad1a;
        volatile java.lang.Object pad1b;
        volatile java.lang.Object pad1c;
        volatile java.lang.Object pad1d;
        volatile java.lang.Object pad1e;
        volatile java.lang.Object pad1f;
        volatile int phase;
        final java8.util.concurrent.ForkJoinPool pool;
        volatile int source;
        int stackPred;
        int top = 4096;
        volatile int base = 4096;

        WorkQueue(java8.util.concurrent.ForkJoinPool forkJoinPool, java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread) {
            this.pool = forkJoinPool;
            this.owner = forkJoinWorkerThread;
        }

        final int getPoolIndex() {
            return (this.id & java8.util.concurrent.ForkJoinPool.SMASK) >>> 1;
        }

        final int queueSize() {
            int i = this.base - this.top;
            if (i >= 0) {
                return 0;
            }
            return -i;
        }

        final boolean isEmpty() {
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr;
            int length;
            int i = this.base;
            int i2 = i - this.top;
            if (i2 < 0) {
                return i2 == -1 && ((forkJoinTaskArr = this.array) == null || (length = forkJoinTaskArr.length) == 0 || forkJoinTaskArr[i & (length - 1)] == null);
            }
            return true;
        }

        final void push(java8.util.concurrent.ForkJoinTask<?> forkJoinTask) throws java.lang.Throwable {
            int length;
            int i = this.top;
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || (length = forkJoinTaskArr.length) <= 0) {
                return;
            }
            long j = (((long) ((length - 1) & i)) << ASHIFT) + ((long) ABASE);
            java8.util.concurrent.ForkJoinPool forkJoinPool = this.pool;
            this.top = i + 1;
            U.putOrderedObject(forkJoinTaskArr, j, forkJoinTask);
            int i2 = this.base - i;
            if (i2 == 0 && forkJoinPool != null) {
                java8.util.concurrent.ForkJoinPool.MemBar.fullFence();
                forkJoinPool.signalWork();
            } else if (i2 + length == 1) {
                growArray();
            }
        }

        final java8.util.concurrent.ForkJoinTask<?>[] growArray() {
            int i;
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            int length = forkJoinTaskArr != null ? forkJoinTaskArr.length : 0;
            int i2 = length > 0 ? length << 1 : 8192;
            if (i2 < 8192 || i2 > MAXIMUM_QUEUE_CAPACITY) {
                throw new java.util.concurrent.RejectedExecutionException("Queue capacity exceeded");
            }
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr2 = new java8.util.concurrent.ForkJoinTask[i2];
            this.array = forkJoinTaskArr2;
            if (forkJoinTaskArr != null && length - 1 > 0) {
                int i3 = this.top;
                int i4 = this.base;
                if (i3 - i4 > 0) {
                    int i5 = i2 - 1;
                    int i6 = i4;
                    do {
                        long j = ((long) ABASE) + (((long) (i6 & i)) << ASHIFT);
                        sun.misc.Unsafe unsafe = U;
                        java8.util.concurrent.ForkJoinTask<?> forkJoinTask = (java8.util.concurrent.ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j);
                        if (forkJoinTask != null && com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(unsafe, forkJoinTaskArr, j, forkJoinTask, (java.lang.Object) null)) {
                            forkJoinTaskArr2[i6 & i5] = forkJoinTask;
                        }
                        i6++;
                    } while (i6 != i3);
                    java8.util.concurrent.ForkJoinPool.MemBar.storeFence();
                }
            }
            return forkJoinTaskArr2;
        }

        final java8.util.concurrent.ForkJoinTask<?> pop() {
            int length;
            int i = this.base;
            int i2 = this.top;
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || i == i2 || (length = forkJoinTaskArr.length) <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            long j = (((long) ((length - 1) & i3)) << ASHIFT) + ((long) ABASE);
            sun.misc.Unsafe unsafe = U;
            java8.util.concurrent.ForkJoinTask<?> forkJoinTask = (java8.util.concurrent.ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j);
            if (forkJoinTask == null || !com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(unsafe, forkJoinTaskArr, j, forkJoinTask, (java.lang.Object) null)) {
                return null;
            }
            this.top = i3;
            java8.util.concurrent.ForkJoinPool.MemBar.storeFence();
            return forkJoinTask;
        }

        final java8.util.concurrent.ForkJoinTask<?> poll() {
            int i;
            int length;
            while (true) {
                int i2 = this.base;
                int i3 = this.top;
                java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
                if (forkJoinTaskArr == null || (i = i2 - i3) >= 0 || (length = forkJoinTaskArr.length) <= 0) {
                    return null;
                }
                long j = (((long) ((length - 1) & i2)) << ASHIFT) + ((long) ABASE);
                sun.misc.Unsafe unsafe = U;
                java8.util.concurrent.ForkJoinTask<?> forkJoinTask = (java8.util.concurrent.ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j);
                int i4 = i2 + 1;
                if (i2 == this.base) {
                    if (forkJoinTask != null) {
                        if (com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(unsafe, forkJoinTaskArr, j, forkJoinTask, (java.lang.Object) null)) {
                            this.base = i4;
                            return forkJoinTask;
                        }
                    } else if (i == -1) {
                        return null;
                    }
                }
            }
        }

        final java8.util.concurrent.ForkJoinTask<?> nextLocalTask() {
            return (this.id & 65536) != 0 ? poll() : pop();
        }

        final java8.util.concurrent.ForkJoinTask<?> peek() {
            int length;
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || (length = forkJoinTaskArr.length) <= 0) {
                return null;
            }
            return forkJoinTaskArr[(length - 1) & ((this.id & 65536) != 0 ? this.base : this.top - 1)];
        }

        final boolean tryUnpush(java8.util.concurrent.ForkJoinTask<?> forkJoinTask) {
            int length;
            int i = this.base;
            int i2 = this.top;
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || i == i2 || (length = forkJoinTaskArr.length) <= 0) {
                return false;
            }
            int i3 = i2 - 1;
            if (!com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(U, forkJoinTaskArr, (((long) ((length - 1) & i3)) << ASHIFT) + ((long) ABASE), forkJoinTask, (java.lang.Object) null)) {
                return false;
            }
            this.top = i3;
            java8.util.concurrent.ForkJoinPool.MemBar.storeFence();
            return true;
        }

        final void cancelAll() {
            while (true) {
                java8.util.concurrent.ForkJoinTask<?> forkJoinTaskPoll = poll();
                if (forkJoinTaskPoll == null) {
                    return;
                } else {
                    java8.util.concurrent.ForkJoinTask.cancelIgnoringExceptions(forkJoinTaskPoll);
                }
            }
        }

        final void localPopAndExec(int i) {
            int length;
            while (true) {
                int i2 = this.base;
                int i3 = this.top;
                java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
                if (forkJoinTaskArr == null || i2 == i3 || (length = forkJoinTaskArr.length) <= 0) {
                    return;
                }
                int i4 = i3 - 1;
                java8.util.concurrent.ForkJoinTask forkJoinTask = (java8.util.concurrent.ForkJoinTask) java8.util.concurrent.ForkJoinPool.getAndSetObject(forkJoinTaskArr, (((long) ((length - 1) & i4)) << ASHIFT) + ((long) ABASE), null);
                if (forkJoinTask == null) {
                    return;
                }
                this.top = i4;
                java8.util.concurrent.ForkJoinPool.MemBar.storeFence();
                forkJoinTask.doExec();
                if (i != 0 && i - 1 == 0) {
                    return;
                }
            }
        }

        final void localPollAndExec(int i) {
            int i2;
            int length;
            do {
                int i3 = 0;
                while (true) {
                    int i4 = this.base;
                    int i5 = this.top;
                    java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
                    if (forkJoinTaskArr != null && (i2 = i4 - i5) < 0 && (length = forkJoinTaskArr.length) > 0) {
                        int i6 = i4 + 1;
                        java8.util.concurrent.ForkJoinTask forkJoinTask = (java8.util.concurrent.ForkJoinTask) java8.util.concurrent.ForkJoinPool.getAndSetObject(forkJoinTaskArr, (((long) (i4 & (length - 1))) << ASHIFT) + ((long) ABASE), null);
                        if (forkJoinTask == null) {
                            break;
                        }
                        this.base = i6;
                        forkJoinTask.doExec();
                        if (i != 0 && (i3 = i3 + 1) == i) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (i2 != -1);
        }

        final void tryRemoveAndExec(java8.util.concurrent.ForkJoinTask<?> forkJoinTask) {
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr;
            int length;
            int i = this.base;
            int i2 = this.top;
            if (i - i2 >= 0 || (forkJoinTaskArr = this.array) == null || (length = forkJoinTaskArr.length) <= 0) {
                return;
            }
            int i3 = length - 1;
            int i4 = i2 - 1;
            int i5 = i4;
            while (true) {
                long j = ((i5 & i3) << ASHIFT) + ABASE;
                sun.misc.Unsafe unsafe = U;
                java8.util.concurrent.ForkJoinTask<?> forkJoinTask2 = (java8.util.concurrent.ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j);
                if (forkJoinTask2 == null) {
                    return;
                }
                if (forkJoinTask2 == forkJoinTask) {
                    if (com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(unsafe, forkJoinTaskArr, j, forkJoinTask2, (java.lang.Object) null)) {
                        this.top = i4;
                        while (i5 != i4) {
                            int i6 = i5 + 1;
                            int i7 = ASHIFT;
                            long j2 = ((i6 & i3) << i7) + ABASE;
                            sun.misc.Unsafe unsafe2 = U;
                            java8.util.concurrent.ForkJoinTask forkJoinTask3 = (java8.util.concurrent.ForkJoinTask) unsafe2.getObject(forkJoinTaskArr, j2);
                            unsafe2.putObjectVolatile(forkJoinTaskArr, j2, (java.lang.Object) null);
                            unsafe2.putOrderedObject(forkJoinTaskArr, ((i5 & i3) << i7) + r4, forkJoinTask3);
                            i5 = i6;
                        }
                        java8.util.concurrent.ForkJoinPool.MemBar.storeFence();
                        forkJoinTask2.doExec();
                        return;
                    }
                    return;
                }
                i5--;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x004b A[EDGE_INSN: B:38:0x004b->B:21:0x004b BREAK  A[LOOP:1: B:14:0x0030->B:40:?]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int localHelpCC(java8.util.concurrent.CountedCompleter<?> r10, int r11) {
            /*
                r9 = this;
                r0 = 0
                if (r10 == 0) goto L5b
                int r1 = r10.status
                if (r1 < 0) goto L5a
            L7:
                int r1 = r9.base
                int r2 = r9.top
                java8.util.concurrent.ForkJoinTask<?>[] r4 = r9.array
                if (r4 == 0) goto L4b
                if (r1 == r2) goto L4b
                int r1 = r4.length
                if (r1 <= 0) goto L4b
                int r1 = r1 + (-1)
                int r2 = r2 + (-1)
                r1 = r1 & r2
                long r5 = (long) r1
                int r1 = java8.util.concurrent.ForkJoinPool.WorkQueue.ASHIFT
                long r5 = r5 << r1
                int r1 = java8.util.concurrent.ForkJoinPool.WorkQueue.ABASE
                long r7 = (long) r1
                long r5 = r5 + r7
                sun.misc.Unsafe r1 = java8.util.concurrent.ForkJoinPool.WorkQueue.U
                java.lang.Object r1 = r1.getObject(r4, r5)
                java8.util.concurrent.ForkJoinTask r1 = (java8.util.concurrent.ForkJoinTask) r1
                boolean r3 = r1 instanceof java8.util.concurrent.CountedCompleter
                if (r3 == 0) goto L4b
                java8.util.concurrent.CountedCompleter r1 = (java8.util.concurrent.CountedCompleter) r1
                r3 = r1
            L30:
                if (r3 == r10) goto L37
                java8.util.concurrent.CountedCompleter<?> r3 = r3.completer
                if (r3 != 0) goto L30
                goto L4b
            L37:
                sun.misc.Unsafe r3 = java8.util.concurrent.ForkJoinPool.WorkQueue.U
                r8 = 0
                r7 = r1
                boolean r3 = com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(r3, r4, r5, r7, r8)
                if (r3 == 0) goto L4b
                r9.top = r2
                java8.util.concurrent.ForkJoinPool.MemBar.storeFence()
                r1.doExec()
                r1 = 1
                goto L4c
            L4b:
                r1 = r0
            L4c:
                int r2 = r10.status
                if (r2 < 0) goto L58
                if (r1 == 0) goto L58
                if (r11 == 0) goto L7
                int r11 = r11 + (-1)
                if (r11 != 0) goto L7
            L58:
                r0 = r2
                goto L5b
            L5a:
                r0 = r1
            L5b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinPool.WorkQueue.localHelpCC(java8.util.concurrent.CountedCompleter, int):int");
        }

        final boolean tryLockSharedQueue() {
            return U.compareAndSwapInt(this, PHASE, 0, 1);
        }

        final boolean trySharedUnpush(java8.util.concurrent.ForkJoinTask<?> forkJoinTask) {
            int length;
            int i = this.top;
            int i2 = i - 1;
            java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || (length = forkJoinTaskArr.length) <= 0) {
                return false;
            }
            boolean z = true;
            long j = (((long) ((length - 1) & i2)) << ASHIFT) + ((long) ABASE);
            sun.misc.Unsafe unsafe = U;
            if (((java8.util.concurrent.ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j)) != forkJoinTask) {
                return false;
            }
            long j2 = PHASE;
            if (!unsafe.compareAndSwapInt(this, j2, 0, 1)) {
                return false;
            }
            if (this.top == i && this.array == forkJoinTaskArr && com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(unsafe, forkJoinTaskArr, j, forkJoinTask, (java.lang.Object) null)) {
                this.top = i2;
            } else {
                z = false;
            }
            unsafe.putOrderedInt(this, j2, 0);
            return z;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007e A[EDGE_INSN: B:49:0x007e->B:33:0x007e BREAK  A[LOOP:1: B:15:0x003a->B:51:?]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int sharedHelpCC(java8.util.concurrent.CountedCompleter<?> r22, int r23) {
            /*
                r21 = this;
                r6 = r21
                r7 = r22
                r8 = 0
                if (r7 == 0) goto L8c
                int r0 = r7.status
                if (r0 < 0) goto L8b
                r9 = r23
            Ld:
                int r0 = r6.base
                int r10 = r6.top
                java8.util.concurrent.ForkJoinTask<?>[] r12 = r6.array
                if (r12 == 0) goto L7e
                if (r0 == r10) goto L7e
                int r0 = r12.length
                if (r0 <= 0) goto L7e
                int r0 = r0 + (-1)
                int r15 = r10 + (-1)
                r0 = r0 & r15
                long r0 = (long) r0
                int r2 = java8.util.concurrent.ForkJoinPool.WorkQueue.ASHIFT
                long r0 = r0 << r2
                int r2 = java8.util.concurrent.ForkJoinPool.WorkQueue.ABASE
                long r2 = (long) r2
                long r13 = r0 + r2
                sun.misc.Unsafe r0 = java8.util.concurrent.ForkJoinPool.WorkQueue.U
                java.lang.Object r0 = r0.getObject(r12, r13)
                java8.util.concurrent.ForkJoinTask r0 = (java8.util.concurrent.ForkJoinTask) r0
                boolean r1 = r0 instanceof java8.util.concurrent.CountedCompleter
                if (r1 == 0) goto L7e
                r17 = r0
                java8.util.concurrent.CountedCompleter r17 = (java8.util.concurrent.CountedCompleter) r17
                r0 = r17
            L3a:
                if (r0 == r7) goto L41
                java8.util.concurrent.CountedCompleter<?> r0 = r0.completer
                if (r0 != 0) goto L3a
                goto L7e
            L41:
                sun.misc.Unsafe r11 = java8.util.concurrent.ForkJoinPool.WorkQueue.U
                long r4 = java8.util.concurrent.ForkJoinPool.WorkQueue.PHASE
                r16 = 0
                r18 = 1
                r0 = r11
                r1 = r21
                r2 = r4
                r19 = r4
                r4 = r16
                r5 = r18
                boolean r0 = r0.compareAndSwapInt(r1, r2, r4, r5)
                if (r0 == 0) goto L7e
                int r0 = r6.top
                if (r0 != r10) goto L71
                java8.util.concurrent.ForkJoinTask<?>[] r0 = r6.array
                if (r0 != r12) goto L71
                r16 = 0
                r0 = r11
                r10 = r15
                r15 = r17
                boolean r1 = com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(r11, r12, r13, r15, r16)
                if (r1 == 0) goto L72
                r6.top = r10
                r1 = 1
                goto L73
            L71:
                r0 = r11
            L72:
                r1 = r8
            L73:
                r2 = r19
                r0.putOrderedInt(r6, r2, r8)
                if (r1 == 0) goto L7f
                r17.doExec()
                goto L7f
            L7e:
                r1 = r8
            L7f:
                int r0 = r7.status
                if (r0 < 0) goto L8b
                if (r1 == 0) goto L8b
                if (r9 == 0) goto Ld
                int r9 = r9 + (-1)
                if (r9 != 0) goto Ld
            L8b:
                r8 = r0
            L8c:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinPool.WorkQueue.sharedHelpCC(java8.util.concurrent.CountedCompleter, int):int");
        }

        final boolean isApparentlyUnblocked() {
            java.lang.Thread.State state;
            java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = this.owner;
            return (forkJoinWorkerThread == null || (state = forkJoinWorkerThread.getState()) == java.lang.Thread.State.BLOCKED || state == java.lang.Thread.State.WAITING || state == java.lang.Thread.State.TIMED_WAITING) ? false : true;
        }

        static {
            sun.misc.Unsafe unsafe = java8.util.concurrent.UnsafeAccess.unsafe;
            U = unsafe;
            try {
                PHASE = unsafe.objectFieldOffset(java8.util.concurrent.ForkJoinPool.WorkQueue.class.getDeclaredField("phase"));
                ABASE = unsafe.arrayBaseOffset(java8.util.concurrent.ForkJoinTask[].class);
                int iArrayIndexScale = unsafe.arrayIndexScale(java8.util.concurrent.ForkJoinTask[].class);
                if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                    throw new java.lang.ExceptionInInitializerError("array index scale not a power of two");
                }
                ASHIFT = 31 - java.lang.Integer.numberOfLeadingZeros(iArrayIndexScale);
            } catch (java.lang.Exception e) {
                throw new java.lang.ExceptionInInitializerError(e);
            }
        }
    }

    private static final synchronized int nextPoolId() {
        int i;
        i = poolNumberSequence + 1;
        poolNumberSequence = i;
        return i;
    }

    static long getAndAddLong(java.lang.Object obj, long j, long j2) {
        sun.misc.Unsafe unsafe;
        long longVolatile;
        do {
            unsafe = U;
            longVolatile = unsafe.getLongVolatile(obj, j);
        } while (!unsafe.compareAndSwapLong(obj, j, longVolatile, longVolatile + j2));
        return longVolatile;
    }

    static java.lang.Object getAndSetObject(java.lang.Object obj, long j, java.lang.Object obj2) {
        sun.misc.Unsafe unsafe;
        java.lang.Object objectVolatile;
        do {
            unsafe = U;
            objectVolatile = unsafe.getObjectVolatile(obj, j);
        } while (!com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(unsafe, obj, j, objectVolatile, obj2));
        return objectVolatile;
    }

    private boolean createWorker() throws java.lang.Throwable {
        java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThreadNewThread;
        java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
        java.lang.Throwable th = null;
        if (forkJoinWorkerThreadFactory != null) {
            try {
                forkJoinWorkerThreadNewThread = forkJoinWorkerThreadFactory.newThread(this);
                if (forkJoinWorkerThreadNewThread != null) {
                    try {
                        forkJoinWorkerThreadNewThread.start();
                        return true;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                forkJoinWorkerThreadNewThread = null;
            }
        } else {
            forkJoinWorkerThreadNewThread = null;
        }
        deregisterWorker(forkJoinWorkerThreadNewThread, th);
        return false;
    }

    private void tryAddWorker(long j) throws java.lang.Throwable {
        long j2 = j;
        do {
            long j3 = ((RC_UNIT + j2) & RC_MASK) | ((TC_UNIT + j2) & TC_MASK);
            if (this.ctl == j2 && U.compareAndSwapLong(this, CTL, j2, j3)) {
                createWorker();
                return;
            } else {
                j2 = this.ctl;
                if ((ADD_WORKER & j2) == 0) {
                    return;
                }
            }
        } while (((int) j2) == 0);
    }

    final java8.util.concurrent.ForkJoinPool.WorkQueue registerWorker(java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread) {
        int i;
        int length;
        forkJoinWorkerThread.setDaemon(true);
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.ueh;
        if (uncaughtExceptionHandler != null) {
            forkJoinWorkerThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = new java8.util.concurrent.ForkJoinPool.WorkQueue(this, forkJoinWorkerThread);
        int i2 = this.mode & 65536;
        java.lang.String str = this.workerNamePrefix;
        if (str != null) {
            synchronized (str) {
                java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
                int i3 = this.indexSeed + SEED_INCREMENT;
                this.indexSeed = i3;
                i = 0;
                if (workQueueArr != null && (length = workQueueArr.length) > 1) {
                    int i4 = length - 1;
                    int i5 = i3 & i4;
                    int i6 = ((i3 << 1) | 1) & i4;
                    int i7 = length >>> 1;
                    while (true) {
                        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue2 = workQueueArr[i6];
                        if (workQueue2 == null || workQueue2.phase == 1073741824) {
                            break;
                        }
                        i7--;
                        if (i7 == 0) {
                            i6 = length | 1;
                            break;
                        }
                        i6 = (i6 + 2) & i4;
                    }
                    int i8 = i2 | i6 | (i3 & 1073610752);
                    workQueue.id = i8;
                    workQueue.phase = i8;
                    if (i6 < length) {
                        workQueueArr[i6] = workQueue;
                    } else {
                        int i9 = length << 1;
                        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr2 = new java8.util.concurrent.ForkJoinPool.WorkQueue[i9];
                        workQueueArr2[i6] = workQueue;
                        int i10 = i9 - 1;
                        while (i < length) {
                            java8.util.concurrent.ForkJoinPool.WorkQueue workQueue3 = workQueueArr[i];
                            if (workQueue3 != null) {
                                workQueueArr2[workQueue3.id & i10 & 126] = workQueue3;
                            }
                            int i11 = i + 1;
                            if (i11 >= length) {
                                break;
                            }
                            workQueueArr2[i11] = workQueueArr[i11];
                            i += 2;
                        }
                        this.workQueues = workQueueArr2;
                    }
                    i = i5;
                }
            }
            forkJoinWorkerThread.setName(str.concat(java.lang.Integer.toString(i)));
        }
        return workQueue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0040 A[LOOP:0: B:27:0x0040->B:44:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void deregisterWorker(java8.util.concurrent.ForkJoinWorkerThread r18, java.lang.Throwable r19) throws java.lang.Throwable {
        /*
            r17 = this;
            r9 = r17
            r0 = r18
            r10 = 4294967295(0xffffffff, double:2.1219957905E-314)
            r1 = 0
            r12 = 0
            if (r0 == 0) goto L3a
            java8.util.concurrent.ForkJoinPool$WorkQueue r0 = r0.workQueue
            if (r0 == 0) goto L3b
            java.lang.String r2 = r9.workerNamePrefix
            int r3 = r0.nsteals
            long r3 = (long) r3
            long r3 = r3 & r10
            int r5 = r0.id
            r6 = 65535(0xffff, float:9.1834E-41)
            r5 = r5 & r6
            if (r2 == 0) goto L37
            monitor-enter(r2)
            java8.util.concurrent.ForkJoinPool$WorkQueue[] r6 = r9.workQueues     // Catch: java.lang.Throwable -> L34
            if (r6 == 0) goto L2d
            int r7 = r6.length     // Catch: java.lang.Throwable -> L34
            if (r7 <= r5) goto L2d
            r7 = r6[r5]     // Catch: java.lang.Throwable -> L34
            if (r7 != r0) goto L2d
            r6[r5] = r1     // Catch: java.lang.Throwable -> L34
        L2d:
            long r5 = r9.stealCount     // Catch: java.lang.Throwable -> L34
            long r5 = r5 + r3
            r9.stealCount = r5     // Catch: java.lang.Throwable -> L34
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L34
            goto L37
        L34:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L34
            throw r0
        L37:
            int r1 = r0.phase
            goto L3c
        L3a:
            r0 = r1
        L3b:
            r1 = r12
        L3c:
            r2 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L66
        L40:
            sun.misc.Unsafe r1 = java8.util.concurrent.ForkJoinPool.U
            long r3 = java8.util.concurrent.ForkJoinPool.CTL
            long r5 = r9.ctl
            r7 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
            long r7 = r5 - r7
            r13 = -281474976710656(0xffff000000000000, double:NaN)
            long r7 = r7 & r13
            r13 = 4294967296(0x100000000, double:2.121995791E-314)
            long r13 = r5 - r13
            r15 = 281470681743360(0xffff00000000, double:1.39064994160909E-309)
            long r13 = r13 & r15
            long r7 = r7 | r13
            long r13 = r5 & r10
            long r7 = r7 | r13
            r2 = r17
            boolean r1 = r1.compareAndSwapLong(r2, r3, r5, r7)
            if (r1 == 0) goto L40
        L66:
            if (r0 == 0) goto L6b
            r0.cancelAll()
        L6b:
            boolean r1 = r9.tryTerminate(r12, r12)
            if (r1 != 0) goto L7a
            if (r0 == 0) goto L7a
            java8.util.concurrent.ForkJoinTask<?>[] r0 = r0.array
            if (r0 == 0) goto L7a
            r17.signalWork()
        L7a:
            if (r19 != 0) goto L80
            java8.util.concurrent.ForkJoinTask.helpExpungeStaleExceptions()
            goto L83
        L80:
            java8.util.concurrent.ForkJoinTask.rethrow(r19)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinPool.deregisterWorker(java8.util.concurrent.ForkJoinWorkerThread, java.lang.Throwable):void");
    }

    final void signalWork() throws java.lang.Throwable {
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue;
        while (true) {
            long j = this.ctl;
            if (j >= 0) {
                return;
            }
            int i = (int) j;
            if (i == 0) {
                if ((ADD_WORKER & j) != 0) {
                    tryAddWorker(j);
                    return;
                }
                return;
            }
            java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr == null) {
                return;
            }
            int length = workQueueArr.length;
            int i2 = SMASK & i;
            if (length <= i2 || (workQueue = workQueueArr[i2]) == null) {
                return;
            }
            int i3 = i & Integer.MAX_VALUE;
            int i4 = workQueue.phase;
            long j2 = (((long) workQueue.stackPred) & SP_MASK) | ((RC_UNIT + j) & UC_MASK);
            java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = workQueue.owner;
            if (i == i4 && U.compareAndSwapLong(this, CTL, j, j2)) {
                workQueue.phase = i3;
                if (workQueue.source < 0) {
                    java.util.concurrent.locks.LockSupport.unpark(forkJoinWorkerThread);
                    return;
                }
                return;
            }
        }
    }

    private int tryCompensate(java8.util.concurrent.ForkJoinPool.WorkQueue workQueue) throws java.lang.Throwable {
        int length;
        java.lang.Thread.State state;
        long j = this.ctl;
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        short s = (short) (j >>> 32);
        if (s >= 0) {
            if (workQueueArr == null || (length = workQueueArr.length) <= 0 || workQueue == null) {
                return 0;
            }
            int i = (int) j;
            if (i != 0) {
                java8.util.concurrent.ForkJoinPool.WorkQueue workQueue2 = workQueueArr[i & (length - 1)];
                int i2 = workQueue.phase;
                long j2 = UC_MASK & (i2 < 0 ? RC_UNIT + j : j);
                int i3 = i & Integer.MAX_VALUE;
                if (workQueue2 == null) {
                    return 0;
                }
                int i4 = workQueue2.phase;
                java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = workQueue2.owner;
                long j3 = (((long) workQueue2.stackPred) & SP_MASK) | j2;
                if (i4 != i || !U.compareAndSwapLong(this, CTL, j, j3)) {
                    return 0;
                }
                workQueue2.phase = i3;
                if (workQueue2.source < 0) {
                    java.util.concurrent.locks.LockSupport.unpark(forkJoinWorkerThread);
                }
                return i2 < 0 ? -1 : 1;
            }
            if (((int) (j >> 48)) - ((short) (this.bounds & SMASK)) > 0) {
                return U.compareAndSwapLong(this, CTL, j, (RC_MASK & (j - RC_UNIT)) | (281474976710655L & j)) ? 1 : 0;
            }
            int i5 = this.mode & SMASK;
            int i6 = i5 + s;
            int i7 = i6;
            int i8 = 0;
            for (int i9 = 1; i9 < length; i9 += 2) {
                java8.util.concurrent.ForkJoinPool.WorkQueue workQueue3 = workQueueArr[i9];
                if (workQueue3 != null) {
                    if (workQueue3.source == 0) {
                        return 0;
                    }
                    i7--;
                    java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread2 = workQueue3.owner;
                    if (forkJoinWorkerThread2 != null && ((state = forkJoinWorkerThread2.getState()) == java.lang.Thread.State.BLOCKED || state == java.lang.Thread.State.WAITING)) {
                        i8++;
                    }
                }
            }
            if (i7 != 0 || this.ctl != j) {
                return 0;
            }
            if (i6 >= MAX_CAP || s >= (this.bounds >>> 16)) {
                java8.util.function.Predicate<? super java8.util.concurrent.ForkJoinPool> predicate = this.saturate;
                if (predicate != null && predicate.test(this)) {
                    return -1;
                }
                if (i8 < i5) {
                    java.lang.Thread.yield();
                    return 0;
                }
                throw new java.util.concurrent.RejectedExecutionException("Thread limit exceeded replacing blocked worker");
            }
        }
        return (U.compareAndSwapLong(this, CTL, j, ((TC_UNIT + j) & TC_MASK) | ((-281470681743361L) & j)) && createWorker()) ? 1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c2, code lost:
    
        r10 = r24.phase;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ce, code lost:
    
        if (r10 < 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d0, code lost:
    
        r15 = (r10 + 65536) | com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
        r24.phase = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d9, code lost:
    
        r4 = r23.ctl;
        r24.stackPred = (int) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f1, code lost:
    
        if (java8.util.concurrent.ForkJoinPool.U.compareAndSwapLong(r23, java8.util.concurrent.ForkJoinPool.CTL, r4, ((r4 - java8.util.concurrent.ForkJoinPool.RC_UNIT) & java8.util.concurrent.ForkJoinPool.UC_MASK) | (((long) r15) & java8.util.concurrent.ForkJoinPool.SP_MASK)) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
    
        r15 = r24.stackPred;
        r24.source = java8.util.concurrent.ForkJoinPool.DORMANT;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fd, code lost:
    
        if (r24.phase < 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ff, code lost:
    
        r24.source = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0106, code lost:
    
        r0 = r23.mode;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0108, code lost:
    
        if (r0 >= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010b, code lost:
    
        r1 = java8.util.concurrent.ForkJoinPool.SMASK & r0;
        r4 = r23.ctl;
        r1 = r1 + ((int) (r4 >> 48));
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0117, code lost:
    
        if (r1 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x011c, code lost:
    
        if ((r0 & java8.util.concurrent.ForkJoinPool.SHUTDOWN) == 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011e, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0123, code lost:
    
        if (tryTerminate(false, false) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0125, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0126, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0127, code lost:
    
        r17 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x012d, code lost:
    
        if ((r17 & 1) != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x012f, code lost:
    
        java.lang.Thread.interrupted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0135, code lost:
    
        if (r1 > 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0137, code lost:
    
        if (r15 == 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x013a, code lost:
    
        if (r10 != ((int) r4)) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x013c, code lost:
    
        r0 = r23.keepAlive + java.lang.System.currentTimeMillis();
        java.util.concurrent.locks.LockSupport.parkUntil(r23, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x014a, code lost:
    
        if (r23.ctl != r4) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0155, code lost:
    
        if ((r0 - java.lang.System.currentTimeMillis()) > 20) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0171, code lost:
    
        if (java8.util.concurrent.ForkJoinPool.U.compareAndSwapLong(r23, java8.util.concurrent.ForkJoinPool.CTL, r4, ((r4 - java8.util.concurrent.ForkJoinPool.TC_UNIT) & java8.util.concurrent.ForkJoinPool.UC_MASK) | (((long) r15) & java8.util.concurrent.ForkJoinPool.SP_MASK)) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0173, code lost:
    
        r24.phase = 1073741824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0177, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0178, code lost:
    
        java.util.concurrent.locks.LockSupport.park(r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x017d, code lost:
    
        r2 = r17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void runWorker(java8.util.concurrent.ForkJoinPool.WorkQueue r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinPool.runWorker(java8.util.concurrent.ForkJoinPool$WorkQueue):void");
    }

    final int awaitJoin(java8.util.concurrent.ForkJoinPool.WorkQueue workQueue, java8.util.concurrent.ForkJoinTask<?> forkJoinTask, long j) throws java.lang.Throwable {
        long millis;
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue2;
        java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr;
        int length;
        int iLocalHelpCC;
        if (workQueue == null || forkJoinTask == null) {
            return 0;
        }
        if ((forkJoinTask instanceof java8.util.concurrent.CountedCompleter) && (iLocalHelpCC = workQueue.localHelpCC((java8.util.concurrent.CountedCompleter) forkJoinTask, 0)) < 0) {
            return iLocalHelpCC;
        }
        workQueue.tryRemoveAndExec(forkJoinTask);
        int i = workQueue.source;
        int i2 = workQueue.id;
        int i3 = forkJoinTask.status;
        while (i3 >= 0) {
            boolean z = true;
            int iNextSecondarySeed = java8.util.concurrent.TLRandom.nextSecondarySeed() | 1;
            java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null) {
                int length2 = workQueueArr.length;
                int i4 = length2 - 1;
                for (int i5 = -length2; i5 < length2; i5 += 2) {
                    int i6 = (iNextSecondarySeed + i5) & i4;
                    if (i6 >= 0 && i6 < length2 && (workQueue2 = workQueueArr[i6]) != null && workQueue2.source == i2) {
                        int i7 = workQueue2.base;
                        if (i7 - workQueue2.top < 0 && (forkJoinTaskArr = workQueue2.array) != null && (length = forkJoinTaskArr.length) > 0) {
                            int i8 = workQueue2.id;
                            long j2 = (((long) ((length - 1) & i7)) << ASHIFT) + ((long) ABASE);
                            sun.misc.Unsafe unsafe = U;
                            java8.util.concurrent.ForkJoinTask forkJoinTask2 = (java8.util.concurrent.ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j2);
                            if (forkJoinTask2 != null) {
                                int i9 = i7 + 1;
                                if (i7 == workQueue2.base && i2 == workQueue2.source && com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(unsafe, forkJoinTaskArr, j2, forkJoinTask2, (java.lang.Object) null)) {
                                    workQueue2.base = i9;
                                    workQueue.source = i8;
                                    forkJoinTask2.doExec();
                                    workQueue.source = i;
                                }
                            }
                        }
                    }
                }
                z = false;
            } else {
                z = false;
            }
            int i10 = forkJoinTask.status;
            if (i10 < 0) {
                return i10;
            }
            if (!z) {
                if (j == 0) {
                    millis = 0;
                } else {
                    long jNanoTime = j - java.lang.System.nanoTime();
                    if (jNanoTime <= 0) {
                        return i10;
                    }
                    millis = java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(jNanoTime);
                    if (millis <= 0) {
                        millis = 1;
                    }
                }
                int iTryCompensate = tryCompensate(workQueue);
                if (iTryCompensate != 0) {
                    forkJoinTask.internalWait(millis);
                    getAndAddLong(this, CTL, iTryCompensate > 0 ? RC_UNIT : 0L);
                }
                i10 = forkJoinTask.status;
            }
            i3 = i10;
        }
        return i3;
    }

    final void helpQuiescePool(java8.util.concurrent.ForkJoinPool.WorkQueue workQueue) {
        boolean z;
        boolean z2;
        int i;
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue2;
        java8.util.concurrent.ForkJoinTask<?>[] forkJoinTaskArr;
        int length;
        int i2 = workQueue.source;
        int i3 = workQueue.id & 65536;
        byte b = -1;
        int i4 = i2;
        byte b2 = -1;
        while (true) {
            if (i3 != 0) {
                workQueue.localPollAndExec(0);
            } else {
                workQueue.localPopAndExec(0);
            }
            if (b2 == b && workQueue.phase >= 0) {
                b2 = 1;
            }
            int iNextSecondarySeed = java8.util.concurrent.TLRandom.nextSecondarySeed();
            java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
            long j = RC_UNIT;
            if (workQueueArr != null) {
                int length2 = workQueueArr.length;
                int i5 = length2 - 1;
                int i6 = length2;
                z2 = true;
                while (true) {
                    if (i6 <= 0) {
                        z = true;
                        break;
                    }
                    int i7 = (iNextSecondarySeed - i6) & i5;
                    if (i7 >= 0 && i7 < length2 && (workQueue2 = workQueueArr[i7]) != null) {
                        int i8 = workQueue2.base;
                        if (i8 - workQueue2.top < 0 && (forkJoinTaskArr = workQueue2.array) != null && (length = forkJoinTaskArr.length) > 0) {
                            int i9 = workQueue2.id;
                            if (b2 == 0) {
                                getAndAddLong(this, CTL, j);
                                b2 = 1;
                            }
                            long j2 = (((long) ((length - 1) & i8)) << ASHIFT) + ((long) ABASE);
                            sun.misc.Unsafe unsafe = U;
                            java8.util.concurrent.ForkJoinTask forkJoinTask = (java8.util.concurrent.ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j2);
                            if (forkJoinTask != null) {
                                int i10 = i8 + 1;
                                if (i8 == workQueue2.base && com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(unsafe, forkJoinTaskArr, j2, forkJoinTask, (java.lang.Object) null)) {
                                    workQueue2.base = i10;
                                    workQueue.source = workQueue2.id;
                                    forkJoinTask.doExec();
                                    workQueue.source = i2;
                                    i4 = i2;
                                }
                            }
                            z = false;
                            z2 = false;
                        } else if ((workQueue2.source & 1073741824) == 0) {
                            z2 = false;
                        }
                    }
                    i6--;
                    j = RC_UNIT;
                }
            } else {
                z = true;
                z2 = true;
            }
            if (z2) {
                break;
            }
            if (z) {
                if (i4 != 1073741824) {
                    workQueue.source = 1073741824;
                    i = 1073741824;
                } else {
                    i = i4;
                }
                if (b2 == 1) {
                    getAndAddLong(this, CTL, RC_MASK);
                    i4 = i;
                    b2 = 0;
                } else {
                    i4 = i;
                }
            }
            b = -1;
        }
        if (b2 == 0) {
            getAndAddLong(this, CTL, RC_UNIT);
        }
        workQueue.source = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r14 = (((long) ((r11 - 1) & r10)) << java8.util.concurrent.ForkJoinPool.ASHIFT) + ((long) java8.util.concurrent.ForkJoinPool.ABASE);
        r12 = java8.util.concurrent.ForkJoinPool.U;
        r1 = (java8.util.concurrent.ForkJoinTask) r12.getObjectVolatile(r13, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        if (r1 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        r2 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        if (r10 != r9.base) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(r12, r13, r14, r1, (java.lang.Object) null) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        r9.base = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0002, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java8.util.concurrent.ForkJoinTask<?> pollScan(boolean r19) {
        /*
            r18 = this;
            r0 = r18
        L2:
            int r1 = r0.mode
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 != 0) goto L71
            java8.util.concurrent.ForkJoinPool$WorkQueue[] r1 = r0.workQueues
            if (r1 == 0) goto L71
            int r2 = r1.length
            if (r2 <= 0) goto L71
            int r2 = r2 + (-1)
            int r3 = java8.util.concurrent.TLRandom.nextSecondarySeed()
            int r4 = r3 >>> 16
            if (r19 == 0) goto L22
            r3 = r3 & (-2)
            r3 = r3 & r2
            r4 = r4 & (-2)
            r4 = r4 | 2
            goto L25
        L22:
            r3 = r3 & r2
            r4 = r4 | 1
        L25:
            r5 = 0
            r6 = r3
            r7 = r5
            r8 = r7
        L29:
            r9 = r1[r6]
            if (r9 == 0) goto L67
            int r10 = r9.base
            int r7 = r7 + r10
            int r11 = r9.top
            int r11 = r10 - r11
            if (r11 >= 0) goto L67
            java8.util.concurrent.ForkJoinTask<?>[] r13 = r9.array
            if (r13 == 0) goto L67
            int r11 = r13.length
            if (r11 <= 0) goto L67
            int r11 = r11 + (-1)
            r1 = r11 & r10
            long r1 = (long) r1
            int r3 = java8.util.concurrent.ForkJoinPool.ASHIFT
            long r1 = r1 << r3
            int r3 = java8.util.concurrent.ForkJoinPool.ABASE
            long r3 = (long) r3
            long r14 = r1 + r3
            sun.misc.Unsafe r12 = java8.util.concurrent.ForkJoinPool.U
            java.lang.Object r1 = r12.getObjectVolatile(r13, r14)
            java8.util.concurrent.ForkJoinTask r1 = (java8.util.concurrent.ForkJoinTask) r1
            if (r1 == 0) goto L2
            int r2 = r10 + 1
            int r3 = r9.base
            if (r10 != r3) goto L2
            r17 = 0
            r16 = r1
            boolean r3 = com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(r12, r13, r14, r16, r17)
            if (r3 == 0) goto L2
            r9.base = r2
            return r1
        L67:
            int r6 = r6 + r4
            r6 = r6 & r2
            if (r6 != r3) goto L29
            if (r8 != r7) goto L6e
            goto L71
        L6e:
            r8 = r7
            r7 = r5
            goto L29
        L71:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinPool.pollScan(boolean):java8.util.concurrent.ForkJoinTask");
    }

    final java8.util.concurrent.ForkJoinTask<?> nextTaskFor(java8.util.concurrent.ForkJoinPool.WorkQueue workQueue) {
        if (workQueue != null) {
            java8.util.concurrent.ForkJoinTask<?> forkJoinTaskPoll = (workQueue.id & 65536) != 0 ? workQueue.poll() : workQueue.pop();
            if (forkJoinTaskPoll != null) {
                return forkJoinTaskPoll;
            }
        }
        return pollScan(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bc, code lost:
    
        throw new java.util.concurrent.RejectedExecutionException();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void externalPush(java8.util.concurrent.ForkJoinTask<?> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            int r0 = java8.util.concurrent.TLRandom.getProbe()
            if (r0 != 0) goto Ld
            java8.util.concurrent.TLRandom.localInit()
            int r0 = java8.util.concurrent.TLRandom.getProbe()
        Ld:
            int r1 = r9.mode
            java8.util.concurrent.ForkJoinPool$WorkQueue[] r2 = r9.workQueues
            r3 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r3
            if (r1 != 0) goto Lb7
            if (r2 == 0) goto Lb7
            int r1 = r2.length
            if (r1 <= 0) goto Lb7
            int r1 = r1 + (-1)
            r1 = r1 & r0
            r1 = r1 & 126(0x7e, float:1.77E-43)
            r1 = r2[r1]
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L5e
            java.lang.String r1 = r9.workerNamePrefix
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = r0 | r4
            r6 = -65538(0xfffffffffffefffe, float:NaN)
            r5 = r5 & r6
            java8.util.concurrent.ForkJoinPool$WorkQueue r6 = new java8.util.concurrent.ForkJoinPool$WorkQueue
            r7 = 0
            r6.<init>(r9, r7)
            r6.id = r5
            r6.source = r4
            r6.phase = r3
            if (r1 == 0) goto L5a
            monitor-enter(r1)
            java8.util.concurrent.ForkJoinPool$WorkQueue[] r4 = r9.workQueues     // Catch: java.lang.Throwable -> L57
            if (r4 == 0) goto L53
            int r7 = r4.length     // Catch: java.lang.Throwable -> L57
            if (r7 <= 0) goto L53
            int r7 = r7 + (-1)
            r5 = r5 & r7
            r5 = r5 & 126(0x7e, float:1.77E-43)
            r7 = r4[r5]     // Catch: java.lang.Throwable -> L57
            if (r7 != 0) goto L53
            r4[r5] = r6     // Catch: java.lang.Throwable -> L57
            r4 = r3
            goto L54
        L53:
            r4 = r2
        L54:
            r5 = r4
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L57
            goto L5c
        L57:
            r10 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L57
            throw r10
        L5a:
            r4 = r2
            r5 = r4
        L5c:
            r1 = r6
            goto L8f
        L5e:
            boolean r4 = r1.tryLockSharedQueue()
            if (r4 == 0) goto L8d
            int r4 = r1.base
            int r5 = r1.top
            java8.util.concurrent.ForkJoinTask<?>[] r6 = r1.array
            if (r6 == 0) goto L8a
            int r7 = r6.length
            if (r7 <= 0) goto L8a
            int r7 = r7 + (-1)
            int r4 = r4 - r5
            int r8 = r7 + r4
            if (r8 <= 0) goto L8a
            r7 = r7 & r5
            r6[r7] = r10
            int r6 = r5 + 1
            r1.top = r6
            r1.phase = r2
            if (r4 >= 0) goto L88
            int r4 = r1.base
            int r4 = r4 - r5
            r5 = -1
            if (r4 >= r5) goto L88
            goto Lb0
        L88:
            r5 = r2
            goto L8b
        L8a:
            r5 = r3
        L8b:
            r4 = r3
            goto L8f
        L8d:
            r4 = r2
            r5 = r4
        L8f:
            if (r4 == 0) goto Lb1
            if (r5 == 0) goto Lad
            r1.growArray()     // Catch: java.lang.Throwable -> La9
            int r0 = r1.top     // Catch: java.lang.Throwable -> La9
            java8.util.concurrent.ForkJoinTask<?>[] r4 = r1.array     // Catch: java.lang.Throwable -> La9
            if (r4 == 0) goto La6
            int r5 = r4.length     // Catch: java.lang.Throwable -> La9
            if (r5 <= 0) goto La6
            int r5 = r5 - r3
            r5 = r5 & r0
            r4[r5] = r10     // Catch: java.lang.Throwable -> La9
            int r0 = r0 + r3
            r1.top = r0     // Catch: java.lang.Throwable -> La9
        La6:
            r1.phase = r2
            goto Lad
        La9:
            r10 = move-exception
            r1.phase = r2
            throw r10
        Lad:
            r9.signalWork()
        Lb0:
            return
        Lb1:
            int r0 = java8.util.concurrent.TLRandom.advanceProbe(r0)
            goto Ld
        Lb7:
            java.util.concurrent.RejectedExecutionException r10 = new java.util.concurrent.RejectedExecutionException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinPool.externalPush(java8.util.concurrent.ForkJoinTask):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <T> java8.util.concurrent.ForkJoinTask<T> externalSubmit(java8.util.concurrent.ForkJoinTask<T> r3) throws java.lang.Throwable {
        /*
            r2 = this;
            java8.util.Objects.requireNonNull(r3)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof java8.util.concurrent.ForkJoinWorkerThread
            if (r1 == 0) goto L19
            java8.util.concurrent.ForkJoinWorkerThread r0 = (java8.util.concurrent.ForkJoinWorkerThread) r0
            java8.util.concurrent.ForkJoinPool r1 = r0.pool
            if (r1 != r2) goto L19
            java8.util.concurrent.ForkJoinPool$WorkQueue r0 = r0.workQueue
            if (r0 == 0) goto L19
            r0.push(r3)
            goto L1c
        L19:
            r2.externalPush(r3)
        L1c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinPool.externalSubmit(java8.util.concurrent.ForkJoinTask):java8.util.concurrent.ForkJoinTask");
    }

    static java8.util.concurrent.ForkJoinPool.WorkQueue commonSubmitterQueue() {
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr;
        int length;
        java8.util.concurrent.ForkJoinPool forkJoinPool = common;
        int probe = java8.util.concurrent.TLRandom.getProbe();
        if (forkJoinPool == null || (workQueueArr = forkJoinPool.workQueues) == null || (length = workQueueArr.length) <= 0) {
            return null;
        }
        return workQueueArr[probe & (length - 1) & 126];
    }

    final boolean tryExternalUnpush(java8.util.concurrent.ForkJoinTask<?> forkJoinTask) {
        int length;
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue;
        int probe = java8.util.concurrent.TLRandom.getProbe();
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        return workQueueArr != null && (length = workQueueArr.length) > 0 && (workQueue = workQueueArr[(probe & (length - 1)) & 126]) != null && workQueue.trySharedUnpush(forkJoinTask);
    }

    final int externalHelpComplete(java8.util.concurrent.CountedCompleter<?> countedCompleter, int i) {
        int length;
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue;
        int probe = java8.util.concurrent.TLRandom.getProbe();
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null || (length = workQueueArr.length) <= 0 || (workQueue = workQueueArr[probe & (length - 1) & 126]) == null) {
            return 0;
        }
        return workQueue.sharedHelpCC(countedCompleter, i);
    }

    final int helpComplete(java8.util.concurrent.ForkJoinPool.WorkQueue workQueue, java8.util.concurrent.CountedCompleter<?> countedCompleter, int i) {
        if (workQueue == null) {
            return 0;
        }
        return workQueue.localHelpCC(countedCompleter, i);
    }

    static int getSurplusQueuedTaskCount() {
        java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread;
        java8.util.concurrent.ForkJoinPool forkJoinPool;
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue;
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        int i = 0;
        if (!(threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) || (forkJoinPool = (forkJoinWorkerThread = (java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).pool) == null || (workQueue = forkJoinWorkerThread.workQueue) == null) {
            return 0;
        }
        int i2 = forkJoinPool.mode & SMASK;
        int i3 = ((int) (forkJoinPool.ctl >> 48)) + i2;
        int i4 = workQueue.top - workQueue.base;
        if (i3 <= (i2 >>> 1)) {
            if (i3 > (i2 >>> 2)) {
                i = 1;
            } else if (i3 > (i2 >>> 3)) {
                i = 2;
            } else {
                i = 4;
                if (i3 <= (i2 >>> 4)) {
                    i = 8;
                }
            }
        }
        return i4 - i;
    }

    private boolean tryTerminate(boolean z, boolean z2) {
        int i;
        int i2;
        while (true) {
            int i3 = this.mode;
            int i4 = 0;
            if ((i3 & SHUTDOWN) != 0) {
                while (true) {
                    int i5 = this.mode;
                    int i6 = i5 & com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
                    int i7 = SMASK;
                    long j = 0;
                    int i8 = 1;
                    if (i6 != 0) {
                        while ((this.mode & TERMINATED) == 0) {
                            long j2 = 0;
                            while (true) {
                                long j3 = this.ctl;
                                java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
                                if (workQueueArr != null) {
                                    for (int i9 = i4; i9 < workQueueArr.length; i9++) {
                                        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = workQueueArr[i9];
                                        if (workQueue != null) {
                                            java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = workQueue.owner;
                                            workQueue.cancelAll();
                                            if (forkJoinWorkerThread != null) {
                                                try {
                                                    forkJoinWorkerThread.interrupt();
                                                } catch (java.lang.Throwable unused) {
                                                }
                                            }
                                            j3 += (((long) workQueue.phase) << 32) + ((long) workQueue.base);
                                        }
                                    }
                                }
                                i = this.mode;
                                i2 = i & TERMINATED;
                                if (i2 != 0) {
                                    break;
                                }
                                if (this.workQueues == workQueueArr) {
                                    if (j2 == j3) {
                                        break;
                                    }
                                    j2 = j3;
                                }
                                i4 = 0;
                            }
                            if (i2 != 0 || (i & SMASK) + ((short) (this.ctl >>> 32)) > 0) {
                                return true;
                            }
                            if (U.compareAndSwapInt(this, MODE, i, i | TERMINATED)) {
                                synchronized (this) {
                                    notifyAll();
                                }
                                return true;
                            }
                            i4 = 0;
                        }
                        return true;
                    }
                    if (!z) {
                        while (true) {
                            long j4 = this.ctl;
                            java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr2 = this.workQueues;
                            char c = '0';
                            if ((i5 & i7) + ((int) (j4 >> 48)) <= 0) {
                                if (workQueueArr2 != null) {
                                    int i10 = i4;
                                    while (i10 < workQueueArr2.length) {
                                        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue2 = workQueueArr2[i10];
                                        if (workQueue2 != null) {
                                            int i11 = workQueue2.source;
                                            int i12 = workQueue2.phase;
                                            int i13 = workQueue2.id;
                                            int i14 = workQueue2.base;
                                            if (i14 != workQueue2.top || ((i13 & 1) == i8 && (i11 >= 0 || i12 >= 0))) {
                                                i8 = 1;
                                                break;
                                            }
                                            j4 += (((long) i11) << c) + (((long) i12) << 32) + (((long) i14) << 16) + ((long) i13);
                                        }
                                        i10++;
                                        c = '0';
                                        i8 = 1;
                                    }
                                    i8 = 0;
                                } else {
                                    i8 = 0;
                                }
                            }
                            i5 = this.mode;
                            if ((i5 & com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER) != 0) {
                                i4 = 0;
                                break;
                            }
                            if (i8 != 0) {
                                return false;
                            }
                            i4 = 0;
                            if (this.workQueues == workQueueArr2) {
                                if (j == j4) {
                                    break;
                                }
                                j = j4;
                            }
                            i7 = SMASK;
                            i8 = 1;
                        }
                    }
                    int i15 = i5;
                    if ((i15 & com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER) == 0) {
                        U.compareAndSwapInt(this, MODE, i15, i15 | com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
                    }
                }
            } else {
                if (!z2 || this == common) {
                    break;
                }
                U.compareAndSwapInt(this, MODE, i3, i3 | SHUTDOWN);
            }
        }
        return false;
    }

    public ForkJoinPool() {
        this(java.lang.Math.min(MAX_CAP, java.lang.Runtime.getRuntime().availableProcessors()), defaultForkJoinWorkerThreadFactory, null, false, 0, MAX_CAP, 1, null, 60000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public ForkJoinPool(int i) {
        this(i, defaultForkJoinWorkerThreadFactory, null, false, 0, MAX_CAP, 1, null, 60000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public ForkJoinPool(int i, java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory, java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        this(i, forkJoinWorkerThreadFactory, uncaughtExceptionHandler, z, 0, MAX_CAP, 1, null, 60000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public ForkJoinPool(int i, java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory, java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z, int i2, int i3, int i4, java8.util.function.Predicate<? super java8.util.concurrent.ForkJoinPool> predicate, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (i <= 0 || i > MAX_CAP || i3 < i || j <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        java8.util.Objects.requireNonNull(forkJoinWorkerThreadFactory);
        long jMax = java.lang.Math.max(timeUnit.toMillis(j), 20L);
        long j2 = ((((long) (-java.lang.Math.min(java.lang.Math.max(i2, i), MAX_CAP))) << 32) & TC_MASK) | ((((long) (-i)) << 48) & RC_MASK);
        int i5 = (z ? 65536 : 0) | i;
        int iMin = ((java.lang.Math.min(i3, MAX_CAP) - i) << 16) | ((java.lang.Math.min(java.lang.Math.max(i4, 0), MAX_CAP) - i) & SMASK);
        int i6 = i > 1 ? i - 1 : 1;
        int i7 = i6 | (i6 >>> 1);
        int i8 = i7 | (i7 >>> 2);
        int i9 = i8 | (i8 >>> 4);
        int i10 = i9 | (i9 >>> 8);
        this.workerNamePrefix = "ForkJoinPool-" + nextPoolId() + "-worker-";
        this.workQueues = new java8.util.concurrent.ForkJoinPool.WorkQueue[((i10 | (i10 >>> 16)) + 1) << 1];
        this.factory = forkJoinWorkerThreadFactory;
        this.ueh = uncaughtExceptionHandler;
        this.saturate = predicate;
        this.keepAlive = jMax;
        this.bounds = iMin;
        this.mode = i5;
        this.ctl = j2;
        checkPermission();
    }

    private static java.lang.Object newInstanceFromSystemProperty(java.lang.String str) throws java.lang.Exception {
        java.lang.String property = java.lang.System.getProperty(str);
        if (property == null) {
            return null;
        }
        return java.lang.ClassLoader.getSystemClassLoader().loadClass(property).getConstructor(null).newInstance(null);
    }

    private ForkJoinPool(byte b) {
        java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory innocuousForkJoinWorkerThreadFactory;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            java.lang.String property = java.lang.System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
            iAvailableProcessors = property != null ? java.lang.Integer.parseInt(property) : -1;
            innocuousForkJoinWorkerThreadFactory = (java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory) newInstanceFromSystemProperty("java.util.concurrent.ForkJoinPool.common.threadFactory");
            try {
                uncaughtExceptionHandler = (java.lang.Thread.UncaughtExceptionHandler) newInstanceFromSystemProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler");
            } catch (java.lang.Exception unused) {
                uncaughtExceptionHandler = null;
            }
        } catch (java.lang.Exception unused2) {
            innocuousForkJoinWorkerThreadFactory = null;
        }
        if (innocuousForkJoinWorkerThreadFactory == null) {
            if (java.lang.System.getSecurityManager() == null) {
                innocuousForkJoinWorkerThreadFactory = defaultForkJoinWorkerThreadFactory;
            } else {
                innocuousForkJoinWorkerThreadFactory = new java8.util.concurrent.ForkJoinPool.InnocuousForkJoinWorkerThreadFactory();
            }
        }
        if (iAvailableProcessors < 0 && (iAvailableProcessors = java.lang.Runtime.getRuntime().availableProcessors() - 1) <= 0) {
            iAvailableProcessors = 1;
        }
        iAvailableProcessors = iAvailableProcessors > MAX_CAP ? MAX_CAP : iAvailableProcessors;
        long j = -iAvailableProcessors;
        long j2 = ((j << 48) & RC_MASK) | ((j << 32) & TC_MASK);
        int i = ((1 - iAvailableProcessors) & SMASK) | (COMMON_MAX_SPARES << 16);
        int i2 = iAvailableProcessors > 1 ? iAvailableProcessors - 1 : 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        this.workerNamePrefix = "ForkJoinPool.commonPool-worker-";
        this.workQueues = new java8.util.concurrent.ForkJoinPool.WorkQueue[((i6 | (i6 >>> 16)) + 1) << 1];
        this.factory = innocuousForkJoinWorkerThreadFactory;
        this.ueh = uncaughtExceptionHandler;
        this.saturate = null;
        this.keepAlive = 60000L;
        this.bounds = i;
        this.mode = iAvailableProcessors;
        this.ctl = j2;
    }

    public static java8.util.concurrent.ForkJoinPool commonPool() {
        return common;
    }

    public <T> T invoke(java8.util.concurrent.ForkJoinTask<T> forkJoinTask) throws java.lang.Throwable {
        externalSubmit((java8.util.concurrent.ForkJoinTask) java8.util.Objects.requireNonNull(forkJoinTask));
        return forkJoinTask.join();
    }

    public void execute(java8.util.concurrent.ForkJoinTask<?> forkJoinTask) throws java.lang.Throwable {
        externalSubmit(forkJoinTask);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) throws java.lang.Throwable {
        java8.util.concurrent.ForkJoinTask runnableExecuteAction;
        java8.util.Objects.requireNonNull(runnable);
        if (runnable instanceof java8.util.concurrent.ForkJoinTask) {
            runnableExecuteAction = (java8.util.concurrent.ForkJoinTask) runnable;
        } else {
            runnableExecuteAction = new java8.util.concurrent.ForkJoinTask.RunnableExecuteAction(runnable);
        }
        externalSubmit(runnableExecuteAction);
    }

    public <T> java8.util.concurrent.ForkJoinTask<T> submit(java8.util.concurrent.ForkJoinTask<T> forkJoinTask) {
        return externalSubmit(forkJoinTask);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> java8.util.concurrent.ForkJoinTask<T> submit(java.util.concurrent.Callable<T> callable) {
        return externalSubmit(new java8.util.concurrent.ForkJoinTask.AdaptedCallable(callable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> java8.util.concurrent.ForkJoinTask<T> submit(java.lang.Runnable runnable, T t) {
        return externalSubmit(new java8.util.concurrent.ForkJoinTask.AdaptedRunnable(runnable, t));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public java8.util.concurrent.ForkJoinTask<?> submit(java.lang.Runnable runnable) {
        java8.util.Objects.requireNonNull(runnable);
        return externalSubmit(runnable instanceof java8.util.concurrent.ForkJoinTask ? (java8.util.concurrent.ForkJoinTask) runnable : new java8.util.concurrent.ForkJoinTask.AdaptedRunnableAction(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) {
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        try {
            java.util.Iterator<? extends java.util.concurrent.Callable<T>> it = collection.iterator();
            while (it.hasNext()) {
                java8.util.concurrent.ForkJoinTask.AdaptedCallable adaptedCallable = new java8.util.concurrent.ForkJoinTask.AdaptedCallable(it.next());
                arrayList.add(adaptedCallable);
                externalSubmit(adaptedCallable);
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((java8.util.concurrent.ForkJoinTask) arrayList.get(i)).quietlyJoin();
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((java.util.concurrent.Future) arrayList.get(i2)).cancel(false);
            }
            throw th;
        }
    }

    public java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory getFactory() {
        return this.factory;
    }

    public java.lang.Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.ueh;
    }

    public int getParallelism() {
        int i = this.mode & SMASK;
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public static int getCommonPoolParallelism() {
        return COMMON_PARALLELISM;
    }

    public int getPoolSize() {
        return (this.mode & SMASK) + ((short) (this.ctl >>> 32));
    }

    public boolean getAsyncMode() {
        return (this.mode & 65536) != 0;
    }

    public int getRunningThreadCount() {
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        int i = 0;
        if (workQueueArr != null) {
            for (int i2 = 1; i2 < workQueueArr.length; i2 += 2) {
                java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = workQueueArr[i2];
                if (workQueue != null && workQueue.isApparentlyUnblocked()) {
                    i++;
                }
            }
        }
        return i;
    }

    public int getActiveThreadCount() {
        int i = (this.mode & SMASK) + ((int) (this.ctl >> 48));
        if (i <= 0) {
            return 0;
        }
        return i;
    }

    public boolean isQuiescent() {
        while (true) {
            long j = this.ctl;
            int i = this.mode;
            int i2 = SMASK & i;
            int i3 = ((short) (j >>> 32)) + i2;
            int i4 = i2 + ((int) (j >> 48));
            if ((i & (-2146959360)) != 0) {
                return true;
            }
            if (i4 > 0) {
                return false;
            }
            java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null) {
                for (int i5 = 1; i5 < workQueueArr.length; i5 += 2) {
                    java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = workQueueArr[i5];
                    if (workQueue != null) {
                        if ((workQueue.source & 1073741824) == 0) {
                            return false;
                        }
                        i3--;
                    }
                }
            }
            if (i3 == 0 && this.ctl == j) {
                return true;
            }
        }
    }

    public long getStealCount() {
        long j = this.stealCount;
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            for (int i = 1; i < workQueueArr.length; i += 2) {
                java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = workQueueArr[i];
                if (workQueue != null) {
                    j += ((long) workQueue.nsteals) & SP_MASK;
                }
            }
        }
        return j;
    }

    public long getQueuedTaskCount() {
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        long jQueueSize = 0;
        if (workQueueArr != null) {
            for (int i = 1; i < workQueueArr.length; i += 2) {
                java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = workQueueArr[i];
                if (workQueue != null) {
                    jQueueSize += (long) workQueue.queueSize();
                }
            }
        }
        return jQueueSize;
    }

    public int getQueuedSubmissionCount() {
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null) {
            return 0;
        }
        int iQueueSize = 0;
        for (int i = 0; i < workQueueArr.length; i += 2) {
            java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = workQueueArr[i];
            if (workQueue != null) {
                iQueueSize += workQueue.queueSize();
            }
        }
        return iQueueSize;
    }

    public boolean hasQueuedSubmissions() {
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            for (int i = 0; i < workQueueArr.length; i += 2) {
                java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = workQueueArr[i];
                if (workQueue != null && !workQueue.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    protected java8.util.concurrent.ForkJoinTask<?> pollSubmission() {
        return pollScan(true);
    }

    protected int drainTasksTo(java.util.Collection<? super java8.util.concurrent.ForkJoinTask<?>> collection) {
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null) {
            return 0;
        }
        int i = 0;
        for (java8.util.concurrent.ForkJoinPool.WorkQueue workQueue : workQueueArr) {
            if (workQueue != null) {
                while (true) {
                    java8.util.concurrent.ForkJoinTask<?> forkJoinTaskPoll = workQueue.poll();
                    if (forkJoinTaskPoll != null) {
                        collection.add(forkJoinTaskPoll);
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public java.lang.String toString() {
        int i;
        java.lang.String str;
        long j = this.stealCount;
        java8.util.concurrent.ForkJoinPool.WorkQueue[] workQueueArr = this.workQueues;
        long j2 = 0;
        long j3 = 0;
        if (workQueueArr != null) {
            i = 0;
            for (int i2 = 0; i2 < workQueueArr.length; i2++) {
                java8.util.concurrent.ForkJoinPool.WorkQueue workQueue = workQueueArr[i2];
                if (workQueue != null) {
                    int iQueueSize = workQueue.queueSize();
                    if ((i2 & 1) == 0) {
                        j3 += (long) iQueueSize;
                    } else {
                        j2 += (long) iQueueSize;
                        j += ((long) workQueue.nsteals) & SP_MASK;
                        if (workQueue.isApparentlyUnblocked()) {
                            i++;
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        int i3 = this.mode;
        int i4 = SMASK & i3;
        int i5 = ((short) (r10 >>> 32)) + i4;
        int i6 = ((int) (this.ctl >> 48)) + i4;
        int i7 = i6 >= 0 ? i6 : 0;
        if ((TERMINATED & i3) != 0) {
            str = "Terminated";
        } else {
            str = (Integer.MIN_VALUE & i3) != 0 ? "Terminating" : (i3 & SHUTDOWN) != 0 ? "Shutting down" : "Running";
        }
        return super.toString() + "[" + str + ", parallelism = " + i4 + ", size = " + i5 + ", active = " + i7 + ", running = " + i + ", steals = " + j + ", tasks = " + j2 + ", submissions = " + j3 + "]";
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        checkPermission();
        tryTerminate(false, true);
    }

    @Override // java.util.concurrent.ExecutorService
    public java.util.List<java.lang.Runnable> shutdownNow() {
        checkPermission();
        tryTerminate(true, true);
        return java.util.Collections.emptyList();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return (this.mode & TERMINATED) != 0;
    }

    public boolean isTerminating() {
        int i = this.mode;
        return (Integer.MIN_VALUE & i) != 0 && (i & TERMINATED) == 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return (this.mode & SHUTDOWN) != 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        if (this == common) {
            awaitQuiescence(j, timeUnit);
            return false;
        }
        long nanos = timeUnit.toNanos(j);
        if (isTerminated()) {
            return true;
        }
        if (nanos <= 0) {
            return false;
        }
        long jNanoTime = java.lang.System.nanoTime() + nanos;
        synchronized (this) {
            while (!isTerminated()) {
                if (nanos <= 0) {
                    return false;
                }
                long millis = java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(nanos);
                if (millis <= 0) {
                    millis = 1;
                }
                wait(millis);
                nanos = jNanoTime - java.lang.System.nanoTime();
            }
            return true;
        }
    }

    public boolean awaitQuiescence(long j, java.util.concurrent.TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread = (java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread;
            if (forkJoinWorkerThread.pool == this) {
                helpQuiescePool(forkJoinWorkerThread.workQueue);
                return true;
            }
        }
        long jNanoTime = java.lang.System.nanoTime();
        while (true) {
            java8.util.concurrent.ForkJoinTask<?> forkJoinTaskPollScan = pollScan(false);
            if (forkJoinTaskPollScan != null) {
                forkJoinTaskPollScan.doExec();
            } else {
                if (isQuiescent()) {
                    return true;
                }
                if (java.lang.System.nanoTime() - jNanoTime > nanos) {
                    return false;
                }
                java.lang.Thread.yield();
            }
        }
    }

    static void quiesceCommonPool() {
        common.awaitQuiescence(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
    }

    public static void managedBlock(java8.util.concurrent.ForkJoinPool.ManagedBlocker managedBlocker) throws java.lang.Throwable {
        java8.util.concurrent.ForkJoinWorkerThread forkJoinWorkerThread;
        java8.util.concurrent.ForkJoinPool forkJoinPool;
        java8.util.concurrent.ForkJoinPool.WorkQueue workQueue;
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if ((threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) && (forkJoinPool = (forkJoinWorkerThread = (java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).pool) != null && (workQueue = forkJoinWorkerThread.workQueue) != null) {
            while (!managedBlocker.isReleasable()) {
                int iTryCompensate = forkJoinPool.tryCompensate(workQueue);
                if (iTryCompensate != 0) {
                    do {
                        long j = RC_UNIT;
                        try {
                            if (managedBlocker.isReleasable()) {
                                break;
                            }
                        } finally {
                            long j2 = CTL;
                            if (iTryCompensate <= 0) {
                                j = 0;
                            }
                            getAndAddLong(forkJoinPool, j2, j);
                        }
                    } while (!managedBlocker.block());
                    return;
                }
            }
            return;
        }
        while (!managedBlocker.isReleasable() && !managedBlocker.block()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void helpAsyncBlocker(java.util.concurrent.Executor r10, java8.util.concurrent.ForkJoinPool.ManagedBlocker r11) {
        /*
            if (r11 == 0) goto L7c
            boolean r0 = r10 instanceof java8.util.concurrent.ForkJoinPool
            if (r0 == 0) goto L7c
            java8.util.concurrent.ForkJoinPool r10 = (java8.util.concurrent.ForkJoinPool) r10
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof java8.util.concurrent.ForkJoinWorkerThread
            if (r1 == 0) goto L19
            java8.util.concurrent.ForkJoinWorkerThread r0 = (java8.util.concurrent.ForkJoinWorkerThread) r0
            java8.util.concurrent.ForkJoinPool r1 = r0.pool
            if (r1 != r10) goto L19
            java8.util.concurrent.ForkJoinPool$WorkQueue r10 = r0.workQueue
            goto L2f
        L19:
            int r0 = java8.util.concurrent.TLRandom.getProbe()
            if (r0 == 0) goto L2e
            java8.util.concurrent.ForkJoinPool$WorkQueue[] r10 = r10.workQueues
            if (r10 == 0) goto L2e
            int r1 = r10.length
            if (r1 <= 0) goto L2e
            int r1 = r1 + (-1)
            r0 = r0 & r1
            r0 = r0 & 126(0x7e, float:1.77E-43)
            r10 = r10[r0]
            goto L2f
        L2e:
            r10 = 0
        L2f:
            if (r10 == 0) goto L7c
        L31:
            int r0 = r10.base
            int r1 = r10.top
            java8.util.concurrent.ForkJoinTask<?>[] r3 = r10.array
            if (r3 == 0) goto L7c
            int r1 = r0 - r1
            if (r1 >= 0) goto L7c
            int r2 = r3.length
            if (r2 <= 0) goto L7c
            int r2 = r2 + (-1)
            r2 = r2 & r0
            long r4 = (long) r2
            int r2 = java8.util.concurrent.ForkJoinPool.ASHIFT
            long r4 = r4 << r2
            int r2 = java8.util.concurrent.ForkJoinPool.ABASE
            long r6 = (long) r2
            long r4 = r4 + r6
            sun.misc.Unsafe r2 = java8.util.concurrent.ForkJoinPool.U
            java.lang.Object r6 = r2.getObjectVolatile(r3, r4)
            r8 = r6
            java8.util.concurrent.ForkJoinTask r8 = (java8.util.concurrent.ForkJoinTask) r8
            boolean r6 = r11.isReleasable()
            if (r6 == 0) goto L5b
            goto L7c
        L5b:
            int r9 = r0 + 1
            int r6 = r10.base
            if (r0 != r6) goto L31
            if (r8 != 0) goto L67
            r0 = -1
            if (r1 != r0) goto L31
            goto L7c
        L67:
            boolean r0 = isInstanceOfAsynCompTask(r8)
            if (r0 != 0) goto L6e
            goto L7c
        L6e:
            r7 = 0
            r6 = r8
            boolean r0 = com.google.common.util.concurrent.Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(r2, r3, r4, r6, r7)
            if (r0 == 0) goto L31
            r10.base = r9
            r8.doExec()
            goto L31
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.ForkJoinPool.helpAsyncBlocker(java.util.concurrent.Executor, java8.util.concurrent.ForkJoinPool$ManagedBlocker):void");
    }

    static boolean isInstanceOfAsynCompTask(java8.util.concurrent.ForkJoinTask<?> forkJoinTask) {
        java.lang.Class<?> cls;
        if (forkJoinTask == null || (cls = ACTCLASS) == null) {
            return false;
        }
        return cls.isAssignableFrom(forkJoinTask.getClass());
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.lang.Runnable runnable, T t) {
        return new java8.util.concurrent.ForkJoinTask.AdaptedRunnable(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.util.concurrent.Callable<T> callable) {
        return new java8.util.concurrent.ForkJoinTask.AdaptedCallable(callable);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.concurrent.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            CTL = unsafe.objectFieldOffset(java8.util.concurrent.ForkJoinPool.class.getDeclaredField("ctl"));
            MODE = unsafe.objectFieldOffset(java8.util.concurrent.ForkJoinPool.class.getDeclaredField("mode"));
            ABASE = unsafe.arrayBaseOffset(java8.util.concurrent.ForkJoinTask[].class);
            int iArrayIndexScale = unsafe.arrayIndexScale(java8.util.concurrent.ForkJoinTask[].class);
            if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                throw new java.lang.ExceptionInInitializerError("array index scale not a power of two");
            }
            ASHIFT = 31 - java.lang.Integer.numberOfLeadingZeros(iArrayIndexScale);
            int i = 256;
            try {
                java.lang.String property = java.lang.System.getProperty("java.util.concurrent.ForkJoinPool.common.maximumSpares");
                if (property != null) {
                    i = java.lang.Integer.parseInt(property);
                }
            } catch (java.lang.Exception unused) {
            }
            COMMON_MAX_SPARES = i;
            defaultForkJoinWorkerThreadFactory = new java8.util.concurrent.ForkJoinPool.DefaultForkJoinWorkerThreadFactory();
            modifyThreadPermission = new java.lang.RuntimePermission("modifyThread");
            java8.util.concurrent.ForkJoinPool forkJoinPool = (java8.util.concurrent.ForkJoinPool) java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java8.util.concurrent.ForkJoinPool>() { // from class: java8.util.concurrent.ForkJoinPool.1
                @Override // java.security.PrivilegedAction
                public java8.util.concurrent.ForkJoinPool run() {
                    return new java8.util.concurrent.ForkJoinPool((byte) 0);
                }
            });
            common = forkJoinPool;
            COMMON_PARALLELISM = java.lang.Math.max(forkJoinPool.mode & SMASK, 1);
            try {
                ACTCLASS = java.lang.Class.forName("java8.util.concurrent.CompletableFuture$AsynchronousCompletionTask");
            } catch (java.lang.Exception unused2) {
                ACTCLASS = null;
            } catch (java.lang.Throwable th) {
                ACTCLASS = null;
                throw th;
            }
        } catch (java.lang.Exception e) {
            throw new java.lang.ExceptionInInitializerError(e);
        }
    }

    private static final class InnocuousForkJoinWorkerThreadFactory implements java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory {
        private static final java.security.AccessControlContext ACC = java8.util.concurrent.ForkJoinPool.contextWithPermissions(java8.util.concurrent.ForkJoinPool.modifyThreadPermission, new java.lang.RuntimePermission("enableContextClassLoaderOverride"), new java.lang.RuntimePermission("modifyThreadGroup"), new java.lang.RuntimePermission("getClassLoader"), new java.lang.RuntimePermission("setContextClassLoader"));

        private InnocuousForkJoinWorkerThreadFactory() {
        }

        @Override // java8.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory
        public final java8.util.concurrent.ForkJoinWorkerThread newThread(final java8.util.concurrent.ForkJoinPool forkJoinPool) {
            return (java8.util.concurrent.ForkJoinWorkerThread) java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java8.util.concurrent.ForkJoinWorkerThread>() { // from class: java8.util.concurrent.ForkJoinPool.InnocuousForkJoinWorkerThreadFactory.1
                @Override // java.security.PrivilegedAction
                public java8.util.concurrent.ForkJoinWorkerThread run() {
                    return new java8.util.concurrent.ForkJoinWorkerThread.InnocuousForkJoinWorkerThread(forkJoinPool);
                }
            }, ACC);
        }
    }

    static final class MemBar {
        private static final long OFF;
        private static final sun.misc.Unsafe U;
        private static final java8.util.concurrent.Mock x = new java8.util.concurrent.Mock();

        static {
            sun.misc.Unsafe unsafe = java8.util.concurrent.UnsafeAccess.unsafe;
            U = unsafe;
            try {
                OFF = unsafe.objectFieldOffset(java8.util.concurrent.Mock.class.getDeclaredField("v"));
            } catch (java.lang.Exception e) {
                throw new java.lang.ExceptionInInitializerError(e);
            }
        }

        static void loadFence() {
            U.getIntVolatile(x, OFF);
        }

        static void storeFence() {
            U.putOrderedInt(x, OFF, 0);
        }

        static void fullFence() {
            U.putIntVolatile(x, OFF, 0);
        }

        private MemBar() {
        }
    }
}
