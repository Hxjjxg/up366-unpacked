package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPipeline$$Lambda$5 implements java8.util.function.LongBinaryOperator {
    private static final java8.util.stream.LongPipeline$$Lambda$5 instance = new java8.util.stream.LongPipeline$$Lambda$5();

    private LongPipeline$$Lambda$5() {
    }

    @Override // java8.util.function.LongBinaryOperator
    public long applyAsLong(long j, long j2) {
        return java.lang.Math.min(j, j2);
    }
}
