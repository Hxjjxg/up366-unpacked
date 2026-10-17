package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Predicates$$Lambda$5 implements java8.util.function.Predicate {
    private final java.lang.Object arg$1;

    private Predicates$$Lambda$5(java.lang.Object obj) {
        this.arg$1 = obj;
    }

    public static java8.util.function.Predicate lambdaFactory$(java.lang.Object obj) {
        return new java8.util.function.Predicates$$Lambda$5(obj);
    }

    @Override // java8.util.function.Predicate
    public boolean test(java.lang.Object obj) {
        return this.arg$1.equals(obj);
    }
}
