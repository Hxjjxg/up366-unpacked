package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$53 implements java8.util.function.BiConsumer {
    private final java8.util.function.BinaryOperator arg$1;

    private Collectors$$Lambda$53(java8.util.function.BinaryOperator binaryOperator) {
        this.arg$1 = binaryOperator;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.BinaryOperator binaryOperator) {
        return new java8.util.stream.Collectors$$Lambda$53(binaryOperator);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$reducing$44(this.arg$1, (java.lang.Object[]) obj, obj2);
    }
}
