package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoublePipeline$$Lambda$13 implements java8.util.function.BiConsumer {
    private static final java8.util.stream.DoublePipeline$$Lambda$13 instance = new java8.util.stream.DoublePipeline$$Lambda$13();

    private DoublePipeline$$Lambda$13() {
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        ((java8.util.DoubleSummaryStatistics) obj).combine((java8.util.DoubleSummaryStatistics) obj2);
    }
}
