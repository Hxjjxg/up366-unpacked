package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoublePipeline$$Lambda$3 implements java8.util.function.ToDoubleFunction {
    private static final java8.util.stream.DoublePipeline$$Lambda$3 instance = new java8.util.stream.DoublePipeline$$Lambda$3();

    private DoublePipeline$$Lambda$3() {
    }

    @Override // java8.util.function.ToDoubleFunction
    public double applyAsDouble(java.lang.Object obj) {
        return ((java.lang.Double) obj).doubleValue();
    }
}
