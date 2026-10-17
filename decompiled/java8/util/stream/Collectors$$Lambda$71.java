package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$71 implements java8.util.function.Supplier {
    private final java8.util.stream.Collector arg$1;

    private Collectors$$Lambda$71(java8.util.stream.Collector collector) {
        this.arg$1 = collector;
    }

    public static java8.util.function.Supplier lambdaFactory$(java8.util.stream.Collector collector) {
        return new java8.util.stream.Collectors$$Lambda$71(collector);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.Collectors.lambda$partitioningBy$66(this.arg$1);
    }
}
