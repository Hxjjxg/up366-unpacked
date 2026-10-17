package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Functions$$Lambda$2 implements java8.util.function.Function {
    private final java8.util.function.Function arg$1;
    private final java8.util.function.Function arg$2;

    private Functions$$Lambda$2(java8.util.function.Function function, java8.util.function.Function function2) {
        this.arg$1 = function;
        this.arg$2 = function2;
    }

    public static java8.util.function.Function lambdaFactory$(java8.util.function.Function function, java8.util.function.Function function2) {
        return new java8.util.function.Functions$$Lambda$2(function, function2);
    }

    @Override // java8.util.function.Function
    public java.lang.Object apply(java.lang.Object obj) {
        return this.arg$1.apply(this.arg$2.apply(obj));
    }
}
