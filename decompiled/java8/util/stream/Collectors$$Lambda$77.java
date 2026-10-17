package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$77 implements java8.util.function.BiConsumer {
    private final java8.util.function.ToLongFunction arg$1;

    private Collectors$$Lambda$77(java8.util.function.ToLongFunction toLongFunction) {
        this.arg$1 = toLongFunction;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.ToLongFunction toLongFunction) {
        return new java8.util.stream.Collectors$$Lambda$77(toLongFunction);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$summarizingLong$72(this.arg$1, (java8.util.LongSummaryStatistics) obj, obj2);
    }
}
