package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntUnaryOperators$$Lambda$2 implements java8.util.function.IntUnaryOperator {
    private final java8.util.function.IntUnaryOperator arg$1;
    private final java8.util.function.IntUnaryOperator arg$2;

    private IntUnaryOperators$$Lambda$2(java8.util.function.IntUnaryOperator intUnaryOperator, java8.util.function.IntUnaryOperator intUnaryOperator2) {
        this.arg$1 = intUnaryOperator;
        this.arg$2 = intUnaryOperator2;
    }

    public static java8.util.function.IntUnaryOperator lambdaFactory$(java8.util.function.IntUnaryOperator intUnaryOperator, java8.util.function.IntUnaryOperator intUnaryOperator2) {
        return new java8.util.function.IntUnaryOperators$$Lambda$2(intUnaryOperator, intUnaryOperator2);
    }

    @Override // java8.util.function.IntUnaryOperator
    public int applyAsInt(int i) {
        return java8.util.function.IntUnaryOperators.lambda$andThen$113(this.arg$1, this.arg$2, i);
    }
}
