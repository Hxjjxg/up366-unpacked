package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Nodes$CollectorTask$OfRef$$Lambda$1 implements java8.util.function.LongFunction {
    private final java8.util.function.IntFunction arg$1;

    private Nodes$CollectorTask$OfRef$$Lambda$1(java8.util.function.IntFunction intFunction) {
        this.arg$1 = intFunction;
    }

    public static java8.util.function.LongFunction lambdaFactory$(java8.util.function.IntFunction intFunction) {
        return new java8.util.stream.Nodes$CollectorTask$OfRef$$Lambda$1(intFunction);
    }

    @Override // java8.util.function.LongFunction
    public java.lang.Object apply(long j) {
        return java8.util.stream.Nodes.CollectorTask.OfRef.lambda$new$109(this.arg$1, j);
    }
}
