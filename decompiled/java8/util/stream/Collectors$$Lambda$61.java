package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$61 implements java8.util.function.BiConsumer {
    private final java8.util.function.BinaryOperator arg$1;
    private final java8.util.function.Function arg$2;

    private Collectors$$Lambda$61(java8.util.function.BinaryOperator binaryOperator, java8.util.function.Function function) {
        this.arg$1 = binaryOperator;
        this.arg$2 = function;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.BinaryOperator binaryOperator, java8.util.function.Function function) {
        return new java8.util.stream.Collectors$$Lambda$61(binaryOperator, function);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$reducing$51(this.arg$1, this.arg$2, (java.lang.Object[]) obj, obj2);
    }
}
