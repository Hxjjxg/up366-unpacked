package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntPipeline$$Lambda$1 implements java8.util.function.IntConsumer {
    private final java8.util.stream.Sink arg$1;

    private IntPipeline$$Lambda$1(java8.util.stream.Sink sink) {
        this.arg$1 = sink;
    }

    public static java8.util.function.IntConsumer lambdaFactory$(java8.util.stream.Sink sink) {
        return new java8.util.stream.IntPipeline$$Lambda$1(sink);
    }

    @Override // java8.util.function.IntConsumer
    public void accept(int i) {
        this.arg$1.accept(i);
    }
}
