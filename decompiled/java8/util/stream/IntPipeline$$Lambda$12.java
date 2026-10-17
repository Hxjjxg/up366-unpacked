package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntPipeline$$Lambda$12 implements java8.util.function.BinaryOperator {
    private final java8.util.function.BiConsumer arg$1;

    private IntPipeline$$Lambda$12(java8.util.function.BiConsumer biConsumer) {
        this.arg$1 = biConsumer;
    }

    public static java8.util.function.BinaryOperator lambdaFactory$(java8.util.function.BiConsumer biConsumer) {
        return new java8.util.stream.IntPipeline$$Lambda$12(biConsumer);
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.stream.IntPipeline.lambda$collect$98(this.arg$1, obj, obj2);
    }
}
