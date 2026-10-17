package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface LongStream extends java8.util.stream.BaseStream<java.lang.Long, java8.util.stream.LongStream> {

    public interface Builder extends java8.util.function.LongConsumer {
        @Override // java8.util.function.LongConsumer
        void accept(long j);

        java8.util.stream.LongStream.Builder add(long j);

        java8.util.stream.LongStream build();
    }

    boolean allMatch(java8.util.function.LongPredicate longPredicate);

    boolean anyMatch(java8.util.function.LongPredicate longPredicate);

    java8.util.stream.DoubleStream asDoubleStream();

    java8.util.OptionalDouble average();

    java8.util.stream.Stream<java.lang.Long> boxed();

    <R> R collect(java8.util.function.Supplier<R> supplier, java8.util.function.ObjLongConsumer<R> objLongConsumer, java8.util.function.BiConsumer<R, R> biConsumer);

    long count();

    java8.util.stream.LongStream distinct();

    java8.util.stream.LongStream dropWhile(java8.util.function.LongPredicate longPredicate);

    java8.util.stream.LongStream filter(java8.util.function.LongPredicate longPredicate);

    java8.util.OptionalLong findAny();

    java8.util.OptionalLong findFirst();

    java8.util.stream.LongStream flatMap(java8.util.function.LongFunction<? extends java8.util.stream.LongStream> longFunction);

    void forEach(java8.util.function.LongConsumer longConsumer);

    void forEachOrdered(java8.util.function.LongConsumer longConsumer);

    @Override // java8.util.stream.BaseStream
    java.util.Iterator<java.lang.Long> iterator();

    java8.util.stream.LongStream limit(long j);

    java8.util.stream.LongStream map(java8.util.function.LongUnaryOperator longUnaryOperator);

    java8.util.stream.DoubleStream mapToDouble(java8.util.function.LongToDoubleFunction longToDoubleFunction);

    java8.util.stream.IntStream mapToInt(java8.util.function.LongToIntFunction longToIntFunction);

    <U> java8.util.stream.Stream<U> mapToObj(java8.util.function.LongFunction<? extends U> longFunction);

    java8.util.OptionalLong max();

    java8.util.OptionalLong min();

    boolean noneMatch(java8.util.function.LongPredicate longPredicate);

    @Override // java8.util.stream.BaseStream
    java8.util.stream.LongStream parallel();

    java8.util.stream.LongStream peek(java8.util.function.LongConsumer longConsumer);

    long reduce(long j, java8.util.function.LongBinaryOperator longBinaryOperator);

    java8.util.OptionalLong reduce(java8.util.function.LongBinaryOperator longBinaryOperator);

    @Override // java8.util.stream.BaseStream
    java8.util.stream.LongStream sequential();

    java8.util.stream.LongStream skip(long j);

    java8.util.stream.LongStream sorted();

    @Override // java8.util.stream.BaseStream
    /* JADX INFO: renamed from: spliterator */
    java8.util.Spliterator<java.lang.Long> spliterator2();

    long sum();

    java8.util.LongSummaryStatistics summaryStatistics();

    java8.util.stream.LongStream takeWhile(java8.util.function.LongPredicate longPredicate);

    long[] toArray();
}
