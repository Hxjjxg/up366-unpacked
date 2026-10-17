package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class BiPredicates {
    public static <T, U> java8.util.function.BiPredicate<T, U> and(java8.util.function.BiPredicate<? super T, ? super U> biPredicate, java8.util.function.BiPredicate<? super T, ? super U> biPredicate2) {
        java8.util.Objects.requireNonNull(biPredicate);
        java8.util.Objects.requireNonNull(biPredicate2);
        return java8.util.function.BiPredicates$$Lambda$1.lambdaFactory$(biPredicate, biPredicate2);
    }

    static /* synthetic */ boolean lambda$and$101(java8.util.function.BiPredicate biPredicate, java8.util.function.BiPredicate biPredicate2, java.lang.Object obj, java.lang.Object obj2) {
        return biPredicate.test(obj, obj2) && biPredicate2.test(obj, obj2);
    }

    public static <T, U> java8.util.function.BiPredicate<T, U> negate(java8.util.function.BiPredicate<? super T, ? super U> biPredicate) {
        java8.util.Objects.requireNonNull(biPredicate);
        return java8.util.function.BiPredicates$$Lambda$2.lambdaFactory$(biPredicate);
    }

    static /* synthetic */ boolean lambda$negate$102(java8.util.function.BiPredicate biPredicate, java.lang.Object obj, java.lang.Object obj2) {
        return !biPredicate.test(obj, obj2);
    }

    public static <T, U> java8.util.function.BiPredicate<T, U> or(java8.util.function.BiPredicate<? super T, ? super U> biPredicate, java8.util.function.BiPredicate<? super T, ? super U> biPredicate2) {
        java8.util.Objects.requireNonNull(biPredicate);
        java8.util.Objects.requireNonNull(biPredicate2);
        return java8.util.function.BiPredicates$$Lambda$3.lambdaFactory$(biPredicate, biPredicate2);
    }

    static /* synthetic */ boolean lambda$or$103(java8.util.function.BiPredicate biPredicate, java8.util.function.BiPredicate biPredicate2, java.lang.Object obj, java.lang.Object obj2) {
        return biPredicate.test(obj, obj2) || biPredicate2.test(obj, obj2);
    }

    private BiPredicates() {
    }
}
