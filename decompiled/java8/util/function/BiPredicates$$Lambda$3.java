package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class BiPredicates$$Lambda$3 implements java8.util.function.BiPredicate {
    private final java8.util.function.BiPredicate arg$1;
    private final java8.util.function.BiPredicate arg$2;

    private BiPredicates$$Lambda$3(java8.util.function.BiPredicate biPredicate, java8.util.function.BiPredicate biPredicate2) {
        this.arg$1 = biPredicate;
        this.arg$2 = biPredicate2;
    }

    public static java8.util.function.BiPredicate lambdaFactory$(java8.util.function.BiPredicate biPredicate, java8.util.function.BiPredicate biPredicate2) {
        return new java8.util.function.BiPredicates$$Lambda$3(biPredicate, biPredicate2);
    }

    @Override // java8.util.function.BiPredicate
    public boolean test(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.function.BiPredicates.lambda$or$103(this.arg$1, this.arg$2, obj, obj2);
    }
}
