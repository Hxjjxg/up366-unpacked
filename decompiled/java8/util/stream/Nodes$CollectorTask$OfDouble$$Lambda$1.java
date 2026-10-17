package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Nodes$CollectorTask$OfDouble$$Lambda$1 implements java8.util.function.LongFunction {
    private static final java8.util.stream.Nodes$CollectorTask$OfDouble$$Lambda$1 instance = new java8.util.stream.Nodes$CollectorTask$OfDouble$$Lambda$1();

    private Nodes$CollectorTask$OfDouble$$Lambda$1() {
    }

    @Override // java8.util.function.LongFunction
    public java.lang.Object apply(long j) {
        return java8.util.stream.Nodes.doubleBuilder(j);
    }
}
