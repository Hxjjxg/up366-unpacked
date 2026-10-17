package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPredicates$$Lambda$2 implements java8.util.function.LongPredicate {
    private final java8.util.function.LongPredicate arg$1;

    private LongPredicates$$Lambda$2(java8.util.function.LongPredicate longPredicate) {
        this.arg$1 = longPredicate;
    }

    public static java8.util.function.LongPredicate lambdaFactory$(java8.util.function.LongPredicate longPredicate) {
        return new java8.util.function.LongPredicates$$Lambda$2(longPredicate);
    }

    @Override // java8.util.function.LongPredicate
    public boolean test(long j) {
        return java8.util.function.LongPredicates.lambda$negate$138(this.arg$1, j);
    }
}
