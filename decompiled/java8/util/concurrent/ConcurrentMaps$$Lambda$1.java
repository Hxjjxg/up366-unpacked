package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class ConcurrentMaps$$Lambda$1 implements java8.util.function.BiConsumer {
    private final java.util.concurrent.ConcurrentMap arg$1;
    private final java8.util.function.BiFunction arg$2;

    private ConcurrentMaps$$Lambda$1(java.util.concurrent.ConcurrentMap concurrentMap, java8.util.function.BiFunction biFunction) {
        this.arg$1 = concurrentMap;
        this.arg$2 = biFunction;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java.util.concurrent.ConcurrentMap concurrentMap, java8.util.function.BiFunction biFunction) {
        return new java8.util.concurrent.ConcurrentMaps$$Lambda$1(concurrentMap, biFunction);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.concurrent.ConcurrentMaps.lambda$replaceAll$132(this.arg$1, this.arg$2, obj, obj2);
    }
}
