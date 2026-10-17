package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class UnaryOperators {
    static /* synthetic */ java.lang.Object lambda$identity$133(java.lang.Object obj) {
        return obj;
    }

    public static <T> java8.util.function.UnaryOperator<T> identity() {
        return java8.util.function.UnaryOperators$$Lambda$1.instance;
    }

    private UnaryOperators() {
    }
}
