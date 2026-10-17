package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Predicates {
    public static <T> java8.util.function.Predicate<T> and(java8.util.function.Predicate<? super T> predicate, java8.util.function.Predicate<? super T> predicate2) {
        java8.util.Objects.requireNonNull(predicate);
        java8.util.Objects.requireNonNull(predicate2);
        return java8.util.function.Predicates$$Lambda$1.lambdaFactory$(predicate, predicate2);
    }

    static /* synthetic */ boolean lambda$and$119(java8.util.function.Predicate predicate, java8.util.function.Predicate predicate2, java.lang.Object obj) {
        return predicate.test(obj) && predicate2.test(obj);
    }

    public static <T> java8.util.function.Predicate<T> negate(java8.util.function.Predicate<? super T> predicate) {
        java8.util.Objects.requireNonNull(predicate);
        return java8.util.function.Predicates$$Lambda$2.lambdaFactory$(predicate);
    }

    static /* synthetic */ boolean lambda$negate$120(java8.util.function.Predicate predicate, java.lang.Object obj) {
        return !predicate.test(obj);
    }

    public static <T> java8.util.function.Predicate<T> or(java8.util.function.Predicate<? super T> predicate, java8.util.function.Predicate<? super T> predicate2) {
        java8.util.Objects.requireNonNull(predicate);
        java8.util.Objects.requireNonNull(predicate2);
        return java8.util.function.Predicates$$Lambda$3.lambdaFactory$(predicate, predicate2);
    }

    static /* synthetic */ boolean lambda$or$121(java8.util.function.Predicate predicate, java8.util.function.Predicate predicate2, java.lang.Object obj) {
        return predicate.test(obj) || predicate2.test(obj);
    }

    public static <T> java8.util.function.Predicate<T> isEqual(java.lang.Object obj) {
        return obj == null ? java8.util.function.Predicates$$Lambda$4.instance : java8.util.function.Predicates$$Lambda$5.lambdaFactory$(obj);
    }

    public static <T> java8.util.function.Predicate<T> not(java8.util.function.Predicate<? super T> predicate) {
        java8.util.Objects.requireNonNull(predicate);
        return negate(predicate);
    }

    private Predicates() {
    }
}
