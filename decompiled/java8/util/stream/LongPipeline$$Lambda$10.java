package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongPipeline$$Lambda$10 implements java8.util.function.ObjLongConsumer {
    private static final java8.util.stream.LongPipeline$$Lambda$10 instance = new java8.util.stream.LongPipeline$$Lambda$10();

    private LongPipeline$$Lambda$10() {
    }

    @Override // java8.util.function.ObjLongConsumer
    public void accept(java.lang.Object obj, long j) {
        ((java8.util.LongSummaryStatistics) obj).accept(j);
    }
}
