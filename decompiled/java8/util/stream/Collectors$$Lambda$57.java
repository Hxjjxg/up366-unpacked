package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$57 implements java8.util.function.Supplier {
    private final java8.util.function.BinaryOperator arg$1;

    private Collectors$$Lambda$57(java8.util.function.BinaryOperator binaryOperator) {
        this.arg$1 = binaryOperator;
    }

    public static java8.util.function.Supplier lambdaFactory$(java8.util.function.BinaryOperator binaryOperator) {
        return new java8.util.stream.Collectors$$Lambda$57(binaryOperator);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.Collectors.lambda$reducing$48(this.arg$1);
    }
}
