package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class VectorSpliterator<E> implements java8.util.Spliterator<E> {
    private static final long DATA_OFF;
    private static final long MODCOUNT_OFF;
    private static final long SIZE_OFF;
    private static final sun.misc.Unsafe U;
    private java.lang.Object[] array;
    private int expectedModCount;
    private int fence;
    private int index;
    private final java.util.Vector<E> list;

    @Override // java8.util.Spliterator
    public int characteristics() {
        return 16464;
    }

    private VectorSpliterator(java.util.Vector<E> vector, java.lang.Object[] objArr, int i, int i2, int i3) {
        this.list = vector;
        this.array = objArr;
        this.index = i;
        this.fence = i2;
        this.expectedModCount = i3;
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.Vector<T> vector) {
        return new java8.util.VectorSpliterator(vector, null, 0, -1, 0);
    }

    private int getFence() {
        int size = this.fence;
        if (size < 0) {
            synchronized (this.list) {
                this.array = getData(this.list);
                this.expectedModCount = getModCount(this.list);
                size = getSize(this.list);
                this.fence = size;
            }
        }
        return size;
    }

    @Override // java8.util.Spliterator
    public java8.util.Spliterator<E> trySplit() {
        int fence = getFence();
        int i = this.index;
        int i2 = (fence + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        java.util.Vector<E> vector = this.list;
        java.lang.Object[] objArr = this.array;
        this.index = i2;
        return new java8.util.VectorSpliterator(vector, objArr, i, i2, this.expectedModCount);
    }

    @Override // java8.util.Spliterator
    public boolean tryAdvance(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        int fence = getFence();
        int i = this.index;
        if (fence <= i) {
            return false;
        }
        this.index = i + 1;
        consumer.accept(this.array[i]);
        if (this.expectedModCount == getModCount(this.list)) {
            return true;
        }
        throw new java.util.ConcurrentModificationException();
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
        if (getModCount(this.list) != this.expectedModCount) {
            throw new java.util.ConcurrentModificationException();
        }
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

    private static <T> int getSize(java.util.Vector<T> vector) {
        return U.getInt(vector, SIZE_OFF);
    }

    private static <T> int getModCount(java.util.Vector<T> vector) {
        return U.getInt(vector, MODCOUNT_OFF);
    }

    private static <T> java.lang.Object[] getData(java.util.Vector<T> vector) {
        return (java.lang.Object[]) U.getObject(vector, DATA_OFF);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            MODCOUNT_OFF = unsafe.objectFieldOffset(java.util.AbstractList.class.getDeclaredField("modCount"));
            SIZE_OFF = unsafe.objectFieldOffset(java.util.Vector.class.getDeclaredField("elementCount"));
            DATA_OFF = unsafe.objectFieldOffset(java.util.Vector.class.getDeclaredField("elementData"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
