package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class LBQSpliterator<E> implements java8.util.Spliterator<E> {
    private static final long HEAD_OFF;
    private static final int MAX_BATCH = 33554432;
    private static final long NODE_ITEM_OFF;
    private static final long NODE_NEXT_OFF;
    private static final long PUT_LOCK_OFF;
    private static final long TAKE_LOCK_OFF;
    private static final sun.misc.Unsafe U;
    private int batch;
    private java.lang.Object current;
    private long est;
    private boolean exhausted;
    private final java.util.concurrent.locks.ReentrantLock putLock;
    private final java.util.concurrent.LinkedBlockingQueue<E> queue;
    private final java.util.concurrent.locks.ReentrantLock takeLock;

    @Override // java8.util.Spliterator
    public int characteristics() {
        return 4368;
    }

    private LBQSpliterator(java.util.concurrent.LinkedBlockingQueue<E> linkedBlockingQueue) {
        this.queue = linkedBlockingQueue;
        this.est = linkedBlockingQueue.size();
        this.putLock = getPutLock(linkedBlockingQueue);
        this.takeLock = getTakeLock(linkedBlockingQueue);
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.concurrent.LinkedBlockingQueue<T> linkedBlockingQueue) {
        return new java8.util.LBQSpliterator(linkedBlockingQueue);
    }

    java.lang.Object succ(java.lang.Object obj) {
        java.lang.Object nextNode = getNextNode(obj);
        return obj == nextNode ? getHeadNext(this.queue) : nextNode;
    }

    @Override // java8.util.Spliterator
    public long estimateSize() {
        return this.est;
    }

    @Override // java8.util.Spliterator
    public void forEachRemaining(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        if (this.exhausted) {
            return;
        }
        this.exhausted = true;
        java.lang.Object obj = this.current;
        this.current = null;
        forEachFrom(consumer, obj);
    }

    @Override // java8.util.Spliterator
    public java.util.Comparator<? super E> getComparator() {
        return java8.util.Spliterators.getComparator(this);
    }

    @Override // java8.util.Spliterator
    public long getExactSizeIfKnown() {
        return java8.util.Spliterators.getExactSizeIfKnown(this);
    }

    @Override // java8.util.Spliterator
    public boolean hasCharacteristics(int i) {
        return java8.util.Spliterators.hasCharacteristics(this, i);
    }

    @Override // java8.util.Spliterator
    public boolean tryAdvance(java8.util.function.Consumer<? super E> consumer) {
        android.R.color colorVar;
        java8.util.Objects.requireNonNull(consumer);
        if (this.exhausted) {
            return false;
        }
        fullyLock();
        try {
            java.lang.Object objSucc = this.current;
            if (objSucc != null || (objSucc = getHeadNext(this.queue)) != null) {
                do {
                    colorVar = (java.lang.Object) getNodeItem(objSucc);
                    objSucc = succ(objSucc);
                    if (colorVar != null) {
                        break;
                    }
                } while (objSucc != null);
            } else {
                colorVar = null;
            }
            this.current = objSucc;
            if (objSucc == null) {
                this.exhausted = true;
            }
            if (colorVar == null) {
                return false;
            }
            consumer.accept(colorVar);
            return true;
        } finally {
            fullyUnlock();
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x002c, B:21:0x003c, B:23:0x0044, B:24:0x0046), top: B:39:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0046 A[SYNTHETIC] */
    @Override // java8.util.Spliterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java8.util.Spliterator<E> trySplit() {
        /*
            r10 = this;
            java.util.concurrent.LinkedBlockingQueue<E> r0 = r10.queue
            boolean r1 = r10.exhausted
            if (r1 != 0) goto L72
            java.lang.Object r1 = r10.current
            if (r1 != 0) goto L10
            java.lang.Object r1 = getHeadNext(r0)
            if (r1 == 0) goto L72
        L10:
            java.lang.Object r1 = getNextNode(r1)
            if (r1 == 0) goto L72
            int r1 = r10.batch
            r2 = 1
            int r1 = r1 + r2
            r3 = 33554432(0x2000000, float:9.403955E-38)
            int r1 = java.lang.Math.min(r1, r3)
            r10.batch = r1
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.Object r4 = r10.current
            r10.fullyLock()
            r5 = 0
            if (r4 != 0) goto L37
            java.lang.Object r4 = getHeadNext(r0)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L33
            goto L37
        L33:
            r0 = r5
            goto L4f
        L35:
            r0 = move-exception
            goto L4b
        L37:
            r0 = r5
        L38:
            if (r4 == 0) goto L4f
            if (r0 >= r1) goto L4f
            java.lang.Object r6 = getNodeItem(r4)     // Catch: java.lang.Throwable -> L35
            r3[r0] = r6     // Catch: java.lang.Throwable -> L35
            if (r6 == 0) goto L46
            int r0 = r0 + 1
        L46:
            java.lang.Object r4 = r10.succ(r4)     // Catch: java.lang.Throwable -> L35
            goto L38
        L4b:
            r10.fullyUnlock()
            throw r0
        L4f:
            r10.fullyUnlock()
            r10.current = r4
            r6 = 0
            if (r4 != 0) goto L5d
            r10.est = r6
            r10.exhausted = r2
            goto L69
        L5d:
            long r1 = r10.est
            long r8 = (long) r0
            long r1 = r1 - r8
            r10.est = r1
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 >= 0) goto L69
            r10.est = r6
        L69:
            if (r0 <= 0) goto L72
            r1 = 4368(0x1110, float:6.121E-42)
            java8.util.Spliterator r0 = java8.util.Spliterators.spliterator(r3, r5, r0, r1)
            return r0
        L72:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.LBQSpliterator.trySplit():java8.util.Spliterator");
    }

    void forEachFrom(java8.util.function.Consumer<? super E> consumer, java.lang.Object obj) {
        java.lang.Object[] objArr = null;
        int i = 0;
        do {
            fullyLock();
            if (objArr == null) {
                if (obj == null) {
                    try {
                        obj = getHeadNext(this.queue);
                    } catch (java.lang.Throwable th) {
                        fullyUnlock();
                        throw th;
                    }
                }
                java.lang.Object objSucc = obj;
                while (objSucc != null && (getNodeItem(objSucc) == null || (i = i + 1) != 64)) {
                    objSucc = succ(objSucc);
                }
                objArr = new java.lang.Object[i];
            }
            int i2 = 0;
            while (obj != null && i2 < i) {
                java.lang.Object nodeItem = getNodeItem(obj);
                objArr[i2] = nodeItem;
                if (nodeItem != null) {
                    i2++;
                }
                obj = succ(obj);
            }
            fullyUnlock();
            for (int i3 = 0; i3 < i2; i3++) {
                consumer.accept(objArr[i3]);
            }
            if (i2 <= 0) {
                return;
            }
        } while (obj != null);
    }

    private void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    private void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    private static java.util.concurrent.locks.ReentrantLock getPutLock(java.util.concurrent.LinkedBlockingQueue<?> linkedBlockingQueue) {
        return (java.util.concurrent.locks.ReentrantLock) U.getObject(linkedBlockingQueue, PUT_LOCK_OFF);
    }

    private static java.util.concurrent.locks.ReentrantLock getTakeLock(java.util.concurrent.LinkedBlockingQueue<?> linkedBlockingQueue) {
        return (java.util.concurrent.locks.ReentrantLock) U.getObject(linkedBlockingQueue, TAKE_LOCK_OFF);
    }

    private static <T> java.lang.Object getHeadNext(java.util.concurrent.LinkedBlockingQueue<T> linkedBlockingQueue) {
        return getNextNode(U.getObject(linkedBlockingQueue, HEAD_OFF));
    }

    private static java.lang.Object getNextNode(java.lang.Object obj) {
        return U.getObject(obj, NODE_NEXT_OFF);
    }

    private static <T> T getNodeItem(java.lang.Object obj) {
        return (T) U.getObject(obj, NODE_ITEM_OFF);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("java.util.concurrent.LinkedBlockingQueue$Node");
            HEAD_OFF = unsafe.objectFieldOffset(java.util.concurrent.LinkedBlockingQueue.class.getDeclaredField("head"));
            NODE_ITEM_OFF = unsafe.objectFieldOffset(cls.getDeclaredField("item"));
            NODE_NEXT_OFF = unsafe.objectFieldOffset(cls.getDeclaredField("next"));
            PUT_LOCK_OFF = unsafe.objectFieldOffset(java.util.concurrent.LinkedBlockingQueue.class.getDeclaredField("putLock"));
            TAKE_LOCK_OFF = unsafe.objectFieldOffset(java.util.concurrent.LinkedBlockingQueue.class.getDeclaredField("takeLock"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
