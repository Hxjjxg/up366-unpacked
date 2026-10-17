package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$27 implements java8.util.function.BiConsumer {
    private final java8.util.function.Predicate arg$1;
    private final java8.util.function.BiConsumer arg$2;

    private Collectors$$Lambda$27(java8.util.function.Predicate predicate, java8.util.function.BiConsumer biConsumer) {
        this.arg$1 = predicate;
        this.arg$2 = biConsumer;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.Predicate predicate, java8.util.function.BiConsumer biConsumer) {
        return new java8.util.stream.Collectors$$Lambda$27(predicate, biConsumer);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$filtering$18(this.arg$1, this.arg$2, obj, obj2);
    }
}
