package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoublePredicates$$Lambda$2 implements java8.util.function.DoublePredicate {
    private final java8.util.function.DoublePredicate arg$1;

    private DoublePredicates$$Lambda$2(java8.util.function.DoublePredicate doublePredicate) {
        this.arg$1 = doublePredicate;
    }

    public static java8.util.function.DoublePredicate lambdaFactory$(java8.util.function.DoublePredicate doublePredicate) {
        return new java8.util.function.DoublePredicates$$Lambda$2(doublePredicate);
    }

    @Override // java8.util.function.DoublePredicate
    public boolean test(double d) {
        return java8.util.function.DoublePredicates.lambda$negate$158(this.arg$1, d);
    }
}
