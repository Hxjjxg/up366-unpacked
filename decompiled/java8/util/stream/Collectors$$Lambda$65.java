package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$65 implements java8.util.function.Function {
    private final java8.util.function.Function arg$1;

    private Collectors$$Lambda$65(java8.util.function.Function function) {
        this.arg$1 = function;
    }

    public static java8.util.function.Function lambdaFactory$(java8.util.function.Function function) {
        return new java8.util.stream.Collectors$$Lambda$65(function);
    }

    @Override // java8.util.function.Function
    public java.lang.Object apply(java.lang.Object obj) {
        return java8.util.stream.Collectors.lambda$groupingBy$57(this.arg$1, (java.util.Map) obj);
    }
}
