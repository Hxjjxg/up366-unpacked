package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$87 implements java8.util.function.Function {
    private final java8.util.function.Supplier arg$1;

    private Collectors$$Lambda$87(java8.util.function.Supplier supplier) {
        this.arg$1 = supplier;
    }

    public static java8.util.function.Function lambdaFactory$(java8.util.function.Supplier supplier) {
        return new java8.util.stream.Collectors$$Lambda$87(supplier);
    }

    @Override // java8.util.function.Function
    public java.lang.Object apply(java.lang.Object obj) {
        return java8.util.stream.Collectors.lambda$null$58(this.arg$1, obj);
    }
}
