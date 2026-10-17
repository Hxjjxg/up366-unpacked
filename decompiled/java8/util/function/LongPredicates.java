package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class LongPredicates {
    public static java8.util.function.LongPredicate and(java8.util.function.LongPredicate longPredicate, java8.util.function.LongPredicate longPredicate2) {
        java8.util.Objects.requireNonNull(longPredicate);
        java8.util.Objects.requireNonNull(longPredicate2);
        return java8.util.function.LongPredicates$$Lambda$1.lambdaFactory$(longPredicate, longPredicate2);
    }

    static /* synthetic */ boolean lambda$and$137(java8.util.function.LongPredicate longPredicate, java8.util.function.LongPredicate longPredicate2, long j) {
        return longPredicate.test(j) && longPredicate2.test(j);
    }

    public static java8.util.function.LongPredicate negate(java8.util.function.LongPredicate longPredicate) {
        java8.util.Objects.requireNonNull(longPredicate);
        return java8.util.function.LongPredicates$$Lambda$2.lambdaFactory$(longPredicate);
    }

    static /* synthetic */ boolean lambda$negate$138(java8.util.function.LongPredicate longPredicate, long j) {
        return !longPredicate.test(j);
    }

    public static java8.util.function.LongPredicate or(java8.util.function.LongPredicate longPredicate, java8.util.function.LongPredicate longPredicate2) {
        java8.util.Objects.requireNonNull(longPredicate);
        java8.util.Objects.requireNonNull(longPredicate2);
        return java8.util.function.LongPredicates$$Lambda$3.lambdaFactory$(longPredicate, longPredicate2);
    }

    static /* synthetic */ boolean lambda$or$139(java8.util.function.LongPredicate longPredicate, java8.util.function.LongPredicate longPredicate2, long j) {
        return longPredicate.test(j) || longPredicate2.test(j);
    }

    private LongPredicates() {
    }
}
