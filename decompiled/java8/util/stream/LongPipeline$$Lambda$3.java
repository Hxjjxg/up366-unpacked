package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPipeline$$Lambda$3 implements java8.util.function.ToLongFunction {
    private static final java8.util.stream.LongPipeline$$Lambda$3 instance = new java8.util.stream.LongPipeline$$Lambda$3();

    private LongPipeline$$Lambda$3() {
    }

    @Override // java8.util.function.ToLongFunction
    public long applyAsLong(java.lang.Object obj) {
        return ((java.lang.Long) obj).longValue();
    }
}
