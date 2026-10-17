package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class PBQueueSpliterator<E> implements java8.util.Spliterator<E> {
    private java.lang.Object[] array;
    private int fence;
    private int index;
    private final java.util.concurrent.PriorityBlockingQueue<E> queue;

    @Override // java8.util.Spliterator
    public int characteristics() {
        return 16704;
    }

    private PBQueueSpliterator(java.util.concurrent.PriorityBlockingQueue<E> priorityBlockingQueue, java.lang.Object[] objArr, int i, int i2) {
        this.queue = priorityBlockingQueue;
        this.array = objArr;
        this.index = i;
        this.fence = i2;
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.concurrent.PriorityBlockingQueue<T> priorityBlockingQueue) {
        return new java8.util.PBQueueSpliterator(priorityBlockingQueue, null, 0, -1);
    }

    private int getFence() {
        if (this.array == null) {
            java.lang.Object[] array = this.queue.toArray();
            this.array = array;
            this.fence = array.length;
        }
        return this.fence;
    }

    @Override // java8.util.Spliterator
    public java8.util.PBQueueSpliterator<E> trySplit() {
        int fence = getFence();
        int i = this.index;
        int i2 = (fence + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        java.util.concurrent.PriorityBlockingQueue<E> priorityBlockingQueue = this.queue;
        java.lang.Object[] objArr = this.array;
        this.index = i2;
        return new java8.util.PBQueueSpliterator<>(priorityBlockingQueue, objArr, i, i2);
    }

    @Override // java8.util.Spliterator
    public void forEachRemaining(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        int fence = getFence();
        java.lang.Object[] objArr = this.array;
        this.index = fence;
        for (int i = this.index; i < fence; i++) {
            consumer.accept(objArr[i]);
        }
    }

    @Override // java8.util.Spliterator
    public boolean tryAdvance(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        int fence = getFence();
        int i = this.index;
        if (fence <= i || i < 0) {
            return false;
        }
        java.lang.Object[] objArr = this.array;
        this.index = i + 1;
        consumer.accept(objArr[i]);
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
}
