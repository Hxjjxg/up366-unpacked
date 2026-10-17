package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$72 implements java8.util.function.Function {
    private final java8.util.stream.Collector arg$1;

    private Collectors$$Lambda$72(java8.util.stream.Collector collector) {
        this.arg$1 = collector;
    }

    public static java8.util.function.Function lambdaFactory$(java8.util.stream.Collector collector) {
        return new java8.util.stream.Collectors$$Lambda$72(collector);
    }

    @Override // java8.util.function.Function
    public java.lang.Object apply(java.lang.Object obj) {
        return java8.util.stream.Collectors.lambda$partitioningBy$67(this.arg$1, (java8.util.stream.Collectors.Partition) obj);
    }
}
