package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class BiFunctions$$Lambda$1 implements java8.util.function.BiFunction {
    private final java8.util.function.Function arg$1;
    private final java8.util.function.BiFunction arg$2;

    private BiFunctions$$Lambda$1(java8.util.function.Function function, java8.util.function.BiFunction biFunction) {
        this.arg$1 = function;
        this.arg$2 = biFunction;
    }

    public static java8.util.function.BiFunction lambdaFactory$(java8.util.function.Function function, java8.util.function.BiFunction biFunction) {
        return new java8.util.function.BiFunctions$$Lambda$1(function, biFunction);
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return this.arg$1.apply(this.arg$2.apply(obj, obj2));
    }
}
