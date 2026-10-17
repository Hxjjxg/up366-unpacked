package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface Stream<T> extends java8.util.stream.BaseStream<T, java8.util.stream.Stream<T>> {

    public interface Builder<T> extends java8.util.function.Consumer<T> {
        @Override // java8.util.function.Consumer
        void accept(T t);

        java8.util.stream.Stream.Builder<T> add(T t);

        java8.util.stream.Stream<T> build();
    }

    boolean allMatch(java8.util.function.Predicate<? super T> predicate);

    boolean anyMatch(java8.util.function.Predicate<? super T> predicate);

    <R> R collect(java8.util.function.Supplier<R> supplier, java8.util.function.BiConsumer<R, ? super T> biConsumer, java8.util.function.BiConsumer<R, R> biConsumer2);

    <R, A> R collect(java8.util.stream.Collector<? super T, A, R> collector);

    long count();

    java8.util.stream.Stream<T> distinct();

    java8.util.stream.Stream<T> dropWhile(java8.util.function.Predicate<? super T> predicate);

    java8.util.stream.Stream<T> filter(java8.util.function.Predicate<? super T> predicate);

    java8.util.Optional<T> findAny();

    java8.util.Optional<T> findFirst();

    <R> java8.util.stream.Stream<R> flatMap(java8.util.function.Function<? super T, ? extends java8.util.stream.Stream<? extends R>> function);

    java8.util.stream.DoubleStream flatMapToDouble(java8.util.function.Function<? super T, ? extends java8.util.stream.DoubleStream> function);

    java8.util.stream.IntStream flatMapToInt(java8.util.function.Function<? super T, ? extends java8.util.stream.IntStream> function);

    java8.util.stream.LongStream flatMapToLong(java8.util.function.Function<? super T, ? extends java8.util.stream.LongStream> function);

    void forEach(java8.util.function.Consumer<? super T> consumer);

    void forEachOrdered(java8.util.function.Consumer<? super T> consumer);

    java8.util.stream.Stream<T> limit(long j);

    <R> java8.util.stream.Stream<R> map(java8.util.function.Function<? super T, ? extends R> function);

    java8.util.stream.DoubleStream mapToDouble(java8.util.function.ToDoubleFunction<? super T> toDoubleFunction);

    java8.util.stream.IntStream mapToInt(java8.util.function.ToIntFunction<? super T> toIntFunction);

    java8.util.stream.LongStream mapToLong(java8.util.function.ToLongFunction<? super T> toLongFunction);

    java8.util.Optional<T> max(java.util.Comparator<? super T> comparator);

    java8.util.Optional<T> min(java.util.Comparator<? super T> comparator);

    boolean noneMatch(java8.util.function.Predicate<? super T> predicate);

    java8.util.stream.Stream<T> peek(java8.util.function.Consumer<? super T> consumer);

    <U> U reduce(U u, java8.util.function.BiFunction<U, ? super T, U> biFunction, java8.util.function.BinaryOperator<U> binaryOperator);

    T reduce(T t, java8.util.function.BinaryOperator<T> binaryOperator);

    java8.util.Optional<T> reduce(java8.util.function.BinaryOperator<T> binaryOperator);

    java8.util.stream.Stream<T> skip(long j);

    java8.util.stream.Stream<T> sorted();

    java8.util.stream.Stream<T> sorted(java.util.Comparator<? super T> comparator);

    java8.util.stream.Stream<T> takeWhile(java8.util.function.Predicate<? super T> predicate);

    java.lang.Object[] toArray();

    <A> A[] toArray(java8.util.function.IntFunction<A[]> intFunction);
}
