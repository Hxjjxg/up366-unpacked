package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class ArrayDequeSpliterator<E> implements java8.util.Spliterator<E> {
    private static final long DATA_OFF;
    private static final long HEAD_OFF;
    private static final long TAIL_OFF;
    private static final sun.misc.Unsafe U;
    private final java.util.ArrayDeque<E> deq;
    private int fence;
    private int index;

    @Override // java8.util.Spliterator
    public int characteristics() {
        return 16720;
    }

    private ArrayDequeSpliterator(java.util.ArrayDeque<E> arrayDeque, int i, int i2) {
        this.deq = arrayDeque;
        this.index = i;
        this.fence = i2;
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.ArrayDeque<T> arrayDeque) {
        return new java8.util.ArrayDequeSpliterator(arrayDeque, -1, -1);
    }

    private int getFence() {
        int i = this.fence;
        if (i >= 0) {
            return i;
        }
        int tail = getTail(this.deq);
        this.fence = tail;
        this.index = getHead(this.deq);
        return tail;
    }

    @Override // java8.util.Spliterator
    public java8.util.ArrayDequeSpliterator<E> trySplit() {
        int fence = getFence();
        int i = this.index;
        int length = getData(this.deq).length;
        if (i == fence) {
            return null;
        }
        int i2 = length - 1;
        if (((i + 1) & i2) == fence) {
            return null;
        }
        if (i > fence) {
            fence += length;
        }
        int i3 = ((fence + i) >>> 1) & i2;
        java.util.ArrayDeque<E> arrayDeque = this.deq;
        this.index = i3;
        return new java8.util.ArrayDequeSpliterator<>(arrayDeque, i, i3);
    }

    @Override // java8.util.Spliterator
    public void forEachRemaining(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        java.lang.Object[] data = getData(this.deq);
        int length = data.length - 1;
        int fence = getFence();
        int i = this.index;
        this.index = fence;
        while (i != fence) {
            java.lang.Object obj = data[i];
            i = (i + 1) & length;
            if (obj == null) {
                throw new java.util.ConcurrentModificationException();
            }
            consumer.accept(obj);
        }
    }

    @Override // java8.util.Spliterator
    public boolean tryAdvance(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        java.lang.Object[] data = getData(this.deq);
        int length = data.length - 1;
        getFence();
        int i = this.index;
        if (i == this.fence) {
            return false;
        }
        java.lang.Object obj = data[i];
        this.index = length & (i + 1);
        if (obj == null) {
            throw new java.util.ConcurrentModificationException();
        }
        consumer.accept(obj);
        return true;
    }

    @Override // java8.util.Spliterator
    public long estimateSize() {
        int fence = getFence() - this.index;
        if (fence < 0) {
            fence += getData(this.deq).length;
        }
        return fence;
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

    private static <T> int getTail(java.util.ArrayDeque<T> arrayDeque) {
        return U.getInt(arrayDeque, TAIL_OFF);
    }

    private static <T> int getHead(java.util.ArrayDeque<T> arrayDeque) {
        return U.getInt(arrayDeque, HEAD_OFF);
    }

    private static <T> java.lang.Object[] getData(java.util.ArrayDeque<T> arrayDeque) {
        return (java.lang.Object[]) U.getObject(arrayDeque, DATA_OFF);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            TAIL_OFF = unsafe.objectFieldOffset(java.util.ArrayDeque.class.getDeclaredField("tail"));
            HEAD_OFF = unsafe.objectFieldOffset(java.util.ArrayDeque.class.getDeclaredField("head"));
            DATA_OFF = unsafe.objectFieldOffset(java.util.ArrayDeque.class.getDeclaredField("elements"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
