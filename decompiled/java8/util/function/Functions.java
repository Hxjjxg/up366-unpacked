package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Functions {
    static /* synthetic */ java.lang.Object lambda$identity$136(java.lang.Object obj) {
        return obj;
    }

    public static <R, T, V> java8.util.function.Function<V, R> compose(java8.util.function.Function<? super T, ? extends R> function, java8.util.function.Function<? super V, ? extends T> function2) {
        java8.util.Objects.requireNonNull(function);
        java8.util.Objects.requireNonNull(function2);
        return java8.util.function.Functions$$Lambda$1.lambdaFactory$(function, function2);
    }

    public static <R, T, V> java8.util.function.Function<T, V> andThen(java8.util.function.Function<? super T, ? extends R> function, java8.util.function.Function<? super R, ? extends V> function2) {
        java8.util.Objects.requireNonNull(function);
        java8.util.Objects.requireNonNull(function2);
        return java8.util.function.Functions$$Lambda$2.lambdaFactory$(function2, function);
    }

    public static <T> java8.util.function.Function<T, T> identity() {
        return java8.util.function.Functions$$Lambda$3.instance;
    }

    private Functions() {
    }
}
