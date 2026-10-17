package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class ArrayListSpliterator<E> implements java8.util.Spliterator<E> {
    private static final long DATA_OFF;
    private static final long MODCOUNT_OFF;
    private static final long SIZE_OFF;
    private static final sun.misc.Unsafe U;
    private int expectedModCount;
    private int fence;
    private int index;
    private final java.util.ArrayList<E> list;

    @Override // java8.util.Spliterator
    public int characteristics() {
        return 16464;
    }

    private ArrayListSpliterator(java.util.ArrayList<E> arrayList, int i, int i2, int i3) {
        this.list = arrayList;
        this.index = i;
        this.fence = i2;
        this.expectedModCount = i3;
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.ArrayList<T> arrayList) {
        return new java8.util.ArrayListSpliterator(arrayList, 0, -1, 0);
    }

    private int getFence() {
        int i = this.fence;
        if (i >= 0) {
            return i;
        }
        java.util.ArrayList<E> arrayList = this.list;
        this.expectedModCount = getModCount(arrayList);
        int size = getSize(arrayList);
        this.fence = size;
        return size;
    }

    @Override // java8.util.Spliterator
    public java8.util.ArrayListSpliterator<E> trySplit() {
        int fence = getFence();
        int i = this.index;
        int i2 = (fence + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        java.util.ArrayList<E> arrayList = this.list;
        this.index = i2;
        return new java8.util.ArrayListSpliterator<>(arrayList, i, i2, this.expectedModCount);
    }

    @Override // java8.util.Spliterator
    public boolean tryAdvance(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        int fence = getFence();
        int i = this.index;
        if (i >= fence) {
            return false;
        }
        this.index = i + 1;
        consumer.accept(getData(this.list)[i]);
        if (this.expectedModCount == getModCount(this.list)) {
            return true;
        }
        throw new java.util.ConcurrentModificationException();
    }

    @Override // java8.util.Spliterator
    public void forEachRemaining(java8.util.function.Consumer<? super E> consumer) {
        int modCount;
        java8.util.Objects.requireNonNull(consumer);
        java.util.ArrayList<E> arrayList = this.list;
        java.lang.Object[] data = getData(arrayList);
        if (data != null) {
            int size = this.fence;
            if (size < 0) {
                modCount = getModCount(arrayList);
                size = getSize(arrayList);
            } else {
                modCount = this.expectedModCount;
            }
            int i = this.index;
            if (i >= 0) {
                this.index = size;
                if (size <= data.length) {
                    while (i < size) {
                        consumer.accept(data[i]);
                        i++;
                    }
                    if (modCount == getModCount(arrayList)) {
                        return;
                    }
                }
            }
        }
        throw new java.util.ConcurrentModificationException();
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

    private static <T> int getSize(java.util.ArrayList<T> arrayList) {
        return U.getInt(arrayList, SIZE_OFF);
    }

    private static <T> int getModCount(java.util.ArrayList<T> arrayList) {
        return U.getInt(arrayList, MODCOUNT_OFF);
    }

    private static <T> java.lang.Object[] getData(java.util.ArrayList<T> arrayList) {
        return (java.lang.Object[]) U.getObject(arrayList, DATA_OFF);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            MODCOUNT_OFF = unsafe.objectFieldOffset(java.util.AbstractList.class.getDeclaredField("modCount"));
            SIZE_OFF = unsafe.objectFieldOffset(java.util.ArrayList.class.getDeclaredField("size"));
            DATA_OFF = unsafe.objectFieldOffset(java.util.ArrayList.class.getDeclaredField(java8.util.Spliterators.IS_HARMONY_ANDROID ? "array" : "elementData"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
