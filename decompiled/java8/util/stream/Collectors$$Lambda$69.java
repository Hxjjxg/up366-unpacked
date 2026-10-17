package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$69 implements java8.util.function.BiConsumer {
    private final java8.util.function.BiConsumer arg$1;
    private final java8.util.function.Predicate arg$2;

    private Collectors$$Lambda$69(java8.util.function.BiConsumer biConsumer, java8.util.function.Predicate predicate) {
        this.arg$1 = biConsumer;
        this.arg$2 = predicate;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.BiConsumer biConsumer, java8.util.function.Predicate predicate) {
        return new java8.util.stream.Collectors$$Lambda$69(biConsumer, predicate);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$partitioningBy$64(this.arg$1, this.arg$2, (java8.util.stream.Collectors.Partition) obj, obj2);
    }
}
