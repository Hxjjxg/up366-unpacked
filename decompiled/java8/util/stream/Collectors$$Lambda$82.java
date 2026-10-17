package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$82 implements java8.util.function.BiConsumer {
    private static final java8.util.stream.Collectors$$Lambda$82 instance = new java8.util.stream.Collectors$$Lambda$82();

    private Collectors$$Lambda$82() {
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        ((java8.util.stream.Collectors.C1PairBox) obj).add(obj2);
    }
}
