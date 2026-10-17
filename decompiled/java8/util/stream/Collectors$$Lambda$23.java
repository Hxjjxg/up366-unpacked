package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$23 implements java8.util.function.BinaryOperator {
    private final java8.util.function.BinaryOperator arg$1;

    private Collectors$$Lambda$23(java8.util.function.BinaryOperator binaryOperator) {
        this.arg$1 = binaryOperator;
    }

    public static java8.util.function.BinaryOperator lambdaFactory$(java8.util.function.BinaryOperator binaryOperator) {
        return new java8.util.stream.Collectors$$Lambda$23(binaryOperator);
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.stream.Collectors.lambda$mapMerger$13(this.arg$1, (java.util.Map) obj, (java.util.Map) obj2);
    }
}
