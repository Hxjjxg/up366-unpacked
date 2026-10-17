package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class StreamSpliterators$IntWrappingSpliterator$$Lambda$1 implements java8.util.function.BooleanSupplier {
    private final java8.util.stream.StreamSpliterators.IntWrappingSpliterator arg$1;

    private StreamSpliterators$IntWrappingSpliterator$$Lambda$1(java8.util.stream.StreamSpliterators.IntWrappingSpliterator intWrappingSpliterator) {
        this.arg$1 = intWrappingSpliterator;
    }

    public static java8.util.function.BooleanSupplier lambdaFactory$(java8.util.stream.StreamSpliterators.IntWrappingSpliterator intWrappingSpliterator) {
        return new java8.util.stream.StreamSpliterators$IntWrappingSpliterator$$Lambda$1(intWrappingSpliterator);
    }

    @Override // java8.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        return java8.util.stream.StreamSpliterators.IntWrappingSpliterator.lambda$initPartialTraversalState$145(this.arg$1);
    }
}
