package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPipeline$$Lambda$1 implements java8.util.function.LongConsumer {
    private final java8.util.stream.Sink arg$1;

    private LongPipeline$$Lambda$1(java8.util.stream.Sink sink) {
        this.arg$1 = sink;
    }

    public static java8.util.function.LongConsumer lambdaFactory$(java8.util.stream.Sink sink) {
        return new java8.util.stream.LongPipeline$$Lambda$1(sink);
    }

    @Override // java8.util.function.LongConsumer
    public void accept(long j) {
        this.arg$1.accept(j);
    }
}
