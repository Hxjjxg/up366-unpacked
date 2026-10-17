package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntPredicates$$Lambda$1 implements java8.util.function.IntPredicate {
    private final java8.util.function.IntPredicate arg$1;
    private final java8.util.function.IntPredicate arg$2;

    private IntPredicates$$Lambda$1(java8.util.function.IntPredicate intPredicate, java8.util.function.IntPredicate intPredicate2) {
        this.arg$1 = intPredicate;
        this.arg$2 = intPredicate2;
    }

    public static java8.util.function.IntPredicate lambdaFactory$(java8.util.function.IntPredicate intPredicate, java8.util.function.IntPredicate intPredicate2) {
        return new java8.util.function.IntPredicates$$Lambda$1(intPredicate, intPredicate2);
    }

    @Override // java8.util.function.IntPredicate
    public boolean test(int i) {
        return java8.util.function.IntPredicates.lambda$and$141(this.arg$1, this.arg$2, i);
    }
}
