package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntPipeline$$Lambda$6 implements java8.util.function.IntBinaryOperator {
    private static final java8.util.stream.IntPipeline$$Lambda$6 instance = new java8.util.stream.IntPipeline$$Lambda$6();

    private IntPipeline$$Lambda$6() {
    }

    @Override // java8.util.function.IntBinaryOperator
    public int applyAsInt(int i, int i2) {
        return java.lang.Math.max(i, i2);
    }
}
