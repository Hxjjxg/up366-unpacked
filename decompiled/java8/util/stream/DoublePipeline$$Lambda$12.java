package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoublePipeline$$Lambda$12 implements java8.util.function.ObjDoubleConsumer {
    private static final java8.util.stream.DoublePipeline$$Lambda$12 instance = new java8.util.stream.DoublePipeline$$Lambda$12();

    private DoublePipeline$$Lambda$12() {
    }

    @Override // java8.util.function.ObjDoubleConsumer
    public void accept(java.lang.Object obj, double d) {
        ((java8.util.DoubleSummaryStatistics) obj).accept(d);
    }
}
