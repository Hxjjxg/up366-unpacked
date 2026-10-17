package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPipeline$$Lambda$11 implements java8.util.function.BiConsumer {
    private static final java8.util.stream.LongPipeline$$Lambda$11 instance = new java8.util.stream.LongPipeline$$Lambda$11();

    private LongPipeline$$Lambda$11() {
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        ((java8.util.LongSummaryStatistics) obj).combine((java8.util.LongSummaryStatistics) obj2);
    }
}
