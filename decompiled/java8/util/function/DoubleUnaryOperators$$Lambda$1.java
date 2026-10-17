package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoubleUnaryOperators$$Lambda$1 implements java8.util.function.DoubleUnaryOperator {
    private final java8.util.function.DoubleUnaryOperator arg$1;
    private final java8.util.function.DoubleUnaryOperator arg$2;

    private DoubleUnaryOperators$$Lambda$1(java8.util.function.DoubleUnaryOperator doubleUnaryOperator, java8.util.function.DoubleUnaryOperator doubleUnaryOperator2) {
        this.arg$1 = doubleUnaryOperator;
        this.arg$2 = doubleUnaryOperator2;
    }

    public static java8.util.function.DoubleUnaryOperator lambdaFactory$(java8.util.function.DoubleUnaryOperator doubleUnaryOperator, java8.util.function.DoubleUnaryOperator doubleUnaryOperator2) {
        return new java8.util.function.DoubleUnaryOperators$$Lambda$1(doubleUnaryOperator, doubleUnaryOperator2);
    }

    @Override // java8.util.function.DoubleUnaryOperator
    public double applyAsDouble(double d) {
        return this.arg$1.applyAsDouble(this.arg$2.applyAsDouble(d));
    }
}
