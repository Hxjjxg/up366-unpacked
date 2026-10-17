package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$79 implements java8.util.function.BiConsumer {
    private final java8.util.function.ToDoubleFunction arg$1;

    private Collectors$$Lambda$79(java8.util.function.ToDoubleFunction toDoubleFunction) {
        this.arg$1 = toDoubleFunction;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.ToDoubleFunction toDoubleFunction) {
        return new java8.util.stream.Collectors$$Lambda$79(toDoubleFunction);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$summarizingDouble$74(this.arg$1, (java8.util.DoubleSummaryStatistics) obj, obj2);
    }
}
