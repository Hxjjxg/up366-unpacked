package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class ReferencePipeline$9$1$$Lambda$1 implements java8.util.function.DoubleConsumer {
    private final java8.util.stream.Sink arg$1;

    private ReferencePipeline$9$1$$Lambda$1(java8.util.stream.Sink sink) {
        this.arg$1 = sink;
    }

    public static java8.util.function.DoubleConsumer lambdaFactory$(java8.util.stream.Sink sink) {
        return new java8.util.stream.ReferencePipeline$9$1$$Lambda$1(sink);
    }

    @Override // java8.util.function.DoubleConsumer
    public void accept(double d) {
        this.arg$1.accept(d);
    }
}
