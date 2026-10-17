package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DistinctOps$1$$Lambda$2 implements java8.util.function.BiConsumer {
    private static final java8.util.stream.DistinctOps$1$$Lambda$2 instance = new java8.util.stream.DistinctOps$1$$Lambda$2();

    private DistinctOps$1$$Lambda$2() {
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        ((java.util.LinkedHashSet) obj).add(obj2);
    }
}
