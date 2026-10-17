package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class BiFunctions {
    public static <R, T, U, V> java8.util.function.BiFunction<T, U, V> andThen(java8.util.function.BiFunction<? super T, ? super U, ? extends R> biFunction, java8.util.function.Function<? super R, ? extends V> function) {
        java8.util.Objects.requireNonNull(biFunction);
        java8.util.Objects.requireNonNull(function);
        return java8.util.function.BiFunctions$$Lambda$1.lambdaFactory$(function, biFunction);
    }

    private BiFunctions() {
    }
}
