package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface Collector<T, A, R> {

    public enum Characteristics {
        CONCURRENT,
        UNORDERED,
        IDENTITY_FINISH
    }

    java8.util.function.BiConsumer<A, T> accumulator();

    java.util.Set<java8.util.stream.Collector.Characteristics> characteristics();

    java8.util.function.BinaryOperator<A> combiner();

    java8.util.function.Function<A, R> finisher();

    java8.util.function.Supplier<A> supplier();
}
