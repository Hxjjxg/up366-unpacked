package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntPipeline$$Lambda$4 implements java8.util.function.IntBinaryOperator {
    private static final java8.util.stream.IntPipeline$$Lambda$4 instance = new java8.util.stream.IntPipeline$$Lambda$4();

    private IntPipeline$$Lambda$4() {
    }

    @Override // java8.util.function.IntBinaryOperator
    public int applyAsInt(int i, int i2) {
        return java8.lang.Integers.sum(i, i2);
    }
}
