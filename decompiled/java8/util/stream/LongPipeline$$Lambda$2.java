package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPipeline$$Lambda$2 implements java8.util.function.LongFunction {
    private static final java8.util.stream.LongPipeline$$Lambda$2 instance = new java8.util.stream.LongPipeline$$Lambda$2();

    private LongPipeline$$Lambda$2() {
    }

    @Override // java8.util.function.LongFunction
    public java.lang.Object apply(long j) {
        return java.lang.Long.valueOf(j);
    }
}
