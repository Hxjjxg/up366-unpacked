package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongUnaryOperators$$Lambda$1 implements java8.util.function.LongUnaryOperator {
    private final java8.util.function.LongUnaryOperator arg$1;
    private final java8.util.function.LongUnaryOperator arg$2;

    private LongUnaryOperators$$Lambda$1(java8.util.function.LongUnaryOperator longUnaryOperator, java8.util.function.LongUnaryOperator longUnaryOperator2) {
        this.arg$1 = longUnaryOperator;
        this.arg$2 = longUnaryOperator2;
    }

    public static java8.util.function.LongUnaryOperator lambdaFactory$(java8.util.function.LongUnaryOperator longUnaryOperator, java8.util.function.LongUnaryOperator longUnaryOperator2) {
        return new java8.util.function.LongUnaryOperators$$Lambda$1(longUnaryOperator, longUnaryOperator2);
    }

    @Override // java8.util.function.LongUnaryOperator
    public long applyAsLong(long j) {
        return this.arg$1.applyAsLong(this.arg$2.applyAsLong(j));
    }
}
