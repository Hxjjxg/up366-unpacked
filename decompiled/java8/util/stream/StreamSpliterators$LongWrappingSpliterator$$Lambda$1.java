package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class StreamSpliterators$LongWrappingSpliterator$$Lambda$1 implements java8.util.function.BooleanSupplier {
    private final java8.util.stream.StreamSpliterators.LongWrappingSpliterator arg$1;

    private StreamSpliterators$LongWrappingSpliterator$$Lambda$1(java8.util.stream.StreamSpliterators.LongWrappingSpliterator longWrappingSpliterator) {
        this.arg$1 = longWrappingSpliterator;
    }

    public static java8.util.function.BooleanSupplier lambdaFactory$(java8.util.stream.StreamSpliterators.LongWrappingSpliterator longWrappingSpliterator) {
        return new java8.util.stream.StreamSpliterators$LongWrappingSpliterator$$Lambda$1(longWrappingSpliterator);
    }

    @Override // java8.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        return java8.util.stream.StreamSpliterators.LongWrappingSpliterator.lambda$initPartialTraversalState$146(this.arg$1);
    }
}
