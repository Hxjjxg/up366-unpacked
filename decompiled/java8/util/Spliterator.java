package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface Spliterator<T> {
    public static final int CONCURRENT = 4096;
    public static final int DISTINCT = 1;
    public static final int IMMUTABLE = 1024;
    public static final int NONNULL = 256;
    public static final int ORDERED = 16;
    public static final int SIZED = 64;
    public static final int SORTED = 4;
    public static final int SUBSIZED = 16384;

    public interface OfDouble extends java8.util.Spliterator.OfPrimitive<java.lang.Double, java8.util.function.DoubleConsumer, java8.util.Spliterator.OfDouble> {
        @Override // java8.util.Spliterator
        void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer);

        void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer);

        @Override // java8.util.Spliterator
        boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer);

        boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer);

        @Override // java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
        java8.util.Spliterator.OfDouble trySplit();
    }

    public interface OfInt extends java8.util.Spliterator.OfPrimitive<java.lang.Integer, java8.util.function.IntConsumer, java8.util.Spliterator.OfInt> {
        @Override // java8.util.Spliterator
        void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer);

        void forEachRemaining(java8.util.function.IntConsumer intConsumer);

        @Override // java8.util.Spliterator
        boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer);

        boolean tryAdvance(java8.util.function.IntConsumer intConsumer);

        @Override // java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
        java8.util.Spliterator.OfInt trySplit();
    }

    public interface OfLong extends java8.util.Spliterator.OfPrimitive<java.lang.Long, java8.util.function.LongConsumer, java8.util.Spliterator.OfLong> {
        @Override // java8.util.Spliterator
        void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer);

        void forEachRemaining(java8.util.function.LongConsumer longConsumer);

        @Override // java8.util.Spliterator
        boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer);

        boolean tryAdvance(java8.util.function.LongConsumer longConsumer);

        @Override // java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
        java8.util.Spliterator.OfLong trySplit();
    }

    public interface OfPrimitive<T, T_CONS, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends java8.util.Spliterator<T> {
        void forEachRemaining(T_CONS t_cons);

        boolean tryAdvance(T_CONS t_cons);

        @Override // java8.util.Spliterator
        T_SPLITR trySplit();
    }

    int characteristics();

    long estimateSize();

    void forEachRemaining(java8.util.function.Consumer<? super T> consumer);

    java.util.Comparator<? super T> getComparator();

    long getExactSizeIfKnown();

    boolean hasCharacteristics(int i);

    boolean tryAdvance(java8.util.function.Consumer<? super T> consumer);

    java8.util.Spliterator<T> trySplit();
}
