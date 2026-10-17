package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class IntUnaryOperators {
    static /* synthetic */ int lambda$identity$114(int i) {
        return i;
    }

    public static java8.util.function.IntUnaryOperator compose(java8.util.function.IntUnaryOperator intUnaryOperator, java8.util.function.IntUnaryOperator intUnaryOperator2) {
        java8.util.Objects.requireNonNull(intUnaryOperator);
        java8.util.Objects.requireNonNull(intUnaryOperator2);
        return java8.util.function.IntUnaryOperators$$Lambda$1.lambdaFactory$(intUnaryOperator, intUnaryOperator2);
    }

    public static java8.util.function.IntUnaryOperator andThen(java8.util.function.IntUnaryOperator intUnaryOperator, java8.util.function.IntUnaryOperator intUnaryOperator2) {
        java8.util.Objects.requireNonNull(intUnaryOperator);
        java8.util.Objects.requireNonNull(intUnaryOperator2);
        return java8.util.function.IntUnaryOperators$$Lambda$2.lambdaFactory$(intUnaryOperator2, intUnaryOperator);
    }

    static /* synthetic */ int lambda$andThen$113(java8.util.function.IntUnaryOperator intUnaryOperator, java8.util.function.IntUnaryOperator intUnaryOperator2, int i) {
        return intUnaryOperator.applyAsInt(intUnaryOperator2.applyAsInt(i));
    }

    public static java8.util.function.IntUnaryOperator identity() {
        return java8.util.function.IntUnaryOperators$$Lambda$3.instance;
    }

    private IntUnaryOperators() {
    }
}
