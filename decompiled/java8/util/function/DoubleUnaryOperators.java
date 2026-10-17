package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DoubleUnaryOperators {
    static /* synthetic */ double lambda$identity$128(double d) {
        return d;
    }

    public static java8.util.function.DoubleUnaryOperator compose(java8.util.function.DoubleUnaryOperator doubleUnaryOperator, java8.util.function.DoubleUnaryOperator doubleUnaryOperator2) {
        java8.util.Objects.requireNonNull(doubleUnaryOperator);
        java8.util.Objects.requireNonNull(doubleUnaryOperator2);
        return java8.util.function.DoubleUnaryOperators$$Lambda$1.lambdaFactory$(doubleUnaryOperator, doubleUnaryOperator2);
    }

    public static java8.util.function.DoubleUnaryOperator andThen(java8.util.function.DoubleUnaryOperator doubleUnaryOperator, java8.util.function.DoubleUnaryOperator doubleUnaryOperator2) {
        java8.util.Objects.requireNonNull(doubleUnaryOperator);
        java8.util.Objects.requireNonNull(doubleUnaryOperator2);
        return java8.util.function.DoubleUnaryOperators$$Lambda$2.lambdaFactory$(doubleUnaryOperator2, doubleUnaryOperator);
    }

    static /* synthetic */ double lambda$andThen$127(java8.util.function.DoubleUnaryOperator doubleUnaryOperator, java8.util.function.DoubleUnaryOperator doubleUnaryOperator2, double d) {
        return doubleUnaryOperator.applyAsDouble(doubleUnaryOperator2.applyAsDouble(d));
    }

    public static java8.util.function.DoubleUnaryOperator identity() {
        return java8.util.function.DoubleUnaryOperators$$Lambda$3.instance;
    }

    private DoubleUnaryOperators() {
    }
}
