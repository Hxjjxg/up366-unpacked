package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class StreamSpliterators$WrappingSpliterator$$Lambda$2 implements java8.util.function.BooleanSupplier {
    private final java8.util.stream.StreamSpliterators.WrappingSpliterator arg$1;

    private StreamSpliterators$WrappingSpliterator$$Lambda$2(java8.util.stream.StreamSpliterators.WrappingSpliterator wrappingSpliterator) {
        this.arg$1 = wrappingSpliterator;
    }

    public static java8.util.function.BooleanSupplier lambdaFactory$(java8.util.stream.StreamSpliterators.WrappingSpliterator wrappingSpliterator) {
        return new java8.util.stream.StreamSpliterators$WrappingSpliterator$$Lambda$2(wrappingSpliterator);
    }

    @Override // java8.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        return java8.util.stream.StreamSpliterators.WrappingSpliterator.lambda$initPartialTraversalState$144(this.arg$1);
    }
}
