package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class IntPredicates {
    public static java8.util.function.IntPredicate and(java8.util.function.IntPredicate intPredicate, java8.util.function.IntPredicate intPredicate2) {
        java8.util.Objects.requireNonNull(intPredicate);
        java8.util.Objects.requireNonNull(intPredicate2);
        return java8.util.function.IntPredicates$$Lambda$1.lambdaFactory$(intPredicate, intPredicate2);
    }

    static /* synthetic */ boolean lambda$and$141(java8.util.function.IntPredicate intPredicate, java8.util.function.IntPredicate intPredicate2, int i) {
        return intPredicate.test(i) && intPredicate2.test(i);
    }

    public static java8.util.function.IntPredicate negate(java8.util.function.IntPredicate intPredicate) {
        java8.util.Objects.requireNonNull(intPredicate);
        return java8.util.function.IntPredicates$$Lambda$2.lambdaFactory$(intPredicate);
    }

    static /* synthetic */ boolean lambda$negate$142(java8.util.function.IntPredicate intPredicate, int i) {
        return !intPredicate.test(i);
    }

    public static java8.util.function.IntPredicate or(java8.util.function.IntPredicate intPredicate, java8.util.function.IntPredicate intPredicate2) {
        java8.util.Objects.requireNonNull(intPredicate);
        java8.util.Objects.requireNonNull(intPredicate2);
        return java8.util.function.IntPredicates$$Lambda$3.lambdaFactory$(intPredicate, intPredicate2);
    }

    static /* synthetic */ boolean lambda$or$143(java8.util.function.IntPredicate intPredicate, java8.util.function.IntPredicate intPredicate2, int i) {
        return intPredicate.test(i) || intPredicate2.test(i);
    }

    private IntPredicates() {
    }
}
