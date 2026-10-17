package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class PQueueSpliterator<E> implements java8.util.Spliterator<E> {
    private static final boolean IS_HARMONY;
    private static final long MODCOUNT_OFF;
    private static final long QUEUE_OFF;
    private static final long SIZE_OFF;
    private static final sun.misc.Unsafe U;
    private int expectedModCount;
    private int fence;
    private int index;
    private final java.util.PriorityQueue<E> pq;

    @Override // java8.util.Spliterator
    public int characteristics() {
        return 16704;
    }

    private PQueueSpliterator(java.util.PriorityQueue<E> priorityQueue, int i, int i2, int i3) {
        this.pq = priorityQueue;
        this.index = i;
        this.fence = i2;
        this.expectedModCount = i3;
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.PriorityQueue<T> priorityQueue) {
        return new java8.util.PQueueSpliterator(priorityQueue, 0, -1, 0);
    }

    private int getFence() {
        int i = this.fence;
        if (i >= 0) {
            return i;
        }
        this.expectedModCount = getModCount(this.pq);
        int size = getSize(this.pq);
        this.fence = size;
        return size;
    }

    @Override // java8.util.Spliterator
    public java8.util.PQueueSpliterator<E> trySplit() {
        int fence = getFence();
        int i = this.index;
        int i2 = (fence + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        java.util.PriorityQueue<E> priorityQueue = this.pq;
        this.index = i2;
        return new java8.util.PQueueSpliterator<>(priorityQueue, i, i2, this.expectedModCount);
    }

    @Override // java8.util.Spliterator
    public void forEachRemaining(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        java.util.PriorityQueue<E> priorityQueue = this.pq;
        if (this.fence < 0) {
            this.fence = getSize(priorityQueue);
            this.expectedModCount = getModCount(priorityQueue);
        }
        java.lang.Object[] queue = getQueue(priorityQueue);
        int i = this.fence;
        this.index = i;
        for (int i2 = this.index; i2 < i; i2++) {
            java.lang.Object obj = queue[i2];
            if (obj == null) {
                break;
            }
            consumer.accept(obj);
        }
        if (getModCount(priorityQueue) != this.expectedModCount) {
            throw new java.util.ConcurrentModificationException();
        }
    }

    @Override // java8.util.Spliterator
    public boolean tryAdvance(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        java.util.PriorityQueue<E> priorityQueue = this.pq;
        if (this.fence < 0) {
            this.fence = getSize(priorityQueue);
            this.expectedModCount = getModCount(priorityQueue);
        }
        int i = this.index;
        if (i >= this.fence) {
            return false;
        }
        this.index = i + 1;
        java.lang.Object obj = getQueue(priorityQueue)[i];
        if (obj == null || getModCount(priorityQueue) != this.expectedModCount) {
            throw new java.util.ConcurrentModificationException();
        }
        consumer.accept(obj);
        return true;
    }

    @Override // java8.util.Spliterator
    public long estimateSize() {
        return getFence() - this.index;
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

    private static <T> int getSize(java.util.PriorityQueue<T> priorityQueue) {
        return U.getInt(priorityQueue, SIZE_OFF);
    }

    private static <T> int getModCount(java.util.PriorityQueue<T> priorityQueue) {
        if (IS_HARMONY) {
            return 0;
        }
        return U.getInt(priorityQueue, MODCOUNT_OFF);
    }

    private static <T> java.lang.Object[] getQueue(java.util.PriorityQueue<T> priorityQueue) {
        return (java.lang.Object[]) U.getObject(priorityQueue, QUEUE_OFF);
    }

    static {
        boolean z = java8.util.Spliterators.IS_HARMONY_ANDROID;
        IS_HARMONY = z;
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            SIZE_OFF = unsafe.objectFieldOffset(java.util.PriorityQueue.class.getDeclaredField("size"));
            if (!z) {
                MODCOUNT_OFF = unsafe.objectFieldOffset(java.util.PriorityQueue.class.getDeclaredField("modCount"));
            } else {
                MODCOUNT_OFF = 0L;
            }
            QUEUE_OFF = unsafe.objectFieldOffset(java.util.PriorityQueue.class.getDeclaredField(z ? "elements" : "queue"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
