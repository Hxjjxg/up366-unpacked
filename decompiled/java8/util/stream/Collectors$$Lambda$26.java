package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$26 implements java8.util.function.BiConsumer {
    private final java8.util.function.Function arg$1;
    private final java8.util.function.BiConsumer arg$2;

    private Collectors$$Lambda$26(java8.util.function.Function function, java8.util.function.BiConsumer biConsumer) {
        this.arg$1 = function;
        this.arg$2 = biConsumer;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.Function function, java8.util.function.BiConsumer biConsumer) {
        return new java8.util.stream.Collectors$$Lambda$26(function, biConsumer);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) throws java.lang.Throwable {
        java8.util.stream.Collectors.lambda$flatMapping$17(this.arg$1, this.arg$2, obj, obj2);
    }
}
