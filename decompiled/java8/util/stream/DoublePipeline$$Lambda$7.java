package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoublePipeline$$Lambda$7 implements java8.util.function.DoubleBinaryOperator {
    private static final java8.util.stream.DoublePipeline$$Lambda$7 instance = new java8.util.stream.DoublePipeline$$Lambda$7();

    private DoublePipeline$$Lambda$7() {
    }

    @Override // java8.util.function.DoubleBinaryOperator
    public double applyAsDouble(double d, double d2) {
        return java.lang.Math.min(d, d2);
    }
}
