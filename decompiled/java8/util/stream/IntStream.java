package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface IntStream extends java8.util.stream.BaseStream<java.lang.Integer, java8.util.stream.IntStream> {

    public interface Builder extends java8.util.function.IntConsumer {
        @Override // java8.util.function.IntConsumer
        void accept(int i);

        java8.util.stream.IntStream.Builder add(int i);

        java8.util.stream.IntStream build();
    }

    boolean allMatch(java8.util.function.IntPredicate intPredicate);

    boolean anyMatch(java8.util.function.IntPredicate intPredicate);

    java8.util.stream.DoubleStream asDoubleStream();

    java8.util.stream.LongStream asLongStream();

    java8.util.OptionalDouble average();

    java8.util.stream.Stream<java.lang.Integer> boxed();

    <R> R collect(java8.util.function.Supplier<R> supplier, java8.util.function.ObjIntConsumer<R> objIntConsumer, java8.util.function.BiConsumer<R, R> biConsumer);

    long count();

    java8.util.stream.IntStream distinct();

    java8.util.stream.IntStream dropWhile(java8.util.function.IntPredicate intPredicate);

    java8.util.stream.IntStream filter(java8.util.function.IntPredicate intPredicate);

    java8.util.OptionalInt findAny();

    java8.util.OptionalInt findFirst();

    java8.util.stream.IntStream flatMap(java8.util.function.IntFunction<? extends java8.util.stream.IntStream> intFunction);

    void forEach(java8.util.function.IntConsumer intConsumer);

    void forEachOrdered(java8.util.function.IntConsumer intConsumer);

    @Override // java8.util.stream.BaseStream
    java.util.Iterator<java.lang.Integer> iterator();

    java8.util.stream.IntStream limit(long j);

    java8.util.stream.IntStream map(java8.util.function.IntUnaryOperator intUnaryOperator);

    java8.util.stream.DoubleStream mapToDouble(java8.util.function.IntToDoubleFunction intToDoubleFunction);

    java8.util.stream.LongStream mapToLong(java8.util.function.IntToLongFunction intToLongFunction);

    <U> java8.util.stream.Stream<U> mapToObj(java8.util.function.IntFunction<? extends U> intFunction);

    java8.util.OptionalInt max();

    java8.util.OptionalInt min();

    boolean noneMatch(java8.util.function.IntPredicate intPredicate);

    @Override // java8.util.stream.BaseStream
    java8.util.stream.IntStream parallel();

    java8.util.stream.IntStream peek(java8.util.function.IntConsumer intConsumer);

    int reduce(int i, java8.util.function.IntBinaryOperator intBinaryOperator);

    java8.util.OptionalInt reduce(java8.util.function.IntBinaryOperator intBinaryOperator);

    @Override // java8.util.stream.BaseStream
    java8.util.stream.IntStream sequential();

    java8.util.stream.IntStream skip(long j);

    java8.util.stream.IntStream sorted();

    @Override // java8.util.stream.BaseStream
    /* JADX INFO: renamed from: spliterator */
    java8.util.Spliterator<java.lang.Integer> spliterator2();

    int sum();

    java8.util.IntSummaryStatistics summaryStatistics();

    java8.util.stream.IntStream takeWhile(java8.util.function.IntPredicate intPredicate);

    int[] toArray();
}
