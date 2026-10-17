package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Predicates$$Lambda$1 implements java8.util.function.Predicate {
    private final java8.util.function.Predicate arg$1;
    private final java8.util.function.Predicate arg$2;

    private Predicates$$Lambda$1(java8.util.function.Predicate predicate, java8.util.function.Predicate predicate2) {
        this.arg$1 = predicate;
        this.arg$2 = predicate2;
    }

    public static java8.util.function.Predicate lambdaFactory$(java8.util.function.Predicate predicate, java8.util.function.Predicate predicate2) {
        return new java8.util.function.Predicates$$Lambda$1(predicate, predicate2);
    }

    @Override // java8.util.function.Predicate
    public boolean test(java.lang.Object obj) {
        return java8.util.function.Predicates.lambda$and$119(this.arg$1, this.arg$2, obj);
    }
}
