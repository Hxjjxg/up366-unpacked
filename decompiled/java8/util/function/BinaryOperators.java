package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class BinaryOperators {
    public static <T> java8.util.function.BinaryOperator<T> minBy(java.util.Comparator<? super T> comparator) {
        java8.util.Objects.requireNonNull(comparator);
        return java8.util.function.BinaryOperators$$Lambda$1.lambdaFactory$(comparator);
    }

    static /* synthetic */ java.lang.Object lambda$minBy$110(java.util.Comparator comparator, java.lang.Object obj, java.lang.Object obj2) {
        return comparator.compare(obj, obj2) <= 0 ? obj : obj2;
    }

    public static <T> java8.util.function.BinaryOperator<T> maxBy(java.util.Comparator<? super T> comparator) {
        java8.util.Objects.requireNonNull(comparator);
        return java8.util.function.BinaryOperators$$Lambda$2.lambdaFactory$(comparator);
    }

    static /* synthetic */ java.lang.Object lambda$maxBy$111(java.util.Comparator comparator, java.lang.Object obj, java.lang.Object obj2) {
        return comparator.compare(obj, obj2) >= 0 ? obj : obj2;
    }

    private BinaryOperators() {
    }
}
