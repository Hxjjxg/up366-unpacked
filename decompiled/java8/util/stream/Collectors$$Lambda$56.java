package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$56 implements java8.util.function.Supplier {
    private final java.lang.Object arg$1;

    private Collectors$$Lambda$56(java.lang.Object obj) {
        this.arg$1 = obj;
    }

    public static java8.util.function.Supplier lambdaFactory$(java.lang.Object obj) {
        return new java8.util.stream.Collectors$$Lambda$56(obj);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.Collectors.lambda$boxSupplier$47(this.arg$1);
    }
}
