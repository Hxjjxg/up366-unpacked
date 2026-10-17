package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$73 implements java8.util.function.BiConsumer {
    private final java8.util.function.Function arg$1;
    private final java8.util.function.Function arg$2;
    private final java8.util.function.BinaryOperator arg$3;

    private Collectors$$Lambda$73(java8.util.function.Function function, java8.util.function.Function function2, java8.util.function.BinaryOperator binaryOperator) {
        this.arg$1 = function;
        this.arg$2 = function2;
        this.arg$3 = binaryOperator;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.Function function, java8.util.function.Function function2, java8.util.function.BinaryOperator binaryOperator) {
        return new java8.util.stream.Collectors$$Lambda$73(function, function2, binaryOperator);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$toMap$68(this.arg$1, this.arg$2, this.arg$3, (java.util.Map) obj, obj2);
    }
}
