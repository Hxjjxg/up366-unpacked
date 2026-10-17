package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$67 implements java8.util.function.BiConsumer {
    private final java8.util.function.Function arg$1;
    private final java8.util.function.Supplier arg$2;
    private final java8.util.function.BiConsumer arg$3;

    private Collectors$$Lambda$67(java8.util.function.Function function, java8.util.function.Supplier supplier, java8.util.function.BiConsumer biConsumer) {
        this.arg$1 = function;
        this.arg$2 = supplier;
        this.arg$3 = biConsumer;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.Function function, java8.util.function.Supplier supplier, java8.util.function.BiConsumer biConsumer) {
        return new java8.util.stream.Collectors$$Lambda$67(function, supplier, biConsumer);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$groupingByConcurrent$61(this.arg$1, this.arg$2, this.arg$3, (java.util.concurrent.ConcurrentMap) obj, obj2);
    }
}
