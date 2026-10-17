package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class BiPredicates$$Lambda$2 implements java8.util.function.BiPredicate {
    private final java8.util.function.BiPredicate arg$1;

    private BiPredicates$$Lambda$2(java8.util.function.BiPredicate biPredicate) {
        this.arg$1 = biPredicate;
    }

    public static java8.util.function.BiPredicate lambdaFactory$(java8.util.function.BiPredicate biPredicate) {
        return new java8.util.function.BiPredicates$$Lambda$2(biPredicate);
    }

    @Override // java8.util.function.BiPredicate
    public boolean test(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.function.BiPredicates.lambda$negate$102(this.arg$1, obj, obj2);
    }
}
