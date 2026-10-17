package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class RASpliterator<E> implements java8.util.Spliterator<E> {
    private static final long MODCOUNT_OFF;
    private static final sun.misc.Unsafe U;
    private final java.util.AbstractList<E> alist;
    private int expectedModCount;
    private int fence;
    private int index;
    private final java.util.List<E> list;

    @Override // java8.util.Spliterator
    public int characteristics() {
        return 16464;
    }

    private RASpliterator(java.util.List<E> list, int i, int i2, int i3) {
        this.list = list;
        this.index = i;
        this.fence = i2;
        this.alist = list instanceof java.util.AbstractList ? (java.util.AbstractList) list : null;
        this.expectedModCount = i3;
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.List<T> list) {
        return new java8.util.RASpliterator(list, 0, -1, 0);
    }

    private int getFence() {
        java.util.List<E> list = this.list;
        int i = this.fence;
        if (i >= 0) {
            return i;
        }
        java.util.AbstractList<E> abstractList = this.alist;
        if (abstractList != null) {
            this.expectedModCount = getModCount(abstractList);
        }
        int size = list.size();
        this.fence = size;
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
        java.util.List<E> list = this.list;
        this.index = i2;
        return new java8.util.RASpliterator(list, i, i2, this.expectedModCount);
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
        consumer.accept(this.list.get(i));
        checkAbsListModCount(this.alist, this.expectedModCount);
        return true;
    }

    @Override // java8.util.Spliterator
    public void forEachRemaining(java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        java.util.List<E> list = this.list;
        int fence = getFence();
        this.index = fence;
        for (int i = this.index; i < fence; i++) {
            try {
                consumer.accept(list.get(i));
            } catch (java.lang.IndexOutOfBoundsException unused) {
                throw new java.util.ConcurrentModificationException();
            }
        }
        checkAbsListModCount(this.alist, this.expectedModCount);
    }

    @Override // java8.util.Spliterator
    public long estimateSize() {
        return getFence() - this.index;
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
    public java.util.Comparator<? super E> getComparator() {
        return java8.util.Spliterators.getComparator(this);
    }

    private static void checkAbsListModCount(java.util.AbstractList<?> abstractList, int i) {
        if (abstractList != null && getModCount(abstractList) != i) {
            throw new java.util.ConcurrentModificationException();
        }
    }

    private static <T> int getModCount(java.util.List<T> list) {
        return U.getInt(list, MODCOUNT_OFF);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            MODCOUNT_OFF = unsafe.objectFieldOffset(java.util.AbstractList.class.getDeclaredField("modCount"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
