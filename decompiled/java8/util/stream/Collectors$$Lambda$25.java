package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$25 implements java8.util.function.BiConsumer {
    private final java8.util.function.BiConsumer arg$1;
    private final java8.util.function.Function arg$2;

    private Collectors$$Lambda$25(java8.util.function.BiConsumer biConsumer, java8.util.function.Function function) {
        this.arg$1 = biConsumer;
        this.arg$2 = function;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.BiConsumer biConsumer, java8.util.function.Function function) {
        return new java8.util.stream.Collectors$$Lambda$25(biConsumer, function);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$mapping$15(this.arg$1, this.arg$2, obj, obj2);
    }
}
