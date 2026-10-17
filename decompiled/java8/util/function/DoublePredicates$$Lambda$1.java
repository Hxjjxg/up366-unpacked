package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoublePredicates$$Lambda$1 implements java8.util.function.DoublePredicate {
    private final java8.util.function.DoublePredicate arg$1;
    private final java8.util.function.DoublePredicate arg$2;

    private DoublePredicates$$Lambda$1(java8.util.function.DoublePredicate doublePredicate, java8.util.function.DoublePredicate doublePredicate2) {
        this.arg$1 = doublePredicate;
        this.arg$2 = doublePredicate2;
    }

    public static java8.util.function.DoublePredicate lambdaFactory$(java8.util.function.DoublePredicate doublePredicate, java8.util.function.DoublePredicate doublePredicate2) {
        return new java8.util.function.DoublePredicates$$Lambda$1(doublePredicate, doublePredicate2);
    }

    @Override // java8.util.function.DoublePredicate
    public boolean test(double d) {
        return java8.util.function.DoublePredicates.lambda$and$157(this.arg$1, this.arg$2, d);
    }
}
