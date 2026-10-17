package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class StreamSpliterators$DoubleWrappingSpliterator$$Lambda$1 implements java8.util.function.BooleanSupplier {
    private final java8.util.stream.StreamSpliterators.DoubleWrappingSpliterator arg$1;

    private StreamSpliterators$DoubleWrappingSpliterator$$Lambda$1(java8.util.stream.StreamSpliterators.DoubleWrappingSpliterator doubleWrappingSpliterator) {
        this.arg$1 = doubleWrappingSpliterator;
    }

    public static java8.util.function.BooleanSupplier lambdaFactory$(java8.util.stream.StreamSpliterators.DoubleWrappingSpliterator doubleWrappingSpliterator) {
        return new java8.util.stream.StreamSpliterators$DoubleWrappingSpliterator$$Lambda$1(doubleWrappingSpliterator);
    }

    @Override // java8.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        java8.util.stream.StreamSpliterators.DoubleWrappingSpliterator doubleWrappingSpliterator = this.arg$1;
        return doubleWrappingSpliterator.spliterator.tryAdvance(doubleWrappingSpliterator.bufferSink);
    }
}
