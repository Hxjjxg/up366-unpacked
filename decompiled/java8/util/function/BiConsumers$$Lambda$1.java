package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class BiConsumers$$Lambda$1 implements java8.util.function.BiConsumer {
    private final java8.util.function.BiConsumer arg$1;
    private final java8.util.function.BiConsumer arg$2;

    private BiConsumers$$Lambda$1(java8.util.function.BiConsumer biConsumer, java8.util.function.BiConsumer biConsumer2) {
        this.arg$1 = biConsumer;
        this.arg$2 = biConsumer2;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.BiConsumer biConsumer, java8.util.function.BiConsumer biConsumer2) {
        return new java8.util.function.BiConsumers$$Lambda$1(biConsumer, biConsumer2);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.function.BiConsumers.lambda$andThen$130(this.arg$1, this.arg$2, obj, obj2);
    }
}
