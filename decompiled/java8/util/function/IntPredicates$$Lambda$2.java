package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntPredicates$$Lambda$2 implements java8.util.function.IntPredicate {
    private final java8.util.function.IntPredicate arg$1;

    private IntPredicates$$Lambda$2(java8.util.function.IntPredicate intPredicate) {
        this.arg$1 = intPredicate;
    }

    public static java8.util.function.IntPredicate lambdaFactory$(java8.util.function.IntPredicate intPredicate) {
        return new java8.util.function.IntPredicates$$Lambda$2(intPredicate);
    }

    @Override // java8.util.function.IntPredicate
    public boolean test(int i) {
        return java8.util.function.IntPredicates.lambda$negate$142(this.arg$1, i);
    }
}
