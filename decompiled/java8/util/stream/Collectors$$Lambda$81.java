package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$81 implements java8.util.function.Supplier {
    private final java8.util.function.Supplier arg$1;
    private final java8.util.function.Supplier arg$2;
    private final java8.util.function.BiConsumer arg$3;
    private final java8.util.function.BiConsumer arg$4;
    private final java8.util.function.BinaryOperator arg$5;
    private final java8.util.function.BinaryOperator arg$6;
    private final java8.util.function.Function arg$7;
    private final java8.util.function.Function arg$8;
    private final java8.util.function.BiFunction arg$9;

    private Collectors$$Lambda$81(java8.util.function.Supplier supplier, java8.util.function.Supplier supplier2, java8.util.function.BiConsumer biConsumer, java8.util.function.BiConsumer biConsumer2, java8.util.function.BinaryOperator binaryOperator, java8.util.function.BinaryOperator binaryOperator2, java8.util.function.Function function, java8.util.function.Function function2, java8.util.function.BiFunction biFunction) {
        this.arg$1 = supplier;
        this.arg$2 = supplier2;
        this.arg$3 = biConsumer;
        this.arg$4 = biConsumer2;
        this.arg$5 = binaryOperator;
        this.arg$6 = binaryOperator2;
        this.arg$7 = function;
        this.arg$8 = function2;
        this.arg$9 = biFunction;
    }

    public static java8.util.function.Supplier lambdaFactory$(java8.util.function.Supplier supplier, java8.util.function.Supplier supplier2, java8.util.function.BiConsumer biConsumer, java8.util.function.BiConsumer biConsumer2, java8.util.function.BinaryOperator binaryOperator, java8.util.function.BinaryOperator binaryOperator2, java8.util.function.Function function, java8.util.function.Function function2, java8.util.function.BiFunction biFunction) {
        return new java8.util.stream.Collectors$$Lambda$81(supplier, supplier2, biConsumer, biConsumer2, binaryOperator, binaryOperator2, function, function2, biFunction);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.Collectors.lambda$teeing0$76(this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5, this.arg$6, this.arg$7, this.arg$8, this.arg$9);
    }
}
