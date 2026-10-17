package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntPipeline$$Lambda$10 implements java8.util.function.ObjIntConsumer {
    private static final java8.util.stream.IntPipeline$$Lambda$10 instance = new java8.util.stream.IntPipeline$$Lambda$10();

    private IntPipeline$$Lambda$10() {
    }

    @Override // java8.util.function.ObjIntConsumer
    public void accept(java.lang.Object obj, int i) {
        ((java8.util.IntSummaryStatistics) obj).accept(i);
    }
}
