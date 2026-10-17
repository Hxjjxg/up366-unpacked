package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class StreamSpliterators$DistinctSpliterator$$Lambda$1 implements java8.util.function.Consumer {
    private final java8.util.stream.StreamSpliterators.DistinctSpliterator arg$1;
    private final java8.util.function.Consumer arg$2;

    private StreamSpliterators$DistinctSpliterator$$Lambda$1(java8.util.stream.StreamSpliterators.DistinctSpliterator distinctSpliterator, java8.util.function.Consumer consumer) {
        this.arg$1 = distinctSpliterator;
        this.arg$2 = consumer;
    }

    public static java8.util.function.Consumer lambdaFactory$(java8.util.stream.StreamSpliterators.DistinctSpliterator distinctSpliterator, java8.util.function.Consumer consumer) {
        return new java8.util.stream.StreamSpliterators$DistinctSpliterator$$Lambda$1(distinctSpliterator, consumer);
    }

    @Override // java8.util.function.Consumer
    public void accept(java.lang.Object obj) {
        java8.util.stream.StreamSpliterators.DistinctSpliterator.lambda$forEachRemaining$153(this.arg$1, this.arg$2, obj);
    }
}
