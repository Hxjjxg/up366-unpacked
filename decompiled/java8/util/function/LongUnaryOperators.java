package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class LongUnaryOperators {
    static /* synthetic */ long lambda$identity$125(long j) {
        return j;
    }

    public static java8.util.function.LongUnaryOperator compose(java8.util.function.LongUnaryOperator longUnaryOperator, java8.util.function.LongUnaryOperator longUnaryOperator2) {
        java8.util.Objects.requireNonNull(longUnaryOperator);
        java8.util.Objects.requireNonNull(longUnaryOperator2);
        return java8.util.function.LongUnaryOperators$$Lambda$1.lambdaFactory$(longUnaryOperator, longUnaryOperator2);
    }

    public static java8.util.function.LongUnaryOperator andThen(java8.util.function.LongUnaryOperator longUnaryOperator, java8.util.function.LongUnaryOperator longUnaryOperator2) {
        java8.util.Objects.requireNonNull(longUnaryOperator);
        java8.util.Objects.requireNonNull(longUnaryOperator2);
        return java8.util.function.LongUnaryOperators$$Lambda$2.lambdaFactory$(longUnaryOperator2, longUnaryOperator);
    }

    static /* synthetic */ long lambda$andThen$124(java8.util.function.LongUnaryOperator longUnaryOperator, java8.util.function.LongUnaryOperator longUnaryOperator2, long j) {
        return longUnaryOperator.applyAsLong(longUnaryOperator2.applyAsLong(j));
    }

    public static java8.util.function.LongUnaryOperator identity() {
        return java8.util.function.LongUnaryOperators$$Lambda$3.instance;
    }

    private LongUnaryOperators() {
    }
}
