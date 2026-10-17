package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Nodes$CollectorTask$OfInt$$Lambda$4 implements java8.util.function.BinaryOperator {
    private static final java8.util.stream.Nodes$CollectorTask$OfInt$$Lambda$4 instance = new java8.util.stream.Nodes$CollectorTask$OfInt$$Lambda$4();

    private Nodes$CollectorTask$OfInt$$Lambda$4() {
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return new java8.util.stream.Nodes.ConcNode.OfInt((java8.util.stream.Node.OfInt) obj, (java8.util.stream.Node.OfInt) obj2);
    }
}
