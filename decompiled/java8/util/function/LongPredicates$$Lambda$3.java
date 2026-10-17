package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPredicates$$Lambda$3 implements java8.util.function.LongPredicate {
    private final java8.util.function.LongPredicate arg$1;
    private final java8.util.function.LongPredicate arg$2;

    private LongPredicates$$Lambda$3(java8.util.function.LongPredicate longPredicate, java8.util.function.LongPredicate longPredicate2) {
        this.arg$1 = longPredicate;
        this.arg$2 = longPredicate2;
    }

    public static java8.util.function.LongPredicate lambdaFactory$(java8.util.function.LongPredicate longPredicate, java8.util.function.LongPredicate longPredicate2) {
        return new java8.util.function.LongPredicates$$Lambda$3(longPredicate, longPredicate2);
    }

    @Override // java8.util.function.LongPredicate
    public boolean test(long j) {
        return java8.util.function.LongPredicates.lambda$or$139(this.arg$1, this.arg$2, j);
    }
}
