package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Nodes$CollectorTask$OfRef$$Lambda$2 implements java8.util.function.BinaryOperator {
    private static final java8.util.stream.Nodes$CollectorTask$OfRef$$Lambda$2 instance = new java8.util.stream.Nodes$CollectorTask$OfRef$$Lambda$2();

    private Nodes$CollectorTask$OfRef$$Lambda$2() {
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return new java8.util.stream.Nodes.ConcNode((java8.util.stream.Node) obj, (java8.util.stream.Node) obj2);
    }
}
