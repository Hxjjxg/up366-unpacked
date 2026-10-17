package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntPipeline$$Lambda$3 implements java8.util.function.ToIntFunction {
    private static final java8.util.stream.IntPipeline$$Lambda$3 instance = new java8.util.stream.IntPipeline$$Lambda$3();

    private IntPipeline$$Lambda$3() {
    }

    @Override // java8.util.function.ToIntFunction
    public int applyAsInt(java.lang.Object obj) {
        return ((java.lang.Integer) obj).intValue();
    }
}
