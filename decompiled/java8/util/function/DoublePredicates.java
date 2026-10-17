package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DoublePredicates {
    public static java8.util.function.DoublePredicate and(java8.util.function.DoublePredicate doublePredicate, java8.util.function.DoublePredicate doublePredicate2) {
        java8.util.Objects.requireNonNull(doublePredicate);
        java8.util.Objects.requireNonNull(doublePredicate2);
        return java8.util.function.DoublePredicates$$Lambda$1.lambdaFactory$(doublePredicate, doublePredicate2);
    }

    static /* synthetic */ boolean lambda$and$157(java8.util.function.DoublePredicate doublePredicate, java8.util.function.DoublePredicate doublePredicate2, double d) {
        return doublePredicate.test(d) && doublePredicate2.test(d);
    }

    public static java8.util.function.DoublePredicate negate(java8.util.function.DoublePredicate doublePredicate) {
        java8.util.Objects.requireNonNull(doublePredicate);
        return java8.util.function.DoublePredicates$$Lambda$2.lambdaFactory$(doublePredicate);
    }

    static /* synthetic */ boolean lambda$negate$158(java8.util.function.DoublePredicate doublePredicate, double d) {
        return !doublePredicate.test(d);
    }

    public static java8.util.function.DoublePredicate or(java8.util.function.DoublePredicate doublePredicate, java8.util.function.DoublePredicate doublePredicate2) {
        java8.util.Objects.requireNonNull(doublePredicate);
        java8.util.Objects.requireNonNull(doublePredicate2);
        return java8.util.function.DoublePredicates$$Lambda$3.lambdaFactory$(doublePredicate, doublePredicate2);
    }

    static /* synthetic */ boolean lambda$or$159(java8.util.function.DoublePredicate doublePredicate, java8.util.function.DoublePredicate doublePredicate2, double d) {
        return doublePredicate.test(d) || doublePredicate2.test(d);
    }

    private DoublePredicates() {
    }
}
