package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Predicates$$Lambda$2 implements java8.util.function.Predicate {
    private final java8.util.function.Predicate arg$1;

    private Predicates$$Lambda$2(java8.util.function.Predicate predicate) {
        this.arg$1 = predicate;
    }

    public static java8.util.function.Predicate lambdaFactory$(java8.util.function.Predicate predicate) {
        return new java8.util.function.Predicates$$Lambda$2(predicate);
    }

    @Override // java8.util.function.Predicate
    public boolean test(java.lang.Object obj) {
        return java8.util.function.Predicates.lambda$negate$120(this.arg$1, obj);
    }
}
