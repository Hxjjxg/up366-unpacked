package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class StreamSupport {
    private StreamSupport() {
    }

    public static <T> java8.util.stream.Stream<T> stream(java.util.Collection<? extends T> collection) {
        return stream(java8.util.Spliterators.spliterator(collection), false);
    }

    public static <T> java8.util.stream.Stream<T> parallelStream(java.util.Collection<? extends T> collection) {
        return stream(java8.util.Spliterators.spliterator(collection), true);
    }

    public static <T> java8.util.stream.Stream<T> stream(java.util.Collection<? extends T> collection, int i) {
        return stream((java.util.Collection) collection, i, false);
    }

    public static <T> java8.util.stream.Stream<T> stream(java.util.Collection<? extends T> collection, int i, boolean z) {
        java8.util.Objects.requireNonNull(collection);
        return stream(java8.util.Spliterators.spliterator(collection, i), z);
    }

    public static <T> java8.util.stream.Stream<T> stream(java8.util.Spliterator<T> spliterator, boolean z) {
        java8.util.Objects.requireNonNull(spliterator);
        return new java8.util.stream.ReferencePipeline.Head((java8.util.Spliterator<?>) spliterator, java8.util.stream.StreamOpFlag.fromCharacteristics((java8.util.Spliterator<?>) spliterator), z);
    }

    public static <T> java8.util.stream.Stream<T> stream(java8.util.function.Supplier<? extends java8.util.Spliterator<T>> supplier, int i, boolean z) {
        java8.util.Objects.requireNonNull(supplier);
        return new java8.util.stream.ReferencePipeline.Head((java8.util.function.Supplier<? extends java8.util.Spliterator<?>>) supplier, java8.util.stream.StreamOpFlag.fromCharacteristics(i), z);
    }

    public static java8.util.stream.IntStream intStream(java8.util.Spliterator.OfInt ofInt, boolean z) {
        return new java8.util.stream.IntPipeline.Head(ofInt, java8.util.stream.StreamOpFlag.fromCharacteristics(ofInt), z);
    }

    public static java8.util.stream.IntStream intStream(java8.util.function.Supplier<? extends java8.util.Spliterator.OfInt> supplier, int i, boolean z) {
        return new java8.util.stream.IntPipeline.Head(supplier, java8.util.stream.StreamOpFlag.fromCharacteristics(i), z);
    }

    public static java8.util.stream.LongStream longStream(java8.util.Spliterator.OfLong ofLong, boolean z) {
        return new java8.util.stream.LongPipeline.Head(ofLong, java8.util.stream.StreamOpFlag.fromCharacteristics(ofLong), z);
    }

    public static java8.util.stream.LongStream longStream(java8.util.function.Supplier<? extends java8.util.Spliterator.OfLong> supplier, int i, boolean z) {
        return new java8.util.stream.LongPipeline.Head(supplier, java8.util.stream.StreamOpFlag.fromCharacteristics(i), z);
    }

    public static java8.util.stream.DoubleStream doubleStream(java8.util.Spliterator.OfDouble ofDouble, boolean z) {
        return new java8.util.stream.DoublePipeline.Head(ofDouble, java8.util.stream.StreamOpFlag.fromCharacteristics(ofDouble), z);
    }

    public static java8.util.stream.DoubleStream doubleStream(java8.util.function.Supplier<? extends java8.util.Spliterator.OfDouble> supplier, int i, boolean z) {
        return new java8.util.stream.DoublePipeline.Head(supplier, java8.util.stream.StreamOpFlag.fromCharacteristics(i), z);
    }

    static java.lang.Runnable closeHandler(java8.util.stream.BaseStream<?, ?> baseStream) {
        baseStream.getClass();
        return java8.util.stream.StreamSupport$$Lambda$1.lambdaFactory$(baseStream);
    }
}
