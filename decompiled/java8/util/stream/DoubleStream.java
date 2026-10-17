package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface DoubleStream extends java8.util.stream.BaseStream<java.lang.Double, java8.util.stream.DoubleStream> {

    public interface Builder extends java8.util.function.DoubleConsumer {
        @Override // java8.util.function.DoubleConsumer
        void accept(double d);

        java8.util.stream.DoubleStream.Builder add(double d);

        java8.util.stream.DoubleStream build();
    }

    boolean allMatch(java8.util.function.DoublePredicate doublePredicate);

    boolean anyMatch(java8.util.function.DoublePredicate doublePredicate);

    java8.util.OptionalDouble average();

    java8.util.stream.Stream<java.lang.Double> boxed();

    <R> R collect(java8.util.function.Supplier<R> supplier, java8.util.function.ObjDoubleConsumer<R> objDoubleConsumer, java8.util.function.BiConsumer<R, R> biConsumer);

    long count();

    java8.util.stream.DoubleStream distinct();

    java8.util.stream.DoubleStream dropWhile(java8.util.function.DoublePredicate doublePredicate);

    java8.util.stream.DoubleStream filter(java8.util.function.DoublePredicate doublePredicate);

    java8.util.OptionalDouble findAny();

    java8.util.OptionalDouble findFirst();

    java8.util.stream.DoubleStream flatMap(java8.util.function.DoubleFunction<? extends java8.util.stream.DoubleStream> doubleFunction);

    void forEach(java8.util.function.DoubleConsumer doubleConsumer);

    void forEachOrdered(java8.util.function.DoubleConsumer doubleConsumer);

    @Override // java8.util.stream.BaseStream
    java.util.Iterator<java.lang.Double> iterator();

    java8.util.stream.DoubleStream limit(long j);

    java8.util.stream.DoubleStream map(java8.util.function.DoubleUnaryOperator doubleUnaryOperator);

    java8.util.stream.IntStream mapToInt(java8.util.function.DoubleToIntFunction doubleToIntFunction);

    java8.util.stream.LongStream mapToLong(java8.util.function.DoubleToLongFunction doubleToLongFunction);

    <U> java8.util.stream.Stream<U> mapToObj(java8.util.function.DoubleFunction<? extends U> doubleFunction);

    java8.util.OptionalDouble max();

    java8.util.OptionalDouble min();

    boolean noneMatch(java8.util.function.DoublePredicate doublePredicate);

    @Override // java8.util.stream.BaseStream
    java8.util.stream.DoubleStream parallel();

    java8.util.stream.DoubleStream peek(java8.util.function.DoubleConsumer doubleConsumer);

    double reduce(double d, java8.util.function.DoubleBinaryOperator doubleBinaryOperator);

    java8.util.OptionalDouble reduce(java8.util.function.DoubleBinaryOperator doubleBinaryOperator);

    @Override // java8.util.stream.BaseStream
    java8.util.stream.DoubleStream sequential();

    java8.util.stream.DoubleStream skip(long j);

    java8.util.stream.DoubleStream sorted();

    @Override // java8.util.stream.BaseStream
    /* JADX INFO: renamed from: spliterator */
    java8.util.Spliterator<java.lang.Double> spliterator2();

    double sum();

    java8.util.DoubleSummaryStatistics summaryStatistics();

    java8.util.stream.DoubleStream takeWhile(java8.util.function.DoublePredicate doublePredicate);

    double[] toArray();
}
