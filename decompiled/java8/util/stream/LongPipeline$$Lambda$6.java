package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPipeline$$Lambda$6 implements java8.util.function.LongBinaryOperator {
    private static final java8.util.stream.LongPipeline$$Lambda$6 instance = new java8.util.stream.LongPipeline$$Lambda$6();

    private LongPipeline$$Lambda$6() {
    }

    @Override // java8.util.function.LongBinaryOperator
    public long applyAsLong(long j, long j2) {
        return java.lang.Math.max(j, j2);
    }
}
