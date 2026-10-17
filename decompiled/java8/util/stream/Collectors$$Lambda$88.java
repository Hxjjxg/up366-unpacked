package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$88 implements java8.util.function.BiFunction {
    private final java8.util.function.Function arg$1;

    private Collectors$$Lambda$88(java8.util.function.Function function) {
        this.arg$1 = function;
    }

    public static java8.util.function.BiFunction lambdaFactory$(java8.util.function.Function function) {
        return new java8.util.stream.Collectors$$Lambda$88(function);
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.stream.Collectors.lambda$null$56(this.arg$1, obj, obj2);
    }
}
